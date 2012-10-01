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
package com.sonycsl.echo.eoj.profile;

import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.eoj.EchoObject;

public abstract class ProfileObject extends EchoObject {

	protected static final byte EPC_FAULT_STATUS = (byte)0x88;
	protected static final byte EPC_MANUFACTURER_CODE = (byte)0x8A;
	protected static final byte EPC_PLACE_OF_BUSINESS_CODE = (byte)0x8B;
	protected static final byte EPC_PRODUCT_CODE =  (byte)0x8C;
	protected static final byte EPC_SERIAL_NUMBER = (byte)0x8D;
	protected static final byte EPC_DATE_OF_MANUFACTURE = (byte)0x8E;
	protected static final byte EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP = (byte)0x9D;
	protected static final byte EPC_SET_PROPERTY_MAP = (byte)0x9E;
	protected static final byte EPC_GET_PROPERTY_MAP = (byte)0x9F;
	

	public static final byte[] ERROR_TRUE = {(byte)0x41};
	public static final byte[] ERROR_FALSE = {(byte)0x42};
	
	/**
	 * プロパティ名称:異常発生状態
	 * EPC:0x88
	 * アクセスルール:Get
	 */
	protected byte[] getFaultStatus() {
		return null;
	}

	/**
	 * プロパティ名称:メーカコード
	 * EPC:0x8A
	 * アクセスルール:Get(必須)
	 */ 
	protected abstract byte[] getManufacturerCode();
	
	/**
	 * プロパティ名称:事業場コード
	 * EPC:0x8B
	 * アクセスルール:Get
	 */
	protected byte[] getPlaceOfBusinessCode() {
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
	protected byte[] getSerialNumber() {
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
	 * プロパティ名称:状変アナウンスプロパティマップ
	 * EPC:0x9D
	 * アクセスルール:Get(必須)
	 */
	protected abstract byte[] getStatusChangeAnnouncementPropertyMap() ;
	
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
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_FAULT_STATUS:
			edt = getFaultStatus();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_MANUFACTURER_CODE:
			edt = getManufacturerCode();
			res.addProperty(epc, edt, (edt != null && edt.length == 3));
			break;
		case EPC_PLACE_OF_BUSINESS_CODE:
			edt = getPlaceOfBusinessCode();
			res.addProperty(epc, edt, (edt != null && edt.length == 3));
			break;
		case EPC_PRODUCT_CODE:
			edt = getProductCode();
			res.addProperty(epc, edt, (edt != null && edt.length == 12));
			break;
		case EPC_SERIAL_NUMBER:
			edt = getSerialNumber();
			res.addProperty(epc, edt, (edt != null && edt.length == 12));
			break;
		case EPC_DATE_OF_MANUFACTURE:
			edt = getDateOfManufacture();
			res.addProperty(epc, edt, (edt != null && edt.length == 4));
			break;
		case EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP:
			edt = getStatusChangeAnnouncementPropertyMap();
			res.addProperty(epc, edt, (edt != null && edt.length <= 17));
			break;
		case EPC_SET_PROPERTY_MAP:
			edt = getSetPropertyMap();
			res.addProperty(epc, edt, (edt != null && edt.length <= 17));
			break;
		case EPC_GET_PROPERTY_MAP:
			edt = getGetPropertyMap();
			res.addProperty(epc, edt, (edt != null && edt.length <= 17));
			break;
		}
	}

	@Override
	protected void onReceiveInfReq(EchoFrame res, byte epc) {
		super.onReceiveInfReq(res, epc);
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
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_FAULT_STATUS:
				onGetFaultStatus(eoj, tid, pdc, edt);
				break;
			case EPC_MANUFACTURER_CODE:
				onGetManufacturerCode(eoj, tid, pdc, edt);
				break;
			case EPC_PLACE_OF_BUSINESS_CODE:
				onGetPlaceOfBusinessCode(eoj, tid, pdc, edt);
				break;
			case EPC_PRODUCT_CODE:
				onGetProductCode(eoj, tid, pdc, edt);
				break;
			case EPC_SERIAL_NUMBER:
				onGetSerialNumber(eoj, tid, pdc, edt);
				break;
			case EPC_DATE_OF_MANUFACTURE:
				onGetDateOfManufacture(eoj, tid, pdc, edt);
				break;
			case EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP:
				onGetStatusChangeAnnouncementPropertyMap(eoj, tid, pdc, edt);
				break;
			case EPC_SET_PROPERTY_MAP:
				onGetSetPropertyMap(eoj, tid, pdc, edt);
				break;
			case EPC_GET_PROPERTY_MAP:
				onGetGetPropertyMap(eoj, tid, pdc, edt);
				break;
			}
		}

		@Override
		protected void onReceiveInfC(EchoObject eoj, short tid, byte epc, byte pdc, byte[] edt) {
			super.onReceiveInfC(eoj, tid, epc, pdc, edt);
		}

		@Override
		protected void onReceiveInfCRes(EchoObject eoj, short tid, byte epc, byte pdc,
				byte[] edt) {
			super.onReceiveInfCRes(eoj, tid, epc, pdc, edt);
		}
		
		protected void onGetFaultStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onGetManufacturerCode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onGetPlaceOfBusinessCode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}
		
		protected void onGetProductCode(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onGetSerialNumber(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}
		
		protected void onGetDateOfManufacture(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onGetStatusChangeAnnouncementPropertyMap(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}
		
		protected void onGetSetPropertyMap(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}
		
		protected void onGetGetPropertyMap(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}
	}

	public interface Setter extends EchoObject.Setter {
		
	}
	
	public class SetterImpl extends EchoObject.SetterImpl implements Setter {
		public SetterImpl(byte esv) {
			super(esv);
		}
	}
	
	public class SetterProxy extends EchoObject.SetterProxy implements Setter {
		public SetterProxy(byte esv) {
			super(esv);
		}
	}
	
	public interface Getter extends EchoObject.Getter {
		public Getter reqGetFaultStatus();
		public Getter reqGetManufacturerCode();
		public Getter reqGetPlaceOfBusinessCode();
		public Getter reqGetProductCode();
		public Getter reqGetSerialNumber();
		public Getter reqGetDateOfManufacture();
		public Getter reqGetStatusChangeAnnouncementPropertyMap();
		public Getter reqGetSetPropertyMap();
		public Getter reqGetGetPropertyMap();
	}
	
	public class GetterImpl extends EchoObject.GetterImpl implements Getter {
		
		@Override
		public Getter reqGetFaultStatus() {
			byte[] edt = getFaultStatus();
			addProperty(EPC_FAULT_STATUS, edt, (edt != null && edt.length == 1));
			return this;
		}
		
		@Override
		public Getter reqGetManufacturerCode() {
			byte[] edt = getManufacturerCode();
			addProperty(EPC_MANUFACTURER_CODE, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Getter reqGetPlaceOfBusinessCode() {
			byte[] edt = getPlaceOfBusinessCode();
			addProperty(EPC_PLACE_OF_BUSINESS_CODE, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Getter reqGetProductCode() {
			byte[] edt = getProductCode();
			addProperty(EPC_PRODUCT_CODE, edt, (edt != null && edt.length == 12));
			return this;
		}

		@Override
		public Getter reqGetSerialNumber() {
			byte[] edt = getSerialNumber();
			addProperty(EPC_SERIAL_NUMBER, edt, (edt != null && edt.length == 12));
			return this;
		}

		@Override
		public Getter reqGetDateOfManufacture() {
			byte[] edt = getDateOfManufacture();
			addProperty(EPC_DATE_OF_MANUFACTURE, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Getter reqGetStatusChangeAnnouncementPropertyMap() {
			byte[] edt = getStatusChangeAnnouncementPropertyMap();
			addProperty(EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP, edt, (edt != null && edt.length <= 17));
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
		public Getter reqGetFaultStatus() {
			addProperty(EPC_FAULT_STATUS);
			return this;
		}

		@Override
		public Getter reqGetManufacturerCode() {
			addProperty(EPC_MANUFACTURER_CODE);
			return this;
		}

		@Override
		public Getter reqGetPlaceOfBusinessCode() {
			addProperty(EPC_PLACE_OF_BUSINESS_CODE);
			return this;
		}

		@Override
		public Getter reqGetProductCode() {
			addProperty(EPC_PRODUCT_CODE);
			return this;
		}

		@Override
		public Getter reqGetSerialNumber() {
			addProperty(EPC_SERIAL_NUMBER);
			return this;
		}

		@Override
		public Getter reqGetDateOfManufacture() {
			addProperty(EPC_DATE_OF_MANUFACTURE);
			return this;
		}

		@Override
		public Getter reqGetStatusChangeAnnouncementPropertyMap() {
			addProperty(EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP);
			return this;
		}

		@Override
		public Getter reqGetSetPropertyMap() {
			addProperty(EPC_SET_PROPERTY_MAP);
			return this;
		}

		@Override
		public Getter reqGetGetPropertyMap() {
			addProperty(EPC_GET_PROPERTY_MAP);
			return this;
		}
		
	}
	
	public interface Informer extends EchoObject.Informer {
		public Informer reqInformFaultStatus();
		public Informer reqInformManufacturerCode();
		public Informer reqInformPlaceOfBusinessCode();
		public Informer reqInformProductCode();
		public Informer reqInformSerialNumber();
		public Informer reqInformDateOfManufacture();
		public Informer reqInformStatusChangeAnnouncementPropertyMap();
		public Informer reqInformSetPropetyMap();
		public Informer reqInformGetPropetyMap();
	}

	public class InformerImpl extends EchoObject.InformerImpl implements Informer {

		@Override
		public Informer reqInformFaultStatus() {
			byte[] edt = getFaultStatus();
			addProperty(EPC_FAULT_STATUS, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformManufacturerCode() {
			byte[] edt = getManufacturerCode();
			addProperty(EPC_MANUFACTURER_CODE, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Informer reqInformPlaceOfBusinessCode() {
			byte[] edt = getPlaceOfBusinessCode();
			addProperty(EPC_PLACE_OF_BUSINESS_CODE, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Informer reqInformProductCode() {
			byte[] edt = getProductCode();
			addProperty(EPC_PRODUCT_CODE, edt, (edt != null && edt.length == 12));
			return this;
		}

		@Override
		public Informer reqInformSerialNumber() {
			byte[] edt = getSerialNumber();
			addProperty(EPC_SERIAL_NUMBER, edt, (edt != null && edt.length == 12));
			return this;
		}

		@Override
		public Informer reqInformDateOfManufacture() {
			byte[] edt = getDateOfManufacture();
			addProperty(EPC_DATE_OF_MANUFACTURE, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Informer reqInformStatusChangeAnnouncementPropertyMap() {
			byte[] edt = getStatusChangeAnnouncementPropertyMap();
			addProperty(EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP, edt, (edt != null && edt.length <= 17));
			return this;
		}

		@Override
		public Informer reqInformSetPropetyMap() {
			byte[] edt = getSetPropertyMap();
			addProperty(EPC_SET_PROPERTY_MAP, edt, (edt != null && edt.length <= 17));
			return this;
		}

		@Override
		public Informer reqInformGetPropetyMap() {
			byte[] edt = getGetPropertyMap();
			addProperty(EPC_GET_PROPERTY_MAP, edt, (edt != null && edt.length <= 17));
			return this;
		}
		
	}

	public class InformerProxy extends EchoObject.InformerProxy implements Informer {

		@Override
		public Informer reqInformFaultStatus() {
			addProperty(EPC_FAULT_STATUS);
			return this;
		}

		@Override
		public Informer reqInformManufacturerCode() {
			addProperty(EPC_MANUFACTURER_CODE);
			return this;
		}

		@Override
		public Informer reqInformPlaceOfBusinessCode() {
			addProperty(EPC_PLACE_OF_BUSINESS_CODE);
			return this;
		}

		@Override
		public Informer reqInformProductCode() {
			addProperty(EPC_PRODUCT_CODE);
			return this;
		}

		@Override
		public Informer reqInformSerialNumber() {
			addProperty(EPC_SERIAL_NUMBER);
			return this;
		}

		@Override
		public Informer reqInformDateOfManufacture() {
			addProperty(EPC_DATE_OF_MANUFACTURE);
			return this;
		}

		@Override
		public Informer reqInformStatusChangeAnnouncementPropertyMap() {
			addProperty(EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP);
			return this;
		}

		@Override
		public Informer reqInformSetPropetyMap() {
			addProperty(EPC_SET_PROPERTY_MAP);
			return this;
		}

		@Override
		public Informer reqInformGetPropetyMap() {
			addProperty(EPC_GET_PROPERTY_MAP);
			return this;
		}
		
	}
}
