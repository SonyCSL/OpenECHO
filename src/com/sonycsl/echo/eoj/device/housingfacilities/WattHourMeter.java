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
	@SuppressWarnings("unused")
	private static final String TAG = WattHourMeter.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x80;

	protected static final byte EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_VALUE = (byte)0xE0;
	protected static final byte EPC_INTEGRAL_ELECTRIC_ENERGY_UNIT = (byte)0xE2;
	protected static final byte EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG1 = (byte)0xE3;
	protected static final byte EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG2 = (byte)0xE4;


	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates integral electric energy in decimal (8 digits).<br>0x00000000.0x05F5E0FF (0.99,999,999)
	 */
	protected abstract byte[] getIntegralElectricEnergyMeasurementValue();
	/**
	 * This property indicates number of decimal places of integral electric energy (0xE0).<br>0x01 :   0.1kWh 0x02 :   0.01kWh
	 */
	protected abstract byte[] getIntegralElectricEnergyUnit();
	/**
	 * This property indicates integral electric energy (8 digits) measurement result log in 30-minute segments for past 24 hours.<br>0x00000000.0x05F5E0FF (0.99,999,999)
	 */
	protected byte[] getIntegralElectricEnergyMeasurementLog1() {return null;}
	/**
	 * This property indicates integral electric energy (8 digits) measurement result log for past 24 hours as one-day data in 30-minute segments.<br>0x00000000.0x05F5E0FF (0.99,999,999)
	 */
	protected byte[] getIntegralElectricEnergyMeasurementLog2() {return null;}


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
			edt = getIntegralElectricEnergyMeasurementValue();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_INTEGRAL_ELECTRIC_ENERGY_UNIT:
			edt = getIntegralElectricEnergyUnit();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG1:
			edt = getIntegralElectricEnergyMeasurementLog1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 192)));
			break;
		case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG2:
			edt = getIntegralElectricEnergyMeasurementLog2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 192)));
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
			case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_VALUE:
				onGetIntegralElectricEnergyMeasurementValue(eoj, tid, pdc, edt);
				break;
			case EPC_INTEGRAL_ELECTRIC_ENERGY_UNIT:
				onGetIntegralElectricEnergyUnit(eoj, tid, pdc, edt);
				break;
			case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG1:
				onGetIntegralElectricEnergyMeasurementLog1(eoj, tid, pdc, edt);
				break;
			case EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG2:
				onGetIntegralElectricEnergyMeasurementLog2(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates integral electric energy in decimal (8 digits).<br>0x00000000.0x05F5E0FF (0.99,999,999)
		 */
		protected void onGetIntegralElectricEnergyMeasurementValue(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates number of decimal places of integral electric energy (0xE0).<br>0x01 :   0.1kWh 0x02 :   0.01kWh
		 */
		protected void onGetIntegralElectricEnergyUnit(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates integral electric energy (8 digits) measurement result log in 30-minute segments for past 24 hours.<br>0x00000000.0x05F5E0FF (0.99,999,999)
		 */
		protected void onGetIntegralElectricEnergyMeasurementLog1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates integral electric energy (8 digits) measurement result log for past 24 hours as one-day data in 30-minute segments.<br>0x00000000.0x05F5E0FF (0.99,999,999)
		 */
		protected void onGetIntegralElectricEnergyMeasurementLog2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

	}
	
	public interface Setter extends DeviceObject.Setter {
		public Setter reqSetPower(byte[] edt);
		public Setter reqSetInstallationLocation(byte[] edt);
		public Setter reqSetCurrentLimiting(byte[] edt);
		public Setter reqSetPowerSaving(byte[] edt);
		public Setter reqSetLocation(byte[] edt);
		public Setter reqSetCurrentTime(byte[] edt);
		public Setter reqSetCurrentDate(byte[] edt);
		public Setter reqSetPowerLimitation(byte[] edt);
		

	}

	public class SetterImpl extends DeviceObject.SetterImpl implements Setter {

		public SetterImpl(byte esv) {
			super(esv);
		}
		
		@Override
		public Setter reqSetPower(byte[] edt) {
			return (Setter)super.reqSetPower(edt);
		}

		@Override
		public Setter reqSetInstallationLocation(byte[] edt) {
			return (Setter)super.reqSetInstallationLocation(edt);
		}

		@Override
		public Setter reqSetCurrentLimiting(byte[] edt) {
			return (Setter)super.reqSetCurrentLimiting(edt);
		}

		@Override
		public Setter reqSetPowerSaving(byte[] edt) {
			return (Setter)super.reqSetPowerSaving(edt);
		}

		@Override
		public Setter reqSetLocation(byte[] edt) {
			return (Setter)super.reqSetLocation(edt);
		}

		@Override
		public Setter reqSetCurrentTime(byte[] edt) {
			return (Setter)super.reqSetCurrentTime(edt);
		}

		@Override
		public Setter reqSetCurrentDate(byte[] edt) {
			return (Setter)super.reqSetCurrentDate(edt);
		}

		@Override
		public Setter reqSetPowerLimitation(byte[] edt) {
			return (Setter)super.reqSetPowerLimitation(edt);
		}


	}
	
	public class SetterProxy extends DeviceObject.SetterProxy implements Setter {

		public SetterProxy(byte esv) {
			super(esv);
		}

		
		@Override
		public Setter reqSetPower(byte[] edt) {
			return (Setter)super.reqSetPower(edt);
		}

		@Override
		public Setter reqSetInstallationLocation(byte[] edt) {
			return (Setter)super.reqSetInstallationLocation(edt);
		}

		@Override
		public Setter reqSetCurrentLimiting(byte[] edt) {
			return (Setter)super.reqSetCurrentLimiting(edt);
		}

		@Override
		public Setter reqSetPowerSaving(byte[] edt) {
			return (Setter)super.reqSetPowerSaving(edt);
		}

		@Override
		public Setter reqSetLocation(byte[] edt) {
			return (Setter)super.reqSetLocation(edt);
		}

		@Override
		public Setter reqSetCurrentTime(byte[] edt) {
			return (Setter)super.reqSetCurrentTime(edt);
		}

		@Override
		public Setter reqSetCurrentDate(byte[] edt) {
			return (Setter)super.reqSetCurrentDate(edt);
		}

		@Override
		public Setter reqSetPowerLimitation(byte[] edt) {
			return (Setter)super.reqSetPowerLimitation(edt);
		}


	}

	public interface Getter extends DeviceObject.Getter {
		public Getter reqGetPower();
		public Getter reqGetInstallationLocation();
		public Getter reqGetVersion();
		public Getter reqGetIdNumber();
		public Getter reqGetElectricityConsumption();
		public Getter reqGetPowerConsumption();
		public Getter reqGetMakerErrorCode();
		public Getter reqGetCurrentLimiting();
		public Getter reqGetError();
		public Getter reqGetErrorInfo();
		public Getter reqGetMakerCode();
		public Getter reqGetWorkplaceCode();
		public Getter reqGetProductCode();
		public Getter reqGetManufacturingNumber();
		public Getter reqGetDateOfManufacture();
		public Getter reqGetPowerSaving();
		public Getter reqGetLocation();
		public Getter reqGetCurrentTime();
		public Getter reqGetCurrentDate();
		public Getter reqGetPowerLimitation();
		public Getter reqGetWorkingTime();
		public Getter reqGetAnnoPropertyMap();
		public Getter reqGetSetPropertyMap();
		public Getter reqGetGetPropertyMap();
		
		/**
		 * This property indicates integral electric energy in decimal (8 digits).<br>0x00000000.0x05F5E0FF (0.99,999,999)
		 */
		public Getter reqGetIntegralElectricEnergyMeasurementValue();
		/**
		 * This property indicates number of decimal places of integral electric energy (0xE0).<br>0x01 :   0.1kWh 0x02 :   0.01kWh
		 */
		public Getter reqGetIntegralElectricEnergyUnit();
		/**
		 * This property indicates integral electric energy (8 digits) measurement result log in 30-minute segments for past 24 hours.<br>0x00000000.0x05F5E0FF (0.99,999,999)
		 */
		public Getter reqGetIntegralElectricEnergyMeasurementLog1();
		/**
		 * This property indicates integral electric energy (8 digits) measurement result log for past 24 hours as one-day data in 30-minute segments.<br>0x00000000.0x05F5E0FF (0.99,999,999)
		 */
		public Getter reqGetIntegralElectricEnergyMeasurementLog2();

	}
	
	public class GetterImpl extends DeviceObject.GetterImpl implements Getter {

		@Override
		public Getter reqGetPower() {
			return (Getter)super.reqGetPower();
		}

		@Override
		public Getter reqGetInstallationLocation() {
			return (Getter)super.reqGetInstallationLocation();
		}

		@Override
		public Getter reqGetVersion() {
			return (Getter)super.reqGetVersion();
		}

		@Override
		public Getter reqGetIdNumber() {
			return (Getter)super.reqGetIdNumber();
		}

		@Override
		public Getter reqGetElectricityConsumption() {
			return (Getter)super.reqGetElectricityConsumption();
		}

		@Override
		public Getter reqGetPowerConsumption() {
			return (Getter)super.reqGetPowerConsumption();
		}

		@Override
		public Getter reqGetMakerErrorCode() {
			return (Getter)super.reqGetMakerErrorCode();
		}

		@Override
		public Getter reqGetCurrentLimiting() {
			return (Getter)super.reqGetCurrentLimiting();
		}

		@Override
		public Getter reqGetError() {
			return (Getter)super.reqGetError();
		}

		@Override
		public Getter reqGetErrorInfo() {
			return (Getter)super.reqGetErrorInfo();
		}

		@Override
		public Getter reqGetMakerCode() {
			return (Getter)super.reqGetMakerCode();
		}

		@Override
		public Getter reqGetWorkplaceCode() {
			return (Getter)super.reqGetWorkplaceCode();
		}

		@Override
		public Getter reqGetProductCode() {
			return (Getter)super.reqGetProductCode();
		}

		@Override
		public Getter reqGetManufacturingNumber() {
			return (Getter)super.reqGetManufacturingNumber();
		}

		@Override
		public Getter reqGetDateOfManufacture() {
			return (Getter)super.reqGetDateOfManufacture();
		}

		@Override
		public Getter reqGetPowerSaving() {
			return (Getter)super.reqGetPowerSaving();
		}

		@Override
		public Getter reqGetLocation() {
			return (Getter)super.reqGetLocation();
		}

		@Override
		public Getter reqGetCurrentTime() {
			return (Getter)super.reqGetCurrentTime();
		}

		@Override
		public Getter reqGetCurrentDate() {
			return (Getter)super.reqGetCurrentDate();
		}

		@Override
		public Getter reqGetPowerLimitation() {
			return (Getter)super.reqGetPowerLimitation();
		}

		@Override
		public Getter reqGetWorkingTime() {
			return (Getter)super.reqGetWorkingTime();
		}

		@Override
		public Getter reqGetAnnoPropertyMap() {
			return (Getter)super.reqGetAnnoPropertyMap();
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
		public Getter reqGetIntegralElectricEnergyMeasurementValue() {
			byte[] edt = getIntegralElectricEnergyMeasurementValue();
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_VALUE, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetIntegralElectricEnergyUnit() {
			byte[] edt = getIntegralElectricEnergyUnit();
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_UNIT, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetIntegralElectricEnergyMeasurementLog1() {
			byte[] edt = getIntegralElectricEnergyMeasurementLog1();
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG1, edt, (edt != null && (edt.length == 192)));
			return this;
		}
		@Override
		public Getter reqGetIntegralElectricEnergyMeasurementLog2() {
			byte[] edt = getIntegralElectricEnergyMeasurementLog2();
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG2, edt, (edt != null && (edt.length == 192)));
			return this;
		}

	}

	public class GetterProxy extends DeviceObject.GetterProxy implements Getter {

		@Override
		public Getter reqGetPower() {
			return (Getter)super.reqGetPower();
		}

		@Override
		public Getter reqGetInstallationLocation() {
			return (Getter)super.reqGetInstallationLocation();
		}

		@Override
		public Getter reqGetVersion() {
			return (Getter)super.reqGetVersion();
		}

		@Override
		public Getter reqGetIdNumber() {
			return (Getter)super.reqGetIdNumber();
		}

		@Override
		public Getter reqGetElectricityConsumption() {
			return (Getter)super.reqGetElectricityConsumption();
		}

		@Override
		public Getter reqGetPowerConsumption() {
			return (Getter)super.reqGetPowerConsumption();
		}

		@Override
		public Getter reqGetMakerErrorCode() {
			return (Getter)super.reqGetMakerErrorCode();
		}

		@Override
		public Getter reqGetCurrentLimiting() {
			return (Getter)super.reqGetCurrentLimiting();
		}

		@Override
		public Getter reqGetError() {
			return (Getter)super.reqGetError();
		}

		@Override
		public Getter reqGetErrorInfo() {
			return (Getter)super.reqGetErrorInfo();
		}

		@Override
		public Getter reqGetMakerCode() {
			return (Getter)super.reqGetMakerCode();
		}

		@Override
		public Getter reqGetWorkplaceCode() {
			return (Getter)super.reqGetWorkplaceCode();
		}

		@Override
		public Getter reqGetProductCode() {
			return (Getter)super.reqGetProductCode();
		}

		@Override
		public Getter reqGetManufacturingNumber() {
			return (Getter)super.reqGetManufacturingNumber();
		}

		@Override
		public Getter reqGetDateOfManufacture() {
			return (Getter)super.reqGetDateOfManufacture();
		}

		@Override
		public Getter reqGetPowerSaving() {
			return (Getter)super.reqGetPowerSaving();
		}

		@Override
		public Getter reqGetLocation() {
			return (Getter)super.reqGetLocation();
		}

		@Override
		public Getter reqGetCurrentTime() {
			return (Getter)super.reqGetCurrentTime();
		}

		@Override
		public Getter reqGetCurrentDate() {
			return (Getter)super.reqGetCurrentDate();
		}

		@Override
		public Getter reqGetPowerLimitation() {
			return (Getter)super.reqGetPowerLimitation();
		}

		@Override
		public Getter reqGetWorkingTime() {
			return (Getter)super.reqGetWorkingTime();
		}

		@Override
		public Getter reqGetAnnoPropertyMap() {
			return (Getter)super.reqGetAnnoPropertyMap();
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
		public Getter reqGetIntegralElectricEnergyMeasurementValue() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_VALUE);
			return this;
		}
		@Override
		public Getter reqGetIntegralElectricEnergyUnit() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_UNIT);
			return this;
		}
		@Override
		public Getter reqGetIntegralElectricEnergyMeasurementLog1() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG1);
			return this;
		}
		@Override
		public Getter reqGetIntegralElectricEnergyMeasurementLog2() {
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG2);
			return this;
		}

	}
	
	public interface Informer extends DeviceObject.Informer {
		public Informer reqInformPower();
		public Informer reqInformInstallationLocation();
		public Informer reqInformVersion();
		public Informer reqInformIdNumber();
		public Informer reqInformElectricityConsumption();
		public Informer reqInformPowerConsumption();
		public Informer reqInformMakerErrorCode();
		public Informer reqInformCurrentLimiting();
		public Informer reqInformError();
		public Informer reqInformErrorInfo();
		public Informer reqInformMakerCode();
		public Informer reqInformWorkplaceCode();
		public Informer reqInformProductCode();
		public Informer reqInformManufacturingNumber();
		public Informer reqInformDateOfManufacture();
		public Informer reqInformPowerSaving();
		public Informer reqInformLocation();
		public Informer reqInformCurrentTime();
		public Informer reqInformCurrentDate();
		public Informer reqInformPowerLimitation();
		public Informer reqInformWorkingTime();
		public Informer reqInformAnnoPropertyMap();
		public Informer reqInformSetPropertyMap();
		public Informer reqInformGetPropertyMap();
		
		/**
		 * This property indicates integral electric energy in decimal (8 digits).<br>0x00000000.0x05F5E0FF (0.99,999,999)
		 */
		public Informer reqInformIntegralElectricEnergyMeasurementValue();
		/**
		 * This property indicates number of decimal places of integral electric energy (0xE0).<br>0x01 :   0.1kWh 0x02 :   0.01kWh
		 */
		public Informer reqInformIntegralElectricEnergyUnit();
		/**
		 * This property indicates integral electric energy (8 digits) measurement result log in 30-minute segments for past 24 hours.<br>0x00000000.0x05F5E0FF (0.99,999,999)
		 */
		public Informer reqInformIntegralElectricEnergyMeasurementLog1();
		/**
		 * This property indicates integral electric energy (8 digits) measurement result log for past 24 hours as one-day data in 30-minute segments.<br>0x00000000.0x05F5E0FF (0.99,999,999)
		 */
		public Informer reqInformIntegralElectricEnergyMeasurementLog2();

	}

	public class InformerImpl extends DeviceObject.InformerImpl implements Informer {

		@Override
		public Informer reqInformPower() {
			return (Informer)super.reqInformPower();
		}

		@Override
		public Informer reqInformInstallationLocation() {
			return (Informer)super.reqInformInstallationLocation();
		}

		@Override
		public Informer reqInformVersion() {
			return (Informer)super.reqInformVersion();
		}

		@Override
		public Informer reqInformIdNumber() {
			return (Informer)super.reqInformIdNumber();
		}

		@Override
		public Informer reqInformElectricityConsumption() {
			return (Informer)super.reqInformElectricityConsumption();
		}

		@Override
		public Informer reqInformPowerConsumption() {
			return (Informer)super.reqInformPowerConsumption();
		}

		@Override
		public Informer reqInformMakerErrorCode() {
			return (Informer)super.reqInformMakerErrorCode();
		}

		@Override
		public Informer reqInformCurrentLimiting() {
			return (Informer)super.reqInformCurrentLimiting();
		}

		@Override
		public Informer reqInformError() {
			return (Informer)super.reqInformError();
		}

		@Override
		public Informer reqInformErrorInfo() {
			return (Informer)super.reqInformErrorInfo();
		}

		@Override
		public Informer reqInformMakerCode() {
			return (Informer)super.reqInformMakerCode();
		}

		@Override
		public Informer reqInformWorkplaceCode() {
			return (Informer)super.reqInformWorkplaceCode();
		}

		@Override
		public Informer reqInformProductCode() {
			return (Informer)super.reqInformProductCode();
		}

		@Override
		public Informer reqInformManufacturingNumber() {
			return (Informer)super.reqInformManufacturingNumber();
		}

		@Override
		public Informer reqInformDateOfManufacture() {
			return (Informer)super.reqInformDateOfManufacture();
		}

		@Override
		public Informer reqInformPowerSaving() {
			return (Informer)super.reqInformPowerSaving();
		}

		@Override
		public Informer reqInformLocation() {
			return (Informer)super.reqInformLocation();
		}

		@Override
		public Informer reqInformCurrentTime() {
			return (Informer)super.reqInformCurrentTime();
		}

		@Override
		public Informer reqInformCurrentDate() {
			return (Informer)super.reqInformCurrentDate();
		}

		@Override
		public Informer reqInformPowerLimitation() {
			return (Informer)super.reqInformPowerLimitation();
		}

		@Override
		public Informer reqInformWorkingTime() {
			return (Informer)super.reqInformWorkingTime();
		}

		@Override
		public Informer reqInformAnnoPropertyMap() {
			return (Informer)super.reqInformAnnoPropertyMap();
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
			byte[] edt = getIntegralElectricEnergyMeasurementValue();
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_VALUE, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformIntegralElectricEnergyUnit() {
			byte[] edt = getIntegralElectricEnergyUnit();
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_UNIT, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformIntegralElectricEnergyMeasurementLog1() {
			byte[] edt = getIntegralElectricEnergyMeasurementLog1();
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG1, edt, (edt != null && (edt.length == 192)));
			return this;
		}
		@Override
		public Informer reqInformIntegralElectricEnergyMeasurementLog2() {
			byte[] edt = getIntegralElectricEnergyMeasurementLog2();
			addProperty(EPC_INTEGRAL_ELECTRIC_ENERGY_MEASUREMENT_LOG2, edt, (edt != null && (edt.length == 192)));
			return this;
		}

	}
	
	public class InformerProxy extends DeviceObject.InformerProxy implements Informer {

		@Override
		public Informer reqInformPower() {
			return (Informer)super.reqInformPower();
		}

		@Override
		public Informer reqInformInstallationLocation() {
			return (Informer)super.reqInformInstallationLocation();
		}

		@Override
		public Informer reqInformVersion() {
			return (Informer)super.reqInformVersion();
		}

		@Override
		public Informer reqInformIdNumber() {
			return (Informer)super.reqInformIdNumber();
		}

		@Override
		public Informer reqInformElectricityConsumption() {
			return (Informer)super.reqInformElectricityConsumption();
		}

		@Override
		public Informer reqInformPowerConsumption() {
			return (Informer)super.reqInformPowerConsumption();
		}

		@Override
		public Informer reqInformMakerErrorCode() {
			return (Informer)super.reqInformMakerErrorCode();
		}

		@Override
		public Informer reqInformCurrentLimiting() {
			return (Informer)super.reqInformCurrentLimiting();
		}

		@Override
		public Informer reqInformError() {
			return (Informer)super.reqInformError();
		}

		@Override
		public Informer reqInformErrorInfo() {
			return (Informer)super.reqInformErrorInfo();
		}

		@Override
		public Informer reqInformMakerCode() {
			return (Informer)super.reqInformMakerCode();
		}

		@Override
		public Informer reqInformWorkplaceCode() {
			return (Informer)super.reqInformWorkplaceCode();
		}

		@Override
		public Informer reqInformProductCode() {
			return (Informer)super.reqInformProductCode();
		}

		@Override
		public Informer reqInformManufacturingNumber() {
			return (Informer)super.reqInformManufacturingNumber();
		}

		@Override
		public Informer reqInformDateOfManufacture() {
			return (Informer)super.reqInformDateOfManufacture();
		}

		@Override
		public Informer reqInformPowerSaving() {
			return (Informer)super.reqInformPowerSaving();
		}

		@Override
		public Informer reqInformLocation() {
			return (Informer)super.reqInformLocation();
		}

		@Override
		public Informer reqInformCurrentTime() {
			return (Informer)super.reqInformCurrentTime();
		}

		@Override
		public Informer reqInformCurrentDate() {
			return (Informer)super.reqInformCurrentDate();
		}

		@Override
		public Informer reqInformPowerLimitation() {
			return (Informer)super.reqInformPowerLimitation();
		}

		@Override
		public Informer reqInformWorkingTime() {
			return (Informer)super.reqInformWorkingTime();
		}

		@Override
		public Informer reqInformAnnoPropertyMap() {
			return (Informer)super.reqInformAnnoPropertyMap();
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
