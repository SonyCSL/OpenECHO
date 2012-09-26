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

public abstract class SmartGasMeter extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = SmartGasMeter.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x89;

	protected static final byte EPC_GAS_METER_CLASSIFICATION = (byte)0xE0;
	protected static final byte EPC_OWNER_CLASSIFICATION = (byte)0xE1;
	protected static final byte EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION = (byte)0xE2;
	protected static final byte EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS = (byte)0xE3;
	protected static final byte EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS = (byte)0xE4;
	protected static final byte EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED = (byte)0xE5;
	protected static final byte EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA = (byte)0xE6;
	protected static final byte EPC_SECURITY_DATA_INFORMATION = (byte)0xE7;
	protected static final byte EPC_VALVE_CLOSURE_BY_THE_CENTER = (byte)0xE8;
	protected static final byte EPC_PERMISSION_FROM_THE_CENTER_TO_REOPEN_THE_VALVE_CLOSED_BY_THE_CENTER = (byte)0xE9;
	protected static final byte EPC_EMERGENCY_CLOSURE_OF_SHUTOFF_VALVE = (byte)0xEA;
	protected static final byte EPC_SHUTOFF_VALVE_STATUS = (byte)0xEB;
	protected static final byte EPC_HISTORICAL_DATA_OF_SHUTOFF_REASONS = (byte)0xEC;
	protected static final byte EPC_ID_NUMBER_SETTING = (byte)0xED;
	protected static final byte EPC_VERIFICATION_EXPIRATION_INFORMATION = (byte)0xEE;


	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates the type of the gas meter.<br>0x30�Fcity gas 0x31�FLP gas 0x32�Fnatural gas 0x33�Fothers
	 */
	protected boolean setGasMeterClassification(byte[] edt) {return false;}
	/**
	 * This property indicates the type of the gas meter.<br>0x30�Fcity gas 0x31�FLP gas 0x32�Fnatural gas 0x33�Fothers
	 */
	protected byte[] getGasMeterClassification() {return null;}
	/**
	 * This property indicates the type of the owner of the meter.<br>0x30�Fnot specified 0x31�Fcity gas 0x32�FLP gas 0x33�Fprivate-sector company 0x34�Findividual
	 */
	protected boolean setOwnerClassification(byte[] edt) {return false;}
	/**
	 * This property indicates the type of the owner of the meter.<br>0x30�Fnot specified 0x31�Fcity gas 0x32�FLP gas 0x33�Fprivate-sector company 0x34�Findividual
	 */
	protected byte[] getOwnerClassification() {return null;}
	/**
	 * This property indicates the measured cumulative gas consumption in m3.<br>0-0x3B9AC9FF (0-999,999,999�j
	 */
	protected abstract byte[] getMeasuredCumulativeGasConsumption();
	/**
	 * This property indicates the unit (multiplying factor) for the measured cumulative gas consumption and the historical data of measured cumulative gas consumptions.<br>0x00: 1��3 0x01: 0.1��3 0x02: 0.01��3 0x03: 0.001��3�iinitial value�j 0x04: 0.0001��3 0x05: 0.00001��3 0x06: 0.000001��3
	 */
	protected abstract byte[] getUnitForMeasuredCumulativeGasConsumptions();
	/**
	 * This property indicates the day for which the historical data of measured cumulative gas consumptions is to be retrieved and the historical data of measured cumulative gas consumptions, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063: 0x0-0x3B9AC9FF (0-99) : (0-999,999.999�j
	 */
	protected byte[] getHistoricalDataOfMeasuredCumulativeGasConsumptions() {return null;}
	/**
	 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1 - 99: previous day - day that precedes the current day by 99 days
	 */
	protected boolean setDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(byte[] edt) {return false;}
	/**
	 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1 - 99: previous day - day that precedes the current day by 99 days
	 */
	protected byte[] getDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved() {return null;}
	/**
	 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>Abnormal value detected: 0x41 No abnormal value detected: 0x42
	 */
	protected byte[] getDetectionOfAbnormalValueInMeteringData() {return null;}
	/**
	 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>For details, refer to the explanations under (9).
	 */
	protected byte[] getSecurityDataInformation() {return null;}
	/**
	 * This property indicates whether the Center has closed the gas shutoff valve of the meter.<br>Center has closed the valve: 0x41 Center has not closed the valve: 0x42
	 */
	protected byte[] getValveClosureByTheCenter() {return null;}
	/**
	 * This property indicates whether permission has been given by the Center to reopen the gas shutoff valve of the meter closed by the Center.<br>Permission has been given by the Center to reopen the gas shutoff valve closed by the Center: 0x41 Permission to reopen the gas shutoff valve closed by the Center has not been given by the Center: 0x42
	 */
	protected byte[] getPermissionFromTheCenterToReopenTheValveClosedByTheCenter() {return null;}
	/**
	 * This property indicates whether the gas shutoff valve of the meter has been closed in response to an emergency.<br>Emergency closure of the shutoff valve has occurred: 0x41 No emergency closure of the shutoff valve has occurred: 0x42
	 */
	protected byte[] getEmergencyClosureOfShutoffValve() {return null;}
	/**
	 * This property indicates whether the shutoff valve is open or closed.<br>Shutoff valve open: 0x41 Shutoff valve closed: 0x42
	 */
	protected byte[] getShutoffValveStatus() {return null;}
	/**
	 * This property indicates the reasons for the 3 past shutoff valve-based gas shutoffs by means of bit assignment with one byte used for each of the 3 shutoff reasons. Historical data3�FHistorical data2�FHistorical data 1<br>0xFF: 0xFF: 0xFF
	 */
	protected byte[] getHistoricalDataOfShutoffReasons() {return null;}
	/**
	 * This property indicates the ID number of the meter.<br>000000-FFFFFF �iInitial .value .: .�g000000�h�j
	 */
	protected boolean setIdNumberSetting(byte[] edt) {return false;}
	/**
	 * This property indicates the ID number of the meter.<br>000000-FFFFFF �iInitial .value .: .�g000000�h�j
	 */
	protected byte[] getIdNumberSetting() {return null;}
	/**
	 * This property indicates the month and year in which the verification of the meter will expire.<br>YYYYMM YYYY�iYear�j�CMM�iMonth�j
	 */
	protected boolean setVerificationExpirationInformation(byte[] edt) {return false;}
	/**
	 * This property indicates the month and year in which the verification of the meter will expire.<br>YYYYMM YYYY�iYear�j�CMM�iMonth�j
	 */
	protected byte[] getVerificationExpirationInformation() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_GAS_METER_CLASSIFICATION:
			res.addProperty(epc, edt, setGasMeterClassification(edt));
			break;
		case EPC_OWNER_CLASSIFICATION:
			res.addProperty(epc, edt, setOwnerClassification(edt));
			break;
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED:
			res.addProperty(epc, edt, setDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(edt));
			break;
		case EPC_ID_NUMBER_SETTING:
			res.addProperty(epc, edt, setIdNumberSetting(edt));
			break;
		case EPC_VERIFICATION_EXPIRATION_INFORMATION:
			res.addProperty(epc, edt, setVerificationExpirationInformation(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_GAS_METER_CLASSIFICATION:
			edt = getGasMeterClassification();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OWNER_CLASSIFICATION:
			edt = getOwnerClassification();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION:
			edt = getMeasuredCumulativeGasConsumption();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS:
			edt = getUnitForMeasuredCumulativeGasConsumptions();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS:
			edt = getHistoricalDataOfMeasuredCumulativeGasConsumptions();
			res.addProperty(epc, edt, (edt != null && (edt.length == 194)));
			break;
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED:
			edt = getDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA:
			edt = getDetectionOfAbnormalValueInMeteringData();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SECURITY_DATA_INFORMATION:
			edt = getSecurityDataInformation();
			res.addProperty(epc, edt, (edt != null && (edt.length == 10)));
			break;
		case EPC_VALVE_CLOSURE_BY_THE_CENTER:
			edt = getValveClosureByTheCenter();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_PERMISSION_FROM_THE_CENTER_TO_REOPEN_THE_VALVE_CLOSED_BY_THE_CENTER:
			edt = getPermissionFromTheCenterToReopenTheValveClosedByTheCenter();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_EMERGENCY_CLOSURE_OF_SHUTOFF_VALVE:
			edt = getEmergencyClosureOfShutoffValve();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SHUTOFF_VALVE_STATUS:
			edt = getShutoffValveStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HISTORICAL_DATA_OF_SHUTOFF_REASONS:
			edt = getHistoricalDataOfShutoffReasons();
			res.addProperty(epc, edt, (edt != null && (edt.length == 3)));
			break;
		case EPC_ID_NUMBER_SETTING:
			edt = getIdNumberSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 6)));
			break;
		case EPC_VERIFICATION_EXPIRATION_INFORMATION:
			edt = getVerificationExpirationInformation();
			res.addProperty(epc, edt, (edt != null && (edt.length == 6)));
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
			case EPC_GAS_METER_CLASSIFICATION:
				onSetGasMeterClassification(eoj, tid, (pdc != 0));
				break;
			case EPC_OWNER_CLASSIFICATION:
				onSetOwnerClassification(eoj, tid, (pdc != 0));
				break;
			case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED:
				onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(eoj, tid, (pdc != 0));
				break;
			case EPC_ID_NUMBER_SETTING:
				onSetIdNumberSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_VERIFICATION_EXPIRATION_INFORMATION:
				onSetVerificationExpirationInformation(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_GAS_METER_CLASSIFICATION:
				onGetGasMeterClassification(eoj, tid, pdc, edt);
				break;
			case EPC_OWNER_CLASSIFICATION:
				onGetOwnerClassification(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION:
				onGetMeasuredCumulativeGasConsumption(eoj, tid, pdc, edt);
				break;
			case EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS:
				onGetUnitForMeasuredCumulativeGasConsumptions(eoj, tid, pdc, edt);
				break;
			case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS:
				onGetHistoricalDataOfMeasuredCumulativeGasConsumptions(eoj, tid, pdc, edt);
				break;
			case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED:
				onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(eoj, tid, pdc, edt);
				break;
			case EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA:
				onGetDetectionOfAbnormalValueInMeteringData(eoj, tid, pdc, edt);
				break;
			case EPC_SECURITY_DATA_INFORMATION:
				onGetSecurityDataInformation(eoj, tid, pdc, edt);
				break;
			case EPC_VALVE_CLOSURE_BY_THE_CENTER:
				onGetValveClosureByTheCenter(eoj, tid, pdc, edt);
				break;
			case EPC_PERMISSION_FROM_THE_CENTER_TO_REOPEN_THE_VALVE_CLOSED_BY_THE_CENTER:
				onGetPermissionFromTheCenterToReopenTheValveClosedByTheCenter(eoj, tid, pdc, edt);
				break;
			case EPC_EMERGENCY_CLOSURE_OF_SHUTOFF_VALVE:
				onGetEmergencyClosureOfShutoffValve(eoj, tid, pdc, edt);
				break;
			case EPC_SHUTOFF_VALVE_STATUS:
				onGetShutoffValveStatus(eoj, tid, pdc, edt);
				break;
			case EPC_HISTORICAL_DATA_OF_SHUTOFF_REASONS:
				onGetHistoricalDataOfShutoffReasons(eoj, tid, pdc, edt);
				break;
			case EPC_ID_NUMBER_SETTING:
				onGetIdNumberSetting(eoj, tid, pdc, edt);
				break;
			case EPC_VERIFICATION_EXPIRATION_INFORMATION:
				onGetVerificationExpirationInformation(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates the type of the gas meter.<br>0x30�Fcity gas 0x31�FLP gas 0x32�Fnatural gas 0x33�Fothers
		 */
		protected void onSetGasMeterClassification(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the type of the gas meter.<br>0x30�Fcity gas 0x31�FLP gas 0x32�Fnatural gas 0x33�Fothers
		 */
		protected void onGetGasMeterClassification(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the type of the owner of the meter.<br>0x30�Fnot specified 0x31�Fcity gas 0x32�FLP gas 0x33�Fprivate-sector company 0x34�Findividual
		 */
		protected void onSetOwnerClassification(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the type of the owner of the meter.<br>0x30�Fnot specified 0x31�Fcity gas 0x32�FLP gas 0x33�Fprivate-sector company 0x34�Findividual
		 */
		protected void onGetOwnerClassification(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured cumulative gas consumption in m3.<br>0-0x3B9AC9FF (0-999,999,999�j
		 */
		protected void onGetMeasuredCumulativeGasConsumption(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the unit (multiplying factor) for the measured cumulative gas consumption and the historical data of measured cumulative gas consumptions.<br>0x00: 1��3 0x01: 0.1��3 0x02: 0.01��3 0x03: 0.001��3�iinitial value�j 0x04: 0.0001��3 0x05: 0.00001��3 0x06: 0.000001��3
		 */
		protected void onGetUnitForMeasuredCumulativeGasConsumptions(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions is to be retrieved and the historical data of measured cumulative gas consumptions, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063: 0x0-0x3B9AC9FF (0-99) : (0-999,999.999�j
		 */
		protected void onGetHistoricalDataOfMeasuredCumulativeGasConsumptions(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1 - 99: previous day - day that precedes the current day by 99 days
		 */
		protected void onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1 - 99: previous day - day that precedes the current day by 99 days
		 */
		protected void onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>Abnormal value detected: 0x41 No abnormal value detected: 0x42
		 */
		protected void onGetDetectionOfAbnormalValueInMeteringData(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>For details, refer to the explanations under (9).
		 */
		protected void onGetSecurityDataInformation(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates whether the Center has closed the gas shutoff valve of the meter.<br>Center has closed the valve: 0x41 Center has not closed the valve: 0x42
		 */
		protected void onGetValveClosureByTheCenter(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates whether permission has been given by the Center to reopen the gas shutoff valve of the meter closed by the Center.<br>Permission has been given by the Center to reopen the gas shutoff valve closed by the Center: 0x41 Permission to reopen the gas shutoff valve closed by the Center has not been given by the Center: 0x42
		 */
		protected void onGetPermissionFromTheCenterToReopenTheValveClosedByTheCenter(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates whether the gas shutoff valve of the meter has been closed in response to an emergency.<br>Emergency closure of the shutoff valve has occurred: 0x41 No emergency closure of the shutoff valve has occurred: 0x42
		 */
		protected void onGetEmergencyClosureOfShutoffValve(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates whether the shutoff valve is open or closed.<br>Shutoff valve open: 0x41 Shutoff valve closed: 0x42
		 */
		protected void onGetShutoffValveStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the reasons for the 3 past shutoff valve-based gas shutoffs by means of bit assignment with one byte used for each of the 3 shutoff reasons. Historical data3�FHistorical data2�FHistorical data 1<br>0xFF: 0xFF: 0xFF
		 */
		protected void onGetHistoricalDataOfShutoffReasons(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the ID number of the meter.<br>000000-FFFFFF �iInitial .value .: .�g000000�h�j
		 */
		protected void onSetIdNumberSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the ID number of the meter.<br>000000-FFFFFF �iInitial .value .: .�g000000�h�j
		 */
		protected void onGetIdNumberSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br>YYYYMM YYYY�iYear�j�CMM�iMonth�j
		 */
		protected void onSetVerificationExpirationInformation(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br>YYYYMM YYYY�iYear�j�CMM�iMonth�j
		 */
		protected void onGetVerificationExpirationInformation(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * This property indicates the type of the gas meter.<br>0x30�Fcity gas 0x31�FLP gas 0x32�Fnatural gas 0x33�Fothers
		 */
		public Setter reqSetGasMeterClassification(byte[] edt);
		/**
		 * This property indicates the type of the owner of the meter.<br>0x30�Fnot specified 0x31�Fcity gas 0x32�FLP gas 0x33�Fprivate-sector company 0x34�Findividual
		 */
		public Setter reqSetOwnerClassification(byte[] edt);
		/**
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1 - 99: previous day - day that precedes the current day by 99 days
		 */
		public Setter reqSetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(byte[] edt);
		/**
		 * This property indicates the ID number of the meter.<br>000000-FFFFFF �iInitial .value .: .�g000000�h�j
		 */
		public Setter reqSetIdNumberSetting(byte[] edt);
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br>YYYYMM YYYY�iYear�j�CMM�iMonth�j
		 */
		public Setter reqSetVerificationExpirationInformation(byte[] edt);

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
		public Setter reqSetGasMeterClassification(byte[] edt) {
			addProperty(EPC_GAS_METER_CLASSIFICATION, edt, setGasMeterClassification(edt));
			return this;
		}
		@Override
		public Setter reqSetOwnerClassification(byte[] edt) {
			addProperty(EPC_OWNER_CLASSIFICATION, edt, setOwnerClassification(edt));
			return this;
		}
		@Override
		public Setter reqSetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(byte[] edt) {
			addProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED, edt, setDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(edt));
			return this;
		}
		@Override
		public Setter reqSetIdNumberSetting(byte[] edt) {
			addProperty(EPC_ID_NUMBER_SETTING, edt, setIdNumberSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetVerificationExpirationInformation(byte[] edt) {
			addProperty(EPC_VERIFICATION_EXPIRATION_INFORMATION, edt, setVerificationExpirationInformation(edt));
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
		public Setter reqSetGasMeterClassification(byte[] edt) {
			addProperty(EPC_GAS_METER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOwnerClassification(byte[] edt) {
			addProperty(EPC_OWNER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(byte[] edt) {
			addProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetIdNumberSetting(byte[] edt) {
			addProperty(EPC_ID_NUMBER_SETTING, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Setter reqSetVerificationExpirationInformation(byte[] edt) {
			addProperty(EPC_VERIFICATION_EXPIRATION_INFORMATION, edt, (edt != null && (edt.length == 6)));
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
		 * This property indicates the type of the gas meter.<br>0x30�Fcity gas 0x31�FLP gas 0x32�Fnatural gas 0x33�Fothers
		 */
		public Getter reqGetGasMeterClassification();
		/**
		 * This property indicates the type of the owner of the meter.<br>0x30�Fnot specified 0x31�Fcity gas 0x32�FLP gas 0x33�Fprivate-sector company 0x34�Findividual
		 */
		public Getter reqGetOwnerClassification();
		/**
		 * This property indicates the measured cumulative gas consumption in m3.<br>0-0x3B9AC9FF (0-999,999,999�j
		 */
		public Getter reqGetMeasuredCumulativeGasConsumption();
		/**
		 * This property indicates the unit (multiplying factor) for the measured cumulative gas consumption and the historical data of measured cumulative gas consumptions.<br>0x00: 1��3 0x01: 0.1��3 0x02: 0.01��3 0x03: 0.001��3�iinitial value�j 0x04: 0.0001��3 0x05: 0.00001��3 0x06: 0.000001��3
		 */
		public Getter reqGetUnitForMeasuredCumulativeGasConsumptions();
		/**
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions is to be retrieved and the historical data of measured cumulative gas consumptions, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063: 0x0-0x3B9AC9FF (0-99) : (0-999,999.999�j
		 */
		public Getter reqGetHistoricalDataOfMeasuredCumulativeGasConsumptions();
		/**
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1 - 99: previous day - day that precedes the current day by 99 days
		 */
		public Getter reqGetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved();
		/**
		 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>Abnormal value detected: 0x41 No abnormal value detected: 0x42
		 */
		public Getter reqGetDetectionOfAbnormalValueInMeteringData();
		/**
		 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>For details, refer to the explanations under (9).
		 */
		public Getter reqGetSecurityDataInformation();
		/**
		 * This property indicates whether the Center has closed the gas shutoff valve of the meter.<br>Center has closed the valve: 0x41 Center has not closed the valve: 0x42
		 */
		public Getter reqGetValveClosureByTheCenter();
		/**
		 * This property indicates whether permission has been given by the Center to reopen the gas shutoff valve of the meter closed by the Center.<br>Permission has been given by the Center to reopen the gas shutoff valve closed by the Center: 0x41 Permission to reopen the gas shutoff valve closed by the Center has not been given by the Center: 0x42
		 */
		public Getter reqGetPermissionFromTheCenterToReopenTheValveClosedByTheCenter();
		/**
		 * This property indicates whether the gas shutoff valve of the meter has been closed in response to an emergency.<br>Emergency closure of the shutoff valve has occurred: 0x41 No emergency closure of the shutoff valve has occurred: 0x42
		 */
		public Getter reqGetEmergencyClosureOfShutoffValve();
		/**
		 * This property indicates whether the shutoff valve is open or closed.<br>Shutoff valve open: 0x41 Shutoff valve closed: 0x42
		 */
		public Getter reqGetShutoffValveStatus();
		/**
		 * This property indicates the reasons for the 3 past shutoff valve-based gas shutoffs by means of bit assignment with one byte used for each of the 3 shutoff reasons. Historical data3�FHistorical data2�FHistorical data 1<br>0xFF: 0xFF: 0xFF
		 */
		public Getter reqGetHistoricalDataOfShutoffReasons();
		/**
		 * This property indicates the ID number of the meter.<br>000000-FFFFFF �iInitial .value .: .�g000000�h�j
		 */
		public Getter reqGetIdNumberSetting();
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br>YYYYMM YYYY�iYear�j�CMM�iMonth�j
		 */
		public Getter reqGetVerificationExpirationInformation();

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
		public Getter reqGetGasMeterClassification() {
			byte[] edt = getGasMeterClassification();
			addProperty(EPC_GAS_METER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOwnerClassification() {
			byte[] edt = getOwnerClassification();
			addProperty(EPC_OWNER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeGasConsumption() {
			byte[] edt = getMeasuredCumulativeGasConsumption();
			addProperty(EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetUnitForMeasuredCumulativeGasConsumptions() {
			byte[] edt = getUnitForMeasuredCumulativeGasConsumptions();
			addProperty(EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHistoricalDataOfMeasuredCumulativeGasConsumptions() {
			byte[] edt = getHistoricalDataOfMeasuredCumulativeGasConsumptions();
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS, edt, (edt != null && (edt.length == 194)));
			return this;
		}
		@Override
		public Getter reqGetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved() {
			byte[] edt = getDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved();
			addProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetDetectionOfAbnormalValueInMeteringData() {
			byte[] edt = getDetectionOfAbnormalValueInMeteringData();
			addProperty(EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSecurityDataInformation() {
			byte[] edt = getSecurityDataInformation();
			addProperty(EPC_SECURITY_DATA_INFORMATION, edt, (edt != null && (edt.length == 10)));
			return this;
		}
		@Override
		public Getter reqGetValveClosureByTheCenter() {
			byte[] edt = getValveClosureByTheCenter();
			addProperty(EPC_VALVE_CLOSURE_BY_THE_CENTER, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetPermissionFromTheCenterToReopenTheValveClosedByTheCenter() {
			byte[] edt = getPermissionFromTheCenterToReopenTheValveClosedByTheCenter();
			addProperty(EPC_PERMISSION_FROM_THE_CENTER_TO_REOPEN_THE_VALVE_CLOSED_BY_THE_CENTER, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetEmergencyClosureOfShutoffValve() {
			byte[] edt = getEmergencyClosureOfShutoffValve();
			addProperty(EPC_EMERGENCY_CLOSURE_OF_SHUTOFF_VALVE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetShutoffValveStatus() {
			byte[] edt = getShutoffValveStatus();
			addProperty(EPC_SHUTOFF_VALVE_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHistoricalDataOfShutoffReasons() {
			byte[] edt = getHistoricalDataOfShutoffReasons();
			addProperty(EPC_HISTORICAL_DATA_OF_SHUTOFF_REASONS, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Getter reqGetIdNumberSetting() {
			byte[] edt = getIdNumberSetting();
			addProperty(EPC_ID_NUMBER_SETTING, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Getter reqGetVerificationExpirationInformation() {
			byte[] edt = getVerificationExpirationInformation();
			addProperty(EPC_VERIFICATION_EXPIRATION_INFORMATION, edt, (edt != null && (edt.length == 6)));
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
		public Getter reqGetGasMeterClassification() {
			addProperty(EPC_GAS_METER_CLASSIFICATION);
			return this;
		}
		@Override
		public Getter reqGetOwnerClassification() {
			addProperty(EPC_OWNER_CLASSIFICATION);
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeGasConsumption() {
			addProperty(EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION);
			return this;
		}
		@Override
		public Getter reqGetUnitForMeasuredCumulativeGasConsumptions() {
			addProperty(EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS);
			return this;
		}
		@Override
		public Getter reqGetHistoricalDataOfMeasuredCumulativeGasConsumptions() {
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS);
			return this;
		}
		@Override
		public Getter reqGetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved() {
			addProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED);
			return this;
		}
		@Override
		public Getter reqGetDetectionOfAbnormalValueInMeteringData() {
			addProperty(EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA);
			return this;
		}
		@Override
		public Getter reqGetSecurityDataInformation() {
			addProperty(EPC_SECURITY_DATA_INFORMATION);
			return this;
		}
		@Override
		public Getter reqGetValveClosureByTheCenter() {
			addProperty(EPC_VALVE_CLOSURE_BY_THE_CENTER);
			return this;
		}
		@Override
		public Getter reqGetPermissionFromTheCenterToReopenTheValveClosedByTheCenter() {
			addProperty(EPC_PERMISSION_FROM_THE_CENTER_TO_REOPEN_THE_VALVE_CLOSED_BY_THE_CENTER);
			return this;
		}
		@Override
		public Getter reqGetEmergencyClosureOfShutoffValve() {
			addProperty(EPC_EMERGENCY_CLOSURE_OF_SHUTOFF_VALVE);
			return this;
		}
		@Override
		public Getter reqGetShutoffValveStatus() {
			addProperty(EPC_SHUTOFF_VALVE_STATUS);
			return this;
		}
		@Override
		public Getter reqGetHistoricalDataOfShutoffReasons() {
			addProperty(EPC_HISTORICAL_DATA_OF_SHUTOFF_REASONS);
			return this;
		}
		@Override
		public Getter reqGetIdNumberSetting() {
			addProperty(EPC_ID_NUMBER_SETTING);
			return this;
		}
		@Override
		public Getter reqGetVerificationExpirationInformation() {
			addProperty(EPC_VERIFICATION_EXPIRATION_INFORMATION);
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
		 * This property indicates the type of the gas meter.<br>0x30�Fcity gas 0x31�FLP gas 0x32�Fnatural gas 0x33�Fothers
		 */
		public Informer reqInformGasMeterClassification();
		/**
		 * This property indicates the type of the owner of the meter.<br>0x30�Fnot specified 0x31�Fcity gas 0x32�FLP gas 0x33�Fprivate-sector company 0x34�Findividual
		 */
		public Informer reqInformOwnerClassification();
		/**
		 * This property indicates the measured cumulative gas consumption in m3.<br>0-0x3B9AC9FF (0-999,999,999�j
		 */
		public Informer reqInformMeasuredCumulativeGasConsumption();
		/**
		 * This property indicates the unit (multiplying factor) for the measured cumulative gas consumption and the historical data of measured cumulative gas consumptions.<br>0x00: 1��3 0x01: 0.1��3 0x02: 0.01��3 0x03: 0.001��3�iinitial value�j 0x04: 0.0001��3 0x05: 0.00001��3 0x06: 0.000001��3
		 */
		public Informer reqInformUnitForMeasuredCumulativeGasConsumptions();
		/**
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions is to be retrieved and the historical data of measured cumulative gas consumptions, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0000-0x0063: 0x0-0x3B9AC9FF (0-99) : (0-999,999.999�j
		 */
		public Informer reqInformHistoricalDataOfMeasuredCumulativeGasConsumptions();
		/**
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>0x00-0x63 ( 0-99) 0: current day 1 - 99: previous day - day that precedes the current day by 99 days
		 */
		public Informer reqInformDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved();
		/**
		 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>Abnormal value detected: 0x41 No abnormal value detected: 0x42
		 */
		public Informer reqInformDetectionOfAbnormalValueInMeteringData();
		/**
		 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>For details, refer to the explanations under (9).
		 */
		public Informer reqInformSecurityDataInformation();
		/**
		 * This property indicates whether the Center has closed the gas shutoff valve of the meter.<br>Center has closed the valve: 0x41 Center has not closed the valve: 0x42
		 */
		public Informer reqInformValveClosureByTheCenter();
		/**
		 * This property indicates whether permission has been given by the Center to reopen the gas shutoff valve of the meter closed by the Center.<br>Permission has been given by the Center to reopen the gas shutoff valve closed by the Center: 0x41 Permission to reopen the gas shutoff valve closed by the Center has not been given by the Center: 0x42
		 */
		public Informer reqInformPermissionFromTheCenterToReopenTheValveClosedByTheCenter();
		/**
		 * This property indicates whether the gas shutoff valve of the meter has been closed in response to an emergency.<br>Emergency closure of the shutoff valve has occurred: 0x41 No emergency closure of the shutoff valve has occurred: 0x42
		 */
		public Informer reqInformEmergencyClosureOfShutoffValve();
		/**
		 * This property indicates whether the shutoff valve is open or closed.<br>Shutoff valve open: 0x41 Shutoff valve closed: 0x42
		 */
		public Informer reqInformShutoffValveStatus();
		/**
		 * This property indicates the reasons for the 3 past shutoff valve-based gas shutoffs by means of bit assignment with one byte used for each of the 3 shutoff reasons. Historical data3�FHistorical data2�FHistorical data 1<br>0xFF: 0xFF: 0xFF
		 */
		public Informer reqInformHistoricalDataOfShutoffReasons();
		/**
		 * This property indicates the ID number of the meter.<br>000000-FFFFFF �iInitial .value .: .�g000000�h�j
		 */
		public Informer reqInformIdNumberSetting();
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br>YYYYMM YYYY�iYear�j�CMM�iMonth�j
		 */
		public Informer reqInformVerificationExpirationInformation();

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
		public Informer reqInformGasMeterClassification() {
			byte[] edt = getGasMeterClassification();
			addProperty(EPC_GAS_METER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOwnerClassification() {
			byte[] edt = getOwnerClassification();
			addProperty(EPC_OWNER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeGasConsumption() {
			byte[] edt = getMeasuredCumulativeGasConsumption();
			addProperty(EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformUnitForMeasuredCumulativeGasConsumptions() {
			byte[] edt = getUnitForMeasuredCumulativeGasConsumptions();
			addProperty(EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHistoricalDataOfMeasuredCumulativeGasConsumptions() {
			byte[] edt = getHistoricalDataOfMeasuredCumulativeGasConsumptions();
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS, edt, (edt != null && (edt.length == 194)));
			return this;
		}
		@Override
		public Informer reqInformDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved() {
			byte[] edt = getDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved();
			addProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDetectionOfAbnormalValueInMeteringData() {
			byte[] edt = getDetectionOfAbnormalValueInMeteringData();
			addProperty(EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSecurityDataInformation() {
			byte[] edt = getSecurityDataInformation();
			addProperty(EPC_SECURITY_DATA_INFORMATION, edt, (edt != null && (edt.length == 10)));
			return this;
		}
		@Override
		public Informer reqInformValveClosureByTheCenter() {
			byte[] edt = getValveClosureByTheCenter();
			addProperty(EPC_VALVE_CLOSURE_BY_THE_CENTER, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformPermissionFromTheCenterToReopenTheValveClosedByTheCenter() {
			byte[] edt = getPermissionFromTheCenterToReopenTheValveClosedByTheCenter();
			addProperty(EPC_PERMISSION_FROM_THE_CENTER_TO_REOPEN_THE_VALVE_CLOSED_BY_THE_CENTER, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformEmergencyClosureOfShutoffValve() {
			byte[] edt = getEmergencyClosureOfShutoffValve();
			addProperty(EPC_EMERGENCY_CLOSURE_OF_SHUTOFF_VALVE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformShutoffValveStatus() {
			byte[] edt = getShutoffValveStatus();
			addProperty(EPC_SHUTOFF_VALVE_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHistoricalDataOfShutoffReasons() {
			byte[] edt = getHistoricalDataOfShutoffReasons();
			addProperty(EPC_HISTORICAL_DATA_OF_SHUTOFF_REASONS, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Informer reqInformIdNumberSetting() {
			byte[] edt = getIdNumberSetting();
			addProperty(EPC_ID_NUMBER_SETTING, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Informer reqInformVerificationExpirationInformation() {
			byte[] edt = getVerificationExpirationInformation();
			addProperty(EPC_VERIFICATION_EXPIRATION_INFORMATION, edt, (edt != null && (edt.length == 6)));
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
		public Informer reqInformGasMeterClassification() {
			addProperty(EPC_GAS_METER_CLASSIFICATION);
			return this;
		}
		@Override
		public Informer reqInformOwnerClassification() {
			addProperty(EPC_OWNER_CLASSIFICATION);
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeGasConsumption() {
			addProperty(EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION);
			return this;
		}
		@Override
		public Informer reqInformUnitForMeasuredCumulativeGasConsumptions() {
			addProperty(EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS);
			return this;
		}
		@Override
		public Informer reqInformHistoricalDataOfMeasuredCumulativeGasConsumptions() {
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS);
			return this;
		}
		@Override
		public Informer reqInformDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved() {
			addProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED);
			return this;
		}
		@Override
		public Informer reqInformDetectionOfAbnormalValueInMeteringData() {
			addProperty(EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA);
			return this;
		}
		@Override
		public Informer reqInformSecurityDataInformation() {
			addProperty(EPC_SECURITY_DATA_INFORMATION);
			return this;
		}
		@Override
		public Informer reqInformValveClosureByTheCenter() {
			addProperty(EPC_VALVE_CLOSURE_BY_THE_CENTER);
			return this;
		}
		@Override
		public Informer reqInformPermissionFromTheCenterToReopenTheValveClosedByTheCenter() {
			addProperty(EPC_PERMISSION_FROM_THE_CENTER_TO_REOPEN_THE_VALVE_CLOSED_BY_THE_CENTER);
			return this;
		}
		@Override
		public Informer reqInformEmergencyClosureOfShutoffValve() {
			addProperty(EPC_EMERGENCY_CLOSURE_OF_SHUTOFF_VALVE);
			return this;
		}
		@Override
		public Informer reqInformShutoffValveStatus() {
			addProperty(EPC_SHUTOFF_VALVE_STATUS);
			return this;
		}
		@Override
		public Informer reqInformHistoricalDataOfShutoffReasons() {
			addProperty(EPC_HISTORICAL_DATA_OF_SHUTOFF_REASONS);
			return this;
		}
		@Override
		public Informer reqInformIdNumberSetting() {
			addProperty(EPC_ID_NUMBER_SETTING);
			return this;
		}
		@Override
		public Informer reqInformVerificationExpirationInformation() {
			addProperty(EPC_VERIFICATION_EXPIRATION_INFORMATION);
			return this;
		}

	}
}
