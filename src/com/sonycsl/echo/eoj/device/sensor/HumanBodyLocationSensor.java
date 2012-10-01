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

public abstract class HumanBodyLocationSensor extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = HumanBodyLocationSensor.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x00;
	public static final byte CLASS_CODE = (byte)0x2B;

	protected static final byte EPC_HUMAN_BODY_DETECTION_LOCATION1 = (byte)0xE0;
	protected static final byte EPC_MAXIMUM_NUMBER_OF_HUMAN_BODY_ID_FS = (byte)0xE1;
	protected static final byte EPC_HUMAN_BODY_DETECTION_LOCATION2 = (byte)0xE2;
	protected static final byte EPC_HUMAN_BODY_EXISTENCE_INFORMATION = (byte)0xE3;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates human body detection location. The array element number indicates a human body ID.<br>1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br><br>Data type : unsigned char x 3 x max 128<br>Data size : 3 x max 128 bytes<br>Set : undefined<br>Get : mandatory
	 */
	protected abstract byte[] getHumanBodyDetectionLocation1();
	/**
	 * This property indicates maximum number of human body IDs that can be registered for human body detection location 1.<br>0x0001.0x0080 (= 1.128)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMaximumNumberOfHumanBodyIdFs() {return null;}
	/**
	 * This property indicates human body detection location.<br>1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br><br>Data type : unsigned char x 3<br>Data size : 3 bytes<br>Set : undefined<br>Get : mandatory
	 */
	protected abstract byte[] getHumanBodyDetectionLocation2();
	/**
	 * Array element number information retained by human body detection location 1.<br>(See (5) below for details.)<br><br>Data type : unsigned char x 16<br>Data size : 16 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getHumanBodyExistenceInformation() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_HUMAN_BODY_DETECTION_LOCATION1:
			edt = getHumanBodyDetectionLocation1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 3)));
			break;
		case EPC_MAXIMUM_NUMBER_OF_HUMAN_BODY_ID_FS:
			edt = getMaximumNumberOfHumanBodyIdFs();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_HUMAN_BODY_DETECTION_LOCATION2:
			edt = getHumanBodyDetectionLocation2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 3)));
			break;
		case EPC_HUMAN_BODY_EXISTENCE_INFORMATION:
			edt = getHumanBodyExistenceInformation();
			res.addProperty(epc, edt, (edt != null && (edt.length == 16)));
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

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_HUMAN_BODY_DETECTION_LOCATION1:
				onGetHumanBodyDetectionLocation1(eoj, tid, pdc, edt);
				break;
			case EPC_MAXIMUM_NUMBER_OF_HUMAN_BODY_ID_FS:
				onGetMaximumNumberOfHumanBodyIdFs(eoj, tid, pdc, edt);
				break;
			case EPC_HUMAN_BODY_DETECTION_LOCATION2:
				onGetHumanBodyDetectionLocation2(eoj, tid, pdc, edt);
				break;
			case EPC_HUMAN_BODY_EXISTENCE_INFORMATION:
				onGetHumanBodyExistenceInformation(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates human body detection location. The array element number indicates a human body ID.<br>1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br><br>Data type : unsigned char x 3 x max 128<br>Data size : 3 x max 128 bytes<br>Set : undefined<br>Get : mandatory
		 */
		protected void onGetHumanBodyDetectionLocation1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates maximum number of human body IDs that can be registered for human body detection location 1.<br>0x0001.0x0080 (= 1.128)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMaximumNumberOfHumanBodyIdFs(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates human body detection location.<br>1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br><br>Data type : unsigned char x 3<br>Data size : 3 bytes<br>Set : undefined<br>Get : mandatory
		 */
		protected void onGetHumanBodyDetectionLocation2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Array element number information retained by human body detection location 1.<br>(See (5) below for details.)<br><br>Data type : unsigned char x 16<br>Data size : 16 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetHumanBodyExistenceInformation(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * This property indicates human body detection location. The array element number indicates a human body ID.<br>1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br><br>Data type : unsigned char x 3 x max 128<br>Data size : 3 x max 128 bytes<br>Set : undefined<br>Get : mandatory
		 */
		public Getter reqGetHumanBodyDetectionLocation1();
		/**
		 * This property indicates maximum number of human body IDs that can be registered for human body detection location 1.<br>0x0001.0x0080 (= 1.128)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMaximumNumberOfHumanBodyIdFs();
		/**
		 * This property indicates human body detection location.<br>1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br><br>Data type : unsigned char x 3<br>Data size : 3 bytes<br>Set : undefined<br>Get : mandatory
		 */
		public Getter reqGetHumanBodyDetectionLocation2();
		/**
		 * Array element number information retained by human body detection location 1.<br>(See (5) below for details.)<br><br>Data type : unsigned char x 16<br>Data size : 16 bytes<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetHumanBodyExistenceInformation();
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
		public Getter reqGetHumanBodyDetectionLocation1() {
			byte[] edt = getHumanBodyDetectionLocation1();
			addProperty(EPC_HUMAN_BODY_DETECTION_LOCATION1, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Getter reqGetMaximumNumberOfHumanBodyIdFs() {
			byte[] edt = getMaximumNumberOfHumanBodyIdFs();
			addProperty(EPC_MAXIMUM_NUMBER_OF_HUMAN_BODY_ID_FS, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetHumanBodyDetectionLocation2() {
			byte[] edt = getHumanBodyDetectionLocation2();
			addProperty(EPC_HUMAN_BODY_DETECTION_LOCATION2, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Getter reqGetHumanBodyExistenceInformation() {
			byte[] edt = getHumanBodyExistenceInformation();
			addProperty(EPC_HUMAN_BODY_EXISTENCE_INFORMATION, edt, (edt != null && (edt.length == 16)));
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
		public Getter reqGetHumanBodyDetectionLocation1() {
			addProperty(EPC_HUMAN_BODY_DETECTION_LOCATION1);
			return this;
		}
		@Override
		public Getter reqGetMaximumNumberOfHumanBodyIdFs() {
			addProperty(EPC_MAXIMUM_NUMBER_OF_HUMAN_BODY_ID_FS);
			return this;
		}
		@Override
		public Getter reqGetHumanBodyDetectionLocation2() {
			addProperty(EPC_HUMAN_BODY_DETECTION_LOCATION2);
			return this;
		}
		@Override
		public Getter reqGetHumanBodyExistenceInformation() {
			addProperty(EPC_HUMAN_BODY_EXISTENCE_INFORMATION);
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
		 * This property indicates human body detection location. The array element number indicates a human body ID.<br>1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br><br>Data type : unsigned char x 3 x max 128<br>Data size : 3 x max 128 bytes<br>Set : undefined<br>Get : mandatory
		 */
		public Informer reqInformHumanBodyDetectionLocation1();
		/**
		 * This property indicates maximum number of human body IDs that can be registered for human body detection location 1.<br>0x0001.0x0080 (= 1.128)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMaximumNumberOfHumanBodyIdFs();
		/**
		 * This property indicates human body detection location.<br>1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br><br>Data type : unsigned char x 3<br>Data size : 3 bytes<br>Set : undefined<br>Get : mandatory
		 */
		public Informer reqInformHumanBodyDetectionLocation2();
		/**
		 * Array element number information retained by human body detection location 1.<br>(See (5) below for details.)<br><br>Data type : unsigned char x 16<br>Data size : 16 bytes<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformHumanBodyExistenceInformation();
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
		public Informer reqInformHumanBodyDetectionLocation1() {
			byte[] edt = getHumanBodyDetectionLocation1();
			addProperty(EPC_HUMAN_BODY_DETECTION_LOCATION1, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Informer reqInformMaximumNumberOfHumanBodyIdFs() {
			byte[] edt = getMaximumNumberOfHumanBodyIdFs();
			addProperty(EPC_MAXIMUM_NUMBER_OF_HUMAN_BODY_ID_FS, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformHumanBodyDetectionLocation2() {
			byte[] edt = getHumanBodyDetectionLocation2();
			addProperty(EPC_HUMAN_BODY_DETECTION_LOCATION2, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Informer reqInformHumanBodyExistenceInformation() {
			byte[] edt = getHumanBodyExistenceInformation();
			addProperty(EPC_HUMAN_BODY_EXISTENCE_INFORMATION, edt, (edt != null && (edt.length == 16)));
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
		public Informer reqInformHumanBodyDetectionLocation1() {
			addProperty(EPC_HUMAN_BODY_DETECTION_LOCATION1);
			return this;
		}
		@Override
		public Informer reqInformMaximumNumberOfHumanBodyIdFs() {
			addProperty(EPC_MAXIMUM_NUMBER_OF_HUMAN_BODY_ID_FS);
			return this;
		}
		@Override
		public Informer reqInformHumanBodyDetectionLocation2() {
			addProperty(EPC_HUMAN_BODY_DETECTION_LOCATION2);
			return this;
		}
		@Override
		public Informer reqInformHumanBodyExistenceInformation() {
			addProperty(EPC_HUMAN_BODY_EXISTENCE_INFORMATION);
			return this;
		}
	}
}
