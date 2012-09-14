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
import com.sonycsl.echo.EchoUtils;
import com.sonycsl.echo.eoj.EchoObject;

public abstract class NodeProfile extends ProfileObject {
	
	protected static final byte EPC_POWER = (byte)0x80;
	protected static final byte EPC_VERSION = (byte)0x82;
	protected static final byte EPC_ID_NUMBER = (byte)0x83;
	protected static final byte EPC_ERROR_INFO = (byte)0x89;
	protected static final byte EPC_ID_INFO = (byte)0xBF;
	protected static final byte EPC_INSTANCE_LIST_SIZE = (byte)0xD3;
	protected static final byte EPC_CLASS_LIST_SIZE = (byte)0xD4;
	protected static final byte EPC_INSTANCE_LIST = (byte)0xD5;
	protected static final byte EPC_INSTANCE_LIST_S = (byte)0xD6;
	protected static final byte EPC_CLASS_LIST_S = (byte)0xD7; 

	@Override
	public byte getClassGroupCode() {
		return (byte)0x0E;
	}

	@Override
	public byte getClassCode() {
		return (byte)0xF0;
	}

	@Override
	public byte getInstanceCode() {
		return (byte)0x01;
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
	
	protected abstract byte[] getPower();
	
	/**
	 * プロパティ名称:Version情報
	 * EPC:0x82
	 * アクセスルール:Get(必須)
	 */ 
	protected abstract byte[] getVersion() ;
	
	/**
	 * プロパティ名称:識別番号
	 * EPC:0x83
	 * アクセスルール:Get(必須)
	 */
	protected abstract byte[] getIdNumber() ;
	
	/**
	 * プロパティ名称:異常内容
	 * EPC:0x89
	 * アクセスルール:Get
	 */
	protected byte[] getErrorInfo() {
		return null;
	}
	
	/**
	 * プロパティ名称:個体識別情報	
	 * EPC:0xBF
	 * アクセスルール:Set(必須)/Get(必須)
	 */
	protected abstract boolean setIdInfo(byte[] edt);
	
	protected abstract byte[] getIdInfo();
	
	/**
	 * プロパティ名称:自ノードインスタンス数
	 * EPC:0xD3
	 * アクセスルール:Get(必須)
	 */
	
	protected byte[] getInstanceListSize() {
		byte[] ret = new byte[3];
		int num = getNode().getDevices().length;
		// ビッグエンディアン??
		ret[2] = (byte)(num & 0xFF);
		ret[1] = (byte)((num >> 8) & 0xFF);
		ret[0] = (byte)((num >> 16) & 0xFF);
		return ret;
	}
	
	/**
	 * プロパティ名称:自ノードクラス数
	 * EPC:0xD4
	 * アクセスルール:Get(必須)
	 */
	
	protected abstract byte[] getClassListSize();
	
	/**
	 * プロパティ名称:インスタンスリスト通知
	 * EPC:0xD5
	 * アクセスルール:Anno(必須)
	 */
	protected byte[] getInstanceList() {
		return EchoUtils.devicesToByteArray(getNode().getDevices());
	}
	
	/**
	 * プロパティ名称:自ノードインスタンスリストS
	 * EPC:0xD6
	 * アクセスルール:Get(必須)
	 */
	protected byte[] getInstanceListS() {
		return getInstanceList();
	}
	
	
	
	/**
	 * プロパティ名称:自ノードクラスリストS
	 * EPC:0xD7
	 * アクセスルール:Get(必須)
	 */
	
	protected abstract byte[] getClassListS();

	@Override
	protected final void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_POWER:
			res.addProperty(epc, edt, setPower(edt));
			break;
		case EPC_ID_INFO:
			res.addProperty(epc, edt, setIdInfo(edt));
			break;
		}
	}

	@Override
	protected final void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_POWER:
			edt = getPower();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_VERSION:
			edt = getVersion();
			res.addProperty(epc, edt, (edt != null && edt.length == 4));
			break;
		case EPC_ID_NUMBER:
			edt = getIdNumber();
			res.addProperty(epc, edt, (edt != null && (edt.length == 9 || edt.length == 17)));
			break;
		case EPC_ERROR_INFO:
			edt = getErrorInfo();
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_ID_INFO:
			edt = getIdInfo();
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_INSTANCE_LIST_SIZE:
			edt = getInstanceListSize();
			res.addProperty(epc, edt, (edt != null && edt.length == 3));
			break;
		case EPC_CLASS_LIST_SIZE:
			edt = getClassListSize();
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_INSTANCE_LIST_S:
			edt = getInstanceListS();
			res.addProperty(epc, edt, (edt != null && edt.length <= 253));
			break;
		case EPC_CLASS_LIST_S:
			edt = getClassListS();
			res.addProperty(epc, edt, (edt != null && edt.length <= 253));
			break;
		}
	}

	@Override
	protected final void onReceiveInfReq(EchoFrame res, byte epc) {
		super.onReceiveInfReq(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_INSTANCE_LIST:
			edt = getInstanceList();
			res.addProperty(epc, edt, (edt != null && edt.length <= 253));
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

	@Override
	protected InformerC informC() {
		return new InformerCImpl();
	}


	public static class Receiver extends ProfileObject.Receiver {
		
		@Override
		protected final void onReceiveSetRes(EchoObject eoj, short tid, byte epc, byte pdc, byte[] edt) {
			super.onReceiveSetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_POWER:
				onSetPower(eoj, tid, (pdc != 0));
				break;
			case EPC_ID_INFO:
				onSetIdInfo(eoj, tid, (pdc != 0));
				break;
			}
		}

		@Override
		protected final void onReceiveGetRes(EchoObject eoj, short tid, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_POWER:
				onGetPower(eoj, tid, pdc, edt);
				break;
			case EPC_VERSION:
				onGetVersion(eoj, tid, pdc, edt);
				break;
			case EPC_ID_NUMBER:
				onGetIdNumber(eoj, tid, pdc, edt);
				break;
			case EPC_ERROR_INFO:
				onGetErrorInfo(eoj, tid, pdc, edt);
				break;
			case EPC_ID_INFO:
				onGetIdInfo(eoj, tid, pdc, edt);
				break;
			case EPC_INSTANCE_LIST_SIZE:
				onGetInstanceListSize(eoj, tid, pdc, edt);
				break;
			case EPC_CLASS_LIST_SIZE:
				onGetClassListSize(eoj, tid, pdc, edt);
				break;
			case EPC_INSTANCE_LIST:
				onGetInstanceList(eoj, tid, pdc, edt);
				break;
			case EPC_INSTANCE_LIST_S:
				onGetInstanceListS(eoj, tid, pdc, edt);
				break;
			case EPC_CLASS_LIST_S:
				onGetClassListS(eoj, tid, pdc, edt);
				break;
			}
		}

		@Override
		protected final void onReceiveInfC(EchoObject eoj, short tid, byte epc, byte pdc, byte[] edt) {
			super.onReceiveInfC(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_INSTANCE_LIST:
				onGetInstanceList(eoj, tid, pdc, edt);
				break;
			}
		}

		@Override
		protected final void onReceiveInfCRes(EchoObject eoj, short tid, byte epc, byte pdc,
				byte[] edt) {
			super.onReceiveInfCRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_INSTANCE_LIST:
				onInformInstanceList(eoj, tid);
				break;
			}
		}
		
		protected void onSetPower(EchoObject eoj, short tid, boolean success) {
			
		}
		
		protected void onGetPower(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onGetVersion(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onGetIdNumber(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onGetErrorInfo(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onSetIdInfo(EchoObject eoj, short tid, boolean success) {
			
		}

		protected void onGetIdInfo(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onGetInstanceListSize(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onGetClassListSize(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onGetInstanceList(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onInformInstanceList(EchoObject eoj, short tid) {
			
		}
		
		protected void onGetInstanceListS(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onGetClassListS(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}
		
	}
	
	public interface Setter extends ProfileObject.Setter {
		public Setter reqSetPower(byte[] edt);
		public Setter reqSetIdInfo(byte[] edt);
	}
	
	public class SetterImpl extends ProfileObject.SetterImpl implements Setter {

		public SetterImpl(byte esv) {
			super(esv);
		}

		@Override
		public Setter reqSetPower(byte[] edt) {
			addProperty(EPC_POWER, edt, setPower(edt));
			return this;
		}

		@Override
		public Setter reqSetIdInfo(byte[] edt) {
			addProperty(EPC_ID_INFO, edt, setIdInfo(edt));
			return this;
		}
	}
	
	public class SetterProxy extends ProfileObject.SetterProxy implements Setter {

		public SetterProxy(byte esv) {
			super(esv);
		}

		@Override
		public Setter reqSetPower(byte[] edt) {
			addProperty(EPC_POWER, edt, (edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetIdInfo(byte[] edt) {
			addProperty(EPC_ID_INFO, edt, (edt.length == 2));
			return this;
		}
		
	}
	
	public interface Getter extends ProfileObject.Getter {
		public Getter reqGetError();
		public Getter reqGetMakerCode();
		public Getter reqGetWorkplaceCode();
		public Getter reqGetProductCode();
		public Getter reqGetManufacturingNumber();
		public Getter reqGetDateOfManufacture();
		public Getter reqGetAnnoPropertyMap();
		public Getter reqGetSetPropertyMap();
		public Getter reqGetGetPropertyMap();
		
		public Getter reqGetPower();
		public Getter reqGetVersion();
		public Getter reqGetIdNumber();
		public Getter reqGetErrorInfo();
		public Getter reqGetIdInfo();
		public Getter reqGetInstanceListSize();
		public Getter reqGetClassListSize();
		public Getter reqGetInstanceListS();
		public Getter reqGetClassListS();
	}
	
	public class GetterImpl extends ProfileObject.GetterImpl implements Getter {
		@Override
		public Getter reqGetError() {
			return (Getter)super.reqGetError();
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
		public Getter reqGetPower() {
			byte[] edt = getPower();
			addProperty(EPC_POWER, edt, (edt != null && edt.length == 1));
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
			addProperty(EPC_ID_NUMBER, edt, (edt != null && (edt.length == 9 || edt.length == 11)));
			return this;
		}

		@Override
		public Getter reqGetErrorInfo() {
			byte[] edt = getErrorInfo();
			addProperty(EPC_ERROR_INFO, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Getter reqGetIdInfo() {
			byte[] edt = getIdInfo();
			addProperty(EPC_ID_INFO, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Getter reqGetInstanceListSize() {
			byte[] edt = getInstanceListSize();
			addProperty(EPC_INSTANCE_LIST_SIZE, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Getter reqGetClassListSize() {
			byte[] edt = getClassListSize();
			addProperty(EPC_CLASS_LIST_SIZE, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Getter reqGetInstanceListS() {
			byte[] edt = getInstanceListS();
			addProperty(EPC_INSTANCE_LIST_S, edt, (edt != null && edt.length <= 253));
			return this;
		}

		@Override
		public Getter reqGetClassListS() {
			byte[] edt = getClassListS();
			addProperty(EPC_CLASS_LIST_S, edt, (edt != null && edt.length <= 17));
			return this;
		}
		
	}

	public class GetterProxy extends ProfileObject.GetterProxy implements Getter {
		@Override
		public Getter reqGetError() {
			return (Getter)super.reqGetError();
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
		public Getter reqGetPower() {
			addProperty(EPC_POWER);
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
		public Getter reqGetErrorInfo() {
			addProperty(EPC_ERROR_INFO);
			return this;
		}

		@Override
		public Getter reqGetIdInfo() {
			addProperty(EPC_ID_INFO);
			return this;
		}

		@Override
		public Getter reqGetInstanceListSize() {
			addProperty(EPC_INSTANCE_LIST_SIZE);
			return this;
		}

		@Override
		public Getter reqGetClassListSize() {
			addProperty(EPC_CLASS_LIST_SIZE);
			return this;
		}

		@Override
		public Getter reqGetInstanceListS() {
			addProperty(EPC_INSTANCE_LIST_S);
			return this;
		}

		@Override
		public Getter reqGetClassListS() {
			addProperty(EPC_CLASS_LIST_S);
			return this;
		}
		
	}
	
	public interface Informer extends ProfileObject.Informer {
		public Informer reqInformError();
		public Informer reqInformMakerCode();
		public Informer reqInformWorkplaceCode();
		public Informer reqInformProductCode();
		public Informer reqInformManufacturingNumber();
		public Informer reqInformDateOfManufacture();
		public Informer reqInformAnnoPropertyMap();
		public Informer reqInformSetPropetyMap();
		public Informer reqInformGetPropetyMap();
		
		public Informer reqInformPower();
		public Informer reqInformVersion();
		public Informer reqInformIdNumber();
		public Informer reqInformErrorInfo();
		public Informer reqInformIdInfo();
		public Informer reqInformInstanceListSize();
		public Informer reqInformClassListSize();
		public Informer reqInformInstanceList();
		public Informer reqInformInstanceListS();
		public Informer reqInformClassListS();
	}
	
	public class InformerImpl extends ProfileObject.InformerImpl implements Informer {
		@Override
		public Informer reqInformError() {
			return (Informer)super.reqInformError();
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
		public Informer reqInformAnnoPropertyMap() {
			return (Informer)super.reqInformAnnoPropertyMap();
		}
		@Override
		public Informer reqInformSetPropetyMap() {
			return (Informer)super.reqInformSetPropetyMap();
		}
		@Override
		public Informer reqInformGetPropetyMap() {
			return (Informer)super.reqInformGetPropetyMap();
		}

		@Override
		public Informer reqInformPower() {
			byte[] edt = getPower();
			addProperty(EPC_POWER, edt, (edt != null && edt.length == 1));
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
			addProperty(EPC_ID_NUMBER, edt, (edt != null && (edt.length == 9 || edt.length == 11)));
			return this;
		}

		@Override
		public Informer reqInformErrorInfo() {
			byte[] edt = getErrorInfo();
			addProperty(EPC_ERROR_INFO, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformIdInfo() {
			byte[] edt = getIdInfo();
			addProperty(EPC_ID_INFO, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformInstanceListSize() {
			byte[] edt = getInstanceListSize();
			addProperty(EPC_INSTANCE_LIST_SIZE, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Informer reqInformClassListSize() {
			byte[] edt = getClassListSize();
			addProperty(EPC_CLASS_LIST_SIZE, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformInstanceList() {
			byte[] edt = getInstanceList();
			addProperty(EPC_INSTANCE_LIST, edt, (edt != null && edt.length <= 253));
			return this;
		}

		@Override
		public Informer reqInformInstanceListS() {
			byte[] edt = getInstanceListS();
			addProperty(EPC_INSTANCE_LIST_S, edt, (edt != null && edt.length <= 253));
			return this;
		}

		@Override
		public Informer reqInformClassListS() {
			byte[] edt = getClassListS();
			addProperty(EPC_CLASS_LIST_S, edt, (edt != null && edt.length <= 17));
			return this;
		}
		
	}
	
	public class InformerProxy extends ProfileObject.InformerProxy implements Informer {
		@Override
		public Informer reqInformError() {
			return (Informer)super.reqInformError();
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
		public Informer reqInformAnnoPropertyMap() {
			return (Informer)super.reqInformAnnoPropertyMap();
		}
		@Override
		public Informer reqInformSetPropetyMap() {
			return (Informer)super.reqInformSetPropetyMap();
		}
		@Override
		public Informer reqInformGetPropetyMap() {
			return (Informer)super.reqInformGetPropetyMap();
		}
		
		@Override
		public Informer reqInformPower() {
			addProperty(EPC_POWER);
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
		public Informer reqInformErrorInfo() {
			addProperty(EPC_ERROR_INFO);
			return this;
		}
		@Override
		public Informer reqInformIdInfo() {
			addProperty(EPC_ID_INFO);
			return this;
		}
		@Override
		public Informer reqInformInstanceListSize() {
			addProperty(EPC_INSTANCE_LIST_SIZE);
			return this;
		}
		@Override
		public Informer reqInformClassListSize() {
			addProperty(EPC_CLASS_LIST_SIZE);
			return this;
		}
		@Override
		public Informer reqInformInstanceList() {
			addProperty(EPC_INSTANCE_LIST);
			return this;
		}
		@Override
		public Informer reqInformInstanceListS() {
			addProperty(EPC_INSTANCE_LIST_S);
			return this;
		}
		@Override
		public Informer reqInformClassListS() {
			addProperty(EPC_CLASS_LIST_S);
			return this;
		}
	}
	

	public interface InformerC extends EchoObject.InformerC {
		public InformerC informInstanceList();
	}

	public class InformerCImpl extends ProfileObject.InformerCImpl implements InformerC {

		@Override
		public InformerC informInstanceList() {
			byte[] edt = getInstanceList();
			addProperty(EPC_INSTANCE_LIST, edt, (edt != null && edt.length <= 253));
			return this;
		}
		

	}
}
