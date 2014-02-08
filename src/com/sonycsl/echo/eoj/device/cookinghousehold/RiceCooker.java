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
package com.sonycsl.echo.eoj.device.cookinghousehold;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class RiceCooker extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x03BB;

	public static final byte EPC_COVER_OPEN_CLOSE_STATUS = (byte)0xB0;
	public static final byte EPC_RICE_COOKING_STATUS = (byte)0xB1;
	public static final byte EPC_RICE_COOKING_CONTROL_SETTING = (byte)0xB2;
	public static final byte EPC_WARMER_SETTING = (byte)0xE1;
	public static final byte EPC_INNER_POT_REMOVAL_STATUS = (byte)0xE5;
	public static final byte EPC_COVER_REMOVAL_STATUS = (byte)0xE6;
	public static final byte EPC_RICE_COOKING_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_TIME = (byte)0x91;
	public static final byte EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_RELATIVE_TIME = (byte)0x92;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_RICE_COOKING_STATUS);
		addSetProperty(EPC_RICE_COOKING_CONTROL_SETTING);
		addGetProperty(EPC_RICE_COOKING_CONTROL_SETTING);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewRiceCooker(this);
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
	 * This  property  indicates  the  ON/OFF status.<br>
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
	 * This  property  indicates  the  ON/OFF status.<br>
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
	 * Property name : Cover open/close status<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether the cover is open or closed.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Cover open = 0x41, Cover closed = 0x42<br>
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
	protected byte[] getCoverOpenCloseStatus() {return null;}
	/**
	 * Property name : Cover open/close status<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether the cover is open or closed.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Cover open = 0x41, Cover closed = 0x42<br>
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
	protected boolean isValidCoverOpenCloseStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Rice cooking status<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates rice cooking status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Stop = 0x41, Preheating = 0x42, Rice cooking = 0x43, Steaming = 0x44, Rice cooking completion = 0x45<br>
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
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getRiceCookingStatus();
	/**
	 * Property name : Rice cooking status<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates rice cooking status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Stop = 0x41, Preheating = 0x42, Rice cooking = 0x43, Steaming = 0x44, Rice cooking completion = 0x45<br>
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
	 * Get - mandatory<br>
	 */
	protected boolean isValidRiceCookingStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Rice cooking control setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates rice cooking control setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Rice cooking start/restart = 0x41, Rice cooking suspension = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract boolean setRiceCookingControlSetting(byte[] edt);
	/**
	 * Property name : Rice cooking control setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates rice cooking control setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Rice cooking start/restart = 0x41, Rice cooking suspension = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getRiceCookingControlSetting();
	/**
	 * Property name : Rice cooking control setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates rice cooking control setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Rice cooking start/restart = 0x41, Rice cooking suspension = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidRiceCookingControlSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Warmer setting<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether or not warmer function is enabled.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Warmer enabled = 0x41, Warmer disabled = 0x42<br>
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
	 * Get - optional<br>
	 */
	protected boolean setWarmerSetting(byte[] edt) {return false;}
	/**
	 * Property name : Warmer setting<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether or not warmer function is enabled.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Warmer enabled = 0x41, Warmer disabled = 0x42<br>
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
	 * Get - optional<br>
	 */
	protected byte[] getWarmerSetting() {return null;}
	/**
	 * Property name : Warmer setting<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether or not warmer function is enabled.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Warmer enabled = 0x41, Warmer disabled = 0x42<br>
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
	 * Get - optional<br>
	 */
	protected boolean isValidWarmerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Inner pot removal status<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether inner pot is removed or not.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Removed = 0x41, Not removed = 0x42<br>
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
	protected byte[] getInnerPotRemovalStatus() {return null;}
	/**
	 * Property name : Inner pot removal status<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether inner pot is removed or not.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Removed = 0x41, Not removed = 0x42<br>
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
	protected boolean isValidInnerPotRemovalStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Cover removal status<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether or not cover is removed.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Removed = 0x41, Not removed = 0x42<br>
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
	protected byte[] getCoverRemovalStatus() {return null;}
	/**
	 * Property name : Cover removal status<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether or not cover is removed.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Removed = 0x41, Not removed = 0x42<br>
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
	protected boolean isValidCoverRemovalStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Rice cooking reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether rice cooking reservation is ON or OFF.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41, Reservation OFF = 0x42<br>
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
	 * Get - optional<br>
	 */
	protected boolean setRiceCookingReservationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Rice cooking reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether rice cooking reservation is ON or OFF.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41, Reservation OFF = 0x42<br>
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
	 * Get - optional<br>
	 */
	protected byte[] getRiceCookingReservationSetting() {return null;}
	/**
	 * Property name : Rice cooking reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether rice cooking reservation is ON or OFF.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41, Reservation OFF = 0x42<br>
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
	 * Get - optional<br>
	 */
	protected boolean isValidRiceCookingReservationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Set value of rice cooking reservation setting time<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSetValueOfRiceCookingReservationSettingTime(byte[] edt) {return false;}
	/**
	 * Property name : Set value of rice cooking reservation setting time<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSetValueOfRiceCookingReservationSettingTime() {return null;}
	/**
	 * Property name : Set value of rice cooking reservation setting time<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSetValueOfRiceCookingReservationSettingTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Set value of rice cooking reservation setting relative time<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSetValueOfRiceCookingReservationSettingRelativeTime(byte[] edt) {return false;}
	/**
	 * Property name : Set value of rice cooking reservation setting relative time<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSetValueOfRiceCookingReservationSettingRelativeTime() {return null;}
	/**
	 * Property name : Set value of rice cooking reservation setting relative time<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSetValueOfRiceCookingReservationSettingRelativeTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_RICE_COOKING_CONTROL_SETTING : return setRiceCookingControlSetting(property.edt);
		case EPC_WARMER_SETTING : return setWarmerSetting(property.edt);
		case EPC_RICE_COOKING_RESERVATION_SETTING : return setRiceCookingReservationSetting(property.edt);
		case EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_TIME : return setSetValueOfRiceCookingReservationSettingTime(property.edt);
		case EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_RELATIVE_TIME : return setSetValueOfRiceCookingReservationSettingRelativeTime(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_COVER_OPEN_CLOSE_STATUS : return getCoverOpenCloseStatus();
		case EPC_RICE_COOKING_STATUS : return getRiceCookingStatus();
		case EPC_RICE_COOKING_CONTROL_SETTING : return getRiceCookingControlSetting();
		case EPC_WARMER_SETTING : return getWarmerSetting();
		case EPC_INNER_POT_REMOVAL_STATUS : return getInnerPotRemovalStatus();
		case EPC_COVER_REMOVAL_STATUS : return getCoverRemovalStatus();
		case EPC_RICE_COOKING_RESERVATION_SETTING : return getRiceCookingReservationSetting();
		case EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_TIME : return getSetValueOfRiceCookingReservationSettingTime();
		case EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_RELATIVE_TIME : return getSetValueOfRiceCookingReservationSettingRelativeTime();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_COVER_OPEN_CLOSE_STATUS : return isValidCoverOpenCloseStatus(property.edt);
		case EPC_RICE_COOKING_STATUS : return isValidRiceCookingStatus(property.edt);
		case EPC_RICE_COOKING_CONTROL_SETTING : return isValidRiceCookingControlSetting(property.edt);
		case EPC_WARMER_SETTING : return isValidWarmerSetting(property.edt);
		case EPC_INNER_POT_REMOVAL_STATUS : return isValidInnerPotRemovalStatus(property.edt);
		case EPC_COVER_REMOVAL_STATUS : return isValidCoverRemovalStatus(property.edt);
		case EPC_RICE_COOKING_RESERVATION_SETTING : return isValidRiceCookingReservationSetting(property.edt);
		case EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_TIME : return isValidSetValueOfRiceCookingReservationSettingTime(property.edt);
		case EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_RELATIVE_TIME : return isValidSetValueOfRiceCookingReservationSettingRelativeTime(property.edt);
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
			case EPC_RICE_COOKING_CONTROL_SETTING : 
				onSetRiceCookingControlSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WARMER_SETTING : 
				onSetWarmerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RICE_COOKING_RESERVATION_SETTING : 
				onSetRiceCookingReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_TIME : 
				onSetSetValueOfRiceCookingReservationSettingTime(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_RELATIVE_TIME : 
				onSetSetValueOfRiceCookingReservationSettingRelativeTime(eoj, tid, esv, property, success);
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
			case EPC_COVER_OPEN_CLOSE_STATUS : 
				onGetCoverOpenCloseStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_RICE_COOKING_STATUS : 
				onGetRiceCookingStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_RICE_COOKING_CONTROL_SETTING : 
				onGetRiceCookingControlSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WARMER_SETTING : 
				onGetWarmerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_INNER_POT_REMOVAL_STATUS : 
				onGetInnerPotRemovalStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_COVER_REMOVAL_STATUS : 
				onGetCoverRemovalStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_RICE_COOKING_RESERVATION_SETTING : 
				onGetRiceCookingReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_TIME : 
				onGetSetValueOfRiceCookingReservationSettingTime(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_RELATIVE_TIME : 
				onGetSetValueOfRiceCookingReservationSettingRelativeTime(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Cover open/close status<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the cover is open or closed.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Cover open = 0x41, Cover closed = 0x42<br>
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
		protected void onGetCoverOpenCloseStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rice cooking status<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates rice cooking status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Stop = 0x41, Preheating = 0x42, Rice cooking = 0x43, Steaming = 0x44, Rice cooking completion = 0x45<br>
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
		 * Get - mandatory<br>
		 */
		protected void onGetRiceCookingStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rice cooking control setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates rice cooking control setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rice cooking start/restart = 0x41, Rice cooking suspension = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onSetRiceCookingControlSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rice cooking control setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates rice cooking control setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rice cooking start/restart = 0x41, Rice cooking suspension = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onGetRiceCookingControlSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Warmer setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether or not warmer function is enabled.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Warmer enabled = 0x41, Warmer disabled = 0x42<br>
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
		 * Get - optional<br>
		 */
		protected void onSetWarmerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Warmer setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether or not warmer function is enabled.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Warmer enabled = 0x41, Warmer disabled = 0x42<br>
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
		 * Get - optional<br>
		 */
		protected void onGetWarmerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Inner pot removal status<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether inner pot is removed or not.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Removed = 0x41, Not removed = 0x42<br>
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
		protected void onGetInnerPotRemovalStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Cover removal status<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether or not cover is removed.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Removed = 0x41, Not removed = 0x42<br>
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
		protected void onGetCoverRemovalStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rice cooking reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether rice cooking reservation is ON or OFF.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, Reservation OFF = 0x42<br>
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
		 * Get - optional<br>
		 */
		protected void onSetRiceCookingReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rice cooking reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether rice cooking reservation is ON or OFF.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, Reservation OFF = 0x42<br>
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
		 * Get - optional<br>
		 */
		protected void onGetRiceCookingReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of rice cooking reservation setting time<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSetValueOfRiceCookingReservationSettingTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of rice cooking reservation setting time<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSetValueOfRiceCookingReservationSettingTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of rice cooking reservation setting relative time<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSetValueOfRiceCookingReservationSettingRelativeTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of rice cooking reservation setting relative time<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSetValueOfRiceCookingReservationSettingRelativeTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Rice cooking control setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates rice cooking control setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rice cooking start/restart = 0x41, Rice cooking suspension = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Setter reqSetRiceCookingControlSetting(byte[] edt) {
			reqSetProperty(EPC_RICE_COOKING_CONTROL_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Warmer setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether or not warmer function is enabled.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Warmer enabled = 0x41, Warmer disabled = 0x42<br>
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
		 * Get - optional<br>
		 */
		public Setter reqSetWarmerSetting(byte[] edt) {
			reqSetProperty(EPC_WARMER_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Rice cooking reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether rice cooking reservation is ON or OFF.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, Reservation OFF = 0x42<br>
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
		 * Get - optional<br>
		 */
		public Setter reqSetRiceCookingReservationSetting(byte[] edt) {
			reqSetProperty(EPC_RICE_COOKING_RESERVATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Set value of rice cooking reservation setting time<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSetValueOfRiceCookingReservationSettingTime(byte[] edt) {
			reqSetProperty(EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_TIME, edt);
			return this;
		}
		/**
		 * Property name : Set value of rice cooking reservation setting relative time<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSetValueOfRiceCookingReservationSettingRelativeTime(byte[] edt) {
			reqSetProperty(EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_RELATIVE_TIME, edt);
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
		 * Property name : Cover open/close status<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the cover is open or closed.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Cover open = 0x41, Cover closed = 0x42<br>
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
		public Getter reqGetCoverOpenCloseStatus() {
			reqGetProperty(EPC_COVER_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * Property name : Rice cooking status<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates rice cooking status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Stop = 0x41, Preheating = 0x42, Rice cooking = 0x43, Steaming = 0x44, Rice cooking completion = 0x45<br>
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
		 * Get - mandatory<br>
		 */
		public Getter reqGetRiceCookingStatus() {
			reqGetProperty(EPC_RICE_COOKING_STATUS);
			return this;
		}
		/**
		 * Property name : Rice cooking control setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates rice cooking control setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rice cooking start/restart = 0x41, Rice cooking suspension = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetRiceCookingControlSetting() {
			reqGetProperty(EPC_RICE_COOKING_CONTROL_SETTING);
			return this;
		}
		/**
		 * Property name : Warmer setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether or not warmer function is enabled.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Warmer enabled = 0x41, Warmer disabled = 0x42<br>
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
		 * Get - optional<br>
		 */
		public Getter reqGetWarmerSetting() {
			reqGetProperty(EPC_WARMER_SETTING);
			return this;
		}
		/**
		 * Property name : Inner pot removal status<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether inner pot is removed or not.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Removed = 0x41, Not removed = 0x42<br>
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
		public Getter reqGetInnerPotRemovalStatus() {
			reqGetProperty(EPC_INNER_POT_REMOVAL_STATUS);
			return this;
		}
		/**
		 * Property name : Cover removal status<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether or not cover is removed.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Removed = 0x41, Not removed = 0x42<br>
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
		public Getter reqGetCoverRemovalStatus() {
			reqGetProperty(EPC_COVER_REMOVAL_STATUS);
			return this;
		}
		/**
		 * Property name : Rice cooking reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether rice cooking reservation is ON or OFF.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, Reservation OFF = 0x42<br>
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
		 * Get - optional<br>
		 */
		public Getter reqGetRiceCookingReservationSetting() {
			reqGetProperty(EPC_RICE_COOKING_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : Set value of rice cooking reservation setting time<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSetValueOfRiceCookingReservationSettingTime() {
			reqGetProperty(EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_TIME);
			return this;
		}
		/**
		 * Property name : Set value of rice cooking reservation setting relative time<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSetValueOfRiceCookingReservationSettingRelativeTime() {
			reqGetProperty(EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_RELATIVE_TIME);
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
		 * Property name : Cover open/close status<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether the cover is open or closed.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Cover open = 0x41, Cover closed = 0x42<br>
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
		public Informer reqInformCoverOpenCloseStatus() {
			reqInformProperty(EPC_COVER_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * Property name : Rice cooking status<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates rice cooking status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Stop = 0x41, Preheating = 0x42, Rice cooking = 0x43, Steaming = 0x44, Rice cooking completion = 0x45<br>
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
		 * Get - mandatory<br>
		 */
		public Informer reqInformRiceCookingStatus() {
			reqInformProperty(EPC_RICE_COOKING_STATUS);
			return this;
		}
		/**
		 * Property name : Rice cooking control setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates rice cooking control setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rice cooking start/restart = 0x41, Rice cooking suspension = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformRiceCookingControlSetting() {
			reqInformProperty(EPC_RICE_COOKING_CONTROL_SETTING);
			return this;
		}
		/**
		 * Property name : Warmer setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether or not warmer function is enabled.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Warmer enabled = 0x41, Warmer disabled = 0x42<br>
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
		 * Get - optional<br>
		 */
		public Informer reqInformWarmerSetting() {
			reqInformProperty(EPC_WARMER_SETTING);
			return this;
		}
		/**
		 * Property name : Inner pot removal status<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether inner pot is removed or not.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Removed = 0x41, Not removed = 0x42<br>
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
		public Informer reqInformInnerPotRemovalStatus() {
			reqInformProperty(EPC_INNER_POT_REMOVAL_STATUS);
			return this;
		}
		/**
		 * Property name : Cover removal status<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether or not cover is removed.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Removed = 0x41, Not removed = 0x42<br>
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
		public Informer reqInformCoverRemovalStatus() {
			reqInformProperty(EPC_COVER_REMOVAL_STATUS);
			return this;
		}
		/**
		 * Property name : Rice cooking reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether rice cooking reservation is ON or OFF.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, Reservation OFF = 0x42<br>
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
		 * Get - optional<br>
		 */
		public Informer reqInformRiceCookingReservationSetting() {
			reqInformProperty(EPC_RICE_COOKING_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : Set value of rice cooking reservation setting time<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSetValueOfRiceCookingReservationSettingTime() {
			reqInformProperty(EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_TIME);
			return this;
		}
		/**
		 * Property name : Set value of rice cooking reservation setting relative time<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSetValueOfRiceCookingReservationSettingRelativeTime() {
			reqInformProperty(EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_RELATIVE_TIME);
			return this;
		}
	}

	public static class Proxy extends RiceCooker {
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
		protected byte[] getRiceCookingStatus() {return null;}
		@Override
		protected boolean setRiceCookingControlSetting(byte[] edt) {return false;}
		@Override
		protected byte[] getRiceCookingControlSetting() {return null;}
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
