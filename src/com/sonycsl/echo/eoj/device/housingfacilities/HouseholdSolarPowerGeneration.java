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

public abstract class HouseholdSolarPowerGeneration extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0279;

	public static final byte EPC_SYSTEM_INTERCONN_ECTED_TYPE = (byte)0xD0;
	public static final byte EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRICITY_GENERATED = (byte)0xE0;
	public static final byte EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED = (byte)0xE1;
	public static final byte EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED = (byte)0xE2;
	public static final byte EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD = (byte)0xE3;
	public static final byte EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD = (byte)0xE4;
	public static final byte EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1 = (byte)0xE5;
	public static final byte EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2 = (byte)0xE6;
	public static final byte EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD = (byte)0xE7;
	public static final byte EPC_RATED_POWER_GENERATION_OUTPUT_SYSTEM_INTERCONNECTED = (byte)0xE8;
	public static final byte EPC_RATED_POWER_GENERATION_OUTPUT_INDEPENDENT = (byte)0xE9;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRICITY_GENERATED);
		addGetProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewHouseholdSolarPowerGeneration(this);
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
	 * Property name : System-interconn ected type<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates system interconnection status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * System-linked type (reverse power flow acceptable) = 0x00 Independent type = 0x01<br>
	 * System-linked   type    (reverse power flow not acceptable) =0x02<br>
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
	protected byte[] getSystemInterconnEctedType() {return null;}
	/**
	 * Property name : System-interconn ected type<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates system interconnection status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * System-linked type (reverse power flow acceptable) = 0x00 Independent type = 0x01<br>
	 * System-linked   type    (reverse power flow not acceptable) =0x02<br>
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
	protected boolean isValidSystemInterconnEctedType(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured instantaneous amount of electricity generated<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates instantaneous generated power in W.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533)<br>
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
	protected abstract byte[] getMeasuredInstantaneousAmountOfElectricityGenerated();
	/**
	 * Property name : Measured instantaneous amount of electricity generated<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates instantaneous generated power in W.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533)<br>
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
	protected boolean isValidMeasuredInstantaneousAmountOfElectricityGenerated(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Measured cumulative amount of electricity generated<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates integral electric energy in 0.001 kWh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999.999 kWh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.001
kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getMeasuredCumulativeAmountOfElectricityGenerated();
	/**
	 * Property name : Measured cumulative amount of electricity generated<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates integral electric energy in 0.001 kWh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999.999 kWh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.001
kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidMeasuredCumulativeAmountOfElectricityGenerated(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Resetting cumulative amount of electricity generated<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * Resets integral generated electric energy by setting 0x00.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset = 0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - undefined<br>
	 */
	protected boolean setResettingCumulativeAmountOfElectricityGenerated(byte[] edt) {return false;}
	/**
	 * Property name : Resetting cumulative amount of electricity generated<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * Resets integral generated electric energy by setting 0x00.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset = 0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - undefined<br>
	 */
	protected boolean isValidResettingCumulativeAmountOfElectricityGenerated(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured cumulative amount of electricity sold<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates integral value of sold power in 0.001 kWh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999.999 kWh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.001
kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredCumulativeAmountOfElectricitySold() {return null;}
	/**
	 * Property name : Measured cumulative amount of electricity sold<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates integral value of sold power in 0.001 kWh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999.999 kWh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.001
kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredCumulativeAmountOfElectricitySold(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Resetting cumulative amount of electricity sold<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Resets integral sold electric energy by setting 0x00.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset = 0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - undefined<br>
	 */
	protected boolean setResettingCumulativeAmountOfElectricitySold(byte[] edt) {return false;}
	/**
	 * Property name : Resetting cumulative amount of electricity sold<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Resets integral sold electric energy by setting 0x00.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset = 0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - undefined<br>
	 */
	protected boolean isValidResettingCumulativeAmountOfElectricitySold(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Power generation output limit setting 1<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br>
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
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setPowerGenerationOutputLimitSetting1(byte[] edt) {return false;}
	/**
	 * Property name : Power generation output limit setting 1<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br>
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
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getPowerGenerationOutputLimitSetting1() {return null;}
	/**
	 * Property name : Power generation output limit setting 1<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br>
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
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidPowerGenerationOutputLimitSetting1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Power generation output limit setting 2<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies the power generation output in watts and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setPowerGenerationOutputLimitSetting2(byte[] edt) {return false;}
	/**
	 * Property name : Power generation output limit setting 2<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies the power generation output in watts and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getPowerGenerationOutputLimitSetting2() {return null;}
	/**
	 * Property name : Power generation output limit setting 2<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies the power generation output in watts and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidPowerGenerationOutputLimitSetting2(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Limit setting for the amount of electricity sold<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setLimitSettingForTheAmountOfElectricitySold(byte[] edt) {return false;}
	/**
	 * Property name : Limit setting for the amount of electricity sold<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getLimitSettingForTheAmountOfElectricitySold() {return null;}
	/**
	 * Property name : Limit setting for the amount of electricity sold<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidLimitSettingForTheAmountOfElectricitySold(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Rated power generation output(System-interconnected)<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated power output in the system-interconnected status in watts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0xFFFD (0–65,533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setRatedPowerGenerationOutputSystemInterconnected(byte[] edt) {return false;}
	/**
	 * Property name : Rated power generation output(System-interconnected)<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated power output in the system-interconnected status in watts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0xFFFD (0–65,533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getRatedPowerGenerationOutputSystemInterconnected() {return null;}
	/**
	 * Property name : Rated power generation output(System-interconnected)<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated power output in the system-interconnected status in watts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0xFFFD (0–65,533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRatedPowerGenerationOutputSystemInterconnected(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Rated power generation output (Independent)<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated power output in the independent status in watts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0xFFFD (0–65,533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setRatedPowerGenerationOutputIndependent(byte[] edt) {return false;}
	/**
	 * Property name : Rated power generation output (Independent)<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated power output in the independent status in watts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0xFFFD (0–65,533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getRatedPowerGenerationOutputIndependent() {return null;}
	/**
	 * Property name : Rated power generation output (Independent)<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated power output in the independent status in watts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0xFFFD (0–65,533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRatedPowerGenerationOutputIndependent(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED : return setResettingCumulativeAmountOfElectricityGenerated(property.edt);
		case EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD : return setResettingCumulativeAmountOfElectricitySold(property.edt);
		case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1 : return setPowerGenerationOutputLimitSetting1(property.edt);
		case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2 : return setPowerGenerationOutputLimitSetting2(property.edt);
		case EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD : return setLimitSettingForTheAmountOfElectricitySold(property.edt);
		case EPC_RATED_POWER_GENERATION_OUTPUT_SYSTEM_INTERCONNECTED : return setRatedPowerGenerationOutputSystemInterconnected(property.edt);
		case EPC_RATED_POWER_GENERATION_OUTPUT_INDEPENDENT : return setRatedPowerGenerationOutputIndependent(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_SYSTEM_INTERCONN_ECTED_TYPE : return getSystemInterconnEctedType();
		case EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRICITY_GENERATED : return getMeasuredInstantaneousAmountOfElectricityGenerated();
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED : return getMeasuredCumulativeAmountOfElectricityGenerated();
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD : return getMeasuredCumulativeAmountOfElectricitySold();
		case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1 : return getPowerGenerationOutputLimitSetting1();
		case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2 : return getPowerGenerationOutputLimitSetting2();
		case EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD : return getLimitSettingForTheAmountOfElectricitySold();
		case EPC_RATED_POWER_GENERATION_OUTPUT_SYSTEM_INTERCONNECTED : return getRatedPowerGenerationOutputSystemInterconnected();
		case EPC_RATED_POWER_GENERATION_OUTPUT_INDEPENDENT : return getRatedPowerGenerationOutputIndependent();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_SYSTEM_INTERCONN_ECTED_TYPE : return isValidSystemInterconnEctedType(property.edt);
		case EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRICITY_GENERATED : return isValidMeasuredInstantaneousAmountOfElectricityGenerated(property.edt);
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED : return isValidMeasuredCumulativeAmountOfElectricityGenerated(property.edt);
		case EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED : return isValidResettingCumulativeAmountOfElectricityGenerated(property.edt);
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD : return isValidMeasuredCumulativeAmountOfElectricitySold(property.edt);
		case EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD : return isValidResettingCumulativeAmountOfElectricitySold(property.edt);
		case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1 : return isValidPowerGenerationOutputLimitSetting1(property.edt);
		case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2 : return isValidPowerGenerationOutputLimitSetting2(property.edt);
		case EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD : return isValidLimitSettingForTheAmountOfElectricitySold(property.edt);
		case EPC_RATED_POWER_GENERATION_OUTPUT_SYSTEM_INTERCONNECTED : return isValidRatedPowerGenerationOutputSystemInterconnected(property.edt);
		case EPC_RATED_POWER_GENERATION_OUTPUT_INDEPENDENT : return isValidRatedPowerGenerationOutputIndependent(property.edt);
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
			case EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED : 
				onSetResettingCumulativeAmountOfElectricityGenerated(eoj, tid, esv, property, success);
				return true;
			case EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD : 
				onSetResettingCumulativeAmountOfElectricitySold(eoj, tid, esv, property, success);
				return true;
			case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1 : 
				onSetPowerGenerationOutputLimitSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2 : 
				onSetPowerGenerationOutputLimitSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD : 
				onSetLimitSettingForTheAmountOfElectricitySold(eoj, tid, esv, property, success);
				return true;
			case EPC_RATED_POWER_GENERATION_OUTPUT_SYSTEM_INTERCONNECTED : 
				onSetRatedPowerGenerationOutputSystemInterconnected(eoj, tid, esv, property, success);
				return true;
			case EPC_RATED_POWER_GENERATION_OUTPUT_INDEPENDENT : 
				onSetRatedPowerGenerationOutputIndependent(eoj, tid, esv, property, success);
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
			case EPC_SYSTEM_INTERCONN_ECTED_TYPE : 
				onGetSystemInterconnEctedType(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRICITY_GENERATED : 
				onGetMeasuredInstantaneousAmountOfElectricityGenerated(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED : 
				onGetMeasuredCumulativeAmountOfElectricityGenerated(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD : 
				onGetMeasuredCumulativeAmountOfElectricitySold(eoj, tid, esv, property, success);
				return true;
			case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1 : 
				onGetPowerGenerationOutputLimitSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2 : 
				onGetPowerGenerationOutputLimitSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD : 
				onGetLimitSettingForTheAmountOfElectricitySold(eoj, tid, esv, property, success);
				return true;
			case EPC_RATED_POWER_GENERATION_OUTPUT_SYSTEM_INTERCONNECTED : 
				onGetRatedPowerGenerationOutputSystemInterconnected(eoj, tid, esv, property, success);
				return true;
			case EPC_RATED_POWER_GENERATION_OUTPUT_INDEPENDENT : 
				onGetRatedPowerGenerationOutputIndependent(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : System-interconn ected type<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates system interconnection status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * System-linked type (reverse power flow acceptable) = 0x00 Independent type = 0x01<br>
		 * System-linked   type    (reverse power flow not acceptable) =0x02<br>
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
		protected void onGetSystemInterconnEctedType(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured instantaneous amount of electricity generated<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates instantaneous generated power in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533)<br>
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
		protected void onGetMeasuredInstantaneousAmountOfElectricityGenerated(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured cumulative amount of electricity generated<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral electric energy in 0.001 kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999.999 kWh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001
kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetMeasuredCumulativeAmountOfElectricityGenerated(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Resetting cumulative amount of electricity generated<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Resets integral generated electric energy by setting 0x00.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset = 0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - undefined<br>
		 */
		protected void onSetResettingCumulativeAmountOfElectricityGenerated(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured cumulative amount of electricity sold<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral value of sold power in 0.001 kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999.999 kWh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001
kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredCumulativeAmountOfElectricitySold(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Resetting cumulative amount of electricity sold<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Resets integral sold electric energy by setting 0x00.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset = 0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - undefined<br>
		 */
		protected void onSetResettingCumulativeAmountOfElectricitySold(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Power generation output limit setting 1<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br>
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
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetPowerGenerationOutputLimitSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Power generation output limit setting 1<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br>
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
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetPowerGenerationOutputLimitSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Power generation output limit setting 2<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the power generation output in watts and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetPowerGenerationOutputLimitSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Power generation output limit setting 2<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the power generation output in watts and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetPowerGenerationOutputLimitSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Limit setting for the amount of electricity sold<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetLimitSettingForTheAmountOfElectricitySold(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Limit setting for the amount of electricity sold<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetLimitSettingForTheAmountOfElectricitySold(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rated power generation output(System-interconnected)<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power output in the system-interconnected status in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetRatedPowerGenerationOutputSystemInterconnected(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rated power generation output(System-interconnected)<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power output in the system-interconnected status in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetRatedPowerGenerationOutputSystemInterconnected(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rated power generation output (Independent)<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power output in the independent status in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetRatedPowerGenerationOutputIndependent(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rated power generation output (Independent)<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power output in the independent status in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetRatedPowerGenerationOutputIndependent(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Resetting cumulative amount of electricity generated<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Resets integral generated electric energy by setting 0x00.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset = 0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - undefined<br>
		 */
		public Setter reqSetResettingCumulativeAmountOfElectricityGenerated(byte[] edt) {
			reqSetProperty(EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED, edt);
			return this;
		}
		/**
		 * Property name : Resetting cumulative amount of electricity sold<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Resets integral sold electric energy by setting 0x00.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset = 0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - undefined<br>
		 */
		public Setter reqSetResettingCumulativeAmountOfElectricitySold(byte[] edt) {
			reqSetProperty(EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD, edt);
			return this;
		}
		/**
		 * Property name : Power generation output limit setting 1<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br>
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
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetPowerGenerationOutputLimitSetting1(byte[] edt) {
			reqSetProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1, edt);
			return this;
		}
		/**
		 * Property name : Power generation output limit setting 2<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the power generation output in watts and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetPowerGenerationOutputLimitSetting2(byte[] edt) {
			reqSetProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2, edt);
			return this;
		}
		/**
		 * Property name : Limit setting for the amount of electricity sold<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetLimitSettingForTheAmountOfElectricitySold(byte[] edt) {
			reqSetProperty(EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD, edt);
			return this;
		}
		/**
		 * Property name : Rated power generation output(System-interconnected)<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power output in the system-interconnected status in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetRatedPowerGenerationOutputSystemInterconnected(byte[] edt) {
			reqSetProperty(EPC_RATED_POWER_GENERATION_OUTPUT_SYSTEM_INTERCONNECTED, edt);
			return this;
		}
		/**
		 * Property name : Rated power generation output (Independent)<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power output in the independent status in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetRatedPowerGenerationOutputIndependent(byte[] edt) {
			reqSetProperty(EPC_RATED_POWER_GENERATION_OUTPUT_INDEPENDENT, edt);
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
		 * Property name : System-interconn ected type<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates system interconnection status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * System-linked type (reverse power flow acceptable) = 0x00 Independent type = 0x01<br>
		 * System-linked   type    (reverse power flow not acceptable) =0x02<br>
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
		public Getter reqGetSystemInterconnEctedType() {
			reqGetProperty(EPC_SYSTEM_INTERCONN_ECTED_TYPE);
			return this;
		}
		/**
		 * Property name : Measured instantaneous amount of electricity generated<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates instantaneous generated power in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533)<br>
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
		public Getter reqGetMeasuredInstantaneousAmountOfElectricityGenerated() {
			reqGetProperty(EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRICITY_GENERATED);
			return this;
		}
		/**
		 * Property name : Measured cumulative amount of electricity generated<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral electric energy in 0.001 kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999.999 kWh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001
kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetMeasuredCumulativeAmountOfElectricityGenerated() {
			reqGetProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED);
			return this;
		}
		/**
		 * Property name : Measured cumulative amount of electricity sold<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral value of sold power in 0.001 kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999.999 kWh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001
kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredCumulativeAmountOfElectricitySold() {
			reqGetProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD);
			return this;
		}
		/**
		 * Property name : Power generation output limit setting 1<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br>
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
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetPowerGenerationOutputLimitSetting1() {
			reqGetProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1);
			return this;
		}
		/**
		 * Property name : Power generation output limit setting 2<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the power generation output in watts and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetPowerGenerationOutputLimitSetting2() {
			reqGetProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2);
			return this;
		}
		/**
		 * Property name : Limit setting for the amount of electricity sold<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetLimitSettingForTheAmountOfElectricitySold() {
			reqGetProperty(EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD);
			return this;
		}
		/**
		 * Property name : Rated power generation output(System-interconnected)<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power output in the system-interconnected status in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRatedPowerGenerationOutputSystemInterconnected() {
			reqGetProperty(EPC_RATED_POWER_GENERATION_OUTPUT_SYSTEM_INTERCONNECTED);
			return this;
		}
		/**
		 * Property name : Rated power generation output (Independent)<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power output in the independent status in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRatedPowerGenerationOutputIndependent() {
			reqGetProperty(EPC_RATED_POWER_GENERATION_OUTPUT_INDEPENDENT);
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
		 * Property name : System-interconn ected type<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates system interconnection status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * System-linked type (reverse power flow acceptable) = 0x00 Independent type = 0x01<br>
		 * System-linked   type    (reverse power flow not acceptable) =0x02<br>
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
		public Informer reqInformSystemInterconnEctedType() {
			reqInformProperty(EPC_SYSTEM_INTERCONN_ECTED_TYPE);
			return this;
		}
		/**
		 * Property name : Measured instantaneous amount of electricity generated<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates instantaneous generated power in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533)<br>
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
		public Informer reqInformMeasuredInstantaneousAmountOfElectricityGenerated() {
			reqInformProperty(EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRICITY_GENERATED);
			return this;
		}
		/**
		 * Property name : Measured cumulative amount of electricity generated<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral electric energy in 0.001 kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999.999 kWh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001
kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformMeasuredCumulativeAmountOfElectricityGenerated() {
			reqInformProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED);
			return this;
		}
		/**
		 * Property name : Measured cumulative amount of electricity sold<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral value of sold power in 0.001 kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999.999 kWh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001
kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredCumulativeAmountOfElectricitySold() {
			reqInformProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD);
			return this;
		}
		/**
		 * Property name : Power generation output limit setting 1<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br>
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
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformPowerGenerationOutputLimitSetting1() {
			reqInformProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1);
			return this;
		}
		/**
		 * Property name : Power generation output limit setting 2<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the power generation output in watts and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformPowerGenerationOutputLimitSetting2() {
			reqInformProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2);
			return this;
		}
		/**
		 * Property name : Limit setting for the amount of electricity sold<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformLimitSettingForTheAmountOfElectricitySold() {
			reqInformProperty(EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD);
			return this;
		}
		/**
		 * Property name : Rated power generation output(System-interconnected)<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power output in the system-interconnected status in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRatedPowerGenerationOutputSystemInterconnected() {
			reqInformProperty(EPC_RATED_POWER_GENERATION_OUTPUT_SYSTEM_INTERCONNECTED);
			return this;
		}
		/**
		 * Property name : Rated power generation output (Independent)<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power output in the independent status in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0xFFFD (0–65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRatedPowerGenerationOutputIndependent() {
			reqInformProperty(EPC_RATED_POWER_GENERATION_OUTPUT_INDEPENDENT);
			return this;
		}
	}

	public static class Proxy extends HouseholdSolarPowerGeneration {
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
		protected byte[] getMeasuredInstantaneousAmountOfElectricityGenerated() {return null;}
		@Override
		protected byte[] getMeasuredCumulativeAmountOfElectricityGenerated() {return null;}
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
