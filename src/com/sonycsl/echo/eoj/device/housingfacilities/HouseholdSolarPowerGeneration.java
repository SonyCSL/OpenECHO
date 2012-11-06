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

public abstract class HouseholdSolarPowerGeneration extends DeviceObject {
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x79;
	
	public HouseholdSolarPowerGeneration() {
		setReceiver(new Receiver());
	}

	public static final byte EPC_SYSTEM_INTERCONNECTION_STATUS = (byte)0xD0;
	public static final byte EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRICITY_GENERATED = (byte)0xE0;
	public static final byte EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED = (byte)0xE1;
	public static final byte EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED = (byte)0xE2;
	public static final byte EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD = (byte)0xE3;
	public static final byte EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD = (byte)0xE4;
	public static final byte EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1 = (byte)0xE5;
	public static final byte EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2 = (byte)0xE6;
	public static final byte EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD = (byte)0xE7;
	public static final byte EPC_RATED_POWER_GENERATION_OUTPUT = (byte)0xE8;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates system interconnection status<br><br>System-linked type = 0x00 Independent type = 0x01<br><br>Name : System interconnection status<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getSystemInterconnectionStatus() {return null;}
	private final byte[] _getSystemInterconnectionStatus(byte epc) {
		byte[] edt = getSystemInterconnectionStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates instantaneous generated power in W.<br><br>0x0000.0xFFFD (0.65533)<br><br>Name : Measured instantaneous amount of electricity generated<br>EPC : 0xE0<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getMeasuredInstantaneousAmountOfElectricityGenerated();
	private final byte[] _getMeasuredInstantaneousAmountOfElectricityGenerated(byte epc) {
		byte[] edt = getMeasuredInstantaneousAmountOfElectricityGenerated();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates integral electric energy in 0.001 kWh.<br><br>0x0.0x3B9AC9FF (0.999999.999 kWh)<br><br>Name : Measured cumulative amount of electricity generated<br>EPC : 0xE1<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getMeasuredCumulativeAmountOfElectricityGenerated();
	private final byte[] _getMeasuredCumulativeAmountOfElectricityGenerated(byte epc) {
		byte[] edt = getMeasuredCumulativeAmountOfElectricityGenerated();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Resets integral generated electric energy by setting 0x00.<br><br>Reset = 0x00<br><br>Name : Resetting cumulative amount of electricity generated<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : undefined<br>
	 */
	protected boolean setResettingCumulativeAmountOfElectricityGenerated(byte[] edt) {return false;}
	private final boolean _setResettingCumulativeAmountOfElectricityGenerated(byte epc, byte[] edt) {
		boolean success = setResettingCumulativeAmountOfElectricityGenerated(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates integral value of sold power in 0.001 kWh.<br><br>0x0.0x3B9AC9FF (0.999999.999 kWh)<br><br>Name : Measured cumulative amount of electricity sold<br>EPC : 0xE3<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredCumulativeAmountOfElectricitySold() {return null;}
	private final byte[] _getMeasuredCumulativeAmountOfElectricitySold(byte epc) {
		byte[] edt = getMeasuredCumulativeAmountOfElectricitySold();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Resets integral sold electric energy by setting 0x00.<br><br>Reset = 0x00<br><br>Name : Resetting cumulative amount of electricity sold<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : undefined<br>
	 */
	protected boolean setResettingCumulativeAmountOfElectricitySold(byte[] edt) {return false;}
	private final boolean _setResettingCumulativeAmountOfElectricitySold(byte epc, byte[] edt) {
		boolean success = setResettingCumulativeAmountOfElectricitySold(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Power generation output limit setting 1<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setPowerGenerationOutputLimitSetting1(byte[] edt) {return false;}
	private final boolean _setPowerGenerationOutputLimitSetting1(byte epc, byte[] edt) {
		boolean success = setPowerGenerationOutputLimitSetting1(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Power generation output limit setting 1<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getPowerGenerationOutputLimitSetting1() {return null;}
	private final byte[] _getPowerGenerationOutputLimitSetting1(byte epc) {
		byte[] edt = getPowerGenerationOutputLimitSetting1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Specifies the power generation output in watts and to acquire the current setting.<br><br>0x0000 to 00xFFFD (0 to 65533)<br><br>Name : Power generation output limit setting 2<br>EPC : 0xE6<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setPowerGenerationOutputLimitSetting2(byte[] edt) {return false;}
	private final boolean _setPowerGenerationOutputLimitSetting2(byte epc, byte[] edt) {
		boolean success = setPowerGenerationOutputLimitSetting2(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Specifies the power generation output in watts and to acquire the current setting.<br><br>0x0000 to 00xFFFD (0 to 65533)<br><br>Name : Power generation output limit setting 2<br>EPC : 0xE6<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getPowerGenerationOutputLimitSetting2() {return null;}
	private final byte[] _getPowerGenerationOutputLimitSetting2(byte epc) {
		byte[] edt = getPowerGenerationOutputLimitSetting2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br><br>0x0000 to 00xFFFD (0 to 65533)<br><br>Name : Limit setting for the amount of electricity sold<br>EPC : 0xE7<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setLimitSettingForTheAmountOfElectricitySold(byte[] edt) {return false;}
	private final boolean _setLimitSettingForTheAmountOfElectricitySold(byte epc, byte[] edt) {
		boolean success = setLimitSettingForTheAmountOfElectricitySold(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br><br>0x0000 to 00xFFFD (0 to 65533)<br><br>Name : Limit setting for the amount of electricity sold<br>EPC : 0xE7<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getLimitSettingForTheAmountOfElectricitySold() {return null;}
	private final byte[] _getLimitSettingForTheAmountOfElectricitySold(byte epc) {
		byte[] edt = getLimitSettingForTheAmountOfElectricitySold();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the rated power generation output (catalog value) in watts.<br><br>0x0000 to 00xFFFD (0 to 65533)<br><br>Name : Rated power generation output<br>EPC : 0xE8<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setRatedPowerGenerationOutput(byte[] edt) {return false;}
	private final boolean _setRatedPowerGenerationOutput(byte epc, byte[] edt) {
		boolean success = setRatedPowerGenerationOutput(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the rated power generation output (catalog value) in watts.<br><br>0x0000 to 00xFFFD (0 to 65533)<br><br>Name : Rated power generation output<br>EPC : 0xE8<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getRatedPowerGenerationOutput() {return null;}
	private final byte[] _getRatedPowerGenerationOutput(byte epc) {
		byte[] edt = getRatedPowerGenerationOutput();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED:
			res.addProperty(epc, edt, _setResettingCumulativeAmountOfElectricityGenerated(epc, edt));
			break;
		case EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD:
			res.addProperty(epc, edt, _setResettingCumulativeAmountOfElectricitySold(epc, edt));
			break;
		case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1:
			res.addProperty(epc, edt, _setPowerGenerationOutputLimitSetting1(epc, edt));
			break;
		case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2:
			res.addProperty(epc, edt, _setPowerGenerationOutputLimitSetting2(epc, edt));
			break;
		case EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD:
			res.addProperty(epc, edt, _setLimitSettingForTheAmountOfElectricitySold(epc, edt));
			break;
		case EPC_RATED_POWER_GENERATION_OUTPUT:
			res.addProperty(epc, edt, _setRatedPowerGenerationOutput(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_SYSTEM_INTERCONNECTION_STATUS:
			edt = _getSystemInterconnectionStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRICITY_GENERATED:
			edt = _getMeasuredInstantaneousAmountOfElectricityGenerated(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED:
			edt = _getMeasuredCumulativeAmountOfElectricityGenerated(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD:
			edt = _getMeasuredCumulativeAmountOfElectricitySold(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1:
			edt = _getPowerGenerationOutputLimitSetting1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2:
			edt = _getPowerGenerationOutputLimitSetting2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD:
			edt = _getLimitSettingForTheAmountOfElectricitySold(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_RATED_POWER_GENERATION_OUTPUT:
			edt = _getRatedPowerGenerationOutput(epc);
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
			case EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED:
				_onSetResettingCumulativeAmountOfElectricityGenerated(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD:
				_onSetResettingCumulativeAmountOfElectricitySold(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1:
				_onSetPowerGenerationOutputLimitSetting1(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2:
				_onSetPowerGenerationOutputLimitSetting2(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD:
				_onSetLimitSettingForTheAmountOfElectricitySold(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_RATED_POWER_GENERATION_OUTPUT:
				_onSetRatedPowerGenerationOutput(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_SYSTEM_INTERCONNECTION_STATUS:
				_onGetSystemInterconnectionStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRICITY_GENERATED:
				_onGetMeasuredInstantaneousAmountOfElectricityGenerated(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED:
				_onGetMeasuredCumulativeAmountOfElectricityGenerated(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD:
				_onGetMeasuredCumulativeAmountOfElectricitySold(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1:
				_onGetPowerGenerationOutputLimitSetting1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2:
				_onGetPowerGenerationOutputLimitSetting2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD:
				_onGetLimitSettingForTheAmountOfElectricitySold(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RATED_POWER_GENERATION_OUTPUT:
				_onGetRatedPowerGenerationOutput(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates system interconnection status<br><br>System-linked type = 0x00 Independent type = 0x01<br><br>Name : System interconnection status<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetSystemInterconnectionStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSystemInterconnectionStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSystemInterconnectionStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates instantaneous generated power in W.<br><br>0x0000.0xFFFD (0.65533)<br><br>Name : Measured instantaneous amount of electricity generated<br>EPC : 0xE0<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetMeasuredInstantaneousAmountOfElectricityGenerated(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredInstantaneousAmountOfElectricityGenerated(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredInstantaneousAmountOfElectricityGenerated(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates integral electric energy in 0.001 kWh.<br><br>0x0.0x3B9AC9FF (0.999999.999 kWh)<br><br>Name : Measured cumulative amount of electricity generated<br>EPC : 0xE1<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetMeasuredCumulativeAmountOfElectricityGenerated(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredCumulativeAmountOfElectricityGenerated(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredCumulativeAmountOfElectricityGenerated(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Resets integral generated electric energy by setting 0x00.<br><br>Reset = 0x00<br><br>Name : Resetting cumulative amount of electricity generated<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : undefined<br>
		 */
		protected void onSetResettingCumulativeAmountOfElectricityGenerated(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetResettingCumulativeAmountOfElectricityGenerated(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetResettingCumulativeAmountOfElectricityGenerated(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates integral value of sold power in 0.001 kWh.<br><br>0x0.0x3B9AC9FF (0.999999.999 kWh)<br><br>Name : Measured cumulative amount of electricity sold<br>EPC : 0xE3<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredCumulativeAmountOfElectricitySold(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredCumulativeAmountOfElectricitySold(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredCumulativeAmountOfElectricitySold(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Resets integral sold electric energy by setting 0x00.<br><br>Reset = 0x00<br><br>Name : Resetting cumulative amount of electricity sold<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : undefined<br>
		 */
		protected void onSetResettingCumulativeAmountOfElectricitySold(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetResettingCumulativeAmountOfElectricitySold(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetResettingCumulativeAmountOfElectricitySold(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Power generation output limit setting 1<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetPowerGenerationOutputLimitSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetPowerGenerationOutputLimitSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetPowerGenerationOutputLimitSetting1(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Power generation output limit setting 1<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetPowerGenerationOutputLimitSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetPowerGenerationOutputLimitSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetPowerGenerationOutputLimitSetting1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Specifies the power generation output in watts and to acquire the current setting.<br><br>0x0000 to 00xFFFD (0 to 65533)<br><br>Name : Power generation output limit setting 2<br>EPC : 0xE6<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetPowerGenerationOutputLimitSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetPowerGenerationOutputLimitSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetPowerGenerationOutputLimitSetting2(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Specifies the power generation output in watts and to acquire the current setting.<br><br>0x0000 to 00xFFFD (0 to 65533)<br><br>Name : Power generation output limit setting 2<br>EPC : 0xE6<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetPowerGenerationOutputLimitSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetPowerGenerationOutputLimitSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetPowerGenerationOutputLimitSetting2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br><br>0x0000 to 00xFFFD (0 to 65533)<br><br>Name : Limit setting for the amount of electricity sold<br>EPC : 0xE7<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetLimitSettingForTheAmountOfElectricitySold(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetLimitSettingForTheAmountOfElectricitySold(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetLimitSettingForTheAmountOfElectricitySold(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br><br>0x0000 to 00xFFFD (0 to 65533)<br><br>Name : Limit setting for the amount of electricity sold<br>EPC : 0xE7<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetLimitSettingForTheAmountOfElectricitySold(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetLimitSettingForTheAmountOfElectricitySold(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetLimitSettingForTheAmountOfElectricitySold(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the rated power generation output (catalog value) in watts.<br><br>0x0000 to 00xFFFD (0 to 65533)<br><br>Name : Rated power generation output<br>EPC : 0xE8<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetRatedPowerGenerationOutput(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRatedPowerGenerationOutput(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRatedPowerGenerationOutput(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the rated power generation output (catalog value) in watts.<br><br>0x0000 to 00xFFFD (0 to 65533)<br><br>Name : Rated power generation output<br>EPC : 0xE8<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetRatedPowerGenerationOutput(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRatedPowerGenerationOutput(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRatedPowerGenerationOutput(eoj, tid, esv, epc, pdc, edt);
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
		 * Resets integral generated electric energy by setting 0x00.<br><br>Reset = 0x00<br><br>Name : Resetting cumulative amount of electricity generated<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : undefined<br>
		 */
		public Setter reqSetResettingCumulativeAmountOfElectricityGenerated(byte[] edt) {
			addProperty(EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Resets integral sold electric energy by setting 0x00.<br><br>Reset = 0x00<br><br>Name : Resetting cumulative amount of electricity sold<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : undefined<br>
		 */
		public Setter reqSetResettingCumulativeAmountOfElectricitySold(byte[] edt) {
			addProperty(EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Power generation output limit setting 1<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetPowerGenerationOutputLimitSetting1(byte[] edt) {
			addProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Specifies the power generation output in watts and to acquire the current setting.<br><br>0x0000 to 00xFFFD (0 to 65533)<br><br>Name : Power generation output limit setting 2<br>EPC : 0xE6<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetPowerGenerationOutputLimitSetting2(byte[] edt) {
			addProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br><br>0x0000 to 00xFFFD (0 to 65533)<br><br>Name : Limit setting for the amount of electricity sold<br>EPC : 0xE7<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetLimitSettingForTheAmountOfElectricitySold(byte[] edt) {
			addProperty(EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * This property indicates the rated power generation output (catalog value) in watts.<br><br>0x0000 to 00xFFFD (0 to 65533)<br><br>Name : Rated power generation output<br>EPC : 0xE8<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetRatedPowerGenerationOutput(byte[] edt) {
			addProperty(EPC_RATED_POWER_GENERATION_OUTPUT, edt, (edt != null && (edt.length == 2)));
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
		 * This property indicates system interconnection status<br><br>System-linked type = 0x00 Independent type = 0x01<br><br>Name : System interconnection status<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetSystemInterconnectionStatus() {
			addProperty(EPC_SYSTEM_INTERCONNECTION_STATUS);
			return this;
		}
		/**
		 * This property indicates instantaneous generated power in W.<br><br>0x0000.0xFFFD (0.65533)<br><br>Name : Measured instantaneous amount of electricity generated<br>EPC : 0xE0<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetMeasuredInstantaneousAmountOfElectricityGenerated() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRICITY_GENERATED);
			return this;
		}
		/**
		 * This property indicates integral electric energy in 0.001 kWh.<br><br>0x0.0x3B9AC9FF (0.999999.999 kWh)<br><br>Name : Measured cumulative amount of electricity generated<br>EPC : 0xE1<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetMeasuredCumulativeAmountOfElectricityGenerated() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED);
			return this;
		}
		/**
		 * This property indicates integral value of sold power in 0.001 kWh.<br><br>0x0.0x3B9AC9FF (0.999999.999 kWh)<br><br>Name : Measured cumulative amount of electricity sold<br>EPC : 0xE3<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredCumulativeAmountOfElectricitySold() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD);
			return this;
		}
		/**
		 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Power generation output limit setting 1<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetPowerGenerationOutputLimitSetting1() {
			addProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1);
			return this;
		}
		/**
		 * Specifies the power generation output in watts and to acquire the current setting.<br><br>0x0000 to 00xFFFD (0 to 65533)<br><br>Name : Power generation output limit setting 2<br>EPC : 0xE6<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetPowerGenerationOutputLimitSetting2() {
			addProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2);
			return this;
		}
		/**
		 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br><br>0x0000 to 00xFFFD (0 to 65533)<br><br>Name : Limit setting for the amount of electricity sold<br>EPC : 0xE7<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetLimitSettingForTheAmountOfElectricitySold() {
			addProperty(EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD);
			return this;
		}
		/**
		 * This property indicates the rated power generation output (catalog value) in watts.<br><br>0x0000 to 00xFFFD (0 to 65533)<br><br>Name : Rated power generation output<br>EPC : 0xE8<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetRatedPowerGenerationOutput() {
			addProperty(EPC_RATED_POWER_GENERATION_OUTPUT);
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
		 * This property indicates system interconnection status<br><br>System-linked type = 0x00 Independent type = 0x01<br><br>Name : System interconnection status<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformSystemInterconnectionStatus();
		/**
		 * This property indicates instantaneous generated power in W.<br><br>0x0000.0xFFFD (0.65533)<br><br>Name : Measured instantaneous amount of electricity generated<br>EPC : 0xE0<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformMeasuredInstantaneousAmountOfElectricityGenerated();
		/**
		 * This property indicates integral electric energy in 0.001 kWh.<br><br>0x0.0x3B9AC9FF (0.999999.999 kWh)<br><br>Name : Measured cumulative amount of electricity generated<br>EPC : 0xE1<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformMeasuredCumulativeAmountOfElectricityGenerated();
		/**
		 * This property indicates integral value of sold power in 0.001 kWh.<br><br>0x0.0x3B9AC9FF (0.999999.999 kWh)<br><br>Name : Measured cumulative amount of electricity sold<br>EPC : 0xE3<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredCumulativeAmountOfElectricitySold();
		/**
		 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Power generation output limit setting 1<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformPowerGenerationOutputLimitSetting1();
		/**
		 * Specifies the power generation output in watts and to acquire the current setting.<br><br>0x0000 to 00xFFFD (0 to 65533)<br><br>Name : Power generation output limit setting 2<br>EPC : 0xE6<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformPowerGenerationOutputLimitSetting2();
		/**
		 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br><br>0x0000 to 00xFFFD (0 to 65533)<br><br>Name : Limit setting for the amount of electricity sold<br>EPC : 0xE7<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformLimitSettingForTheAmountOfElectricitySold();
		/**
		 * This property indicates the rated power generation output (catalog value) in watts.<br><br>0x0000 to 00xFFFD (0 to 65533)<br><br>Name : Rated power generation output<br>EPC : 0xE8<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformRatedPowerGenerationOutput();
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
		public Informer reqInformSystemInterconnectionStatus() {
			byte epc = EPC_SYSTEM_INTERCONNECTION_STATUS;
			byte[] edt = _getSystemInterconnectionStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousAmountOfElectricityGenerated() {
			byte epc = EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRICITY_GENERATED;
			byte[] edt = _getMeasuredInstantaneousAmountOfElectricityGenerated(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeAmountOfElectricityGenerated() {
			byte epc = EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED;
			byte[] edt = _getMeasuredCumulativeAmountOfElectricityGenerated(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeAmountOfElectricitySold() {
			byte epc = EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD;
			byte[] edt = _getMeasuredCumulativeAmountOfElectricitySold(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformPowerGenerationOutputLimitSetting1() {
			byte epc = EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1;
			byte[] edt = _getPowerGenerationOutputLimitSetting1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformPowerGenerationOutputLimitSetting2() {
			byte epc = EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2;
			byte[] edt = _getPowerGenerationOutputLimitSetting2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformLimitSettingForTheAmountOfElectricitySold() {
			byte epc = EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD;
			byte[] edt = _getLimitSettingForTheAmountOfElectricitySold(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRatedPowerGenerationOutput() {
			byte epc = EPC_RATED_POWER_GENERATION_OUTPUT;
			byte[] edt = _getRatedPowerGenerationOutput(epc);
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
		public Informer reqInformSystemInterconnectionStatus() {
			addProperty(EPC_SYSTEM_INTERCONNECTION_STATUS);
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousAmountOfElectricityGenerated() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRICITY_GENERATED);
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeAmountOfElectricityGenerated() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED);
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeAmountOfElectricitySold() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD);
			return this;
		}
		@Override
		public Informer reqInformPowerGenerationOutputLimitSetting1() {
			addProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1);
			return this;
		}
		@Override
		public Informer reqInformPowerGenerationOutputLimitSetting2() {
			addProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2);
			return this;
		}
		@Override
		public Informer reqInformLimitSettingForTheAmountOfElectricitySold() {
			addProperty(EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD);
			return this;
		}
		@Override
		public Informer reqInformRatedPowerGenerationOutput() {
			addProperty(EPC_RATED_POWER_GENERATION_OUTPUT);
			return this;
		}
	}
}
