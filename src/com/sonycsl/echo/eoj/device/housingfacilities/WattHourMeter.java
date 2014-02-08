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

public abstract class WattHourMeter extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0280;

	public static final byte EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_VALUE = (byte)0xE0;
	public static final byte EPC_INTEGRAL_ELECTRIC_ENERGY_UNIT = (byte)0xE2;
	public static final byte EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG1 = (byte)0xE3;
	public static final byte EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG2 = (byte)0xE4;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_VALUE);
		addGetProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_UNIT);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewWattHourMeter(this);
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
	 * Property name : Integral electric energy measurement value<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates integral electric energy in decimal (8 digits).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.1 or
0.01
kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getIntegralElectricEnergyMeasurementValue();
	/**
	 * Property name : Integral electric energy measurement value<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates integral electric energy in decimal (8 digits).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.1 or
0.01
kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidIntegralElectricEnergyMeasurementValue(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Integral electric energy unit<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates number of decimal places of integral electric energy (0xE0).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 :   0.1kWh<br>
	 * 0x02 :   0.01kWh<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getIntegralElectricEnergyUnit();
	/**
	 * Property name : Integral electric energy unit<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates number of decimal places of integral electric energy (0xE0).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 :   0.1kWh<br>
	 * 0x02 :   0.01kWh<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidIntegralElectricEnergyUnit(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Integral electric energy measurement log 1<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates integral electric energy (8 digits) measurement result log in 30-minute segments for past 24 hours.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned long × 48<br>
	 * <br>
	 * Data size : 192
bytes<br>
	 * <br>
	 * Unit : 0.1 or
0.01
kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getIntegralElectricEnergyMeasurementLog1() {return null;}
	/**
	 * Property name : Integral electric energy measurement log 1<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates integral electric energy (8 digits) measurement result log in 30-minute segments for past 24 hours.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned long × 48<br>
	 * <br>
	 * Data size : 192
bytes<br>
	 * <br>
	 * Unit : 0.1 or
0.01
kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidIntegralElectricEnergyMeasurementLog1(byte[] edt) {
		if(edt == null || !(edt.length == 192)) return false;
		return true;
	}
	/**
	 * Property name : Integral electric energy measurement log 2<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates integral electric energy (8 digits) measurement result log for past 24 hours as one-day data in 30-minute segments.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned long
×48
×45<br>
	 * <br>
	 * Data size : 192
bytes
× 45<br>
	 * <br>
	 * Unit : 0.1 or
0.01
kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getIntegralElectricEnergyMeasurementLog2() {return null;}
	/**
	 * Property name : Integral electric energy measurement log 2<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates integral electric energy (8 digits) measurement result log for past 24 hours as one-day data in 30-minute segments.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned long
×48
×45<br>
	 * <br>
	 * Data size : 192
bytes
× 45<br>
	 * <br>
	 * Unit : 0.1 or
0.01
kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidIntegralElectricEnergyMeasurementLog2(byte[] edt) {
		if(edt == null || !(edt.length == 192)) return false;
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
		case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_VALUE : return getIntegralElectricEnergyMeasurementValue();
		case EPC_INTEGRAL_ELECTRIC_ENERGY_UNIT : return getIntegralElectricEnergyUnit();
		case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG1 : return getIntegralElectricEnergyMeasurementLog1();
		case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG2 : return getIntegralElectricEnergyMeasurementLog2();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_VALUE : return isValidIntegralElectricEnergyMeasurementValue(property.edt);
		case EPC_INTEGRAL_ELECTRIC_ENERGY_UNIT : return isValidIntegralElectricEnergyUnit(property.edt);
		case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG1 : return isValidIntegralElectricEnergyMeasurementLog1(property.edt);
		case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG2 : return isValidIntegralElectricEnergyMeasurementLog2(property.edt);
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
			case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_VALUE : 
				onGetIntegralElectricEnergyMeasurementValue(eoj, tid, esv, property, success);
				return true;
			case EPC_INTEGRAL_ELECTRIC_ENERGY_UNIT : 
				onGetIntegralElectricEnergyUnit(eoj, tid, esv, property, success);
				return true;
			case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG1 : 
				onGetIntegralElectricEnergyMeasurementLog1(eoj, tid, esv, property, success);
				return true;
			case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG2 : 
				onGetIntegralElectricEnergyMeasurementLog2(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Integral electric energy measurement value<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral electric energy in decimal (8 digits).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.1 or
0.01
kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetIntegralElectricEnergyMeasurementValue(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Integral electric energy unit<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates number of decimal places of integral electric energy (0xE0).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 :   0.1kWh<br>
		 * 0x02 :   0.01kWh<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetIntegralElectricEnergyUnit(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Integral electric energy measurement log 1<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral electric energy (8 digits) measurement result log in 30-minute segments for past 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned long × 48<br>
		 * <br>
		 * Data size : 192
bytes<br>
		 * <br>
		 * Unit : 0.1 or
0.01
kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetIntegralElectricEnergyMeasurementLog1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Integral electric energy measurement log 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral electric energy (8 digits) measurement result log for past 24 hours as one-day data in 30-minute segments.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned long
×48
×45<br>
		 * <br>
		 * Data size : 192
bytes
× 45<br>
		 * <br>
		 * Unit : 0.1 or
0.01
kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetIntegralElectricEnergyMeasurementLog2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Integral electric energy measurement value<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral electric energy in decimal (8 digits).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.1 or
0.01
kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetIntegralElectricEnergyMeasurementValue() {
			reqGetProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_VALUE);
			return this;
		}
		/**
		 * Property name : Integral electric energy unit<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates number of decimal places of integral electric energy (0xE0).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 :   0.1kWh<br>
		 * 0x02 :   0.01kWh<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetIntegralElectricEnergyUnit() {
			reqGetProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_UNIT);
			return this;
		}
		/**
		 * Property name : Integral electric energy measurement log 1<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral electric energy (8 digits) measurement result log in 30-minute segments for past 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned long × 48<br>
		 * <br>
		 * Data size : 192
bytes<br>
		 * <br>
		 * Unit : 0.1 or
0.01
kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetIntegralElectricEnergyMeasurementLog1() {
			reqGetProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG1);
			return this;
		}
		/**
		 * Property name : Integral electric energy measurement log 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral electric energy (8 digits) measurement result log for past 24 hours as one-day data in 30-minute segments.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned long
×48
×45<br>
		 * <br>
		 * Data size : 192
bytes
× 45<br>
		 * <br>
		 * Unit : 0.1 or
0.01
kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetIntegralElectricEnergyMeasurementLog2() {
			reqGetProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG2);
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
		 * Property name : Integral electric energy measurement value<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral electric energy in decimal (8 digits).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.1 or
0.01
kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformIntegralElectricEnergyMeasurementValue() {
			reqInformProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_VALUE);
			return this;
		}
		/**
		 * Property name : Integral electric energy unit<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates number of decimal places of integral electric energy (0xE0).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 :   0.1kWh<br>
		 * 0x02 :   0.01kWh<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformIntegralElectricEnergyUnit() {
			reqInformProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_UNIT);
			return this;
		}
		/**
		 * Property name : Integral electric energy measurement log 1<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral electric energy (8 digits) measurement result log in 30-minute segments for past 24 hours.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned long × 48<br>
		 * <br>
		 * Data size : 192
bytes<br>
		 * <br>
		 * Unit : 0.1 or
0.01
kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformIntegralElectricEnergyMeasurementLog1() {
			reqInformProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG1);
			return this;
		}
		/**
		 * Property name : Integral electric energy measurement log 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral electric energy (8 digits) measurement result log for past 24 hours as one-day data in 30-minute segments.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned long
×48
×45<br>
		 * <br>
		 * Data size : 192
bytes
× 45<br>
		 * <br>
		 * Unit : 0.1 or
0.01
kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformIntegralElectricEnergyMeasurementLog2() {
			reqInformProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG2);
			return this;
		}
	}

	public static class Proxy extends WattHourMeter {
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
		protected byte[] getIntegralElectricEnergyMeasurementValue() {return null;}
		@Override
		protected byte[] getIntegralElectricEnergyUnit() {return null;}
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
