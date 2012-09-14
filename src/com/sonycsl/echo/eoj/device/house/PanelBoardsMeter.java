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
package com.sonycsl.echo.eoj.device.house;

import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;

public abstract class PanelBoardsMeter extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = PanelBoardsMeter.class.getSimpleName();
	private final PanelBoardsMeter self = this;
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x87;

	protected static final byte EPC_FORWARD_INTEGRAL_POWER_CONSUMPTION_VALUE = (byte)0xC0;
	protected static final byte EPC_BACKWARD_INTEGRAL_POWER_CONSUMPTION_VALUE = (byte)0xC1;
	protected static final byte EPC_INTEGRAL_POWER_CONSUMPTION_UNIT = (byte)0xC2;
	protected static final byte EPC_FORWARD_INTEGRAL_POWER_CONSUMPTION_RECORD = (byte)0xC3;
	protected static final byte EPC_BACKWARD_INTEGRAL_POWER_CONSUMPTION_RECORD = (byte)0xC4;
	protected static final byte EPC_COLLECTING_RECORD_DAY = (byte)0xC5;
	protected static final byte EPC_INSTANTANEOUS_POWER = (byte)0xC6;
	protected static final byte EPC_INSTANTANEOUS_CURRENT = (byte)0xC7;
	protected static final byte EPC_INSTANTANEOUS_VOLTAGE = (byte)0xC8;
	protected static final byte EPC_CHANNEL_1 = (byte)0xD0;
	protected static final byte EPC_CHANNEL_2 = (byte)0xD1;
	protected static final byte EPC_CHANNEL_3 = (byte)0xD2;
	protected static final byte EPC_CHANNEL_4 = (byte)0xD3;
	protected static final byte EPC_CHANNEL_5 = (byte)0xD4;
	protected static final byte EPC_CHANNEL_6 = (byte)0xD5;
	protected static final byte EPC_CHANNEL_7 = (byte)0xD6;
	protected static final byte EPC_CHANNEL_8 = (byte)0xD7;
	protected static final byte EPC_CHANNEL_9 = (byte)0xD8;
	protected static final byte EPC_CHANNEL_10 = (byte)0xD9;
	protected static final byte EPC_CHANNEL_11 = (byte)0xDA;
	protected static final byte EPC_CHANNEL_12 = (byte)0xDB;
	protected static final byte EPC_CHANNEL_13 = (byte)0xDC;
	protected static final byte EPC_CHANNEL_14 = (byte)0xDD;
	protected static final byte EPC_CHANNEL_15 = (byte)0xDE;
	protected static final byte EPC_CHANNEL_16 = (byte)0xDF;
	protected static final byte EPC_CHANNEL_17 = (byte)0xE0;
	protected static final byte EPC_CHANNEL_18 = (byte)0xE1;
	protected static final byte EPC_CHANNEL_19 = (byte)0xE2;
	protected static final byte EPC_CHANNEL_20 = (byte)0xE3;
	protected static final byte EPC_CHANNEL_21 = (byte)0xE4;
	protected static final byte EPC_CHANNEL_22 = (byte)0xE5;
	protected static final byte EPC_CHANNEL_23 = (byte)0xE6;
	protected static final byte EPC_CHANNEL_24 = (byte)0xE7;
	protected static final byte EPC_CHANNEL_25 = (byte)0xE8;
	protected static final byte EPC_CHANNEL_26 = (byte)0xE9;
	protected static final byte EPC_CHANNEL_27 = (byte)0xEA;
	protected static final byte EPC_CHANNEL_28 = (byte)0xEB;
	protected static final byte EPC_CHANNEL_29 = (byte)0xEC;
	protected static final byte EPC_CHANNEL_30 = (byte)0xED;
	protected static final byte EPC_CHANNEL_31 = (byte)0xEE;
	protected static final byte EPC_CHANNEL_32 = (byte)0xEF;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	protected abstract byte[] getForwardIntegralPowerConsumptionValue();
	protected abstract byte[] getBackwardIntegralPowerConsumptionValue();
	protected abstract byte[] getIntegralPowerConsumptionUnit();
	protected byte[] getForwardIntegralPowerConsumptionRecord() {
		return null;
	}
	protected byte[] getBackwardIntegralPowerConsumptionRecord() {
		return null;
	}
	protected boolean setCollectingRecordDay(byte[] edt) {
		return false;
	}
	protected byte[] getCollectingRecordDay() {
		return null;
	}
	protected byte[] getInstantaneousPower() {
		return null;
	}
	protected byte[] getInstantaneousCurrent() {
		return null;
	}
	protected byte[] getInstantaneousVoltage() {
		return null;
	}
	protected byte[] getChannel1() {
		return null;
	}
	protected byte[] getChannel2() {
		return null;
	}
	protected byte[] getChannel3() {
		return null;
	}
	protected byte[] getChannel4() {
		return null;
	}
	protected byte[] getChannel5() {
		return null;
	}
	protected byte[] getChannel6() {
		return null;
	}
	protected byte[] getChannel7() {
		return null;
	}
	protected byte[] getChannel8() {
		return null;
	}
	protected byte[] getChannel9() {
		return null;
	}
	protected byte[] getChannel10() {
		return null;
	}
	protected byte[] getChannel11() {
		return null;
	}
	protected byte[] getChannel12() {
		return null;
	}
	protected byte[] getChannel13() {
		return null;
	}
	protected byte[] getChannel14() {
		return null;
	}
	protected byte[] getChannel15() {
		return null;
	}
	protected byte[] getChannel16() {
		return null;
	}
	protected byte[] getChannel17() {
		return null;
	}
	protected byte[] getChannel18() {
		return null;
	}
	protected byte[] getChannel19() {
		return null;
	}
	protected byte[] getChannel20() {
		return null;
	}
	protected byte[] getChannel21() {
		return null;
	}
	protected byte[] getChannel22() {
		return null;
	}
	protected byte[] getChannel23() {
		return null;
	}
	protected byte[] getChannel24() {
		return null;
	}
	protected byte[] getChannel25() {
		return null;
	}
	protected byte[] getChannel26() {
		return null;
	}
	protected byte[] getChannel27() {
		return null;
	}
	protected byte[] getChannel28() {
		return null;
	}
	protected byte[] getChannel29() {
		return null;
	}
	protected byte[] getChannel30() {
		return null;
	}
	protected byte[] getChannel31() {
		return null;
	}
	protected byte[] getChannel32() {
		return null;
	}

	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_COLLECTING_RECORD_DAY:
			res.addProperty(epc, edt, setCollectingRecordDay(edt));
			break;
		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_FORWARD_INTEGRAL_POWER_CONSUMPTION_VALUE:
			edt = getForwardIntegralPowerConsumptionValue();
			res.addProperty(epc, edt, (edt != null && edt.length == 4));
			break;
		case EPC_BACKWARD_INTEGRAL_POWER_CONSUMPTION_VALUE:
			edt = getBackwardIntegralPowerConsumptionValue();
			res.addProperty(epc, edt, (edt != null && edt.length == 4));
			break;
		case EPC_INTEGRAL_POWER_CONSUMPTION_UNIT:
			edt = getIntegralPowerConsumptionUnit();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_FORWARD_INTEGRAL_POWER_CONSUMPTION_RECORD:
			edt = getForwardIntegralPowerConsumptionRecord();
			res.addProperty(epc, edt, (edt != null && edt.length == 194));
			break;
		case EPC_BACKWARD_INTEGRAL_POWER_CONSUMPTION_RECORD:
			edt = getBackwardIntegralPowerConsumptionRecord();
			res.addProperty(epc, edt, (edt != null && edt.length == 194));
			break;
		case EPC_COLLECTING_RECORD_DAY:
			edt = getCollectingRecordDay();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_INSTANTANEOUS_POWER:
			edt = getInstantaneousPower();
			res.addProperty(epc, edt, (edt != null && edt.length == 4));
			break;
		case EPC_INSTANTANEOUS_CURRENT:
			edt = getInstantaneousCurrent();
			res.addProperty(epc, edt, (edt != null && edt.length == 4));
			break;
		case EPC_INSTANTANEOUS_VOLTAGE:
			edt = getInstantaneousVoltage();
			res.addProperty(epc, edt, (edt != null && edt.length == 4));
			break;
		case EPC_CHANNEL_1:
			edt = getChannel1();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_2:
			edt = getChannel2();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_3:
			edt = getChannel3();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_4:
			edt = getChannel4();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_5:
			edt = getChannel5();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_6:
			edt = getChannel6();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_7:
			edt = getChannel7();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_8:
			edt = getChannel8();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_9:
			edt = getChannel9();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_10:
			edt = getChannel10();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_11:
			edt = getChannel11();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_12:
			edt = getChannel12();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_13:
			edt = getChannel13();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_14:
			edt = getChannel14();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_15:
			edt = getChannel15();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_16:
			edt = getChannel16();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_17:
			edt = getChannel17();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_18:
			edt = getChannel18();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_19:
			edt = getChannel19();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_20:
			edt = getChannel20();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_21:
			edt = getChannel21();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_22:
			edt = getChannel22();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_23:
			edt = getChannel23();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_24:
			edt = getChannel24();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_25:
			edt = getChannel25();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_26:
			edt = getChannel26();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_27:
			edt = getChannel27();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_28:
			edt = getChannel28();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_29:
			edt = getChannel29();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_30:
			edt = getChannel30();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_31:
			edt = getChannel31();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
			break;
		case EPC_CHANNEL_32:
			edt = getChannel32();
			res.addProperty(epc, edt, (edt != null && edt.length == 8));
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
			case EPC_COLLECTING_RECORD_DAY:
				onSetCollectingRecordDay(eoj, tid, (pdc != 0));
				break;
			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_FORWARD_INTEGRAL_POWER_CONSUMPTION_VALUE:
				onGetForwardIntegralPowerConsumptionValue(eoj, tid, pdc, edt);
				break;
			case EPC_BACKWARD_INTEGRAL_POWER_CONSUMPTION_VALUE:
				onGetBackwardIntegralPowerConsumptionValue(eoj, tid, pdc, edt);
				break;
			case EPC_INTEGRAL_POWER_CONSUMPTION_UNIT:
				onGetIntegralPowerConsumptionUnit(eoj, tid, pdc, edt);
				break;
			case EPC_FORWARD_INTEGRAL_POWER_CONSUMPTION_RECORD:
				onGetForwardIntegralPowerConsumptionRecord(eoj, tid, pdc, edt);
				break;
			case EPC_BACKWARD_INTEGRAL_POWER_CONSUMPTION_RECORD:
				onGetBackwardIntegralPowerConsumptionRecord(eoj, tid, pdc, edt);
				break;
			case EPC_COLLECTING_RECORD_DAY:
				onGetCollectingRecordDay(eoj, tid, pdc, edt);
				break;
			case EPC_INSTANTANEOUS_POWER:
				onGetInstantaneousPower(eoj, tid, pdc, edt);
				break;
			case EPC_INSTANTANEOUS_CURRENT:
				onGetInstantaneousCurrent(eoj, tid, pdc, edt);
				break;
			case EPC_INSTANTANEOUS_VOLTAGE:
				onGetInstantaneousVoltage(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_1:
				onGetChannel1(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_2:
				onGetChannel2(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_3:
				onGetChannel3(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_4:
				onGetChannel4(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_5:
				onGetChannel5(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_6:
				onGetChannel6(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_7:
				onGetChannel7(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_8:
				onGetChannel8(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_9:
				onGetChannel9(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_10:
				onGetChannel10(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_11:
				onGetChannel11(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_12:
				onGetChannel12(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_13:
				onGetChannel13(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_14:
				onGetChannel14(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_15:
				onGetChannel15(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_16:
				onGetChannel16(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_17:
				onGetChannel17(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_18:
				onGetChannel18(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_19:
				onGetChannel19(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_20:
				onGetChannel20(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_21:
				onGetChannel21(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_22:
				onGetChannel22(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_23:
				onGetChannel23(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_24:
				onGetChannel24(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_25:
				onGetChannel25(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_26:
				onGetChannel26(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_27:
				onGetChannel27(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_28:
				onGetChannel28(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_29:
				onGetChannel29(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_30:
				onGetChannel30(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_31:
				onGetChannel31(eoj, tid, pdc, edt);
				break;
			case EPC_CHANNEL_32:
				onGetChannel32(eoj, tid, pdc, edt);
				break;

			}
		}

		protected void onGetForwardIntegralPowerConsumptionValue(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetBackwardIntegralPowerConsumptionValue(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetIntegralPowerConsumptionUnit(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetForwardIntegralPowerConsumptionRecord(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetBackwardIntegralPowerConsumptionRecord(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onSetCollectingRecordDay(EchoObject eoj, short tid, boolean success) {
		}
		protected void onGetCollectingRecordDay(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetInstantaneousPower(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetInstantaneousCurrent(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetInstantaneousVoltage(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel1(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel2(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel3(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel4(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel5(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel6(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel7(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel8(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel9(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel10(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel11(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel12(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel13(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel14(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel15(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel16(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel17(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel18(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel19(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel20(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel21(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel22(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel23(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel24(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel25(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel26(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel27(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel28(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel29(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel30(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel31(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		protected void onGetChannel32(EchoObject eoj, short tid, byte pdc, byte[] edt) {
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
		
		public Setter reqSetCollectingRecordDay(byte[] edt);
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
		public Setter reqSetCollectingRecordDay(byte[] edt) {
			addProperty(EPC_COLLECTING_RECORD_DAY, edt, setCollectingRecordDay(edt));
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
		public Setter reqSetCollectingRecordDay(byte[] edt) {
			addProperty(EPC_COLLECTING_RECORD_DAY, edt, (edt.length == 1));
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
		
		public Getter reqGetForwardIntegralPowerConsumptionValue();
		public Getter reqGetBackwardIntegralPowerConsumptionValue();
		public Getter reqGetIntegralPowerConsumptionUnit();
		public Getter reqGetForwardIntegralPowerConsumptionRecord();
		public Getter reqGetBackwardIntegralPowerConsumptionRecord();
		public Getter reqGetCollectingRecordDay();
		public Getter reqGetInstantaneousPower();
		public Getter reqGetInstantaneousCurrent();
		public Getter reqGetInstantaneousVoltage();
		public Getter reqGetChannel1();
		public Getter reqGetChannel2();
		public Getter reqGetChannel3();
		public Getter reqGetChannel4();
		public Getter reqGetChannel5();
		public Getter reqGetChannel6();
		public Getter reqGetChannel7();
		public Getter reqGetChannel8();
		public Getter reqGetChannel9();
		public Getter reqGetChannel10();
		public Getter reqGetChannel11();
		public Getter reqGetChannel12();
		public Getter reqGetChannel13();
		public Getter reqGetChannel14();
		public Getter reqGetChannel15();
		public Getter reqGetChannel16();
		public Getter reqGetChannel17();
		public Getter reqGetChannel18();
		public Getter reqGetChannel19();
		public Getter reqGetChannel20();
		public Getter reqGetChannel21();
		public Getter reqGetChannel22();
		public Getter reqGetChannel23();
		public Getter reqGetChannel24();
		public Getter reqGetChannel25();
		public Getter reqGetChannel26();
		public Getter reqGetChannel27();
		public Getter reqGetChannel28();
		public Getter reqGetChannel29();
		public Getter reqGetChannel30();
		public Getter reqGetChannel31();
		public Getter reqGetChannel32();
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
		public Getter reqGetForwardIntegralPowerConsumptionValue() {
			byte[] edt = getForwardIntegralPowerConsumptionValue();
			addProperty(EPC_FORWARD_INTEGRAL_POWER_CONSUMPTION_VALUE, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Getter reqGetBackwardIntegralPowerConsumptionValue() {
			byte[] edt = getBackwardIntegralPowerConsumptionValue();
			addProperty(EPC_BACKWARD_INTEGRAL_POWER_CONSUMPTION_VALUE, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Getter reqGetIntegralPowerConsumptionUnit() {
			byte[] edt = getIntegralPowerConsumptionUnit();
			addProperty(EPC_INTEGRAL_POWER_CONSUMPTION_UNIT, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetForwardIntegralPowerConsumptionRecord() {
			byte[] edt = getForwardIntegralPowerConsumptionRecord();
			addProperty(EPC_FORWARD_INTEGRAL_POWER_CONSUMPTION_RECORD, edt, (edt != null && edt.length == 194));
			return this;
		}

		@Override
		public Getter reqGetBackwardIntegralPowerConsumptionRecord() {
			byte[] edt = getBackwardIntegralPowerConsumptionRecord();
			addProperty(EPC_BACKWARD_INTEGRAL_POWER_CONSUMPTION_RECORD, edt, (edt != null && edt.length == 194));
			return this;
		}

		@Override
		public Getter reqGetCollectingRecordDay() {
			byte[] edt = getCollectingRecordDay();
			addProperty(EPC_COLLECTING_RECORD_DAY, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetInstantaneousPower() {
			byte[] edt = getInstantaneousPower();
			addProperty(EPC_INSTANTANEOUS_POWER, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Getter reqGetInstantaneousCurrent() {
			byte[] edt = getInstantaneousCurrent();
			addProperty(EPC_INSTANTANEOUS_CURRENT, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Getter reqGetInstantaneousVoltage() {
			byte[] edt = getInstantaneousVoltage();
			addProperty(EPC_INSTANTANEOUS_VOLTAGE, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Getter reqGetChannel1() {
			byte[] edt = getChannel1();
			addProperty(EPC_CHANNEL_1, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel2() {
			byte[] edt = getChannel2();
			addProperty(EPC_CHANNEL_2, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel3() {
			byte[] edt = getChannel3();
			addProperty(EPC_CHANNEL_3, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel4() {
			byte[] edt = getChannel4();
			addProperty(EPC_CHANNEL_4, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel5() {
			byte[] edt = getChannel5();
			addProperty(EPC_CHANNEL_5, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel6() {
			byte[] edt = getChannel6();
			addProperty(EPC_CHANNEL_6, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel7() {
			byte[] edt = getChannel7();
			addProperty(EPC_CHANNEL_7, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel8() {
			byte[] edt = getChannel8();
			addProperty(EPC_CHANNEL_8, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel9() {
			byte[] edt = getChannel9();
			addProperty(EPC_CHANNEL_9, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel10() {
			byte[] edt = getChannel10();
			addProperty(EPC_CHANNEL_10, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel11() {
			byte[] edt = getChannel11();
			addProperty(EPC_CHANNEL_11, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel12() {
			byte[] edt = getChannel12();
			addProperty(EPC_CHANNEL_12, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel13() {
			byte[] edt = getChannel13();
			addProperty(EPC_CHANNEL_13, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel14() {
			byte[] edt = getChannel14();
			addProperty(EPC_CHANNEL_14, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel15() {
			byte[] edt = getChannel15();
			addProperty(EPC_CHANNEL_15, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel16() {
			byte[] edt = getChannel16();
			addProperty(EPC_CHANNEL_16, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel17() {
			byte[] edt = getChannel17();
			addProperty(EPC_CHANNEL_17, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel18() {
			byte[] edt = getChannel18();
			addProperty(EPC_CHANNEL_18, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel19() {
			byte[] edt = getChannel19();
			addProperty(EPC_CHANNEL_19, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel20() {
			byte[] edt = getChannel20();
			addProperty(EPC_CHANNEL_20, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel21() {
			byte[] edt = getChannel21();
			addProperty(EPC_CHANNEL_21, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel22() {
			byte[] edt = getChannel22();
			addProperty(EPC_CHANNEL_22, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel23() {
			byte[] edt = getChannel23();
			addProperty(EPC_CHANNEL_23, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel24() {
			byte[] edt = getChannel24();
			addProperty(EPC_CHANNEL_24, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel25() {
			byte[] edt = getChannel25();
			addProperty(EPC_CHANNEL_25, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel26() {
			byte[] edt = getChannel26();
			addProperty(EPC_CHANNEL_26, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel27() {
			byte[] edt = getChannel27();
			addProperty(EPC_CHANNEL_27, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel28() {
			byte[] edt = getChannel28();
			addProperty(EPC_CHANNEL_28, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel29() {
			byte[] edt = getChannel29();
			addProperty(EPC_CHANNEL_29, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel30() {
			byte[] edt = getChannel30();
			addProperty(EPC_CHANNEL_30, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel31() {
			byte[] edt = getChannel31();
			addProperty(EPC_CHANNEL_31, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Getter reqGetChannel32() {
			byte[] edt = getChannel32();
			addProperty(EPC_CHANNEL_32, edt, (edt != null && edt.length == 8));
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
		public Getter reqGetForwardIntegralPowerConsumptionValue() {
			addProperty(EPC_FORWARD_INTEGRAL_POWER_CONSUMPTION_VALUE);
			return this;
		}

		@Override
		public Getter reqGetBackwardIntegralPowerConsumptionValue() {
			addProperty(EPC_BACKWARD_INTEGRAL_POWER_CONSUMPTION_VALUE);
			return this;
		}

		@Override
		public Getter reqGetIntegralPowerConsumptionUnit() {
			addProperty(EPC_INTEGRAL_POWER_CONSUMPTION_UNIT);
			return this;
		}

		@Override
		public Getter reqGetForwardIntegralPowerConsumptionRecord() {
			addProperty(EPC_FORWARD_INTEGRAL_POWER_CONSUMPTION_RECORD);
			return this;
		}

		@Override
		public Getter reqGetBackwardIntegralPowerConsumptionRecord() {
			addProperty(EPC_BACKWARD_INTEGRAL_POWER_CONSUMPTION_RECORD);
			return this;
		}

		@Override
		public Getter reqGetCollectingRecordDay() {
			addProperty(EPC_COLLECTING_RECORD_DAY);
			return this;
		}

		@Override
		public Getter reqGetInstantaneousPower() {
			addProperty(EPC_INSTANTANEOUS_POWER);
			return this;
		}

		@Override
		public Getter reqGetInstantaneousCurrent() {
			addProperty(EPC_INSTANTANEOUS_CURRENT);
			return this;
		}

		@Override
		public Getter reqGetInstantaneousVoltage() {
			addProperty(EPC_INSTANTANEOUS_VOLTAGE);
			return this;
		}

		@Override
		public Getter reqGetChannel1() {
			addProperty(EPC_CHANNEL_1);
			return this;
		}

		@Override
		public Getter reqGetChannel2() {
			addProperty(EPC_CHANNEL_2);
			return this;
		}

		@Override
		public Getter reqGetChannel3() {
			addProperty(EPC_CHANNEL_3);
			return this;
		}

		@Override
		public Getter reqGetChannel4() {
			addProperty(EPC_CHANNEL_4);
			return this;
		}

		@Override
		public Getter reqGetChannel5() {
			addProperty(EPC_CHANNEL_5);
			return this;
		}

		@Override
		public Getter reqGetChannel6() {
			addProperty(EPC_CHANNEL_6);
			return this;
		}

		@Override
		public Getter reqGetChannel7() {
			addProperty(EPC_CHANNEL_7);
			return this;
		}

		@Override
		public Getter reqGetChannel8() {
			addProperty(EPC_CHANNEL_8);
			return this;
		}

		@Override
		public Getter reqGetChannel9() {
			addProperty(EPC_CHANNEL_9);
			return this;
		}

		@Override
		public Getter reqGetChannel10() {
			addProperty(EPC_CHANNEL_10);
			return this;
		}

		@Override
		public Getter reqGetChannel11() {
			addProperty(EPC_CHANNEL_11);
			return this;
		}

		@Override
		public Getter reqGetChannel12() {
			addProperty(EPC_CHANNEL_12);
			return this;
		}

		@Override
		public Getter reqGetChannel13() {
			addProperty(EPC_CHANNEL_13);
			return this;
		}

		@Override
		public Getter reqGetChannel14() {
			addProperty(EPC_CHANNEL_14);
			return this;
		}

		@Override
		public Getter reqGetChannel15() {
			addProperty(EPC_CHANNEL_15);
			return this;
		}

		@Override
		public Getter reqGetChannel16() {
			addProperty(EPC_CHANNEL_16);
			return this;
		}

		@Override
		public Getter reqGetChannel17() {
			addProperty(EPC_CHANNEL_17);
			return this;
		}

		@Override
		public Getter reqGetChannel18() {
			addProperty(EPC_CHANNEL_18);
			return this;
		}

		@Override
		public Getter reqGetChannel19() {
			addProperty(EPC_CHANNEL_19);
			return this;
		}

		@Override
		public Getter reqGetChannel20() {
			addProperty(EPC_CHANNEL_20);
			return this;
		}

		@Override
		public Getter reqGetChannel21() {
			addProperty(EPC_CHANNEL_21);
			return this;
		}

		@Override
		public Getter reqGetChannel22() {
			addProperty(EPC_CHANNEL_22);
			return this;
		}

		@Override
		public Getter reqGetChannel23() {
			addProperty(EPC_CHANNEL_23);
			return this;
		}

		@Override
		public Getter reqGetChannel24() {
			addProperty(EPC_CHANNEL_24);
			return this;
		}

		@Override
		public Getter reqGetChannel25() {
			addProperty(EPC_CHANNEL_25);
			return this;
		}

		@Override
		public Getter reqGetChannel26() {
			addProperty(EPC_CHANNEL_26);
			return this;
		}

		@Override
		public Getter reqGetChannel27() {
			addProperty(EPC_CHANNEL_27);
			return this;
		}

		@Override
		public Getter reqGetChannel28() {
			addProperty(EPC_CHANNEL_28);
			return this;
		}

		@Override
		public Getter reqGetChannel29() {
			addProperty(EPC_CHANNEL_29);
			return this;
		}

		@Override
		public Getter reqGetChannel30() {
			addProperty(EPC_CHANNEL_30);
			return this;
		}

		@Override
		public Getter reqGetChannel31() {
			addProperty(EPC_CHANNEL_31);
			return this;
		}

		@Override
		public Getter reqGetChannel32() {
			addProperty(EPC_CHANNEL_32);
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
		
		public Informer reqInformForwardIntegralPowerConsumptionValue();
		public Informer reqInformBackwardIntegralPowerConsumptionValue();
		public Informer reqInformIntegralPowerConsumptionUnit();
		public Informer reqInformForwardIntegralPowerConsumptionRecord();
		public Informer reqInformBackwardIntegralPowerConsumptionRecord();
		public Informer reqInformCollectingRecordDay();
		public Informer reqInformInstantaneousPower();
		public Informer reqInformInstantaneousCurrent();
		public Informer reqInformInstantaneousVoltage();
		public Informer reqInformChannel1();
		public Informer reqInformChannel2();
		public Informer reqInformChannel3();
		public Informer reqInformChannel4();
		public Informer reqInformChannel5();
		public Informer reqInformChannel6();
		public Informer reqInformChannel7();
		public Informer reqInformChannel8();
		public Informer reqInformChannel9();
		public Informer reqInformChannel10();
		public Informer reqInformChannel11();
		public Informer reqInformChannel12();
		public Informer reqInformChannel13();
		public Informer reqInformChannel14();
		public Informer reqInformChannel15();
		public Informer reqInformChannel16();
		public Informer reqInformChannel17();
		public Informer reqInformChannel18();
		public Informer reqInformChannel19();
		public Informer reqInformChannel20();
		public Informer reqInformChannel21();
		public Informer reqInformChannel22();
		public Informer reqInformChannel23();
		public Informer reqInformChannel24();
		public Informer reqInformChannel25();
		public Informer reqInformChannel26();
		public Informer reqInformChannel27();
		public Informer reqInformChannel28();
		public Informer reqInformChannel29();
		public Informer reqInformChannel30();
		public Informer reqInformChannel31();
		public Informer reqInformChannel32();
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
		public Informer reqInformForwardIntegralPowerConsumptionValue() {
			byte[] edt = getForwardIntegralPowerConsumptionValue();
			addProperty(EPC_FORWARD_INTEGRAL_POWER_CONSUMPTION_VALUE, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Informer reqInformBackwardIntegralPowerConsumptionValue() {
			byte[] edt = getBackwardIntegralPowerConsumptionValue();
			addProperty(EPC_BACKWARD_INTEGRAL_POWER_CONSUMPTION_VALUE, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Informer reqInformIntegralPowerConsumptionUnit() {
			byte[] edt = getIntegralPowerConsumptionUnit();
			addProperty(EPC_INTEGRAL_POWER_CONSUMPTION_UNIT, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformForwardIntegralPowerConsumptionRecord() {
			byte[] edt = getForwardIntegralPowerConsumptionRecord();
			addProperty(EPC_FORWARD_INTEGRAL_POWER_CONSUMPTION_RECORD, edt, (edt != null && edt.length == 194));
			return this;
		}

		@Override
		public Informer reqInformBackwardIntegralPowerConsumptionRecord() {
			byte[] edt = getBackwardIntegralPowerConsumptionRecord();
			addProperty(EPC_BACKWARD_INTEGRAL_POWER_CONSUMPTION_RECORD, edt, (edt != null && edt.length == 194));
			return this;
		}

		@Override
		public Informer reqInformCollectingRecordDay() {
			byte[] edt = getCollectingRecordDay();
			addProperty(EPC_COLLECTING_RECORD_DAY, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformInstantaneousPower() {
			byte[] edt = getInstantaneousPower();
			addProperty(EPC_INSTANTANEOUS_POWER, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Informer reqInformInstantaneousCurrent() {
			byte[] edt = getInstantaneousCurrent();
			addProperty(EPC_INSTANTANEOUS_CURRENT, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Informer reqInformInstantaneousVoltage() {
			byte[] edt = getInstantaneousVoltage();
			addProperty(EPC_INSTANTANEOUS_VOLTAGE, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Informer reqInformChannel1() {
			byte[] edt = getChannel1();
			addProperty(EPC_CHANNEL_1, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel2() {
			byte[] edt = getChannel2();
			addProperty(EPC_CHANNEL_2, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel3() {
			byte[] edt = getChannel3();
			addProperty(EPC_CHANNEL_3, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel4() {
			byte[] edt = getChannel4();
			addProperty(EPC_CHANNEL_4, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel5() {
			byte[] edt = getChannel5();
			addProperty(EPC_CHANNEL_5, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel6() {
			byte[] edt = getChannel6();
			addProperty(EPC_CHANNEL_6, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel7() {
			byte[] edt = getChannel7();
			addProperty(EPC_CHANNEL_7, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel8() {
			byte[] edt = getChannel8();
			addProperty(EPC_CHANNEL_8, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel9() {
			byte[] edt = getChannel9();
			addProperty(EPC_CHANNEL_9, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel10() {
			byte[] edt = getChannel10();
			addProperty(EPC_CHANNEL_10, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel11() {
			byte[] edt = getChannel11();
			addProperty(EPC_CHANNEL_11, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel12() {
			byte[] edt = getChannel12();
			addProperty(EPC_CHANNEL_12, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel13() {
			byte[] edt = getChannel13();
			addProperty(EPC_CHANNEL_13, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel14() {
			byte[] edt = getChannel14();
			addProperty(EPC_CHANNEL_14, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel15() {
			byte[] edt = getChannel15();
			addProperty(EPC_CHANNEL_15, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel16() {
			byte[] edt = getChannel16();
			addProperty(EPC_CHANNEL_16, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel17() {
			byte[] edt = getChannel17();
			addProperty(EPC_CHANNEL_17, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel18() {
			byte[] edt = getChannel18();
			addProperty(EPC_CHANNEL_18, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel19() {
			byte[] edt = getChannel19();
			addProperty(EPC_CHANNEL_19, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel20() {
			byte[] edt = getChannel20();
			addProperty(EPC_CHANNEL_20, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel21() {
			byte[] edt = getChannel21();
			addProperty(EPC_CHANNEL_21, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel22() {
			byte[] edt = getChannel22();
			addProperty(EPC_CHANNEL_22, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel23() {
			byte[] edt = getChannel23();
			addProperty(EPC_CHANNEL_23, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel24() {
			byte[] edt = getChannel24();
			addProperty(EPC_CHANNEL_24, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel25() {
			byte[] edt = getChannel25();
			addProperty(EPC_CHANNEL_25, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel26() {
			byte[] edt = getChannel26();
			addProperty(EPC_CHANNEL_26, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel27() {
			byte[] edt = getChannel27();
			addProperty(EPC_CHANNEL_27, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel28() {
			byte[] edt = getChannel28();
			addProperty(EPC_CHANNEL_28, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel29() {
			byte[] edt = getChannel29();
			addProperty(EPC_CHANNEL_29, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel30() {
			byte[] edt = getChannel30();
			addProperty(EPC_CHANNEL_30, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel31() {
			byte[] edt = getChannel31();
			addProperty(EPC_CHANNEL_31, edt, (edt != null && edt.length == 8));
			return this;
		}

		@Override
		public Informer reqInformChannel32() {
			byte[] edt = getChannel32();
			addProperty(EPC_CHANNEL_32, edt, (edt != null && edt.length == 8));
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
		public Informer reqInformForwardIntegralPowerConsumptionValue() {
			addProperty(EPC_FORWARD_INTEGRAL_POWER_CONSUMPTION_VALUE);
			return this;
		}

		@Override
		public Informer reqInformBackwardIntegralPowerConsumptionValue() {
			addProperty(EPC_BACKWARD_INTEGRAL_POWER_CONSUMPTION_VALUE);
			return this;
		}

		@Override
		public Informer reqInformIntegralPowerConsumptionUnit() {
			addProperty(EPC_INTEGRAL_POWER_CONSUMPTION_UNIT);
			return this;
		}

		@Override
		public Informer reqInformForwardIntegralPowerConsumptionRecord() {
			addProperty(EPC_FORWARD_INTEGRAL_POWER_CONSUMPTION_RECORD);
			return this;
		}

		@Override
		public Informer reqInformBackwardIntegralPowerConsumptionRecord() {
			addProperty(EPC_BACKWARD_INTEGRAL_POWER_CONSUMPTION_RECORD);
			return this;
		}

		@Override
		public Informer reqInformCollectingRecordDay() {
			addProperty(EPC_COLLECTING_RECORD_DAY);
			return this;
		}

		@Override
		public Informer reqInformInstantaneousPower() {
			addProperty(EPC_INSTANTANEOUS_POWER);
			return this;
		}

		@Override
		public Informer reqInformInstantaneousCurrent() {
			addProperty(EPC_INSTANTANEOUS_CURRENT);
			return this;
		}

		@Override
		public Informer reqInformInstantaneousVoltage() {
			addProperty(EPC_INSTANTANEOUS_VOLTAGE);
			return this;
		}

		@Override
		public Informer reqInformChannel1() {
			addProperty(EPC_CHANNEL_1);
			return this;
		}

		@Override
		public Informer reqInformChannel2() {
			addProperty(EPC_CHANNEL_2);
			return this;
		}

		@Override
		public Informer reqInformChannel3() {
			addProperty(EPC_CHANNEL_3);
			return this;
		}

		@Override
		public Informer reqInformChannel4() {
			addProperty(EPC_CHANNEL_4);
			return this;
		}

		@Override
		public Informer reqInformChannel5() {
			addProperty(EPC_CHANNEL_5);
			return this;
		}

		@Override
		public Informer reqInformChannel6() {
			addProperty(EPC_CHANNEL_6);
			return this;
		}

		@Override
		public Informer reqInformChannel7() {
			addProperty(EPC_CHANNEL_7);
			return this;
		}

		@Override
		public Informer reqInformChannel8() {
			addProperty(EPC_CHANNEL_8);
			return this;
		}

		@Override
		public Informer reqInformChannel9() {
			addProperty(EPC_CHANNEL_9);
			return this;
		}

		@Override
		public Informer reqInformChannel10() {
			addProperty(EPC_CHANNEL_10);
			return this;
		}

		@Override
		public Informer reqInformChannel11() {
			addProperty(EPC_CHANNEL_11);
			return this;
		}

		@Override
		public Informer reqInformChannel12() {
			addProperty(EPC_CHANNEL_12);
			return this;
		}

		@Override
		public Informer reqInformChannel13() {
			addProperty(EPC_CHANNEL_13);
			return this;
		}

		@Override
		public Informer reqInformChannel14() {
			addProperty(EPC_CHANNEL_14);
			return this;
		}

		@Override
		public Informer reqInformChannel15() {
			addProperty(EPC_CHANNEL_15);
			return this;
		}

		@Override
		public Informer reqInformChannel16() {
			addProperty(EPC_CHANNEL_16);
			return this;
		}

		@Override
		public Informer reqInformChannel17() {
			addProperty(EPC_CHANNEL_17);
			return this;
		}

		@Override
		public Informer reqInformChannel18() {
			addProperty(EPC_CHANNEL_18);
			return this;
		}

		@Override
		public Informer reqInformChannel19() {
			addProperty(EPC_CHANNEL_19);
			return this;
		}

		@Override
		public Informer reqInformChannel20() {
			addProperty(EPC_CHANNEL_20);
			return this;
		}

		@Override
		public Informer reqInformChannel21() {
			addProperty(EPC_CHANNEL_21);
			return this;
		}

		@Override
		public Informer reqInformChannel22() {
			addProperty(EPC_CHANNEL_22);
			return this;
		}

		@Override
		public Informer reqInformChannel23() {
			addProperty(EPC_CHANNEL_23);
			return this;
		}

		@Override
		public Informer reqInformChannel24() {
			addProperty(EPC_CHANNEL_24);
			return this;
		}

		@Override
		public Informer reqInformChannel25() {
			addProperty(EPC_CHANNEL_25);
			return this;
		}

		@Override
		public Informer reqInformChannel26() {
			addProperty(EPC_CHANNEL_26);
			return this;
		}

		@Override
		public Informer reqInformChannel27() {
			addProperty(EPC_CHANNEL_27);
			return this;
		}

		@Override
		public Informer reqInformChannel28() {
			addProperty(EPC_CHANNEL_28);
			return this;
		}

		@Override
		public Informer reqInformChannel29() {
			addProperty(EPC_CHANNEL_29);
			return this;
		}

		@Override
		public Informer reqInformChannel30() {
			addProperty(EPC_CHANNEL_30);
			return this;
		}

		@Override
		public Informer reqInformChannel31() {
			addProperty(EPC_CHANNEL_31);
			return this;
		}

		@Override
		public Informer reqInformChannel32() {
			addProperty(EPC_CHANNEL_32);
			return this;
		}
	}
}
