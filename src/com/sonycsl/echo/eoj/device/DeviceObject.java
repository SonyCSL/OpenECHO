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

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.EchoUtils;
import com.sonycsl.echo.eoj.EchoObject;

public abstract class DeviceObject extends EchoObject {

	public static final byte EPC_OPERATION_STATUS = (byte)0x80;
	public static final byte EPC_INSTALLATION_LOCATION = (byte)0x81;
	public static final byte EPC_STANDARD_VERSION_INFORMATION = (byte)0x82;
	public static final byte EPC_IDENTIFICATION_NUMBER = (byte)0x83;
	public static final byte EPC_MEASURED_INSTANTANEOUS_POWER_CONSUMPTION = (byte)0x84;
	public static final byte EPC_MEASURED_CUMULATIVE_POWER_CONSUMPTION = (byte)0x85;
	public static final byte EPC_MANUFACTURERS_FAULT_CODE = (byte)0x86;
	public static final byte EPC_CURRENT_LIMIT_SETTING = (byte)0x87;
	public static final byte EPC_FAULT_STATUS = (byte)0x88;
	public static final byte EPC_FAULT_DESCRIPTION = (byte)0x89;
	public static final byte EPC_MANUFACTURER_CODE = (byte)0x8A;
	public static final byte EPC_BUSINESS_FACILITY_CODE = (byte)0x8B;
	public static final byte EPC_PRODUCT_CODE =  (byte)0x8C;
	public static final byte EPC_PRODUCTION_NUMBER = (byte)0x8D;
	public static final byte EPC_PRODUCTION_DATE = (byte)0x8E;
	public static final byte EPC_POWER_SAVING_OPERATION_SETTING = (byte)0x8F;
	public static final byte EPC_REMOTE_CONTROL_SETTING = (byte)0x93;
	public static final byte EPC_CURRENT_TIME_SETTING = (byte)0x97;
	public static final byte EPC_CURRENT_DATE_SETTING = (byte)0x98;
	public static final byte EPC_POWER_LIMIT_SETTING = (byte)0x99;
	public static final byte EPC_CUMULATIVE_OPERATING_TIME = (byte)0x9A;
	public static final byte EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP = (byte)0x9D;
	public static final byte EPC_SET_PROPERTY_MAP = (byte)0x9E;
	public static final byte EPC_GET_PROPERTY_MAP = (byte)0x9F;
	
	public static final byte[] EDT_OPERATION_STATUS_ON = {(byte)0x30};
	public static final byte[] EDT_OPERATION_STATUS_OFF = {(byte)0x31};
	
	public static final byte[] EDT_STANDARD_VERSION_INFORMATION = {(byte)0x00, (byte)0x00, (byte)0x43, (byte)0x00};
	
	protected byte mEchoInstanceCode = 0;
	
	@Override
	public byte getInstanceCode() {
		return mEchoInstanceCode;
	}
	
	public void allocateSelfDeviceInstanceCode() {
		mEchoInstanceCode = EchoUtils.allocateSelfDeviceInstanceCode(getEchoClassCode());
	}

	
	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewDeviceObject(this);
	}

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();

		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		addStatusChangeAnnouncementProperty(EPC_INSTALLATION_LOCATION);
		addStatusChangeAnnouncementProperty(EPC_FAULT_STATUS);
		
		addSetProperty(EPC_INSTALLATION_LOCATION);

		addGetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_INSTALLATION_LOCATION);
		addGetProperty(EPC_STANDARD_VERSION_INFORMATION);
		addGetProperty(EPC_FAULT_STATUS);
		addGetProperty(EPC_MANUFACTURER_CODE);
		addGetProperty(EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP);
		addGetProperty(EPC_SET_PROPERTY_MAP);
		addGetProperty(EPC_GET_PROPERTY_MAP);
	}
	
	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_OPERATION_STATUS : return setOperationStatus(property.edt);
		case EPC_INSTALLATION_LOCATION : return setInstallationLocation(property.edt);
		case EPC_CURRENT_LIMIT_SETTING : return setCurrentLimitSetting(property.edt);
		case EPC_POWER_SAVING_OPERATION_SETTING : return setPowerSavingOperationSetting(property.edt);
		case EPC_REMOTE_CONTROL_SETTING : return setRemoteControlSetting(property.edt);
		case EPC_CURRENT_TIME_SETTING : return setCurrentTimeSetting(property.edt);
		case EPC_CURRENT_DATE_SETTING : return setCurrentDateSetting(property.edt);
		case EPC_POWER_LIMIT_SETTING : return setPowerLimitSetting(property.edt);
		default : return false;
		}
	}

	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_OPERATION_STATUS : return getOperationStatus();
		case EPC_INSTALLATION_LOCATION : return getInstallationLocation();
		case EPC_STANDARD_VERSION_INFORMATION : return getStandardVersionInformation();
		case EPC_IDENTIFICATION_NUMBER : return getIdentificationNumber();
		case EPC_MEASURED_INSTANTANEOUS_POWER_CONSUMPTION : return getMeasuredInstantaneousPowerConsumption();
		case EPC_MEASURED_CUMULATIVE_POWER_CONSUMPTION : return getMeasuredCumulativePowerConsumption();
		case EPC_MANUFACTURERS_FAULT_CODE : return getManufacturersFaultCode();
		case EPC_CURRENT_LIMIT_SETTING : return getCurrentLimitSetting();
		case EPC_FAULT_STATUS : return getFaultStatus();
		case EPC_FAULT_DESCRIPTION :return getFaultDescription();
		case EPC_MANUFACTURER_CODE :return getManufacturerCode();
		case EPC_BUSINESS_FACILITY_CODE : return getBusinessFacilityCode();
		case EPC_PRODUCT_CODE : return getProductCode();
		case EPC_PRODUCTION_NUMBER : return getProductionNumber();
		case EPC_PRODUCTION_DATE : return getProductionDate();
		case EPC_POWER_SAVING_OPERATION_SETTING : return getPowerSavingOperationSetting();
		case EPC_REMOTE_CONTROL_SETTING : return getRemoteControlSetting();
		case EPC_CURRENT_TIME_SETTING : return getCurrentTimeSetting();
		case EPC_CURRENT_DATE_SETTING : return getCurrentDateSetting();
		case EPC_POWER_LIMIT_SETTING : return getPowerLimitSetting();
		case EPC_CUMULATIVE_OPERATING_TIME : return getCumulativeOperatingTime();
		case EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP : return getStatusChangeAnnouncementPropertyMap();
		case EPC_SET_PROPERTY_MAP : return getSetPropertyMap();
		case EPC_GET_PROPERTY_MAP : return getGetPropertyMap();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_OPERATION_STATUS : return isValidOperationStatus(property.edt);
		case EPC_INSTALLATION_LOCATION : return isValidInstallationLocation(property.edt);
		case EPC_STANDARD_VERSION_INFORMATION : return isValidStandardVersionInformation(property.edt);
		case EPC_IDENTIFICATION_NUMBER : return isValidIdentificationNumber(property.edt);
		case EPC_MEASURED_INSTANTANEOUS_POWER_CONSUMPTION : return isValidMeasuredInstantaneousPowerConsumption(property.edt);
		case EPC_MEASURED_CUMULATIVE_POWER_CONSUMPTION : return isValidMeasuredCumulativePowerConsumption(property.edt);
		case EPC_MANUFACTURERS_FAULT_CODE : return isValidManufacturersFaultCode(property.edt);
		case EPC_CURRENT_LIMIT_SETTING : return isValidCurrentLimitSetting(property.edt);
		case EPC_FAULT_STATUS : return isValidFaultStatus(property.edt);
		case EPC_FAULT_DESCRIPTION : return isValidFaultDescription(property.edt);
		case EPC_MANUFACTURER_CODE : return isValidManufacturerCode(property.edt);
		case EPC_BUSINESS_FACILITY_CODE : return isValidBusinessFacilityCode(property.edt);
		case EPC_PRODUCT_CODE :  return isValidProductCode(property.edt);
		case EPC_PRODUCTION_NUMBER : return isValidProductionNumber(property.edt);
		case EPC_PRODUCTION_DATE : return isValidProductionDate(property.edt);
		case EPC_POWER_SAVING_OPERATION_SETTING : return isValidPowerSavingOperationSetting(property.edt);
		case EPC_REMOTE_CONTROL_SETTING : return isValidRemoteControlSetting(property.edt);
		case EPC_CURRENT_TIME_SETTING : return isValidCurrentTimeSetting(property.edt);
		case EPC_CURRENT_DATE_SETTING : return isValidCurrentDateSetting(property.edt);
		case EPC_POWER_LIMIT_SETTING : return isValidPowerLimitSetting(property.edt);
		case EPC_CUMULATIVE_OPERATING_TIME : return isValidCumulativeOperatingTime(property.edt);
		case EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP : return isValidStatusChangeAnnouncementPropertyMap(property.edt);
		case EPC_SET_PROPERTY_MAP : return isValidSetPropertyMap(property.edt);
		case EPC_GET_PROPERTY_MAP : return isValidGetPropertyMap(property.edt);
		default : return false;
		}
	}
	
	/**This property indicates the ON/OFF status.<br>
	 * <br>
	 * ON＝0x30，OFF＝0x31<br>
	 * <br>
	 * Data Type : unsigned char<br>
	 * Data Size(Byte) : 1<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : optional<br>
	 * Get : mandatory<br>
	 * <br>
	 * Announcement at status change<br>
	 */
	protected boolean setOperationStatus(byte[] edt) {
		return false;
	}

	/**This property indicates the ON/OFF status.<br>
	 * <br>
	 * ON＝0x30，OFF＝0x31<br>
	 * <br>
	 * Data Type : unsigned char<br>
	 * Data Size(Byte) : 1<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : optional<br>
	 * Get : mandatory<br>
	 * <br>
	 * Announcement at status change<br>
	 */
	protected abstract byte[] getOperationStatus();


	protected boolean isValidOperationStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		if(edt[0] != EDT_OPERATION_STATUS_ON[0] && edt[0] != EDT_OPERATION_STATUS_OFF[0]) return false;
		return true;
	}
	/**
	 * This property indicates the installation location<br>
	 * <br>
	 * See “2.2 ‘Installation location’ property.”<br>
	 * <br>
	 * Data Type : unsigned char<br>
	 * Data Size(Byte) : 1<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : mandatory<br>
	 * Get : mandatory<br>
	 * <br>
	 * Announcement at status change<br>
	 */
	protected abstract boolean setInstallationLocation(byte[] edt);

	/**
	 * This property indicates the installation location<br>
	 * <br>
	 * See “2.2 ‘Installation location’ property.”<br>
	 * <br>
	 * Data Type : unsigned char<br>
	 * Data Size(Byte) : 1<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : mandatory<br>
	 * Get : mandatory<br>
	 * <br>
	 * Announcement at status change<br>
	 */
	protected abstract byte[] getInstallationLocation();

	protected boolean isValidInstallationLocation(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * This property indicates the version number of the corresponding standard.<br>
	 * <br>
	 * First byte: Fixed at 0x00 (for future reserved). <br>
	 * Second byte: Fixed at 0x00 (for future reserved). <br>
	 * Third byte: Indicates the order of release in the ASCII format. <br>
	 * Fourth byte: Fixed at 0x00 (for future reserved).<br>
	 * <br>
	 * Data Type : unsigned char×4<br>
	 * Data Size(Byte) : 4<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : mandatory<br>
	 */
	protected byte[] getStandardVersionInformation() {return EDT_STANDARD_VERSION_INFORMATION;};
	

	protected boolean isValidStandardVersionInformation(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	
	/**
	 * A number that allows each object to be uniquely identified.<br>
	 * <br>
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
	 * Second and succeeding bytes: unique number field<br>
	 * <br>
	 * Data Type : unsigned char<br>
	 * Data Size(Byte) : 9 or 17<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : optional<br>
	 */
	protected byte[] getIdentificationNumber() {
		return null;
	}

	protected boolean isValidIdentificationNumber(byte[] edt) {
		if(edt == null || !(edt.length == 9 || edt.length == 17)) return false;
		return true;
	}

	/**
	 * This property indicates the instantaneous power consumption of the device in watts.<br>
	 * <br>
	 * 0x0000-0xFFFF（0-65535W）<br>
	 * <br>
	 * Data Type : unsigned short<br>
	 * Data Size(Byte) : 2<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : optional<br>
	 */
	protected byte[] getMeasuredInstantaneousPowerConsumption() {
		return null;
	}

	protected boolean isValidMeasuredInstantaneousPowerConsumption(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	
	/**
	 * This property indicates the cumulative power consumption of the device in increments of 0.001kWh.<br>
	 * <br>
	 * 0x0-0x3B9AC9FF（0-999,999.999kWh）<br>
	 * <br>
	 * Data Type : unsigned long<br>
	 * Data Size(Byte) : 4<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : optional<br>
	 */
	protected byte[] getMeasuredCumulativePowerConsumption() {
		return null;
	}
	
	protected boolean isValidMeasuredCumulativePowerConsumption(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	
	/**
	 * This property indicates the manufacturer-defined fault code.<br>
	 * <br>
	 * First byte: Indicates the data size of the fault code field.<br>
	 * Second to fourth bytes: Manufacturer code<br>
	 * Fifth and succeeding bytes: Field for manufacturer-defined fault code<br>
	 * <br>
	 * Data Type : unsigned char×(MAX)225<br>
	 * Data Size(Byte) : Max 225<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : optional<br>
	 */	
	protected byte[] getManufacturersFaultCode() {
		return null;
	}

	protected boolean isValidManufacturersFaultCode(byte[] edt) {
		if(edt == null || !(edt.length <= 255)) return false;
		return true;
	}
	
	/**
	 * This property indicates the current limit setting (0-100%).<br>
	 * 0x00-0x64 （=0-100%）<br>
	 * <br>
	 * Data Type : unsigned char<br>
	 * Data Size(Byte) : 1<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : optional<br>
	 * Get : optional<br>
	 */
	protected boolean setCurrentLimitSetting(byte[] edt) {
		return false;
	}
	
	/**
	 * This property indicates the current limit setting (0-100%).<br>
	 * <br>
	 * 0x00-0x64 （=0-100%）<br>
	 * <br>
	 * Data Type : unsigned char<br>
	 * Data Size(Byte) : 1<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : optional<br>
	 * Get : optional<br>
	 */
	protected byte[] getCurrentLimitSetting() {
		return null;
	}
	
	protected boolean isValidCurrentLimitSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}

	/**
	 * This property indicates whether a fault (e.g. a sensor trouble) has occurred or not.<br>
	 * <br>
	 * Fault occurred＝0x41, No fault has occurred＝0x42<br>
	 * <br>
	 * Data Type : unsigned char<br>
	 * Data Size(Byte) : 1<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : mandatory<br>
	 * <br>
	 * Announcement at status change<br>
	 */
	protected abstract byte[] getFaultStatus();

	protected boolean isValidFaultStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	
	/**
	 * Describes the fault.<br>
	 * <br>
	 * See “2.5 ‘Fault Description’ Property.”<br>
	 * <br>
	 * Data Type : unsigned short<br>
	 * Data Size(Byte) : 2<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : optional<br>
	 */
	protected byte[] getFaultDescription() {
		return null;
	}
	
	protected boolean isValidFaultDescription(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	
	/**
	 * 3-byte manufacturer code<br>
	 * <br>
	 * (Defined by the ECHONET Consortium.)<br>
	 * <br>
	 * Data Type : unsigned char×3<br>
	 * Data Size(Byte) : 3<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : mandatory<br>
	 */
	protected abstract byte[] getManufacturerCode();
	
	protected boolean isValidManufacturerCode(byte[] edt) {
		if(edt == null || !(edt.length == 3)) return false;
		return true;
	}
	
	/**
	 * 3-byte business facility code<br>
	 * <br>
	 * （Defined by each manufacturer.）<br>
	 * <br>
	 * Data Type : unsigned char×3<br>
	 * Data Size(Byte) : 3<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : optional<br>
	 */
	protected byte[] getBusinessFacilityCode() {
		return null;
	}
	
	protected boolean isValidBusinessFacilityCode(byte[] edt) {
		if(edt == null || !(edt.length == 3)) return false;
		return true;
	}
	
	/**
	 * Identifies the product usingASCI I code.<br>
	 * （Defined by each manufacturer.）<br>
	 * <br>
	 * Data Type : unsigned char×12<br>
	 * Data Size(Byte) : 12<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : optional<br>
	 */
	protected byte[] getProductCode() {
		return null;
	}
	
	protected boolean isValidProductCode(byte[] edt) {
		if(edt == null || !(edt.length == 12)) return false;
		return true;
	}

	/**
	 * This property indicates the production number using ASCI I code.<br>
	 * <br>
	 * （Defined by each manufacturer.）<br>
	 * <br>
	 * Data Type : unsigned char×12<br>
	 * Data Size(Byte) : 12<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : optional<br>
	 */
	protected byte[] getProductionNumber() {
		return null;
	}
	
	protected boolean isValidProductionNumber(byte[] edt) {
		if(edt == null || !(edt.length == 12)) return false;
		return true;
	}
	
	/**
	 * 4-byte production date code<br>
	 * <br>
	 * This property indicates the product ion date in the YYMD format (1 character = 1 byte) .<br>
	 * YY： Year (e.g. 1999＝ 0x07CF)<br>
	 * M： Month (e.g. December＝0x0C)<br>
	 * D： Day (e.g. 20th＝ 0x14)<br>
	 * <br>
	 * Data Type : unsigned char×4<br>
	 * Data Size(Byte) : 4<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : optional<br>
	 */
	protected byte[] getProductionDate() {
		return null;
	}
	
	protected boolean isValidProductionDate(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	
	/**
	 * This property indicates whether the device is operating in power-saving mode.<br>
	 * <br>
	 * Operating in power-saving mode =0x41<br>
	 * Operating in normal operation mode =0x42<br>
	 * <br>
	 * Data Type : unsigned char<br>
	 * Data Size(Byte) : 1<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : optional<br>
	 * Get : optional<br>
	 */
	protected boolean setPowerSavingOperationSetting(byte[] edt) {
		return false;
	}
	
	/**
	 * This property indicates whether the device is operating in power-saving mode.<br>
	 * <br>
	 * Operating in power-saving mode =0x41<br>
	 * Operating in normal operation mode =0x42<br>
	 * <br>
	 * Data Type : unsigned char<br>
	 * Data Size(Byte) : 1<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : optional<br>
	 * Get : optional<br>
	 */
	protected byte[] getPowerSavingOperationSetting() {
		return null;
	}
	
	protected boolean isValidPowerSavingOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}

	/**
	 * This property indicates whether remote control is through a public network or not.<br>
	 * <br>
	 * Not through a public network=0x41<br>
	 * Through a public network=0x42<br>
	 * <br>
	 * Data Type : unsigned char<br>
	 * Data Size(Byte) : 1<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : optional<br>
	 * Get : optional<br>
	 * <br>
	 */
	protected boolean setRemoteControlSetting(byte[] edt) {
		return false;
	}

	/**
	 * This property indicates whether remote control is through a public network or not.<br>
	 * <br>
	 * Not through a public network=0x41<br>
	 * Through a public network=0x42<br>
	 * <br>
	 * Data Type : unsigned char<br>
	 * Data Size(Byte) : 1<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : optional<br>
	 * Get : optional<br>
	 * <br>
	 */
	protected byte[] getRemoteControlSetting() {
		return null;
	}

	protected boolean isValidRemoteControlSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}

	/**
	 * Current time (HH：MM format)<br>
	 * <br>
	 * 0x00-0x17：0x00-0x3B（ ＝ 0-23）：（ ＝ 0-59）<br>
	 * <br>
	 * Data Type : unsigned char×2<br>
	 * Data Size(Byte) : 2<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : optional<br>
	 * Get : optional<br>
	 */
	protected boolean setCurrentTimeSetting(byte[] edt) {
		return false;
	}
	
	/**
	 * Current time (HH：MM format)<br>
	 * <br>
	 * 0x00-0x17 ： 0x00-0x3B（ ＝ 0-23）：（ ＝ 0-59）<br>
	 * <br>
	 * Data Type : unsigned char×2<br>
	 * Data Size(Byte) : 2<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : optional<br>
	 * Get : optional<br>
	 */
	protected byte[] getCurrentTimeSetting() {
		return null;
	}
	
	protected boolean isValidCurrentTimeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}

	/**
	 * Current date (YYYY：MM：DD format)<br>
	 * <br>
	 * 1 ～ 0x270F ： 1 ～ 0x0C ： 1 ～ 0x1F (=1 ～ 9999) ： (=1 ～ 12) ： (=1 ～ 31)<br>
	 * <br>
	 * Data Type : unsigned char×4<br>
	 * Data Size(Byte) : 4<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : optional<br>
	 * Get : optional<br>
	 */
	protected boolean setCurrentDateSetting(byte edt[]) {
		return false;
	}
	
	/**
	 * Current date (YYYY：MM：DD format)<br>
	 * <br>
	 * 1 ～ 0x270F ： 1 ～ 0x0C ： 1 ～ 0x1F (=1 ～ 9999) ： (=1 ～ 12) ： (=1 ～ 31)<br>
	 * <br>
	 * Data Type : unsigned char×4<br>
	 * Data Size(Byte) : 4<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : optional<br>
	 * Get : optional<br>
	 */
	protected byte[] getCurrentDateSetting() {
		return null;
	}
	
	protected boolean isValidCurrentDateSetting(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}

	/**
	 * This property indicates the power limit setting in watts.<br>
	 * <br>
	 * 0x0000~0xFFFF（0-65535W）<br>
	 * <br>
	 * Data Type : unsigned short<br>
	 * Data Size(Byte) : 2<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : optional<br>
	 * Get : optional<br>
	 */
	protected boolean setPowerLimitSetting(byte[] edt) {
		return false;
	}
	
	/**
	 * This property indicates the power limit setting in watts.<br>
	 * <br>
	 * 0x0000~0xFFFF（0-65535W）<br>
	 * <br>
	 * Data Type : unsigned short<br>
	 * Data Size(Byte) : 2<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : optional<br>
	 * Get : optional<br>
	 */
	protected byte[] getPowerLimitSetting() {
		return null;
	}
	
	protected boolean isValidPowerLimitSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}

	/**
	 * This property indicates the cumulative number of days, hours, minutes or seconds for which the device has operated, using 1 byte for the unit and 4 bytes for the time.<br>
	 * <br>
	 * First byte: Indicates the unit.<br>
	 * Second： 0x41; Minute： 0x42; Hour： 0x43; Day:0x44<br>
	 * Second to fifth bytes ：<br>
	 * Indicates the elapsed time in the unit specified by the first byte. 0x00000000-0xFFFFFFFF (0-4294967295)<br>
	 * <br>
	 * Data Type : unsigned char + unsigned long<br>
	 * Data Size(Byte) : 1+4 Byte<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : optional<br>
	 */
	protected byte[] getCumulativeOperatingTime() {
		return null;
	}
	
	protected boolean isValidCumulativeOperatingTime(byte[] edt) {
		if(edt == null || !(edt.length == 5)) return false;
		return true;
	}
	
	/**
	 * See Appendix 1.<br>
	 * <br>
	 * Data Type : unsigned char×(MAX17)<br>
	 * Data Size(Byte) : Max.17<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : mandatory<br>
	 */
	protected byte[] getStatusChangeAnnouncementPropertyMap() {
		return EchoUtils.propertiesToPropertyMap(getStatusChangeAnnouncementProperties());
	}
		
	protected boolean isValidStatusChangeAnnouncementPropertyMap(byte[] edt) {
		if(edt == null || !(edt.length <= 17)) return false;
		return true;
	}
	
	/**
	 * See Appendix 1.<br>
	 * <br>
	 * Data Type : unsigned char×(MAX17)<br>
	 * Data Size(Byte) : Max.17<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : mandatory<br>
	 */
	protected byte[] getSetPropertyMap() {
		return EchoUtils.propertiesToPropertyMap(getSetProperties());
	}
	
	protected boolean isValidSetPropertyMap(byte[] edt) {
		if(edt == null || !(edt.length <= 17)) return false;
		return true;
	}

	/**
	 * See Appendix 1.<br>
	 * <br>
	 * Data Type : unsigned char×(MAX17)<br>
	 * Data Size(Byte) : Max.17<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : mandatory<br>
	 */
	protected byte[] getGetPropertyMap() {
		return EchoUtils.propertiesToPropertyMap(getGetProperties());
	}
	
	protected boolean isValidGetPropertyMap(byte[] edt) {
		if(edt == null || !(edt.length <= 17)) return false;
		return true;
	}

	@Override
	public Setter set() {
		return set(true);
	}

	@Override
	public Setter set(boolean responseRequired) {
		return new Setter(getEchoClassCode(), getInstanceCode()
				, getNode().getAddressStr(), responseRequired);
	}

	@Override
	public Getter get() {
		return new Getter(getEchoClassCode(), getInstanceCode()
				, getNode().getAddressStr());
	}

	@Override
	public Informer inform() {
		return inform(isSelfObject());
	}

	@Override
	protected Informer inform(boolean multicast) {
		String address;
		if(multicast) {
			address = EchoSocket.MULTICAST_ADDRESS;
		} else {
			address = getNode().getAddressStr();
		}
		return new Informer(getEchoClassCode(), getInstanceCode()
				, address, isSelfObject());
	}


	public static class Receiver extends EchoObject.Receiver {

		@Override
		protected boolean onSetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onSetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_OPERATION_STATUS :
				onSetOperationStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_INSTALLATION_LOCATION :
				onSetInstallationLocation(eoj, tid, esv, property, success);
				return true;
			case EPC_CURRENT_LIMIT_SETTING :
				onSetCurrentLimitSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_POWER_SAVING_OPERATION_SETTING :
				onSetPowerSavingOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_REMOTE_CONTROL_SETTING :
				onSetRemoteControlSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CURRENT_TIME_SETTING :
				onSetCurrentTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CURRENT_DATE_SETTING :
				onSetCurrentDateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_POWER_LIMIT_SETTING :
				onSetPowerLimitSetting(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}

		@Override
		protected boolean onGetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onGetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_OPERATION_STATUS :
				onGetOperationStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_INSTALLATION_LOCATION :
				onGetInstallationLocation(eoj, tid, esv, property, success);
				return true;
			case EPC_STANDARD_VERSION_INFORMATION :
				onGetStandardVersionInformation(eoj, tid, esv, property, success);
				return true;
			case EPC_IDENTIFICATION_NUMBER :
				onGetIdentificationNumber(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INSTANTANEOUS_POWER_CONSUMPTION :
				onGetMeasuredInstantaneousPowerConsumption(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_CUMULATIVE_POWER_CONSUMPTION :
				onGetMeasuredCumulativePowerConsumption(eoj, tid, esv, property, success);
				return true;
			case EPC_MANUFACTURERS_FAULT_CODE :
				onGetManufacturersFaultCode(eoj, tid, esv, property, success);
				return true;
			case EPC_CURRENT_LIMIT_SETTING :
				onGetCurrentLimitSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_FAULT_STATUS :
				onGetFaultStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_FAULT_DESCRIPTION :
				onGetFaultDescription(eoj, tid, esv, property, success);
				return true;
			case EPC_MANUFACTURER_CODE :
				onGetManufacturerCode(eoj, tid, esv, property, success);
				return true;
			case EPC_BUSINESS_FACILITY_CODE :
				onGetBusinessFacilityCode(eoj, tid, esv, property, success);
				return true;
			case EPC_PRODUCT_CODE :
				onGetProductCode(eoj, tid, esv, property, success);
				return true;
			case EPC_PRODUCTION_NUMBER :
				onGetProductionNumber(eoj, tid, esv, property, success);
				return true;
			case EPC_PRODUCTION_DATE :
				onGetProductionDate(eoj, tid, esv, property, success);
				return true;
			case EPC_POWER_SAVING_OPERATION_SETTING :
				onGetPowerSavingOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_REMOTE_CONTROL_SETTING :
				onGetRemoteControlSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CURRENT_TIME_SETTING :
				onGetCurrentTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CURRENT_DATE_SETTING :
				onGetCurrentDateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_POWER_LIMIT_SETTING :
				onGetPowerLimitSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CUMULATIVE_OPERATING_TIME :
				onGetCumulativeOperatingTime(eoj, tid, esv, property, success);
				return true;
			case EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP :
				onGetStatusChangeAnnouncementPropertyMap(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_PROPERTY_MAP :
				onGetSetPropertyMap(eoj, tid, esv, property, success);
				return true;
			case EPC_GET_PROPERTY_MAP :
				onGetGetPropertyMap(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * This property indicates the ON/OFF status.<br>
		 * ON＝0x30，OFF＝0x31<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : mandatory<br>
		 * Announcement at status change
		 */
		protected void onSetOperationStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}

		/**
		 * This property indicates the ON/OFF status.<br>
		 * ON＝0x30，OFF＝0x31<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : mandatory<br>
		 * Announcement at status change
		 */
		protected void onGetOperationStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * This property indicates the installation location<br>
		 * See “2.2 ‘Installation location’ property.”<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : mandatory<br>
		 * Get : mandatory<br>
		 * Announcement at status change
		 */
		protected void onSetInstallationLocation(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}

		/**
		 * This property indicates the installation location<br>
		 * See “2.2 ‘Installation location’ property.”<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : mandatory<br>
		 * Get : mandatory<br>
		 * Announcement at status change
		 */
		protected void onGetInstallationLocation(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * This property indicates the version number of the corresponding standard.<br>
		 * First byte: Fixed at 0x00 (for future reserved). <br>
		 * Second byte: Fixed at 0x00 (for future reserved). <br>
		 * Third byte: Indicates the order of release in the ASCII format. <br>
		 * Fourth byte: Fixed at 0x00 (for future reserved).<br><br>
		 * Data Type : unsigned char×4<br>
		 * Data Size(Byte) : 4<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		protected void onGetStandardVersionInformation(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
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
		 * Second and succeeding bytes: unique number field<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 9 or 17<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		protected void onGetIdentificationNumber(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * This property indicates the instantaneous power consumption of the device in watts.<br>
		 * 0x0000-0xFFFF（0-65535W）<br><br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		protected void onGetMeasuredInstantaneousPowerConsumption(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * This property indicates the cumulative power consumption of the device in increments of 0.001kWh.<br>
		 * 0x0-0x3B9AC9FF（0-999,999.999kWh）<br><br>
		 * Data Type : unsigned long<br>
		 * Data Size(Byte) : 4<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		protected void onGetMeasuredCumulativePowerConsumption(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * This property indicates the manufacturer-defined fault code.<br>
		 * First byte: Indicates the data size of the fault code field.<br>
		 * Second to fourth bytes: Manufacturer code<br>
		 * Fifth and succeeding bytes: Field for manufacturer-defined fault code<br><br>
		 * Data Type : unsigned char×(MAX)225<br>
		 * Data Size(Byte) : Max 225<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		protected void onGetManufacturersFaultCode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * This property indicates the current limit setting (0-100%).<br>
		 * 0x00-0x64 （=0-100%）<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		protected void onSetCurrentLimitSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}

		/**
		 * This property indicates the current limit setting (0-100%).<br>
		 * 0x00-0x64 （=0-100%）<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		protected void onGetCurrentLimitSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}

		/**
		 * This property indicates whether a fault (e.g. a sensor trouble) has occurred or not.<br>
		 * Fault occurred＝0x41, No fault has occurred＝0x42<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 * Announcement at status change
		 */
		protected void onGetFaultStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * Describes the fault.<br>
		 * See “2.5 ‘Fault Description’ Property.”<br><br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		protected void onGetFaultDescription(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * 3-byte manufacturer code<br>
		 * (Defined by the ECHONET Consortium.)<br><br>
		 * Data Type : unsigned char×3<br>
		 * Data Size(Byte) : 3<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */ 
		protected void onGetManufacturerCode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * 3-byte business facility code<br>
		 * （Defined by each manufacturer.）<br><br>
		 * Data Type : unsigned char×3<br>
		 * Data Size(Byte) : 3<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		protected void onGetBusinessFacilityCode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * Identifies the product usingASCI I code.<br>
		 * （Defined by each manufacturer.）<br><br>
		 * Data Type : unsigned char×12<br>
		 * Data Size(Byte) : 12<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		protected void onGetProductCode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * This property indicates the production number using ASCI I code.<br>
		 * （Defined by each manufacturer.）<br><br>
		 * Data Type : unsigned char×12<br>
		 * Data Size(Byte) : 12<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		protected void onGetProductionNumber(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * 4-byte production date code<br>
		 * This property indicates the product ion date in the YYMD format (1 character = 1 byte) .<br>
		 * YY： Year (e.g. 1999＝ 0x07CF)<br>
		 * M： Month (e.g. December＝0x0C)<br>
		 * D： Day (e.g. 20th＝ 0x14)<br><br>
		 * Data Type : unsigned char×4<br>
		 * Data Size(Byte) : 4<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		protected void onGetProductionDate(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * This property indicates whether the device is operating in power-saving mode.<br>
		 * Operating in power-saving mode =0x41<br>
		 * Operating in normal operation mode =0x42<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		protected void onSetPowerSavingOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * This property indicates whether the device is operating in power-saving mode.<br>
		 * Operating in power-saving mode =0x41<br>
		 * Operating in normal operation mode =0x42<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		protected void onGetPowerSavingOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * This property indicates whether remote control is through a public network or not.<br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : optional<br>
		 */
		protected void onSetRemoteControlSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}

		/**
		 * This property indicates whether remote control is through a public network or not.<br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : optional<br>
		 */
		protected void onGetRemoteControlSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * Current time (HH：MM format)<br>
		 * 0x00-0x17：0x00-0x3B（ ＝ 0-23）：（ ＝ 0-59）<br><br>
		 * Data Type : unsigned char×2<br>
		 * Data Size(Byte) : 2<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		protected void onSetCurrentTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * Current time (HH：MM format)<br>
		 * 0x00-0x17：0x00-0x3B（ ＝ 0-23）：（ ＝ 0-59）<br><br>
		 * Data Type : unsigned char×2<br>
		 * Data Size(Byte) : 2<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		protected void onGetCurrentTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * Current date (YYYY：MM：DD format)<br>
		 * 1 ～ 0x270F ： 1 ～ 0x0C ： 1 ～ 0x1F (=1 ～ 9999) ： (=1 ～ 12) ： (=1 ～ 31)<br><br>
		 * Data Type : unsigned char×4<br>
		 * Data Size(Byte) : 4<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		protected void onSetCurrentDateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}

		/**
		 * Current date (YYYY：MM：DD format)<br>
		 * 1 ～ 0x270F ： 1 ～ 0x0C ： 1 ～ 0x1F (=1 ～ 9999) ： (=1 ～ 12) ： (=1 ～ 31)<br><br>
		 * Data Type : unsigned char×4<br>
		 * Data Size(Byte) : 4<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		protected void onGetCurrentDateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * This property indicates the power limit setting in watts.<br>
		 * 0x0000~0xFFFF（0-65535W）<br><br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		protected void onSetPowerLimitSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}

		/**
		 * This property indicates the power limit setting in watts.<br>
		 * 0x0000~0xFFFF（0-65535W）<br><br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		protected void onGetPowerLimitSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * This property indicates the cumulative number of days, hours, minutes or seconds for which the device has operated, using 1 byte for the unit and 4 bytes for the time.<br>
		 * First byte: Indicates the unit.<br>
		 * Second： 0x41; Minute： 0x42; Hour： 0x43; Day:0x44<br>
		 * Second to fifth bytes ：<br>
		 * Indicates the elapsed time in the unit specified by the first byte. 0x00000000-0xFFFFFFFF (0-4294967295)<br><br>
		 * Data Type : unsigned char + unsigned long<br>
		 * Data Size(Byte) : 1+4 Byte<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		protected void onGetCumulativeOperatingTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * See Appendix 1.<br><br>
		 * Data Type : unsigned char×(MAX17)<br>
		 * Data Size(Byte) : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		protected void onGetStatusChangeAnnouncementPropertyMap(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * See Appendix 1.<br><br>
		 * Data Type : unsigned char×(MAX17)<br>
		 * Data Size(Byte) : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		protected void onGetSetPropertyMap(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * See Appendix 1.<br><br>
		 * Data Type : unsigned char×(MAX17)<br>
		 * Data Size(Byte) : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		protected void onGetGetPropertyMap(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
	}

	public static class Setter extends EchoObject.Setter {
		public Setter(short dstEchoClassCode, byte dstEchoInstanceCode
				, String dstEchoAddress, boolean responseRequired) {
			super(dstEchoClassCode, dstEchoInstanceCode
					, dstEchoAddress, responseRequired);
		}
		
		
		@Override
		public Setter reqSetProperty(byte epc, byte[] edt) {
			return (Setter)super.reqSetProperty(epc, edt);
		}

		/**
		 * This property indicates the ON/OFF status.<br>
		 * ON＝0x30，OFF＝0x31<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : mandatory<br>
		 * Announcement at status change
		 */
		public Setter reqSetOperationStatus(byte[] edt) {
			reqSetProperty(EPC_OPERATION_STATUS, edt);
			return this;
		}
		/**
		 * This property indicates the installation location<br>
		 * See “2.2 ‘Installation location’ property.”<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : mandatory<br>
		 * Get : mandatory<br>
		 * Announcement at status change
		 */
		public Setter reqSetInstallationLocation(byte[] edt) {
			reqSetProperty(EPC_INSTALLATION_LOCATION, edt);
			return this;
		}
		/**
		 * This property indicates the current limit setting (0-100%).<br>
		 * 0x00-0x64 （=0-100%）<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		public Setter reqSetCurrentLimitSetting(byte[] edt) {
			reqSetProperty(EPC_CURRENT_LIMIT_SETTING, edt);
			return this;
		}
		/**
		 * This property indicates whether the device is operating in power-saving mode.<br>
		 * Operating in power-saving mode =0x41<br>
		 * Operating in normal operation mode =0x42<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		public Setter reqSetPowerSavingOperationSetting(byte[] edt) {
			reqSetProperty(EPC_POWER_SAVING_OPERATION_SETTING, edt);
			return this;
		}

		/**
		 * This property indicates whether remote control is through a public network or not.<br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : optional<br>
		 */
		public Setter reqSetRemoteControlSetting(byte[] edt) {
			reqSetProperty(EPC_REMOTE_CONTROL_SETTING, edt);
			return this;
		}
		/**
		 * Current time (HH：MM format)<br>
		 * 0x00-0x17：0x00-0x3B（ ＝ 0-23）：（ ＝ 0-59）<br><br>
		 * Data Type : unsigned char×2<br>
		 * Data Size(Byte) : 2<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		public Setter reqSetCurrentTimeSetting(byte[] edt) {
			reqSetProperty(EPC_CURRENT_TIME_SETTING, edt);
			return this;
		}
		/**
		 * Current date (YYYY：MM：DD format)<br>
		 * 1 ～ 0x270F ： 1 ～ 0x0C ： 1 ～ 0x1F (=1 ～ 9999) ： (=1 ～ 12) ： (=1 ～ 31)<br><br>
		 * Data Type : unsigned char×4<br>
		 * Data Size(Byte) : 4<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		public Setter reqSetCurrentDateSetting(byte[] edt) {
			reqSetProperty(EPC_CURRENT_DATE_SETTING, edt);
			return this;
		}
		/**
		 * This property indicates the power limit setting in watts.<br>
		 * 0x0000~0xFFFF（0-65535W）<br><br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		public Setter reqSetPowerLimitSetting(byte[] edt) {
			reqSetProperty(EPC_POWER_LIMIT_SETTING, edt);
			return this;
		}
	}
	
	public static class Getter extends EchoObject.Getter {

		public Getter(short dstEchoClassCode, byte dstEchoInstanceCode
				, String dstEchoAddress) {
			super(dstEchoClassCode, dstEchoInstanceCode
					, dstEchoAddress);
		}
		@Override
		public Getter reqGetProperty(byte epc) {
			return (Getter)super.reqGetProperty(epc);
		}
		/**
		 * This property indicates the ON/OFF status.<br>
		 * ON＝0x30，OFF＝0x31<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : mandatory<br>
		 * Announcement at status change
		 */
		public Getter reqGetOperationStatus() {
			reqGetProperty(EPC_OPERATION_STATUS);
			return this;
		}
		/**
		 * This property indicates the installation location<br>
		 * See “2.2 ‘Installation location’ property.”<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : mandatory<br>
		 * Get : mandatory<br>
		 * Announcement at status change
		 */
		public Getter reqGetInstallationLocation() {
			reqGetProperty(EPC_INSTALLATION_LOCATION);
			return this;
		}
		/**
		 * This property indicates the version number of the corresponding standard.<br>
		 * First byte: Fixed at 0x00 (for future reserved). <br>
		 * Second byte: Fixed at 0x00 (for future reserved). <br>
		 * Third byte: Indicates the order of release in the ASCII format. <br>
		 * Fourth byte: Fixed at 0x00 (for future reserved).<br><br>
		 * Data Type : unsigned char×4<br>
		 * Data Size(Byte) : 4<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Getter reqGetStandardVersionInformation() {
			reqGetProperty(EPC_STANDARD_VERSION_INFORMATION);
			return this;
		}
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
		 * Second and succeeding bytes: unique number field<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 9 or 17<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Getter reqGetIdentificationNumber() {
			reqGetProperty(EPC_IDENTIFICATION_NUMBER);
			return this;
		}
		/**
		 * This property indicates the instantaneous power consumption of the device in watts.<br>
		 * 0x0000-0xFFFF（0-65535W）<br><br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Getter reqGetMeasuredInstantaneousPowerConsumption() {
			reqGetProperty(EPC_MEASURED_INSTANTANEOUS_POWER_CONSUMPTION);
			return this;
		}
		/**
		 * This property indicates the cumulative power consumption of the device in increments of 0.001kWh.<br>
		 * 0x0-0x3B9AC9FF（0-999,999.999kWh）<br><br>
		 * Data Type : unsigned long<br>
		 * Data Size(Byte) : 4<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Getter reqGetMeasuredCumulativePowerConsumption() {
			reqGetProperty(EPC_MEASURED_CUMULATIVE_POWER_CONSUMPTION);
			return this;
		}
		/**
		 * This property indicates the manufacturer-defined fault code.<br>
		 * First byte: Indicates the data size of the fault code field.<br>
		 * Second to fourth bytes: Manufacturer code<br>
		 * Fifth and succeeding bytes: Field for manufacturer-defined fault code<br><br>
		 * Data Type : unsigned char×(MAX)225<br>
		 * Data Size(Byte) : Max 225<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Getter reqGetManufacturersFaultCode() {
			reqGetProperty(EPC_MANUFACTURERS_FAULT_CODE);
			return this;
		}
		/**
		 * This property indicates the current limit setting (0-100%).<br>
		 * 0x00-0x64 （=0-100%）<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		public Getter reqGetCurrentLimitSetting() {
			reqGetProperty(EPC_CURRENT_LIMIT_SETTING);
			return this;
		}
		/**
		 * This property indicates whether a fault (e.g. a sensor trouble) has occurred or not.<br>
		 * Fault occurred＝0x41, No fault has occurred＝0x42<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 * Announcement at status change
		 */
		public Getter reqGetFaultStatus() {
			reqGetProperty(EPC_FAULT_STATUS);
			return this;
		}
		/**
		 * Describes the fault.<br>
		 * See “2.5 ‘Fault Description’ Property.”<br><br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Getter reqGetFaultDescription() {
			reqGetProperty(EPC_FAULT_DESCRIPTION);
			return this;
		}
		/**
		 * 3-byte manufacturer code<br>
		 * (Defined by the ECHONET Consortium.)<br><br>
		 * Data Type : unsigned char×3<br>
		 * Data Size(Byte) : 3<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Getter reqGetManufacturerCode() {
			reqGetProperty(EPC_MANUFACTURER_CODE);
			return this;
		}
		/**
		 * 3-byte business facility code<br>
		 * （Defined by each manufacturer.）<br><br>
		 * Data Type : unsigned char×3<br>
		 * Data Size(Byte) : 3<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Getter reqGetBusinessFacilityCode() {
			reqGetProperty(EPC_BUSINESS_FACILITY_CODE);
			return this;
		}
		/**
		 * Identifies the product usingASCI I code.<br>
		 * （Defined by each manufacturer.）<br><br>
		 * Data Type : unsigned char×12<br>
		 * Data Size(Byte) : 12<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Getter reqGetProductCode() {
			reqGetProperty(EPC_PRODUCT_CODE);
			return this;
		}
		/**
		 * This property indicates the production number using ASCI I code.<br>
		 * （Defined by each manufacturer.）<br><br>
		 * Data Type : unsigned char×12<br>
		 * Data Size(Byte) : 12<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Getter reqGetProductionNumber() {
			reqGetProperty(EPC_PRODUCTION_NUMBER);
			return this;
		}
		/**
		 * 4-byte production date code<br>
		 * This property indicates the product ion date in the YYMD format (1 character = 1 byte) .<br>
		 * YY： Year (e.g. 1999＝ 0x07CF)<br>
		 * M： Month (e.g. December＝0x0C)<br>
		 * D： Day (e.g. 20th＝ 0x14)<br><br>
		 * Data Type : unsigned char×4<br>
		 * Data Size(Byte) : 4<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Getter reqGetProductionDate() {
			reqGetProperty(EPC_PRODUCTION_DATE);
			return this;
		}
		/**
		 * This property indicates whether the device is operating in power-saving mode.<br>
		 * Operating in power-saving mode =0x41<br>
		 * Operating in normal operation mode =0x42<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		public Getter reqGetPowerSavingOperationSetting() {
			reqGetProperty(EPC_POWER_SAVING_OPERATION_SETTING);
			return this;
		}
		/**
		 * This property indicates whether remote control is through a public network or not.<br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : optional<br>
		 */
		public Getter reqGetRemoteControlSetting() {
			reqGetProperty(EPC_REMOTE_CONTROL_SETTING);
			return this;
		}
		/**
		 * Current time (HH：MM format)<br>
		 * 0x00-0x17：0x00-0x3B（ ＝ 0-23）：（ ＝ 0-59）<br><br>
		 * Data Type : unsigned char×2<br>
		 * Data Size(Byte) : 2<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		public Getter reqGetCurrentTimeSetting() {
			reqGetProperty(EPC_CURRENT_TIME_SETTING);
			return this;
		}
		/**
		 * Current date (YYYY：MM：DD format)<br>
		 * 1 ～ 0x270F ： 1 ～ 0x0C ： 1 ～ 0x1F (=1 ～ 9999) ： (=1 ～ 12) ： (=1 ～ 31)<br><br>
		 * Data Type : unsigned char×4<br>
		 * Data Size(Byte) : 4<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		public Getter reqGetCurrentDateSetting() {
			reqGetProperty(EPC_CURRENT_DATE_SETTING);
			return this;
		}
		/**
		 * This property indicates the power limit setting in watts.<br>
		 * 0x0000~0xFFFF（0-65535W）<br><br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		public Getter reqGetPowerLimitSetting() {
			reqGetProperty(EPC_POWER_LIMIT_SETTING);
			return this;
		}
		/**
		 * This property indicates the cumulative number of days, hours, minutes or seconds for which the device has operated, using 1 byte for the unit and 4 bytes for the time.<br>
		 * First byte: Indicates the unit.<br>
		 * Second： 0x41; Minute： 0x42; Hour： 0x43; Day:0x44<br>
		 * Second to fifth bytes ：<br>
		 * Indicates the elapsed time in the unit specified by the first byte. 0x00000000-0xFFFFFFFF (0-4294967295)<br><br>
		 * Data Type : unsigned char + unsigned long<br>
		 * Data Size(Byte) : 1+4 Byte<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Getter reqGetCumulativeOperatingTime() {
			reqGetProperty(EPC_CUMULATIVE_OPERATING_TIME);
			return this;
		}
		/**
		 * See Appendix 1.<br><br>
		 * Data Type : unsigned char×(MAX17)<br>
		 * Data Size(Byte) : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Getter reqGetStatusChangeAnnouncementPropertyMap() {
			reqGetProperty(EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP);
			return this;
		}
		/**
		 * See Appendix 1.<br><br>
		 * Data Type : unsigned char×(MAX17)<br>
		 * Data Size(Byte) : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Getter reqGetSetPropertyMap() {
			reqGetProperty(EPC_SET_PROPERTY_MAP);
			return this;
		}
		/**
		 * See Appendix 1.<br><br>
		 * Data Type : unsigned char×(MAX17)<br>
		 * Data Size(Byte) : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Getter reqGetGetPropertyMap() {
			reqGetProperty(EPC_GET_PROPERTY_MAP);
			return this;
		}
	}
	
	public static class Informer extends EchoObject.Informer {


		public Informer(short echoClassCode, byte echoInstanceCode
				, String dstEchoAddress, boolean isSelfObject) {
			super(echoClassCode, echoInstanceCode
					, dstEchoAddress, isSelfObject);
		}

		@Override
		public Informer reqInformProperty(byte epc) {
			return (Informer)super.reqInformProperty(epc);
		}
		
		/**
		 * This property indicates the ON/OFF status.<br>
		 * ON＝0x30，OFF＝0x31<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : mandatory<br>
		 * Announcement at status change
		 */
		public Informer reqInformOperationStatus() {
			reqInformProperty(EPC_OPERATION_STATUS);
			return this;
		}
		/**
		 * This property indicates the installation location<br>
		 * See “2.2 ‘Installation location’ property.”<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : mandatory<br>
		 * Get : mandatory<br>
		 * Announcement at status change
		 */
		public Informer reqInformInstallationLocation() {
			reqInformProperty(EPC_INSTALLATION_LOCATION);
			return this;
		}
		/**
		 * This property indicates the version number of the corresponding standard.<br>
		 * First byte: Fixed at 0x00 (for future reserved). <br>
		 * Second byte: Fixed at 0x00 (for future reserved). <br>
		 * Third byte: Indicates the order of release in the ASCII format. <br>
		 * Fourth byte: Fixed at 0x00 (for future reserved).<br><br>
		 * Data Type : unsigned char×4<br>
		 * Data Size(Byte) : 4<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Informer reqInformStandardVersionInformation() {
			reqInformProperty(EPC_STANDARD_VERSION_INFORMATION);
			return this;
		}
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
		 * Second and succeeding bytes: unique number field<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 9 or 17<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Informer reqInformIdentificationNumber() {
			reqInformProperty(EPC_IDENTIFICATION_NUMBER);
			return this;
		}
		/**
		 * This property indicates the instantaneous power consumption of the device in watts.<br>
		 * 0x0000-0xFFFF（0-65535W）<br><br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Informer reqInformMeasuredInstantaneousPowerConsumption() {
			reqInformProperty(EPC_MEASURED_INSTANTANEOUS_POWER_CONSUMPTION);
			return this;
		}
		/**
		 * This property indicates the cumulative power consumption of the device in increments of 0.001kWh.<br>
		 * 0x0-0x3B9AC9FF（0-999,999.999kWh）<br><br>
		 * Data Type : unsigned long<br>
		 * Data Size(Byte) : 4<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Informer reqInformMeasuredCumulativePowerConsumption() {
			reqInformProperty(EPC_MEASURED_CUMULATIVE_POWER_CONSUMPTION);
			return this;
		}
		/**
		 * This property indicates the manufacturer-defined fault code.<br>
		 * First byte: Indicates the data size of the fault code field.<br>
		 * Second to fourth bytes: Manufacturer code<br>
		 * Fifth and succeeding bytes: Field for manufacturer-defined fault code<br><br>
		 * Data Type : unsigned char×(MAX)225<br>
		 * Data Size(Byte) : Max 225<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Informer reqInformManufacturersFaultCode() {
			reqInformProperty(EPC_MANUFACTURERS_FAULT_CODE);
			return this;
		}
		/**
		 * This property indicates the current limit setting (0-100%).<br>
		 * 0x00-0x64 （=0-100%）<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		public Informer reqInformCurrentLimitSetting() {
			reqInformProperty(EPC_CURRENT_LIMIT_SETTING);
			return this;
		}
		/**
		 * This property indicates whether a fault (e.g. a sensor trouble) has occurred or not.<br>
		 * Fault occurred＝0x41, No fault has occurred＝0x42<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 * Announcement at status change
		 */
		public Informer reqInformFaultStatus() {
			reqInformProperty(EPC_FAULT_STATUS);
			return this;
		}
		/**
		 * Describes the fault.<br>
		 * See “2.5 ‘Fault Description’ Property.”<br><br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Informer reqInformFaultDescription() {
			reqInformProperty(EPC_FAULT_DESCRIPTION);
			return this;
		}
		/**
		 * 3-byte manufacturer code<br>
		 * (Defined by the ECHONET Consortium.)<br><br>
		 * Data Type : unsigned char×3<br>
		 * Data Size(Byte) : 3<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Informer reqInformManufacturerCode() {
			reqInformProperty(EPC_MANUFACTURER_CODE);
			return this;
		}
		/**
		 * 3-byte business facility code<br>
		 * （Defined by each manufacturer.）<br><br>
		 * Data Type : unsigned char×3<br>
		 * Data Size(Byte) : 3<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Informer reqInformBusinessFacilityCode() {
			reqInformProperty(EPC_BUSINESS_FACILITY_CODE);
			return this;
		}
		/**
		 * Identifies the product usingASCI I code.<br>
		 * （Defined by each manufacturer.）<br><br>
		 * Data Type : unsigned char×12<br>
		 * Data Size(Byte) : 12<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Informer reqInformProductCode() {
			reqInformProperty(EPC_PRODUCT_CODE);
			return this;
		}
		/**
		 * This property indicates the production number using ASCI I code.<br>
		 * （Defined by each manufacturer.）<br><br>
		 * Data Type : unsigned char×12<br>
		 * Data Size(Byte) : 12<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Informer reqInformProductionNumber() {
			reqInformProperty(EPC_PRODUCTION_NUMBER);
			return this;
		}
		/**
		 * 4-byte production date code<br>
		 * This property indicates the product ion date in the YYMD format (1 character = 1 byte) .<br>
		 * YY： Year (e.g. 1999＝ 0x07CF)<br>
		 * M： Month (e.g. December＝0x0C)<br>
		 * D： Day (e.g. 20th＝ 0x14)<br><br>
		 * Data Type : unsigned char×4<br>
		 * Data Size(Byte) : 4<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Informer reqInformProductionDate() {
			reqInformProperty(EPC_PRODUCTION_DATE);
			return this;
		}
		/**
		 * This property indicates whether the device is operating in power-saving mode.<br>
		 * Operating in power-saving mode =0x41<br>
		 * Operating in normal operation mode =0x42<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		public Informer reqInformPowerSavingOperationSetting() {
			reqInformProperty(EPC_POWER_SAVING_OPERATION_SETTING);
			return this;
		}
		/**
		 * This property indicates whether remote control is through a public network or not.<br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : optional<br>
		 */
		public Informer reqInformRemoteControlSetting() {
			reqInformProperty(EPC_REMOTE_CONTROL_SETTING);
			return this;
		}
		/**
		 * Current time (HH：MM format)<br>
		 * 0x00-0x17：0x00-0x3B（ ＝ 0-23）：（ ＝ 0-59）<br><br>
		 * Data Type : unsigned char×2<br>
		 * Data Size(Byte) : 2<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		public Informer reqInformCurrentTimeSetting() {
			reqInformProperty(EPC_CURRENT_TIME_SETTING);
			return this;
		}
		/**
		 * Current date (YYYY：MM：DD format)<br>
		 * 1 ～ 0x270F ： 1 ～ 0x0C ： 1 ～ 0x1F (=1 ～ 9999) ： (=1 ～ 12) ： (=1 ～ 31)<br><br>
		 * Data Type : unsigned char×4<br>
		 * Data Size(Byte) : 4<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		public Informer reqInformCurrentDateSetting() {
			reqInformProperty(EPC_CURRENT_DATE_SETTING);
			return this;
		}
		/**
		 * This property indicates the power limit setting in watts.<br>
		 * 0x0000~0xFFFF（0-65535W）<br><br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		public Informer reqInformPowerLimitSetting() {
			reqInformProperty(EPC_POWER_LIMIT_SETTING);
			return this;
		}
		/**
		 * This property indicates the cumulative number of days, hours, minutes or seconds for which the device has operated, using 1 byte for the unit and 4 bytes for the time.<br>
		 * First byte: Indicates the unit.<br>
		 * Second： 0x41; Minute： 0x42; Hour： 0x43; Day:0x44<br>
		 * Second to fifth bytes ：<br>
		 * Indicates the elapsed time in the unit specified by the first byte. 0x00000000-0xFFFFFFFF (0-4294967295)<br><br>
		 * Data Type : unsigned char + unsigned long<br>
		 * Data Size(Byte) : 1+4 Byte<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Informer reqInformCumulativeOperatingTime() {
			reqInformProperty(EPC_CUMULATIVE_OPERATING_TIME);
			return this;
		}
		/**
		 * See Appendix 1.<br><br>
		 * Data Type : unsigned char×(MAX17)<br>
		 * Data Size(Byte) : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Informer reqInformStatusChangeAnnouncementPropertyMap() {
			reqInformProperty(EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP);
			return this;
		}
		/**
		 * See Appendix 1.<br><br>
		 * Data Type : unsigned char×(MAX17)<br>
		 * Data Size(Byte) : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Informer reqInformSetPropertyMap() {
			reqInformProperty(EPC_SET_PROPERTY_MAP);
			return this;
		}
		/**
		 * See Appendix 1.<br><br>
		 * Data Type : unsigned char×(MAX17)<br>
		 * Data Size(Byte) : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Informer reqInformGetPropertyMap() {
			reqInformProperty(EPC_GET_PROPERTY_MAP);
			return this;
		}
	}


	public static class Proxy extends DeviceObject {
		private short mEchoClassCode;
		public Proxy(short echoClassCode, byte instanceCode) {
			super();
			mEchoClassCode = echoClassCode;
			mEchoInstanceCode = instanceCode;
		}

		@Override
		public short getEchoClassCode() {
			return mEchoClassCode;
		}
		@Override
		public byte getInstanceCode() {
			return mEchoInstanceCode;
		}
		@Override
		protected byte[] getOperationStatus() {return null;}
		@Override
		protected boolean setInstallationLocation(byte[] edt) {return false;}
		@Override
		protected byte[] getInstallationLocation() {return null;}
		@Override
		protected byte[] getStandardVersionInformation() {return null;}
		@Override
		protected byte[] getFaultStatus() {return null;}
		@Override
		protected byte[] getManufacturerCode() {return null;}
	}
	
}
