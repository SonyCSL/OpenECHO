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

public abstract class ElectricEnergySensor extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0022;

	public static final byte EPC_INTEGRAL_ELECTRIC_ENERGY = (byte)0xE0;
	public static final byte EPC_MEDIUM_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY = (byte)0xE1;
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
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewElectricEnergySensor(this);
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
	 * Property name : Integral electric energy<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates integral electric energy in 0.001kWh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0.0x3B9AC9FF (0.999,999.999 kWh)<br>
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
	 * 0x0.0x3B9AC9FF (0.999,999.999 kWh)<br>
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
	 * Property name : Medium-capacity sensor instantaneous electric energy<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates measured instantaneous electric energy in W.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xC4653601.0x3B9AC9FF (-999,999.999.999,999.999)<br>
	 * <br>
	 * Data type : signed long<br>
	 * <br>
	 * Data size : 4 byte<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMediumCapacitySensorInstantaneousElectricEnergy() {return null;}
	/**
	 * Property name : Medium-capacity sensor instantaneous electric energy<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates measured instantaneous electric energy in W.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xC4653601.0x3B9AC9FF (-999,999.999.999,999.999)<br>
	 * <br>
	 * Data type : signed long<br>
	 * <br>
	 * Data size : 4 byte<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMediumCapacitySensorInstantaneousElectricEnergy(byte[] edt) {
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
	 * 0x8001.0x7FFE (-3276.7.3276.6)<br>
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
	 * 0x8001.0x7FFE (-3276.7.3276.6)<br>
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
	 * 0x8001.0x7FFE (-3276.7.3276.6)<br>
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
	 * 0x8001.0x7FFE (-3276.7.3276.6)<br>
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
	 * This property indicates measurement result log of integral electric energy (0.001kWh) for the past 24 hours in 30-minute sections.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x3B9AC9F (0.999,999.999)<br>
	 * (0.999,999.999 kWh)<br>
	 * <br>
	 * Data type : unsigned long × 48<br>
	 * <br>
	 * Data size : 192
bytes<br>
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
	 * This property indicates measurement result log of integral electric energy (0.001kWh) for the past 24 hours in 30-minute sections.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x3B9AC9F (0.999,999.999)<br>
	 * (0.999,999.999 kWh)<br>
	 * <br>
	 * Data type : unsigned long × 48<br>
	 * <br>
	 * Data size : 192
bytes<br>
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
		case EPC_MEDIUM_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY : return getMediumCapacitySensorInstantaneousElectricEnergy();
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
		case EPC_MEDIUM_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY : return isValidMediumCapacitySensorInstantaneousElectricEnergy(property.edt);
		case EPC_SMALL_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY : return isValidSmallCapacitySensorInstantaneousElectricEnergy(property.edt);
		case EPC_LARGE_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY : return isValidLargeCapacitySensorInstantaneousElectricEnergy(property.edt);
		case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG : return isValidIntegralElectricEnergyMeasurementLog(property.edt);
		case EPC_EFFECTIVE_VOLTAGE_VALUE : return isValidEffectiveVoltageValue(property.edt);
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
			case EPC_INTEGRAL_ELECTRIC_ENERGY : 
				onGetIntegralElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_MEDIUM_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY : 
				onGetMediumCapacitySensorInstantaneousElectricEnergy(eoj, tid, esv, property, success);
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
		 * 0x0.0x3B9AC9FF (0.999,999.999 kWh)<br>
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
		 * Property name : Medium-capacity sensor instantaneous electric energy<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates measured instantaneous electric energy in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xC4653601.0x3B9AC9FF (-999,999.999.999,999.999)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4 byte<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMediumCapacitySensorInstantaneousElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Small-capacity sensor instantaneous electric energy<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates instantaneous electric energy in units of 0.1 W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x8001.0x7FFE (-3276.7.3276.6)<br>
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
		 * 0x8001.0x7FFE (-3276.7.3276.6)<br>
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
		 * This property indicates measurement result log of integral electric energy (0.001kWh) for the past 24 hours in 30-minute sections.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x3B9AC9F (0.999,999.999)<br>
		 * (0.999,999.999 kWh)<br>
		 * <br>
		 * Data type : unsigned long × 48<br>
		 * <br>
		 * Data size : 192
bytes<br>
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
		 * Property name : Integral electric energy<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral electric energy in 0.001kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0.0x3B9AC9FF (0.999,999.999 kWh)<br>
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
			reqGetProperty(EPC_INTEGRAL_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Medium-capacity sensor instantaneous electric energy<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates measured instantaneous electric energy in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xC4653601.0x3B9AC9FF (-999,999.999.999,999.999)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4 byte<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMediumCapacitySensorInstantaneousElectricEnergy() {
			reqGetProperty(EPC_MEDIUM_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY);
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
		 * 0x8001.0x7FFE (-3276.7.3276.6)<br>
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
			reqGetProperty(EPC_SMALL_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY);
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
		 * 0x8001.0x7FFE (-3276.7.3276.6)<br>
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
			reqGetProperty(EPC_LARGE_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Integral electric energy measurement log<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates measurement result log of integral electric energy (0.001kWh) for the past 24 hours in 30-minute sections.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x3B9AC9F (0.999,999.999)<br>
		 * (0.999,999.999 kWh)<br>
		 * <br>
		 * Data type : unsigned long × 48<br>
		 * <br>
		 * Data size : 192
bytes<br>
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
			reqGetProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG);
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
			reqGetProperty(EPC_EFFECTIVE_VOLTAGE_VALUE);
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
		 * Property name : Integral electric energy<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral electric energy in 0.001kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0.0x3B9AC9FF (0.999,999.999 kWh)<br>
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
			reqInformProperty(EPC_INTEGRAL_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Medium-capacity sensor instantaneous electric energy<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates measured instantaneous electric energy in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xC4653601.0x3B9AC9FF (-999,999.999.999,999.999)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4 byte<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMediumCapacitySensorInstantaneousElectricEnergy() {
			reqInformProperty(EPC_MEDIUM_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY);
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
		 * 0x8001.0x7FFE (-3276.7.3276.6)<br>
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
			reqInformProperty(EPC_SMALL_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY);
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
		 * 0x8001.0x7FFE (-3276.7.3276.6)<br>
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
			reqInformProperty(EPC_LARGE_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Integral electric energy measurement log<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates measurement result log of integral electric energy (0.001kWh) for the past 24 hours in 30-minute sections.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x3B9AC9F (0.999,999.999)<br>
		 * (0.999,999.999 kWh)<br>
		 * <br>
		 * Data type : unsigned long × 48<br>
		 * <br>
		 * Data size : 192
bytes<br>
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
			reqInformProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG);
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
			reqInformProperty(EPC_EFFECTIVE_VOLTAGE_VALUE);
			return this;
		}
	}

	public static class Proxy extends ElectricEnergySensor {
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
		protected byte[] getIntegralElectricEnergy() {return null;}
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
