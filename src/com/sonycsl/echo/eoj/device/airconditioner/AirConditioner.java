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

public abstract class AirConditioner extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = AirConditioner.class.getSimpleName();
	private final AirConditioner self = this;
	
	public static final byte CLASS_GROUP_CODE = (byte)0x01;
	public static final byte CLASS_CODE = (byte)0x30;

	protected static final byte EPC_MODE = (byte)0xB0;
	protected static final byte EPC_AUTOMATIC_TEMPERATURE_SETTING = (byte)0xB1;
	protected static final byte EPC_RAPID_MODE = (byte)0xB2;
	protected static final byte EPC_TEMPERATURE = (byte)0xB3;
	protected static final byte EPC_RELATIVE_TEMPERATURE_ON_DEHUMIDIFICATION_MODE = (byte)0xB4;
	protected static final byte EPC_TEMPERATURE_ON_COOLING_MODE = (byte)0xB5;
	protected static final byte EPC_TEMPERATURE_ON_HEATING_MODE = (byte)0xB6;
	protected static final byte EPC_TEMPERATURE_ON_DEHUMIDIFICATION_MODE = (byte)0xB7;
	protected static final byte EPC_POWER_DISSIPATION = (byte)0xB8;
	protected static final byte EPC_CURRENT_CONSUMPTION = (byte)0xB9;
	protected static final byte EPC_INDOOR_RELATIVE_TEMPERATURE = (byte)0xBA;
	protected static final byte EPC_INDOOR_TEMPERATURE = (byte)0xBB;
	protected static final byte EPC_USER_REMOTE_CONTROL_TEMPERATURE = (byte)0xBC;
	protected static final byte EPC_BLOWOFF_TEMPERATURE = (byte)0xBD;
	protected static final byte EPC_OUTDOOR_AIR_TEMPERATURE = (byte)0xBE;
	protected static final byte EPC_RELATIVE_TEMPERATURE = (byte)0xBF;
	protected static final byte EPC_AIR_VOLUME = (byte)0xA0;
	protected static final byte EPC_AUTOMATIC_WIND_DIRECTION_SETTING = (byte)0xA1;
	protected static final byte EPC_SWING_WIND_DIRECTION = (byte)0xA3;
	protected static final byte EPC_TOP_AND_BOTTOM_WIND_DIRECTION = (byte)0xA4;
	protected static final byte EPC_RIGHT_AND_LEFT_WIND_DIRECTION = (byte)0xA5;
	protected static final byte EPC_SPECIAL_STATE = (byte)0xAA;
	protected static final byte EPC_NONPRIORITIZED_STATE = (byte)0xAB;
	protected static final byte EPC_VENTILATION_MODE = (byte)0xC0;
	protected static final byte EPC_HUMIDIFICATION_MODE = (byte)0xC1;
	protected static final byte EPC_VENTILATION_AIR_VOLUME = (byte)0xC2;
	protected static final byte EPC_HUMIDIFICATION_VOLUME = (byte)0xC4;
	protected static final byte EPC_AIR_CLEANING_METHOD = (byte)0xC6;
	protected static final byte EPC_AIR_CLEANING_METHOD_MODE = (byte)0xC7;
	protected static final byte EPC_REFRESH_METHOD = (byte)0xC8;
	protected static final byte EPC_REFRESH_METHOD_MODE = (byte)0xC9;
	protected static final byte EPC_SELF_CLEANING_METHOD = (byte)0xCA;
	protected static final byte EPC_SELF_CLEANING_METHOD_MODE = (byte)0xCB;
	protected static final byte EPC_SPECIAL_MODE = (byte)0xCC;
	protected static final byte EPC_INTERIOR_ACTION = (byte)0xCD;
	protected static final byte EPC_FORCED_THERMO_MODE = (byte)0xCE;
	protected static final byte EPC_AIR_CLEANING_MODE = (byte)0xCF;
	protected static final byte EPC_ON_TIMER_RESERVATION = (byte)0x90;
	protected static final byte EPC_ON_TIMER_TIME = (byte)0x91;
	protected static final byte EPC_ON_TIMER_RELATIVE_TIME = (byte)0x92;
	protected static final byte EPC_OFF_TIMER_RESERVATION = (byte)0x93;
	protected static final byte EPC_OFF_TIMER_TIME = (byte)0x95;
	protected static final byte EPC_OFF_TIMER_RELATIVE_TIME = (byte)0x96;
	
	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	@Override
	protected abstract byte[] getPower();
	
	protected abstract boolean setMode(byte[] edt);
	protected abstract byte[] getMode();
	
	protected boolean setAutomaticTemperatureSetting(byte[] edt) {
		return false;
	}
	protected byte[] getAutomaticTemperatureSetting() {
		return null;
	}
	
	protected boolean setRapidMode(byte[] edt) {
		return false;
	}
	protected byte[] getRapidMode() {
		return null;
	}
	
	protected abstract boolean setTemperature(byte[] edt);
	protected abstract byte[] getTemperature();

	protected boolean setRelativeTemperatureOnDehumidificationMode(byte[] edt) {
		return false;
	}
	protected byte[] getRelativeTemperatureOnDehumidificationMode() {
		return null;
	}
	
	protected boolean setTemperatureOnCoolingMode(byte[] edt) {
		return false;
	}
	protected byte[] getTemperatureOnCoolingMode() {
		return null;
	}
	
	protected boolean setTemperatureOnHeatingMode(byte[] edt) {
		return false;
	}
	protected byte[] getTemperatureOnHeatingMode() {
		return null;
	}
	
	protected boolean setTemperatureOnDehumidificationMode(byte[] edt) {
		return false;
	}
	protected byte[] getTemperatureOnDehumidificationMode() {
		return null;
	}
	
	protected byte[] getPowerDissipation() {
		return null;
	}
	
	protected byte[] getCurrentConsumption() {
		return null;
	}

	protected byte[] getIndoorRelativeTemperature() {
		return null;
	}
	
	protected byte[] getIndoorTemperature() {
		return null;
	}
	
	protected byte[] getUserRemoteControlTemperature() {
		return null;
	}
	
	protected byte[] getBlowoffTemperature() {
		return null;
	}
	
	protected byte[] getOutdoorAirTemperature() {
		return null;
	}
	
	protected boolean setRelativeTemperature(byte[] edt) {
		return false;
	}
	protected byte[] getRelativeTemperature() {
		return null;
	}
	
	protected boolean setAirVolume(byte[] edt) {
		return false;
	}
	protected byte[] getAirVolume() {
		return null;
	}
	
	protected boolean setAutomaticWindDirectionSetting(byte[] edt) {
		return false;
	}
	protected byte[] getAutomaticWindDirectionSetting() {
		return null;
	}

	protected boolean setSwingWindDirection(byte[] edt) {
		return false;
	}
	protected byte[] getSwingWindDirection() {
		return null;
	}
	
	protected boolean setTopAndBottomWindDirection(byte[] edt) {
		return false;
	}
	protected byte[] getTopAndBottomWindDirection() {
		return null;
	}
	
	protected boolean setRightAndLeftWindDirection(byte[] edt) {
		return false;
	}
	protected byte[] getRightAndLeftWindDirection() {
		return null;
	}
	
	protected byte[] getSpecialState() {
		return null;
	}

	protected byte[] getNonprioritizedState() {
		return null;
	}

	protected boolean setVentilationMode(byte[] edt) {
		return false;
	}
	protected byte[] getVentilationMode() {
		return null;
	}
	
	protected boolean setHumidificationMode(byte[] edt) {
		return false;
	}
	protected byte[] getHumidificationMode() {
		return null;
	}

	protected boolean setVentilationAirVolume(byte[] edt) {
		return false;
	}
	protected byte[] getVentilationAirVolume() {
		return null;
	}
	
	protected boolean setHumidificationVolume(byte[] edt) {
		return false;
	}
	protected byte[] getHumidificationVolume() {
		return null;
	}

	protected byte[] getAirCleaningMethod() {
		return null;
	}
	

	protected boolean setAirCleaningMethodMode(byte[] edt) {
		return false;
	}
	protected byte[] getAirCleaningMethodMode() {
		return null;
	}
	
	protected byte[] getRefreshMethod() {
		return null;
	}
	
	protected boolean setRefreshMethodMode(byte[] edt) {
		return false;
	}
	protected byte[] getRefreshMethodMode() {
		return null;
	}
	
	protected byte[] getSelfCleaningMethod() {
		return null;
	}
	
	protected boolean setSelfCleaningMethodMode(byte[] edt) {
		return false;
	}
	protected byte[] getSelfCleaningMethodMode() {
		return null;
	}
	
	protected boolean setSpecialMode(byte[] edt) {
		return false;
	}
	protected byte[] getSpecialMode() {
		return null;
	}
	
	protected byte[] getInteriorAction() {
		return null;
	}
	
	protected boolean setForcedThermoMode(byte[] edt) {
		return false;
	}
	
	protected boolean setAirCleaningMode(byte[] edt) {
		return false;
	}
	protected byte[] getAirCleaningMode() {
		return null;
	}

	protected boolean setOnTimerReservation(byte[] edt) {
		return false;
	}
	protected byte[] getOnTimerReservation() {
		return null;
	}

	protected boolean setOnTimerTime(byte[] edt) {
		return false;
	}
	protected byte[] getOnTimerTime() {
		return null;
	}

	protected boolean setOnTimerRelativeTime(byte[] edt) {
		return false;
	}
	protected byte[] getOnTimerRelativeTime() {
		return null;
	}

	protected boolean setOffTimerReservation(byte[] edt) {
		return false;
	}
	protected byte[] getOffTimerReservation() {
		return null;
	}

	protected boolean setOffTimerTime(byte[] edt) {
		return false;
	}
	protected byte[] getOffTimerTime() {
		return null;
	}

	protected boolean setOffTimerRelativeTime(byte[] edt) {
		return false;
	}
	protected byte[] getOffTimerRelativeTime() {
		return null;
	}

	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_MODE:
			res.addProperty(epc, edt, setMode(edt));
			break;
		case EPC_AUTOMATIC_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, setAutomaticTemperatureSetting(edt));
			break;
		case EPC_RAPID_MODE:
			res.addProperty(epc, edt, setRapidMode(edt));
			break;
		case EPC_TEMPERATURE:
			res.addProperty(epc, edt, setTemperature(edt));
			break;
		case EPC_RELATIVE_TEMPERATURE_ON_DEHUMIDIFICATION_MODE:
			res.addProperty(epc, edt, setRelativeTemperatureOnDehumidificationMode(edt));
			break;
		case EPC_TEMPERATURE_ON_COOLING_MODE:
			res.addProperty(epc, edt, setTemperatureOnCoolingMode(edt));
			break;
		case EPC_TEMPERATURE_ON_HEATING_MODE:
			res.addProperty(epc, edt, setTemperatureOnHeatingMode(edt));
			break;
		case EPC_TEMPERATURE_ON_DEHUMIDIFICATION_MODE:
			res.addProperty(epc, edt, setTemperatureOnDehumidificationMode(edt));
			break;
		case EPC_RELATIVE_TEMPERATURE:
			res.addProperty(epc, edt, setRelativeTemperature(edt));
			break;
		case EPC_AIR_VOLUME:
			res.addProperty(epc, edt, setAirVolume(edt));
			break;
		case EPC_AUTOMATIC_WIND_DIRECTION_SETTING:
			res.addProperty(epc, edt, setAutomaticWindDirectionSetting(edt));
			break;
		case EPC_SWING_WIND_DIRECTION:
			res.addProperty(epc, edt, setSwingWindDirection(edt));
			break;
		case EPC_TOP_AND_BOTTOM_WIND_DIRECTION:
			res.addProperty(epc, edt, setTopAndBottomWindDirection(edt));
			break;
		case EPC_RIGHT_AND_LEFT_WIND_DIRECTION:
			res.addProperty(epc, edt, setRightAndLeftWindDirection(edt));
			break;
		case EPC_VENTILATION_MODE:
			res.addProperty(epc, edt, setVentilationMode(edt));
			break;
		case EPC_HUMIDIFICATION_MODE:
			res.addProperty(epc, edt, setHumidificationMode(edt));
			break;
		case EPC_VENTILATION_AIR_VOLUME:
			res.addProperty(epc, edt, setVentilationAirVolume(edt));
			break;
		case EPC_HUMIDIFICATION_VOLUME:
			res.addProperty(epc, edt, setHumidificationVolume(edt));
			break;
		case EPC_AIR_CLEANING_METHOD_MODE:
			res.addProperty(epc, edt, setAirCleaningMethodMode(edt));
			break;
		case EPC_REFRESH_METHOD_MODE:
			res.addProperty(epc, edt, setRefreshMethodMode(edt));
			break;
		case EPC_SELF_CLEANING_METHOD_MODE:
			res.addProperty(epc, edt, setSelfCleaningMethodMode(edt));
			break;
		case EPC_SPECIAL_MODE:
			res.addProperty(epc, edt, setSpecialMode(edt));
			break;
		case EPC_FORCED_THERMO_MODE:
			res.addProperty(epc, edt, setForcedThermoMode(edt));
			break;
		case EPC_AIR_CLEANING_MODE:
			res.addProperty(epc, edt, setAirCleaningMode(edt));
			break;
		case EPC_ON_TIMER_RESERVATION:
			res.addProperty(epc, edt, setOnTimerReservation(edt));
			break;
		case EPC_ON_TIMER_TIME:
			res.addProperty(epc, edt, setOnTimerTime(edt));
			break;
		case EPC_ON_TIMER_RELATIVE_TIME:
			res.addProperty(epc, edt, setOnTimerRelativeTime(edt));
			break;
		case EPC_OFF_TIMER_RESERVATION:
			res.addProperty(epc, edt, setOffTimerReservation(edt));
			break;
		case EPC_OFF_TIMER_TIME:
			res.addProperty(epc, edt, setOffTimerTime(edt));
			break;
		case EPC_OFF_TIMER_RELATIVE_TIME:
			res.addProperty(epc, edt, setOffTimerRelativeTime(edt));
			break;
		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_MODE:
			edt = getMode();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_AUTOMATIC_TEMPERATURE_SETTING:
			edt = getAutomaticTemperatureSetting();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_RAPID_MODE:
			edt = getRapidMode();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_TEMPERATURE:
			edt = getTemperature();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_RELATIVE_TEMPERATURE_ON_DEHUMIDIFICATION_MODE:
			edt = getRelativeTemperatureOnDehumidificationMode();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_TEMPERATURE_ON_COOLING_MODE:
			edt = getTemperatureOnCoolingMode();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_TEMPERATURE_ON_HEATING_MODE:
			edt = getTemperatureOnHeatingMode();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_TEMPERATURE_ON_DEHUMIDIFICATION_MODE:
			edt = getTemperatureOnDehumidificationMode();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_POWER_DISSIPATION:
			edt = getPowerDissipation();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CURRENT_CONSUMPTION:
			edt = getCurrentConsumption();
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_INDOOR_RELATIVE_TEMPERATURE:
			edt = getIndoorRelativeTemperature();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_INDOOR_TEMPERATURE:
			edt = getIndoorTemperature();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_USER_REMOTE_CONTROL_TEMPERATURE:
			edt = getUserRemoteControlTemperature();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_BLOWOFF_TEMPERATURE:
			edt = getBlowoffTemperature();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_OUTDOOR_AIR_TEMPERATURE:
			edt = getOutdoorAirTemperature();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_RELATIVE_TEMPERATURE:
			edt = getRelativeTemperature();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_AIR_VOLUME:
			edt = getAirVolume();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_AUTOMATIC_WIND_DIRECTION_SETTING:
			edt = getAutomaticWindDirectionSetting();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_SWING_WIND_DIRECTION:
			edt = getSwingWindDirection();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_TOP_AND_BOTTOM_WIND_DIRECTION:
			edt = getTopAndBottomWindDirection();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_RIGHT_AND_LEFT_WIND_DIRECTION:
			edt = getRightAndLeftWindDirection();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_SPECIAL_STATE:
			edt = getSpecialState();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_NONPRIORITIZED_STATE:
			edt = getNonprioritizedState();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_VENTILATION_MODE:
			edt = getVentilationMode();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_HUMIDIFICATION_MODE:
			edt = getHumidificationMode();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_VENTILATION_AIR_VOLUME:
			edt = getVentilationAirVolume();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_HUMIDIFICATION_VOLUME:
			edt = getHumidificationVolume();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_AIR_CLEANING_METHOD:
			edt = getAirCleaningMethod();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_AIR_CLEANING_METHOD_MODE:
			edt = getAirCleaningMethodMode();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_REFRESH_METHOD:
			edt = getRefreshMethod();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_REFRESH_METHOD_MODE:
			edt = getRefreshMethodMode();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_SELF_CLEANING_METHOD:
			edt = getSelfCleaningMethod();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_SELF_CLEANING_METHOD_MODE:
			edt = getSelfCleaningMethodMode();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_SPECIAL_MODE:
			edt = getSpecialMode();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_INTERIOR_ACTION:
			edt = getInteriorAction();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_AIR_CLEANING_MODE:
			edt = getAirCleaningMode();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_ON_TIMER_RESERVATION:
			edt = getOnTimerReservation();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_ON_TIMER_TIME:
			edt = getOnTimerTime();
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_ON_TIMER_RELATIVE_TIME:
			edt = getOnTimerRelativeTime();
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_OFF_TIMER_RESERVATION:
			edt = getOffTimerReservation();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_OFF_TIMER_TIME:
			edt = getOffTimerTime();
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_OFF_TIMER_RELATIVE_TIME:
			edt = getOffTimerRelativeTime();
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
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
			case EPC_MODE:
				onSetMode(eoj, tid, (pdc != 0));
				break;
			case EPC_AUTOMATIC_TEMPERATURE_SETTING:
				onSetAutomaticTemperatureSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_RAPID_MODE:
				onSetRapidMode(eoj, tid, (pdc != 0));
				break;
			case EPC_TEMPERATURE:
				onSetTemperature(eoj, tid, (pdc != 0));
				break;
			case EPC_RELATIVE_TEMPERATURE_ON_DEHUMIDIFICATION_MODE:
				onSetRelativeTemperatureOnDehumidificationMode(eoj, tid, (pdc != 0));
				break;
			case EPC_TEMPERATURE_ON_COOLING_MODE:
				onSetTemperatureOnCoolingMode(eoj, tid, (pdc != 0));
				break;
			case EPC_TEMPERATURE_ON_HEATING_MODE:
				onSetTemperatureOnHeatingMode(eoj, tid, (pdc != 0));
				break;
			case EPC_TEMPERATURE_ON_DEHUMIDIFICATION_MODE:
				onSetTemperatureOnDehumidificationMode(eoj, tid, (pdc != 0));
				break;
			case EPC_RELATIVE_TEMPERATURE:
				onSetRelativeTemperature(eoj, tid, (pdc != 0));
				break;
			case EPC_AIR_VOLUME:
				onSetAirVolume(eoj, tid, (pdc != 0));
				break;
			case EPC_AUTOMATIC_WIND_DIRECTION_SETTING:
				onSetAutomaticWindDirectionSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_SWING_WIND_DIRECTION:
				onSetSwingWindDirection(eoj, tid, (pdc != 0));
				break;
			case EPC_TOP_AND_BOTTOM_WIND_DIRECTION:
				onSetTopAndBottomWindDirection(eoj, tid, (pdc != 0));
				break;
			case EPC_RIGHT_AND_LEFT_WIND_DIRECTION:
				onSetRightAndLeftWindDirection(eoj, tid, (pdc != 0));
				break;
			case EPC_VENTILATION_MODE:
				onSetVentilationMode(eoj, tid, (pdc != 0));
				break;
			case EPC_HUMIDIFICATION_MODE:
				onSetHumidificationMode(eoj, tid, (pdc != 0));
				break;
			case EPC_VENTILATION_AIR_VOLUME:
				onSetVentilationAirVolume(eoj, tid, (pdc != 0));
				break;
			case EPC_HUMIDIFICATION_VOLUME:
				onSetHumidificationVolume(eoj, tid, (pdc != 0));
				break;
			case EPC_AIR_CLEANING_METHOD_MODE:
				onSetAirCleaningMethodMode(eoj, tid, (pdc != 0));
				break;
			case EPC_REFRESH_METHOD_MODE:
				onSetRefreshMethodMode(eoj, tid, (pdc != 0));
				break;
			case EPC_SELF_CLEANING_METHOD_MODE:
				onSetSelfCleaningMethodMode(eoj, tid, (pdc != 0));
				break;
			case EPC_SPECIAL_MODE:
				onSetSpecialMode(eoj, tid, (pdc != 0));
				break;
			case EPC_FORCED_THERMO_MODE:
				onSetForcedThermoMode(eoj, tid, (pdc != 0));
				break;
			case EPC_AIR_CLEANING_MODE:
				onSetAirCleaningMode(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_RESERVATION:
				onSetOnTimerReservation(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_TIME:
				onSetOnTimerTime(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_RELATIVE_TIME:
				onSetOnTimerRelativeTime(eoj, tid, (pdc != 0));
				break;
			case EPC_OFF_TIMER_RESERVATION:
				onSetOffTimerReservation(eoj, tid, (pdc != 0));
				break;
			case EPC_OFF_TIMER_TIME:
				onSetOffTimerTime(eoj, tid, (pdc != 0));
				break;
			case EPC_OFF_TIMER_RELATIVE_TIME:
				onSetOffTimerRelativeTime(eoj, tid, (pdc != 0));
				break;
			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_MODE:
				onGetMode(eoj, tid, pdc, edt);
				break;
			case EPC_AUTOMATIC_TEMPERATURE_SETTING:
				onGetAutomaticTemperatureSetting(eoj, tid, pdc, edt);
				break;
			case EPC_RAPID_MODE:
				onGetRapidMode(eoj, tid, pdc, edt);
				break;
			case EPC_TEMPERATURE:
				onGetTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_RELATIVE_TEMPERATURE_ON_DEHUMIDIFICATION_MODE:
				onGetRelativeTemperatureOnDehumidificationMode(eoj, tid, pdc, edt);
				break;
			case EPC_TEMPERATURE_ON_COOLING_MODE:
				onGetTemperatureOnCoolingMode(eoj, tid, pdc, edt);
				break;
			case EPC_TEMPERATURE_ON_HEATING_MODE:
				onGetTemperatureOnHeatingMode(eoj, tid, pdc, edt);
				break;
			case EPC_TEMPERATURE_ON_DEHUMIDIFICATION_MODE:
				onGetTemperatureOnDehumidificationMode(eoj, tid, pdc, edt);
				break;
			case EPC_POWER_DISSIPATION:
				onGetPowerDissipation(eoj, tid, pdc, edt);
				break;
			case EPC_CURRENT_CONSUMPTION:
				onGetCurrentConsumption(eoj, tid, pdc, edt);
				break;
			case EPC_INDOOR_RELATIVE_TEMPERATURE:
				onGetIndoorRelativeTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_INDOOR_TEMPERATURE:
				onGetIndoorTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_USER_REMOTE_CONTROL_TEMPERATURE:
				onGetUserRemoteControlTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_BLOWOFF_TEMPERATURE:
				onGetBlowoffTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_OUTDOOR_AIR_TEMPERATURE:
				onGetOutdoorAirTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_RELATIVE_TEMPERATURE:
				onGetRelativeTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_AIR_VOLUME:
				onGetAirVolume(eoj, tid, pdc, edt);
				break;
			case EPC_AUTOMATIC_WIND_DIRECTION_SETTING:
				onGetAutomaticWindDirectionSetting(eoj, tid, pdc, edt);
				break;
			case EPC_SWING_WIND_DIRECTION:
				onGetSwingWindDirection(eoj, tid, pdc, edt);
				break;
			case EPC_TOP_AND_BOTTOM_WIND_DIRECTION:
				onGetTopAndBottomWindDirection(eoj, tid, pdc, edt);
				break;
			case EPC_RIGHT_AND_LEFT_WIND_DIRECTION:
				onGetRightAndLeftWindDirection(eoj, tid, pdc, edt);
				break;
			case EPC_SPECIAL_STATE:
				onGetSpecialState(eoj, tid, pdc, edt);
				break;
			case EPC_NONPRIORITIZED_STATE:
				onGetNonprioritizedState(eoj, tid, pdc, edt);
				break;
			case EPC_VENTILATION_MODE:
				onGetVentilationMode(eoj, tid, pdc, edt);
				break;
			case EPC_HUMIDIFICATION_MODE:
				onGetHumidificationMode(eoj, tid, pdc, edt);
				break;
			case EPC_VENTILATION_AIR_VOLUME:
				onGetVentilationAirVolume(eoj, tid, pdc, edt);
				break;
			case EPC_HUMIDIFICATION_VOLUME:
				onGetHumidificationVolume(eoj, tid, pdc, edt);
				break;
			case EPC_AIR_CLEANING_METHOD:
				onGetAirCleaningMethod(eoj, tid, pdc, edt);
				break;
			case EPC_AIR_CLEANING_METHOD_MODE:
				onGetAirCleaningMethodMode(eoj, tid, pdc, edt);
				break;
			case EPC_REFRESH_METHOD:
				onGetRefreshMethod(eoj, tid, pdc, edt);
				break;
			case EPC_REFRESH_METHOD_MODE:
				onGetRefreshMethodMode(eoj, tid, pdc, edt);
				break;
			case EPC_SELF_CLEANING_METHOD:
				onGetSelfCleaningMethod(eoj, tid, pdc, edt);
				break;
			case EPC_SELF_CLEANING_METHOD_MODE:
				onGetSelfCleaningMethodMode(eoj, tid, pdc, edt);
				break;
			case EPC_SPECIAL_MODE:
				onGetSpecialMode(eoj, tid, pdc, edt);
				break;
			case EPC_INTERIOR_ACTION:
				onGetInteriorAction(eoj, tid, pdc, edt);
				break;
			case EPC_AIR_CLEANING_MODE:
				onGetAirCleaningMode(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_RESERVATION:
				onGetOnTimerReservation(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_TIME:
				onGetOnTimerTime(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_RELATIVE_TIME:
				onGetOnTimerRelativeTime(eoj, tid, pdc, edt);
				break;
			case EPC_OFF_TIMER_RESERVATION:
				onGetOffTimerReservation(eoj, tid, pdc, edt);
				break;
			case EPC_OFF_TIMER_TIME:
				onGetOffTimerTime(eoj, tid, pdc, edt);
				break;
			case EPC_OFF_TIMER_RELATIVE_TIME:
				onGetOffTimerRelativeTime(eoj, tid, pdc, edt);
				break;
			}
		}

		protected void onSetMode(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetMode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onSetAutomaticTemperatureSetting(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetAutomaticTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onSetRapidMode(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetRapidMode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onSetTemperature(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		protected void onSetRelativeTemperatureOnDehumidificationMode(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetRelativeTemperatureOnDehumidificationMode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onSetTemperatureOnCoolingMode(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetTemperatureOnCoolingMode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onSetTemperatureOnHeatingMode(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetTemperatureOnHeatingMode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onSetTemperatureOnDehumidificationMode(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetTemperatureOnDehumidificationMode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onGetPowerDissipation(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onGetCurrentConsumption(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		protected void onGetIndoorRelativeTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onGetIndoorTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onGetUserRemoteControlTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onGetBlowoffTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onGetOutdoorAirTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onSetRelativeTemperature(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetRelativeTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onSetAirVolume(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetAirVolume(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onSetAutomaticWindDirectionSetting(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetAutomaticWindDirectionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		protected void onSetSwingWindDirection(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetSwingWindDirection(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onSetTopAndBottomWindDirection(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetTopAndBottomWindDirection(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onSetRightAndLeftWindDirection(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetRightAndLeftWindDirection(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onGetSpecialState(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		protected void onGetNonprioritizedState(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		protected void onSetVentilationMode(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetVentilationMode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onSetHumidificationMode(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetHumidificationMode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		protected void onSetVentilationAirVolume(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetVentilationAirVolume(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onSetHumidificationVolume(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetHumidificationVolume(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		protected void onGetAirCleaningMethod(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onSetAirCleaningMethodMode(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetAirCleaningMethodMode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onGetRefreshMethod(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onSetRefreshMethodMode(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetRefreshMethodMode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onGetSelfCleaningMethod(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onSetSelfCleaningMethodMode(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetSelfCleaningMethodMode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onSetSpecialMode(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetSpecialMode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onGetInteriorAction(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		protected void onSetForcedThermoMode(EchoObject eoj, short tid, boolean success) {
		}
		
		protected void onSetAirCleaningMode(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetAirCleaningMode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		protected void onSetOnTimerReservation(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetOnTimerReservation(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		protected void onSetOnTimerTime(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetOnTimerTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		protected void onSetOnTimerRelativeTime(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetOnTimerRelativeTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		protected void onSetOffTimerReservation(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetOffTimerReservation(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		protected void onSetOffTimerTime(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetOffTimerTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		protected void onSetOffTimerRelativeTime(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetOffTimerRelativeTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
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
		
		public Setter reqSetMode(byte[] edt);
		public Setter reqSetAutomaticTemperatureSetting(byte[] edt);
		public Setter reqSetRapidMode(byte[] edt);
		public Setter reqSetTemperature(byte[] edt);
		public Setter reqSetRelativeTemperatureOnDehumidificationMode(byte[] edt);
		public Setter reqSetTemperatureOnCoolingMode(byte[] edt);
		public Setter reqSetTemperatureOnHeatingMode(byte[] edt);
		public Setter reqSetTemperatureOnDehumidificationMode(byte[] edt);
		public Setter reqSetRelativeTemperature(byte[] edt);
		public Setter reqSetAirVolume(byte[] edt);
		public Setter reqSetAutomaticWindDirectionSetting(byte[] edt);
		public Setter reqSetSwingWindDirection(byte[] edt);
		public Setter reqSetTopAndBottomWindDirection(byte[] edt);
		public Setter reqSetRightAndLeftWindDirection(byte[] edt);
		public Setter reqSetVentilationMode(byte[] edt);
		public Setter reqSetHumidificationMode(byte[] edt);
		public Setter reqSetVentilationAirVolume(byte[] edt);
		public Setter reqSetHumidificationVolume(byte[] edt);
		public Setter reqSetAirCleaningMethodMode(byte[] edt);
		public Setter reqSetRefreshMethodMode(byte[] edt);
		public Setter reqSetSelfCleaningMethodMode(byte[] edt);
		public Setter reqSetSpecialMode(byte[] edt);
		public Setter reqSetForcedThermoMode(byte[] edt);
		public Setter reqSetAirCleaningMode(byte[] edt);
		public Setter reqSetOnTimerReservation(byte[] edt);
		public Setter reqSetOnTimerTime(byte[] edt);
		public Setter reqSetOnTimerRelativeTime(byte[] edt);
		public Setter reqSetOffTimerReservation(byte[] edt);
		public Setter reqSetOffTimerTime(byte[] edt);
		public Setter reqSetOffTimerRelativeTime(byte[] edt);
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
		public Setter reqSetMode(byte[] edt) {
			addProperty(EPC_MODE, edt, setMode(edt));
			return this;
		}

		@Override
		public Setter reqSetAutomaticTemperatureSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_SETTING, edt, setAutomaticTemperatureSetting(edt));
			return this;
		}

		@Override
		public Setter reqSetRapidMode(byte[] edt) {
			addProperty(EPC_RAPID_MODE, edt, setRapidMode(edt));
			return this;
		}

		@Override
		public Setter reqSetTemperature(byte[] edt) {
			addProperty(EPC_TEMPERATURE, edt, setTemperature(edt));
			return this;
		}

		@Override
		public Setter reqSetRelativeTemperatureOnDehumidificationMode(byte[] edt) {
			addProperty(EPC_RELATIVE_TEMPERATURE_ON_DEHUMIDIFICATION_MODE, edt, setRelativeTemperatureOnDehumidificationMode(edt));
			return this;
		}

		@Override
		public Setter reqSetTemperatureOnCoolingMode(byte[] edt) {
			addProperty(EPC_TEMPERATURE_ON_COOLING_MODE, edt, setTemperatureOnCoolingMode(edt));
			return this;
		}

		@Override
		public Setter reqSetTemperatureOnHeatingMode(byte[] edt) {
			addProperty(EPC_TEMPERATURE_ON_HEATING_MODE, edt, setTemperatureOnHeatingMode(edt));
			return this;
		}

		@Override
		public Setter reqSetTemperatureOnDehumidificationMode(byte[] edt) {
			addProperty(EPC_TEMPERATURE_ON_DEHUMIDIFICATION_MODE, edt, setTemperatureOnDehumidificationMode(edt));
			return this;
		}


		@Override
		public Setter reqSetRelativeTemperature(byte[] edt) {
			addProperty(EPC_RELATIVE_TEMPERATURE, edt, setRelativeTemperature(edt));
			return this;
		}

		@Override
		public Setter reqSetAirVolume(byte[] edt) {
			addProperty(EPC_AIR_VOLUME, edt, setAirVolume(edt));
			return this;
		}

		@Override
		public Setter reqSetAutomaticWindDirectionSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_WIND_DIRECTION_SETTING, edt, setAutomaticWindDirectionSetting(edt));
			return this;
		}

		@Override
		public Setter reqSetSwingWindDirection(byte[] edt) {
			addProperty(EPC_SWING_WIND_DIRECTION, edt, setSwingWindDirection(edt));
			return this;
		}

		@Override
		public Setter reqSetTopAndBottomWindDirection(byte[] edt) {
			addProperty(EPC_TOP_AND_BOTTOM_WIND_DIRECTION, edt, setTopAndBottomWindDirection(edt));
			return this;
		}

		@Override
		public Setter reqSetRightAndLeftWindDirection(byte[] edt) {
			addProperty(EPC_RIGHT_AND_LEFT_WIND_DIRECTION, edt, setRightAndLeftWindDirection(edt));
			return this;
		}

		@Override
		public Setter reqSetVentilationMode(byte[] edt) {
			addProperty(EPC_VENTILATION_MODE, edt, setVentilationMode(edt));
			return this;
		}

		@Override
		public Setter reqSetHumidificationMode(byte[] edt) {
			addProperty(EPC_HUMIDIFICATION_MODE, edt, setHumidificationMode(edt));
			return this;
		}

		@Override
		public Setter reqSetVentilationAirVolume(byte[] edt) {
			addProperty(EPC_VENTILATION_AIR_VOLUME, edt, setVentilationAirVolume(edt));
			return this;
		}

		@Override
		public Setter reqSetHumidificationVolume(byte[] edt) {
			addProperty(EPC_HUMIDIFICATION_VOLUME, edt, setHumidificationVolume(edt));
			return this;
		}


		@Override
		public Setter reqSetAirCleaningMethodMode(byte[] edt) {
			addProperty(EPC_AIR_CLEANING_METHOD_MODE, edt, setAirCleaningMethodMode(edt));
			return this;
		}

		@Override
		public Setter reqSetRefreshMethodMode(byte[] edt) {
			addProperty(EPC_REFRESH_METHOD_MODE, edt, setRefreshMethodMode(edt));
			return this;
		}

		@Override
		public Setter reqSetSelfCleaningMethodMode(byte[] edt) {
			addProperty(EPC_SELF_CLEANING_METHOD_MODE, edt, setSelfCleaningMethodMode(edt));
			return this;
		}

		@Override
		public Setter reqSetSpecialMode(byte[] edt) {
			addProperty(EPC_SPECIAL_MODE, edt, setSpecialMode(edt));
			return this;
		}


		@Override
		public Setter reqSetForcedThermoMode(byte[] edt) {
			addProperty(EPC_FORCED_THERMO_MODE, edt, setForcedThermoMode(edt));
			return this;
		}

		@Override
		public Setter reqSetAirCleaningMode(byte[] edt) {
			addProperty(EPC_AIR_CLEANING_MODE, edt, setAirCleaningMode(edt));
			return this;
		}

		@Override
		public Setter reqSetOnTimerReservation(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION, edt, setOnTimerReservation(edt));
			return this;
		}

		@Override
		public Setter reqSetOnTimerTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_TIME, edt, setOnTimerTime(edt));
			return this;
		}

		@Override
		public Setter reqSetOnTimerRelativeTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_RELATIVE_TIME, edt, setOnTimerRelativeTime(edt));
			return this;
		}

		@Override
		public Setter reqSetOffTimerReservation(byte[] edt) {
			addProperty(EPC_OFF_TIMER_RESERVATION, edt, setOffTimerReservation(edt));
			return this;
		}

		@Override
		public Setter reqSetOffTimerTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_RELATIVE_TIME, edt, setOffTimerTime(edt));
			return this;
		}

		@Override
		public Setter reqSetOffTimerRelativeTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_RELATIVE_TIME, edt, setOffTimerRelativeTime(edt));
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
		public Setter reqSetMode(byte[] edt) {
			addProperty(EPC_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetAutomaticTemperatureSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_SETTING, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetRapidMode(byte[] edt) {
			addProperty(EPC_RAPID_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetTemperature(byte[] edt) {
			addProperty(EPC_TEMPERATURE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetRelativeTemperatureOnDehumidificationMode(byte[] edt) {
			addProperty(EPC_RELATIVE_TEMPERATURE_ON_DEHUMIDIFICATION_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetTemperatureOnCoolingMode(byte[] edt) {
			addProperty(EPC_TEMPERATURE_ON_COOLING_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetTemperatureOnHeatingMode(byte[] edt) {
			addProperty(EPC_TEMPERATURE_ON_HEATING_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetTemperatureOnDehumidificationMode(byte[] edt) {
			addProperty(EPC_TEMPERATURE_ON_DEHUMIDIFICATION_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}


		@Override
		public Setter reqSetRelativeTemperature(byte[] edt) {
			addProperty(EPC_RELATIVE_TEMPERATURE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetAirVolume(byte[] edt) {
			addProperty(EPC_AIR_VOLUME, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetAutomaticWindDirectionSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_WIND_DIRECTION_SETTING, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetSwingWindDirection(byte[] edt) {
			addProperty(EPC_SWING_WIND_DIRECTION, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetTopAndBottomWindDirection(byte[] edt) {
			addProperty(EPC_TOP_AND_BOTTOM_WIND_DIRECTION, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetRightAndLeftWindDirection(byte[] edt) {
			addProperty(EPC_RIGHT_AND_LEFT_WIND_DIRECTION, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetVentilationMode(byte[] edt) {
			addProperty(EPC_VENTILATION_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetHumidificationMode(byte[] edt) {
			addProperty(EPC_HUMIDIFICATION_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetVentilationAirVolume(byte[] edt) {
			addProperty(EPC_VENTILATION_AIR_VOLUME, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetHumidificationVolume(byte[] edt) {
			addProperty(EPC_HUMIDIFICATION_VOLUME, edt, (edt != null && edt.length == 1));
			return this;
		}


		@Override
		public Setter reqSetAirCleaningMethodMode(byte[] edt) {
			addProperty(EPC_AIR_CLEANING_METHOD_MODE, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Setter reqSetRefreshMethodMode(byte[] edt) {
			addProperty(EPC_REFRESH_METHOD_MODE, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Setter reqSetSelfCleaningMethodMode(byte[] edt) {
			addProperty(EPC_SELF_CLEANING_METHOD_MODE, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Setter reqSetSpecialMode(byte[] edt) {
			addProperty(EPC_SPECIAL_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}


		@Override
		public Setter reqSetForcedThermoMode(byte[] edt) {
			addProperty(EPC_FORCED_THERMO_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetAirCleaningMode(byte[] edt) {
			addProperty(EPC_AIR_CLEANING_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetOnTimerReservation(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetOnTimerTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_TIME, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Setter reqSetOnTimerRelativeTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_RELATIVE_TIME, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Setter reqSetOffTimerReservation(byte[] edt) {
			addProperty(EPC_OFF_TIMER_RESERVATION, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetOffTimerTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_RELATIVE_TIME, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Setter reqSetOffTimerRelativeTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_RELATIVE_TIME, edt, (edt != null && edt.length == 2));
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
		
		public Getter reqGetMode();
		public Getter reqGetAutomaticTemperatureSetting();
		public Getter reqGetRapidMode();
		public Getter reqGetTemperature();
		public Getter reqGetRelativeTemperatureOnDehumidificationMode();
		public Getter reqGetTemperatureOnCoolingMode();
		public Getter reqGetTemperatureOnHeatingMode();
		public Getter reqGetTemperatureOnDehumidificationMode();
		public Getter reqGetPowerDissipation();
		public Getter reqGetCurrentConsumption();
		public Getter reqGetIndoorRelativeTemperature();
		public Getter reqGetIndoorTemperature();
		public Getter reqGetUserRemoteControlTemperature();
		public Getter reqGetBlowoffTemperature();
		public Getter reqGetOutdoorAirTemperature();
		public Getter reqGetRelativeTemperature();
		public Getter reqGetAirVolume();
		public Getter reqGetAutomaticWindDirectionSetting();
		public Getter reqGetSwingWindDirection();
		public Getter reqGetTopAndBottomWindDirection();
		public Getter reqGetRightAndLeftWindDirection();
		public Getter reqGetSpecialState();
		public Getter reqGetNonprioritizedState();
		public Getter reqGetVentilationMode();
		public Getter reqGetHumidificationMode();
		public Getter reqGetVentilationAirVolume();
		public Getter reqGetHumidificationVolume();
		public Getter reqGetAirCleaningMethod();
		public Getter reqGetAirCleaningMethodMode();
		public Getter reqGetRefreshMethod();
		public Getter reqGetRefreshMethodMode();
		public Getter reqGetSelfCleaningMethod();
		public Getter reqGetSelfCleaningMethodMode();
		public Getter reqGetSpecialMode();
		public Getter reqGetInteriorAction();
		public Getter reqGetAirCleaningMode();
		public Getter reqGetOnTimerReservation();
		public Getter reqGetOnTimerTime();
		public Getter reqGetOnTimerRelativeTime();
		public Getter reqGetOffTimerReservation();
		public Getter reqGetOffTimerTime();
		public Getter reqGetOffTimerRelativeTime();
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
		public Getter reqGetMode() {
			byte[] edt = getMode();
			addProperty(EPC_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetAutomaticTemperatureSetting() {
			byte[] edt = getAutomaticTemperatureSetting();
			addProperty(EPC_AUTOMATIC_TEMPERATURE_SETTING, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetRapidMode() {
			byte[] edt = getRapidMode();
			addProperty(EPC_RAPID_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetTemperature() {
			byte[] edt = getTemperature();
			addProperty(EPC_TEMPERATURE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetRelativeTemperatureOnDehumidificationMode() {
			byte[] edt = getRelativeTemperatureOnDehumidificationMode();
			addProperty(EPC_RELATIVE_TEMPERATURE_ON_DEHUMIDIFICATION_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetTemperatureOnCoolingMode() {
			byte[] edt = getTemperatureOnCoolingMode();
			addProperty(EPC_TEMPERATURE_ON_COOLING_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetTemperatureOnHeatingMode() {
			byte[] edt = getTemperatureOnHeatingMode();
			addProperty(EPC_TEMPERATURE_ON_HEATING_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetTemperatureOnDehumidificationMode() {
			byte[] edt = getTemperatureOnDehumidificationMode();
			addProperty(EPC_TEMPERATURE_ON_DEHUMIDIFICATION_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetPowerDissipation() {
			byte[] edt = getPowerDissipation();
			addProperty(EPC_POWER_DISSIPATION, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetCurrentConsumption() {
			byte[] edt = getCurrentConsumption();
			addProperty(EPC_CURRENT_CONSUMPTION, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Getter reqGetIndoorRelativeTemperature() {
			byte[] edt = getIndoorRelativeTemperature();
			addProperty(EPC_INDOOR_RELATIVE_TEMPERATURE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetIndoorTemperature() {
			byte[] edt = getIndoorTemperature();
			addProperty(EPC_INDOOR_TEMPERATURE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetUserRemoteControlTemperature() {
			byte[] edt = getUserRemoteControlTemperature();
			addProperty(EPC_USER_REMOTE_CONTROL_TEMPERATURE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetBlowoffTemperature() {
			byte[] edt = getBlowoffTemperature();
			addProperty(EPC_BLOWOFF_TEMPERATURE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetOutdoorAirTemperature() {
			byte[] edt = getOutdoorAirTemperature();
			addProperty(EPC_OUTDOOR_AIR_TEMPERATURE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetRelativeTemperature() {
			byte[] edt = getRelativeTemperature();
			addProperty(EPC_RELATIVE_TEMPERATURE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetAirVolume() {
			byte[] edt = getAirVolume();
			addProperty(EPC_AIR_VOLUME, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetAutomaticWindDirectionSetting() {
			byte[] edt = getAutomaticWindDirectionSetting();
			addProperty(EPC_AUTOMATIC_WIND_DIRECTION_SETTING, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetSwingWindDirection() {
			byte[] edt = getSwingWindDirection();
			addProperty(EPC_SWING_WIND_DIRECTION, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetTopAndBottomWindDirection() {
			byte[] edt = getTopAndBottomWindDirection();
			addProperty(EPC_TOP_AND_BOTTOM_WIND_DIRECTION, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetRightAndLeftWindDirection() {
			byte[] edt = getRightAndLeftWindDirection();
			addProperty(EPC_RIGHT_AND_LEFT_WIND_DIRECTION, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetSpecialState() {
			byte[] edt = getSpecialState();
			addProperty(EPC_SPECIAL_STATE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetNonprioritizedState() {
			byte[] edt = getNonprioritizedState();
			addProperty(EPC_NONPRIORITIZED_STATE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetVentilationMode() {
			byte[] edt = getVentilationMode();
			addProperty(EPC_VENTILATION_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetHumidificationMode() {
			byte[] edt = getHumidificationMode();
			addProperty(EPC_HUMIDIFICATION_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetVentilationAirVolume() {
			byte[] edt = getVentilationAirVolume();
			addProperty(EPC_VENTILATION_AIR_VOLUME, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetHumidificationVolume() {
			byte[] edt = getHumidificationVolume();
			addProperty(EPC_HUMIDIFICATION_VOLUME, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetAirCleaningMethod() {
			byte[] edt = getAirCleaningMethod();
			addProperty(EPC_AIR_CLEANING_METHOD, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetAirCleaningMethodMode() {
			byte[] edt = getAirCleaningMethodMode();
			addProperty(EPC_AIR_CLEANING_METHOD_MODE, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetRefreshMethod() {
			byte[] edt = getRefreshMethod();
			addProperty(EPC_REFRESH_METHOD, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetRefreshMethodMode() {
			byte[] edt = getRefreshMethodMode();
			addProperty(EPC_REFRESH_METHOD_MODE, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetSelfCleaningMethod() {
			byte[] edt = getSelfCleaningMethod();
			addProperty(EPC_SELF_CLEANING_METHOD, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetSelfCleaningMethodMode() {
			byte[] edt = getSelfCleaningMethodMode();
			addProperty(EPC_SELF_CLEANING_METHOD_MODE, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetSpecialMode() {
			byte[] edt = getSpecialMode();
			addProperty(EPC_SPECIAL_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetInteriorAction() {
			byte[] edt = getInteriorAction();
			addProperty(EPC_INTERIOR_ACTION, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetAirCleaningMode() {
			byte[] edt = getAirCleaningMode();
			addProperty(EPC_AIR_CLEANING_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetOnTimerReservation() {
			byte[] edt = getOnTimerReservation();
			addProperty(EPC_ON_TIMER_RESERVATION, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetOnTimerTime() {
			byte[] edt = getOnTimerTime();
			addProperty(EPC_ON_TIMER_TIME, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Getter reqGetOnTimerRelativeTime() {
			byte[] edt = getOnTimerRelativeTime();
			addProperty(EPC_ON_TIMER_RELATIVE_TIME, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Getter reqGetOffTimerReservation() {
			byte[] edt = getOffTimerReservation();
			addProperty(EPC_OFF_TIMER_RESERVATION, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetOffTimerTime() {
			byte[] edt = getOffTimerTime();
			addProperty(EPC_OFF_TIMER_RELATIVE_TIME, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Getter reqGetOffTimerRelativeTime() {
			byte[] edt = getOffTimerRelativeTime();
			addProperty(EPC_OFF_TIMER_RELATIVE_TIME, edt, (edt != null && edt.length == 2));
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
		public Getter reqGetMode() {
			addProperty(EPC_MODE);
			return this;
		}

		@Override
		public Getter reqGetAutomaticTemperatureSetting() {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_SETTING);
			return this;
		}

		@Override
		public Getter reqGetRapidMode() {
			addProperty(EPC_RAPID_MODE);
			return this;
		}

		@Override
		public Getter reqGetTemperature() {
			addProperty(EPC_TEMPERATURE);
			return this;
		}

		@Override
		public Getter reqGetRelativeTemperatureOnDehumidificationMode() {
			addProperty(EPC_RELATIVE_TEMPERATURE_ON_DEHUMIDIFICATION_MODE);
			return this;
		}

		@Override
		public Getter reqGetTemperatureOnCoolingMode() {
			addProperty(EPC_TEMPERATURE_ON_COOLING_MODE);
			return this;
		}

		@Override
		public Getter reqGetTemperatureOnHeatingMode() {
			addProperty(EPC_TEMPERATURE_ON_HEATING_MODE);
			return this;
		}

		@Override
		public Getter reqGetTemperatureOnDehumidificationMode() {
			addProperty(EPC_TEMPERATURE_ON_DEHUMIDIFICATION_MODE);
			return this;
		}

		@Override
		public Getter reqGetPowerDissipation() {
			addProperty(EPC_POWER_DISSIPATION);
			return this;
		}

		@Override
		public Getter reqGetCurrentConsumption() {
			addProperty(EPC_CURRENT_CONSUMPTION);
			return this;
		}

		@Override
		public Getter reqGetIndoorRelativeTemperature() {
			addProperty(EPC_INDOOR_RELATIVE_TEMPERATURE);
			return this;
		}

		@Override
		public Getter reqGetIndoorTemperature() {
			addProperty(EPC_INDOOR_TEMPERATURE);
			return this;
		}

		@Override
		public Getter reqGetUserRemoteControlTemperature() {
			addProperty(EPC_USER_REMOTE_CONTROL_TEMPERATURE);
			return this;
		}

		@Override
		public Getter reqGetBlowoffTemperature() {
			addProperty(EPC_BLOWOFF_TEMPERATURE);
			return this;
		}

		@Override
		public Getter reqGetOutdoorAirTemperature() {
			addProperty(EPC_OUTDOOR_AIR_TEMPERATURE);
			return this;
		}

		@Override
		public Getter reqGetRelativeTemperature() {
			addProperty(EPC_RELATIVE_TEMPERATURE);
			return this;
		}

		@Override
		public Getter reqGetAirVolume() {
			addProperty(EPC_AIR_VOLUME);
			return this;
		}

		@Override
		public Getter reqGetAutomaticWindDirectionSetting() {
			addProperty(EPC_AUTOMATIC_WIND_DIRECTION_SETTING);
			return this;
		}

		@Override
		public Getter reqGetSwingWindDirection() {
			addProperty(EPC_SWING_WIND_DIRECTION);
			return this;
		}

		@Override
		public Getter reqGetTopAndBottomWindDirection() {
			addProperty(EPC_TOP_AND_BOTTOM_WIND_DIRECTION);
			return this;
		}

		@Override
		public Getter reqGetRightAndLeftWindDirection() {
			addProperty(EPC_RIGHT_AND_LEFT_WIND_DIRECTION);
			return this;
		}

		@Override
		public Getter reqGetSpecialState() {
			addProperty(EPC_SPECIAL_STATE);
			return this;
		}

		@Override
		public Getter reqGetNonprioritizedState() {
			addProperty(EPC_NONPRIORITIZED_STATE);
			return this;
		}

		@Override
		public Getter reqGetVentilationMode() {
			addProperty(EPC_VENTILATION_MODE);
			return this;
		}

		@Override
		public Getter reqGetHumidificationMode() {
			addProperty(EPC_HUMIDIFICATION_MODE);
			return this;
		}

		@Override
		public Getter reqGetVentilationAirVolume() {
			addProperty(EPC_VENTILATION_AIR_VOLUME);
			return this;
		}

		@Override
		public Getter reqGetHumidificationVolume() {
			addProperty(EPC_HUMIDIFICATION_VOLUME);
			return this;
		}

		@Override
		public Getter reqGetAirCleaningMethod() {
			addProperty(EPC_AIR_CLEANING_METHOD);
			return this;
		}

		@Override
		public Getter reqGetAirCleaningMethodMode() {
			addProperty(EPC_AIR_CLEANING_METHOD_MODE);
			return this;
		}

		@Override
		public Getter reqGetRefreshMethod() {
			addProperty(EPC_REFRESH_METHOD);
			return this;
		}

		@Override
		public Getter reqGetRefreshMethodMode() {
			addProperty(EPC_REFRESH_METHOD_MODE);
			return this;
		}

		@Override
		public Getter reqGetSelfCleaningMethod() {
			addProperty(EPC_SELF_CLEANING_METHOD);
			return this;
		}

		@Override
		public Getter reqGetSelfCleaningMethodMode() {
			addProperty(EPC_SELF_CLEANING_METHOD_MODE);
			return this;
		}

		@Override
		public Getter reqGetSpecialMode() {
			addProperty(EPC_SPECIAL_MODE);
			return this;
		}

		@Override
		public Getter reqGetInteriorAction() {
			addProperty(EPC_INTERIOR_ACTION);
			return this;
		}

		@Override
		public Getter reqGetAirCleaningMode() {
			addProperty(EPC_AIR_CLEANING_MODE);
			return this;
		}

		@Override
		public Getter reqGetOnTimerReservation() {
			addProperty(EPC_ON_TIMER_RESERVATION);
			return this;
		}

		@Override
		public Getter reqGetOnTimerTime() {
			addProperty(EPC_ON_TIMER_TIME);
			return this;
		}

		@Override
		public Getter reqGetOnTimerRelativeTime() {
			addProperty(EPC_ON_TIMER_RELATIVE_TIME);
			return this;
		}

		@Override
		public Getter reqGetOffTimerReservation() {
			addProperty(EPC_OFF_TIMER_RESERVATION);
			return this;
		}

		@Override
		public Getter reqGetOffTimerTime() {
			addProperty(EPC_OFF_TIMER_RELATIVE_TIME);
			return this;
		}

		@Override
		public Getter reqGetOffTimerRelativeTime() {
			addProperty(EPC_OFF_TIMER_RELATIVE_TIME);
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

		public Informer reqInformMode();
		public Informer reqInformAutomaticTemperatureSetting();
		public Informer reqInformRapidMode();
		public Informer reqInformTemperature();
		public Informer reqInformRelativeTemperatureOnDehumidificationMode();
		public Informer reqInformTemperatureOnCoolingMode();
		public Informer reqInformTemperatureOnHeatingMode();
		public Informer reqInformTemperatureOnDehumidificationMode();
		public Informer reqInformPowerDissipation();
		public Informer reqInformCurrentConsumption();
		public Informer reqInformIndoorRelativeTemperature();
		public Informer reqInformIndoorTemperature();
		public Informer reqInformUserRemoteControlTemperature();
		public Informer reqInformBlowoffTemperature();
		public Informer reqInformOutdoorAirTemperature();
		public Informer reqInformRelativeTemperature();
		public Informer reqInformAirVolume();
		public Informer reqInformAutomaticWindDirectionSetting();
		public Informer reqInformSwingWindDirection();
		public Informer reqInformTopAndBottomWindDirection();
		public Informer reqInformRightAndLeftWindDirection();
		public Informer reqInformSpecialState();
		public Informer reqInformNonprioritizedState();
		public Informer reqInformVentilationMode();
		public Informer reqInformHumidificationMode();
		public Informer reqInformVentilationAirVolume();
		public Informer reqInformHumidificationVolume();
		public Informer reqInformAirCleaningMethod();
		public Informer reqInformAirCleaningMethodMode();
		public Informer reqInformRefreshMethod();
		public Informer reqInformRefreshMethodMode();
		public Informer reqInformSelfCleaningMethod();
		public Informer reqInformSelfCleaningMethodMode();
		public Informer reqInformSpecialMode();
		public Informer reqInformInteriorAction();
		public Informer reqInformAirCleaningMode();
		public Informer reqInformOnTimerReservation();
		public Informer reqInformOnTimerTime();
		public Informer reqInformOnTimerRelativeTime();
		public Informer reqInformOffTimerReservation();
		public Informer reqInformOffTimerTime();
		public Informer reqInformOffTimerRelativeTime();
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
		public Informer reqInformMode() {
			byte[] edt = getMode();
			addProperty(EPC_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformAutomaticTemperatureSetting() {
			byte[] edt = getAutomaticTemperatureSetting();
			addProperty(EPC_AUTOMATIC_TEMPERATURE_SETTING, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformRapidMode() {
			byte[] edt = getRapidMode();
			addProperty(EPC_RAPID_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformTemperature() {
			byte[] edt = getTemperature();
			addProperty(EPC_TEMPERATURE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformRelativeTemperatureOnDehumidificationMode() {
			byte[] edt = getRelativeTemperatureOnDehumidificationMode();
			addProperty(EPC_RELATIVE_TEMPERATURE_ON_DEHUMIDIFICATION_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformTemperatureOnCoolingMode() {
			byte[] edt = getTemperatureOnCoolingMode();
			addProperty(EPC_TEMPERATURE_ON_COOLING_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformTemperatureOnHeatingMode() {
			byte[] edt = getTemperatureOnHeatingMode();
			addProperty(EPC_TEMPERATURE_ON_HEATING_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformTemperatureOnDehumidificationMode() {
			byte[] edt = getTemperatureOnDehumidificationMode();
			addProperty(EPC_TEMPERATURE_ON_DEHUMIDIFICATION_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformPowerDissipation() {
			byte[] edt = getPowerDissipation();
			addProperty(EPC_POWER_DISSIPATION, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformCurrentConsumption() {
			byte[] edt = getCurrentConsumption();
			addProperty(EPC_CURRENT_CONSUMPTION, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformIndoorRelativeTemperature() {
			byte[] edt = getIndoorRelativeTemperature();
			addProperty(EPC_INDOOR_RELATIVE_TEMPERATURE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformIndoorTemperature() {
			byte[] edt = getIndoorTemperature();
			addProperty(EPC_INDOOR_TEMPERATURE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformUserRemoteControlTemperature() {
			byte[] edt = getUserRemoteControlTemperature();
			addProperty(EPC_USER_REMOTE_CONTROL_TEMPERATURE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformBlowoffTemperature() {
			byte[] edt = getBlowoffTemperature();
			addProperty(EPC_BLOWOFF_TEMPERATURE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformOutdoorAirTemperature() {
			byte[] edt = getOutdoorAirTemperature();
			addProperty(EPC_OUTDOOR_AIR_TEMPERATURE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformRelativeTemperature() {
			byte[] edt = getRelativeTemperature();
			addProperty(EPC_RELATIVE_TEMPERATURE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformAirVolume() {
			byte[] edt = getAirVolume();
			addProperty(EPC_AIR_VOLUME, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformAutomaticWindDirectionSetting() {
			byte[] edt = getAutomaticWindDirectionSetting();
			addProperty(EPC_AUTOMATIC_WIND_DIRECTION_SETTING, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformSwingWindDirection() {
			byte[] edt = getSwingWindDirection();
			addProperty(EPC_SWING_WIND_DIRECTION, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformTopAndBottomWindDirection() {
			byte[] edt = getTopAndBottomWindDirection();
			addProperty(EPC_TOP_AND_BOTTOM_WIND_DIRECTION, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformRightAndLeftWindDirection() {
			byte[] edt = getRightAndLeftWindDirection();
			addProperty(EPC_RIGHT_AND_LEFT_WIND_DIRECTION, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformSpecialState() {
			byte[] edt = getSpecialState();
			addProperty(EPC_SPECIAL_STATE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformNonprioritizedState() {
			byte[] edt = getNonprioritizedState();
			addProperty(EPC_NONPRIORITIZED_STATE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformVentilationMode() {
			byte[] edt = getVentilationMode();
			addProperty(EPC_VENTILATION_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformHumidificationMode() {
			byte[] edt = getHumidificationMode();
			addProperty(EPC_HUMIDIFICATION_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformVentilationAirVolume() {
			byte[] edt = getVentilationAirVolume();
			addProperty(EPC_VENTILATION_AIR_VOLUME, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformHumidificationVolume() {
			byte[] edt = getHumidificationVolume();
			addProperty(EPC_HUMIDIFICATION_VOLUME, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformAirCleaningMethod() {
			byte[] edt = getAirCleaningMethod();
			addProperty(EPC_AIR_CLEANING_METHOD, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformAirCleaningMethodMode() {
			byte[] edt = getAirCleaningMethodMode();
			addProperty(EPC_AIR_CLEANING_METHOD_MODE, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformRefreshMethod() {
			byte[] edt = getRefreshMethod();
			addProperty(EPC_REFRESH_METHOD, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformRefreshMethodMode() {
			byte[] edt = getRefreshMethodMode();
			addProperty(EPC_REFRESH_METHOD_MODE, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformSelfCleaningMethod() {
			byte[] edt = getSelfCleaningMethod();
			addProperty(EPC_SELF_CLEANING_METHOD, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformSelfCleaningMethodMode() {
			byte[] edt = getSelfCleaningMethodMode();
			addProperty(EPC_SELF_CLEANING_METHOD_MODE, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformSpecialMode() {
			byte[] edt = getSpecialMode();
			addProperty(EPC_SPECIAL_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformInteriorAction() {
			byte[] edt = getInteriorAction();
			addProperty(EPC_INTERIOR_ACTION, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformAirCleaningMode() {
			byte[] edt = getAirCleaningMode();
			addProperty(EPC_AIR_CLEANING_MODE, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformOnTimerReservation() {
			byte[] edt = getOnTimerReservation();
			addProperty(EPC_ON_TIMER_RESERVATION, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformOnTimerTime() {
			byte[] edt = getOnTimerTime();
			addProperty(EPC_ON_TIMER_TIME, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformOnTimerRelativeTime() {
			byte[] edt = getOnTimerRelativeTime();
			addProperty(EPC_ON_TIMER_RELATIVE_TIME, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformOffTimerReservation() {
			byte[] edt = getOffTimerReservation();
			addProperty(EPC_OFF_TIMER_RESERVATION, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformOffTimerTime() {
			byte[] edt = getOffTimerTime();
			addProperty(EPC_OFF_TIMER_RELATIVE_TIME, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformOffTimerRelativeTime() {
			byte[] edt = getOffTimerRelativeTime();
			addProperty(EPC_OFF_TIMER_RELATIVE_TIME, edt, (edt != null && edt.length == 2));
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
		public Informer reqInformMode() {
			addProperty(EPC_MODE);
			return this;
		}

		@Override
		public Informer reqInformAutomaticTemperatureSetting() {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_SETTING);
			return this;
		}

		@Override
		public Informer reqInformRapidMode() {
			addProperty(EPC_RAPID_MODE);
			return this;
		}

		@Override
		public Informer reqInformTemperature() {
			addProperty(EPC_TEMPERATURE);
			return this;
		}

		@Override
		public Informer reqInformRelativeTemperatureOnDehumidificationMode() {
			addProperty(EPC_RELATIVE_TEMPERATURE_ON_DEHUMIDIFICATION_MODE);
			return this;
		}

		@Override
		public Informer reqInformTemperatureOnCoolingMode() {
			addProperty(EPC_TEMPERATURE_ON_COOLING_MODE);
			return this;
		}

		@Override
		public Informer reqInformTemperatureOnHeatingMode() {
			addProperty(EPC_TEMPERATURE_ON_HEATING_MODE);
			return this;
		}

		@Override
		public Informer reqInformTemperatureOnDehumidificationMode() {
			addProperty(EPC_TEMPERATURE_ON_DEHUMIDIFICATION_MODE);
			return this;
		}

		@Override
		public Informer reqInformPowerDissipation() {
			addProperty(EPC_POWER_DISSIPATION);
			return this;
		}

		@Override
		public Informer reqInformCurrentConsumption() {
			addProperty(EPC_CURRENT_CONSUMPTION);
			return this;
		}

		@Override
		public Informer reqInformIndoorRelativeTemperature() {
			addProperty(EPC_INDOOR_RELATIVE_TEMPERATURE);
			return this;
		}

		@Override
		public Informer reqInformIndoorTemperature() {
			addProperty(EPC_INDOOR_TEMPERATURE);
			return this;
		}

		@Override
		public Informer reqInformUserRemoteControlTemperature() {
			addProperty(EPC_USER_REMOTE_CONTROL_TEMPERATURE);
			return this;
		}

		@Override
		public Informer reqInformBlowoffTemperature() {
			addProperty(EPC_BLOWOFF_TEMPERATURE);
			return this;
		}

		@Override
		public Informer reqInformOutdoorAirTemperature() {
			addProperty(EPC_OUTDOOR_AIR_TEMPERATURE);
			return this;
		}

		@Override
		public Informer reqInformRelativeTemperature() {
			addProperty(EPC_RELATIVE_TEMPERATURE);
			return this;
		}

		@Override
		public Informer reqInformAirVolume() {
			addProperty(EPC_AIR_VOLUME);
			return this;
		}

		@Override
		public Informer reqInformAutomaticWindDirectionSetting() {
			addProperty(EPC_AUTOMATIC_WIND_DIRECTION_SETTING);
			return this;
		}

		@Override
		public Informer reqInformSwingWindDirection() {
			addProperty(EPC_SWING_WIND_DIRECTION);
			return this;
		}

		@Override
		public Informer reqInformTopAndBottomWindDirection() {
			addProperty(EPC_TOP_AND_BOTTOM_WIND_DIRECTION);
			return this;
		}

		@Override
		public Informer reqInformRightAndLeftWindDirection() {
			addProperty(EPC_RIGHT_AND_LEFT_WIND_DIRECTION);
			return this;
		}

		@Override
		public Informer reqInformSpecialState() {
			addProperty(EPC_SPECIAL_STATE);
			return this;
		}

		@Override
		public Informer reqInformNonprioritizedState() {
			addProperty(EPC_NONPRIORITIZED_STATE);
			return this;
		}

		@Override
		public Informer reqInformVentilationMode() {
			addProperty(EPC_VENTILATION_MODE);
			return this;
		}

		@Override
		public Informer reqInformHumidificationMode() {
			addProperty(EPC_HUMIDIFICATION_MODE);
			return this;
		}

		@Override
		public Informer reqInformVentilationAirVolume() {
			addProperty(EPC_VENTILATION_AIR_VOLUME);
			return this;
		}

		@Override
		public Informer reqInformHumidificationVolume() {
			addProperty(EPC_HUMIDIFICATION_VOLUME);
			return this;
		}

		@Override
		public Informer reqInformAirCleaningMethod() {
			addProperty(EPC_AIR_CLEANING_METHOD);
			return this;
		}

		@Override
		public Informer reqInformAirCleaningMethodMode() {
			addProperty(EPC_AIR_CLEANING_METHOD_MODE);
			return this;
		}

		@Override
		public Informer reqInformRefreshMethod() {
			addProperty(EPC_REFRESH_METHOD);
			return this;
		}

		@Override
		public Informer reqInformRefreshMethodMode() {
			addProperty(EPC_REFRESH_METHOD_MODE);
			return this;
		}

		@Override
		public Informer reqInformSelfCleaningMethod() {
			addProperty(EPC_SELF_CLEANING_METHOD);
			return this;
		}

		@Override
		public Informer reqInformSelfCleaningMethodMode() {
			addProperty(EPC_SELF_CLEANING_METHOD_MODE);
			return this;
		}

		@Override
		public Informer reqInformSpecialMode() {
			addProperty(EPC_SPECIAL_MODE);
			return this;
		}

		@Override
		public Informer reqInformInteriorAction() {
			addProperty(EPC_INTERIOR_ACTION);
			return this;
		}

		@Override
		public Informer reqInformAirCleaningMode() {
			addProperty(EPC_AIR_CLEANING_MODE);
			return this;
		}

		@Override
		public Informer reqInformOnTimerReservation() {
			addProperty(EPC_ON_TIMER_RESERVATION);
			return this;
		}

		@Override
		public Informer reqInformOnTimerTime() {
			addProperty(EPC_ON_TIMER_TIME);
			return this;
		}

		@Override
		public Informer reqInformOnTimerRelativeTime() {
			addProperty(EPC_ON_TIMER_RELATIVE_TIME);
			return this;
		}

		@Override
		public Informer reqInformOffTimerReservation() {
			addProperty(EPC_OFF_TIMER_RESERVATION);
			return this;
		}

		@Override
		public Informer reqInformOffTimerTime() {
			addProperty(EPC_OFF_TIMER_RELATIVE_TIME);
			return this;
		}

		@Override
		public Informer reqInformOffTimerRelativeTime() {
			addProperty(EPC_OFF_TIMER_RELATIVE_TIME);
			return this;
		}
	}
}
