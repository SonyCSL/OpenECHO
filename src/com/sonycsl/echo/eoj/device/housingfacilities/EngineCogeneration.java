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

public abstract class EngineCogeneration extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x027F;

	public static final byte EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER = (byte)0xC1;
	public static final byte EPC_RATED_POWER_GENERATION_OUTPUT = (byte)0xC2;
	public static final byte EPC_HEATING_VALUE_OF_HOT_WATER_STORAGE_TANK = (byte)0xC3;
	public static final byte EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT = (byte)0xC4;
	public static final byte EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT = (byte)0xC5;
	public static final byte EPC_CUMULATIVE_POWER_GENERATION_OUTPUT_RESET_SETTING = (byte)0xC6;
	public static final byte EPC_MEASURED_INSTANTANEOUS_GAS_CONSUMPTION = (byte)0xC7;
	public static final byte EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION = (byte)0xC8;
	public static final byte EPC_CUMULATIVE_GAS_CONSUMPTION_RESET_SETTING = (byte)0xC9;
	public static final byte EPC_POWER_GENERATION_SETTING = (byte)0xCA;
	public static final byte EPC_POWER_GENERATION_STATUS = (byte)0xCB;
	public static final byte EPC_MEASURED_IN_HOUSE_INSTANTANEOUS_POWER_CONSUMPTION = (byte)0xCC;
	public static final byte EPC_MEASURED_IN_HOUSE_CUMULATIVE_POWER_CONSUMPTION = (byte)0xCD;
	public static final byte EPC_IN_HOUSE_CUMULATIVE_POWER_CONSUMPTION_RESET = (byte)0xCE;
	public static final byte EPC_SYSTEM_INTERCONNECTED_TYPE = (byte)0xD0;
	public static final byte EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT = (byte)0xE1;
	public static final byte EPC_TANK_CAPACITY = (byte)0xE2;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT);
		addGetProperty(EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewEngineCogeneration(this);
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
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
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
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
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
	 * Property name : Measured temperature of water in water heater<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the current temperature of the water in the water heater in ℃.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00–0x64 (0–100℃)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : ℃<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredTemperatureOfWaterInWaterHeater() {return null;}
	/**
	 * Property name : Measured temperature of water in water heater<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the current temperature of the water in the water heater in ℃.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00–0x64 (0–100℃)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : ℃<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredTemperatureOfWaterInWaterHeater(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Rated power generation output<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated power generation output in watts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0xFFFD (0–65,533W)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getRatedPowerGenerationOutput() {return null;}
	/**
	 * Property name : Rated power generation output<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated power generation output in watts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0xFFFD (0–65,533W)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRatedPowerGenerationOutput(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Heating value of hot water storage tank<br>
	 * <br>
	 * EPC : 0xC3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the heating value of the hot water storage tank in MJ.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0xFFFD (0–65,533MJ)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : MJ<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getHeatingValueOfHotWaterStorageTank() {return null;}
	/**
	 * Property name : Heating value of hot water storage tank<br>
	 * <br>
	 * EPC : 0xC3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the heating value of the hot water storage tank in MJ.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0xFFFD (0–65,533MJ)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : MJ<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidHeatingValueOfHotWaterStorageTank(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Measured instantaneous power generation output<br>
	 * <br>
	 * EPC : 0xC4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the instantaneous power generation output in watts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0xFFFD (0–65,533W)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getMeasuredInstantaneousPowerGenerationOutput();
	/**
	 * Property name : Measured instantaneous power generation output<br>
	 * <br>
	 * EPC : 0xC4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the instantaneous power generation output in watts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0xFFFD (0–65,533W)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidMeasuredInstantaneousPowerGenerationOutput(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Measured cumulative power generation output<br>
	 * <br>
	 * EPC : 0xC5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the cumulative power generation output in increments of 0.001kWh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000–0x3B9AC9FF (0–999,999.999kWh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.001 kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getMeasuredCumulativePowerGenerationOutput();
	/**
	 * Property name : Measured cumulative power generation output<br>
	 * <br>
	 * EPC : 0xC5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the cumulative power generation output in increments of 0.001kWh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000–0x3B9AC9FF (0–999,999.999kWh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.001 kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidMeasuredCumulativePowerGenerationOutput(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Cumulative power generation output reset setting<br>
	 * <br>
	 * EPC : 0xC6<br>
	 * <br>
	 * Contents of property :<br>
	 * Resets the cumulative power generation output by writing 0x00.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset=0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - undefined<br>
	 */
	protected boolean setCumulativePowerGenerationOutputResetSetting(byte[] edt) {return false;}
	/**
	 * Property name : Cumulative power generation output reset setting<br>
	 * <br>
	 * EPC : 0xC6<br>
	 * <br>
	 * Contents of property :<br>
	 * Resets the cumulative power generation output by writing 0x00.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset=0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - undefined<br>
	 */
	protected boolean isValidCumulativePowerGenerationOutputResetSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured instantaneous gas consumption<br>
	 * <br>
	 * EPC : 0xC7<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the instantaneous gas consumption in increments of 0.001m3/h.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0xFFFD (0–65.533m3/h)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.001 m3/h<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredInstantaneousGasConsumption() {return null;}
	/**
	 * Property name : Measured instantaneous gas consumption<br>
	 * <br>
	 * EPC : 0xC7<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the instantaneous gas consumption in increments of 0.001m3/h.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0xFFFD (0–65.533m3/h)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.001 m3/h<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredInstantaneousGasConsumption(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Measured cumulative gas consumption<br>
	 * <br>
	 * EPC : 0xC8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the cumulative gas consumption in increments of 0.001m3.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000–0x3B9AC9FF (0–999,999.999m3)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.001 m3<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredCumulativeGasConsumption() {return null;}
	/**
	 * Property name : Measured cumulative gas consumption<br>
	 * <br>
	 * EPC : 0xC8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the cumulative gas consumption in increments of 0.001m3.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000–0x3B9AC9FF (0–999,999.999m3)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.001 m3<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredCumulativeGasConsumption(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Cumulative gas consumption reset setting<br>
	 * <br>
	 * EPC : 0xC9<br>
	 * <br>
	 * Contents of property :<br>
	 * Resets the cumulative gas consumption by writing 0x00.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset=0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - undefined<br>
	 */
	protected boolean setCumulativeGasConsumptionResetSetting(byte[] edt) {return false;}
	/**
	 * Property name : Cumulative gas consumption reset setting<br>
	 * <br>
	 * EPC : 0xC9<br>
	 * <br>
	 * Contents of property :<br>
	 * Resets the cumulative gas consumption by writing 0x00.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset=0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - undefined<br>
	 */
	protected boolean isValidCumulativeGasConsumptionResetSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Power generation setting
<br>
	 * <br>
	 * EPC : 0xCA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property instructs the start or stop of power generation.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Power generation ON=0x41, Power generation OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - undefined<br>
	 */
	protected boolean setPowerGenerationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Power generation setting
<br>
	 * <br>
	 * EPC : 0xCA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property instructs the start or stop of power generation.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Power generation ON=0x41, Power generation OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - undefined<br>
	 */
	protected boolean isValidPowerGenerationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Power generation status<br>
	 * <br>
	 * EPC : 0xCB<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates power generation status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * generating =0x41, stopped=0x42, idling=0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getPowerGenerationStatus() {return null;}
	/**
	 * Property name : Power generation status<br>
	 * <br>
	 * EPC : 0xCB<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates power generation status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * generating =0x41, stopped=0x42, idling=0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidPowerGenerationStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured in-house instantaneous power consumption<br>
	 * <br>
	 * EPC : 0xCC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured in-house instantaneous power consumption in watts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0xFFFD (0-65.533W)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredInHouseInstantaneousPowerConsumption() {return null;}
	/**
	 * Property name : Measured in-house instantaneous power consumption<br>
	 * <br>
	 * EPC : 0xCC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured in-house instantaneous power consumption in watts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0xFFFD (0-65.533W)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredInHouseInstantaneousPowerConsumption(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Measured in-house cumulative power consumption<br>
	 * <br>
	 * EPC : 0xCD<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured in-house cumulative power consumption in0.001kWh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000-0x3B9AC9FF (0-999,999.999kWh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.001 kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredInHouseCumulativePowerConsumption() {return null;}
	/**
	 * Property name : Measured in-house cumulative power consumption<br>
	 * <br>
	 * EPC : 0xCD<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured in-house cumulative power consumption in0.001kWh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000-0x3B9AC9FF (0-999,999.999kWh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.001 kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredInHouseCumulativePowerConsumption(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : In-house cumulative power consumption reset<br>
	 * <br>
	 * EPC : 0xCE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property is set to 0x00 to reset the in-house cumulative power consumption.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset=0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - undefined<br>
	 */
	protected boolean setInHouseCumulativePowerConsumptionReset(byte[] edt) {return false;}
	/**
	 * Property name : In-house cumulative power consumption reset<br>
	 * <br>
	 * EPC : 0xCE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property is set to 0x00 to reset the in-house cumulative power consumption.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset=0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - undefined<br>
	 */
	protected boolean isValidInHouseCumulativePowerConsumptionReset(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : System interconnected type<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the system interconnected type.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * System-interconnected type (reverse power flow acceptable)=0x00, Independent type=0x01, System-interconnected type(reverse power flow not acceptable)=0x02<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getSystemInterconnectedType() {return null;}
	/**
	 * Property name : System interconnected type<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the system interconnected type.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * System-interconnected type (reverse power flow acceptable)=0x00, Independent type=0x01, System-interconnected type(reverse power flow not acceptable)=0x02<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSystemInterconnectedType(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured remaining hot water amount<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured amount of the remaining hot water in liters.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0xFFFD (0–65,533 liters)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredRemainingHotWaterAmount() {return null;}
	/**
	 * Property name : Measured remaining hot water amount<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured amount of the remaining hot water in liters.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0xFFFD (0–65,533 liters)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredRemainingHotWaterAmount(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Tank capacity<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the tank capacity in liters.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0xFFFD (0–65,533 liters)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getTankCapacity() {return null;}
	/**
	 * Property name : Tank capacity<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the tank capacity in liters.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0xFFFD (0–65,533 liters)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidTankCapacity(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_CUMULATIVE_POWER_GENERATION_OUTPUT_RESET_SETTING : return setCumulativePowerGenerationOutputResetSetting(property.edt);
		case EPC_CUMULATIVE_GAS_CONSUMPTION_RESET_SETTING : return setCumulativeGasConsumptionResetSetting(property.edt);
		case EPC_POWER_GENERATION_SETTING : return setPowerGenerationSetting(property.edt);
		case EPC_IN_HOUSE_CUMULATIVE_POWER_CONSUMPTION_RESET : return setInHouseCumulativePowerConsumptionReset(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER : return getMeasuredTemperatureOfWaterInWaterHeater();
		case EPC_RATED_POWER_GENERATION_OUTPUT : return getRatedPowerGenerationOutput();
		case EPC_HEATING_VALUE_OF_HOT_WATER_STORAGE_TANK : return getHeatingValueOfHotWaterStorageTank();
		case EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT : return getMeasuredInstantaneousPowerGenerationOutput();
		case EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT : return getMeasuredCumulativePowerGenerationOutput();
		case EPC_MEASURED_INSTANTANEOUS_GAS_CONSUMPTION : return getMeasuredInstantaneousGasConsumption();
		case EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION : return getMeasuredCumulativeGasConsumption();
		case EPC_POWER_GENERATION_STATUS : return getPowerGenerationStatus();
		case EPC_MEASURED_IN_HOUSE_INSTANTANEOUS_POWER_CONSUMPTION : return getMeasuredInHouseInstantaneousPowerConsumption();
		case EPC_MEASURED_IN_HOUSE_CUMULATIVE_POWER_CONSUMPTION : return getMeasuredInHouseCumulativePowerConsumption();
		case EPC_SYSTEM_INTERCONNECTED_TYPE : return getSystemInterconnectedType();
		case EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT : return getMeasuredRemainingHotWaterAmount();
		case EPC_TANK_CAPACITY : return getTankCapacity();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER : return isValidMeasuredTemperatureOfWaterInWaterHeater(property.edt);
		case EPC_RATED_POWER_GENERATION_OUTPUT : return isValidRatedPowerGenerationOutput(property.edt);
		case EPC_HEATING_VALUE_OF_HOT_WATER_STORAGE_TANK : return isValidHeatingValueOfHotWaterStorageTank(property.edt);
		case EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT : return isValidMeasuredInstantaneousPowerGenerationOutput(property.edt);
		case EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT : return isValidMeasuredCumulativePowerGenerationOutput(property.edt);
		case EPC_CUMULATIVE_POWER_GENERATION_OUTPUT_RESET_SETTING : return isValidCumulativePowerGenerationOutputResetSetting(property.edt);
		case EPC_MEASURED_INSTANTANEOUS_GAS_CONSUMPTION : return isValidMeasuredInstantaneousGasConsumption(property.edt);
		case EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION : return isValidMeasuredCumulativeGasConsumption(property.edt);
		case EPC_CUMULATIVE_GAS_CONSUMPTION_RESET_SETTING : return isValidCumulativeGasConsumptionResetSetting(property.edt);
		case EPC_POWER_GENERATION_SETTING : return isValidPowerGenerationSetting(property.edt);
		case EPC_POWER_GENERATION_STATUS : return isValidPowerGenerationStatus(property.edt);
		case EPC_MEASURED_IN_HOUSE_INSTANTANEOUS_POWER_CONSUMPTION : return isValidMeasuredInHouseInstantaneousPowerConsumption(property.edt);
		case EPC_MEASURED_IN_HOUSE_CUMULATIVE_POWER_CONSUMPTION : return isValidMeasuredInHouseCumulativePowerConsumption(property.edt);
		case EPC_IN_HOUSE_CUMULATIVE_POWER_CONSUMPTION_RESET : return isValidInHouseCumulativePowerConsumptionReset(property.edt);
		case EPC_SYSTEM_INTERCONNECTED_TYPE : return isValidSystemInterconnectedType(property.edt);
		case EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT : return isValidMeasuredRemainingHotWaterAmount(property.edt);
		case EPC_TANK_CAPACITY : return isValidTankCapacity(property.edt);
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
			case EPC_CUMULATIVE_POWER_GENERATION_OUTPUT_RESET_SETTING : 
				onSetCumulativePowerGenerationOutputResetSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CUMULATIVE_GAS_CONSUMPTION_RESET_SETTING : 
				onSetCumulativeGasConsumptionResetSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_POWER_GENERATION_SETTING : 
				onSetPowerGenerationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_IN_HOUSE_CUMULATIVE_POWER_CONSUMPTION_RESET : 
				onSetInHouseCumulativePowerConsumptionReset(eoj, tid, esv, property, success);
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
			case EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER : 
				onGetMeasuredTemperatureOfWaterInWaterHeater(eoj, tid, esv, property, success);
				return true;
			case EPC_RATED_POWER_GENERATION_OUTPUT : 
				onGetRatedPowerGenerationOutput(eoj, tid, esv, property, success);
				return true;
			case EPC_HEATING_VALUE_OF_HOT_WATER_STORAGE_TANK : 
				onGetHeatingValueOfHotWaterStorageTank(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT : 
				onGetMeasuredInstantaneousPowerGenerationOutput(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT : 
				onGetMeasuredCumulativePowerGenerationOutput(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INSTANTANEOUS_GAS_CONSUMPTION : 
				onGetMeasuredInstantaneousGasConsumption(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION : 
				onGetMeasuredCumulativeGasConsumption(eoj, tid, esv, property, success);
				return true;
			case EPC_POWER_GENERATION_STATUS : 
				onGetPowerGenerationStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_IN_HOUSE_INSTANTANEOUS_POWER_CONSUMPTION : 
				onGetMeasuredInHouseInstantaneousPowerConsumption(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_IN_HOUSE_CUMULATIVE_POWER_CONSUMPTION : 
				onGetMeasuredInHouseCumulativePowerConsumption(eoj, tid, esv, property, success);
				return true;
			case EPC_SYSTEM_INTERCONNECTED_TYPE : 
				onGetSystemInterconnectedType(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT : 
				onGetMeasuredRemainingHotWaterAmount(eoj, tid, esv, property, success);
				return true;
			case EPC_TANK_CAPACITY : 
				onGetTankCapacity(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Measured temperature of water in water heater<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the current temperature of the water in the water heater in ℃.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00–0x64 (0–100℃)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : ℃<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredTemperatureOfWaterInWaterHeater(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rated power generation output<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power generation output in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533W)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetRatedPowerGenerationOutput(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Heating value of hot water storage tank<br>
		 * <br>
		 * EPC : 0xC3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the heating value of the hot water storage tank in MJ.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533MJ)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : MJ<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetHeatingValueOfHotWaterStorageTank(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured instantaneous power generation output<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the instantaneous power generation output in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533W)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetMeasuredInstantaneousPowerGenerationOutput(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured cumulative power generation output<br>
		 * <br>
		 * EPC : 0xC5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the cumulative power generation output in increments of 0.001kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000–0x3B9AC9FF (0–999,999.999kWh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001 kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetMeasuredCumulativePowerGenerationOutput(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Cumulative power generation output reset setting<br>
		 * <br>
		 * EPC : 0xC6<br>
		 * <br>
		 * Contents of property :<br>
		 * Resets the cumulative power generation output by writing 0x00.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset=0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - undefined<br>
		 */
		protected void onSetCumulativePowerGenerationOutputResetSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured instantaneous gas consumption<br>
		 * <br>
		 * EPC : 0xC7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the instantaneous gas consumption in increments of 0.001m3/h.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65.533m3/h)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.001 m3/h<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredInstantaneousGasConsumption(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured cumulative gas consumption<br>
		 * <br>
		 * EPC : 0xC8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the cumulative gas consumption in increments of 0.001m3.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000–0x3B9AC9FF (0–999,999.999m3)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001 m3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredCumulativeGasConsumption(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Cumulative gas consumption reset setting<br>
		 * <br>
		 * EPC : 0xC9<br>
		 * <br>
		 * Contents of property :<br>
		 * Resets the cumulative gas consumption by writing 0x00.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset=0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - undefined<br>
		 */
		protected void onSetCumulativeGasConsumptionResetSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Power generation setting
<br>
		 * <br>
		 * EPC : 0xCA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property instructs the start or stop of power generation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Power generation ON=0x41, Power generation OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - undefined<br>
		 */
		protected void onSetPowerGenerationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Power generation status<br>
		 * <br>
		 * EPC : 0xCB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates power generation status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * generating =0x41, stopped=0x42, idling=0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetPowerGenerationStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured in-house instantaneous power consumption<br>
		 * <br>
		 * EPC : 0xCC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured in-house instantaneous power consumption in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0xFFFD (0-65.533W)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredInHouseInstantaneousPowerConsumption(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured in-house cumulative power consumption<br>
		 * <br>
		 * EPC : 0xCD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured in-house cumulative power consumption in0.001kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x3B9AC9FF (0-999,999.999kWh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001 kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredInHouseCumulativePowerConsumption(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : In-house cumulative power consumption reset<br>
		 * <br>
		 * EPC : 0xCE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property is set to 0x00 to reset the in-house cumulative power consumption.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset=0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - undefined<br>
		 */
		protected void onSetInHouseCumulativePowerConsumptionReset(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : System interconnected type<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the system interconnected type.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * System-interconnected type (reverse power flow acceptable)=0x00, Independent type=0x01, System-interconnected type(reverse power flow not acceptable)=0x02<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetSystemInterconnectedType(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured remaining hot water amount<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured amount of the remaining hot water in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredRemainingHotWaterAmount(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Tank capacity<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the tank capacity in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetTankCapacity(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Cumulative power generation output reset setting<br>
		 * <br>
		 * EPC : 0xC6<br>
		 * <br>
		 * Contents of property :<br>
		 * Resets the cumulative power generation output by writing 0x00.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset=0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - undefined<br>
		 */
		public Setter reqSetCumulativePowerGenerationOutputResetSetting(byte[] edt) {
			reqSetProperty(EPC_CUMULATIVE_POWER_GENERATION_OUTPUT_RESET_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Cumulative gas consumption reset setting<br>
		 * <br>
		 * EPC : 0xC9<br>
		 * <br>
		 * Contents of property :<br>
		 * Resets the cumulative gas consumption by writing 0x00.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset=0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - undefined<br>
		 */
		public Setter reqSetCumulativeGasConsumptionResetSetting(byte[] edt) {
			reqSetProperty(EPC_CUMULATIVE_GAS_CONSUMPTION_RESET_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Power generation setting
<br>
		 * <br>
		 * EPC : 0xCA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property instructs the start or stop of power generation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Power generation ON=0x41, Power generation OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - undefined<br>
		 */
		public Setter reqSetPowerGenerationSetting(byte[] edt) {
			reqSetProperty(EPC_POWER_GENERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : In-house cumulative power consumption reset<br>
		 * <br>
		 * EPC : 0xCE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property is set to 0x00 to reset the in-house cumulative power consumption.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset=0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - undefined<br>
		 */
		public Setter reqSetInHouseCumulativePowerConsumptionReset(byte[] edt) {
			reqSetProperty(EPC_IN_HOUSE_CUMULATIVE_POWER_CONSUMPTION_RESET, edt);
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
		 * Property name : Measured temperature of water in water heater<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the current temperature of the water in the water heater in ℃.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00–0x64 (0–100℃)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : ℃<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredTemperatureOfWaterInWaterHeater() {
			reqGetProperty(EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER);
			return this;
		}
		/**
		 * Property name : Rated power generation output<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power generation output in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533W)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRatedPowerGenerationOutput() {
			reqGetProperty(EPC_RATED_POWER_GENERATION_OUTPUT);
			return this;
		}
		/**
		 * Property name : Heating value of hot water storage tank<br>
		 * <br>
		 * EPC : 0xC3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the heating value of the hot water storage tank in MJ.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533MJ)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : MJ<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetHeatingValueOfHotWaterStorageTank() {
			reqGetProperty(EPC_HEATING_VALUE_OF_HOT_WATER_STORAGE_TANK);
			return this;
		}
		/**
		 * Property name : Measured instantaneous power generation output<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the instantaneous power generation output in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533W)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetMeasuredInstantaneousPowerGenerationOutput() {
			reqGetProperty(EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT);
			return this;
		}
		/**
		 * Property name : Measured cumulative power generation output<br>
		 * <br>
		 * EPC : 0xC5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the cumulative power generation output in increments of 0.001kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000–0x3B9AC9FF (0–999,999.999kWh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001 kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetMeasuredCumulativePowerGenerationOutput() {
			reqGetProperty(EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT);
			return this;
		}
		/**
		 * Property name : Measured instantaneous gas consumption<br>
		 * <br>
		 * EPC : 0xC7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the instantaneous gas consumption in increments of 0.001m3/h.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65.533m3/h)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.001 m3/h<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredInstantaneousGasConsumption() {
			reqGetProperty(EPC_MEASURED_INSTANTANEOUS_GAS_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Measured cumulative gas consumption<br>
		 * <br>
		 * EPC : 0xC8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the cumulative gas consumption in increments of 0.001m3.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000–0x3B9AC9FF (0–999,999.999m3)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001 m3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredCumulativeGasConsumption() {
			reqGetProperty(EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Power generation status<br>
		 * <br>
		 * EPC : 0xCB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates power generation status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * generating =0x41, stopped=0x42, idling=0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetPowerGenerationStatus() {
			reqGetProperty(EPC_POWER_GENERATION_STATUS);
			return this;
		}
		/**
		 * Property name : Measured in-house instantaneous power consumption<br>
		 * <br>
		 * EPC : 0xCC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured in-house instantaneous power consumption in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0xFFFD (0-65.533W)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredInHouseInstantaneousPowerConsumption() {
			reqGetProperty(EPC_MEASURED_IN_HOUSE_INSTANTANEOUS_POWER_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Measured in-house cumulative power consumption<br>
		 * <br>
		 * EPC : 0xCD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured in-house cumulative power consumption in0.001kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x3B9AC9FF (0-999,999.999kWh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001 kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredInHouseCumulativePowerConsumption() {
			reqGetProperty(EPC_MEASURED_IN_HOUSE_CUMULATIVE_POWER_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : System interconnected type<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the system interconnected type.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * System-interconnected type (reverse power flow acceptable)=0x00, Independent type=0x01, System-interconnected type(reverse power flow not acceptable)=0x02<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSystemInterconnectedType() {
			reqGetProperty(EPC_SYSTEM_INTERCONNECTED_TYPE);
			return this;
		}
		/**
		 * Property name : Measured remaining hot water amount<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured amount of the remaining hot water in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredRemainingHotWaterAmount() {
			reqGetProperty(EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT);
			return this;
		}
		/**
		 * Property name : Tank capacity<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the tank capacity in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetTankCapacity() {
			reqGetProperty(EPC_TANK_CAPACITY);
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
		 * Property name : Measured temperature of water in water heater<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the current temperature of the water in the water heater in ℃.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00–0x64 (0–100℃)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : ℃<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredTemperatureOfWaterInWaterHeater() {
			reqInformProperty(EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER);
			return this;
		}
		/**
		 * Property name : Rated power generation output<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power generation output in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533W)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRatedPowerGenerationOutput() {
			reqInformProperty(EPC_RATED_POWER_GENERATION_OUTPUT);
			return this;
		}
		/**
		 * Property name : Heating value of hot water storage tank<br>
		 * <br>
		 * EPC : 0xC3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the heating value of the hot water storage tank in MJ.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533MJ)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : MJ<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformHeatingValueOfHotWaterStorageTank() {
			reqInformProperty(EPC_HEATING_VALUE_OF_HOT_WATER_STORAGE_TANK);
			return this;
		}
		/**
		 * Property name : Measured instantaneous power generation output<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the instantaneous power generation output in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533W)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformMeasuredInstantaneousPowerGenerationOutput() {
			reqInformProperty(EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT);
			return this;
		}
		/**
		 * Property name : Measured cumulative power generation output<br>
		 * <br>
		 * EPC : 0xC5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the cumulative power generation output in increments of 0.001kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000–0x3B9AC9FF (0–999,999.999kWh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001 kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformMeasuredCumulativePowerGenerationOutput() {
			reqInformProperty(EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT);
			return this;
		}
		/**
		 * Property name : Measured instantaneous gas consumption<br>
		 * <br>
		 * EPC : 0xC7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the instantaneous gas consumption in increments of 0.001m3/h.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65.533m3/h)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.001 m3/h<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredInstantaneousGasConsumption() {
			reqInformProperty(EPC_MEASURED_INSTANTANEOUS_GAS_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Measured cumulative gas consumption<br>
		 * <br>
		 * EPC : 0xC8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the cumulative gas consumption in increments of 0.001m3.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000–0x3B9AC9FF (0–999,999.999m3)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001 m3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredCumulativeGasConsumption() {
			reqInformProperty(EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Power generation status<br>
		 * <br>
		 * EPC : 0xCB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates power generation status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * generating =0x41, stopped=0x42, idling=0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformPowerGenerationStatus() {
			reqInformProperty(EPC_POWER_GENERATION_STATUS);
			return this;
		}
		/**
		 * Property name : Measured in-house instantaneous power consumption<br>
		 * <br>
		 * EPC : 0xCC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured in-house instantaneous power consumption in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0xFFFD (0-65.533W)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredInHouseInstantaneousPowerConsumption() {
			reqInformProperty(EPC_MEASURED_IN_HOUSE_INSTANTANEOUS_POWER_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Measured in-house cumulative power consumption<br>
		 * <br>
		 * EPC : 0xCD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured in-house cumulative power consumption in0.001kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x3B9AC9FF (0-999,999.999kWh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001 kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredInHouseCumulativePowerConsumption() {
			reqInformProperty(EPC_MEASURED_IN_HOUSE_CUMULATIVE_POWER_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : System interconnected type<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the system interconnected type.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * System-interconnected type (reverse power flow acceptable)=0x00, Independent type=0x01, System-interconnected type(reverse power flow not acceptable)=0x02<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSystemInterconnectedType() {
			reqInformProperty(EPC_SYSTEM_INTERCONNECTED_TYPE);
			return this;
		}
		/**
		 * Property name : Measured remaining hot water amount<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured amount of the remaining hot water in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredRemainingHotWaterAmount() {
			reqInformProperty(EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT);
			return this;
		}
		/**
		 * Property name : Tank capacity<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the tank capacity in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformTankCapacity() {
			reqInformProperty(EPC_TANK_CAPACITY);
			return this;
		}
	}

	public static class Proxy extends EngineCogeneration {
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
		protected byte[] getMeasuredInstantaneousPowerGenerationOutput() {return null;}
		@Override
		protected byte[] getMeasuredCumulativePowerGenerationOutput() {return null;}
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
