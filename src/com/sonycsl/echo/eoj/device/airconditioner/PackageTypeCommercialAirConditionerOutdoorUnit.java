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
package com.sonycsl.echo.eoj.device.airconditioner;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class PackageTypeCommercialAirConditionerOutdoorUnit extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0146;

	public static final byte EPC_OPERATION_MODE_SETTING = (byte)0xB0;
	public static final byte EPC_RATED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT = (byte)0xB8;
	public static final byte EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_OUTDOOR_UNIT = (byte)0xB9;
	public static final byte EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE1 = (byte)0xBE;
	public static final byte EPC_SPECIAL_STATE = (byte)0xAA;
	public static final byte EPC_OPERATION_STATUS_OF_COMPRESSOR = (byte)0xD0;
	public static final byte EPC_OPERATION_MODE_INFORMATION = (byte)0xD1;
	public static final byte EPC_FAN_ROTATION_SPEED = (byte)0xD2;
	public static final byte EPC_MEASURED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT = (byte)0xDB;
	public static final byte EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE2 = (byte)0xEE;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addStatusChangeAnnouncementProperty(EPC_OPERATION_MODE_SETTING);
		addGetProperty(EPC_OPERATION_MODE_INFORMATION);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewPackageTypeCommercialAirConditionerOutdoorUnit(this);
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
	 * Unit : —<br>
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
	 * Unit : —<br>
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
	 * Property name : Operation mode setting<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the current operation mode setting (i.e. “automatic,” “cooling,” “heating,” “dehumidification” or “air circulator”).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The following values shall be used: Automatic: 0x41<br>
	 * Cooling: 0x42 Heating: 0x43<br>
	 * Dehumidification: 0x44<br>
	 * Air circulator: 0x45<br>
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
	 * Get - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setOperationModeSetting(byte[] edt) {return false;}
	/**
	 * Property name : Operation mode setting<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the current operation mode setting (i.e. “automatic,” “cooling,” “heating,” “dehumidification” or “air circulator”).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The following values shall be used: Automatic: 0x41<br>
	 * Cooling: 0x42 Heating: 0x43<br>
	 * Dehumidification: 0x44<br>
	 * Air circulator: 0x45<br>
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
	 * Get - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getOperationModeSetting() {return null;}
	/**
	 * Property name : Operation mode setting<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the current operation mode setting (i.e. “automatic,” “cooling,” “heating,” “dehumidification” or “air circulator”).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The following values shall be used: Automatic: 0x41<br>
	 * Cooling: 0x42 Heating: 0x43<br>
	 * Dehumidification: 0x44<br>
	 * Air circulator: 0x45<br>
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
	 * Get - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidOperationModeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Rated power consumption of outdoor unit<br>
	 * <br>
	 * EPC : 0xB8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the rated power consumption for the cooling, heating and dehumidification modes.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533W)<br>
	 * Cooling: heating: dehumidification<br>
	 * <br>
	 * Data type : unsigned short × 3<br>
	 * <br>
	 * Data size : 6 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getRatedPowerConsumptionOfOutdoorUnit() {return null;}
	/**
	 * Property name : Rated power consumption of outdoor unit<br>
	 * <br>
	 * EPC : 0xB8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the rated power consumption for the cooling, heating and dehumidification modes.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533W)<br>
	 * Cooling: heating: dehumidification<br>
	 * <br>
	 * Data type : unsigned short × 3<br>
	 * <br>
	 * Data size : 6 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRatedPowerConsumptionOfOutdoorUnit(byte[] edt) {
		if(edt == null || !(edt.length == 6)) return false;
		return true;
	}
	/**
	 * Property name : Measured electric current consumption of outdoor unit<br>
	 * <br>
	 * EPC : 0xB9<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured electric current consumption.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.6553.3A)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredElectricCurrentConsumptionOfOutdoorUnit() {return null;}
	/**
	 * Property name : Measured electric current consumption of outdoor unit<br>
	 * <br>
	 * EPC : 0xB9<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured electric current consumption.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.6553.3A)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredElectricCurrentConsumptionOfOutdoorUnit(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Measured outdoor air temperature 1<br>
	 * <br>
	 * EPC : 0xBE<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured temperature of the outdoor air.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7D (-127.125°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredOutdoorAirTemperature1() {return null;}
	/**
	 * Property name : Measured outdoor air temperature 1<br>
	 * <br>
	 * EPC : 0xBE<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured temperature of the outdoor air.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7D (-127.125°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredOutdoorAirTemperature1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : “Special” state<br>
	 * <br>
	 * EPC : 0xAA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates when the air conditioner is in the “special” state<br>
	 * (i.e. “defrosting” state).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Normal operation” state = 0x40,<br>
	 * “defrosting” state = 0x41<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getSpecialState() {return null;}
	/**
	 * Property name : “Special” state<br>
	 * <br>
	 * EPC : 0xAA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates when the air conditioner is in the “special” state<br>
	 * (i.e. “defrosting” state).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Normal operation” state = 0x40,<br>
	 * “defrosting” state = 0x41<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSpecialState(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Operation status of compressor<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the operation status<br>
	 * (i.e. ON or OFF) of the compressor.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Compressor ON: 0x41 Compressor OFF: 0x42<br>
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
	protected byte[] getOperationStatusOfCompressor() {return null;}
	/**
	 * Property name : Operation status of compressor<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the operation status<br>
	 * (i.e. ON or OFF) of the compressor.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Compressor ON: 0x41 Compressor OFF: 0x42<br>
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
	protected boolean isValidOperationStatusOfCompressor(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Operation mode information<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the current operation mode (i.e. “cooling,” “heating,” “dehumidification” or “other”).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Cooling: 0x42 Heating: 0x43<br>
	 * Dehumidification: 0x44 Other: 0x40<br>
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
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getOperationModeInformation();
	/**
	 * Property name : Operation mode information<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the current operation mode (i.e. “cooling,” “heating,” “dehumidification” or “other”).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Cooling: 0x42 Heating: 0x43<br>
	 * Dehumidification: 0x44 Other: 0x40<br>
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
	 * Get - mandatory<br>
	 */
	protected boolean isValidOperationModeInformation(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Fan rotation speed<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the rotation speed of the fan of the outdoor unit (expressed in %).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getFanRotationSpeed() {return null;}
	/**
	 * Property name : Fan rotation speed<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the rotation speed of the fan of the outdoor unit (expressed in %).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidFanRotationSpeed(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured power consumption of outdoor unit<br>
	 * <br>
	 * EPC : 0xDB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured power consumption of the outdoor unit.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533W)<br>
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
	protected byte[] getMeasuredPowerConsumptionOfOutdoorUnit() {return null;}
	/**
	 * Property name : Measured power consumption of outdoor unit<br>
	 * <br>
	 * EPC : 0xDB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured power consumption of the outdoor unit.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533W)<br>
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
	protected boolean isValidMeasuredPowerConsumptionOfOutdoorUnit(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Measured outdoor air temperature 2<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured temperature of the outdoor air.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xF554.0x7FFD (-273,2 .3276.5°C)<br>
	 * <br>
	 * Data type : signed short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredOutdoorAirTemperature2() {return null;}
	/**
	 * Property name : Measured outdoor air temperature 2<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured temperature of the outdoor air.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xF554.0x7FFD (-273,2 .3276.5°C)<br>
	 * <br>
	 * Data type : signed short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredOutdoorAirTemperature2(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_OPERATION_MODE_SETTING : return setOperationModeSetting(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_OPERATION_MODE_SETTING : return getOperationModeSetting();
		case EPC_RATED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT : return getRatedPowerConsumptionOfOutdoorUnit();
		case EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_OUTDOOR_UNIT : return getMeasuredElectricCurrentConsumptionOfOutdoorUnit();
		case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE1 : return getMeasuredOutdoorAirTemperature1();
		case EPC_SPECIAL_STATE : return getSpecialState();
		case EPC_OPERATION_STATUS_OF_COMPRESSOR : return getOperationStatusOfCompressor();
		case EPC_OPERATION_MODE_INFORMATION : return getOperationModeInformation();
		case EPC_FAN_ROTATION_SPEED : return getFanRotationSpeed();
		case EPC_MEASURED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT : return getMeasuredPowerConsumptionOfOutdoorUnit();
		case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE2 : return getMeasuredOutdoorAirTemperature2();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_OPERATION_MODE_SETTING : return isValidOperationModeSetting(property.edt);
		case EPC_RATED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT : return isValidRatedPowerConsumptionOfOutdoorUnit(property.edt);
		case EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_OUTDOOR_UNIT : return isValidMeasuredElectricCurrentConsumptionOfOutdoorUnit(property.edt);
		case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE1 : return isValidMeasuredOutdoorAirTemperature1(property.edt);
		case EPC_SPECIAL_STATE : return isValidSpecialState(property.edt);
		case EPC_OPERATION_STATUS_OF_COMPRESSOR : return isValidOperationStatusOfCompressor(property.edt);
		case EPC_OPERATION_MODE_INFORMATION : return isValidOperationModeInformation(property.edt);
		case EPC_FAN_ROTATION_SPEED : return isValidFanRotationSpeed(property.edt);
		case EPC_MEASURED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT : return isValidMeasuredPowerConsumptionOfOutdoorUnit(property.edt);
		case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE2 : return isValidMeasuredOutdoorAirTemperature2(property.edt);
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
			case EPC_OPERATION_MODE_SETTING : 
				onSetOperationModeSetting(eoj, tid, esv, property, success);
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
			case EPC_OPERATION_MODE_SETTING : 
				onGetOperationModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RATED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT : 
				onGetRatedPowerConsumptionOfOutdoorUnit(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_OUTDOOR_UNIT : 
				onGetMeasuredElectricCurrentConsumptionOfOutdoorUnit(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE1 : 
				onGetMeasuredOutdoorAirTemperature1(eoj, tid, esv, property, success);
				return true;
			case EPC_SPECIAL_STATE : 
				onGetSpecialState(eoj, tid, esv, property, success);
				return true;
			case EPC_OPERATION_STATUS_OF_COMPRESSOR : 
				onGetOperationStatusOfCompressor(eoj, tid, esv, property, success);
				return true;
			case EPC_OPERATION_MODE_INFORMATION : 
				onGetOperationModeInformation(eoj, tid, esv, property, success);
				return true;
			case EPC_FAN_ROTATION_SPEED : 
				onGetFanRotationSpeed(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT : 
				onGetMeasuredPowerConsumptionOfOutdoorUnit(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE2 : 
				onGetMeasuredOutdoorAirTemperature2(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current operation mode setting (i.e. “automatic,” “cooling,” “heating,” “dehumidification” or “air circulator”).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Automatic: 0x41<br>
		 * Cooling: 0x42 Heating: 0x43<br>
		 * Dehumidification: 0x44<br>
		 * Air circulator: 0x45<br>
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
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetOperationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current operation mode setting (i.e. “automatic,” “cooling,” “heating,” “dehumidification” or “air circulator”).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Automatic: 0x41<br>
		 * Cooling: 0x42 Heating: 0x43<br>
		 * Dehumidification: 0x44<br>
		 * Air circulator: 0x45<br>
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
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetOperationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rated power consumption of outdoor unit<br>
		 * <br>
		 * EPC : 0xB8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the rated power consumption for the cooling, heating and dehumidification modes.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)<br>
		 * Cooling: heating: dehumidification<br>
		 * <br>
		 * Data type : unsigned short × 3<br>
		 * <br>
		 * Data size : 6 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetRatedPowerConsumptionOfOutdoorUnit(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured electric current consumption of outdoor unit<br>
		 * <br>
		 * EPC : 0xB9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured electric current consumption.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredElectricCurrentConsumptionOfOutdoorUnit(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured outdoor air temperature 1<br>
		 * <br>
		 * EPC : 0xBE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured temperature of the outdoor air.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-127.125°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredOutdoorAirTemperature1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Special” state<br>
		 * <br>
		 * EPC : 0xAA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates when the air conditioner is in the “special” state<br>
		 * (i.e. “defrosting” state).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” state = 0x40,<br>
		 * “defrosting” state = 0x41<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetSpecialState(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation status of compressor<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the operation status<br>
		 * (i.e. ON or OFF) of the compressor.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Compressor ON: 0x41 Compressor OFF: 0x42<br>
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
		protected void onGetOperationStatusOfCompressor(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation mode information<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current operation mode (i.e. “cooling,” “heating,” “dehumidification” or “other”).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Cooling: 0x42 Heating: 0x43<br>
		 * Dehumidification: 0x44 Other: 0x40<br>
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
		 * Get - mandatory<br>
		 */
		protected void onGetOperationModeInformation(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Fan rotation speed<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the rotation speed of the fan of the outdoor unit (expressed in %).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetFanRotationSpeed(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured power consumption of outdoor unit<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured power consumption of the outdoor unit.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)<br>
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
		protected void onGetMeasuredPowerConsumptionOfOutdoorUnit(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured outdoor air temperature 2<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured temperature of the outdoor air.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xF554.0x7FFD (-273,2 .3276.5°C)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredOutdoorAirTemperature2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current operation mode setting (i.e. “automatic,” “cooling,” “heating,” “dehumidification” or “air circulator”).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Automatic: 0x41<br>
		 * Cooling: 0x42 Heating: 0x43<br>
		 * Dehumidification: 0x44<br>
		 * Air circulator: 0x45<br>
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
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetOperationModeSetting(byte[] edt) {
			reqSetProperty(EPC_OPERATION_MODE_SETTING, edt);
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
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current operation mode setting (i.e. “automatic,” “cooling,” “heating,” “dehumidification” or “air circulator”).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Automatic: 0x41<br>
		 * Cooling: 0x42 Heating: 0x43<br>
		 * Dehumidification: 0x44<br>
		 * Air circulator: 0x45<br>
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
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetOperationModeSetting() {
			reqGetProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Rated power consumption of outdoor unit<br>
		 * <br>
		 * EPC : 0xB8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the rated power consumption for the cooling, heating and dehumidification modes.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)<br>
		 * Cooling: heating: dehumidification<br>
		 * <br>
		 * Data type : unsigned short × 3<br>
		 * <br>
		 * Data size : 6 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRatedPowerConsumptionOfOutdoorUnit() {
			reqGetProperty(EPC_RATED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT);
			return this;
		}
		/**
		 * Property name : Measured electric current consumption of outdoor unit<br>
		 * <br>
		 * EPC : 0xB9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured electric current consumption.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredElectricCurrentConsumptionOfOutdoorUnit() {
			reqGetProperty(EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_OUTDOOR_UNIT);
			return this;
		}
		/**
		 * Property name : Measured outdoor air temperature 1<br>
		 * <br>
		 * EPC : 0xBE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured temperature of the outdoor air.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-127.125°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredOutdoorAirTemperature1() {
			reqGetProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE1);
			return this;
		}
		/**
		 * Property name : “Special” state<br>
		 * <br>
		 * EPC : 0xAA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates when the air conditioner is in the “special” state<br>
		 * (i.e. “defrosting” state).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” state = 0x40,<br>
		 * “defrosting” state = 0x41<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSpecialState() {
			reqGetProperty(EPC_SPECIAL_STATE);
			return this;
		}
		/**
		 * Property name : Operation status of compressor<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the operation status<br>
		 * (i.e. ON or OFF) of the compressor.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Compressor ON: 0x41 Compressor OFF: 0x42<br>
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
		public Getter reqGetOperationStatusOfCompressor() {
			reqGetProperty(EPC_OPERATION_STATUS_OF_COMPRESSOR);
			return this;
		}
		/**
		 * Property name : Operation mode information<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current operation mode (i.e. “cooling,” “heating,” “dehumidification” or “other”).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Cooling: 0x42 Heating: 0x43<br>
		 * Dehumidification: 0x44 Other: 0x40<br>
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
		 * Get - mandatory<br>
		 */
		public Getter reqGetOperationModeInformation() {
			reqGetProperty(EPC_OPERATION_MODE_INFORMATION);
			return this;
		}
		/**
		 * Property name : Fan rotation speed<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the rotation speed of the fan of the outdoor unit (expressed in %).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetFanRotationSpeed() {
			reqGetProperty(EPC_FAN_ROTATION_SPEED);
			return this;
		}
		/**
		 * Property name : Measured power consumption of outdoor unit<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured power consumption of the outdoor unit.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)<br>
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
		public Getter reqGetMeasuredPowerConsumptionOfOutdoorUnit() {
			reqGetProperty(EPC_MEASURED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT);
			return this;
		}
		/**
		 * Property name : Measured outdoor air temperature 2<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured temperature of the outdoor air.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xF554.0x7FFD (-273,2 .3276.5°C)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredOutdoorAirTemperature2() {
			reqGetProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE2);
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
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current operation mode setting (i.e. “automatic,” “cooling,” “heating,” “dehumidification” or “air circulator”).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Automatic: 0x41<br>
		 * Cooling: 0x42 Heating: 0x43<br>
		 * Dehumidification: 0x44<br>
		 * Air circulator: 0x45<br>
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
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformOperationModeSetting() {
			reqInformProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Rated power consumption of outdoor unit<br>
		 * <br>
		 * EPC : 0xB8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the rated power consumption for the cooling, heating and dehumidification modes.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)<br>
		 * Cooling: heating: dehumidification<br>
		 * <br>
		 * Data type : unsigned short × 3<br>
		 * <br>
		 * Data size : 6 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRatedPowerConsumptionOfOutdoorUnit() {
			reqInformProperty(EPC_RATED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT);
			return this;
		}
		/**
		 * Property name : Measured electric current consumption of outdoor unit<br>
		 * <br>
		 * EPC : 0xB9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured electric current consumption.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredElectricCurrentConsumptionOfOutdoorUnit() {
			reqInformProperty(EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_OUTDOOR_UNIT);
			return this;
		}
		/**
		 * Property name : Measured outdoor air temperature 1<br>
		 * <br>
		 * EPC : 0xBE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured temperature of the outdoor air.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-127.125°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredOutdoorAirTemperature1() {
			reqInformProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE1);
			return this;
		}
		/**
		 * Property name : “Special” state<br>
		 * <br>
		 * EPC : 0xAA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates when the air conditioner is in the “special” state<br>
		 * (i.e. “defrosting” state).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” state = 0x40,<br>
		 * “defrosting” state = 0x41<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSpecialState() {
			reqInformProperty(EPC_SPECIAL_STATE);
			return this;
		}
		/**
		 * Property name : Operation status of compressor<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the operation status<br>
		 * (i.e. ON or OFF) of the compressor.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Compressor ON: 0x41 Compressor OFF: 0x42<br>
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
		public Informer reqInformOperationStatusOfCompressor() {
			reqInformProperty(EPC_OPERATION_STATUS_OF_COMPRESSOR);
			return this;
		}
		/**
		 * Property name : Operation mode information<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current operation mode (i.e. “cooling,” “heating,” “dehumidification” or “other”).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Cooling: 0x42 Heating: 0x43<br>
		 * Dehumidification: 0x44 Other: 0x40<br>
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
		 * Get - mandatory<br>
		 */
		public Informer reqInformOperationModeInformation() {
			reqInformProperty(EPC_OPERATION_MODE_INFORMATION);
			return this;
		}
		/**
		 * Property name : Fan rotation speed<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the rotation speed of the fan of the outdoor unit (expressed in %).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformFanRotationSpeed() {
			reqInformProperty(EPC_FAN_ROTATION_SPEED);
			return this;
		}
		/**
		 * Property name : Measured power consumption of outdoor unit<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured power consumption of the outdoor unit.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)<br>
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
		public Informer reqInformMeasuredPowerConsumptionOfOutdoorUnit() {
			reqInformProperty(EPC_MEASURED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT);
			return this;
		}
		/**
		 * Property name : Measured outdoor air temperature 2<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured temperature of the outdoor air.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xF554.0x7FFD (-273,2 .3276.5°C)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredOutdoorAirTemperature2() {
			reqInformProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE2);
			return this;
		}
	}

	public static class Proxy extends PackageTypeCommercialAirConditionerOutdoorUnit {
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
		protected byte[] getOperationModeInformation() {return null;}
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
