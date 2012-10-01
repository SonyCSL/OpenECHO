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
package com.sonycsl.echo.eoj.device.sensor;

import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;

public abstract class MicromotionSensor extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = MicromotionSensor.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x00;
	public static final byte CLASS_CODE = (byte)0x26;

	protected static final byte EPC_DETECTION_THRESHOLD_LEVEL = (byte)0xB0;
	protected static final byte EPC_MICROMOTION_DETECTION_STATUS = (byte)0xB1;
	protected static final byte EPC_DETECTION_COUNTER = (byte)0xB2;
	protected static final byte EPC_SAMPLING_COUNT = (byte)0xBC;
	protected static final byte EPC_SAMPLING_CYCLE = (byte)0xBD;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Specifies detection threshold level (8-step).<br>0x31.0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setDetectionThresholdLevel(byte[] edt) {return false;}
	/**
	 * Specifies detection threshold level (8-step).<br>0x31.0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getDetectionThresholdLevel() {return null;}
	/**
	 * This property indicates whether micromotion is detected or not.<br>Micromotion detected = 0x41 Micromotion not detected = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : mandatory<br>Announcement at status change
	 */
	protected abstract byte[] getMicromotionDetectionStatus();
	/**
	 * This property indicates micromotion detection count.<br>0x0000.0xFFFE (0.65534)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setDetectionCounter(byte[] edt) {return false;}
	/**
	 * This property indicates micromotion detection count.<br>0x0000.0xFFFE (0.65534)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getDetectionCounter() {return null;}
	/**
	 * This property indicates micromotion detection sampling count.<br>0x0000.0xFFFE (0.65534)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setSamplingCount(byte[] edt) {return false;}
	/**
	 * This property indicates micromotion detection sampling count.<br>0x0000.0xFFFE (0.65534)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getSamplingCount() {return null;}
	/**
	 * This property indicates micromotion detection sampling cycle.<br>0x0000.0xFFFE (0.65534)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setSamplingCycle(byte[] edt) {return false;}
	/**
	 * This property indicates micromotion detection sampling cycle.<br>0x0000.0xFFFE (0.65534)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getSamplingCycle() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_DETECTION_THRESHOLD_LEVEL:
			res.addProperty(epc, edt, setDetectionThresholdLevel(edt));
			break;
		case EPC_DETECTION_COUNTER:
			res.addProperty(epc, edt, setDetectionCounter(edt));
			break;
		case EPC_SAMPLING_COUNT:
			res.addProperty(epc, edt, setSamplingCount(edt));
			break;
		case EPC_SAMPLING_CYCLE:
			res.addProperty(epc, edt, setSamplingCycle(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_DETECTION_THRESHOLD_LEVEL:
			edt = getDetectionThresholdLevel();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MICROMOTION_DETECTION_STATUS:
			edt = getMicromotionDetectionStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DETECTION_COUNTER:
			edt = getDetectionCounter();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_SAMPLING_COUNT:
			edt = getSamplingCount();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_SAMPLING_CYCLE:
			edt = getSamplingCycle();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
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
			case EPC_DETECTION_THRESHOLD_LEVEL:
				onSetDetectionThresholdLevel(eoj, tid, (pdc != 0));
				break;
			case EPC_DETECTION_COUNTER:
				onSetDetectionCounter(eoj, tid, (pdc != 0));
				break;
			case EPC_SAMPLING_COUNT:
				onSetSamplingCount(eoj, tid, (pdc != 0));
				break;
			case EPC_SAMPLING_CYCLE:
				onSetSamplingCycle(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_DETECTION_THRESHOLD_LEVEL:
				onGetDetectionThresholdLevel(eoj, tid, pdc, edt);
				break;
			case EPC_MICROMOTION_DETECTION_STATUS:
				onGetMicromotionDetectionStatus(eoj, tid, pdc, edt);
				break;
			case EPC_DETECTION_COUNTER:
				onGetDetectionCounter(eoj, tid, pdc, edt);
				break;
			case EPC_SAMPLING_COUNT:
				onGetSamplingCount(eoj, tid, pdc, edt);
				break;
			case EPC_SAMPLING_CYCLE:
				onGetSamplingCycle(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * Specifies detection threshold level (8-step).<br>0x31.0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetDetectionThresholdLevel(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Specifies detection threshold level (8-step).<br>0x31.0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetDetectionThresholdLevel(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates whether micromotion is detected or not.<br>Micromotion detected = 0x41 Micromotion not detected = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : mandatory<br>Announcement at status change
		 */
		protected void onGetMicromotionDetectionStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates micromotion detection count.<br>0x0000.0xFFFE (0.65534)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetDetectionCounter(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates micromotion detection count.<br>0x0000.0xFFFE (0.65534)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetDetectionCounter(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates micromotion detection sampling count.<br>0x0000.0xFFFE (0.65534)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetSamplingCount(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates micromotion detection sampling count.<br>0x0000.0xFFFE (0.65534)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetSamplingCount(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates micromotion detection sampling cycle.<br>0x0000.0xFFFE (0.65534)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetSamplingCycle(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates micromotion detection sampling cycle.<br>0x0000.0xFFFE (0.65534)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetSamplingCycle(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Specifies detection threshold level (8-step).<br>0x31.0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetDetectionThresholdLevel(byte[] edt);
		/**
		 * This property indicates micromotion detection count.<br>0x0000.0xFFFE (0.65534)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetDetectionCounter(byte[] edt);
		/**
		 * This property indicates micromotion detection sampling count.<br>0x0000.0xFFFE (0.65534)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetSamplingCount(byte[] edt);
		/**
		 * This property indicates micromotion detection sampling cycle.<br>0x0000.0xFFFE (0.65534)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetSamplingCycle(byte[] edt);
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
		public Setter reqSetDetectionThresholdLevel(byte[] edt) {
			addProperty(EPC_DETECTION_THRESHOLD_LEVEL, edt, setDetectionThresholdLevel(edt));
			return this;
		}
		@Override
		public Setter reqSetDetectionCounter(byte[] edt) {
			addProperty(EPC_DETECTION_COUNTER, edt, setDetectionCounter(edt));
			return this;
		}
		@Override
		public Setter reqSetSamplingCount(byte[] edt) {
			addProperty(EPC_SAMPLING_COUNT, edt, setSamplingCount(edt));
			return this;
		}
		@Override
		public Setter reqSetSamplingCycle(byte[] edt) {
			addProperty(EPC_SAMPLING_CYCLE, edt, setSamplingCycle(edt));
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
		public Setter reqSetDetectionThresholdLevel(byte[] edt) {
			addProperty(EPC_DETECTION_THRESHOLD_LEVEL, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetDetectionCounter(byte[] edt) {
			addProperty(EPC_DETECTION_COUNTER, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetSamplingCount(byte[] edt) {
			addProperty(EPC_SAMPLING_COUNT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetSamplingCycle(byte[] edt) {
			addProperty(EPC_SAMPLING_CYCLE, edt, (edt != null && (edt.length == 2)));
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
		 * Specifies detection threshold level (8-step).<br>0x31.0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetDetectionThresholdLevel();
		/**
		 * This property indicates whether micromotion is detected or not.<br>Micromotion detected = 0x41 Micromotion not detected = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : mandatory<br>Announcement at status change
		 */
		public Getter reqGetMicromotionDetectionStatus();
		/**
		 * This property indicates micromotion detection count.<br>0x0000.0xFFFE (0.65534)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetDetectionCounter();
		/**
		 * This property indicates micromotion detection sampling count.<br>0x0000.0xFFFE (0.65534)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetSamplingCount();
		/**
		 * This property indicates micromotion detection sampling cycle.<br>0x0000.0xFFFE (0.65534)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetSamplingCycle();
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
		public Getter reqGetDetectionThresholdLevel() {
			byte[] edt = getDetectionThresholdLevel();
			addProperty(EPC_DETECTION_THRESHOLD_LEVEL, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMicromotionDetectionStatus() {
			byte[] edt = getMicromotionDetectionStatus();
			addProperty(EPC_MICROMOTION_DETECTION_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetDetectionCounter() {
			byte[] edt = getDetectionCounter();
			addProperty(EPC_DETECTION_COUNTER, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetSamplingCount() {
			byte[] edt = getSamplingCount();
			addProperty(EPC_SAMPLING_COUNT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetSamplingCycle() {
			byte[] edt = getSamplingCycle();
			addProperty(EPC_SAMPLING_CYCLE, edt, (edt != null && (edt.length == 2)));
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
		public Getter reqGetDetectionThresholdLevel() {
			addProperty(EPC_DETECTION_THRESHOLD_LEVEL);
			return this;
		}
		@Override
		public Getter reqGetMicromotionDetectionStatus() {
			addProperty(EPC_MICROMOTION_DETECTION_STATUS);
			return this;
		}
		@Override
		public Getter reqGetDetectionCounter() {
			addProperty(EPC_DETECTION_COUNTER);
			return this;
		}
		@Override
		public Getter reqGetSamplingCount() {
			addProperty(EPC_SAMPLING_COUNT);
			return this;
		}
		@Override
		public Getter reqGetSamplingCycle() {
			addProperty(EPC_SAMPLING_CYCLE);
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
		 * Specifies detection threshold level (8-step).<br>0x31.0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformDetectionThresholdLevel();
		/**
		 * This property indicates whether micromotion is detected or not.<br>Micromotion detected = 0x41 Micromotion not detected = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : mandatory<br>Announcement at status change
		 */
		public Informer reqInformMicromotionDetectionStatus();
		/**
		 * This property indicates micromotion detection count.<br>0x0000.0xFFFE (0.65534)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformDetectionCounter();
		/**
		 * This property indicates micromotion detection sampling count.<br>0x0000.0xFFFE (0.65534)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformSamplingCount();
		/**
		 * This property indicates micromotion detection sampling cycle.<br>0x0000.0xFFFE (0.65534)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformSamplingCycle();
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
		public Informer reqInformDetectionThresholdLevel() {
			byte[] edt = getDetectionThresholdLevel();
			addProperty(EPC_DETECTION_THRESHOLD_LEVEL, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMicromotionDetectionStatus() {
			byte[] edt = getMicromotionDetectionStatus();
			addProperty(EPC_MICROMOTION_DETECTION_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDetectionCounter() {
			byte[] edt = getDetectionCounter();
			addProperty(EPC_DETECTION_COUNTER, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformSamplingCount() {
			byte[] edt = getSamplingCount();
			addProperty(EPC_SAMPLING_COUNT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformSamplingCycle() {
			byte[] edt = getSamplingCycle();
			addProperty(EPC_SAMPLING_CYCLE, edt, (edt != null && (edt.length == 2)));
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
		public Informer reqInformDetectionThresholdLevel() {
			addProperty(EPC_DETECTION_THRESHOLD_LEVEL);
			return this;
		}
		@Override
		public Informer reqInformMicromotionDetectionStatus() {
			addProperty(EPC_MICROMOTION_DETECTION_STATUS);
			return this;
		}
		@Override
		public Informer reqInformDetectionCounter() {
			addProperty(EPC_DETECTION_COUNTER);
			return this;
		}
		@Override
		public Informer reqInformSamplingCount() {
			addProperty(EPC_SAMPLING_COUNT);
			return this;
		}
		@Override
		public Informer reqInformSamplingCycle() {
			addProperty(EPC_SAMPLING_CYCLE);
			return this;
		}
	}
}
