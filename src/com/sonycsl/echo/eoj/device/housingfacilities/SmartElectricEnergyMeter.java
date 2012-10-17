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

public abstract class SmartElectricEnergyMeter extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = SmartElectricEnergyMeter.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x88;

	public static final byte EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION = (byte)0xD0;
	public static final byte EPC_OWNER_CLASSIFICATION = (byte)0xD1;
	public static final byte EPC_CONFIGURATION_INFORMATION_OF_PHASES_AND_WIRES_OF_THE_SYSTEMS = (byte)0xD2;
	public static final byte EPC_COMPOSITE_TRANSFORMATION_RATIO = (byte)0xD3;
	public static final byte EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO = (byte)0xD4;
	public static final byte EPC_METER_TYPE_CERTIFICATION_NUMBER_TYPE_APPROVAL_NUMBER_IN_JAPAN = (byte)0xD5;
	public static final byte EPC_VERIFICATION_EXPIRATION_DATE = (byte)0xD6;
	public static final byte EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION = (byte)0xE0;
	public static final byte EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS = (byte)0xE1;
	public static final byte EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION = (byte)0xE2;
	public static final byte EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION = (byte)0xE3;
	public static final byte EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION = (byte)0xE4;
	public static final byte EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED = (byte)0xE5;
	public static final byte EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRIC_ENERGY = (byte)0xE7;
	public static final byte EPC_MEASURED_INSTANTANEOUS_CURRENTS = (byte)0xE8;
	public static final byte EPC_MEASURED_INSTANTANEOUS_VOLTAGES = (byte)0xE9;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates the electric energy meter type.<br>0x30�FElectric utility company 0x31�FSolar power 0x32�FFuel cell 0x33�FBattery 0x34�FEV 0x35�FOthers<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setElectricEnergyMeterClassification(byte[] edt) {return false;}
	private final boolean _setElectricEnergyMeterClassification(byte epc, byte[] edt) {
		boolean success = setElectricEnergyMeterClassification(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the electric energy meter type.<br>0x30�FElectric utility company 0x31�FSolar power 0x32�FFuel cell 0x33�FBattery 0x34�FEV 0x35�FOthers<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getElectricEnergyMeterClassification() {return null;}
	private final byte[] _getElectricEnergyMeterClassification(byte epc) {
		byte[] edt = getElectricEnergyMeterClassification();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the type of the owner of the meter.<br>0x30�FNot specified 0x31�FElectric utility company 0x32�FPrivate sector company 0x33�FIndividual<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOwnerClassification(byte[] edt) {return false;}
	private final boolean _setOwnerClassification(byte epc, byte[] edt) {
		boolean success = setOwnerClassification(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the type of the owner of the meter.<br>0x30�FNot specified 0x31�FElectric utility company 0x32�FPrivate sector company 0x33�FIndividual<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOwnerClassification() {return null;}
	private final byte[] _getOwnerClassification(byte epc) {
		byte[] edt = getOwnerClassification();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the configuration regarding the phases and wires of the system.<br>Single-phase, two-wire system�F 0x30 Single-phase, three-wire system�F 0x31 Three-phase, three-wire system�F 0x32 Three-phase, four-wire system�F 0x33<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getConfigurationInformationOfPhasesAndWiresOfTheSystems() {return null;}
	private final byte[] _getConfigurationInformationOfPhasesAndWiresOfTheSystems(byte epc) {
		byte[] edt = getConfigurationInformationOfPhasesAndWiresOfTheSystems();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the composite transformation ratio using a 6-digit decimal notation number (initial value = 1).<br>0x00000000-0x000F423F (000000-999999)<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getCompositeTransformationRatio() {return null;}
	private final byte[] _getCompositeTransformationRatio(byte epc) {
		byte[] edt = getCompositeTransformationRatio();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the multiplying factor for the composite transformation ratio.<br>0x00�F�~1(initial value) 0x01�F�~0.1 0x02�F�~0.01 0x03�F�~0.001<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMultiplyingFactorForCompositeTransformationRatio() {return null;}
	private final byte[] _getMultiplyingFactorForCompositeTransformationRatio(byte epc) {
		byte[] edt = getMultiplyingFactorForCompositeTransformationRatio();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the type-certified meter number using alphanumeric characters (0x20-0x70).<br>Type-certified meter (type number): 0000-0��������- 9999-9�������� Non-type certified meter: FFFFFFFFFF (initial value)<br><br>Data type : unsigned char x 10<br>Data size : 10 Byte<br>Set : undefined<br>Get : mandatory
	 */
	protected abstract byte[] getMeterTypeCertificationNumberTypeApprovalNumberInJapan();
	private final byte[] _getMeterTypeCertificationNumberTypeApprovalNumberInJapan(byte epc) {
		byte[] edt = getMeterTypeCertificationNumberTypeApprovalNumberInJapan();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates, in the form of an ASCII code, the month and year in which the verification of the meter will expire.<br>YYYYMM YYYY (Year), MM (Month)<br><br>Data type : unsigned char x 6<br>Data size : 6 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setVerificationExpirationDate(byte[] edt) {return false;}
	private final boolean _setVerificationExpirationDate(byte epc, byte[] edt) {
		boolean success = setVerificationExpirationDate(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates, in the form of an ASCII code, the month and year in which the verification of the meter will expire.<br>YYYYMM YYYY (Year), MM (Month)<br><br>Data type : unsigned char x 6<br>Data size : 6 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getVerificationExpirationDate() {return null;}
	private final byte[] _getVerificationExpirationDate(byte epc) {
		byte[] edt = getVerificationExpirationDate();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : mandatory
	 */
	protected abstract byte[] getMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
	private final byte[] _getMeasuredCumulativeAmountOfElectricEnergyNormalDirection(byte epc) {
		byte[] edt = getMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>0x00: 1kWh 0x01: 0.1kWh 0x02: 0.01kWh 0x03: 0.001kWh (Initial value) 0x04: 0.0001kWh 0x0A: 10kWh 0x0B: 100kWh 0x0C: 1000kWh 0x0D: 10000kWh<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : mandatory
	 */
	protected abstract byte[] getUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections();
	private final byte[] _getUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections(byte epc) {
		byte[] edt = getUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063: 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)<br><br>Data type : unsigned short + unsigned long x48<br>Data size : 194 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection() {return null;}
	private final byte[] _getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(byte epc) {
		byte[] edt = getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredCumulativeAmountOfElectricEnergyReverseDirection() {return null;}
	private final byte[] _getMeasuredCumulativeAmountOfElectricEnergyReverseDirection(byte epc) {
		byte[] edt = getMeasuredCumulativeAmountOfElectricEnergyReverseDirection();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063: 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)<br><br>Data type : unsigned short �{ unsigned long �~48<br>Data size : 194 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection() {return null;}
	private final byte[] _getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(byte epc) {
		byte[] edt = getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte[] edt) {return false;}
	private final boolean _setDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte epc, byte[] edt) {
		boolean success = setDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved() {return null;}
	private final byte[] _getDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte epc) {
		byte[] edt = getDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br>0x80000001-0x7FFFFFFD (-2,147,483,647- 2,147,483,645)<br><br>Data type : signed long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredInstantaneousAmountOfElectricEnergy() {return null;}
	private final byte[] _getMeasuredInstantaneousAmountOfElectricEnergy(byte epc) {
		byte[] edt = getMeasuredInstantaneousAmountOfElectricEnergy();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured effective instantaneous R and T phase currents in amperes. In the case of a single-phase, two-wire system, 0x7FFE shall be used for the T phase.<br>0x8001-0x7FFD�iR phase�j : 0x8001-0x7FFD�iT phase�j (-3,276.7-3,276.5): (-3,276.7-3,276.5)<br><br>Data type : signed short �~2<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredInstantaneousCurrents() {return null;}
	private final byte[] _getMeasuredInstantaneousCurrents(byte epc) {
		byte[] edt = getMeasuredInstantaneousCurrents();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a single-phase, two-wire system, 0xFFFE shall be used for the S(N)-T voltage.<br>0x0000-0xFFFD (between R and S(N))�F 0x0000-0xFFFD (between S(N) and T) (0-6,553.3) : (0-6,553.3)<br><br>Data type : unsigned short �~2<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredInstantaneousVoltages() {return null;}
	private final byte[] _getMeasuredInstantaneousVoltages(byte epc) {
		byte[] edt = getMeasuredInstantaneousVoltages();
		notify(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION:
			res.addProperty(epc, edt, _setElectricEnergyMeterClassification(epc, edt));
			break;
		case EPC_OWNER_CLASSIFICATION:
			res.addProperty(epc, edt, _setOwnerClassification(epc, edt));
			break;
		case EPC_VERIFICATION_EXPIRATION_DATE:
			res.addProperty(epc, edt, _setVerificationExpirationDate(epc, edt));
			break;
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
		case EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION:
			edt = _getElectricEnergyMeterClassification(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OWNER_CLASSIFICATION:
			edt = _getOwnerClassification(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_CONFIGURATION_INFORMATION_OF_PHASES_AND_WIRES_OF_THE_SYSTEMS:
			edt = _getConfigurationInformationOfPhasesAndWiresOfTheSystems(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_COMPOSITE_TRANSFORMATION_RATIO:
			edt = _getCompositeTransformationRatio(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO:
			edt = _getMultiplyingFactorForCompositeTransformationRatio(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_METER_TYPE_CERTIFICATION_NUMBER_TYPE_APPROVAL_NUMBER_IN_JAPAN:
			edt = _getMeterTypeCertificationNumberTypeApprovalNumberInJapan(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 10)));
			break;
		case EPC_VERIFICATION_EXPIRATION_DATE:
			edt = _getVerificationExpirationDate(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 6)));
			break;
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION:
			edt = _getMeasuredCumulativeAmountOfElectricEnergyNormalDirection(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS:
			edt = _getUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION:
			edt = _getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 194)));
			break;
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION:
			edt = _getMeasuredCumulativeAmountOfElectricEnergyReverseDirection(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION:
			edt = _getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 194)));
			break;
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED:
			edt = _getDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRIC_ENERGY:
			edt = _getMeasuredInstantaneousAmountOfElectricEnergy(epc);
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
			case EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION:
				_onSetElectricEnergyMeterClassification(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_OWNER_CLASSIFICATION:
				_onSetOwnerClassification(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_VERIFICATION_EXPIRATION_DATE:
				_onSetVerificationExpirationDate(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED:
				_onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION:
				_onGetElectricEnergyMeterClassification(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OWNER_CLASSIFICATION:
				_onGetOwnerClassification(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_CONFIGURATION_INFORMATION_OF_PHASES_AND_WIRES_OF_THE_SYSTEMS:
				_onGetConfigurationInformationOfPhasesAndWiresOfTheSystems(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_COMPOSITE_TRANSFORMATION_RATIO:
				_onGetCompositeTransformationRatio(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO:
				_onGetMultiplyingFactorForCompositeTransformationRatio(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_METER_TYPE_CERTIFICATION_NUMBER_TYPE_APPROVAL_NUMBER_IN_JAPAN:
				_onGetMeterTypeCertificationNumberTypeApprovalNumberInJapan(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_VERIFICATION_EXPIRATION_DATE:
				_onGetVerificationExpirationDate(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION:
				_onGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS:
				_onGetUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION:
				_onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION:
				_onGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION:
				_onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED:
				_onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRIC_ENERGY:
				_onGetMeasuredInstantaneousAmountOfElectricEnergy(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_CURRENTS:
				_onGetMeasuredInstantaneousCurrents(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_VOLTAGES:
				_onGetMeasuredInstantaneousVoltages(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates the electric energy meter type.<br>0x30�FElectric utility company 0x31�FSolar power 0x32�FFuel cell 0x33�FBattery 0x34�FEV 0x35�FOthers<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetElectricEnergyMeterClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetElectricEnergyMeterClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetElectricEnergyMeterClassification(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the electric energy meter type.<br>0x30�FElectric utility company 0x31�FSolar power 0x32�FFuel cell 0x33�FBattery 0x34�FEV 0x35�FOthers<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetElectricEnergyMeterClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetElectricEnergyMeterClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetElectricEnergyMeterClassification(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the type of the owner of the meter.<br>0x30�FNot specified 0x31�FElectric utility company 0x32�FPrivate sector company 0x33�FIndividual<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOwnerClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOwnerClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOwnerClassification(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the type of the owner of the meter.<br>0x30�FNot specified 0x31�FElectric utility company 0x32�FPrivate sector company 0x33�FIndividual<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOwnerClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOwnerClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOwnerClassification(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the configuration regarding the phases and wires of the system.<br>Single-phase, two-wire system�F 0x30 Single-phase, three-wire system�F 0x31 Three-phase, three-wire system�F 0x32 Three-phase, four-wire system�F 0x33<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetConfigurationInformationOfPhasesAndWiresOfTheSystems(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetConfigurationInformationOfPhasesAndWiresOfTheSystems(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetConfigurationInformationOfPhasesAndWiresOfTheSystems(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the composite transformation ratio using a 6-digit decimal notation number (initial value = 1).<br>0x00000000-0x000F423F (000000-999999)<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetCompositeTransformationRatio(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetCompositeTransformationRatio(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetCompositeTransformationRatio(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the multiplying factor for the composite transformation ratio.<br>0x00�F�~1(initial value) 0x01�F�~0.1 0x02�F�~0.01 0x03�F�~0.001<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMultiplyingFactorForCompositeTransformationRatio(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMultiplyingFactorForCompositeTransformationRatio(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMultiplyingFactorForCompositeTransformationRatio(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the type-certified meter number using alphanumeric characters (0x20-0x70).<br>Type-certified meter (type number): 0000-0��������- 9999-9�������� Non-type certified meter: FFFFFFFFFF (initial value)<br><br>Data type : unsigned char x 10<br>Data size : 10 Byte<br>Set : undefined<br>Get : mandatory
		 */
		protected void onGetMeterTypeCertificationNumberTypeApprovalNumberInJapan(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeterTypeCertificationNumberTypeApprovalNumberInJapan(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeterTypeCertificationNumberTypeApprovalNumberInJapan(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates, in the form of an ASCII code, the month and year in which the verification of the meter will expire.<br>YYYYMM YYYY (Year), MM (Month)<br><br>Data type : unsigned char x 6<br>Data size : 6 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetVerificationExpirationDate(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetVerificationExpirationDate(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetVerificationExpirationDate(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates, in the form of an ASCII code, the month and year in which the verification of the meter will expire.<br>YYYYMM YYYY (Year), MM (Month)<br><br>Data type : unsigned char x 6<br>Data size : 6 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetVerificationExpirationDate(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetVerificationExpirationDate(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetVerificationExpirationDate(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : mandatory
		 */
		protected void onGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>0x00: 1kWh 0x01: 0.1kWh 0x02: 0.01kWh 0x03: 0.001kWh (Initial value) 0x04: 0.0001kWh 0x0A: 10kWh 0x0B: 100kWh 0x0C: 1000kWh 0x0D: 10000kWh<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : mandatory
		 */
		protected void onGetUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063: 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)<br><br>Data type : unsigned short + unsigned long x48<br>Data size : 194 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063: 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)<br><br>Data type : unsigned short �{ unsigned long �~48<br>Data size : 194 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br>0x80000001-0x7FFFFFFD (-2,147,483,647- 2,147,483,645)<br><br>Data type : signed long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredInstantaneousAmountOfElectricEnergy(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredInstantaneousAmountOfElectricEnergy(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredInstantaneousAmountOfElectricEnergy(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured effective instantaneous R and T phase currents in amperes. In the case of a single-phase, two-wire system, 0x7FFE shall be used for the T phase.<br>0x8001-0x7FFD�iR phase�j : 0x8001-0x7FFD�iT phase�j (-3,276.7-3,276.5): (-3,276.7-3,276.5)<br><br>Data type : signed short �~2<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredInstantaneousCurrents(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredInstantaneousCurrents(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredInstantaneousCurrents(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a single-phase, two-wire system, 0xFFFE shall be used for the S(N)-T voltage.<br>0x0000-0xFFFD (between R and S(N))�F 0x0000-0xFFFD (between S(N) and T) (0-6,553.3) : (0-6,553.3)<br><br>Data type : unsigned short �~2<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredInstantaneousVoltages(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredInstantaneousVoltages(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredInstantaneousVoltages(eoj, tid, esv, epc, pdc, edt);
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
		 * This property indicates the electric energy meter type.<br>0x30�FElectric utility company 0x31�FSolar power 0x32�FFuel cell 0x33�FBattery 0x34�FEV 0x35�FOthers<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetElectricEnergyMeterClassification(byte[] edt);
		/**
		 * This property indicates the type of the owner of the meter.<br>0x30�FNot specified 0x31�FElectric utility company 0x32�FPrivate sector company 0x33�FIndividual<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOwnerClassification(byte[] edt);
		/**
		 * This property indicates, in the form of an ASCII code, the month and year in which the verification of the meter will expire.<br>YYYYMM YYYY (Year), MM (Month)<br><br>Data type : unsigned char x 6<br>Data size : 6 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetVerificationExpirationDate(byte[] edt);
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte[] edt);
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
		public Setter reqSetElectricEnergyMeterClassification(byte[] edt) {
			byte epc = EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION;
			addProperty(epc, edt, _setElectricEnergyMeterClassification(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetOwnerClassification(byte[] edt) {
			byte epc = EPC_OWNER_CLASSIFICATION;
			addProperty(epc, edt, _setOwnerClassification(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetVerificationExpirationDate(byte[] edt) {
			byte epc = EPC_VERIFICATION_EXPIRATION_DATE;
			addProperty(epc, edt, _setVerificationExpirationDate(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte[] edt) {
			byte epc = EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED;
			addProperty(epc, edt, _setDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(epc, edt));
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
		public Setter reqSetElectricEnergyMeterClassification(byte[] edt) {
			addProperty(EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOwnerClassification(byte[] edt) {
			addProperty(EPC_OWNER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetVerificationExpirationDate(byte[] edt) {
			addProperty(EPC_VERIFICATION_EXPIRATION_DATE, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Setter reqSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte[] edt) {
			addProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED, edt, (edt != null && (edt.length == 1)));
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
		 * This property indicates the electric energy meter type.<br>0x30�FElectric utility company 0x31�FSolar power 0x32�FFuel cell 0x33�FBattery 0x34�FEV 0x35�FOthers<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetElectricEnergyMeterClassification();
		/**
		 * This property indicates the type of the owner of the meter.<br>0x30�FNot specified 0x31�FElectric utility company 0x32�FPrivate sector company 0x33�FIndividual<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOwnerClassification();
		/**
		 * This property indicates the configuration regarding the phases and wires of the system.<br>Single-phase, two-wire system�F 0x30 Single-phase, three-wire system�F 0x31 Three-phase, three-wire system�F 0x32 Three-phase, four-wire system�F 0x33<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetConfigurationInformationOfPhasesAndWiresOfTheSystems();
		/**
		 * This property indicates the composite transformation ratio using a 6-digit decimal notation number (initial value = 1).<br>0x00000000-0x000F423F (000000-999999)<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetCompositeTransformationRatio();
		/**
		 * This property indicates the multiplying factor for the composite transformation ratio.<br>0x00�F�~1(initial value) 0x01�F�~0.1 0x02�F�~0.01 0x03�F�~0.001<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMultiplyingFactorForCompositeTransformationRatio();
		/**
		 * This property indicates the type-certified meter number using alphanumeric characters (0x20-0x70).<br>Type-certified meter (type number): 0000-0��������- 9999-9�������� Non-type certified meter: FFFFFFFFFF (initial value)<br><br>Data type : unsigned char x 10<br>Data size : 10 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Getter reqGetMeterTypeCertificationNumberTypeApprovalNumberInJapan();
		/**
		 * This property indicates, in the form of an ASCII code, the month and year in which the verification of the meter will expire.<br>YYYYMM YYYY (Year), MM (Month)<br><br>Data type : unsigned char x 6<br>Data size : 6 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetVerificationExpirationDate();
		/**
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
		/**
		 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>0x00: 1kWh 0x01: 0.1kWh 0x02: 0.01kWh 0x03: 0.001kWh (Initial value) 0x04: 0.0001kWh 0x0A: 10kWh 0x0B: 100kWh 0x0C: 1000kWh 0x0D: 10000kWh<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Getter reqGetUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections();
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063: 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)<br><br>Data type : unsigned short + unsigned long x48<br>Data size : 194 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection();
		/**
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection();
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063: 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)<br><br>Data type : unsigned short �{ unsigned long �~48<br>Data size : 194 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection();
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved();
		/**
		 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br>0x80000001-0x7FFFFFFD (-2,147,483,647- 2,147,483,645)<br><br>Data type : signed long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredInstantaneousAmountOfElectricEnergy();
		/**
		 * This property indicates the measured effective instantaneous R and T phase currents in amperes. In the case of a single-phase, two-wire system, 0x7FFE shall be used for the T phase.<br>0x8001-0x7FFD�iR phase�j : 0x8001-0x7FFD�iT phase�j (-3,276.7-3,276.5): (-3,276.7-3,276.5)<br><br>Data type : signed short �~2<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredInstantaneousCurrents();
		/**
		 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a single-phase, two-wire system, 0xFFFE shall be used for the S(N)-T voltage.<br>0x0000-0xFFFD (between R and S(N))�F 0x0000-0xFFFD (between S(N) and T) (0-6,553.3) : (0-6,553.3)<br><br>Data type : unsigned short �~2<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredInstantaneousVoltages();
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
		public Getter reqGetElectricEnergyMeterClassification() {
			byte epc = EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION;
			byte[] edt = _getElectricEnergyMeterClassification(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOwnerClassification() {
			byte epc = EPC_OWNER_CLASSIFICATION;
			byte[] edt = _getOwnerClassification(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetConfigurationInformationOfPhasesAndWiresOfTheSystems() {
			byte epc = EPC_CONFIGURATION_INFORMATION_OF_PHASES_AND_WIRES_OF_THE_SYSTEMS;
			byte[] edt = _getConfigurationInformationOfPhasesAndWiresOfTheSystems(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetCompositeTransformationRatio() {
			byte epc = EPC_COMPOSITE_TRANSFORMATION_RATIO;
			byte[] edt = _getCompositeTransformationRatio(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetMultiplyingFactorForCompositeTransformationRatio() {
			byte epc = EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO;
			byte[] edt = _getMultiplyingFactorForCompositeTransformationRatio(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeterTypeCertificationNumberTypeApprovalNumberInJapan() {
			byte epc = EPC_METER_TYPE_CERTIFICATION_NUMBER_TYPE_APPROVAL_NUMBER_IN_JAPAN;
			byte[] edt = _getMeterTypeCertificationNumberTypeApprovalNumberInJapan(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 10)));
			return this;
		}
		@Override
		public Getter reqGetVerificationExpirationDate() {
			byte epc = EPC_VERIFICATION_EXPIRATION_DATE;
			byte[] edt = _getVerificationExpirationDate(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection() {
			byte epc = EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION;
			byte[] edt = _getMeasuredCumulativeAmountOfElectricEnergyNormalDirection(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections() {
			byte epc = EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS;
			byte[] edt = _getUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection() {
			byte epc = EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION;
			byte[] edt = _getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 194)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection() {
			byte epc = EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION;
			byte[] edt = _getMeasuredCumulativeAmountOfElectricEnergyReverseDirection(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection() {
			byte epc = EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION;
			byte[] edt = _getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 194)));
			return this;
		}
		@Override
		public Getter reqGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved() {
			byte epc = EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED;
			byte[] edt = _getDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousAmountOfElectricEnergy() {
			byte epc = EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRIC_ENERGY;
			byte[] edt = _getMeasuredInstantaneousAmountOfElectricEnergy(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousCurrents() {
			byte epc = EPC_MEASURED_INSTANTANEOUS_CURRENTS;
			byte[] edt = _getMeasuredInstantaneousCurrents(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousVoltages() {
			byte epc = EPC_MEASURED_INSTANTANEOUS_VOLTAGES;
			byte[] edt = _getMeasuredInstantaneousVoltages(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
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
		public Getter reqGetElectricEnergyMeterClassification() {
			addProperty(EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION);
			return this;
		}
		@Override
		public Getter reqGetOwnerClassification() {
			addProperty(EPC_OWNER_CLASSIFICATION);
			return this;
		}
		@Override
		public Getter reqGetConfigurationInformationOfPhasesAndWiresOfTheSystems() {
			addProperty(EPC_CONFIGURATION_INFORMATION_OF_PHASES_AND_WIRES_OF_THE_SYSTEMS);
			return this;
		}
		@Override
		public Getter reqGetCompositeTransformationRatio() {
			addProperty(EPC_COMPOSITE_TRANSFORMATION_RATIO);
			return this;
		}
		@Override
		public Getter reqGetMultiplyingFactorForCompositeTransformationRatio() {
			addProperty(EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO);
			return this;
		}
		@Override
		public Getter reqGetMeterTypeCertificationNumberTypeApprovalNumberInJapan() {
			addProperty(EPC_METER_TYPE_CERTIFICATION_NUMBER_TYPE_APPROVAL_NUMBER_IN_JAPAN);
			return this;
		}
		@Override
		public Getter reqGetVerificationExpirationDate() {
			addProperty(EPC_VERIFICATION_EXPIRATION_DATE);
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
			return this;
		}
		@Override
		public Getter reqGetUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections() {
			addProperty(EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS);
			return this;
		}
		@Override
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection() {
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION);
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
		public Getter reqGetMeasuredInstantaneousAmountOfElectricEnergy() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRIC_ENERGY);
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
		 * This property indicates the electric energy meter type.<br>0x30�FElectric utility company 0x31�FSolar power 0x32�FFuel cell 0x33�FBattery 0x34�FEV 0x35�FOthers<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformElectricEnergyMeterClassification();
		/**
		 * This property indicates the type of the owner of the meter.<br>0x30�FNot specified 0x31�FElectric utility company 0x32�FPrivate sector company 0x33�FIndividual<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOwnerClassification();
		/**
		 * This property indicates the configuration regarding the phases and wires of the system.<br>Single-phase, two-wire system�F 0x30 Single-phase, three-wire system�F 0x31 Three-phase, three-wire system�F 0x32 Three-phase, four-wire system�F 0x33<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformConfigurationInformationOfPhasesAndWiresOfTheSystems();
		/**
		 * This property indicates the composite transformation ratio using a 6-digit decimal notation number (initial value = 1).<br>0x00000000-0x000F423F (000000-999999)<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformCompositeTransformationRatio();
		/**
		 * This property indicates the multiplying factor for the composite transformation ratio.<br>0x00�F�~1(initial value) 0x01�F�~0.1 0x02�F�~0.01 0x03�F�~0.001<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMultiplyingFactorForCompositeTransformationRatio();
		/**
		 * This property indicates the type-certified meter number using alphanumeric characters (0x20-0x70).<br>Type-certified meter (type number): 0000-0��������- 9999-9�������� Non-type certified meter: FFFFFFFFFF (initial value)<br><br>Data type : unsigned char x 10<br>Data size : 10 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Informer reqInformMeterTypeCertificationNumberTypeApprovalNumberInJapan();
		/**
		 * This property indicates, in the form of an ASCII code, the month and year in which the verification of the meter will expire.<br>YYYYMM YYYY (Year), MM (Month)<br><br>Data type : unsigned char x 6<br>Data size : 6 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformVerificationExpirationDate();
		/**
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
		/**
		 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>0x00: 1kWh 0x01: 0.1kWh 0x02: 0.01kWh 0x03: 0.001kWh (Initial value) 0x04: 0.0001kWh 0x0A: 10kWh 0x0B: 100kWh 0x0C: 1000kWh 0x0D: 10000kWh<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Informer reqInformUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections();
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063: 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)<br><br>Data type : unsigned short + unsigned long x48<br>Data size : 194 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection();
		/**
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyReverseDirection();
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063: 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)<br><br>Data type : unsigned short �{ unsigned long �~48<br>Data size : 194 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection();
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved();
		/**
		 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br>0x80000001-0x7FFFFFFD (-2,147,483,647- 2,147,483,645)<br><br>Data type : signed long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredInstantaneousAmountOfElectricEnergy();
		/**
		 * This property indicates the measured effective instantaneous R and T phase currents in amperes. In the case of a single-phase, two-wire system, 0x7FFE shall be used for the T phase.<br>0x8001-0x7FFD�iR phase�j : 0x8001-0x7FFD�iT phase�j (-3,276.7-3,276.5): (-3,276.7-3,276.5)<br><br>Data type : signed short �~2<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredInstantaneousCurrents();
		/**
		 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a single-phase, two-wire system, 0xFFFE shall be used for the S(N)-T voltage.<br>0x0000-0xFFFD (between R and S(N))�F 0x0000-0xFFFD (between S(N) and T) (0-6,553.3) : (0-6,553.3)<br><br>Data type : unsigned short �~2<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredInstantaneousVoltages();
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
		public Informer reqInformElectricEnergyMeterClassification() {
			byte epc = EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION;
			byte[] edt = _getElectricEnergyMeterClassification(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOwnerClassification() {
			byte epc = EPC_OWNER_CLASSIFICATION;
			byte[] edt = _getOwnerClassification(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformConfigurationInformationOfPhasesAndWiresOfTheSystems() {
			byte epc = EPC_CONFIGURATION_INFORMATION_OF_PHASES_AND_WIRES_OF_THE_SYSTEMS;
			byte[] edt = _getConfigurationInformationOfPhasesAndWiresOfTheSystems(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformCompositeTransformationRatio() {
			byte epc = EPC_COMPOSITE_TRANSFORMATION_RATIO;
			byte[] edt = _getCompositeTransformationRatio(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformMultiplyingFactorForCompositeTransformationRatio() {
			byte epc = EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO;
			byte[] edt = _getMultiplyingFactorForCompositeTransformationRatio(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeterTypeCertificationNumberTypeApprovalNumberInJapan() {
			byte epc = EPC_METER_TYPE_CERTIFICATION_NUMBER_TYPE_APPROVAL_NUMBER_IN_JAPAN;
			byte[] edt = _getMeterTypeCertificationNumberTypeApprovalNumberInJapan(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 10)));
			return this;
		}
		@Override
		public Informer reqInformVerificationExpirationDate() {
			byte epc = EPC_VERIFICATION_EXPIRATION_DATE;
			byte[] edt = _getVerificationExpirationDate(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyNormalDirection() {
			byte epc = EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION;
			byte[] edt = _getMeasuredCumulativeAmountOfElectricEnergyNormalDirection(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections() {
			byte epc = EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS;
			byte[] edt = _getUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections(epc);
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
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyReverseDirection() {
			byte epc = EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION;
			byte[] edt = _getMeasuredCumulativeAmountOfElectricEnergyReverseDirection(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
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
		public Informer reqInformMeasuredInstantaneousAmountOfElectricEnergy() {
			byte epc = EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRIC_ENERGY;
			byte[] edt = _getMeasuredInstantaneousAmountOfElectricEnergy(epc);
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
		public Informer reqInformElectricEnergyMeterClassification() {
			addProperty(EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION);
			return this;
		}
		@Override
		public Informer reqInformOwnerClassification() {
			addProperty(EPC_OWNER_CLASSIFICATION);
			return this;
		}
		@Override
		public Informer reqInformConfigurationInformationOfPhasesAndWiresOfTheSystems() {
			addProperty(EPC_CONFIGURATION_INFORMATION_OF_PHASES_AND_WIRES_OF_THE_SYSTEMS);
			return this;
		}
		@Override
		public Informer reqInformCompositeTransformationRatio() {
			addProperty(EPC_COMPOSITE_TRANSFORMATION_RATIO);
			return this;
		}
		@Override
		public Informer reqInformMultiplyingFactorForCompositeTransformationRatio() {
			addProperty(EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO);
			return this;
		}
		@Override
		public Informer reqInformMeterTypeCertificationNumberTypeApprovalNumberInJapan() {
			addProperty(EPC_METER_TYPE_CERTIFICATION_NUMBER_TYPE_APPROVAL_NUMBER_IN_JAPAN);
			return this;
		}
		@Override
		public Informer reqInformVerificationExpirationDate() {
			addProperty(EPC_VERIFICATION_EXPIRATION_DATE);
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyNormalDirection() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
			return this;
		}
		@Override
		public Informer reqInformUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections() {
			addProperty(EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS);
			return this;
		}
		@Override
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection() {
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyReverseDirection() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION);
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
		public Informer reqInformMeasuredInstantaneousAmountOfElectricEnergy() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRIC_ENERGY);
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
	}
}
