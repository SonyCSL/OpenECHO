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
	
	public static final byte CLASS_GROUP_CODE = (byte)0x01;
	public static final byte CLASS_CODE = (byte)0x46;
	
	public PackageTypeCommercialAirConditionerOutdoorUnit() {
		setReceiver(new Receiver());
	}

	public static final byte EPC_OPERATION_MODE_SETTING = (byte)0xB0;
	public static final byte EPC_RATED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT = (byte)0xB8;
	public static final byte EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_OUTDOOR_UNIT = (byte)0xB9;
	public static final byte EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE1 = (byte)0xBE;
	public static final byte EPC_GSPECIAL_H_STATE = (byte)0xAA;
	public static final byte EPC_OPERATION_STATUS_OF_COMPRESSOR = (byte)0xD0;
	public static final byte EPC_OPERATION_MODE_INFORMATION = (byte)0xD1;
	public static final byte EPC_FAN_ROTATION_SPEED = (byte)0xD2;
	public static final byte EPC_MEASURED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT = (byte)0xDB;
	public static final byte EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE2 = (byte)0xEE;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Used to acquire the current operation mode setting (i.e. �gautomatic,�h �gcooling,�h �gheating,�h �gdehumidification�h or �gair circulator�h).<br><br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br><br>Name : Operation mode setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
	 */
	protected boolean setOperationModeSetting(byte[] edt) {return false;}
	private final boolean _setOperationModeSetting(byte epc, byte[] edt) {
		boolean success = setOperationModeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to acquire the current operation mode setting (i.e. �gautomatic,�h �gcooling,�h �gheating,�h �gdehumidification�h or �gair circulator�h).<br><br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br><br>Name : Operation mode setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
	 */
	protected byte[] getOperationModeSetting() {return null;}
	private final byte[] _getOperationModeSetting(byte epc) {
		byte[] edt = getOperationModeSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the rated power consumption for the cooling, heating and dehumidification modes.<br><br>0x0000 to 0xFFFD (0 to 65533W) Cooling: heating: dehumidification<br><br>Name : Rated power consumption of outdoor unit<br>EPC : 0xB8<br>Data Type : unsigned short x 3<br>Data Size(Byte) : 6 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getRatedPowerConsumptionOfOutdoorUnit() {return null;}
	private final byte[] _getRatedPowerConsumptionOfOutdoorUnit(byte epc) {
		byte[] edt = getRatedPowerConsumptionOfOutdoorUnit();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the measured electric current consumption.<br><br>0x0000 to 0xFFFD (0 to 6553.3A)<br><br>Name : Measured electric current consumption of outdoor unit<br>EPC : 0xB9<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredElectricCurrentConsumptionOfOutdoorUnit() {return null;}
	private final byte[] _getMeasuredElectricCurrentConsumptionOfOutdoorUnit(byte epc) {
		byte[] edt = getMeasuredElectricCurrentConsumptionOfOutdoorUnit();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the measured temperature of the outdoor air.<br><br>0x81 to 0x7D (-127 to 125��C)<br><br>Name : Measured outdoor air temperature 1<br>EPC : 0xBE<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredOutdoorAirTemperature1() {return null;}
	private final byte[] _getMeasuredOutdoorAirTemperature1(byte epc) {
		byte[] edt = getMeasuredOutdoorAirTemperature1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates when the air conditioner is in the �gspecial�h state (i.e. �gdefrosting�h state).<br><br>�gNormal operation�h state = 0x40, �gdefrosting�h state = 0x41<br><br>Name : �gSpecial�h state<br>EPC : 0xAA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getGspecialHState() {return null;}
	private final byte[] _getGspecialHState(byte epc) {
		byte[] edt = getGspecialHState();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the operation status (i.e. ON or OFF) of the compressor.<br><br>Compressor ON: 0x41 Compressor OFF: 0x42<br><br>Name : Operation status of compressor<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getOperationStatusOfCompressor() {return null;}
	private final byte[] _getOperationStatusOfCompressor(byte epc) {
		byte[] edt = getOperationStatusOfCompressor();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the current operation mode (i.e. �gcooling,�h �gheating,�h �gdehumidification�h or �gother�h).<br><br>Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Other: 0x40<br><br>Name : Operation mode information<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getOperationModeInformation();
	private final byte[] _getOperationModeInformation(byte epc) {
		byte[] edt = getOperationModeInformation();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the rotation speed of the fan of the outdoor unit (expressed in %).<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Fan rotation speed<br>EPC : 0xD2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getFanRotationSpeed() {return null;}
	private final byte[] _getFanRotationSpeed(byte epc) {
		byte[] edt = getFanRotationSpeed();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the measured power consumption of the outdoor unit.<br><br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Measured power consumption of outdoor unit<br>EPC : 0xDB<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredPowerConsumptionOfOutdoorUnit() {return null;}
	private final byte[] _getMeasuredPowerConsumptionOfOutdoorUnit(byte epc) {
		byte[] edt = getMeasuredPowerConsumptionOfOutdoorUnit();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the measured temperature of the outdoor air.<br><br>0xF554 to 0x7FFD (-273,2 to 3276.5��C)<br><br>Name : Measured outdoor air temperature 2<br>EPC : 0xEE<br>Data Type : signed short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredOutdoorAirTemperature2() {return null;}
	private final byte[] _getMeasuredOutdoorAirTemperature2(byte epc) {
		byte[] edt = getMeasuredOutdoorAirTemperature2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_OPERATION_MODE_SETTING:
			res.addProperty(epc, edt, _setOperationModeSetting(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_OPERATION_MODE_SETTING:
			edt = _getOperationModeSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RATED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT:
			edt = _getRatedPowerConsumptionOfOutdoorUnit(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 6)));
			break;
		case EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_OUTDOOR_UNIT:
			edt = _getMeasuredElectricCurrentConsumptionOfOutdoorUnit(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE1:
			edt = _getMeasuredOutdoorAirTemperature1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GSPECIAL_H_STATE:
			edt = _getGspecialHState(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OPERATION_STATUS_OF_COMPRESSOR:
			edt = _getOperationStatusOfCompressor(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OPERATION_MODE_INFORMATION:
			edt = _getOperationModeInformation(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_FAN_ROTATION_SPEED:
			edt = _getFanRotationSpeed(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT:
			edt = _getMeasuredPowerConsumptionOfOutdoorUnit(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE2:
			edt = _getMeasuredOutdoorAirTemperature2(epc);
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
			case EPC_OPERATION_MODE_SETTING:
				_onSetOperationModeSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_OPERATION_MODE_SETTING:
				_onGetOperationModeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RATED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT:
				_onGetRatedPowerConsumptionOfOutdoorUnit(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_OUTDOOR_UNIT:
				_onGetMeasuredElectricCurrentConsumptionOfOutdoorUnit(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE1:
				_onGetMeasuredOutdoorAirTemperature1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GSPECIAL_H_STATE:
				_onGetGspecialHState(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OPERATION_STATUS_OF_COMPRESSOR:
				_onGetOperationStatusOfCompressor(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OPERATION_MODE_INFORMATION:
				_onGetOperationModeInformation(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_FAN_ROTATION_SPEED:
				_onGetFanRotationSpeed(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT:
				_onGetMeasuredPowerConsumptionOfOutdoorUnit(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE2:
				_onGetMeasuredOutdoorAirTemperature2(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * Used to acquire the current operation mode setting (i.e. �gautomatic,�h �gcooling,�h �gheating,�h �gdehumidification�h or �gair circulator�h).<br><br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br><br>Name : Operation mode setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		protected void onSetOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOperationModeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to acquire the current operation mode setting (i.e. �gautomatic,�h �gcooling,�h �gheating,�h �gdehumidification�h or �gair circulator�h).<br><br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br><br>Name : Operation mode setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		protected void onGetOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOperationModeSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the rated power consumption for the cooling, heating and dehumidification modes.<br><br>0x0000 to 0xFFFD (0 to 65533W) Cooling: heating: dehumidification<br><br>Name : Rated power consumption of outdoor unit<br>EPC : 0xB8<br>Data Type : unsigned short x 3<br>Data Size(Byte) : 6 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetRatedPowerConsumptionOfOutdoorUnit(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRatedPowerConsumptionOfOutdoorUnit(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRatedPowerConsumptionOfOutdoorUnit(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the measured electric current consumption.<br><br>0x0000 to 0xFFFD (0 to 6553.3A)<br><br>Name : Measured electric current consumption of outdoor unit<br>EPC : 0xB9<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredElectricCurrentConsumptionOfOutdoorUnit(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredElectricCurrentConsumptionOfOutdoorUnit(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredElectricCurrentConsumptionOfOutdoorUnit(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the measured temperature of the outdoor air.<br><br>0x81 to 0x7D (-127 to 125��C)<br><br>Name : Measured outdoor air temperature 1<br>EPC : 0xBE<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredOutdoorAirTemperature1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredOutdoorAirTemperature1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredOutdoorAirTemperature1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates when the air conditioner is in the �gspecial�h state (i.e. �gdefrosting�h state).<br><br>�gNormal operation�h state = 0x40, �gdefrosting�h state = 0x41<br><br>Name : �gSpecial�h state<br>EPC : 0xAA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetGspecialHState(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGspecialHState(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGspecialHState(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the operation status (i.e. ON or OFF) of the compressor.<br><br>Compressor ON: 0x41 Compressor OFF: 0x42<br><br>Name : Operation status of compressor<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetOperationStatusOfCompressor(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOperationStatusOfCompressor(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOperationStatusOfCompressor(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the current operation mode (i.e. �gcooling,�h �gheating,�h �gdehumidification�h or �gother�h).<br><br>Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Other: 0x40<br><br>Name : Operation mode information<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetOperationModeInformation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOperationModeInformation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOperationModeInformation(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the rotation speed of the fan of the outdoor unit (expressed in %).<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Fan rotation speed<br>EPC : 0xD2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetFanRotationSpeed(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetFanRotationSpeed(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetFanRotationSpeed(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the measured power consumption of the outdoor unit.<br><br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Measured power consumption of outdoor unit<br>EPC : 0xDB<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredPowerConsumptionOfOutdoorUnit(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredPowerConsumptionOfOutdoorUnit(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredPowerConsumptionOfOutdoorUnit(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the measured temperature of the outdoor air.<br><br>0xF554 to 0x7FFD (-273,2 to 3276.5��C)<br><br>Name : Measured outdoor air temperature 2<br>EPC : 0xEE<br>Data Type : signed short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredOutdoorAirTemperature2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredOutdoorAirTemperature2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredOutdoorAirTemperature2(eoj, tid, esv, epc, pdc, edt);
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
		 * Used to acquire the current operation mode setting (i.e. �gautomatic,�h �gcooling,�h �gheating,�h �gdehumidification�h or �gair circulator�h).<br><br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br><br>Name : Operation mode setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Setter reqSetOperationModeSetting(byte[] edt) {
			addProperty(EPC_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
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
		 * Used to acquire the current operation mode setting (i.e. �gautomatic,�h �gcooling,�h �gheating,�h �gdehumidification�h or �gair circulator�h).<br><br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br><br>Name : Operation mode setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Getter reqGetOperationModeSetting() {
			addProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		/**
		 * Used to acquire the rated power consumption for the cooling, heating and dehumidification modes.<br><br>0x0000 to 0xFFFD (0 to 65533W) Cooling: heating: dehumidification<br><br>Name : Rated power consumption of outdoor unit<br>EPC : 0xB8<br>Data Type : unsigned short x 3<br>Data Size(Byte) : 6 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetRatedPowerConsumptionOfOutdoorUnit() {
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT);
			return this;
		}
		/**
		 * Used to acquire the measured electric current consumption.<br><br>0x0000 to 0xFFFD (0 to 6553.3A)<br><br>Name : Measured electric current consumption of outdoor unit<br>EPC : 0xB9<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredElectricCurrentConsumptionOfOutdoorUnit() {
			addProperty(EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_OUTDOOR_UNIT);
			return this;
		}
		/**
		 * Used to acquire the measured temperature of the outdoor air.<br><br>0x81 to 0x7D (-127 to 125��C)<br><br>Name : Measured outdoor air temperature 1<br>EPC : 0xBE<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredOutdoorAirTemperature1() {
			addProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE1);
			return this;
		}
		/**
		 * This property indicates when the air conditioner is in the �gspecial�h state (i.e. �gdefrosting�h state).<br><br>�gNormal operation�h state = 0x40, �gdefrosting�h state = 0x41<br><br>Name : �gSpecial�h state<br>EPC : 0xAA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetGspecialHState() {
			addProperty(EPC_GSPECIAL_H_STATE);
			return this;
		}
		/**
		 * Used to acquire the operation status (i.e. ON or OFF) of the compressor.<br><br>Compressor ON: 0x41 Compressor OFF: 0x42<br><br>Name : Operation status of compressor<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetOperationStatusOfCompressor() {
			addProperty(EPC_OPERATION_STATUS_OF_COMPRESSOR);
			return this;
		}
		/**
		 * Used to acquire the current operation mode (i.e. �gcooling,�h �gheating,�h �gdehumidification�h or �gother�h).<br><br>Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Other: 0x40<br><br>Name : Operation mode information<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetOperationModeInformation() {
			addProperty(EPC_OPERATION_MODE_INFORMATION);
			return this;
		}
		/**
		 * Used to acquire the rotation speed of the fan of the outdoor unit (expressed in %).<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Fan rotation speed<br>EPC : 0xD2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetFanRotationSpeed() {
			addProperty(EPC_FAN_ROTATION_SPEED);
			return this;
		}
		/**
		 * Used to acquire the measured power consumption of the outdoor unit.<br><br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Measured power consumption of outdoor unit<br>EPC : 0xDB<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredPowerConsumptionOfOutdoorUnit() {
			addProperty(EPC_MEASURED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT);
			return this;
		}
		/**
		 * Used to acquire the measured temperature of the outdoor air.<br><br>0xF554 to 0x7FFD (-273,2 to 3276.5��C)<br><br>Name : Measured outdoor air temperature 2<br>EPC : 0xEE<br>Data Type : signed short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredOutdoorAirTemperature2() {
			addProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE2);
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
		 * Used to acquire the current operation mode setting (i.e. �gautomatic,�h �gcooling,�h �gheating,�h �gdehumidification�h or �gair circulator�h).<br><br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br><br>Name : Operation mode setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Informer reqInformOperationModeSetting();
		/**
		 * Used to acquire the rated power consumption for the cooling, heating and dehumidification modes.<br><br>0x0000 to 0xFFFD (0 to 65533W) Cooling: heating: dehumidification<br><br>Name : Rated power consumption of outdoor unit<br>EPC : 0xB8<br>Data Type : unsigned short x 3<br>Data Size(Byte) : 6 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformRatedPowerConsumptionOfOutdoorUnit();
		/**
		 * Used to acquire the measured electric current consumption.<br><br>0x0000 to 0xFFFD (0 to 6553.3A)<br><br>Name : Measured electric current consumption of outdoor unit<br>EPC : 0xB9<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredElectricCurrentConsumptionOfOutdoorUnit();
		/**
		 * Used to acquire the measured temperature of the outdoor air.<br><br>0x81 to 0x7D (-127 to 125��C)<br><br>Name : Measured outdoor air temperature 1<br>EPC : 0xBE<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredOutdoorAirTemperature1();
		/**
		 * This property indicates when the air conditioner is in the �gspecial�h state (i.e. �gdefrosting�h state).<br><br>�gNormal operation�h state = 0x40, �gdefrosting�h state = 0x41<br><br>Name : �gSpecial�h state<br>EPC : 0xAA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformGspecialHState();
		/**
		 * Used to acquire the operation status (i.e. ON or OFF) of the compressor.<br><br>Compressor ON: 0x41 Compressor OFF: 0x42<br><br>Name : Operation status of compressor<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformOperationStatusOfCompressor();
		/**
		 * Used to acquire the current operation mode (i.e. �gcooling,�h �gheating,�h �gdehumidification�h or �gother�h).<br><br>Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Other: 0x40<br><br>Name : Operation mode information<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformOperationModeInformation();
		/**
		 * Used to acquire the rotation speed of the fan of the outdoor unit (expressed in %).<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Fan rotation speed<br>EPC : 0xD2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformFanRotationSpeed();
		/**
		 * Used to acquire the measured power consumption of the outdoor unit.<br><br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Measured power consumption of outdoor unit<br>EPC : 0xDB<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredPowerConsumptionOfOutdoorUnit();
		/**
		 * Used to acquire the measured temperature of the outdoor air.<br><br>0xF554 to 0x7FFD (-273,2 to 3276.5��C)<br><br>Name : Measured outdoor air temperature 2<br>EPC : 0xEE<br>Data Type : signed short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredOutdoorAirTemperature2();
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
		public Informer reqInformOperationModeSetting() {
			byte epc = EPC_OPERATION_MODE_SETTING;
			byte[] edt = _getOperationModeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumptionOfOutdoorUnit() {
			byte epc = EPC_RATED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT;
			byte[] edt = _getRatedPowerConsumptionOfOutdoorUnit(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredElectricCurrentConsumptionOfOutdoorUnit() {
			byte epc = EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_OUTDOOR_UNIT;
			byte[] edt = _getMeasuredElectricCurrentConsumptionOfOutdoorUnit(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredOutdoorAirTemperature1() {
			byte epc = EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE1;
			byte[] edt = _getMeasuredOutdoorAirTemperature1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGspecialHState() {
			byte epc = EPC_GSPECIAL_H_STATE;
			byte[] edt = _getGspecialHState(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOperationStatusOfCompressor() {
			byte epc = EPC_OPERATION_STATUS_OF_COMPRESSOR;
			byte[] edt = _getOperationStatusOfCompressor(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOperationModeInformation() {
			byte epc = EPC_OPERATION_MODE_INFORMATION;
			byte[] edt = _getOperationModeInformation(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformFanRotationSpeed() {
			byte epc = EPC_FAN_ROTATION_SPEED;
			byte[] edt = _getFanRotationSpeed(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredPowerConsumptionOfOutdoorUnit() {
			byte epc = EPC_MEASURED_POWER_CONSUMPTION_OF_OUTDOOR_UNIT;
			byte[] edt = _getMeasuredPowerConsumptionOfOutdoorUnit(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredOutdoorAirTemperature2() {
			byte epc = EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE2;
			byte[] edt = _getMeasuredOutdoorAirTemperature2(epc);
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
