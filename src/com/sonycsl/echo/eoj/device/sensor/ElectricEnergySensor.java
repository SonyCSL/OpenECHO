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

import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;

public abstract class ElectricEnergySensor extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = ElectricEnergySensor.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x00;
	public static final byte CLASS_CODE = (byte)0x22;

	protected static final byte EPC_INTEGRAL_ELECTRIC_ENERGY = (byte)0xE0;
	protected static final byte EPC_SMALL_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY = (byte)0xE2;
	protected static final byte EPC_LARGE_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY = (byte)0xE3;
	protected static final byte EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG = (byte)0xE4;
	protected static final byte EPC_EFFECTIVE_VOLTAGE_VALUE = (byte)0xE5;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates integral electric energy in 0.001kWh.<br>0x0.0x3B9AC9FF (0.999999.999 kWh)<br><br>Data type : unsigned long<br>Data size : 4 bytes<br>Set : undefined<br>Get : mandatory
	 */
	protected abstract byte[] getIntegralElectricEnergy();
	/**
	 * This property indicates instantaneous electric energy in units of 0.1 W.<br>0x8001.0x7FFE (-3276,7.3276,6)<br><br>Data type : signed short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getSmallCapacitySensorInstantaneousElectricEnergy() {return null;}
	/**
	 * This property indicates instantaneous electric energy in units of 0.1 kW.<br>0x8001.0x7FFE (-3276,7.3276,6)<br><br>Data type : signed short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getLargeCapacitySensorInstantaneousElectricEnergy() {return null;}
	/**
	 * This property indicates measurement result log of integral electric energy (0.001kWh) for the past 24 hours in 30-minute sections.<br>0.0x3B9AC9F (0.999,999,999) (0.999999.999 kWh)<br><br>Data type : unsigned long x 48<br>Data size : 192 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getIntegralElectricEnergyMeasurementLog() {return null;}
	/**
	 * This property indicates effective voltage value in V.<br>0x0000.0xFFFD (0.65533V)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getEffectiveVoltageValue() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_INTEGRAL_ELECTRIC_ENERGY:
			edt = getIntegralElectricEnergy();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_SMALL_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY:
			edt = getSmallCapacitySensorInstantaneousElectricEnergy();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_LARGE_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY:
			edt = getLargeCapacitySensorInstantaneousElectricEnergy();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG:
			edt = getIntegralElectricEnergyMeasurementLog();
			res.addProperty(epc, edt, (edt != null && (edt.length == 192)));
			break;
		case EPC_EFFECTIVE_VOLTAGE_VALUE:
			edt = getEffectiveVoltageValue();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;

		}
	}
	
	@Override
	public Setter set() {
		return new SetterImpl(ESV_SET_NO_RES);
	}

	@Override
	public Setter setC() {
		return new SetterImpl(ESV_SET_RES);
	}

	@Override
	public Getter get() {
		return new GetterImpl();
	}

	@Override
	public Informer inform() {
		return new InformerImpl();
	}
	
	public static class Receiver extends DeviceObject.Receiver {

		@Override
		protected void onReceiveSetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveSetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_INTEGRAL_ELECTRIC_ENERGY:
				onGetIntegralElectricEnergy(eoj, tid, pdc, edt);
				break;
			case EPC_SMALL_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY:
				onGetSmallCapacitySensorInstantaneousElectricEnergy(eoj, tid, pdc, edt);
				break;
			case EPC_LARGE_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY:
				onGetLargeCapacitySensorInstantaneousElectricEnergy(eoj, tid, pdc, edt);
				break;
			case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG:
				onGetIntegralElectricEnergyMeasurementLog(eoj, tid, pdc, edt);
				break;
			case EPC_EFFECTIVE_VOLTAGE_VALUE:
				onGetEffectiveVoltageValue(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates integral electric energy in 0.001kWh.<br>0x0.0x3B9AC9FF (0.999999.999 kWh)<br><br>Data type : unsigned long<br>Data size : 4 bytes<br>Set : undefined<br>Get : mandatory
		 */
		protected void onGetIntegralElectricEnergy(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates instantaneous electric energy in units of 0.1 W.<br>0x8001.0x7FFE (-3276,7.3276,6)<br><br>Data type : signed short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetSmallCapacitySensorInstantaneousElectricEnergy(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates instantaneous electric energy in units of 0.1 kW.<br>0x8001.0x7FFE (-3276,7.3276,6)<br><br>Data type : signed short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetLargeCapacitySensorInstantaneousElectricEnergy(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates measurement result log of integral electric energy (0.001kWh) for the past 24 hours in 30-minute sections.<br>0.0x3B9AC9F (0.999,999,999) (0.999999.999 kWh)<br><br>Data type : unsigned long x 48<br>Data size : 192 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetIntegralElectricEnergyMeasurementLog(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates effective voltage value in V.<br>0x0000.0xFFFD (0.65533V)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetEffectiveVoltageValue(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

	}
	
	public interface Setter extends DeviceObject.Setter {
		public Setter reqSetOperationStatus(byte[] edt);
		public Setter reqSetInstallationLocation(byte[] edt);
		public Setter reqSetCurrentLimitSetting(byte[] edt);
		public Setter reqSetPowerSavingOperationSetting(byte[] edt);
		public Setter reqSetPositionInformation(byte[] edt);
		public Setter reqSetCurrentTimeSetting(byte[] edt);
		public Setter reqSetCurrentDateSetting(byte[] edt);
		public Setter reqSetPowerLimitSetting(byte[] edt);
		
	}

	public class SetterImpl extends DeviceObject.SetterImpl implements Setter {

		public SetterImpl(byte esv) {
			super(esv);
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
	
	public class SetterProxy extends DeviceObject.SetterProxy implements Setter {

		public SetterProxy(byte esv) {
			super(esv);
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

	public interface Getter extends DeviceObject.Getter {
		public Getter reqGetOperationStatus();
		public Getter reqGetInstallationLocation();
		public Getter reqGetStandardVersionInformation();
		public Getter reqGetIdentificationNumber();
		public Getter reqGetMeasuredInstantaneousPowerConsumption();
		public Getter reqGetMeasuredCumulativePowerConsumption();
		public Getter reqGetManufacturersFaultCode();
		public Getter reqGetCurrentLimitSetting();
		public Getter reqGetFaultStatus();
		public Getter reqGetFaultDescription();
		public Getter reqGetManufacturerCode();
		public Getter reqGetBusinessFacilityCode();
		public Getter reqGetProductCode();
		public Getter reqGetProductionNumber();
		public Getter reqGetProductionDate();
		public Getter reqGetPowerSavingOperationSetting();
		public Getter reqGetPositionInformation();
		public Getter reqGetCurrentTimeSetting();
		public Getter reqGetCurrentDateSetting();
		public Getter reqGetPowerLimitSetting();
		public Getter reqGetCumulativeOperatingTime();
		public Getter reqGetStatusChangeAnnouncementPropertyMap();
		public Getter reqGetSetPropertyMap();
		public Getter reqGetGetPropertyMap();
		
		/**
		 * This property indicates integral electric energy in 0.001kWh.<br>0x0.0x3B9AC9FF (0.999999.999 kWh)<br><br>Data type : unsigned long<br>Data size : 4 bytes<br>Set : undefined<br>Get : mandatory
		 */
		public Getter reqGetIntegralElectricEnergy();
		/**
		 * This property indicates instantaneous electric energy in units of 0.1 W.<br>0x8001.0x7FFE (-3276,7.3276,6)<br><br>Data type : signed short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetSmallCapacitySensorInstantaneousElectricEnergy();
		/**
		 * This property indicates instantaneous electric energy in units of 0.1 kW.<br>0x8001.0x7FFE (-3276,7.3276,6)<br><br>Data type : signed short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetLargeCapacitySensorInstantaneousElectricEnergy();
		/**
		 * This property indicates measurement result log of integral electric energy (0.001kWh) for the past 24 hours in 30-minute sections.<br>0.0x3B9AC9F (0.999,999,999) (0.999999.999 kWh)<br><br>Data type : unsigned long x 48<br>Data size : 192 bytes<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetIntegralElectricEnergyMeasurementLog();
		/**
		 * This property indicates effective voltage value in V.<br>0x0000.0xFFFD (0.65533V)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetEffectiveVoltageValue();
	}
	
	public class GetterImpl extends DeviceObject.GetterImpl implements Getter {

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

		@Override
		public Getter reqGetIntegralElectricEnergy() {
			byte[] edt = getIntegralElectricEnergy();
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetSmallCapacitySensorInstantaneousElectricEnergy() {
			byte[] edt = getSmallCapacitySensorInstantaneousElectricEnergy();
			addProperty(EPC_SMALL_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetLargeCapacitySensorInstantaneousElectricEnergy() {
			byte[] edt = getLargeCapacitySensorInstantaneousElectricEnergy();
			addProperty(EPC_LARGE_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetIntegralElectricEnergyMeasurementLog() {
			byte[] edt = getIntegralElectricEnergyMeasurementLog();
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG, edt, (edt != null && (edt.length == 192)));
			return this;
		}
		@Override
		public Getter reqGetEffectiveVoltageValue() {
			byte[] edt = getEffectiveVoltageValue();
			addProperty(EPC_EFFECTIVE_VOLTAGE_VALUE, edt, (edt != null && (edt.length == 2)));
			return this;
		}
	}

	public class GetterProxy extends DeviceObject.GetterProxy implements Getter {

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

		@Override
		public Getter reqGetIntegralElectricEnergy() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY);
			return this;
		}
		@Override
		public Getter reqGetSmallCapacitySensorInstantaneousElectricEnergy() {
			addProperty(EPC_SMALL_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY);
			return this;
		}
		@Override
		public Getter reqGetLargeCapacitySensorInstantaneousElectricEnergy() {
			addProperty(EPC_LARGE_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY);
			return this;
		}
		@Override
		public Getter reqGetIntegralElectricEnergyMeasurementLog() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG);
			return this;
		}
		@Override
		public Getter reqGetEffectiveVoltageValue() {
			addProperty(EPC_EFFECTIVE_VOLTAGE_VALUE);
			return this;
		}
	}
	
	public interface Informer extends DeviceObject.Informer {
		public Informer reqInformOperationStatus();
		public Informer reqInformInstallationLocation();
		public Informer reqInformStandardVersionInformation();
		public Informer reqInformIdentificationNumber();
		public Informer reqInformMeasuredInstantaneousPowerConsumption();
		public Informer reqInformMeasuredCumulativePowerConsumption();
		public Informer reqInformManufacturersFaultCode();
		public Informer reqInformCurrentLimitSetting();
		public Informer reqInformFaultStatus();
		public Informer reqInformFaultDescription();
		public Informer reqInformManufacturerCode();
		public Informer reqInformBusinessFacilityCode();
		public Informer reqInformProductCode();
		public Informer reqInformProductionNumber();
		public Informer reqInformProductionDate();
		public Informer reqInformPowerSavingOperationSetting();
		public Informer reqInformPositionInformation();
		public Informer reqInformCurrentTimeSetting();
		public Informer reqInformCurrentDateSetting();
		public Informer reqInformPowerLimitSetting();
		public Informer reqInformCumulativeOperatingTime();
		public Informer reqInformStatusChangeAnnouncementPropertyMap();
		public Informer reqInformSetPropertyMap();
		public Informer reqInformGetPropertyMap();
		
		/**
		 * This property indicates integral electric energy in 0.001kWh.<br>0x0.0x3B9AC9FF (0.999999.999 kWh)<br><br>Data type : unsigned long<br>Data size : 4 bytes<br>Set : undefined<br>Get : mandatory
		 */
		public Informer reqInformIntegralElectricEnergy();
		/**
		 * This property indicates instantaneous electric energy in units of 0.1 W.<br>0x8001.0x7FFE (-3276,7.3276,6)<br><br>Data type : signed short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformSmallCapacitySensorInstantaneousElectricEnergy();
		/**
		 * This property indicates instantaneous electric energy in units of 0.1 kW.<br>0x8001.0x7FFE (-3276,7.3276,6)<br><br>Data type : signed short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformLargeCapacitySensorInstantaneousElectricEnergy();
		/**
		 * This property indicates measurement result log of integral electric energy (0.001kWh) for the past 24 hours in 30-minute sections.<br>0.0x3B9AC9F (0.999,999,999) (0.999999.999 kWh)<br><br>Data type : unsigned long x 48<br>Data size : 192 bytes<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformIntegralElectricEnergyMeasurementLog();
		/**
		 * This property indicates effective voltage value in V.<br>0x0000.0xFFFD (0.65533V)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformEffectiveVoltageValue();
	}

	public class InformerImpl extends DeviceObject.InformerImpl implements Informer {

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

		@Override
		public Informer reqInformIntegralElectricEnergy() {
			byte[] edt = getIntegralElectricEnergy();
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformSmallCapacitySensorInstantaneousElectricEnergy() {
			byte[] edt = getSmallCapacitySensorInstantaneousElectricEnergy();
			addProperty(EPC_SMALL_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformLargeCapacitySensorInstantaneousElectricEnergy() {
			byte[] edt = getLargeCapacitySensorInstantaneousElectricEnergy();
			addProperty(EPC_LARGE_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformIntegralElectricEnergyMeasurementLog() {
			byte[] edt = getIntegralElectricEnergyMeasurementLog();
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG, edt, (edt != null && (edt.length == 192)));
			return this;
		}
		@Override
		public Informer reqInformEffectiveVoltageValue() {
			byte[] edt = getEffectiveVoltageValue();
			addProperty(EPC_EFFECTIVE_VOLTAGE_VALUE, edt, (edt != null && (edt.length == 2)));
			return this;
		}
	}
	
	public class InformerProxy extends DeviceObject.InformerProxy implements Informer {

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

		@Override
		public Informer reqInformIntegralElectricEnergy() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY);
			return this;
		}
		@Override
		public Informer reqInformSmallCapacitySensorInstantaneousElectricEnergy() {
			addProperty(EPC_SMALL_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY);
			return this;
		}
		@Override
		public Informer reqInformLargeCapacitySensorInstantaneousElectricEnergy() {
			addProperty(EPC_LARGE_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY);
			return this;
		}
		@Override
		public Informer reqInformIntegralElectricEnergyMeasurementLog() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG);
			return this;
		}
		@Override
		public Informer reqInformEffectiveVoltageValue() {
			addProperty(EPC_EFFECTIVE_VOLTAGE_VALUE);
			return this;
		}
	}
}
