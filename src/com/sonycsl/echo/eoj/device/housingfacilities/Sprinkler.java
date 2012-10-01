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

public abstract class Sprinkler extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = Sprinkler.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x67;

	protected static final byte EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING = (byte)0xE0;
	protected static final byte EPC_SPRINKLE_INTERVAL_SETTING = (byte)0xE1;
	protected static final byte EPC_NUMBER_OF_SPRINKLES_SETTING = (byte)0xE2;
	protected static final byte EPC_SPRINKLE_TIME_SETTING1 = (byte)0xE3;
	protected static final byte EPC_SPRINKLE_TIME_SETTING2 = (byte)0xE4;
	protected static final byte EPC_SPRINKLE_DURATION_SETTING = (byte)0xE5;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Open/close of sprinkle valve<br>Automatic ON=0x40    manual ON�� 0x41�Cmanual OFF��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract boolean setSprinkleValveOpenCloseSetting(byte[] edt);
	/**
	 * Open/close of sprinkle valve<br>Automatic ON=0x40    manual ON�� 0x41�Cmanual OFF��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract byte[] getSprinkleValveOpenCloseSetting();
	/**
	 * OFF / daily / every other day / every 3 days / once a week<br>0x40�^0x41�^0x42�^0x43�^0x44<br><br>Data type : unsigned long<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setSprinkleIntervalSetting(byte[] edt) {return false;}
	/**
	 * OFF / daily / every other day / every 3 days / once a week<br>0x40�^0x41�^0x42�^0x43�^0x44<br><br>Data type : unsigned long<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getSprinkleIntervalSetting() {return null;}
	/**
	 * Number of sprinkles in a day(up to 2 times) First ON�^second ON�^both ON<br>0x41�^0x42�^0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setNumberOfSprinklesSetting(byte[] edt) {return false;}
	/**
	 * Number of sprinkles in a day(up to 2 times) First ON�^second ON�^both ON<br>0x41�^0x42�^0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getNumberOfSprinklesSetting() {return null;}
	/**
	 * Set timer value HH:MM and get updated time<br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setSprinkleTimeSetting1(byte[] edt) {return false;}
	/**
	 * Set timer value HH:MM and get updated time<br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getSprinkleTimeSetting1() {return null;}
	/**
	 * Set timer value HH:MM and get updated time<br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setSprinkleTimeSetting2(byte[] edt) {return false;}
	/**
	 * Set timer value HH:MM and get updated time<br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getSprinkleTimeSetting2() {return null;}
	/**
	 * Set timer value MM 0 to 59 minutes<br>0-0x3B (=0~59)<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setSprinkleDurationSetting(byte[] edt) {return false;}
	/**
	 * Set timer value MM 0 to 59 minutes<br>0-0x3B (=0~59)<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getSprinkleDurationSetting() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING:
			res.addProperty(epc, edt, setSprinkleValveOpenCloseSetting(edt));
			break;
		case EPC_SPRINKLE_INTERVAL_SETTING:
			res.addProperty(epc, edt, setSprinkleIntervalSetting(edt));
			break;
		case EPC_NUMBER_OF_SPRINKLES_SETTING:
			res.addProperty(epc, edt, setNumberOfSprinklesSetting(edt));
			break;
		case EPC_SPRINKLE_TIME_SETTING1:
			res.addProperty(epc, edt, setSprinkleTimeSetting1(edt));
			break;
		case EPC_SPRINKLE_TIME_SETTING2:
			res.addProperty(epc, edt, setSprinkleTimeSetting2(edt));
			break;
		case EPC_SPRINKLE_DURATION_SETTING:
			res.addProperty(epc, edt, setSprinkleDurationSetting(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING:
			edt = getSprinkleValveOpenCloseSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SPRINKLE_INTERVAL_SETTING:
			edt = getSprinkleIntervalSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_NUMBER_OF_SPRINKLES_SETTING:
			edt = getNumberOfSprinklesSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SPRINKLE_TIME_SETTING1:
			edt = getSprinkleTimeSetting1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_SPRINKLE_TIME_SETTING2:
			edt = getSprinkleTimeSetting2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_SPRINKLE_DURATION_SETTING:
			edt = getSprinkleDurationSetting();
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
			case EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING:
				onSetSprinkleValveOpenCloseSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_SPRINKLE_INTERVAL_SETTING:
				onSetSprinkleIntervalSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_NUMBER_OF_SPRINKLES_SETTING:
				onSetNumberOfSprinklesSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_SPRINKLE_TIME_SETTING1:
				onSetSprinkleTimeSetting1(eoj, tid, (pdc != 0));
				break;
			case EPC_SPRINKLE_TIME_SETTING2:
				onSetSprinkleTimeSetting2(eoj, tid, (pdc != 0));
				break;
			case EPC_SPRINKLE_DURATION_SETTING:
				onSetSprinkleDurationSetting(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING:
				onGetSprinkleValveOpenCloseSetting(eoj, tid, pdc, edt);
				break;
			case EPC_SPRINKLE_INTERVAL_SETTING:
				onGetSprinkleIntervalSetting(eoj, tid, pdc, edt);
				break;
			case EPC_NUMBER_OF_SPRINKLES_SETTING:
				onGetNumberOfSprinklesSetting(eoj, tid, pdc, edt);
				break;
			case EPC_SPRINKLE_TIME_SETTING1:
				onGetSprinkleTimeSetting1(eoj, tid, pdc, edt);
				break;
			case EPC_SPRINKLE_TIME_SETTING2:
				onGetSprinkleTimeSetting2(eoj, tid, pdc, edt);
				break;
			case EPC_SPRINKLE_DURATION_SETTING:
				onGetSprinkleDurationSetting(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * Open/close of sprinkle valve<br>Automatic ON=0x40    manual ON�� 0x41�Cmanual OFF��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onSetSprinkleValveOpenCloseSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Open/close of sprinkle valve<br>Automatic ON=0x40    manual ON�� 0x41�Cmanual OFF��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onGetSprinkleValveOpenCloseSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * OFF / daily / every other day / every 3 days / once a week<br>0x40�^0x41�^0x42�^0x43�^0x44<br><br>Data type : unsigned long<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetSprinkleIntervalSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * OFF / daily / every other day / every 3 days / once a week<br>0x40�^0x41�^0x42�^0x43�^0x44<br><br>Data type : unsigned long<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetSprinkleIntervalSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Number of sprinkles in a day(up to 2 times) First ON�^second ON�^both ON<br>0x41�^0x42�^0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetNumberOfSprinklesSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Number of sprinkles in a day(up to 2 times) First ON�^second ON�^both ON<br>0x41�^0x42�^0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetNumberOfSprinklesSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Set timer value HH:MM and get updated time<br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetSprinkleTimeSetting1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Set timer value HH:MM and get updated time<br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetSprinkleTimeSetting1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Set timer value HH:MM and get updated time<br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetSprinkleTimeSetting2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Set timer value HH:MM and get updated time<br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetSprinkleTimeSetting2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Set timer value MM 0 to 59 minutes<br>0-0x3B (=0~59)<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetSprinkleDurationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Set timer value MM 0 to 59 minutes<br>0-0x3B (=0~59)<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetSprinkleDurationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

	}
	
	public interface Setter extends DeviceObject.Setter {
		public Setter reqSetOperationStatus(byte[] edt);
		public Setter reqSetInstallationLocation(byte[] edt);
		public Setter reqSetCurrentLimitSetting(byte[] edt);
		public Setter reqSetPowerSavingOperationSetting(byte[] edt);
		public Setter reqSetPositionInformation(byte[] edt);
		public Setter reqSetCurrentTimeSetting(byte[] edt);
		public Setter reqSetCurrentDateSetting(byte[] edt);
		public Setter reqSetPowerLimitSetting(byte[] edt);
		
		/**
		 * Open/close of sprinkle valve<br>Automatic ON=0x40    manual ON�� 0x41�Cmanual OFF��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Setter reqSetSprinkleValveOpenCloseSetting(byte[] edt);
		/**
		 * OFF / daily / every other day / every 3 days / once a week<br>0x40�^0x41�^0x42�^0x43�^0x44<br><br>Data type : unsigned long<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetSprinkleIntervalSetting(byte[] edt);
		/**
		 * Number of sprinkles in a day(up to 2 times) First ON�^second ON�^both ON<br>0x41�^0x42�^0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetNumberOfSprinklesSetting(byte[] edt);
		/**
		 * Set timer value HH:MM and get updated time<br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetSprinkleTimeSetting1(byte[] edt);
		/**
		 * Set timer value HH:MM and get updated time<br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetSprinkleTimeSetting2(byte[] edt);
		/**
		 * Set timer value MM 0 to 59 minutes<br>0-0x3B (=0~59)<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetSprinkleDurationSetting(byte[] edt);
	}

	public class SetterImpl extends DeviceObject.SetterImpl implements Setter {

		public SetterImpl(byte esv) {
			super(esv);
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

		@Override
		public Setter reqSetSprinkleValveOpenCloseSetting(byte[] edt) {
			addProperty(EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING, edt, setSprinkleValveOpenCloseSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetSprinkleIntervalSetting(byte[] edt) {
			addProperty(EPC_SPRINKLE_INTERVAL_SETTING, edt, setSprinkleIntervalSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetNumberOfSprinklesSetting(byte[] edt) {
			addProperty(EPC_NUMBER_OF_SPRINKLES_SETTING, edt, setNumberOfSprinklesSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetSprinkleTimeSetting1(byte[] edt) {
			addProperty(EPC_SPRINKLE_TIME_SETTING1, edt, setSprinkleTimeSetting1(edt));
			return this;
		}
		@Override
		public Setter reqSetSprinkleTimeSetting2(byte[] edt) {
			addProperty(EPC_SPRINKLE_TIME_SETTING2, edt, setSprinkleTimeSetting2(edt));
			return this;
		}
		@Override
		public Setter reqSetSprinkleDurationSetting(byte[] edt) {
			addProperty(EPC_SPRINKLE_DURATION_SETTING, edt, setSprinkleDurationSetting(edt));
			return this;
		}
	}
	
	public class SetterProxy extends DeviceObject.SetterProxy implements Setter {

		public SetterProxy(byte esv) {
			super(esv);
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

		@Override
		public Setter reqSetSprinkleValveOpenCloseSetting(byte[] edt) {
			addProperty(EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetSprinkleIntervalSetting(byte[] edt) {
			addProperty(EPC_SPRINKLE_INTERVAL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetNumberOfSprinklesSetting(byte[] edt) {
			addProperty(EPC_NUMBER_OF_SPRINKLES_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetSprinkleTimeSetting1(byte[] edt) {
			addProperty(EPC_SPRINKLE_TIME_SETTING1, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetSprinkleTimeSetting2(byte[] edt) {
			addProperty(EPC_SPRINKLE_TIME_SETTING2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetSprinkleDurationSetting(byte[] edt) {
			addProperty(EPC_SPRINKLE_DURATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
	}

	public interface Getter extends DeviceObject.Getter {
		public Getter reqGetOperationStatus();
		public Getter reqGetInstallationLocation();
		public Getter reqGetStandardVersionInformation();
		public Getter reqGetIdentificationNumber();
		public Getter reqGetMeasuredInstantaneousPowerConsumption();
		public Getter reqGetMeasuredCumulativePowerConsumption();
		public Getter reqGetManufacturersFaultCode();
		public Getter reqGetCurrentLimitSetting();
		public Getter reqGetFaultStatus();
		public Getter reqGetFaultDescription();
		public Getter reqGetManufacturerCode();
		public Getter reqGetBusinessFacilityCode();
		public Getter reqGetProductCode();
		public Getter reqGetProductionNumber();
		public Getter reqGetProductionDate();
		public Getter reqGetPowerSavingOperationSetting();
		public Getter reqGetPositionInformation();
		public Getter reqGetCurrentTimeSetting();
		public Getter reqGetCurrentDateSetting();
		public Getter reqGetPowerLimitSetting();
		public Getter reqGetCumulativeOperatingTime();
		public Getter reqGetStatusChangeAnnouncementPropertyMap();
		public Getter reqGetSetPropertyMap();
		public Getter reqGetGetPropertyMap();
		
		/**
		 * Open/close of sprinkle valve<br>Automatic ON=0x40    manual ON�� 0x41�Cmanual OFF��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Getter reqGetSprinkleValveOpenCloseSetting();
		/**
		 * OFF / daily / every other day / every 3 days / once a week<br>0x40�^0x41�^0x42�^0x43�^0x44<br><br>Data type : unsigned long<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetSprinkleIntervalSetting();
		/**
		 * Number of sprinkles in a day(up to 2 times) First ON�^second ON�^both ON<br>0x41�^0x42�^0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetNumberOfSprinklesSetting();
		/**
		 * Set timer value HH:MM and get updated time<br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetSprinkleTimeSetting1();
		/**
		 * Set timer value HH:MM and get updated time<br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetSprinkleTimeSetting2();
		/**
		 * Set timer value MM 0 to 59 minutes<br>0-0x3B (=0~59)<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetSprinkleDurationSetting();
	}
	
	public class GetterImpl extends DeviceObject.GetterImpl implements Getter {

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

		@Override
		public Getter reqGetSprinkleValveOpenCloseSetting() {
			byte[] edt = getSprinkleValveOpenCloseSetting();
			addProperty(EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSprinkleIntervalSetting() {
			byte[] edt = getSprinkleIntervalSetting();
			addProperty(EPC_SPRINKLE_INTERVAL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetNumberOfSprinklesSetting() {
			byte[] edt = getNumberOfSprinklesSetting();
			addProperty(EPC_NUMBER_OF_SPRINKLES_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSprinkleTimeSetting1() {
			byte[] edt = getSprinkleTimeSetting1();
			addProperty(EPC_SPRINKLE_TIME_SETTING1, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetSprinkleTimeSetting2() {
			byte[] edt = getSprinkleTimeSetting2();
			addProperty(EPC_SPRINKLE_TIME_SETTING2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetSprinkleDurationSetting() {
			byte[] edt = getSprinkleDurationSetting();
			addProperty(EPC_SPRINKLE_DURATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
	}

	public class GetterProxy extends DeviceObject.GetterProxy implements Getter {

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

		@Override
		public Getter reqGetSprinkleValveOpenCloseSetting() {
			addProperty(EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetSprinkleIntervalSetting() {
			addProperty(EPC_SPRINKLE_INTERVAL_SETTING);
			return this;
		}
		@Override
		public Getter reqGetNumberOfSprinklesSetting() {
			addProperty(EPC_NUMBER_OF_SPRINKLES_SETTING);
			return this;
		}
		@Override
		public Getter reqGetSprinkleTimeSetting1() {
			addProperty(EPC_SPRINKLE_TIME_SETTING1);
			return this;
		}
		@Override
		public Getter reqGetSprinkleTimeSetting2() {
			addProperty(EPC_SPRINKLE_TIME_SETTING2);
			return this;
		}
		@Override
		public Getter reqGetSprinkleDurationSetting() {
			addProperty(EPC_SPRINKLE_DURATION_SETTING);
			return this;
		}
	}
	
	public interface Informer extends DeviceObject.Informer {
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
		 * Open/close of sprinkle valve<br>Automatic ON=0x40    manual ON�� 0x41�Cmanual OFF��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Informer reqInformSprinkleValveOpenCloseSetting();
		/**
		 * OFF / daily / every other day / every 3 days / once a week<br>0x40�^0x41�^0x42�^0x43�^0x44<br><br>Data type : unsigned long<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformSprinkleIntervalSetting();
		/**
		 * Number of sprinkles in a day(up to 2 times) First ON�^second ON�^both ON<br>0x41�^0x42�^0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformNumberOfSprinklesSetting();
		/**
		 * Set timer value HH:MM and get updated time<br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformSprinkleTimeSetting1();
		/**
		 * Set timer value HH:MM and get updated time<br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformSprinkleTimeSetting2();
		/**
		 * Set timer value MM 0 to 59 minutes<br>0-0x3B (=0~59)<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformSprinkleDurationSetting();
	}

	public class InformerImpl extends DeviceObject.InformerImpl implements Informer {

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
		public Informer reqInformSprinkleValveOpenCloseSetting() {
			byte[] edt = getSprinkleValveOpenCloseSetting();
			addProperty(EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSprinkleIntervalSetting() {
			byte[] edt = getSprinkleIntervalSetting();
			addProperty(EPC_SPRINKLE_INTERVAL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformNumberOfSprinklesSetting() {
			byte[] edt = getNumberOfSprinklesSetting();
			addProperty(EPC_NUMBER_OF_SPRINKLES_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSprinkleTimeSetting1() {
			byte[] edt = getSprinkleTimeSetting1();
			addProperty(EPC_SPRINKLE_TIME_SETTING1, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformSprinkleTimeSetting2() {
			byte[] edt = getSprinkleTimeSetting2();
			addProperty(EPC_SPRINKLE_TIME_SETTING2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformSprinkleDurationSetting() {
			byte[] edt = getSprinkleDurationSetting();
			addProperty(EPC_SPRINKLE_DURATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
	}
	
	public class InformerProxy extends DeviceObject.InformerProxy implements Informer {

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
		public Informer reqInformSprinkleValveOpenCloseSetting() {
			addProperty(EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformSprinkleIntervalSetting() {
			addProperty(EPC_SPRINKLE_INTERVAL_SETTING);
			return this;
		}
		@Override
		public Informer reqInformNumberOfSprinklesSetting() {
			addProperty(EPC_NUMBER_OF_SPRINKLES_SETTING);
			return this;
		}
		@Override
		public Informer reqInformSprinkleTimeSetting1() {
			addProperty(EPC_SPRINKLE_TIME_SETTING1);
			return this;
		}
		@Override
		public Informer reqInformSprinkleTimeSetting2() {
			addProperty(EPC_SPRINKLE_TIME_SETTING2);
			return this;
		}
		@Override
		public Informer reqInformSprinkleDurationSetting() {
			addProperty(EPC_SPRINKLE_DURATION_SETTING);
			return this;
		}
	}
}
