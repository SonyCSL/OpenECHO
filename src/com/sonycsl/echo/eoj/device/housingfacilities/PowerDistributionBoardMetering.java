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
	@SuppressWarnings("unused")
	private static final String TAG = PowerDistributionBoardMetering.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x87;

	protected static final byte EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION = (byte)0xC0;
	protected static final byte EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION = (byte)0xC1;
	protected static final byte EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY = (byte)0xC2;
	protected static final byte EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION = (byte)0xC3;
	protected static final byte EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION = (byte)0xC4;
	protected static final byte EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED = (byte)0xC5;
	protected static final byte EPC_MEASURED_INSTANTANEO_US_AMOUNT_OF_ELECTRIC_ENERGY = (byte)0xC6;
	protected static final byte EPC_MEASURED_INSTANTANEOUS_CURRENTS = (byte)0xC7;
	protected static final byte EPC_MEASURED_INSTANTANEOUS_VOLTAGES = (byte)0xC8;
	protected static final byte EPC_MEASUREMENT_CHANNEL1 = (byte)0xD0;
	protected static final byte EPC_MEASUREMENT_CHANNEL2 = (byte)0xD1;
	protected static final byte EPC_MEASUREMENT_CHANNEL3 = (byte)0xD2;
	protected static final byte EPC_MEASUREMENT_CHANNEL4 = (byte)0xD3;
	protected static final byte EPC_MEASUREMENT_CHANNEL5 = (byte)0xD4;
	protected static final byte EPC_MEASUREMENT_CHANNEL6 = (byte)0xD5;
	protected static final byte EPC_MEASUREMENT_CHANNEL7 = (byte)0xD6;
	protected static final byte EPC_MEASUREMENT_CHANNEL8 = (byte)0xD7;
	protected static final byte EPC_MEASUREMENT_CHANNEL9 = (byte)0xD8;
	protected static final byte EPC_MEASUREMENT_CHANNEL10 = (byte)0xD9;
	protected static final byte EPC_MEASUREMENT_CHANNEL11 = (byte)0xDA;
	protected static final byte EPC_MEASUREMENT_CHANNEL12 = (byte)0xDB;
	protected static final byte EPC_MEASUREMENT_CHANNEL13 = (byte)0xDC;
	protected static final byte EPC_MEASUREMENT_CHANNEL14 = (byte)0xDD;
	protected static final byte EPC_MEASUREMENT_CHANNEL15 = (byte)0xDE;
	protected static final byte EPC_MEASUREMENT_CHANNEL16 = (byte)0xDF;
	protected static final byte EPC_MEASUREMENT_CHANNEL17 = (byte)0xE0;
	protected static final byte EPC_MEASUREMENT_CHANNEL18 = (byte)0xE1;
	protected static final byte EPC_MEASUREMENT_CHANNEL19 = (byte)0xE2;
	protected static final byte EPC_MEASUREMENT_CHANNEL20 = (byte)0xE3;
	protected static final byte EPC_MEASUREMENT_CHANNEL21 = (byte)0xE4;
	protected static final byte EPC_MEASUREMENT_CHANNEL22 = (byte)0xE5;
	protected static final byte EPC_MEASUREMENT_CHANNEL23 = (byte)0xE6;
	protected static final byte EPC_MEASUREMENT_CHANNEL24 = (byte)0xE7;
	protected static final byte EPC_MEASUREMENT_CHANNEL25 = (byte)0xE8;
	protected static final byte EPC_MEASUREMENT_CHANNEL26 = (byte)0xE9;
	protected static final byte EPC_MEASUREMENT_CHANNEL27 = (byte)0xEA;
	protected static final byte EPC_MEASUREMENT_CHANNEL28 = (byte)0xEB;
	protected static final byte EPC_MEASUREMENT_CHANNEL29 = (byte)0xEC;
	protected static final byte EPC_MEASUREMENT_CHANNEL30 = (byte)0xED;
	protected static final byte EPC_MEASUREMENT_CHANNEL31 = (byte)0xEE;
	protected static final byte EPC_MEASUREMENT_CHANNEL32 = (byte)0xEF;


	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)
	 */
	protected abstract byte[] getMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
	/**
	 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)
	 */
	protected abstract byte[] getMeasuredCumulativeAmountOfElectricEnergyReverseDirection();
	/**
	 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>0x00: 1kWh 0x01: 0.1kWh 0x02: 0.01kWh 0x03: 0.001kWh�iInitial value�j 0x04: 0.0001kWh 0x0A: 10kWh 0x0B: 100kWh 0x0C: 1000kWh 0x0D: 10000kWh
	 */
	protected abstract byte[] getUnitForCumulativeAmountsOfElectricEnergy();
	/**
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063�F 0x00000000-0x05F5E0FF (0-99)�F(0-99,999,999)
	 */
	protected byte[] getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection() {return null;}
	/**
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063�F 0x00000000-0x05F5E0FF (0-99)�F(0-99,999,999)
	 */
	protected byte[] getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection() {return null;}
	/**
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days
	 */
	protected boolean setDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte[] edt) {return false;}
	/**
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days
	 */
	protected byte[] getDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved() {return null;}
	/**
	 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br>0x80000001-0x7FFFFFFD (-2,147,483,647- 2,147,483,645)
	 */
	protected byte[] getMeasuredInstantaneoUsAmountOfElectricEnergy() {return null;}
	/**
	 * This property indicates the measured effective instantaneous R and T phase currents in amperes. In the case of a single-phase, two-wire system, 0x7FFE shall be used for the T phase.<br>0x8001-0x7FFD�iR phase�j : 0x8001-0x7FFD�iT phase�j (-3,276.7-3,276.5): (-3,276.7-3,276.5)
	 */
	protected byte[] getMeasuredInstantaneousCurrents() {return null;}
	/**
	 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a single-phase, two-wire system, 0xFFFE shall be used for the S(N)-T voltage.<br>0x0000-0xFFFD (between R and S(N))�F 0x0000-0xFFFD (between S(N) and T) (0-6,553.3) : (0-6,553.3)
	 */
	protected byte[] getMeasuredInstantaneousVoltages() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 1 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel1() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 2 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel2() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 3 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel3() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 4 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel4() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 5 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel5() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 6 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel6() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 7 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel7() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 8 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel8() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 9 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel9() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 10 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel10() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 11 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel11() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 12 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel12() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 13 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel13() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 14 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel14() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 15 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel15() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 16 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel16() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 17 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel17() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 18 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel18() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 19 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel19() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 20 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel20() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 21 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel21() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 22 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel22() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 23 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel23() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 24 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel24() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 25 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel25() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 26 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel26() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 27 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel27() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 28 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel28() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 29 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel29() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 30 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel30() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 31 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel31() {return null;}
	/**
	 * This property indicates the measurement data for Measurement channel 32 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
	 */
	protected byte[] getMeasurementChannel32() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED:
			res.addProperty(epc, edt, setDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION:
			edt = getMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION:
			edt = getMeasuredCumulativeAmountOfElectricEnergyReverseDirection();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY:
			edt = getUnitForCumulativeAmountsOfElectricEnergy();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION:
			edt = getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection();
			res.addProperty(epc, edt, (edt != null && (edt.length == 194)));
			break;
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION:
			edt = getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection();
			res.addProperty(epc, edt, (edt != null && (edt.length == 194)));
			break;
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED:
			edt = getDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_INSTANTANEO_US_AMOUNT_OF_ELECTRIC_ENERGY:
			edt = getMeasuredInstantaneoUsAmountOfElectricEnergy();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_MEASURED_INSTANTANEOUS_CURRENTS:
			edt = getMeasuredInstantaneousCurrents();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_MEASURED_INSTANTANEOUS_VOLTAGES:
			edt = getMeasuredInstantaneousVoltages();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_MEASUREMENT_CHANNEL1:
			edt = getMeasurementChannel1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL2:
			edt = getMeasurementChannel2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL3:
			edt = getMeasurementChannel3();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL4:
			edt = getMeasurementChannel4();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL5:
			edt = getMeasurementChannel5();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL6:
			edt = getMeasurementChannel6();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL7:
			edt = getMeasurementChannel7();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL8:
			edt = getMeasurementChannel8();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL9:
			edt = getMeasurementChannel9();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL10:
			edt = getMeasurementChannel10();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL11:
			edt = getMeasurementChannel11();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL12:
			edt = getMeasurementChannel12();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL13:
			edt = getMeasurementChannel13();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL14:
			edt = getMeasurementChannel14();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL15:
			edt = getMeasurementChannel15();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL16:
			edt = getMeasurementChannel16();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL17:
			edt = getMeasurementChannel17();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL18:
			edt = getMeasurementChannel18();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL19:
			edt = getMeasurementChannel19();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL20:
			edt = getMeasurementChannel20();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL21:
			edt = getMeasurementChannel21();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL22:
			edt = getMeasurementChannel22();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL23:
			edt = getMeasurementChannel23();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL24:
			edt = getMeasurementChannel24();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL25:
			edt = getMeasurementChannel25();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL26:
			edt = getMeasurementChannel26();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL27:
			edt = getMeasurementChannel27();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL28:
			edt = getMeasurementChannel28();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL29:
			edt = getMeasurementChannel29();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL30:
			edt = getMeasurementChannel30();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL31:
			edt = getMeasurementChannel31();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASUREMENT_CHANNEL32:
			edt = getMeasurementChannel32();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
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
			case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED:
				onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION:
				onGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION:
				onGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection(eoj, tid, pdc, edt);
				break;
			case EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY:
				onGetUnitForCumulativeAmountsOfElectricEnergy(eoj, tid, pdc, edt);
				break;
			case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION:
				onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(eoj, tid, pdc, edt);
				break;
			case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION:
				onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(eoj, tid, pdc, edt);
				break;
			case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED:
				onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEO_US_AMOUNT_OF_ELECTRIC_ENERGY:
				onGetMeasuredInstantaneoUsAmountOfElectricEnergy(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_CURRENTS:
				onGetMeasuredInstantaneousCurrents(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_VOLTAGES:
				onGetMeasuredInstantaneousVoltages(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL1:
				onGetMeasurementChannel1(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL2:
				onGetMeasurementChannel2(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL3:
				onGetMeasurementChannel3(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL4:
				onGetMeasurementChannel4(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL5:
				onGetMeasurementChannel5(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL6:
				onGetMeasurementChannel6(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL7:
				onGetMeasurementChannel7(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL8:
				onGetMeasurementChannel8(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL9:
				onGetMeasurementChannel9(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL10:
				onGetMeasurementChannel10(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL11:
				onGetMeasurementChannel11(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL12:
				onGetMeasurementChannel12(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL13:
				onGetMeasurementChannel13(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL14:
				onGetMeasurementChannel14(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL15:
				onGetMeasurementChannel15(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL16:
				onGetMeasurementChannel16(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL17:
				onGetMeasurementChannel17(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL18:
				onGetMeasurementChannel18(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL19:
				onGetMeasurementChannel19(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL20:
				onGetMeasurementChannel20(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL21:
				onGetMeasurementChannel21(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL22:
				onGetMeasurementChannel22(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL23:
				onGetMeasurementChannel23(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL24:
				onGetMeasurementChannel24(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL25:
				onGetMeasurementChannel25(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL26:
				onGetMeasurementChannel26(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL27:
				onGetMeasurementChannel27(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL28:
				onGetMeasurementChannel28(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL29:
				onGetMeasurementChannel29(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL30:
				onGetMeasurementChannel30(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL31:
				onGetMeasurementChannel31(eoj, tid, pdc, edt);
				break;
			case EPC_MEASUREMENT_CHANNEL32:
				onGetMeasurementChannel32(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)
		 */
		protected void onGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)
		 */
		protected void onGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>0x00: 1kWh 0x01: 0.1kWh 0x02: 0.01kWh 0x03: 0.001kWh�iInitial value�j 0x04: 0.0001kWh 0x0A: 10kWh 0x0B: 100kWh 0x0C: 1000kWh 0x0D: 10000kWh
		 */
		protected void onGetUnitForCumulativeAmountsOfElectricEnergy(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063�F 0x00000000-0x05F5E0FF (0-99)�F(0-99,999,999)
		 */
		protected void onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063�F 0x00000000-0x05F5E0FF (0-99)�F(0-99,999,999)
		 */
		protected void onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days
		 */
		protected void onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days
		 */
		protected void onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br>0x80000001-0x7FFFFFFD (-2,147,483,647- 2,147,483,645)
		 */
		protected void onGetMeasuredInstantaneoUsAmountOfElectricEnergy(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured effective instantaneous R and T phase currents in amperes. In the case of a single-phase, two-wire system, 0x7FFE shall be used for the T phase.<br>0x8001-0x7FFD�iR phase�j : 0x8001-0x7FFD�iT phase�j (-3,276.7-3,276.5): (-3,276.7-3,276.5)
		 */
		protected void onGetMeasuredInstantaneousCurrents(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a single-phase, two-wire system, 0xFFFE shall be used for the S(N)-T voltage.<br>0x0000-0xFFFD (between R and S(N))�F 0x0000-0xFFFD (between S(N) and T) (0-6,553.3) : (0-6,553.3)
		 */
		protected void onGetMeasuredInstantaneousVoltages(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 1 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 2 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 3 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel3(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 4 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel4(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 5 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel5(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 6 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel6(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 7 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel7(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 8 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel8(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 9 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel9(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 10 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel10(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 11 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel11(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 12 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel12(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 13 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel13(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 14 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel14(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 15 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel15(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 16 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel16(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 17 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel17(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 18 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel18(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 19 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel19(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 20 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel20(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 21 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel21(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 22 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel22(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 23 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel23(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 24 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel24(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 25 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel25(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 26 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel26(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 27 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel27(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 28 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel28(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 29 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel29(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 30 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel30(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 31 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel31(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measurement data for Measurement channel 32 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		protected void onGetMeasurementChannel32(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days
		 */
		public Setter reqSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte[] edt);

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
		public Setter reqSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte[] edt) {
			addProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED, edt, setDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(edt));
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
		public Setter reqSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte[] edt) {
			addProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED, edt, (edt != null && (edt.length == 1)));
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
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)
		 */
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
		/**
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)
		 */
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection();
		/**
		 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>0x00: 1kWh 0x01: 0.1kWh 0x02: 0.01kWh 0x03: 0.001kWh�iInitial value�j 0x04: 0.0001kWh 0x0A: 10kWh 0x0B: 100kWh 0x0C: 1000kWh 0x0D: 10000kWh
		 */
		public Getter reqGetUnitForCumulativeAmountsOfElectricEnergy();
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063�F 0x00000000-0x05F5E0FF (0-99)�F(0-99,999,999)
		 */
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection();
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063�F 0x00000000-0x05F5E0FF (0-99)�F(0-99,999,999)
		 */
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection();
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days
		 */
		public Getter reqGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved();
		/**
		 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br>0x80000001-0x7FFFFFFD (-2,147,483,647- 2,147,483,645)
		 */
		public Getter reqGetMeasuredInstantaneoUsAmountOfElectricEnergy();
		/**
		 * This property indicates the measured effective instantaneous R and T phase currents in amperes. In the case of a single-phase, two-wire system, 0x7FFE shall be used for the T phase.<br>0x8001-0x7FFD�iR phase�j : 0x8001-0x7FFD�iT phase�j (-3,276.7-3,276.5): (-3,276.7-3,276.5)
		 */
		public Getter reqGetMeasuredInstantaneousCurrents();
		/**
		 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a single-phase, two-wire system, 0xFFFE shall be used for the S(N)-T voltage.<br>0x0000-0xFFFD (between R and S(N))�F 0x0000-0xFFFD (between S(N) and T) (0-6,553.3) : (0-6,553.3)
		 */
		public Getter reqGetMeasuredInstantaneousVoltages();
		/**
		 * This property indicates the measurement data for Measurement channel 1 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel1();
		/**
		 * This property indicates the measurement data for Measurement channel 2 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel2();
		/**
		 * This property indicates the measurement data for Measurement channel 3 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel3();
		/**
		 * This property indicates the measurement data for Measurement channel 4 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel4();
		/**
		 * This property indicates the measurement data for Measurement channel 5 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel5();
		/**
		 * This property indicates the measurement data for Measurement channel 6 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel6();
		/**
		 * This property indicates the measurement data for Measurement channel 7 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel7();
		/**
		 * This property indicates the measurement data for Measurement channel 8 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel8();
		/**
		 * This property indicates the measurement data for Measurement channel 9 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel9();
		/**
		 * This property indicates the measurement data for Measurement channel 10 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel10();
		/**
		 * This property indicates the measurement data for Measurement channel 11 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel11();
		/**
		 * This property indicates the measurement data for Measurement channel 12 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel12();
		/**
		 * This property indicates the measurement data for Measurement channel 13 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel13();
		/**
		 * This property indicates the measurement data for Measurement channel 14 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel14();
		/**
		 * This property indicates the measurement data for Measurement channel 15 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel15();
		/**
		 * This property indicates the measurement data for Measurement channel 16 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel16();
		/**
		 * This property indicates the measurement data for Measurement channel 17 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel17();
		/**
		 * This property indicates the measurement data for Measurement channel 18 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel18();
		/**
		 * This property indicates the measurement data for Measurement channel 19 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel19();
		/**
		 * This property indicates the measurement data for Measurement channel 20 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel20();
		/**
		 * This property indicates the measurement data for Measurement channel 21 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel21();
		/**
		 * This property indicates the measurement data for Measurement channel 22 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel22();
		/**
		 * This property indicates the measurement data for Measurement channel 23 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel23();
		/**
		 * This property indicates the measurement data for Measurement channel 24 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel24();
		/**
		 * This property indicates the measurement data for Measurement channel 25 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel25();
		/**
		 * This property indicates the measurement data for Measurement channel 26 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel26();
		/**
		 * This property indicates the measurement data for Measurement channel 27 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel27();
		/**
		 * This property indicates the measurement data for Measurement channel 28 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel28();
		/**
		 * This property indicates the measurement data for Measurement channel 29 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel29();
		/**
		 * This property indicates the measurement data for Measurement channel 30 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel30();
		/**
		 * This property indicates the measurement data for Measurement channel 31 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel31();
		/**
		 * This property indicates the measurement data for Measurement channel 32 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Getter reqGetMeasurementChannel32();

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
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection() {
			byte[] edt = getMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection() {
			byte[] edt = getMeasuredCumulativeAmountOfElectricEnergyReverseDirection();
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetUnitForCumulativeAmountsOfElectricEnergy() {
			byte[] edt = getUnitForCumulativeAmountsOfElectricEnergy();
			addProperty(EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection() {
			byte[] edt = getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection();
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION, edt, (edt != null && (edt.length == 194)));
			return this;
		}
		@Override
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection() {
			byte[] edt = getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection();
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION, edt, (edt != null && (edt.length == 194)));
			return this;
		}
		@Override
		public Getter reqGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved() {
			byte[] edt = getDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved();
			addProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneoUsAmountOfElectricEnergy() {
			byte[] edt = getMeasuredInstantaneoUsAmountOfElectricEnergy();
			addProperty(EPC_MEASURED_INSTANTANEO_US_AMOUNT_OF_ELECTRIC_ENERGY, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousCurrents() {
			byte[] edt = getMeasuredInstantaneousCurrents();
			addProperty(EPC_MEASURED_INSTANTANEOUS_CURRENTS, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousVoltages() {
			byte[] edt = getMeasuredInstantaneousVoltages();
			addProperty(EPC_MEASURED_INSTANTANEOUS_VOLTAGES, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel1() {
			byte[] edt = getMeasurementChannel1();
			addProperty(EPC_MEASUREMENT_CHANNEL1, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel2() {
			byte[] edt = getMeasurementChannel2();
			addProperty(EPC_MEASUREMENT_CHANNEL2, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel3() {
			byte[] edt = getMeasurementChannel3();
			addProperty(EPC_MEASUREMENT_CHANNEL3, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel4() {
			byte[] edt = getMeasurementChannel4();
			addProperty(EPC_MEASUREMENT_CHANNEL4, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel5() {
			byte[] edt = getMeasurementChannel5();
			addProperty(EPC_MEASUREMENT_CHANNEL5, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel6() {
			byte[] edt = getMeasurementChannel6();
			addProperty(EPC_MEASUREMENT_CHANNEL6, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel7() {
			byte[] edt = getMeasurementChannel7();
			addProperty(EPC_MEASUREMENT_CHANNEL7, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel8() {
			byte[] edt = getMeasurementChannel8();
			addProperty(EPC_MEASUREMENT_CHANNEL8, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel9() {
			byte[] edt = getMeasurementChannel9();
			addProperty(EPC_MEASUREMENT_CHANNEL9, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel10() {
			byte[] edt = getMeasurementChannel10();
			addProperty(EPC_MEASUREMENT_CHANNEL10, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel11() {
			byte[] edt = getMeasurementChannel11();
			addProperty(EPC_MEASUREMENT_CHANNEL11, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel12() {
			byte[] edt = getMeasurementChannel12();
			addProperty(EPC_MEASUREMENT_CHANNEL12, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel13() {
			byte[] edt = getMeasurementChannel13();
			addProperty(EPC_MEASUREMENT_CHANNEL13, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel14() {
			byte[] edt = getMeasurementChannel14();
			addProperty(EPC_MEASUREMENT_CHANNEL14, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel15() {
			byte[] edt = getMeasurementChannel15();
			addProperty(EPC_MEASUREMENT_CHANNEL15, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel16() {
			byte[] edt = getMeasurementChannel16();
			addProperty(EPC_MEASUREMENT_CHANNEL16, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel17() {
			byte[] edt = getMeasurementChannel17();
			addProperty(EPC_MEASUREMENT_CHANNEL17, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel18() {
			byte[] edt = getMeasurementChannel18();
			addProperty(EPC_MEASUREMENT_CHANNEL18, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel19() {
			byte[] edt = getMeasurementChannel19();
			addProperty(EPC_MEASUREMENT_CHANNEL19, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel20() {
			byte[] edt = getMeasurementChannel20();
			addProperty(EPC_MEASUREMENT_CHANNEL20, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel21() {
			byte[] edt = getMeasurementChannel21();
			addProperty(EPC_MEASUREMENT_CHANNEL21, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel22() {
			byte[] edt = getMeasurementChannel22();
			addProperty(EPC_MEASUREMENT_CHANNEL22, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel23() {
			byte[] edt = getMeasurementChannel23();
			addProperty(EPC_MEASUREMENT_CHANNEL23, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel24() {
			byte[] edt = getMeasurementChannel24();
			addProperty(EPC_MEASUREMENT_CHANNEL24, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel25() {
			byte[] edt = getMeasurementChannel25();
			addProperty(EPC_MEASUREMENT_CHANNEL25, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel26() {
			byte[] edt = getMeasurementChannel26();
			addProperty(EPC_MEASUREMENT_CHANNEL26, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel27() {
			byte[] edt = getMeasurementChannel27();
			addProperty(EPC_MEASUREMENT_CHANNEL27, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel28() {
			byte[] edt = getMeasurementChannel28();
			addProperty(EPC_MEASUREMENT_CHANNEL28, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel29() {
			byte[] edt = getMeasurementChannel29();
			addProperty(EPC_MEASUREMENT_CHANNEL29, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel30() {
			byte[] edt = getMeasurementChannel30();
			addProperty(EPC_MEASUREMENT_CHANNEL30, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel31() {
			byte[] edt = getMeasurementChannel31();
			addProperty(EPC_MEASUREMENT_CHANNEL31, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel32() {
			byte[] edt = getMeasurementChannel32();
			addProperty(EPC_MEASUREMENT_CHANNEL32, edt, (edt != null && (edt.length == 8)));
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
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION);
			return this;
		}
		@Override
		public Getter reqGetUnitForCumulativeAmountsOfElectricEnergy() {
			addProperty(EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY);
			return this;
		}
		@Override
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection() {
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
			return this;
		}
		@Override
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection() {
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION);
			return this;
		}
		@Override
		public Getter reqGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved() {
			addProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED);
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneoUsAmountOfElectricEnergy() {
			addProperty(EPC_MEASURED_INSTANTANEO_US_AMOUNT_OF_ELECTRIC_ENERGY);
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousCurrents() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_CURRENTS);
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousVoltages() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_VOLTAGES);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel1() {
			addProperty(EPC_MEASUREMENT_CHANNEL1);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel2() {
			addProperty(EPC_MEASUREMENT_CHANNEL2);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel3() {
			addProperty(EPC_MEASUREMENT_CHANNEL3);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel4() {
			addProperty(EPC_MEASUREMENT_CHANNEL4);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel5() {
			addProperty(EPC_MEASUREMENT_CHANNEL5);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel6() {
			addProperty(EPC_MEASUREMENT_CHANNEL6);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel7() {
			addProperty(EPC_MEASUREMENT_CHANNEL7);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel8() {
			addProperty(EPC_MEASUREMENT_CHANNEL8);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel9() {
			addProperty(EPC_MEASUREMENT_CHANNEL9);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel10() {
			addProperty(EPC_MEASUREMENT_CHANNEL10);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel11() {
			addProperty(EPC_MEASUREMENT_CHANNEL11);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel12() {
			addProperty(EPC_MEASUREMENT_CHANNEL12);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel13() {
			addProperty(EPC_MEASUREMENT_CHANNEL13);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel14() {
			addProperty(EPC_MEASUREMENT_CHANNEL14);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel15() {
			addProperty(EPC_MEASUREMENT_CHANNEL15);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel16() {
			addProperty(EPC_MEASUREMENT_CHANNEL16);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel17() {
			addProperty(EPC_MEASUREMENT_CHANNEL17);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel18() {
			addProperty(EPC_MEASUREMENT_CHANNEL18);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel19() {
			addProperty(EPC_MEASUREMENT_CHANNEL19);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel20() {
			addProperty(EPC_MEASUREMENT_CHANNEL20);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel21() {
			addProperty(EPC_MEASUREMENT_CHANNEL21);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel22() {
			addProperty(EPC_MEASUREMENT_CHANNEL22);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel23() {
			addProperty(EPC_MEASUREMENT_CHANNEL23);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel24() {
			addProperty(EPC_MEASUREMENT_CHANNEL24);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel25() {
			addProperty(EPC_MEASUREMENT_CHANNEL25);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel26() {
			addProperty(EPC_MEASUREMENT_CHANNEL26);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel27() {
			addProperty(EPC_MEASUREMENT_CHANNEL27);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel28() {
			addProperty(EPC_MEASUREMENT_CHANNEL28);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel29() {
			addProperty(EPC_MEASUREMENT_CHANNEL29);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel30() {
			addProperty(EPC_MEASUREMENT_CHANNEL30);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel31() {
			addProperty(EPC_MEASUREMENT_CHANNEL31);
			return this;
		}
		@Override
		public Getter reqGetMeasurementChannel32() {
			addProperty(EPC_MEASUREMENT_CHANNEL32);
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
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)
		 */
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
		/**
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)
		 */
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyReverseDirection();
		/**
		 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>0x00: 1kWh 0x01: 0.1kWh 0x02: 0.01kWh 0x03: 0.001kWh�iInitial value�j 0x04: 0.0001kWh 0x0A: 10kWh 0x0B: 100kWh 0x0C: 1000kWh 0x0D: 10000kWh
		 */
		public Informer reqInformUnitForCumulativeAmountsOfElectricEnergy();
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063�F 0x00000000-0x05F5E0FF (0-99)�F(0-99,999,999)
		 */
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection();
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063�F 0x00000000-0x05F5E0FF (0-99)�F(0-99,999,999)
		 */
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection();
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days
		 */
		public Informer reqInformDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved();
		/**
		 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br>0x80000001-0x7FFFFFFD (-2,147,483,647- 2,147,483,645)
		 */
		public Informer reqInformMeasuredInstantaneoUsAmountOfElectricEnergy();
		/**
		 * This property indicates the measured effective instantaneous R and T phase currents in amperes. In the case of a single-phase, two-wire system, 0x7FFE shall be used for the T phase.<br>0x8001-0x7FFD�iR phase�j : 0x8001-0x7FFD�iT phase�j (-3,276.7-3,276.5): (-3,276.7-3,276.5)
		 */
		public Informer reqInformMeasuredInstantaneousCurrents();
		/**
		 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a single-phase, two-wire system, 0xFFFE shall be used for the S(N)-T voltage.<br>0x0000-0xFFFD (between R and S(N))�F 0x0000-0xFFFD (between S(N) and T) (0-6,553.3) : (0-6,553.3)
		 */
		public Informer reqInformMeasuredInstantaneousVoltages();
		/**
		 * This property indicates the measurement data for Measurement channel 1 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel1();
		/**
		 * This property indicates the measurement data for Measurement channel 2 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel2();
		/**
		 * This property indicates the measurement data for Measurement channel 3 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel3();
		/**
		 * This property indicates the measurement data for Measurement channel 4 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel4();
		/**
		 * This property indicates the measurement data for Measurement channel 5 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel5();
		/**
		 * This property indicates the measurement data for Measurement channel 6 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel6();
		/**
		 * This property indicates the measurement data for Measurement channel 7 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel7();
		/**
		 * This property indicates the measurement data for Measurement channel 8 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel8();
		/**
		 * This property indicates the measurement data for Measurement channel 9 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel9();
		/**
		 * This property indicates the measurement data for Measurement channel 10 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel10();
		/**
		 * This property indicates the measurement data for Measurement channel 11 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel11();
		/**
		 * This property indicates the measurement data for Measurement channel 12 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel12();
		/**
		 * This property indicates the measurement data for Measurement channel 13 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel13();
		/**
		 * This property indicates the measurement data for Measurement channel 14 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel14();
		/**
		 * This property indicates the measurement data for Measurement channel 15 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel15();
		/**
		 * This property indicates the measurement data for Measurement channel 16 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel16();
		/**
		 * This property indicates the measurement data for Measurement channel 17 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel17();
		/**
		 * This property indicates the measurement data for Measurement channel 18 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel18();
		/**
		 * This property indicates the measurement data for Measurement channel 19 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel19();
		/**
		 * This property indicates the measurement data for Measurement channel 20 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel20();
		/**
		 * This property indicates the measurement data for Measurement channel 21 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel21();
		/**
		 * This property indicates the measurement data for Measurement channel 22 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel22();
		/**
		 * This property indicates the measurement data for Measurement channel 23 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel23();
		/**
		 * This property indicates the measurement data for Measurement channel 24 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel24();
		/**
		 * This property indicates the measurement data for Measurement channel 25 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel25();
		/**
		 * This property indicates the measurement data for Measurement channel 26 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel26();
		/**
		 * This property indicates the measurement data for Measurement channel 27 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel27();
		/**
		 * This property indicates the measurement data for Measurement channel 28 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel28();
		/**
		 * This property indicates the measurement data for Measurement channel 29 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel29();
		/**
		 * This property indicates the measurement data for Measurement channel 30 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel30();
		/**
		 * This property indicates the measurement data for Measurement channel 31 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel31();
		/**
		 * This property indicates the measurement data for Measurement channel 32 (cumulative amount of electric energy (kWh) and effective instantaneous R and T phase currents (amperes)).<br>Data format for the electric energy: same as 0xC0 Unit: same as 0xC2 Data format for the currents: same as 0xC7
		 */
		public Informer reqInformMeasurementChannel32();

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
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyNormalDirection() {
			byte[] edt = getMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyReverseDirection() {
			byte[] edt = getMeasuredCumulativeAmountOfElectricEnergyReverseDirection();
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformUnitForCumulativeAmountsOfElectricEnergy() {
			byte[] edt = getUnitForCumulativeAmountsOfElectricEnergy();
			addProperty(EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection() {
			byte[] edt = getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection();
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION, edt, (edt != null && (edt.length == 194)));
			return this;
		}
		@Override
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection() {
			byte[] edt = getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection();
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION, edt, (edt != null && (edt.length == 194)));
			return this;
		}
		@Override
		public Informer reqInformDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved() {
			byte[] edt = getDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved();
			addProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneoUsAmountOfElectricEnergy() {
			byte[] edt = getMeasuredInstantaneoUsAmountOfElectricEnergy();
			addProperty(EPC_MEASURED_INSTANTANEO_US_AMOUNT_OF_ELECTRIC_ENERGY, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousCurrents() {
			byte[] edt = getMeasuredInstantaneousCurrents();
			addProperty(EPC_MEASURED_INSTANTANEOUS_CURRENTS, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousVoltages() {
			byte[] edt = getMeasuredInstantaneousVoltages();
			addProperty(EPC_MEASURED_INSTANTANEOUS_VOLTAGES, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel1() {
			byte[] edt = getMeasurementChannel1();
			addProperty(EPC_MEASUREMENT_CHANNEL1, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel2() {
			byte[] edt = getMeasurementChannel2();
			addProperty(EPC_MEASUREMENT_CHANNEL2, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel3() {
			byte[] edt = getMeasurementChannel3();
			addProperty(EPC_MEASUREMENT_CHANNEL3, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel4() {
			byte[] edt = getMeasurementChannel4();
			addProperty(EPC_MEASUREMENT_CHANNEL4, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel5() {
			byte[] edt = getMeasurementChannel5();
			addProperty(EPC_MEASUREMENT_CHANNEL5, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel6() {
			byte[] edt = getMeasurementChannel6();
			addProperty(EPC_MEASUREMENT_CHANNEL6, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel7() {
			byte[] edt = getMeasurementChannel7();
			addProperty(EPC_MEASUREMENT_CHANNEL7, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel8() {
			byte[] edt = getMeasurementChannel8();
			addProperty(EPC_MEASUREMENT_CHANNEL8, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel9() {
			byte[] edt = getMeasurementChannel9();
			addProperty(EPC_MEASUREMENT_CHANNEL9, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel10() {
			byte[] edt = getMeasurementChannel10();
			addProperty(EPC_MEASUREMENT_CHANNEL10, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel11() {
			byte[] edt = getMeasurementChannel11();
			addProperty(EPC_MEASUREMENT_CHANNEL11, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel12() {
			byte[] edt = getMeasurementChannel12();
			addProperty(EPC_MEASUREMENT_CHANNEL12, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel13() {
			byte[] edt = getMeasurementChannel13();
			addProperty(EPC_MEASUREMENT_CHANNEL13, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel14() {
			byte[] edt = getMeasurementChannel14();
			addProperty(EPC_MEASUREMENT_CHANNEL14, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel15() {
			byte[] edt = getMeasurementChannel15();
			addProperty(EPC_MEASUREMENT_CHANNEL15, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel16() {
			byte[] edt = getMeasurementChannel16();
			addProperty(EPC_MEASUREMENT_CHANNEL16, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel17() {
			byte[] edt = getMeasurementChannel17();
			addProperty(EPC_MEASUREMENT_CHANNEL17, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel18() {
			byte[] edt = getMeasurementChannel18();
			addProperty(EPC_MEASUREMENT_CHANNEL18, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel19() {
			byte[] edt = getMeasurementChannel19();
			addProperty(EPC_MEASUREMENT_CHANNEL19, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel20() {
			byte[] edt = getMeasurementChannel20();
			addProperty(EPC_MEASUREMENT_CHANNEL20, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel21() {
			byte[] edt = getMeasurementChannel21();
			addProperty(EPC_MEASUREMENT_CHANNEL21, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel22() {
			byte[] edt = getMeasurementChannel22();
			addProperty(EPC_MEASUREMENT_CHANNEL22, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel23() {
			byte[] edt = getMeasurementChannel23();
			addProperty(EPC_MEASUREMENT_CHANNEL23, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel24() {
			byte[] edt = getMeasurementChannel24();
			addProperty(EPC_MEASUREMENT_CHANNEL24, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel25() {
			byte[] edt = getMeasurementChannel25();
			addProperty(EPC_MEASUREMENT_CHANNEL25, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel26() {
			byte[] edt = getMeasurementChannel26();
			addProperty(EPC_MEASUREMENT_CHANNEL26, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel27() {
			byte[] edt = getMeasurementChannel27();
			addProperty(EPC_MEASUREMENT_CHANNEL27, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel28() {
			byte[] edt = getMeasurementChannel28();
			addProperty(EPC_MEASUREMENT_CHANNEL28, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel29() {
			byte[] edt = getMeasurementChannel29();
			addProperty(EPC_MEASUREMENT_CHANNEL29, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel30() {
			byte[] edt = getMeasurementChannel30();
			addProperty(EPC_MEASUREMENT_CHANNEL30, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel31() {
			byte[] edt = getMeasurementChannel31();
			addProperty(EPC_MEASUREMENT_CHANNEL31, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasurementChannel32() {
			byte[] edt = getMeasurementChannel32();
			addProperty(EPC_MEASUREMENT_CHANNEL32, edt, (edt != null && (edt.length == 8)));
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
