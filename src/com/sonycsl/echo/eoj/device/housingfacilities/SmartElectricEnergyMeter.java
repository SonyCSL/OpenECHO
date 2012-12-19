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

public abstract class SmartElectricEnergyMeter extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0288;

	public static final byte EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION = (byte)0xD0;
	public static final byte EPC_OWNER_CLASSIFICATION = (byte)0xD1;
	public static final byte EPC_CONFIGURATION_INFORMATION_OF_PHASES_AND_WIRES_OF_THE_SYSTEMS = (byte)0xD2;
	public static final byte EPC_COMPOSITE_TRANSFORMATION_RATIO = (byte)0xD3;
	public static final byte EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO = (byte)0xD4;
	public static final byte EPC_METER_TYPE_CERTIFICATION_NUMBER_TYPE_APPROVAL_NUMBER_IN_JAPAN = (byte)0xD5;
	public static final byte EPC_VERIFICATION_EXPIRATION_DATE = (byte)0xD6;
	public static final byte EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION = (byte)0xE0;
	public static final byte EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS = (byte)0xE1;
	public static final byte EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION = (byte)0xE2;
	public static final byte EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION = (byte)0xE3;
	public static final byte EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION = (byte)0xE4;
	public static final byte EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED = (byte)0xE5;
	public static final byte EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRIC_ENERGY = (byte)0xE7;
	public static final byte EPC_MEASURED_INSTANTANEOUS_CURRENTS = (byte)0xE8;
	public static final byte EPC_MEASURED_INSTANTANEOUS_VOLTAGES = (byte)0xE9;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_METER_TYPE_CERTIFICATION_NUMBER_TYPE_APPROVAL_NUMBER_IN_JAPAN);
		addGetProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
		addGetProperty(EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS);
	}
	
	@Override
	public void initialize(EchoNode node) {
		super.initialize(node);
		Echo.EventListener listener = Echo.getEventListener();
		if(listener != null) listener.onNewSmartElectricEnergyMeter(this);
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
	 * This property indicates the ON/OFF<br>
	 * status.<br>
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
	 * Property name : Electric energy meter classification<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the electric energy meter type.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30�FElectric utility company<br>
	 * 0x31�FSolar power<br>
	 * 0x32�FFuel cell<br>
	 * 0x33�FBattery<br>
	 * 0x34�FEV<br>
	 * 0x35�FOthers<br>
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
	protected boolean setElectricEnergyMeterClassification(byte[] edt) {return false;}
	/**
	 * Property name : Electric energy meter classification<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the electric energy meter type.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30�FElectric utility company<br>
	 * 0x31�FSolar power<br>
	 * 0x32�FFuel cell<br>
	 * 0x33�FBattery<br>
	 * 0x34�FEV<br>
	 * 0x35�FOthers<br>
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
	protected byte[] getElectricEnergyMeterClassification() {return null;}
	/**
	 * Property name : Electric energy meter classification<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the electric energy meter type.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30�FElectric utility company<br>
	 * 0x31�FSolar power<br>
	 * 0x32�FFuel cell<br>
	 * 0x33�FBattery<br>
	 * 0x34�FEV<br>
	 * 0x35�FOthers<br>
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
	protected boolean isValidElectricEnergyMeterClassification(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Owner classification<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the type of the owner of the meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30�FNot specified<br>
	 * 0x31�FElectric utility company<br>
	 * 0x32�FPrivate sector company<br>
	 * 0x33�FIndividual<br>
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
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the type of the owner of the meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30�FNot specified<br>
	 * 0x31�FElectric utility company<br>
	 * 0x32�FPrivate sector company<br>
	 * 0x33�FIndividual<br>
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
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the type of the owner of the meter.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30�FNot specified<br>
	 * 0x31�FElectric utility company<br>
	 * 0x32�FPrivate sector company<br>
	 * 0x33�FIndividual<br>
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
	 * Property name : Configuration information of phases and wires of the systems<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the configuration regarding the phases and wires of the system.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Single-phase, two-wire system�F<br>
	 * 0x30<br>
	 * Single-phase, three-wire system�F<br>
	 * 0x31<br>
	 * Three-phase, three-wire system�F<br>
	 * 0x32<br>
	 * Three-phase, four-wire system�F<br>
	 * 0x33<br>
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
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getConfigurationInformationOfPhasesAndWiresOfTheSystems() {return null;}
	/**
	 * Property name : Configuration information of phases and wires of the systems<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the configuration regarding the phases and wires of the system.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Single-phase, two-wire system�F<br>
	 * 0x30<br>
	 * Single-phase, three-wire system�F<br>
	 * 0x31<br>
	 * Three-phase, three-wire system�F<br>
	 * 0x32<br>
	 * Three-phase, four-wire system�F<br>
	 * 0x33<br>
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
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidConfigurationInformationOfPhasesAndWiresOfTheSystems(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Composite transformation ratio<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the composite transformation ratio using a 6-digit decimal notation number (initial value = 1).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000-0x000F423F<br>
	 * (000000-999999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getCompositeTransformationRatio() {return null;}
	/**
	 * Property name : Composite transformation ratio<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the composite transformation ratio using a 6-digit decimal notation number (initial value = 1).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000-0x000F423F<br>
	 * (000000-999999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidCompositeTransformationRatio(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Multiplying factor for composite transformation ratio<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the multiplying factor for the composite transformation ratio.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00�F�~1(initial value)<br>
	 * 0x01�F�~0.1<br>
	 * 0x02�F�~0.01<br>
	 * 0x03�F�~0.001<br>
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
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMultiplyingFactorForCompositeTransformationRatio() {return null;}
	/**
	 * Property name : Multiplying factor for composite transformation ratio<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the multiplying factor for the composite transformation ratio.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00�F�~1(initial value)<br>
	 * 0x01�F�~0.1<br>
	 * 0x02�F�~0.01<br>
	 * 0x03�F�~0.001<br>
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
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMultiplyingFactorForCompositeTransformationRatio(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Meter type certification number (type approval number in Japan)<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the<br>
	 * type-certified meter number using alphanumeric characters<br>
	 * (0x20-0x70).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Type-certified meter (type number):<br>
	 * 0000-0��������-<br>
	 * 9999-9��������<br>
	 * Non-type certified meter: FFFFFFFFFF (initial value)<br>
	 * <br>
	 * Data type : unsigned char x 10<br>
	 * <br>
	 * Data size : 10
Byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getMeterTypeCertificationNumberTypeApprovalNumberInJapan();
	/**
	 * Property name : Meter type certification number (type approval number in Japan)<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the<br>
	 * type-certified meter number using alphanumeric characters<br>
	 * (0x20-0x70).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Type-certified meter (type number):<br>
	 * 0000-0��������-<br>
	 * 9999-9��������<br>
	 * Non-type certified meter: FFFFFFFFFF (initial value)<br>
	 * <br>
	 * Data type : unsigned char x 10<br>
	 * <br>
	 * Data size : 10
Byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidMeterTypeCertificationNumberTypeApprovalNumberInJapan(byte[] edt) {
		if(edt == null || !(edt.length == 10)) return false;
		return true;
	}
	/**
	 * Property name : Verification expiration date<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates, in the form of an ASCII code, the month and year in which the verification of<br>
	 * the meter will expire.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * YYYYMM<br>
	 * YYYY (Year), MM (Month)<br>
	 * <br>
	 * Data type : unsigned char x 6<br>
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
	protected boolean setVerificationExpirationDate(byte[] edt) {return false;}
	/**
	 * Property name : Verification expiration date<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates, in the form of an ASCII code, the month and year in which the verification of<br>
	 * the meter will expire.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * YYYYMM<br>
	 * YYYY (Year), MM (Month)<br>
	 * <br>
	 * Data type : unsigned char x 6<br>
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
	protected byte[] getVerificationExpirationDate() {return null;}
	/**
	 * Property name : Verification expiration date<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates, in the form of an ASCII code, the month and year in which the verification of<br>
	 * the meter will expire.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * YYYYMM<br>
	 * YYYY (Year), MM (Month)<br>
	 * <br>
	 * Data type : unsigned char x 6<br>
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
	protected boolean isValidVerificationExpirationDate(byte[] edt) {
		if(edt == null || !(edt.length == 6)) return false;
		return true;
	}
	/**
	 * Property name : Measured cumulative amount of electric energy (normal direction)<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000-0x05F5E0FF<br>
	 * (0-99,999,999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
	/**
	 * Property name : Measured cumulative amount of electric energy (normal direction)<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000-0x05F5E0FF<br>
	 * (0-99,999,999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidMeasuredCumulativeAmountOfElectricEnergyNormalDirection(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Unit for cumulative amounts of electric energy (normal and reverse directions)<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00: 1kWh<br>
	 * 0x01: 0.1kWh<br>
	 * 0x02: 0.01kWh<br>
	 * 0x03: 0.001kWh (Initial value)<br>
	 * 0x04: 0.0001kWh<br>
	 * 0x0A: 10kWh<br>
	 * 0x0B: 100kWh<br>
	 * 0x0C: 1000kWh<br>
	 * 0x0D: 10000kWh<br>
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
	protected abstract byte[] getUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections();
	/**
	 * Property name : Unit for cumulative amounts of electric energy (normal and reverse directions)<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00: 1kWh<br>
	 * 0x01: 0.1kWh<br>
	 * 0x02: 0.01kWh<br>
	 * 0x03: 0.001kWh (Initial value)<br>
	 * 0x04: 0.0001kWh<br>
	 * 0x0A: 10kWh<br>
	 * 0x0B: 100kWh<br>
	 * 0x0C: 1000kWh<br>
	 * 0x0D: 10000kWh<br>
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
	protected boolean isValidUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Historical data of measured cumulative amounts of electric energy
(normal direction)<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of<br>
	 * measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of<br>
	 * half-hourly data for the preceding<br>
	 * 24 hours.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0x0063:<br>
	 * 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)<br>
	 * <br>
	 * Data type : unsigned short
+ unsigned long
x48<br>
	 * <br>
	 * Data size : 194
Byte<br>
	 * <br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection() {return null;}
	/**
	 * Property name : Historical data of measured cumulative amounts of electric energy
(normal direction)<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of<br>
	 * measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of<br>
	 * half-hourly data for the preceding<br>
	 * 24 hours.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0x0063:<br>
	 * 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)<br>
	 * <br>
	 * Data type : unsigned short
+ unsigned long
x48<br>
	 * <br>
	 * Data size : 194
Byte<br>
	 * <br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(byte[] edt) {
		if(edt == null || !(edt.length == 194)) return false;
		return true;
	}
	/**
	 * Property name : Measured cumulative amount of electric energy (reverse direction)<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000-0x05F5E0FF<br>
	 * (0-99,999,999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredCumulativeAmountOfElectricEnergyReverseDirection() {return null;}
	/**
	 * Property name : Measured cumulative amount of electric energy (reverse direction)<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000-0x05F5E0FF<br>
	 * (0-99,999,999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredCumulativeAmountOfElectricEnergyReverseDirection(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Historical data of measured cumulative amounts of electric energy
(reverse direction)<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of<br>
	 * measured cumulative amounts of<br>
	 * electric energy (8 digits), which consists of 48 pieces of<br>
	 * half-hourly data for the preceding<br>
	 * 24 hours.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0x0063:<br>
	 * 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)<br>
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
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection() {return null;}
	/**
	 * Property name : Historical data of measured cumulative amounts of electric energy
(reverse direction)<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of<br>
	 * measured cumulative amounts of<br>
	 * electric energy (8 digits), which consists of 48 pieces of<br>
	 * half-hourly data for the preceding<br>
	 * 24 hours.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0x0063:<br>
	 * 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)<br>
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
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(byte[] edt) {
		if(edt == null || !(edt.length == 194)) return false;
		return true;
	}
	/**
	 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of<br>
	 * 48 pieces of half-hourly data for the preceding 24 hours) is to be<br>
	 * retrieved.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x63 ( 0-99)<br>
	 * 0: current day<br>
	 * 1  . 99: previous day . day that precedes the current day by<br>
	 * 99 days<br>
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
	protected boolean setDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte[] edt) {return false;}
	/**
	 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of<br>
	 * 48 pieces of half-hourly data for the preceding 24 hours) is to be<br>
	 * retrieved.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x63 ( 0-99)<br>
	 * 0: current day<br>
	 * 1  . 99: previous day . day that precedes the current day by<br>
	 * 99 days<br>
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
	protected byte[] getDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved() {return null;}
	/**
	 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of<br>
	 * 48 pieces of half-hourly data for the preceding 24 hours) is to be<br>
	 * retrieved.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x63 ( 0-99)<br>
	 * 0: current day<br>
	 * 1  . 99: previous day . day that precedes the current day by<br>
	 * 99 days<br>
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
	protected boolean isValidDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured instantaneous amount of electric energy<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x80000001-0x7FFFFFFD (-2,147,483,647-<br>
	 * 2,147,483,645)<br>
	 * <br>
	 * Data type : signed long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredInstantaneousAmountOfElectricEnergy() {return null;}
	/**
	 * Property name : Measured instantaneous amount of electric energy<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x80000001-0x7FFFFFFD (-2,147,483,647-<br>
	 * 2,147,483,645)<br>
	 * <br>
	 * Data type : signed long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredInstantaneousAmountOfElectricEnergy(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Measured instantaneous currents<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured effective instantaneous R and T phase currents in amperes.<br>
	 * In the case of a single-phase,<br>
	 * two-wire system, 0x7FFE shall be used for the T phase.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x8001-0x7FFD�iR phase�j<br>
	 * : 0x8001-0x7FFD�iT phase�j<br>
	 * (-3,276.7-3,276.5): (-3,276.7-3,276.5)<br>
	 * <br>
	 * Data type : signed short
�~2<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : 0.1
A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredInstantaneousCurrents() {return null;}
	/**
	 * Property name : Measured instantaneous currents<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured effective instantaneous R and T phase currents in amperes.<br>
	 * In the case of a single-phase,<br>
	 * two-wire system, 0x7FFE shall be used for the T phase.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x8001-0x7FFD�iR phase�j<br>
	 * : 0x8001-0x7FFD�iT phase�j<br>
	 * (-3,276.7-3,276.5): (-3,276.7-3,276.5)<br>
	 * <br>
	 * Data type : signed short
�~2<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : 0.1
A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredInstantaneousCurrents(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Measured instantaneous voltages<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a<br>
	 * single-phase, two-wire system,<br>
	 * 0xFFFE shall be used for the<br>
	 * S(N)-T voltage.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0xFFFD (between R and<br>
	 * S(N))�F<br>
	 * 0x0000-0xFFFD (between S(N)<br>
	 * and T)<br>
	 * (0-6,553.3) : (0-6,553.3)<br>
	 * <br>
	 * Data type : unsigned short
�~2<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : 0.1
V<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredInstantaneousVoltages() {return null;}
	/**
	 * Property name : Measured instantaneous voltages<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a<br>
	 * single-phase, two-wire system,<br>
	 * 0xFFFE shall be used for the<br>
	 * S(N)-T voltage.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0xFFFD (between R and<br>
	 * S(N))�F<br>
	 * 0x0000-0xFFFD (between S(N)<br>
	 * and T)<br>
	 * (0-6,553.3) : (0-6,553.3)<br>
	 * <br>
	 * Data type : unsigned short
�~2<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : 0.1
V<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredInstantaneousVoltages(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}

	@Override
	protected boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION : return setElectricEnergyMeterClassification(property.edt);
		case EPC_OWNER_CLASSIFICATION : return setOwnerClassification(property.edt);
		case EPC_VERIFICATION_EXPIRATION_DATE : return setVerificationExpirationDate(property.edt);
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED : return setDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION : return getElectricEnergyMeterClassification();
		case EPC_OWNER_CLASSIFICATION : return getOwnerClassification();
		case EPC_CONFIGURATION_INFORMATION_OF_PHASES_AND_WIRES_OF_THE_SYSTEMS : return getConfigurationInformationOfPhasesAndWiresOfTheSystems();
		case EPC_COMPOSITE_TRANSFORMATION_RATIO : return getCompositeTransformationRatio();
		case EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO : return getMultiplyingFactorForCompositeTransformationRatio();
		case EPC_METER_TYPE_CERTIFICATION_NUMBER_TYPE_APPROVAL_NUMBER_IN_JAPAN : return getMeterTypeCertificationNumberTypeApprovalNumberInJapan();
		case EPC_VERIFICATION_EXPIRATION_DATE : return getVerificationExpirationDate();
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION : return getMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
		case EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS : return getUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections();
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION : return getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection();
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION : return getMeasuredCumulativeAmountOfElectricEnergyReverseDirection();
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION : return getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection();
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED : return getDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved();
		case EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRIC_ENERGY : return getMeasuredInstantaneousAmountOfElectricEnergy();
		case EPC_MEASURED_INSTANTANEOUS_CURRENTS : return getMeasuredInstantaneousCurrents();
		case EPC_MEASURED_INSTANTANEOUS_VOLTAGES : return getMeasuredInstantaneousVoltages();
		default : return null;
		}
	}

	@Override
	protected boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION : return isValidElectricEnergyMeterClassification(property.edt);
		case EPC_OWNER_CLASSIFICATION : return isValidOwnerClassification(property.edt);
		case EPC_CONFIGURATION_INFORMATION_OF_PHASES_AND_WIRES_OF_THE_SYSTEMS : return isValidConfigurationInformationOfPhasesAndWiresOfTheSystems(property.edt);
		case EPC_COMPOSITE_TRANSFORMATION_RATIO : return isValidCompositeTransformationRatio(property.edt);
		case EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO : return isValidMultiplyingFactorForCompositeTransformationRatio(property.edt);
		case EPC_METER_TYPE_CERTIFICATION_NUMBER_TYPE_APPROVAL_NUMBER_IN_JAPAN : return isValidMeterTypeCertificationNumberTypeApprovalNumberInJapan(property.edt);
		case EPC_VERIFICATION_EXPIRATION_DATE : return isValidVerificationExpirationDate(property.edt);
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION : return isValidMeasuredCumulativeAmountOfElectricEnergyNormalDirection(property.edt);
		case EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS : return isValidUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections(property.edt);
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION : return isValidHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(property.edt);
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION : return isValidMeasuredCumulativeAmountOfElectricEnergyReverseDirection(property.edt);
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION : return isValidHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(property.edt);
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED : return isValidDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(property.edt);
		case EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRIC_ENERGY : return isValidMeasuredInstantaneousAmountOfElectricEnergy(property.edt);
		case EPC_MEASURED_INSTANTANEOUS_CURRENTS : return isValidMeasuredInstantaneousCurrents(property.edt);
		case EPC_MEASURED_INSTANTANEOUS_VOLTAGES : return isValidMeasuredInstantaneousVoltages(property.edt);
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
			case EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION : 
				onSetElectricEnergyMeterClassification(eoj, tid, esv, property, success);
				return true;
			case EPC_OWNER_CLASSIFICATION : 
				onSetOwnerClassification(eoj, tid, esv, property, success);
				return true;
			case EPC_VERIFICATION_EXPIRATION_DATE : 
				onSetVerificationExpirationDate(eoj, tid, esv, property, success);
				return true;
			case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED : 
				onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(eoj, tid, esv, property, success);
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
			case EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION : 
				onGetElectricEnergyMeterClassification(eoj, tid, esv, property, success);
				return true;
			case EPC_OWNER_CLASSIFICATION : 
				onGetOwnerClassification(eoj, tid, esv, property, success);
				return true;
			case EPC_CONFIGURATION_INFORMATION_OF_PHASES_AND_WIRES_OF_THE_SYSTEMS : 
				onGetConfigurationInformationOfPhasesAndWiresOfTheSystems(eoj, tid, esv, property, success);
				return true;
			case EPC_COMPOSITE_TRANSFORMATION_RATIO : 
				onGetCompositeTransformationRatio(eoj, tid, esv, property, success);
				return true;
			case EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO : 
				onGetMultiplyingFactorForCompositeTransformationRatio(eoj, tid, esv, property, success);
				return true;
			case EPC_METER_TYPE_CERTIFICATION_NUMBER_TYPE_APPROVAL_NUMBER_IN_JAPAN : 
				onGetMeterTypeCertificationNumberTypeApprovalNumberInJapan(eoj, tid, esv, property, success);
				return true;
			case EPC_VERIFICATION_EXPIRATION_DATE : 
				onGetVerificationExpirationDate(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION : 
				onGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection(eoj, tid, esv, property, success);
				return true;
			case EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS : 
				onGetUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections(eoj, tid, esv, property, success);
				return true;
			case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION : 
				onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION : 
				onGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection(eoj, tid, esv, property, success);
				return true;
			case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION : 
				onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(eoj, tid, esv, property, success);
				return true;
			case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED : 
				onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRIC_ENERGY : 
				onGetMeasuredInstantaneousAmountOfElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INSTANTANEOUS_CURRENTS : 
				onGetMeasuredInstantaneousCurrents(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INSTANTANEOUS_VOLTAGES : 
				onGetMeasuredInstantaneousVoltages(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Electric energy meter classification<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the electric energy meter type.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30�FElectric utility company<br>
		 * 0x31�FSolar power<br>
		 * 0x32�FFuel cell<br>
		 * 0x33�FBattery<br>
		 * 0x34�FEV<br>
		 * 0x35�FOthers<br>
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
		protected void onSetElectricEnergyMeterClassification(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Electric energy meter classification<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the electric energy meter type.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30�FElectric utility company<br>
		 * 0x31�FSolar power<br>
		 * 0x32�FFuel cell<br>
		 * 0x33�FBattery<br>
		 * 0x34�FEV<br>
		 * 0x35�FOthers<br>
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
		protected void onGetElectricEnergyMeterClassification(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Owner classification<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of the owner of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30�FNot specified<br>
		 * 0x31�FElectric utility company<br>
		 * 0x32�FPrivate sector company<br>
		 * 0x33�FIndividual<br>
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
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of the owner of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30�FNot specified<br>
		 * 0x31�FElectric utility company<br>
		 * 0x32�FPrivate sector company<br>
		 * 0x33�FIndividual<br>
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
		 * Property name : Configuration information of phases and wires of the systems<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the configuration regarding the phases and wires of the system.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Single-phase, two-wire system�F<br>
		 * 0x30<br>
		 * Single-phase, three-wire system�F<br>
		 * 0x31<br>
		 * Three-phase, three-wire system�F<br>
		 * 0x32<br>
		 * Three-phase, four-wire system�F<br>
		 * 0x33<br>
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
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetConfigurationInformationOfPhasesAndWiresOfTheSystems(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Composite transformation ratio<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the composite transformation ratio using a 6-digit decimal notation number (initial value = 1).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x000F423F<br>
		 * (000000-999999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetCompositeTransformationRatio(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Multiplying factor for composite transformation ratio<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the multiplying factor for the composite transformation ratio.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00�F�~1(initial value)<br>
		 * 0x01�F�~0.1<br>
		 * 0x02�F�~0.01<br>
		 * 0x03�F�~0.001<br>
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
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMultiplyingFactorForCompositeTransformationRatio(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Meter type certification number (type approval number in Japan)<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the<br>
		 * type-certified meter number using alphanumeric characters<br>
		 * (0x20-0x70).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Type-certified meter (type number):<br>
		 * 0000-0��������-<br>
		 * 9999-9��������<br>
		 * Non-type certified meter: FFFFFFFFFF (initial value)<br>
		 * <br>
		 * Data type : unsigned char x 10<br>
		 * <br>
		 * Data size : 10
Byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetMeterTypeCertificationNumberTypeApprovalNumberInJapan(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Verification expiration date<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates, in the form of an ASCII code, the month and year in which the verification of<br>
		 * the meter will expire.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * YYYYMM<br>
		 * YYYY (Year), MM (Month)<br>
		 * <br>
		 * Data type : unsigned char x 6<br>
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
		protected void onSetVerificationExpirationDate(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Verification expiration date<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates, in the form of an ASCII code, the month and year in which the verification of<br>
		 * the meter will expire.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * YYYYMM<br>
		 * YYYY (Year), MM (Month)<br>
		 * <br>
		 * Data type : unsigned char x 6<br>
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
		protected void onGetVerificationExpirationDate(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured cumulative amount of electric energy (normal direction)<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x05F5E0FF<br>
		 * (0-99,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Unit for cumulative amounts of electric energy (normal and reverse directions)<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00: 1kWh<br>
		 * 0x01: 0.1kWh<br>
		 * 0x02: 0.01kWh<br>
		 * 0x03: 0.001kWh (Initial value)<br>
		 * 0x04: 0.0001kWh<br>
		 * 0x0A: 10kWh<br>
		 * 0x0B: 100kWh<br>
		 * 0x0C: 1000kWh<br>
		 * 0x0D: 10000kWh<br>
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
		protected void onGetUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Historical data of measured cumulative amounts of electric energy
(normal direction)<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of<br>
		 * measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of<br>
		 * half-hourly data for the preceding<br>
		 * 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x0063:<br>
		 * 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)<br>
		 * <br>
		 * Data type : unsigned short
+ unsigned long
x48<br>
		 * <br>
		 * Data size : 194
Byte<br>
		 * <br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured cumulative amount of electric energy (reverse direction)<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x05F5E0FF<br>
		 * (0-99,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Historical data of measured cumulative amounts of electric energy
(reverse direction)<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of<br>
		 * measured cumulative amounts of<br>
		 * electric energy (8 digits), which consists of 48 pieces of<br>
		 * half-hourly data for the preceding<br>
		 * 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x0063:<br>
		 * 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)<br>
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
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of<br>
		 * 48 pieces of half-hourly data for the preceding 24 hours) is to be<br>
		 * retrieved.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x63 ( 0-99)<br>
		 * 0: current day<br>
		 * 1  . 99: previous day . day that precedes the current day by<br>
		 * 99 days<br>
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
		protected void onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of<br>
		 * 48 pieces of half-hourly data for the preceding 24 hours) is to be<br>
		 * retrieved.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x63 ( 0-99)<br>
		 * 0: current day<br>
		 * 1  . 99: previous day . day that precedes the current day by<br>
		 * 99 days<br>
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
		protected void onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured instantaneous amount of electric energy<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x80000001-0x7FFFFFFD (-2,147,483,647-<br>
		 * 2,147,483,645)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredInstantaneousAmountOfElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured instantaneous currents<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured effective instantaneous R and T phase currents in amperes.<br>
		 * In the case of a single-phase,<br>
		 * two-wire system, 0x7FFE shall be used for the T phase.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x8001-0x7FFD�iR phase�j<br>
		 * : 0x8001-0x7FFD�iT phase�j<br>
		 * (-3,276.7-3,276.5): (-3,276.7-3,276.5)<br>
		 * <br>
		 * Data type : signed short
�~2<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : 0.1
A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredInstantaneousCurrents(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured instantaneous voltages<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a<br>
		 * single-phase, two-wire system,<br>
		 * 0xFFFE shall be used for the<br>
		 * S(N)-T voltage.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0xFFFD (between R and<br>
		 * S(N))�F<br>
		 * 0x0000-0xFFFD (between S(N)<br>
		 * and T)<br>
		 * (0-6,553.3) : (0-6,553.3)<br>
		 * <br>
		 * Data type : unsigned short
�~2<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : 0.1
V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredInstantaneousVoltages(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Electric energy meter classification<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the electric energy meter type.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30�FElectric utility company<br>
		 * 0x31�FSolar power<br>
		 * 0x32�FFuel cell<br>
		 * 0x33�FBattery<br>
		 * 0x34�FEV<br>
		 * 0x35�FOthers<br>
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
		public Setter reqSetElectricEnergyMeterClassification(byte[] edt) {
			addProperty(EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION, edt);
			return this;
		}
		/**
		 * Property name : Owner classification<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of the owner of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30�FNot specified<br>
		 * 0x31�FElectric utility company<br>
		 * 0x32�FPrivate sector company<br>
		 * 0x33�FIndividual<br>
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
			addProperty(EPC_OWNER_CLASSIFICATION, edt);
			return this;
		}
		/**
		 * Property name : Verification expiration date<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates, in the form of an ASCII code, the month and year in which the verification of<br>
		 * the meter will expire.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * YYYYMM<br>
		 * YYYY (Year), MM (Month)<br>
		 * <br>
		 * Data type : unsigned char x 6<br>
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
		public Setter reqSetVerificationExpirationDate(byte[] edt) {
			addProperty(EPC_VERIFICATION_EXPIRATION_DATE, edt);
			return this;
		}
		/**
		 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of<br>
		 * 48 pieces of half-hourly data for the preceding 24 hours) is to be<br>
		 * retrieved.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x63 ( 0-99)<br>
		 * 0: current day<br>
		 * 1  . 99: previous day . day that precedes the current day by<br>
		 * 99 days<br>
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
		public Setter reqSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte[] edt) {
			addProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED, edt);
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
		 * Property name : Electric energy meter classification<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the electric energy meter type.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30�FElectric utility company<br>
		 * 0x31�FSolar power<br>
		 * 0x32�FFuel cell<br>
		 * 0x33�FBattery<br>
		 * 0x34�FEV<br>
		 * 0x35�FOthers<br>
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
		public Getter reqGetElectricEnergyMeterClassification() {
			addProperty(EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION);
			return this;
		}
		/**
		 * Property name : Owner classification<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of the owner of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30�FNot specified<br>
		 * 0x31�FElectric utility company<br>
		 * 0x32�FPrivate sector company<br>
		 * 0x33�FIndividual<br>
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
			addProperty(EPC_OWNER_CLASSIFICATION);
			return this;
		}
		/**
		 * Property name : Configuration information of phases and wires of the systems<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the configuration regarding the phases and wires of the system.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Single-phase, two-wire system�F<br>
		 * 0x30<br>
		 * Single-phase, three-wire system�F<br>
		 * 0x31<br>
		 * Three-phase, three-wire system�F<br>
		 * 0x32<br>
		 * Three-phase, four-wire system�F<br>
		 * 0x33<br>
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
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetConfigurationInformationOfPhasesAndWiresOfTheSystems() {
			addProperty(EPC_CONFIGURATION_INFORMATION_OF_PHASES_AND_WIRES_OF_THE_SYSTEMS);
			return this;
		}
		/**
		 * Property name : Composite transformation ratio<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the composite transformation ratio using a 6-digit decimal notation number (initial value = 1).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x000F423F<br>
		 * (000000-999999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetCompositeTransformationRatio() {
			addProperty(EPC_COMPOSITE_TRANSFORMATION_RATIO);
			return this;
		}
		/**
		 * Property name : Multiplying factor for composite transformation ratio<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the multiplying factor for the composite transformation ratio.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00�F�~1(initial value)<br>
		 * 0x01�F�~0.1<br>
		 * 0x02�F�~0.01<br>
		 * 0x03�F�~0.001<br>
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
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMultiplyingFactorForCompositeTransformationRatio() {
			addProperty(EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO);
			return this;
		}
		/**
		 * Property name : Meter type certification number (type approval number in Japan)<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the<br>
		 * type-certified meter number using alphanumeric characters<br>
		 * (0x20-0x70).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Type-certified meter (type number):<br>
		 * 0000-0��������-<br>
		 * 9999-9��������<br>
		 * Non-type certified meter: FFFFFFFFFF (initial value)<br>
		 * <br>
		 * Data type : unsigned char x 10<br>
		 * <br>
		 * Data size : 10
Byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetMeterTypeCertificationNumberTypeApprovalNumberInJapan() {
			addProperty(EPC_METER_TYPE_CERTIFICATION_NUMBER_TYPE_APPROVAL_NUMBER_IN_JAPAN);
			return this;
		}
		/**
		 * Property name : Verification expiration date<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates, in the form of an ASCII code, the month and year in which the verification of<br>
		 * the meter will expire.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * YYYYMM<br>
		 * YYYY (Year), MM (Month)<br>
		 * <br>
		 * Data type : unsigned char x 6<br>
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
		public Getter reqGetVerificationExpirationDate() {
			addProperty(EPC_VERIFICATION_EXPIRATION_DATE);
			return this;
		}
		/**
		 * Property name : Measured cumulative amount of electric energy (normal direction)<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x05F5E0FF<br>
		 * (0-99,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
			return this;
		}
		/**
		 * Property name : Unit for cumulative amounts of electric energy (normal and reverse directions)<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00: 1kWh<br>
		 * 0x01: 0.1kWh<br>
		 * 0x02: 0.01kWh<br>
		 * 0x03: 0.001kWh (Initial value)<br>
		 * 0x04: 0.0001kWh<br>
		 * 0x0A: 10kWh<br>
		 * 0x0B: 100kWh<br>
		 * 0x0C: 1000kWh<br>
		 * 0x0D: 10000kWh<br>
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
		public Getter reqGetUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections() {
			addProperty(EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS);
			return this;
		}
		/**
		 * Property name : Historical data of measured cumulative amounts of electric energy
(normal direction)<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of<br>
		 * measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of<br>
		 * half-hourly data for the preceding<br>
		 * 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x0063:<br>
		 * 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)<br>
		 * <br>
		 * Data type : unsigned short
+ unsigned long
x48<br>
		 * <br>
		 * Data size : 194
Byte<br>
		 * <br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection() {
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
			return this;
		}
		/**
		 * Property name : Measured cumulative amount of electric energy (reverse direction)<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x05F5E0FF<br>
		 * (0-99,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyReverseDirection() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION);
			return this;
		}
		/**
		 * Property name : Historical data of measured cumulative amounts of electric energy
(reverse direction)<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of<br>
		 * measured cumulative amounts of<br>
		 * electric energy (8 digits), which consists of 48 pieces of<br>
		 * half-hourly data for the preceding<br>
		 * 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x0063:<br>
		 * 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)<br>
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
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection() {
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION);
			return this;
		}
		/**
		 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of<br>
		 * 48 pieces of half-hourly data for the preceding 24 hours) is to be<br>
		 * retrieved.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x63 ( 0-99)<br>
		 * 0: current day<br>
		 * 1  . 99: previous day . day that precedes the current day by<br>
		 * 99 days<br>
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
		public Getter reqGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved() {
			addProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED);
			return this;
		}
		/**
		 * Property name : Measured instantaneous amount of electric energy<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x80000001-0x7FFFFFFD (-2,147,483,647-<br>
		 * 2,147,483,645)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredInstantaneousAmountOfElectricEnergy() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Measured instantaneous currents<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured effective instantaneous R and T phase currents in amperes.<br>
		 * In the case of a single-phase,<br>
		 * two-wire system, 0x7FFE shall be used for the T phase.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x8001-0x7FFD�iR phase�j<br>
		 * : 0x8001-0x7FFD�iT phase�j<br>
		 * (-3,276.7-3,276.5): (-3,276.7-3,276.5)<br>
		 * <br>
		 * Data type : signed short
�~2<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : 0.1
A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredInstantaneousCurrents() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_CURRENTS);
			return this;
		}
		/**
		 * Property name : Measured instantaneous voltages<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a<br>
		 * single-phase, two-wire system,<br>
		 * 0xFFFE shall be used for the<br>
		 * S(N)-T voltage.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0xFFFD (between R and<br>
		 * S(N))�F<br>
		 * 0x0000-0xFFFD (between S(N)<br>
		 * and T)<br>
		 * (0-6,553.3) : (0-6,553.3)<br>
		 * <br>
		 * Data type : unsigned short
�~2<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : 0.1
V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredInstantaneousVoltages() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_VOLTAGES);
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
		 * Property name : Electric energy meter classification<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the electric energy meter type.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30�FElectric utility company<br>
		 * 0x31�FSolar power<br>
		 * 0x32�FFuel cell<br>
		 * 0x33�FBattery<br>
		 * 0x34�FEV<br>
		 * 0x35�FOthers<br>
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
		public Informer reqInformElectricEnergyMeterClassification() {
			addProperty(EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION);
			return this;
		}
		/**
		 * Property name : Owner classification<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the type of the owner of the meter.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30�FNot specified<br>
		 * 0x31�FElectric utility company<br>
		 * 0x32�FPrivate sector company<br>
		 * 0x33�FIndividual<br>
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
			addProperty(EPC_OWNER_CLASSIFICATION);
			return this;
		}
		/**
		 * Property name : Configuration information of phases and wires of the systems<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the configuration regarding the phases and wires of the system.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Single-phase, two-wire system�F<br>
		 * 0x30<br>
		 * Single-phase, three-wire system�F<br>
		 * 0x31<br>
		 * Three-phase, three-wire system�F<br>
		 * 0x32<br>
		 * Three-phase, four-wire system�F<br>
		 * 0x33<br>
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
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformConfigurationInformationOfPhasesAndWiresOfTheSystems() {
			addProperty(EPC_CONFIGURATION_INFORMATION_OF_PHASES_AND_WIRES_OF_THE_SYSTEMS);
			return this;
		}
		/**
		 * Property name : Composite transformation ratio<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the composite transformation ratio using a 6-digit decimal notation number (initial value = 1).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x000F423F<br>
		 * (000000-999999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformCompositeTransformationRatio() {
			addProperty(EPC_COMPOSITE_TRANSFORMATION_RATIO);
			return this;
		}
		/**
		 * Property name : Multiplying factor for composite transformation ratio<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the multiplying factor for the composite transformation ratio.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00�F�~1(initial value)<br>
		 * 0x01�F�~0.1<br>
		 * 0x02�F�~0.01<br>
		 * 0x03�F�~0.001<br>
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
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMultiplyingFactorForCompositeTransformationRatio() {
			addProperty(EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO);
			return this;
		}
		/**
		 * Property name : Meter type certification number (type approval number in Japan)<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the<br>
		 * type-certified meter number using alphanumeric characters<br>
		 * (0x20-0x70).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Type-certified meter (type number):<br>
		 * 0000-0��������-<br>
		 * 9999-9��������<br>
		 * Non-type certified meter: FFFFFFFFFF (initial value)<br>
		 * <br>
		 * Data type : unsigned char x 10<br>
		 * <br>
		 * Data size : 10
Byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformMeterTypeCertificationNumberTypeApprovalNumberInJapan() {
			addProperty(EPC_METER_TYPE_CERTIFICATION_NUMBER_TYPE_APPROVAL_NUMBER_IN_JAPAN);
			return this;
		}
		/**
		 * Property name : Verification expiration date<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates, in the form of an ASCII code, the month and year in which the verification of<br>
		 * the meter will expire.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * YYYYMM<br>
		 * YYYY (Year), MM (Month)<br>
		 * <br>
		 * Data type : unsigned char x 6<br>
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
		public Informer reqInformVerificationExpirationDate() {
			addProperty(EPC_VERIFICATION_EXPIRATION_DATE);
			return this;
		}
		/**
		 * Property name : Measured cumulative amount of electric energy (normal direction)<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x05F5E0FF<br>
		 * (0-99,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyNormalDirection() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
			return this;
		}
		/**
		 * Property name : Unit for cumulative amounts of electric energy (normal and reverse directions)<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00: 1kWh<br>
		 * 0x01: 0.1kWh<br>
		 * 0x02: 0.01kWh<br>
		 * 0x03: 0.001kWh (Initial value)<br>
		 * 0x04: 0.0001kWh<br>
		 * 0x0A: 10kWh<br>
		 * 0x0B: 100kWh<br>
		 * 0x0C: 1000kWh<br>
		 * 0x0D: 10000kWh<br>
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
		public Informer reqInformUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections() {
			addProperty(EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS);
			return this;
		}
		/**
		 * Property name : Historical data of measured cumulative amounts of electric energy
(normal direction)<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of<br>
		 * measured cumulative amounts of electric energy (8 digits), which consists of 48 pieces of<br>
		 * half-hourly data for the preceding<br>
		 * 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x0063:<br>
		 * 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)<br>
		 * <br>
		 * Data type : unsigned short
+ unsigned long
x48<br>
		 * <br>
		 * Data size : 194
Byte<br>
		 * <br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyNormalDirection() {
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
			return this;
		}
		/**
		 * Property name : Measured cumulative amount of electric energy (reverse direction)<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x05F5E0FF<br>
		 * (0-99,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyReverseDirection() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION);
			return this;
		}
		/**
		 * Property name : Historical data of measured cumulative amounts of electric energy
(reverse direction)<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of<br>
		 * measured cumulative amounts of<br>
		 * electric energy (8 digits), which consists of 48 pieces of<br>
		 * half-hourly data for the preceding<br>
		 * 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x0063:<br>
		 * 0x00000000-0x05F5E0FF (0-99) : (0-99,999,999)<br>
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
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyReverseDirection() {
			addProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION);
			return this;
		}
		/**
		 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of<br>
		 * 48 pieces of half-hourly data for the preceding 24 hours) is to be<br>
		 * retrieved.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x63 ( 0-99)<br>
		 * 0: current day<br>
		 * 1  . 99: previous day . day that precedes the current day by<br>
		 * 99 days<br>
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
		public Informer reqInformDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved() {
			addProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED);
			return this;
		}
		/**
		 * Property name : Measured instantaneous amount of electric energy<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured effective instantaneous amount of electric energy in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x80000001-0x7FFFFFFD (-2,147,483,647-<br>
		 * 2,147,483,645)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredInstantaneousAmountOfElectricEnergy() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Measured instantaneous currents<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured effective instantaneous R and T phase currents in amperes.<br>
		 * In the case of a single-phase,<br>
		 * two-wire system, 0x7FFE shall be used for the T phase.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x8001-0x7FFD�iR phase�j<br>
		 * : 0x8001-0x7FFD�iT phase�j<br>
		 * (-3,276.7-3,276.5): (-3,276.7-3,276.5)<br>
		 * <br>
		 * Data type : signed short
�~2<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : 0.1
A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredInstantaneousCurrents() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_CURRENTS);
			return this;
		}
		/**
		 * Property name : Measured instantaneous voltages<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a<br>
		 * single-phase, two-wire system,<br>
		 * 0xFFFE shall be used for the<br>
		 * S(N)-T voltage.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0xFFFD (between R and<br>
		 * S(N))�F<br>
		 * 0x0000-0xFFFD (between S(N)<br>
		 * and T)<br>
		 * (0-6,553.3) : (0-6,553.3)<br>
		 * <br>
		 * Data type : unsigned short
�~2<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : 0.1
V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredInstantaneousVoltages() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_VOLTAGES);
			return this;
		}
	}

	public static class Proxy extends SmartElectricEnergyMeter {
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
		protected byte[] getMeterTypeCertificationNumberTypeApprovalNumberInJapan() {return null;}
		@Override
		protected byte[] getMeasuredCumulativeAmountOfElectricEnergyNormalDirection() {return null;}
		@Override
		protected byte[] getUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections() {return null;}
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
