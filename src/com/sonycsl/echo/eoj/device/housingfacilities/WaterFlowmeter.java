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

public abstract class WaterFlowmeter extends DeviceObject {
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x81;

	public static final byte EPC_FLOWING_WATER_CLASSIFICATION = (byte)0xD0;
	public static final byte EPC_OWNER_CLASSIFICATION = (byte)0xD1;
	public static final byte EPC_MEASURED_CUMULATIVE_AMOUNT_OF_FLOWING_WATER = (byte)0xE0;
	public static final byte EPC_UNIT_FOR_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER = (byte)0xE1;
	public static final byte EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER = (byte)0xE2;
	public static final byte EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA = (byte)0xE3;
	public static final byte EPC_SECURITY_DATA_INFORMATION = (byte)0xE4;
	public static final byte EPC_ID_NUMBER_SETTING = (byte)0xE5;
	public static final byte EPC_VERIFICATION_EXPIRATION_INFORMATION = (byte)0xE6;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates the water flowmeter type.<br><br>0x30�Frunning water 0x31�Frecycled water 0x32�Fwarm water 0x33�Fother water<br><br>Name : Flowing water classification<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setFlowingWaterClassification(byte[] edt) {return false;}
	private final boolean _setFlowingWaterClassification(byte epc, byte[] edt) {
		boolean success = setFlowingWaterClassification(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the water flowmeter type.<br><br>0x30�Frunning water 0x31�Frecycled water 0x32�Fwarm water 0x33�Fother water<br><br>Name : Flowing water classification<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getFlowingWaterClassification() {return null;}
	private final byte[] _getFlowingWaterClassification(byte epc) {
		byte[] edt = getFlowingWaterClassification();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the owner of the meter in the form of owner classification.<br><br>0x30�FNot specified 0x31�FPublic waterworks company 0x32�FPrivate sector company 0x33�FIndividual<br><br>Name : Owner classification<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOwnerClassification(byte[] edt) {return false;}
	private final boolean _setOwnerClassification(byte epc, byte[] edt) {
		boolean success = setOwnerClassification(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the owner of the meter in the form of owner classification.<br><br>0x30�FNot specified 0x31�FPublic waterworks company 0x32�FPrivate sector company 0x33�FIndividual<br><br>Name : Owner classification<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOwnerClassification() {return null;}
	private final byte[] _getOwnerClassification(byte epc) {
		byte[] edt = getOwnerClassification();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the cumulative amount (consumption) of flowing water using a 9-digit number.<br><br>0-0x3B9AC9FF (0-999,999,999�j<br><br>Name : Measured cumulative amount of flowing water<br>EPC : 0xE0<br>Data Type : unsigned long<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getMeasuredCumulativeAmountOfFlowingWater();
	private final byte[] _getMeasuredCumulativeAmountOfFlowingWater(byte epc) {
		byte[] edt = getMeasuredCumulativeAmountOfFlowingWater();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the unit (multiplying factor) for the measured cumulative amount of flowing water and the historical data of measured cumulative amounts of flowing water.<br><br>0x00: 1��3 0x01: 0.1��3 0x02: 0.01��3 0x03: 0.001��3 0x04: 0.0001��3�iInitial value�j 0x05: 0.00001��3 0x06: 0.000001��3<br><br>Name : Unit for measured cumulative amounts of flowing water<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getUnitForMeasuredCumulativeAmountsOfFlowingWater();
	private final byte[] _getUnitForMeasuredCumulativeAmountsOfFlowingWater(byte epc) {
		byte[] edt = getUnitForMeasuredCumulativeAmountsOfFlowingWater();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the historical data of measured cumulative amounts (consumptions) of running water, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br><br>0x0-0x3B9AC9FF (0-999,999.999m3�j<br><br>Name : Historical data of measured cumulative amounts of flowing water<br>EPC : 0xE2<br>Data Type : unsigned long �~48<br>Data Size(Byte) : 192 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater() {return null;}
	private final byte[] _getHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater(byte epc) {
		byte[] edt = getHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates whether the meter has detected an abnormal value in the metering data.<br><br>Abnormal value detected: 0x41 No abnormal value detected: 0x42<br><br>Name : Detection of abnormal value in metering data<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
	 */
	protected byte[] getDetectionOfAbnormalValueInMeteringData() {return null;}
	private final byte[] _getDetectionOfAbnormalValueInMeteringData(byte epc) {
		byte[] edt = getDetectionOfAbnormalValueInMeteringData();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br><br>0-0xFFFFFFFF<br><br>Name : Security data information<br>EPC : 0xE4<br>Data Type : unsigned long<br>Data Size(Byte) : 5 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getSecurityDataInformation() {return null;}
	private final byte[] _getSecurityDataInformation(byte epc) {
		byte[] edt = getSecurityDataInformation();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the ID number of the meter.<br><br>The ID number is specified using ASCII code. �iInitial value�F�g000000�h�j<br><br>Name : ID number setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setIdNumberSetting(byte[] edt) {return false;}
	private final boolean _setIdNumberSetting(byte epc, byte[] edt) {
		boolean success = setIdNumberSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the ID number of the meter.<br><br>The ID number is specified using ASCII code. �iInitial value�F�g000000�h�j<br><br>Name : ID number setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getIdNumberSetting() {return null;}
	private final byte[] _getIdNumberSetting(byte epc) {
		byte[] edt = getIdNumberSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the month and year in which the verification of the meter will expire.<br><br>The month and year are specified using ASCII code. xxxx xx Year Month<br><br>Name : Verification expiration information<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setVerificationExpirationInformation(byte[] edt) {return false;}
	private final boolean _setVerificationExpirationInformation(byte epc, byte[] edt) {
		boolean success = setVerificationExpirationInformation(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the month and year in which the verification of the meter will expire.<br><br>The month and year are specified using ASCII code. xxxx xx Year Month<br><br>Name : Verification expiration information<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
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
		case EPC_FLOWING_WATER_CLASSIFICATION:
			res.addProperty(epc, edt, _setFlowingWaterClassification(epc, edt));
			break;
		case EPC_OWNER_CLASSIFICATION:
			res.addProperty(epc, edt, _setOwnerClassification(epc, edt));
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
		case EPC_FLOWING_WATER_CLASSIFICATION:
			edt = _getFlowingWaterClassification(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OWNER_CLASSIFICATION:
			edt = _getOwnerClassification(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_FLOWING_WATER:
			edt = _getMeasuredCumulativeAmountOfFlowingWater(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_UNIT_FOR_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER:
			edt = _getUnitForMeasuredCumulativeAmountsOfFlowingWater(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER:
			edt = _getHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 192)));
			break;
		case EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA:
			edt = _getDetectionOfAbnormalValueInMeteringData(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SECURITY_DATA_INFORMATION:
			edt = _getSecurityDataInformation(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 5)));
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
			case EPC_FLOWING_WATER_CLASSIFICATION:
				_onSetFlowingWaterClassification(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_OWNER_CLASSIFICATION:
				_onSetOwnerClassification(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
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
			case EPC_FLOWING_WATER_CLASSIFICATION:
				_onGetFlowingWaterClassification(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OWNER_CLASSIFICATION:
				_onGetOwnerClassification(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_FLOWING_WATER:
				_onGetMeasuredCumulativeAmountOfFlowingWater(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_UNIT_FOR_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER:
				_onGetUnitForMeasuredCumulativeAmountsOfFlowingWater(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER:
				_onGetHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA:
				_onGetDetectionOfAbnormalValueInMeteringData(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SECURITY_DATA_INFORMATION:
				_onGetSecurityDataInformation(eoj, tid, esv, epc, pdc, edt);
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
		 * This property indicates the water flowmeter type.<br><br>0x30�Frunning water 0x31�Frecycled water 0x32�Fwarm water 0x33�Fother water<br><br>Name : Flowing water classification<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetFlowingWaterClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetFlowingWaterClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetFlowingWaterClassification(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the water flowmeter type.<br><br>0x30�Frunning water 0x31�Frecycled water 0x32�Fwarm water 0x33�Fother water<br><br>Name : Flowing water classification<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetFlowingWaterClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetFlowingWaterClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetFlowingWaterClassification(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the owner of the meter in the form of owner classification.<br><br>0x30�FNot specified 0x31�FPublic waterworks company 0x32�FPrivate sector company 0x33�FIndividual<br><br>Name : Owner classification<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOwnerClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOwnerClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOwnerClassification(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the owner of the meter in the form of owner classification.<br><br>0x30�FNot specified 0x31�FPublic waterworks company 0x32�FPrivate sector company 0x33�FIndividual<br><br>Name : Owner classification<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOwnerClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOwnerClassification(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOwnerClassification(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the cumulative amount (consumption) of flowing water using a 9-digit number.<br><br>0-0x3B9AC9FF (0-999,999,999�j<br><br>Name : Measured cumulative amount of flowing water<br>EPC : 0xE0<br>Data Type : unsigned long<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetMeasuredCumulativeAmountOfFlowingWater(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredCumulativeAmountOfFlowingWater(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredCumulativeAmountOfFlowingWater(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the unit (multiplying factor) for the measured cumulative amount of flowing water and the historical data of measured cumulative amounts of flowing water.<br><br>0x00: 1��3 0x01: 0.1��3 0x02: 0.01��3 0x03: 0.001��3 0x04: 0.0001��3�iInitial value�j 0x05: 0.00001��3 0x06: 0.000001��3<br><br>Name : Unit for measured cumulative amounts of flowing water<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetUnitForMeasuredCumulativeAmountsOfFlowingWater(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetUnitForMeasuredCumulativeAmountsOfFlowingWater(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetUnitForMeasuredCumulativeAmountsOfFlowingWater(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the historical data of measured cumulative amounts (consumptions) of running water, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br><br>0x0-0x3B9AC9FF (0-999,999.999m3�j<br><br>Name : Historical data of measured cumulative amounts of flowing water<br>EPC : 0xE2<br>Data Type : unsigned long �~48<br>Data Size(Byte) : 192 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates whether the meter has detected an abnormal value in the metering data.<br><br>Abnormal value detected: 0x41 No abnormal value detected: 0x42<br><br>Name : Detection of abnormal value in metering data<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		protected void onGetDetectionOfAbnormalValueInMeteringData(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDetectionOfAbnormalValueInMeteringData(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDetectionOfAbnormalValueInMeteringData(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br><br>0-0xFFFFFFFF<br><br>Name : Security data information<br>EPC : 0xE4<br>Data Type : unsigned long<br>Data Size(Byte) : 5 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetSecurityDataInformation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSecurityDataInformation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSecurityDataInformation(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the ID number of the meter.<br><br>The ID number is specified using ASCII code. �iInitial value�F�g000000�h�j<br><br>Name : ID number setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetIdNumberSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetIdNumberSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetIdNumberSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the ID number of the meter.<br><br>The ID number is specified using ASCII code. �iInitial value�F�g000000�h�j<br><br>Name : ID number setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetIdNumberSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetIdNumberSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetIdNumberSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br><br>The month and year are specified using ASCII code. xxxx xx Year Month<br><br>Name : Verification expiration information<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetVerificationExpirationInformation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetVerificationExpirationInformation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetVerificationExpirationInformation(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br><br>The month and year are specified using ASCII code. xxxx xx Year Month<br><br>Name : Verification expiration information<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
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
		 * This property indicates the water flowmeter type.<br><br>0x30�Frunning water 0x31�Frecycled water 0x32�Fwarm water 0x33�Fother water<br><br>Name : Flowing water classification<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetFlowingWaterClassification(byte[] edt) {
			addProperty(EPC_FLOWING_WATER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * This property indicates the owner of the meter in the form of owner classification.<br><br>0x30�FNot specified 0x31�FPublic waterworks company 0x32�FPrivate sector company 0x33�FIndividual<br><br>Name : Owner classification<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOwnerClassification(byte[] edt) {
			addProperty(EPC_OWNER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * This property indicates the ID number of the meter.<br><br>The ID number is specified using ASCII code. �iInitial value�F�g000000�h�j<br><br>Name : ID number setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetIdNumberSetting(byte[] edt) {
			addProperty(EPC_ID_NUMBER_SETTING, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br><br>The month and year are specified using ASCII code. xxxx xx Year Month<br><br>Name : Verification expiration information<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
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
		 * This property indicates the water flowmeter type.<br><br>0x30�Frunning water 0x31�Frecycled water 0x32�Fwarm water 0x33�Fother water<br><br>Name : Flowing water classification<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetFlowingWaterClassification() {
			addProperty(EPC_FLOWING_WATER_CLASSIFICATION);
			return this;
		}
		/**
		 * This property indicates the owner of the meter in the form of owner classification.<br><br>0x30�FNot specified 0x31�FPublic waterworks company 0x32�FPrivate sector company 0x33�FIndividual<br><br>Name : Owner classification<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOwnerClassification() {
			addProperty(EPC_OWNER_CLASSIFICATION);
			return this;
		}
		/**
		 * This property indicates the cumulative amount (consumption) of flowing water using a 9-digit number.<br><br>0-0x3B9AC9FF (0-999,999,999�j<br><br>Name : Measured cumulative amount of flowing water<br>EPC : 0xE0<br>Data Type : unsigned long<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetMeasuredCumulativeAmountOfFlowingWater() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_FLOWING_WATER);
			return this;
		}
		/**
		 * This property indicates the unit (multiplying factor) for the measured cumulative amount of flowing water and the historical data of measured cumulative amounts of flowing water.<br><br>0x00: 1��3 0x01: 0.1��3 0x02: 0.01��3 0x03: 0.001��3 0x04: 0.0001��3�iInitial value�j 0x05: 0.00001��3 0x06: 0.000001��3<br><br>Name : Unit for measured cumulative amounts of flowing water<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetUnitForMeasuredCumulativeAmountsOfFlowingWater() {
			addProperty(EPC_UNIT_FOR_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER);
			return this;
		}
		/**
		 * This property indicates the historical data of measured cumulative amounts (consumptions) of running water, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br><br>0x0-0x3B9AC9FF (0-999,999.999m3�j<br><br>Name : Historical data of measured cumulative amounts of flowing water<br>EPC : 0xE2<br>Data Type : unsigned long �~48<br>Data Size(Byte) : 192 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater() {
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER);
			return this;
		}
		/**
		 * This property indicates whether the meter has detected an abnormal value in the metering data.<br><br>Abnormal value detected: 0x41 No abnormal value detected: 0x42<br><br>Name : Detection of abnormal value in metering data<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Getter reqGetDetectionOfAbnormalValueInMeteringData() {
			addProperty(EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA);
			return this;
		}
		/**
		 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br><br>0-0xFFFFFFFF<br><br>Name : Security data information<br>EPC : 0xE4<br>Data Type : unsigned long<br>Data Size(Byte) : 5 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetSecurityDataInformation() {
			addProperty(EPC_SECURITY_DATA_INFORMATION);
			return this;
		}
		/**
		 * This property indicates the ID number of the meter.<br><br>The ID number is specified using ASCII code. �iInitial value�F�g000000�h�j<br><br>Name : ID number setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetIdNumberSetting() {
			addProperty(EPC_ID_NUMBER_SETTING);
			return this;
		}
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br><br>The month and year are specified using ASCII code. xxxx xx Year Month<br><br>Name : Verification expiration information<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
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
		 * This property indicates the water flowmeter type.<br><br>0x30�Frunning water 0x31�Frecycled water 0x32�Fwarm water 0x33�Fother water<br><br>Name : Flowing water classification<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformFlowingWaterClassification();
		/**
		 * This property indicates the owner of the meter in the form of owner classification.<br><br>0x30�FNot specified 0x31�FPublic waterworks company 0x32�FPrivate sector company 0x33�FIndividual<br><br>Name : Owner classification<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOwnerClassification();
		/**
		 * This property indicates the cumulative amount (consumption) of flowing water using a 9-digit number.<br><br>0-0x3B9AC9FF (0-999,999,999�j<br><br>Name : Measured cumulative amount of flowing water<br>EPC : 0xE0<br>Data Type : unsigned long<br>Data Size(Byte) : 4 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformMeasuredCumulativeAmountOfFlowingWater();
		/**
		 * This property indicates the unit (multiplying factor) for the measured cumulative amount of flowing water and the historical data of measured cumulative amounts of flowing water.<br><br>0x00: 1��3 0x01: 0.1��3 0x02: 0.01��3 0x03: 0.001��3 0x04: 0.0001��3�iInitial value�j 0x05: 0.00001��3 0x06: 0.000001��3<br><br>Name : Unit for measured cumulative amounts of flowing water<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformUnitForMeasuredCumulativeAmountsOfFlowingWater();
		/**
		 * This property indicates the historical data of measured cumulative amounts (consumptions) of running water, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br><br>0x0-0x3B9AC9FF (0-999,999.999m3�j<br><br>Name : Historical data of measured cumulative amounts of flowing water<br>EPC : 0xE2<br>Data Type : unsigned long �~48<br>Data Size(Byte) : 192 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater();
		/**
		 * This property indicates whether the meter has detected an abnormal value in the metering data.<br><br>Abnormal value detected: 0x41 No abnormal value detected: 0x42<br><br>Name : Detection of abnormal value in metering data<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Informer reqInformDetectionOfAbnormalValueInMeteringData();
		/**
		 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br><br>0-0xFFFFFFFF<br><br>Name : Security data information<br>EPC : 0xE4<br>Data Type : unsigned long<br>Data Size(Byte) : 5 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformSecurityDataInformation();
		/**
		 * This property indicates the ID number of the meter.<br><br>The ID number is specified using ASCII code. �iInitial value�F�g000000�h�j<br><br>Name : ID number setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformIdNumberSetting();
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br><br>The month and year are specified using ASCII code. xxxx xx Year Month<br><br>Name : Verification expiration information<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 6 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
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
		public Informer reqInformFlowingWaterClassification() {
			byte epc = EPC_FLOWING_WATER_CLASSIFICATION;
			byte[] edt = _getFlowingWaterClassification(epc);
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
		public Informer reqInformMeasuredCumulativeAmountOfFlowingWater() {
			byte epc = EPC_MEASURED_CUMULATIVE_AMOUNT_OF_FLOWING_WATER;
			byte[] edt = _getMeasuredCumulativeAmountOfFlowingWater(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformUnitForMeasuredCumulativeAmountsOfFlowingWater() {
			byte epc = EPC_UNIT_FOR_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER;
			byte[] edt = _getUnitForMeasuredCumulativeAmountsOfFlowingWater(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater() {
			byte epc = EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER;
			byte[] edt = _getHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 192)));
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
			addProperty(epc, edt, (edt != null && (edt.length == 5)));
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
		public Informer reqInformFlowingWaterClassification() {
			addProperty(EPC_FLOWING_WATER_CLASSIFICATION);
			return this;
		}
		@Override
		public Informer reqInformOwnerClassification() {
			addProperty(EPC_OWNER_CLASSIFICATION);
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeAmountOfFlowingWater() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_FLOWING_WATER);
			return this;
		}
		@Override
		public Informer reqInformUnitForMeasuredCumulativeAmountsOfFlowingWater() {
			addProperty(EPC_UNIT_FOR_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER);
			return this;
		}
		@Override
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater() {
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER);
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
