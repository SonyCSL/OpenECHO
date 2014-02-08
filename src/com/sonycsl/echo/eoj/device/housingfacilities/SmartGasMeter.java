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

	public static final byte EPC_GAS_METER_CLASSIFICATION_SETTING = (byte)0xE0;
	public static final byte EPC_OWNER_CLASSIFICATION_SETTING = (byte)0xE1;
	public static final byte EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION = (byte)0xE2;
	public static final byte EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTION = (byte)0xE3;
	public static final byte EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTION = (byte)0xE4;
	public static final byte EPC_DAY_SETTING_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTION_IS_TO_BE_RETRIEVED = (byte)0xE5;
	public static final byte EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA = (byte)0xE6;
	public static final byte EPC_SECURITY_DATA_INFORMATION = (byte)0xE7;
	public static final byte EPC_VALVE_CLOSURE_BY_THE_CENTER = (byte)0xE8;
	public static final byte EPC_PERMISSION_FROM_THE_CENTER_TO_REOPEN_THE_VALVE_CLOSED_BY_THE_CENTER = (byte)0xE9;
	public static final byte EPC_EMERGENCY_CLOSURE_OF_SHUTOFF_VALVE = (byte)0xEA;
	public static final byte EPC_SHUTOFF_VALVE_STATUS = (byte)0xEB;
	public static final byte EPC_HISTORICAL_DATA_OF_SHUTOFF_REASONS = (byte)0xEC;
	public static final byte EPC_ID_NUMBER_SETTING = (byte)0xED;
	public static final byte EPC_VERIFICATION_EXPIRATION_SETTING = (byte)0xEE;
	public static final byte EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION_INFORMATION_WITH_DATE_AND_TIME = (byte)0xD0;
	public static final byte EPC_HISTORICAL_INFORMATION_OF_CUMULATIVE_GAS_CONSUMPTION = (byte)0xD1;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION);
		addGetProperty(EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION_INFORMATION_WITH_DATE_AND_TIME);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewSmartGasMeter(this);
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
	 * Property name : Gas meter classification setting<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the type of the gas meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30: city gas 0x31: LP gas 0x32: natural gas 0x33: others<br>
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
	protected boolean setGasMeterClassificationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Gas meter classification setting<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the type of the gas meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30: city gas 0x31: LP gas 0x32: natural gas 0x33: others<br>
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
	protected byte[] getGasMeterClassificationSetting() {return null;}
	/**
	 * Property name : Gas meter classification setting<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the type of the gas meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30: city gas 0x31: LP gas 0x32: natural gas 0x33: others<br>
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
	protected boolean isValidGasMeterClassificationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Owner classification setting<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the type of owner of the meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30: not specified 0x31: city gas 0x32: LP gas<br>
	 * 0x33: private-sector company 0x34: individual<br>
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
	protected boolean setOwnerClassificationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Owner classification setting<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the type of owner of the meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30: not specified 0x31: city gas 0x32: LP gas<br>
	 * 0x33: private-sector company 0x34: individual<br>
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
	protected byte[] getOwnerClassificationSetting() {return null;}
	/**
	 * Property name : Owner classification setting<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the type of owner of the meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30: not specified 0x31: city gas 0x32: LP gas<br>
	 * 0x33: private-sector company 0x34: individual<br>
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
	protected boolean isValidOwnerClassificationSetting(byte[] edt) {
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
	 * 0.0x3B9AC9FF (0.999,999,999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
bytes<br>
	 * <br>
	 * Unit : 0.001
m3<br>
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
	 * 0.0x3B9AC9FF (0.999,999,999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
bytes<br>
	 * <br>
	 * Unit : 0.001
m3<br>
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
	 * Property name : Unit for measured cumulative gas consumption<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the unit (multiplying factor) for the measured cumulative gas consumption and the historical data of measured cumulative gas consumption.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00: 1m3<br>
	 * 0x01: 0.1m3<br>
	 * 0x02: 0.01m3<br>
	 * 0x03: 0.001m3<br>
	 * 0x04: 0.0001m3<br>
	 * 0x05: 0.00001m3<br>
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
	 * Get - optional<br>
	 */
	protected byte[] getUnitForMeasuredCumulativeGasConsumption() {return null;}
	/**
	 * Property name : Unit for measured cumulative gas consumption<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the unit (multiplying factor) for the measured cumulative gas consumption and the historical data of measured cumulative gas consumption.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00: 1m3<br>
	 * 0x01: 0.1m3<br>
	 * 0x02: 0.01m3<br>
	 * 0x03: 0.001m3<br>
	 * 0x04: 0.0001m3<br>
	 * 0x05: 0.00001m3<br>
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
	 * Get - optional<br>
	 */
	protected boolean isValidUnitForMeasuredCumulativeGasConsumption(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Historical data of measured cumulative gas consumption<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative gas consumption is to be retrieved and the historical data of measured cumulative gas consumption, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x0063:<br>
	 * 0x0.0x3B9AC9FF (0.99) : (0.999,999.999)<br>
	 * <br>
	 * Data type : unsigned short
+unsigne d
long
×48<br>
	 * <br>
	 * Data size : 194
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
	protected byte[] getHistoricalDataOfMeasuredCumulativeGasConsumption() {return null;}
	/**
	 * Property name : Historical data of measured cumulative gas consumption<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative gas consumption is to be retrieved and the historical data of measured cumulative gas consumption, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x0063:<br>
	 * 0x0.0x3B9AC9FF (0.99) : (0.999,999.999)<br>
	 * <br>
	 * Data type : unsigned short
+unsigne d
long
×48<br>
	 * <br>
	 * Data size : 194
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
	protected boolean isValidHistoricalDataOfMeasuredCumulativeGasConsumption(byte[] edt) {
		if(edt == null || !(edt.length == 194)) return false;
		return true;
	}
	/**
	 * Property name : Day setting for which the historical data of measured cumulative gas consumption is to be retrieved<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative gas consumption (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x63 (0.99)<br>
	 * 0: current day<br>
	 * 1.99: previous day.day that precedes the current day by 99 days<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDaySettingForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionIsToBeRetrieved(byte[] edt) {return false;}
	/**
	 * Property name : Day setting for which the historical data of measured cumulative gas consumption is to be retrieved<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative gas consumption (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x63 (0.99)<br>
	 * 0: current day<br>
	 * 1.99: previous day.day that precedes the current day by 99 days<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDaySettingForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionIsToBeRetrieved() {return null;}
	/**
	 * Property name : Day setting for which the historical data of measured cumulative gas consumption is to be retrieved<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative gas consumption (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x63 (0.99)<br>
	 * 0: current day<br>
	 * 1.99: previous day.day that precedes the current day by 99 days<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDaySettingForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionIsToBeRetrieved(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Detection of abnormal value in metering data<br>
	 * <br>
	 * EPC : 0xE6<br>
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
	 */
	protected byte[] getDetectionOfAbnormalValueInMeteringData() {return null;}
	/**
	 * Property name : Detection of abnormal value in metering data<br>
	 * <br>
	 * EPC : 0xE6<br>
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
	 * Provides security information  about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * For details, refer to the explanations under (9).<br>
	 * <br>
	 * Data type : unsigned char
×10<br>
	 * <br>
	 * Data size : 10
bytes<br>
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
	 * Provides security information  about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * For details, refer to the explanations under (9).<br>
	 * <br>
	 * Data type : unsigned char
×10<br>
	 * <br>
	 * Data size : 10
bytes<br>
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
	 * Center has closed the valve: 0x41 Center has not closed the valve:<br>
	 * 0x42<br>
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
	 * Center has closed the valve: 0x41 Center has not closed the valve:<br>
	 * 0x42<br>
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
	 */
	protected boolean isValidValveClosureByTheCenter(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Permission from the Center to reopen the valve closed by the Center<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether permission has been given by the Center to reopen the gas shutoff valve of the meter closed by the Center.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Permission has been given by the Center to reopen the gas shutoff valve closed by the Center: 0x41<br>
	 * Permission to reopen the gas shutoff valve closed by the Center has not been given by the Center: 0x42<br>
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
	 */
	protected byte[] getPermissionFromTheCenterToReopenTheValveClosedByTheCenter() {return null;}
	/**
	 * Property name : Permission from the Center to reopen the valve closed by the Center<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether permission has been given by the Center to reopen the gas shutoff valve of the meter closed by the Center.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Permission has been given by the Center to reopen the gas shutoff valve closed by the Center: 0x41<br>
	 * Permission to reopen the gas shutoff valve closed by the Center has not been given by the Center: 0x42<br>
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
byte<br>
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
byte<br>
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
	 * Shutoff valve open: 0x41 Shutoff valve closed: 0x42<br>
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
	 * Shutoff valve open: 0x41 Shutoff valve closed: 0x42<br>
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
	 * Historical data3: Historical data2: Historical data 1<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xFF: 0xFF: 0xFF<br>
	 * <br>
	 * Data type : unsigned char
×3<br>
	 * <br>
	 * Data size : 3
bytes<br>
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
	 * Historical data3: Historical data2: Historical data 1<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xFF: 0xFF: 0xFF<br>
	 * <br>
	 * Data type : unsigned char
×3<br>
	 * <br>
	 * Data size : 3
bytes<br>
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
	 * This property indicates the ID number of the meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 000000.FFFFFF<br>
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
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ID number of the meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 000000.FFFFFF<br>
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
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ID number of the meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 000000.FFFFFF<br>
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
	 * Property name : Verification expiration setting<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the month and year in which the verification of the meter will expire.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * YYYYMM<br>
	 * YYYY (Year), MM (Month)<br>
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
	protected boolean setVerificationExpirationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Verification expiration setting<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the month and year in which the verification of the meter will expire.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * YYYYMM<br>
	 * YYYY (Year), MM (Month)<br>
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
	protected byte[] getVerificationExpirationSetting() {return null;}
	/**
	 * Property name : Verification expiration setting<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the month and year in which the verification of the meter will expire.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * YYYYMM<br>
	 * YYYY (Year), MM (Month)<br>
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
	protected boolean isValidVerificationExpirationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 6)) return false;
		return true;
	}
	/**
	 * Property name : Measured cumulative gas consumption information with date and time<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the cumulative gas consumption and the date and time of measurement.<br>
	 * Date of measurement: YYYY:MM:DD<br>
	 * Time of measurement: HH:MM:SS<br>
	 * Cumulative gas consumption: 9 digits<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 1.4 bytes: 0.0x270f:1.0x0C:1.0x1F (=0.9999):(=1.12):(1.31)<br>
	 * 5.7 bytes: 0.0x17:0.0x3B:0.-0x3B (=0.23):(=0.59): (=0.59)<br>
	 * 8.11 bytes: 0x00000000.0x3B9AC9FF<br>
	 * (0.999,999,999)<br>
	 * <br>
	 * Data type : unsigne d char×4+
unsigne d char×3+
unsigne d long<br>
	 * <br>
	 * Data size : 11 bytes<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getMeasuredCumulativeGasConsumptionInformationWithDateAndTime();
	/**
	 * Property name : Measured cumulative gas consumption information with date and time<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the cumulative gas consumption and the date and time of measurement.<br>
	 * Date of measurement: YYYY:MM:DD<br>
	 * Time of measurement: HH:MM:SS<br>
	 * Cumulative gas consumption: 9 digits<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 1.4 bytes: 0.0x270f:1.0x0C:1.0x1F (=0.9999):(=1.12):(1.31)<br>
	 * 5.7 bytes: 0.0x17:0.0x3B:0.-0x3B (=0.23):(=0.59): (=0.59)<br>
	 * 8.11 bytes: 0x00000000.0x3B9AC9FF<br>
	 * (0.999,999,999)<br>
	 * <br>
	 * Data type : unsigne d char×4+
unsigne d char×3+
unsigne d long<br>
	 * <br>
	 * Data size : 11 bytes<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidMeasuredCumulativeGasConsumptionInformationWithDateAndTime(byte[] edt) {
		if(edt == null || !(edt.length == 11)) return false;
		return true;
	}
	/**
	 * Property name : Historical information of cumulative gas consumption<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the historical information of gas consumption measured at every hour, the date and time of history start, cumulative gas consumption at history start and cumulative time interval.<br>
	 * Date: YYYY:MM:DD Time: HH:MM:SS<br>
	 * Historical information of gas consumption<br>
	 * Cumulative gas consumption at history start<br>
	 * Cumulative time interval: 5 digits, every minute<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 1.4 bytes:<br>
	 * 0.0x270f:1.0x0C:1.0x1F<br>
	 * (=0.9999):(=1.12):(1.31)<br>
	 * 5.7 bytes:<br>
	 * 0.0x17:0.0x3B:0.0x3B<br>
	 * (=0.23):(=0.59):(=0.59)<br>
	 * 8.103 bytes:<br>
	 * 0x00000000.0x0001869F×24<br>
	 * (0.99.999m3)×24<br>
	 * 104.107 bytes:<br>
	 * 0x00000000.0x3B9AC9FF<br>
	 * (0.999,999,999 m3)<br>
	 * 108.109 bytes:<br>
	 * 0x0001.0xFFFF<br>
	 * (1.65535)<br>
	 * <br>
	 * Data type : unsigne d char×4+ unsigne d char×3+ unsigne d long×24
+unsign ed long+un signed
short<br>
	 * <br>
	 * Data size : 109 bytes<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - undefined<br>
	 */
	protected boolean isValidHistoricalInformationOfCumulativeGasConsumption(byte[] edt) {
		if(edt == null || !(edt.length == 109)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_GAS_METER_CLASSIFICATION_SETTING : return setGasMeterClassificationSetting(property.edt);
		case EPC_OWNER_CLASSIFICATION_SETTING : return setOwnerClassificationSetting(property.edt);
		case EPC_DAY_SETTING_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTION_IS_TO_BE_RETRIEVED : return setDaySettingForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionIsToBeRetrieved(property.edt);
		case EPC_ID_NUMBER_SETTING : return setIdNumberSetting(property.edt);
		case EPC_VERIFICATION_EXPIRATION_SETTING : return setVerificationExpirationSetting(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_GAS_METER_CLASSIFICATION_SETTING : return getGasMeterClassificationSetting();
		case EPC_OWNER_CLASSIFICATION_SETTING : return getOwnerClassificationSetting();
		case EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION : return getMeasuredCumulativeGasConsumption();
		case EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTION : return getUnitForMeasuredCumulativeGasConsumption();
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTION : return getHistoricalDataOfMeasuredCumulativeGasConsumption();
		case EPC_DAY_SETTING_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTION_IS_TO_BE_RETRIEVED : return getDaySettingForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionIsToBeRetrieved();
		case EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA : return getDetectionOfAbnormalValueInMeteringData();
		case EPC_SECURITY_DATA_INFORMATION : return getSecurityDataInformation();
		case EPC_VALVE_CLOSURE_BY_THE_CENTER : return getValveClosureByTheCenter();
		case EPC_PERMISSION_FROM_THE_CENTER_TO_REOPEN_THE_VALVE_CLOSED_BY_THE_CENTER : return getPermissionFromTheCenterToReopenTheValveClosedByTheCenter();
		case EPC_EMERGENCY_CLOSURE_OF_SHUTOFF_VALVE : return getEmergencyClosureOfShutoffValve();
		case EPC_SHUTOFF_VALVE_STATUS : return getShutoffValveStatus();
		case EPC_HISTORICAL_DATA_OF_SHUTOFF_REASONS : return getHistoricalDataOfShutoffReasons();
		case EPC_ID_NUMBER_SETTING : return getIdNumberSetting();
		case EPC_VERIFICATION_EXPIRATION_SETTING : return getVerificationExpirationSetting();
		case EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION_INFORMATION_WITH_DATE_AND_TIME : return getMeasuredCumulativeGasConsumptionInformationWithDateAndTime();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_GAS_METER_CLASSIFICATION_SETTING : return isValidGasMeterClassificationSetting(property.edt);
		case EPC_OWNER_CLASSIFICATION_SETTING : return isValidOwnerClassificationSetting(property.edt);
		case EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION : return isValidMeasuredCumulativeGasConsumption(property.edt);
		case EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTION : return isValidUnitForMeasuredCumulativeGasConsumption(property.edt);
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTION : return isValidHistoricalDataOfMeasuredCumulativeGasConsumption(property.edt);
		case EPC_DAY_SETTING_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTION_IS_TO_BE_RETRIEVED : return isValidDaySettingForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionIsToBeRetrieved(property.edt);
		case EPC_DETECTION_OF_ABNORMAL_VALUE_IN_METERING_DATA : return isValidDetectionOfAbnormalValueInMeteringData(property.edt);
		case EPC_SECURITY_DATA_INFORMATION : return isValidSecurityDataInformation(property.edt);
		case EPC_VALVE_CLOSURE_BY_THE_CENTER : return isValidValveClosureByTheCenter(property.edt);
		case EPC_PERMISSION_FROM_THE_CENTER_TO_REOPEN_THE_VALVE_CLOSED_BY_THE_CENTER : return isValidPermissionFromTheCenterToReopenTheValveClosedByTheCenter(property.edt);
		case EPC_EMERGENCY_CLOSURE_OF_SHUTOFF_VALVE : return isValidEmergencyClosureOfShutoffValve(property.edt);
		case EPC_SHUTOFF_VALVE_STATUS : return isValidShutoffValveStatus(property.edt);
		case EPC_HISTORICAL_DATA_OF_SHUTOFF_REASONS : return isValidHistoricalDataOfShutoffReasons(property.edt);
		case EPC_ID_NUMBER_SETTING : return isValidIdNumberSetting(property.edt);
		case EPC_VERIFICATION_EXPIRATION_SETTING : return isValidVerificationExpirationSetting(property.edt);
		case EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION_INFORMATION_WITH_DATE_AND_TIME : return isValidMeasuredCumulativeGasConsumptionInformationWithDateAndTime(property.edt);
		case EPC_HISTORICAL_INFORMATION_OF_CUMULATIVE_GAS_CONSUMPTION : return isValidHistoricalInformationOfCumulativeGasConsumption(property.edt);
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
			case EPC_GAS_METER_CLASSIFICATION_SETTING : 
				onSetGasMeterClassificationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OWNER_CLASSIFICATION_SETTING : 
				onSetOwnerClassificationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DAY_SETTING_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTION_IS_TO_BE_RETRIEVED : 
				onSetDaySettingForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionIsToBeRetrieved(eoj, tid, esv, property, success);
				return true;
			case EPC_ID_NUMBER_SETTING : 
				onSetIdNumberSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VERIFICATION_EXPIRATION_SETTING : 
				onSetVerificationExpirationSetting(eoj, tid, esv, property, success);
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
			case EPC_GAS_METER_CLASSIFICATION_SETTING : 
				onGetGasMeterClassificationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OWNER_CLASSIFICATION_SETTING : 
				onGetOwnerClassificationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION : 
				onGetMeasuredCumulativeGasConsumption(eoj, tid, esv, property, success);
				return true;
			case EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTION : 
				onGetUnitForMeasuredCumulativeGasConsumption(eoj, tid, esv, property, success);
				return true;
			case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTION : 
				onGetHistoricalDataOfMeasuredCumulativeGasConsumption(eoj, tid, esv, property, success);
				return true;
			case EPC_DAY_SETTING_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTION_IS_TO_BE_RETRIEVED : 
				onGetDaySettingForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionIsToBeRetrieved(eoj, tid, esv, property, success);
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
			case EPC_VERIFICATION_EXPIRATION_SETTING : 
				onGetVerificationExpirationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION_INFORMATION_WITH_DATE_AND_TIME : 
				onGetMeasuredCumulativeGasConsumptionInformationWithDateAndTime(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Gas meter classification setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of the gas meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30: city gas 0x31: LP gas 0x32: natural gas 0x33: others<br>
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
		protected void onSetGasMeterClassificationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Gas meter classification setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of the gas meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30: city gas 0x31: LP gas 0x32: natural gas 0x33: others<br>
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
		protected void onGetGasMeterClassificationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Owner classification setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of owner of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30: not specified 0x31: city gas 0x32: LP gas<br>
		 * 0x33: private-sector company 0x34: individual<br>
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
		protected void onSetOwnerClassificationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Owner classification setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of owner of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30: not specified 0x31: city gas 0x32: LP gas<br>
		 * 0x33: private-sector company 0x34: individual<br>
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
		protected void onGetOwnerClassificationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured cumulative gas consumption<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative gas consumption in m3.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x3B9AC9FF (0.999,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : 0.001
m3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetMeasuredCumulativeGasConsumption(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Unit for measured cumulative gas consumption<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the unit (multiplying factor) for the measured cumulative gas consumption and the historical data of measured cumulative gas consumption.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00: 1m3<br>
		 * 0x01: 0.1m3<br>
		 * 0x02: 0.01m3<br>
		 * 0x03: 0.001m3<br>
		 * 0x04: 0.0001m3<br>
		 * 0x05: 0.00001m3<br>
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
		 * Get - optional<br>
		 */
		protected void onGetUnitForMeasuredCumulativeGasConsumption(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Historical data of measured cumulative gas consumption<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative gas consumption is to be retrieved and the historical data of measured cumulative gas consumption, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x0063:<br>
		 * 0x0.0x3B9AC9FF (0.99) : (0.999,999.999)<br>
		 * <br>
		 * Data type : unsigned short
+unsigne d
long
×48<br>
		 * <br>
		 * Data size : 194
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
		protected void onGetHistoricalDataOfMeasuredCumulativeGasConsumption(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Day setting for which the historical data of measured cumulative gas consumption is to be retrieved<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative gas consumption (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x63 (0.99)<br>
		 * 0: current day<br>
		 * 1.99: previous day.day that precedes the current day by 99 days<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDaySettingForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionIsToBeRetrieved(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Day setting for which the historical data of measured cumulative gas consumption is to be retrieved<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative gas consumption (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x63 (0.99)<br>
		 * 0: current day<br>
		 * 1.99: previous day.day that precedes the current day by 99 days<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDaySettingForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionIsToBeRetrieved(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Detection of abnormal value in metering data<br>
		 * <br>
		 * EPC : 0xE6<br>
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
		 */
		protected void onGetDetectionOfAbnormalValueInMeteringData(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Security data information<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Provides security information  about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * For details, refer to the explanations under (9).<br>
		 * <br>
		 * Data type : unsigned char
×10<br>
		 * <br>
		 * Data size : 10
bytes<br>
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
		 * Center has closed the valve: 0x41 Center has not closed the valve:<br>
		 * 0x42<br>
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
		 */
		protected void onGetValveClosureByTheCenter(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Permission from the Center to reopen the valve closed by the Center<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether permission has been given by the Center to reopen the gas shutoff valve of the meter closed by the Center.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Permission has been given by the Center to reopen the gas shutoff valve closed by the Center: 0x41<br>
		 * Permission to reopen the gas shutoff valve closed by the Center has not been given by the Center: 0x42<br>
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
byte<br>
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
		 * Shutoff valve open: 0x41 Shutoff valve closed: 0x42<br>
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
		 */
		protected void onGetShutoffValveStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Historical data of shutoff reasons<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the reasons for the 3 past shutoff valve-based gas shutoffs by means of bit assignment with one byte used for each of the 3 shutoff reasons.<br>
		 * Historical data3: Historical data2: Historical data 1<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFF: 0xFF: 0xFF<br>
		 * <br>
		 * Data type : unsigned char
×3<br>
		 * <br>
		 * Data size : 3
bytes<br>
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
		 * This property indicates the ID number of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 000000.FFFFFF<br>
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
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ID number of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 000000.FFFFFF<br>
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
		 * Property name : Verification expiration setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the month and year in which the verification of the meter will expire.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * YYYYMM<br>
		 * YYYY (Year), MM (Month)<br>
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
		protected void onSetVerificationExpirationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Verification expiration setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the month and year in which the verification of the meter will expire.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * YYYYMM<br>
		 * YYYY (Year), MM (Month)<br>
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
		protected void onGetVerificationExpirationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured cumulative gas consumption information with date and time<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the cumulative gas consumption and the date and time of measurement.<br>
		 * Date of measurement: YYYY:MM:DD<br>
		 * Time of measurement: HH:MM:SS<br>
		 * Cumulative gas consumption: 9 digits<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 1.4 bytes: 0.0x270f:1.0x0C:1.0x1F (=0.9999):(=1.12):(1.31)<br>
		 * 5.7 bytes: 0.0x17:0.0x3B:0.-0x3B (=0.23):(=0.59): (=0.59)<br>
		 * 8.11 bytes: 0x00000000.0x3B9AC9FF<br>
		 * (0.999,999,999)<br>
		 * <br>
		 * Data type : unsigne d char×4+
unsigne d char×3+
unsigne d long<br>
		 * <br>
		 * Data size : 11 bytes<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetMeasuredCumulativeGasConsumptionInformationWithDateAndTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Gas meter classification setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of the gas meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30: city gas 0x31: LP gas 0x32: natural gas 0x33: others<br>
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
		public Setter reqSetGasMeterClassificationSetting(byte[] edt) {
			reqSetProperty(EPC_GAS_METER_CLASSIFICATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Owner classification setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of owner of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30: not specified 0x31: city gas 0x32: LP gas<br>
		 * 0x33: private-sector company 0x34: individual<br>
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
		public Setter reqSetOwnerClassificationSetting(byte[] edt) {
			reqSetProperty(EPC_OWNER_CLASSIFICATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Day setting for which the historical data of measured cumulative gas consumption is to be retrieved<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative gas consumption (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x63 (0.99)<br>
		 * 0: current day<br>
		 * 1.99: previous day.day that precedes the current day by 99 days<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDaySettingForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionIsToBeRetrieved(byte[] edt) {
			reqSetProperty(EPC_DAY_SETTING_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTION_IS_TO_BE_RETRIEVED, edt);
			return this;
		}
		/**
		 * Property name : ID number setting<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ID number of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 000000.FFFFFF<br>
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
		 * Property name : Verification expiration setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the month and year in which the verification of the meter will expire.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * YYYYMM<br>
		 * YYYY (Year), MM (Month)<br>
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
		public Setter reqSetVerificationExpirationSetting(byte[] edt) {
			reqSetProperty(EPC_VERIFICATION_EXPIRATION_SETTING, edt);
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
		 * Property name : Gas meter classification setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of the gas meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30: city gas 0x31: LP gas 0x32: natural gas 0x33: others<br>
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
		public Getter reqGetGasMeterClassificationSetting() {
			reqGetProperty(EPC_GAS_METER_CLASSIFICATION_SETTING);
			return this;
		}
		/**
		 * Property name : Owner classification setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of owner of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30: not specified 0x31: city gas 0x32: LP gas<br>
		 * 0x33: private-sector company 0x34: individual<br>
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
		public Getter reqGetOwnerClassificationSetting() {
			reqGetProperty(EPC_OWNER_CLASSIFICATION_SETTING);
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
		 * 0.0x3B9AC9FF (0.999,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : 0.001
m3<br>
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
		 * Property name : Unit for measured cumulative gas consumption<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the unit (multiplying factor) for the measured cumulative gas consumption and the historical data of measured cumulative gas consumption.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00: 1m3<br>
		 * 0x01: 0.1m3<br>
		 * 0x02: 0.01m3<br>
		 * 0x03: 0.001m3<br>
		 * 0x04: 0.0001m3<br>
		 * 0x05: 0.00001m3<br>
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
		 * Get - optional<br>
		 */
		public Getter reqGetUnitForMeasuredCumulativeGasConsumption() {
			reqGetProperty(EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Historical data of measured cumulative gas consumption<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative gas consumption is to be retrieved and the historical data of measured cumulative gas consumption, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x0063:<br>
		 * 0x0.0x3B9AC9FF (0.99) : (0.999,999.999)<br>
		 * <br>
		 * Data type : unsigned short
+unsigne d
long
×48<br>
		 * <br>
		 * Data size : 194
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
		public Getter reqGetHistoricalDataOfMeasuredCumulativeGasConsumption() {
			reqGetProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Day setting for which the historical data of measured cumulative gas consumption is to be retrieved<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative gas consumption (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x63 (0.99)<br>
		 * 0: current day<br>
		 * 1.99: previous day.day that precedes the current day by 99 days<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDaySettingForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionIsToBeRetrieved() {
			reqGetProperty(EPC_DAY_SETTING_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTION_IS_TO_BE_RETRIEVED);
			return this;
		}
		/**
		 * Property name : Detection of abnormal value in metering data<br>
		 * <br>
		 * EPC : 0xE6<br>
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
		 * Provides security information  about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * For details, refer to the explanations under (9).<br>
		 * <br>
		 * Data type : unsigned char
×10<br>
		 * <br>
		 * Data size : 10
bytes<br>
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
		 * Center has closed the valve: 0x41 Center has not closed the valve:<br>
		 * 0x42<br>
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
		 */
		public Getter reqGetValveClosureByTheCenter() {
			reqGetProperty(EPC_VALVE_CLOSURE_BY_THE_CENTER);
			return this;
		}
		/**
		 * Property name : Permission from the Center to reopen the valve closed by the Center<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether permission has been given by the Center to reopen the gas shutoff valve of the meter closed by the Center.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Permission has been given by the Center to reopen the gas shutoff valve closed by the Center: 0x41<br>
		 * Permission to reopen the gas shutoff valve closed by the Center has not been given by the Center: 0x42<br>
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
byte<br>
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
		 * Shutoff valve open: 0x41 Shutoff valve closed: 0x42<br>
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
		 * Historical data3: Historical data2: Historical data 1<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFF: 0xFF: 0xFF<br>
		 * <br>
		 * Data type : unsigned char
×3<br>
		 * <br>
		 * Data size : 3
bytes<br>
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
		 * This property indicates the ID number of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 000000.FFFFFF<br>
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
		 * Property name : Verification expiration setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the month and year in which the verification of the meter will expire.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * YYYYMM<br>
		 * YYYY (Year), MM (Month)<br>
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
		public Getter reqGetVerificationExpirationSetting() {
			reqGetProperty(EPC_VERIFICATION_EXPIRATION_SETTING);
			return this;
		}
		/**
		 * Property name : Measured cumulative gas consumption information with date and time<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the cumulative gas consumption and the date and time of measurement.<br>
		 * Date of measurement: YYYY:MM:DD<br>
		 * Time of measurement: HH:MM:SS<br>
		 * Cumulative gas consumption: 9 digits<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 1.4 bytes: 0.0x270f:1.0x0C:1.0x1F (=0.9999):(=1.12):(1.31)<br>
		 * 5.7 bytes: 0.0x17:0.0x3B:0.-0x3B (=0.23):(=0.59): (=0.59)<br>
		 * 8.11 bytes: 0x00000000.0x3B9AC9FF<br>
		 * (0.999,999,999)<br>
		 * <br>
		 * Data type : unsigne d char×4+
unsigne d char×3+
unsigne d long<br>
		 * <br>
		 * Data size : 11 bytes<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetMeasuredCumulativeGasConsumptionInformationWithDateAndTime() {
			reqGetProperty(EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION_INFORMATION_WITH_DATE_AND_TIME);
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
		 * Property name : Gas meter classification setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of the gas meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30: city gas 0x31: LP gas 0x32: natural gas 0x33: others<br>
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
		public Informer reqInformGasMeterClassificationSetting() {
			reqInformProperty(EPC_GAS_METER_CLASSIFICATION_SETTING);
			return this;
		}
		/**
		 * Property name : Owner classification setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of owner of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30: not specified 0x31: city gas 0x32: LP gas<br>
		 * 0x33: private-sector company 0x34: individual<br>
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
		public Informer reqInformOwnerClassificationSetting() {
			reqInformProperty(EPC_OWNER_CLASSIFICATION_SETTING);
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
		 * 0.0x3B9AC9FF (0.999,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : 0.001
m3<br>
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
		 * Property name : Unit for measured cumulative gas consumption<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the unit (multiplying factor) for the measured cumulative gas consumption and the historical data of measured cumulative gas consumption.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00: 1m3<br>
		 * 0x01: 0.1m3<br>
		 * 0x02: 0.01m3<br>
		 * 0x03: 0.001m3<br>
		 * 0x04: 0.0001m3<br>
		 * 0x05: 0.00001m3<br>
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
		 * Get - optional<br>
		 */
		public Informer reqInformUnitForMeasuredCumulativeGasConsumption() {
			reqInformProperty(EPC_UNIT_FOR_MEASURED_CUMULATIVE_GAS_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Historical data of measured cumulative gas consumption<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative gas consumption is to be retrieved and the historical data of measured cumulative gas consumption, which consists of 48 pieces of half-hourly data for the preceding 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x0063:<br>
		 * 0x0.0x3B9AC9FF (0.99) : (0.999,999.999)<br>
		 * <br>
		 * Data type : unsigned short
+unsigne d
long
×48<br>
		 * <br>
		 * Data size : 194
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
		public Informer reqInformHistoricalDataOfMeasuredCumulativeGasConsumption() {
			reqInformProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Day setting for which the historical data of measured cumulative gas consumption is to be retrieved<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative gas consumption (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x63 (0.99)<br>
		 * 0: current day<br>
		 * 1.99: previous day.day that precedes the current day by 99 days<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDaySettingForWhichTheHistoricalDataOfMeasuredCumulativeGasConsumptionIsToBeRetrieved() {
			reqInformProperty(EPC_DAY_SETTING_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_GAS_CONSUMPTION_IS_TO_BE_RETRIEVED);
			return this;
		}
		/**
		 * Property name : Detection of abnormal value in metering data<br>
		 * <br>
		 * EPC : 0xE6<br>
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
		 * Provides security information  about the abnormal states detected by the meter in the form of security data that identifies the abnormal states by means of bit assignment.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * For details, refer to the explanations under (9).<br>
		 * <br>
		 * Data type : unsigned char
×10<br>
		 * <br>
		 * Data size : 10
bytes<br>
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
		 * Center has closed the valve: 0x41 Center has not closed the valve:<br>
		 * 0x42<br>
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
		 */
		public Informer reqInformValveClosureByTheCenter() {
			reqInformProperty(EPC_VALVE_CLOSURE_BY_THE_CENTER);
			return this;
		}
		/**
		 * Property name : Permission from the Center to reopen the valve closed by the Center<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether permission has been given by the Center to reopen the gas shutoff valve of the meter closed by the Center.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Permission has been given by the Center to reopen the gas shutoff valve closed by the Center: 0x41<br>
		 * Permission to reopen the gas shutoff valve closed by the Center has not been given by the Center: 0x42<br>
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
byte<br>
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
		 * Shutoff valve open: 0x41 Shutoff valve closed: 0x42<br>
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
		 * Historical data3: Historical data2: Historical data 1<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFF: 0xFF: 0xFF<br>
		 * <br>
		 * Data type : unsigned char
×3<br>
		 * <br>
		 * Data size : 3
bytes<br>
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
		 * This property indicates the ID number of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 000000.FFFFFF<br>
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
		 * Property name : Verification expiration setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the month and year in which the verification of the meter will expire.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * YYYYMM<br>
		 * YYYY (Year), MM (Month)<br>
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
		public Informer reqInformVerificationExpirationSetting() {
			reqInformProperty(EPC_VERIFICATION_EXPIRATION_SETTING);
			return this;
		}
		/**
		 * Property name : Measured cumulative gas consumption information with date and time<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the cumulative gas consumption and the date and time of measurement.<br>
		 * Date of measurement: YYYY:MM:DD<br>
		 * Time of measurement: HH:MM:SS<br>
		 * Cumulative gas consumption: 9 digits<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 1.4 bytes: 0.0x270f:1.0x0C:1.0x1F (=0.9999):(=1.12):(1.31)<br>
		 * 5.7 bytes: 0.0x17:0.0x3B:0.-0x3B (=0.23):(=0.59): (=0.59)<br>
		 * 8.11 bytes: 0x00000000.0x3B9AC9FF<br>
		 * (0.999,999,999)<br>
		 * <br>
		 * Data type : unsigne d char×4+
unsigne d char×3+
unsigne d long<br>
		 * <br>
		 * Data size : 11 bytes<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformMeasuredCumulativeGasConsumptionInformationWithDateAndTime() {
			reqInformProperty(EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION_INFORMATION_WITH_DATE_AND_TIME);
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
		protected byte[] getMeasuredCumulativeGasConsumptionInformationWithDateAndTime() {return null;}
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
