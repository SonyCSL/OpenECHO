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
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class FuelCell extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x027C;

	public static final byte EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE = (byte)0xB1;
	public static final byte EPC_HEATING_STATUS = (byte)0xB2;
	public static final byte EPC_HEATED_WATER_TEMPERATURE_SETTING = (byte)0xB3;
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
	public static final byte EPC_BATH_WATER_REHEATING = (byte)0xE4;
	public static final byte EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING = (byte)0xD1;
	public static final byte EPC_BATH_WATER_TEMPERATURE_SETTING = (byte)0xD3;
	public static final byte EPC_HEATED_BATH_WATER_AMOUNT_SETTING = (byte)0xE0;
	public static final byte EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT = (byte)0xE1;
	public static final byte EPC_TANK_CAPACITY = (byte)0xE2;
	public static final byte EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING = (byte)0xE3;
	public static final byte EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING = (byte)0xE5;
	public static final byte EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING = (byte)0xE6;
	public static final byte EPC_BATH_WATER_AMOUNT_SETTING2 = (byte)0xE8;
	public static final byte EPC_BATH_WATER_AMOUNT_SETTING3 = (byte)0xEE;
	public static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_ON_TIMER_SETTING = (byte)0x91;

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
	public void initialize(EchoNode node) {
		super.initialize(node);
		Echo.EventListener listener = Echo.getEventListener();
		if(listener != null) listener.onNewFuelCell(this);
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
	 * This property indicates the ON/OFF<br>
	 * status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30 COFF=0x31<br>
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
	 * This property indicates the ON/OFF<br>
	 * status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30 COFF=0x31<br>
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
	 * Property name : Automatic setting of heated water temperature<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * AUTO/Non-AUTO<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * AUTO  0x41 CNon-AUTO  0x42<br>
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
	protected boolean setAutomaticSettingOfHeatedWaterTemperature(byte[] edt) {return false;}
	/**
	 * Property name : Automatic setting of heated water temperature<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * AUTO/Non-AUTO<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * AUTO  0x41 CNon-AUTO  0x42<br>
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
	protected byte[] getAutomaticSettingOfHeatedWaterTemperature() {return null;}
	/**
	 * Property name : Automatic setting of heated water temperature<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * AUTO/Non-AUTO<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * AUTO  0x41 CNon-AUTO  0x42<br>
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
	protected boolean isValidAutomaticSettingOfHeatedWaterTemperature(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Heating status<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether the water is being heated.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Being heated  0x41 C<br>
	 * Not being heated  0x42<br>
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
	protected byte[] getHeatingStatus() {return null;}
	/**
	 * Property name : Heating status<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether the water is being heated.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Being heated  0x41 C<br>
	 * Not being heated  0x42<br>
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
	protected boolean isValidHeatingStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Heated water temperature setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the heated water temperature setting in   .<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x64 (0-100  )<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit :   <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setHeatedWaterTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Property name : Heated water temperature setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the heated water temperature setting in   .<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x64 (0-100  )<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit :   <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getHeatedWaterTemperatureSetting() {return null;}
	/**
	 * Property name : Heated water temperature setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the heated water temperature setting in   .<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x64 (0-100  )<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit :   <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidHeatedWaterTemperatureSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured temperature of water in water heater<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the current temperature of the water in the water heater in    .<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x64 i0-100   j<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit :   <br>
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
	 * This property indicates the current temperature of the water in the water heater in    .<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x64 i0-100   j<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit :   <br>
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
	 * 0x0000-0xFFFD<br>
	 *  i0-65533W j<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
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
	 * 0x0000-0xFFFD<br>
	 *  i0-65533W j<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
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
	 * 0x0000-0xFFFD<br>
	 *  i0-65533MJ j<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
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
	 * 0x0000-0xFFFD<br>
	 *  i0-65533MJ j<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
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
	 * 0x0000-0xFFFD<br>
	 *  i0-65533W j<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
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
	 * 0x0000-0xFFFD<br>
	 *  i0-65533W j<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
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
	 * 0x0-0x3B9AC9FF<br>
	 *  i0-999,999.999kWh j<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
Byte<br>
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
	 * 0x0-0x3B9AC9FF<br>
	 *  i0-999,999.999kWh j<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
Byte<br>
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
	 * Property name : Cumulative power generation
output reset setting<br>
	 * <br>
	 * EPC : 0xC6<br>
	 * <br>
	 * Contents of property :<br>
	 * Resets the cumulative power generation output by writing 0x00.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset  0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - undefined<br>
	 */
	protected boolean setCumulativePowerGenerationOutputResetSetting(byte[] edt) {return false;}
	/**
	 * Property name : Cumulative power generation
output reset setting<br>
	 * <br>
	 * EPC : 0xC6<br>
	 * <br>
	 * Contents of property :<br>
	 * Resets the cumulative power generation output by writing 0x00.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset  0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 Byte<br>
	 * <br>
	 * Unit : .<br>
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
	 * This property indicates the instantaneous gas consumption in increments of 0.001m3.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0-0xFFFD<br>
	 *  i0-65.533m3 j<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 Byte<br>
	 * <br>
	 * Unit : 0.001 m3<br>
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
	 * This property indicates the instantaneous gas consumption in increments of 0.001m3.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0-0xFFFD<br>
	 *  i0-65.533m3 j<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 Byte<br>
	 * <br>
	 * Unit : 0.001 m3<br>
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
	 * 0x0-0x3B9AC9FF<br>
	 *  i0-999,999.999m3 j<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
Byte<br>
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
	 * 0x0-0x3B9AC9FF<br>
	 *  i0-999,999.999m3 j<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
Byte<br>
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
	 * Reset  0x00<br>
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
	 * Reset  0x00<br>
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
	 * Get - undefined<br>
	 */
	protected boolean isValidCumulativeGasConsumptionResetSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Power generation setting<br>
	 * <br>
	 * EPC : 0xCA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ON/OFF<br>
	 * status of power generation.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Power generation ON=0x41 C<br>
	 * Power generation OFF  0x42<br>
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
	protected boolean setPowerGenerationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Power generation setting<br>
	 * <br>
	 * EPC : 0xCA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ON/OFF<br>
	 * status of power generation.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Power generation ON=0x41 C<br>
	 * Power generation OFF  0x42<br>
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
	protected byte[] getPowerGenerationSetting() {return null;}
	/**
	 * Property name : Power generation setting<br>
	 * <br>
	 * EPC : 0xCA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ON/OFF<br>
	 * status of power generation.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Power generation ON=0x41 C<br>
	 * Power generation OFF  0x42<br>
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
	protected boolean isValidPowerGenerationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bath water reheating<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Reheating ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reheating ON =0x41 C<br>
	 * Reheating OFF  0x42<br>
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
	protected boolean setBathWaterReheating(byte[] edt) {return false;}
	/**
	 * Property name : Bath water reheating<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Reheating ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reheating ON =0x41 C<br>
	 * Reheating OFF  0x42<br>
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
	protected byte[] getBathWaterReheating() {return null;}
	/**
	 * Property name : Bath water reheating<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Reheating ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reheating ON =0x41 C<br>
	 * Reheating OFF  0x42<br>
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
	protected boolean isValidBathWaterReheating(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name :  gTemperature of supplied water h setting<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the temperature setting for the supplied water in   C.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x64 i0-100   j<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit :   <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setGtemperatureOfSuppliedWaterHSetting(byte[] edt) {return false;}
	/**
	 * Property name :  gTemperature of supplied water h setting<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the temperature setting for the supplied water in   C.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x64 i0-100   j<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit :   <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getGtemperatureOfSuppliedWaterHSetting() {return null;}
	/**
	 * Property name :  gTemperature of supplied water h setting<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the temperature setting for the supplied water in   C.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x64 i0-100   j<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit :   <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidGtemperatureOfSuppliedWaterHSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bath water temperature setting<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the temperature setting for the bath water in    .<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x64 i0-100   j<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit :   <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setBathWaterTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Property name : Bath water temperature setting<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the temperature setting for the bath water in    .<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x64 i0-100   j<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit :   <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getBathWaterTemperatureSetting() {return null;}
	/**
	 * Property name : Bath water temperature setting<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the temperature setting for the bath water in    .<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x64 i0-100   j<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit :   <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidBathWaterTemperatureSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Heated bath water amount setting<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x64 (0-100  )<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit :   <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setHeatedBathWaterAmountSetting(byte[] edt) {return false;}
	/**
	 * Property name : Heated bath water amount setting<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x64 (0-100  )<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit :   <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getHeatedBathWaterAmountSetting() {return null;}
	/**
	 * Property name : Heated bath water amount setting<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x64 (0-100  )<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit :   <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidHeatedBathWaterAmountSetting(byte[] edt) {
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
	 * 0x0000-0xFFFD i0-65533 liters j<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
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
	 * 0x0000-0xFFFD i0-65533 liters j<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
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
	 * 0x0000-0xFFFD i0-65533 liters j<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
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
	 * 0x0000-0xFFFD i0-65533 liters j<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
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
	/**
	 * Property name :  gAutomatic bath water heating mode h setting<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic mode ON  0x41 C<br>
	 * Automatic mode OFF  0x42<br>
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
	protected boolean setGautomaticBathWaterHeatingModeHSetting(byte[] edt) {return false;}
	/**
	 * Property name :  gAutomatic bath water heating mode h setting<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic mode ON  0x41 C<br>
	 * Automatic mode OFF  0x42<br>
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
	protected byte[] getGautomaticBathWaterHeatingModeHSetting() {return null;}
	/**
	 * Property name :  gAutomatic bath water heating mode h setting<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic mode ON  0x41 C<br>
	 * Automatic mode OFF  0x42<br>
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
	protected boolean isValidGautomaticBathWaterHeatingModeHSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name :  gBath water addition function h setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Addition function ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Addition function ON  0x41 C<br>
	 * Addition function OFF  0x42<br>
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
	protected boolean setGbathWaterAdditionFunctionHSetting(byte[] edt) {return false;}
	/**
	 * Property name :  gBath water addition function h setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Addition function ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Addition function ON  0x41 C<br>
	 * Addition function OFF  0x42<br>
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
	protected byte[] getGbathWaterAdditionFunctionHSetting() {return null;}
	/**
	 * Property name :  gBath water addition function h setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Addition function ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Addition function ON  0x41 C<br>
	 * Addition function OFF  0x42<br>
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
	protected boolean isValidGbathWaterAdditionFunctionHSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name :  gSlight bath water temperature
lowering h
function setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 *  gSlight bath water temperature lowering h function ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 *  gSlight bath water temperature lowering h function ON  <br>
	 * 0x41 C hSlight bath water temperature lowering h function OFF  0x42<br>
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
	protected boolean setGslightBathWaterTemperatureLoweringHFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name :  gSlight bath water temperature
lowering h
function setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 *  gSlight bath water temperature lowering h function ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 *  gSlight bath water temperature lowering h function ON  <br>
	 * 0x41 C hSlight bath water temperature lowering h function OFF  0x42<br>
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
	protected byte[] getGslightBathWaterTemperatureLoweringHFunctionSetting() {return null;}
	/**
	 * Property name :  gSlight bath water temperature
lowering h
function setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 *  gSlight bath water temperature lowering h function ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 *  gSlight bath water temperature lowering h function ON  <br>
	 * 0x41 C hSlight bath water temperature lowering h function OFF  0x42<br>
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
	protected boolean isValidGslightBathWaterTemperatureLoweringHFunctionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bath water amount setting
2<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the amount of the bath water using an 8-level scale.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31-38<br>
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
	protected boolean setBathWaterAmountSetting2(byte[] edt) {return false;}
	/**
	 * Property name : Bath water amount setting
2<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the amount of the bath water using an 8-level scale.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31-38<br>
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
	protected byte[] getBathWaterAmountSetting2() {return null;}
	/**
	 * Property name : Bath water amount setting
2<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the amount of the bath water using an 8-level scale.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31-38<br>
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
	protected boolean isValidBathWaterAmountSetting2(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bath water amount setting
3<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the amount of the bath water in liters.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0xFFFD i0-65533 liters j<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setBathWaterAmountSetting3(byte[] edt) {return false;}
	/**
	 * Property name : Bath water amount setting
3<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the amount of the bath water in liters.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0xFFFD i0-65533 liters j<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getBathWaterAmountSetting3() {return null;}
	/**
	 * Property name : Bath water amount setting
3<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the amount of the bath water in liters.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0xFFFD i0-65533 liters j<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidBathWaterAmountSetting3(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON  0x41, Reservation<br>
	 * OFF  0x42<br>
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
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON  0x41, Reservation<br>
	 * OFF  0x42<br>
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
	protected byte[] getOnTimerReservationSetting() {return null;}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON  0x41, Reservation<br>
	 * OFF  0x42<br>
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
	protected boolean isValidOnTimerReservationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : ON timer setting<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Time    HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0-0x3B (=0-23):(=0-59 j<br>
	 * <br>
	 * Data type : unsigned char
 ~2<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Property name : ON timer setting<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Time    HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0-0x3B (=0-23):(=0-59 j<br>
	 * <br>
	 * Data type : unsigned char
 ~2<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOnTimerSetting() {return null;}
	/**
	 * Property name : ON timer setting<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Time    HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0-0x3B (=0-23):(=0-59 j<br>
	 * <br>
	 * Data type : unsigned char
 ~2<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOnTimerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE : return setAutomaticSettingOfHeatedWaterTemperature(property.edt);
		case EPC_HEATED_WATER_TEMPERATURE_SETTING : return setHeatedWaterTemperatureSetting(property.edt);
		case EPC_CUMULATIVE_POWER_GENERATION_OUTPUT_RESET_SETTING : return setCumulativePowerGenerationOutputResetSetting(property.edt);
		case EPC_CUMULATIVE_GAS_CONSUMPTION_RESET_SETTING : return setCumulativeGasConsumptionResetSetting(property.edt);
		case EPC_POWER_GENERATION_SETTING : return setPowerGenerationSetting(property.edt);
		case EPC_BATH_WATER_REHEATING : return setBathWaterReheating(property.edt);
		case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING : return setGtemperatureOfSuppliedWaterHSetting(property.edt);
		case EPC_BATH_WATER_TEMPERATURE_SETTING : return setBathWaterTemperatureSetting(property.edt);
		case EPC_HEATED_BATH_WATER_AMOUNT_SETTING : return setHeatedBathWaterAmountSetting(property.edt);
		case EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING : return setGautomaticBathWaterHeatingModeHSetting(property.edt);
		case EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING : return setGbathWaterAdditionFunctionHSetting(property.edt);
		case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING : return setGslightBathWaterTemperatureLoweringHFunctionSetting(property.edt);
		case EPC_BATH_WATER_AMOUNT_SETTING2 : return setBathWaterAmountSetting2(property.edt);
		case EPC_BATH_WATER_AMOUNT_SETTING3 : return setBathWaterAmountSetting3(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return setOnTimerReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING : return setOnTimerSetting(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE : return getAutomaticSettingOfHeatedWaterTemperature();
		case EPC_HEATING_STATUS : return getHeatingStatus();
		case EPC_HEATED_WATER_TEMPERATURE_SETTING : return getHeatedWaterTemperatureSetting();
		case EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER : return getMeasuredTemperatureOfWaterInWaterHeater();
		case EPC_RATED_POWER_GENERATION_OUTPUT : return getRatedPowerGenerationOutput();
		case EPC_HEATING_VALUE_OF_HOT_WATER_STORAGE_TANK : return getHeatingValueOfHotWaterStorageTank();
		case EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT : return getMeasuredInstantaneousPowerGenerationOutput();
		case EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT : return getMeasuredCumulativePowerGenerationOutput();
		case EPC_MEASURED_INSTANTANEOUS_GAS_CONSUMPTION : return getMeasuredInstantaneousGasConsumption();
		case EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION : return getMeasuredCumulativeGasConsumption();
		case EPC_POWER_GENERATION_SETTING : return getPowerGenerationSetting();
		case EPC_BATH_WATER_REHEATING : return getBathWaterReheating();
		case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING : return getGtemperatureOfSuppliedWaterHSetting();
		case EPC_BATH_WATER_TEMPERATURE_SETTING : return getBathWaterTemperatureSetting();
		case EPC_HEATED_BATH_WATER_AMOUNT_SETTING : return getHeatedBathWaterAmountSetting();
		case EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT : return getMeasuredRemainingHotWaterAmount();
		case EPC_TANK_CAPACITY : return getTankCapacity();
		case EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING : return getGautomaticBathWaterHeatingModeHSetting();
		case EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING : return getGbathWaterAdditionFunctionHSetting();
		case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING : return getGslightBathWaterTemperatureLoweringHFunctionSetting();
		case EPC_BATH_WATER_AMOUNT_SETTING2 : return getBathWaterAmountSetting2();
		case EPC_BATH_WATER_AMOUNT_SETTING3 : return getBathWaterAmountSetting3();
		case EPC_ON_TIMER_RESERVATION_SETTING : return getOnTimerReservationSetting();
		case EPC_ON_TIMER_SETTING : return getOnTimerSetting();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE : return isValidAutomaticSettingOfHeatedWaterTemperature(property.edt);
		case EPC_HEATING_STATUS : return isValidHeatingStatus(property.edt);
		case EPC_HEATED_WATER_TEMPERATURE_SETTING : return isValidHeatedWaterTemperatureSetting(property.edt);
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
		case EPC_BATH_WATER_REHEATING : return isValidBathWaterReheating(property.edt);
		case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING : return isValidGtemperatureOfSuppliedWaterHSetting(property.edt);
		case EPC_BATH_WATER_TEMPERATURE_SETTING : return isValidBathWaterTemperatureSetting(property.edt);
		case EPC_HEATED_BATH_WATER_AMOUNT_SETTING : return isValidHeatedBathWaterAmountSetting(property.edt);
		case EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT : return isValidMeasuredRemainingHotWaterAmount(property.edt);
		case EPC_TANK_CAPACITY : return isValidTankCapacity(property.edt);
		case EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING : return isValidGautomaticBathWaterHeatingModeHSetting(property.edt);
		case EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING : return isValidGbathWaterAdditionFunctionHSetting(property.edt);
		case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING : return isValidGslightBathWaterTemperatureLoweringHFunctionSetting(property.edt);
		case EPC_BATH_WATER_AMOUNT_SETTING2 : return isValidBathWaterAmountSetting2(property.edt);
		case EPC_BATH_WATER_AMOUNT_SETTING3 : return isValidBathWaterAmountSetting3(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return isValidOnTimerReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING : return isValidOnTimerSetting(property.edt);
		default : return false;
		}
	}

	@Override
	public Setter set() {
		return new Setter(this, true, false);
	}

	@Override
	public Setter set(boolean responseRequired) {
		return new Setter(this, responseRequired, false);
	}

	@Override
	public Getter get() {
		return new Getter(this, false);
	}

	@Override
	public Informer inform() {
		return new Informer(this, !isProxy());
	}
	
	@Override
	protected Informer inform(boolean multicast) {
		return new Informer(this, multicast);
	}
	
	public static class Receiver extends DeviceObject.Receiver {

		@Override
		protected boolean onSetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onSetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE : 
				onSetAutomaticSettingOfHeatedWaterTemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_HEATED_WATER_TEMPERATURE_SETTING : 
				onSetHeatedWaterTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CUMULATIVE_POWER_GENERATION_OUTPUT_RESET_SETTING : 
				onSetCumulativePowerGenerationOutputResetSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CUMULATIVE_GAS_CONSUMPTION_RESET_SETTING : 
				onSetCumulativeGasConsumptionResetSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_POWER_GENERATION_SETTING : 
				onSetPowerGenerationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_REHEATING : 
				onSetBathWaterReheating(eoj, tid, esv, property, success);
				return true;
			case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING : 
				onSetGtemperatureOfSuppliedWaterHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_TEMPERATURE_SETTING : 
				onSetBathWaterTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_HEATED_BATH_WATER_AMOUNT_SETTING : 
				onSetHeatedBathWaterAmountSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING : 
				onSetGautomaticBathWaterHeatingModeHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING : 
				onSetGbathWaterAdditionFunctionHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING : 
				onSetGslightBathWaterTemperatureLoweringHFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_AMOUNT_SETTING2 : 
				onSetBathWaterAmountSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_AMOUNT_SETTING3 : 
				onSetBathWaterAmountSetting3(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onSetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING : 
				onSetOnTimerSetting(eoj, tid, esv, property, success);
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
			case EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE : 
				onGetAutomaticSettingOfHeatedWaterTemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_HEATING_STATUS : 
				onGetHeatingStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_HEATED_WATER_TEMPERATURE_SETTING : 
				onGetHeatedWaterTemperatureSetting(eoj, tid, esv, property, success);
				return true;
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
			case EPC_POWER_GENERATION_SETTING : 
				onGetPowerGenerationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_REHEATING : 
				onGetBathWaterReheating(eoj, tid, esv, property, success);
				return true;
			case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING : 
				onGetGtemperatureOfSuppliedWaterHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_TEMPERATURE_SETTING : 
				onGetBathWaterTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_HEATED_BATH_WATER_AMOUNT_SETTING : 
				onGetHeatedBathWaterAmountSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT : 
				onGetMeasuredRemainingHotWaterAmount(eoj, tid, esv, property, success);
				return true;
			case EPC_TANK_CAPACITY : 
				onGetTankCapacity(eoj, tid, esv, property, success);
				return true;
			case EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING : 
				onGetGautomaticBathWaterHeatingModeHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING : 
				onGetGbathWaterAdditionFunctionHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING : 
				onGetGslightBathWaterTemperatureLoweringHFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_AMOUNT_SETTING2 : 
				onGetBathWaterAmountSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_AMOUNT_SETTING3 : 
				onGetBathWaterAmountSetting3(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onGetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING : 
				onGetOnTimerSetting(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Automatic setting of heated water temperature<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * AUTO/Non-AUTO<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * AUTO  0x41 CNon-AUTO  0x42<br>
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
		protected void onSetAutomaticSettingOfHeatedWaterTemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Automatic setting of heated water temperature<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * AUTO/Non-AUTO<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * AUTO  0x41 CNon-AUTO  0x42<br>
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
		protected void onGetAutomaticSettingOfHeatedWaterTemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Heating status<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the water is being heated.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Being heated  0x41 C<br>
		 * Not being heated  0x42<br>
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
		protected void onGetHeatingStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Heated water temperature setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the heated water temperature setting in   .<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 (0-100  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetHeatedWaterTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Heated water temperature setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the heated water temperature setting in   .<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 (0-100  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetHeatedWaterTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured temperature of water in water heater<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the current temperature of the water in the water heater in    .<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 i0-100   j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
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
		 * 0x0000-0xFFFD<br>
		 *  i0-65533W j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
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
		 * 0x0000-0xFFFD<br>
		 *  i0-65533MJ j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
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
		 * 0x0000-0xFFFD<br>
		 *  i0-65533W j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
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
		 * 0x0-0x3B9AC9FF<br>
		 *  i0-999,999.999kWh j<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
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
		 * Property name : Cumulative power generation
output reset setting<br>
		 * <br>
		 * EPC : 0xC6<br>
		 * <br>
		 * Contents of property :<br>
		 * Resets the cumulative power generation output by writing 0x00.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset  0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 Byte<br>
		 * <br>
		 * Unit : .<br>
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
		 * This property indicates the instantaneous gas consumption in increments of 0.001m3.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0-0xFFFD<br>
		 *  i0-65.533m3 j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 Byte<br>
		 * <br>
		 * Unit : 0.001 m3<br>
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
		 * 0x0-0x3B9AC9FF<br>
		 *  i0-999,999.999m3 j<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
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
		 * Reset  0x00<br>
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
		 * Get - undefined<br>
		 */
		protected void onSetCumulativeGasConsumptionResetSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Power generation setting<br>
		 * <br>
		 * EPC : 0xCA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ON/OFF<br>
		 * status of power generation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Power generation ON=0x41 C<br>
		 * Power generation OFF  0x42<br>
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
		protected void onSetPowerGenerationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Power generation setting<br>
		 * <br>
		 * EPC : 0xCA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ON/OFF<br>
		 * status of power generation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Power generation ON=0x41 C<br>
		 * Power generation OFF  0x42<br>
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
		protected void onGetPowerGenerationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water reheating<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Reheating ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reheating ON =0x41 C<br>
		 * Reheating OFF  0x42<br>
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
		protected void onSetBathWaterReheating(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water reheating<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Reheating ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reheating ON =0x41 C<br>
		 * Reheating OFF  0x42<br>
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
		protected void onGetBathWaterReheating(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name :  gTemperature of supplied water h setting<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the temperature setting for the supplied water in   C.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 i0-100   j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetGtemperatureOfSuppliedWaterHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name :  gTemperature of supplied water h setting<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the temperature setting for the supplied water in   C.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 i0-100   j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetGtemperatureOfSuppliedWaterHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water temperature setting<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the temperature setting for the bath water in    .<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 i0-100   j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetBathWaterTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water temperature setting<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the temperature setting for the bath water in    .<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 i0-100   j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetBathWaterTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Heated bath water amount setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 (0-100  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetHeatedBathWaterAmountSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Heated bath water amount setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 (0-100  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetHeatedBathWaterAmountSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured remaining hot water amount<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured amount of the remaining hot water in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0xFFFD i0-65533 liters j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
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
		 * 0x0000-0xFFFD i0-65533 liters j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetTankCapacity(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name :  gAutomatic bath water heating mode h setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic mode ON  0x41 C<br>
		 * Automatic mode OFF  0x42<br>
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
		protected void onSetGautomaticBathWaterHeatingModeHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name :  gAutomatic bath water heating mode h setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic mode ON  0x41 C<br>
		 * Automatic mode OFF  0x42<br>
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
		protected void onGetGautomaticBathWaterHeatingModeHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name :  gBath water addition function h setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Addition function ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Addition function ON  0x41 C<br>
		 * Addition function OFF  0x42<br>
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
		protected void onSetGbathWaterAdditionFunctionHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name :  gBath water addition function h setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Addition function ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Addition function ON  0x41 C<br>
		 * Addition function OFF  0x42<br>
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
		protected void onGetGbathWaterAdditionFunctionHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name :  gSlight bath water temperature
lowering h
function setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 *  gSlight bath water temperature lowering h function ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 *  gSlight bath water temperature lowering h function ON  <br>
		 * 0x41 C hSlight bath water temperature lowering h function OFF  0x42<br>
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
		protected void onSetGslightBathWaterTemperatureLoweringHFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name :  gSlight bath water temperature
lowering h
function setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 *  gSlight bath water temperature lowering h function ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 *  gSlight bath water temperature lowering h function ON  <br>
		 * 0x41 C hSlight bath water temperature lowering h function OFF  0x42<br>
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
		protected void onGetGslightBathWaterTemperatureLoweringHFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water amount setting
2<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the amount of the bath water using an 8-level scale.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31-38<br>
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
		protected void onSetBathWaterAmountSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water amount setting
2<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the amount of the bath water using an 8-level scale.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31-38<br>
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
		protected void onGetBathWaterAmountSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water amount setting
3<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the amount of the bath water in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0xFFFD i0-65533 liters j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetBathWaterAmountSetting3(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water amount setting
3<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the amount of the bath water in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0xFFFD i0-65533 liters j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetBathWaterAmountSetting3(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON  0x41, Reservation<br>
		 * OFF  0x42<br>
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
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON  0x41, Reservation<br>
		 * OFF  0x42<br>
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
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Time    HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B (=0-23):(=0-59 j<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Time    HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B (=0-23):(=0-59 j<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
	}

	public static class Setter extends DeviceObject.Setter {
		public Setter(EchoObject eoj, boolean responseRequired, boolean multicast) {
			super(eoj, responseRequired, multicast);
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
		 * Property name : Automatic setting of heated water temperature<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * AUTO/Non-AUTO<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * AUTO  0x41 CNon-AUTO  0x42<br>
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
		public Setter reqSetAutomaticSettingOfHeatedWaterTemperature(byte[] edt) {
			addProperty(EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE, edt);
			return this;
		}
		/**
		 * Property name : Heated water temperature setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the heated water temperature setting in   .<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 (0-100  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetHeatedWaterTemperatureSetting(byte[] edt) {
			addProperty(EPC_HEATED_WATER_TEMPERATURE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Cumulative power generation
output reset setting<br>
		 * <br>
		 * EPC : 0xC6<br>
		 * <br>
		 * Contents of property :<br>
		 * Resets the cumulative power generation output by writing 0x00.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset  0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - undefined<br>
		 */
		public Setter reqSetCumulativePowerGenerationOutputResetSetting(byte[] edt) {
			addProperty(EPC_CUMULATIVE_POWER_GENERATION_OUTPUT_RESET_SETTING, edt);
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
		 * Reset  0x00<br>
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
		 * Get - undefined<br>
		 */
		public Setter reqSetCumulativeGasConsumptionResetSetting(byte[] edt) {
			addProperty(EPC_CUMULATIVE_GAS_CONSUMPTION_RESET_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Power generation setting<br>
		 * <br>
		 * EPC : 0xCA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ON/OFF<br>
		 * status of power generation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Power generation ON=0x41 C<br>
		 * Power generation OFF  0x42<br>
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
		public Setter reqSetPowerGenerationSetting(byte[] edt) {
			addProperty(EPC_POWER_GENERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Bath water reheating<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Reheating ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reheating ON =0x41 C<br>
		 * Reheating OFF  0x42<br>
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
		public Setter reqSetBathWaterReheating(byte[] edt) {
			addProperty(EPC_BATH_WATER_REHEATING, edt);
			return this;
		}
		/**
		 * Property name :  gTemperature of supplied water h setting<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the temperature setting for the supplied water in   C.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 i0-100   j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetGtemperatureOfSuppliedWaterHSetting(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Bath water temperature setting<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the temperature setting for the bath water in    .<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 i0-100   j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetBathWaterTemperatureSetting(byte[] edt) {
			addProperty(EPC_BATH_WATER_TEMPERATURE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Heated bath water amount setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 (0-100  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetHeatedBathWaterAmountSetting(byte[] edt) {
			addProperty(EPC_HEATED_BATH_WATER_AMOUNT_SETTING, edt);
			return this;
		}
		/**
		 * Property name :  gAutomatic bath water heating mode h setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic mode ON  0x41 C<br>
		 * Automatic mode OFF  0x42<br>
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
		public Setter reqSetGautomaticBathWaterHeatingModeHSetting(byte[] edt) {
			addProperty(EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING, edt);
			return this;
		}
		/**
		 * Property name :  gBath water addition function h setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Addition function ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Addition function ON  0x41 C<br>
		 * Addition function OFF  0x42<br>
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
		public Setter reqSetGbathWaterAdditionFunctionHSetting(byte[] edt) {
			addProperty(EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING, edt);
			return this;
		}
		/**
		 * Property name :  gSlight bath water temperature
lowering h
function setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 *  gSlight bath water temperature lowering h function ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 *  gSlight bath water temperature lowering h function ON  <br>
		 * 0x41 C hSlight bath water temperature lowering h function OFF  0x42<br>
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
		public Setter reqSetGslightBathWaterTemperatureLoweringHFunctionSetting(byte[] edt) {
			addProperty(EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Bath water amount setting
2<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the amount of the bath water using an 8-level scale.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31-38<br>
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
		public Setter reqSetBathWaterAmountSetting2(byte[] edt) {
			addProperty(EPC_BATH_WATER_AMOUNT_SETTING2, edt);
			return this;
		}
		/**
		 * Property name : Bath water amount setting
3<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the amount of the bath water in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0xFFFD i0-65533 liters j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetBathWaterAmountSetting3(byte[] edt) {
			addProperty(EPC_BATH_WATER_AMOUNT_SETTING3, edt);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON  0x41, Reservation<br>
		 * OFF  0x42<br>
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
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Time    HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B (=0-23):(=0-59 j<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOnTimerSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING, edt);
			return this;
		}
	}
	
	public static class Getter extends DeviceObject.Getter {
		public Getter(EchoObject eoj, boolean multicast) {
			super(eoj, multicast);
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
		 * Property name : Automatic setting of heated water temperature<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * AUTO/Non-AUTO<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * AUTO  0x41 CNon-AUTO  0x42<br>
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
		public Getter reqGetAutomaticSettingOfHeatedWaterTemperature() {
			addProperty(EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Heating status<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the water is being heated.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Being heated  0x41 C<br>
		 * Not being heated  0x42<br>
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
		public Getter reqGetHeatingStatus() {
			addProperty(EPC_HEATING_STATUS);
			return this;
		}
		/**
		 * Property name : Heated water temperature setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the heated water temperature setting in   .<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 (0-100  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetHeatedWaterTemperatureSetting() {
			addProperty(EPC_HEATED_WATER_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Measured temperature of water in water heater<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the current temperature of the water in the water heater in    .<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 i0-100   j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredTemperatureOfWaterInWaterHeater() {
			addProperty(EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER);
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
		 * 0x0000-0xFFFD<br>
		 *  i0-65533W j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRatedPowerGenerationOutput() {
			addProperty(EPC_RATED_POWER_GENERATION_OUTPUT);
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
		 * 0x0000-0xFFFD<br>
		 *  i0-65533MJ j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : MJ<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetHeatingValueOfHotWaterStorageTank() {
			addProperty(EPC_HEATING_VALUE_OF_HOT_WATER_STORAGE_TANK);
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
		 * 0x0000-0xFFFD<br>
		 *  i0-65533W j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetMeasuredInstantaneousPowerGenerationOutput() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT);
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
		 * 0x0-0x3B9AC9FF<br>
		 *  i0-999,999.999kWh j<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : 0.001 kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetMeasuredCumulativePowerGenerationOutput() {
			addProperty(EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT);
			return this;
		}
		/**
		 * Property name : Measured instantaneous gas consumption<br>
		 * <br>
		 * EPC : 0xC7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the instantaneous gas consumption in increments of 0.001m3.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0-0xFFFD<br>
		 *  i0-65.533m3 j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 Byte<br>
		 * <br>
		 * Unit : 0.001 m3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredInstantaneousGasConsumption() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_GAS_CONSUMPTION);
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
		 * 0x0-0x3B9AC9FF<br>
		 *  i0-999,999.999m3 j<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : 0.001 m3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredCumulativeGasConsumption() {
			addProperty(EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Power generation setting<br>
		 * <br>
		 * EPC : 0xCA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ON/OFF<br>
		 * status of power generation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Power generation ON=0x41 C<br>
		 * Power generation OFF  0x42<br>
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
		public Getter reqGetPowerGenerationSetting() {
			addProperty(EPC_POWER_GENERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Bath water reheating<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Reheating ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reheating ON =0x41 C<br>
		 * Reheating OFF  0x42<br>
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
		public Getter reqGetBathWaterReheating() {
			addProperty(EPC_BATH_WATER_REHEATING);
			return this;
		}
		/**
		 * Property name :  gTemperature of supplied water h setting<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the temperature setting for the supplied water in   C.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 i0-100   j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetGtemperatureOfSuppliedWaterHSetting() {
			addProperty(EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING);
			return this;
		}
		/**
		 * Property name : Bath water temperature setting<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the temperature setting for the bath water in    .<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 i0-100   j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetBathWaterTemperatureSetting() {
			addProperty(EPC_BATH_WATER_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Heated bath water amount setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 (0-100  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetHeatedBathWaterAmountSetting() {
			addProperty(EPC_HEATED_BATH_WATER_AMOUNT_SETTING);
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
		 * 0x0000-0xFFFD i0-65533 liters j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredRemainingHotWaterAmount() {
			addProperty(EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT);
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
		 * 0x0000-0xFFFD i0-65533 liters j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetTankCapacity() {
			addProperty(EPC_TANK_CAPACITY);
			return this;
		}
		/**
		 * Property name :  gAutomatic bath water heating mode h setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic mode ON  0x41 C<br>
		 * Automatic mode OFF  0x42<br>
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
		public Getter reqGetGautomaticBathWaterHeatingModeHSetting() {
			addProperty(EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING);
			return this;
		}
		/**
		 * Property name :  gBath water addition function h setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Addition function ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Addition function ON  0x41 C<br>
		 * Addition function OFF  0x42<br>
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
		public Getter reqGetGbathWaterAdditionFunctionHSetting() {
			addProperty(EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING);
			return this;
		}
		/**
		 * Property name :  gSlight bath water temperature
lowering h
function setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 *  gSlight bath water temperature lowering h function ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 *  gSlight bath water temperature lowering h function ON  <br>
		 * 0x41 C hSlight bath water temperature lowering h function OFF  0x42<br>
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
		public Getter reqGetGslightBathWaterTemperatureLoweringHFunctionSetting() {
			addProperty(EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Bath water amount setting
2<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the amount of the bath water using an 8-level scale.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31-38<br>
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
		public Getter reqGetBathWaterAmountSetting2() {
			addProperty(EPC_BATH_WATER_AMOUNT_SETTING2);
			return this;
		}
		/**
		 * Property name : Bath water amount setting
3<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the amount of the bath water in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0xFFFD i0-65533 liters j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetBathWaterAmountSetting3() {
			addProperty(EPC_BATH_WATER_AMOUNT_SETTING3);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON  0x41, Reservation<br>
		 * OFF  0x42<br>
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
		public Getter reqGetOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Time    HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B (=0-23):(=0-59 j<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOnTimerSetting() {
			addProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
	}
	
	public static class Informer extends DeviceObject.Informer {
		public Informer(EchoObject eoj, boolean multicast) {
			super(eoj, multicast);
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
		 * Property name : Automatic setting of heated water temperature<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * AUTO/Non-AUTO<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * AUTO  0x41 CNon-AUTO  0x42<br>
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
		public Informer reqInformAutomaticSettingOfHeatedWaterTemperature() {
			addProperty(EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Heating status<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the water is being heated.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Being heated  0x41 C<br>
		 * Not being heated  0x42<br>
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
		public Informer reqInformHeatingStatus() {
			addProperty(EPC_HEATING_STATUS);
			return this;
		}
		/**
		 * Property name : Heated water temperature setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the heated water temperature setting in   .<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 (0-100  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformHeatedWaterTemperatureSetting() {
			addProperty(EPC_HEATED_WATER_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Measured temperature of water in water heater<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the current temperature of the water in the water heater in    .<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 i0-100   j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredTemperatureOfWaterInWaterHeater() {
			addProperty(EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER);
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
		 * 0x0000-0xFFFD<br>
		 *  i0-65533W j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRatedPowerGenerationOutput() {
			addProperty(EPC_RATED_POWER_GENERATION_OUTPUT);
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
		 * 0x0000-0xFFFD<br>
		 *  i0-65533MJ j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : MJ<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformHeatingValueOfHotWaterStorageTank() {
			addProperty(EPC_HEATING_VALUE_OF_HOT_WATER_STORAGE_TANK);
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
		 * 0x0000-0xFFFD<br>
		 *  i0-65533W j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformMeasuredInstantaneousPowerGenerationOutput() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT);
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
		 * 0x0-0x3B9AC9FF<br>
		 *  i0-999,999.999kWh j<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : 0.001 kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformMeasuredCumulativePowerGenerationOutput() {
			addProperty(EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT);
			return this;
		}
		/**
		 * Property name : Measured instantaneous gas consumption<br>
		 * <br>
		 * EPC : 0xC7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the instantaneous gas consumption in increments of 0.001m3.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0-0xFFFD<br>
		 *  i0-65.533m3 j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 Byte<br>
		 * <br>
		 * Unit : 0.001 m3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredInstantaneousGasConsumption() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_GAS_CONSUMPTION);
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
		 * 0x0-0x3B9AC9FF<br>
		 *  i0-999,999.999m3 j<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : 0.001 m3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredCumulativeGasConsumption() {
			addProperty(EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Power generation setting<br>
		 * <br>
		 * EPC : 0xCA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ON/OFF<br>
		 * status of power generation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Power generation ON=0x41 C<br>
		 * Power generation OFF  0x42<br>
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
		public Informer reqInformPowerGenerationSetting() {
			addProperty(EPC_POWER_GENERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Bath water reheating<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Reheating ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reheating ON =0x41 C<br>
		 * Reheating OFF  0x42<br>
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
		public Informer reqInformBathWaterReheating() {
			addProperty(EPC_BATH_WATER_REHEATING);
			return this;
		}
		/**
		 * Property name :  gTemperature of supplied water h setting<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the temperature setting for the supplied water in   C.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 i0-100   j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformGtemperatureOfSuppliedWaterHSetting() {
			addProperty(EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING);
			return this;
		}
		/**
		 * Property name : Bath water temperature setting<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the temperature setting for the bath water in    .<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 i0-100   j<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformBathWaterTemperatureSetting() {
			addProperty(EPC_BATH_WATER_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Heated bath water amount setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x64 (0-100  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit :   <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformHeatedBathWaterAmountSetting() {
			addProperty(EPC_HEATED_BATH_WATER_AMOUNT_SETTING);
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
		 * 0x0000-0xFFFD i0-65533 liters j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredRemainingHotWaterAmount() {
			addProperty(EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT);
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
		 * 0x0000-0xFFFD i0-65533 liters j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformTankCapacity() {
			addProperty(EPC_TANK_CAPACITY);
			return this;
		}
		/**
		 * Property name :  gAutomatic bath water heating mode h setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic mode ON  0x41 C<br>
		 * Automatic mode OFF  0x42<br>
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
		public Informer reqInformGautomaticBathWaterHeatingModeHSetting() {
			addProperty(EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING);
			return this;
		}
		/**
		 * Property name :  gBath water addition function h setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Addition function ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Addition function ON  0x41 C<br>
		 * Addition function OFF  0x42<br>
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
		public Informer reqInformGbathWaterAdditionFunctionHSetting() {
			addProperty(EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING);
			return this;
		}
		/**
		 * Property name :  gSlight bath water temperature
lowering h
function setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 *  gSlight bath water temperature lowering h function ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 *  gSlight bath water temperature lowering h function ON  <br>
		 * 0x41 C hSlight bath water temperature lowering h function OFF  0x42<br>
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
		public Informer reqInformGslightBathWaterTemperatureLoweringHFunctionSetting() {
			addProperty(EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Bath water amount setting
2<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the amount of the bath water using an 8-level scale.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31-38<br>
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
		public Informer reqInformBathWaterAmountSetting2() {
			addProperty(EPC_BATH_WATER_AMOUNT_SETTING2);
			return this;
		}
		/**
		 * Property name : Bath water amount setting
3<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the amount of the bath water in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0xFFFD i0-65533 liters j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformBathWaterAmountSetting3() {
			addProperty(EPC_BATH_WATER_AMOUNT_SETTING3);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON  0x41, Reservation<br>
		 * OFF  0x42<br>
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
		public Informer reqInformOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Time    HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B (=0-23):(=0-59 j<br>
		 * <br>
		 * Data type : unsigned char
 ~2<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOnTimerSetting() {
			addProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
	}

	public static class Proxy extends FuelCell {
		private byte mInstanceCode;
		public Proxy(byte instanceCode) {
			super();
			mInstanceCode = instanceCode;
		}
		@Override
		public byte getInstanceCode() {
			return mInstanceCode;
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
		return new Setter(new Proxy(instanceCode), true, true);
	}

	public static Setter setG(boolean responseRequired) {
		return setG((byte)0, responseRequired);
	}

	public static Setter setG(byte instanceCode, boolean responseRequired) {
		return new Setter(new Proxy(instanceCode), responseRequired, true);
	}

	public static Getter getG() {
		return getG((byte)0);
	}
	
	public static Getter getG(byte instanceCode) {
		return new Getter(new Proxy(instanceCode), true);
	}

	public static Informer informG() {
		return informG((byte)0);
	}

	public static Informer informG(byte instanceCode) {
		return new Informer(new Proxy(instanceCode), true);
	}

}
