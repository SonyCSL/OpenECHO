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
	@SuppressWarnings("unused")
	private static final String TAG = HouseholdSolarPowerGeneration.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x79;

	protected static final byte EPC_SYSTEM_INTERCONNECTION_STATUS = (byte)0xD0;
	protected static final byte EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRICITY_GENERATED = (byte)0xE0;
	protected static final byte EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED = (byte)0xE1;
	protected static final byte EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED = (byte)0xE2;
	protected static final byte EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD = (byte)0xE3;
	protected static final byte EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD = (byte)0xE4;
	protected static final byte EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1 = (byte)0xE5;
	protected static final byte EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2 = (byte)0xE6;
	protected static final byte EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD = (byte)0xE7;
	protected static final byte EPC_RATED_POWER_GENERATION_OUTPUT = (byte)0xE8;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates system interconnection status<br>System-linked type = 0x00 Independent type = 0x01
	 */
	protected byte[] getSystemInterconnectionStatus() {return null;}
	/**
	 * This property indicates instantaneous generated power in W.<br>0x0000.0xFFFD (0.65533)
	 */
	protected abstract byte[] getMeasuredInstantaneousAmountOfElectricityGenerated();
	/**
	 * This property indicates integral electric energy in 0.001 kWh.<br>0x0.0x3B9AC9FF (0.999999.999 kWh)
	 */
	protected abstract byte[] getMeasuredCumulativeAmountOfElectricityGenerated();
	/**
	 * Resets integral generated electric energy by setting 0x00.<br>Reset = 0x00
	 */
	protected boolean setResettingCumulativeAmountOfElectricityGenerated(byte[] edt) {return false;}
	/**
	 * This property indicates integral value of sold power in 0.001 kWh.<br>0x0.0x3B9AC9FF (0.999999.999 kWh)
	 */
	protected byte[] getMeasuredCumulativeAmountOfElectricitySold() {return null;}
	/**
	 * Resets integral sold electric energy by setting 0x00.<br>Reset = 0x00
	 */
	protected boolean setResettingCumulativeAmountOfElectricitySold(byte[] edt) {return false;}
	/**
	 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br>0x00 to 0x64 (0 to 100%)
	 */
	protected boolean setPowerGenerationOutputLimitSetting1(byte[] edt) {return false;}
	/**
	 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br>0x00 to 0x64 (0 to 100%)
	 */
	protected byte[] getPowerGenerationOutputLimitSetting1() {return null;}
	/**
	 * Specifies the power generation output in watts and to acquire the current setting.<br>0x0000 to 00xFFFD (0 to 65533)
	 */
	protected boolean setPowerGenerationOutputLimitSetting2(byte[] edt) {return false;}
	/**
	 * Specifies the power generation output in watts and to acquire the current setting.<br>0x0000 to 00xFFFD (0 to 65533)
	 */
	protected byte[] getPowerGenerationOutputLimitSetting2() {return null;}
	/**
	 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br>0x0000 to 00xFFFD (0 to 65533)
	 */
	protected boolean setLimitSettingForTheAmountOfElectricitySold(byte[] edt) {return false;}
	/**
	 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br>0x0000 to 00xFFFD (0 to 65533)
	 */
	protected byte[] getLimitSettingForTheAmountOfElectricitySold() {return null;}
	/**
	 * This property indicates the rated power generation output (catalog value) in watts.<br>0x0000 to 00xFFFD (0 to 65533)
	 */
	protected boolean setRatedPowerGenerationOutput(byte[] edt) {return false;}
	/**
	 * This property indicates the rated power generation output (catalog value) in watts.<br>0x0000 to 00xFFFD (0 to 65533)
	 */
	protected byte[] getRatedPowerGenerationOutput() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED:
			res.addProperty(epc, edt, setResettingCumulativeAmountOfElectricityGenerated(edt));
			break;
		case EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD:
			res.addProperty(epc, edt, setResettingCumulativeAmountOfElectricitySold(edt));
			break;
		case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1:
			res.addProperty(epc, edt, setPowerGenerationOutputLimitSetting1(edt));
			break;
		case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2:
			res.addProperty(epc, edt, setPowerGenerationOutputLimitSetting2(edt));
			break;
		case EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD:
			res.addProperty(epc, edt, setLimitSettingForTheAmountOfElectricitySold(edt));
			break;
		case EPC_RATED_POWER_GENERATION_OUTPUT:
			res.addProperty(epc, edt, setRatedPowerGenerationOutput(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_SYSTEM_INTERCONNECTION_STATUS:
			edt = getSystemInterconnectionStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRICITY_GENERATED:
			edt = getMeasuredInstantaneousAmountOfElectricityGenerated();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED:
			edt = getMeasuredCumulativeAmountOfElectricityGenerated();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD:
			edt = getMeasuredCumulativeAmountOfElectricitySold();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1:
			edt = getPowerGenerationOutputLimitSetting1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2:
			edt = getPowerGenerationOutputLimitSetting2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD:
			edt = getLimitSettingForTheAmountOfElectricitySold();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_RATED_POWER_GENERATION_OUTPUT:
			edt = getRatedPowerGenerationOutput();
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
			case EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED:
				onSetResettingCumulativeAmountOfElectricityGenerated(eoj, tid, (pdc != 0));
				break;
			case EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD:
				onSetResettingCumulativeAmountOfElectricitySold(eoj, tid, (pdc != 0));
				break;
			case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1:
				onSetPowerGenerationOutputLimitSetting1(eoj, tid, (pdc != 0));
				break;
			case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2:
				onSetPowerGenerationOutputLimitSetting2(eoj, tid, (pdc != 0));
				break;
			case EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD:
				onSetLimitSettingForTheAmountOfElectricitySold(eoj, tid, (pdc != 0));
				break;
			case EPC_RATED_POWER_GENERATION_OUTPUT:
				onSetRatedPowerGenerationOutput(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_SYSTEM_INTERCONNECTION_STATUS:
				onGetSystemInterconnectionStatus(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRICITY_GENERATED:
				onGetMeasuredInstantaneousAmountOfElectricityGenerated(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED:
				onGetMeasuredCumulativeAmountOfElectricityGenerated(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD:
				onGetMeasuredCumulativeAmountOfElectricitySold(eoj, tid, pdc, edt);
				break;
			case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1:
				onGetPowerGenerationOutputLimitSetting1(eoj, tid, pdc, edt);
				break;
			case EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2:
				onGetPowerGenerationOutputLimitSetting2(eoj, tid, pdc, edt);
				break;
			case EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD:
				onGetLimitSettingForTheAmountOfElectricitySold(eoj, tid, pdc, edt);
				break;
			case EPC_RATED_POWER_GENERATION_OUTPUT:
				onGetRatedPowerGenerationOutput(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates system interconnection status<br>System-linked type = 0x00 Independent type = 0x01
		 */
		protected void onGetSystemInterconnectionStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates instantaneous generated power in W.<br>0x0000.0xFFFD (0.65533)
		 */
		protected void onGetMeasuredInstantaneousAmountOfElectricityGenerated(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates integral electric energy in 0.001 kWh.<br>0x0.0x3B9AC9FF (0.999999.999 kWh)
		 */
		protected void onGetMeasuredCumulativeAmountOfElectricityGenerated(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Resets integral generated electric energy by setting 0x00.<br>Reset = 0x00
		 */
		protected void onSetResettingCumulativeAmountOfElectricityGenerated(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates integral value of sold power in 0.001 kWh.<br>0x0.0x3B9AC9FF (0.999999.999 kWh)
		 */
		protected void onGetMeasuredCumulativeAmountOfElectricitySold(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Resets integral sold electric energy by setting 0x00.<br>Reset = 0x00
		 */
		protected void onSetResettingCumulativeAmountOfElectricitySold(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br>0x00 to 0x64 (0 to 100%)
		 */
		protected void onSetPowerGenerationOutputLimitSetting1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br>0x00 to 0x64 (0 to 100%)
		 */
		protected void onGetPowerGenerationOutputLimitSetting1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Specifies the power generation output in watts and to acquire the current setting.<br>0x0000 to 00xFFFD (0 to 65533)
		 */
		protected void onSetPowerGenerationOutputLimitSetting2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Specifies the power generation output in watts and to acquire the current setting.<br>0x0000 to 00xFFFD (0 to 65533)
		 */
		protected void onGetPowerGenerationOutputLimitSetting2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br>0x0000 to 00xFFFD (0 to 65533)
		 */
		protected void onSetLimitSettingForTheAmountOfElectricitySold(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br>0x0000 to 00xFFFD (0 to 65533)
		 */
		protected void onGetLimitSettingForTheAmountOfElectricitySold(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the rated power generation output (catalog value) in watts.<br>0x0000 to 00xFFFD (0 to 65533)
		 */
		protected void onSetRatedPowerGenerationOutput(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the rated power generation output (catalog value) in watts.<br>0x0000 to 00xFFFD (0 to 65533)
		 */
		protected void onGetRatedPowerGenerationOutput(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Resets integral generated electric energy by setting 0x00.<br>Reset = 0x00
		 */
		public Setter reqSetResettingCumulativeAmountOfElectricityGenerated(byte[] edt);
		/**
		 * Resets integral sold electric energy by setting 0x00.<br>Reset = 0x00
		 */
		public Setter reqSetResettingCumulativeAmountOfElectricitySold(byte[] edt);
		/**
		 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br>0x00 to 0x64 (0 to 100%)
		 */
		public Setter reqSetPowerGenerationOutputLimitSetting1(byte[] edt);
		/**
		 * Specifies the power generation output in watts and to acquire the current setting.<br>0x0000 to 00xFFFD (0 to 65533)
		 */
		public Setter reqSetPowerGenerationOutputLimitSetting2(byte[] edt);
		/**
		 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br>0x0000 to 00xFFFD (0 to 65533)
		 */
		public Setter reqSetLimitSettingForTheAmountOfElectricitySold(byte[] edt);
		/**
		 * This property indicates the rated power generation output (catalog value) in watts.<br>0x0000 to 00xFFFD (0 to 65533)
		 */
		public Setter reqSetRatedPowerGenerationOutput(byte[] edt);

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
		public Setter reqSetResettingCumulativeAmountOfElectricityGenerated(byte[] edt) {
			addProperty(EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED, edt, setResettingCumulativeAmountOfElectricityGenerated(edt));
			return this;
		}
		@Override
		public Setter reqSetResettingCumulativeAmountOfElectricitySold(byte[] edt) {
			addProperty(EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD, edt, setResettingCumulativeAmountOfElectricitySold(edt));
			return this;
		}
		@Override
		public Setter reqSetPowerGenerationOutputLimitSetting1(byte[] edt) {
			addProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1, edt, setPowerGenerationOutputLimitSetting1(edt));
			return this;
		}
		@Override
		public Setter reqSetPowerGenerationOutputLimitSetting2(byte[] edt) {
			addProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2, edt, setPowerGenerationOutputLimitSetting2(edt));
			return this;
		}
		@Override
		public Setter reqSetLimitSettingForTheAmountOfElectricitySold(byte[] edt) {
			addProperty(EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD, edt, setLimitSettingForTheAmountOfElectricitySold(edt));
			return this;
		}
		@Override
		public Setter reqSetRatedPowerGenerationOutput(byte[] edt) {
			addProperty(EPC_RATED_POWER_GENERATION_OUTPUT, edt, setRatedPowerGenerationOutput(edt));
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
		public Setter reqSetResettingCumulativeAmountOfElectricityGenerated(byte[] edt) {
			addProperty(EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetResettingCumulativeAmountOfElectricitySold(byte[] edt) {
			addProperty(EPC_RESETTING_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetPowerGenerationOutputLimitSetting1(byte[] edt) {
			addProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetPowerGenerationOutputLimitSetting2(byte[] edt) {
			addProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetLimitSettingForTheAmountOfElectricitySold(byte[] edt) {
			addProperty(EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetRatedPowerGenerationOutput(byte[] edt) {
			addProperty(EPC_RATED_POWER_GENERATION_OUTPUT, edt, (edt != null && (edt.length == 2)));
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
		 * This property indicates system interconnection status<br>System-linked type = 0x00 Independent type = 0x01
		 */
		public Getter reqGetSystemInterconnectionStatus();
		/**
		 * This property indicates instantaneous generated power in W.<br>0x0000.0xFFFD (0.65533)
		 */
		public Getter reqGetMeasuredInstantaneousAmountOfElectricityGenerated();
		/**
		 * This property indicates integral electric energy in 0.001 kWh.<br>0x0.0x3B9AC9FF (0.999999.999 kWh)
		 */
		public Getter reqGetMeasuredCumulativeAmountOfElectricityGenerated();
		/**
		 * This property indicates integral value of sold power in 0.001 kWh.<br>0x0.0x3B9AC9FF (0.999999.999 kWh)
		 */
		public Getter reqGetMeasuredCumulativeAmountOfElectricitySold();
		/**
		 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br>0x00 to 0x64 (0 to 100%)
		 */
		public Getter reqGetPowerGenerationOutputLimitSetting1();
		/**
		 * Specifies the power generation output in watts and to acquire the current setting.<br>0x0000 to 00xFFFD (0 to 65533)
		 */
		public Getter reqGetPowerGenerationOutputLimitSetting2();
		/**
		 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br>0x0000 to 00xFFFD (0 to 65533)
		 */
		public Getter reqGetLimitSettingForTheAmountOfElectricitySold();
		/**
		 * This property indicates the rated power generation output (catalog value) in watts.<br>0x0000 to 00xFFFD (0 to 65533)
		 */
		public Getter reqGetRatedPowerGenerationOutput();

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
		public Getter reqGetSystemInterconnectionStatus() {
			byte[] edt = getSystemInterconnectionStatus();
			addProperty(EPC_SYSTEM_INTERCONNECTION_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousAmountOfElectricityGenerated() {
			byte[] edt = getMeasuredInstantaneousAmountOfElectricityGenerated();
			addProperty(EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRICITY_GENERATED, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeAmountOfElectricityGenerated() {
			byte[] edt = getMeasuredCumulativeAmountOfElectricityGenerated();
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeAmountOfElectricitySold() {
			byte[] edt = getMeasuredCumulativeAmountOfElectricitySold();
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetPowerGenerationOutputLimitSetting1() {
			byte[] edt = getPowerGenerationOutputLimitSetting1();
			addProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetPowerGenerationOutputLimitSetting2() {
			byte[] edt = getPowerGenerationOutputLimitSetting2();
			addProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetLimitSettingForTheAmountOfElectricitySold() {
			byte[] edt = getLimitSettingForTheAmountOfElectricitySold();
			addProperty(EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetRatedPowerGenerationOutput() {
			byte[] edt = getRatedPowerGenerationOutput();
			addProperty(EPC_RATED_POWER_GENERATION_OUTPUT, edt, (edt != null && (edt.length == 2)));
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
		public Getter reqGetSystemInterconnectionStatus() {
			addProperty(EPC_SYSTEM_INTERCONNECTION_STATUS);
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousAmountOfElectricityGenerated() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRICITY_GENERATED);
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeAmountOfElectricityGenerated() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED);
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeAmountOfElectricitySold() {
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD);
			return this;
		}
		@Override
		public Getter reqGetPowerGenerationOutputLimitSetting1() {
			addProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1);
			return this;
		}
		@Override
		public Getter reqGetPowerGenerationOutputLimitSetting2() {
			addProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2);
			return this;
		}
		@Override
		public Getter reqGetLimitSettingForTheAmountOfElectricitySold() {
			addProperty(EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD);
			return this;
		}
		@Override
		public Getter reqGetRatedPowerGenerationOutput() {
			addProperty(EPC_RATED_POWER_GENERATION_OUTPUT);
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
		 * This property indicates system interconnection status<br>System-linked type = 0x00 Independent type = 0x01
		 */
		public Informer reqInformSystemInterconnectionStatus();
		/**
		 * This property indicates instantaneous generated power in W.<br>0x0000.0xFFFD (0.65533)
		 */
		public Informer reqInformMeasuredInstantaneousAmountOfElectricityGenerated();
		/**
		 * This property indicates integral electric energy in 0.001 kWh.<br>0x0.0x3B9AC9FF (0.999999.999 kWh)
		 */
		public Informer reqInformMeasuredCumulativeAmountOfElectricityGenerated();
		/**
		 * This property indicates integral value of sold power in 0.001 kWh.<br>0x0.0x3B9AC9FF (0.999999.999 kWh)
		 */
		public Informer reqInformMeasuredCumulativeAmountOfElectricitySold();
		/**
		 * Specifies the power generation output as a percentage of the rated power generation output and to acquire the current setting.<br>0x00 to 0x64 (0 to 100%)
		 */
		public Informer reqInformPowerGenerationOutputLimitSetting1();
		/**
		 * Specifies the power generation output in watts and to acquire the current setting.<br>0x0000 to 00xFFFD (0 to 65533)
		 */
		public Informer reqInformPowerGenerationOutputLimitSetting2();
		/**
		 * Specifies, in watts, the amount of electricity sold and to acquire the current setting.<br>0x0000 to 00xFFFD (0 to 65533)
		 */
		public Informer reqInformLimitSettingForTheAmountOfElectricitySold();
		/**
		 * This property indicates the rated power generation output (catalog value) in watts.<br>0x0000 to 00xFFFD (0 to 65533)
		 */
		public Informer reqInformRatedPowerGenerationOutput();

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
		public Informer reqInformSystemInterconnectionStatus() {
			byte[] edt = getSystemInterconnectionStatus();
			addProperty(EPC_SYSTEM_INTERCONNECTION_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousAmountOfElectricityGenerated() {
			byte[] edt = getMeasuredInstantaneousAmountOfElectricityGenerated();
			addProperty(EPC_MEASURED_INSTANTANEOUS_AMOUNT_OF_ELECTRICITY_GENERATED, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeAmountOfElectricityGenerated() {
			byte[] edt = getMeasuredCumulativeAmountOfElectricityGenerated();
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_GENERATED, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeAmountOfElectricitySold() {
			byte[] edt = getMeasuredCumulativeAmountOfElectricitySold();
			addProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRICITY_SOLD, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformPowerGenerationOutputLimitSetting1() {
			byte[] edt = getPowerGenerationOutputLimitSetting1();
			addProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformPowerGenerationOutputLimitSetting2() {
			byte[] edt = getPowerGenerationOutputLimitSetting2();
			addProperty(EPC_POWER_GENERATION_OUTPUT_LIMIT_SETTING2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformLimitSettingForTheAmountOfElectricitySold() {
			byte[] edt = getLimitSettingForTheAmountOfElectricitySold();
			addProperty(EPC_LIMIT_SETTING_FOR_THE_AMOUNT_OF_ELECTRICITY_SOLD, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRatedPowerGenerationOutput() {
			byte[] edt = getRatedPowerGenerationOutput();
			addProperty(EPC_RATED_POWER_GENERATION_OUTPUT, edt, (edt != null && (edt.length == 2)));
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
