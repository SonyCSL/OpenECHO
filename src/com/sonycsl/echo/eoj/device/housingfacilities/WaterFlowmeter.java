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
	 * This property indicates the water flowmeter type.<br>0x30�Frunning water 0x31�Frecycled water 0x32�Fwarm water 0x33�Fother water
	 */
	protected boolean setFlowingWaterClassification(byte[] edt) {return false;}
	/**
	 * This property indicates the water flowmeter type.<br>0x30�Frunning water 0x31�Frecycled water 0x32�Fwarm water 0x33�Fother water
	 */
	protected byte[] getFlowingWaterClassification() {return null;}
	/**
	 * This property indicates the owner of the meter in the form of owner classification.<br>0x30�FNot specified 0x31�FPublic waterworks company 0x32�FPrivate sector company 0x33�FIndividual
	 */
	protected boolean setOwnerClassification(byte[] edt) {return false;}
	/**
	 * This property indicates the owner of the meter in the form of owner classification.<br>0x30�FNot specified 0x31�FPublic waterworks company 0x32�FPrivate sector company 0x33�FIndividual
	 */
	protected byte[] getOwnerClassification() {return null;}
	/**
	 * This property indicates the cumulative amount (consumption) of flowing water using a 9-digit number.<br>0-0x3B9AC9FF (0-999,999,999�j
	 */
	protected abstract byte[] getMeasuredCumulativeAmountOfFlowingWater();
	/**
	 * This property indicates the unit (multiplying factor) for the measured cumulative amount of flowing water and the historical data of measured cumulative amounts of flowing water.<br>0x00: 1��3 0x01: 0.1��3 0x02: 0.01��3 0x03: 0.001��3 0x04: 0.0001��3�iInitial value�j 0x05: 0.00001��3 0x06: 0.000001��3
	 */
	protected abstract byte[] getUnitForMeasuredCumulativeAmountsOfFlowingWater();
	/**
	 * This property indicates the historical data of measured cumulative amounts (consumptions) of running water, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0-0x3B9AC9FF (0-999,999.999m3�j
	 */
	protected byte[] getHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater() {return null;}
	/**
	 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>Abnormal value detected: 0x41 No abnormal value detected: 0x42
	 */
	protected byte[] getDetectionOfAbnormalValueInMeteringData() {return null;}
	/**
	 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>0-0xFFFFFFFF
	 */
	protected byte[] getSecurityDataInformation() {return null;}
	/**
	 * This property indicates the ID number of the meter.<br>The ID number is specified using ASCII code. �iInitial value�F�g000000�h�j
	 */
	protected boolean setIdNumberSetting(byte[] edt) {return false;}
	/**
	 * This property indicates the ID number of the meter.<br>The ID number is specified using ASCII code. �iInitial value�F�g000000�h�j
	 */
	protected byte[] getIdNumberSetting() {return null;}
	/**
	 * This property indicates the month and year in which the verification of the meter will expire.<br>The month and year are specified using ASCII code. xxxx xx Year Month
	 */
	protected boolean setVerificationExpirationInformation(byte[] edt) {return false;}
	/**
	 * This property indicates the month and year in which the verification of the meter will expire.<br>The month and year are specified using ASCII code. xxxx xx Year Month
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
		 * This property indicates the water flowmeter type.<br>0x30�Frunning water 0x31�Frecycled water 0x32�Fwarm water 0x33�Fother water
		 */
		protected void onSetFlowingWaterClassification(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the water flowmeter type.<br>0x30�Frunning water 0x31�Frecycled water 0x32�Fwarm water 0x33�Fother water
		 */
		protected void onGetFlowingWaterClassification(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the owner of the meter in the form of owner classification.<br>0x30�FNot specified 0x31�FPublic waterworks company 0x32�FPrivate sector company 0x33�FIndividual
		 */
		protected void onSetOwnerClassification(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the owner of the meter in the form of owner classification.<br>0x30�FNot specified 0x31�FPublic waterworks company 0x32�FPrivate sector company 0x33�FIndividual
		 */
		protected void onGetOwnerClassification(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the cumulative amount (consumption) of flowing water using a 9-digit number.<br>0-0x3B9AC9FF (0-999,999,999�j
		 */
		protected void onGetMeasuredCumulativeAmountOfFlowingWater(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the unit (multiplying factor) for the measured cumulative amount of flowing water and the historical data of measured cumulative amounts of flowing water.<br>0x00: 1��3 0x01: 0.1��3 0x02: 0.01��3 0x03: 0.001��3 0x04: 0.0001��3�iInitial value�j 0x05: 0.00001��3 0x06: 0.000001��3
		 */
		protected void onGetUnitForMeasuredCumulativeAmountsOfFlowingWater(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the historical data of measured cumulative amounts (consumptions) of running water, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0-0x3B9AC9FF (0-999,999.999m3�j
		 */
		protected void onGetHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>Abnormal value detected: 0x41 No abnormal value detected: 0x42
		 */
		protected void onGetDetectionOfAbnormalValueInMeteringData(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>0-0xFFFFFFFF
		 */
		protected void onGetSecurityDataInformation(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the ID number of the meter.<br>The ID number is specified using ASCII code. �iInitial value�F�g000000�h�j
		 */
		protected void onSetIdNumberSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the ID number of the meter.<br>The ID number is specified using ASCII code. �iInitial value�F�g000000�h�j
		 */
		protected void onGetIdNumberSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br>The month and year are specified using ASCII code. xxxx xx Year Month
		 */
		protected void onSetVerificationExpirationInformation(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br>The month and year are specified using ASCII code. xxxx xx Year Month
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
		 * This property indicates the water flowmeter type.<br>0x30�Frunning water 0x31�Frecycled water 0x32�Fwarm water 0x33�Fother water
		 */
		public Setter reqSetFlowingWaterClassification(byte[] edt);
		/**
		 * This property indicates the owner of the meter in the form of owner classification.<br>0x30�FNot specified 0x31�FPublic waterworks company 0x32�FPrivate sector company 0x33�FIndividual
		 */
		public Setter reqSetOwnerClassification(byte[] edt);
		/**
		 * This property indicates the ID number of the meter.<br>The ID number is specified using ASCII code. �iInitial value�F�g000000�h�j
		 */
		public Setter reqSetIdNumberSetting(byte[] edt);
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br>The month and year are specified using ASCII code. xxxx xx Year Month
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
		 * This property indicates the water flowmeter type.<br>0x30�Frunning water 0x31�Frecycled water 0x32�Fwarm water 0x33�Fother water
		 */
		public Getter reqGetFlowingWaterClassification();
		/**
		 * This property indicates the owner of the meter in the form of owner classification.<br>0x30�FNot specified 0x31�FPublic waterworks company 0x32�FPrivate sector company 0x33�FIndividual
		 */
		public Getter reqGetOwnerClassification();
		/**
		 * This property indicates the cumulative amount (consumption) of flowing water using a 9-digit number.<br>0-0x3B9AC9FF (0-999,999,999�j
		 */
		public Getter reqGetMeasuredCumulativeAmountOfFlowingWater();
		/**
		 * This property indicates the unit (multiplying factor) for the measured cumulative amount of flowing water and the historical data of measured cumulative amounts of flowing water.<br>0x00: 1��3 0x01: 0.1��3 0x02: 0.01��3 0x03: 0.001��3 0x04: 0.0001��3�iInitial value�j 0x05: 0.00001��3 0x06: 0.000001��3
		 */
		public Getter reqGetUnitForMeasuredCumulativeAmountsOfFlowingWater();
		/**
		 * This property indicates the historical data of measured cumulative amounts (consumptions) of running water, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0-0x3B9AC9FF (0-999,999.999m3�j
		 */
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater();
		/**
		 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>Abnormal value detected: 0x41 No abnormal value detected: 0x42
		 */
		public Getter reqGetDetectionOfAbnormalValueInMeteringData();
		/**
		 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>0-0xFFFFFFFF
		 */
		public Getter reqGetSecurityDataInformation();
		/**
		 * This property indicates the ID number of the meter.<br>The ID number is specified using ASCII code. �iInitial value�F�g000000�h�j
		 */
		public Getter reqGetIdNumberSetting();
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br>The month and year are specified using ASCII code. xxxx xx Year Month
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
		 * This property indicates the water flowmeter type.<br>0x30�Frunning water 0x31�Frecycled water 0x32�Fwarm water 0x33�Fother water
		 */
		public Informer reqInformFlowingWaterClassification();
		/**
		 * This property indicates the owner of the meter in the form of owner classification.<br>0x30�FNot specified 0x31�FPublic waterworks company 0x32�FPrivate sector company 0x33�FIndividual
		 */
		public Informer reqInformOwnerClassification();
		/**
		 * This property indicates the cumulative amount (consumption) of flowing water using a 9-digit number.<br>0-0x3B9AC9FF (0-999,999,999�j
		 */
		public Informer reqInformMeasuredCumulativeAmountOfFlowingWater();
		/**
		 * This property indicates the unit (multiplying factor) for the measured cumulative amount of flowing water and the historical data of measured cumulative amounts of flowing water.<br>0x00: 1��3 0x01: 0.1��3 0x02: 0.01��3 0x03: 0.001��3 0x04: 0.0001��3�iInitial value�j 0x05: 0.00001��3 0x06: 0.000001��3
		 */
		public Informer reqInformUnitForMeasuredCumulativeAmountsOfFlowingWater();
		/**
		 * This property indicates the historical data of measured cumulative amounts (consumptions) of running water, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>0x0-0x3B9AC9FF (0-999,999.999m3�j
		 */
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater();
		/**
		 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>Abnormal value detected: 0x41 No abnormal value detected: 0x42
		 */
		public Informer reqInformDetectionOfAbnormalValueInMeteringData();
		/**
		 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>0-0xFFFFFFFF
		 */
		public Informer reqInformSecurityDataInformation();
		/**
		 * This property indicates the ID number of the meter.<br>The ID number is specified using ASCII code. �iInitial value�F�g000000�h�j
		 */
		public Informer reqInformIdNumberSetting();
		/**
		 * This property indicates the month and year in which the verification of the meter will expire.<br>The month and year are specified using ASCII code. xxxx xx Year Month
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
