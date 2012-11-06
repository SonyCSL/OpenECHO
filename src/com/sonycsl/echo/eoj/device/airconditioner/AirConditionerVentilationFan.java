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
	
	public static final byte CLASS_GROUP_CODE = (byte)0x01;
	public static final byte CLASS_CODE = (byte)0x34;
	
	public AirConditionerVentilationFan() {
		setReceiver(new Receiver());
	}

	public static final byte EPC_SET_VALUE_OF_ROOM_RELATIVE_HUMIDITY = (byte)0xB4;
	public static final byte EPC_VENTILATION_AUTO_SETTING = (byte)0xBF;
	public static final byte EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY = (byte)0xBA;
	public static final byte EPC_SET_VALUE_OF_VENTILATION_AIR_FLOW_RATE = (byte)0xA0;
	public static final byte EPC_HEAT_EXCHANGER_OPERATION_SETTING = (byte)0xE0;
	public static final byte EPC_MEASURED_VALUE_OF_CO2_CONCENTRATION = (byte)0xC0;
	public static final byte EPC_SMOKE_CIGARETTE_DETECTION_STATUS = (byte)0xC1;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Set value of relative humidity at auto ventilating operation.<br><br>0x00.0x64, (0.100%)<br><br>Name : Set value of room relative humidity<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSetValueOfRoomRelativeHumidity(byte[] edt) {return false;}
	private final boolean _setSetValueOfRoomRelativeHumidity(byte epc, byte[] edt) {
		boolean success = setSetValueOfRoomRelativeHumidity(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Set value of relative humidity at auto ventilating operation.<br><br>0x00.0x64, (0.100%)<br><br>Name : Set value of room relative humidity<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSetValueOfRoomRelativeHumidity() {return null;}
	private final byte[] _getSetValueOfRoomRelativeHumidity(byte epc) {
		byte[] edt = getSetValueOfRoomRelativeHumidity();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Auto/Non-auto<br><br>Auto = 0x41, Non-auto = 0x42<br><br>Name : Ventilation auto setting<br>EPC : 0xBF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setVentilationAutoSetting(byte[] edt) {return false;}
	private final boolean _setVentilationAutoSetting(byte epc, byte[] edt) {
		boolean success = setVentilationAutoSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Auto/Non-auto<br><br>Auto = 0x41, Non-auto = 0x42<br><br>Name : Ventilation auto setting<br>EPC : 0xBF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getVentilationAutoSetting() {return null;}
	private final byte[] _getVentilationAutoSetting(byte epc) {
		byte[] edt = getVentilationAutoSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Measured value of room relative humidity<br><br>0x00.0x64 (0.100%)<br><br>Name : Measured value of room relative humidity<br>EPC : 0xBA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredValueOfRoomRelativeHumidity() {return null;}
	private final byte[] _getMeasuredValueOfRoomRelativeHumidity(byte epc) {
		byte[] edt = getMeasuredValueOfRoomRelativeHumidity();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Sets ventilation air flow rate level and ventilation air flow rate auto status. This property specifies ventilation air flow rate level (8-step).<br><br>Ventilation air flow rate auto status = 0x41 Ventilation air flow rate level = 0x31.0x38<br><br>Name : Set value of ventilation air flow rate<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSetValueOfVentilationAirFlowRate(byte[] edt) {return false;}
	private final boolean _setSetValueOfVentilationAirFlowRate(byte epc, byte[] edt) {
		boolean success = setSetValueOfVentilationAirFlowRate(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Sets ventilation air flow rate level and ventilation air flow rate auto status. This property specifies ventilation air flow rate level (8-step).<br><br>Ventilation air flow rate auto status = 0x41 Ventilation air flow rate level = 0x31.0x38<br><br>Name : Set value of ventilation air flow rate<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSetValueOfVentilationAirFlowRate() {return null;}
	private final byte[] _getSetValueOfVentilationAirFlowRate(byte epc) {
		byte[] edt = getSetValueOfVentilationAirFlowRate();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates ON/OFF status of heat exchanger.<br><br>Heat exchanger ON = 0x41, OFF��0x42<br><br>Name : Heat exchanger operation setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setHeatExchangerOperationSetting(byte[] edt) {return false;}
	private final boolean _setHeatExchangerOperationSetting(byte epc, byte[] edt) {
		boolean success = setHeatExchangerOperationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates ON/OFF status of heat exchanger.<br><br>Heat exchanger ON = 0x41, OFF��0x42<br><br>Name : Heat exchanger operation setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getHeatExchangerOperationSetting() {return null;}
	private final byte[] _getHeatExchangerOperationSetting(byte epc) {
		byte[] edt = getHeatExchangerOperationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates measured value of CO2 concentration in ppm.<br><br>0x0000.0xFFFD (0.65533 ppm)<br><br>Name : Measured value of CO2 concentration<br>EPC : 0xC0<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredValueOfCo2Concentration() {return null;}
	private final byte[] _getMeasuredValueOfCo2Concentration(byte epc) {
		byte[] edt = getMeasuredValueOfCo2Concentration();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates smoke (cigarette) detection status.<br><br>Smoke (cigarette) detection status found = 0x41 Smoke (cigarette) detection status not found = 0x42<br><br>Name : Smoke (cigarette) detection status<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getSmokeCigaretteDetectionStatus() {return null;}
	private final byte[] _getSmokeCigaretteDetectionStatus(byte epc) {
		byte[] edt = getSmokeCigaretteDetectionStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_SET_VALUE_OF_ROOM_RELATIVE_HUMIDITY:
			res.addProperty(epc, edt, _setSetValueOfRoomRelativeHumidity(epc, edt));
			break;
		case EPC_VENTILATION_AUTO_SETTING:
			res.addProperty(epc, edt, _setVentilationAutoSetting(epc, edt));
			break;
		case EPC_SET_VALUE_OF_VENTILATION_AIR_FLOW_RATE:
			res.addProperty(epc, edt, _setSetValueOfVentilationAirFlowRate(epc, edt));
			break;
		case EPC_HEAT_EXCHANGER_OPERATION_SETTING:
			res.addProperty(epc, edt, _setHeatExchangerOperationSetting(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_SET_VALUE_OF_ROOM_RELATIVE_HUMIDITY:
			edt = _getSetValueOfRoomRelativeHumidity(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VENTILATION_AUTO_SETTING:
			edt = _getVentilationAutoSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY:
			edt = _getMeasuredValueOfRoomRelativeHumidity(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_VALUE_OF_VENTILATION_AIR_FLOW_RATE:
			edt = _getSetValueOfVentilationAirFlowRate(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HEAT_EXCHANGER_OPERATION_SETTING:
			edt = _getHeatExchangerOperationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_VALUE_OF_CO2_CONCENTRATION:
			edt = _getMeasuredValueOfCo2Concentration(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_SMOKE_CIGARETTE_DETECTION_STATUS:
			edt = _getSmokeCigaretteDetectionStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
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
			case EPC_SET_VALUE_OF_ROOM_RELATIVE_HUMIDITY:
				_onSetSetValueOfRoomRelativeHumidity(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_VENTILATION_AUTO_SETTING:
				_onSetVentilationAutoSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_SET_VALUE_OF_VENTILATION_AIR_FLOW_RATE:
				_onSetSetValueOfVentilationAirFlowRate(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_HEAT_EXCHANGER_OPERATION_SETTING:
				_onSetHeatExchangerOperationSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_SET_VALUE_OF_ROOM_RELATIVE_HUMIDITY:
				_onGetSetValueOfRoomRelativeHumidity(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_VENTILATION_AUTO_SETTING:
				_onGetVentilationAutoSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY:
				_onGetMeasuredValueOfRoomRelativeHumidity(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_VENTILATION_AIR_FLOW_RATE:
				_onGetSetValueOfVentilationAirFlowRate(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HEAT_EXCHANGER_OPERATION_SETTING:
				_onGetHeatExchangerOperationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_VALUE_OF_CO2_CONCENTRATION:
				_onGetMeasuredValueOfCo2Concentration(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SMOKE_CIGARETTE_DETECTION_STATUS:
				_onGetSmokeCigaretteDetectionStatus(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * Set value of relative humidity at auto ventilating operation.<br><br>0x00.0x64, (0.100%)<br><br>Name : Set value of room relative humidity<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSetValueOfRoomRelativeHumidity(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSetValueOfRoomRelativeHumidity(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSetValueOfRoomRelativeHumidity(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Set value of relative humidity at auto ventilating operation.<br><br>0x00.0x64, (0.100%)<br><br>Name : Set value of room relative humidity<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSetValueOfRoomRelativeHumidity(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetValueOfRoomRelativeHumidity(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetValueOfRoomRelativeHumidity(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Auto/Non-auto<br><br>Auto = 0x41, Non-auto = 0x42<br><br>Name : Ventilation auto setting<br>EPC : 0xBF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetVentilationAutoSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetVentilationAutoSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetVentilationAutoSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Auto/Non-auto<br><br>Auto = 0x41, Non-auto = 0x42<br><br>Name : Ventilation auto setting<br>EPC : 0xBF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetVentilationAutoSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetVentilationAutoSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetVentilationAutoSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Measured value of room relative humidity<br><br>0x00.0x64 (0.100%)<br><br>Name : Measured value of room relative humidity<br>EPC : 0xBA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredValueOfRoomRelativeHumidity(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredValueOfRoomRelativeHumidity(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredValueOfRoomRelativeHumidity(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets ventilation air flow rate level and ventilation air flow rate auto status. This property specifies ventilation air flow rate level (8-step).<br><br>Ventilation air flow rate auto status = 0x41 Ventilation air flow rate level = 0x31.0x38<br><br>Name : Set value of ventilation air flow rate<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSetValueOfVentilationAirFlowRate(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSetValueOfVentilationAirFlowRate(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSetValueOfVentilationAirFlowRate(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets ventilation air flow rate level and ventilation air flow rate auto status. This property specifies ventilation air flow rate level (8-step).<br><br>Ventilation air flow rate auto status = 0x41 Ventilation air flow rate level = 0x31.0x38<br><br>Name : Set value of ventilation air flow rate<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSetValueOfVentilationAirFlowRate(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetValueOfVentilationAirFlowRate(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetValueOfVentilationAirFlowRate(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates ON/OFF status of heat exchanger.<br><br>Heat exchanger ON = 0x41, OFF��0x42<br><br>Name : Heat exchanger operation setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetHeatExchangerOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetHeatExchangerOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetHeatExchangerOperationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates ON/OFF status of heat exchanger.<br><br>Heat exchanger ON = 0x41, OFF��0x42<br><br>Name : Heat exchanger operation setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetHeatExchangerOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHeatExchangerOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHeatExchangerOperationSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates measured value of CO2 concentration in ppm.<br><br>0x0000.0xFFFD (0.65533 ppm)<br><br>Name : Measured value of CO2 concentration<br>EPC : 0xC0<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredValueOfCo2Concentration(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredValueOfCo2Concentration(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredValueOfCo2Concentration(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates smoke (cigarette) detection status.<br><br>Smoke (cigarette) detection status found = 0x41 Smoke (cigarette) detection status not found = 0x42<br><br>Name : Smoke (cigarette) detection status<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetSmokeCigaretteDetectionStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSmokeCigaretteDetectionStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSmokeCigaretteDetectionStatus(eoj, tid, esv, epc, pdc, edt);
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

		/**
		 * Set value of relative humidity at auto ventilating operation.<br><br>0x00.0x64, (0.100%)<br><br>Name : Set value of room relative humidity<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSetValueOfRoomRelativeHumidity(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_ROOM_RELATIVE_HUMIDITY, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Auto/Non-auto<br><br>Auto = 0x41, Non-auto = 0x42<br><br>Name : Ventilation auto setting<br>EPC : 0xBF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetVentilationAutoSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_AUTO_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Sets ventilation air flow rate level and ventilation air flow rate auto status. This property specifies ventilation air flow rate level (8-step).<br><br>Ventilation air flow rate auto status = 0x41 Ventilation air flow rate level = 0x31.0x38<br><br>Name : Set value of ventilation air flow rate<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSetValueOfVentilationAirFlowRate(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_VENTILATION_AIR_FLOW_RATE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * This property indicates ON/OFF status of heat exchanger.<br><br>Heat exchanger ON = 0x41, OFF��0x42<br><br>Name : Heat exchanger operation setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetHeatExchangerOperationSetting(byte[] edt) {
			addProperty(EPC_HEAT_EXCHANGER_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
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
		 * Set value of relative humidity at auto ventilating operation.<br><br>0x00.0x64, (0.100%)<br><br>Name : Set value of room relative humidity<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSetValueOfRoomRelativeHumidity() {
			addProperty(EPC_SET_VALUE_OF_ROOM_RELATIVE_HUMIDITY);
			return this;
		}
		/**
		 * Auto/Non-auto<br><br>Auto = 0x41, Non-auto = 0x42<br><br>Name : Ventilation auto setting<br>EPC : 0xBF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetVentilationAutoSetting() {
			addProperty(EPC_VENTILATION_AUTO_SETTING);
			return this;
		}
		/**
		 * Measured value of room relative humidity<br><br>0x00.0x64 (0.100%)<br><br>Name : Measured value of room relative humidity<br>EPC : 0xBA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredValueOfRoomRelativeHumidity() {
			addProperty(EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY);
			return this;
		}
		/**
		 * Sets ventilation air flow rate level and ventilation air flow rate auto status. This property specifies ventilation air flow rate level (8-step).<br><br>Ventilation air flow rate auto status = 0x41 Ventilation air flow rate level = 0x31.0x38<br><br>Name : Set value of ventilation air flow rate<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSetValueOfVentilationAirFlowRate() {
			addProperty(EPC_SET_VALUE_OF_VENTILATION_AIR_FLOW_RATE);
			return this;
		}
		/**
		 * This property indicates ON/OFF status of heat exchanger.<br><br>Heat exchanger ON = 0x41, OFF��0x42<br><br>Name : Heat exchanger operation setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetHeatExchangerOperationSetting() {
			addProperty(EPC_HEAT_EXCHANGER_OPERATION_SETTING);
			return this;
		}
		/**
		 * This property indicates measured value of CO2 concentration in ppm.<br><br>0x0000.0xFFFD (0.65533 ppm)<br><br>Name : Measured value of CO2 concentration<br>EPC : 0xC0<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredValueOfCo2Concentration() {
			addProperty(EPC_MEASURED_VALUE_OF_CO2_CONCENTRATION);
			return this;
		}
		/**
		 * This property indicates smoke (cigarette) detection status.<br><br>Smoke (cigarette) detection status found = 0x41 Smoke (cigarette) detection status not found = 0x42<br><br>Name : Smoke (cigarette) detection status<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetSmokeCigaretteDetectionStatus() {
			addProperty(EPC_SMOKE_CIGARETTE_DETECTION_STATUS);
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
		 * Set value of relative humidity at auto ventilating operation.<br><br>0x00.0x64, (0.100%)<br><br>Name : Set value of room relative humidity<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSetValueOfRoomRelativeHumidity();
		/**
		 * Auto/Non-auto<br><br>Auto = 0x41, Non-auto = 0x42<br><br>Name : Ventilation auto setting<br>EPC : 0xBF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformVentilationAutoSetting();
		/**
		 * Measured value of room relative humidity<br><br>0x00.0x64 (0.100%)<br><br>Name : Measured value of room relative humidity<br>EPC : 0xBA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredValueOfRoomRelativeHumidity();
		/**
		 * Sets ventilation air flow rate level and ventilation air flow rate auto status. This property specifies ventilation air flow rate level (8-step).<br><br>Ventilation air flow rate auto status = 0x41 Ventilation air flow rate level = 0x31.0x38<br><br>Name : Set value of ventilation air flow rate<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSetValueOfVentilationAirFlowRate();
		/**
		 * This property indicates ON/OFF status of heat exchanger.<br><br>Heat exchanger ON = 0x41, OFF��0x42<br><br>Name : Heat exchanger operation setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformHeatExchangerOperationSetting();
		/**
		 * This property indicates measured value of CO2 concentration in ppm.<br><br>0x0000.0xFFFD (0.65533 ppm)<br><br>Name : Measured value of CO2 concentration<br>EPC : 0xC0<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredValueOfCo2Concentration();
		/**
		 * This property indicates smoke (cigarette) detection status.<br><br>Smoke (cigarette) detection status found = 0x41 Smoke (cigarette) detection status not found = 0x42<br><br>Name : Smoke (cigarette) detection status<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformSmokeCigaretteDetectionStatus();
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
		public Informer reqInformSetValueOfRoomRelativeHumidity() {
			byte epc = EPC_SET_VALUE_OF_ROOM_RELATIVE_HUMIDITY;
			byte[] edt = _getSetValueOfRoomRelativeHumidity(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformVentilationAutoSetting() {
			byte epc = EPC_VENTILATION_AUTO_SETTING;
			byte[] edt = _getVentilationAutoSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredValueOfRoomRelativeHumidity() {
			byte epc = EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY;
			byte[] edt = _getMeasuredValueOfRoomRelativeHumidity(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfVentilationAirFlowRate() {
			byte epc = EPC_SET_VALUE_OF_VENTILATION_AIR_FLOW_RATE;
			byte[] edt = _getSetValueOfVentilationAirFlowRate(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHeatExchangerOperationSetting() {
			byte epc = EPC_HEAT_EXCHANGER_OPERATION_SETTING;
			byte[] edt = _getHeatExchangerOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredValueOfCo2Concentration() {
			byte epc = EPC_MEASURED_VALUE_OF_CO2_CONCENTRATION;
			byte[] edt = _getMeasuredValueOfCo2Concentration(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformSmokeCigaretteDetectionStatus() {
			byte epc = EPC_SMOKE_CIGARETTE_DETECTION_STATUS;
			byte[] edt = _getSmokeCigaretteDetectionStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
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
