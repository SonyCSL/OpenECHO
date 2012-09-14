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
package com.sonycsl.echo.eoj.device;

import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.eoj.EchoObject;

/**
 * 　機器オブジェクトのスーパークラス
 *
 */
public abstract class DeviceObject extends EchoObject {

	protected static final byte EPC_POWER = (byte)0x80;
	protected static final byte EPC_INSTALLATION_LOCATION = (byte)0x81;
	protected static final byte EPC_VERSION = (byte)0x82;
	protected static final byte EPC_ID_NUMBER = (byte)0x83;
	protected static final byte EPC_ELECTRICITY_CONSUMPTION = (byte)0x84;
	protected static final byte EPC_POWER_CONSUMPTION = (byte)0x85;
	protected static final byte EPC_MAKER_ERROR_CODE = (byte)0x86;
	protected static final byte EPC_CURRENT_LIMITING = (byte)0x87;
	protected static final byte EPC_ERROR = (byte)0x88;
	protected static final byte EPC_ERROR_INFO = (byte)0x89;
	protected static final byte EPC_MAKER_CODE = (byte)0x8A;
	protected static final byte EPC_WORKPLACE_CODE = (byte)0x8B;
	protected static final byte EPC_PRODUCT_CODE =  (byte)0x8C;
	protected static final byte EPC_MANUFACTURING_NUMBER = (byte)0x8D;
	protected static final byte EPC_DATE_OF_MANUFACTURE = (byte)0x8E;
	protected static final byte EPC_POWER_SAVING = (byte)0x8F;
	protected static final byte EPC_LOCATION = (byte)0x93;
	protected static final byte EPC_CURRENT_TIME = (byte)0x97;
	protected static final byte EPC_CURRENT_DATE = (byte)0x98;
	protected static final byte EPC_POWER_LIMITATION = (byte)0x99;
	protected static final byte EPC_WORKING_TIME = (byte)0x9A;
	protected static final byte EPC_ANNO_PROPERTY_MAP = (byte)0x9D;
	protected static final byte EPC_SET_PROPERTY_MAP = (byte)0x9E;
	protected static final byte EPC_GET_PROPERTY_MAP = (byte)0x9F;

	@Override
	public byte getInstanceCode() {
		return getNode().getDeviceNumber(this);
	}

	/**
	 * プロパティ名称:動作状態
	 * EPC:0x80
	 * アクセスルール:Set/Get(必須)
	 * 状態変化アナウンス必須
	 */
	protected boolean setPower(byte[] edt) {
		return false;
	}

	/**
	 * プロパティ名称:動作状態
	 * EPC:0x80
	 * アクセスルール:Set/Get(必須)
	 * 状態変化アナウンス必須
	 */
	protected abstract byte[] getPower();	

	/**
	 * プロパティ名称:設置場所
	 * EPC:0x81
	 * アクセスルール:Set(必須)/Get(必須)
	 * 状態変化アナウンス必須
	 */
	protected abstract boolean setInstallationLocation(byte[] edt);

	/**
	 * プロパティ名称:設置場所
	 * EPC:0x81
	 * アクセスルール:Set(必須)/Get(必須)
	 * 状態変化アナウンス必須
	 */
	protected abstract byte[] getInstallationLocation();

	/**
	 * プロパティ名称:Version情報
	 * EPC:0x82
	 * アクセスルール:Get(必須)
	 */ 
	protected abstract byte[] getVersion() ;
	
	/**
	 * プロパティ名称:識別番号
	 * EPC:0x83
	 * アクセスルール:Get
	 */
	protected byte[] getIdNumber() {
		return null;
	}

	/**
	 * プロパティ名称:瞬時消費電力計測値
	 * EPC:0x84
	 * アクセスルール:Get
	 */
	protected byte[] getElectricityConsumption() {
		return null;
	}

	/**
	 * プロパティ名称:積算消費電力計測値
	 * EPC:0x85
	 * アクセスルール:Get
	 */
	protected byte[] getPowerConsumption() {
		return null;
	}

	/**
	 * プロパティ名称:メーカ異常コード
	 * EPC:0x86
	 * アクセスルール:Get
	 */	
	protected byte[] getMakerErrorCode() {
		return null;
	}

	/**
	 * プロパティ名称:電流制限設定
	 * EPC:0x87
	 * アクセスルール:Set/Get
	 */
	protected boolean setCurrentLimiting(byte[] edt) {
		return false;
	}

	/**
	 * プロパティ名称:電流制限設定
	 * EPC:0x87
	 * アクセスルール:Set/Get
	 */
	protected byte[] getCurrentLimiting() {
		return null;
	}

	/**
	 * プロパティ名称:異常発生状態
	 * EPC:0x88
	 * アクセスルール:Get(必須)
	 */
	protected abstract byte[] getError();

	
	/**
	 * プロパティ名称:異常内容
	 * EPC:0x89
	 * アクセスルール:Get
	 */
	protected byte[] getErrorInfo() {
		return null;
	}
	
	/**
	 * プロパティ名称:メーカコード
	 * EPC:0x8A
	 * アクセスルール:Get(必須)
	 */ 
	protected abstract byte[] getMakerCode();
	
	/**
	 * プロパティ名称:事業場コード
	 * EPC:0x8B
	 * アクセスルール:Get
	 */
	protected byte[] getWorkplaceCode() {
		return null;
	}
	
	/**
	 * プロパティ名称:商品コード
	 * EPC:0x8C
	 * アクセスルール:Get
	 */
	protected byte[] getProductCode() {
		return null;
	}

	/**
	 * プロパティ名称:製造番号
	 * EPC:0x8D
	 * アクセスルール:Get
	 */
	protected byte[] getManufacturingNumber() {
		return null;
	}
	
	/**
	 * プロパティ名称:製造年月日
	 * EPC:0x8E
	 * アクセスルール:Get
	 */
	protected byte[] getDateOfManufacture() {
		return null;
	}

	/**
	 * プロパティ名称:節電動作設定
	 * EPC:0x8F
	 * アクセスルール:Set/Get
	 */
	protected boolean setPowerSaving(byte[] edt) {
		return false;
	}

	/**
	 * プロパティ名称:節電動作設定
	 * EPC:0x8F
	 * アクセスルール:Set/Get
	 */
	protected byte[] getPowerSaving() {
		return null;
	}

	/**
	 * プロパティ名称:位置情報
	 * EPC:0x93
	 * アクセスルール:Set/Get
	 * 状態変化アナウンス必須
	 */
	protected boolean setLocation(byte[] edt) {
		return false;
	}

	/**
	 * プロパティ名称:位置情報
	 * EPC:0x93
	 * アクセスルール:Set/Get
	 * 状態変化アナウンス必須
	 */	
	protected byte[] getLocation() {
		return null;
	}

	/**
	 * プロパティ名称:現在時刻設定
	 * EPC:0x97
	 * アクセスルール:Set/Get
	 */
	protected boolean setCurrentTime(byte[] edt) {
		return false;
	}

	/**
	 * プロパティ名称:現在時刻設定
	 * EPC:0x97
	 * アクセスルール:Set/Get
	 */
	protected byte[] getCurrentTime() {
		return null;
	}

	/**
	 * プロパティ名称:現在年月日設定
	 * EPC:0x98
	 * アクセスルール:Set/Get
	 */
	protected boolean setCurrentDate(byte edt[]) {
		return false;
	}

	/**
	 * プロパティ名称:現在年月日設定
	 * EPC:0x98
	 * アクセスルール:Set/Get
	 */
	protected byte[] getCurrentDate() {
		return null;
	}

	/**
	 * プロパティ名称:電力制限設定
	 * EPC:0x99
	 * アクセスルール:Set/Get
	 */
	protected boolean setPowerLimitation(byte[] edt) {
		return false;
	}

	/**
	 * プロパティ名称:電力制限設定
	 * EPC:0x99
	 * アクセスルール:Set/Get
	 */
	protected byte[] getPowerLimitation() {
		return null;
	}

	/**
	 * プロパティ名称:積算運転時間
	 * EPC:0x9A
	 * アクセスルール:Set/Get
	 */
	protected byte[] getWorkingTime() {
		return null;
	}
	
	/**
	 * プロパティ名称:状変アナウンスプロパティマップ
	 * EPC:0x9D
	 * アクセスルール:Get(必須)
	 */
	protected abstract byte[] getAnnoPropertyMap() ;
	
	/**
	 * プロパティ名称:Setプロパティマップ
	 * EPC:0x9E
	 * アクセスルール:Get(必須)
	 */
	protected abstract byte[] getSetPropertyMap();

	/**
	 * プロパティ名称:Getプロパティマップ
	 * EPC:0x9F
	 * アクセスルール:Get(必須)
	 */
	protected abstract byte[] getGetPropertyMap();

	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_POWER :
			res.addProperty(epc, edt, setPower(edt));
			break;
		case EPC_INSTALLATION_LOCATION :
			res.addProperty(epc, edt, setInstallationLocation(edt));
			break;
		case EPC_CURRENT_LIMITING :
			res.addProperty(epc, edt, setCurrentLimiting(edt));
			break;
		case EPC_POWER_SAVING :
			res.addProperty(epc, edt, setPowerSaving(edt));
			break;
		case EPC_LOCATION :
			res.addProperty(epc, edt, setLocation(edt));
			break;
		case EPC_CURRENT_TIME :
			res.addProperty(epc, edt, setCurrentTime(edt));
			break;
		case EPC_CURRENT_DATE :
			res.addProperty(epc, edt, setCurrentDate(edt));
			break;
		case EPC_POWER_LIMITATION :
			res.addProperty(epc, edt, setPowerLimitation(edt));
			break;
		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_POWER :
			edt = getPower();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_INSTALLATION_LOCATION :
			edt = getInstallationLocation();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_VERSION :
			edt = getVersion();
			res.addProperty(epc, edt, (edt != null && edt.length == 4));
			break;
		case EPC_ID_NUMBER :
			edt = getIdNumber();
			res.addProperty(epc, edt, (edt != null && (edt.length == 9 || edt.length == 17)));
			break;
		case EPC_ELECTRICITY_CONSUMPTION :
			edt = getElectricityConsumption();
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_POWER_CONSUMPTION :
			edt = getPowerConsumption();
			res.addProperty(epc, edt, (edt != null && edt.length == 4));
			break;
		case EPC_MAKER_ERROR_CODE :
			edt = getMakerErrorCode();
			res.addProperty(epc, edt, (edt != null && edt.length <= 225));
			break;
		case EPC_CURRENT_LIMITING :
			edt = getCurrentLimiting();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_ERROR :
			edt = getError();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_ERROR_INFO :
			edt = getErrorInfo();
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_MAKER_CODE :
			edt = getMakerCode();
			res.addProperty(epc, edt, (edt != null && edt.length == 3));
			break;
		case EPC_WORKPLACE_CODE :
			edt = getWorkplaceCode();
			res.addProperty(epc, edt, (edt != null && edt.length == 3));
			break;
		case EPC_PRODUCT_CODE :
			edt = getProductCode();
			res.addProperty(epc, edt, (edt != null && edt.length == 12));
			break;
		case EPC_MANUFACTURING_NUMBER :
			edt = getManufacturingNumber();
			res.addProperty(epc, edt, (edt != null && edt.length == 12));
			break;
		case EPC_DATE_OF_MANUFACTURE :
			edt = getDateOfManufacture();
			res.addProperty(epc, edt, (edt != null && edt.length == 4));
			break;
		case EPC_POWER_SAVING :
			edt = getPowerSaving();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_LOCATION :
			edt = getLocation();
			res.addProperty(epc, edt, (edt != null && edt.length == 16));
			break;
		case EPC_CURRENT_TIME :
			edt = getCurrentTime();
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_CURRENT_DATE :
			edt = getCurrentDate();
			res.addProperty(epc, edt, (edt != null && edt.length == 4));
			break;
		case EPC_POWER_LIMITATION :
			edt = getPowerLimitation();
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_WORKING_TIME :
			edt = getWorkingTime();
			res.addProperty(epc, edt, (edt != null && edt.length == 5));
			break;
		case EPC_ANNO_PROPERTY_MAP :
			edt = getAnnoPropertyMap();
			res.addProperty(epc, edt, (edt != null && edt.length <= 17));
			break;
		case EPC_SET_PROPERTY_MAP :
			edt = getSetPropertyMap();
			res.addProperty(epc, edt, (edt != null && edt.length <= 17));
			break;
		case EPC_GET_PROPERTY_MAP :
			edt = getGetPropertyMap();
			res.addProperty(epc, edt, (edt != null && edt.length <= 17));
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
	
	public static class Receiver extends EchoObject.Receiver {

		@Override
		protected void onReceiveSetRes(EchoObject eoj, short tid, byte epc, byte pdc, byte[] edt) {
			super.onReceiveSetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_POWER :
				onSetPower(eoj, tid, (pdc != 0));
				break;
			case EPC_INSTALLATION_LOCATION :
				onSetInstallationLocation(eoj, tid, (pdc != 0));
				break;
			case EPC_CURRENT_LIMITING :
				onSetCurrentLimiting(eoj, tid, (pdc != 0));
				break;
			case EPC_POWER_SAVING :
				onSetPowerSaving(eoj, tid, (pdc != 0));
				break;
			case EPC_LOCATION :
				onSetLocation(eoj, tid, (pdc != 0));
				break;
			case EPC_CURRENT_TIME :
				onSetCurrentTime(eoj, tid, (pdc != 0));
				break;
			case EPC_CURRENT_DATE :
				onSetCurrentDate(eoj, tid, (pdc != 0));
				break;
			case EPC_POWER_LIMITATION :
				onSetPowerLimitation(eoj, tid, (pdc != 0));
				break;
			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_POWER :
				onGetPower(eoj, tid, pdc, edt);
				break;
			case EPC_INSTALLATION_LOCATION :
				onGetInstallationLocation(eoj, tid, pdc, edt);
				break;
			case EPC_VERSION :
				onGetVersion(eoj, tid, pdc, edt);
				break;
			case EPC_ID_NUMBER :
				onGetIdNumber(eoj, tid, pdc, edt);
				break;
			case EPC_ELECTRICITY_CONSUMPTION :
				onGetElectricityConsumption(eoj, tid, pdc, edt);
				break;
			case EPC_POWER_CONSUMPTION :
				onGetPowerConsumption(eoj, tid, pdc, edt);
				break;
			case EPC_MAKER_ERROR_CODE :
				onGetMakerErrorCode(eoj, tid, pdc, edt);
				break;
			case EPC_CURRENT_LIMITING :
				onGetCurrentLimiting(eoj, tid, pdc, edt);
				break;
			case EPC_ERROR :
				onGetError(eoj, tid, pdc, edt);
				break;
			case EPC_ERROR_INFO :
				onGetErrorInfo(eoj, tid, pdc, edt);
				break;
			case EPC_MAKER_CODE :
				onGetMakerCode(eoj, tid, pdc, edt);
				break;
			case EPC_WORKPLACE_CODE :
				onGetWorkplaceCode(eoj, tid, pdc, edt);
				break;
			case EPC_PRODUCT_CODE :
				onGetProductCode(eoj, tid, pdc, edt);
				break;
			case EPC_MANUFACTURING_NUMBER :
				onGetManufacturingNumber(eoj, tid, pdc, edt);
				break;
			case EPC_DATE_OF_MANUFACTURE :
				onGetDateOfManufacture(eoj, tid, pdc, edt);
				break;
			case EPC_POWER_SAVING :
				onGetPowerSaving(eoj, tid, pdc, edt);
				break;
			case EPC_LOCATION :
				onGetLocation(eoj, tid, pdc, edt);
				break;
			case EPC_CURRENT_TIME :
				onGetCurrentTime(eoj, tid, pdc, edt);
				break;
			case EPC_CURRENT_DATE :
				onGetCurrentDate(eoj, tid, pdc, edt);
				break;
			case EPC_POWER_LIMITATION :
				onGetPowerLimitation(eoj, tid, pdc, edt);
				break;
			case EPC_WORKING_TIME :
				onGetWorkingTime(eoj, tid, pdc, edt);
				break;
			case EPC_ANNO_PROPERTY_MAP :
				onGetAnnoPropertyMap(eoj, tid, pdc, edt);
				break;
			case EPC_SET_PROPERTY_MAP :
				onGetSetPropertyMap(eoj, tid, pdc, edt);
				break;
			case EPC_GET_PROPERTY_MAP :
				onGetGetPropertyMap(eoj, tid, pdc, edt);
				break;
			}
		}

		/**
		 * プロパティ名称:動作状態
		 * EPC:0x80
		 * アクセスルール:Set/Get(必須)
		 * 状態変化アナウンス必須
		 */
		protected void onSetPower(EchoObject eoj, short tid, boolean success) {
		}

		/**
		 * プロパティ名称:動作状態
		 * EPC:0x80
		 * アクセスルール:Set/Get(必須)
		 * 状態変化アナウンス必須
		 */
		protected void onGetPower(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:設置場所
		 * EPC:0x81
		 * アクセスルール:Set(必須)/Get(必須)
		 * 状態変化アナウンス必須
		 */
		protected void onSetInstallationLocation(EchoObject eoj, short tid, boolean success) {
			
		}

		/**
		 * プロパティ名称:設置場所
		 * EPC:0x81
		 * アクセスルール:Set(必須)/Get(必須)
		 * 状態変化アナウンス必須
		 */
		protected void onGetInstallationLocation(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		/**
		 * プロパティ名称:Version情報
		 * EPC:0x82
		 * アクセスルール:Get(必須)
		 */ 
		protected void onGetVersion(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}
		
		/**
		 * プロパティ名称:識別番号
		 * EPC:0x83
		 * アクセスルール:Get
		 */
		protected void onGetIdNumber(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:瞬時消費電力計測値
		 * EPC:0x84
		 * アクセスルール:Get
		 */
		protected void onGetElectricityConsumption(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:積算消費電力計測値
		 * EPC:0x85
		 * アクセスルール:Get
		 */
		protected void onGetPowerConsumption(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:メーカ異常コード
		 * EPC:0x86
		 * アクセスルール:Get
		 */	
		protected void onGetMakerErrorCode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:電流制限設定
		 * EPC:0x87
		 * アクセスルール:Set/Get
		 */
		protected void onSetCurrentLimiting(EchoObject eoj, short tid, boolean success) {
		}

		/**
		 * プロパティ名称:電流制限設定
		 * EPC:0x87
		 * アクセスルール:Set/Get
		 */
		protected void onGetCurrentLimiting(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:異常発生状態
		 * EPC:0x88
		 * アクセスルール:Get(必須)
		 */
		protected void onGetError(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}
		
		/**
		 * プロパティ名称:異常内容
		 * EPC:0x89
		 * アクセスルール:Get
		 */
		protected void onGetErrorInfo(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		/**
		 * プロパティ名称:メーカコード
		 * EPC:0x8A
		 * アクセスルール:Get(必須)
		 */ 
		protected void onGetMakerCode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}
		
		/**
		 * プロパティ名称:事業場コード
		 * EPC:0x8B
		 * アクセスルール:Get
		 */
		protected void onGetWorkplaceCode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		/**
		 * プロパティ名称:商品コード
		 * EPC:0x8C
		 * アクセスルール:Get
		 */
		protected void onGetProductCode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:製造番号
		 * EPC:0x8D
		 * アクセスルール:Get
		 */
		protected void onGetManufacturingNumber(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		/**
		 * プロパティ名称:製造年月日
		 * EPC:0x8E
		 * アクセスルール:Get
		 */
		protected void onGetDateOfManufacture(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:節電動作設定
		 * EPC:0x8F
		 * アクセスルール:Set/Get
		 */
		protected void onSetPowerSaving(EchoObject eoj, short tid, boolean success) {
		}

		/**
		 * プロパティ名称:節電動作設定
		 * EPC:0x8F
		 * アクセスルール:Set/Get
		 */
		protected void onGetPowerSaving(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:位置情報
		 * EPC:0x93
		 * アクセスルール:Set/Get
		 * 状態変化アナウンス必須
		 */
		protected void onSetLocation(EchoObject eoj, short tid, boolean success) {
		}

		/**
		 * プロパティ名称:位置情報
		 * EPC:0x93
		 * アクセスルール:Set/Get
		 * 状態変化アナウンス必須
		 */	
		protected void onGetLocation(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:現在時刻設定
		 * EPC:0x97
		 * アクセスルール:Set/Get
		 */
		protected void onSetCurrentTime(EchoObject eoj, short tid, boolean success) {
		}

		/**
		 * プロパティ名称:現在時刻設定
		 * EPC:0x97
		 * アクセスルール:Set/Get
		 */
		protected void onGetCurrentTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:現在年月日設定
		 * EPC:0x98
		 * アクセスルール:Set/Get
		 */
		protected void onSetCurrentDate(EchoObject eoj, short tid, boolean success) {
		}

		/**
		 * プロパティ名称:現在年月日設定
		 * EPC:0x98
		 * アクセスルール:Set/Get
		 */
		protected void onGetCurrentDate(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:電力制限設定
		 * EPC:0x99
		 * アクセスルール:Set/Get
		 */
		protected void onSetPowerLimitation(EchoObject eoj, short tid, boolean success) {
		}

		/**
		 * プロパティ名称:電力制限設定
		 * EPC:0x99
		 * アクセスルール:Set/Get
		 */
		protected void onGetPowerLimitation(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:積算運転時間
		 * EPC:0x9A
		 * アクセスルール:Set/Get
		 */
		protected void onGetWorkingTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		/**
		 * プロパティ名称:状変アナウンスプロパティマップ
		 * EPC:0x9D
		 * アクセスルール:Get(必須)
		 */
		protected void onGetAnnoPropertyMap(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}
		
		/**
		 * プロパティ名称:Setプロパティマップ
		 * EPC:0x9E
		 * アクセスルール:Get(必須)
		 */
		protected void onGetSetPropertyMap(EchoObject eoj, short tid, byte pdc, byte[] edt) {
		}

		/**
		 * プロパティ名称:Getプロパティマップ
		 * EPC:0x9F
		 * アクセスルール:Get(必須)
		 */
		protected void onGetGetPropertyMap(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		
	}

	public interface Setter extends EchoObject.Setter {
		/**
		 * プロパティ名称:動作状態
		 * EPC:0x80
		 * アクセスルール:Set/Get(必須)
		 * 状態変化アナウンス必須
		 */
		public Setter reqSetPower(byte[] edt);
		/**
		 * プロパティ名称:設置場所
		 * EPC:0x81
		 * アクセスルール:Set(必須)/Get(必須)
		 * 状態変化アナウンス必須
		 */
		public Setter reqSetInstallationLocation(byte[] edt);
		/**
		 * プロパティ名称:電流制限設定
		 * EPC:0x87
		 * アクセスルール:Set/Get
		 */
		public Setter reqSetCurrentLimiting(byte[] edt);
		/**
		 * プロパティ名称:節電動作設定
		 * EPC:0x8F
		 * アクセスルール:Set/Get
		 */
		public Setter reqSetPowerSaving(byte[] edt);
		/**
		 * プロパティ名称:位置情報
		 * EPC:0x93
		 * アクセスルール:Set/Get
		 * 状態変化アナウンス必須
		 */
		public Setter reqSetLocation(byte[] edt);
		/**
		 * プロパティ名称:現在時刻設定
		 * EPC:0x97
		 * アクセスルール:Set/Get
		 */
		public Setter reqSetCurrentTime(byte[] edt);
		/**
		 * プロパティ名称:現在年月日設定
		 * EPC:0x98
		 * アクセスルール:Set/Get
		 */
		public Setter reqSetCurrentDate(byte[] edt);
		/**
		 * プロパティ名称:電力制限設定
		 * EPC:0x99
		 * アクセスルール:Set/Get
		 */
		public Setter reqSetPowerLimitation(byte[] edt);
	}
	
	public class SetterImpl extends EchoObject.SetterImpl implements Setter {

		public SetterImpl(byte esv) {
			super(esv);
		}
		
		@Override
		public Setter reqSetPower(byte[] edt) {
			addProperty(EPC_POWER, edt, setPower(edt));
			return this;
		}

		@Override
		public Setter reqSetInstallationLocation(byte[] edt) {
			addProperty(EPC_INSTALLATION_LOCATION, edt, setPower(edt));
			return this;
		}

		@Override
		public Setter reqSetCurrentLimiting(byte[] edt) {
			addProperty(EPC_CURRENT_LIMITING, edt, setPower(edt));
			return this;
		}
		
		@Override
		public Setter reqSetPowerSaving(byte[] edt) {
			addProperty(EPC_POWER_SAVING, edt, setPower(edt));
			return this;
		}

		@Override
		public Setter reqSetLocation(byte[] edt) {
			addProperty(EPC_LOCATION, edt, setPower(edt));
			return this;
		}

		@Override
		public Setter reqSetCurrentTime(byte[] edt) {
			addProperty(EPC_CURRENT_TIME, edt, setPower(edt));
			return this;
		}

		@Override
		public Setter reqSetCurrentDate(byte[] edt) {
			addProperty(EPC_CURRENT_DATE, edt, setPower(edt));
			return this;
		}

		@Override
		public Setter reqSetPowerLimitation(byte[] edt) {
			addProperty(EPC_POWER_LIMITATION, edt, setPower(edt));
			return this;
		}
		
	}

	public class SetterProxy extends EchoObject.SetterProxy implements Setter {

		public SetterProxy(byte esv) {
			super(esv);
		}

		@Override
		public Setter reqSetPower(byte[] edt) {
			addProperty(EPC_POWER, edt, (edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetInstallationLocation(byte[] edt) {
			addProperty(EPC_INSTALLATION_LOCATION, edt, (edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetCurrentLimiting(byte[] edt) {
			addProperty(EPC_CURRENT_LIMITING, edt, (edt.length == 1));
			return this;
		}
		
		@Override
		public Setter reqSetPowerSaving(byte[] edt) {
			addProperty(EPC_POWER_SAVING, edt, (edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetLocation(byte[] edt) {
			addProperty(EPC_LOCATION, edt, (edt.length == 16));
			return this;
		}

		@Override
		public Setter reqSetCurrentTime(byte[] edt) {
			addProperty(EPC_CURRENT_TIME, edt, (edt.length == 2));
			return this;
		}

		@Override
		public Setter reqSetCurrentDate(byte[] edt) {
			addProperty(EPC_CURRENT_DATE, edt, (edt.length == 4));
			return this;
		}

		@Override
		public Setter reqSetPowerLimitation(byte[] edt) {
			addProperty(EPC_POWER_LIMITATION, edt, (edt.length == 2));
			return this;
		}
		
	}
	
	public interface Getter extends EchoObject.Getter {
		/**
		 * プロパティ名称:動作状態
		 * EPC:0x80
		 * アクセスルール:Set/Get(必須)
		 * 状態変化アナウンス必須
		 */
		public Getter reqGetPower();
		/**
		 * プロパティ名称:設置場所
		 * EPC:0x81
		 * アクセスルール:Set(必須)/Get(必須)
		 * 状態変化アナウンス必須
		 */
		public Getter reqGetInstallationLocation();
		/**
		 * プロパティ名称:Version情報
		 * EPC:0x82
		 * アクセスルール:Get(必須)
		 */ 
		public Getter reqGetVersion();
		/**
		 * プロパティ名称:識別番号
		 * EPC:0x83
		 * アクセスルール:Get
		 */
		public Getter reqGetIdNumber();
		/**
		 * プロパティ名称:瞬時消費電力計測値
		 * EPC:0x84
		 * アクセスルール:Get
		 */
		public Getter reqGetElectricityConsumption();
		/**
		 * プロパティ名称:積算消費電力計測値
		 * EPC:0x85
		 * アクセスルール:Get
		 */
		public Getter reqGetPowerConsumption();
		/**
		 * プロパティ名称:メーカ異常コード
		 * EPC:0x86
		 * アクセスルール:Get
		 */	
		public Getter reqGetMakerErrorCode();
		/**
		 * プロパティ名称:電流制限設定
		 * EPC:0x87
		 * アクセスルール:Set/Get
		 */
		public Getter reqGetCurrentLimiting();
		/**
		 * プロパティ名称:異常発生状態
		 * EPC:0x88
		 * アクセスルール:Get(必須)
		 */
		public Getter reqGetError();
		/**
		 * プロパティ名称:異常内容
		 * EPC:0x89
		 * アクセスルール:Get
		 */
		public Getter reqGetErrorInfo();
		/**
		 * プロパティ名称:メーカコード
		 * EPC:0x8A
		 * アクセスルール:Get(必須)
		 */ 
		public Getter reqGetMakerCode();
		/**
		 * プロパティ名称:事業場コード
		 * EPC:0x8B
		 * アクセスルール:Get
		 */
		public Getter reqGetWorkplaceCode();
		/**
		 * プロパティ名称:商品コード
		 * EPC:0x8C
		 * アクセスルール:Get
		 */
		public Getter reqGetProductCode();
		/**
		 * プロパティ名称:製造番号
		 * EPC:0x8D
		 * アクセスルール:Get
		 */
		public Getter reqGetManufacturingNumber();
		/**
		 * プロパティ名称:製造年月日
		 * EPC:0x8E
		 * アクセスルール:Get
		 */
		public Getter reqGetDateOfManufacture();
		/**
		 * プロパティ名称:節電動作設定
		 * EPC:0x8F
		 * アクセスルール:Set/Get
		 */
		public Getter reqGetPowerSaving();
		/**
		 * プロパティ名称:位置情報
		 * EPC:0x93
		 * アクセスルール:Set/Get
		 * 状態変化アナウンス必須
		 */	
		public Getter reqGetLocation();
		/**
		 * プロパティ名称:現在時刻設定
		 * EPC:0x97
		 * アクセスルール:Set/Get
		 */
		public Getter reqGetCurrentTime();
		/**
		 * プロパティ名称:現在年月日設定
		 * EPC:0x98
		 * アクセスルール:Set/Get
		 */
		public Getter reqGetCurrentDate();
		/**
		 * プロパティ名称:電力制限設定
		 * EPC:0x99
		 * アクセスルール:Set/Get
		 */
		public Getter reqGetPowerLimitation();
		/**
		 * プロパティ名称:積算運転時間
		 * EPC:0x9A
		 * アクセスルール:Set/Get
		 */
		public Getter reqGetWorkingTime();
		/**
		 * プロパティ名称:状変アナウンスプロパティマップ
		 * EPC:0x9D
		 * アクセスルール:Get(必須)
		 */
		public Getter reqGetAnnoPropertyMap();
		/**
		 * プロパティ名称:Setプロパティマップ
		 * EPC:0x9E
		 * アクセスルール:Get(必須)
		 */
		public Getter reqGetSetPropertyMap();
		/**
		 * プロパティ名称:Getプロパティマップ
		 * EPC:0x9F
		 * アクセスルール:Get(必須)
		 */
		public Getter reqGetGetPropertyMap();
	}
	
	public class GetterImpl extends EchoObject.GetterImpl implements Getter {

		@Override
		public Getter reqGetPower() {
			byte[] edt = getPower();
			addProperty(EPC_POWER, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetInstallationLocation() {
			byte[] edt = getInstallationLocation();
			addProperty(EPC_INSTALLATION_LOCATION, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetVersion() {
			byte[] edt = getVersion();
			addProperty(EPC_VERSION, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Getter reqGetIdNumber() {
			byte[] edt = getIdNumber();
			addProperty(EPC_ID_NUMBER, edt, (edt != null && (edt.length == 9 || edt.length == 17)));
			return this;
		}

		@Override
		public Getter reqGetElectricityConsumption() {
			byte[] edt = getElectricityConsumption();
			addProperty(EPC_ELECTRICITY_CONSUMPTION, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Getter reqGetPowerConsumption() {
			byte[] edt = getPowerConsumption();
			addProperty(EPC_POWER_CONSUMPTION, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Getter reqGetMakerErrorCode() {
			byte[] edt = getMakerErrorCode();
			addProperty(EPC_MAKER_ERROR_CODE, edt, (edt != null && edt.length <= 225));
			return this;
		}

		@Override
		public Getter reqGetCurrentLimiting() {
			byte[] edt = getCurrentLimiting();
			addProperty(EPC_CURRENT_LIMITING, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetError() {
			byte[] edt = getError();
			addProperty(EPC_ERROR, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetErrorInfo() {
			byte[] edt = getErrorInfo();
			addProperty(EPC_ERROR_INFO, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Getter reqGetMakerCode() {
			byte[] edt = getMakerCode();
			addProperty(EPC_MAKER_CODE, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Getter reqGetWorkplaceCode() {
			byte[] edt = getWorkplaceCode();
			addProperty(EPC_WORKPLACE_CODE, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Getter reqGetProductCode() {
			byte[] edt = getProductCode();
			addProperty(EPC_PRODUCT_CODE, edt, (edt != null && edt.length == 12));
			return this;
		}

		@Override
		public Getter reqGetManufacturingNumber() {
			byte[] edt = getManufacturingNumber();
			addProperty(EPC_MANUFACTURING_NUMBER, edt, (edt != null && edt.length == 12));
			return this;
		}

		@Override
		public Getter reqGetDateOfManufacture() {
			byte[] edt = getDateOfManufacture();
			addProperty(EPC_DATE_OF_MANUFACTURE, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Getter reqGetPowerSaving() {
			byte[] edt = getPowerSaving();
			addProperty(EPC_POWER_SAVING, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetLocation() {
			byte[] edt = getLocation();
			addProperty(EPC_LOCATION, edt, (edt != null && edt.length == 16));
			return this;
		}

		@Override
		public Getter reqGetCurrentTime() {
			byte[] edt = getCurrentTime();
			addProperty(EPC_CURRENT_TIME, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Getter reqGetCurrentDate() {
			byte[] edt = getCurrentDate();
			addProperty(EPC_CURRENT_DATE, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Getter reqGetPowerLimitation() {
			byte[] edt = getPowerLimitation();
			addProperty(EPC_POWER_LIMITATION, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Getter reqGetWorkingTime() {
			byte[] edt = getWorkingTime();
			addProperty(EPC_WORKING_TIME, edt, (edt != null && edt.length == 5));
			return this;
		}

		@Override
		public Getter reqGetAnnoPropertyMap() {
			byte[] edt = getAnnoPropertyMap();
			addProperty(EPC_ANNO_PROPERTY_MAP, edt, (edt != null && edt.length <= 17));
			return this;
		}

		@Override
		public Getter reqGetSetPropertyMap() {
			byte[] edt = getSetPropertyMap();
			addProperty(EPC_SET_PROPERTY_MAP, edt, (edt != null && edt.length <= 17));
			return this;
		}

		@Override
		public Getter reqGetGetPropertyMap() {
			byte[] edt = getGetPropertyMap();
			addProperty(EPC_GET_PROPERTY_MAP, edt, (edt != null && edt.length <= 17));
			return this;
		}
		
	}
	
	public class GetterProxy extends EchoObject.GetterProxy implements Getter {

		@Override
		public Getter reqGetPower() {
			addProperty(EPC_POWER);
			return this;
		}

		@Override
		public Getter reqGetInstallationLocation() {
			addProperty(EPC_INSTALLATION_LOCATION);
			return this;
		}

		@Override
		public Getter reqGetVersion() {
			addProperty(EPC_VERSION);
			return this;
		}

		@Override
		public Getter reqGetIdNumber() {
			addProperty(EPC_ID_NUMBER);
			return this;
		}

		@Override
		public Getter reqGetElectricityConsumption() {
			addProperty(EPC_ELECTRICITY_CONSUMPTION);
			return this;
		}

		@Override
		public Getter reqGetPowerConsumption() {
			addProperty(EPC_POWER_CONSUMPTION);
			return this;
		}

		@Override
		public Getter reqGetMakerErrorCode() {
			addProperty(EPC_MAKER_ERROR_CODE);
			return this;
		}

		@Override
		public Getter reqGetCurrentLimiting() {
			addProperty(EPC_CURRENT_LIMITING);
			return this;
		}

		@Override
		public Getter reqGetError() {
			addProperty(EPC_ERROR);
			return this;
		}

		@Override
		public Getter reqGetErrorInfo() {
			addProperty(EPC_ERROR_INFO);
			return this;
		}

		@Override
		public Getter reqGetMakerCode() {
			addProperty(EPC_MAKER_CODE);
			return this;
		}

		@Override
		public Getter reqGetWorkplaceCode() {
			addProperty(EPC_WORKPLACE_CODE);
			return this;
		}

		@Override
		public Getter reqGetProductCode() {
			addProperty(EPC_PRODUCT_CODE);
			return this;
		}

		@Override
		public Getter reqGetManufacturingNumber() {
			addProperty(EPC_MANUFACTURING_NUMBER);
			return this;
		}

		@Override
		public Getter reqGetDateOfManufacture() {
			addProperty(EPC_DATE_OF_MANUFACTURE);
			return this;
		}

		@Override
		public Getter reqGetPowerSaving() {
			addProperty(EPC_POWER_SAVING);
			return this;
		}

		@Override
		public Getter reqGetLocation() {
			addProperty(EPC_LOCATION);
			return this;
		}

		@Override
		public Getter reqGetCurrentTime() {
			addProperty(EPC_CURRENT_TIME);
			return this;
		}

		@Override
		public Getter reqGetCurrentDate() {
			addProperty(EPC_CURRENT_DATE);
			return this;
		}

		@Override
		public Getter reqGetPowerLimitation() {
			addProperty(EPC_POWER_LIMITATION);
			return this;
		}

		@Override
		public Getter reqGetWorkingTime() {
			addProperty(EPC_WORKING_TIME);
			return this;
		}

		@Override
		public Getter reqGetAnnoPropertyMap() {
			addProperty(EPC_ANNO_PROPERTY_MAP);
			return this;
		}

		@Override
		public Getter reqGetSetPropertyMap() {
			addProperty(EPC_GET_PROPERTY_MAP);
			return this;
		}

		@Override
		public Getter reqGetGetPropertyMap() {
			addProperty(EPC_GET_PROPERTY_MAP);
			return this;
		}
		
	}
	
	public interface Informer extends EchoObject.Informer {
		/**
		 * プロパティ名称:動作状態
		 * EPC:0x80
		 * アクセスルール:Set/Get(必須)
		 * 状態変化アナウンス必須
		 */
		public Informer reqInformPower();
		/**
		 * プロパティ名称:設置場所
		 * EPC:0x81
		 * アクセスルール:Set(必須)/Get(必須)
		 * 状態変化アナウンス必須
		 */
		public Informer reqInformInstallationLocation();
		/**
		 * プロパティ名称:Version情報
		 * EPC:0x82
		 * アクセスルール:Get(必須)
		 */ 
		public Informer reqInformVersion();
		/**
		 * プロパティ名称:識別番号
		 * EPC:0x83
		 * アクセスルール:Get
		 */
		public Informer reqInformIdNumber();
		/**
		 * プロパティ名称:瞬時消費電力計測値
		 * EPC:0x84
		 * アクセスルール:Get
		 */
		public Informer reqInformElectricityConsumption();
		/**
		 * プロパティ名称:積算消費電力計測値
		 * EPC:0x85
		 * アクセスルール:Get
		 */
		public Informer reqInformPowerConsumption();
		/**
		 * プロパティ名称:メーカ異常コード
		 * EPC:0x86
		 * アクセスルール:Get
		 */	
		public Informer reqInformMakerErrorCode();
		/**
		 * プロパティ名称:電流制限設定
		 * EPC:0x87
		 * アクセスルール:Set/Get
		 */
		public Informer reqInformCurrentLimiting();
		/**
		 * プロパティ名称:異常発生状態
		 * EPC:0x88
		 * アクセスルール:Get(必須)
		 */
		public Informer reqInformError();
		/**
		 * プロパティ名称:異常内容
		 * EPC:0x89
		 * アクセスルール:Get
		 */
		public Informer reqInformErrorInfo();
		/**
		 * プロパティ名称:メーカコード
		 * EPC:0x8A
		 * アクセスルール:Get(必須)
		 */ 
		public Informer reqInformMakerCode();
		/**
		 * プロパティ名称:事業場コード
		 * EPC:0x8B
		 * アクセスルール:Get
		 */
		public Informer reqInformWorkplaceCode();
		/**
		 * プロパティ名称:商品コード
		 * EPC:0x8C
		 * アクセスルール:Get
		 */
		public Informer reqInformProductCode();
		/**
		 * プロパティ名称:製造番号
		 * EPC:0x8D
		 * アクセスルール:Get
		 */
		public Informer reqInformManufacturingNumber();
		/**
		 * プロパティ名称:製造年月日
		 * EPC:0x8E
		 * アクセスルール:Get
		 */
		public Informer reqInformDateOfManufacture();
		/**
		 * プロパティ名称:節電動作設定
		 * EPC:0x8F
		 * アクセスルール:Set/Get
		 */
		public Informer reqInformPowerSaving();
		/**
		 * プロパティ名称:位置情報
		 * EPC:0x93
		 * アクセスルール:Set/Get
		 * 状態変化アナウンス必須
		 */	
		public Informer reqInformLocation();
		/**
		 * プロパティ名称:現在時刻設定
		 * EPC:0x97
		 * アクセスルール:Set/Get
		 */
		public Informer reqInformCurrentTime();
		/**
		 * プロパティ名称:現在年月日設定
		 * EPC:0x98
		 * アクセスルール:Set/Get
		 */
		public Informer reqInformCurrentDate();
		/**
		 * プロパティ名称:電力制限設定
		 * EPC:0x99
		 * アクセスルール:Set/Get
		 */
		public Informer reqInformPowerLimitation();
		/**
		 * プロパティ名称:積算運転時間
		 * EPC:0x9A
		 * アクセスルール:Set/Get
		 */
		public Informer reqInformWorkingTime();
		/**
		 * プロパティ名称:状変アナウンスプロパティマップ
		 * EPC:0x9D
		 * アクセスルール:Get(必須)
		 */
		public Informer reqInformAnnoPropertyMap();
		/**
		 * プロパティ名称:Setプロパティマップ
		 * EPC:0x9E
		 * アクセスルール:Get(必須)
		 */
		public Informer reqInformSetPropertyMap();
		/**
		 * プロパティ名称:Getプロパティマップ
		 * EPC:0x9F
		 * アクセスルール:Get(必須)
		 */
		public Informer reqInformGetPropertyMap();
	}
	
	public class InformerImpl extends EchoObject.InformerImpl implements Informer {

		@Override
		public Informer reqInformPower() {
			byte[] edt = getPower();
			addProperty(EPC_POWER, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformInstallationLocation() {
			byte[] edt = getInstallationLocation();
			addProperty(EPC_INSTALLATION_LOCATION, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformVersion() {
			byte[] edt = getVersion();
			addProperty(EPC_VERSION, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Informer reqInformIdNumber() {
			byte[] edt = getIdNumber();
			addProperty(EPC_ID_NUMBER, edt, (edt != null && (edt.length == 9 || edt.length == 17)));
			return this;
		}

		@Override
		public Informer reqInformElectricityConsumption() {
			byte[] edt = getElectricityConsumption();
			addProperty(EPC_ELECTRICITY_CONSUMPTION, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformPowerConsumption() {
			byte[] edt = getPowerConsumption();
			addProperty(EPC_POWER_CONSUMPTION, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Informer reqInformMakerErrorCode() {
			byte[] edt = getMakerErrorCode();
			addProperty(EPC_MAKER_ERROR_CODE, edt, (edt != null && edt.length <= 225));
			return this;
		}

		@Override
		public Informer reqInformCurrentLimiting() {
			byte[] edt = getCurrentLimiting();
			addProperty(EPC_CURRENT_LIMITING, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformError() {
			byte[] edt = getError();
			addProperty(EPC_ERROR, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformErrorInfo() {
			byte[] edt = getErrorInfo();
			addProperty(EPC_ERROR_INFO, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformMakerCode() {
			byte[] edt = getMakerCode();
			addProperty(EPC_MAKER_CODE, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Informer reqInformWorkplaceCode() {
			byte[] edt = getWorkplaceCode();
			addProperty(EPC_WORKPLACE_CODE, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Informer reqInformProductCode() {
			byte[] edt = getProductCode();
			addProperty(EPC_PRODUCT_CODE, edt, (edt != null && edt.length == 12));
			return this;
		}

		@Override
		public Informer reqInformManufacturingNumber() {
			byte[] edt = getManufacturingNumber();
			addProperty(EPC_MANUFACTURING_NUMBER, edt, (edt != null && edt.length == 12));
			return this;
		}

		@Override
		public Informer reqInformDateOfManufacture() {
			byte[] edt = getDateOfManufacture();
			addProperty(EPC_DATE_OF_MANUFACTURE, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Informer reqInformPowerSaving() {
			byte[] edt = getPowerSaving();
			addProperty(EPC_POWER_SAVING, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformLocation() {
			byte[] edt = getLocation();
			addProperty(EPC_LOCATION, edt, (edt != null && edt.length == 16));
			return this;
		}

		@Override
		public Informer reqInformCurrentTime() {
			byte[] edt = getCurrentTime();
			addProperty(EPC_CURRENT_TIME, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformCurrentDate() {
			byte[] edt = getCurrentDate();
			addProperty(EPC_CURRENT_DATE, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Informer reqInformPowerLimitation() {
			byte[] edt = getPowerLimitation();
			addProperty(EPC_POWER_LIMITATION, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformWorkingTime() {
			byte[] edt = getWorkingTime();
			addProperty(EPC_WORKING_TIME, edt, (edt != null && edt.length == 5));
			return this;
		}

		@Override
		public Informer reqInformAnnoPropertyMap() {
			byte[] edt = getAnnoPropertyMap();
			addProperty(EPC_ANNO_PROPERTY_MAP, edt, (edt != null && edt.length <= 17));
			return this;
		}

		@Override
		public Informer reqInformSetPropertyMap() {
			byte[] edt = getSetPropertyMap();
			addProperty(EPC_SET_PROPERTY_MAP, edt, (edt != null && edt.length <= 17));
			return this;
		}

		@Override
		public Informer reqInformGetPropertyMap() {
			byte[] edt = getGetPropertyMap();
			addProperty(EPC_GET_PROPERTY_MAP, edt, (edt != null && edt.length <= 17));
			return this;
		}
		
	}

	public class InformerProxy extends EchoObject.InformerProxy implements Informer {

		@Override
		public Informer reqInformPower() {
			addProperty(EPC_POWER);
			return this;
		}

		@Override
		public Informer reqInformInstallationLocation() {
			addProperty(EPC_INSTALLATION_LOCATION);
			return this;
		}

		@Override
		public Informer reqInformVersion() {
			addProperty(EPC_VERSION);
			return this;
		}

		@Override
		public Informer reqInformIdNumber() {
			addProperty(EPC_ID_NUMBER);
			return this;
		}

		@Override
		public Informer reqInformElectricityConsumption() {
			addProperty(EPC_ELECTRICITY_CONSUMPTION);
			return this;
		}

		@Override
		public Informer reqInformPowerConsumption() {
			addProperty(EPC_POWER_CONSUMPTION);
			return this;
		}

		@Override
		public Informer reqInformMakerErrorCode() {
			addProperty(EPC_MAKER_ERROR_CODE);
			return this;
		}

		@Override
		public Informer reqInformCurrentLimiting() {
			addProperty(EPC_CURRENT_LIMITING);
			return this;
		}

		@Override
		public Informer reqInformError() {
			addProperty(EPC_ERROR);
			return this;
		}

		@Override
		public Informer reqInformErrorInfo() {
			addProperty(EPC_ERROR_INFO);
			return this;
		}

		@Override
		public Informer reqInformMakerCode() {
			addProperty(EPC_MAKER_CODE);
			return this;
		}

		@Override
		public Informer reqInformWorkplaceCode() {
			addProperty(EPC_WORKPLACE_CODE);
			return this;
		}

		@Override
		public Informer reqInformProductCode() {
			addProperty(EPC_PRODUCT_CODE);
			return this;
		}

		@Override
		public Informer reqInformManufacturingNumber() {
			addProperty(EPC_MANUFACTURING_NUMBER);
			return this;
		}

		@Override
		public Informer reqInformDateOfManufacture() {
			addProperty(EPC_DATE_OF_MANUFACTURE);
			return this;
		}

		@Override
		public Informer reqInformPowerSaving() {
			addProperty(EPC_POWER_SAVING);
			return this;
		}

		@Override
		public Informer reqInformLocation() {
			addProperty(EPC_LOCATION);
			return this;
		}

		@Override
		public Informer reqInformCurrentTime() {
			addProperty(EPC_CURRENT_TIME);
			return this;
		}

		@Override
		public Informer reqInformCurrentDate() {
			addProperty(EPC_CURRENT_DATE);
			return this;
		}

		@Override
		public Informer reqInformPowerLimitation() {
			addProperty(EPC_POWER_LIMITATION);
			return this;
		}

		@Override
		public Informer reqInformWorkingTime() {
			addProperty(EPC_WORKING_TIME);
			return this;
		}

		@Override
		public Informer reqInformAnnoPropertyMap() {
			addProperty(EPC_ANNO_PROPERTY_MAP);
			return this;
		}

		@Override
		public Informer reqInformSetPropertyMap() {
			addProperty(EPC_SET_PROPERTY_MAP);
			return this;
		}

		@Override
		public Informer reqInformGetPropertyMap() {
			addProperty(EPC_GET_PROPERTY_MAP);
			return this;
		}
		
	}
}
