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

public abstract class BathroomHeaterAndDryer extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0273;

	public static final byte EPC_OPERATION_SETTING = (byte)0xB0;
	public static final byte EPC_VENTILATION_OPERATION_SETTING = (byte)0xB1;
	public static final byte EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING = (byte)0xB2;
	public static final byte EPC_BATHROOM_HEATER_OPERATION_SETTING = (byte)0xB3;
	public static final byte EPC_BATHROOM_DRYER_OPERATION_SETTING = (byte)0xB4;
	public static final byte EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING = (byte)0xB5;
	public static final byte EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY = (byte)0xBA;
	public static final byte EPC_MEASURED_BATHROOM_TEMPERATURE = (byte)0xBB;
	public static final byte EPC_VENTILATION_AIR_FLOW_RATE_SETTING = (byte)0xC2;
	public static final byte EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING = (byte)0xCF;
	public static final byte EPC_HUMAN_BODY_DETECTION_STATUS = (byte)0xE0;
	public static final byte EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1 = (byte)0x90;
	public static final byte EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2 = (byte)0xE1;
	public static final byte EPC_ON_TIMER_SETTING_TIME = (byte)0x91;
	public static final byte EPC_ON_TIMER_SETTING_RELATIVE_TIME = (byte)0x92;
	public static final byte EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING = (byte)0x94;
	public static final byte EPC_OFF_TIMER_SETTING_TIME = (byte)0x95;
	public static final byte EPC_OFF_TIMER_SETTING_RELATIVE_TIME = (byte)0x96;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		removeStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addSetProperty(EPC_OPERATION_SETTING);
		addGetProperty(EPC_OPERATION_SETTING);
		addSetProperty(EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING);
		addGetProperty(EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING);
		addSetProperty(EPC_BATHROOM_DRYER_OPERATION_SETTING);
		addGetProperty(EPC_BATHROOM_DRYER_OPERATION_SETTING);
	}
	
	@Override
	public void initialize(EchoNode node) {
		super.initialize(node);
		Echo.EventListener listener = Echo.getEventListener();
		if(listener != null) listener.onNewBathroomHeaterAndDryer(this);
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
	 * ON           : 0x30<br>
	 * OFF          : 0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - mandatory<br>
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
	 * ON           : 0x30<br>
	 * OFF          : 0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getOperationStatus();
	/**
	 * Property name : Operation setting<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the operation mode<br>
	 * (ventilation mode, bathroom<br>
	 * pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Ventilation operation             : 0x10<br>
	 * Bathroom pre-warmer operation :<br>
	 * 0x20<br>
	 * Bathroom heater operation   : 0x30<br>
	 * Bathroom dryer operation      : 0x40<br>
	 * Cool air circulator operation : 0x50<br>
	 * Stop                                           :0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract boolean setOperationSetting(byte[] edt);
	/**
	 * Property name : Operation setting<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the operation mode<br>
	 * (ventilation mode, bathroom<br>
	 * pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Ventilation operation             : 0x10<br>
	 * Bathroom pre-warmer operation :<br>
	 * 0x20<br>
	 * Bathroom heater operation   : 0x30<br>
	 * Bathroom dryer operation      : 0x40<br>
	 * Cool air circulator operation : 0x50<br>
	 * Stop                                           :0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getOperationSetting();
	/**
	 * Property name : Operation setting<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the operation mode<br>
	 * (ventilation mode, bathroom<br>
	 * pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Ventilation operation             : 0x10<br>
	 * Bathroom pre-warmer operation :<br>
	 * 0x20<br>
	 * Bathroom heater operation   : 0x30<br>
	 * Bathroom dryer operation      : 0x40<br>
	 * Cool air circulator operation : 0x50<br>
	 * Stop                                           :0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Ventilation operation setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41<br>
	 * Standard          : 0x42<br>
	 * Air flow rate level    : 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setVentilationOperationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Ventilation operation setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41<br>
	 * Standard          : 0x42<br>
	 * Air flow rate level    : 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getVentilationOperationSetting() {return null;}
	/**
	 * Property name : Ventilation operation setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41<br>
	 * Standard          : 0x42<br>
	 * Air flow rate level    : 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidVentilationOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bathroom pre-warmer operation setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41<br>
	 * Standard          : 0x42<br>
	 * Bathroom pre-warming level<br>
	 * : 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract boolean setBathroomPreWarmerOperationSetting(byte[] edt);
	/**
	 * Property name : Bathroom pre-warmer operation setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41<br>
	 * Standard          : 0x42<br>
	 * Bathroom pre-warming level<br>
	 * : 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getBathroomPreWarmerOperationSetting();
	/**
	 * Property name : Bathroom pre-warmer operation setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41<br>
	 * Standard          : 0x42<br>
	 * Bathroom pre-warming level<br>
	 * : 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidBathroomPreWarmerOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bathroom heater operation setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41<br>
	 * Standard          : 0x42<br>
	 * Bathroom heating level<br>
	 * : 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setBathroomHeaterOperationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Bathroom heater operation setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41<br>
	 * Standard          : 0x42<br>
	 * Bathroom heating level<br>
	 * : 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getBathroomHeaterOperationSetting() {return null;}
	/**
	 * Property name : Bathroom heater operation setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41<br>
	 * Standard          : 0x42<br>
	 * Bathroom heating level<br>
	 * : 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidBathroomHeaterOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bathroom dryer operation setting<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41<br>
	 * Standard          : 0x42<br>
	 * Bathroom drying level<br>
	 * : 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract boolean setBathroomDryerOperationSetting(byte[] edt);
	/**
	 * Property name : Bathroom dryer operation setting<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41<br>
	 * Standard          : 0x42<br>
	 * Bathroom drying level<br>
	 * : 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getBathroomDryerOperationSetting();
	/**
	 * Property name : Bathroom dryer operation setting<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41<br>
	 * Standard          : 0x42<br>
	 * Bathroom drying level<br>
	 * : 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidBathroomDryerOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Cool air circulator operation setting<br>
	 * <br>
	 * EPC : 0xB5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41<br>
	 * Standard          : 0x42<br>
	 * Cool air circulation level<br>
	 * : 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setCoolAirCirculatorOperationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Cool air circulator operation setting<br>
	 * <br>
	 * EPC : 0xB5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41<br>
	 * Standard          : 0x42<br>
	 * Cool air circulation level<br>
	 * : 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getCoolAirCirculatorOperationSetting() {return null;}
	/**
	 * Property name : Cool air circulator operation setting<br>
	 * <br>
	 * EPC : 0xB5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41<br>
	 * Standard          : 0x42<br>
	 * Cool air circulation level<br>
	 * : 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidCoolAirCirculatorOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured
relative bathroom humidity<br>
	 * <br>
	 * EPC : 0xBA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured relative humidity of the bathroom.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x64 (0 to 100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredRelativeBathroomHumidity() {return null;}
	/**
	 * Property name : Measured
relative bathroom humidity<br>
	 * <br>
	 * EPC : 0xBA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured relative humidity of the bathroom.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x64 (0 to 100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredRelativeBathroomHumidity(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured bathroom temperature<br>
	 * <br>
	 * EPC : 0xBB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured temperature of the bathroom.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81 to 0x7D (.127 to �{125��)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : ��<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredBathroomTemperature() {return null;}
	/**
	 * Property name : Measured bathroom temperature<br>
	 * <br>
	 * EPC : 0xBB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured temperature of the bathroom.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81 to 0x7D (.127 to �{125��)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : ��<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredBathroomTemperature(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Ventilation air flow rate setting<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic: 0x41<br>
	 * Air flow rate level: 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setVentilationAirFlowRateSetting(byte[] edt) {return false;}
	/**
	 * Property name : Ventilation air flow rate setting<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic: 0x41<br>
	 * Air flow rate level: 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getVentilationAirFlowRateSetting() {return null;}
	/**
	 * Property name : Ventilation air flow rate setting<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic: 0x41<br>
	 * Air flow rate level: 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidVentilationAirFlowRateSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Filter cleaning reminder sign setting<br>
	 * <br>
	 * EPC : 0xCF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the filter cleaning reminder<br>
	 * sign status (lit/not lit) and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Lit: 0x41<br>
	 * Not lit: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setFilterCleaningReminderSignSetting(byte[] edt) {return false;}
	/**
	 * Property name : Filter cleaning reminder sign setting<br>
	 * <br>
	 * EPC : 0xCF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the filter cleaning reminder<br>
	 * sign status (lit/not lit) and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Lit: 0x41<br>
	 * Not lit: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getFilterCleaningReminderSignSetting() {return null;}
	/**
	 * Property name : Filter cleaning reminder sign setting<br>
	 * <br>
	 * EPC : 0xCF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the filter cleaning reminder<br>
	 * sign status (lit/not lit) and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Lit: 0x41<br>
	 * Not lit: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidFilterCleaningReminderSignSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Human body detection status<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the human body detection status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Detected: 0x41<br>
	 * Not detected: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getHumanBodyDetectionStatus() {return null;}
	/**
	 * Property name : Human body detection status<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the human body detection status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Detected: 0x41<br>
	 * Not detected: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidHumanBodyDetectionStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : �gON timer-based reservation�h setting 1<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the ON/OFF status of the<br>
	 * ON timer-based reservation function and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation function ON: 0x41<br>
	 * Reservation function OFF: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setGonTimerBasedReservationHSetting1(byte[] edt) {return false;}
	/**
	 * Property name : �gON timer-based reservation�h setting 1<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the ON/OFF status of the<br>
	 * ON timer-based reservation function and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation function ON: 0x41<br>
	 * Reservation function OFF: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getGonTimerBasedReservationHSetting1() {return null;}
	/**
	 * Property name : �gON timer-based reservation�h setting 1<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the ON/OFF status of the<br>
	 * ON timer-based reservation function and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation function ON: 0x41<br>
	 * Reservation function OFF: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidGonTimerBasedReservationHSetting1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : �gON timer-based reservation�h setting 2<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the ON/OFF status of the<br>
	 * ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation function ON for the ventilation mode                      : 0x10<br>
	 * Reservation function ON for the bathroom pre-warmer mode : 0x20<br>
	 * Reservation function ON for the bathroom heater mode          : 0x30<br>
	 * Reservation function ON for the bathroom dryer mode            : 0x40<br>
	 * Reservation function ON for the cool air circulator mode       : 0x50<br>
	 * Reservation function OFF : 0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setGonTimerBasedReservationHSetting2(byte[] edt) {return false;}
	/**
	 * Property name : �gON timer-based reservation�h setting 2<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the ON/OFF status of the<br>
	 * ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation function ON for the ventilation mode                      : 0x10<br>
	 * Reservation function ON for the bathroom pre-warmer mode : 0x20<br>
	 * Reservation function ON for the bathroom heater mode          : 0x30<br>
	 * Reservation function ON for the bathroom dryer mode            : 0x40<br>
	 * Reservation function ON for the cool air circulator mode       : 0x50<br>
	 * Reservation function OFF : 0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getGonTimerBasedReservationHSetting2() {return null;}
	/**
	 * Property name : �gON timer-based reservation�h setting 2<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the ON/OFF status of the<br>
	 * ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation function ON for the ventilation mode                      : 0x10<br>
	 * Reservation function ON for the bathroom pre-warmer mode : 0x20<br>
	 * Reservation function ON for the bathroom heater mode          : 0x30<br>
	 * Reservation function ON for the bathroom dryer mode            : 0x40<br>
	 * Reservation function ON for the cool air circulator mode       : 0x50<br>
	 * Reservation function OFF : 0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidGonTimerBasedReservationHSetting2(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : ON timer setting
(time)<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the time setting for the<br>
	 * time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
x2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOnTimerSettingTime(byte[] edt) {return false;}
	/**
	 * Property name : ON timer setting
(time)<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the time setting for the<br>
	 * time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
x2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOnTimerSettingTime() {return null;}
	/**
	 * Property name : ON timer setting
(time)<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the time setting for the<br>
	 * time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
x2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOnTimerSettingTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : ON timer setting
(relative time)<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the relative time setting for<br>
	 * the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
x2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOnTimerSettingRelativeTime(byte[] edt) {return false;}
	/**
	 * Property name : ON timer setting
(relative time)<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the relative time setting for<br>
	 * the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
x2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOnTimerSettingRelativeTime() {return null;}
	/**
	 * Property name : ON timer setting
(relative time)<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the relative time setting for<br>
	 * the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
x2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOnTimerSettingRelativeTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : �gOFF
timer-based reservation�h setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation function ON: 0x41<br>
	 * Reservation function OFF: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setGoffTimerBasedReservationHSetting(byte[] edt) {return false;}
	/**
	 * Property name : �gOFF
timer-based reservation�h setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation function ON: 0x41<br>
	 * Reservation function OFF: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getGoffTimerBasedReservationHSetting() {return null;}
	/**
	 * Property name : �gOFF
timer-based reservation�h setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation function ON: 0x41<br>
	 * Reservation function OFF: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidGoffTimerBasedReservationHSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : OFF timer setting (time)<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the time setting for the<br>
	 * time-based reservation function for the<br>
	 * OFF timer (in the HH:MM format)<br>
	 * and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
x2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOffTimerSettingTime(byte[] edt) {return false;}
	/**
	 * Property name : OFF timer setting (time)<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the time setting for the<br>
	 * time-based reservation function for the<br>
	 * OFF timer (in the HH:MM format)<br>
	 * and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
x2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOffTimerSettingTime() {return null;}
	/**
	 * Property name : OFF timer setting (time)<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the time setting for the<br>
	 * time-based reservation function for the<br>
	 * OFF timer (in the HH:MM format)<br>
	 * and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
x2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOffTimerSettingTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : OFF timer setting (relative time)<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the<br>
	 * current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
x2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOffTimerSettingRelativeTime(byte[] edt) {return false;}
	/**
	 * Property name : OFF timer setting (relative time)<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the<br>
	 * current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
x2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOffTimerSettingRelativeTime() {return null;}
	/**
	 * Property name : OFF timer setting (relative time)<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the<br>
	 * current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
x2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOffTimerSettingRelativeTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_OPERATION_SETTING : return setOperationSetting(property.edt);
		case EPC_VENTILATION_OPERATION_SETTING : return setVentilationOperationSetting(property.edt);
		case EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING : return setBathroomPreWarmerOperationSetting(property.edt);
		case EPC_BATHROOM_HEATER_OPERATION_SETTING : return setBathroomHeaterOperationSetting(property.edt);
		case EPC_BATHROOM_DRYER_OPERATION_SETTING : return setBathroomDryerOperationSetting(property.edt);
		case EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING : return setCoolAirCirculatorOperationSetting(property.edt);
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : return setVentilationAirFlowRateSetting(property.edt);
		case EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING : return setFilterCleaningReminderSignSetting(property.edt);
		case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1 : return setGonTimerBasedReservationHSetting1(property.edt);
		case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2 : return setGonTimerBasedReservationHSetting2(property.edt);
		case EPC_ON_TIMER_SETTING_TIME : return setOnTimerSettingTime(property.edt);
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME : return setOnTimerSettingRelativeTime(property.edt);
		case EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING : return setGoffTimerBasedReservationHSetting(property.edt);
		case EPC_OFF_TIMER_SETTING_TIME : return setOffTimerSettingTime(property.edt);
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME : return setOffTimerSettingRelativeTime(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_OPERATION_SETTING : return getOperationSetting();
		case EPC_VENTILATION_OPERATION_SETTING : return getVentilationOperationSetting();
		case EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING : return getBathroomPreWarmerOperationSetting();
		case EPC_BATHROOM_HEATER_OPERATION_SETTING : return getBathroomHeaterOperationSetting();
		case EPC_BATHROOM_DRYER_OPERATION_SETTING : return getBathroomDryerOperationSetting();
		case EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING : return getCoolAirCirculatorOperationSetting();
		case EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY : return getMeasuredRelativeBathroomHumidity();
		case EPC_MEASURED_BATHROOM_TEMPERATURE : return getMeasuredBathroomTemperature();
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : return getVentilationAirFlowRateSetting();
		case EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING : return getFilterCleaningReminderSignSetting();
		case EPC_HUMAN_BODY_DETECTION_STATUS : return getHumanBodyDetectionStatus();
		case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1 : return getGonTimerBasedReservationHSetting1();
		case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2 : return getGonTimerBasedReservationHSetting2();
		case EPC_ON_TIMER_SETTING_TIME : return getOnTimerSettingTime();
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME : return getOnTimerSettingRelativeTime();
		case EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING : return getGoffTimerBasedReservationHSetting();
		case EPC_OFF_TIMER_SETTING_TIME : return getOffTimerSettingTime();
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME : return getOffTimerSettingRelativeTime();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_OPERATION_SETTING : return isValidOperationSetting(property.edt);
		case EPC_VENTILATION_OPERATION_SETTING : return isValidVentilationOperationSetting(property.edt);
		case EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING : return isValidBathroomPreWarmerOperationSetting(property.edt);
		case EPC_BATHROOM_HEATER_OPERATION_SETTING : return isValidBathroomHeaterOperationSetting(property.edt);
		case EPC_BATHROOM_DRYER_OPERATION_SETTING : return isValidBathroomDryerOperationSetting(property.edt);
		case EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING : return isValidCoolAirCirculatorOperationSetting(property.edt);
		case EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY : return isValidMeasuredRelativeBathroomHumidity(property.edt);
		case EPC_MEASURED_BATHROOM_TEMPERATURE : return isValidMeasuredBathroomTemperature(property.edt);
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : return isValidVentilationAirFlowRateSetting(property.edt);
		case EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING : return isValidFilterCleaningReminderSignSetting(property.edt);
		case EPC_HUMAN_BODY_DETECTION_STATUS : return isValidHumanBodyDetectionStatus(property.edt);
		case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1 : return isValidGonTimerBasedReservationHSetting1(property.edt);
		case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2 : return isValidGonTimerBasedReservationHSetting2(property.edt);
		case EPC_ON_TIMER_SETTING_TIME : return isValidOnTimerSettingTime(property.edt);
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME : return isValidOnTimerSettingRelativeTime(property.edt);
		case EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING : return isValidGoffTimerBasedReservationHSetting(property.edt);
		case EPC_OFF_TIMER_SETTING_TIME : return isValidOffTimerSettingTime(property.edt);
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME : return isValidOffTimerSettingRelativeTime(property.edt);
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
			case EPC_OPERATION_SETTING : 
				onSetOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VENTILATION_OPERATION_SETTING : 
				onSetVentilationOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING : 
				onSetBathroomPreWarmerOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATHROOM_HEATER_OPERATION_SETTING : 
				onSetBathroomHeaterOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATHROOM_DRYER_OPERATION_SETTING : 
				onSetBathroomDryerOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING : 
				onSetCoolAirCirculatorOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : 
				onSetVentilationAirFlowRateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING : 
				onSetFilterCleaningReminderSignSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1 : 
				onSetGonTimerBasedReservationHSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2 : 
				onSetGonTimerBasedReservationHSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING_TIME : 
				onSetOnTimerSettingTime(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME : 
				onSetOnTimerSettingRelativeTime(eoj, tid, esv, property, success);
				return true;
			case EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING : 
				onSetGoffTimerBasedReservationHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING_TIME : 
				onSetOffTimerSettingTime(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING_RELATIVE_TIME : 
				onSetOffTimerSettingRelativeTime(eoj, tid, esv, property, success);
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
			case EPC_OPERATION_SETTING : 
				onGetOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VENTILATION_OPERATION_SETTING : 
				onGetVentilationOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING : 
				onGetBathroomPreWarmerOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATHROOM_HEATER_OPERATION_SETTING : 
				onGetBathroomHeaterOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATHROOM_DRYER_OPERATION_SETTING : 
				onGetBathroomDryerOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING : 
				onGetCoolAirCirculatorOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY : 
				onGetMeasuredRelativeBathroomHumidity(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_BATHROOM_TEMPERATURE : 
				onGetMeasuredBathroomTemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : 
				onGetVentilationAirFlowRateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING : 
				onGetFilterCleaningReminderSignSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_HUMAN_BODY_DETECTION_STATUS : 
				onGetHumanBodyDetectionStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1 : 
				onGetGonTimerBasedReservationHSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2 : 
				onGetGonTimerBasedReservationHSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING_TIME : 
				onGetOnTimerSettingTime(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME : 
				onGetOnTimerSettingRelativeTime(eoj, tid, esv, property, success);
				return true;
			case EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING : 
				onGetGoffTimerBasedReservationHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING_TIME : 
				onGetOffTimerSettingTime(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING_RELATIVE_TIME : 
				onGetOffTimerSettingRelativeTime(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Operation setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the operation mode<br>
		 * (ventilation mode, bathroom<br>
		 * pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation operation             : 0x10<br>
		 * Bathroom pre-warmer operation :<br>
		 * 0x20<br>
		 * Bathroom heater operation   : 0x30<br>
		 * Bathroom dryer operation      : 0x40<br>
		 * Cool air circulator operation : 0x50<br>
		 * Stop                                           :0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onSetOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the operation mode<br>
		 * (ventilation mode, bathroom<br>
		 * pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation operation             : 0x10<br>
		 * Bathroom pre-warmer operation :<br>
		 * 0x20<br>
		 * Bathroom heater operation   : 0x30<br>
		 * Bathroom dryer operation      : 0x40<br>
		 * Cool air circulator operation : 0x50<br>
		 * Stop                                           :0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onGetOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ventilation operation setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Air flow rate level    : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetVentilationOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ventilation operation setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Air flow rate level    : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetVentilationOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bathroom pre-warmer operation setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Bathroom pre-warming level<br>
		 * : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onSetBathroomPreWarmerOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bathroom pre-warmer operation setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Bathroom pre-warming level<br>
		 * : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onGetBathroomPreWarmerOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bathroom heater operation setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Bathroom heating level<br>
		 * : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetBathroomHeaterOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bathroom heater operation setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Bathroom heating level<br>
		 * : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetBathroomHeaterOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bathroom dryer operation setting<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Bathroom drying level<br>
		 * : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onSetBathroomDryerOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bathroom dryer operation setting<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Bathroom drying level<br>
		 * : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onGetBathroomDryerOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Cool air circulator operation setting<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Cool air circulation level<br>
		 * : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetCoolAirCirculatorOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Cool air circulator operation setting<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Cool air circulation level<br>
		 * : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetCoolAirCirculatorOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured
relative bathroom humidity<br>
		 * <br>
		 * EPC : 0xBA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured relative humidity of the bathroom.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredRelativeBathroomHumidity(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured bathroom temperature<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured temperature of the bathroom.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81 to 0x7D (.127 to �{125��)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : ��<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredBathroomTemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic: 0x41<br>
		 * Air flow rate level: 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic: 0x41<br>
		 * Air flow rate level: 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Filter cleaning reminder sign setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the filter cleaning reminder<br>
		 * sign status (lit/not lit) and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Lit: 0x41<br>
		 * Not lit: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetFilterCleaningReminderSignSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Filter cleaning reminder sign setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the filter cleaning reminder<br>
		 * sign status (lit/not lit) and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Lit: 0x41<br>
		 * Not lit: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetFilterCleaningReminderSignSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Human body detection status<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the human body detection status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Detected: 0x41<br>
		 * Not detected: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetHumanBodyDetectionStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : �gON timer-based reservation�h setting 1<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the ON/OFF status of the<br>
		 * ON timer-based reservation function and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON: 0x41<br>
		 * Reservation function OFF: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetGonTimerBasedReservationHSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : �gON timer-based reservation�h setting 1<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the ON/OFF status of the<br>
		 * ON timer-based reservation function and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON: 0x41<br>
		 * Reservation function OFF: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetGonTimerBasedReservationHSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : �gON timer-based reservation�h setting 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the ON/OFF status of the<br>
		 * ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON for the ventilation mode                      : 0x10<br>
		 * Reservation function ON for the bathroom pre-warmer mode : 0x20<br>
		 * Reservation function ON for the bathroom heater mode          : 0x30<br>
		 * Reservation function ON for the bathroom dryer mode            : 0x40<br>
		 * Reservation function ON for the cool air circulator mode       : 0x50<br>
		 * Reservation function OFF : 0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetGonTimerBasedReservationHSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : �gON timer-based reservation�h setting 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the ON/OFF status of the<br>
		 * ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON for the ventilation mode                      : 0x10<br>
		 * Reservation function ON for the bathroom pre-warmer mode : 0x20<br>
		 * Reservation function ON for the bathroom heater mode          : 0x30<br>
		 * Reservation function ON for the bathroom dryer mode            : 0x40<br>
		 * Reservation function ON for the cool air circulator mode       : 0x50<br>
		 * Reservation function OFF : 0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetGonTimerBasedReservationHSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting
(time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the time setting for the<br>
		 * time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
x2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting
(time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the time setting for the<br>
		 * time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
x2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting
(relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative time setting for<br>
		 * the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
x2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting
(relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative time setting for<br>
		 * the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
x2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : �gOFF
timer-based reservation�h setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON: 0x41<br>
		 * Reservation function OFF: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetGoffTimerBasedReservationHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : �gOFF
timer-based reservation�h setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON: 0x41<br>
		 * Reservation function OFF: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetGoffTimerBasedReservationHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the time setting for the<br>
		 * time-based reservation function for the<br>
		 * OFF timer (in the HH:MM format)<br>
		 * and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
x2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the time setting for the<br>
		 * time-based reservation function for the<br>
		 * OFF timer (in the HH:MM format)<br>
		 * and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
x2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the<br>
		 * current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
x2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOffTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the<br>
		 * current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
x2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOffTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Operation setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the operation mode<br>
		 * (ventilation mode, bathroom<br>
		 * pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation operation             : 0x10<br>
		 * Bathroom pre-warmer operation :<br>
		 * 0x20<br>
		 * Bathroom heater operation   : 0x30<br>
		 * Bathroom dryer operation      : 0x40<br>
		 * Cool air circulator operation : 0x50<br>
		 * Stop                                           :0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Setter reqSetOperationSetting(byte[] edt) {
			addProperty(EPC_OPERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Ventilation operation setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Air flow rate level    : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetVentilationOperationSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_OPERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Bathroom pre-warmer operation setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Bathroom pre-warming level<br>
		 * : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Setter reqSetBathroomPreWarmerOperationSetting(byte[] edt) {
			addProperty(EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Bathroom heater operation setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Bathroom heating level<br>
		 * : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetBathroomHeaterOperationSetting(byte[] edt) {
			addProperty(EPC_BATHROOM_HEATER_OPERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Bathroom dryer operation setting<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Bathroom drying level<br>
		 * : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Setter reqSetBathroomDryerOperationSetting(byte[] edt) {
			addProperty(EPC_BATHROOM_DRYER_OPERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Cool air circulator operation setting<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Cool air circulation level<br>
		 * : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetCoolAirCirculatorOperationSetting(byte[] edt) {
			addProperty(EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic: 0x41<br>
		 * Air flow rate level: 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetVentilationAirFlowRateSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Filter cleaning reminder sign setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the filter cleaning reminder<br>
		 * sign status (lit/not lit) and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Lit: 0x41<br>
		 * Not lit: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetFilterCleaningReminderSignSetting(byte[] edt) {
			addProperty(EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING, edt);
			return this;
		}
		/**
		 * Property name : �gON timer-based reservation�h setting 1<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the ON/OFF status of the<br>
		 * ON timer-based reservation function and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON: 0x41<br>
		 * Reservation function OFF: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetGonTimerBasedReservationHSetting1(byte[] edt) {
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1, edt);
			return this;
		}
		/**
		 * Property name : �gON timer-based reservation�h setting 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the ON/OFF status of the<br>
		 * ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON for the ventilation mode                      : 0x10<br>
		 * Reservation function ON for the bathroom pre-warmer mode : 0x20<br>
		 * Reservation function ON for the bathroom heater mode          : 0x30<br>
		 * Reservation function ON for the bathroom dryer mode            : 0x40<br>
		 * Reservation function ON for the cool air circulator mode       : 0x50<br>
		 * Reservation function OFF : 0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetGonTimerBasedReservationHSetting2(byte[] edt) {
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2, edt);
			return this;
		}
		/**
		 * Property name : ON timer setting
(time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the time setting for the<br>
		 * time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
x2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOnTimerSettingTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_TIME, edt);
			return this;
		}
		/**
		 * Property name : ON timer setting
(relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative time setting for<br>
		 * the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
x2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOnTimerSettingRelativeTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME, edt);
			return this;
		}
		/**
		 * Property name : �gOFF
timer-based reservation�h setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON: 0x41<br>
		 * Reservation function OFF: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetGoffTimerBasedReservationHSetting(byte[] edt) {
			addProperty(EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING, edt);
			return this;
		}
		/**
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the time setting for the<br>
		 * time-based reservation function for the<br>
		 * OFF timer (in the HH:MM format)<br>
		 * and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
x2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOffTimerSettingTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_TIME, edt);
			return this;
		}
		/**
		 * Property name : OFF timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the<br>
		 * current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
x2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOffTimerSettingRelativeTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME, edt);
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
		 * Property name : Operation setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the operation mode<br>
		 * (ventilation mode, bathroom<br>
		 * pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation operation             : 0x10<br>
		 * Bathroom pre-warmer operation :<br>
		 * 0x20<br>
		 * Bathroom heater operation   : 0x30<br>
		 * Bathroom dryer operation      : 0x40<br>
		 * Cool air circulator operation : 0x50<br>
		 * Stop                                           :0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetOperationSetting() {
			addProperty(EPC_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Ventilation operation setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Air flow rate level    : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetVentilationOperationSetting() {
			addProperty(EPC_VENTILATION_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Bathroom pre-warmer operation setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Bathroom pre-warming level<br>
		 * : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetBathroomPreWarmerOperationSetting() {
			addProperty(EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Bathroom heater operation setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Bathroom heating level<br>
		 * : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetBathroomHeaterOperationSetting() {
			addProperty(EPC_BATHROOM_HEATER_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Bathroom dryer operation setting<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Bathroom drying level<br>
		 * : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetBathroomDryerOperationSetting() {
			addProperty(EPC_BATHROOM_DRYER_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Cool air circulator operation setting<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Cool air circulation level<br>
		 * : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetCoolAirCirculatorOperationSetting() {
			addProperty(EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Measured
relative bathroom humidity<br>
		 * <br>
		 * EPC : 0xBA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured relative humidity of the bathroom.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredRelativeBathroomHumidity() {
			addProperty(EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY);
			return this;
		}
		/**
		 * Property name : Measured bathroom temperature<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured temperature of the bathroom.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81 to 0x7D (.127 to �{125��)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : ��<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredBathroomTemperature() {
			addProperty(EPC_MEASURED_BATHROOM_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic: 0x41<br>
		 * Air flow rate level: 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetVentilationAirFlowRateSetting() {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Property name : Filter cleaning reminder sign setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the filter cleaning reminder<br>
		 * sign status (lit/not lit) and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Lit: 0x41<br>
		 * Not lit: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetFilterCleaningReminderSignSetting() {
			addProperty(EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING);
			return this;
		}
		/**
		 * Property name : Human body detection status<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the human body detection status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Detected: 0x41<br>
		 * Not detected: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetHumanBodyDetectionStatus() {
			addProperty(EPC_HUMAN_BODY_DETECTION_STATUS);
			return this;
		}
		/**
		 * Property name : �gON timer-based reservation�h setting 1<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the ON/OFF status of the<br>
		 * ON timer-based reservation function and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON: 0x41<br>
		 * Reservation function OFF: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetGonTimerBasedReservationHSetting1() {
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1);
			return this;
		}
		/**
		 * Property name : �gON timer-based reservation�h setting 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the ON/OFF status of the<br>
		 * ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON for the ventilation mode                      : 0x10<br>
		 * Reservation function ON for the bathroom pre-warmer mode : 0x20<br>
		 * Reservation function ON for the bathroom heater mode          : 0x30<br>
		 * Reservation function ON for the bathroom dryer mode            : 0x40<br>
		 * Reservation function ON for the cool air circulator mode       : 0x50<br>
		 * Reservation function OFF : 0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetGonTimerBasedReservationHSetting2() {
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2);
			return this;
		}
		/**
		 * Property name : ON timer setting
(time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the time setting for the<br>
		 * time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
x2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOnTimerSettingTime() {
			addProperty(EPC_ON_TIMER_SETTING_TIME);
			return this;
		}
		/**
		 * Property name : ON timer setting
(relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative time setting for<br>
		 * the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
x2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOnTimerSettingRelativeTime() {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
		/**
		 * Property name : �gOFF
timer-based reservation�h setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON: 0x41<br>
		 * Reservation function OFF: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetGoffTimerBasedReservationHSetting() {
			addProperty(EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING);
			return this;
		}
		/**
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the time setting for the<br>
		 * time-based reservation function for the<br>
		 * OFF timer (in the HH:MM format)<br>
		 * and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
x2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOffTimerSettingTime() {
			addProperty(EPC_OFF_TIMER_SETTING_TIME);
			return this;
		}
		/**
		 * Property name : OFF timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the<br>
		 * current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
x2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOffTimerSettingRelativeTime() {
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME);
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
		 * Property name : Operation setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the operation mode<br>
		 * (ventilation mode, bathroom<br>
		 * pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation operation             : 0x10<br>
		 * Bathroom pre-warmer operation :<br>
		 * 0x20<br>
		 * Bathroom heater operation   : 0x30<br>
		 * Bathroom dryer operation      : 0x40<br>
		 * Cool air circulator operation : 0x50<br>
		 * Stop                                           :0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformOperationSetting() {
			addProperty(EPC_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Ventilation operation setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Air flow rate level    : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformVentilationOperationSetting() {
			addProperty(EPC_VENTILATION_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Bathroom pre-warmer operation setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Bathroom pre-warming level<br>
		 * : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformBathroomPreWarmerOperationSetting() {
			addProperty(EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Bathroom heater operation setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Bathroom heating level<br>
		 * : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformBathroomHeaterOperationSetting() {
			addProperty(EPC_BATHROOM_HEATER_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Bathroom dryer operation setting<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Bathroom drying level<br>
		 * : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformBathroomDryerOperationSetting() {
			addProperty(EPC_BATHROOM_DRYER_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Cool air circulator operation setting<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41<br>
		 * Standard          : 0x42<br>
		 * Cool air circulation level<br>
		 * : 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformCoolAirCirculatorOperationSetting() {
			addProperty(EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Measured
relative bathroom humidity<br>
		 * <br>
		 * EPC : 0xBA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured relative humidity of the bathroom.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredRelativeBathroomHumidity() {
			addProperty(EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY);
			return this;
		}
		/**
		 * Property name : Measured bathroom temperature<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured temperature of the bathroom.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81 to 0x7D (.127 to �{125��)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : ��<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredBathroomTemperature() {
			addProperty(EPC_MEASURED_BATHROOM_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic: 0x41<br>
		 * Air flow rate level: 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformVentilationAirFlowRateSetting() {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Property name : Filter cleaning reminder sign setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the filter cleaning reminder<br>
		 * sign status (lit/not lit) and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Lit: 0x41<br>
		 * Not lit: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformFilterCleaningReminderSignSetting() {
			addProperty(EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING);
			return this;
		}
		/**
		 * Property name : Human body detection status<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the human body detection status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Detected: 0x41<br>
		 * Not detected: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformHumanBodyDetectionStatus() {
			addProperty(EPC_HUMAN_BODY_DETECTION_STATUS);
			return this;
		}
		/**
		 * Property name : �gON timer-based reservation�h setting 1<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the ON/OFF status of the<br>
		 * ON timer-based reservation function and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON: 0x41<br>
		 * Reservation function OFF: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformGonTimerBasedReservationHSetting1() {
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1);
			return this;
		}
		/**
		 * Property name : �gON timer-based reservation�h setting 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the ON/OFF status of the<br>
		 * ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON for the ventilation mode                      : 0x10<br>
		 * Reservation function ON for the bathroom pre-warmer mode : 0x20<br>
		 * Reservation function ON for the bathroom heater mode          : 0x30<br>
		 * Reservation function ON for the bathroom dryer mode            : 0x40<br>
		 * Reservation function ON for the cool air circulator mode       : 0x50<br>
		 * Reservation function OFF : 0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformGonTimerBasedReservationHSetting2() {
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2);
			return this;
		}
		/**
		 * Property name : ON timer setting
(time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the time setting for the<br>
		 * time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
x2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOnTimerSettingTime() {
			addProperty(EPC_ON_TIMER_SETTING_TIME);
			return this;
		}
		/**
		 * Property name : ON timer setting
(relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative time setting for<br>
		 * the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
x2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOnTimerSettingRelativeTime() {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
		/**
		 * Property name : �gOFF
timer-based reservation�h setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON: 0x41<br>
		 * Reservation function OFF: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformGoffTimerBasedReservationHSetting() {
			addProperty(EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING);
			return this;
		}
		/**
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the time setting for the<br>
		 * time-based reservation function for the<br>
		 * OFF timer (in the HH:MM format)<br>
		 * and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
x2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOffTimerSettingTime() {
			addProperty(EPC_OFF_TIMER_SETTING_TIME);
			return this;
		}
		/**
		 * Property name : OFF timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the<br>
		 * current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
x2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOffTimerSettingRelativeTime() {
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
	}

	public static class Proxy extends BathroomHeaterAndDryer {
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
		protected boolean setOperationSetting(byte[] edt) {return false;}
		@Override
		protected byte[] getOperationSetting() {return null;}
		@Override
		protected boolean setBathroomPreWarmerOperationSetting(byte[] edt) {return false;}
		@Override
		protected byte[] getBathroomPreWarmerOperationSetting() {return null;}
		@Override
		protected boolean setBathroomDryerOperationSetting(byte[] edt) {return false;}
		@Override
		protected byte[] getBathroomDryerOperationSetting() {return null;}
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
