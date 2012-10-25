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

public abstract class AirCleaner extends DeviceObject {
	
	public static final byte CLASS_GROUP_CODE = (byte)0x01;
	public static final byte CLASS_CODE = (byte)0x35;
	
	public AirCleaner() {
		setReceiver(new Receiver());
	}

	public static final byte EPC_FILTER_CHANGE_NOTICE = (byte)0xE1;
	public static final byte EPC_AIR_FLOW_RATE_SETTING = (byte)0xA0;
	public static final byte EPC_SMOKE_CIGARETTE_DETECTION_STATUS = (byte)0xC1;
	public static final byte EPC_OPTICAL_CATALYST_OPERATION_SETTING = (byte)0xC2;
	public static final byte EPC_AIR_POLLUTION_DETECTION_STATUS = (byte)0xC0;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Filter change time notice found/not found<br><br>Found = 0x41, Not found = 0x42<br><br>Name : Filter change notice<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getFilterChangeNotice() {return null;}
	private final byte[] _getFilterChangeNotice(byte epc) {
		byte[] edt = getFilterChangeNotice();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Sets air flow rate level and air flow rate auto status. The ventilation air flow rate is specified (8-step).<br><br>Ventilation air flow rate auto status = 0x41 Ventilation air flow rate level = 0x31.0x38<br><br>Name : Air flow rate setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setAirFlowRateSetting(byte[] edt) {return false;}
	private final boolean _setAirFlowRateSetting(byte epc, byte[] edt) {
		boolean success = setAirFlowRateSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Sets air flow rate level and air flow rate auto status. The ventilation air flow rate is specified (8-step).<br><br>Ventilation air flow rate auto status = 0x41 Ventilation air flow rate level = 0x31.0x38<br><br>Name : Air flow rate setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getAirFlowRateSetting() {return null;}
	private final byte[] _getAirFlowRateSetting(byte epc) {
		byte[] edt = getAirFlowRateSetting();
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
	/**
	 * Optical catalyst ON/OFF status<br><br>Optical catalyst ON = 0x41 Optical catalyst OFF = 0x42<br><br>Name : Optical catalyst operation setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOpticalCatalystOperationSetting(byte[] edt) {return false;}
	private final boolean _setOpticalCatalystOperationSetting(byte epc, byte[] edt) {
		boolean success = setOpticalCatalystOperationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Optical catalyst ON/OFF status<br><br>Optical catalyst ON = 0x41 Optical catalyst OFF = 0x42<br><br>Name : Optical catalyst operation setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOpticalCatalystOperationSetting() {return null;}
	private final byte[] _getOpticalCatalystOperationSetting(byte epc) {
		byte[] edt = getOpticalCatalystOperationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates air pollution detection status<br><br>Air pollution detected = 0x41 Air pollution non-detected = 0x42<br><br>Name : Air pollution detection status<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getAirPollutionDetectionStatus() {return null;}
	private final byte[] _getAirPollutionDetectionStatus(byte epc) {
		byte[] edt = getAirPollutionDetectionStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_AIR_FLOW_RATE_SETTING:
			res.addProperty(epc, edt, _setAirFlowRateSetting(epc, edt));
			break;
		case EPC_OPTICAL_CATALYST_OPERATION_SETTING:
			res.addProperty(epc, edt, _setOpticalCatalystOperationSetting(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_FILTER_CHANGE_NOTICE:
			edt = _getFilterChangeNotice(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AIR_FLOW_RATE_SETTING:
			edt = _getAirFlowRateSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SMOKE_CIGARETTE_DETECTION_STATUS:
			edt = _getSmokeCigaretteDetectionStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OPTICAL_CATALYST_OPERATION_SETTING:
			edt = _getOpticalCatalystOperationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AIR_POLLUTION_DETECTION_STATUS:
			edt = _getAirPollutionDetectionStatus(epc);
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
			case EPC_AIR_FLOW_RATE_SETTING:
				_onSetAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_OPTICAL_CATALYST_OPERATION_SETTING:
				_onSetOpticalCatalystOperationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_FILTER_CHANGE_NOTICE:
				_onGetFilterChangeNotice(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_AIR_FLOW_RATE_SETTING:
				_onGetAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SMOKE_CIGARETTE_DETECTION_STATUS:
				_onGetSmokeCigaretteDetectionStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OPTICAL_CATALYST_OPERATION_SETTING:
				_onGetOpticalCatalystOperationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_AIR_POLLUTION_DETECTION_STATUS:
				_onGetAirPollutionDetectionStatus(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * Filter change time notice found/not found<br><br>Found = 0x41, Not found = 0x42<br><br>Name : Filter change notice<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetFilterChangeNotice(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetFilterChangeNotice(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetFilterChangeNotice(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets air flow rate level and air flow rate auto status. The ventilation air flow rate is specified (8-step).<br><br>Ventilation air flow rate auto status = 0x41 Ventilation air flow rate level = 0x31.0x38<br><br>Name : Air flow rate setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets air flow rate level and air flow rate auto status. The ventilation air flow rate is specified (8-step).<br><br>Ventilation air flow rate auto status = 0x41 Ventilation air flow rate level = 0x31.0x38<br><br>Name : Air flow rate setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt);
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
		/**
		 * Optical catalyst ON/OFF status<br><br>Optical catalyst ON = 0x41 Optical catalyst OFF = 0x42<br><br>Name : Optical catalyst operation setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOpticalCatalystOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOpticalCatalystOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOpticalCatalystOperationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Optical catalyst ON/OFF status<br><br>Optical catalyst ON = 0x41 Optical catalyst OFF = 0x42<br><br>Name : Optical catalyst operation setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOpticalCatalystOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOpticalCatalystOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOpticalCatalystOperationSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates air pollution detection status<br><br>Air pollution detected = 0x41 Air pollution non-detected = 0x42<br><br>Name : Air pollution detection status<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetAirPollutionDetectionStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAirPollutionDetectionStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAirPollutionDetectionStatus(eoj, tid, esv, epc, pdc, edt);
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
		 * Sets air flow rate level and air flow rate auto status. The ventilation air flow rate is specified (8-step).<br><br>Ventilation air flow rate auto status = 0x41 Ventilation air flow rate level = 0x31.0x38<br><br>Name : Air flow rate setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetAirFlowRateSetting(byte[] edt) {
			addProperty(EPC_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Optical catalyst ON/OFF status<br><br>Optical catalyst ON = 0x41 Optical catalyst OFF = 0x42<br><br>Name : Optical catalyst operation setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOpticalCatalystOperationSetting(byte[] edt) {
			addProperty(EPC_OPTICAL_CATALYST_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
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
		 * Filter change time notice found/not found<br><br>Found = 0x41, Not found = 0x42<br><br>Name : Filter change notice<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetFilterChangeNotice() {
			addProperty(EPC_FILTER_CHANGE_NOTICE);
			return this;
		}
		/**
		 * Sets air flow rate level and air flow rate auto status. The ventilation air flow rate is specified (8-step).<br><br>Ventilation air flow rate auto status = 0x41 Ventilation air flow rate level = 0x31.0x38<br><br>Name : Air flow rate setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetAirFlowRateSetting() {
			addProperty(EPC_AIR_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * This property indicates smoke (cigarette) detection status.<br><br>Smoke (cigarette) detection status found = 0x41 Smoke (cigarette) detection status not found = 0x42<br><br>Name : Smoke (cigarette) detection status<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetSmokeCigaretteDetectionStatus() {
			addProperty(EPC_SMOKE_CIGARETTE_DETECTION_STATUS);
			return this;
		}
		/**
		 * Optical catalyst ON/OFF status<br><br>Optical catalyst ON = 0x41 Optical catalyst OFF = 0x42<br><br>Name : Optical catalyst operation setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOpticalCatalystOperationSetting() {
			addProperty(EPC_OPTICAL_CATALYST_OPERATION_SETTING);
			return this;
		}
		/**
		 * This property indicates air pollution detection status<br><br>Air pollution detected = 0x41 Air pollution non-detected = 0x42<br><br>Name : Air pollution detection status<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetAirPollutionDetectionStatus() {
			addProperty(EPC_AIR_POLLUTION_DETECTION_STATUS);
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
		 * Filter change time notice found/not found<br><br>Found = 0x41, Not found = 0x42<br><br>Name : Filter change notice<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformFilterChangeNotice();
		/**
		 * Sets air flow rate level and air flow rate auto status. The ventilation air flow rate is specified (8-step).<br><br>Ventilation air flow rate auto status = 0x41 Ventilation air flow rate level = 0x31.0x38<br><br>Name : Air flow rate setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformAirFlowRateSetting();
		/**
		 * This property indicates smoke (cigarette) detection status.<br><br>Smoke (cigarette) detection status found = 0x41 Smoke (cigarette) detection status not found = 0x42<br><br>Name : Smoke (cigarette) detection status<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformSmokeCigaretteDetectionStatus();
		/**
		 * Optical catalyst ON/OFF status<br><br>Optical catalyst ON = 0x41 Optical catalyst OFF = 0x42<br><br>Name : Optical catalyst operation setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOpticalCatalystOperationSetting();
		/**
		 * This property indicates air pollution detection status<br><br>Air pollution detected = 0x41 Air pollution non-detected = 0x42<br><br>Name : Air pollution detection status<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformAirPollutionDetectionStatus();
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
		public Informer reqInformFilterChangeNotice() {
			byte epc = EPC_FILTER_CHANGE_NOTICE;
			byte[] edt = _getFilterChangeNotice(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAirFlowRateSetting() {
			byte epc = EPC_AIR_FLOW_RATE_SETTING;
			byte[] edt = _getAirFlowRateSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSmokeCigaretteDetectionStatus() {
			byte epc = EPC_SMOKE_CIGARETTE_DETECTION_STATUS;
			byte[] edt = _getSmokeCigaretteDetectionStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOpticalCatalystOperationSetting() {
			byte epc = EPC_OPTICAL_CATALYST_OPERATION_SETTING;
			byte[] edt = _getOpticalCatalystOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAirPollutionDetectionStatus() {
			byte epc = EPC_AIR_POLLUTION_DETECTION_STATUS;
			byte[] edt = _getAirPollutionDetectionStatus(epc);
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
		public Informer reqInformFilterChangeNotice() {
			addProperty(EPC_FILTER_CHANGE_NOTICE);
			return this;
		}
		@Override
		public Informer reqInformAirFlowRateSetting() {
			addProperty(EPC_AIR_FLOW_RATE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformSmokeCigaretteDetectionStatus() {
			addProperty(EPC_SMOKE_CIGARETTE_DETECTION_STATUS);
			return this;
		}
		@Override
		public Informer reqInformOpticalCatalystOperationSetting() {
			addProperty(EPC_OPTICAL_CATALYST_OPERATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformAirPollutionDetectionStatus() {
			addProperty(EPC_AIR_POLLUTION_DETECTION_STATUS);
			return this;
		}
	}
}
