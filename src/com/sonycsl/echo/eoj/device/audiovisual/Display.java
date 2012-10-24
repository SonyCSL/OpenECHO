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
	
	public static final byte CLASS_GROUP_CODE = (byte)0x06;
	public static final byte CLASS_CODE = (byte)0x01;

	public static final byte EPC_DISPLAY_CONTROL_SETTING = (byte)0xB0;
	public static final byte EPC_CHARACTER_STRING_SETTING_ACCEPTANCE_STATUS = (byte)0xB1;
	public static final byte EPC_SUPPORTED_CHARACTER_CODES = (byte)0xB2;
	public static final byte EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER = (byte)0xB3;
	public static final byte EPC_LENGTH_OF_CHARACTER_STRING_ACCEPTED = (byte)0xB4;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br><br>Displaying enabled: 0x30 Displaying disabled: 0x31<br><br>Name : Display control setting<br>EPC : 0xB0<br>Data Type : unsigne d char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setDisplayControlSetting(byte[] edt) {return false;}
	private final boolean _setDisplayControlSetting(byte epc, byte[] edt) {
		boolean success = setDisplayControlSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br><br>Displaying enabled: 0x30 Displaying disabled: 0x31<br><br>Name : Display control setting<br>EPC : 0xB0<br>Data Type : unsigne d char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getDisplayControlSetting() {return null;}
	private final byte[] _getDisplayControlSetting(byte epc) {
		byte[] edt = getDisplayControlSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates whether or not the device is ready to accept the character string to present to the user.<br><br>Ready: 0x30        Busy: 0x31<br><br>Name : Character string setting acceptance status<br>EPC : 0xB1<br>Data Type : unsigne d char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br><br>Announcement at status change<br>
	 */
	protected abstract byte[] getCharacterStringSettingAcceptanceStatus();
	private final byte[] _getCharacterStringSettingAcceptanceStatus(byte epc) {
		byte[] edt = getCharacterStringSettingAcceptanceStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates, in a bit map format, the implemented character codes that can be used to present character strings.<br><br>Bit 0   ANSI X3.4 Implemented: 1 Not implemented: 0 Bit 1   Shift-JIS Implemented: 1 Not implemented: 0 Bit 2   JIS Implemented: 1 Not implemented: 0 Bit 3   Japanese EUC Implemented: 1 Not implemented: 0 Bit 4   UCS-4 Implemented: 1 Not implemented: 0 Bit 5   UCS-2 Implemented: 1 Not implemented: 0 Bit 6   Latin-1 Implemented: 1 Not implemented: 0 Bit 7   UTF-8 Implemented: 1 Not implemented: 0 Bit 8 and succeeding bits: for future reserved    0<br><br>Name : Supported character codes<br>EPC : 0xB2<br>Data Type : unsigne d char ~ 2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getSupportedCharacterCodes();
	private final byte[] _getSupportedCharacterCodes(byte epc) {
		byte[] edt = getSupportedCharacterCodes();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting. The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character string to present to the user.<br><br>First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte code sequence of the character string to present to the user (max. 244 bytes) Each of the character codes listed below shall be assigned with the indicated code value. ANSI X3.4=0x01 Shift .JIS=0x02 JIS =0x03 Japanese EUC=0x04 UCS-4 =0x05 UCS-2 =0x06 Latin -1=0x07 UTF-8=0x08 0x09 and succeeding values = for future reserved<br><br>Name : Character string to present to the user<br>EPC : 0xB3<br>Data Type : unsigne d    char  ~ Max 247<br>Data Size(Byte) : Max247 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : optional<br>
	 */
	protected abstract boolean setCharacterStringToPresentToTheUser(byte[] edt);
	private final boolean _setCharacterStringToPresentToTheUser(byte epc, byte[] edt) {
		boolean success = setCharacterStringToPresentToTheUser(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting. The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character string to present to the user.<br><br>First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte code sequence of the character string to present to the user (max. 244 bytes) Each of the character codes listed below shall be assigned with the indicated code value. ANSI X3.4=0x01 Shift .JIS=0x02 JIS =0x03 Japanese EUC=0x04 UCS-4 =0x05 UCS-2 =0x06 Latin -1=0x07 UTF-8=0x08 0x09 and succeeding values = for future reserved<br><br>Name : Character string to present to the user<br>EPC : 0xB3<br>Data Type : unsigne d    char  ~ Max 247<br>Data Size(Byte) : Max247 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : optional<br>
	 */
	protected byte[] getCharacterStringToPresentToTheUser() {return null;}
	private final byte[] _getCharacterStringToPresentToTheUser(byte epc) {
		byte[] edt = getCharacterStringToPresentToTheUser();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the total number of bytes of the newest character string to present to the user which has been set and is being held.<br><br>First byte: 0x00 to 0xF4 Second byte: 0x00 (for future reserved)<br><br>Name : Length of character string accepted<br>EPC : 0xB4<br>Data Type : unsigne d char<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getLengthOfCharacterStringAccepted();
	private final byte[] _getLengthOfCharacterStringAccepted(byte epc) {
		byte[] edt = getLengthOfCharacterStringAccepted();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_DISPLAY_CONTROL_SETTING:
			res.addProperty(epc, edt, _setDisplayControlSetting(epc, edt));
			break;
		case EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER:
			res.addProperty(epc, edt, _setCharacterStringToPresentToTheUser(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_DISPLAY_CONTROL_SETTING:
			edt = _getDisplayControlSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_CHARACTER_STRING_SETTING_ACCEPTANCE_STATUS:
			edt = _getCharacterStringSettingAcceptanceStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SUPPORTED_CHARACTER_CODES:
			edt = _getSupportedCharacterCodes(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER:
			edt = _getCharacterStringToPresentToTheUser(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length <= 247)));
			break;
		case EPC_LENGTH_OF_CHARACTER_STRING_ACCEPTED:
			edt = _getLengthOfCharacterStringAccepted(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
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
			case EPC_DISPLAY_CONTROL_SETTING:
				_onSetDisplayControlSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER:
				_onSetCharacterStringToPresentToTheUser(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_DISPLAY_CONTROL_SETTING:
				_onGetDisplayControlSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_CHARACTER_STRING_SETTING_ACCEPTANCE_STATUS:
				_onGetCharacterStringSettingAcceptanceStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SUPPORTED_CHARACTER_CODES:
				_onGetSupportedCharacterCodes(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER:
				_onGetCharacterStringToPresentToTheUser(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_LENGTH_OF_CHARACTER_STRING_ACCEPTED:
				_onGetLengthOfCharacterStringAccepted(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br><br>Displaying enabled: 0x30 Displaying disabled: 0x31<br><br>Name : Display control setting<br>EPC : 0xB0<br>Data Type : unsigne d char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetDisplayControlSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDisplayControlSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDisplayControlSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br><br>Displaying enabled: 0x30 Displaying disabled: 0x31<br><br>Name : Display control setting<br>EPC : 0xB0<br>Data Type : unsigne d char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetDisplayControlSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDisplayControlSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDisplayControlSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates whether or not the device is ready to accept the character string to present to the user.<br><br>Ready: 0x30        Busy: 0x31<br><br>Name : Character string setting acceptance status<br>EPC : 0xB1<br>Data Type : unsigne d char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		protected void onGetCharacterStringSettingAcceptanceStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetCharacterStringSettingAcceptanceStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetCharacterStringSettingAcceptanceStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates, in a bit map format, the implemented character codes that can be used to present character strings.<br><br>Bit 0   ANSI X3.4 Implemented: 1 Not implemented: 0 Bit 1   Shift-JIS Implemented: 1 Not implemented: 0 Bit 2   JIS Implemented: 1 Not implemented: 0 Bit 3   Japanese EUC Implemented: 1 Not implemented: 0 Bit 4   UCS-4 Implemented: 1 Not implemented: 0 Bit 5   UCS-2 Implemented: 1 Not implemented: 0 Bit 6   Latin-1 Implemented: 1 Not implemented: 0 Bit 7   UTF-8 Implemented: 1 Not implemented: 0 Bit 8 and succeeding bits: for future reserved    0<br><br>Name : Supported character codes<br>EPC : 0xB2<br>Data Type : unsigne d char ~ 2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetSupportedCharacterCodes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSupportedCharacterCodes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSupportedCharacterCodes(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting. The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character string to present to the user.<br><br>First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte code sequence of the character string to present to the user (max. 244 bytes) Each of the character codes listed below shall be assigned with the indicated code value. ANSI X3.4=0x01 Shift .JIS=0x02 JIS =0x03 Japanese EUC=0x04 UCS-4 =0x05 UCS-2 =0x06 Latin -1=0x07 UTF-8=0x08 0x09 and succeeding values = for future reserved<br><br>Name : Character string to present to the user<br>EPC : 0xB3<br>Data Type : unsigne d    char  ~ Max 247<br>Data Size(Byte) : Max247 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : optional<br>
		 */
		protected void onSetCharacterStringToPresentToTheUser(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetCharacterStringToPresentToTheUser(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetCharacterStringToPresentToTheUser(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting. The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character string to present to the user.<br><br>First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte code sequence of the character string to present to the user (max. 244 bytes) Each of the character codes listed below shall be assigned with the indicated code value. ANSI X3.4=0x01 Shift .JIS=0x02 JIS =0x03 Japanese EUC=0x04 UCS-4 =0x05 UCS-2 =0x06 Latin -1=0x07 UTF-8=0x08 0x09 and succeeding values = for future reserved<br><br>Name : Character string to present to the user<br>EPC : 0xB3<br>Data Type : unsigne d    char  ~ Max 247<br>Data Size(Byte) : Max247 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : optional<br>
		 */
		protected void onGetCharacterStringToPresentToTheUser(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetCharacterStringToPresentToTheUser(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetCharacterStringToPresentToTheUser(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the total number of bytes of the newest character string to present to the user which has been set and is being held.<br><br>First byte: 0x00 to 0xF4 Second byte: 0x00 (for future reserved)<br><br>Name : Length of character string accepted<br>EPC : 0xB4<br>Data Type : unsigne d char<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetLengthOfCharacterStringAccepted(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetLengthOfCharacterStringAccepted(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetLengthOfCharacterStringAccepted(eoj, tid, esv, epc, pdc, edt);
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
		 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br><br>Displaying enabled: 0x30 Displaying disabled: 0x31<br><br>Name : Display control setting<br>EPC : 0xB0<br>Data Type : unsigne d char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetDisplayControlSetting(byte[] edt) {
			addProperty(EPC_DISPLAY_CONTROL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting. The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character string to present to the user.<br><br>First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte code sequence of the character string to present to the user (max. 244 bytes) Each of the character codes listed below shall be assigned with the indicated code value. ANSI X3.4=0x01 Shift .JIS=0x02 JIS =0x03 Japanese EUC=0x04 UCS-4 =0x05 UCS-2 =0x06 Latin -1=0x07 UTF-8=0x08 0x09 and succeeding values = for future reserved<br><br>Name : Character string to present to the user<br>EPC : 0xB3<br>Data Type : unsigne d    char  ~ Max 247<br>Data Size(Byte) : Max247 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : optional<br>
		 */
		public Setter reqSetCharacterStringToPresentToTheUser(byte[] edt) {
			addProperty(EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER, edt, (edt != null && (edt.length <= 247)));
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
		 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br><br>Displaying enabled: 0x30 Displaying disabled: 0x31<br><br>Name : Display control setting<br>EPC : 0xB0<br>Data Type : unsigne d char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetDisplayControlSetting() {
			addProperty(EPC_DISPLAY_CONTROL_SETTING);
			return this;
		}
		/**
		 * This property indicates whether or not the device is ready to accept the character string to present to the user.<br><br>Ready: 0x30        Busy: 0x31<br><br>Name : Character string setting acceptance status<br>EPC : 0xB1<br>Data Type : unsigne d char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Getter reqGetCharacterStringSettingAcceptanceStatus() {
			addProperty(EPC_CHARACTER_STRING_SETTING_ACCEPTANCE_STATUS);
			return this;
		}
		/**
		 * This property indicates, in a bit map format, the implemented character codes that can be used to present character strings.<br><br>Bit 0   ANSI X3.4 Implemented: 1 Not implemented: 0 Bit 1   Shift-JIS Implemented: 1 Not implemented: 0 Bit 2   JIS Implemented: 1 Not implemented: 0 Bit 3   Japanese EUC Implemented: 1 Not implemented: 0 Bit 4   UCS-4 Implemented: 1 Not implemented: 0 Bit 5   UCS-2 Implemented: 1 Not implemented: 0 Bit 6   Latin-1 Implemented: 1 Not implemented: 0 Bit 7   UTF-8 Implemented: 1 Not implemented: 0 Bit 8 and succeeding bits: for future reserved    0<br><br>Name : Supported character codes<br>EPC : 0xB2<br>Data Type : unsigne d char ~ 2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetSupportedCharacterCodes() {
			addProperty(EPC_SUPPORTED_CHARACTER_CODES);
			return this;
		}
		/**
		 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting. The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character string to present to the user.<br><br>First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte code sequence of the character string to present to the user (max. 244 bytes) Each of the character codes listed below shall be assigned with the indicated code value. ANSI X3.4=0x01 Shift .JIS=0x02 JIS =0x03 Japanese EUC=0x04 UCS-4 =0x05 UCS-2 =0x06 Latin -1=0x07 UTF-8=0x08 0x09 and succeeding values = for future reserved<br><br>Name : Character string to present to the user<br>EPC : 0xB3<br>Data Type : unsigne d    char  ~ Max 247<br>Data Size(Byte) : Max247 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : optional<br>
		 */
		public Getter reqGetCharacterStringToPresentToTheUser() {
			addProperty(EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER);
			return this;
		}
		/**
		 * This property indicates the total number of bytes of the newest character string to present to the user which has been set and is being held.<br><br>First byte: 0x00 to 0xF4 Second byte: 0x00 (for future reserved)<br><br>Name : Length of character string accepted<br>EPC : 0xB4<br>Data Type : unsigne d char<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetLengthOfCharacterStringAccepted() {
			addProperty(EPC_LENGTH_OF_CHARACTER_STRING_ACCEPTED);
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
		 * Sets the status as to whether the displaying of characters is enabled or disabled and acquires the current setting.<br><br>Displaying enabled: 0x30 Displaying disabled: 0x31<br><br>Name : Display control setting<br>EPC : 0xB0<br>Data Type : unsigne d char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformDisplayControlSetting();
		/**
		 * This property indicates whether or not the device is ready to accept the character string to present to the user.<br><br>Ready: 0x30        Busy: 0x31<br><br>Name : Character string setting acceptance status<br>EPC : 0xB1<br>Data Type : unsigne d char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Informer reqInformCharacterStringSettingAcceptanceStatus();
		/**
		 * This property indicates, in a bit map format, the implemented character codes that can be used to present character strings.<br><br>Bit 0   ANSI X3.4 Implemented: 1 Not implemented: 0 Bit 1   Shift-JIS Implemented: 1 Not implemented: 0 Bit 2   JIS Implemented: 1 Not implemented: 0 Bit 3   Japanese EUC Implemented: 1 Not implemented: 0 Bit 4   UCS-4 Implemented: 1 Not implemented: 0 Bit 5   UCS-2 Implemented: 1 Not implemented: 0 Bit 6   Latin-1 Implemented: 1 Not implemented: 0 Bit 7   UTF-8 Implemented: 1 Not implemented: 0 Bit 8 and succeeding bits: for future reserved    0<br><br>Name : Supported character codes<br>EPC : 0xB2<br>Data Type : unsigne d char ~ 2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformSupportedCharacterCodes();
		/**
		 * Sets the character string to present to the user, the length of the character string and the character code to use to present the character string and acquires the stored setting. The highest-order byte shall indicate the byte sequence data length of the character string to present to the user and the second-highest-order byte shall indicate the character code to use. The second-highest-order byte shall be followed by a byte containing  g0x00 h (for future reserved), which shall be followed by a number of bytes, each assigned with one of the first and succeeding bytes, starting with the first byte, of the character string to present to the user. The lowest-order byte shall be assigned with the last byte of the character string to present to the user.<br><br>First byte: Byte code sequence data length of the character string to present to the user converted to the hexadecimal format Second byte: Character code to use Third byte: for future reserved Fourth and succeeding bytes: Byte code sequence of the character string to present to the user (max. 244 bytes) Each of the character codes listed below shall be assigned with the indicated code value. ANSI X3.4=0x01 Shift .JIS=0x02 JIS =0x03 Japanese EUC=0x04 UCS-4 =0x05 UCS-2 =0x06 Latin -1=0x07 UTF-8=0x08 0x09 and succeeding values = for future reserved<br><br>Name : Character string to present to the user<br>EPC : 0xB3<br>Data Type : unsigne d    char  ~ Max 247<br>Data Size(Byte) : Max247 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : optional<br>
		 */
		public Informer reqInformCharacterStringToPresentToTheUser();
		/**
		 * This property indicates the total number of bytes of the newest character string to present to the user which has been set and is being held.<br><br>First byte: 0x00 to 0xF4 Second byte: 0x00 (for future reserved)<br><br>Name : Length of character string accepted<br>EPC : 0xB4<br>Data Type : unsigne d char<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformLengthOfCharacterStringAccepted();
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
		public Informer reqInformDisplayControlSetting() {
			byte epc = EPC_DISPLAY_CONTROL_SETTING;
			byte[] edt = _getDisplayControlSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformCharacterStringSettingAcceptanceStatus() {
			byte epc = EPC_CHARACTER_STRING_SETTING_ACCEPTANCE_STATUS;
			byte[] edt = _getCharacterStringSettingAcceptanceStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSupportedCharacterCodes() {
			byte epc = EPC_SUPPORTED_CHARACTER_CODES;
			byte[] edt = _getSupportedCharacterCodes(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformCharacterStringToPresentToTheUser() {
			byte epc = EPC_CHARACTER_STRING_TO_PRESENT_TO_THE_USER;
			byte[] edt = _getCharacterStringToPresentToTheUser(epc);
			addProperty(epc, edt, (edt != null && (edt.length <= 247)));
			return this;
		}
		@Override
		public Informer reqInformLengthOfCharacterStringAccepted() {
			byte epc = EPC_LENGTH_OF_CHARACTER_STRING_ACCEPTED;
			byte[] edt = _getLengthOfCharacterStringAccepted(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
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
