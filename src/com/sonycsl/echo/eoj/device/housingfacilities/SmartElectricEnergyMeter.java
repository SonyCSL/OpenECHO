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

	protected static final byte EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION = (byte)0xD0;
	protected static final byte EPC_OWNER_CLASSIFICATION = (byte)0xD1;
	protected static final byte EPC_CONFIGURATION_INFORMATION_OF_PHASES_AND_WIRES_OF_THE_SYSTEMS = (byte)0xD2;
	protected static final byte EPC_COMPOSITE_TRANSFORMATION_RATIO = (byte)0xD3;
	protected static final byte EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO = (byte)0xD4;
	protected static final byte EPC_METER_TYPE_CERTIFICATION_NUMBER_TYPE_APPROVAL_NUMBER_IN_JAPAN = (byte)0xD5;
	protected static final byte EPC_VERIFICATION_EXPIRATION_DATE = (byte)0xD6;
	protected static final byte EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION = (byte)0xE0;
	protected static final byte EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS = (byte)0xE1;
	protected static final byte EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION = (byte)0xE2;
	protected static final byte EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION = (byte)0xE3;
	protected static final byte EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION = (byte)0xE4;
	protected static final byte EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED = (byte)0xE5;
	protected static final byte EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRIC_ENERGY = (byte)0xE7;
	protected static final byte EPC_MEASURED_INSTANTANEOUS_CURRENTS = (byte)0xE8;
	protected static final byte EPC_MEASURED_INSTANTANEOUS_VOLTAGES = (byte)0xE9;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates the electric energy meter type.<br>0x30�FElectric utility company 0x31�FSolar power 0x32�FFuel cell 0x33�FBattery 0x34�FEV 0x35�FOthers
	 */
	protected boolean setElectricEnergyMeterClassification(byte[] edt) {return false;}
	/**
	 * This property indicates the electric energy meter type.<br>0x30�FElectric utility company 0x31�FSolar power 0x32�FFuel cell 0x33�FBattery 0x34�FEV 0x35�FOthers
	 */
	protected byte[] getElectricEnergyMeterClassification() {return null;}
	/**
	 * This property indicates the type of the owner of the meter.<br>0x30�FNot specified 0x31�FElectric utility company 0x32�FPrivate sector company 0x33�FIndividual
	 */
	protected boolean setOwnerClassification(byte[] edt) {return false;}
	/**
	 * This property indicates the type of the owner of the meter.<br>0x30�FNot specified 0x31�FElectric utility company 0x32�FPrivate sector company 0x33�FIndividual
	 */
	protected byte[] getOwnerClassification() {return null;}
	/**
	 * This property indicates the configuration regarding the phases and wires of the system.<br>Single-phase, two-wire system�F 0x30 Single-phase, three-wire system�F 0x31 Three-phase, three-wire system�F 0x32 Three-phase, four-wire system�F 0x33
	 */
	protected byte[] getConfigurationInformationOfPhasesAndWiresOfTheSystems() {return null;}
	/**
	 * This property indicates the composite transformation ratio using a 6-digit decimal notation number (initial value = 1).<br>0x00000000-0x000F423F (000000-999999)
	 */
	protected byte[] getCompositeTransformationRatio() {return null;}
	/**
	 * This property indicates the multiplying factor for the composite transformation ratio.<br>0x00�F�~1(initial value) 0x01�F�~0.1 0x02�F�~0.01 0x03�F�~0.001
	 */
	protected byte[] getMultiplyingFactorForCompositeTransformationRatio() {return null;}
	/**
	 * This property indicates the type-certified meter number using alphanumeric characters (0x20-0x70).<br>Type-certified meter (type number): 0000-0��������- 9999-9�������� Non-type certified meter: FFFFFFFFFF (initial value)
	 */
	protected abstract byte[] getMeterTypeCertificationNumberTypeApprovalNumberInJapan();
	/**
	 * This property indicates, in the form of an ASCII code, the month and year in which the verification of the meter will expire.<br>YYYYMM YYYY (Year), MM (Month)
	 */
	protected boolean setVerificationExpirationDate(byte[] edt) {return false;}
	/**
	 * This property indicates, in the form of an ASCII code, the month and year in which the verification of the meter will expire.<br>YYYYMM YYYY (Year), MM (Month)
	 */
	protected byte[] getVerificationExpirationDate() {return null;}
	/**
	 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)
	 */
	protected abstract byte[] getMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
	/**
	 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>0x00: 1kWh 0x01: 0.1kWh 0x02: 0.01kWh 0x03: 0.001kWh (Initial value) 0x04: 0.0001kWh 0x0A: 10kWh 0x0B: 100kWh 0x0C: 1000kWh 0x0D: 10000kWh
	 */
	protected abstract byte[] getUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections();
	/**
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063: 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)
	 */
	protected byte[] getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection() {return null;}
	/**
	 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)
	 */
	protected byte[] getMeasuredCumulativeAmountOfElectricEnergyReverseDirection() {return null;}
	/**
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063: 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)
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
	protected byte[] getMeasuredInstantaneousAmountOfElectricEnergy() {return null;}
	/**
	 * This property indicates the measured effective instantaneous R and T phase currents in amperes. In the case of a single-phase, two-wire system, 0x7FFE shall be used for the T phase.<br>0x8001-0x7FFD�iR phase�j : 0x8001-0x7FFD�iT phase�j (-3,276.7-3,276.5): (-3,276.7-3,276.5)
	 */
	protected byte[] getMeasuredInstantaneousCurrents() {return null;}
	/**
	 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a single-phase, two-wire system, 0xFFFE shall be used for the S(N)-T voltage.<br>0x0000-0xFFFD (between R and S(N))�F 0x0000-0xFFFD (between S(N) and T) (0-6,553.3) : (0-6,553.3)
	 */
	protected byte[] getMeasuredInstantaneousVoltages() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION:
			res.addProperty(epc, edt, setElectricEnergyMeterClassification(edt));
			break;
		case EPC_OWNER_CLASSIFICATION:
			res.addProperty(epc, edt, setOwnerClassification(edt));
			break;
		case EPC_VERIFICATION_EXPIRATION_DATE:
			res.addProperty(epc, edt, setVerificationExpirationDate(edt));
			break;
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
		case EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION:
			edt = getElectricEnergyMeterClassification();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OWNER_CLASSIFICATION:
			edt = getOwnerClassification();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_CONFIGURATION_INFORMATION_OF_PHASES_AND_WIRES_OF_THE_SYSTEMS:
			edt = getConfigurationInformationOfPhasesAndWiresOfTheSystems();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_COMPOSITE_TRANSFORMATION_RATIO:
			edt = getCompositeTransformationRatio();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO:
			edt = getMultiplyingFactorForCompositeTransformationRatio();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_METER_TYPE_CERTIFICATION_NUMBER_TYPE_APPROVAL_NUMBER_IN_JAPAN:
			edt = getMeterTypeCertificationNumberTypeApprovalNumberInJapan();
			res.addProperty(epc, edt, (edt != null && (edt.length == 10)));
			break;
		case EPC_VERIFICATION_EXPIRATION_DATE:
			edt = getVerificationExpirationDate();
			res.addProperty(epc, edt, (edt != null && (edt.length == 6)));
			break;
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION:
			edt = getMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS:
			edt = getUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION:
			edt = getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection();
			res.addProperty(epc, edt, (edt != null && (edt.length == 194)));
			break;
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION:
			edt = getMeasuredCumulativeAmountOfElectricEnergyReverseDirection();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION:
			edt = getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection();
			res.addProperty(epc, edt, (edt != null && (edt.length == 194)));
			break;
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED:
			edt = getDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRIC_ENERGY:
			edt = getMeasuredInstantaneousAmountOfElectricEnergy();
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
			case EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION:
				onSetElectricEnergyMeterClassification(eoj, tid, (pdc != 0));
				break;
			case EPC_OWNER_CLASSIFICATION:
				onSetOwnerClassification(eoj, tid, (pdc != 0));
				break;
			case EPC_VERIFICATION_EXPIRATION_DATE:
				onSetVerificationExpirationDate(eoj, tid, (pdc != 0));
				break;
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
			case EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION:
				onGetElectricEnergyMeterClassification(eoj, tid, pdc, edt);
				break;
			case EPC_OWNER_CLASSIFICATION:
				onGetOwnerClassification(eoj, tid, pdc, edt);
				break;
			case EPC_CONFIGURATION_INFORMATION_OF_PHASES_AND_WIRES_OF_THE_SYSTEMS:
				onGetConfigurationInformationOfPhasesAndWiresOfTheSystems(eoj, tid, pdc, edt);
				break;
			case EPC_COMPOSITE_TRANSFORMATION_RATIO:
				onGetCompositeTransformationRatio(eoj, tid, pdc, edt);
				break;
			case EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO:
				onGetMultiplyingFactorForCompositeTransformationRatio(eoj, tid, pdc, edt);
				break;
			case EPC_METER_TYPE_CERTIFICATION_NUMBER_TYPE_APPROVAL_NUMBER_IN_JAPAN:
				onGetMeterTypeCertificationNumberTypeApprovalNumberInJapan(eoj, tid, pdc, edt);
				break;
			case EPC_VERIFICATION_EXPIRATION_DATE:
				onGetVerificationExpirationDate(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION:
				onGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection(eoj, tid, pdc, edt);
				break;
			case EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS:
				onGetUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections(eoj, tid, pdc, edt);
				break;
			case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION:
				onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION:
				onGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection(eoj, tid, pdc, edt);
				break;
			case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION:
				onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(eoj, tid, pdc, edt);
				break;
			case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED:
				onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRIC_ENERGY:
				onGetMeasuredInstantaneousAmountOfElectricEnergy(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_CURRENTS:
				onGetMeasuredInstantaneousCurrents(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_VOLTAGES:
				onGetMeasuredInstantaneousVoltages(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates the electric energy meter type.<br>0x30�FElectric utility company 0x31�FSolar power 0x32�FFuel cell 0x33�FBattery 0x34�FEV 0x35�FOthers
		 */
		protected void onSetElectricEnergyMeterClassification(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the electric energy meter type.<br>0x30�FElectric utility company 0x31�FSolar power 0x32�FFuel cell 0x33�FBattery 0x34�FEV 0x35�FOthers
		 */
		protected void onGetElectricEnergyMeterClassification(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the type of the owner of the meter.<br>0x30�FNot specified 0x31�FElectric utility company 0x32�FPrivate sector company 0x33�FIndividual
		 */
		protected void onSetOwnerClassification(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the type of the owner of the meter.<br>0x30�FNot specified 0x31�FElectric utility company 0x32�FPrivate sector company 0x33�FIndividual
		 */
		protected void onGetOwnerClassification(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the configuration regarding the phases and wires of the system.<br>Single-phase, two-wire system�F 0x30 Single-phase, three-wire system�F 0x31 Three-phase, three-wire system�F 0x32 Three-phase, four-wire system�F 0x33
		 */
		protected void onGetConfigurationInformationOfPhasesAndWiresOfTheSystems(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the composite transformation ratio using a 6-digit decimal notation number (initial value = 1).<br>0x00000000-0x000F423F (000000-999999)
		 */
		protected void onGetCompositeTransformationRatio(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the multiplying factor for the composite transformation ratio.<br>0x00�F�~1(initial value) 0x01�F�~0.1 0x02�F�~0.01 0x03�F�~0.001
		 */
		protected void onGetMultiplyingFactorForCompositeTransformationRatio(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the type-certified meter number using alphanumeric characters (0x20-0x70).<br>Type-certified meter (type number): 0000-0��������- 9999-9�������� Non-type certified meter: FFFFFFFFFF (initial value)
		 */
		protected void onGetMeterTypeCertificationNumberTypeApprovalNumberInJapan(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates, in the form of an ASCII code, the month and year in which the verification of the meter will expire.<br>YYYYMM YYYY (Year), MM (Month)
		 */
		protected void onSetVerificationExpirationDate(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates, in the form of an ASCII code, the month and year in which the verification of the meter will expire.<br>YYYYMM YYYY (Year), MM (Month)
		 */
		protected void onGetVerificationExpirationDate(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)
		 */
		protected void onGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>0x00: 1kWh 0x01: 0.1kWh 0x02: 0.01kWh 0x03: 0.001kWh (Initial value) 0x04: 0.0001kWh 0x0A: 10kWh 0x0B: 100kWh 0x0C: 1000kWh 0x0D: 10000kWh
		 */
		protected void onGetUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063: 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)
		 */
		protected void onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)
		 */
		protected void onGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063: 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)
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
		protected void onGetMeasuredInstantaneousAmountOfElectricEnergy(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured effective instantaneous R and T phase currents in amperes. In the case of a single-phase, two-wire system, 0x7FFE shall be used for the T phase.<br>0x8001-0x7FFD�iR phase�j : 0x8001-0x7FFD�iT phase�j (-3,276.7-3,276.5): (-3,276.7-3,276.5)
		 */
		protected void onGetMeasuredInstantaneousCurrents(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a single-phase, two-wire system, 0xFFFE shall be used for the S(N)-T voltage.<br>0x0000-0xFFFD (between R and S(N))�F 0x0000-0xFFFD (between S(N) and T) (0-6,553.3) : (0-6,553.3)
		 */
		protected void onGetMeasuredInstantaneousVoltages(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * This property indicates the electric energy meter type.<br>0x30�FElectric utility company 0x31�FSolar power 0x32�FFuel cell 0x33�FBattery 0x34�FEV 0x35�FOthers
		 */
		public Setter reqSetElectricEnergyMeterClassification(byte[] edt);
		/**
		 * This property indicates the type of the owner of the meter.<br>0x30�FNot specified 0x31�FElectric utility company 0x32�FPrivate sector company 0x33�FIndividual
		 */
		public Setter reqSetOwnerClassification(byte[] edt);
		/**
		 * This property indicates, in the form of an ASCII code, the month and year in which the verification of the meter will expire.<br>YYYYMM YYYY (Year), MM (Month)
		 */
		public Setter reqSetVerificationExpirationDate(byte[] edt);
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
		public Setter reqSetElectricEnergyMeterClassification(byte[] edt) {
			addProperty(EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION, edt, setElectricEnergyMeterClassification(edt));
			return this;
		}
		@Override
		public Setter reqSetOwnerClassification(byte[] edt) {
			addProperty(EPC_OWNER_CLASSIFICATION, edt, setOwnerClassification(edt));
			return this;
		}
		@Override
		public Setter reqSetVerificationExpirationDate(byte[] edt) {
			addProperty(EPC_VERIFICATION_EXPIRATION_DATE, edt, setVerificationExpirationDate(edt));
			return this;
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
		 * This property indicates the electric energy meter type.<br>0x30�FElectric utility company 0x31�FSolar power 0x32�FFuel cell 0x33�FBattery 0x34�FEV 0x35�FOthers
		 */
		public Getter reqGetElectricEnergyMeterClassification();
		/**
		 * This property indicates the type of the owner of the meter.<br>0x30�FNot specified 0x31�FElectric utility company 0x32�FPrivate sector company 0x33�FIndividual
		 */
		public Getter reqGetOwnerClassification();
		/**
		 * This property indicates the configuration regarding the phases and wires of the system.<br>Single-phase, two-wire system�F 0x30 Single-phase, three-wire system�F 0x31 Three-phase, three-wire system�F 0x32 Three-phase, four-wire system�F 0x33
		 */
		public Getter reqGetConfigurationInformationOfPhasesAndWiresOfTheSystems();
		/**
		 * This property indicates the composite transformation ratio using a 6-digit decimal notation number (initial value = 1).<br>0x00000000-0x000F423F (000000-999999)
		 */
		public Getter reqGetCompositeTransformationRatio();
		/**
		 * This property indicates the multiplying factor for the composite transformation ratio.<br>0x00�F�~1(initial value) 0x01�F�~0.1 0x02�F�~0.01 0x03�F�~0.001
		 */
		public Getter reqGetMultiplyingFactorForCompositeTransformationRatio();
		/**
		 * This property indicates the type-certified meter number using alphanumeric characters (0x20-0x70).<br>Type-certified meter (type number): 0000-0��������- 9999-9�������� Non-type certified meter: FFFFFFFFFF (initial value)
		 */
		public Getter reqGetMeterTypeCertificationNumberTypeApprovalNumberInJapan();
		/**
		 * This property indicates, in the form of an ASCII code, the month and year in which the verification of the meter will expire.<br>YYYYMM YYYY (Year), MM (Month)
		 */
		public Getter reqGetVerificationExpirationDate();
		/**
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)
		 */
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
		/**
		 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>0x00: 1kWh 0x01: 0.1kWh 0x02: 0.01kWh 0x03: 0.001kWh (Initial value) 0x04: 0.0001kWh 0x0A: 10kWh 0x0B: 100kWh 0x0C: 1000kWh 0x0D: 10000kWh
		 */
		public Getter reqGetUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections();
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063: 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)
		 */
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection();
		/**
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)
		 */
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection();
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063: 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)
		 */
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection();
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days
		 */
		public Getter reqGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved();
		/**
		 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br>0x80000001-0x7FFFFFFD (-2,147,483,647- 2,147,483,645)
		 */
		public Getter reqGetMeasuredInstantaneousAmountOfElectricEnergy();
		/**
		 * This property indicates the measured effective instantaneous R and T phase currents in amperes. In the case of a single-phase, two-wire system, 0x7FFE shall be used for the T phase.<br>0x8001-0x7FFD�iR phase�j : 0x8001-0x7FFD�iT phase�j (-3,276.7-3,276.5): (-3,276.7-3,276.5)
		 */
		public Getter reqGetMeasuredInstantaneousCurrents();
		/**
		 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a single-phase, two-wire system, 0xFFFE shall be used for the S(N)-T voltage.<br>0x0000-0xFFFD (between R and S(N))�F 0x0000-0xFFFD (between S(N) and T) (0-6,553.3) : (0-6,553.3)
		 */
		public Getter reqGetMeasuredInstantaneousVoltages();

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
		public Getter reqGetElectricEnergyMeterClassification() {
			byte[] edt = getElectricEnergyMeterClassification();
			addProperty(EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOwnerClassification() {
			byte[] edt = getOwnerClassification();
			addProperty(EPC_OWNER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetConfigurationInformationOfPhasesAndWiresOfTheSystems() {
			byte[] edt = getConfigurationInformationOfPhasesAndWiresOfTheSystems();
			addProperty(EPC_CONFIGURATION_INFORMATION_OF_PHASES_AND_WIRES_OF_THE_SYSTEMS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetCompositeTransformationRatio() {
			byte[] edt = getCompositeTransformationRatio();
			addProperty(EPC_COMPOSITE_TRANSFORMATION_RATIO, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetMultiplyingFactorForCompositeTransformationRatio() {
			byte[] edt = getMultiplyingFactorForCompositeTransformationRatio();
			addProperty(EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeterTypeCertificationNumberTypeApprovalNumberInJapan() {
			byte[] edt = getMeterTypeCertificationNumberTypeApprovalNumberInJapan();
			addProperty(EPC_METER_TYPE_CERTIFICATION_NUMBER_TYPE_APPROVAL_NUMBER_IN_JAPAN, edt, (edt != null && (edt.length == 10)));
			return this;
		}
		@Override
		public Getter reqGetVerificationExpirationDate() {
			byte[] edt = getVerificationExpirationDate();
			addProperty(EPC_VERIFICATION_EXPIRATION_DATE, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection() {
			byte[] edt = getMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections() {
			byte[] edt = getUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections();
			addProperty(EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection() {
			byte[] edt = getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection();
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION, edt, (edt != null && (edt.length == 194)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection() {
			byte[] edt = getMeasuredCumulativeAmountOfElectricEnergyReverseDirection();
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION, edt, (edt != null && (edt.length == 4)));
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
		public Getter reqGetMeasuredInstantaneousAmountOfElectricEnergy() {
			byte[] edt = getMeasuredInstantaneousAmountOfElectricEnergy();
			addProperty(EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRIC_ENERGY, edt, (edt != null && (edt.length == 4)));
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
		 * This property indicates the electric energy meter type.<br>0x30�FElectric utility company 0x31�FSolar power 0x32�FFuel cell 0x33�FBattery 0x34�FEV 0x35�FOthers
		 */
		public Informer reqInformElectricEnergyMeterClassification();
		/**
		 * This property indicates the type of the owner of the meter.<br>0x30�FNot specified 0x31�FElectric utility company 0x32�FPrivate sector company 0x33�FIndividual
		 */
		public Informer reqInformOwnerClassification();
		/**
		 * This property indicates the configuration regarding the phases and wires of the system.<br>Single-phase, two-wire system�F 0x30 Single-phase, three-wire system�F 0x31 Three-phase, three-wire system�F 0x32 Three-phase, four-wire system�F 0x33
		 */
		public Informer reqInformConfigurationInformationOfPhasesAndWiresOfTheSystems();
		/**
		 * This property indicates the composite transformation ratio using a 6-digit decimal notation number (initial value = 1).<br>0x00000000-0x000F423F (000000-999999)
		 */
		public Informer reqInformCompositeTransformationRatio();
		/**
		 * This property indicates the multiplying factor for the composite transformation ratio.<br>0x00�F�~1(initial value) 0x01�F�~0.1 0x02�F�~0.01 0x03�F�~0.001
		 */
		public Informer reqInformMultiplyingFactorForCompositeTransformationRatio();
		/**
		 * This property indicates the type-certified meter number using alphanumeric characters (0x20-0x70).<br>Type-certified meter (type number): 0000-0��������- 9999-9�������� Non-type certified meter: FFFFFFFFFF (initial value)
		 */
		public Informer reqInformMeterTypeCertificationNumberTypeApprovalNumberInJapan();
		/**
		 * This property indicates, in the form of an ASCII code, the month and year in which the verification of the meter will expire.<br>YYYYMM YYYY (Year), MM (Month)
		 */
		public Informer reqInformVerificationExpirationDate();
		/**
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)
		 */
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
		/**
		 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>0x00: 1kWh 0x01: 0.1kWh 0x02: 0.01kWh 0x03: 0.001kWh (Initial value) 0x04: 0.0001kWh 0x0A: 10kWh 0x0B: 100kWh 0x0C: 1000kWh 0x0D: 10000kWh
		 */
		public Informer reqInformUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections();
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063: 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)
		 */
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection();
		/**
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>0x00000000-0x05F5E0FF (0-99,999,999)
		 */
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyReverseDirection();
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063: 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)
		 */
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection();
		/**
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1  . 99: previous day . day that precedes the current day by 99 days
		 */
		public Informer reqInformDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved();
		/**
		 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br>0x80000001-0x7FFFFFFD (-2,147,483,647- 2,147,483,645)
		 */
		public Informer reqInformMeasuredInstantaneousAmountOfElectricEnergy();
		/**
		 * This property indicates the measured effective instantaneous R and T phase currents in amperes. In the case of a single-phase, two-wire system, 0x7FFE shall be used for the T phase.<br>0x8001-0x7FFD�iR phase�j : 0x8001-0x7FFD�iT phase�j (-3,276.7-3,276.5): (-3,276.7-3,276.5)
		 */
		public Informer reqInformMeasuredInstantaneousCurrents();
		/**
		 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a single-phase, two-wire system, 0xFFFE shall be used for the S(N)-T voltage.<br>0x0000-0xFFFD (between R and S(N))�F 0x0000-0xFFFD (between S(N) and T) (0-6,553.3) : (0-6,553.3)
		 */
		public Informer reqInformMeasuredInstantaneousVoltages();

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
		public Informer reqInformElectricEnergyMeterClassification() {
			byte[] edt = getElectricEnergyMeterClassification();
			addProperty(EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOwnerClassification() {
			byte[] edt = getOwnerClassification();
			addProperty(EPC_OWNER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformConfigurationInformationOfPhasesAndWiresOfTheSystems() {
			byte[] edt = getConfigurationInformationOfPhasesAndWiresOfTheSystems();
			addProperty(EPC_CONFIGURATION_INFORMATION_OF_PHASES_AND_WIRES_OF_THE_SYSTEMS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformCompositeTransformationRatio() {
			byte[] edt = getCompositeTransformationRatio();
			addProperty(EPC_COMPOSITE_TRANSFORMATION_RATIO, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformMultiplyingFactorForCompositeTransformationRatio() {
			byte[] edt = getMultiplyingFactorForCompositeTransformationRatio();
			addProperty(EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeterTypeCertificationNumberTypeApprovalNumberInJapan() {
			byte[] edt = getMeterTypeCertificationNumberTypeApprovalNumberInJapan();
			addProperty(EPC_METER_TYPE_CERTIFICATION_NUMBER_TYPE_APPROVAL_NUMBER_IN_JAPAN, edt, (edt != null && (edt.length == 10)));
			return this;
		}
		@Override
		public Informer reqInformVerificationExpirationDate() {
			byte[] edt = getVerificationExpirationDate();
			addProperty(EPC_VERIFICATION_EXPIRATION_DATE, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyNormalDirection() {
			byte[] edt = getMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections() {
			byte[] edt = getUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections();
			addProperty(EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection() {
			byte[] edt = getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection();
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION, edt, (edt != null && (edt.length == 194)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyReverseDirection() {
			byte[] edt = getMeasuredCumulativeAmountOfElectricEnergyReverseDirection();
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION, edt, (edt != null && (edt.length == 4)));
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
		public Informer reqInformMeasuredInstantaneousAmountOfElectricEnergy() {
			byte[] edt = getMeasuredInstantaneousAmountOfElectricEnergy();
			addProperty(EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRIC_ENERGY, edt, (edt != null && (edt.length == 4)));
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
