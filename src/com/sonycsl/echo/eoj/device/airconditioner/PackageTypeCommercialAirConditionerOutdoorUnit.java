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

import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;

public abstract class PackageTypeCommercialAirConditionerOutdoorUnit extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = PackageTypeCommercialAirConditionerOutdoorUnit.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x01;
	public static final byte CLASS_CODE = (byte)0x46;

	protected static final byte EPC_OPERATION_MODE_SETTING = (byte)0xB0;
	protected static final byte EPC_RATED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT = (byte)0xB8;
	protected static final byte EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_OUTDOOR_UNIT = (byte)0xB9;
	protected static final byte EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE1 = (byte)0xBE;
	protected static final byte EPC_GSPECIAL_H_STATE = (byte)0xAA;
	protected static final byte EPC_OPERATION_STATUS_OF_COMPRESSOR = (byte)0xD0;
	protected static final byte EPC_OPERATION_MODE_INFORMATION = (byte)0xD1;
	protected static final byte EPC_FAN_ROTATION_SPEED = (byte)0xD2;
	protected static final byte EPC_MEASURED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT = (byte)0xDB;
	protected static final byte EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE2 = (byte)0xEE;


	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Used to acquire the current operation mode setting (i.e. �gautomatic,�h �gcooling,�h �gheating,�h �gdehumidification�h or �gair circulator�h).<br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45
	 */
	protected boolean setOperationModeSetting(byte[] edt) {return false;}
	/**
	 * Used to acquire the current operation mode setting (i.e. �gautomatic,�h �gcooling,�h �gheating,�h �gdehumidification�h or �gair circulator�h).<br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45
	 */
	protected byte[] getOperationModeSetting() {return null;}
	/**
	 * Used to acquire the rated power consumption for the cooling, heating and dehumidification modes.<br>0x0000 to 0xFFFD (0 to 65533W) Cooling: heating: dehumidification
	 */
	protected byte[] getRatedPowerConsumptionOfOutdoorUnit() {return null;}
	/**
	 * Used to acquire the measured electric current consumption.<br>0x0000 to 0xFFFD (0 to 6553.3A)
	 */
	protected byte[] getMeasuredElectricCurrentConsumptionOfOutdoorUnit() {return null;}
	/**
	 * Used to acquire the measured temperature of the outdoor air.<br>0x81 to 0x7D (-127 to 125��C)
	 */
	protected byte[] getMeasuredOutdoorAirTemperature1() {return null;}
	/**
	 * This property indicates when the air conditioner is in the �gspecial�h state (i.e. �gdefrosting�h state).<br>�gNormal operation�h state = 0x40, �gdefrosting�h state = 0x41
	 */
	protected byte[] getGspecialHState() {return null;}
	/**
	 * Used to acquire the operation status (i.e. ON or OFF) of the compressor.<br>Compressor ON: 0x41 Compressor OFF: 0x42
	 */
	protected byte[] getOperationStatusOfCompressor() {return null;}
	/**
	 * Used to acquire the current operation mode (i.e. �gcooling,�h �gheating,�h �gdehumidification�h or �gother�h).<br>Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Other: 0x40
	 */
	protected abstract byte[] getOperationModeInformation();
	/**
	 * Used to acquire the rotation speed of the fan of the outdoor unit (expressed in %).<br>0x00 to 0x64 (0 to 100%)
	 */
	protected byte[] getFanRotationSpeed() {return null;}
	/**
	 * Used to acquire the measured power consumption of the outdoor unit.<br>0x0000 to 0xFFFD (0 to 65533W)
	 */
	protected byte[] getMeasuredPowerConsumptionOfOutdoorUnit() {return null;}
	/**
	 * Used to acquire the measured temperature of the outdoor air.<br>0xF554 to 0x7FFD (-273,2 to 3276.5��C)
	 */
	protected byte[] getMeasuredOutdoorAirTemperature2() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_OPERATION_MODE_SETTING:
			res.addProperty(epc, edt, setOperationModeSetting(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_OPERATION_MODE_SETTING:
			edt = getOperationModeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RATED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT:
			edt = getRatedPowerConsumptionOfOutdoorUnit();
			res.addProperty(epc, edt, (edt != null && (edt.length == 6)));
			break;
		case EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_OUTDOOR_UNIT:
			edt = getMeasuredElectricCurrentConsumptionOfOutdoorUnit();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE1:
			edt = getMeasuredOutdoorAirTemperature1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GSPECIAL_H_STATE:
			edt = getGspecialHState();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OPERATION_STATUS_OF_COMPRESSOR:
			edt = getOperationStatusOfCompressor();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OPERATION_MODE_INFORMATION:
			edt = getOperationModeInformation();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_FAN_ROTATION_SPEED:
			edt = getFanRotationSpeed();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT:
			edt = getMeasuredPowerConsumptionOfOutdoorUnit();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE2:
			edt = getMeasuredOutdoorAirTemperature2();
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
			case EPC_OPERATION_MODE_SETTING:
				onSetOperationModeSetting(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_OPERATION_MODE_SETTING:
				onGetOperationModeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_RATED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT:
				onGetRatedPowerConsumptionOfOutdoorUnit(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_OUTDOOR_UNIT:
				onGetMeasuredElectricCurrentConsumptionOfOutdoorUnit(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE1:
				onGetMeasuredOutdoorAirTemperature1(eoj, tid, pdc, edt);
				break;
			case EPC_GSPECIAL_H_STATE:
				onGetGspecialHState(eoj, tid, pdc, edt);
				break;
			case EPC_OPERATION_STATUS_OF_COMPRESSOR:
				onGetOperationStatusOfCompressor(eoj, tid, pdc, edt);
				break;
			case EPC_OPERATION_MODE_INFORMATION:
				onGetOperationModeInformation(eoj, tid, pdc, edt);
				break;
			case EPC_FAN_ROTATION_SPEED:
				onGetFanRotationSpeed(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT:
				onGetMeasuredPowerConsumptionOfOutdoorUnit(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE2:
				onGetMeasuredOutdoorAirTemperature2(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * Used to acquire the current operation mode setting (i.e. �gautomatic,�h �gcooling,�h �gheating,�h �gdehumidification�h or �gair circulator�h).<br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45
		 */
		protected void onSetOperationModeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to acquire the current operation mode setting (i.e. �gautomatic,�h �gcooling,�h �gheating,�h �gdehumidification�h or �gair circulator�h).<br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45
		 */
		protected void onGetOperationModeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the rated power consumption for the cooling, heating and dehumidification modes.<br>0x0000 to 0xFFFD (0 to 65533W) Cooling: heating: dehumidification
		 */
		protected void onGetRatedPowerConsumptionOfOutdoorUnit(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured electric current consumption.<br>0x0000 to 0xFFFD (0 to 6553.3A)
		 */
		protected void onGetMeasuredElectricCurrentConsumptionOfOutdoorUnit(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured temperature of the outdoor air.<br>0x81 to 0x7D (-127 to 125��C)
		 */
		protected void onGetMeasuredOutdoorAirTemperature1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates when the air conditioner is in the �gspecial�h state (i.e. �gdefrosting�h state).<br>�gNormal operation�h state = 0x40, �gdefrosting�h state = 0x41
		 */
		protected void onGetGspecialHState(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the operation status (i.e. ON or OFF) of the compressor.<br>Compressor ON: 0x41 Compressor OFF: 0x42
		 */
		protected void onGetOperationStatusOfCompressor(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the current operation mode (i.e. �gcooling,�h �gheating,�h �gdehumidification�h or �gother�h).<br>Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Other: 0x40
		 */
		protected void onGetOperationModeInformation(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the rotation speed of the fan of the outdoor unit (expressed in %).<br>0x00 to 0x64 (0 to 100%)
		 */
		protected void onGetFanRotationSpeed(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured power consumption of the outdoor unit.<br>0x0000 to 0xFFFD (0 to 65533W)
		 */
		protected void onGetMeasuredPowerConsumptionOfOutdoorUnit(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured temperature of the outdoor air.<br>0xF554 to 0x7FFD (-273,2 to 3276.5��C)
		 */
		protected void onGetMeasuredOutdoorAirTemperature2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		
		/**
		 * Used to acquire the current operation mode setting (i.e. �gautomatic,�h �gcooling,�h �gheating,�h �gdehumidification�h or �gair circulator�h).<br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45
		 */
		public Setter reqSetOperationModeSetting(byte[] edt);

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

		@Override
		public Setter reqSetOperationModeSetting(byte[] edt) {
			addProperty(EPC_OPERATION_MODE_SETTING, edt, setOperationModeSetting(edt));
			return this;
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

		@Override
		public Setter reqSetOperationModeSetting(byte[] edt) {
			addProperty(EPC_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
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
		 * Used to acquire the current operation mode setting (i.e. �gautomatic,�h �gcooling,�h �gheating,�h �gdehumidification�h or �gair circulator�h).<br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45
		 */
		public Getter reqGetOperationModeSetting();
		/**
		 * Used to acquire the rated power consumption for the cooling, heating and dehumidification modes.<br>0x0000 to 0xFFFD (0 to 65533W) Cooling: heating: dehumidification
		 */
		public Getter reqGetRatedPowerConsumptionOfOutdoorUnit();
		/**
		 * Used to acquire the measured electric current consumption.<br>0x0000 to 0xFFFD (0 to 6553.3A)
		 */
		public Getter reqGetMeasuredElectricCurrentConsumptionOfOutdoorUnit();
		/**
		 * Used to acquire the measured temperature of the outdoor air.<br>0x81 to 0x7D (-127 to 125��C)
		 */
		public Getter reqGetMeasuredOutdoorAirTemperature1();
		/**
		 * This property indicates when the air conditioner is in the �gspecial�h state (i.e. �gdefrosting�h state).<br>�gNormal operation�h state = 0x40, �gdefrosting�h state = 0x41
		 */
		public Getter reqGetGspecialHState();
		/**
		 * Used to acquire the operation status (i.e. ON or OFF) of the compressor.<br>Compressor ON: 0x41 Compressor OFF: 0x42
		 */
		public Getter reqGetOperationStatusOfCompressor();
		/**
		 * Used to acquire the current operation mode (i.e. �gcooling,�h �gheating,�h �gdehumidification�h or �gother�h).<br>Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Other: 0x40
		 */
		public Getter reqGetOperationModeInformation();
		/**
		 * Used to acquire the rotation speed of the fan of the outdoor unit (expressed in %).<br>0x00 to 0x64 (0 to 100%)
		 */
		public Getter reqGetFanRotationSpeed();
		/**
		 * Used to acquire the measured power consumption of the outdoor unit.<br>0x0000 to 0xFFFD (0 to 65533W)
		 */
		public Getter reqGetMeasuredPowerConsumptionOfOutdoorUnit();
		/**
		 * Used to acquire the measured temperature of the outdoor air.<br>0xF554 to 0x7FFD (-273,2 to 3276.5��C)
		 */
		public Getter reqGetMeasuredOutdoorAirTemperature2();

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
		public Getter reqGetOperationModeSetting() {
			byte[] edt = getOperationModeSetting();
			addProperty(EPC_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRatedPowerConsumptionOfOutdoorUnit() {
			byte[] edt = getRatedPowerConsumptionOfOutdoorUnit();
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredElectricCurrentConsumptionOfOutdoorUnit() {
			byte[] edt = getMeasuredElectricCurrentConsumptionOfOutdoorUnit();
			addProperty(EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_OUTDOOR_UNIT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredOutdoorAirTemperature1() {
			byte[] edt = getMeasuredOutdoorAirTemperature1();
			addProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGspecialHState() {
			byte[] edt = getGspecialHState();
			addProperty(EPC_GSPECIAL_H_STATE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOperationStatusOfCompressor() {
			byte[] edt = getOperationStatusOfCompressor();
			addProperty(EPC_OPERATION_STATUS_OF_COMPRESSOR, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOperationModeInformation() {
			byte[] edt = getOperationModeInformation();
			addProperty(EPC_OPERATION_MODE_INFORMATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetFanRotationSpeed() {
			byte[] edt = getFanRotationSpeed();
			addProperty(EPC_FAN_ROTATION_SPEED, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredPowerConsumptionOfOutdoorUnit() {
			byte[] edt = getMeasuredPowerConsumptionOfOutdoorUnit();
			addProperty(EPC_MEASURED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredOutdoorAirTemperature2() {
			byte[] edt = getMeasuredOutdoorAirTemperature2();
			addProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE2, edt, (edt != null && (edt.length == 2)));
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
		public Getter reqGetOperationModeSetting() {
			addProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetRatedPowerConsumptionOfOutdoorUnit() {
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT);
			return this;
		}
		@Override
		public Getter reqGetMeasuredElectricCurrentConsumptionOfOutdoorUnit() {
			addProperty(EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_OUTDOOR_UNIT);
			return this;
		}
		@Override
		public Getter reqGetMeasuredOutdoorAirTemperature1() {
			addProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE1);
			return this;
		}
		@Override
		public Getter reqGetGspecialHState() {
			addProperty(EPC_GSPECIAL_H_STATE);
			return this;
		}
		@Override
		public Getter reqGetOperationStatusOfCompressor() {
			addProperty(EPC_OPERATION_STATUS_OF_COMPRESSOR);
			return this;
		}
		@Override
		public Getter reqGetOperationModeInformation() {
			addProperty(EPC_OPERATION_MODE_INFORMATION);
			return this;
		}
		@Override
		public Getter reqGetFanRotationSpeed() {
			addProperty(EPC_FAN_ROTATION_SPEED);
			return this;
		}
		@Override
		public Getter reqGetMeasuredPowerConsumptionOfOutdoorUnit() {
			addProperty(EPC_MEASURED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT);
			return this;
		}
		@Override
		public Getter reqGetMeasuredOutdoorAirTemperature2() {
			addProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE2);
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
		 * Used to acquire the current operation mode setting (i.e. �gautomatic,�h �gcooling,�h �gheating,�h �gdehumidification�h or �gair circulator�h).<br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45
		 */
		public Informer reqInformOperationModeSetting();
		/**
		 * Used to acquire the rated power consumption for the cooling, heating and dehumidification modes.<br>0x0000 to 0xFFFD (0 to 65533W) Cooling: heating: dehumidification
		 */
		public Informer reqInformRatedPowerConsumptionOfOutdoorUnit();
		/**
		 * Used to acquire the measured electric current consumption.<br>0x0000 to 0xFFFD (0 to 6553.3A)
		 */
		public Informer reqInformMeasuredElectricCurrentConsumptionOfOutdoorUnit();
		/**
		 * Used to acquire the measured temperature of the outdoor air.<br>0x81 to 0x7D (-127 to 125��C)
		 */
		public Informer reqInformMeasuredOutdoorAirTemperature1();
		/**
		 * This property indicates when the air conditioner is in the �gspecial�h state (i.e. �gdefrosting�h state).<br>�gNormal operation�h state = 0x40, �gdefrosting�h state = 0x41
		 */
		public Informer reqInformGspecialHState();
		/**
		 * Used to acquire the operation status (i.e. ON or OFF) of the compressor.<br>Compressor ON: 0x41 Compressor OFF: 0x42
		 */
		public Informer reqInformOperationStatusOfCompressor();
		/**
		 * Used to acquire the current operation mode (i.e. �gcooling,�h �gheating,�h �gdehumidification�h or �gother�h).<br>Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Other: 0x40
		 */
		public Informer reqInformOperationModeInformation();
		/**
		 * Used to acquire the rotation speed of the fan of the outdoor unit (expressed in %).<br>0x00 to 0x64 (0 to 100%)
		 */
		public Informer reqInformFanRotationSpeed();
		/**
		 * Used to acquire the measured power consumption of the outdoor unit.<br>0x0000 to 0xFFFD (0 to 65533W)
		 */
		public Informer reqInformMeasuredPowerConsumptionOfOutdoorUnit();
		/**
		 * Used to acquire the measured temperature of the outdoor air.<br>0xF554 to 0x7FFD (-273,2 to 3276.5��C)
		 */
		public Informer reqInformMeasuredOutdoorAirTemperature2();

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
		public Informer reqInformOperationModeSetting() {
			byte[] edt = getOperationModeSetting();
			addProperty(EPC_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumptionOfOutdoorUnit() {
			byte[] edt = getRatedPowerConsumptionOfOutdoorUnit();
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredElectricCurrentConsumptionOfOutdoorUnit() {
			byte[] edt = getMeasuredElectricCurrentConsumptionOfOutdoorUnit();
			addProperty(EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_OUTDOOR_UNIT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredOutdoorAirTemperature1() {
			byte[] edt = getMeasuredOutdoorAirTemperature1();
			addProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGspecialHState() {
			byte[] edt = getGspecialHState();
			addProperty(EPC_GSPECIAL_H_STATE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOperationStatusOfCompressor() {
			byte[] edt = getOperationStatusOfCompressor();
			addProperty(EPC_OPERATION_STATUS_OF_COMPRESSOR, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOperationModeInformation() {
			byte[] edt = getOperationModeInformation();
			addProperty(EPC_OPERATION_MODE_INFORMATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformFanRotationSpeed() {
			byte[] edt = getFanRotationSpeed();
			addProperty(EPC_FAN_ROTATION_SPEED, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredPowerConsumptionOfOutdoorUnit() {
			byte[] edt = getMeasuredPowerConsumptionOfOutdoorUnit();
			addProperty(EPC_MEASURED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredOutdoorAirTemperature2() {
			byte[] edt = getMeasuredOutdoorAirTemperature2();
			addProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE2, edt, (edt != null && (edt.length == 2)));
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
		public Informer reqInformOperationModeSetting() {
			addProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumptionOfOutdoorUnit() {
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT);
			return this;
		}
		@Override
		public Informer reqInformMeasuredElectricCurrentConsumptionOfOutdoorUnit() {
			addProperty(EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_OUTDOOR_UNIT);
			return this;
		}
		@Override
		public Informer reqInformMeasuredOutdoorAirTemperature1() {
			addProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE1);
			return this;
		}
		@Override
		public Informer reqInformGspecialHState() {
			addProperty(EPC_GSPECIAL_H_STATE);
			return this;
		}
		@Override
		public Informer reqInformOperationStatusOfCompressor() {
			addProperty(EPC_OPERATION_STATUS_OF_COMPRESSOR);
			return this;
		}
		@Override
		public Informer reqInformOperationModeInformation() {
			addProperty(EPC_OPERATION_MODE_INFORMATION);
			return this;
		}
		@Override
		public Informer reqInformFanRotationSpeed() {
			addProperty(EPC_FAN_ROTATION_SPEED);
			return this;
		}
		@Override
		public Informer reqInformMeasuredPowerConsumptionOfOutdoorUnit() {
			addProperty(EPC_MEASURED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT);
			return this;
		}
		@Override
		public Informer reqInformMeasuredOutdoorAirTemperature2() {
			addProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE2);
			return this;
		}

	}
}
