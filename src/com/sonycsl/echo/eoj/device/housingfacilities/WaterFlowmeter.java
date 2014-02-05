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

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class WaterFlowmeter extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0281;

	public static final byte EPC_FLOWING_WATER_CLASSIFICATION = (byte)0xD0;
	public static final byte EPC_OWNER_CLASSIFICATION = (byte)0xD1;
	public static final byte EPC_MEASURED_CUMULATIVE_AMOUNT_OF_FLOWING_WATER = (byte)0xE0;
	public static final byte EPC_UNIT_FOR_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER = (byte)0xE1;
	public static final byte EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER = (byte)0xE2;
	public static final byte EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA = (byte)0xE3;
	public static final byte EPC_SECURITY_DATA_INFORMATION = (byte)0xE4;
	public static final byte EPC_ID_NUMBER_SETTING = (byte)0xE5;
	public static final byte EPC_VERIFICATION_EXPIRATION_INFORMATION = (byte)0xE6;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_FLOWING_WATER);
		addGetProperty(EPC_UNIT_FOR_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER);
		addStatusChangeAnnouncementProperty(EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA);
	}
	
	@Override
	public short getEchoClassCode() {
		return ECHO_CLASS_CODE;
	}

	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ON/OFF status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setOperationStatus(byte[] edt) {return false;}
	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ON/OFF status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getOperationStatus();
	/**
	 * Property name : Flowing water classification<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the water flowmeter type.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30 : running water 0x31 : recycled water 0x32 : warm water 0x33 : other water<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setFlowingWaterClassification(byte[] edt) {return false;}
	/**
	 * Property name : Flowing water classification<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the water flowmeter type.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30 : running water 0x31 : recycled water 0x32 : warm water 0x33 : other water<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getFlowingWaterClassification() {return null;}
	/**
	 * Property name : Flowing water classification<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the water flowmeter type.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30 : running water 0x31 : recycled water 0x32 : warm water 0x33 : other water<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidFlowingWaterClassification(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Owner classification<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the owner of the meter in the form of owner classification.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30 : Not specified  0x31 : Public waterworks<br>
	 * company<br>
	 * 0x32 : Private sector company 0x33 : Individual<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOwnerClassification(byte[] edt) {return false;}
	/**
	 * Property name : Owner classification<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the owner of the meter in the form of owner classification.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30 : Not specified  0x31 : Public waterworks<br>
	 * company<br>
	 * 0x32 : Private sector company 0x33 : Individual<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOwnerClassification() {return null;}
	/**
	 * Property name : Owner classification<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the owner of the meter in the form of owner classification.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30 : Not specified  0x31 : Public waterworks<br>
	 * company<br>
	 * 0x32 : Private sector company 0x33 : Individual<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOwnerClassification(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured cumulative amount of flowing water<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the cumulative amount (consumption) of flowing water using a 9-digit number.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x3B9AC9FF (0.999,999,999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
bytes<br>
	 * <br>
	 * Unit : m3<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getMeasuredCumulativeAmountOfFlowingWater();
	/**
	 * Property name : Measured cumulative amount of flowing water<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the cumulative amount (consumption) of flowing water using a 9-digit number.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x3B9AC9FF (0.999,999,999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
bytes<br>
	 * <br>
	 * Unit : m3<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidMeasuredCumulativeAmountOfFlowingWater(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Unit for measured cumulative amounts of flowing water<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the unit (multiplying factor) for the measured cumulative amount of flowing water and the historical data of measured cumulative amounts of flowing water.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00: 1m3<br>
	 * 0x01: 0.1m3<br>
	 * 0x02: 0.01m3<br>
	 * 0x03: 0.001m3<br>
	 * 0x04: 0.0001m3 (Initial value) 0x05: 0.00001m3<br>
	 * 0x06: 0.000001m3<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getUnitForMeasuredCumulativeAmountsOfFlowingWater();
	/**
	 * Property name : Unit for measured cumulative amounts of flowing water<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the unit (multiplying factor) for the measured cumulative amount of flowing water and the historical data of measured cumulative amounts of flowing water.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00: 1m3<br>
	 * 0x01: 0.1m3<br>
	 * 0x02: 0.01m3<br>
	 * 0x03: 0.001m3<br>
	 * 0x04: 0.0001m3 (Initial value) 0x05: 0.00001m3<br>
	 * 0x06: 0.000001m3<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidUnitForMeasuredCumulativeAmountsOfFlowingWater(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Historical data of measured cumulative amounts of flowing water<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the historical data of measured cumulative amounts (consumptions) of running water, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0.0x3B9AC9FF (0.999,999.999m3)<br>
	 * <br>
	 * Data type : unsigned long
×48<br>
	 * <br>
	 * Data size : 192
bytes<br>
	 * <br>
	 * Unit : 0.001
m3<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater() {return null;}
	/**
	 * Property name : Historical data of measured cumulative amounts of flowing water<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the historical data of measured cumulative amounts (consumptions) of running water, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0.0x3B9AC9FF (0.999,999.999m3)<br>
	 * <br>
	 * Data type : unsigned long
×48<br>
	 * <br>
	 * Data size : 192
bytes<br>
	 * <br>
	 * Unit : 0.001
m3<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater(byte[] edt) {
		if(edt == null || !(edt.length == 192)) return false;
		return true;
	}
	/**
	 * Property name : Detection of abnormal value in metering data<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Abnormal value detected: 0x41 No abnormal value detected: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getDetectionOfAbnormalValueInMeteringData() {return null;}
	/**
	 * Property name : Detection of abnormal value in metering data<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Abnormal value detected: 0x41 No abnormal value detected: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidDetectionOfAbnormalValueInMeteringData(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Security data information<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Provides security information  about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFFFFFFFF<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getSecurityDataInformation() {return null;}
	/**
	 * Property name : Security data information<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Provides security information  about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFFFFFFFF<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSecurityDataInformation(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : ID number setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ID number of the meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The ID number is specified using ASCII code.<br>
	 * (Initial value : “000000”)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 6
bytes<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setIdNumberSetting(byte[] edt) {return false;}
	/**
	 * Property name : ID number setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ID number of the meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The ID number is specified using ASCII code.<br>
	 * (Initial value : “000000”)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 6
bytes<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getIdNumberSetting() {return null;}
	/**
	 * Property name : ID number setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ID number of the meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The ID number is specified using ASCII code.<br>
	 * (Initial value : “000000”)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 6
bytes<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidIdNumberSetting(byte[] edt) {
		if(edt == null || !(edt.length == 6)) return false;
		return true;
	}
	/**
	 * Property name : Verification expiration information<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the month and year in which the verification of the meter will expire.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The month and year are specified using ASCII code.<br>
	 * xxxx xx Year Month<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 6
bytes<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setVerificationExpirationInformation(byte[] edt) {return false;}
	/**
	 * Property name : Verification expiration information<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the month and year in which the verification of the meter will expire.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The month and year are specified using ASCII code.<br>
	 * xxxx xx Year Month<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 6
bytes<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getVerificationExpirationInformation() {return null;}
	/**
	 * Property name : Verification expiration information<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the month and year in which the verification of the meter will expire.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The month and year are specified using ASCII code.<br>
	 * xxxx xx Year Month<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 6
bytes<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidVerificationExpirationInformation(byte[] edt) {
		if(edt == null || !(edt.length == 6)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_FLOWING_WATER_CLASSIFICATION : return setFlowingWaterClassification(property.edt);
		case EPC_OWNER_CLASSIFICATION : return setOwnerClassification(property.edt);
		case EPC_ID_NUMBER_SETTING : return setIdNumberSetting(property.edt);
		case EPC_VERIFICATION_EXPIRATION_INFORMATION : return setVerificationExpirationInformation(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_FLOWING_WATER_CLASSIFICATION : return getFlowingWaterClassification();
		case EPC_OWNER_CLASSIFICATION : return getOwnerClassification();
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_FLOWING_WATER : return getMeasuredCumulativeAmountOfFlowingWater();
		case EPC_UNIT_FOR_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER : return getUnitForMeasuredCumulativeAmountsOfFlowingWater();
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER : return getHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater();
		case EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA : return getDetectionOfAbnormalValueInMeteringData();
		case EPC_SECURITY_DATA_INFORMATION : return getSecurityDataInformation();
		case EPC_ID_NUMBER_SETTING : return getIdNumberSetting();
		case EPC_VERIFICATION_EXPIRATION_INFORMATION : return getVerificationExpirationInformation();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_FLOWING_WATER_CLASSIFICATION : return isValidFlowingWaterClassification(property.edt);
		case EPC_OWNER_CLASSIFICATION : return isValidOwnerClassification(property.edt);
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_FLOWING_WATER : return isValidMeasuredCumulativeAmountOfFlowingWater(property.edt);
		case EPC_UNIT_FOR_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER : return isValidUnitForMeasuredCumulativeAmountsOfFlowingWater(property.edt);
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER : return isValidHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater(property.edt);
		case EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA : return isValidDetectionOfAbnormalValueInMeteringData(property.edt);
		case EPC_SECURITY_DATA_INFORMATION : return isValidSecurityDataInformation(property.edt);
		case EPC_ID_NUMBER_SETTING : return isValidIdNumberSetting(property.edt);
		case EPC_VERIFICATION_EXPIRATION_INFORMATION : return isValidVerificationExpirationInformation(property.edt);
		default : return false;
		}
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
	
	public static class Receiver extends DeviceObject.Receiver {

		@Override
		protected boolean onSetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onSetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_FLOWING_WATER_CLASSIFICATION : 
				onSetFlowingWaterClassification(eoj, tid, esv, property, success);
				return true;
			case EPC_OWNER_CLASSIFICATION : 
				onSetOwnerClassification(eoj, tid, esv, property, success);
				return true;
			case EPC_ID_NUMBER_SETTING : 
				onSetIdNumberSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VERIFICATION_EXPIRATION_INFORMATION : 
				onSetVerificationExpirationInformation(eoj, tid, esv, property, success);
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
			case EPC_FLOWING_WATER_CLASSIFICATION : 
				onGetFlowingWaterClassification(eoj, tid, esv, property, success);
				return true;
			case EPC_OWNER_CLASSIFICATION : 
				onGetOwnerClassification(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_FLOWING_WATER : 
				onGetMeasuredCumulativeAmountOfFlowingWater(eoj, tid, esv, property, success);
				return true;
			case EPC_UNIT_FOR_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER : 
				onGetUnitForMeasuredCumulativeAmountsOfFlowingWater(eoj, tid, esv, property, success);
				return true;
			case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER : 
				onGetHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater(eoj, tid, esv, property, success);
				return true;
			case EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA : 
				onGetDetectionOfAbnormalValueInMeteringData(eoj, tid, esv, property, success);
				return true;
			case EPC_SECURITY_DATA_INFORMATION : 
				onGetSecurityDataInformation(eoj, tid, esv, property, success);
				return true;
			case EPC_ID_NUMBER_SETTING : 
				onGetIdNumberSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VERIFICATION_EXPIRATION_INFORMATION : 
				onGetVerificationExpirationInformation(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Flowing water classification<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the water flowmeter type.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30 : running water 0x31 : recycled water 0x32 : warm water 0x33 : other water<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetFlowingWaterClassification(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Flowing water classification<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the water flowmeter type.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30 : running water 0x31 : recycled water 0x32 : warm water 0x33 : other water<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetFlowingWaterClassification(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Owner classification<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the owner of the meter in the form of owner classification.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30 : Not specified  0x31 : Public waterworks<br>
		 * company<br>
		 * 0x32 : Private sector company 0x33 : Individual<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOwnerClassification(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Owner classification<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the owner of the meter in the form of owner classification.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30 : Not specified  0x31 : Public waterworks<br>
		 * company<br>
		 * 0x32 : Private sector company 0x33 : Individual<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOwnerClassification(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured cumulative amount of flowing water<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the cumulative amount (consumption) of flowing water using a 9-digit number.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x3B9AC9FF (0.999,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : m3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetMeasuredCumulativeAmountOfFlowingWater(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Unit for measured cumulative amounts of flowing water<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the unit (multiplying factor) for the measured cumulative amount of flowing water and the historical data of measured cumulative amounts of flowing water.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00: 1m3<br>
		 * 0x01: 0.1m3<br>
		 * 0x02: 0.01m3<br>
		 * 0x03: 0.001m3<br>
		 * 0x04: 0.0001m3 (Initial value) 0x05: 0.00001m3<br>
		 * 0x06: 0.000001m3<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetUnitForMeasuredCumulativeAmountsOfFlowingWater(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Historical data of measured cumulative amounts of flowing water<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the historical data of measured cumulative amounts (consumptions) of running water, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0.0x3B9AC9FF (0.999,999.999m3)<br>
		 * <br>
		 * Data type : unsigned long
×48<br>
		 * <br>
		 * Data size : 192
bytes<br>
		 * <br>
		 * Unit : 0.001
m3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Detection of abnormal value in metering data<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Abnormal value detected: 0x41 No abnormal value detected: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetDetectionOfAbnormalValueInMeteringData(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Security data information<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Provides security information  about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFFFF<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetSecurityDataInformation(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ID number setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ID number of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The ID number is specified using ASCII code.<br>
		 * (Initial value : “000000”)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 6
bytes<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetIdNumberSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ID number setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ID number of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The ID number is specified using ASCII code.<br>
		 * (Initial value : “000000”)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 6
bytes<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetIdNumberSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Verification expiration information<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the month and year in which the verification of the meter will expire.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The month and year are specified using ASCII code.<br>
		 * xxxx xx Year Month<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 6
bytes<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetVerificationExpirationInformation(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Verification expiration information<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the month and year in which the verification of the meter will expire.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The month and year are specified using ASCII code.<br>
		 * xxxx xx Year Month<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 6
bytes<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetVerificationExpirationInformation(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
	}

	public static class Setter extends DeviceObject.Setter {
		public Setter(short dstEchoClassCode, byte dstEchoInstanceCode
				, String dstEchoAddress, boolean responseRequired) {
			super(dstEchoClassCode, dstEchoInstanceCode
					, dstEchoAddress, responseRequired);
		}
		
		@Override
		public Setter reqSetProperty(byte epc, byte[] edt) {
			return (Setter)super.reqSetProperty(epc, edt);
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
		public Setter reqSetRemoteControlSetting(byte[] edt) {
			return (Setter)super.reqSetRemoteControlSetting(edt);
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
		 * Property name : Flowing water classification<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the water flowmeter type.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30 : running water 0x31 : recycled water 0x32 : warm water 0x33 : other water<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetFlowingWaterClassification(byte[] edt) {
			reqSetProperty(EPC_FLOWING_WATER_CLASSIFICATION, edt);
			return this;
		}
		/**
		 * Property name : Owner classification<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the owner of the meter in the form of owner classification.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30 : Not specified  0x31 : Public waterworks<br>
		 * company<br>
		 * 0x32 : Private sector company 0x33 : Individual<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOwnerClassification(byte[] edt) {
			reqSetProperty(EPC_OWNER_CLASSIFICATION, edt);
			return this;
		}
		/**
		 * Property name : ID number setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ID number of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The ID number is specified using ASCII code.<br>
		 * (Initial value : “000000”)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 6
bytes<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetIdNumberSetting(byte[] edt) {
			reqSetProperty(EPC_ID_NUMBER_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Verification expiration information<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the month and year in which the verification of the meter will expire.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The month and year are specified using ASCII code.<br>
		 * xxxx xx Year Month<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 6
bytes<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetVerificationExpirationInformation(byte[] edt) {
			reqSetProperty(EPC_VERIFICATION_EXPIRATION_INFORMATION, edt);
			return this;
		}
	}
	
	public static class Getter extends DeviceObject.Getter {
		public Getter(short dstEchoClassCode, byte dstEchoInstanceCode
				, String dstEchoAddress) {
			super(dstEchoClassCode, dstEchoInstanceCode
					, dstEchoAddress);
		}
		
		@Override
		public Getter reqGetProperty(byte epc) {
			return (Getter)super.reqGetProperty(epc);
		}
		
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
		public Getter reqGetRemoteControlSetting() {
			return (Getter)super.reqGetRemoteControlSetting();
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
		 * Property name : Flowing water classification<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the water flowmeter type.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30 : running water 0x31 : recycled water 0x32 : warm water 0x33 : other water<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetFlowingWaterClassification() {
			reqGetProperty(EPC_FLOWING_WATER_CLASSIFICATION);
			return this;
		}
		/**
		 * Property name : Owner classification<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the owner of the meter in the form of owner classification.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30 : Not specified  0x31 : Public waterworks<br>
		 * company<br>
		 * 0x32 : Private sector company 0x33 : Individual<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOwnerClassification() {
			reqGetProperty(EPC_OWNER_CLASSIFICATION);
			return this;
		}
		/**
		 * Property name : Measured cumulative amount of flowing water<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the cumulative amount (consumption) of flowing water using a 9-digit number.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x3B9AC9FF (0.999,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : m3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetMeasuredCumulativeAmountOfFlowingWater() {
			reqGetProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_FLOWING_WATER);
			return this;
		}
		/**
		 * Property name : Unit for measured cumulative amounts of flowing water<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the unit (multiplying factor) for the measured cumulative amount of flowing water and the historical data of measured cumulative amounts of flowing water.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00: 1m3<br>
		 * 0x01: 0.1m3<br>
		 * 0x02: 0.01m3<br>
		 * 0x03: 0.001m3<br>
		 * 0x04: 0.0001m3 (Initial value) 0x05: 0.00001m3<br>
		 * 0x06: 0.000001m3<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetUnitForMeasuredCumulativeAmountsOfFlowingWater() {
			reqGetProperty(EPC_UNIT_FOR_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER);
			return this;
		}
		/**
		 * Property name : Historical data of measured cumulative amounts of flowing water<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the historical data of measured cumulative amounts (consumptions) of running water, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0.0x3B9AC9FF (0.999,999.999m3)<br>
		 * <br>
		 * Data type : unsigned long
×48<br>
		 * <br>
		 * Data size : 192
bytes<br>
		 * <br>
		 * Unit : 0.001
m3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater() {
			reqGetProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER);
			return this;
		}
		/**
		 * Property name : Detection of abnormal value in metering data<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Abnormal value detected: 0x41 No abnormal value detected: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetDetectionOfAbnormalValueInMeteringData() {
			reqGetProperty(EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA);
			return this;
		}
		/**
		 * Property name : Security data information<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Provides security information  about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFFFF<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSecurityDataInformation() {
			reqGetProperty(EPC_SECURITY_DATA_INFORMATION);
			return this;
		}
		/**
		 * Property name : ID number setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ID number of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The ID number is specified using ASCII code.<br>
		 * (Initial value : “000000”)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 6
bytes<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetIdNumberSetting() {
			reqGetProperty(EPC_ID_NUMBER_SETTING);
			return this;
		}
		/**
		 * Property name : Verification expiration information<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the month and year in which the verification of the meter will expire.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The month and year are specified using ASCII code.<br>
		 * xxxx xx Year Month<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 6
bytes<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetVerificationExpirationInformation() {
			reqGetProperty(EPC_VERIFICATION_EXPIRATION_INFORMATION);
			return this;
		}
	}
	
	public static class Informer extends DeviceObject.Informer {
		public Informer(short echoClassCode, byte echoInstanceCode
				, String dstEchoAddress, boolean isSelfObject) {
			super(echoClassCode, echoInstanceCode
					, dstEchoAddress, isSelfObject);
		}
		
		@Override
		public Informer reqInformProperty(byte epc) {
			return (Informer)super.reqInformProperty(epc);
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
		public Informer reqInformRemoteControlSetting() {
			return (Informer)super.reqInformRemoteControlSetting();
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
		
		/**
		 * Property name : Flowing water classification<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the water flowmeter type.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30 : running water 0x31 : recycled water 0x32 : warm water 0x33 : other water<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformFlowingWaterClassification() {
			reqInformProperty(EPC_FLOWING_WATER_CLASSIFICATION);
			return this;
		}
		/**
		 * Property name : Owner classification<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the owner of the meter in the form of owner classification.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30 : Not specified  0x31 : Public waterworks<br>
		 * company<br>
		 * 0x32 : Private sector company 0x33 : Individual<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOwnerClassification() {
			reqInformProperty(EPC_OWNER_CLASSIFICATION);
			return this;
		}
		/**
		 * Property name : Measured cumulative amount of flowing water<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the cumulative amount (consumption) of flowing water using a 9-digit number.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x3B9AC9FF (0.999,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : m3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformMeasuredCumulativeAmountOfFlowingWater() {
			reqInformProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_FLOWING_WATER);
			return this;
		}
		/**
		 * Property name : Unit for measured cumulative amounts of flowing water<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the unit (multiplying factor) for the measured cumulative amount of flowing water and the historical data of measured cumulative amounts of flowing water.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00: 1m3<br>
		 * 0x01: 0.1m3<br>
		 * 0x02: 0.01m3<br>
		 * 0x03: 0.001m3<br>
		 * 0x04: 0.0001m3 (Initial value) 0x05: 0.00001m3<br>
		 * 0x06: 0.000001m3<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformUnitForMeasuredCumulativeAmountsOfFlowingWater() {
			reqInformProperty(EPC_UNIT_FOR_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER);
			return this;
		}
		/**
		 * Property name : Historical data of measured cumulative amounts of flowing water<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the historical data of measured cumulative amounts (consumptions) of running water, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0.0x3B9AC9FF (0.999,999.999m3)<br>
		 * <br>
		 * Data type : unsigned long
×48<br>
		 * <br>
		 * Data size : 192
bytes<br>
		 * <br>
		 * Unit : 0.001
m3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfFlowingWater() {
			reqInformProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_FLOWING_WATER);
			return this;
		}
		/**
		 * Property name : Detection of abnormal value in metering data<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Abnormal value detected: 0x41 No abnormal value detected: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformDetectionOfAbnormalValueInMeteringData() {
			reqInformProperty(EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA);
			return this;
		}
		/**
		 * Property name : Security data information<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Provides security information  about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFFFF<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSecurityDataInformation() {
			reqInformProperty(EPC_SECURITY_DATA_INFORMATION);
			return this;
		}
		/**
		 * Property name : ID number setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ID number of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The ID number is specified using ASCII code.<br>
		 * (Initial value : “000000”)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 6
bytes<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformIdNumberSetting() {
			reqInformProperty(EPC_ID_NUMBER_SETTING);
			return this;
		}
		/**
		 * Property name : Verification expiration information<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the month and year in which the verification of the meter will expire.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The month and year are specified using ASCII code.<br>
		 * xxxx xx Year Month<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 6
bytes<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformVerificationExpirationInformation() {
			reqInformProperty(EPC_VERIFICATION_EXPIRATION_INFORMATION);
			return this;
		}
	}

	public static class Proxy extends WaterFlowmeter {
		public Proxy(byte instanceCode) {
			super();
			mEchoInstanceCode = instanceCode;
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
		@Override
		protected byte[] getMeasuredCumulativeAmountOfFlowingWater() {return null;}
		@Override
		protected byte[] getUnitForMeasuredCumulativeAmountsOfFlowingWater() {return null;}
	}
	
	public static Setter setG() {
		return setG((byte)0);
	}

	public static Setter setG(byte instanceCode) {
		return setG(instanceCode, true);
	}

	public static Setter setG(boolean responseRequired) {
		return setG((byte)0, responseRequired);
	}

	public static Setter setG(byte instanceCode, boolean responseRequired) {
		return new Setter(ECHO_CLASS_CODE, instanceCode
				, EchoSocket.MULTICAST_ADDRESS, responseRequired);
	}

	public static Getter getG() {
		return getG((byte)0);
	}
	
	public static Getter getG(byte instanceCode) {
		return new Getter(ECHO_CLASS_CODE, instanceCode
				, EchoSocket.MULTICAST_ADDRESS);
	}

	public static Informer informG() {
		return informG((byte)0);
	}

	public static Informer informG(byte instanceCode) {
		return new Informer(ECHO_CLASS_CODE, instanceCode
				, EchoSocket.MULTICAST_ADDRESS, false);
	}

}
