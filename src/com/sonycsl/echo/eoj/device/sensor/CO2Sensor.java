/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2014 Sony Computer Science Laboratories, Inc.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sonycsl.echo.eoj.device.sensor;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;

public abstract class CO2Sensor extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x001B;

	public static final byte EPC_MEASURED_VALUE_OF_CO2_CONCENTRATION = (byte)0xE0;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addGetProperty(EPC_MEASURED_VALUE_OF_CO2_CONCENTRATION);
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);

	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewCO2Sensor(this);
	}
	
	@Override
	public short getEchoClassCode() {
		return ECHO_CLASS_CODE;
	}

	/**
	 * Property name : Measured value of CO2 concentration<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates measured value of CO2 concentration in ppm. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : ppm<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getMeasuredValueOfCo2Concentration();
	/**
	 * Property name : Measured value of CO2 concentration<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates measured value of CO2 concentration in ppm. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : ppm<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMeasuredValueOfCo2Concentration(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the ON/OFF status. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setOperationStatus(byte[] edt) {return false;}
	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the ON/OFF status. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getOperationStatus();
	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the ON/OFF status. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidOperationStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
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
		case EPC_MEASURED_VALUE_OF_CO2_CONCENTRATION : return getMeasuredValueOfCo2Concentration();

		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_MEASURED_VALUE_OF_CO2_CONCENTRATION : return isValidMeasuredValueOfCo2Concentration(property.edt);

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
			case EPC_MEASURED_VALUE_OF_CO2_CONCENTRATION : 
				onGetMeasuredValueOfCo2Concentration(eoj, tid, esv, property, success);
				return true;

			default :
				return false;
			}
		}
		
		/**
		 * Property name : Measured value of CO2 concentration<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates measured value of CO2 concentration in ppm. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : ppm<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMeasuredValueOfCo2Concentration(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation status<br>
		 * <br>
		 * EPC : 0x80<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the ON/OFF status. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON=0x30, OFF=0x31<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetOperationStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation status<br>
		 * <br>
		 * EPC : 0x80<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the ON/OFF status. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON=0x30, OFF=0x31<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetOperationStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}

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
		 * Property name : Measured value of CO2 concentration<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates measured value of CO2 concentration in ppm. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : ppm<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetMeasuredValueOfCo2Concentration() {
			reqGetProperty(EPC_MEASURED_VALUE_OF_CO2_CONCENTRATION);
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
		 * Property name : Measured value of CO2 concentration<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates measured value of CO2 concentration in ppm. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : ppm<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformMeasuredValueOfCo2Concentration() {
			reqInformProperty(EPC_MEASURED_VALUE_OF_CO2_CONCENTRATION);
			return this;
		}

	}

	public static class Proxy extends CO2Sensor {
		public Proxy(byte instanceCode) {
			super();
			mEchoInstanceCode = instanceCode;
		}
		@Override
		public byte getInstanceCode() {
			return mEchoInstanceCode;
		}
		@Override
		protected byte[] getGetPropertyMap(){return null;}
		@Override
		protected byte[] getSetPropertyMap(){return null;}
		@Override
		protected byte[] getMeasuredValueOfCo2Concentration(){return null;}
		@Override
		protected byte[] getStatusChangeAnnouncementPropertyMap(){return null;}
		@Override
		protected byte[] getOperationStatus(){return null;}
		@Override
		protected boolean setInstallationLocation(byte[] edt){return false;}
		@Override
		protected byte[] getInstallationLocation(){return null;}
		@Override
		protected byte[] getStandardVersionInformation(){return null;}
		@Override
		protected byte[] getFaultStatus(){return null;}
		@Override
		protected byte[] getManufacturerCode(){return null;}

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
