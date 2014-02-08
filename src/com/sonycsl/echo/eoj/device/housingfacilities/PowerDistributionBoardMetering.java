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

public abstract class PowerDistributionBoardMetering extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0287;

	public static final byte EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION = (byte)0xC0;
	public static final byte EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION = (byte)0xC1;
	public static final byte EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY = (byte)0xC2;
	public static final byte EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION = (byte)0xC3;
	public static final byte EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION = (byte)0xC4;
	public static final byte EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED = (byte)0xC5;
	public static final byte EPC_MEASURED_INSTANTANEO_US_AMOUNT_OF_ELECTRIC_ENERGY = (byte)0xC6;
	public static final byte EPC_MEASURED_INSTANTANEOUS_CURRENTS = (byte)0xC7;
	public static final byte EPC_MEASURED_INSTANTANEOUS_VOLTAGES = (byte)0xC8;
	public static final byte EPC_MEASUREMENT_CHANNEL1 = (byte)0xD0;
	public static final byte EPC_MEASUREMENT_CHANNEL2 = (byte)0xD1;
	public static final byte EPC_MEASUREMENT_CHANNEL3 = (byte)0xD2;
	public static final byte EPC_MEASUREMENT_CHANNEL4 = (byte)0xD3;
	public static final byte EPC_MEASUREMENT_CHANNEL5 = (byte)0xD4;
	public static final byte EPC_MEASUREMENT_CHANNEL6 = (byte)0xD5;
	public static final byte EPC_MEASUREMENT_CHANNEL7 = (byte)0xD6;
	public static final byte EPC_MEASUREMENT_CHANNEL8 = (byte)0xD7;
	public static final byte EPC_MEASUREMENT_CHANNEL9 = (byte)0xD8;
	public static final byte EPC_MEASUREMENT_CHANNEL10 = (byte)0xD9;
	public static final byte EPC_MEASUREMENT_CHANNEL11 = (byte)0xDA;
	public static final byte EPC_MEASUREMENT_CHANNEL12 = (byte)0xDB;
	public static final byte EPC_MEASUREMENT_CHANNEL13 = (byte)0xDC;
	public static final byte EPC_MEASUREMENT_CHANNEL14 = (byte)0xDD;
	public static final byte EPC_MEASUREMENT_CHANNEL15 = (byte)0xDE;
	public static final byte EPC_MEASUREMENT_CHANNEL16 = (byte)0xDF;
	public static final byte EPC_MEASUREMENT_CHANNEL17 = (byte)0xE0;
	public static final byte EPC_MEASUREMENT_CHANNEL18 = (byte)0xE1;
	public static final byte EPC_MEASUREMENT_CHANNEL19 = (byte)0xE2;
	public static final byte EPC_MEASUREMENT_CHANNEL20 = (byte)0xE3;
	public static final byte EPC_MEASUREMENT_CHANNEL21 = (byte)0xE4;
	public static final byte EPC_MEASUREMENT_CHANNEL22 = (byte)0xE5;
	public static final byte EPC_MEASUREMENT_CHANNEL23 = (byte)0xE6;
	public static final byte EPC_MEASUREMENT_CHANNEL24 = (byte)0xE7;
	public static final byte EPC_MEASUREMENT_CHANNEL25 = (byte)0xE8;
	public static final byte EPC_MEASUREMENT_CHANNEL26 = (byte)0xE9;
	public static final byte EPC_MEASUREMENT_CHANNEL27 = (byte)0xEA;
	public static final byte EPC_MEASUREMENT_CHANNEL28 = (byte)0xEB;
	public static final byte EPC_MEASUREMENT_CHANNEL29 = (byte)0xEC;
	public static final byte EPC_MEASUREMENT_CHANNEL30 = (byte)0xED;
	public static final byte EPC_MEASUREMENT_CHANNEL31 = (byte)0xEE;
	public static final byte EPC_MEASUREMENT_CHANNEL32 = (byte)0xEF;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
		addGetProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION);
		addGetProperty(EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewPowerDistributionBoardMetering(this);
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
	 * Data size : 1
byte<br>
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
	 * This property indicates the ON/OFF status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
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
	 * Property name : Measured cumulative amount of electric energy (normal direction)<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured cumulative amount of electric  energy using an 8-digit decimal notation number.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
bytes<br>
	 * <br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
	/**
	 * Property name : Measured cumulative amount of electric energy (normal direction)<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured cumulative amount of electric  energy using an 8-digit decimal notation number.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
bytes<br>
	 * <br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidMeasuredCumulativeAmountOfElectricEnergyNormalDirection(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Measured cumulative amount of electric energy (reverse direction)<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured cumulative amount of electric  energy using an 8-digit decimal notation number.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
bytes<br>
	 * <br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getMeasuredCumulativeAmountOfElectricEnergyReverseDirection();
	/**
	 * Property name : Measured cumulative amount of electric energy (reverse direction)<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured cumulative amount of electric  energy using an 8-digit decimal notation number.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
bytes<br>
	 * <br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidMeasuredCumulativeAmountOfElectricEnergyReverseDirection(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Unit for cumulative amounts of electric energy<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00: 1kWh 0x01: 0.1kWh<br>
	 * 0x02: 0.01kWh<br>
	 * 0x03: 0.001kWh (Initial value) 0x04: 0.0001kWh<br>
	 * 0x0A: 10kWh 0x0B: 100kWh<br>
	 * 0x0C: 1000kWh<br>
	 * 0x0D: 10000kWh<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getUnitForCumulativeAmountsOfElectricEnergy();
	/**
	 * Property name : Unit for cumulative amounts of electric energy<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00: 1kWh 0x01: 0.1kWh<br>
	 * 0x02: 0.01kWh<br>
	 * 0x03: 0.001kWh (Initial value) 0x04: 0.0001kWh<br>
	 * 0x0A: 10kWh 0x0B: 100kWh<br>
	 * 0x0C: 1000kWh<br>
	 * 0x0D: 10000kWh<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidUnitForCumulativeAmountsOfElectricEnergy(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Historical data of measured cumulative amounts of electric energy
(normal direction)<br>
	 * <br>
	 * EPC : 0xC3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x0063 :<br>
	 * 0x00000000.0x05F5E0FF (0.99) : (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned short
+unsign ed
long
×48<br>
	 * <br>
	 * Data size : 194
bytes<br>
	 * <br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection() {return null;}
	/**
	 * Property name : Historical data of measured cumulative amounts of electric energy
(normal direction)<br>
	 * <br>
	 * EPC : 0xC3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x0063 :<br>
	 * 0x00000000.0x05F5E0FF (0.99) : (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned short
+unsign ed
long
×48<br>
	 * <br>
	 * Data size : 194
bytes<br>
	 * <br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(byte[] edt) {
		if(edt == null || !(edt.length == 194)) return false;
		return true;
	}
	/**
	 * Property name : Historical data of measured cumulative amounts of electric energy
(reverse direction)<br>
	 * <br>
	 * EPC : 0xC4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x0063 :<br>
	 * 0x00000000.0x05F5E0FF (0.99) : (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned short
+unsign ed
long
×48<br>
	 * <br>
	 * Data size : 194
bytes<br>
	 * <br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection() {return null;}
	/**
	 * Property name : Historical data of measured cumulative amounts of electric energy
(reverse direction)<br>
	 * <br>
	 * EPC : 0xC4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x0063 :<br>
	 * 0x00000000.0x05F5E0FF (0.99) : (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned short
+unsign ed
long
×48<br>
	 * <br>
	 * Data size : 194
bytes<br>
	 * <br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(byte[] edt) {
		if(edt == null || !(edt.length == 194)) return false;
		return true;
	}
	/**
	 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
	 * <br>
	 * EPC : 0xC5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x63 ( 0.99)<br>
	 * 0: current day<br>
	 * 1. 99: previous day.day that precedes the current day by 99 days<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte[] edt) {return false;}
	/**
	 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
	 * <br>
	 * EPC : 0xC5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x63 ( 0.99)<br>
	 * 0: current day<br>
	 * 1. 99: previous day.day that precedes the current day by 99 days<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved() {return null;}
	/**
	 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
	 * <br>
	 * EPC : 0xC5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x63 ( 0.99)<br>
	 * 0: current day<br>
	 * 1. 99: previous day.day that precedes the current day by 99 days<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured instantaneo us amount of electric energy<br>
	 * <br>
	 * EPC : 0xC6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x80000001.0x7FFFFFFD<br>
	 * (-2,147,483,647.2,147,483,645)<br>
	 * <br>
	 * Data type : signed long<br>
	 * <br>
	 * Data size : 4
bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredInstantaneoUsAmountOfElectricEnergy() {return null;}
	/**
	 * Property name : Measured instantaneo us amount of electric energy<br>
	 * <br>
	 * EPC : 0xC6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x80000001.0x7FFFFFFD<br>
	 * (-2,147,483,647.2,147,483,645)<br>
	 * <br>
	 * Data type : signed long<br>
	 * <br>
	 * Data size : 4
bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredInstantaneoUsAmountOfElectricEnergy(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Measured instantaneous currents<br>
	 * <br>
	 * EPC : 0xC7<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured effective instantaneous R and T phase currents in amperes.<br>
	 * In the case of a single-phase,<br>
	 * two-wire system, 0x7FFE shall be used for the T phase.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x8001-0x7FFD (R phase)<br>
	 * : 0x8001-0x7FFD (T phase)<br>
	 * (-3,276.7.3,276.5):<br>
	 * (-3,276.7.3,276.5)<br>
	 * <br>
	 * Data type : signed short
×2<br>
	 * <br>
	 * Data size : 4
bytes<br>
	 * <br>
	 * Unit : 0.1
A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredInstantaneousCurrents() {return null;}
	/**
	 * Property name : Measured instantaneous currents<br>
	 * <br>
	 * EPC : 0xC7<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured effective instantaneous R and T phase currents in amperes.<br>
	 * In the case of a single-phase,<br>
	 * two-wire system, 0x7FFE shall be used for the T phase.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x8001-0x7FFD (R phase)<br>
	 * : 0x8001-0x7FFD (T phase)<br>
	 * (-3,276.7.3,276.5):<br>
	 * (-3,276.7.3,276.5)<br>
	 * <br>
	 * Data type : signed short
×2<br>
	 * <br>
	 * Data size : 4
bytes<br>
	 * <br>
	 * Unit : 0.1
A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredInstantaneousCurrents(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Measured instantaneous voltages<br>
	 * <br>
	 * EPC : 0xC8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a single-phase, two-wire system, 0xFFFE shall be used for the S(N)-T voltage.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (between R and S(N)) :<br>
	 * 0x0000.0xFFFD (between S(N) and T)<br>
	 * (0.6,553.3) : (0.6,553.3)<br>
	 * <br>
	 * Data type : unsigned short
×2<br>
	 * <br>
	 * Data size : 4
bytes<br>
	 * <br>
	 * Unit : 0.1
V<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredInstantaneousVoltages() {return null;}
	/**
	 * Property name : Measured instantaneous voltages<br>
	 * <br>
	 * EPC : 0xC8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a single-phase, two-wire system, 0xFFFE shall be used for the S(N)-T voltage.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (between R and S(N)) :<br>
	 * 0x0000.0xFFFD (between S(N) and T)<br>
	 * (0.6,553.3) : (0.6,553.3)<br>
	 * <br>
	 * Data type : unsigned short
×2<br>
	 * <br>
	 * Data size : 4
bytes<br>
	 * <br>
	 * Unit : 0.1
V<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredInstantaneousVoltages(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 1<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 1 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel1() {return null;}
	/**
	 * Property name : Measurement channel 1<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 1 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel1(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 2<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 2 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel2() {return null;}
	/**
	 * Property name : Measurement channel 2<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 2 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel2(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 3<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 3 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel3() {return null;}
	/**
	 * Property name : Measurement channel 3<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 3 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel3(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 4<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 4 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel4() {return null;}
	/**
	 * Property name : Measurement channel 4<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 4 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel4(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 5<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 5 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel5() {return null;}
	/**
	 * Property name : Measurement channel 5<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 5 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel5(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 6<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 6 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel6() {return null;}
	/**
	 * Property name : Measurement channel 6<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 6 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel6(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 7<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 7 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel7() {return null;}
	/**
	 * Property name : Measurement channel 7<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 7 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel7(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 8<br>
	 * <br>
	 * EPC : 0xD7<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 8 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel8() {return null;}
	/**
	 * Property name : Measurement channel 8<br>
	 * <br>
	 * EPC : 0xD7<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 8 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel8(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 9<br>
	 * <br>
	 * EPC : 0xD8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 9 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel9() {return null;}
	/**
	 * Property name : Measurement channel 9<br>
	 * <br>
	 * EPC : 0xD8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 9 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel9(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 10<br>
	 * <br>
	 * EPC : 0xD9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 10 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel10() {return null;}
	/**
	 * Property name : Measurement channel 10<br>
	 * <br>
	 * EPC : 0xD9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 10 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel10(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 11<br>
	 * <br>
	 * EPC : 0xDA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 11 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel11() {return null;}
	/**
	 * Property name : Measurement channel 11<br>
	 * <br>
	 * EPC : 0xDA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 11 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel11(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 12<br>
	 * <br>
	 * EPC : 0xDB<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 12 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel12() {return null;}
	/**
	 * Property name : Measurement channel 12<br>
	 * <br>
	 * EPC : 0xDB<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 12 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel12(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 13<br>
	 * <br>
	 * EPC : 0xDC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 13 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel13() {return null;}
	/**
	 * Property name : Measurement channel 13<br>
	 * <br>
	 * EPC : 0xDC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 13 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel13(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 14<br>
	 * <br>
	 * EPC : 0xDD<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 14 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel14() {return null;}
	/**
	 * Property name : Measurement channel 14<br>
	 * <br>
	 * EPC : 0xDD<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 14 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel14(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 15<br>
	 * <br>
	 * EPC : 0xDE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 15 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel15() {return null;}
	/**
	 * Property name : Measurement channel 15<br>
	 * <br>
	 * EPC : 0xDE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 15 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel15(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 16<br>
	 * <br>
	 * EPC : 0xDF<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 16 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel16() {return null;}
	/**
	 * Property name : Measurement channel 16<br>
	 * <br>
	 * EPC : 0xDF<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 16 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel16(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 17<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 17 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel17() {return null;}
	/**
	 * Property name : Measurement channel 17<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 17 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel17(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 18<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 18 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel18() {return null;}
	/**
	 * Property name : Measurement channel 18<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 18 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel18(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 19<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 19 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel19() {return null;}
	/**
	 * Property name : Measurement channel 19<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 19 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel19(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 20<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 20 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel20() {return null;}
	/**
	 * Property name : Measurement channel 20<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 20 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel20(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 21<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 21 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel21() {return null;}
	/**
	 * Property name : Measurement channel 21<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 21 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel21(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 22<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 22 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel22() {return null;}
	/**
	 * Property name : Measurement channel 22<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 22 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel22(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 23<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 23 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel23() {return null;}
	/**
	 * Property name : Measurement channel 23<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 23 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel23(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 24<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 24 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel24() {return null;}
	/**
	 * Property name : Measurement channel 24<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 24 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel24(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 25<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 25 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel25() {return null;}
	/**
	 * Property name : Measurement channel 25<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 25 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel25(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 26<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 26 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel26() {return null;}
	/**
	 * Property name : Measurement channel 26<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 26 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel26(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 27<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 27 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel27() {return null;}
	/**
	 * Property name : Measurement channel 27<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 27 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel27(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 28<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 28 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel28() {return null;}
	/**
	 * Property name : Measurement channel 28<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 28 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel28(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 29<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 29 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel29() {return null;}
	/**
	 * Property name : Measurement channel 29<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 29 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel29(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 30<br>
	 * <br>
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 30 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel30() {return null;}
	/**
	 * Property name : Measurement channel 30<br>
	 * <br>
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 30 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel30(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 31<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 31 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel31() {return null;}
	/**
	 * Property name : Measurement channel 31<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 31 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel31(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measurement channel 32<br>
	 * <br>
	 * EPC : 0xEF<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 32 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasurementChannel32() {return null;}
	/**
	 * Property name : Measurement channel 32<br>
	 * <br>
	 * EPC : 0xEF<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measurement data for Measurement channel 32 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Data format for the electric energy: same as 0xC0<br>
	 * Unit: same as 0xC2<br>
	 * Data format for the currents: same as 0xC7<br>
	 * <br>
	 * Data type : unsigned long
+
signed short
×2<br>
	 * <br>
	 * Data size : 8
bytes<br>
	 * <br>
	 * Unit : kWh
+ 0.1A
×2<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasurementChannel32(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED : return setDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION : return getMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION : return getMeasuredCumulativeAmountOfElectricEnergyReverseDirection();
		case EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY : return getUnitForCumulativeAmountsOfElectricEnergy();
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION : return getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection();
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION : return getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection();
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED : return getDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved();
		case EPC_MEASURED_INSTANTANEO_US_AMOUNT_OF_ELECTRIC_ENERGY : return getMeasuredInstantaneoUsAmountOfElectricEnergy();
		case EPC_MEASURED_INSTANTANEOUS_CURRENTS : return getMeasuredInstantaneousCurrents();
		case EPC_MEASURED_INSTANTANEOUS_VOLTAGES : return getMeasuredInstantaneousVoltages();
		case EPC_MEASUREMENT_CHANNEL1 : return getMeasurementChannel1();
		case EPC_MEASUREMENT_CHANNEL2 : return getMeasurementChannel2();
		case EPC_MEASUREMENT_CHANNEL3 : return getMeasurementChannel3();
		case EPC_MEASUREMENT_CHANNEL4 : return getMeasurementChannel4();
		case EPC_MEASUREMENT_CHANNEL5 : return getMeasurementChannel5();
		case EPC_MEASUREMENT_CHANNEL6 : return getMeasurementChannel6();
		case EPC_MEASUREMENT_CHANNEL7 : return getMeasurementChannel7();
		case EPC_MEASUREMENT_CHANNEL8 : return getMeasurementChannel8();
		case EPC_MEASUREMENT_CHANNEL9 : return getMeasurementChannel9();
		case EPC_MEASUREMENT_CHANNEL10 : return getMeasurementChannel10();
		case EPC_MEASUREMENT_CHANNEL11 : return getMeasurementChannel11();
		case EPC_MEASUREMENT_CHANNEL12 : return getMeasurementChannel12();
		case EPC_MEASUREMENT_CHANNEL13 : return getMeasurementChannel13();
		case EPC_MEASUREMENT_CHANNEL14 : return getMeasurementChannel14();
		case EPC_MEASUREMENT_CHANNEL15 : return getMeasurementChannel15();
		case EPC_MEASUREMENT_CHANNEL16 : return getMeasurementChannel16();
		case EPC_MEASUREMENT_CHANNEL17 : return getMeasurementChannel17();
		case EPC_MEASUREMENT_CHANNEL18 : return getMeasurementChannel18();
		case EPC_MEASUREMENT_CHANNEL19 : return getMeasurementChannel19();
		case EPC_MEASUREMENT_CHANNEL20 : return getMeasurementChannel20();
		case EPC_MEASUREMENT_CHANNEL21 : return getMeasurementChannel21();
		case EPC_MEASUREMENT_CHANNEL22 : return getMeasurementChannel22();
		case EPC_MEASUREMENT_CHANNEL23 : return getMeasurementChannel23();
		case EPC_MEASUREMENT_CHANNEL24 : return getMeasurementChannel24();
		case EPC_MEASUREMENT_CHANNEL25 : return getMeasurementChannel25();
		case EPC_MEASUREMENT_CHANNEL26 : return getMeasurementChannel26();
		case EPC_MEASUREMENT_CHANNEL27 : return getMeasurementChannel27();
		case EPC_MEASUREMENT_CHANNEL28 : return getMeasurementChannel28();
		case EPC_MEASUREMENT_CHANNEL29 : return getMeasurementChannel29();
		case EPC_MEASUREMENT_CHANNEL30 : return getMeasurementChannel30();
		case EPC_MEASUREMENT_CHANNEL31 : return getMeasurementChannel31();
		case EPC_MEASUREMENT_CHANNEL32 : return getMeasurementChannel32();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION : return isValidMeasuredCumulativeAmountOfElectricEnergyNormalDirection(property.edt);
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION : return isValidMeasuredCumulativeAmountOfElectricEnergyReverseDirection(property.edt);
		case EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY : return isValidUnitForCumulativeAmountsOfElectricEnergy(property.edt);
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION : return isValidHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(property.edt);
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION : return isValidHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(property.edt);
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED : return isValidDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(property.edt);
		case EPC_MEASURED_INSTANTANEO_US_AMOUNT_OF_ELECTRIC_ENERGY : return isValidMeasuredInstantaneoUsAmountOfElectricEnergy(property.edt);
		case EPC_MEASURED_INSTANTANEOUS_CURRENTS : return isValidMeasuredInstantaneousCurrents(property.edt);
		case EPC_MEASURED_INSTANTANEOUS_VOLTAGES : return isValidMeasuredInstantaneousVoltages(property.edt);
		case EPC_MEASUREMENT_CHANNEL1 : return isValidMeasurementChannel1(property.edt);
		case EPC_MEASUREMENT_CHANNEL2 : return isValidMeasurementChannel2(property.edt);
		case EPC_MEASUREMENT_CHANNEL3 : return isValidMeasurementChannel3(property.edt);
		case EPC_MEASUREMENT_CHANNEL4 : return isValidMeasurementChannel4(property.edt);
		case EPC_MEASUREMENT_CHANNEL5 : return isValidMeasurementChannel5(property.edt);
		case EPC_MEASUREMENT_CHANNEL6 : return isValidMeasurementChannel6(property.edt);
		case EPC_MEASUREMENT_CHANNEL7 : return isValidMeasurementChannel7(property.edt);
		case EPC_MEASUREMENT_CHANNEL8 : return isValidMeasurementChannel8(property.edt);
		case EPC_MEASUREMENT_CHANNEL9 : return isValidMeasurementChannel9(property.edt);
		case EPC_MEASUREMENT_CHANNEL10 : return isValidMeasurementChannel10(property.edt);
		case EPC_MEASUREMENT_CHANNEL11 : return isValidMeasurementChannel11(property.edt);
		case EPC_MEASUREMENT_CHANNEL12 : return isValidMeasurementChannel12(property.edt);
		case EPC_MEASUREMENT_CHANNEL13 : return isValidMeasurementChannel13(property.edt);
		case EPC_MEASUREMENT_CHANNEL14 : return isValidMeasurementChannel14(property.edt);
		case EPC_MEASUREMENT_CHANNEL15 : return isValidMeasurementChannel15(property.edt);
		case EPC_MEASUREMENT_CHANNEL16 : return isValidMeasurementChannel16(property.edt);
		case EPC_MEASUREMENT_CHANNEL17 : return isValidMeasurementChannel17(property.edt);
		case EPC_MEASUREMENT_CHANNEL18 : return isValidMeasurementChannel18(property.edt);
		case EPC_MEASUREMENT_CHANNEL19 : return isValidMeasurementChannel19(property.edt);
		case EPC_MEASUREMENT_CHANNEL20 : return isValidMeasurementChannel20(property.edt);
		case EPC_MEASUREMENT_CHANNEL21 : return isValidMeasurementChannel21(property.edt);
		case EPC_MEASUREMENT_CHANNEL22 : return isValidMeasurementChannel22(property.edt);
		case EPC_MEASUREMENT_CHANNEL23 : return isValidMeasurementChannel23(property.edt);
		case EPC_MEASUREMENT_CHANNEL24 : return isValidMeasurementChannel24(property.edt);
		case EPC_MEASUREMENT_CHANNEL25 : return isValidMeasurementChannel25(property.edt);
		case EPC_MEASUREMENT_CHANNEL26 : return isValidMeasurementChannel26(property.edt);
		case EPC_MEASUREMENT_CHANNEL27 : return isValidMeasurementChannel27(property.edt);
		case EPC_MEASUREMENT_CHANNEL28 : return isValidMeasurementChannel28(property.edt);
		case EPC_MEASUREMENT_CHANNEL29 : return isValidMeasurementChannel29(property.edt);
		case EPC_MEASUREMENT_CHANNEL30 : return isValidMeasurementChannel30(property.edt);
		case EPC_MEASUREMENT_CHANNEL31 : return isValidMeasurementChannel31(property.edt);
		case EPC_MEASUREMENT_CHANNEL32 : return isValidMeasurementChannel32(property.edt);
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
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION : 
				onGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION : 
				onGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection(eoj, tid, esv, property, success);
				return true;
			case EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY : 
				onGetUnitForCumulativeAmountsOfElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION : 
				onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(eoj, tid, esv, property, success);
				return true;
			case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION : 
				onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(eoj, tid, esv, property, success);
				return true;
			case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED : 
				onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INSTANTANEO_US_AMOUNT_OF_ELECTRIC_ENERGY : 
				onGetMeasuredInstantaneoUsAmountOfElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INSTANTANEOUS_CURRENTS : 
				onGetMeasuredInstantaneousCurrents(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INSTANTANEOUS_VOLTAGES : 
				onGetMeasuredInstantaneousVoltages(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL1 : 
				onGetMeasurementChannel1(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL2 : 
				onGetMeasurementChannel2(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL3 : 
				onGetMeasurementChannel3(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL4 : 
				onGetMeasurementChannel4(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL5 : 
				onGetMeasurementChannel5(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL6 : 
				onGetMeasurementChannel6(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL7 : 
				onGetMeasurementChannel7(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL8 : 
				onGetMeasurementChannel8(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL9 : 
				onGetMeasurementChannel9(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL10 : 
				onGetMeasurementChannel10(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL11 : 
				onGetMeasurementChannel11(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL12 : 
				onGetMeasurementChannel12(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL13 : 
				onGetMeasurementChannel13(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL14 : 
				onGetMeasurementChannel14(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL15 : 
				onGetMeasurementChannel15(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL16 : 
				onGetMeasurementChannel16(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL17 : 
				onGetMeasurementChannel17(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL18 : 
				onGetMeasurementChannel18(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL19 : 
				onGetMeasurementChannel19(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL20 : 
				onGetMeasurementChannel20(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL21 : 
				onGetMeasurementChannel21(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL22 : 
				onGetMeasurementChannel22(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL23 : 
				onGetMeasurementChannel23(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL24 : 
				onGetMeasurementChannel24(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL25 : 
				onGetMeasurementChannel25(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL26 : 
				onGetMeasurementChannel26(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL27 : 
				onGetMeasurementChannel27(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL28 : 
				onGetMeasurementChannel28(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL29 : 
				onGetMeasurementChannel29(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL30 : 
				onGetMeasurementChannel30(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL31 : 
				onGetMeasurementChannel31(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASUREMENT_CHANNEL32 : 
				onGetMeasurementChannel32(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Measured cumulative amount of electric energy (normal direction)<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative amount of electric  energy using an 8-digit decimal notation number.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured cumulative amount of electric energy (reverse direction)<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative amount of electric  energy using an 8-digit decimal notation number.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Unit for cumulative amounts of electric energy<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00: 1kWh 0x01: 0.1kWh<br>
		 * 0x02: 0.01kWh<br>
		 * 0x03: 0.001kWh (Initial value) 0x04: 0.0001kWh<br>
		 * 0x0A: 10kWh 0x0B: 100kWh<br>
		 * 0x0C: 1000kWh<br>
		 * 0x0D: 10000kWh<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetUnitForCumulativeAmountsOfElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Historical data of measured cumulative amounts of electric energy
(normal direction)<br>
		 * <br>
		 * EPC : 0xC3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x0063 :<br>
		 * 0x00000000.0x05F5E0FF (0.99) : (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned short
+unsign ed
long
×48<br>
		 * <br>
		 * Data size : 194
bytes<br>
		 * <br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Historical data of measured cumulative amounts of electric energy
(reverse direction)<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x0063 :<br>
		 * 0x00000000.0x05F5E0FF (0.99) : (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned short
+unsign ed
long
×48<br>
		 * <br>
		 * Data size : 194
bytes<br>
		 * <br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
		 * <br>
		 * EPC : 0xC5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x63 ( 0.99)<br>
		 * 0: current day<br>
		 * 1. 99: previous day.day that precedes the current day by 99 days<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
		 * <br>
		 * EPC : 0xC5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x63 ( 0.99)<br>
		 * 0: current day<br>
		 * 1. 99: previous day.day that precedes the current day by 99 days<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured instantaneo us amount of electric energy<br>
		 * <br>
		 * EPC : 0xC6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x80000001.0x7FFFFFFD<br>
		 * (-2,147,483,647.2,147,483,645)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredInstantaneoUsAmountOfElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured instantaneous currents<br>
		 * <br>
		 * EPC : 0xC7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured effective instantaneous R and T phase currents in amperes.<br>
		 * In the case of a single-phase,<br>
		 * two-wire system, 0x7FFE shall be used for the T phase.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x8001-0x7FFD (R phase)<br>
		 * : 0x8001-0x7FFD (T phase)<br>
		 * (-3,276.7.3,276.5):<br>
		 * (-3,276.7.3,276.5)<br>
		 * <br>
		 * Data type : signed short
×2<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : 0.1
A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredInstantaneousCurrents(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured instantaneous voltages<br>
		 * <br>
		 * EPC : 0xC8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a single-phase, two-wire system, 0xFFFE shall be used for the S(N)-T voltage.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (between R and S(N)) :<br>
		 * 0x0000.0xFFFD (between S(N) and T)<br>
		 * (0.6,553.3) : (0.6,553.3)<br>
		 * <br>
		 * Data type : unsigned short
×2<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : 0.1
V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredInstantaneousVoltages(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 1<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 1 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 2<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 2 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 3<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 3 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel3(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 4<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 4 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel4(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 5<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 5 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel5(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 6<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 6 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel6(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 7<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 7 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel7(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 8<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 8 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel8(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 9<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 9 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel9(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 10<br>
		 * <br>
		 * EPC : 0xD9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 10 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel10(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 11<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 11 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel11(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 12<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 12 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel12(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 13<br>
		 * <br>
		 * EPC : 0xDC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 13 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel13(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 14<br>
		 * <br>
		 * EPC : 0xDD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 14 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel14(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 15<br>
		 * <br>
		 * EPC : 0xDE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 15 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel15(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 16<br>
		 * <br>
		 * EPC : 0xDF<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 16 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel16(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 17<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 17 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel17(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 18<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 18 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel18(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 19<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 19 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel19(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 20<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 20 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel20(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 21<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 21 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel21(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 22<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 22 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel22(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 23<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 23 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel23(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 24<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 24 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel24(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 25<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 25 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel25(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 26<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 26 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel26(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 27<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 27 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel27(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 28<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 28 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel28(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 29<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 29 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel29(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 30<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 30 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel30(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 31<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 31 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel31(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measurement channel 32<br>
		 * <br>
		 * EPC : 0xEF<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 32 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasurementChannel32(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * EPC : 0xC5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x63 ( 0.99)<br>
		 * 0: current day<br>
		 * 1. 99: previous day.day that precedes the current day by 99 days<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte[] edt) {
			reqSetProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED, edt);
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
		 * Property name : Measured cumulative amount of electric energy (normal direction)<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative amount of electric  energy using an 8-digit decimal notation number.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection() {
			reqGetProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
			return this;
		}
		/**
		 * Property name : Measured cumulative amount of electric energy (reverse direction)<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative amount of electric  energy using an 8-digit decimal notation number.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection() {
			reqGetProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION);
			return this;
		}
		/**
		 * Property name : Unit for cumulative amounts of electric energy<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00: 1kWh 0x01: 0.1kWh<br>
		 * 0x02: 0.01kWh<br>
		 * 0x03: 0.001kWh (Initial value) 0x04: 0.0001kWh<br>
		 * 0x0A: 10kWh 0x0B: 100kWh<br>
		 * 0x0C: 1000kWh<br>
		 * 0x0D: 10000kWh<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetUnitForCumulativeAmountsOfElectricEnergy() {
			reqGetProperty(EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Historical data of measured cumulative amounts of electric energy
(normal direction)<br>
		 * <br>
		 * EPC : 0xC3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x0063 :<br>
		 * 0x00000000.0x05F5E0FF (0.99) : (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned short
+unsign ed
long
×48<br>
		 * <br>
		 * Data size : 194
bytes<br>
		 * <br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection() {
			reqGetProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
			return this;
		}
		/**
		 * Property name : Historical data of measured cumulative amounts of electric energy
(reverse direction)<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x0063 :<br>
		 * 0x00000000.0x05F5E0FF (0.99) : (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned short
+unsign ed
long
×48<br>
		 * <br>
		 * Data size : 194
bytes<br>
		 * <br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection() {
			reqGetProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION);
			return this;
		}
		/**
		 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
		 * <br>
		 * EPC : 0xC5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x63 ( 0.99)<br>
		 * 0: current day<br>
		 * 1. 99: previous day.day that precedes the current day by 99 days<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved() {
			reqGetProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED);
			return this;
		}
		/**
		 * Property name : Measured instantaneo us amount of electric energy<br>
		 * <br>
		 * EPC : 0xC6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x80000001.0x7FFFFFFD<br>
		 * (-2,147,483,647.2,147,483,645)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredInstantaneoUsAmountOfElectricEnergy() {
			reqGetProperty(EPC_MEASURED_INSTANTANEO_US_AMOUNT_OF_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Measured instantaneous currents<br>
		 * <br>
		 * EPC : 0xC7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured effective instantaneous R and T phase currents in amperes.<br>
		 * In the case of a single-phase,<br>
		 * two-wire system, 0x7FFE shall be used for the T phase.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x8001-0x7FFD (R phase)<br>
		 * : 0x8001-0x7FFD (T phase)<br>
		 * (-3,276.7.3,276.5):<br>
		 * (-3,276.7.3,276.5)<br>
		 * <br>
		 * Data type : signed short
×2<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : 0.1
A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredInstantaneousCurrents() {
			reqGetProperty(EPC_MEASURED_INSTANTANEOUS_CURRENTS);
			return this;
		}
		/**
		 * Property name : Measured instantaneous voltages<br>
		 * <br>
		 * EPC : 0xC8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a single-phase, two-wire system, 0xFFFE shall be used for the S(N)-T voltage.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (between R and S(N)) :<br>
		 * 0x0000.0xFFFD (between S(N) and T)<br>
		 * (0.6,553.3) : (0.6,553.3)<br>
		 * <br>
		 * Data type : unsigned short
×2<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : 0.1
V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredInstantaneousVoltages() {
			reqGetProperty(EPC_MEASURED_INSTANTANEOUS_VOLTAGES);
			return this;
		}
		/**
		 * Property name : Measurement channel 1<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 1 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel1() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL1);
			return this;
		}
		/**
		 * Property name : Measurement channel 2<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 2 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel2() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL2);
			return this;
		}
		/**
		 * Property name : Measurement channel 3<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 3 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel3() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL3);
			return this;
		}
		/**
		 * Property name : Measurement channel 4<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 4 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel4() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL4);
			return this;
		}
		/**
		 * Property name : Measurement channel 5<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 5 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel5() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL5);
			return this;
		}
		/**
		 * Property name : Measurement channel 6<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 6 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel6() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL6);
			return this;
		}
		/**
		 * Property name : Measurement channel 7<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 7 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel7() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL7);
			return this;
		}
		/**
		 * Property name : Measurement channel 8<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 8 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel8() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL8);
			return this;
		}
		/**
		 * Property name : Measurement channel 9<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 9 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel9() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL9);
			return this;
		}
		/**
		 * Property name : Measurement channel 10<br>
		 * <br>
		 * EPC : 0xD9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 10 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel10() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL10);
			return this;
		}
		/**
		 * Property name : Measurement channel 11<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 11 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel11() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL11);
			return this;
		}
		/**
		 * Property name : Measurement channel 12<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 12 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel12() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL12);
			return this;
		}
		/**
		 * Property name : Measurement channel 13<br>
		 * <br>
		 * EPC : 0xDC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 13 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel13() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL13);
			return this;
		}
		/**
		 * Property name : Measurement channel 14<br>
		 * <br>
		 * EPC : 0xDD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 14 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel14() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL14);
			return this;
		}
		/**
		 * Property name : Measurement channel 15<br>
		 * <br>
		 * EPC : 0xDE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 15 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel15() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL15);
			return this;
		}
		/**
		 * Property name : Measurement channel 16<br>
		 * <br>
		 * EPC : 0xDF<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 16 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel16() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL16);
			return this;
		}
		/**
		 * Property name : Measurement channel 17<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 17 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel17() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL17);
			return this;
		}
		/**
		 * Property name : Measurement channel 18<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 18 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel18() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL18);
			return this;
		}
		/**
		 * Property name : Measurement channel 19<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 19 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel19() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL19);
			return this;
		}
		/**
		 * Property name : Measurement channel 20<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 20 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel20() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL20);
			return this;
		}
		/**
		 * Property name : Measurement channel 21<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 21 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel21() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL21);
			return this;
		}
		/**
		 * Property name : Measurement channel 22<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 22 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel22() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL22);
			return this;
		}
		/**
		 * Property name : Measurement channel 23<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 23 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel23() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL23);
			return this;
		}
		/**
		 * Property name : Measurement channel 24<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 24 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel24() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL24);
			return this;
		}
		/**
		 * Property name : Measurement channel 25<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 25 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel25() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL25);
			return this;
		}
		/**
		 * Property name : Measurement channel 26<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 26 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel26() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL26);
			return this;
		}
		/**
		 * Property name : Measurement channel 27<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 27 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel27() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL27);
			return this;
		}
		/**
		 * Property name : Measurement channel 28<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 28 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel28() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL28);
			return this;
		}
		/**
		 * Property name : Measurement channel 29<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 29 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel29() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL29);
			return this;
		}
		/**
		 * Property name : Measurement channel 30<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 30 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel30() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL30);
			return this;
		}
		/**
		 * Property name : Measurement channel 31<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 31 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel31() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL31);
			return this;
		}
		/**
		 * Property name : Measurement channel 32<br>
		 * <br>
		 * EPC : 0xEF<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 32 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasurementChannel32() {
			reqGetProperty(EPC_MEASUREMENT_CHANNEL32);
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
		 * Property name : Measured cumulative amount of electric energy (normal direction)<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative amount of electric  energy using an 8-digit decimal notation number.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyNormalDirection() {
			reqInformProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
			return this;
		}
		/**
		 * Property name : Measured cumulative amount of electric energy (reverse direction)<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative amount of electric  energy using an 8-digit decimal notation number.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyReverseDirection() {
			reqInformProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION);
			return this;
		}
		/**
		 * Property name : Unit for cumulative amounts of electric energy<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00: 1kWh 0x01: 0.1kWh<br>
		 * 0x02: 0.01kWh<br>
		 * 0x03: 0.001kWh (Initial value) 0x04: 0.0001kWh<br>
		 * 0x0A: 10kWh 0x0B: 100kWh<br>
		 * 0x0C: 1000kWh<br>
		 * 0x0D: 10000kWh<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformUnitForCumulativeAmountsOfElectricEnergy() {
			reqInformProperty(EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Historical data of measured cumulative amounts of electric energy
(normal direction)<br>
		 * <br>
		 * EPC : 0xC3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x0063 :<br>
		 * 0x00000000.0x05F5E0FF (0.99) : (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned short
+unsign ed
long
×48<br>
		 * <br>
		 * Data size : 194
bytes<br>
		 * <br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection() {
			reqInformProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
			return this;
		}
		/**
		 * Property name : Historical data of measured cumulative amounts of electric energy
(reverse direction)<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x0063 :<br>
		 * 0x00000000.0x05F5E0FF (0.99) : (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned short
+unsign ed
long
×48<br>
		 * <br>
		 * Data size : 194
bytes<br>
		 * <br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection() {
			reqInformProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION);
			return this;
		}
		/**
		 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
		 * <br>
		 * EPC : 0xC5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x63 ( 0.99)<br>
		 * 0: current day<br>
		 * 1. 99: previous day.day that precedes the current day by 99 days<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved() {
			reqInformProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED);
			return this;
		}
		/**
		 * Property name : Measured instantaneo us amount of electric energy<br>
		 * <br>
		 * EPC : 0xC6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x80000001.0x7FFFFFFD<br>
		 * (-2,147,483,647.2,147,483,645)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredInstantaneoUsAmountOfElectricEnergy() {
			reqInformProperty(EPC_MEASURED_INSTANTANEO_US_AMOUNT_OF_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Measured instantaneous currents<br>
		 * <br>
		 * EPC : 0xC7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured effective instantaneous R and T phase currents in amperes.<br>
		 * In the case of a single-phase,<br>
		 * two-wire system, 0x7FFE shall be used for the T phase.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x8001-0x7FFD (R phase)<br>
		 * : 0x8001-0x7FFD (T phase)<br>
		 * (-3,276.7.3,276.5):<br>
		 * (-3,276.7.3,276.5)<br>
		 * <br>
		 * Data type : signed short
×2<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : 0.1
A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredInstantaneousCurrents() {
			reqInformProperty(EPC_MEASURED_INSTANTANEOUS_CURRENTS);
			return this;
		}
		/**
		 * Property name : Measured instantaneous voltages<br>
		 * <br>
		 * EPC : 0xC8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a single-phase, two-wire system, 0xFFFE shall be used for the S(N)-T voltage.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (between R and S(N)) :<br>
		 * 0x0000.0xFFFD (between S(N) and T)<br>
		 * (0.6,553.3) : (0.6,553.3)<br>
		 * <br>
		 * Data type : unsigned short
×2<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : 0.1
V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredInstantaneousVoltages() {
			reqInformProperty(EPC_MEASURED_INSTANTANEOUS_VOLTAGES);
			return this;
		}
		/**
		 * Property name : Measurement channel 1<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 1 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel1() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL1);
			return this;
		}
		/**
		 * Property name : Measurement channel 2<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 2 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel2() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL2);
			return this;
		}
		/**
		 * Property name : Measurement channel 3<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 3 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel3() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL3);
			return this;
		}
		/**
		 * Property name : Measurement channel 4<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 4 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel4() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL4);
			return this;
		}
		/**
		 * Property name : Measurement channel 5<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 5 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel5() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL5);
			return this;
		}
		/**
		 * Property name : Measurement channel 6<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 6 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel6() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL6);
			return this;
		}
		/**
		 * Property name : Measurement channel 7<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 7 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel7() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL7);
			return this;
		}
		/**
		 * Property name : Measurement channel 8<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 8 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel8() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL8);
			return this;
		}
		/**
		 * Property name : Measurement channel 9<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 9 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel9() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL9);
			return this;
		}
		/**
		 * Property name : Measurement channel 10<br>
		 * <br>
		 * EPC : 0xD9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 10 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel10() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL10);
			return this;
		}
		/**
		 * Property name : Measurement channel 11<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 11 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel11() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL11);
			return this;
		}
		/**
		 * Property name : Measurement channel 12<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 12 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel12() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL12);
			return this;
		}
		/**
		 * Property name : Measurement channel 13<br>
		 * <br>
		 * EPC : 0xDC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 13 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel13() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL13);
			return this;
		}
		/**
		 * Property name : Measurement channel 14<br>
		 * <br>
		 * EPC : 0xDD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 14 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel14() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL14);
			return this;
		}
		/**
		 * Property name : Measurement channel 15<br>
		 * <br>
		 * EPC : 0xDE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 15 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel15() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL15);
			return this;
		}
		/**
		 * Property name : Measurement channel 16<br>
		 * <br>
		 * EPC : 0xDF<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 16 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel16() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL16);
			return this;
		}
		/**
		 * Property name : Measurement channel 17<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 17 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel17() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL17);
			return this;
		}
		/**
		 * Property name : Measurement channel 18<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 18 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel18() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL18);
			return this;
		}
		/**
		 * Property name : Measurement channel 19<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 19 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel19() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL19);
			return this;
		}
		/**
		 * Property name : Measurement channel 20<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 20 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel20() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL20);
			return this;
		}
		/**
		 * Property name : Measurement channel 21<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 21 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel21() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL21);
			return this;
		}
		/**
		 * Property name : Measurement channel 22<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 22 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel22() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL22);
			return this;
		}
		/**
		 * Property name : Measurement channel 23<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 23 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel23() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL23);
			return this;
		}
		/**
		 * Property name : Measurement channel 24<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 24 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel24() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL24);
			return this;
		}
		/**
		 * Property name : Measurement channel 25<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 25 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel25() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL25);
			return this;
		}
		/**
		 * Property name : Measurement channel 26<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 26 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel26() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL26);
			return this;
		}
		/**
		 * Property name : Measurement channel 27<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 27 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel27() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL27);
			return this;
		}
		/**
		 * Property name : Measurement channel 28<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 28 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel28() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL28);
			return this;
		}
		/**
		 * Property name : Measurement channel 29<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 29 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel29() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL29);
			return this;
		}
		/**
		 * Property name : Measurement channel 30<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 30 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel30() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL30);
			return this;
		}
		/**
		 * Property name : Measurement channel 31<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 31 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel31() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL31);
			return this;
		}
		/**
		 * Property name : Measurement channel 32<br>
		 * <br>
		 * EPC : 0xEF<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measurement data for Measurement channel 32 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Data format for the electric energy: same as 0xC0<br>
		 * Unit: same as 0xC2<br>
		 * Data format for the currents: same as 0xC7<br>
		 * <br>
		 * Data type : unsigned long
+
signed short
×2<br>
		 * <br>
		 * Data size : 8
bytes<br>
		 * <br>
		 * Unit : kWh
+ 0.1A
×2<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasurementChannel32() {
			reqInformProperty(EPC_MEASUREMENT_CHANNEL32);
			return this;
		}
	}

	public static class Proxy extends PowerDistributionBoardMetering {
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
		protected byte[] getMeasuredCumulativeAmountOfElectricEnergyNormalDirection() {return null;}
		@Override
		protected byte[] getMeasuredCumulativeAmountOfElectricEnergyReverseDirection() {return null;}
		@Override
		protected byte[] getUnitForCumulativeAmountsOfElectricEnergy() {return null;}
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
