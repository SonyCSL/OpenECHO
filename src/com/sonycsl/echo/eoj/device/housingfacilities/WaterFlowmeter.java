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
	@SuppressWarnings("unused")
	private static final String TAG = WaterFlowmeter.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x81;

	protected static final byte EPC_FLOWING_WATER_CLASSIFICATION = (byte)0xD0;
	protected static final byte EPC_OWNER_CLASSIFICATION = (byte)0xD1;
	protected static final byte EPC_MEASURED_CUMULATIVE_AMOUNT_OF_FLOWING_WATER = (byte)0xE0;
	protected static final byte EPC_UNIT_FOR_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER = (byte)0xE1;
	protected static final byte EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER = (byte)0xE2;
	protected static final byte EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA = (byte)0xE3;
	protected static final byte EPC_SECURITY_DATA_INFORMATION = (byte)0xE4;
	protected static final byte EPC_ID_NUMBER_SETTING = (byte)0xE5;
	protected static final byte EPC_VERIFICATION_EXPIRATION_INFORMATION = (byte)0xE6;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates the water flowmeter type.<br>0x30�Frunning water 0x31�Frecycled water 0x32�Fwarm water 0x33�Fother water<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setFlowingWaterClassification(byte[] edt) {return false;}
	/**
	 * This property indicates the water flowmeter type.<br>0x30�Frunning water 0x31�Frecycled water 0x32�Fwarm water 0x33�Fother water<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getFlowingWaterClassification() {return null;}
	/**
	 * This property indicates the owner of the meter in the form of owner classification.<br>0x30�FNot specified 0x31�FPublic waterworks company 0x32�FPrivate sector company 0x33�FIndividual<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOwnerClassification(byte[] edt) {return false;}
	/**
	 * This property indicates the owner of the meter in the form of owner classification.<br>0x30�FNot specified 0x31�FPublic waterworks company 0x32�FPrivate sector company 0x33�FIndividual<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOwnerClassification() {return null;}
	/**
	 * This property indicates the cumulative amount (consumption) of flowing water using a 9-digit number.<br>0-0x3B9AC9FF (0-999,999,999�j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : mandatory
	 */
	protected abstract byte[] getMeasuredCumulativeAmountOfFlowingWater();
	/**
	 * This property indicates the unit (multiplying factor) for the measured cumulative amount of flowing water and the historical data of measured cumulative amounts of flowing water.<br>0x00: 1��3 0x01: 0.1��3 0x02: 0.01��3 0x03: 0.001��3 0x04: 0.0001��3�iInitial value�j 0x05: 0.00001��3 0x06: 0.000001��3<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : mandatory
	 */
	protected abstract byte[] getUnitForMeasuredCumulativeAmountsOfFlowingWater();
	/**
	 * This property indicates the historical data of measured cumulative amounts (consumptions) of running water, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0-0x3B9AC9FF (0-999,999.999m3�j<br><br>Data type : unsigned long �~48<br>Data size : 192 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater() {return null;}
	/**
	 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>Abnormal value detected: 0x41 No abnormal value detected: 0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
	 */
	protected byte[] getDetectionOfAbnormalValueInMeteringData() {return null;}
	/**
	 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>0-0xFFFFFFFF<br><br>Data type : unsigned long<br>Data size : 5 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getSecurityDataInformation() {return null;}
	/**
	 * This property indicates the ID number of the meter.<br>The ID number is specified using ASCII code. �iInitial value�F�g000000�h�j<br><br>Data type : unsigned char<br>Data size : 6 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setIdNumberSetting(byte[] edt) {return false;}
	/**
	 * This property indicates the ID number of the meter.<br>The ID number is specified using ASCII code. �iInitial value�F�g000000�h�j<br><br>Data type : unsigned char<br>Data size : 6 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getIdNumberSetting() {return null;}
	/**
	 * This property indicates the month and year in which the verification of the meter will expire.<br>The month and year are specified using ASCII code. xxxx xx Year Month<br><br>Data type : unsigned char<br>Data size : 6 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setVerificationExpirationInformation(byte[] edt) {return false;}
	/**
	 * This property indicates the month and year in which the verification of the meter will expire.<br>The month and year are specified using ASCII code. xxxx xx Year Month<br><br>Data type : unsigned char<br>Data size : 6 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getVerificationExpirationInformation() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_FLOWING_WATER_CLASSIFICATION:
			res.addProperty(epc, edt, setFlowingWaterClassification(edt));
			break;
		case EPC_OWNER_CLASSIFICATION:
			res.addProperty(epc, edt, setOwnerClassification(edt));
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
		case EPC_FLOWING_WATER_CLASSIFICATION:
			edt = getFlowingWaterClassification();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OWNER_CLASSIFICATION:
			edt = getOwnerClassification();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_FLOWING_WATER:
			edt = getMeasuredCumulativeAmountOfFlowingWater();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_UNIT_FOR_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER:
			edt = getUnitForMeasuredCumulativeAmountsOfFlowingWater();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER:
			edt = getHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater();
			res.addProperty(epc, edt, (edt != null && (edt.length == 192)));
			break;
		case EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA:
			edt = getDetectionOfAbnormalValueInMeteringData();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SECURITY_DATA_INFORMATION:
			edt = getSecurityDataInformation();
			res.addProperty(epc, edt, (edt != null && (edt.length == 5)));
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
			case EPC_FLOWING_WATER_CLASSIFICATION:
				onSetFlowingWaterClassification(eoj, tid, (pdc != 0));
				break;
			case EPC_OWNER_CLASSIFICATION:
				onSetOwnerClassification(eoj, tid, (pdc != 0));
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
			case EPC_FLOWING_WATER_CLASSIFICATION:
				onGetFlowingWaterClassification(eoj, tid, pdc, edt);
				break;
			case EPC_OWNER_CLASSIFICATION:
				onGetOwnerClassification(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_FLOWING_WATER:
				onGetMeasuredCumulativeAmountOfFlowingWater(eoj, tid, pdc, edt);
				break;
			case EPC_UNIT_FOR_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER:
				onGetUnitForMeasuredCumulativeAmountsOfFlowingWater(eoj, tid, pdc, edt);
				break;
			case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER:
				onGetHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater(eoj, tid, pdc, edt);
				break;
			case EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA:
				onGetDetectionOfAbnormalValueInMeteringData(eoj, tid, pdc, edt);
				break;
			case EPC_SECURITY_DATA_INFORMATION:
				onGetSecurityDataInformation(eoj, tid, pdc, edt);
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
		 * This property indicates the water flowmeter type.<br>0x30�Frunning water 0x31�Frecycled water 0x32�Fwarm water 0x33�Fother water<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetFlowingWaterClassification(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the water flowmeter type.<br>0x30�Frunning water 0x31�Frecycled water 0x32�Fwarm water 0x33�Fother water<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetFlowingWaterClassification(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the owner of the meter in the form of owner classification.<br>0x30�FNot specified 0x31�FPublic waterworks company 0x32�FPrivate sector company 0x33�FIndividual<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOwnerClassification(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the owner of the meter in the form of owner classification.<br>0x30�FNot specified 0x31�FPublic waterworks company 0x32�FPrivate sector company 0x33�FIndividual<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOwnerClassification(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the cumulative amount (consumption) of flowing water using a 9-digit number.<br>0-0x3B9AC9FF (0-999,999,999�j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : mandatory
		 */
		protected void onGetMeasuredCumulativeAmountOfFlowingWater(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the unit (multiplying factor) for the measured cumulative amount of flowing water and the historical data of measured cumulative amounts of flowing water.<br>0x00: 1��3 0x01: 0.1��3 0x02: 0.01��3 0x03: 0.001��3 0x04: 0.0001��3�iInitial value�j 0x05: 0.00001��3 0x06: 0.000001��3<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : mandatory
		 */
		protected void onGetUnitForMeasuredCumulativeAmountsOfFlowingWater(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the historical data of measured cumulative amounts (consumptions) of running water, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0-0x3B9AC9FF (0-999,999.999m3�j<br><br>Data type : unsigned long �~48<br>Data size : 192 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>Abnormal value detected: 0x41 No abnormal value detected: 0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
		 */
		protected void onGetDetectionOfAbnormalValueInMeteringData(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>0-0xFFFFFFFF<br><br>Data type : unsigned long<br>Data size : 5 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetSecurityDataInformation(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the ID number of the meter.<br>The ID number is specified using ASCII code. �iInitial value�F�g000000�h�j<br><br>Data type : unsigned char<br>Data size : 6 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetIdNumberSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the ID number of the meter.<br>The ID number is specified using ASCII code. �iInitial value�F�g000000�h�j<br><br>Data type : unsigned char<br>Data size : 6 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetIdNumberSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br>The month and year are specified using ASCII code. xxxx xx Year Month<br><br>Data type : unsigned char<br>Data size : 6 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetVerificationExpirationInformation(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br>The month and year are specified using ASCII code. xxxx xx Year Month<br><br>Data type : unsigned char<br>Data size : 6 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetVerificationExpirationInformation(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * This property indicates the water flowmeter type.<br>0x30�Frunning water 0x31�Frecycled water 0x32�Fwarm water 0x33�Fother water<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetFlowingWaterClassification(byte[] edt);
		/**
		 * This property indicates the owner of the meter in the form of owner classification.<br>0x30�FNot specified 0x31�FPublic waterworks company 0x32�FPrivate sector company 0x33�FIndividual<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOwnerClassification(byte[] edt);
		/**
		 * This property indicates the ID number of the meter.<br>The ID number is specified using ASCII code. �iInitial value�F�g000000�h�j<br><br>Data type : unsigned char<br>Data size : 6 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetIdNumberSetting(byte[] edt);
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br>The month and year are specified using ASCII code. xxxx xx Year Month<br><br>Data type : unsigned char<br>Data size : 6 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetVerificationExpirationInformation(byte[] edt);
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
		public Setter reqSetFlowingWaterClassification(byte[] edt) {
			addProperty(EPC_FLOWING_WATER_CLASSIFICATION, edt, setFlowingWaterClassification(edt));
			return this;
		}
		@Override
		public Setter reqSetOwnerClassification(byte[] edt) {
			addProperty(EPC_OWNER_CLASSIFICATION, edt, setOwnerClassification(edt));
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
		public Setter reqSetFlowingWaterClassification(byte[] edt) {
			addProperty(EPC_FLOWING_WATER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOwnerClassification(byte[] edt) {
			addProperty(EPC_OWNER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
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
		 * This property indicates the water flowmeter type.<br>0x30�Frunning water 0x31�Frecycled water 0x32�Fwarm water 0x33�Fother water<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetFlowingWaterClassification();
		/**
		 * This property indicates the owner of the meter in the form of owner classification.<br>0x30�FNot specified 0x31�FPublic waterworks company 0x32�FPrivate sector company 0x33�FIndividual<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOwnerClassification();
		/**
		 * This property indicates the cumulative amount (consumption) of flowing water using a 9-digit number.<br>0-0x3B9AC9FF (0-999,999,999�j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Getter reqGetMeasuredCumulativeAmountOfFlowingWater();
		/**
		 * This property indicates the unit (multiplying factor) for the measured cumulative amount of flowing water and the historical data of measured cumulative amounts of flowing water.<br>0x00: 1��3 0x01: 0.1��3 0x02: 0.01��3 0x03: 0.001��3 0x04: 0.0001��3�iInitial value�j 0x05: 0.00001��3 0x06: 0.000001��3<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Getter reqGetUnitForMeasuredCumulativeAmountsOfFlowingWater();
		/**
		 * This property indicates the historical data of measured cumulative amounts (consumptions) of running water, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0-0x3B9AC9FF (0-999,999.999m3�j<br><br>Data type : unsigned long �~48<br>Data size : 192 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater();
		/**
		 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>Abnormal value detected: 0x41 No abnormal value detected: 0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
		 */
		public Getter reqGetDetectionOfAbnormalValueInMeteringData();
		/**
		 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>0-0xFFFFFFFF<br><br>Data type : unsigned long<br>Data size : 5 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetSecurityDataInformation();
		/**
		 * This property indicates the ID number of the meter.<br>The ID number is specified using ASCII code. �iInitial value�F�g000000�h�j<br><br>Data type : unsigned char<br>Data size : 6 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetIdNumberSetting();
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br>The month and year are specified using ASCII code. xxxx xx Year Month<br><br>Data type : unsigned char<br>Data size : 6 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetVerificationExpirationInformation();
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
		public Getter reqGetFlowingWaterClassification() {
			byte[] edt = getFlowingWaterClassification();
			addProperty(EPC_FLOWING_WATER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOwnerClassification() {
			byte[] edt = getOwnerClassification();
			addProperty(EPC_OWNER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeAmountOfFlowingWater() {
			byte[] edt = getMeasuredCumulativeAmountOfFlowingWater();
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_FLOWING_WATER, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetUnitForMeasuredCumulativeAmountsOfFlowingWater() {
			byte[] edt = getUnitForMeasuredCumulativeAmountsOfFlowingWater();
			addProperty(EPC_UNIT_FOR_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater() {
			byte[] edt = getHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater();
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER, edt, (edt != null && (edt.length == 192)));
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
			addProperty(EPC_SECURITY_DATA_INFORMATION, edt, (edt != null && (edt.length == 5)));
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
		public Getter reqGetFlowingWaterClassification() {
			addProperty(EPC_FLOWING_WATER_CLASSIFICATION);
			return this;
		}
		@Override
		public Getter reqGetOwnerClassification() {
			addProperty(EPC_OWNER_CLASSIFICATION);
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeAmountOfFlowingWater() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_FLOWING_WATER);
			return this;
		}
		@Override
		public Getter reqGetUnitForMeasuredCumulativeAmountsOfFlowingWater() {
			addProperty(EPC_UNIT_FOR_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER);
			return this;
		}
		@Override
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater() {
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER);
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
		 * This property indicates the water flowmeter type.<br>0x30�Frunning water 0x31�Frecycled water 0x32�Fwarm water 0x33�Fother water<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformFlowingWaterClassification();
		/**
		 * This property indicates the owner of the meter in the form of owner classification.<br>0x30�FNot specified 0x31�FPublic waterworks company 0x32�FPrivate sector company 0x33�FIndividual<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOwnerClassification();
		/**
		 * This property indicates the cumulative amount (consumption) of flowing water using a 9-digit number.<br>0-0x3B9AC9FF (0-999,999,999�j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Informer reqInformMeasuredCumulativeAmountOfFlowingWater();
		/**
		 * This property indicates the unit (multiplying factor) for the measured cumulative amount of flowing water and the historical data of measured cumulative amounts of flowing water.<br>0x00: 1��3 0x01: 0.1��3 0x02: 0.01��3 0x03: 0.001��3 0x04: 0.0001��3�iInitial value�j 0x05: 0.00001��3 0x06: 0.000001��3<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Informer reqInformUnitForMeasuredCumulativeAmountsOfFlowingWater();
		/**
		 * This property indicates the historical data of measured cumulative amounts (consumptions) of running water, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0-0x3B9AC9FF (0-999,999.999m3�j<br><br>Data type : unsigned long �~48<br>Data size : 192 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater();
		/**
		 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>Abnormal value detected: 0x41 No abnormal value detected: 0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
		 */
		public Informer reqInformDetectionOfAbnormalValueInMeteringData();
		/**
		 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>0-0xFFFFFFFF<br><br>Data type : unsigned long<br>Data size : 5 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformSecurityDataInformation();
		/**
		 * This property indicates the ID number of the meter.<br>The ID number is specified using ASCII code. �iInitial value�F�g000000�h�j<br><br>Data type : unsigned char<br>Data size : 6 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformIdNumberSetting();
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br>The month and year are specified using ASCII code. xxxx xx Year Month<br><br>Data type : unsigned char<br>Data size : 6 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformVerificationExpirationInformation();
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
		public Informer reqInformFlowingWaterClassification() {
			byte[] edt = getFlowingWaterClassification();
			addProperty(EPC_FLOWING_WATER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOwnerClassification() {
			byte[] edt = getOwnerClassification();
			addProperty(EPC_OWNER_CLASSIFICATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeAmountOfFlowingWater() {
			byte[] edt = getMeasuredCumulativeAmountOfFlowingWater();
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_FLOWING_WATER, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformUnitForMeasuredCumulativeAmountsOfFlowingWater() {
			byte[] edt = getUnitForMeasuredCumulativeAmountsOfFlowingWater();
			addProperty(EPC_UNIT_FOR_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater() {
			byte[] edt = getHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater();
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER, edt, (edt != null && (edt.length == 192)));
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
			addProperty(EPC_SECURITY_DATA_INFORMATION, edt, (edt != null && (edt.length == 5)));
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
