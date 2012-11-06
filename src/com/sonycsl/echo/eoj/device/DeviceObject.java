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
import com.sonycsl.echo.eoj.EchoObject.Getter;
import com.sonycsl.echo.eoj.EchoObject.Setter;
import com.sonycsl.echo.eoj.profile.ProfileObject.Informer;

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
	public static final byte EPC_POSITION_INFORMATION = (byte)0x93;
	public static final byte EPC_CURRENT_TIME_SETTING = (byte)0x97;
	public static final byte EPC_CURRENT_DATE_SETTING = (byte)0x98;
	public static final byte EPC_POWER_LIMIT_SETTING = (byte)0x99;
	public static final byte EPC_CUMULATIVE_OPERATING_TIME = (byte)0x9A;
	public static final byte EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP = (byte)0x9D;
	public static final byte EPC_SET_PROPERTY_MAP = (byte)0x9E;
	public static final byte EPC_GET_PROPERTY_MAP = (byte)0x9F;

	@Override
	public byte getInstanceCode() {
		return getNode().getDeviceNumber(this);
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
	private final boolean _setOperationStatus(byte epc, byte[] edt) {
		boolean success = setOperationStatus(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
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
	private final byte[] _getOperationStatus(byte epc) {
		byte[] edt = getOperationStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	private final boolean _setInstallationLocation(byte epc, byte[] edt) {
		boolean success = setInstallationLocation(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
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
	protected abstract byte[] getInstallationLocation();
	private final byte[] _getInstallationLocation(byte epc) {
		byte[] edt = getInstallationLocation();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	protected abstract byte[] getStandardVersionInformation() ;
	private final byte[] _getStandardVersionInformation(byte epc) {
		byte[] edt = getStandardVersionInformation();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	private final byte[] _getIdentificationNumber(byte epc) {
		byte[] edt = getIdentificationNumber();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	private final byte[] _getMeasuredInstantaneousPowerConsumption(byte epc) {
		byte[] edt = getMeasuredInstantaneousPowerConsumption();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	private final byte[] _getMeasuredCumulativePowerConsumption(byte epc) {
		byte[] edt = getMeasuredCumulativePowerConsumption();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	private final byte[] _getManufacturersFaultCode(byte epc) {
		byte[] edt = getManufacturersFaultCode();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	private final boolean _setCurrentLimitSetting(byte epc, byte[] edt) {
		boolean success = setCurrentLimitSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
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
	private final byte[] _getCurrentLimitSetting(byte epc) {
		byte[] edt = getCurrentLimitSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	private final byte[] _getFaultStatus(byte epc) {
		byte[] edt = getFaultStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	private final byte[] _getFaultDescription(byte epc) {
		byte[] edt = getFaultDescription();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	private final byte[] _getManufacturerCode(byte epc) {
		byte[] edt = getManufacturerCode();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	private final byte[] _getBusinessFacilityCode(byte epc) {
		byte[] edt = getBusinessFacilityCode();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	private final byte[] _getProductCode(byte epc) {
		byte[] edt = getProductCode();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	private final byte[] _getProductionNumber(byte epc) {
		byte[] edt = getProductionNumber();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	private final byte[] _getProductionDate(byte epc) {
		byte[] edt = getProductionDate();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	private final boolean _setPowerSavingOperationSetting(byte epc, byte[] edt) {
		boolean success = setPowerSavingOperationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
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
	private final byte[] _getPowerSavingOperationSetting(byte epc) {
		byte[] edt = getPowerSavingOperationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}

	/**
	 * This property indicates the latitude, longitude and altitude of the installation location.<br>
	 * <br>
	 * Data Type : unsigned char×16<br>
	 * Data Size(Byte) : 16<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : optional<br>
	 * Get : optional<br>
	 * <br>
	 * Announcement at status change<br>
	 */
	protected boolean setPositionInformation(byte[] edt) {
		return false;
	}
	private final boolean _setPositionInformation(byte epc, byte[] edt) {
		boolean success = setPositionInformation(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	
	/**
	 * This property indicates the latitude, longitude and altitude of the installation location.<br>
	 * <br>
	 * Data Type : unsigned char×16<br>
	 * Data Size(Byte) : 16<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : optional<br>
	 * Get : optional<br>
	 * <br>
	 * Announcement at status change<br>
	 */	
	protected byte[] getPositionInformation() {
		return null;
	}
	private final byte[] _getPositionInformation(byte epc) {
		byte[] edt = getPositionInformation();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	private final boolean _setCurrentTimeSetting(byte epc, byte[] edt) {
		boolean success = setCurrentTimeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
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
	private final byte[] _getCurrentTimeSetting(byte epc) {
		byte[] edt = getCurrentTimeSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	private final boolean _setCurrentDateSetting(byte epc, byte[] edt) {
		boolean success = setCurrentDateSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
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
	private final byte[] _getCurrentDateSetting(byte epc) {
		byte[] edt = getCurrentDateSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	private final boolean _setPowerLimitSetting(byte epc, byte[] edt) {
		boolean success = setPowerLimitSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
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
	private final byte[] _getPowerLimitSetting(byte epc) {
		byte[] edt = getPowerLimitSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	private final byte[] _getCumulativeOperatingTime(byte epc) {
		byte[] edt = getCumulativeOperatingTime();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	protected abstract byte[] getStatusChangeAnnouncementPropertyMap() ;
	private final byte[] _getStatusChangeAnnouncementPropertyMap(byte epc) {
		byte[] edt = getStatusChangeAnnouncementPropertyMap();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	protected abstract byte[] getSetPropertyMap();
	private final byte[] _getSetPropertyMap(byte epc) {
		byte[] edt = getSetPropertyMap();
		onInvokedGetMethod(epc, edt);
		return edt;
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
	protected abstract byte[] getGetPropertyMap();
	private final byte[] _getGetPropertyMap(byte epc) {
		byte[] edt = getGetPropertyMap();
		onInvokedGetMethod(epc, edt);
		return edt;
	}

	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_OPERATION_STATUS :
			res.addProperty(epc, edt, _setOperationStatus(epc, edt));
			break;
		case EPC_INSTALLATION_LOCATION :
			res.addProperty(epc, edt, _setInstallationLocation(epc, edt));
			break;
		case EPC_CURRENT_LIMIT_SETTING :
			res.addProperty(epc, edt, _setCurrentLimitSetting(epc, edt));
			break;
		case EPC_POWER_SAVING_OPERATION_SETTING :
			res.addProperty(epc, edt, _setPowerSavingOperationSetting(epc, edt));
			break;
		case EPC_POSITION_INFORMATION :
			res.addProperty(epc, edt, _setPositionInformation(epc, edt));
			break;
		case EPC_CURRENT_TIME_SETTING :
			res.addProperty(epc, edt, _setCurrentTimeSetting(epc, edt));
			break;
		case EPC_CURRENT_DATE_SETTING :
			res.addProperty(epc, edt, _setCurrentDateSetting(epc, edt));
			break;
		case EPC_POWER_LIMIT_SETTING :
			res.addProperty(epc, edt, _setPowerLimitSetting(epc, edt));
			break;
		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_OPERATION_STATUS :
			edt = _getOperationStatus(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_INSTALLATION_LOCATION :
			edt = _getInstallationLocation(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_STANDARD_VERSION_INFORMATION :
			edt = _getStandardVersionInformation(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 4));
			break;
		case EPC_IDENTIFICATION_NUMBER :
			edt = _getIdentificationNumber(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 9 || edt.length == 17)));
			break;
		case EPC_MEASURED_INSTANTANEOUS_POWER_CONSUMPTION :
			edt = _getMeasuredInstantaneousPowerConsumption(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_MEASURED_CUMULATIVE_POWER_CONSUMPTION :
			edt = _getMeasuredCumulativePowerConsumption(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 4));
			break;
		case EPC_MANUFACTURERS_FAULT_CODE :
			edt = _getManufacturersFaultCode(epc);
			res.addProperty(epc, edt, (edt != null && edt.length <= 225));
			break;
		case EPC_CURRENT_LIMIT_SETTING :
			edt = _getCurrentLimitSetting(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_FAULT_STATUS :
			edt = _getFaultStatus(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_FAULT_DESCRIPTION :
			edt = _getFaultDescription(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_MANUFACTURER_CODE :
			edt = _getManufacturerCode(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 3));
			break;
		case EPC_BUSINESS_FACILITY_CODE :
			edt = _getBusinessFacilityCode(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 3));
			break;
		case EPC_PRODUCT_CODE :
			edt = _getProductCode(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 12));
			break;
		case EPC_PRODUCTION_NUMBER :
			edt = _getProductionNumber(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 12));
			break;
		case EPC_PRODUCTION_DATE :
			edt = _getProductionDate(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 4));
			break;
		case EPC_POWER_SAVING_OPERATION_SETTING :
			edt = _getPowerSavingOperationSetting(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_POSITION_INFORMATION :
			edt = _getPositionInformation(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 16));
			break;
		case EPC_CURRENT_TIME_SETTING :
			edt = _getCurrentTimeSetting(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_CURRENT_DATE_SETTING :
			edt = _getCurrentDateSetting(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 4));
			break;
		case EPC_POWER_LIMIT_SETTING :
			edt = _getPowerLimitSetting(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_CUMULATIVE_OPERATING_TIME :
			edt = _getCumulativeOperatingTime(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 5));
			break;
		case EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP :
			edt = _getStatusChangeAnnouncementPropertyMap(epc);
			res.addProperty(epc, edt, (edt != null && edt.length <= 17));
			break;
		case EPC_SET_PROPERTY_MAP :
			edt = _getSetPropertyMap(epc);
			res.addProperty(epc, edt, (edt != null && edt.length <= 17));
			break;
		case EPC_GET_PROPERTY_MAP :
			edt = _getGetPropertyMap(epc);
			res.addProperty(epc, edt, (edt != null && edt.length <= 17));
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
	
	public static class Receiver extends EchoObject.Receiver {

		@Override
		protected void onReceiveSetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveSetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_OPERATION_STATUS :
				_onSetOperationStatus(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_INSTALLATION_LOCATION :
				_onSetInstallationLocation(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_CURRENT_LIMIT_SETTING :
				_onSetCurrentLimitSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_POWER_SAVING_OPERATION_SETTING :
				_onSetPowerSavingOperationSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_POSITION_INFORMATION :
				_onSetPositionInformation(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_CURRENT_TIME_SETTING :
				_onSetCurrentTimeSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_CURRENT_DATE_SETTING :
				_onSetCurrentDateSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_POWER_LIMIT_SETTING :
				_onSetPowerLimitSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_OPERATION_STATUS :
				_onGetOperationStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_INSTALLATION_LOCATION :
				_onGetInstallationLocation(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_STANDARD_VERSION_INFORMATION :
				_onGetStandardVersionInformation(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_IDENTIFICATION_NUMBER :
				_onGetIdentificationNumber(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_POWER_CONSUMPTION :
				_onGetMeasuredInstantaneousPowerConsumption(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_POWER_CONSUMPTION :
				_onGetMeasuredCumulativehPowerConsumption(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MANUFACTURERS_FAULT_CODE :
				_onGetManufacturersFaultCode(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_CURRENT_LIMIT_SETTING :
				_onGetCurrentLimitSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_FAULT_STATUS :
				_onGetFaultStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_FAULT_DESCRIPTION :
				_onGetFaultDescription(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MANUFACTURER_CODE :
				_onGetManufacturerCode(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BUSINESS_FACILITY_CODE :
				_onGetBusinessFacilityCode(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_PRODUCT_CODE :
				_onGetProductCode(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_PRODUCTION_NUMBER :
				_onGetProductionNumber(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_PRODUCTION_DATE :
				_onGetProductionDate(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_POWER_SAVING_OPERATION_SETTING :
				_onGetPowerSavingOperationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_POSITION_INFORMATION :
				_onGetPositionInformation(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_CURRENT_TIME_SETTING :
				_onGetCurrentTimeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_CURRENT_DATE_SETTING :
				_onGetCurrentDateSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_POWER_LIMIT_SETTING :
				_onGetPowerLimitSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_CUMULATIVE_OPERATING_TIME :
				_onGetCumulativeOperatingTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP :
				_onGetStatusChageAnnouncementPropertyMap(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_PROPERTY_MAP :
				_onGetSetPropertyMap(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GET_PROPERTY_MAP :
				_onGetGetPropertyMap(eoj, tid, esv, epc, pdc, edt);
				break;
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
		protected void onSetOperationStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOperationStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOperationStatus(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
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
		protected void onGetOperationStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOperationStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOperationStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
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
		protected void onSetInstallationLocation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetInstallationLocation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetInstallationLocation(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
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
		protected void onGetInstallationLocation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetInstallationLocation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetInstallationLocation(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
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
		protected void onGetStandardVersionInformation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetStandardVersionInformation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetStandardVersionInformation(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
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
		protected void onGetIdentificationNumber(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetIdentificationNumber(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetIdentificationNumber(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		
		/**
		 * This property indicates the instantaneous power consumption of the device in watts.<br>
		 * 0x0000-0xFFFF（0-65535W）<br><br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		protected void onGetMeasuredInstantaneousPowerConsumption(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredInstantaneousPowerConsumption(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredInstantaneousPowerConsumption(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		
		/**
		 * This property indicates the cumulative power consumption of the device in increments of 0.001kWh.<br>
		 * 0x0-0x3B9AC9FF（0-999,999.999kWh）<br><br>
		 * Data Type : unsigned long<br>
		 * Data Size(Byte) : 4<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		protected void onGetMeasuredCumulativehPowerConsumption(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredCumulativehPowerConsumption(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredCumulativehPowerConsumption(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
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
		protected void onGetManufacturersFaultCode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetManufacturersFaultCode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetManufacturersFaultCode(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		
		/**
		 * This property indicates the current limit setting (0-100%).<br>
		 * 0x00-0x64 （=0-100%）<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		protected void onSetCurrentLimitSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetCurrentLimitSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetCurrentLimitSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}

		/**
		 * This property indicates the current limit setting (0-100%).<br>
		 * 0x00-0x64 （=0-100%）<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		protected void onGetCurrentLimitSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetCurrentLimitSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetCurrentLimitSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
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
		protected void onGetFaultStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetFaultStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetFaultStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		
		/**
		 * Describes the fault.<br>
		 * See “2.5 ‘Fault Description’ Property.”<br><br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		protected void onGetFaultDescription(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetFaultDescription(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetFaultDescription(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		
		/**
		 * 3-byte manufacturer code<br>
		 * (Defined by the ECHONET Consortium.)<br><br>
		 * Data Type : unsigned char×3<br>
		 * Data Size(Byte) : 3<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */ 
		protected void onGetManufacturerCode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetManufacturerCode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetManufacturerCode(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		
		/**
		 * 3-byte business facility code<br>
		 * （Defined by each manufacturer.）<br><br>
		 * Data Type : unsigned char×3<br>
		 * Data Size(Byte) : 3<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		protected void onGetBusinessFacilityCode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBusinessFacilityCode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBusinessFacilityCode(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		
		/**
		 * Identifies the product usingASCI I code.<br>
		 * （Defined by each manufacturer.）<br><br>
		 * Data Type : unsigned char×12<br>
		 * Data Size(Byte) : 12<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		protected void onGetProductCode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetProductCode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetProductCode(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		
		/**
		 * This property indicates the production number using ASCI I code.<br>
		 * （Defined by each manufacturer.）<br><br>
		 * Data Type : unsigned char×12<br>
		 * Data Size(Byte) : 12<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		protected void onGetProductionNumber(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetProductionNumber(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetProductionNumber(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
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
		protected void onGetProductionDate(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetProductionDate(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetProductionDate(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
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
		protected void onSetPowerSavingOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetPowerSavingOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetPowerSavingOperationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
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
		protected void onGetPowerSavingOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetPowerSavingOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetPowerSavingOperationSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		
		/**
		 * This property indicates the latitude, longitude and altitude of the installation location.<br><br>
		 * Data Type : unsigned char×16<br>
		 * Data Size(Byte) : 16<br>
		 * Set : optional<br>
		 * Get : optional<br>
		 * Announcement at status change
		 */
		protected void onSetPositionInformation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetPositionInformation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetPositionInformation(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}

		/**
		 * This property indicates the latitude, longitude and altitude of the installation location.<br><br>
		 * Data Type : unsigned char×16<br>
		 * Data Size(Byte) : 16<br>
		 * Set : optional<br>
		 * Get : optional<br>
		 * Announcement at status change
		 */
		protected void onGetPositionInformation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetPositionInformation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetPositionInformation(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		
		/**
		 * Current time (HH：MM format)<br>
		 * 0x00-0x17：0x00-0x3B（ ＝ 0-23）：（ ＝ 0-59）<br><br>
		 * Data Type : unsigned char×2<br>
		 * Data Size(Byte) : 2<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		protected void onSetCurrentTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetCurrentTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetCurrentTimeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		
		/**
		 * Current time (HH：MM format)<br>
		 * 0x00-0x17：0x00-0x3B（ ＝ 0-23）：（ ＝ 0-59）<br><br>
		 * Data Type : unsigned char×2<br>
		 * Data Size(Byte) : 2<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		protected void onGetCurrentTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetCurrentTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetCurrentTimeSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		
		/**
		 * Current date (YYYY：MM：DD format)<br>
		 * 1 ～ 0x270F ： 1 ～ 0x0C ： 1 ～ 0x1F (=1 ～ 9999) ： (=1 ～ 12) ： (=1 ～ 31)<br><br>
		 * Data Type : unsigned char×4<br>
		 * Data Size(Byte) : 4<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		protected void onSetCurrentDateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetCurrentDateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetCurrentDateSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}

		/**
		 * Current date (YYYY：MM：DD format)<br>
		 * 1 ～ 0x270F ： 1 ～ 0x0C ： 1 ～ 0x1F (=1 ～ 9999) ： (=1 ～ 12) ： (=1 ～ 31)<br><br>
		 * Data Type : unsigned char×4<br>
		 * Data Size(Byte) : 4<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		protected void onGetCurrentDateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetCurrentDateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetCurrentDateSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		
		/**
		 * This property indicates the power limit setting in watts.<br>
		 * 0x0000~0xFFFF（0-65535W）<br><br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		protected void onSetPowerLimitSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetPowerLimitSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetPowerLimitSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}

		/**
		 * This property indicates the power limit setting in watts.<br>
		 * 0x0000~0xFFFF（0-65535W）<br><br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		protected void onGetPowerLimitSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetPowerLimitSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetPowerLimitSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
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
		protected void onGetCumulativeOperatingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetCumulativeOperatingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetCumulativeOperatingTime(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		
		/**
		 * See Appendix 1.<br><br>
		 * Data Type : unsigned char×(MAX17)<br>
		 * Data Size(Byte) : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		protected void onGetStatusChageAnnouncementPropertyMap(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetStatusChageAnnouncementPropertyMap(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetStatusChageAnnouncementPropertyMap(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		
		/**
		 * See Appendix 1.<br><br>
		 * Data Type : unsigned char×(MAX17)<br>
		 * Data Size(Byte) : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		protected void onGetSetPropertyMap(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetPropertyMap(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetPropertyMap(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		
		/**
		 * See Appendix 1.<br><br>
		 * Data Type : unsigned char×(MAX17)<br>
		 * Data Size(Byte) : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		protected void onGetGetPropertyMap(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGetPropertyMap(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGetPropertyMap(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
	}

	public class Setter extends EchoObject.Setter {
		public Setter(byte esv) {
			super(esv);
		}
		
		@Override
		public Setter reqSet(byte epc, byte[] edt) {
			return (Setter)super.reqSet(epc, edt);
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
			addProperty(EPC_OPERATION_STATUS, edt, (edt.length == 1));
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
			addProperty(EPC_INSTALLATION_LOCATION, edt, (edt.length == 1));
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
			addProperty(EPC_CURRENT_LIMIT_SETTING, edt, (edt.length == 1));
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
			addProperty(EPC_POWER_SAVING_OPERATION_SETTING, edt, (edt.length == 1));
			return this;
		}
		/**
		 * This property indicates the latitude, longitude and altitude of the installation location.<br><br>
		 * Data Type : unsigned char×16<br>
		 * Data Size(Byte) : 16<br>
		 * Set : optional<br>
		 * Get : optional<br>
		 * Announcement at status change
		 */
		public Setter reqSetPositionInformation(byte[] edt) {
			addProperty(EPC_POSITION_INFORMATION, edt, (edt.length == 16));
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
			addProperty(EPC_CURRENT_TIME_SETTING, edt, (edt.length == 2));
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
			addProperty(EPC_CURRENT_DATE_SETTING, edt, (edt.length == 4));
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
			addProperty(EPC_POWER_LIMIT_SETTING, edt, (edt.length == 2));
			return this;
		}
	}
	
	public class Getter extends EchoObject.Getter {
		
		@Override
		public Getter reqGet(byte epc) {
			return (Getter)super.reqGet(epc);
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
			addProperty(EPC_OPERATION_STATUS);
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
			addProperty(EPC_INSTALLATION_LOCATION);
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
			addProperty(EPC_STANDARD_VERSION_INFORMATION);
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
			addProperty(EPC_IDENTIFICATION_NUMBER);
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
			addProperty(EPC_MEASURED_INSTANTANEOUS_POWER_CONSUMPTION);
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
			addProperty(EPC_MEASURED_CUMULATIVE_POWER_CONSUMPTION);
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
			addProperty(EPC_MANUFACTURERS_FAULT_CODE);
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
			addProperty(EPC_CURRENT_LIMIT_SETTING);
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
			addProperty(EPC_FAULT_STATUS);
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
			addProperty(EPC_FAULT_DESCRIPTION);
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
			addProperty(EPC_MANUFACTURER_CODE);
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
			addProperty(EPC_BUSINESS_FACILITY_CODE);
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
			addProperty(EPC_PRODUCT_CODE);
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
			addProperty(EPC_PRODUCTION_NUMBER);
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
			addProperty(EPC_PRODUCTION_DATE);
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
			addProperty(EPC_POWER_SAVING_OPERATION_SETTING);
			return this;
		}
		/**
		 * This property indicates the latitude, longitude and altitude of the installation location.<br><br>
		 * Data Type : unsigned char×16<br>
		 * Data Size(Byte) : 16<br>
		 * Set : optional<br>
		 * Get : optional<br>
		 * Announcement at status change
		 */
		public Getter reqGetPositionInformation() {
			addProperty(EPC_POSITION_INFORMATION);
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
			addProperty(EPC_CURRENT_TIME_SETTING);
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
			addProperty(EPC_CURRENT_DATE_SETTING);
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
			addProperty(EPC_POWER_LIMIT_SETTING);
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
			addProperty(EPC_CUMULATIVE_OPERATING_TIME);
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
			addProperty(EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP);
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
			addProperty(EPC_SET_PROPERTY_MAP);
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
			addProperty(EPC_GET_PROPERTY_MAP);
			return this;
		}
	}
	
	public interface Informer extends EchoObject.Informer {
		public Informer reqInform(byte epc);
		
		/**
		 * This property indicates the ON/OFF status.<br>
		 * ON＝0x30，OFF＝0x31<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : mandatory<br>
		 * Announcement at status change
		 */
		public Informer reqInformOperationStatus();
		/**
		 * This property indicates the installation location<br>
		 * See “2.2 ‘Installation location’ property.”<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : mandatory<br>
		 * Get : mandatory<br>
		 * Announcement at status change
		 */
		public Informer reqInformInstallationLocation();
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
		public Informer reqInformStandardVersionInformation();
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
		public Informer reqInformIdentificationNumber();
		/**
		 * This property indicates the instantaneous power consumption of the device in watts.<br>
		 * 0x0000-0xFFFF（0-65535W）<br><br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Informer reqInformMeasuredInstantaneousPowerConsumption();
		/**
		 * This property indicates the cumulative power consumption of the device in increments of 0.001kWh.<br>
		 * 0x0-0x3B9AC9FF（0-999,999.999kWh）<br><br>
		 * Data Type : unsigned long<br>
		 * Data Size(Byte) : 4<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Informer reqInformMeasuredCumulativePowerConsumption();
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
		public Informer reqInformManufacturersFaultCode();
		/**
		 * This property indicates the current limit setting (0-100%).<br>
		 * 0x00-0x64 （=0-100%）<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		public Informer reqInformCurrentLimitSetting();
		/**
		 * This property indicates whether a fault (e.g. a sensor trouble) has occurred or not.<br>
		 * Fault occurred＝0x41, No fault has occurred＝0x42<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 * Announcement at status change
		 */
		public Informer reqInformFaultStatus();
		/**
		 * Describes the fault.<br>
		 * See “2.5 ‘Fault Description’ Property.”<br><br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Informer reqInformFaultDescription();
		/**
		 * 3-byte manufacturer code<br>
		 * (Defined by the ECHONET Consortium.)<br><br>
		 * Data Type : unsigned char×3<br>
		 * Data Size(Byte) : 3<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Informer reqInformManufacturerCode();
		/**
		 * 3-byte business facility code<br>
		 * （Defined by each manufacturer.）<br><br>
		 * Data Type : unsigned char×3<br>
		 * Data Size(Byte) : 3<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Informer reqInformBusinessFacilityCode();
		/**
		 * Identifies the product usingASCI I code.<br>
		 * （Defined by each manufacturer.）<br><br>
		 * Data Type : unsigned char×12<br>
		 * Data Size(Byte) : 12<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Informer reqInformProductCode();
		/**
		 * This property indicates the production number using ASCI I code.<br>
		 * （Defined by each manufacturer.）<br><br>
		 * Data Type : unsigned char×12<br>
		 * Data Size(Byte) : 12<br>
		 * Set : undefined<br>
		 * Get : optional
		 */
		public Informer reqInformProductionNumber();
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
		public Informer reqInformProductionDate();
		/**
		 * This property indicates whether the device is operating in power-saving mode.<br>
		 * Operating in power-saving mode =0x41<br>
		 * Operating in normal operation mode =0x42<br><br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		public Informer reqInformPowerSavingOperationSetting();
		/**
		 * This property indicates the latitude, longitude and altitude of the installation location.<br><br>
		 * Data Type : unsigned char×16<br>
		 * Data Size(Byte) : 16<br>
		 * Set : optional<br>
		 * Get : optional<br>
		 * Announcement at status change
		 */
		public Informer reqInformPositionInformation();
		/**
		 * Current time (HH：MM format)<br>
		 * 0x00-0x17：0x00-0x3B（ ＝ 0-23）：（ ＝ 0-59）<br><br>
		 * Data Type : unsigned char×2<br>
		 * Data Size(Byte) : 2<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		public Informer reqInformCurrentTimeSetting();
		/**
		 * Current date (YYYY：MM：DD format)<br>
		 * 1 ～ 0x270F ： 1 ～ 0x0C ： 1 ～ 0x1F (=1 ～ 9999) ： (=1 ～ 12) ： (=1 ～ 31)<br><br>
		 * Data Type : unsigned char×4<br>
		 * Data Size(Byte) : 4<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		public Informer reqInformCurrentDateSetting();
		/**
		 * This property indicates the power limit setting in watts.<br>
		 * 0x0000~0xFFFF（0-65535W）<br><br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * Set : optional<br>
		 * Get : optional
		 */
		public Informer reqInformPowerLimitSetting();
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
		public Informer reqInformCumulativeOperatingTime();
		/**
		 * See Appendix 1.<br><br>
		 * Data Type : unsigned char×(MAX17)<br>
		 * Data Size(Byte) : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Informer reqInformStatusChangeAnnouncementPropertyMap();
		/**
		 * See Appendix 1.<br><br>
		 * Data Type : unsigned char×(MAX17)<br>
		 * Data Size(Byte) : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Informer reqInformSetPropertyMap();
		/**
		 * See Appendix 1.<br><br>
		 * Data Type : unsigned char×(MAX17)<br>
		 * Data Size(Byte) : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Informer reqInformGetPropertyMap();
	}
	
	public class InformerImpl extends EchoObject.InformerImpl implements Informer {

		@Override
		public Informer reqInform(byte epc) {
			return (Informer)super.reqInform(epc);
		}

		@Override
		public Informer reqInformOperationStatus() {
			byte epc = EPC_OPERATION_STATUS;
			byte[] edt = _getOperationStatus(epc);
			addProperty(epc, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformInstallationLocation() {
			byte epc = EPC_INSTALLATION_LOCATION;
			byte[] edt = _getInstallationLocation(epc);
			addProperty(epc, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformStandardVersionInformation() {
			byte epc = EPC_STANDARD_VERSION_INFORMATION;
			byte[] edt = _getStandardVersionInformation(epc);
			addProperty(epc, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Informer reqInformIdentificationNumber() {
			byte epc = EPC_IDENTIFICATION_NUMBER;
			byte[] edt = _getIdentificationNumber(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 9 || edt.length == 17)));
			return this;
		}

		@Override
		public Informer reqInformMeasuredInstantaneousPowerConsumption() {
			byte epc = EPC_MEASURED_INSTANTANEOUS_POWER_CONSUMPTION;
			byte[] edt = _getMeasuredInstantaneousPowerConsumption(epc);
			addProperty(epc, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformMeasuredCumulativePowerConsumption() {
			byte epc = EPC_MEASURED_CUMULATIVE_POWER_CONSUMPTION;
			byte[] edt = _getMeasuredCumulativePowerConsumption(epc);
			addProperty(epc, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Informer reqInformManufacturersFaultCode() {
			byte epc = EPC_MANUFACTURERS_FAULT_CODE;
			byte[] edt = _getManufacturersFaultCode(epc);
			addProperty(epc, edt, (edt != null && edt.length <= 225));
			return this;
		}

		@Override
		public Informer reqInformCurrentLimitSetting() {
			byte epc = EPC_CURRENT_LIMIT_SETTING;
			byte[] edt = _getCurrentLimitSetting(epc);
			addProperty(epc, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformFaultStatus() {
			byte epc = EPC_FAULT_STATUS;
			byte[] edt = _getFaultStatus(epc);
			addProperty(epc, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformFaultDescription() {
			byte epc = EPC_FAULT_DESCRIPTION;
			byte[] edt = _getFaultDescription(epc);
			addProperty(epc, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformManufacturerCode() {
			byte epc = EPC_MANUFACTURER_CODE;
			byte[] edt = _getManufacturerCode(epc);
			addProperty(epc, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Informer reqInformBusinessFacilityCode() {
			byte epc = EPC_BUSINESS_FACILITY_CODE;
			byte[] edt = _getBusinessFacilityCode(epc);
			addProperty(epc, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Informer reqInformProductCode() {
			byte epc = EPC_PRODUCT_CODE;
			byte[] edt = _getProductCode(epc);
			addProperty(epc, edt, (edt != null && edt.length == 12));
			return this;
		}

		@Override
		public Informer reqInformProductionNumber() {
			byte epc = EPC_PRODUCTION_NUMBER;
			byte[] edt = _getProductionNumber(epc);
			addProperty(epc, edt, (edt != null && edt.length == 12));
			return this;
		}

		@Override
		public Informer reqInformProductionDate() {
			byte epc = EPC_PRODUCTION_DATE;
			byte[] edt = _getProductionDate(epc);
			addProperty(epc, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Informer reqInformPowerSavingOperationSetting() {
			byte epc = EPC_POWER_SAVING_OPERATION_SETTING;
			byte[] edt = _getPowerSavingOperationSetting(epc);
			addProperty(epc, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformPositionInformation() {
			byte epc = EPC_POSITION_INFORMATION;
			byte[] edt = _getPositionInformation(epc);
			addProperty(epc, edt, (edt != null && edt.length == 16));
			return this;
		}

		@Override
		public Informer reqInformCurrentTimeSetting() {
			byte epc = EPC_CURRENT_TIME_SETTING;
			byte[] edt = _getCurrentTimeSetting(epc);
			addProperty(epc, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformCurrentDateSetting() {
			byte epc = EPC_CURRENT_DATE_SETTING;
			byte[] edt = _getCurrentDateSetting(epc);
			addProperty(epc, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Informer reqInformPowerLimitSetting() {
			byte epc = EPC_POWER_LIMIT_SETTING;
			byte[] edt = _getPowerLimitSetting(epc);
			addProperty(epc, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformCumulativeOperatingTime() {
			byte epc = EPC_CUMULATIVE_OPERATING_TIME;
			byte[] edt = _getCumulativeOperatingTime(epc);
			addProperty(epc, edt, (edt != null && edt.length == 5));
			return this;
		}

		@Override
		public Informer reqInformStatusChangeAnnouncementPropertyMap() {
			byte epc = EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP;
			byte[] edt = _getStatusChangeAnnouncementPropertyMap(epc);
			addProperty(epc, edt, (edt != null && edt.length <= 17));
			return this;
		}

		@Override
		public Informer reqInformSetPropertyMap() {
			byte epc = EPC_SET_PROPERTY_MAP;
			byte[] edt = _getSetPropertyMap(epc);
			addProperty(epc, edt, (edt != null && edt.length <= 17));
			return this;
		}

		@Override
		public Informer reqInformGetPropertyMap() {
			byte epc = EPC_GET_PROPERTY_MAP;
			byte[] edt = _getGetPropertyMap(epc);
			addProperty(epc, edt, (edt != null && edt.length <= 17));
			return this;
		}
	}

	public class InformerProxy extends EchoObject.InformerProxy implements Informer {

		@Override
		public Informer reqInform(byte epc) {
			return (Informer)super.reqInform(epc);
		}
		
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
