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
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class ElectricEnergySensor extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0022;

	public static final byte EPC_INTEGRAL_ELECTRIC_ENERGY = (byte)0xE0;
	public static final byte EPC_SMALL_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY = (byte)0xE2;
	public static final byte EPC_LARGE_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY = (byte)0xE3;
	public static final byte EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG = (byte)0xE4;
	public static final byte EPC_EFFECTIVE_VOLTAGE_VALUE = (byte)0xE5;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_INTEGRAL_ELECTRIC_ENERGY);
	}
	
	@Override
	public void initialize(EchoNode node) {
		super.initialize(node);
		Echo.EventListener listener = Echo.getEventListener();
		if(listener != null) listener.onNewElectricEnergySensor(this);
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
	 * This  property  indicates  the  ON/OFF<br>
	 * status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : �\<br>
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
	 * This  property  indicates  the  ON/OFF<br>
	 * status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : �\<br>
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
	 * Property name : Integral electric energy<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates integral electric energy in 0.001kWh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0.0x3B9AC9FF (0.999999.999 kWh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.001k
Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getIntegralElectricEnergy();
	/**
	 * Property name : Integral electric energy<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates integral electric energy in 0.001kWh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0.0x3B9AC9FF (0.999999.999 kWh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.001k
Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidIntegralElectricEnergy(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Small-capacity sensor instantaneous electric energy<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates instantaneous electric energy in units of 0.1 W.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x8001.0x7FFE<br>
	 * (-3276,7.3276,6)<br>
	 * <br>
	 * Data type : signed short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1 W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getSmallCapacitySensorInstantaneousElectricEnergy() {return null;}
	/**
	 * Property name : Small-capacity sensor instantaneous electric energy<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates instantaneous electric energy in units of 0.1 W.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x8001.0x7FFE<br>
	 * (-3276,7.3276,6)<br>
	 * <br>
	 * Data type : signed short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1 W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSmallCapacitySensorInstantaneousElectricEnergy(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Large-capacity sensor instantaneous electric energy<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates instantaneous electric energy in units of 0.1 kW.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x8001.0x7FFE<br>
	 * (-3276,7.3276,6)<br>
	 * <br>
	 * Data type : signed short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1 kW<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getLargeCapacitySensorInstantaneousElectricEnergy() {return null;}
	/**
	 * Property name : Large-capacity sensor instantaneous electric energy<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates instantaneous electric energy in units of 0.1 kW.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x8001.0x7FFE<br>
	 * (-3276,7.3276,6)<br>
	 * <br>
	 * Data type : signed short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1 kW<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidLargeCapacitySensorInstantaneousElectricEnergy(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Integral electric energy measurement log<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates measurement result log of integral electric energy (0.001kWh) for the past 24 hours in<br>
	 * 30-minute sections.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x3B9AC9F (0.999,999,999) (0.999999.999 kWh)<br>
	 * <br>
	 * Data type : unsigned long x 48<br>
	 * <br>
	 * Data size : 192 bytes<br>
	 * <br>
	 * Unit : 0.001k
Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getIntegralElectricEnergyMeasurementLog() {return null;}
	/**
	 * Property name : Integral electric energy measurement log<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates measurement result log of integral electric energy (0.001kWh) for the past 24 hours in<br>
	 * 30-minute sections.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x3B9AC9F (0.999,999,999) (0.999999.999 kWh)<br>
	 * <br>
	 * Data type : unsigned long x 48<br>
	 * <br>
	 * Data size : 192 bytes<br>
	 * <br>
	 * Unit : 0.001k
Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidIntegralElectricEnergyMeasurementLog(byte[] edt) {
		if(edt == null || !(edt.length == 192)) return false;
		return true;
	}
	/**
	 * Property name : Effective voltage value<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates effective voltage value in V.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533V)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : V<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getEffectiveVoltageValue() {return null;}
	/**
	 * Property name : Effective voltage value<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates effective voltage value in V.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533V)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : V<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidEffectiveVoltageValue(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
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
		case EPC_INTEGRAL_ELECTRIC_ENERGY : return getIntegralElectricEnergy();
		case EPC_SMALL_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY : return getSmallCapacitySensorInstantaneousElectricEnergy();
		case EPC_LARGE_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY : return getLargeCapacitySensorInstantaneousElectricEnergy();
		case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG : return getIntegralElectricEnergyMeasurementLog();
		case EPC_EFFECTIVE_VOLTAGE_VALUE : return getEffectiveVoltageValue();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_INTEGRAL_ELECTRIC_ENERGY : return isValidIntegralElectricEnergy(property.edt);
		case EPC_SMALL_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY : return isValidSmallCapacitySensorInstantaneousElectricEnergy(property.edt);
		case EPC_LARGE_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY : return isValidLargeCapacitySensorInstantaneousElectricEnergy(property.edt);
		case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG : return isValidIntegralElectricEnergyMeasurementLog(property.edt);
		case EPC_EFFECTIVE_VOLTAGE_VALUE : return isValidEffectiveVoltageValue(property.edt);
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
			case EPC_INTEGRAL_ELECTRIC_ENERGY : 
				onGetIntegralElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_SMALL_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY : 
				onGetSmallCapacitySensorInstantaneousElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_LARGE_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY : 
				onGetLargeCapacitySensorInstantaneousElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG : 
				onGetIntegralElectricEnergyMeasurementLog(eoj, tid, esv, property, success);
				return true;
			case EPC_EFFECTIVE_VOLTAGE_VALUE : 
				onGetEffectiveVoltageValue(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Integral electric energy<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral electric energy in 0.001kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0.0x3B9AC9FF (0.999999.999 kWh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001k
Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetIntegralElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Small-capacity sensor instantaneous electric energy<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates instantaneous electric energy in units of 0.1 W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x8001.0x7FFE<br>
		 * (-3276,7.3276,6)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1 W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetSmallCapacitySensorInstantaneousElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Large-capacity sensor instantaneous electric energy<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates instantaneous electric energy in units of 0.1 kW.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x8001.0x7FFE<br>
		 * (-3276,7.3276,6)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1 kW<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetLargeCapacitySensorInstantaneousElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Integral electric energy measurement log<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates measurement result log of integral electric energy (0.001kWh) for the past 24 hours in<br>
		 * 30-minute sections.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x3B9AC9F (0.999,999,999) (0.999999.999 kWh)<br>
		 * <br>
		 * Data type : unsigned long x 48<br>
		 * <br>
		 * Data size : 192 bytes<br>
		 * <br>
		 * Unit : 0.001k
Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetIntegralElectricEnergyMeasurementLog(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Effective voltage value<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates effective voltage value in V.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533V)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetEffectiveVoltageValue(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Integral electric energy<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral electric energy in 0.001kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0.0x3B9AC9FF (0.999999.999 kWh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001k
Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetIntegralElectricEnergy() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Small-capacity sensor instantaneous electric energy<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates instantaneous electric energy in units of 0.1 W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x8001.0x7FFE<br>
		 * (-3276,7.3276,6)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1 W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSmallCapacitySensorInstantaneousElectricEnergy() {
			addProperty(EPC_SMALL_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Large-capacity sensor instantaneous electric energy<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates instantaneous electric energy in units of 0.1 kW.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x8001.0x7FFE<br>
		 * (-3276,7.3276,6)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1 kW<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetLargeCapacitySensorInstantaneousElectricEnergy() {
			addProperty(EPC_LARGE_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Integral electric energy measurement log<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates measurement result log of integral electric energy (0.001kWh) for the past 24 hours in<br>
		 * 30-minute sections.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x3B9AC9F (0.999,999,999) (0.999999.999 kWh)<br>
		 * <br>
		 * Data type : unsigned long x 48<br>
		 * <br>
		 * Data size : 192 bytes<br>
		 * <br>
		 * Unit : 0.001k
Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetIntegralElectricEnergyMeasurementLog() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG);
			return this;
		}
		/**
		 * Property name : Effective voltage value<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates effective voltage value in V.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533V)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetEffectiveVoltageValue() {
			addProperty(EPC_EFFECTIVE_VOLTAGE_VALUE);
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
		 * Property name : Integral electric energy<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral electric energy in 0.001kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0.0x3B9AC9FF (0.999999.999 kWh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001k
Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformIntegralElectricEnergy() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Small-capacity sensor instantaneous electric energy<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates instantaneous electric energy in units of 0.1 W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x8001.0x7FFE<br>
		 * (-3276,7.3276,6)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1 W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSmallCapacitySensorInstantaneousElectricEnergy() {
			addProperty(EPC_SMALL_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Large-capacity sensor instantaneous electric energy<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates instantaneous electric energy in units of 0.1 kW.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x8001.0x7FFE<br>
		 * (-3276,7.3276,6)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1 kW<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformLargeCapacitySensorInstantaneousElectricEnergy() {
			addProperty(EPC_LARGE_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Integral electric energy measurement log<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates measurement result log of integral electric energy (0.001kWh) for the past 24 hours in<br>
		 * 30-minute sections.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x3B9AC9F (0.999,999,999) (0.999999.999 kWh)<br>
		 * <br>
		 * Data type : unsigned long x 48<br>
		 * <br>
		 * Data size : 192 bytes<br>
		 * <br>
		 * Unit : 0.001k
Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformIntegralElectricEnergyMeasurementLog() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG);
			return this;
		}
		/**
		 * Property name : Effective voltage value<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates effective voltage value in V.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533V)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformEffectiveVoltageValue() {
			addProperty(EPC_EFFECTIVE_VOLTAGE_VALUE);
			return this;
		}
	}

	public static class Proxy extends ElectricEnergySensor {
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
		protected byte[] getIntegralElectricEnergy() {return null;}
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
