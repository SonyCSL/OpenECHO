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
	
	public static final byte CLASS_GROUP_CODE = (byte)0x00;
	public static final byte CLASS_CODE = (byte)0x22;
	
	public ElectricEnergySensor() {
		setReceiver(new Receiver());
	}

	public static final byte EPC_INTEGRAL_ELECTRIC_ENERGY = (byte)0xE0;
	public static final byte EPC_SMALL_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY = (byte)0xE2;
	public static final byte EPC_LARGE_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY = (byte)0xE3;
	public static final byte EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG = (byte)0xE4;
	public static final byte EPC_EFFECTIVE_VOLTAGE_VALUE = (byte)0xE5;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates integral electric energy in 0.001kWh.<br><br>0x0.0x3B9AC9FF (0.999999.999 kWh)<br><br>Name : Integral electric energy<br>EPC : 0xE0<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getIntegralElectricEnergy();
	private final byte[] _getIntegralElectricEnergy(byte epc) {
		byte[] edt = getIntegralElectricEnergy();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates instantaneous electric energy in units of 0.1 W.<br><br>0x8001.0x7FFE (-3276,7.3276,6)<br><br>Name : Small-capacity sensor instantaneous electric energy<br>EPC : 0xE2<br>Data Type : signed short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getSmallCapacitySensorInstantaneousElectricEnergy() {return null;}
	private final byte[] _getSmallCapacitySensorInstantaneousElectricEnergy(byte epc) {
		byte[] edt = getSmallCapacitySensorInstantaneousElectricEnergy();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates instantaneous electric energy in units of 0.1 kW.<br><br>0x8001.0x7FFE (-3276,7.3276,6)<br><br>Name : Large-capacity sensor instantaneous electric energy<br>EPC : 0xE3<br>Data Type : signed short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getLargeCapacitySensorInstantaneousElectricEnergy() {return null;}
	private final byte[] _getLargeCapacitySensorInstantaneousElectricEnergy(byte epc) {
		byte[] edt = getLargeCapacitySensorInstantaneousElectricEnergy();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates measurement result log of integral electric energy (0.001kWh) for the past 24 hours in 30-minute sections.<br><br>0.0x3B9AC9F (0.999,999,999) (0.999999.999 kWh)<br><br>Name : Integral electric energy measurement log<br>EPC : 0xE4<br>Data Type : unsigned long x 48<br>Data Size(Byte) : 192 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getIntegralElectricEnergyMeasurementLog() {return null;}
	private final byte[] _getIntegralElectricEnergyMeasurementLog(byte epc) {
		byte[] edt = getIntegralElectricEnergyMeasurementLog();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates effective voltage value in V.<br><br>0x0000.0xFFFD (0.65533V)<br><br>Name : Effective voltage value<br>EPC : 0xE5<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getEffectiveVoltageValue() {return null;}
	private final byte[] _getEffectiveVoltageValue(byte epc) {
		byte[] edt = getEffectiveVoltageValue();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


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
			edt = _getIntegralElectricEnergy(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_SMALL_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY:
			edt = _getSmallCapacitySensorInstantaneousElectricEnergy(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_LARGE_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY:
			edt = _getLargeCapacitySensorInstantaneousElectricEnergy(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG:
			edt = _getIntegralElectricEnergyMeasurementLog(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 192)));
			break;
		case EPC_EFFECTIVE_VOLTAGE_VALUE:
			edt = _getEffectiveVoltageValue(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;

		}
	}
	
	@Override
	public Setter set() {
		return new Setter(ESV_SETI);
	}

	@Override
	public Setter setC() {
		return new Setter(ESV_SETC);
	}

	@Override
	public Getter get() {
		return new Getter();
	}

	@Override
	public Informer inform() {
		return new InformerImpl();
	}
	
	public static class Receiver extends DeviceObject.Receiver {

		@Override
		protected void onReceiveSetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveSetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_INTEGRAL_ELECTRIC_ENERGY:
				_onGetIntegralElectricEnergy(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SMALL_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY:
				_onGetSmallCapacitySensorInstantaneousElectricEnergy(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_LARGE_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY:
				_onGetLargeCapacitySensorInstantaneousElectricEnergy(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG:
				_onGetIntegralElectricEnergyMeasurementLog(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_EFFECTIVE_VOLTAGE_VALUE:
				_onGetEffectiveVoltageValue(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates integral electric energy in 0.001kWh.<br><br>0x0.0x3B9AC9FF (0.999999.999 kWh)<br><br>Name : Integral electric energy<br>EPC : 0xE0<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetIntegralElectricEnergy(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetIntegralElectricEnergy(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetIntegralElectricEnergy(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates instantaneous electric energy in units of 0.1 W.<br><br>0x8001.0x7FFE (-3276,7.3276,6)<br><br>Name : Small-capacity sensor instantaneous electric energy<br>EPC : 0xE2<br>Data Type : signed short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetSmallCapacitySensorInstantaneousElectricEnergy(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSmallCapacitySensorInstantaneousElectricEnergy(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSmallCapacitySensorInstantaneousElectricEnergy(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates instantaneous electric energy in units of 0.1 kW.<br><br>0x8001.0x7FFE (-3276,7.3276,6)<br><br>Name : Large-capacity sensor instantaneous electric energy<br>EPC : 0xE3<br>Data Type : signed short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetLargeCapacitySensorInstantaneousElectricEnergy(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetLargeCapacitySensorInstantaneousElectricEnergy(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetLargeCapacitySensorInstantaneousElectricEnergy(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates measurement result log of integral electric energy (0.001kWh) for the past 24 hours in 30-minute sections.<br><br>0.0x3B9AC9F (0.999,999,999) (0.999999.999 kWh)<br><br>Name : Integral electric energy measurement log<br>EPC : 0xE4<br>Data Type : unsigned long x 48<br>Data Size(Byte) : 192 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetIntegralElectricEnergyMeasurementLog(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetIntegralElectricEnergyMeasurementLog(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetIntegralElectricEnergyMeasurementLog(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates effective voltage value in V.<br><br>0x0000.0xFFFD (0.65533V)<br><br>Name : Effective voltage value<br>EPC : 0xE5<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetEffectiveVoltageValue(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetEffectiveVoltageValue(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetEffectiveVoltageValue(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}

	}
	
	public class Setter extends DeviceObject.Setter {
		public Setter(byte esv) {
			super(esv);
		}

		@Override
		public Setter reqSet(byte epc, byte[] edt) {
			return (Setter)super.reqSet(epc, edt);
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

	public class Getter extends DeviceObject.Getter {

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
		 * This property indicates integral electric energy in 0.001kWh.<br><br>0x0.0x3B9AC9FF (0.999999.999 kWh)<br><br>Name : Integral electric energy<br>EPC : 0xE0<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetIntegralElectricEnergy() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * This property indicates instantaneous electric energy in units of 0.1 W.<br><br>0x8001.0x7FFE (-3276,7.3276,6)<br><br>Name : Small-capacity sensor instantaneous electric energy<br>EPC : 0xE2<br>Data Type : signed short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetSmallCapacitySensorInstantaneousElectricEnergy() {
			addProperty(EPC_SMALL_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * This property indicates instantaneous electric energy in units of 0.1 kW.<br><br>0x8001.0x7FFE (-3276,7.3276,6)<br><br>Name : Large-capacity sensor instantaneous electric energy<br>EPC : 0xE3<br>Data Type : signed short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetLargeCapacitySensorInstantaneousElectricEnergy() {
			addProperty(EPC_LARGE_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * This property indicates measurement result log of integral electric energy (0.001kWh) for the past 24 hours in 30-minute sections.<br><br>0.0x3B9AC9F (0.999,999,999) (0.999999.999 kWh)<br><br>Name : Integral electric energy measurement log<br>EPC : 0xE4<br>Data Type : unsigned long x 48<br>Data Size(Byte) : 192 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetIntegralElectricEnergyMeasurementLog() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG);
			return this;
		}
		/**
		 * This property indicates effective voltage value in V.<br><br>0x0000.0xFFFD (0.65533V)<br><br>Name : Effective voltage value<br>EPC : 0xE5<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetEffectiveVoltageValue() {
			addProperty(EPC_EFFECTIVE_VOLTAGE_VALUE);
			return this;
		}
	}
	
	public interface Informer extends DeviceObject.Informer {
		public Informer reqInform(byte epc);
		
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
		 * This property indicates integral electric energy in 0.001kWh.<br><br>0x0.0x3B9AC9FF (0.999999.999 kWh)<br><br>Name : Integral electric energy<br>EPC : 0xE0<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformIntegralElectricEnergy();
		/**
		 * This property indicates instantaneous electric energy in units of 0.1 W.<br><br>0x8001.0x7FFE (-3276,7.3276,6)<br><br>Name : Small-capacity sensor instantaneous electric energy<br>EPC : 0xE2<br>Data Type : signed short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformSmallCapacitySensorInstantaneousElectricEnergy();
		/**
		 * This property indicates instantaneous electric energy in units of 0.1 kW.<br><br>0x8001.0x7FFE (-3276,7.3276,6)<br><br>Name : Large-capacity sensor instantaneous electric energy<br>EPC : 0xE3<br>Data Type : signed short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformLargeCapacitySensorInstantaneousElectricEnergy();
		/**
		 * This property indicates measurement result log of integral electric energy (0.001kWh) for the past 24 hours in 30-minute sections.<br><br>0.0x3B9AC9F (0.999,999,999) (0.999999.999 kWh)<br><br>Name : Integral electric energy measurement log<br>EPC : 0xE4<br>Data Type : unsigned long x 48<br>Data Size(Byte) : 192 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformIntegralElectricEnergyMeasurementLog();
		/**
		 * This property indicates effective voltage value in V.<br><br>0x0000.0xFFFD (0.65533V)<br><br>Name : Effective voltage value<br>EPC : 0xE5<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformEffectiveVoltageValue();
	}

	public class InformerImpl extends DeviceObject.InformerImpl implements Informer {
		@Override
		public Informer reqInform(byte epc) {
			return (Informer)super.reqInform(epc);
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

		@Override
		public Informer reqInformIntegralElectricEnergy() {
			byte epc = EPC_INTEGRAL_ELECTRIC_ENERGY;
			byte[] edt = _getIntegralElectricEnergy(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformSmallCapacitySensorInstantaneousElectricEnergy() {
			byte epc = EPC_SMALL_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY;
			byte[] edt = _getSmallCapacitySensorInstantaneousElectricEnergy(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformLargeCapacitySensorInstantaneousElectricEnergy() {
			byte epc = EPC_LARGE_CAPACITY_SENSOR_INSTANTANEOUS_ELECTRIC_ENERGY;
			byte[] edt = _getLargeCapacitySensorInstantaneousElectricEnergy(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformIntegralElectricEnergyMeasurementLog() {
			byte epc = EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG;
			byte[] edt = _getIntegralElectricEnergyMeasurementLog(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 192)));
			return this;
		}
		@Override
		public Informer reqInformEffectiveVoltageValue() {
			byte epc = EPC_EFFECTIVE_VOLTAGE_VALUE;
			byte[] edt = _getEffectiveVoltageValue(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
	}
	
	public class InformerProxy extends DeviceObject.InformerProxy implements Informer {
		@Override
		public Informer reqInform(byte epc) {
			return (Informer)super.reqInform(epc);
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
