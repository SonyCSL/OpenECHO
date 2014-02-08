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

public abstract class AirCleaner extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0135;

	public static final byte EPC_FILTER_CHANGE_NOTICE = (byte)0xE1;
	public static final byte EPC_AIR_FLOW_RATE_SETTING = (byte)0xA0;
	public static final byte EPC_SMOKE_CIGARETTE_DETECTION_STATUS = (byte)0xC1;
	public static final byte EPC_OPTICAL_CATALYST_OPERATION_SETTING = (byte)0xC2;
	public static final byte EPC_AIR_POLLUTION_DETECTION_STATUS = (byte)0xC0;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		addSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewAirCleaner(this);
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
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract boolean setOperationStatus(byte[] edt);
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
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getOperationStatus();
	/**
	 * Property name : Filter change notice<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Filter change time notice found/not found<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Found = 0x41, Not found = 0x42<br>
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
	protected byte[] getFilterChangeNotice() {return null;}
	/**
	 * Property name : Filter change notice<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Filter change time notice found/not found<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Found = 0x41, Not found = 0x42<br>
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
	protected boolean isValidFilterChangeNotice(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Air flow rate setting<br>
	 * <br>
	 * EPC : 0xA0<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets air flow rate level and air flow rate auto status. The ventilation air flow rate is specified (8-step).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Ventilation air flow rate auto status<br>
	 * = 0x41<br>
	 * Ventilation air flow rate level<br>
	 * = 0x31.0x38<br>
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
	protected boolean setAirFlowRateSetting(byte[] edt) {return false;}
	/**
	 * Property name : Air flow rate setting<br>
	 * <br>
	 * EPC : 0xA0<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets air flow rate level and air flow rate auto status. The ventilation air flow rate is specified (8-step).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Ventilation air flow rate auto status<br>
	 * = 0x41<br>
	 * Ventilation air flow rate level<br>
	 * = 0x31.0x38<br>
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
	protected byte[] getAirFlowRateSetting() {return null;}
	/**
	 * Property name : Air flow rate setting<br>
	 * <br>
	 * EPC : 0xA0<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets air flow rate level and air flow rate auto status. The ventilation air flow rate is specified (8-step).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Ventilation air flow rate auto status<br>
	 * = 0x41<br>
	 * Ventilation air flow rate level<br>
	 * = 0x31.0x38<br>
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
	protected boolean isValidAirFlowRateSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Smoke (cigarette) detection status<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates smoke (cigarette) detection status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Smoke (cigarette) detection status found = 0x41<br>
	 * Smoke (cigarette) detection status not found = 0x42<br>
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
	protected byte[] getSmokeCigaretteDetectionStatus() {return null;}
	/**
	 * Property name : Smoke (cigarette) detection status<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates smoke (cigarette) detection status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Smoke (cigarette) detection status found = 0x41<br>
	 * Smoke (cigarette) detection status not found = 0x42<br>
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
	protected boolean isValidSmokeCigaretteDetectionStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Optical catalyst operation setting<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents of property :<br>
	 * Optical catalyst ON/OFF status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Optical catalyst ON = 0x41 Optical catalyst OFF = 0x42<br>
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
	protected boolean setOpticalCatalystOperationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Optical catalyst operation setting<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents of property :<br>
	 * Optical catalyst ON/OFF status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Optical catalyst ON = 0x41 Optical catalyst OFF = 0x42<br>
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
	protected byte[] getOpticalCatalystOperationSetting() {return null;}
	/**
	 * Property name : Optical catalyst operation setting<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents of property :<br>
	 * Optical catalyst ON/OFF status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Optical catalyst ON = 0x41 Optical catalyst OFF = 0x42<br>
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
	protected boolean isValidOpticalCatalystOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Air pollution detection status<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates air pollution detection status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Air pollution detected = 0x41<br>
	 * Air pollution non-detected = 0x42<br>
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
	protected byte[] getAirPollutionDetectionStatus() {return null;}
	/**
	 * Property name : Air pollution detection status<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates air pollution detection status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Air pollution detected = 0x41<br>
	 * Air pollution non-detected = 0x42<br>
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
	protected boolean isValidAirPollutionDetectionStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_AIR_FLOW_RATE_SETTING : return setAirFlowRateSetting(property.edt);
		case EPC_OPTICAL_CATALYST_OPERATION_SETTING : return setOpticalCatalystOperationSetting(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_FILTER_CHANGE_NOTICE : return getFilterChangeNotice();
		case EPC_AIR_FLOW_RATE_SETTING : return getAirFlowRateSetting();
		case EPC_SMOKE_CIGARETTE_DETECTION_STATUS : return getSmokeCigaretteDetectionStatus();
		case EPC_OPTICAL_CATALYST_OPERATION_SETTING : return getOpticalCatalystOperationSetting();
		case EPC_AIR_POLLUTION_DETECTION_STATUS : return getAirPollutionDetectionStatus();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_FILTER_CHANGE_NOTICE : return isValidFilterChangeNotice(property.edt);
		case EPC_AIR_FLOW_RATE_SETTING : return isValidAirFlowRateSetting(property.edt);
		case EPC_SMOKE_CIGARETTE_DETECTION_STATUS : return isValidSmokeCigaretteDetectionStatus(property.edt);
		case EPC_OPTICAL_CATALYST_OPERATION_SETTING : return isValidOpticalCatalystOperationSetting(property.edt);
		case EPC_AIR_POLLUTION_DETECTION_STATUS : return isValidAirPollutionDetectionStatus(property.edt);
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
			case EPC_AIR_FLOW_RATE_SETTING : 
				onSetAirFlowRateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OPTICAL_CATALYST_OPERATION_SETTING : 
				onSetOpticalCatalystOperationSetting(eoj, tid, esv, property, success);
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
			case EPC_FILTER_CHANGE_NOTICE : 
				onGetFilterChangeNotice(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_FLOW_RATE_SETTING : 
				onGetAirFlowRateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SMOKE_CIGARETTE_DETECTION_STATUS : 
				onGetSmokeCigaretteDetectionStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_OPTICAL_CATALYST_OPERATION_SETTING : 
				onGetOpticalCatalystOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_POLLUTION_DETECTION_STATUS : 
				onGetAirPollutionDetectionStatus(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Filter change notice<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Filter change time notice found/not found<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Found = 0x41, Not found = 0x42<br>
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
		protected void onGetFilterChangeNotice(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air flow rate setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets air flow rate level and air flow rate auto status. The ventilation air flow rate is specified (8-step).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation air flow rate auto status<br>
		 * = 0x41<br>
		 * Ventilation air flow rate level<br>
		 * = 0x31.0x38<br>
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
		protected void onSetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air flow rate setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets air flow rate level and air flow rate auto status. The ventilation air flow rate is specified (8-step).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation air flow rate auto status<br>
		 * = 0x41<br>
		 * Ventilation air flow rate level<br>
		 * = 0x31.0x38<br>
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
		protected void onGetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Smoke (cigarette) detection status<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates smoke (cigarette) detection status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Smoke (cigarette) detection status found = 0x41<br>
		 * Smoke (cigarette) detection status not found = 0x42<br>
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
		protected void onGetSmokeCigaretteDetectionStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Optical catalyst operation setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Optical catalyst ON/OFF status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Optical catalyst ON = 0x41 Optical catalyst OFF = 0x42<br>
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
		protected void onSetOpticalCatalystOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Optical catalyst operation setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Optical catalyst ON/OFF status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Optical catalyst ON = 0x41 Optical catalyst OFF = 0x42<br>
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
		protected void onGetOpticalCatalystOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air pollution detection status<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates air pollution detection status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Air pollution detected = 0x41<br>
		 * Air pollution non-detected = 0x42<br>
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
		protected void onGetAirPollutionDetectionStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Air flow rate setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets air flow rate level and air flow rate auto status. The ventilation air flow rate is specified (8-step).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation air flow rate auto status<br>
		 * = 0x41<br>
		 * Ventilation air flow rate level<br>
		 * = 0x31.0x38<br>
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
		public Setter reqSetAirFlowRateSetting(byte[] edt) {
			reqSetProperty(EPC_AIR_FLOW_RATE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Optical catalyst operation setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Optical catalyst ON/OFF status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Optical catalyst ON = 0x41 Optical catalyst OFF = 0x42<br>
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
		public Setter reqSetOpticalCatalystOperationSetting(byte[] edt) {
			reqSetProperty(EPC_OPTICAL_CATALYST_OPERATION_SETTING, edt);
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
		 * Property name : Filter change notice<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Filter change time notice found/not found<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Found = 0x41, Not found = 0x42<br>
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
		public Getter reqGetFilterChangeNotice() {
			reqGetProperty(EPC_FILTER_CHANGE_NOTICE);
			return this;
		}
		/**
		 * Property name : Air flow rate setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets air flow rate level and air flow rate auto status. The ventilation air flow rate is specified (8-step).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation air flow rate auto status<br>
		 * = 0x41<br>
		 * Ventilation air flow rate level<br>
		 * = 0x31.0x38<br>
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
		public Getter reqGetAirFlowRateSetting() {
			reqGetProperty(EPC_AIR_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Property name : Smoke (cigarette) detection status<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates smoke (cigarette) detection status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Smoke (cigarette) detection status found = 0x41<br>
		 * Smoke (cigarette) detection status not found = 0x42<br>
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
		public Getter reqGetSmokeCigaretteDetectionStatus() {
			reqGetProperty(EPC_SMOKE_CIGARETTE_DETECTION_STATUS);
			return this;
		}
		/**
		 * Property name : Optical catalyst operation setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Optical catalyst ON/OFF status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Optical catalyst ON = 0x41 Optical catalyst OFF = 0x42<br>
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
		public Getter reqGetOpticalCatalystOperationSetting() {
			reqGetProperty(EPC_OPTICAL_CATALYST_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Air pollution detection status<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates air pollution detection status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Air pollution detected = 0x41<br>
		 * Air pollution non-detected = 0x42<br>
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
		public Getter reqGetAirPollutionDetectionStatus() {
			reqGetProperty(EPC_AIR_POLLUTION_DETECTION_STATUS);
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
		 * Property name : Filter change notice<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Filter change time notice found/not found<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Found = 0x41, Not found = 0x42<br>
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
		public Informer reqInformFilterChangeNotice() {
			reqInformProperty(EPC_FILTER_CHANGE_NOTICE);
			return this;
		}
		/**
		 * Property name : Air flow rate setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets air flow rate level and air flow rate auto status. The ventilation air flow rate is specified (8-step).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation air flow rate auto status<br>
		 * = 0x41<br>
		 * Ventilation air flow rate level<br>
		 * = 0x31.0x38<br>
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
		public Informer reqInformAirFlowRateSetting() {
			reqInformProperty(EPC_AIR_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Property name : Smoke (cigarette) detection status<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates smoke (cigarette) detection status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Smoke (cigarette) detection status found = 0x41<br>
		 * Smoke (cigarette) detection status not found = 0x42<br>
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
		public Informer reqInformSmokeCigaretteDetectionStatus() {
			reqInformProperty(EPC_SMOKE_CIGARETTE_DETECTION_STATUS);
			return this;
		}
		/**
		 * Property name : Optical catalyst operation setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Optical catalyst ON/OFF status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Optical catalyst ON = 0x41 Optical catalyst OFF = 0x42<br>
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
		public Informer reqInformOpticalCatalystOperationSetting() {
			reqInformProperty(EPC_OPTICAL_CATALYST_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Air pollution detection status<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates air pollution detection status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Air pollution detected = 0x41<br>
		 * Air pollution non-detected = 0x42<br>
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
		public Informer reqInformAirPollutionDetectionStatus() {
			reqInformProperty(EPC_AIR_POLLUTION_DETECTION_STATUS);
			return this;
		}
	}

	public static class Proxy extends AirCleaner {
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
		protected boolean setOperationStatus(byte[] edt) {return false;}
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
