/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2014 Sony Computer Science Laboratories, Inc.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sonycsl.echo.eoj.profile;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.EchoUtils;
import com.sonycsl.echo.eoj.EchoObject;

public abstract class ProfileObject extends EchoObject {

	public static final byte EPC_FAULT_STATUS = (byte)0x88;
	public static final byte EPC_MANUFACTURER_CODE = (byte)0x8A;
	public static final byte EPC_PLACE_OF_BUSINESS_CODE = (byte)0x8B;
	public static final byte EPC_PRODUCT_CODE =  (byte)0x8C;
	public static final byte EPC_SERIAL_NUMBER = (byte)0x8D;
	public static final byte EPC_DATE_OF_MANUFACTURE = (byte)0x8E;
	public static final byte EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP = (byte)0x9D;
	public static final byte EPC_SET_PROPERTY_MAP = (byte)0x9E;
	public static final byte EPC_GET_PROPERTY_MAP = (byte)0x9F;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();

		addGetProperty(EPC_MANUFACTURER_CODE);
		addGetProperty(EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP);
		addGetProperty(EPC_SET_PROPERTY_MAP);
		addGetProperty(EPC_GET_PROPERTY_MAP);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewProfileObject(this);
	}
	
	
	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_FAULT_STATUS : return getFaultStatus();
		case EPC_MANUFACTURER_CODE : return getManufacturerCode();
		case EPC_PLACE_OF_BUSINESS_CODE : return getPlaceOfBusinessCode();
		case EPC_PRODUCT_CODE : return getProductCode();
		case EPC_SERIAL_NUMBER : return getSerialNumber();
		case EPC_DATE_OF_MANUFACTURE : return getDateOfManufacture();
		case EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP : return getStatusChangeAnnouncementPropertyMap();
		case EPC_SET_PROPERTY_MAP : return getSetPropertyMap();
		case EPC_GET_PROPERTY_MAP : return getGetPropertyMap();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_FAULT_STATUS : return isValidFaultStatus(property.edt);
		case EPC_MANUFACTURER_CODE : return isValidManufacturerCode(property.edt);
		case EPC_PLACE_OF_BUSINESS_CODE : return isValidPlaceOfBusinessCode(property.edt);
		case EPC_PRODUCT_CODE : return isValidProductCode(property.edt);
		case EPC_SERIAL_NUMBER : return isValidSerialNumber(property.edt);
		case EPC_DATE_OF_MANUFACTURE : return isValidDateOfManufacture(property.edt);
		case EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP : return isValidStatusChangeAnnouncementPropertyMap(property.edt);
		case EPC_SET_PROPERTY_MAP : return isValidSetPropertyMap(property.edt);
		case EPC_GET_PROPERTY_MAP : return isValidGetPropertyMap(property.edt);
		default : return false;
		}
	}

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
	
	protected boolean isValidFaultStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
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

	protected boolean isValidManufacturerCode(byte[] edt) {
		if(edt == null || !(edt.length == 3)) return false;
		return true;
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
	
	protected boolean isValidPlaceOfBusinessCode(byte[] edt) {
		if(edt == null || !(edt.length == 3)) return false;
		return true;
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

	protected boolean isValidProductCode(byte[] edt) {
		if(edt == null || !(edt.length == 12)) return false;
		return true;
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

	protected boolean isValidSerialNumber(byte[] edt) {
		if(edt == null || !(edt.length == 12)) return false;
		return true;
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
	
	protected boolean isValidDateOfManufacture(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	
	/**
	 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
	 * Data type : unsigned char×(MAX17)<br>
	 * Data size : Max.17<br>
	 * Set : undefined<br>
	 * Get : mandatory
	 */
	protected byte[] getStatusChangeAnnouncementPropertyMap() {
		return EchoUtils.propertiesToPropertyMap(getStatusChangeAnnouncementProperties());
	}
	
	protected boolean isValidStatusChangeAnnouncementPropertyMap(byte[] edt) {
		if(edt == null || !(edt.length <= 17)) return false;
		return true;
	}
	
	/**
	 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
	 * Data type : unsigned char×(MAX17)<br>
	 * Data size : Max.17<br>
	 * Set : undefined<br>
	 * Get : mandatory
	 */
	protected byte[] getSetPropertyMap() {
		return EchoUtils.propertiesToPropertyMap(getSetProperties());
	}
	protected boolean isValidSetPropertyMap(byte[] edt) {
		if(edt == null || !(edt.length <= 17)) return false;
		return true;
	}

	/**
	 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
	 * Data type : unsigned char×(MAX17)<br>
	 * Data size : Max.17<br>
	 * Set : undefined<br>
	 * Get : mandatory
	 */
	protected byte[] getGetPropertyMap() {
		return EchoUtils.propertiesToPropertyMap(getGetProperties());
	}
	protected boolean isValidGetPropertyMap(byte[] edt) {
		if(edt == null || !(edt.length <= 17)) return false;
		return true;
	}
	

	@Override
	public Setter set() {
		return set(true);
	}

	@Override
	public Setter set(boolean responseRequired) {
		return new Setter(getEchoClassCode(), getInstanceCode()
				, getNode().getAddressStr(), responseRequired);
	}

	@Override
	public Getter get() {
		return new Getter(getEchoClassCode(), getInstanceCode()
				, getNode().getAddressStr());
	}

	@Override
	public Informer inform() {
		return inform(isSelfObject());
	}

	@Override
	protected Informer inform(boolean multicast) {
		String address;
		if(multicast) {
			address = EchoSocket.MULTICAST_ADDRESS;
		} else {
			address = getNode().getAddressStr();
		}
		return new Informer(getEchoClassCode(), getInstanceCode()
				, address, isSelfObject());
	}

	public static class Receiver extends EchoObject.Receiver {

		@Override
		protected boolean onSetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onSetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			//switch(property.epc) {
			//default :
			//	return false;
			//}
			return false;
		}

		@Override
		protected boolean onGetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onGetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_FAULT_STATUS:
				onGetFaultStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_MANUFACTURER_CODE:
				onGetManufacturerCode(eoj, tid, esv, property, success);
				return true;
			case EPC_PLACE_OF_BUSINESS_CODE:
				onGetPlaceOfBusinessCode(eoj, tid, esv, property, success);
				return true;
			case EPC_PRODUCT_CODE:
				onGetProductCode(eoj, tid, esv, property, success);
				return true;
			case EPC_SERIAL_NUMBER:
				onGetSerialNumber(eoj, tid, esv, property, success);
				return true;
			case EPC_DATE_OF_MANUFACTURE:
				onGetDateOfManufacture(eoj, tid, esv, property, success);
				return true;
			case EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP:
				onGetStatusChangeAnnouncementPropertyMap(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_PROPERTY_MAP:
				onGetSetPropertyMap(eoj, tid, esv, property, success);
				return true;
			case EPC_GET_PROPERTY_MAP:
				onGetGetPropertyMap(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		@Override
		protected boolean onInformProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property) {
			boolean ret = super.onInformProperty(eoj, tid, esv, property);
			if(ret) return true;
			
			//switch(property.epc) {
			//default :
			//	return false;
			//}
			return false;
		}
		
		/**
		 * Indicates an encountered abnormality (sensor trouble, etc.).<br>
		 * Fault encountered = 0x41, no fault encountered = 0x42<br><br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		protected void onGetFaultStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Stipulated in 3 bytes<br>
		 * (To be specified by ECHONET Consortium)<br><br>
		 * Data type : unsigned char×3<br>
		 * Data size : 3<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		protected void onGetManufacturerCode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Stipulated in 3-byte place-of-business code<br>
		 * (Specified individually by each char×3 manufacturer)<br><br>
		 * Data type : unsigned char×3<br>
		 * Data size : 3<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		protected void onGetPlaceOfBusinessCode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Specified in ASCII code<br>
		 * (Specified individually by each manufacturer)<br><br>
		 * Data type : unsigned char×12<br>
		 * Data size : 12<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		protected void onGetProductCode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Specified in ASCII code<br>
		 * (Specified individually by each manufacturer)<br><br>
		 * Data type : unsigned char×12<br>
		 * Data size : 12<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		protected void onGetSerialNumber(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		protected void onGetDateOfManufacture(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
		 * Data type : unsigned char×(MAX17)<br>
		 * Data size : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		protected void onGetStatusChangeAnnouncementPropertyMap(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {

		}
		/**
		 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
		 * Data type : unsigned char×(MAX17)<br>
		 * Data size : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		protected void onGetSetPropertyMap(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
			
		}
		/**
		 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
		 * Data type : unsigned char×(MAX17)<br>
		 * Data size : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		protected void onGetGetPropertyMap(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
			
		}
	}

	public static class Setter extends EchoObject.Setter {

		public Setter(short dstEchoClassCode, byte dstEchoInstanceCode
				, String dstEchoAddress, boolean responseRequired) {
			super(dstEchoClassCode, dstEchoInstanceCode
					, dstEchoAddress, responseRequired);
		}

		@Override
		public Setter reqSetProperty(byte epc,
				byte[] edt) {
			return (Setter)super.reqSetProperty(epc, edt);
		}
		
	}
	
	public static class Getter extends EchoObject.Getter {
		public Getter(short dstEchoClassCode, byte dstEchoInstanceCode
				, String dstEchoAddress) {
			super(dstEchoClassCode, dstEchoInstanceCode
					, dstEchoAddress);
		}

		@Override
		public Getter reqGetProperty(byte epc) {
			return (Getter)super.reqGetProperty(epc);
		}
		
		/**
		 * Indicates an encountered abnormality (sensor trouble, etc.).<br>
		 * Fault encountered = 0x41, no fault encountered = 0x42<br><br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		public Getter reqGetFaultStatus() {
			reqGetProperty(EPC_FAULT_STATUS);
			return this;
		}
		/**
		 * Stipulated in 3 bytes<br>
		 * (To be specified by ECHONET Consortium)<br><br>
		 * Data type : unsigned char×3<br>
		 * Data size : 3<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		public Getter reqGetManufacturerCode() {
			reqGetProperty(EPC_MANUFACTURER_CODE);
			return this;
		}
		/**
		 * Stipulated in 3-byte place-of-business code<br>
		 * (Specified individually by each char×3 manufacturer)<br><br>
		 * Data type : unsigned char×3<br>
		 * Data size : 3<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		public Getter reqGetPlaceOfBusinessCode() {
			reqGetProperty(EPC_PLACE_OF_BUSINESS_CODE);
			return this;
		}
		/**
		 * Specified in ASCII code<br>
		 * (Specified individually by each manufacturer)<br><br>
		 * Data type : unsigned char×12<br>
		 * Data size : 12<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		public Getter reqGetProductCode() {
			reqGetProperty(EPC_PRODUCT_CODE);
			return this;
		}
		/**
		 * Specified in ASCII code<br>
		 * (Specified individually by each manufacturer)<br><br>
		 * Data type : unsigned char×12<br>
		 * Data size : 12<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		public Getter reqGetSerialNumber() {
			reqGetProperty(EPC_SERIAL_NUMBER);
			return this;
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
		public Getter reqGetDateOfManufacture() {
			reqGetProperty(EPC_DATE_OF_MANUFACTURE);
			return this;
		}
		/**
		 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
		 * Data type : unsigned char×(MAX17)<br>
		 * Data size : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Getter reqGetStatusChangeAnnouncementPropertyMap() {
			reqGetProperty(EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP);
			return this;
		}
		/**
		 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
		 * Data type : unsigned char×(MAX17)<br>
		 * Data size : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Getter reqGetSetPropertyMap() {
			reqGetProperty(EPC_SET_PROPERTY_MAP);
			return this;
		}
		/**
		 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
		 * Data type : unsigned char×(MAX17)<br>
		 * Data size : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Getter reqGetGetPropertyMap() {
			reqGetProperty(EPC_GET_PROPERTY_MAP);
			return this;
		}
	}
	
	public static class Informer extends EchoObject.Informer {

		public Informer(short echoClassCode, byte echoInstanceCode
				, String dstEchoAddress, boolean isSelfObject) {
			super(echoClassCode, echoInstanceCode
					, dstEchoAddress, isSelfObject);
		}

		@Override
		public Informer reqInformProperty(byte epc) {
			return (Informer)super.reqInformProperty(epc);
		}
		
		/**
		 * Indicates an encountered abnormality (sensor trouble, etc.).<br>
		 * Fault encountered = 0x41, no fault encountered = 0x42<br><br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		public Informer reqInformFaultStatus() {
			reqInformProperty(EPC_FAULT_STATUS);
			return this;
		}
		/**
		 * Stipulated in 3 bytes<br>
		 * (To be specified by ECHONET Consortium)<br><br>
		 * Data type : unsigned char×3<br>
		 * Data size : 3<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		public Informer reqInformManufacturerCode() {
			reqInformProperty(EPC_MANUFACTURER_CODE);
			return this;
		}
		/**
		 * Stipulated in 3-byte place-of-business code<br>
		 * (Specified individually by each char×3 manufacturer)<br><br>
		 * Data type : unsigned char×3<br>
		 * Data size : 3<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		public Informer reqInformPlaceOfBusinessCode() {
			reqInformProperty(EPC_PLACE_OF_BUSINESS_CODE);
			return this;
		}
		/**
		 * Specified in ASCII code<br>
		 * (Specified individually by each manufacturer)<br><br>
		 * Data type : unsigned char×12<br>
		 * Data size : 12<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		public Informer reqInformProductCode() {
			reqInformProperty(EPC_PRODUCT_CODE);
			return this;
		}
		/**
		 * Specified in ASCII code<br>
		 * (Specified individually by each manufacturer)<br><br>
		 * Data type : unsigned char×12<br>
		 * Data size : 12<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		public Informer reqInformSerialNumber() {
			reqInformProperty(EPC_SERIAL_NUMBER);
			return this;
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
		public Informer reqInformDateOfManufacture() {
			reqInformProperty(EPC_DATE_OF_MANUFACTURE);
			return this;
		}
		/**
		 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
		 * Data type : unsigned char×(MAX17)<br>
		 * Data size : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Informer reqInformStatusChangeAnnouncementPropertyMap() {
			reqInformProperty(EPC_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_MAP);
			return this;
		}
		/**
		 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
		 * Data type : unsigned char×(MAX17)<br>
		 * Data size : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Informer reqInformSetPropertyMap() {
			reqInformProperty(EPC_SET_PROPERTY_MAP);
			return this;
		}
		/**
		 * See “ECHONET Device Objects: Detailed Specifications”.<br><br>
		 * Data type : unsigned char×(MAX17)<br>
		 * Data size : Max.17<br>
		 * Set : undefined<br>
		 * Get : mandatory
		 */
		public Informer reqInformGetPropertyMap() {
			reqInformProperty(EPC_GET_PROPERTY_MAP);
			return this;
		}
	}
}
