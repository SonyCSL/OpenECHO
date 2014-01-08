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

public abstract class SmartGasMeter extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0289;

	public static final byte EPC_GAS_METER_CLASSIFICATION = (byte)0xE0;
	public static final byte EPC_OWNER_CLASSIFICATION = (byte)0xE1;
	public static final byte EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION = (byte)0xE2;
	public static final byte EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS = (byte)0xE3;
	public static final byte EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS = (byte)0xE4;
	public static final byte EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED = (byte)0xE5;
	public static final byte EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA = (byte)0xE6;
	public static final byte EPC_SECURITY_DATA_INFORMATION = (byte)0xE7;
	public static final byte EPC_VALVE_CLOSURE_BY_THE_CENTER = (byte)0xE8;
	public static final byte EPC_PERMISSION_FROM_THE_CENTER_TO_REOPEN_THE_VALVE_CLOSED_BY_THE_CENTER = (byte)0xE9;
	public static final byte EPC_EMERGENCY_CLOSURE_OF_SHUTOFF_VALVE = (byte)0xEA;
	public static final byte EPC_SHUTOFF_VALVE_STATUS = (byte)0xEB;
	public static final byte EPC_HISTORICAL_DATA_OF_SHUTOFF_REASONS = (byte)0xEC;
	public static final byte EPC_ID_NUMBER_SETTING = (byte)0xED;
	public static final byte EPC_VERIFICATION_EXPIRATION_INFORMATION = (byte)0xEE;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION);
		addGetProperty(EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS);
		addStatusChangeAnnouncementProperty(EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA);
		addStatusChangeAnnouncementProperty(EPC_VALVE_CLOSURE_BY_THE_CENTER);
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
	 * This property indicates the<br>
	 * ON/OFF status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30�COFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
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
	 * This property indicates the<br>
	 * ON/OFF status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30�COFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
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
	 * Property name : Gas meter classification<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the type of the gas meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30�Fcity gas<br>
	 * 0x31�FLP gas<br>
	 * 0x32�Fnatural gas<br>
	 * 0x33�Fothers<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setGasMeterClassification(byte[] edt) {return false;}
	/**
	 * Property name : Gas meter classification<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the type of the gas meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30�Fcity gas<br>
	 * 0x31�FLP gas<br>
	 * 0x32�Fnatural gas<br>
	 * 0x33�Fothers<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getGasMeterClassification() {return null;}
	/**
	 * Property name : Gas meter classification<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the type of the gas meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30�Fcity gas<br>
	 * 0x31�FLP gas<br>
	 * 0x32�Fnatural gas<br>
	 * 0x33�Fothers<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidGasMeterClassification(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Owner classification<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the type of the owner of the meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30�Fnot specified<br>
	 * 0x31�Fcity gas<br>
	 * 0x32�FLP gas<br>
	 * 0x33�Fprivate-sector company<br>
	 * 0x34�Findividual<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
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
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the type of the owner of the meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30�Fnot specified<br>
	 * 0x31�Fcity gas<br>
	 * 0x32�FLP gas<br>
	 * 0x33�Fprivate-sector company<br>
	 * 0x34�Findividual<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
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
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the type of the owner of the meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30�Fnot specified<br>
	 * 0x31�Fcity gas<br>
	 * 0x32�FLP gas<br>
	 * 0x33�Fprivate-sector company<br>
	 * 0x34�Findividual<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
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
	 * Property name : Measured cumulative gas consumption<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured cumulative gas consumption in m3.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x3B9AC9FF<br>
	 * (0-999,999,999�j<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : 0.001
��3<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getMeasuredCumulativeGasConsumption();
	/**
	 * Property name : Measured cumulative gas consumption<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured cumulative gas consumption in m3.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x3B9AC9FF<br>
	 * (0-999,999,999�j<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : 0.001
��3<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidMeasuredCumulativeGasConsumption(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Unit for measured cumulative gas consumptions<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the unit (multiplying factor) for the measured cumulative gas consumption and the historical data of measured cumulative gas consumptions.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00: 1��3<br>
	 * 0x01: 0.1��3<br>
	 * 0x02: 0.01��3<br>
	 * 0x03: 0.001��3�iinitial value�j<br>
	 * 0x04: 0.0001��3<br>
	 * 0x05: 0.00001��3<br>
	 * 0x06: 0.000001��3<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getUnitForMeasuredCumulativeGasConsumptions();
	/**
	 * Property name : Unit for measured cumulative gas consumptions<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the unit (multiplying factor) for the measured cumulative gas consumption and the historical data of measured cumulative gas consumptions.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00: 1��3<br>
	 * 0x01: 0.1��3<br>
	 * 0x02: 0.01��3<br>
	 * 0x03: 0.001��3�iinitial value�j<br>
	 * 0x04: 0.0001��3<br>
	 * 0x05: 0.00001��3<br>
	 * 0x06: 0.000001��3<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidUnitForMeasuredCumulativeGasConsumptions(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Historical data of measured cumulative gas consumptions<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative gas consumptions is to be retrieved and the historical data of measured cumulative gas consumptions, which consists of 48 pieces of<br>
	 * half-hourly data for the preceding<br>
	 * 24 hours.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0x0063:<br>
	 * 0x0-0x3B9AC9FF<br>
	 * (0-99) : (0-999,999.999�j<br>
	 * <br>
	 * Data type : unsigned short
�{
unsigned
long
�~48<br>
	 * <br>
	 * Data size : 194
Byte<br>
	 * <br>
	 * Unit : 0.001
��3<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getHistoricalDataOfMeasuredCumulativeGasConsumptions() {return null;}
	/**
	 * Property name : Historical data of measured cumulative gas consumptions<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative gas consumptions is to be retrieved and the historical data of measured cumulative gas consumptions, which consists of 48 pieces of<br>
	 * half-hourly data for the preceding<br>
	 * 24 hours.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0x0063:<br>
	 * 0x0-0x3B9AC9FF<br>
	 * (0-99) : (0-999,999.999�j<br>
	 * <br>
	 * Data type : unsigned short
�{
unsigned
long
�~48<br>
	 * <br>
	 * Data size : 194
Byte<br>
	 * <br>
	 * Unit : 0.001
��3<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidHistoricalDataOfMeasuredCumulativeGasConsumptions(byte[] edt) {
		if(edt == null || !(edt.length == 194)) return false;
		return true;
	}
	/**
	 * Property name : Day for which the historical data of measured cumulative gas consumptions is to be retrieved<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of<br>
	 * 48 pieces of half-hourly data for<br>
	 * the preceding 24 hours) is to be retrieved.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x63 ( 0-99)<br>
	 * 0: current day<br>
	 * 1 - 99: previous day - day that precedes the current day by 99 days<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(byte[] edt) {return false;}
	/**
	 * Property name : Day for which the historical data of measured cumulative gas consumptions is to be retrieved<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of<br>
	 * 48 pieces of half-hourly data for<br>
	 * the preceding 24 hours) is to be retrieved.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x63 ( 0-99)<br>
	 * 0: current day<br>
	 * 1 - 99: previous day - day that precedes the current day by 99 days<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved() {return null;}
	/**
	 * Property name : Day for which the historical data of measured cumulative gas consumptions is to be retrieved<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of<br>
	 * 48 pieces of half-hourly data for<br>
	 * the preceding 24 hours) is to be retrieved.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x63 ( 0-99)<br>
	 * 0: current day<br>
	 * 1 - 99: previous day - day that precedes the current day by 99 days<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Detection of abnormal value in metering
data<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Abnormal value detected: 0x41<br>
	 * No abnormal value detected: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
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
	 * Property name : Detection of abnormal value in metering
data<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Abnormal value detected: 0x41<br>
	 * No abnormal value detected: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
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
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * For details, refer to the explanations under (9).<br>
	 * <br>
	 * Data type : unsigned char
�~10<br>
	 * <br>
	 * Data size : 10
Byte<br>
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
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * For details, refer to the explanations under (9).<br>
	 * <br>
	 * Data type : unsigned char
�~10<br>
	 * <br>
	 * Data size : 10
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSecurityDataInformation(byte[] edt) {
		if(edt == null || !(edt.length == 10)) return false;
		return true;
	}
	/**
	 * Property name : Valve closure by the Center<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether the Center has closed the gas shutoff valve of the meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Center has closed the valve: 0x41<br>
	 * Center has not closed the valve:<br>
	 * 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
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
	protected byte[] getValveClosureByTheCenter() {return null;}
	/**
	 * Property name : Valve closure by the Center<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether the Center has closed the gas shutoff valve of the meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Center has closed the valve: 0x41<br>
	 * Center has not closed the valve:<br>
	 * 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
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
	protected boolean isValidValveClosureByTheCenter(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Permission
from the Center to reopen the valve closed by the Center<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether permission has been given by the Center to reopen the gas shutoff valve of the meter closed by the Center.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Permission has been given by the Center to reopen the gas shutoff valve closed by the Center: 0x41<br>
	 * Permission to reopen the gas shutoff valve closed by the Center has not been given by the Center:<br>
	 * 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getPermissionFromTheCenterToReopenTheValveClosedByTheCenter() {return null;}
	/**
	 * Property name : Permission
from the Center to reopen the valve closed by the Center<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether permission has been given by the Center to reopen the gas shutoff valve of the meter closed by the Center.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Permission has been given by the Center to reopen the gas shutoff valve closed by the Center: 0x41<br>
	 * Permission to reopen the gas shutoff valve closed by the Center has not been given by the Center:<br>
	 * 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidPermissionFromTheCenterToReopenTheValveClosedByTheCenter(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Emergency closure of shutoff valve<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether the gas shutoff valve of the meter has been closed in response to an emergency.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Emergency closure of the shutoff valve has occurred: 0x41<br>
	 * No emergency closure of the shutoff valve has occurred: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getEmergencyClosureOfShutoffValve() {return null;}
	/**
	 * Property name : Emergency closure of shutoff valve<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether the gas shutoff valve of the meter has been closed in response to an emergency.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Emergency closure of the shutoff valve has occurred: 0x41<br>
	 * No emergency closure of the shutoff valve has occurred: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidEmergencyClosureOfShutoffValve(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Shutoff valve status<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether the shutoff valve is open or closed.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Shutoff valve open: 0x41<br>
	 * Shutoff valve closed: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getShutoffValveStatus() {return null;}
	/**
	 * Property name : Shutoff valve status<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether the shutoff valve is open or closed.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Shutoff valve open: 0x41<br>
	 * Shutoff valve closed: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidShutoffValveStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Historical data of shutoff reasons<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the reasons for the 3 past shutoff valve-based gas shutoffs by means of bit assignment with one byte used for each of the 3 shutoff reasons.<br>
	 * Historical data3�FHistorical data2�FHistorical data 1<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xFF: 0xFF: 0xFF<br>
	 * <br>
	 * Data type : unsigned char
�~3<br>
	 * <br>
	 * Data size : 3
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getHistoricalDataOfShutoffReasons() {return null;}
	/**
	 * Property name : Historical data of shutoff reasons<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the reasons for the 3 past shutoff valve-based gas shutoffs by means of bit assignment with one byte used for each of the 3 shutoff reasons.<br>
	 * Historical data3�FHistorical data2�FHistorical data 1<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xFF: 0xFF: 0xFF<br>
	 * <br>
	 * Data type : unsigned char
�~3<br>
	 * <br>
	 * Data size : 3
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidHistoricalDataOfShutoffReasons(byte[] edt) {
		if(edt == null || !(edt.length == 3)) return false;
		return true;
	}
	/**
	 * Property name : ID number setting<br>
	 * <br>
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ID<br>
	 * number of the meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 000000-FFFFFF<br>
	 * �iInitial .value .: .�g000000�h�j<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 6
Byte<br>
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
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ID<br>
	 * number of the meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 000000-FFFFFF<br>
	 * �iInitial .value .: .�g000000�h�j<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 6
Byte<br>
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
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ID<br>
	 * number of the meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 000000-FFFFFF<br>
	 * �iInitial .value .: .�g000000�h�j<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 6
Byte<br>
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
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the month and year in which the verification of the meter will expire.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * YYYYMM<br>
	 * YYYY�iYear�j�CMM�iMonth�j<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 6
Byte<br>
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
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the month and year in which the verification of the meter will expire.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * YYYYMM<br>
	 * YYYY�iYear�j�CMM�iMonth�j<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 6
Byte<br>
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
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the month and year in which the verification of the meter will expire.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * YYYYMM<br>
	 * YYYY�iYear�j�CMM�iMonth�j<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 6
Byte<br>
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
		case EPC_GAS_METER_CLASSIFICATION : return setGasMeterClassification(property.edt);
		case EPC_OWNER_CLASSIFICATION : return setOwnerClassification(property.edt);
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED : return setDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(property.edt);
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
		case EPC_GAS_METER_CLASSIFICATION : return getGasMeterClassification();
		case EPC_OWNER_CLASSIFICATION : return getOwnerClassification();
		case EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION : return getMeasuredCumulativeGasConsumption();
		case EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS : return getUnitForMeasuredCumulativeGasConsumptions();
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS : return getHistoricalDataOfMeasuredCumulativeGasConsumptions();
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED : return getDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved();
		case EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA : return getDetectionOfAbnormalValueInMeteringData();
		case EPC_SECURITY_DATA_INFORMATION : return getSecurityDataInformation();
		case EPC_VALVE_CLOSURE_BY_THE_CENTER : return getValveClosureByTheCenter();
		case EPC_PERMISSION_FROM_THE_CENTER_TO_REOPEN_THE_VALVE_CLOSED_BY_THE_CENTER : return getPermissionFromTheCenterToReopenTheValveClosedByTheCenter();
		case EPC_EMERGENCY_CLOSURE_OF_SHUTOFF_VALVE : return getEmergencyClosureOfShutoffValve();
		case EPC_SHUTOFF_VALVE_STATUS : return getShutoffValveStatus();
		case EPC_HISTORICAL_DATA_OF_SHUTOFF_REASONS : return getHistoricalDataOfShutoffReasons();
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
		case EPC_GAS_METER_CLASSIFICATION : return isValidGasMeterClassification(property.edt);
		case EPC_OWNER_CLASSIFICATION : return isValidOwnerClassification(property.edt);
		case EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION : return isValidMeasuredCumulativeGasConsumption(property.edt);
		case EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS : return isValidUnitForMeasuredCumulativeGasConsumptions(property.edt);
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS : return isValidHistoricalDataOfMeasuredCumulativeGasConsumptions(property.edt);
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED : return isValidDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(property.edt);
		case EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA : return isValidDetectionOfAbnormalValueInMeteringData(property.edt);
		case EPC_SECURITY_DATA_INFORMATION : return isValidSecurityDataInformation(property.edt);
		case EPC_VALVE_CLOSURE_BY_THE_CENTER : return isValidValveClosureByTheCenter(property.edt);
		case EPC_PERMISSION_FROM_THE_CENTER_TO_REOPEN_THE_VALVE_CLOSED_BY_THE_CENTER : return isValidPermissionFromTheCenterToReopenTheValveClosedByTheCenter(property.edt);
		case EPC_EMERGENCY_CLOSURE_OF_SHUTOFF_VALVE : return isValidEmergencyClosureOfShutoffValve(property.edt);
		case EPC_SHUTOFF_VALVE_STATUS : return isValidShutoffValveStatus(property.edt);
		case EPC_HISTORICAL_DATA_OF_SHUTOFF_REASONS : return isValidHistoricalDataOfShutoffReasons(property.edt);
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
			case EPC_GAS_METER_CLASSIFICATION : 
				onSetGasMeterClassification(eoj, tid, esv, property, success);
				return true;
			case EPC_OWNER_CLASSIFICATION : 
				onSetOwnerClassification(eoj, tid, esv, property, success);
				return true;
			case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED : 
				onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(eoj, tid, esv, property, success);
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
			case EPC_GAS_METER_CLASSIFICATION : 
				onGetGasMeterClassification(eoj, tid, esv, property, success);
				return true;
			case EPC_OWNER_CLASSIFICATION : 
				onGetOwnerClassification(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION : 
				onGetMeasuredCumulativeGasConsumption(eoj, tid, esv, property, success);
				return true;
			case EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS : 
				onGetUnitForMeasuredCumulativeGasConsumptions(eoj, tid, esv, property, success);
				return true;
			case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS : 
				onGetHistoricalDataOfMeasuredCumulativeGasConsumptions(eoj, tid, esv, property, success);
				return true;
			case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED : 
				onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(eoj, tid, esv, property, success);
				return true;
			case EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA : 
				onGetDetectionOfAbnormalValueInMeteringData(eoj, tid, esv, property, success);
				return true;
			case EPC_SECURITY_DATA_INFORMATION : 
				onGetSecurityDataInformation(eoj, tid, esv, property, success);
				return true;
			case EPC_VALVE_CLOSURE_BY_THE_CENTER : 
				onGetValveClosureByTheCenter(eoj, tid, esv, property, success);
				return true;
			case EPC_PERMISSION_FROM_THE_CENTER_TO_REOPEN_THE_VALVE_CLOSED_BY_THE_CENTER : 
				onGetPermissionFromTheCenterToReopenTheValveClosedByTheCenter(eoj, tid, esv, property, success);
				return true;
			case EPC_EMERGENCY_CLOSURE_OF_SHUTOFF_VALVE : 
				onGetEmergencyClosureOfShutoffValve(eoj, tid, esv, property, success);
				return true;
			case EPC_SHUTOFF_VALVE_STATUS : 
				onGetShutoffValveStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_HISTORICAL_DATA_OF_SHUTOFF_REASONS : 
				onGetHistoricalDataOfShutoffReasons(eoj, tid, esv, property, success);
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
		 * Property name : Gas meter classification<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of the gas meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30�Fcity gas<br>
		 * 0x31�FLP gas<br>
		 * 0x32�Fnatural gas<br>
		 * 0x33�Fothers<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetGasMeterClassification(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Gas meter classification<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of the gas meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30�Fcity gas<br>
		 * 0x31�FLP gas<br>
		 * 0x32�Fnatural gas<br>
		 * 0x33�Fothers<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetGasMeterClassification(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Owner classification<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of the owner of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30�Fnot specified<br>
		 * 0x31�Fcity gas<br>
		 * 0x32�FLP gas<br>
		 * 0x33�Fprivate-sector company<br>
		 * 0x34�Findividual<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
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
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of the owner of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30�Fnot specified<br>
		 * 0x31�Fcity gas<br>
		 * 0x32�FLP gas<br>
		 * 0x33�Fprivate-sector company<br>
		 * 0x34�Findividual<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
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
		 * Property name : Measured cumulative gas consumption<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative gas consumption in m3.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x3B9AC9FF<br>
		 * (0-999,999,999�j<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : 0.001
��3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetMeasuredCumulativeGasConsumption(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Unit for measured cumulative gas consumptions<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the unit (multiplying factor) for the measured cumulative gas consumption and the historical data of measured cumulative gas consumptions.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00: 1��3<br>
		 * 0x01: 0.1��3<br>
		 * 0x02: 0.01��3<br>
		 * 0x03: 0.001��3�iinitial value�j<br>
		 * 0x04: 0.0001��3<br>
		 * 0x05: 0.00001��3<br>
		 * 0x06: 0.000001��3<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetUnitForMeasuredCumulativeGasConsumptions(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Historical data of measured cumulative gas consumptions<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions is to be retrieved and the historical data of measured cumulative gas consumptions, which consists of 48 pieces of<br>
		 * half-hourly data for the preceding<br>
		 * 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x0063:<br>
		 * 0x0-0x3B9AC9FF<br>
		 * (0-99) : (0-999,999.999�j<br>
		 * <br>
		 * Data type : unsigned short
�{
unsigned
long
�~48<br>
		 * <br>
		 * Data size : 194
Byte<br>
		 * <br>
		 * Unit : 0.001
��3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetHistoricalDataOfMeasuredCumulativeGasConsumptions(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Day for which the historical data of measured cumulative gas consumptions is to be retrieved<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of<br>
		 * 48 pieces of half-hourly data for<br>
		 * the preceding 24 hours) is to be retrieved.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x63 ( 0-99)<br>
		 * 0: current day<br>
		 * 1 - 99: previous day - day that precedes the current day by 99 days<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Day for which the historical data of measured cumulative gas consumptions is to be retrieved<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of<br>
		 * 48 pieces of half-hourly data for<br>
		 * the preceding 24 hours) is to be retrieved.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x63 ( 0-99)<br>
		 * 0: current day<br>
		 * 1 - 99: previous day - day that precedes the current day by 99 days<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Detection of abnormal value in metering
data<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Abnormal value detected: 0x41<br>
		 * No abnormal value detected: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
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
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * For details, refer to the explanations under (9).<br>
		 * <br>
		 * Data type : unsigned char
�~10<br>
		 * <br>
		 * Data size : 10
Byte<br>
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
		 * Property name : Valve closure by the Center<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the Center has closed the gas shutoff valve of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Center has closed the valve: 0x41<br>
		 * Center has not closed the valve:<br>
		 * 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
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
		protected void onGetValveClosureByTheCenter(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Permission
from the Center to reopen the valve closed by the Center<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether permission has been given by the Center to reopen the gas shutoff valve of the meter closed by the Center.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Permission has been given by the Center to reopen the gas shutoff valve closed by the Center: 0x41<br>
		 * Permission to reopen the gas shutoff valve closed by the Center has not been given by the Center:<br>
		 * 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetPermissionFromTheCenterToReopenTheValveClosedByTheCenter(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Emergency closure of shutoff valve<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the gas shutoff valve of the meter has been closed in response to an emergency.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Emergency closure of the shutoff valve has occurred: 0x41<br>
		 * No emergency closure of the shutoff valve has occurred: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetEmergencyClosureOfShutoffValve(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Shutoff valve status<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the shutoff valve is open or closed.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Shutoff valve open: 0x41<br>
		 * Shutoff valve closed: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetShutoffValveStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Historical data of shutoff reasons<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the reasons for the 3 past shutoff valve-based gas shutoffs by means of bit assignment with one byte used for each of the 3 shutoff reasons.<br>
		 * Historical data3�FHistorical data2�FHistorical data 1<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFF: 0xFF: 0xFF<br>
		 * <br>
		 * Data type : unsigned char
�~3<br>
		 * <br>
		 * Data size : 3
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetHistoricalDataOfShutoffReasons(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ID number setting<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ID<br>
		 * number of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 000000-FFFFFF<br>
		 * �iInitial .value .: .�g000000�h�j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 6
Byte<br>
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
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ID<br>
		 * number of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 000000-FFFFFF<br>
		 * �iInitial .value .: .�g000000�h�j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 6
Byte<br>
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
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the month and year in which the verification of the meter will expire.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * YYYYMM<br>
		 * YYYY�iYear�j�CMM�iMonth�j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 6
Byte<br>
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
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the month and year in which the verification of the meter will expire.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * YYYYMM<br>
		 * YYYY�iYear�j�CMM�iMonth�j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 6
Byte<br>
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
		 * Property name : Gas meter classification<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of the gas meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30�Fcity gas<br>
		 * 0x31�FLP gas<br>
		 * 0x32�Fnatural gas<br>
		 * 0x33�Fothers<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetGasMeterClassification(byte[] edt) {
			reqSetProperty(EPC_GAS_METER_CLASSIFICATION, edt);
			return this;
		}
		/**
		 * Property name : Owner classification<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of the owner of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30�Fnot specified<br>
		 * 0x31�Fcity gas<br>
		 * 0x32�FLP gas<br>
		 * 0x33�Fprivate-sector company<br>
		 * 0x34�Findividual<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
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
		 * Property name : Day for which the historical data of measured cumulative gas consumptions is to be retrieved<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of<br>
		 * 48 pieces of half-hourly data for<br>
		 * the preceding 24 hours) is to be retrieved.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x63 ( 0-99)<br>
		 * 0: current day<br>
		 * 1 - 99: previous day - day that precedes the current day by 99 days<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved(byte[] edt) {
			reqSetProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED, edt);
			return this;
		}
		/**
		 * Property name : ID number setting<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ID<br>
		 * number of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 000000-FFFFFF<br>
		 * �iInitial .value .: .�g000000�h�j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 6
Byte<br>
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
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the month and year in which the verification of the meter will expire.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * YYYYMM<br>
		 * YYYY�iYear�j�CMM�iMonth�j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 6
Byte<br>
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
		 * Property name : Gas meter classification<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of the gas meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30�Fcity gas<br>
		 * 0x31�FLP gas<br>
		 * 0x32�Fnatural gas<br>
		 * 0x33�Fothers<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetGasMeterClassification() {
			reqGetProperty(EPC_GAS_METER_CLASSIFICATION);
			return this;
		}
		/**
		 * Property name : Owner classification<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of the owner of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30�Fnot specified<br>
		 * 0x31�Fcity gas<br>
		 * 0x32�FLP gas<br>
		 * 0x33�Fprivate-sector company<br>
		 * 0x34�Findividual<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
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
		 * Property name : Measured cumulative gas consumption<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative gas consumption in m3.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x3B9AC9FF<br>
		 * (0-999,999,999�j<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : 0.001
��3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetMeasuredCumulativeGasConsumption() {
			reqGetProperty(EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Unit for measured cumulative gas consumptions<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the unit (multiplying factor) for the measured cumulative gas consumption and the historical data of measured cumulative gas consumptions.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00: 1��3<br>
		 * 0x01: 0.1��3<br>
		 * 0x02: 0.01��3<br>
		 * 0x03: 0.001��3�iinitial value�j<br>
		 * 0x04: 0.0001��3<br>
		 * 0x05: 0.00001��3<br>
		 * 0x06: 0.000001��3<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetUnitForMeasuredCumulativeGasConsumptions() {
			reqGetProperty(EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS);
			return this;
		}
		/**
		 * Property name : Historical data of measured cumulative gas consumptions<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions is to be retrieved and the historical data of measured cumulative gas consumptions, which consists of 48 pieces of<br>
		 * half-hourly data for the preceding<br>
		 * 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x0063:<br>
		 * 0x0-0x3B9AC9FF<br>
		 * (0-99) : (0-999,999.999�j<br>
		 * <br>
		 * Data type : unsigned short
�{
unsigned
long
�~48<br>
		 * <br>
		 * Data size : 194
Byte<br>
		 * <br>
		 * Unit : 0.001
��3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetHistoricalDataOfMeasuredCumulativeGasConsumptions() {
			reqGetProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS);
			return this;
		}
		/**
		 * Property name : Day for which the historical data of measured cumulative gas consumptions is to be retrieved<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of<br>
		 * 48 pieces of half-hourly data for<br>
		 * the preceding 24 hours) is to be retrieved.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x63 ( 0-99)<br>
		 * 0: current day<br>
		 * 1 - 99: previous day - day that precedes the current day by 99 days<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved() {
			reqGetProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED);
			return this;
		}
		/**
		 * Property name : Detection of abnormal value in metering
data<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Abnormal value detected: 0x41<br>
		 * No abnormal value detected: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
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
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * For details, refer to the explanations under (9).<br>
		 * <br>
		 * Data type : unsigned char
�~10<br>
		 * <br>
		 * Data size : 10
Byte<br>
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
		 * Property name : Valve closure by the Center<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the Center has closed the gas shutoff valve of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Center has closed the valve: 0x41<br>
		 * Center has not closed the valve:<br>
		 * 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
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
		public Getter reqGetValveClosureByTheCenter() {
			reqGetProperty(EPC_VALVE_CLOSURE_BY_THE_CENTER);
			return this;
		}
		/**
		 * Property name : Permission
from the Center to reopen the valve closed by the Center<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether permission has been given by the Center to reopen the gas shutoff valve of the meter closed by the Center.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Permission has been given by the Center to reopen the gas shutoff valve closed by the Center: 0x41<br>
		 * Permission to reopen the gas shutoff valve closed by the Center has not been given by the Center:<br>
		 * 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetPermissionFromTheCenterToReopenTheValveClosedByTheCenter() {
			reqGetProperty(EPC_PERMISSION_FROM_THE_CENTER_TO_REOPEN_THE_VALVE_CLOSED_BY_THE_CENTER);
			return this;
		}
		/**
		 * Property name : Emergency closure of shutoff valve<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the gas shutoff valve of the meter has been closed in response to an emergency.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Emergency closure of the shutoff valve has occurred: 0x41<br>
		 * No emergency closure of the shutoff valve has occurred: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetEmergencyClosureOfShutoffValve() {
			reqGetProperty(EPC_EMERGENCY_CLOSURE_OF_SHUTOFF_VALVE);
			return this;
		}
		/**
		 * Property name : Shutoff valve status<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the shutoff valve is open or closed.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Shutoff valve open: 0x41<br>
		 * Shutoff valve closed: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetShutoffValveStatus() {
			reqGetProperty(EPC_SHUTOFF_VALVE_STATUS);
			return this;
		}
		/**
		 * Property name : Historical data of shutoff reasons<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the reasons for the 3 past shutoff valve-based gas shutoffs by means of bit assignment with one byte used for each of the 3 shutoff reasons.<br>
		 * Historical data3�FHistorical data2�FHistorical data 1<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFF: 0xFF: 0xFF<br>
		 * <br>
		 * Data type : unsigned char
�~3<br>
		 * <br>
		 * Data size : 3
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetHistoricalDataOfShutoffReasons() {
			reqGetProperty(EPC_HISTORICAL_DATA_OF_SHUTOFF_REASONS);
			return this;
		}
		/**
		 * Property name : ID number setting<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ID<br>
		 * number of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 000000-FFFFFF<br>
		 * �iInitial .value .: .�g000000�h�j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 6
Byte<br>
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
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the month and year in which the verification of the meter will expire.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * YYYYMM<br>
		 * YYYY�iYear�j�CMM�iMonth�j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 6
Byte<br>
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
		
		/**
		 * Property name : Gas meter classification<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of the gas meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30�Fcity gas<br>
		 * 0x31�FLP gas<br>
		 * 0x32�Fnatural gas<br>
		 * 0x33�Fothers<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformGasMeterClassification() {
			reqInformProperty(EPC_GAS_METER_CLASSIFICATION);
			return this;
		}
		/**
		 * Property name : Owner classification<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of the owner of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30�Fnot specified<br>
		 * 0x31�Fcity gas<br>
		 * 0x32�FLP gas<br>
		 * 0x33�Fprivate-sector company<br>
		 * 0x34�Findividual<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
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
		 * Property name : Measured cumulative gas consumption<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative gas consumption in m3.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x3B9AC9FF<br>
		 * (0-999,999,999�j<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : 0.001
��3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformMeasuredCumulativeGasConsumption() {
			reqInformProperty(EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Unit for measured cumulative gas consumptions<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the unit (multiplying factor) for the measured cumulative gas consumption and the historical data of measured cumulative gas consumptions.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00: 1��3<br>
		 * 0x01: 0.1��3<br>
		 * 0x02: 0.01��3<br>
		 * 0x03: 0.001��3�iinitial value�j<br>
		 * 0x04: 0.0001��3<br>
		 * 0x05: 0.00001��3<br>
		 * 0x06: 0.000001��3<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformUnitForMeasuredCumulativeGasConsumptions() {
			reqInformProperty(EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS);
			return this;
		}
		/**
		 * Property name : Historical data of measured cumulative gas consumptions<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions is to be retrieved and the historical data of measured cumulative gas consumptions, which consists of 48 pieces of<br>
		 * half-hourly data for the preceding<br>
		 * 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x0063:<br>
		 * 0x0-0x3B9AC9FF<br>
		 * (0-99) : (0-999,999.999�j<br>
		 * <br>
		 * Data type : unsigned short
�{
unsigned
long
�~48<br>
		 * <br>
		 * Data size : 194
Byte<br>
		 * <br>
		 * Unit : 0.001
��3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformHistoricalDataOfMeasuredCumulativeGasConsumptions() {
			reqInformProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS);
			return this;
		}
		/**
		 * Property name : Day for which the historical data of measured cumulative gas consumptions is to be retrieved<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative gas consumptions (which consists of<br>
		 * 48 pieces of half-hourly data for<br>
		 * the preceding 24 hours) is to be retrieved.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x63 ( 0-99)<br>
		 * 0: current day<br>
		 * 1 - 99: previous day - day that precedes the current day by 99 days<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDayForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionsIsToBeRetrieved() {
			reqInformProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTIONS_IS_TO_BE_RETRIEVED);
			return this;
		}
		/**
		 * Property name : Detection of abnormal value in metering
data<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the meter has detected an abnormal value in the metering data.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Abnormal value detected: 0x41<br>
		 * No abnormal value detected: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
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
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Provides security information about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * For details, refer to the explanations under (9).<br>
		 * <br>
		 * Data type : unsigned char
�~10<br>
		 * <br>
		 * Data size : 10
Byte<br>
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
		 * Property name : Valve closure by the Center<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the Center has closed the gas shutoff valve of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Center has closed the valve: 0x41<br>
		 * Center has not closed the valve:<br>
		 * 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
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
		public Informer reqInformValveClosureByTheCenter() {
			reqInformProperty(EPC_VALVE_CLOSURE_BY_THE_CENTER);
			return this;
		}
		/**
		 * Property name : Permission
from the Center to reopen the valve closed by the Center<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether permission has been given by the Center to reopen the gas shutoff valve of the meter closed by the Center.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Permission has been given by the Center to reopen the gas shutoff valve closed by the Center: 0x41<br>
		 * Permission to reopen the gas shutoff valve closed by the Center has not been given by the Center:<br>
		 * 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformPermissionFromTheCenterToReopenTheValveClosedByTheCenter() {
			reqInformProperty(EPC_PERMISSION_FROM_THE_CENTER_TO_REOPEN_THE_VALVE_CLOSED_BY_THE_CENTER);
			return this;
		}
		/**
		 * Property name : Emergency closure of shutoff valve<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the gas shutoff valve of the meter has been closed in response to an emergency.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Emergency closure of the shutoff valve has occurred: 0x41<br>
		 * No emergency closure of the shutoff valve has occurred: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformEmergencyClosureOfShutoffValve() {
			reqInformProperty(EPC_EMERGENCY_CLOSURE_OF_SHUTOFF_VALVE);
			return this;
		}
		/**
		 * Property name : Shutoff valve status<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the shutoff valve is open or closed.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Shutoff valve open: 0x41<br>
		 * Shutoff valve closed: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformShutoffValveStatus() {
			reqInformProperty(EPC_SHUTOFF_VALVE_STATUS);
			return this;
		}
		/**
		 * Property name : Historical data of shutoff reasons<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the reasons for the 3 past shutoff valve-based gas shutoffs by means of bit assignment with one byte used for each of the 3 shutoff reasons.<br>
		 * Historical data3�FHistorical data2�FHistorical data 1<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFF: 0xFF: 0xFF<br>
		 * <br>
		 * Data type : unsigned char
�~3<br>
		 * <br>
		 * Data size : 3
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformHistoricalDataOfShutoffReasons() {
			reqInformProperty(EPC_HISTORICAL_DATA_OF_SHUTOFF_REASONS);
			return this;
		}
		/**
		 * Property name : ID number setting<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ID<br>
		 * number of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 000000-FFFFFF<br>
		 * �iInitial .value .: .�g000000�h�j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 6
Byte<br>
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
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the month and year in which the verification of the meter will expire.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * YYYYMM<br>
		 * YYYY�iYear�j�CMM�iMonth�j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 6
Byte<br>
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

	public static class Proxy extends SmartGasMeter {
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
		protected byte[] getMeasuredCumulativeGasConsumption() {return null;}
		@Override
		protected byte[] getUnitForMeasuredCumulativeGasConsumptions() {return null;}
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
