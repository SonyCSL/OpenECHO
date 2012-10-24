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
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x89;

	public static final byte EPC_GAS_METER_CLASSIFICATION = (byte)0xE0;
	public static final byte EPC_OWNER_CLASSIFICATION = (byte)0xE1;
	public static final byte EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION = (byte)0xE2;
	public static final byte EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS = (byte)0xE3;
	public static final byte EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS = (byte)0xE4;
	public static final byte EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED = (byte)0xE5;
	public static final byte EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA = (byte)0xE6;
	public static final byte EPC_SECURITY_DATA_INFORMATION = (byte)0xE7;
	public static final byte EPC_VALVE_CLOSURE_BY_THE_CENTER = (byte)0xE8;
	public static final byte EPC_PERMISSION_FROM_THE_CENTER_TO_REOPEN_THE_VALVE_CLOSED_BY_THE_CENTER = (byte)0xE9;
	public static final byte EPC_EMERGENCY_CLOSURE_OF_SHUTOFF_VALVE = (byte)0xEA;
	public static final byte EPC_SHUTOFF_VALVE_STATUS = (byte)0xEB;
	public static final byte EPC_HISTORICAL_DATA_OF_SHUTOFF_REASONS = (byte)0xEC;
	public static final byte EPC_ID_NUMBER_SETTING = (byte)0xED;
	public static final byte EPC_VERIFICATION_EXPIRATION_INFORMATION = (byte)0xEE;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates the type of the gas meter.<br><br>0x30�Fcity gas 0x31�FLP gas 0x32�Fnatural gas 0x33�Fothers<br><br>Name : Gas meter classification<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGasMeterClassification(byte[] edt) {return false;}
	private final boolean _setGasMeterClassification(byte epc, byte[] edt) {
		boolean success = setGasMeterClassification(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the type of the gas meter.<br><br>0x30�Fcity gas 0x31�FLP gas 0x32�Fnatural gas 0x33�Fothers<br><br>Name : Gas meter classification<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGasMeterClassification() {return null;}
	private final byte[] _getGasMeterClassification(byte epc) {
		byte[] edt = getGasMeterClassification();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the type of the owner of the meter.<br><br>0x30�Fnot specified 0x31�Fcity gas 0x32�FLP gas 0x33�Fprivate-sector company 0x34�Findividual<br><br>Name : Owner classification<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOwnerClassification(byte[] edt) {return false;}
	private final boolean _setOwnerClassification(byte epc, byte[] edt) {
		boolean success = setOwnerClassification(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the type of the owner of the meter.<br><br>0x30�Fnot specified 0x31�Fcity gas 0x32�FLP gas 0x33�Fprivate-sector company 0x34�Findividual<br><br>Name : Owner classification<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOwnerClassification() {return null;}
	private final byte[] _getOwnerClassification(byte epc) {
		byte[] edt = getOwnerClassification();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured cumulative gas consumption in m3.<br><br>0-0x3B9AC9FF (0-999,999,999�j<br><br>Name : Measured cumulative gas consumption<br>EPC : 0xE2<br>Data Type : unsigned long<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getMeasuredCumulativeGasConsumption();
	private final byte[] _getMeasuredCumulativeGasConsumption(byte epc) {
		byte[] edt = getMeasuredCumulativeGasConsumption();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the unit (multiplying factor) for the measured cumulative gas consumption and the historical data of measured cumulative gas consumptions.<br><br>0x00: 1��3 0x01: 0.1��3 0x02: 0.01��3 0x03: 0.001��3�iinitial value�j 0x04: 0.0001��3 0x05: 0.00001��3 0x06: 0.000001��3<br><br>Name : Unit for measured cumulative gas consumptions<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getUnitForMeasuredCumulativeGasConsumptions();
	private final byte[] _getUnitForMeasuredCumulativeGasConsumptions(byte epc) {
		byte[] edt = getUnitForMeasuredCumulativeGasConsumptions();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the day for which the historical data of measured cumulative gas consumptions is to be retrieved and the historical data of measured cumulative gas consumptions, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br><br>0x0000-0x0063: 0x0-0x3B9AC9FF (0-99) : (0-999,999.999�j<br><br>Name : Historical data of measured cumulative gas consumptions<br>EPC : 0xE4<br>Data Type : unsigned short �{ unsigned long �~48<br>Data Size(Byte) : 194 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getHistoricalDataOfMeasuredCumulativeGasConsumptions() {return null;}
	private final byte[] _getHistoricalDataOfMeasuredCumulativeGasConsumptions(byte epc) {
		byte[] edt = getHistoricalDataOfMeasuredCumulativeGasConsumptions();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br><br>0x00-0x63 ( 0-99) 0: current day 1 - 99: previous day - day that precedes the current day by 99 days<br><br>Name : Day for which the historical data of measured cumulative gas consumptions is to be retrieved<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(byte[] edt) {return false;}
	private final boolean _setDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(byte epc, byte[] edt) {
		boolean success = setDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br><br>0x00-0x63 ( 0-99) 0: current day 1 - 99: previous day - day that precedes the current day by 99 days<br><br>Name : Day for which the historical data of measured cumulative gas consumptions is to be retrieved<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved() {return null;}
	private final byte[] _getDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(byte epc) {
		byte[] edt = getDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates whether the meter has detected an abnormal value in the metering data.<br><br>Abnormal value detected: 0x41 No abnormal value detected: 0x42<br><br>Name : Detection of abnormal value in metering data<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
	 */
	protected byte[] getDetectionOfAbnormalValueInMeteringData() {return null;}
	private final byte[] _getDetectionOfAbnormalValueInMeteringData(byte epc) {
		byte[] edt = getDetectionOfAbnormalValueInMeteringData();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br><br>For details, refer to the explanations under (9).<br><br>Name : Security data information<br>EPC : 0xE7<br>Data Type : unsigned char �~10<br>Data Size(Byte) : 10 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getSecurityDataInformation() {return null;}
	private final byte[] _getSecurityDataInformation(byte epc) {
		byte[] edt = getSecurityDataInformation();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates whether the Center has closed the gas shutoff valve of the meter.<br><br>Center has closed the valve: 0x41 Center has not closed the valve: 0x42<br><br>Name : Valve closure by the Center<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
	 */
	protected byte[] getValveClosureByTheCenter() {return null;}
	private final byte[] _getValveClosureByTheCenter(byte epc) {
		byte[] edt = getValveClosureByTheCenter();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates whether permission has been given by the Center to reopen the gas shutoff valve of the meter closed by the Center.<br><br>Permission has been given by the Center to reopen the gas shutoff valve closed by the Center: 0x41 Permission to reopen the gas shutoff valve closed by the Center has not been given by the Center: 0x42<br><br>Name : Permission from the Center to reopen the valve closed by the Center<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getPermissionFromTheCenterToReopenTheValveClosedByTheCenter() {return null;}
	private final byte[] _getPermissionFromTheCenterToReopenTheValveClosedByTheCenter(byte epc) {
		byte[] edt = getPermissionFromTheCenterToReopenTheValveClosedByTheCenter();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates whether the gas shutoff valve of the meter has been closed in response to an emergency.<br><br>Emergency closure of the shutoff valve has occurred: 0x41 No emergency closure of the shutoff valve has occurred: 0x42<br><br>Name : Emergency closure of shutoff valve<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getEmergencyClosureOfShutoffValve() {return null;}
	private final byte[] _getEmergencyClosureOfShutoffValve(byte epc) {
		byte[] edt = getEmergencyClosureOfShutoffValve();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates whether the shutoff valve is open or closed.<br><br>Shutoff valve open: 0x41 Shutoff valve closed: 0x42<br><br>Name : Shutoff valve status<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getShutoffValveStatus() {return null;}
	private final byte[] _getShutoffValveStatus(byte epc) {
		byte[] edt = getShutoffValveStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the reasons for the 3 past shutoff valve-based gas shutoffs by means of bit assignment with one byte used for each of the 3 shutoff reasons. Historical data3�FHistorical data2�FHistorical data 1<br><br>0xFF: 0xFF: 0xFF<br><br>Name : Historical data of shutoff reasons<br>EPC : 0xEC<br>Data Type : unsigned char �~3<br>Data Size(Byte) : 3 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getHistoricalDataOfShutoffReasons() {return null;}
	private final byte[] _getHistoricalDataOfShutoffReasons(byte epc) {
		byte[] edt = getHistoricalDataOfShutoffReasons();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the ID number of the meter.<br><br>000000-FFFFFF �iInitial .value .: .�g000000�h�j<br><br>Name : ID number setting<br>EPC : 0xED<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setIdNumberSetting(byte[] edt) {return false;}
	private final boolean _setIdNumberSetting(byte epc, byte[] edt) {
		boolean success = setIdNumberSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the ID number of the meter.<br><br>000000-FFFFFF �iInitial .value .: .�g000000�h�j<br><br>Name : ID number setting<br>EPC : 0xED<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getIdNumberSetting() {return null;}
	private final byte[] _getIdNumberSetting(byte epc) {
		byte[] edt = getIdNumberSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the month and year in which the verification of the meter will expire.<br><br>YYYYMM YYYY�iYear�j�CMM�iMonth�j<br><br>Name : Verification expiration information<br>EPC : 0xEE<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setVerificationExpirationInformation(byte[] edt) {return false;}
	private final boolean _setVerificationExpirationInformation(byte epc, byte[] edt) {
		boolean success = setVerificationExpirationInformation(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the month and year in which the verification of the meter will expire.<br><br>YYYYMM YYYY�iYear�j�CMM�iMonth�j<br><br>Name : Verification expiration information<br>EPC : 0xEE<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getVerificationExpirationInformation() {return null;}
	private final byte[] _getVerificationExpirationInformation(byte epc) {
		byte[] edt = getVerificationExpirationInformation();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_GAS_METER_CLASSIFICATION:
			res.addProperty(epc, edt, _setGasMeterClassification(epc, edt));
			break;
		case EPC_OWNER_CLASSIFICATION:
			res.addProperty(epc, edt, _setOwnerClassification(epc, edt));
			break;
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED:
			res.addProperty(epc, edt, _setDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(epc, edt));
			break;
		case EPC_ID_NUMBER_SETTING:
			res.addProperty(epc, edt, _setIdNumberSetting(epc, edt));
			break;
		case EPC_VERIFICATION_EXPIRATION_INFORMATION:
			res.addProperty(epc, edt, _setVerificationExpirationInformation(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_GAS_METER_CLASSIFICATION:
			edt = _getGasMeterClassification(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OWNER_CLASSIFICATION:
			edt = _getOwnerClassification(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION:
			edt = _getMeasuredCumulativeGasConsumption(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS:
			edt = _getUnitForMeasuredCumulativeGasConsumptions(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS:
			edt = _getHistoricalDataOfMeasuredCumulativeGasConsumptions(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 194)));
			break;
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED:
			edt = _getDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA:
			edt = _getDetectionOfAbnormalValueInMeteringData(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SECURITY_DATA_INFORMATION:
			edt = _getSecurityDataInformation(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 10)));
			break;
		case EPC_VALVE_CLOSURE_BY_THE_CENTER:
			edt = _getValveClosureByTheCenter(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_PERMISSION_FROM_THE_CENTER_TO_REOPEN_THE_VALVE_CLOSED_BY_THE_CENTER:
			edt = _getPermissionFromTheCenterToReopenTheValveClosedByTheCenter(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_EMERGENCY_CLOSURE_OF_SHUTOFF_VALVE:
			edt = _getEmergencyClosureOfShutoffValve(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SHUTOFF_VALVE_STATUS:
			edt = _getShutoffValveStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HISTORICAL_DATA_OF_SHUTOFF_REASONS:
			edt = _getHistoricalDataOfShutoffReasons(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 3)));
			break;
		case EPC_ID_NUMBER_SETTING:
			edt = _getIdNumberSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 6)));
			break;
		case EPC_VERIFICATION_EXPIRATION_INFORMATION:
			edt = _getVerificationExpirationInformation(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 6)));
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
			case EPC_GAS_METER_CLASSIFICATION:
				_onSetGasMeterClassification(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_OWNER_CLASSIFICATION:
				_onSetOwnerClassification(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED:
				_onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ID_NUMBER_SETTING:
				_onSetIdNumberSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_VERIFICATION_EXPIRATION_INFORMATION:
				_onSetVerificationExpirationInformation(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_GAS_METER_CLASSIFICATION:
				_onGetGasMeterClassification(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OWNER_CLASSIFICATION:
				_onGetOwnerClassification(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION:
				_onGetMeasuredCumulativeGasConsumption(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS:
				_onGetUnitForMeasuredCumulativeGasConsumptions(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS:
				_onGetHistoricalDataOfMeasuredCumulativeGasConsumptions(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED:
				_onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA:
				_onGetDetectionOfAbnormalValueInMeteringData(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SECURITY_DATA_INFORMATION:
				_onGetSecurityDataInformation(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_VALVE_CLOSURE_BY_THE_CENTER:
				_onGetValveClosureByTheCenter(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_PERMISSION_FROM_THE_CENTER_TO_REOPEN_THE_VALVE_CLOSED_BY_THE_CENTER:
				_onGetPermissionFromTheCenterToReopenTheValveClosedByTheCenter(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_EMERGENCY_CLOSURE_OF_SHUTOFF_VALVE:
				_onGetEmergencyClosureOfShutoffValve(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SHUTOFF_VALVE_STATUS:
				_onGetShutoffValveStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HISTORICAL_DATA_OF_SHUTOFF_REASONS:
				_onGetHistoricalDataOfShutoffReasons(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ID_NUMBER_SETTING:
				_onGetIdNumberSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_VERIFICATION_EXPIRATION_INFORMATION:
				_onGetVerificationExpirationInformation(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates the type of the gas meter.<br><br>0x30�Fcity gas 0x31�FLP gas 0x32�Fnatural gas 0x33�Fothers<br><br>Name : Gas meter classification<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGasMeterClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGasMeterClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGasMeterClassification(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the type of the gas meter.<br><br>0x30�Fcity gas 0x31�FLP gas 0x32�Fnatural gas 0x33�Fothers<br><br>Name : Gas meter classification<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGasMeterClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGasMeterClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGasMeterClassification(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the type of the owner of the meter.<br><br>0x30�Fnot specified 0x31�Fcity gas 0x32�FLP gas 0x33�Fprivate-sector company 0x34�Findividual<br><br>Name : Owner classification<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOwnerClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOwnerClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOwnerClassification(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the type of the owner of the meter.<br><br>0x30�Fnot specified 0x31�Fcity gas 0x32�FLP gas 0x33�Fprivate-sector company 0x34�Findividual<br><br>Name : Owner classification<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOwnerClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOwnerClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOwnerClassification(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured cumulative gas consumption in m3.<br><br>0-0x3B9AC9FF (0-999,999,999�j<br><br>Name : Measured cumulative gas consumption<br>EPC : 0xE2<br>Data Type : unsigned long<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetMeasuredCumulativeGasConsumption(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredCumulativeGasConsumption(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredCumulativeGasConsumption(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the unit (multiplying factor) for the measured cumulative gas consumption and the historical data of measured cumulative gas consumptions.<br><br>0x00: 1��3 0x01: 0.1��3 0x02: 0.01��3 0x03: 0.001��3�iinitial value�j 0x04: 0.0001��3 0x05: 0.00001��3 0x06: 0.000001��3<br><br>Name : Unit for measured cumulative gas consumptions<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetUnitForMeasuredCumulativeGasConsumptions(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetUnitForMeasuredCumulativeGasConsumptions(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetUnitForMeasuredCumulativeGasConsumptions(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions is to be retrieved and the historical data of measured cumulative gas consumptions, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br><br>0x0000-0x0063: 0x0-0x3B9AC9FF (0-99) : (0-999,999.999�j<br><br>Name : Historical data of measured cumulative gas consumptions<br>EPC : 0xE4<br>Data Type : unsigned short �{ unsigned long �~48<br>Data Size(Byte) : 194 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetHistoricalDataOfMeasuredCumulativeGasConsumptions(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHistoricalDataOfMeasuredCumulativeGasConsumptions(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHistoricalDataOfMeasuredCumulativeGasConsumptions(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br><br>0x00-0x63 ( 0-99) 0: current day 1 - 99: previous day - day that precedes the current day by 99 days<br><br>Name : Day for which the historical data of measured cumulative gas consumptions is to be retrieved<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br><br>0x00-0x63 ( 0-99) 0: current day 1 - 99: previous day - day that precedes the current day by 99 days<br><br>Name : Day for which the historical data of measured cumulative gas consumptions is to be retrieved<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates whether the meter has detected an abnormal value in the metering data.<br><br>Abnormal value detected: 0x41 No abnormal value detected: 0x42<br><br>Name : Detection of abnormal value in metering data<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		protected void onGetDetectionOfAbnormalValueInMeteringData(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDetectionOfAbnormalValueInMeteringData(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDetectionOfAbnormalValueInMeteringData(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br><br>For details, refer to the explanations under (9).<br><br>Name : Security data information<br>EPC : 0xE7<br>Data Type : unsigned char �~10<br>Data Size(Byte) : 10 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetSecurityDataInformation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSecurityDataInformation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSecurityDataInformation(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates whether the Center has closed the gas shutoff valve of the meter.<br><br>Center has closed the valve: 0x41 Center has not closed the valve: 0x42<br><br>Name : Valve closure by the Center<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		protected void onGetValveClosureByTheCenter(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetValveClosureByTheCenter(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetValveClosureByTheCenter(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates whether permission has been given by the Center to reopen the gas shutoff valve of the meter closed by the Center.<br><br>Permission has been given by the Center to reopen the gas shutoff valve closed by the Center: 0x41 Permission to reopen the gas shutoff valve closed by the Center has not been given by the Center: 0x42<br><br>Name : Permission from the Center to reopen the valve closed by the Center<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetPermissionFromTheCenterToReopenTheValveClosedByTheCenter(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetPermissionFromTheCenterToReopenTheValveClosedByTheCenter(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetPermissionFromTheCenterToReopenTheValveClosedByTheCenter(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates whether the gas shutoff valve of the meter has been closed in response to an emergency.<br><br>Emergency closure of the shutoff valve has occurred: 0x41 No emergency closure of the shutoff valve has occurred: 0x42<br><br>Name : Emergency closure of shutoff valve<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetEmergencyClosureOfShutoffValve(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetEmergencyClosureOfShutoffValve(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetEmergencyClosureOfShutoffValve(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates whether the shutoff valve is open or closed.<br><br>Shutoff valve open: 0x41 Shutoff valve closed: 0x42<br><br>Name : Shutoff valve status<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetShutoffValveStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetShutoffValveStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetShutoffValveStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the reasons for the 3 past shutoff valve-based gas shutoffs by means of bit assignment with one byte used for each of the 3 shutoff reasons. Historical data3�FHistorical data2�FHistorical data 1<br><br>0xFF: 0xFF: 0xFF<br><br>Name : Historical data of shutoff reasons<br>EPC : 0xEC<br>Data Type : unsigned char �~3<br>Data Size(Byte) : 3 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetHistoricalDataOfShutoffReasons(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHistoricalDataOfShutoffReasons(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHistoricalDataOfShutoffReasons(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the ID number of the meter.<br><br>000000-FFFFFF �iInitial .value .: .�g000000�h�j<br><br>Name : ID number setting<br>EPC : 0xED<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetIdNumberSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetIdNumberSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetIdNumberSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the ID number of the meter.<br><br>000000-FFFFFF �iInitial .value .: .�g000000�h�j<br><br>Name : ID number setting<br>EPC : 0xED<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetIdNumberSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetIdNumberSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetIdNumberSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br><br>YYYYMM YYYY�iYear�j�CMM�iMonth�j<br><br>Name : Verification expiration information<br>EPC : 0xEE<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetVerificationExpirationInformation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetVerificationExpirationInformation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetVerificationExpirationInformation(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br><br>YYYYMM YYYY�iYear�j�CMM�iMonth�j<br><br>Name : Verification expiration information<br>EPC : 0xEE<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetVerificationExpirationInformation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetVerificationExpirationInformation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetVerificationExpirationInformation(eoj, tid, esv, epc, pdc, edt);
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
		 * This property indicates the type of the gas meter.<br><br>0x30�Fcity gas 0x31�FLP gas 0x32�Fnatural gas 0x33�Fothers<br><br>Name : Gas meter classification<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGasMeterClassification(byte[] edt) {
			addProperty(EPC_GAS_METER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * This property indicates the type of the owner of the meter.<br><br>0x30�Fnot specified 0x31�Fcity gas 0x32�FLP gas 0x33�Fprivate-sector company 0x34�Findividual<br><br>Name : Owner classification<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOwnerClassification(byte[] edt) {
			addProperty(EPC_OWNER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br><br>0x00-0x63 ( 0-99) 0: current day 1 - 99: previous day - day that precedes the current day by 99 days<br><br>Name : Day for which the historical data of measured cumulative gas consumptions is to be retrieved<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(byte[] edt) {
			addProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * This property indicates the ID number of the meter.<br><br>000000-FFFFFF �iInitial .value .: .�g000000�h�j<br><br>Name : ID number setting<br>EPC : 0xED<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetIdNumberSetting(byte[] edt) {
			addProperty(EPC_ID_NUMBER_SETTING, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br><br>YYYYMM YYYY�iYear�j�CMM�iMonth�j<br><br>Name : Verification expiration information<br>EPC : 0xEE<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetVerificationExpirationInformation(byte[] edt) {
			addProperty(EPC_VERIFICATION_EXPIRATION_INFORMATION, edt, (edt != null && (edt.length == 6)));
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
		 * This property indicates the type of the gas meter.<br><br>0x30�Fcity gas 0x31�FLP gas 0x32�Fnatural gas 0x33�Fothers<br><br>Name : Gas meter classification<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGasMeterClassification() {
			addProperty(EPC_GAS_METER_CLASSIFICATION);
			return this;
		}
		/**
		 * This property indicates the type of the owner of the meter.<br><br>0x30�Fnot specified 0x31�Fcity gas 0x32�FLP gas 0x33�Fprivate-sector company 0x34�Findividual<br><br>Name : Owner classification<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOwnerClassification() {
			addProperty(EPC_OWNER_CLASSIFICATION);
			return this;
		}
		/**
		 * This property indicates the measured cumulative gas consumption in m3.<br><br>0-0x3B9AC9FF (0-999,999,999�j<br><br>Name : Measured cumulative gas consumption<br>EPC : 0xE2<br>Data Type : unsigned long<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetMeasuredCumulativeGasConsumption() {
			addProperty(EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION);
			return this;
		}
		/**
		 * This property indicates the unit (multiplying factor) for the measured cumulative gas consumption and the historical data of measured cumulative gas consumptions.<br><br>0x00: 1��3 0x01: 0.1��3 0x02: 0.01��3 0x03: 0.001��3�iinitial value�j 0x04: 0.0001��3 0x05: 0.00001��3 0x06: 0.000001��3<br><br>Name : Unit for measured cumulative gas consumptions<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetUnitForMeasuredCumulativeGasConsumptions() {
			addProperty(EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS);
			return this;
		}
		/**
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions is to be retrieved and the historical data of measured cumulative gas consumptions, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br><br>0x0000-0x0063: 0x0-0x3B9AC9FF (0-99) : (0-999,999.999�j<br><br>Name : Historical data of measured cumulative gas consumptions<br>EPC : 0xE4<br>Data Type : unsigned short �{ unsigned long �~48<br>Data Size(Byte) : 194 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetHistoricalDataOfMeasuredCumulativeGasConsumptions() {
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS);
			return this;
		}
		/**
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br><br>0x00-0x63 ( 0-99) 0: current day 1 - 99: previous day - day that precedes the current day by 99 days<br><br>Name : Day for which the historical data of measured cumulative gas consumptions is to be retrieved<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved() {
			addProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED);
			return this;
		}
		/**
		 * This property indicates whether the meter has detected an abnormal value in the metering data.<br><br>Abnormal value detected: 0x41 No abnormal value detected: 0x42<br><br>Name : Detection of abnormal value in metering data<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Getter reqGetDetectionOfAbnormalValueInMeteringData() {
			addProperty(EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA);
			return this;
		}
		/**
		 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br><br>For details, refer to the explanations under (9).<br><br>Name : Security data information<br>EPC : 0xE7<br>Data Type : unsigned char �~10<br>Data Size(Byte) : 10 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetSecurityDataInformation() {
			addProperty(EPC_SECURITY_DATA_INFORMATION);
			return this;
		}
		/**
		 * This property indicates whether the Center has closed the gas shutoff valve of the meter.<br><br>Center has closed the valve: 0x41 Center has not closed the valve: 0x42<br><br>Name : Valve closure by the Center<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Getter reqGetValveClosureByTheCenter() {
			addProperty(EPC_VALVE_CLOSURE_BY_THE_CENTER);
			return this;
		}
		/**
		 * This property indicates whether permission has been given by the Center to reopen the gas shutoff valve of the meter closed by the Center.<br><br>Permission has been given by the Center to reopen the gas shutoff valve closed by the Center: 0x41 Permission to reopen the gas shutoff valve closed by the Center has not been given by the Center: 0x42<br><br>Name : Permission from the Center to reopen the valve closed by the Center<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetPermissionFromTheCenterToReopenTheValveClosedByTheCenter() {
			addProperty(EPC_PERMISSION_FROM_THE_CENTER_TO_REOPEN_THE_VALVE_CLOSED_BY_THE_CENTER);
			return this;
		}
		/**
		 * This property indicates whether the gas shutoff valve of the meter has been closed in response to an emergency.<br><br>Emergency closure of the shutoff valve has occurred: 0x41 No emergency closure of the shutoff valve has occurred: 0x42<br><br>Name : Emergency closure of shutoff valve<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetEmergencyClosureOfShutoffValve() {
			addProperty(EPC_EMERGENCY_CLOSURE_OF_SHUTOFF_VALVE);
			return this;
		}
		/**
		 * This property indicates whether the shutoff valve is open or closed.<br><br>Shutoff valve open: 0x41 Shutoff valve closed: 0x42<br><br>Name : Shutoff valve status<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetShutoffValveStatus() {
			addProperty(EPC_SHUTOFF_VALVE_STATUS);
			return this;
		}
		/**
		 * This property indicates the reasons for the 3 past shutoff valve-based gas shutoffs by means of bit assignment with one byte used for each of the 3 shutoff reasons. Historical data3�FHistorical data2�FHistorical data 1<br><br>0xFF: 0xFF: 0xFF<br><br>Name : Historical data of shutoff reasons<br>EPC : 0xEC<br>Data Type : unsigned char �~3<br>Data Size(Byte) : 3 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetHistoricalDataOfShutoffReasons() {
			addProperty(EPC_HISTORICAL_DATA_OF_SHUTOFF_REASONS);
			return this;
		}
		/**
		 * This property indicates the ID number of the meter.<br><br>000000-FFFFFF �iInitial .value .: .�g000000�h�j<br><br>Name : ID number setting<br>EPC : 0xED<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetIdNumberSetting() {
			addProperty(EPC_ID_NUMBER_SETTING);
			return this;
		}
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br><br>YYYYMM YYYY�iYear�j�CMM�iMonth�j<br><br>Name : Verification expiration information<br>EPC : 0xEE<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetVerificationExpirationInformation() {
			addProperty(EPC_VERIFICATION_EXPIRATION_INFORMATION);
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
		 * This property indicates the type of the gas meter.<br><br>0x30�Fcity gas 0x31�FLP gas 0x32�Fnatural gas 0x33�Fothers<br><br>Name : Gas meter classification<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGasMeterClassification();
		/**
		 * This property indicates the type of the owner of the meter.<br><br>0x30�Fnot specified 0x31�Fcity gas 0x32�FLP gas 0x33�Fprivate-sector company 0x34�Findividual<br><br>Name : Owner classification<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOwnerClassification();
		/**
		 * This property indicates the measured cumulative gas consumption in m3.<br><br>0-0x3B9AC9FF (0-999,999,999�j<br><br>Name : Measured cumulative gas consumption<br>EPC : 0xE2<br>Data Type : unsigned long<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformMeasuredCumulativeGasConsumption();
		/**
		 * This property indicates the unit (multiplying factor) for the measured cumulative gas consumption and the historical data of measured cumulative gas consumptions.<br><br>0x00: 1��3 0x01: 0.1��3 0x02: 0.01��3 0x03: 0.001��3�iinitial value�j 0x04: 0.0001��3 0x05: 0.00001��3 0x06: 0.000001��3<br><br>Name : Unit for measured cumulative gas consumptions<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformUnitForMeasuredCumulativeGasConsumptions();
		/**
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions is to be retrieved and the historical data of measured cumulative gas consumptions, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br><br>0x0000-0x0063: 0x0-0x3B9AC9FF (0-99) : (0-999,999.999�j<br><br>Name : Historical data of measured cumulative gas consumptions<br>EPC : 0xE4<br>Data Type : unsigned short �{ unsigned long �~48<br>Data Size(Byte) : 194 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformHistoricalDataOfMeasuredCumulativeGasConsumptions();
		/**
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br><br>0x00-0x63 ( 0-99) 0: current day 1 - 99: previous day - day that precedes the current day by 99 days<br><br>Name : Day for which the historical data of measured cumulative gas consumptions is to be retrieved<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved();
		/**
		 * This property indicates whether the meter has detected an abnormal value in the metering data.<br><br>Abnormal value detected: 0x41 No abnormal value detected: 0x42<br><br>Name : Detection of abnormal value in metering data<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Informer reqInformDetectionOfAbnormalValueInMeteringData();
		/**
		 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br><br>For details, refer to the explanations under (9).<br><br>Name : Security data information<br>EPC : 0xE7<br>Data Type : unsigned char �~10<br>Data Size(Byte) : 10 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformSecurityDataInformation();
		/**
		 * This property indicates whether the Center has closed the gas shutoff valve of the meter.<br><br>Center has closed the valve: 0x41 Center has not closed the valve: 0x42<br><br>Name : Valve closure by the Center<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Informer reqInformValveClosureByTheCenter();
		/**
		 * This property indicates whether permission has been given by the Center to reopen the gas shutoff valve of the meter closed by the Center.<br><br>Permission has been given by the Center to reopen the gas shutoff valve closed by the Center: 0x41 Permission to reopen the gas shutoff valve closed by the Center has not been given by the Center: 0x42<br><br>Name : Permission from the Center to reopen the valve closed by the Center<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformPermissionFromTheCenterToReopenTheValveClosedByTheCenter();
		/**
		 * This property indicates whether the gas shutoff valve of the meter has been closed in response to an emergency.<br><br>Emergency closure of the shutoff valve has occurred: 0x41 No emergency closure of the shutoff valve has occurred: 0x42<br><br>Name : Emergency closure of shutoff valve<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformEmergencyClosureOfShutoffValve();
		/**
		 * This property indicates whether the shutoff valve is open or closed.<br><br>Shutoff valve open: 0x41 Shutoff valve closed: 0x42<br><br>Name : Shutoff valve status<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformShutoffValveStatus();
		/**
		 * This property indicates the reasons for the 3 past shutoff valve-based gas shutoffs by means of bit assignment with one byte used for each of the 3 shutoff reasons. Historical data3�FHistorical data2�FHistorical data 1<br><br>0xFF: 0xFF: 0xFF<br><br>Name : Historical data of shutoff reasons<br>EPC : 0xEC<br>Data Type : unsigned char �~3<br>Data Size(Byte) : 3 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformHistoricalDataOfShutoffReasons();
		/**
		 * This property indicates the ID number of the meter.<br><br>000000-FFFFFF �iInitial .value .: .�g000000�h�j<br><br>Name : ID number setting<br>EPC : 0xED<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformIdNumberSetting();
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br><br>YYYYMM YYYY�iYear�j�CMM�iMonth�j<br><br>Name : Verification expiration information<br>EPC : 0xEE<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformVerificationExpirationInformation();
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
		public Informer reqInformGasMeterClassification() {
			byte epc = EPC_GAS_METER_CLASSIFICATION;
			byte[] edt = _getGasMeterClassification(epc);
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
		public Informer reqInformMeasuredCumulativeGasConsumption() {
			byte epc = EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION;
			byte[] edt = _getMeasuredCumulativeGasConsumption(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformUnitForMeasuredCumulativeGasConsumptions() {
			byte epc = EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS;
			byte[] edt = _getUnitForMeasuredCumulativeGasConsumptions(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHistoricalDataOfMeasuredCumulativeGasConsumptions() {
			byte epc = EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS;
			byte[] edt = _getHistoricalDataOfMeasuredCumulativeGasConsumptions(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 194)));
			return this;
		}
		@Override
		public Informer reqInformDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved() {
			byte epc = EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED;
			byte[] edt = _getDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDetectionOfAbnormalValueInMeteringData() {
			byte epc = EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA;
			byte[] edt = _getDetectionOfAbnormalValueInMeteringData(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSecurityDataInformation() {
			byte epc = EPC_SECURITY_DATA_INFORMATION;
			byte[] edt = _getSecurityDataInformation(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 10)));
			return this;
		}
		@Override
		public Informer reqInformValveClosureByTheCenter() {
			byte epc = EPC_VALVE_CLOSURE_BY_THE_CENTER;
			byte[] edt = _getValveClosureByTheCenter(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformPermissionFromTheCenterToReopenTheValveClosedByTheCenter() {
			byte epc = EPC_PERMISSION_FROM_THE_CENTER_TO_REOPEN_THE_VALVE_CLOSED_BY_THE_CENTER;
			byte[] edt = _getPermissionFromTheCenterToReopenTheValveClosedByTheCenter(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformEmergencyClosureOfShutoffValve() {
			byte epc = EPC_EMERGENCY_CLOSURE_OF_SHUTOFF_VALVE;
			byte[] edt = _getEmergencyClosureOfShutoffValve(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformShutoffValveStatus() {
			byte epc = EPC_SHUTOFF_VALVE_STATUS;
			byte[] edt = _getShutoffValveStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHistoricalDataOfShutoffReasons() {
			byte epc = EPC_HISTORICAL_DATA_OF_SHUTOFF_REASONS;
			byte[] edt = _getHistoricalDataOfShutoffReasons(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Informer reqInformIdNumberSetting() {
			byte epc = EPC_ID_NUMBER_SETTING;
			byte[] edt = _getIdNumberSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Informer reqInformVerificationExpirationInformation() {
			byte epc = EPC_VERIFICATION_EXPIRATION_INFORMATION;
			byte[] edt = _getVerificationExpirationInformation(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 6)));
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
