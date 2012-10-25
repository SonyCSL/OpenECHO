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
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x67;
	
	public Sprinkler() {
		setReceiver(new Receiver());
	}

	public static final byte EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING = (byte)0xE0;
	public static final byte EPC_SPRINKLE_INTERVAL_SETTING = (byte)0xE1;
	public static final byte EPC_NUMBER_OF_SPRINKLES_SETTING = (byte)0xE2;
	public static final byte EPC_SPRINKLE_TIME_SETTING1 = (byte)0xE3;
	public static final byte EPC_SPRINKLE_TIME_SETTING2 = (byte)0xE4;
	public static final byte EPC_SPRINKLE_DURATION_SETTING = (byte)0xE5;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Open/close of sprinkle valve<br><br>Automatic ON=0x40    manual ON�� 0x41�Cmanual OFF��0x42<br><br>Name : Sprinkle valve open/close setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
	 */
	protected abstract boolean setSprinkleValveOpenCloseSetting(byte[] edt);
	private final boolean _setSprinkleValveOpenCloseSetting(byte epc, byte[] edt) {
		boolean success = setSprinkleValveOpenCloseSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Open/close of sprinkle valve<br><br>Automatic ON=0x40    manual ON�� 0x41�Cmanual OFF��0x42<br><br>Name : Sprinkle valve open/close setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
	 */
	protected abstract byte[] getSprinkleValveOpenCloseSetting();
	private final byte[] _getSprinkleValveOpenCloseSetting(byte epc) {
		byte[] edt = getSprinkleValveOpenCloseSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * OFF / daily / every other day / every 3 days / once a week<br><br>0x40�^0x41�^0x42�^0x43�^0x44<br><br>Name : Sprinkle interval setting<br>EPC : 0xE1<br>Data Type : unsigned long<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSprinkleIntervalSetting(byte[] edt) {return false;}
	private final boolean _setSprinkleIntervalSetting(byte epc, byte[] edt) {
		boolean success = setSprinkleIntervalSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * OFF / daily / every other day / every 3 days / once a week<br><br>0x40�^0x41�^0x42�^0x43�^0x44<br><br>Name : Sprinkle interval setting<br>EPC : 0xE1<br>Data Type : unsigned long<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSprinkleIntervalSetting() {return null;}
	private final byte[] _getSprinkleIntervalSetting(byte epc) {
		byte[] edt = getSprinkleIntervalSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Number of sprinkles in a day(up to 2 times) First ON�^second ON�^both ON<br><br>0x41�^0x42�^0x43<br><br>Name : Number of sprinkles setting<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setNumberOfSprinklesSetting(byte[] edt) {return false;}
	private final boolean _setNumberOfSprinklesSetting(byte epc, byte[] edt) {
		boolean success = setNumberOfSprinklesSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Number of sprinkles in a day(up to 2 times) First ON�^second ON�^both ON<br><br>0x41�^0x42�^0x43<br><br>Name : Number of sprinkles setting<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getNumberOfSprinklesSetting() {return null;}
	private final byte[] _getNumberOfSprinklesSetting(byte epc) {
		byte[] edt = getNumberOfSprinklesSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Set timer value HH:MM and get updated time<br><br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Name : Sprinkle time setting 1<br>EPC : 0xE3<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSprinkleTimeSetting1(byte[] edt) {return false;}
	private final boolean _setSprinkleTimeSetting1(byte epc, byte[] edt) {
		boolean success = setSprinkleTimeSetting1(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Set timer value HH:MM and get updated time<br><br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Name : Sprinkle time setting 1<br>EPC : 0xE3<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSprinkleTimeSetting1() {return null;}
	private final byte[] _getSprinkleTimeSetting1(byte epc) {
		byte[] edt = getSprinkleTimeSetting1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Set timer value HH:MM and get updated time<br><br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Name : Sprinkle time setting 2<br>EPC : 0xE4<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSprinkleTimeSetting2(byte[] edt) {return false;}
	private final boolean _setSprinkleTimeSetting2(byte epc, byte[] edt) {
		boolean success = setSprinkleTimeSetting2(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Set timer value HH:MM and get updated time<br><br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Name : Sprinkle time setting 2<br>EPC : 0xE4<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSprinkleTimeSetting2() {return null;}
	private final byte[] _getSprinkleTimeSetting2(byte epc) {
		byte[] edt = getSprinkleTimeSetting2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Set timer value MM 0 to 59 minutes<br><br>0-0x3B (=0~59)<br><br>Name : Sprinkle duration setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSprinkleDurationSetting(byte[] edt) {return false;}
	private final boolean _setSprinkleDurationSetting(byte epc, byte[] edt) {
		boolean success = setSprinkleDurationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Set timer value MM 0 to 59 minutes<br><br>0-0x3B (=0~59)<br><br>Name : Sprinkle duration setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSprinkleDurationSetting() {return null;}
	private final byte[] _getSprinkleDurationSetting(byte epc) {
		byte[] edt = getSprinkleDurationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING:
			res.addProperty(epc, edt, _setSprinkleValveOpenCloseSetting(epc, edt));
			break;
		case EPC_SPRINKLE_INTERVAL_SETTING:
			res.addProperty(epc, edt, _setSprinkleIntervalSetting(epc, edt));
			break;
		case EPC_NUMBER_OF_SPRINKLES_SETTING:
			res.addProperty(epc, edt, _setNumberOfSprinklesSetting(epc, edt));
			break;
		case EPC_SPRINKLE_TIME_SETTING1:
			res.addProperty(epc, edt, _setSprinkleTimeSetting1(epc, edt));
			break;
		case EPC_SPRINKLE_TIME_SETTING2:
			res.addProperty(epc, edt, _setSprinkleTimeSetting2(epc, edt));
			break;
		case EPC_SPRINKLE_DURATION_SETTING:
			res.addProperty(epc, edt, _setSprinkleDurationSetting(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING:
			edt = _getSprinkleValveOpenCloseSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SPRINKLE_INTERVAL_SETTING:
			edt = _getSprinkleIntervalSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_NUMBER_OF_SPRINKLES_SETTING:
			edt = _getNumberOfSprinklesSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SPRINKLE_TIME_SETTING1:
			edt = _getSprinkleTimeSetting1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_SPRINKLE_TIME_SETTING2:
			edt = _getSprinkleTimeSetting2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_SPRINKLE_DURATION_SETTING:
			edt = _getSprinkleDurationSetting(epc);
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
			case EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING:
				_onSetSprinkleValveOpenCloseSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_SPRINKLE_INTERVAL_SETTING:
				_onSetSprinkleIntervalSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_NUMBER_OF_SPRINKLES_SETTING:
				_onSetNumberOfSprinklesSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_SPRINKLE_TIME_SETTING1:
				_onSetSprinkleTimeSetting1(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_SPRINKLE_TIME_SETTING2:
				_onSetSprinkleTimeSetting2(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_SPRINKLE_DURATION_SETTING:
				_onSetSprinkleDurationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING:
				_onGetSprinkleValveOpenCloseSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SPRINKLE_INTERVAL_SETTING:
				_onGetSprinkleIntervalSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_NUMBER_OF_SPRINKLES_SETTING:
				_onGetNumberOfSprinklesSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SPRINKLE_TIME_SETTING1:
				_onGetSprinkleTimeSetting1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SPRINKLE_TIME_SETTING2:
				_onGetSprinkleTimeSetting2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SPRINKLE_DURATION_SETTING:
				_onGetSprinkleDurationSetting(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * Open/close of sprinkle valve<br><br>Automatic ON=0x40    manual ON�� 0x41�Cmanual OFF��0x42<br><br>Name : Sprinkle valve open/close setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		protected void onSetSprinkleValveOpenCloseSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSprinkleValveOpenCloseSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSprinkleValveOpenCloseSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Open/close of sprinkle valve<br><br>Automatic ON=0x40    manual ON�� 0x41�Cmanual OFF��0x42<br><br>Name : Sprinkle valve open/close setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		protected void onGetSprinkleValveOpenCloseSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSprinkleValveOpenCloseSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSprinkleValveOpenCloseSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * OFF / daily / every other day / every 3 days / once a week<br><br>0x40�^0x41�^0x42�^0x43�^0x44<br><br>Name : Sprinkle interval setting<br>EPC : 0xE1<br>Data Type : unsigned long<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSprinkleIntervalSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSprinkleIntervalSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSprinkleIntervalSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * OFF / daily / every other day / every 3 days / once a week<br><br>0x40�^0x41�^0x42�^0x43�^0x44<br><br>Name : Sprinkle interval setting<br>EPC : 0xE1<br>Data Type : unsigned long<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSprinkleIntervalSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSprinkleIntervalSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSprinkleIntervalSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Number of sprinkles in a day(up to 2 times) First ON�^second ON�^both ON<br><br>0x41�^0x42�^0x43<br><br>Name : Number of sprinkles setting<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetNumberOfSprinklesSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetNumberOfSprinklesSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetNumberOfSprinklesSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Number of sprinkles in a day(up to 2 times) First ON�^second ON�^both ON<br><br>0x41�^0x42�^0x43<br><br>Name : Number of sprinkles setting<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetNumberOfSprinklesSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetNumberOfSprinklesSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetNumberOfSprinklesSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Set timer value HH:MM and get updated time<br><br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Name : Sprinkle time setting 1<br>EPC : 0xE3<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSprinkleTimeSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSprinkleTimeSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSprinkleTimeSetting1(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Set timer value HH:MM and get updated time<br><br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Name : Sprinkle time setting 1<br>EPC : 0xE3<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSprinkleTimeSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSprinkleTimeSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSprinkleTimeSetting1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Set timer value HH:MM and get updated time<br><br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Name : Sprinkle time setting 2<br>EPC : 0xE4<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSprinkleTimeSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSprinkleTimeSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSprinkleTimeSetting2(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Set timer value HH:MM and get updated time<br><br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Name : Sprinkle time setting 2<br>EPC : 0xE4<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSprinkleTimeSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSprinkleTimeSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSprinkleTimeSetting2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Set timer value MM 0 to 59 minutes<br><br>0-0x3B (=0~59)<br><br>Name : Sprinkle duration setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSprinkleDurationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSprinkleDurationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSprinkleDurationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Set timer value MM 0 to 59 minutes<br><br>0-0x3B (=0~59)<br><br>Name : Sprinkle duration setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSprinkleDurationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSprinkleDurationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSprinkleDurationSetting(eoj, tid, esv, epc, pdc, edt);
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
		 * Open/close of sprinkle valve<br><br>Automatic ON=0x40    manual ON�� 0x41�Cmanual OFF��0x42<br><br>Name : Sprinkle valve open/close setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Setter reqSetSprinkleValveOpenCloseSetting(byte[] edt) {
			addProperty(EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * OFF / daily / every other day / every 3 days / once a week<br><br>0x40�^0x41�^0x42�^0x43�^0x44<br><br>Name : Sprinkle interval setting<br>EPC : 0xE1<br>Data Type : unsigned long<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSprinkleIntervalSetting(byte[] edt) {
			addProperty(EPC_SPRINKLE_INTERVAL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Number of sprinkles in a day(up to 2 times) First ON�^second ON�^both ON<br><br>0x41�^0x42�^0x43<br><br>Name : Number of sprinkles setting<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetNumberOfSprinklesSetting(byte[] edt) {
			addProperty(EPC_NUMBER_OF_SPRINKLES_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Set timer value HH:MM and get updated time<br><br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Name : Sprinkle time setting 1<br>EPC : 0xE3<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSprinkleTimeSetting1(byte[] edt) {
			addProperty(EPC_SPRINKLE_TIME_SETTING1, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Set timer value HH:MM and get updated time<br><br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Name : Sprinkle time setting 2<br>EPC : 0xE4<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSprinkleTimeSetting2(byte[] edt) {
			addProperty(EPC_SPRINKLE_TIME_SETTING2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Set timer value MM 0 to 59 minutes<br><br>0-0x3B (=0~59)<br><br>Name : Sprinkle duration setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSprinkleDurationSetting(byte[] edt) {
			addProperty(EPC_SPRINKLE_DURATION_SETTING, edt, (edt != null && (edt.length == 1)));
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
		 * Open/close of sprinkle valve<br><br>Automatic ON=0x40    manual ON�� 0x41�Cmanual OFF��0x42<br><br>Name : Sprinkle valve open/close setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Getter reqGetSprinkleValveOpenCloseSetting() {
			addProperty(EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING);
			return this;
		}
		/**
		 * OFF / daily / every other day / every 3 days / once a week<br><br>0x40�^0x41�^0x42�^0x43�^0x44<br><br>Name : Sprinkle interval setting<br>EPC : 0xE1<br>Data Type : unsigned long<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSprinkleIntervalSetting() {
			addProperty(EPC_SPRINKLE_INTERVAL_SETTING);
			return this;
		}
		/**
		 * Number of sprinkles in a day(up to 2 times) First ON�^second ON�^both ON<br><br>0x41�^0x42�^0x43<br><br>Name : Number of sprinkles setting<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetNumberOfSprinklesSetting() {
			addProperty(EPC_NUMBER_OF_SPRINKLES_SETTING);
			return this;
		}
		/**
		 * Set timer value HH:MM and get updated time<br><br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Name : Sprinkle time setting 1<br>EPC : 0xE3<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSprinkleTimeSetting1() {
			addProperty(EPC_SPRINKLE_TIME_SETTING1);
			return this;
		}
		/**
		 * Set timer value HH:MM and get updated time<br><br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Name : Sprinkle time setting 2<br>EPC : 0xE4<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSprinkleTimeSetting2() {
			addProperty(EPC_SPRINKLE_TIME_SETTING2);
			return this;
		}
		/**
		 * Set timer value MM 0 to 59 minutes<br><br>0-0x3B (=0~59)<br><br>Name : Sprinkle duration setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSprinkleDurationSetting() {
			addProperty(EPC_SPRINKLE_DURATION_SETTING);
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
		 * Open/close of sprinkle valve<br><br>Automatic ON=0x40    manual ON�� 0x41�Cmanual OFF��0x42<br><br>Name : Sprinkle valve open/close setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Informer reqInformSprinkleValveOpenCloseSetting();
		/**
		 * OFF / daily / every other day / every 3 days / once a week<br><br>0x40�^0x41�^0x42�^0x43�^0x44<br><br>Name : Sprinkle interval setting<br>EPC : 0xE1<br>Data Type : unsigned long<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSprinkleIntervalSetting();
		/**
		 * Number of sprinkles in a day(up to 2 times) First ON�^second ON�^both ON<br><br>0x41�^0x42�^0x43<br><br>Name : Number of sprinkles setting<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformNumberOfSprinklesSetting();
		/**
		 * Set timer value HH:MM and get updated time<br><br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Name : Sprinkle time setting 1<br>EPC : 0xE3<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSprinkleTimeSetting1();
		/**
		 * Set timer value HH:MM and get updated time<br><br>0~0x17�F0~0x3B (=0~23)�F(=0~59)<br><br>Name : Sprinkle time setting 2<br>EPC : 0xE4<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSprinkleTimeSetting2();
		/**
		 * Set timer value MM 0 to 59 minutes<br><br>0-0x3B (=0~59)<br><br>Name : Sprinkle duration setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSprinkleDurationSetting();
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
		public Informer reqInformSprinkleValveOpenCloseSetting() {
			byte epc = EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING;
			byte[] edt = _getSprinkleValveOpenCloseSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSprinkleIntervalSetting() {
			byte epc = EPC_SPRINKLE_INTERVAL_SETTING;
			byte[] edt = _getSprinkleIntervalSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformNumberOfSprinklesSetting() {
			byte epc = EPC_NUMBER_OF_SPRINKLES_SETTING;
			byte[] edt = _getNumberOfSprinklesSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSprinkleTimeSetting1() {
			byte epc = EPC_SPRINKLE_TIME_SETTING1;
			byte[] edt = _getSprinkleTimeSetting1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformSprinkleTimeSetting2() {
			byte epc = EPC_SPRINKLE_TIME_SETTING2;
			byte[] edt = _getSprinkleTimeSetting2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformSprinkleDurationSetting() {
			byte epc = EPC_SPRINKLE_DURATION_SETTING;
			byte[] edt = _getSprinkleDurationSetting(epc);
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
