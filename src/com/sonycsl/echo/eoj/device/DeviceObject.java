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
package com.sonycsl.echo.eoj.device;

import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.eoj.EchoObject;

/**
 * 　機器オブジェクトのスーパークラス
 *
 */
public abstract class DeviceObject extends EchoObject {

	protected static final byte EPC_OPERATION_STATUS = (byte)0x80;
	protected static final byte EPC_INSTALLATION_LOCATION = (byte)0x81;
	protected static final byte EPC_STANDARD_VERSION_INFORMATION = (byte)0x82;
	protected static final byte EPC_IDENTIFICATION_NUMBER = (byte)0x83;
	protected static final byte EPC_MEASURED_INSTANTANEOUS_POWER_CONSUMPTION = (byte)0x84;
	protected static final byte EPC_MEASURED_CUMULATIVE_POWER_CONSUMPTION = (byte)0x85;
	protected static final byte EPC_MANUFACTURERS_FAULT_CODE = (byte)0x86;
	protected static final byte EPC_CURRENT_LIMIT_SETTING = (byte)0x87;
	protected static final byte EPC_FAULT_STATUS = (byte)0x88;
	protected static final byte EPC_FAULT_DESCRIPTION = (byte)0x89;
	protected static final byte EPC_MANUFACTURER_CODE = (byte)0x8A;
	protected static final byte EPC_BUSINESS_FACILITY_CODE = (byte)0x8B;
	protected static final byte EPC_PRODUCT_CODE =  (byte)0x8C;
	protected static final byte EPC_PRODUCTION_NUMBER = (byte)0x8D;
	protected static final byte EPC_PRODUCTION_DATE = (byte)0x8E;
	protected static final byte EPC_POWER_SAVING_OPERATION_SETTING = (byte)0x8F;
	protected static final byte EPC_POSITION_INFORMATION = (byte)0x93;
	protected static final byte EPC_CURRENT_TIME_SETTING = (byte)0x97;
	protected static final byte EPC_CURRENT_DATE_SETTING = (byte)0x98;
	protected static final byte EPC_POWER_LIMIT_SETTING = (byte)0x99;
	protected static final byte EPC_CUMULATIVE_OPERATING_TIME = (byte)0x9A;
	protected static final byte EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP = (byte)0x9D;
	protected static final byte EPC_SET_PROPERTY_MAP = (byte)0x9E;
	protected static final byte EPC_GET_PROPERTY_MAP = (byte)0x9F;

	@Override
	public byte getInstanceCode() {
		return getNode().getDeviceNumber(this);
	}

	/**
	 * This property indicates the ON/OFF status.<br>
	 * ON＝0x30，OFF＝0x31<br><br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Set : optional<br>
	 * Get : mandatory<br>
	 * Announcement at status change
	 */
	protected boolean setOperationStatus(byte[] edt) {
		return false;
	}

	/**
	 * This property indicates the ON/OFF status.<br>
	 * ON＝0x30，OFF＝0x31<br><br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Set : optional<br>
	 * Get : mandatory<br>
	 * Announcement at status change
	 */
	protected abstract byte[] getOperationStatus();	

	/**
	 * This property indicates the installation location<br>
	 * See “2.2 ‘Installation location’ property.”<br><br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Set : mandatory<br>
	 * Get : mandatory<br>
	 * Announcement at status change
	 */
	protected abstract boolean setInstallationLocation(byte[] edt);

	/**
	 * This property indicates the installation location<br>
	 * See “2.2 ‘Installation location’ property.”
	 */
	protected abstract byte[] getInstallationLocation();

	/**
	 * This property indicates the version number of the corresponding standard.<br>
	 * First byte: Fixed at 0x00 (for future reserved). <br>
	 * Second byte: Fixed at 0x00 (for future reserved). <br>
	 * Third byte: Indicates the order of release in the ASCII format. <br>
	 * Fourth byte: Fixed at 0x00 (for future reserved).<br><br>
	 * Data type : unsigned char×4<br>
	 * Data size : 4<br>
	 * Set : undefined<br>
	 * Get : mandatory<br>
	 */
	protected abstract byte[] getStandardVersionInformation() ;
	
	/**
	 * A number that allows each object to be uniquely identified.<br>
	 * First byte: lower-layer communication ID field<br>
	 * 0x01－0xFD：This is a communication protocol used in the lower-layer communication and is set arbitrarily according to the protocol class in the case where unique number is assigned (not used in ECHONET Lite).<br>
	 * 0x11－0x1F: Power line Communication Protocol A and B systems<br>
	 * 0x31-0x3F: Designated low-powor radio<br>
	 * 0x41-0x4F: Extended HBS<br>
	 * 0x51-0x5F: IrDA<br>
	 * 0x61-0x6F: LonTalk®<br>
	 * 0x71-0x7F: BlueTooth<br>
	 * 0x81-0x8F: Ethernet<br>
	 * 0x91-0x9F: IEEE802.11/11B<br>
	 * 0xA1: Power line Communication Protocol C systems<br>
	 * 0xB2：IPv6/6LoWPAN<br>
	 * 0xFE：2－17 bytes are defined by the manufacturer, and are set according to the type.<br>
	 * 0xFF：2－9 bytes are defined when randomly generated protocol is used in the lower-layer communication.<br>
	 * 0x00：Identification number is not set.<br>
	 * Second and succeeding bytes: unique number field
	 */
	protected byte[] getIdentificationNumber() {
		return null;
	}

	/**
	 * This property indicates the instantaneous power consumption of the device in watts.<br>
	 * 0x0000-0xFFFF（0-65535W）
	 */
	protected byte[] getMeasuredInstantaneousPowerConsumption() {
		return null;
	}

	/**
	 * This property indicates the cumulative power consumption of the device in increments of 0.001kWh.<br>
	 * 0x0-0x3B9AC9FF（0-999,999.999kWh）
	 */
	protected byte[] getMeasuredCumulativePowerConsumption() {
		return null;
	}

	/**
	 * This property indicates the manufacturer-defined fault code.<br>
	 * First byte: Indicates the data size of the fault code field.<br>
	 * Second to fourth bytes: Manufacturer code<br>
	 * Fifth and succeeding bytes: Field for manufacturer-defined fault code
	 */	
	protected byte[] getManufacturersFaultCode() {
		return null;
	}

	/**
	 * This property indicates the current limit setting (0-100%).<br>
	 * 0x00-0x64 （=0-100%）
	 */
	protected boolean setCurrentLimitSetting(byte[] edt) {
		return false;
	}

	/**
	 * This property indicates the current limit setting (0-100%).<br>
	 * 0x00-0x64 （=0-100%）
	 */
	protected byte[] getCurrentLimitSetting() {
		return null;
	}

	/**
	 * This property indicates whether a fault (e.g. a sensor trouble) has occurred or not.<br>
	 * Fault occurred＝0x41, No fault has occurred＝0x42
	 */
	protected abstract byte[] getFaultStatus();

	
	/**
	 * Describes the fault.<br>
	 * See “2.5 ‘Fault Description’ Property.”
	 */
	protected byte[] getFaultDescription() {
		return null;
	}
	
	/**
	 * 3-byte manufacturer code<br>
	 * (Defined by the ECHONET Consortium.)
	 */
	protected abstract byte[] getManufacturerCode();
	
	/**
	 * 3-byte business facility code<br>
	 * （Defined by each manufacturer.）
	 */
	protected byte[] getBusinessFacilityCode() {
		return null;
	}
	
	/**
	 * Identifies the product usingASCI I code.<br>
	 * （Defined by each manufacturer.）
	 */
	protected byte[] getProductCode() {
		return null;
	}

	/**
	 * This property indicates the production number using ASCI I code.<br>
	 * （Defined by each manufacturer.）
	 */
	protected byte[] getProductionNumber() {
		return null;
	}
	
	/**
	 * 4-byte production date code<br>
	 * This property indicates the product ion date in the YYMD format (1 character = 1 byte) .<br>
	 * YY： Year (e.g. 1999＝ 0x07CF)<br>
	 * M： Month (e.g. December＝0x0C)<br>
	 * D： Day (e.g. 20th＝ 0x14)
	 */
	protected byte[] getProductionDate() {
		return null;
	}
	
	/**
	 * This property indicates whether the device is operating in power-saving mode.<br>
	 * Operating in power-saving mode =0x41<br>
	 * Operating in normal operation mode =0x42
	 */
	protected boolean setPowerSavingOperationSetting(byte[] edt) {
		return false;
	}

	/**
	 * This property indicates whether the device is operating in power-saving mode.<br>
	 * Operating in power-saving mode =0x41<br>
	 * Operating in normal operation mode =0x42
	 */
	protected byte[] getPowerSavingOperationSetting() {
		return null;
	}

	/**
	 * This property indicates the latitude, longitude and altitude of the installation location.
	 */
	protected boolean setPositionInformation(byte[] edt) {
		return false;
	}

	/**
	 * This property indicates the latitude, longitude and altitude of the installation location.
	 */	
	protected byte[] getPositionInformation() {
		return null;
	}

	/**
	 * Current time (HH：MM format)<br>
	 * 0x00-0x17：0x00-0x3B（ ＝ 0-23）：（ ＝ 0-59）
	 */
	protected boolean setCurrentTimeSetting(byte[] edt) {
		return false;
	}

	/**
	 * Current time (HH：MM format)<br>
	 * 0x00-0x17 ： 0x00-0x3B（ ＝ 0-23）：（ ＝ 0-59）
	 */
	protected byte[] getCurrentTimeSetting() {
		return null;
	}

	/**
	 * Current date (YYYY：MM：DD format)<br>
	 * 1 ～ 0x270F ： 1 ～ 0x0C ： 1 ～ 0x1F (=1 ～ 9999) ： (=1 ～ 12) ： (=1 ～ 31)
	 */
	protected boolean setCurrentDateSetting(byte edt[]) {
		return false;
	}

	/**
	 * Current date (YYYY：MM：DD format)<br>
	 * 1 ～ 0x270F ： 1 ～ 0x0C ： 1 ～ 0x1F (=1 ～ 9999) ： (=1 ～ 12) ： (=1 ～ 31)
	 */
	protected byte[] getCurrentDateSetting() {
		return null;
	}

	/**
	 * This property indicates the power limit setting in watts.<br>
	 * 0x0000~0xFFFF（0-65535W）
	 */
	protected boolean setPowerLimitSetting(byte[] edt) {
		return false;
	}

	/**
	 * This property indicates the power limit setting in watts.<br>
	 * 0x0000~0xFFFF（0-65535W）
	 */
	protected byte[] getPowerLimitSetting() {
		return null;
	}

	/**
	 * This property indicates the cumulative number of days, hours, minutes or seconds for which the device has operated, using 1 byte for the unit and 4 bytes for the time.<br>
	 * First byte: Indicates the unit.<br>
	 * Second： 0x41; Minute： 0x42; Hour： 0x43; Day:0x44<br>
	 * Second to fifth bytes ：<br>
	 * Indicates the elapsed time in the unit specified by the first byte. 0x00000000-0xFFFFFFFF (0-4294967295)
	 */
	protected byte[] getCumulativeOperatingTime() {
		return null;
	}
	
	/**
	 * See Appendix 1.
	 */
	protected abstract byte[] getStatusChangeAnnouncementPropertyMap() ;
	
	/**
	 * See Appendix 1.
	 */
	protected abstract byte[] getSetPropertyMap();

	/**
	 * See Appendix 1.
	 */
	protected abstract byte[] getGetPropertyMap();

	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_OPERATION_STATUS :
			res.addProperty(epc, edt, setOperationStatus(edt));
			break;
		case EPC_INSTALLATION_LOCATION :
			res.addProperty(epc, edt, setInstallationLocation(edt));
			break;
		case EPC_CURRENT_LIMIT_SETTING :
			res.addProperty(epc, edt, setCurrentLimitSetting(edt));
			break;
		case EPC_POWER_SAVING_OPERATION_SETTING :
			res.addProperty(epc, edt, setPowerSavingOperationSetting(edt));
			break;
		case EPC_POSITION_INFORMATION :
			res.addProperty(epc, edt, setPositionInformation(edt));
			break;
		case EPC_CURRENT_TIME_SETTING :
			res.addProperty(epc, edt, setCurrentTimeSetting(edt));
			break;
		case EPC_CURRENT_DATE_SETTING :
			res.addProperty(epc, edt, setCurrentDateSetting(edt));
			break;
		case EPC_POWER_LIMIT_SETTING :
			res.addProperty(epc, edt, setPowerLimitSetting(edt));
			break;
		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_OPERATION_STATUS :
			edt = getOperationStatus();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_INSTALLATION_LOCATION :
			edt = getInstallationLocation();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_STANDARD_VERSION_INFORMATION :
			edt = getStandardVersionInformation();
			res.addProperty(epc, edt, (edt != null && edt.length == 4));
			break;
		case EPC_IDENTIFICATION_NUMBER :
			edt = getIdentificationNumber();
			res.addProperty(epc, edt, (edt != null && (edt.length == 9 || edt.length == 17)));
			break;
		case EPC_MEASURED_INSTANTANEOUS_POWER_CONSUMPTION :
			edt = getMeasuredInstantaneousPowerConsumption();
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_MEASURED_CUMULATIVE_POWER_CONSUMPTION :
			edt = getMeasuredCumulativePowerConsumption();
			res.addProperty(epc, edt, (edt != null && edt.length == 4));
			break;
		case EPC_MANUFACTURERS_FAULT_CODE :
			edt = getManufacturersFaultCode();
			res.addProperty(epc, edt, (edt != null && edt.length <= 225));
			break;
		case EPC_CURRENT_LIMIT_SETTING :
			edt = getCurrentLimitSetting();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_FAULT_STATUS :
			edt = getFaultStatus();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_FAULT_DESCRIPTION :
			edt = getFaultDescription();
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_MANUFACTURER_CODE :
			edt = getManufacturerCode();
			res.addProperty(epc, edt, (edt != null && edt.length == 3));
			break;
		case EPC_BUSINESS_FACILITY_CODE :
			edt = getBusinessFacilityCode();
			res.addProperty(epc, edt, (edt != null && edt.length == 3));
			break;
		case EPC_PRODUCT_CODE :
			edt = getProductCode();
			res.addProperty(epc, edt, (edt != null && edt.length == 12));
			break;
		case EPC_PRODUCTION_NUMBER :
			edt = getProductionNumber();
			res.addProperty(epc, edt, (edt != null && edt.length == 12));
			break;
		case EPC_PRODUCTION_DATE :
			edt = getProductionDate();
			res.addProperty(epc, edt, (edt != null && edt.length == 4));
			break;
		case EPC_POWER_SAVING_OPERATION_SETTING :
			edt = getPowerSavingOperationSetting();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_POSITION_INFORMATION :
			edt = getPositionInformation();
			res.addProperty(epc, edt, (edt != null && edt.length == 16));
			break;
		case EPC_CURRENT_TIME_SETTING :
			edt = getCurrentTimeSetting();
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_CURRENT_DATE_SETTING :
			edt = getCurrentDateSetting();
			res.addProperty(epc, edt, (edt != null && edt.length == 4));
			break;
		case EPC_POWER_LIMIT_SETTING :
			edt = getPowerLimitSetting();
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_CUMULATIVE_OPERATING_TIME :
			edt = getCumulativeOperatingTime();
			res.addProperty(epc, edt, (edt != null && edt.length == 5));
			break;
		case EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP :
			edt = getStatusChangeAnnouncementPropertyMap();
			res.addProperty(epc, edt, (edt != null && edt.length <= 17));
			break;
		case EPC_SET_PROPERTY_MAP :
			edt = getSetPropertyMap();
			res.addProperty(epc, edt, (edt != null && edt.length <= 17));
			break;
		case EPC_GET_PROPERTY_MAP :
			edt = getGetPropertyMap();
			res.addProperty(epc, edt, (edt != null && edt.length <= 17));
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
	
	public static class Receiver extends EchoObject.Receiver {

		@Override
		protected void onReceiveSetRes(EchoObject eoj, short tid, byte epc, byte pdc, byte[] edt) {
			super.onReceiveSetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_OPERATION_STATUS :
				onSetOperationStatus(eoj, tid, (pdc != 0));
				break;
			case EPC_INSTALLATION_LOCATION :
				onSetInstallationLocation(eoj, tid, (pdc != 0));
				break;
			case EPC_CURRENT_LIMIT_SETTING :
				onSetCurrentLimitSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_POWER_SAVING_OPERATION_SETTING :
				onSetPowerSavingOperationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_POSITION_INFORMATION :
				onSetPositionInformation(eoj, tid, (pdc != 0));
				break;
			case EPC_CURRENT_TIME_SETTING :
				onSetCurrentTimeSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_CURRENT_DATE_SETTING :
				onSetCurrentDateSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_POWER_LIMIT_SETTING :
				onSetPowerLimitSetting(eoj, tid, (pdc != 0));
				break;
			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_OPERATION_STATUS :
				onGetOperationStatus(eoj, tid, pdc, edt);
				break;
			case EPC_INSTALLATION_LOCATION :
				onGetInstallationLocation(eoj, tid, pdc, edt);
				break;
			case EPC_STANDARD_VERSION_INFORMATION :
				onGetStandardVersionInformation(eoj, tid, pdc, edt);
				break;
			case EPC_IDENTIFICATION_NUMBER :
				onGetIdentificationNumber(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_POWER_CONSUMPTION :
				onGetMeasuredInstantaneousPowerConsumption(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_POWER_CONSUMPTION :
				onGetMeasuredCumulativehPowerConsumption(eoj, tid, pdc, edt);
				break;
			case EPC_MANUFACTURERS_FAULT_CODE :
				onGetManufacturersFaultCode(eoj, tid, pdc, edt);
				break;
			case EPC_CURRENT_LIMIT_SETTING :
				onGetCurrentLimitSetting(eoj, tid, pdc, edt);
				break;
			case EPC_FAULT_STATUS :
				onGetFaultStatus(eoj, tid, pdc, edt);
				break;
			case EPC_FAULT_DESCRIPTION :
				onGetFaultDescription(eoj, tid, pdc, edt);
				break;
			case EPC_MANUFACTURER_CODE :
				onGetManufacturerCode(eoj, tid, pdc, edt);
				break;
			case EPC_BUSINESS_FACILITY_CODE :
				onGetBusinessFacilityCode(eoj, tid, pdc, edt);
				break;
			case EPC_PRODUCT_CODE :
				onGetProductCode(eoj, tid, pdc, edt);
				break;
			case EPC_PRODUCTION_NUMBER :
				onGetProductionNumber(eoj, tid, pdc, edt);
				break;
			case EPC_PRODUCTION_DATE :
				onGetProductionDate(eoj, tid, pdc, edt);
				break;
			case EPC_POWER_SAVING_OPERATION_SETTING :
				onGetPowerSavingOperationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_POSITION_INFORMATION :
				onGetPositionInformation(eoj, tid, pdc, edt);
				break;
			case EPC_CURRENT_TIME_SETTING :
				onGetCurrentTimeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_CURRENT_DATE_SETTING :
				onGetCurrentDateSetting(eoj, tid, pdc, edt);
				break;
			case EPC_POWER_LIMIT_SETTING :
				onGetPowerLimitSetting(eoj, tid, pdc, edt);
				break;
			case EPC_CUMULATIVE_OPERATING_TIME :
				onGetCumulativeOperatingTime(eoj, tid, pdc, edt);
				break;
			case EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP :
				onGetStatusChageAnnouncementPropertyMap(eoj, tid, pdc, edt);
				break;
			case EPC_SET_PROPERTY_MAP :
				onGetSetPropertyMap(eoj, tid, pdc, edt);
				break;
			case EPC_GET_PROPERTY_MAP :
				onGetGetPropertyMap(eoj, tid, pdc, edt);
				break;
			}
		}

		/**
		 * プロパティ名称:動作状態
		 * EPC:0x80
		 * アクセスルール:Set/Get(必須)
		 * 状態変化アナウンス必須
		 */
		protected void onSetOperationStatus(EchoObject eoj, short tid, boolean success) {
		}

		/**
		 * プロパティ名称:動作状態
		 * EPC:0x80
		 * アクセスルール:Set/Get(必須)
		 * 状態変化アナウンス必須
		 */
		protected void onGetOperationStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:設置場所
		 * EPC:0x81
		 * アクセスルール:Set(必須)/Get(必須)
		 * 状態変化アナウンス必須
		 */
		protected void onSetInstallationLocation(EchoObject eoj, short tid, boolean success) {
			
		}

		/**
		 * プロパティ名称:設置場所
		 * EPC:0x81
		 * アクセスルール:Set(必須)/Get(必須)
		 * 状態変化アナウンス必須
		 */
		protected void onGetInstallationLocation(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		/**
		 * プロパティ名称:Version情報
		 * EPC:0x82
		 * アクセスルール:Get(必須)
		 */ 
		protected void onGetStandardVersionInformation(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}
		
		/**
		 * プロパティ名称:識別番号
		 * EPC:0x83
		 * アクセスルール:Get
		 */
		protected void onGetIdentificationNumber(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:瞬時消費電力計測値
		 * EPC:0x84
		 * アクセスルール:Get
		 */
		protected void onGetMeasuredInstantaneousPowerConsumption(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:積算消費電力計測値
		 * EPC:0x85
		 * アクセスルール:Get
		 */
		protected void onGetMeasuredCumulativehPowerConsumption(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:メーカ異常コード
		 * EPC:0x86
		 * アクセスルール:Get
		 */	
		protected void onGetManufacturersFaultCode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:電流制限設定
		 * EPC:0x87
		 * アクセスルール:Set/Get
		 */
		protected void onSetCurrentLimitSetting(EchoObject eoj, short tid, boolean success) {
		}

		/**
		 * プロパティ名称:電流制限設定
		 * EPC:0x87
		 * アクセスルール:Set/Get
		 */
		protected void onGetCurrentLimitSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:異常発生状態
		 * EPC:0x88
		 * アクセスルール:Get(必須)
		 */
		protected void onGetFaultStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}
		
		/**
		 * プロパティ名称:異常内容
		 * EPC:0x89
		 * アクセスルール:Get
		 */
		protected void onGetFaultDescription(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		/**
		 * プロパティ名称:メーカコード
		 * EPC:0x8A
		 * アクセスルール:Get(必須)
		 */ 
		protected void onGetManufacturerCode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}
		
		/**
		 * プロパティ名称:事業場コード
		 * EPC:0x8B
		 * アクセスルール:Get
		 */
		protected void onGetBusinessFacilityCode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		/**
		 * プロパティ名称:商品コード
		 * EPC:0x8C
		 * アクセスルール:Get
		 */
		protected void onGetProductCode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:製造番号
		 * EPC:0x8D
		 * アクセスルール:Get
		 */
		protected void onGetProductionNumber(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		/**
		 * プロパティ名称:製造年月日
		 * EPC:0x8E
		 * アクセスルール:Get
		 */
		protected void onGetProductionDate(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:節電動作設定
		 * EPC:0x8F
		 * アクセスルール:Set/Get
		 */
		protected void onSetPowerSavingOperationSetting(EchoObject eoj, short tid, boolean success) {
		}

		/**
		 * プロパティ名称:節電動作設定
		 * EPC:0x8F
		 * アクセスルール:Set/Get
		 */
		protected void onGetPowerSavingOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:位置情報
		 * EPC:0x93
		 * アクセスルール:Set/Get
		 * 状態変化アナウンス必須
		 */
		protected void onSetPositionInformation(EchoObject eoj, short tid, boolean success) {
		}

		/**
		 * プロパティ名称:位置情報
		 * EPC:0x93
		 * アクセスルール:Set/Get
		 * 状態変化アナウンス必須
		 */	
		protected void onGetPositionInformation(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:現在時刻設定
		 * EPC:0x97
		 * アクセスルール:Set/Get
		 */
		protected void onSetCurrentTimeSetting(EchoObject eoj, short tid, boolean success) {
		}

		/**
		 * プロパティ名称:現在時刻設定
		 * EPC:0x97
		 * アクセスルール:Set/Get
		 */
		protected void onGetCurrentTimeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:現在年月日設定
		 * EPC:0x98
		 * アクセスルール:Set/Get
		 */
		protected void onSetCurrentDateSetting(EchoObject eoj, short tid, boolean success) {
		}

		/**
		 * プロパティ名称:現在年月日設定
		 * EPC:0x98
		 * アクセスルール:Set/Get
		 */
		protected void onGetCurrentDateSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:電力制限設定
		 * EPC:0x99
		 * アクセスルール:Set/Get
		 */
		protected void onSetPowerLimitSetting(EchoObject eoj, short tid, boolean success) {
		}

		/**
		 * プロパティ名称:電力制限設定
		 * EPC:0x99
		 * アクセスルール:Set/Get
		 */
		protected void onGetPowerLimitSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:積算運転時間
		 * EPC:0x9A
		 * アクセスルール:Set/Get
		 */
		protected void onGetCumulativeOperatingTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		/**
		 * プロパティ名称:状変アナウンスプロパティマップ
		 * EPC:0x9D
		 * アクセスルール:Get(必須)
		 */
		protected void onGetStatusChageAnnouncementPropertyMap(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		/**
		 * プロパティ名称:Setプロパティマップ
		 * EPC:0x9E
		 * アクセスルール:Get(必須)
		 */
		protected void onGetSetPropertyMap(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:Getプロパティマップ
		 * EPC:0x9F
		 * アクセスルール:Get(必須)
		 */
		protected void onGetGetPropertyMap(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		
	}

	public interface Setter extends EchoObject.Setter {
		/**
		 * プロパティ名称:動作状態
		 * EPC:0x80
		 * アクセスルール:Set/Get(必須)
		 * 状態変化アナウンス必須
		 */
		public Setter reqSetOperationStatus(byte[] edt);
		/**
		 * プロパティ名称:設置場所
		 * EPC:0x81
		 * アクセスルール:Set(必須)/Get(必須)
		 * 状態変化アナウンス必須
		 */
		public Setter reqSetInstallationLocation(byte[] edt);
		/**
		 * プロパティ名称:電流制限設定
		 * EPC:0x87
		 * アクセスルール:Set/Get
		 */
		public Setter reqSetCurrentLimitSetting(byte[] edt);
		/**
		 * プロパティ名称:節電動作設定
		 * EPC:0x8F
		 * アクセスルール:Set/Get
		 */
		public Setter reqSetPowerSavingOperationSetting(byte[] edt);
		/**
		 * プロパティ名称:位置情報
		 * EPC:0x93
		 * アクセスルール:Set/Get
		 * 状態変化アナウンス必須
		 */
		public Setter reqSetPositionInformation(byte[] edt);
		/**
		 * プロパティ名称:現在時刻設定
		 * EPC:0x97
		 * アクセスルール:Set/Get
		 */
		public Setter reqSetCurrentTimeSetting(byte[] edt);
		/**
		 * プロパティ名称:現在年月日設定
		 * EPC:0x98
		 * アクセスルール:Set/Get
		 */
		public Setter reqSetCurrentDateSetting(byte[] edt);
		/**
		 * プロパティ名称:電力制限設定
		 * EPC:0x99
		 * アクセスルール:Set/Get
		 */
		public Setter reqSetPowerLimitSetting(byte[] edt);
	}
	
	public class SetterImpl extends EchoObject.SetterImpl implements Setter {

		public SetterImpl(byte esv) {
			super(esv);
		}
		
		@Override
		public Setter reqSetOperationStatus(byte[] edt) {
			addProperty(EPC_OPERATION_STATUS, edt, setOperationStatus(edt));
			return this;
		}

		@Override
		public Setter reqSetInstallationLocation(byte[] edt) {
			addProperty(EPC_INSTALLATION_LOCATION, edt, setInstallationLocation(edt));
			return this;
		}

		@Override
		public Setter reqSetCurrentLimitSetting(byte[] edt) {
			addProperty(EPC_CURRENT_LIMIT_SETTING, edt, setCurrentLimitSetting(edt));
			return this;
		}
		
		@Override
		public Setter reqSetPowerSavingOperationSetting(byte[] edt) {
			addProperty(EPC_POWER_SAVING_OPERATION_SETTING, edt, setPowerSavingOperationSetting(edt));
			return this;
		}

		@Override
		public Setter reqSetPositionInformation(byte[] edt) {
			addProperty(EPC_POSITION_INFORMATION, edt, setPositionInformation(edt));
			return this;
		}

		@Override
		public Setter reqSetCurrentTimeSetting(byte[] edt) {
			addProperty(EPC_CURRENT_TIME_SETTING, edt, setCurrentTimeSetting(edt));
			return this;
		}

		@Override
		public Setter reqSetCurrentDateSetting(byte[] edt) {
			addProperty(EPC_CURRENT_DATE_SETTING, edt, setCurrentDateSetting(edt));
			return this;
		}

		@Override
		public Setter reqSetPowerLimitSetting(byte[] edt) {
			addProperty(EPC_POWER_LIMIT_SETTING, edt, setPowerLimitSetting(edt));
			return this;
		}
		
	}

	public class SetterProxy extends EchoObject.SetterProxy implements Setter {

		public SetterProxy(byte esv) {
			super(esv);
		}

		@Override
		public Setter reqSetOperationStatus(byte[] edt) {
			addProperty(EPC_OPERATION_STATUS, edt, (edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetInstallationLocation(byte[] edt) {
			addProperty(EPC_INSTALLATION_LOCATION, edt, (edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetCurrentLimitSetting(byte[] edt) {
			addProperty(EPC_CURRENT_LIMIT_SETTING, edt, (edt.length == 1));
			return this;
		}
		
		@Override
		public Setter reqSetPowerSavingOperationSetting(byte[] edt) {
			addProperty(EPC_POWER_SAVING_OPERATION_SETTING, edt, (edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetPositionInformation(byte[] edt) {
			addProperty(EPC_POSITION_INFORMATION, edt, (edt.length == 16));
			return this;
		}

		@Override
		public Setter reqSetCurrentTimeSetting(byte[] edt) {
			addProperty(EPC_CURRENT_TIME_SETTING, edt, (edt.length == 2));
			return this;
		}

		@Override
		public Setter reqSetCurrentDateSetting(byte[] edt) {
			addProperty(EPC_CURRENT_DATE_SETTING, edt, (edt.length == 4));
			return this;
		}

		@Override
		public Setter reqSetPowerLimitSetting(byte[] edt) {
			addProperty(EPC_POWER_LIMIT_SETTING, edt, (edt.length == 2));
			return this;
		}
		
	}
	
	public interface Getter extends EchoObject.Getter {
		/**
		 * プロパティ名称:動作状態
		 * EPC:0x80
		 * アクセスルール:Set/Get(必須)
		 * 状態変化アナウンス必須
		 */
		public Getter reqGetOperationStatus();
		/**
		 * プロパティ名称:設置場所
		 * EPC:0x81
		 * アクセスルール:Set(必須)/Get(必須)
		 * 状態変化アナウンス必須
		 */
		public Getter reqGetInstallationLocation();
		/**
		 * プロパティ名称:Version情報
		 * EPC:0x82
		 * アクセスルール:Get(必須)
		 */ 
		public Getter reqGetStandardVersionInformation();
		/**
		 * プロパティ名称:識別番号
		 * EPC:0x83
		 * アクセスルール:Get
		 */
		public Getter reqGetIdentificationNumber();
		/**
		 * プロパティ名称:瞬時消費電力計測値
		 * EPC:0x84
		 * アクセスルール:Get
		 */
		public Getter reqGetMeasuredInstantaneousPowerConsumption();
		/**
		 * プロパティ名称:積算消費電力計測値
		 * EPC:0x85
		 * アクセスルール:Get
		 */
		public Getter reqGetMeasuredCumulativePowerConsumption();
		/**
		 * プロパティ名称:メーカ異常コード
		 * EPC:0x86
		 * アクセスルール:Get
		 */	
		public Getter reqGetManufacturersFaultCode();
		/**
		 * プロパティ名称:電流制限設定
		 * EPC:0x87
		 * アクセスルール:Set/Get
		 */
		public Getter reqGetCurrentLimitSetting();
		/**
		 * プロパティ名称:異常発生状態
		 * EPC:0x88
		 * アクセスルール:Get(必須)
		 */
		public Getter reqGetFaultStatus();
		/**
		 * プロパティ名称:異常内容
		 * EPC:0x89
		 * アクセスルール:Get
		 */
		public Getter reqGetFaultDescription();
		/**
		 * プロパティ名称:メーカコード
		 * EPC:0x8A
		 * アクセスルール:Get(必須)
		 */ 
		public Getter reqGetManufacturerCode();
		/**
		 * プロパティ名称:事業場コード
		 * EPC:0x8B
		 * アクセスルール:Get
		 */
		public Getter reqGetBusinessFacilityCode();
		/**
		 * プロパティ名称:商品コード
		 * EPC:0x8C
		 * アクセスルール:Get
		 */
		public Getter reqGetProductCode();
		/**
		 * プロパティ名称:製造番号
		 * EPC:0x8D
		 * アクセスルール:Get
		 */
		public Getter reqGetProductionNumber();
		/**
		 * プロパティ名称:製造年月日
		 * EPC:0x8E
		 * アクセスルール:Get
		 */
		public Getter reqGetProductionDate();
		/**
		 * プロパティ名称:節電動作設定
		 * EPC:0x8F
		 * アクセスルール:Set/Get
		 */
		public Getter reqGetPowerSavingOperationSetting();
		/**
		 * プロパティ名称:位置情報
		 * EPC:0x93
		 * アクセスルール:Set/Get
		 * 状態変化アナウンス必須
		 */	
		public Getter reqGetPositionInformation();
		/**
		 * プロパティ名称:現在時刻設定
		 * EPC:0x97
		 * アクセスルール:Set/Get
		 */
		public Getter reqGetCurrentTimeSetting();
		/**
		 * プロパティ名称:現在年月日設定
		 * EPC:0x98
		 * アクセスルール:Set/Get
		 */
		public Getter reqGetCurrentDateSetting();
		/**
		 * プロパティ名称:電力制限設定
		 * EPC:0x99
		 * アクセスルール:Set/Get
		 */
		public Getter reqGetPowerLimitSetting();
		/**
		 * プロパティ名称:積算運転時間
		 * EPC:0x9A
		 * アクセスルール:Set/Get
		 */
		public Getter reqGetCumulativeOperatingTime();
		/**
		 * プロパティ名称:状変アナウンスプロパティマップ
		 * EPC:0x9D
		 * アクセスルール:Get(必須)
		 */
		public Getter reqGetStatusChangeAnnouncementPropertyMap();
		/**
		 * プロパティ名称:Setプロパティマップ
		 * EPC:0x9E
		 * アクセスルール:Get(必須)
		 */
		public Getter reqGetSetPropertyMap();
		/**
		 * プロパティ名称:Getプロパティマップ
		 * EPC:0x9F
		 * アクセスルール:Get(必須)
		 */
		public Getter reqGetGetPropertyMap();
	}
	
	public class GetterImpl extends EchoObject.GetterImpl implements Getter {

		@Override
		public Getter reqGetOperationStatus() {
			byte[] edt = getOperationStatus();
			addProperty(EPC_OPERATION_STATUS, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetInstallationLocation() {
			byte[] edt = getInstallationLocation();
			addProperty(EPC_INSTALLATION_LOCATION, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetStandardVersionInformation() {
			byte[] edt = getStandardVersionInformation();
			addProperty(EPC_STANDARD_VERSION_INFORMATION, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Getter reqGetIdentificationNumber() {
			byte[] edt = getIdentificationNumber();
			addProperty(EPC_IDENTIFICATION_NUMBER, edt, (edt != null && (edt.length == 9 || edt.length == 17)));
			return this;
		}

		@Override
		public Getter reqGetMeasuredInstantaneousPowerConsumption() {
			byte[] edt = getMeasuredInstantaneousPowerConsumption();
			addProperty(EPC_MEASURED_INSTANTANEOUS_POWER_CONSUMPTION, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Getter reqGetMeasuredCumulativePowerConsumption() {
			byte[] edt = getMeasuredCumulativePowerConsumption();
			addProperty(EPC_MEASURED_CUMULATIVE_POWER_CONSUMPTION, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Getter reqGetManufacturersFaultCode() {
			byte[] edt = getManufacturersFaultCode();
			addProperty(EPC_MANUFACTURERS_FAULT_CODE, edt, (edt != null && edt.length <= 225));
			return this;
		}

		@Override
		public Getter reqGetCurrentLimitSetting() {
			byte[] edt = getCurrentLimitSetting();
			addProperty(EPC_CURRENT_LIMIT_SETTING, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetFaultStatus() {
			byte[] edt = getFaultStatus();
			addProperty(EPC_FAULT_STATUS, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetFaultDescription() {
			byte[] edt = getFaultDescription();
			addProperty(EPC_FAULT_DESCRIPTION, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Getter reqGetManufacturerCode() {
			byte[] edt = getManufacturerCode();
			addProperty(EPC_MANUFACTURER_CODE, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Getter reqGetBusinessFacilityCode() {
			byte[] edt = getBusinessFacilityCode();
			addProperty(EPC_BUSINESS_FACILITY_CODE, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Getter reqGetProductCode() {
			byte[] edt = getProductCode();
			addProperty(EPC_PRODUCT_CODE, edt, (edt != null && edt.length == 12));
			return this;
		}

		@Override
		public Getter reqGetProductionNumber() {
			byte[] edt = getProductionNumber();
			addProperty(EPC_PRODUCTION_NUMBER, edt, (edt != null && edt.length == 12));
			return this;
		}

		@Override
		public Getter reqGetProductionDate() {
			byte[] edt = getProductionDate();
			addProperty(EPC_PRODUCTION_DATE, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Getter reqGetPowerSavingOperationSetting() {
			byte[] edt = getPowerSavingOperationSetting();
			addProperty(EPC_POWER_SAVING_OPERATION_SETTING, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetPositionInformation() {
			byte[] edt = getPositionInformation();
			addProperty(EPC_POSITION_INFORMATION, edt, (edt != null && edt.length == 16));
			return this;
		}

		@Override
		public Getter reqGetCurrentTimeSetting() {
			byte[] edt = getCurrentTimeSetting();
			addProperty(EPC_CURRENT_TIME_SETTING, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Getter reqGetCurrentDateSetting() {
			byte[] edt = getCurrentDateSetting();
			addProperty(EPC_CURRENT_DATE_SETTING, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Getter reqGetPowerLimitSetting() {
			byte[] edt = getPowerLimitSetting();
			addProperty(EPC_POWER_LIMIT_SETTING, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Getter reqGetCumulativeOperatingTime() {
			byte[] edt = getCumulativeOperatingTime();
			addProperty(EPC_CUMULATIVE_OPERATING_TIME, edt, (edt != null && edt.length == 5));
			return this;
		}

		@Override
		public Getter reqGetStatusChangeAnnouncementPropertyMap() {
			byte[] edt = getStatusChangeAnnouncementPropertyMap();
			addProperty(EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP, edt, (edt != null && edt.length <= 17));
			return this;
		}

		@Override
		public Getter reqGetSetPropertyMap() {
			byte[] edt = getSetPropertyMap();
			addProperty(EPC_SET_PROPERTY_MAP, edt, (edt != null && edt.length <= 17));
			return this;
		}

		@Override
		public Getter reqGetGetPropertyMap() {
			byte[] edt = getGetPropertyMap();
			addProperty(EPC_GET_PROPERTY_MAP, edt, (edt != null && edt.length <= 17));
			return this;
		}
		
	}
	
	public class GetterProxy extends EchoObject.GetterProxy implements Getter {

		@Override
		public Getter reqGetOperationStatus() {
			addProperty(EPC_OPERATION_STATUS);
			return this;
		}

		@Override
		public Getter reqGetInstallationLocation() {
			addProperty(EPC_INSTALLATION_LOCATION);
			return this;
		}

		@Override
		public Getter reqGetStandardVersionInformation() {
			addProperty(EPC_STANDARD_VERSION_INFORMATION);
			return this;
		}

		@Override
		public Getter reqGetIdentificationNumber() {
			addProperty(EPC_IDENTIFICATION_NUMBER);
			return this;
		}

		@Override
		public Getter reqGetMeasuredInstantaneousPowerConsumption() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_POWER_CONSUMPTION);
			return this;
		}

		@Override
		public Getter reqGetMeasuredCumulativePowerConsumption() {
			addProperty(EPC_MEASURED_CUMULATIVE_POWER_CONSUMPTION);
			return this;
		}

		@Override
		public Getter reqGetManufacturersFaultCode() {
			addProperty(EPC_MANUFACTURERS_FAULT_CODE);
			return this;
		}

		@Override
		public Getter reqGetCurrentLimitSetting() {
			addProperty(EPC_CURRENT_LIMIT_SETTING);
			return this;
		}

		@Override
		public Getter reqGetFaultStatus() {
			addProperty(EPC_FAULT_STATUS);
			return this;
		}

		@Override
		public Getter reqGetFaultDescription() {
			addProperty(EPC_FAULT_DESCRIPTION);
			return this;
		}

		@Override
		public Getter reqGetManufacturerCode() {
			addProperty(EPC_MANUFACTURER_CODE);
			return this;
		}

		@Override
		public Getter reqGetBusinessFacilityCode() {
			addProperty(EPC_BUSINESS_FACILITY_CODE);
			return this;
		}

		@Override
		public Getter reqGetProductCode() {
			addProperty(EPC_PRODUCT_CODE);
			return this;
		}

		@Override
		public Getter reqGetProductionNumber() {
			addProperty(EPC_PRODUCTION_NUMBER);
			return this;
		}

		@Override
		public Getter reqGetProductionDate() {
			addProperty(EPC_PRODUCTION_DATE);
			return this;
		}

		@Override
		public Getter reqGetPowerSavingOperationSetting() {
			addProperty(EPC_POWER_SAVING_OPERATION_SETTING);
			return this;
		}

		@Override
		public Getter reqGetPositionInformation() {
			addProperty(EPC_POSITION_INFORMATION);
			return this;
		}

		@Override
		public Getter reqGetCurrentTimeSetting() {
			addProperty(EPC_CURRENT_TIME_SETTING);
			return this;
		}

		@Override
		public Getter reqGetCurrentDateSetting() {
			addProperty(EPC_CURRENT_DATE_SETTING);
			return this;
		}

		@Override
		public Getter reqGetPowerLimitSetting() {
			addProperty(EPC_POWER_LIMIT_SETTING);
			return this;
		}

		@Override
		public Getter reqGetCumulativeOperatingTime() {
			addProperty(EPC_CUMULATIVE_OPERATING_TIME);
			return this;
		}

		@Override
		public Getter reqGetStatusChangeAnnouncementPropertyMap() {
			addProperty(EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP);
			return this;
		}

		@Override
		public Getter reqGetSetPropertyMap() {
			addProperty(EPC_GET_PROPERTY_MAP);
			return this;
		}

		@Override
		public Getter reqGetGetPropertyMap() {
			addProperty(EPC_GET_PROPERTY_MAP);
			return this;
		}
		
	}
	
	public interface Informer extends EchoObject.Informer {
		/**
		 * プロパティ名称:動作状態
		 * EPC:0x80
		 * アクセスルール:Set/Get(必須)
		 * 状態変化アナウンス必須
		 */
		public Informer reqInformOperationStatus();
		/**
		 * プロパティ名称:設置場所
		 * EPC:0x81
		 * アクセスルール:Set(必須)/Get(必須)
		 * 状態変化アナウンス必須
		 */
		public Informer reqInformInstallationLocation();
		/**
		 * プロパティ名称:Version情報
		 * EPC:0x82
		 * アクセスルール:Get(必須)
		 */ 
		public Informer reqInformStandardVersionInformation();
		/**
		 * プロパティ名称:識別番号
		 * EPC:0x83
		 * アクセスルール:Get
		 */
		public Informer reqInformIdentificationNumber();
		/**
		 * プロパティ名称:瞬時消費電力計測値
		 * EPC:0x84
		 * アクセスルール:Get
		 */
		public Informer reqInformMeasuredInstantaneousPowerConsumption();
		/**
		 * プロパティ名称:積算消費電力計測値
		 * EPC:0x85
		 * アクセスルール:Get
		 */
		public Informer reqInformMeasuredCumulativePowerConsumption();
		/**
		 * プロパティ名称:メーカ異常コード
		 * EPC:0x86
		 * アクセスルール:Get
		 */	
		public Informer reqInformManufacturersFaultCode();
		/**
		 * プロパティ名称:電流制限設定
		 * EPC:0x87
		 * アクセスルール:Set/Get
		 */
		public Informer reqInformCurrentLimitSetting();
		/**
		 * プロパティ名称:異常発生状態
		 * EPC:0x88
		 * アクセスルール:Get(必須)
		 */
		public Informer reqInformFaultStatus();
		/**
		 * プロパティ名称:異常内容
		 * EPC:0x89
		 * アクセスルール:Get
		 */
		public Informer reqInformFaultDescription();
		/**
		 * プロパティ名称:メーカコード
		 * EPC:0x8A
		 * アクセスルール:Get(必須)
		 */ 
		public Informer reqInformManufacturerCode();
		/**
		 * プロパティ名称:事業場コード
		 * EPC:0x8B
		 * アクセスルール:Get
		 */
		public Informer reqInformBusinessFacilityCode();
		/**
		 * プロパティ名称:商品コード
		 * EPC:0x8C
		 * アクセスルール:Get
		 */
		public Informer reqInformProductCode();
		/**
		 * プロパティ名称:製造番号
		 * EPC:0x8D
		 * アクセスルール:Get
		 */
		public Informer reqInformProductionNumber();
		/**
		 * プロパティ名称:製造年月日
		 * EPC:0x8E
		 * アクセスルール:Get
		 */
		public Informer reqInformProductionDate();
		/**
		 * プロパティ名称:節電動作設定
		 * EPC:0x8F
		 * アクセスルール:Set/Get
		 */
		public Informer reqInformPowerSavingOperationSetting();
		/**
		 * プロパティ名称:位置情報
		 * EPC:0x93
		 * アクセスルール:Set/Get
		 * 状態変化アナウンス必須
		 */	
		public Informer reqInformPositionInformation();
		/**
		 * プロパティ名称:現在時刻設定
		 * EPC:0x97
		 * アクセスルール:Set/Get
		 */
		public Informer reqInformCurrentTimeSetting();
		/**
		 * プロパティ名称:現在年月日設定
		 * EPC:0x98
		 * アクセスルール:Set/Get
		 */
		public Informer reqInformCurrentDateSetting();
		/**
		 * プロパティ名称:電力制限設定
		 * EPC:0x99
		 * アクセスルール:Set/Get
		 */
		public Informer reqInformPowerLimitSetting();
		/**
		 * プロパティ名称:積算運転時間
		 * EPC:0x9A
		 * アクセスルール:Set/Get
		 */
		public Informer reqInformCumulativeOperatingTime();
		/**
		 * プロパティ名称:状変アナウンスプロパティマップ
		 * EPC:0x9D
		 * アクセスルール:Get(必須)
		 */
		public Informer reqInformStatusChangeAnnouncementPropertyMap();
		/**
		 * プロパティ名称:Setプロパティマップ
		 * EPC:0x9E
		 * アクセスルール:Get(必須)
		 */
		public Informer reqInformSetPropertyMap();
		/**
		 * プロパティ名称:Getプロパティマップ
		 * EPC:0x9F
		 * アクセスルール:Get(必須)
		 */
		public Informer reqInformGetPropertyMap();
	}
	
	public class InformerImpl extends EchoObject.InformerImpl implements Informer {

		@Override
		public Informer reqInformOperationStatus() {
			byte[] edt = getOperationStatus();
			addProperty(EPC_OPERATION_STATUS, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformInstallationLocation() {
			byte[] edt = getInstallationLocation();
			addProperty(EPC_INSTALLATION_LOCATION, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformStandardVersionInformation() {
			byte[] edt = getStandardVersionInformation();
			addProperty(EPC_STANDARD_VERSION_INFORMATION, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Informer reqInformIdentificationNumber() {
			byte[] edt = getIdentificationNumber();
			addProperty(EPC_IDENTIFICATION_NUMBER, edt, (edt != null && (edt.length == 9 || edt.length == 17)));
			return this;
		}

		@Override
		public Informer reqInformMeasuredInstantaneousPowerConsumption() {
			byte[] edt = getMeasuredInstantaneousPowerConsumption();
			addProperty(EPC_MEASURED_INSTANTANEOUS_POWER_CONSUMPTION, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformMeasuredCumulativePowerConsumption() {
			byte[] edt = getMeasuredCumulativePowerConsumption();
			addProperty(EPC_MEASURED_CUMULATIVE_POWER_CONSUMPTION, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Informer reqInformManufacturersFaultCode() {
			byte[] edt = getManufacturersFaultCode();
			addProperty(EPC_MANUFACTURERS_FAULT_CODE, edt, (edt != null && edt.length <= 225));
			return this;
		}

		@Override
		public Informer reqInformCurrentLimitSetting() {
			byte[] edt = getCurrentLimitSetting();
			addProperty(EPC_CURRENT_LIMIT_SETTING, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformFaultStatus() {
			byte[] edt = getFaultStatus();
			addProperty(EPC_FAULT_STATUS, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformFaultDescription() {
			byte[] edt = getFaultDescription();
			addProperty(EPC_FAULT_DESCRIPTION, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformManufacturerCode() {
			byte[] edt = getManufacturerCode();
			addProperty(EPC_MANUFACTURER_CODE, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Informer reqInformBusinessFacilityCode() {
			byte[] edt = getBusinessFacilityCode();
			addProperty(EPC_BUSINESS_FACILITY_CODE, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Informer reqInformProductCode() {
			byte[] edt = getProductCode();
			addProperty(EPC_PRODUCT_CODE, edt, (edt != null && edt.length == 12));
			return this;
		}

		@Override
		public Informer reqInformProductionNumber() {
			byte[] edt = getProductionNumber();
			addProperty(EPC_PRODUCTION_NUMBER, edt, (edt != null && edt.length == 12));
			return this;
		}

		@Override
		public Informer reqInformProductionDate() {
			byte[] edt = getProductionDate();
			addProperty(EPC_PRODUCTION_DATE, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Informer reqInformPowerSavingOperationSetting() {
			byte[] edt = getPowerSavingOperationSetting();
			addProperty(EPC_POWER_SAVING_OPERATION_SETTING, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformPositionInformation() {
			byte[] edt = getPositionInformation();
			addProperty(EPC_POSITION_INFORMATION, edt, (edt != null && edt.length == 16));
			return this;
		}

		@Override
		public Informer reqInformCurrentTimeSetting() {
			byte[] edt = getCurrentTimeSetting();
			addProperty(EPC_CURRENT_TIME_SETTING, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformCurrentDateSetting() {
			byte[] edt = getCurrentDateSetting();
			addProperty(EPC_CURRENT_DATE_SETTING, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Informer reqInformPowerLimitSetting() {
			byte[] edt = getPowerLimitSetting();
			addProperty(EPC_POWER_LIMIT_SETTING, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformCumulativeOperatingTime() {
			byte[] edt = getCumulativeOperatingTime();
			addProperty(EPC_CUMULATIVE_OPERATING_TIME, edt, (edt != null && edt.length == 5));
			return this;
		}

		@Override
		public Informer reqInformStatusChangeAnnouncementPropertyMap() {
			byte[] edt = getStatusChangeAnnouncementPropertyMap();
			addProperty(EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP, edt, (edt != null && edt.length <= 17));
			return this;
		}

		@Override
		public Informer reqInformSetPropertyMap() {
			byte[] edt = getSetPropertyMap();
			addProperty(EPC_SET_PROPERTY_MAP, edt, (edt != null && edt.length <= 17));
			return this;
		}

		@Override
		public Informer reqInformGetPropertyMap() {
			byte[] edt = getGetPropertyMap();
			addProperty(EPC_GET_PROPERTY_MAP, edt, (edt != null && edt.length <= 17));
			return this;
		}
		
	}

	public class InformerProxy extends EchoObject.InformerProxy implements Informer {

		@Override
		public Informer reqInformOperationStatus() {
			addProperty(EPC_OPERATION_STATUS);
			return this;
		}

		@Override
		public Informer reqInformInstallationLocation() {
			addProperty(EPC_INSTALLATION_LOCATION);
			return this;
		}

		@Override
		public Informer reqInformStandardVersionInformation() {
			addProperty(EPC_STANDARD_VERSION_INFORMATION);
			return this;
		}

		@Override
		public Informer reqInformIdentificationNumber() {
			addProperty(EPC_IDENTIFICATION_NUMBER);
			return this;
		}

		@Override
		public Informer reqInformMeasuredInstantaneousPowerConsumption() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_POWER_CONSUMPTION);
			return this;
		}

		@Override
		public Informer reqInformMeasuredCumulativePowerConsumption() {
			addProperty(EPC_MEASURED_CUMULATIVE_POWER_CONSUMPTION);
			return this;
		}

		@Override
		public Informer reqInformManufacturersFaultCode() {
			addProperty(EPC_MANUFACTURERS_FAULT_CODE);
			return this;
		}

		@Override
		public Informer reqInformCurrentLimitSetting() {
			addProperty(EPC_CURRENT_LIMIT_SETTING);
			return this;
		}

		@Override
		public Informer reqInformFaultStatus() {
			addProperty(EPC_FAULT_STATUS);
			return this;
		}

		@Override
		public Informer reqInformFaultDescription() {
			addProperty(EPC_FAULT_DESCRIPTION);
			return this;
		}

		@Override
		public Informer reqInformManufacturerCode() {
			addProperty(EPC_MANUFACTURER_CODE);
			return this;
		}

		@Override
		public Informer reqInformBusinessFacilityCode() {
			addProperty(EPC_BUSINESS_FACILITY_CODE);
			return this;
		}

		@Override
		public Informer reqInformProductCode() {
			addProperty(EPC_PRODUCT_CODE);
			return this;
		}

		@Override
		public Informer reqInformProductionNumber() {
			addProperty(EPC_PRODUCTION_NUMBER);
			return this;
		}

		@Override
		public Informer reqInformProductionDate() {
			addProperty(EPC_PRODUCTION_DATE);
			return this;
		}

		@Override
		public Informer reqInformPowerSavingOperationSetting() {
			addProperty(EPC_POWER_SAVING_OPERATION_SETTING);
			return this;
		}

		@Override
		public Informer reqInformPositionInformation() {
			addProperty(EPC_POSITION_INFORMATION);
			return this;
		}

		@Override
		public Informer reqInformCurrentTimeSetting() {
			addProperty(EPC_CURRENT_TIME_SETTING);
			return this;
		}

		@Override
		public Informer reqInformCurrentDateSetting() {
			addProperty(EPC_CURRENT_DATE_SETTING);
			return this;
		}

		@Override
		public Informer reqInformPowerLimitSetting() {
			addProperty(EPC_POWER_LIMIT_SETTING);
			return this;
		}

		@Override
		public Informer reqInformCumulativeOperatingTime() {
			addProperty(EPC_CUMULATIVE_OPERATING_TIME);
			return this;
		}

		@Override
		public Informer reqInformStatusChangeAnnouncementPropertyMap() {
			addProperty(EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP);
			return this;
		}

		@Override
		public Informer reqInformSetPropertyMap() {
			addProperty(EPC_SET_PROPERTY_MAP);
			return this;
		}

		@Override
		public Informer reqInformGetPropertyMap() {
			addProperty(EPC_GET_PROPERTY_MAP);
			return this;
		}
		
	}
}
