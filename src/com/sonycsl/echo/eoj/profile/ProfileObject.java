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
	
	/**
	 * Indicates an encountered abnormality (sensor trouble, etc.).<br>
	 * Fault encountered = 0x41, no fault encountered = 0x42<br><br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Set : undefined<br>
	 * Get : optional<br>
	 */
	protected byte[] getFaultStatus() {
		return null;
	}
	private final byte[] _getFaultStatus(byte epc) {
		byte[] edt = getFaultStatus();
		notify(epc, edt);
		return edt;
	}

	/**
	 * Stipulated in 3 bytes<br>
	 * (To be specified by ECHONET Consortium)<br><br>
	 * Data type : unsigned char×3<br>
	 * Data size : 3<br>
	 * Set : undefined<br>
	 * Get : mandatory<br>
	 */
	protected abstract byte[] getManufacturerCode();
	private final byte[] _getManufacturerCode(byte epc) {
		byte[] edt = getManufacturerCode();
		notify(epc, edt);
		return edt;
	}
	
	/**
	 * Stipulated in 3-byte place-of-business code<br>
	 * (Specified individually by each char×3 manufacturer)<br><br>
	 * Data type : unsigned char×3<br>
	 * Data size : 3<br>
	 * Set : undefined<br>
	 * Get : optional<br>
	 */
	protected byte[] getPlaceOfBusinessCode() {
		return null;
	}
	private final byte[] _getPlaceOfBusinessCode(byte epc) {
		byte[] edt = getPlaceOfBusinessCode();
		notify(epc, edt);
		return edt;
	}
	
	/**
	 * Specified in ASCII code<br>
	 * (Specified individually by each manufacturer)<br><br>
	 * Data type : unsigned char×12<br>
	 * Data size : 12<br>
	 * Set : undefined<br>
	 * Get : optional<br>
	 */
	protected byte[] getProductCode() {
		return null;
	}
	private final byte[] _getProductCode(byte epc) {
		byte[] edt = getProductCode();
		notify(epc, edt);
		return edt;
	}

	/**
	 * Specified in ASCII code<br>
	 * (Specified individually by each manufacturer)<br><br>
	 * Data type : unsigned char×12<br>
	 * Data size : 12<br>
	 * Set : undefined<br>
	 * Get : optional<br>
	 */
	protected byte[] getSerialNumber() {
		return null;
	}
	private final byte[] _getSerialNumber(byte epc) {
		byte[] edt = getSerialNumber();
		notify(epc, edt);
		return edt;
	}
	
	/**
	 * Stipulated in 4 bytes<br>
	 * YYMD (1 byte/character)<br>
	 * YY:Year (0x07CF for 1999)<br>M:Month (0x0C for 12)<br>
	 * D:Day (0x14 for 20)<br><br>
	 * Data type : unsigned char×4<br>
	 * Data size : 4<br>
	 * Set : undefined<br>
	 * Get : optional<br>
	 */
	protected byte[] getDateOfManufacture() {
		return null;
	}
	private final byte[] _getDateOfManufacture(byte epc) {
		byte[] edt = getDateOfManufacture();
		notify(epc, edt);
		return edt;
	}
	
	/**
	 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
	 * Data type : unsigned char×(MAX17)<br>
	 * Data size : Max.17<br>
	 * Set : undefined<br>
	 * Get : mandatory
	 */
	protected abstract byte[] getStatusChangeAnnouncementPropertyMap();
	private final byte[] _getStatusChangeAnnouncementPropertyMap(byte epc) {
		byte[] edt = getStatusChangeAnnouncementPropertyMap();
		notify(epc, edt);
		return edt;
	}
	
	/**
	 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
	 * Data type : unsigned char×(MAX17)<br>
	 * Data size : Max.17<br>
	 * Set : undefined<br>
	 * Get : mandatory
	 */
	protected abstract byte[] getSetPropertyMap();
	private final byte[] _getSetPropertyMap(byte epc) {
		byte[] edt = getSetPropertyMap();
		notify(epc, edt);
		return edt;
	}

	/**
	 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
	 * Data type : unsigned char×(MAX17)<br>
	 * Data size : Max.17<br>
	 * Set : undefined<br>
	 * Get : mandatory
	 */
	protected abstract byte[] getGetPropertyMap();
	private final byte[] _getGetPropertyMap(byte epc) {
		byte[] edt = getGetPropertyMap();
		notify(epc, edt);
		return edt;
	}
	
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
			edt = _getFaultStatus(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_MANUFACTURER_CODE:
			edt = _getManufacturerCode(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 3));
			break;
		case EPC_PLACE_OF_BUSINESS_CODE:
			edt = _getPlaceOfBusinessCode(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 3));
			break;
		case EPC_PRODUCT_CODE:
			edt = _getProductCode(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 12));
			break;
		case EPC_SERIAL_NUMBER:
			edt = _getSerialNumber(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 12));
			break;
		case EPC_DATE_OF_MANUFACTURE:
			edt = _getDateOfManufacture(epc);
			res.addProperty(epc, edt, (edt != null && edt.length == 4));
			break;
		case EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP:
			edt = _getStatusChangeAnnouncementPropertyMap(epc);
			res.addProperty(epc, edt, (edt != null && edt.length <= 17));
			break;
		case EPC_SET_PROPERTY_MAP:
			edt = _getSetPropertyMap(epc);
			res.addProperty(epc, edt, (edt != null && edt.length <= 17));
			break;
		case EPC_GET_PROPERTY_MAP:
			edt = _getGetPropertyMap(epc);
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
		protected void onReceiveSetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveSetRes(eoj, tid, esv, epc, pdc, edt);
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_FAULT_STATUS:
				_onGetFaultStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MANUFACTURER_CODE:
				_onGetManufacturerCode(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_PLACE_OF_BUSINESS_CODE:
				_onGetPlaceOfBusinessCode(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_PRODUCT_CODE:
				_onGetProductCode(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SERIAL_NUMBER:
				_onGetSerialNumber(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_DATE_OF_MANUFACTURE:
				_onGetDateOfManufacture(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP:
				_onGetStatusChangeAnnouncementPropertyMap(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_PROPERTY_MAP:
				_onGetSetPropertyMap(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GET_PROPERTY_MAP:
				_onGetGetPropertyMap(eoj, tid, esv, epc, pdc, edt);
				break;
			}
		}

		@Override
		protected void onReceiveInfC(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveInfC(eoj, tid, esv, epc, pdc, edt);
		}

		@Override
		protected void onReceiveInfCRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveInfCRes(eoj, tid, esv, epc, pdc, edt);
		}
		
		/**
		 * Indicates an encountered abnormality (sensor trouble, etc.).<br>
		 * Fault encountered = 0x41, no fault encountered = 0x42<br><br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		protected void onGetFaultStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetFaultStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetFaultStatus(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Stipulated in 3 bytes<br>
		 * (To be specified by ECHONET Consortium)<br><br>
		 * Data type : unsigned char×3<br>
		 * Data size : 3<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		protected void onGetManufacturerCode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetManufacturerCode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetManufacturerCode(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Stipulated in 3-byte place-of-business code<br>
		 * (Specified individually by each char×3 manufacturer)<br><br>
		 * Data type : unsigned char×3<br>
		 * Data size : 3<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		protected void onGetPlaceOfBusinessCode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetPlaceOfBusinessCode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetPlaceOfBusinessCode(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Specified in ASCII code<br>
		 * (Specified individually by each manufacturer)<br><br>
		 * Data type : unsigned char×12<br>
		 * Data size : 12<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		protected void onGetProductCode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetProductCode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetProductCode(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Specified in ASCII code<br>
		 * (Specified individually by each manufacturer)<br><br>
		 * Data type : unsigned char×12<br>
		 * Data size : 12<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		protected void onGetSerialNumber(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSerialNumber(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSerialNumber(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Stipulated in 4 bytes<br>
		 * YYMD (1 byte/character)<br>
		 * YY:Year (0x07CF for 1999)<br>M:Month (0x0C for 12)<br>
		 * D:Day (0x14 for 20)<br><br>
		 * Data type : unsigned char×4<br>
		 * Data size : 4<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		protected void onGetDateOfManufacture(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDateOfManufacture(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDateOfManufacture(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
		 * Data type : unsigned char×(MAX17)<br>
		 * Data size : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		protected void onGetStatusChangeAnnouncementPropertyMap(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetStatusChangeAnnouncementPropertyMap(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetStatusChangeAnnouncementPropertyMap(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
		 * Data type : unsigned char×(MAX17)<br>
		 * Data size : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		protected void onGetSetPropertyMap(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetPropertyMap(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetPropertyMap(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
		 * Data type : unsigned char×(MAX17)<br>
		 * Data size : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		protected void onGetGetPropertyMap(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGetPropertyMap(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGetPropertyMap(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
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
		/**
		 * Indicates an encountered abnormality (sensor trouble, etc.).<br>
		 * Fault encountered = 0x41, no fault encountered = 0x42<br><br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		public Getter reqGetFaultStatus();
		/**
		 * Stipulated in 3 bytes<br>
		 * (To be specified by ECHONET Consortium)<br><br>
		 * Data type : unsigned char×3<br>
		 * Data size : 3<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		public Getter reqGetManufacturerCode();
		/**
		 * Stipulated in 3-byte place-of-business code<br>
		 * (Specified individually by each char×3 manufacturer)<br><br>
		 * Data type : unsigned char×3<br>
		 * Data size : 3<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		public Getter reqGetPlaceOfBusinessCode();
		/**
		 * Specified in ASCII code<br>
		 * (Specified individually by each manufacturer)<br><br>
		 * Data type : unsigned char×12<br>
		 * Data size : 12<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		public Getter reqGetProductCode();
		/**
		 * Specified in ASCII code<br>
		 * (Specified individually by each manufacturer)<br><br>
		 * Data type : unsigned char×12<br>
		 * Data size : 12<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		public Getter reqGetSerialNumber();
		/**
		 * Stipulated in 4 bytes<br>
		 * YYMD (1 byte/character)<br>
		 * YY:Year (0x07CF for 1999)<br>M:Month (0x0C for 12)<br>
		 * D:Day (0x14 for 20)<br><br>
		 * Data type : unsigned char×4<br>
		 * Data size : 4<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		public Getter reqGetDateOfManufacture();
		/**
		 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
		 * Data type : unsigned char×(MAX17)<br>
		 * Data size : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Getter reqGetStatusChangeAnnouncementPropertyMap();
		/**
		 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
		 * Data type : unsigned char×(MAX17)<br>
		 * Data size : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Getter reqGetSetPropertyMap();
		/**
		 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
		 * Data type : unsigned char×(MAX17)<br>
		 * Data size : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Getter reqGetGetPropertyMap();
	}
	
	public class GetterImpl extends EchoObject.GetterImpl implements Getter {
		
		@Override
		public Getter reqGetFaultStatus() {
			byte epc = EPC_FAULT_STATUS;
			byte[] edt = _getFaultStatus(epc);
			addProperty(epc, edt, (edt != null && edt.length == 1));
			return this;
		}
		
		@Override
		public Getter reqGetManufacturerCode() {
			byte epc = EPC_MANUFACTURER_CODE;
			byte[] edt = _getManufacturerCode(epc);
			addProperty(epc, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Getter reqGetPlaceOfBusinessCode() {
			byte epc = EPC_PLACE_OF_BUSINESS_CODE;
			byte[] edt = _getPlaceOfBusinessCode(epc);
			addProperty(epc, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Getter reqGetProductCode() {
			byte epc = EPC_PRODUCT_CODE;
			byte[] edt = _getProductCode(epc);
			addProperty(epc, edt, (edt != null && edt.length == 12));
			return this;
		}

		@Override
		public Getter reqGetSerialNumber() {
			byte epc = EPC_SERIAL_NUMBER;
			byte[] edt = _getSerialNumber(epc);
			addProperty(epc, edt, (edt != null && edt.length == 12));
			return this;
		}

		@Override
		public Getter reqGetDateOfManufacture() {
			byte epc = EPC_DATE_OF_MANUFACTURE;
			byte[] edt = _getDateOfManufacture(epc);
			addProperty(epc, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Getter reqGetStatusChangeAnnouncementPropertyMap() {
			byte epc = EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP;
			byte[] edt = _getStatusChangeAnnouncementPropertyMap(epc);
			addProperty(epc, edt, (edt != null && edt.length <= 17));
			return this;
		}

		@Override
		public Getter reqGetSetPropertyMap() {
			byte epc = EPC_SET_PROPERTY_MAP;
			byte[] edt = _getSetPropertyMap(epc);
			addProperty(epc, edt, (edt != null && edt.length <= 17));
			return this;
		}

		@Override
		public Getter reqGetGetPropertyMap() {
			byte epc = EPC_GET_PROPERTY_MAP;
			byte[] edt = _getGetPropertyMap(epc);
			addProperty(epc, edt, (edt != null && edt.length <= 17));
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
		/**
		 * Indicates an encountered abnormality (sensor trouble, etc.).<br>
		 * Fault encountered = 0x41, no fault encountered = 0x42<br><br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		public Informer reqInformFaultStatus();
		/**
		 * Stipulated in 3 bytes<br>
		 * (To be specified by ECHONET Consortium)<br><br>
		 * Data type : unsigned char×3<br>
		 * Data size : 3<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		public Informer reqInformManufacturerCode();
		/**
		 * Stipulated in 3-byte place-of-business code<br>
		 * (Specified individually by each char×3 manufacturer)<br><br>
		 * Data type : unsigned char×3<br>
		 * Data size : 3<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		public Informer reqInformPlaceOfBusinessCode();
		/**
		 * Specified in ASCII code<br>
		 * (Specified individually by each manufacturer)<br><br>
		 * Data type : unsigned char×12<br>
		 * Data size : 12<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		public Informer reqInformProductCode();
		/**
		 * Specified in ASCII code<br>
		 * (Specified individually by each manufacturer)<br><br>
		 * Data type : unsigned char×12<br>
		 * Data size : 12<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		public Informer reqInformSerialNumber();
		/**
		 * Stipulated in 4 bytes<br>
		 * YYMD (1 byte/character)<br>
		 * YY:Year (0x07CF for 1999)<br>M:Month (0x0C for 12)<br>
		 * D:Day (0x14 for 20)<br><br>
		 * Data type : unsigned char×4<br>
		 * Data size : 4<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		public Informer reqInformDateOfManufacture();
		/**
		 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
		 * Data type : unsigned char×(MAX17)<br>
		 * Data size : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Informer reqInformStatusChangeAnnouncementPropertyMap();
		/**
		 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
		 * Data type : unsigned char×(MAX17)<br>
		 * Data size : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Informer reqInformSetPropertyMap();
		/**
		 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
		 * Data type : unsigned char×(MAX17)<br>
		 * Data size : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Informer reqInformGetPropertyMap();
	}

	public class InformerImpl extends EchoObject.InformerImpl implements Informer {

		@Override
		public Informer reqInformFaultStatus() {
			byte epc = EPC_FAULT_STATUS;
			byte[] edt = _getFaultStatus(epc);
			addProperty(epc, edt, (edt != null && edt.length == 1));
			return this;
		}
		
		@Override
		public Informer reqInformManufacturerCode() {
			byte epc = EPC_MANUFACTURER_CODE;
			byte[] edt = _getManufacturerCode(epc);
			addProperty(epc, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Informer reqInformPlaceOfBusinessCode() {
			byte epc = EPC_PLACE_OF_BUSINESS_CODE;
			byte[] edt = _getPlaceOfBusinessCode(epc);
			addProperty(epc, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Informer reqInformProductCode() {
			byte epc = EPC_PRODUCT_CODE;
			byte[] edt = _getProductCode(epc);
			addProperty(epc, edt, (edt != null && edt.length == 12));
			return this;
		}

		@Override
		public Informer reqInformSerialNumber() {
			byte epc = EPC_SERIAL_NUMBER;
			byte[] edt = _getSerialNumber(epc);
			addProperty(epc, edt, (edt != null && edt.length == 12));
			return this;
		}

		@Override
		public Informer reqInformDateOfManufacture() {
			byte epc = EPC_DATE_OF_MANUFACTURE;
			byte[] edt = _getDateOfManufacture(epc);
			addProperty(epc, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Informer reqInformStatusChangeAnnouncementPropertyMap() {
			byte epc = EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP;
			byte[] edt = _getStatusChangeAnnouncementPropertyMap(epc);
			addProperty(epc, edt, (edt != null && edt.length <= 17));
			return this;
		}

		@Override
		public Informer reqInformSetPropertyMap() {
			byte epc = EPC_SET_PROPERTY_MAP;
			byte[] edt = _getSetPropertyMap(epc);
			addProperty(epc, edt, (edt != null && edt.length <= 17));
			return this;
		}

		@Override
		public Informer reqInformGetPropertyMap() {
			byte epc = EPC_GET_PROPERTY_MAP;
			byte[] edt = _getGetPropertyMap(epc);
			addProperty(epc, edt, (edt != null && edt.length <= 17));
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
