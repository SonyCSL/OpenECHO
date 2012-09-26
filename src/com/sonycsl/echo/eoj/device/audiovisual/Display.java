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

public abstract class Display extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = Display.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x06;
	public static final byte CLASS_CODE = (byte)0x01;

	protected static final byte EPC_DISPLAY_CONTROL_SETTING = (byte)0xB0;
	protected static final byte EPC_CHARACTER_STRING_SETTING_ACCEPTANCE_STATUS = (byte)0xB1;
	protected static final byte EPC_SUPPORTED_CHARACTER_CODES = (byte)0xB2;
	protected static final byte EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER = (byte)0xB3;
	protected static final byte EPC_LENGTH_OF_CHARACTER_STRING_ACCEPTED = (byte)0xB4;


	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br>Displaying enabled: 0x30 Displaying disabled: 0x31
	 */
	protected boolean setDisplayControlSetting(byte[] edt) {return false;}
	/**
	 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br>Displaying enabled: 0x30 Displaying disabled: 0x31
	 */
	protected byte[] getDisplayControlSetting() {return null;}
	/**
	 * This property indicates whether or not the device is ready to accept the character string to present to the user.<br>Ready: 0x30        Busy: 0x31
	 */
	protected abstract byte[] getCharacterStringSettingAcceptanceStatus();
	/**
	 * This property indicates, in a bit map format, the implemented character codes that can be used to present character strings.<br>Bit 0   ANSI X3.4 Implemented: 1 Not implemented: 0 Bit 1   Shift-JIS Implemented: 1 Not implemented: 0 Bit 2   JIS Implemented: 1 Not implemented: 0 Bit 3   Japanese EUC Implemented: 1 Not implemented: 0 Bit 4   UCS-4 Implemented: 1 Not implemented: 0 Bit 5   UCS-2 Implemented: 1 Not implemented: 0 Bit 6   Latin-1 Implemented: 1 Not implemented: 0 Bit 7   UTF-8 Implemented: 1 Not implemented: 0 Bit 8 and succeeding bits: for future reserved    0
	 */
	protected abstract byte[] getSupportedCharacterCodes();
	/**
	 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting. The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character string to present to the user.<br>First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte code sequence of the character string to present to the user (max. 244 bytes) Each of the character codes listed below shall be assigned with the indicated code value. ANSI X3.4=0x01 Shift .JIS=0x02 JIS =0x03 Japanese EUC=0x04 UCS-4 =0x05 UCS-2 =0x06 Latin -1=0x07 UTF-8=0x08 0x09 and succeeding values = for future reserved
	 */
	protected abstract boolean setCharacterStringToPresentToTheUser(byte[] edt);
	/**
	 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting. The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character string to present to the user.<br>First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte code sequence of the character string to present to the user (max. 244 bytes) Each of the character codes listed below shall be assigned with the indicated code value. ANSI X3.4=0x01 Shift .JIS=0x02 JIS =0x03 Japanese EUC=0x04 UCS-4 =0x05 UCS-2 =0x06 Latin -1=0x07 UTF-8=0x08 0x09 and succeeding values = for future reserved
	 */
	protected byte[] getCharacterStringToPresentToTheUser() {return null;}
	/**
	 * This property indicates the total number of bytes of the newest character string to present to the user which has been set and is being held.<br>First byte: 0x00 to 0xF4 Second byte: 0x00 (for future reserved)
	 */
	protected abstract byte[] getLengthOfCharacterStringAccepted();


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
		case EPC_LENGTH_OF_CHARACTER_STRING_ACCEPTED:
			edt = getLengthOfCharacterStringAccepted();
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
			case EPC_LENGTH_OF_CHARACTER_STRING_ACCEPTED:
				onGetLengthOfCharacterStringAccepted(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br>Displaying enabled: 0x30 Displaying disabled: 0x31
		 */
		protected void onSetDisplayControlSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br>Displaying enabled: 0x30 Displaying disabled: 0x31
		 */
		protected void onGetDisplayControlSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates whether or not the device is ready to accept the character string to present to the user.<br>Ready: 0x30        Busy: 0x31
		 */
		protected void onGetCharacterStringSettingAcceptanceStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates, in a bit map format, the implemented character codes that can be used to present character strings.<br>Bit 0   ANSI X3.4 Implemented: 1 Not implemented: 0 Bit 1   Shift-JIS Implemented: 1 Not implemented: 0 Bit 2   JIS Implemented: 1 Not implemented: 0 Bit 3   Japanese EUC Implemented: 1 Not implemented: 0 Bit 4   UCS-4 Implemented: 1 Not implemented: 0 Bit 5   UCS-2 Implemented: 1 Not implemented: 0 Bit 6   Latin-1 Implemented: 1 Not implemented: 0 Bit 7   UTF-8 Implemented: 1 Not implemented: 0 Bit 8 and succeeding bits: for future reserved    0
		 */
		protected void onGetSupportedCharacterCodes(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting. The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character string to present to the user.<br>First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte code sequence of the character string to present to the user (max. 244 bytes) Each of the character codes listed below shall be assigned with the indicated code value. ANSI X3.4=0x01 Shift .JIS=0x02 JIS =0x03 Japanese EUC=0x04 UCS-4 =0x05 UCS-2 =0x06 Latin -1=0x07 UTF-8=0x08 0x09 and succeeding values = for future reserved
		 */
		protected void onSetCharacterStringToPresentToTheUser(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting. The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character string to present to the user.<br>First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte code sequence of the character string to present to the user (max. 244 bytes) Each of the character codes listed below shall be assigned with the indicated code value. ANSI X3.4=0x01 Shift .JIS=0x02 JIS =0x03 Japanese EUC=0x04 UCS-4 =0x05 UCS-2 =0x06 Latin -1=0x07 UTF-8=0x08 0x09 and succeeding values = for future reserved
		 */
		protected void onGetCharacterStringToPresentToTheUser(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the total number of bytes of the newest character string to present to the user which has been set and is being held.<br>First byte: 0x00 to 0xF4 Second byte: 0x00 (for future reserved)
		 */
		protected void onGetLengthOfCharacterStringAccepted(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br>Displaying enabled: 0x30 Displaying disabled: 0x31
		 */
		public Setter reqSetDisplayControlSetting(byte[] edt);
		/**
		 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting. The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character string to present to the user.<br>First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte code sequence of the character string to present to the user (max. 244 bytes) Each of the character codes listed below shall be assigned with the indicated code value. ANSI X3.4=0x01 Shift .JIS=0x02 JIS =0x03 Japanese EUC=0x04 UCS-4 =0x05 UCS-2 =0x06 Latin -1=0x07 UTF-8=0x08 0x09 and succeeding values = for future reserved
		 */
		public Setter reqSetCharacterStringToPresentToTheUser(byte[] edt);

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
		 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br>Displaying enabled: 0x30 Displaying disabled: 0x31
		 */
		public Getter reqGetDisplayControlSetting();
		/**
		 * This property indicates whether or not the device is ready to accept the character string to present to the user.<br>Ready: 0x30        Busy: 0x31
		 */
		public Getter reqGetCharacterStringSettingAcceptanceStatus();
		/**
		 * This property indicates, in a bit map format, the implemented character codes that can be used to present character strings.<br>Bit 0   ANSI X3.4 Implemented: 1 Not implemented: 0 Bit 1   Shift-JIS Implemented: 1 Not implemented: 0 Bit 2   JIS Implemented: 1 Not implemented: 0 Bit 3   Japanese EUC Implemented: 1 Not implemented: 0 Bit 4   UCS-4 Implemented: 1 Not implemented: 0 Bit 5   UCS-2 Implemented: 1 Not implemented: 0 Bit 6   Latin-1 Implemented: 1 Not implemented: 0 Bit 7   UTF-8 Implemented: 1 Not implemented: 0 Bit 8 and succeeding bits: for future reserved    0
		 */
		public Getter reqGetSupportedCharacterCodes();
		/**
		 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting. The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character string to present to the user.<br>First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte code sequence of the character string to present to the user (max. 244 bytes) Each of the character codes listed below shall be assigned with the indicated code value. ANSI X3.4=0x01 Shift .JIS=0x02 JIS =0x03 Japanese EUC=0x04 UCS-4 =0x05 UCS-2 =0x06 Latin -1=0x07 UTF-8=0x08 0x09 and succeeding values = for future reserved
		 */
		public Getter reqGetCharacterStringToPresentToTheUser();
		/**
		 * This property indicates the total number of bytes of the newest character string to present to the user which has been set and is being held.<br>First byte: 0x00 to 0xF4 Second byte: 0x00 (for future reserved)
		 */
		public Getter reqGetLengthOfCharacterStringAccepted();

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
		@Override
		public Getter reqGetLengthOfCharacterStringAccepted() {
			byte[] edt = getLengthOfCharacterStringAccepted();
			addProperty(EPC_LENGTH_OF_CHARACTER_STRING_ACCEPTED, edt, (edt != null && (edt.length == 2)));
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
		@Override
		public Getter reqGetLengthOfCharacterStringAccepted() {
			addProperty(EPC_LENGTH_OF_CHARACTER_STRING_ACCEPTED);
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
		 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br>Displaying enabled: 0x30 Displaying disabled: 0x31
		 */
		public Informer reqInformDisplayControlSetting();
		/**
		 * This property indicates whether or not the device is ready to accept the character string to present to the user.<br>Ready: 0x30        Busy: 0x31
		 */
		public Informer reqInformCharacterStringSettingAcceptanceStatus();
		/**
		 * This property indicates, in a bit map format, the implemented character codes that can be used to present character strings.<br>Bit 0   ANSI X3.4 Implemented: 1 Not implemented: 0 Bit 1   Shift-JIS Implemented: 1 Not implemented: 0 Bit 2   JIS Implemented: 1 Not implemented: 0 Bit 3   Japanese EUC Implemented: 1 Not implemented: 0 Bit 4   UCS-4 Implemented: 1 Not implemented: 0 Bit 5   UCS-2 Implemented: 1 Not implemented: 0 Bit 6   Latin-1 Implemented: 1 Not implemented: 0 Bit 7   UTF-8 Implemented: 1 Not implemented: 0 Bit 8 and succeeding bits: for future reserved    0
		 */
		public Informer reqInformSupportedCharacterCodes();
		/**
		 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting. The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character string to present to the user.<br>First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte code sequence of the character string to present to the user (max. 244 bytes) Each of the character codes listed below shall be assigned with the indicated code value. ANSI X3.4=0x01 Shift .JIS=0x02 JIS =0x03 Japanese EUC=0x04 UCS-4 =0x05 UCS-2 =0x06 Latin -1=0x07 UTF-8=0x08 0x09 and succeeding values = for future reserved
		 */
		public Informer reqInformCharacterStringToPresentToTheUser();
		/**
		 * This property indicates the total number of bytes of the newest character string to present to the user which has been set and is being held.<br>First byte: 0x00 to 0xF4 Second byte: 0x00 (for future reserved)
		 */
		public Informer reqInformLengthOfCharacterStringAccepted();

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
		@Override
		public Informer reqInformLengthOfCharacterStringAccepted() {
			byte[] edt = getLengthOfCharacterStringAccepted();
			addProperty(EPC_LENGTH_OF_CHARACTER_STRING_ACCEPTED, edt, (edt != null && (edt.length == 2)));
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
		@Override
		public Informer reqInformLengthOfCharacterStringAccepted() {
			addProperty(EPC_LENGTH_OF_CHARACTER_STRING_ACCEPTED);
			return this;
		}

	}
}
