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
package com.sonycsl.echo.eoj.device.sensor;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class HumanBodyLocationSensor extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x002B;

	public static final byte EPC_HUMAN_BODY_DETECTION_LOCATION1 = (byte)0xE0;
	public static final byte EPC_MAXIMUM_NUMBER_OF_HUMAN_BODY_ID_S = (byte)0xE1;
	public static final byte EPC_HUMAN_BODY_DETECTION_LOCATION2 = (byte)0xE2;
	public static final byte EPC_HUMAN_BODY_EXISTENCE_INFORMATION = (byte)0xE3;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_HUMAN_BODY_DETECTION_LOCATION1);
		addGetProperty(EPC_HUMAN_BODY_DETECTION_LOCATION2);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewHumanBodyLocationSensor(this);
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
	 * Property name : Human body detection location 1<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates human body detection location. The array element number indicates a human body ID.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br>
	 * <br>
	 * Data type : unsigned char × 3
x max 128<br>
	 * <br>
	 * Data size : 3 × max
128
bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getHumanBodyDetectionLocation1();
	/**
	 * Property name : Human body detection location 1<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates human body detection location. The array element number indicates a human body ID.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br>
	 * <br>
	 * Data type : unsigned char × 3
x max 128<br>
	 * <br>
	 * Data size : 3 × max
128
bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidHumanBodyDetectionLocation1(byte[] edt) {
		if(edt == null || !(edt.length == 3)) return false;
		return true;
	}
	/**
	 * Property name : Maximum number of human body ID’s<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates maximum number of human body IDs that can be registered for human body detection location 1.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0001.0x0080 (= 1.128)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMaximumNumberOfHumanBodyIdS() {return null;}
	/**
	 * Property name : Maximum number of human body ID’s<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates maximum number of human body IDs that can be registered for human body detection location 1.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0001.0x0080 (= 1.128)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMaximumNumberOfHumanBodyIdS(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Human body detection location 2<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates human body detection location.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br>
	 * <br>
	 * Data type : unsigned char × 3<br>
	 * <br>
	 * Data size : 3 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getHumanBodyDetectionLocation2();
	/**
	 * Property name : Human body detection location 2<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates human body detection location.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br>
	 * <br>
	 * Data type : unsigned char × 3<br>
	 * <br>
	 * Data size : 3 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidHumanBodyDetectionLocation2(byte[] edt) {
		if(edt == null || !(edt.length == 3)) return false;
		return true;
	}
	/**
	 * Property name : Human body existence information<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Array element number information retained by human body detection location 1.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * (See (5) below for details.)<br>
	 * <br>
	 * Data type : unsigned char × 16<br>
	 * <br>
	 * Data size : 16
bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getHumanBodyExistenceInformation() {return null;}
	/**
	 * Property name : Human body existence information<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Array element number information retained by human body detection location 1.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * (See (5) below for details.)<br>
	 * <br>
	 * Data type : unsigned char × 16<br>
	 * <br>
	 * Data size : 16
bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidHumanBodyExistenceInformation(byte[] edt) {
		if(edt == null || !(edt.length == 16)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_HUMAN_BODY_DETECTION_LOCATION1 : return getHumanBodyDetectionLocation1();
		case EPC_MAXIMUM_NUMBER_OF_HUMAN_BODY_ID_S : return getMaximumNumberOfHumanBodyIdS();
		case EPC_HUMAN_BODY_DETECTION_LOCATION2 : return getHumanBodyDetectionLocation2();
		case EPC_HUMAN_BODY_EXISTENCE_INFORMATION : return getHumanBodyExistenceInformation();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_HUMAN_BODY_DETECTION_LOCATION1 : return isValidHumanBodyDetectionLocation1(property.edt);
		case EPC_MAXIMUM_NUMBER_OF_HUMAN_BODY_ID_S : return isValidMaximumNumberOfHumanBodyIdS(property.edt);
		case EPC_HUMAN_BODY_DETECTION_LOCATION2 : return isValidHumanBodyDetectionLocation2(property.edt);
		case EPC_HUMAN_BODY_EXISTENCE_INFORMATION : return isValidHumanBodyExistenceInformation(property.edt);
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
			case EPC_HUMAN_BODY_DETECTION_LOCATION1 : 
				onGetHumanBodyDetectionLocation1(eoj, tid, esv, property, success);
				return true;
			case EPC_MAXIMUM_NUMBER_OF_HUMAN_BODY_ID_S : 
				onGetMaximumNumberOfHumanBodyIdS(eoj, tid, esv, property, success);
				return true;
			case EPC_HUMAN_BODY_DETECTION_LOCATION2 : 
				onGetHumanBodyDetectionLocation2(eoj, tid, esv, property, success);
				return true;
			case EPC_HUMAN_BODY_EXISTENCE_INFORMATION : 
				onGetHumanBodyExistenceInformation(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Human body detection location 1<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates human body detection location. The array element number indicates a human body ID.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br>
		 * <br>
		 * Data type : unsigned char × 3
x max 128<br>
		 * <br>
		 * Data size : 3 × max
128
bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetHumanBodyDetectionLocation1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Maximum number of human body ID’s<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates maximum number of human body IDs that can be registered for human body detection location 1.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001.0x0080 (= 1.128)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMaximumNumberOfHumanBodyIdS(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Human body detection location 2<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates human body detection location.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br>
		 * <br>
		 * Data type : unsigned char × 3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetHumanBodyDetectionLocation2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Human body existence information<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Array element number information retained by human body detection location 1.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * (See (5) below for details.)<br>
		 * <br>
		 * Data type : unsigned char × 16<br>
		 * <br>
		 * Data size : 16
bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetHumanBodyExistenceInformation(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Human body detection location 1<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates human body detection location. The array element number indicates a human body ID.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br>
		 * <br>
		 * Data type : unsigned char × 3
x max 128<br>
		 * <br>
		 * Data size : 3 × max
128
bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetHumanBodyDetectionLocation1() {
			reqGetProperty(EPC_HUMAN_BODY_DETECTION_LOCATION1);
			return this;
		}
		/**
		 * Property name : Maximum number of human body ID’s<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates maximum number of human body IDs that can be registered for human body detection location 1.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001.0x0080 (= 1.128)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMaximumNumberOfHumanBodyIdS() {
			reqGetProperty(EPC_MAXIMUM_NUMBER_OF_HUMAN_BODY_ID_S);
			return this;
		}
		/**
		 * Property name : Human body detection location 2<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates human body detection location.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br>
		 * <br>
		 * Data type : unsigned char × 3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetHumanBodyDetectionLocation2() {
			reqGetProperty(EPC_HUMAN_BODY_DETECTION_LOCATION2);
			return this;
		}
		/**
		 * Property name : Human body existence information<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Array element number information retained by human body detection location 1.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * (See (5) below for details.)<br>
		 * <br>
		 * Data type : unsigned char × 16<br>
		 * <br>
		 * Data size : 16
bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetHumanBodyExistenceInformation() {
			reqGetProperty(EPC_HUMAN_BODY_EXISTENCE_INFORMATION);
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
		 * Property name : Human body detection location 1<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates human body detection location. The array element number indicates a human body ID.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br>
		 * <br>
		 * Data type : unsigned char × 3
x max 128<br>
		 * <br>
		 * Data size : 3 × max
128
bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformHumanBodyDetectionLocation1() {
			reqInformProperty(EPC_HUMAN_BODY_DETECTION_LOCATION1);
			return this;
		}
		/**
		 * Property name : Maximum number of human body ID’s<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates maximum number of human body IDs that can be registered for human body detection location 1.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001.0x0080 (= 1.128)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMaximumNumberOfHumanBodyIdS() {
			reqInformProperty(EPC_MAXIMUM_NUMBER_OF_HUMAN_BODY_ID_S);
			return this;
		}
		/**
		 * Property name : Human body detection location 2<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates human body detection location.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 1st byte: X coordinate; 2nd byte: Y coordinate; 3rd byte: Z coordinate<br>
		 * <br>
		 * Data type : unsigned char × 3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformHumanBodyDetectionLocation2() {
			reqInformProperty(EPC_HUMAN_BODY_DETECTION_LOCATION2);
			return this;
		}
		/**
		 * Property name : Human body existence information<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Array element number information retained by human body detection location 1.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * (See (5) below for details.)<br>
		 * <br>
		 * Data type : unsigned char × 16<br>
		 * <br>
		 * Data size : 16
bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformHumanBodyExistenceInformation() {
			reqInformProperty(EPC_HUMAN_BODY_EXISTENCE_INFORMATION);
			return this;
		}
	}

	public static class Proxy extends HumanBodyLocationSensor {
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
		protected byte[] getHumanBodyDetectionLocation1() {return null;}
		@Override
		protected byte[] getHumanBodyDetectionLocation2() {return null;}
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
