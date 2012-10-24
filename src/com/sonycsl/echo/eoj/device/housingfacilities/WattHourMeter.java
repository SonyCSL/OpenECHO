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

import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;

public abstract class WattHourMeter extends DeviceObject {
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x80;

	public static final byte EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_VALUE = (byte)0xE0;
	public static final byte EPC_INTEGRAL_ELECTRIC_ENERGY_UNIT = (byte)0xE2;
	public static final byte EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG1 = (byte)0xE3;
	public static final byte EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG2 = (byte)0xE4;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates integral electric energy in decimal (8 digits).<br><br>0x00000000.0x05F5E0FF (0.99,999,999)<br><br>Name : Integral electric energy measurement value<br>EPC : 0xE0<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getIntegralElectricEnergyMeasurementValue();
	private final byte[] _getIntegralElectricEnergyMeasurementValue(byte epc) {
		byte[] edt = getIntegralElectricEnergyMeasurementValue();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates number of decimal places of integral electric energy (0xE0).<br><br>0x01 :   0.1kWh 0x02 :   0.01kWh<br><br>Name : Integral electric energy unit<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getIntegralElectricEnergyUnit();
	private final byte[] _getIntegralElectricEnergyUnit(byte epc) {
		byte[] edt = getIntegralElectricEnergyUnit();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates integral electric energy (8 digits) measurement result log in 30-minute segments for past 24 hours.<br><br>0x00000000.0x05F5E0FF (0.99,999,999)<br><br>Name : Integral electric energy measurement log 1<br>EPC : 0xE3<br>Data Type : unsigned long x 48<br>Data Size(Byte) : 192 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getIntegralElectricEnergyMeasurementLog1() {return null;}
	private final byte[] _getIntegralElectricEnergyMeasurementLog1(byte epc) {
		byte[] edt = getIntegralElectricEnergyMeasurementLog1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates integral electric energy (8 digits) measurement result log for past 24 hours as one-day data in 30-minute segments.<br><br>0x00000000.0x05F5E0FF (0.99,999,999)<br><br>Name : Integral electric energy measurement log 2<br>EPC : 0xE4<br>Data Type : unsigned long x48 x45<br>Data Size(Byte) : 192 bytes x 45<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getIntegralElectricEnergyMeasurementLog2() {return null;}
	private final byte[] _getIntegralElectricEnergyMeasurementLog2(byte epc) {
		byte[] edt = getIntegralElectricEnergyMeasurementLog2();
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
		case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_VALUE:
			edt = _getIntegralElectricEnergyMeasurementValue(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_INTEGRAL_ELECTRIC_ENERGY_UNIT:
			edt = _getIntegralElectricEnergyUnit(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG1:
			edt = _getIntegralElectricEnergyMeasurementLog1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 192)));
			break;
		case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG2:
			edt = _getIntegralElectricEnergyMeasurementLog2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 192)));
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
			case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_VALUE:
				_onGetIntegralElectricEnergyMeasurementValue(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_INTEGRAL_ELECTRIC_ENERGY_UNIT:
				_onGetIntegralElectricEnergyUnit(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG1:
				_onGetIntegralElectricEnergyMeasurementLog1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG2:
				_onGetIntegralElectricEnergyMeasurementLog2(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates integral electric energy in decimal (8 digits).<br><br>0x00000000.0x05F5E0FF (0.99,999,999)<br><br>Name : Integral electric energy measurement value<br>EPC : 0xE0<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetIntegralElectricEnergyMeasurementValue(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetIntegralElectricEnergyMeasurementValue(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetIntegralElectricEnergyMeasurementValue(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates number of decimal places of integral electric energy (0xE0).<br><br>0x01 :   0.1kWh 0x02 :   0.01kWh<br><br>Name : Integral electric energy unit<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetIntegralElectricEnergyUnit(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetIntegralElectricEnergyUnit(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetIntegralElectricEnergyUnit(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates integral electric energy (8 digits) measurement result log in 30-minute segments for past 24 hours.<br><br>0x00000000.0x05F5E0FF (0.99,999,999)<br><br>Name : Integral electric energy measurement log 1<br>EPC : 0xE3<br>Data Type : unsigned long x 48<br>Data Size(Byte) : 192 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetIntegralElectricEnergyMeasurementLog1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetIntegralElectricEnergyMeasurementLog1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetIntegralElectricEnergyMeasurementLog1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates integral electric energy (8 digits) measurement result log for past 24 hours as one-day data in 30-minute segments.<br><br>0x00000000.0x05F5E0FF (0.99,999,999)<br><br>Name : Integral electric energy measurement log 2<br>EPC : 0xE4<br>Data Type : unsigned long x48 x45<br>Data Size(Byte) : 192 bytes x 45<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetIntegralElectricEnergyMeasurementLog2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetIntegralElectricEnergyMeasurementLog2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetIntegralElectricEnergyMeasurementLog2(eoj, tid, esv, epc, pdc, edt);
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
		 * This property indicates integral electric energy in decimal (8 digits).<br><br>0x00000000.0x05F5E0FF (0.99,999,999)<br><br>Name : Integral electric energy measurement value<br>EPC : 0xE0<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetIntegralElectricEnergyMeasurementValue() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_VALUE);
			return this;
		}
		/**
		 * This property indicates number of decimal places of integral electric energy (0xE0).<br><br>0x01 :   0.1kWh 0x02 :   0.01kWh<br><br>Name : Integral electric energy unit<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetIntegralElectricEnergyUnit() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_UNIT);
			return this;
		}
		/**
		 * This property indicates integral electric energy (8 digits) measurement result log in 30-minute segments for past 24 hours.<br><br>0x00000000.0x05F5E0FF (0.99,999,999)<br><br>Name : Integral electric energy measurement log 1<br>EPC : 0xE3<br>Data Type : unsigned long x 48<br>Data Size(Byte) : 192 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetIntegralElectricEnergyMeasurementLog1() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG1);
			return this;
		}
		/**
		 * This property indicates integral electric energy (8 digits) measurement result log for past 24 hours as one-day data in 30-minute segments.<br><br>0x00000000.0x05F5E0FF (0.99,999,999)<br><br>Name : Integral electric energy measurement log 2<br>EPC : 0xE4<br>Data Type : unsigned long x48 x45<br>Data Size(Byte) : 192 bytes x 45<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetIntegralElectricEnergyMeasurementLog2() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG2);
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
		 * This property indicates integral electric energy in decimal (8 digits).<br><br>0x00000000.0x05F5E0FF (0.99,999,999)<br><br>Name : Integral electric energy measurement value<br>EPC : 0xE0<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformIntegralElectricEnergyMeasurementValue();
		/**
		 * This property indicates number of decimal places of integral electric energy (0xE0).<br><br>0x01 :   0.1kWh 0x02 :   0.01kWh<br><br>Name : Integral electric energy unit<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformIntegralElectricEnergyUnit();
		/**
		 * This property indicates integral electric energy (8 digits) measurement result log in 30-minute segments for past 24 hours.<br><br>0x00000000.0x05F5E0FF (0.99,999,999)<br><br>Name : Integral electric energy measurement log 1<br>EPC : 0xE3<br>Data Type : unsigned long x 48<br>Data Size(Byte) : 192 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformIntegralElectricEnergyMeasurementLog1();
		/**
		 * This property indicates integral electric energy (8 digits) measurement result log for past 24 hours as one-day data in 30-minute segments.<br><br>0x00000000.0x05F5E0FF (0.99,999,999)<br><br>Name : Integral electric energy measurement log 2<br>EPC : 0xE4<br>Data Type : unsigned long x48 x45<br>Data Size(Byte) : 192 bytes x 45<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformIntegralElectricEnergyMeasurementLog2();
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
		public Informer reqInformIntegralElectricEnergyMeasurementValue() {
			byte epc = EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_VALUE;
			byte[] edt = _getIntegralElectricEnergyMeasurementValue(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformIntegralElectricEnergyUnit() {
			byte epc = EPC_INTEGRAL_ELECTRIC_ENERGY_UNIT;
			byte[] edt = _getIntegralElectricEnergyUnit(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformIntegralElectricEnergyMeasurementLog1() {
			byte epc = EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG1;
			byte[] edt = _getIntegralElectricEnergyMeasurementLog1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 192)));
			return this;
		}
		@Override
		public Informer reqInformIntegralElectricEnergyMeasurementLog2() {
			byte epc = EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG2;
			byte[] edt = _getIntegralElectricEnergyMeasurementLog2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 192)));
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
		public Informer reqInformIntegralElectricEnergyMeasurementValue() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_VALUE);
			return this;
		}
		@Override
		public Informer reqInformIntegralElectricEnergyUnit() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_UNIT);
			return this;
		}
		@Override
		public Informer reqInformIntegralElectricEnergyMeasurementLog1() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG1);
			return this;
		}
		@Override
		public Informer reqInformIntegralElectricEnergyMeasurementLog2() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG2);
			return this;
		}
	}
}
