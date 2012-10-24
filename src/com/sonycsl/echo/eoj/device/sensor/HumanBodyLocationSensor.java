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
	
	public static final byte CLASS_GROUP_CODE = (byte)0x00;
	public static final byte CLASS_CODE = (byte)0x2B;

	public static final byte EPC_HUMAN_BODY_DETECTION_LOCATION1 = (byte)0xE0;
	public static final byte EPC_MAXIMUM_NUMBER_OF_HUMAN_BODY_ID_FS = (byte)0xE1;
	public static final byte EPC_HUMAN_BODY_DETECTION_LOCATION2 = (byte)0xE2;
	public static final byte EPC_HUMAN_BODY_EXISTENCE_INFORMATION = (byte)0xE3;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates human body detection location. The array element number indicates a human body ID.<br><br>1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br><br>Name : Human body detection location 1<br>EPC : 0xE0<br>Data Type : unsigned char x 3 x max 128<br>Data Size(Byte) : 3 x max 128 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getHumanBodyDetectionLocation1();
	private final byte[] _getHumanBodyDetectionLocation1(byte epc) {
		byte[] edt = getHumanBodyDetectionLocation1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates maximum number of human body IDs that can be registered for human body detection location 1.<br><br>0x0001.0x0080 (= 1.128)<br><br>Name : Maximum number of human body ID�fs<br>EPC : 0xE1<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMaximumNumberOfHumanBodyIdFs() {return null;}
	private final byte[] _getMaximumNumberOfHumanBodyIdFs(byte epc) {
		byte[] edt = getMaximumNumberOfHumanBodyIdFs();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates human body detection location.<br><br>1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br><br>Name : Human body detection location 2<br>EPC : 0xE2<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getHumanBodyDetectionLocation2();
	private final byte[] _getHumanBodyDetectionLocation2(byte epc) {
		byte[] edt = getHumanBodyDetectionLocation2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Array element number information retained by human body detection location 1.<br><br>(See (5) below for details.)<br><br>Name : Human body existence information<br>EPC : 0xE3<br>Data Type : unsigned char x 16<br>Data Size(Byte) : 16 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getHumanBodyExistenceInformation() {return null;}
	private final byte[] _getHumanBodyExistenceInformation(byte epc) {
		byte[] edt = getHumanBodyExistenceInformation();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


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
			edt = _getHumanBodyDetectionLocation1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 3)));
			break;
		case EPC_MAXIMUM_NUMBER_OF_HUMAN_BODY_ID_FS:
			edt = _getMaximumNumberOfHumanBodyIdFs(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_HUMAN_BODY_DETECTION_LOCATION2:
			edt = _getHumanBodyDetectionLocation2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 3)));
			break;
		case EPC_HUMAN_BODY_EXISTENCE_INFORMATION:
			edt = _getHumanBodyExistenceInformation(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 16)));
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

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_HUMAN_BODY_DETECTION_LOCATION1:
				_onGetHumanBodyDetectionLocation1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MAXIMUM_NUMBER_OF_HUMAN_BODY_ID_FS:
				_onGetMaximumNumberOfHumanBodyIdFs(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HUMAN_BODY_DETECTION_LOCATION2:
				_onGetHumanBodyDetectionLocation2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HUMAN_BODY_EXISTENCE_INFORMATION:
				_onGetHumanBodyExistenceInformation(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates human body detection location. The array element number indicates a human body ID.<br><br>1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br><br>Name : Human body detection location 1<br>EPC : 0xE0<br>Data Type : unsigned char x 3 x max 128<br>Data Size(Byte) : 3 x max 128 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetHumanBodyDetectionLocation1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHumanBodyDetectionLocation1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHumanBodyDetectionLocation1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates maximum number of human body IDs that can be registered for human body detection location 1.<br><br>0x0001.0x0080 (= 1.128)<br><br>Name : Maximum number of human body ID�fs<br>EPC : 0xE1<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMaximumNumberOfHumanBodyIdFs(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMaximumNumberOfHumanBodyIdFs(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMaximumNumberOfHumanBodyIdFs(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates human body detection location.<br><br>1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br><br>Name : Human body detection location 2<br>EPC : 0xE2<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetHumanBodyDetectionLocation2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHumanBodyDetectionLocation2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHumanBodyDetectionLocation2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Array element number information retained by human body detection location 1.<br><br>(See (5) below for details.)<br><br>Name : Human body existence information<br>EPC : 0xE3<br>Data Type : unsigned char x 16<br>Data Size(Byte) : 16 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetHumanBodyExistenceInformation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHumanBodyExistenceInformation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHumanBodyExistenceInformation(eoj, tid, esv, epc, pdc, edt);
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
		 * This property indicates human body detection location. The array element number indicates a human body ID.<br><br>1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br><br>Name : Human body detection location 1<br>EPC : 0xE0<br>Data Type : unsigned char x 3 x max 128<br>Data Size(Byte) : 3 x max 128 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetHumanBodyDetectionLocation1() {
			addProperty(EPC_HUMAN_BODY_DETECTION_LOCATION1);
			return this;
		}
		/**
		 * This property indicates maximum number of human body IDs that can be registered for human body detection location 1.<br><br>0x0001.0x0080 (= 1.128)<br><br>Name : Maximum number of human body ID�fs<br>EPC : 0xE1<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMaximumNumberOfHumanBodyIdFs() {
			addProperty(EPC_MAXIMUM_NUMBER_OF_HUMAN_BODY_ID_FS);
			return this;
		}
		/**
		 * This property indicates human body detection location.<br><br>1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br><br>Name : Human body detection location 2<br>EPC : 0xE2<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetHumanBodyDetectionLocation2() {
			addProperty(EPC_HUMAN_BODY_DETECTION_LOCATION2);
			return this;
		}
		/**
		 * Array element number information retained by human body detection location 1.<br><br>(See (5) below for details.)<br><br>Name : Human body existence information<br>EPC : 0xE3<br>Data Type : unsigned char x 16<br>Data Size(Byte) : 16 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetHumanBodyExistenceInformation() {
			addProperty(EPC_HUMAN_BODY_EXISTENCE_INFORMATION);
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
		 * This property indicates human body detection location. The array element number indicates a human body ID.<br><br>1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br><br>Name : Human body detection location 1<br>EPC : 0xE0<br>Data Type : unsigned char x 3 x max 128<br>Data Size(Byte) : 3 x max 128 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformHumanBodyDetectionLocation1();
		/**
		 * This property indicates maximum number of human body IDs that can be registered for human body detection location 1.<br><br>0x0001.0x0080 (= 1.128)<br><br>Name : Maximum number of human body ID�fs<br>EPC : 0xE1<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMaximumNumberOfHumanBodyIdFs();
		/**
		 * This property indicates human body detection location.<br><br>1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br><br>Name : Human body detection location 2<br>EPC : 0xE2<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformHumanBodyDetectionLocation2();
		/**
		 * Array element number information retained by human body detection location 1.<br><br>(See (5) below for details.)<br><br>Name : Human body existence information<br>EPC : 0xE3<br>Data Type : unsigned char x 16<br>Data Size(Byte) : 16 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformHumanBodyExistenceInformation();
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
		public Informer reqInformHumanBodyDetectionLocation1() {
			byte epc = EPC_HUMAN_BODY_DETECTION_LOCATION1;
			byte[] edt = _getHumanBodyDetectionLocation1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Informer reqInformMaximumNumberOfHumanBodyIdFs() {
			byte epc = EPC_MAXIMUM_NUMBER_OF_HUMAN_BODY_ID_FS;
			byte[] edt = _getMaximumNumberOfHumanBodyIdFs(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformHumanBodyDetectionLocation2() {
			byte epc = EPC_HUMAN_BODY_DETECTION_LOCATION2;
			byte[] edt = _getHumanBodyDetectionLocation2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Informer reqInformHumanBodyExistenceInformation() {
			byte epc = EPC_HUMAN_BODY_EXISTENCE_INFORMATION;
			byte[] edt = _getHumanBodyExistenceInformation(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 16)));
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
