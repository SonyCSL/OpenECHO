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
package com.sonycsl.echo.eoj.device.audiovisual;

import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;

public abstract class Television extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = Television.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x06;
	public static final byte CLASS_CODE = (byte)0x02;

	protected static final byte EPC_DISPLAY_CONTROL_SETTING = (byte)0xB0;
	protected static final byte EPC_CHARACTER_STRING_SETTING_ACCEPTANCE_STATUS = (byte)0xB1;
	protected static final byte EPC_SUPPORTED_CHARACTER_CODES = (byte)0xB2;
	protected static final byte EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER = (byte)0xB3;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setDisplayControlSetting(byte[] edt) {return false;}
	/**
	 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getDisplayControlSetting() {return null;}
	/**
	 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : mandatory<br>Announcement at status change
	 */
	protected abstract byte[] getCharacterStringSettingAcceptanceStatus();
	/**
	 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char ~ 2<br>Data size : 2 Byte<br>Set : undefined<br>Get : mandatory
	 */
	protected abstract byte[] getSupportedCharacterCodes();
	/**
	 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char ~ Max 247<br>Data size : Max247 B yte<br>Set : mandatory<br>Get : optional
	 */
	protected abstract boolean setCharacterStringToPresentToTheUser(byte[] edt);
	/**
	 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char ~ Max 247<br>Data size : Max247 B yte<br>Set : mandatory<br>Get : optional
	 */
	protected byte[] getCharacterStringToPresentToTheUser() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_DISPLAY_CONTROL_SETTING:
			res.addProperty(epc, edt, setDisplayControlSetting(edt));
			break;
		case EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER:
			res.addProperty(epc, edt, setCharacterStringToPresentToTheUser(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_DISPLAY_CONTROL_SETTING:
			edt = getDisplayControlSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_CHARACTER_STRING_SETTING_ACCEPTANCE_STATUS:
			edt = getCharacterStringSettingAcceptanceStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SUPPORTED_CHARACTER_CODES:
			edt = getSupportedCharacterCodes();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER:
			edt = getCharacterStringToPresentToTheUser();
			res.addProperty(epc, edt, (edt != null && (edt.length <= 247)));
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
			case EPC_DISPLAY_CONTROL_SETTING:
				onSetDisplayControlSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER:
				onSetCharacterStringToPresentToTheUser(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_DISPLAY_CONTROL_SETTING:
				onGetDisplayControlSetting(eoj, tid, pdc, edt);
				break;
			case EPC_CHARACTER_STRING_SETTING_ACCEPTANCE_STATUS:
				onGetCharacterStringSettingAcceptanceStatus(eoj, tid, pdc, edt);
				break;
			case EPC_SUPPORTED_CHARACTER_CODES:
				onGetSupportedCharacterCodes(eoj, tid, pdc, edt);
				break;
			case EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER:
				onGetCharacterStringToPresentToTheUser(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetDisplayControlSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetDisplayControlSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : mandatory<br>Announcement at status change
		 */
		protected void onGetCharacterStringSettingAcceptanceStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char ~ 2<br>Data size : 2 Byte<br>Set : undefined<br>Get : mandatory
		 */
		protected void onGetSupportedCharacterCodes(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char ~ Max 247<br>Data size : Max247 B yte<br>Set : mandatory<br>Get : optional
		 */
		protected void onSetCharacterStringToPresentToTheUser(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char ~ Max 247<br>Data size : Max247 B yte<br>Set : mandatory<br>Get : optional
		 */
		protected void onGetCharacterStringToPresentToTheUser(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetDisplayControlSetting(byte[] edt);
		/**
		 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char ~ Max 247<br>Data size : Max247 B yte<br>Set : mandatory<br>Get : optional
		 */
		public Setter reqSetCharacterStringToPresentToTheUser(byte[] edt);
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
		public Setter reqSetDisplayControlSetting(byte[] edt) {
			addProperty(EPC_DISPLAY_CONTROL_SETTING, edt, setDisplayControlSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetCharacterStringToPresentToTheUser(byte[] edt) {
			addProperty(EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER, edt, setCharacterStringToPresentToTheUser(edt));
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
		public Setter reqSetDisplayControlSetting(byte[] edt) {
			addProperty(EPC_DISPLAY_CONTROL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetCharacterStringToPresentToTheUser(byte[] edt) {
			addProperty(EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER, edt, (edt != null && (edt.length <= 247)));
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
		 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetDisplayControlSetting();
		/**
		 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : mandatory<br>Announcement at status change
		 */
		public Getter reqGetCharacterStringSettingAcceptanceStatus();
		/**
		 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char ~ 2<br>Data size : 2 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Getter reqGetSupportedCharacterCodes();
		/**
		 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char ~ Max 247<br>Data size : Max247 B yte<br>Set : mandatory<br>Get : optional
		 */
		public Getter reqGetCharacterStringToPresentToTheUser();
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
		public Getter reqGetDisplayControlSetting() {
			byte[] edt = getDisplayControlSetting();
			addProperty(EPC_DISPLAY_CONTROL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetCharacterStringSettingAcceptanceStatus() {
			byte[] edt = getCharacterStringSettingAcceptanceStatus();
			addProperty(EPC_CHARACTER_STRING_SETTING_ACCEPTANCE_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSupportedCharacterCodes() {
			byte[] edt = getSupportedCharacterCodes();
			addProperty(EPC_SUPPORTED_CHARACTER_CODES, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetCharacterStringToPresentToTheUser() {
			byte[] edt = getCharacterStringToPresentToTheUser();
			addProperty(EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER, edt, (edt != null && (edt.length <= 247)));
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
		public Getter reqGetDisplayControlSetting() {
			addProperty(EPC_DISPLAY_CONTROL_SETTING);
			return this;
		}
		@Override
		public Getter reqGetCharacterStringSettingAcceptanceStatus() {
			addProperty(EPC_CHARACTER_STRING_SETTING_ACCEPTANCE_STATUS);
			return this;
		}
		@Override
		public Getter reqGetSupportedCharacterCodes() {
			addProperty(EPC_SUPPORTED_CHARACTER_CODES);
			return this;
		}
		@Override
		public Getter reqGetCharacterStringToPresentToTheUser() {
			addProperty(EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER);
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
		 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformDisplayControlSetting();
		/**
		 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : mandatory<br>Announcement at status change
		 */
		public Informer reqInformCharacterStringSettingAcceptanceStatus();
		/**
		 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char ~ 2<br>Data size : 2 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Informer reqInformSupportedCharacterCodes();
		/**
		 * Refer to the section on the requirements for the display class (class group code = 0x06, class code = 0x01).<br><br><br>Data type : unsigned char ~ Max 247<br>Data size : Max247 B yte<br>Set : mandatory<br>Get : optional
		 */
		public Informer reqInformCharacterStringToPresentToTheUser();
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
		public Informer reqInformDisplayControlSetting() {
			byte[] edt = getDisplayControlSetting();
			addProperty(EPC_DISPLAY_CONTROL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformCharacterStringSettingAcceptanceStatus() {
			byte[] edt = getCharacterStringSettingAcceptanceStatus();
			addProperty(EPC_CHARACTER_STRING_SETTING_ACCEPTANCE_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSupportedCharacterCodes() {
			byte[] edt = getSupportedCharacterCodes();
			addProperty(EPC_SUPPORTED_CHARACTER_CODES, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformCharacterStringToPresentToTheUser() {
			byte[] edt = getCharacterStringToPresentToTheUser();
			addProperty(EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER, edt, (edt != null && (edt.length <= 247)));
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
		public Informer reqInformDisplayControlSetting() {
			addProperty(EPC_DISPLAY_CONTROL_SETTING);
			return this;
		}
		@Override
		public Informer reqInformCharacterStringSettingAcceptanceStatus() {
			addProperty(EPC_CHARACTER_STRING_SETTING_ACCEPTANCE_STATUS);
			return this;
		}
		@Override
		public Informer reqInformSupportedCharacterCodes() {
			addProperty(EPC_SUPPORTED_CHARACTER_CODES);
			return this;
		}
		@Override
		public Informer reqInformCharacterStringToPresentToTheUser() {
			addProperty(EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER);
			return this;
		}
	}
}
