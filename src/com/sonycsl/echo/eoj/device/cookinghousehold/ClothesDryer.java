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
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class ClothesDryer extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x03C6;

	public static final byte EPC_DOOR_COVER_OPEN_CLOSE_STATUS = (byte)0xB0;
	public static final byte EPC_DRYING_SETTING = (byte)0xB2;
	public static final byte EPC_DRYING_STATUS = (byte)0xE1;
	public static final byte EPC_REMAINING_DRYING_TIME = (byte)0xE6;
	public static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_ON_TIMER_SETTING = (byte)0x91;
	public static final byte EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING = (byte)0x92;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
	}
	
	@Override
	public void initialize(EchoNode node) {
		super.initialize(node);
		Echo.EventListener listener = Echo.getEventListener();
		if(listener != null) listener.onNewClothesDryer(this);
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
	 * This property indicates the<br>
	 * ON/OFF status.<br>
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
	 * Property name : Door/cover open/close status<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the status of the door or cover as to whether it is open or closed.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Door/cover open = 0x41<br>
	 * Door/cover closed = 0x42<br>
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
	protected byte[] getDoorCoverOpenCloseStatus() {return null;}
	/**
	 * Property name : Door/cover open/close status<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the status of the door or cover as to whether it is open or closed.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Door/cover open = 0x41<br>
	 * Door/cover closed = 0x42<br>
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
	protected boolean isValidDoorCoverOpenCloseStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Drying setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Drying setting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Start/restart drying  0x41, Suspend drying  0x42,<br>
	 * Stop drying  0x43<br>
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
	protected boolean setDryingSetting(byte[] edt) {return false;}
	/**
	 * Property name : Drying setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Drying setting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Start/restart drying  0x41, Suspend drying  0x42,<br>
	 * Stop drying  0x43<br>
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
	protected byte[] getDryingSetting() {return null;}
	/**
	 * Property name : Drying setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Drying setting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Start/restart drying  0x41, Suspend drying  0x42,<br>
	 * Stop drying  0x43<br>
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
	protected boolean isValidDryingSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Drying status<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Drying status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Drying in progress  0x41<br>
	 * Drying suspended  0x42<br>
	 * Drying completed/stopped  0x43<br>
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
	protected byte[] getDryingStatus() {return null;}
	/**
	 * Property name : Drying status<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Drying status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Drying in progress  0x41<br>
	 * Drying suspended  0x42<br>
	 * Drying completed/stopped  0x43<br>
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
	protected boolean isValidDryingStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Remaining drying time<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the remaining drying time in the  gHH:MM:SS h .format.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0-0x3B : 0-0x3B<br>
	 * (=0-23):(=0-59):(=0-59)<br>
	 * <br>
	 * Data type : unsigned char
 ~3<br>
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
	protected byte[] getRemainingDryingTime() {return null;}
	/**
	 * Property name : Remaining drying time<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the remaining drying time in the  gHH:MM:SS h .format.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0-0x3B : 0-0x3B<br>
	 * (=0-23):(=0-59):(=0-59)<br>
	 * <br>
	 * Data type : unsigned char
 ~3<br>
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
	protected boolean isValidRemainingDryingTime(byte[] edt) {
		if(edt == null || !(edt.length == 3)) return false;
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
	 * Reservation ON  0x41<br>
	 * Reservation OFF  0x42<br>
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
	 * Reservation ON  0x41<br>
	 * Reservation OFF  0x42<br>
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
	 * Reservation ON  0x41<br>
	 * Reservation OFF  0x42<br>
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
	 * Timer value    HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0-0x3B<br>
	 * (=0-23):(=0-59)<br>
	 * <br>
	 * Data type : unsigned char
 ~ Q<br>
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
	 * Timer value    HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0-0x3B<br>
	 * (=0-23):(=0-59)<br>
	 * <br>
	 * Data type : unsigned char
 ~ Q<br>
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
	 * Timer value    HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0-0x3B<br>
	 * (=0-23):(=0-59)<br>
	 * <br>
	 * Data type : unsigned char
 ~ Q<br>
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
	/**
	 * Property name : Relative
time-based ON
timer setting<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value    HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0-0x3B<br>
	 * (=0-23):(=0-59)<br>
	 * <br>
	 * Data type : unsigned char
 ~ Q<br>
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
	protected boolean setRelativeTimeBasedOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Property name : Relative
time-based ON
timer setting<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value    HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0-0x3B<br>
	 * (=0-23):(=0-59)<br>
	 * <br>
	 * Data type : unsigned char
 ~ Q<br>
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
	protected byte[] getRelativeTimeBasedOnTimerSetting() {return null;}
	/**
	 * Property name : Relative
time-based ON
timer setting<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value    HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0-0x3B<br>
	 * (=0-23):(=0-59)<br>
	 * <br>
	 * Data type : unsigned char
 ~ Q<br>
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
	protected boolean isValidRelativeTimeBasedOnTimerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}

	@Override
	protected boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_DRYING_SETTING : return setDryingSetting(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return setOnTimerReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING : return setOnTimerSetting(property.edt);
		case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING : return setRelativeTimeBasedOnTimerSetting(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_DOOR_COVER_OPEN_CLOSE_STATUS : return getDoorCoverOpenCloseStatus();
		case EPC_DRYING_SETTING : return getDryingSetting();
		case EPC_DRYING_STATUS : return getDryingStatus();
		case EPC_REMAINING_DRYING_TIME : return getRemainingDryingTime();
		case EPC_ON_TIMER_RESERVATION_SETTING : return getOnTimerReservationSetting();
		case EPC_ON_TIMER_SETTING : return getOnTimerSetting();
		case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING : return getRelativeTimeBasedOnTimerSetting();
		default : return null;
		}
	}

	@Override
	protected boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_DOOR_COVER_OPEN_CLOSE_STATUS : return isValidDoorCoverOpenCloseStatus(property.edt);
		case EPC_DRYING_SETTING : return isValidDryingSetting(property.edt);
		case EPC_DRYING_STATUS : return isValidDryingStatus(property.edt);
		case EPC_REMAINING_DRYING_TIME : return isValidRemainingDryingTime(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return isValidOnTimerReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING : return isValidOnTimerSetting(property.edt);
		case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING : return isValidRelativeTimeBasedOnTimerSetting(property.edt);
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
			case EPC_DRYING_SETTING : 
				onSetDryingSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onSetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING : 
				onSetOnTimerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING : 
				onSetRelativeTimeBasedOnTimerSetting(eoj, tid, esv, property, success);
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
			case EPC_DOOR_COVER_OPEN_CLOSE_STATUS : 
				onGetDoorCoverOpenCloseStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_DRYING_SETTING : 
				onGetDryingSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DRYING_STATUS : 
				onGetDryingStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_REMAINING_DRYING_TIME : 
				onGetRemainingDryingTime(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onGetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING : 
				onGetOnTimerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING : 
				onGetRelativeTimeBasedOnTimerSetting(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Door/cover open/close status<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the status of the door or cover as to whether it is open or closed.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Door/cover open = 0x41<br>
		 * Door/cover closed = 0x42<br>
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
		protected void onGetDoorCoverOpenCloseStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Drying setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Drying setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart drying  0x41, Suspend drying  0x42,<br>
		 * Stop drying  0x43<br>
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
		protected void onSetDryingSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Drying setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Drying setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart drying  0x41, Suspend drying  0x42,<br>
		 * Stop drying  0x43<br>
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
		protected void onGetDryingSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Drying status<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Drying status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Drying in progress  0x41<br>
		 * Drying suspended  0x42<br>
		 * Drying completed/stopped  0x43<br>
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
		protected void onGetDryingStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Remaining drying time<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the remaining drying time in the  gHH:MM:SS h .format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B : 0-0x3B<br>
		 * (=0-23):(=0-59):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
 ~3<br>
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
		protected void onGetRemainingDryingTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON  0x41<br>
		 * Reservation OFF  0x42<br>
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
		 * Reservation ON  0x41<br>
		 * Reservation OFF  0x42<br>
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
		 * Timer value    HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
 ~ Q<br>
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
		 * Timer value    HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
 ~ Q<br>
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
		/**
		 * Property name : Relative
time-based ON
timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value    HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
 ~ Q<br>
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
		protected void onSetRelativeTimeBasedOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Relative
time-based ON
timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value    HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
 ~ Q<br>
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
		protected void onGetRelativeTimeBasedOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Drying setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Drying setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart drying  0x41, Suspend drying  0x42,<br>
		 * Stop drying  0x43<br>
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
		public Setter reqSetDryingSetting(byte[] edt) {
			addProperty(EPC_DRYING_SETTING, edt);
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
		 * Reservation ON  0x41<br>
		 * Reservation OFF  0x42<br>
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
		 * Timer value    HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
 ~ Q<br>
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
		/**
		 * Property name : Relative
time-based ON
timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value    HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
 ~ Q<br>
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
		public Setter reqSetRelativeTimeBasedOnTimerSetting(byte[] edt) {
			addProperty(EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING, edt);
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
		 * Property name : Door/cover open/close status<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the status of the door or cover as to whether it is open or closed.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Door/cover open = 0x41<br>
		 * Door/cover closed = 0x42<br>
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
		public Getter reqGetDoorCoverOpenCloseStatus() {
			addProperty(EPC_DOOR_COVER_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * Property name : Drying setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Drying setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart drying  0x41, Suspend drying  0x42,<br>
		 * Stop drying  0x43<br>
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
		public Getter reqGetDryingSetting() {
			addProperty(EPC_DRYING_SETTING);
			return this;
		}
		/**
		 * Property name : Drying status<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Drying status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Drying in progress  0x41<br>
		 * Drying suspended  0x42<br>
		 * Drying completed/stopped  0x43<br>
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
		public Getter reqGetDryingStatus() {
			addProperty(EPC_DRYING_STATUS);
			return this;
		}
		/**
		 * Property name : Remaining drying time<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the remaining drying time in the  gHH:MM:SS h .format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B : 0-0x3B<br>
		 * (=0-23):(=0-59):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
 ~3<br>
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
		public Getter reqGetRemainingDryingTime() {
			addProperty(EPC_REMAINING_DRYING_TIME);
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
		 * Reservation ON  0x41<br>
		 * Reservation OFF  0x42<br>
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
		 * Timer value    HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
 ~ Q<br>
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
		/**
		 * Property name : Relative
time-based ON
timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value    HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
 ~ Q<br>
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
		public Getter reqGetRelativeTimeBasedOnTimerSetting() {
			addProperty(EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING);
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
		 * Property name : Door/cover open/close status<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the status of the door or cover as to whether it is open or closed.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Door/cover open = 0x41<br>
		 * Door/cover closed = 0x42<br>
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
		public Informer reqInformDoorCoverOpenCloseStatus() {
			addProperty(EPC_DOOR_COVER_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * Property name : Drying setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Drying setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart drying  0x41, Suspend drying  0x42,<br>
		 * Stop drying  0x43<br>
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
		public Informer reqInformDryingSetting() {
			addProperty(EPC_DRYING_SETTING);
			return this;
		}
		/**
		 * Property name : Drying status<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Drying status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Drying in progress  0x41<br>
		 * Drying suspended  0x42<br>
		 * Drying completed/stopped  0x43<br>
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
		public Informer reqInformDryingStatus() {
			addProperty(EPC_DRYING_STATUS);
			return this;
		}
		/**
		 * Property name : Remaining drying time<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the remaining drying time in the  gHH:MM:SS h .format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B : 0-0x3B<br>
		 * (=0-23):(=0-59):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
 ~3<br>
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
		public Informer reqInformRemainingDryingTime() {
			addProperty(EPC_REMAINING_DRYING_TIME);
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
		 * Reservation ON  0x41<br>
		 * Reservation OFF  0x42<br>
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
		 * Timer value    HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
 ~ Q<br>
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
		/**
		 * Property name : Relative
time-based ON
timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value    HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
 ~ Q<br>
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
		public Informer reqInformRelativeTimeBasedOnTimerSetting() {
			addProperty(EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING);
			return this;
		}
	}

	public static class Proxy extends ClothesDryer {
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
