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

public abstract class PowerDistributionBoardMetering extends DeviceObject {
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x87;

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
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br><br>0x00000000-0x05F5E0FF (0-99,999,999)<br><br>Name : Measured cumulative amount of electric energy (normal direction)<br>EPC : 0xC0<br>Data Type : unsigned long<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
	private final byte[] _getMeasuredCumulativeAmountOfElectricEnergyNormalDirection(byte epc) {
		byte[] edt = getMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br><br>0x00000000-0x05F5E0FF (0-99,999,999)<br><br>Name : Measured cumulative amount of electric energy (reverse direction)<br>EPC : 0xC1<br>Data Type : unsigned long<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getMeasuredCumulativeAmountOfElectricEnergyReverseDirection();
	private final byte[] _getMeasuredCumulativeAmountOfElectricEnergyReverseDirection(byte epc) {
		byte[] edt = getMeasuredCumulativeAmountOfElectricEnergyReverseDirection();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br><br>0x00: 1kWh 0x01: 0.1kWh 0x02: 0.01kWh 0x03: 0.001kWh�iInitial value�j 0x04: 0.0001kWh 0x0A: 10kWh 0x0B: 100kWh 0x0C: 1000kWh 0x0D: 10000kWh<br><br>Name : Unit for cumulative amounts of electric energy<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getUnitForCumulativeAmountsOfElectricEnergy();
	private final byte[] _getUnitForCumulativeAmountsOfElectricEnergy(byte epc) {
		byte[] edt = getUnitForCumulativeAmountsOfElectricEnergy();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br><br>0x0000-0x0063�F 0x00000000-0x05F5E0FF (0-99)�F(0-99,999,999)<br><br>Name : Historical data of measured cumulative amounts of electric energy (normal direction)<br>EPC : 0xC3<br>Data Type : unsigned short �{ unsigned long �~48<br>Data Size(Byte) : 194 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection() {return null;}
	private final byte[] _getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(byte epc) {
		byte[] edt = getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br><br>0x0000-0x0063�F 0x00000000-0x05F5E0FF (0-99)�F(0-99,999,999)<br><br>Name : Historical data of measured cumulative amounts of electric energy (reverse direction)<br>EPC : 0xC4<br>Data Type : unsigned short �{ unsigned long �~48<br>Data Size(Byte) : 194 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection() {return null;}
	private final byte[] _getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(byte epc) {
		byte[] edt = getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br><br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days<br><br>Name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>EPC : 0xC5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte[] edt) {return false;}
	private final boolean _setDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte epc, byte[] edt) {
		boolean success = setDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br><br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days<br><br>Name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>EPC : 0xC5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved() {return null;}
	private final byte[] _getDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte epc) {
		byte[] edt = getDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br><br>0x80000001-0x7FFFFFFD (-2,147,483,647- 2,147,483,645)<br><br>Name : Measured instantaneo us amount of electric energy<br>EPC : 0xC6<br>Data Type : signed long<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredInstantaneoUsAmountOfElectricEnergy() {return null;}
	private final byte[] _getMeasuredInstantaneoUsAmountOfElectricEnergy(byte epc) {
		byte[] edt = getMeasuredInstantaneoUsAmountOfElectricEnergy();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured effective instantaneous R and T phase currents in amperes. In the case of a single-phase, two-wire system, 0x7FFE shall be used for the T phase.<br><br>0x8001-0x7FFD�iR phase�j : 0x8001-0x7FFD�iT phase�j (-3,276.7-3,276.5): (-3,276.7-3,276.5)<br><br>Name : Measured instantaneous currents<br>EPC : 0xC7<br>Data Type : signed short �~2<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredInstantaneousCurrents() {return null;}
	private final byte[] _getMeasuredInstantaneousCurrents(byte epc) {
		byte[] edt = getMeasuredInstantaneousCurrents();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a single-phase, two-wire system, 0xFFFE shall be used for the S(N)-T voltage.<br><br>0x0000-0xFFFD (between R and S(N))�F 0x0000-0xFFFD (between S(N) and T) (0-6,553.3) : (0-6,553.3)<br><br>Name : Measured instantaneous voltages<br>EPC : 0xC8<br>Data Type : unsigned short �~2<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredInstantaneousVoltages() {return null;}
	private final byte[] _getMeasuredInstantaneousVoltages(byte epc) {
		byte[] edt = getMeasuredInstantaneousVoltages();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 1 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 1<br>EPC : 0xD0<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel1() {return null;}
	private final byte[] _getMeasurementChannel1(byte epc) {
		byte[] edt = getMeasurementChannel1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 2 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 2<br>EPC : 0xD1<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel2() {return null;}
	private final byte[] _getMeasurementChannel2(byte epc) {
		byte[] edt = getMeasurementChannel2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 3 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 3<br>EPC : 0xD2<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel3() {return null;}
	private final byte[] _getMeasurementChannel3(byte epc) {
		byte[] edt = getMeasurementChannel3();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 4 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 4<br>EPC : 0xD3<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel4() {return null;}
	private final byte[] _getMeasurementChannel4(byte epc) {
		byte[] edt = getMeasurementChannel4();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 5 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 5<br>EPC : 0xD4<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel5() {return null;}
	private final byte[] _getMeasurementChannel5(byte epc) {
		byte[] edt = getMeasurementChannel5();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 6 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 6<br>EPC : 0xD5<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel6() {return null;}
	private final byte[] _getMeasurementChannel6(byte epc) {
		byte[] edt = getMeasurementChannel6();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 7 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 7<br>EPC : 0xD6<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel7() {return null;}
	private final byte[] _getMeasurementChannel7(byte epc) {
		byte[] edt = getMeasurementChannel7();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 8 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 8<br>EPC : 0xD7<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel8() {return null;}
	private final byte[] _getMeasurementChannel8(byte epc) {
		byte[] edt = getMeasurementChannel8();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 9 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 9<br>EPC : 0xD8<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel9() {return null;}
	private final byte[] _getMeasurementChannel9(byte epc) {
		byte[] edt = getMeasurementChannel9();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 10 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 10<br>EPC : 0xD9<br>Data Type : unsigned long �{ uigned short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel10() {return null;}
	private final byte[] _getMeasurementChannel10(byte epc) {
		byte[] edt = getMeasurementChannel10();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 11 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 11<br>EPC : 0xDA<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel11() {return null;}
	private final byte[] _getMeasurementChannel11(byte epc) {
		byte[] edt = getMeasurementChannel11();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 12 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 12<br>EPC : 0xDB<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel12() {return null;}
	private final byte[] _getMeasurementChannel12(byte epc) {
		byte[] edt = getMeasurementChannel12();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 13 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 13<br>EPC : 0xDC<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel13() {return null;}
	private final byte[] _getMeasurementChannel13(byte epc) {
		byte[] edt = getMeasurementChannel13();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 14 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 14<br>EPC : 0xDD<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel14() {return null;}
	private final byte[] _getMeasurementChannel14(byte epc) {
		byte[] edt = getMeasurementChannel14();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 15 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 15<br>EPC : 0xDE<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel15() {return null;}
	private final byte[] _getMeasurementChannel15(byte epc) {
		byte[] edt = getMeasurementChannel15();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 16 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 16<br>EPC : 0xDF<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel16() {return null;}
	private final byte[] _getMeasurementChannel16(byte epc) {
		byte[] edt = getMeasurementChannel16();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 17 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 17<br>EPC : 0xE0<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel17() {return null;}
	private final byte[] _getMeasurementChannel17(byte epc) {
		byte[] edt = getMeasurementChannel17();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 18 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 18<br>EPC : 0xE1<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel18() {return null;}
	private final byte[] _getMeasurementChannel18(byte epc) {
		byte[] edt = getMeasurementChannel18();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 19 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 19<br>EPC : 0xE2<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel19() {return null;}
	private final byte[] _getMeasurementChannel19(byte epc) {
		byte[] edt = getMeasurementChannel19();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 20 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 20<br>EPC : 0xE3<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel20() {return null;}
	private final byte[] _getMeasurementChannel20(byte epc) {
		byte[] edt = getMeasurementChannel20();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 21 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 21<br>EPC : 0xE4<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel21() {return null;}
	private final byte[] _getMeasurementChannel21(byte epc) {
		byte[] edt = getMeasurementChannel21();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 22 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 22<br>EPC : 0xE5<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel22() {return null;}
	private final byte[] _getMeasurementChannel22(byte epc) {
		byte[] edt = getMeasurementChannel22();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 23 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 23<br>EPC : 0xE6<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel23() {return null;}
	private final byte[] _getMeasurementChannel23(byte epc) {
		byte[] edt = getMeasurementChannel23();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 24 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 24<br>EPC : 0xE7<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel24() {return null;}
	private final byte[] _getMeasurementChannel24(byte epc) {
		byte[] edt = getMeasurementChannel24();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 25 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 25<br>EPC : 0xE8<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel25() {return null;}
	private final byte[] _getMeasurementChannel25(byte epc) {
		byte[] edt = getMeasurementChannel25();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 26 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 26<br>EPC : 0xE9<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel26() {return null;}
	private final byte[] _getMeasurementChannel26(byte epc) {
		byte[] edt = getMeasurementChannel26();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 27 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 27<br>EPC : 0xEA<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel27() {return null;}
	private final byte[] _getMeasurementChannel27(byte epc) {
		byte[] edt = getMeasurementChannel27();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 28 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 28<br>EPC : 0xEB<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel28() {return null;}
	private final byte[] _getMeasurementChannel28(byte epc) {
		byte[] edt = getMeasurementChannel28();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 29 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 29<br>EPC : 0xEC<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel29() {return null;}
	private final byte[] _getMeasurementChannel29(byte epc) {
		byte[] edt = getMeasurementChannel29();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 30 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 30<br>EPC : 0xED<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel30() {return null;}
	private final byte[] _getMeasurementChannel30(byte epc) {
		byte[] edt = getMeasurementChannel30();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 31 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 31<br>EPC : 0xEE<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel31() {return null;}
	private final byte[] _getMeasurementChannel31(byte epc) {
		byte[] edt = getMeasurementChannel31();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measurement data for Measurement channel 32 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 32<br>EPC : 0xEF<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasurementChannel32() {return null;}
	private final byte[] _getMeasurementChannel32(byte epc) {
		byte[] edt = getMeasurementChannel32();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED:
			res.addProperty(epc, edt, _setDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION:
			edt = _getMeasuredCumulativeAmountOfElectricEnergyNormalDirection(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION:
			edt = _getMeasuredCumulativeAmountOfElectricEnergyReverseDirection(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY:
			edt = _getUnitForCumulativeAmountsOfElectricEnergy(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION:
			edt = _getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 194)));
			break;
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION:
			edt = _getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 194)));
			break;
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED:
			edt = _getDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_INSTANTANEO_US_AMOUNT_OF_ELECTRIC_ENERGY:
			edt = _getMeasuredInstantaneoUsAmountOfElectricEnergy(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_MEASURED_INSTANTANEOUS_CURRENTS:
			edt = _getMeasuredInstantaneousCurrents(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_MEASURED_INSTANTANEOUS_VOLTAGES:
			edt = _getMeasuredInstantaneousVoltages(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_MEASUREMENT_CHANNEL1:
			edt = _getMeasurementChannel1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL2:
			edt = _getMeasurementChannel2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL3:
			edt = _getMeasurementChannel3(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL4:
			edt = _getMeasurementChannel4(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL5:
			edt = _getMeasurementChannel5(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL6:
			edt = _getMeasurementChannel6(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL7:
			edt = _getMeasurementChannel7(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL8:
			edt = _getMeasurementChannel8(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL9:
			edt = _getMeasurementChannel9(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL10:
			edt = _getMeasurementChannel10(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL11:
			edt = _getMeasurementChannel11(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL12:
			edt = _getMeasurementChannel12(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL13:
			edt = _getMeasurementChannel13(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL14:
			edt = _getMeasurementChannel14(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL15:
			edt = _getMeasurementChannel15(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL16:
			edt = _getMeasurementChannel16(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL17:
			edt = _getMeasurementChannel17(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL18:
			edt = _getMeasurementChannel18(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL19:
			edt = _getMeasurementChannel19(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL20:
			edt = _getMeasurementChannel20(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL21:
			edt = _getMeasurementChannel21(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL22:
			edt = _getMeasurementChannel22(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL23:
			edt = _getMeasurementChannel23(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL24:
			edt = _getMeasurementChannel24(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL25:
			edt = _getMeasurementChannel25(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL26:
			edt = _getMeasurementChannel26(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL27:
			edt = _getMeasurementChannel27(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL28:
			edt = _getMeasurementChannel28(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL29:
			edt = _getMeasurementChannel29(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL30:
			edt = _getMeasurementChannel30(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL31:
			edt = _getMeasurementChannel31(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL32:
			edt = _getMeasurementChannel32(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
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
			case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED:
				_onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION:
				_onGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION:
				_onGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY:
				_onGetUnitForCumulativeAmountsOfElectricEnergy(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION:
				_onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION:
				_onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED:
				_onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEO_US_AMOUNT_OF_ELECTRIC_ENERGY:
				_onGetMeasuredInstantaneoUsAmountOfElectricEnergy(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_CURRENTS:
				_onGetMeasuredInstantaneousCurrents(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_VOLTAGES:
				_onGetMeasuredInstantaneousVoltages(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL1:
				_onGetMeasurementChannel1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL2:
				_onGetMeasurementChannel2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL3:
				_onGetMeasurementChannel3(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL4:
				_onGetMeasurementChannel4(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL5:
				_onGetMeasurementChannel5(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL6:
				_onGetMeasurementChannel6(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL7:
				_onGetMeasurementChannel7(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL8:
				_onGetMeasurementChannel8(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL9:
				_onGetMeasurementChannel9(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL10:
				_onGetMeasurementChannel10(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL11:
				_onGetMeasurementChannel11(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL12:
				_onGetMeasurementChannel12(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL13:
				_onGetMeasurementChannel13(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL14:
				_onGetMeasurementChannel14(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL15:
				_onGetMeasurementChannel15(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL16:
				_onGetMeasurementChannel16(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL17:
				_onGetMeasurementChannel17(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL18:
				_onGetMeasurementChannel18(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL19:
				_onGetMeasurementChannel19(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL20:
				_onGetMeasurementChannel20(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL21:
				_onGetMeasurementChannel21(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL22:
				_onGetMeasurementChannel22(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL23:
				_onGetMeasurementChannel23(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL24:
				_onGetMeasurementChannel24(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL25:
				_onGetMeasurementChannel25(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL26:
				_onGetMeasurementChannel26(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL27:
				_onGetMeasurementChannel27(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL28:
				_onGetMeasurementChannel28(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL29:
				_onGetMeasurementChannel29(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL30:
				_onGetMeasurementChannel30(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL31:
				_onGetMeasurementChannel31(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL32:
				_onGetMeasurementChannel32(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br><br>0x00000000-0x05F5E0FF (0-99,999,999)<br><br>Name : Measured cumulative amount of electric energy (normal direction)<br>EPC : 0xC0<br>Data Type : unsigned long<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br><br>0x00000000-0x05F5E0FF (0-99,999,999)<br><br>Name : Measured cumulative amount of electric energy (reverse direction)<br>EPC : 0xC1<br>Data Type : unsigned long<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br><br>0x00: 1kWh 0x01: 0.1kWh 0x02: 0.01kWh 0x03: 0.001kWh�iInitial value�j 0x04: 0.0001kWh 0x0A: 10kWh 0x0B: 100kWh 0x0C: 1000kWh 0x0D: 10000kWh<br><br>Name : Unit for cumulative amounts of electric energy<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetUnitForCumulativeAmountsOfElectricEnergy(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetUnitForCumulativeAmountsOfElectricEnergy(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetUnitForCumulativeAmountsOfElectricEnergy(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br><br>0x0000-0x0063�F 0x00000000-0x05F5E0FF (0-99)�F(0-99,999,999)<br><br>Name : Historical data of measured cumulative amounts of electric energy (normal direction)<br>EPC : 0xC3<br>Data Type : unsigned short �{ unsigned long �~48<br>Data Size(Byte) : 194 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br><br>0x0000-0x0063�F 0x00000000-0x05F5E0FF (0-99)�F(0-99,999,999)<br><br>Name : Historical data of measured cumulative amounts of electric energy (reverse direction)<br>EPC : 0xC4<br>Data Type : unsigned short �{ unsigned long �~48<br>Data Size(Byte) : 194 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br><br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days<br><br>Name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>EPC : 0xC5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br><br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days<br><br>Name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>EPC : 0xC5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br><br>0x80000001-0x7FFFFFFD (-2,147,483,647- 2,147,483,645)<br><br>Name : Measured instantaneo us amount of electric energy<br>EPC : 0xC6<br>Data Type : signed long<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredInstantaneoUsAmountOfElectricEnergy(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredInstantaneoUsAmountOfElectricEnergy(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredInstantaneoUsAmountOfElectricEnergy(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured effective instantaneous R and T phase currents in amperes. In the case of a single-phase, two-wire system, 0x7FFE shall be used for the T phase.<br><br>0x8001-0x7FFD�iR phase�j : 0x8001-0x7FFD�iT phase�j (-3,276.7-3,276.5): (-3,276.7-3,276.5)<br><br>Name : Measured instantaneous currents<br>EPC : 0xC7<br>Data Type : signed short �~2<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredInstantaneousCurrents(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredInstantaneousCurrents(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredInstantaneousCurrents(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a single-phase, two-wire system, 0xFFFE shall be used for the S(N)-T voltage.<br><br>0x0000-0xFFFD (between R and S(N))�F 0x0000-0xFFFD (between S(N) and T) (0-6,553.3) : (0-6,553.3)<br><br>Name : Measured instantaneous voltages<br>EPC : 0xC8<br>Data Type : unsigned short �~2<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredInstantaneousVoltages(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredInstantaneousVoltages(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredInstantaneousVoltages(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 1 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 1<br>EPC : 0xD0<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 2 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 2<br>EPC : 0xD1<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 3 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 3<br>EPC : 0xD2<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel3(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 4 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 4<br>EPC : 0xD3<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel4(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel4(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel4(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 5 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 5<br>EPC : 0xD4<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel5(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel5(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel5(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 6 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 6<br>EPC : 0xD5<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel6(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel6(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel6(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 7 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 7<br>EPC : 0xD6<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel7(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel7(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel7(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 8 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 8<br>EPC : 0xD7<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel8(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel8(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel8(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 9 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 9<br>EPC : 0xD8<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel9(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel9(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel9(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 10 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 10<br>EPC : 0xD9<br>Data Type : unsigned long �{ uigned short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel10(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel10(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel10(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 11 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 11<br>EPC : 0xDA<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel11(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel11(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel11(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 12 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 12<br>EPC : 0xDB<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel12(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel12(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel12(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 13 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 13<br>EPC : 0xDC<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel13(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel13(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel13(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 14 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 14<br>EPC : 0xDD<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel14(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel14(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel14(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 15 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 15<br>EPC : 0xDE<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel15(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel15(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel15(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 16 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 16<br>EPC : 0xDF<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel16(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel16(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel16(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 17 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 17<br>EPC : 0xE0<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel17(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel17(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel17(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 18 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 18<br>EPC : 0xE1<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel18(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel18(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel18(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 19 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 19<br>EPC : 0xE2<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel19(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel19(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel19(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 20 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 20<br>EPC : 0xE3<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel20(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel20(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel20(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 21 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 21<br>EPC : 0xE4<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel21(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel21(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel21(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 22 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 22<br>EPC : 0xE5<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel22(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel22(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel22(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 23 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 23<br>EPC : 0xE6<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel23(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel23(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel23(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 24 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 24<br>EPC : 0xE7<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel24(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel24(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel24(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 25 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 25<br>EPC : 0xE8<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel25(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel25(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel25(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 26 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 26<br>EPC : 0xE9<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel26(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel26(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel26(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 27 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 27<br>EPC : 0xEA<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel27(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel27(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel27(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 28 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 28<br>EPC : 0xEB<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel28(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel28(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel28(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 29 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 29<br>EPC : 0xEC<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel29(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel29(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel29(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 30 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 30<br>EPC : 0xED<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel30(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel30(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel30(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 31 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 31<br>EPC : 0xEE<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel31(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel31(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel31(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measurement data for Measurement channel 32 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 32<br>EPC : 0xEF<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasurementChannel32(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasurementChannel32(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasurementChannel32(eoj, tid, esv, epc, pdc, edt);
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
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br><br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days<br><br>Name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>EPC : 0xC5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte[] edt) {
			addProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED, edt, (edt != null && (edt.length == 1)));
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
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br><br>0x00000000-0x05F5E0FF (0-99,999,999)<br><br>Name : Measured cumulative amount of electric energy (normal direction)<br>EPC : 0xC0<br>Data Type : unsigned long<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
			return this;
		}
		/**
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br><br>0x00000000-0x05F5E0FF (0-99,999,999)<br><br>Name : Measured cumulative amount of electric energy (reverse direction)<br>EPC : 0xC1<br>Data Type : unsigned long<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION);
			return this;
		}
		/**
		 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br><br>0x00: 1kWh 0x01: 0.1kWh 0x02: 0.01kWh 0x03: 0.001kWh�iInitial value�j 0x04: 0.0001kWh 0x0A: 10kWh 0x0B: 100kWh 0x0C: 1000kWh 0x0D: 10000kWh<br><br>Name : Unit for cumulative amounts of electric energy<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetUnitForCumulativeAmountsOfElectricEnergy() {
			addProperty(EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br><br>0x0000-0x0063�F 0x00000000-0x05F5E0FF (0-99)�F(0-99,999,999)<br><br>Name : Historical data of measured cumulative amounts of electric energy (normal direction)<br>EPC : 0xC3<br>Data Type : unsigned short �{ unsigned long �~48<br>Data Size(Byte) : 194 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection() {
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
			return this;
		}
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br><br>0x0000-0x0063�F 0x00000000-0x05F5E0FF (0-99)�F(0-99,999,999)<br><br>Name : Historical data of measured cumulative amounts of electric energy (reverse direction)<br>EPC : 0xC4<br>Data Type : unsigned short �{ unsigned long �~48<br>Data Size(Byte) : 194 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection() {
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION);
			return this;
		}
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br><br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days<br><br>Name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>EPC : 0xC5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved() {
			addProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED);
			return this;
		}
		/**
		 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br><br>0x80000001-0x7FFFFFFD (-2,147,483,647- 2,147,483,645)<br><br>Name : Measured instantaneo us amount of electric energy<br>EPC : 0xC6<br>Data Type : signed long<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredInstantaneoUsAmountOfElectricEnergy() {
			addProperty(EPC_MEASURED_INSTANTANEO_US_AMOUNT_OF_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * This property indicates the measured effective instantaneous R and T phase currents in amperes. In the case of a single-phase, two-wire system, 0x7FFE shall be used for the T phase.<br><br>0x8001-0x7FFD�iR phase�j : 0x8001-0x7FFD�iT phase�j (-3,276.7-3,276.5): (-3,276.7-3,276.5)<br><br>Name : Measured instantaneous currents<br>EPC : 0xC7<br>Data Type : signed short �~2<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredInstantaneousCurrents() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_CURRENTS);
			return this;
		}
		/**
		 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a single-phase, two-wire system, 0xFFFE shall be used for the S(N)-T voltage.<br><br>0x0000-0xFFFD (between R and S(N))�F 0x0000-0xFFFD (between S(N) and T) (0-6,553.3) : (0-6,553.3)<br><br>Name : Measured instantaneous voltages<br>EPC : 0xC8<br>Data Type : unsigned short �~2<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredInstantaneousVoltages() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_VOLTAGES);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 1 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 1<br>EPC : 0xD0<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel1() {
			addProperty(EPC_MEASUREMENT_CHANNEL1);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 2 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 2<br>EPC : 0xD1<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel2() {
			addProperty(EPC_MEASUREMENT_CHANNEL2);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 3 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 3<br>EPC : 0xD2<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel3() {
			addProperty(EPC_MEASUREMENT_CHANNEL3);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 4 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 4<br>EPC : 0xD3<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel4() {
			addProperty(EPC_MEASUREMENT_CHANNEL4);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 5 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 5<br>EPC : 0xD4<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel5() {
			addProperty(EPC_MEASUREMENT_CHANNEL5);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 6 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 6<br>EPC : 0xD5<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel6() {
			addProperty(EPC_MEASUREMENT_CHANNEL6);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 7 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 7<br>EPC : 0xD6<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel7() {
			addProperty(EPC_MEASUREMENT_CHANNEL7);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 8 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 8<br>EPC : 0xD7<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel8() {
			addProperty(EPC_MEASUREMENT_CHANNEL8);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 9 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 9<br>EPC : 0xD8<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel9() {
			addProperty(EPC_MEASUREMENT_CHANNEL9);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 10 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 10<br>EPC : 0xD9<br>Data Type : unsigned long �{ uigned short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel10() {
			addProperty(EPC_MEASUREMENT_CHANNEL10);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 11 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 11<br>EPC : 0xDA<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel11() {
			addProperty(EPC_MEASUREMENT_CHANNEL11);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 12 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 12<br>EPC : 0xDB<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel12() {
			addProperty(EPC_MEASUREMENT_CHANNEL12);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 13 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 13<br>EPC : 0xDC<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel13() {
			addProperty(EPC_MEASUREMENT_CHANNEL13);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 14 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 14<br>EPC : 0xDD<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel14() {
			addProperty(EPC_MEASUREMENT_CHANNEL14);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 15 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 15<br>EPC : 0xDE<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel15() {
			addProperty(EPC_MEASUREMENT_CHANNEL15);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 16 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 16<br>EPC : 0xDF<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel16() {
			addProperty(EPC_MEASUREMENT_CHANNEL16);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 17 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 17<br>EPC : 0xE0<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel17() {
			addProperty(EPC_MEASUREMENT_CHANNEL17);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 18 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 18<br>EPC : 0xE1<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel18() {
			addProperty(EPC_MEASUREMENT_CHANNEL18);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 19 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 19<br>EPC : 0xE2<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel19() {
			addProperty(EPC_MEASUREMENT_CHANNEL19);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 20 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 20<br>EPC : 0xE3<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel20() {
			addProperty(EPC_MEASUREMENT_CHANNEL20);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 21 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 21<br>EPC : 0xE4<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel21() {
			addProperty(EPC_MEASUREMENT_CHANNEL21);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 22 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 22<br>EPC : 0xE5<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel22() {
			addProperty(EPC_MEASUREMENT_CHANNEL22);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 23 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 23<br>EPC : 0xE6<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel23() {
			addProperty(EPC_MEASUREMENT_CHANNEL23);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 24 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 24<br>EPC : 0xE7<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel24() {
			addProperty(EPC_MEASUREMENT_CHANNEL24);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 25 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 25<br>EPC : 0xE8<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel25() {
			addProperty(EPC_MEASUREMENT_CHANNEL25);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 26 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 26<br>EPC : 0xE9<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel26() {
			addProperty(EPC_MEASUREMENT_CHANNEL26);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 27 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 27<br>EPC : 0xEA<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel27() {
			addProperty(EPC_MEASUREMENT_CHANNEL27);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 28 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 28<br>EPC : 0xEB<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel28() {
			addProperty(EPC_MEASUREMENT_CHANNEL28);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 29 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 29<br>EPC : 0xEC<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel29() {
			addProperty(EPC_MEASUREMENT_CHANNEL29);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 30 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 30<br>EPC : 0xED<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel30() {
			addProperty(EPC_MEASUREMENT_CHANNEL30);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 31 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 31<br>EPC : 0xEE<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel31() {
			addProperty(EPC_MEASUREMENT_CHANNEL31);
			return this;
		}
		/**
		 * This property indicates the measurement data for Measurement channel 32 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 32<br>EPC : 0xEF<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasurementChannel32() {
			addProperty(EPC_MEASUREMENT_CHANNEL32);
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
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br><br>0x00000000-0x05F5E0FF (0-99,999,999)<br><br>Name : Measured cumulative amount of electric energy (normal direction)<br>EPC : 0xC0<br>Data Type : unsigned long<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
		/**
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br><br>0x00000000-0x05F5E0FF (0-99,999,999)<br><br>Name : Measured cumulative amount of electric energy (reverse direction)<br>EPC : 0xC1<br>Data Type : unsigned long<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyReverseDirection();
		/**
		 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br><br>0x00: 1kWh 0x01: 0.1kWh 0x02: 0.01kWh 0x03: 0.001kWh�iInitial value�j 0x04: 0.0001kWh 0x0A: 10kWh 0x0B: 100kWh 0x0C: 1000kWh 0x0D: 10000kWh<br><br>Name : Unit for cumulative amounts of electric energy<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformUnitForCumulativeAmountsOfElectricEnergy();
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br><br>0x0000-0x0063�F 0x00000000-0x05F5E0FF (0-99)�F(0-99,999,999)<br><br>Name : Historical data of measured cumulative amounts of electric energy (normal direction)<br>EPC : 0xC3<br>Data Type : unsigned short �{ unsigned long �~48<br>Data Size(Byte) : 194 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection();
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br><br>0x0000-0x0063�F 0x00000000-0x05F5E0FF (0-99)�F(0-99,999,999)<br><br>Name : Historical data of measured cumulative amounts of electric energy (reverse direction)<br>EPC : 0xC4<br>Data Type : unsigned short �{ unsigned long �~48<br>Data Size(Byte) : 194 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection();
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br><br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days<br><br>Name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>EPC : 0xC5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved();
		/**
		 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br><br>0x80000001-0x7FFFFFFD (-2,147,483,647- 2,147,483,645)<br><br>Name : Measured instantaneo us amount of electric energy<br>EPC : 0xC6<br>Data Type : signed long<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredInstantaneoUsAmountOfElectricEnergy();
		/**
		 * This property indicates the measured effective instantaneous R and T phase currents in amperes. In the case of a single-phase, two-wire system, 0x7FFE shall be used for the T phase.<br><br>0x8001-0x7FFD�iR phase�j : 0x8001-0x7FFD�iT phase�j (-3,276.7-3,276.5): (-3,276.7-3,276.5)<br><br>Name : Measured instantaneous currents<br>EPC : 0xC7<br>Data Type : signed short �~2<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredInstantaneousCurrents();
		/**
		 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a single-phase, two-wire system, 0xFFFE shall be used for the S(N)-T voltage.<br><br>0x0000-0xFFFD (between R and S(N))�F 0x0000-0xFFFD (between S(N) and T) (0-6,553.3) : (0-6,553.3)<br><br>Name : Measured instantaneous voltages<br>EPC : 0xC8<br>Data Type : unsigned short �~2<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredInstantaneousVoltages();
		/**
		 * This property indicates the measurement data for Measurement channel 1 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 1<br>EPC : 0xD0<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel1();
		/**
		 * This property indicates the measurement data for Measurement channel 2 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 2<br>EPC : 0xD1<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel2();
		/**
		 * This property indicates the measurement data for Measurement channel 3 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 3<br>EPC : 0xD2<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel3();
		/**
		 * This property indicates the measurement data for Measurement channel 4 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 4<br>EPC : 0xD3<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel4();
		/**
		 * This property indicates the measurement data for Measurement channel 5 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 5<br>EPC : 0xD4<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel5();
		/**
		 * This property indicates the measurement data for Measurement channel 6 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 6<br>EPC : 0xD5<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel6();
		/**
		 * This property indicates the measurement data for Measurement channel 7 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 7<br>EPC : 0xD6<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel7();
		/**
		 * This property indicates the measurement data for Measurement channel 8 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 8<br>EPC : 0xD7<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel8();
		/**
		 * This property indicates the measurement data for Measurement channel 9 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 9<br>EPC : 0xD8<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel9();
		/**
		 * This property indicates the measurement data for Measurement channel 10 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 10<br>EPC : 0xD9<br>Data Type : unsigned long �{ uigned short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel10();
		/**
		 * This property indicates the measurement data for Measurement channel 11 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 11<br>EPC : 0xDA<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel11();
		/**
		 * This property indicates the measurement data for Measurement channel 12 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 12<br>EPC : 0xDB<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel12();
		/**
		 * This property indicates the measurement data for Measurement channel 13 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 13<br>EPC : 0xDC<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel13();
		/**
		 * This property indicates the measurement data for Measurement channel 14 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 14<br>EPC : 0xDD<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel14();
		/**
		 * This property indicates the measurement data for Measurement channel 15 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 15<br>EPC : 0xDE<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel15();
		/**
		 * This property indicates the measurement data for Measurement channel 16 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 16<br>EPC : 0xDF<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel16();
		/**
		 * This property indicates the measurement data for Measurement channel 17 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 17<br>EPC : 0xE0<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel17();
		/**
		 * This property indicates the measurement data for Measurement channel 18 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 18<br>EPC : 0xE1<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel18();
		/**
		 * This property indicates the measurement data for Measurement channel 19 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 19<br>EPC : 0xE2<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel19();
		/**
		 * This property indicates the measurement data for Measurement channel 20 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 20<br>EPC : 0xE3<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel20();
		/**
		 * This property indicates the measurement data for Measurement channel 21 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 21<br>EPC : 0xE4<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel21();
		/**
		 * This property indicates the measurement data for Measurement channel 22 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 22<br>EPC : 0xE5<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel22();
		/**
		 * This property indicates the measurement data for Measurement channel 23 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 23<br>EPC : 0xE6<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel23();
		/**
		 * This property indicates the measurement data for Measurement channel 24 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 24<br>EPC : 0xE7<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel24();
		/**
		 * This property indicates the measurement data for Measurement channel 25 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 25<br>EPC : 0xE8<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel25();
		/**
		 * This property indicates the measurement data for Measurement channel 26 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 26<br>EPC : 0xE9<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel26();
		/**
		 * This property indicates the measurement data for Measurement channel 27 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 27<br>EPC : 0xEA<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel27();
		/**
		 * This property indicates the measurement data for Measurement channel 28 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 28<br>EPC : 0xEB<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel28();
		/**
		 * This property indicates the measurement data for Measurement channel 29 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 29<br>EPC : 0xEC<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel29();
		/**
		 * This property indicates the measurement data for Measurement channel 30 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 30<br>EPC : 0xED<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel30();
		/**
		 * This property indicates the measurement data for Measurement channel 31 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 31<br>EPC : 0xEE<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel31();
		/**
		 * This property indicates the measurement data for Measurement channel 32 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br><br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7<br><br>Name : Measurement channel 32<br>EPC : 0xEF<br>Data Type : unsigned long �{ signed short �~2<br>Data Size(Byte) : 8 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasurementChannel32();
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
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyNormalDirection() {
			byte epc = EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION;
			byte[] edt = _getMeasuredCumulativeAmountOfElectricEnergyNormalDirection(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyReverseDirection() {
			byte epc = EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION;
			byte[] edt = _getMeasuredCumulativeAmountOfElectricEnergyReverseDirection(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformUnitForCumulativeAmountsOfElectricEnergy() {
			byte epc = EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY;
			byte[] edt = _getUnitForCumulativeAmountsOfElectricEnergy(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection() {
			byte epc = EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION;
			byte[] edt = _getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 194)));
			return this;
		}
		@Override
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection() {
			byte epc = EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION;
			byte[] edt = _getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 194)));
			return this;
		}
		@Override
		public Informer reqInformDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved() {
			byte epc = EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED;
			byte[] edt = _getDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneoUsAmountOfElectricEnergy() {
			byte epc = EPC_MEASURED_INSTANTANEO_US_AMOUNT_OF_ELECTRIC_ENERGY;
			byte[] edt = _getMeasuredInstantaneoUsAmountOfElectricEnergy(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousCurrents() {
			byte epc = EPC_MEASURED_INSTANTANEOUS_CURRENTS;
			byte[] edt = _getMeasuredInstantaneousCurrents(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousVoltages() {
			byte epc = EPC_MEASURED_INSTANTANEOUS_VOLTAGES;
			byte[] edt = _getMeasuredInstantaneousVoltages(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel1() {
			byte epc = EPC_MEASUREMENT_CHANNEL1;
			byte[] edt = _getMeasurementChannel1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel2() {
			byte epc = EPC_MEASUREMENT_CHANNEL2;
			byte[] edt = _getMeasurementChannel2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel3() {
			byte epc = EPC_MEASUREMENT_CHANNEL3;
			byte[] edt = _getMeasurementChannel3(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel4() {
			byte epc = EPC_MEASUREMENT_CHANNEL4;
			byte[] edt = _getMeasurementChannel4(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel5() {
			byte epc = EPC_MEASUREMENT_CHANNEL5;
			byte[] edt = _getMeasurementChannel5(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel6() {
			byte epc = EPC_MEASUREMENT_CHANNEL6;
			byte[] edt = _getMeasurementChannel6(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel7() {
			byte epc = EPC_MEASUREMENT_CHANNEL7;
			byte[] edt = _getMeasurementChannel7(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel8() {
			byte epc = EPC_MEASUREMENT_CHANNEL8;
			byte[] edt = _getMeasurementChannel8(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel9() {
			byte epc = EPC_MEASUREMENT_CHANNEL9;
			byte[] edt = _getMeasurementChannel9(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel10() {
			byte epc = EPC_MEASUREMENT_CHANNEL10;
			byte[] edt = _getMeasurementChannel10(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel11() {
			byte epc = EPC_MEASUREMENT_CHANNEL11;
			byte[] edt = _getMeasurementChannel11(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel12() {
			byte epc = EPC_MEASUREMENT_CHANNEL12;
			byte[] edt = _getMeasurementChannel12(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel13() {
			byte epc = EPC_MEASUREMENT_CHANNEL13;
			byte[] edt = _getMeasurementChannel13(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel14() {
			byte epc = EPC_MEASUREMENT_CHANNEL14;
			byte[] edt = _getMeasurementChannel14(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel15() {
			byte epc = EPC_MEASUREMENT_CHANNEL15;
			byte[] edt = _getMeasurementChannel15(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel16() {
			byte epc = EPC_MEASUREMENT_CHANNEL16;
			byte[] edt = _getMeasurementChannel16(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel17() {
			byte epc = EPC_MEASUREMENT_CHANNEL17;
			byte[] edt = _getMeasurementChannel17(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel18() {
			byte epc = EPC_MEASUREMENT_CHANNEL18;
			byte[] edt = _getMeasurementChannel18(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel19() {
			byte epc = EPC_MEASUREMENT_CHANNEL19;
			byte[] edt = _getMeasurementChannel19(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel20() {
			byte epc = EPC_MEASUREMENT_CHANNEL20;
			byte[] edt = _getMeasurementChannel20(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel21() {
			byte epc = EPC_MEASUREMENT_CHANNEL21;
			byte[] edt = _getMeasurementChannel21(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel22() {
			byte epc = EPC_MEASUREMENT_CHANNEL22;
			byte[] edt = _getMeasurementChannel22(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel23() {
			byte epc = EPC_MEASUREMENT_CHANNEL23;
			byte[] edt = _getMeasurementChannel23(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel24() {
			byte epc = EPC_MEASUREMENT_CHANNEL24;
			byte[] edt = _getMeasurementChannel24(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel25() {
			byte epc = EPC_MEASUREMENT_CHANNEL25;
			byte[] edt = _getMeasurementChannel25(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel26() {
			byte epc = EPC_MEASUREMENT_CHANNEL26;
			byte[] edt = _getMeasurementChannel26(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel27() {
			byte epc = EPC_MEASUREMENT_CHANNEL27;
			byte[] edt = _getMeasurementChannel27(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel28() {
			byte epc = EPC_MEASUREMENT_CHANNEL28;
			byte[] edt = _getMeasurementChannel28(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel29() {
			byte epc = EPC_MEASUREMENT_CHANNEL29;
			byte[] edt = _getMeasurementChannel29(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel30() {
			byte epc = EPC_MEASUREMENT_CHANNEL30;
			byte[] edt = _getMeasurementChannel30(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel31() {
			byte epc = EPC_MEASUREMENT_CHANNEL31;
			byte[] edt = _getMeasurementChannel31(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel32() {
			byte epc = EPC_MEASUREMENT_CHANNEL32;
			byte[] edt = _getMeasurementChannel32(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
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
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyNormalDirection() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyReverseDirection() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION);
			return this;
		}
		@Override
		public Informer reqInformUnitForCumulativeAmountsOfElectricEnergy() {
			addProperty(EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY);
			return this;
		}
		@Override
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection() {
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
			return this;
		}
		@Override
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection() {
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION);
			return this;
		}
		@Override
		public Informer reqInformDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved() {
			addProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED);
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneoUsAmountOfElectricEnergy() {
			addProperty(EPC_MEASURED_INSTANTANEO_US_AMOUNT_OF_ELECTRIC_ENERGY);
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousCurrents() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_CURRENTS);
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousVoltages() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_VOLTAGES);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel1() {
			addProperty(EPC_MEASUREMENT_CHANNEL1);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel2() {
			addProperty(EPC_MEASUREMENT_CHANNEL2);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel3() {
			addProperty(EPC_MEASUREMENT_CHANNEL3);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel4() {
			addProperty(EPC_MEASUREMENT_CHANNEL4);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel5() {
			addProperty(EPC_MEASUREMENT_CHANNEL5);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel6() {
			addProperty(EPC_MEASUREMENT_CHANNEL6);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel7() {
			addProperty(EPC_MEASUREMENT_CHANNEL7);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel8() {
			addProperty(EPC_MEASUREMENT_CHANNEL8);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel9() {
			addProperty(EPC_MEASUREMENT_CHANNEL9);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel10() {
			addProperty(EPC_MEASUREMENT_CHANNEL10);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel11() {
			addProperty(EPC_MEASUREMENT_CHANNEL11);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel12() {
			addProperty(EPC_MEASUREMENT_CHANNEL12);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel13() {
			addProperty(EPC_MEASUREMENT_CHANNEL13);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel14() {
			addProperty(EPC_MEASUREMENT_CHANNEL14);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel15() {
			addProperty(EPC_MEASUREMENT_CHANNEL15);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel16() {
			addProperty(EPC_MEASUREMENT_CHANNEL16);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel17() {
			addProperty(EPC_MEASUREMENT_CHANNEL17);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel18() {
			addProperty(EPC_MEASUREMENT_CHANNEL18);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel19() {
			addProperty(EPC_MEASUREMENT_CHANNEL19);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel20() {
			addProperty(EPC_MEASUREMENT_CHANNEL20);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel21() {
			addProperty(EPC_MEASUREMENT_CHANNEL21);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel22() {
			addProperty(EPC_MEASUREMENT_CHANNEL22);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel23() {
			addProperty(EPC_MEASUREMENT_CHANNEL23);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel24() {
			addProperty(EPC_MEASUREMENT_CHANNEL24);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel25() {
			addProperty(EPC_MEASUREMENT_CHANNEL25);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel26() {
			addProperty(EPC_MEASUREMENT_CHANNEL26);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel27() {
			addProperty(EPC_MEASUREMENT_CHANNEL27);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel28() {
			addProperty(EPC_MEASUREMENT_CHANNEL28);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel29() {
			addProperty(EPC_MEASUREMENT_CHANNEL29);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel30() {
			addProperty(EPC_MEASUREMENT_CHANNEL30);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel31() {
			addProperty(EPC_MEASUREMENT_CHANNEL31);
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel32() {
			addProperty(EPC_MEASUREMENT_CHANNEL32);
			return this;
		}
	}
}
