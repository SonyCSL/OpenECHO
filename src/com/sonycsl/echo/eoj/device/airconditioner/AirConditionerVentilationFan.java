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

public abstract class AirConditionerVentilationFan extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = AirConditionerVentilationFan.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x01;
	public static final byte CLASS_CODE = (byte)0x34;

	protected static final byte EPC_SET_VALUE_OF_ROOM_RELATIVE_HUMIDITY = (byte)0xB4;
	protected static final byte EPC_VENTILATION_AUTO_SETTING = (byte)0xBF;
	protected static final byte EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY = (byte)0xBA;
	protected static final byte EPC_SET_VALUE_OF_VENTILATION_AIR_FLOW_RATE = (byte)0xA0;
	protected static final byte EPC_HEAT_EXCHANGER_OPERATION_SETTING = (byte)0xE0;
	protected static final byte EPC_MEASURED_VALUE_OF_CO2_CONCENTRATION = (byte)0xC0;
	protected static final byte EPC_SMOKE_CIGARETTE_DETECTION_STATUS = (byte)0xC1;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Set value of relative humidity at auto ventilating operation.<br>0x00.0x64, (0.100%)
	 */
	protected boolean setSetValueOfRoomRelativeHumidity(byte[] edt) {return false;}
	/**
	 * Set value of relative humidity at auto ventilating operation.<br>0x00.0x64, (0.100%)
	 */
	protected byte[] getSetValueOfRoomRelativeHumidity() {return null;}
	/**
	 * Auto/Non-auto<br>Auto = 0x41, Non-auto = 0x42
	 */
	protected boolean setVentilationAutoSetting(byte[] edt) {return false;}
	/**
	 * Auto/Non-auto<br>Auto = 0x41, Non-auto = 0x42
	 */
	protected byte[] getVentilationAutoSetting() {return null;}
	/**
	 * Measured value of room relative humidity<br>0x00.0x64 (0.100%)
	 */
	protected byte[] getMeasuredValueOfRoomRelativeHumidity() {return null;}
	/**
	 * Sets ventilation air flow rate level and ventilation air flow rate auto status. This property specifies ventilation air flow rate level (8-step).<br>Ventilation air flow rate auto status = 0x41 Ventilation air flow rate level = 0x31.0x38
	 */
	protected boolean setSetValueOfVentilationAirFlowRate(byte[] edt) {return false;}
	/**
	 * Sets ventilation air flow rate level and ventilation air flow rate auto status. This property specifies ventilation air flow rate level (8-step).<br>Ventilation air flow rate auto status = 0x41 Ventilation air flow rate level = 0x31.0x38
	 */
	protected byte[] getSetValueOfVentilationAirFlowRate() {return null;}
	/**
	 * This property indicates ON/OFF status of heat exchanger.<br>Heat exchanger ON = 0x41, OFF��0x42
	 */
	protected boolean setHeatExchangerOperationSetting(byte[] edt) {return false;}
	/**
	 * This property indicates ON/OFF status of heat exchanger.<br>Heat exchanger ON = 0x41, OFF��0x42
	 */
	protected byte[] getHeatExchangerOperationSetting() {return null;}
	/**
	 * This property indicates measured value of CO2 concentration in ppm.<br>0x0000.0xFFFD (0.65533 ppm)
	 */
	protected byte[] getMeasuredValueOfCo2Concentration() {return null;}
	/**
	 * This property indicates smoke (cigarette) detection status.<br>Smoke (cigarette) detection status found = 0x41 Smoke (cigarette) detection status not found = 0x42
	 */
	protected byte[] getSmokeCigaretteDetectionStatus() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_SET_VALUE_OF_ROOM_RELATIVE_HUMIDITY:
			res.addProperty(epc, edt, setSetValueOfRoomRelativeHumidity(edt));
			break;
		case EPC_VENTILATION_AUTO_SETTING:
			res.addProperty(epc, edt, setVentilationAutoSetting(edt));
			break;
		case EPC_SET_VALUE_OF_VENTILATION_AIR_FLOW_RATE:
			res.addProperty(epc, edt, setSetValueOfVentilationAirFlowRate(edt));
			break;
		case EPC_HEAT_EXCHANGER_OPERATION_SETTING:
			res.addProperty(epc, edt, setHeatExchangerOperationSetting(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_SET_VALUE_OF_ROOM_RELATIVE_HUMIDITY:
			edt = getSetValueOfRoomRelativeHumidity();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VENTILATION_AUTO_SETTING:
			edt = getVentilationAutoSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY:
			edt = getMeasuredValueOfRoomRelativeHumidity();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_VALUE_OF_VENTILATION_AIR_FLOW_RATE:
			edt = getSetValueOfVentilationAirFlowRate();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HEAT_EXCHANGER_OPERATION_SETTING:
			edt = getHeatExchangerOperationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_VALUE_OF_CO2_CONCENTRATION:
			edt = getMeasuredValueOfCo2Concentration();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_SMOKE_CIGARETTE_DETECTION_STATUS:
			edt = getSmokeCigaretteDetectionStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
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
			case EPC_SET_VALUE_OF_ROOM_RELATIVE_HUMIDITY:
				onSetSetValueOfRoomRelativeHumidity(eoj, tid, (pdc != 0));
				break;
			case EPC_VENTILATION_AUTO_SETTING:
				onSetVentilationAutoSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_SET_VALUE_OF_VENTILATION_AIR_FLOW_RATE:
				onSetSetValueOfVentilationAirFlowRate(eoj, tid, (pdc != 0));
				break;
			case EPC_HEAT_EXCHANGER_OPERATION_SETTING:
				onSetHeatExchangerOperationSetting(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_SET_VALUE_OF_ROOM_RELATIVE_HUMIDITY:
				onGetSetValueOfRoomRelativeHumidity(eoj, tid, pdc, edt);
				break;
			case EPC_VENTILATION_AUTO_SETTING:
				onGetVentilationAutoSetting(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY:
				onGetMeasuredValueOfRoomRelativeHumidity(eoj, tid, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_VENTILATION_AIR_FLOW_RATE:
				onGetSetValueOfVentilationAirFlowRate(eoj, tid, pdc, edt);
				break;
			case EPC_HEAT_EXCHANGER_OPERATION_SETTING:
				onGetHeatExchangerOperationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_VALUE_OF_CO2_CONCENTRATION:
				onGetMeasuredValueOfCo2Concentration(eoj, tid, pdc, edt);
				break;
			case EPC_SMOKE_CIGARETTE_DETECTION_STATUS:
				onGetSmokeCigaretteDetectionStatus(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * Set value of relative humidity at auto ventilating operation.<br>0x00.0x64, (0.100%)
		 */
		protected void onSetSetValueOfRoomRelativeHumidity(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Set value of relative humidity at auto ventilating operation.<br>0x00.0x64, (0.100%)
		 */
		protected void onGetSetValueOfRoomRelativeHumidity(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Auto/Non-auto<br>Auto = 0x41, Non-auto = 0x42
		 */
		protected void onSetVentilationAutoSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Auto/Non-auto<br>Auto = 0x41, Non-auto = 0x42
		 */
		protected void onGetVentilationAutoSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Measured value of room relative humidity<br>0x00.0x64 (0.100%)
		 */
		protected void onGetMeasuredValueOfRoomRelativeHumidity(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets ventilation air flow rate level and ventilation air flow rate auto status. This property specifies ventilation air flow rate level (8-step).<br>Ventilation air flow rate auto status = 0x41 Ventilation air flow rate level = 0x31.0x38
		 */
		protected void onSetSetValueOfVentilationAirFlowRate(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets ventilation air flow rate level and ventilation air flow rate auto status. This property specifies ventilation air flow rate level (8-step).<br>Ventilation air flow rate auto status = 0x41 Ventilation air flow rate level = 0x31.0x38
		 */
		protected void onGetSetValueOfVentilationAirFlowRate(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates ON/OFF status of heat exchanger.<br>Heat exchanger ON = 0x41, OFF��0x42
		 */
		protected void onSetHeatExchangerOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates ON/OFF status of heat exchanger.<br>Heat exchanger ON = 0x41, OFF��0x42
		 */
		protected void onGetHeatExchangerOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates measured value of CO2 concentration in ppm.<br>0x0000.0xFFFD (0.65533 ppm)
		 */
		protected void onGetMeasuredValueOfCo2Concentration(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates smoke (cigarette) detection status.<br>Smoke (cigarette) detection status found = 0x41 Smoke (cigarette) detection status not found = 0x42
		 */
		protected void onGetSmokeCigaretteDetectionStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Set value of relative humidity at auto ventilating operation.<br>0x00.0x64, (0.100%)
		 */
		public Setter reqSetSetValueOfRoomRelativeHumidity(byte[] edt);
		/**
		 * Auto/Non-auto<br>Auto = 0x41, Non-auto = 0x42
		 */
		public Setter reqSetVentilationAutoSetting(byte[] edt);
		/**
		 * Sets ventilation air flow rate level and ventilation air flow rate auto status. This property specifies ventilation air flow rate level (8-step).<br>Ventilation air flow rate auto status = 0x41 Ventilation air flow rate level = 0x31.0x38
		 */
		public Setter reqSetSetValueOfVentilationAirFlowRate(byte[] edt);
		/**
		 * This property indicates ON/OFF status of heat exchanger.<br>Heat exchanger ON = 0x41, OFF��0x42
		 */
		public Setter reqSetHeatExchangerOperationSetting(byte[] edt);

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
		public Setter reqSetSetValueOfRoomRelativeHumidity(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_ROOM_RELATIVE_HUMIDITY, edt, setSetValueOfRoomRelativeHumidity(edt));
			return this;
		}
		@Override
		public Setter reqSetVentilationAutoSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_AUTO_SETTING, edt, setVentilationAutoSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfVentilationAirFlowRate(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_VENTILATION_AIR_FLOW_RATE, edt, setSetValueOfVentilationAirFlowRate(edt));
			return this;
		}
		@Override
		public Setter reqSetHeatExchangerOperationSetting(byte[] edt) {
			addProperty(EPC_HEAT_EXCHANGER_OPERATION_SETTING, edt, setHeatExchangerOperationSetting(edt));
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
		public Setter reqSetSetValueOfRoomRelativeHumidity(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_ROOM_RELATIVE_HUMIDITY, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetVentilationAutoSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_AUTO_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfVentilationAirFlowRate(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_VENTILATION_AIR_FLOW_RATE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetHeatExchangerOperationSetting(byte[] edt) {
			addProperty(EPC_HEAT_EXCHANGER_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
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
		 * Set value of relative humidity at auto ventilating operation.<br>0x00.0x64, (0.100%)
		 */
		public Getter reqGetSetValueOfRoomRelativeHumidity();
		/**
		 * Auto/Non-auto<br>Auto = 0x41, Non-auto = 0x42
		 */
		public Getter reqGetVentilationAutoSetting();
		/**
		 * Measured value of room relative humidity<br>0x00.0x64 (0.100%)
		 */
		public Getter reqGetMeasuredValueOfRoomRelativeHumidity();
		/**
		 * Sets ventilation air flow rate level and ventilation air flow rate auto status. This property specifies ventilation air flow rate level (8-step).<br>Ventilation air flow rate auto status = 0x41 Ventilation air flow rate level = 0x31.0x38
		 */
		public Getter reqGetSetValueOfVentilationAirFlowRate();
		/**
		 * This property indicates ON/OFF status of heat exchanger.<br>Heat exchanger ON = 0x41, OFF��0x42
		 */
		public Getter reqGetHeatExchangerOperationSetting();
		/**
		 * This property indicates measured value of CO2 concentration in ppm.<br>0x0000.0xFFFD (0.65533 ppm)
		 */
		public Getter reqGetMeasuredValueOfCo2Concentration();
		/**
		 * This property indicates smoke (cigarette) detection status.<br>Smoke (cigarette) detection status found = 0x41 Smoke (cigarette) detection status not found = 0x42
		 */
		public Getter reqGetSmokeCigaretteDetectionStatus();

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
		public Getter reqGetSetValueOfRoomRelativeHumidity() {
			byte[] edt = getSetValueOfRoomRelativeHumidity();
			addProperty(EPC_SET_VALUE_OF_ROOM_RELATIVE_HUMIDITY, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetVentilationAutoSetting() {
			byte[] edt = getVentilationAutoSetting();
			addProperty(EPC_VENTILATION_AUTO_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredValueOfRoomRelativeHumidity() {
			byte[] edt = getMeasuredValueOfRoomRelativeHumidity();
			addProperty(EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSetValueOfVentilationAirFlowRate() {
			byte[] edt = getSetValueOfVentilationAirFlowRate();
			addProperty(EPC_SET_VALUE_OF_VENTILATION_AIR_FLOW_RATE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHeatExchangerOperationSetting() {
			byte[] edt = getHeatExchangerOperationSetting();
			addProperty(EPC_HEAT_EXCHANGER_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredValueOfCo2Concentration() {
			byte[] edt = getMeasuredValueOfCo2Concentration();
			addProperty(EPC_MEASURED_VALUE_OF_CO2_CONCENTRATION, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetSmokeCigaretteDetectionStatus() {
			byte[] edt = getSmokeCigaretteDetectionStatus();
			addProperty(EPC_SMOKE_CIGARETTE_DETECTION_STATUS, edt, (edt != null && (edt.length == 1)));
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
		public Getter reqGetSetValueOfRoomRelativeHumidity() {
			addProperty(EPC_SET_VALUE_OF_ROOM_RELATIVE_HUMIDITY);
			return this;
		}
		@Override
		public Getter reqGetVentilationAutoSetting() {
			addProperty(EPC_VENTILATION_AUTO_SETTING);
			return this;
		}
		@Override
		public Getter reqGetMeasuredValueOfRoomRelativeHumidity() {
			addProperty(EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY);
			return this;
		}
		@Override
		public Getter reqGetSetValueOfVentilationAirFlowRate() {
			addProperty(EPC_SET_VALUE_OF_VENTILATION_AIR_FLOW_RATE);
			return this;
		}
		@Override
		public Getter reqGetHeatExchangerOperationSetting() {
			addProperty(EPC_HEAT_EXCHANGER_OPERATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetMeasuredValueOfCo2Concentration() {
			addProperty(EPC_MEASURED_VALUE_OF_CO2_CONCENTRATION);
			return this;
		}
		@Override
		public Getter reqGetSmokeCigaretteDetectionStatus() {
			addProperty(EPC_SMOKE_CIGARETTE_DETECTION_STATUS);
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
		 * Set value of relative humidity at auto ventilating operation.<br>0x00.0x64, (0.100%)
		 */
		public Informer reqInformSetValueOfRoomRelativeHumidity();
		/**
		 * Auto/Non-auto<br>Auto = 0x41, Non-auto = 0x42
		 */
		public Informer reqInformVentilationAutoSetting();
		/**
		 * Measured value of room relative humidity<br>0x00.0x64 (0.100%)
		 */
		public Informer reqInformMeasuredValueOfRoomRelativeHumidity();
		/**
		 * Sets ventilation air flow rate level and ventilation air flow rate auto status. This property specifies ventilation air flow rate level (8-step).<br>Ventilation air flow rate auto status = 0x41 Ventilation air flow rate level = 0x31.0x38
		 */
		public Informer reqInformSetValueOfVentilationAirFlowRate();
		/**
		 * This property indicates ON/OFF status of heat exchanger.<br>Heat exchanger ON = 0x41, OFF��0x42
		 */
		public Informer reqInformHeatExchangerOperationSetting();
		/**
		 * This property indicates measured value of CO2 concentration in ppm.<br>0x0000.0xFFFD (0.65533 ppm)
		 */
		public Informer reqInformMeasuredValueOfCo2Concentration();
		/**
		 * This property indicates smoke (cigarette) detection status.<br>Smoke (cigarette) detection status found = 0x41 Smoke (cigarette) detection status not found = 0x42
		 */
		public Informer reqInformSmokeCigaretteDetectionStatus();

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
		public Informer reqInformSetValueOfRoomRelativeHumidity() {
			byte[] edt = getSetValueOfRoomRelativeHumidity();
			addProperty(EPC_SET_VALUE_OF_ROOM_RELATIVE_HUMIDITY, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformVentilationAutoSetting() {
			byte[] edt = getVentilationAutoSetting();
			addProperty(EPC_VENTILATION_AUTO_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredValueOfRoomRelativeHumidity() {
			byte[] edt = getMeasuredValueOfRoomRelativeHumidity();
			addProperty(EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfVentilationAirFlowRate() {
			byte[] edt = getSetValueOfVentilationAirFlowRate();
			addProperty(EPC_SET_VALUE_OF_VENTILATION_AIR_FLOW_RATE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHeatExchangerOperationSetting() {
			byte[] edt = getHeatExchangerOperationSetting();
			addProperty(EPC_HEAT_EXCHANGER_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredValueOfCo2Concentration() {
			byte[] edt = getMeasuredValueOfCo2Concentration();
			addProperty(EPC_MEASURED_VALUE_OF_CO2_CONCENTRATION, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformSmokeCigaretteDetectionStatus() {
			byte[] edt = getSmokeCigaretteDetectionStatus();
			addProperty(EPC_SMOKE_CIGARETTE_DETECTION_STATUS, edt, (edt != null && (edt.length == 1)));
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
		public Informer reqInformSetValueOfRoomRelativeHumidity() {
			addProperty(EPC_SET_VALUE_OF_ROOM_RELATIVE_HUMIDITY);
			return this;
		}
		@Override
		public Informer reqInformVentilationAutoSetting() {
			addProperty(EPC_VENTILATION_AUTO_SETTING);
			return this;
		}
		@Override
		public Informer reqInformMeasuredValueOfRoomRelativeHumidity() {
			addProperty(EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY);
			return this;
		}
		@Override
		public Informer reqInformSetValueOfVentilationAirFlowRate() {
			addProperty(EPC_SET_VALUE_OF_VENTILATION_AIR_FLOW_RATE);
			return this;
		}
		@Override
		public Informer reqInformHeatExchangerOperationSetting() {
			addProperty(EPC_HEAT_EXCHANGER_OPERATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformMeasuredValueOfCo2Concentration() {
			addProperty(EPC_MEASURED_VALUE_OF_CO2_CONCENTRATION);
			return this;
		}
		@Override
		public Informer reqInformSmokeCigaretteDetectionStatus() {
			addProperty(EPC_SMOKE_CIGARETTE_DETECTION_STATUS);
			return this;
		}

	}
}
