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
	@SuppressWarnings("unused")
	private static final String TAG = NodeProfile.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x0E;
	public static final byte CLASS_CODE = (byte)0xF0;
	public static final byte INSTANCE_CODE = (byte)0x01;
	
	protected static final byte EPC_OPERATING_STATUS = (byte)0x80;
	protected static final byte EPC_VERSION_INFORMATION = (byte)0x82;
	protected static final byte EPC_IDENTIFICATION_NUMBER = (byte)0x83;
	protected static final byte EPC_FAULT_CONTENT = (byte)0x89;
	protected static final byte EPC_UNIQUE_IDENTIFIER_DATA = (byte)0xBF;
	protected static final byte EPC_NUMBER_OF_SELF_NODE_INSTANCES = (byte)0xD3;
	protected static final byte EPC_NUMBER_OF_SELF_NODE_CLASSES = (byte)0xD4;
	protected static final byte EPC_INSTANCE_LIST_NOTIFICATION = (byte)0xD5;
	protected static final byte EPC_SELF_NODE_INSTANCE_LIST_S = (byte)0xD6;
	protected static final byte EPC_SELF_NODE_CLASS_LIST = (byte)0xD7; 

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	@Override
	public byte getInstanceCode() {
		return INSTANCE_CODE;
	}

	/**
	 * プロパティ名称:動作状態
	 * EPC:0x80
	 * アクセスルール:Set/Get(必須)
	 * 状態変化アナウンス必須
	 */
	protected boolean setOperatingStatus(byte[] edt) {
		return false;
	}
	
	protected abstract byte[] getOperatingStatus();
	
	/**
	 * プロパティ名称:Version情報
	 * EPC:0x82
	 * アクセスルール:Get(必須)
	 */ 
	protected abstract byte[] getVersionInformation() ;
	
	/**
	 * プロパティ名称:識別番号
	 * EPC:0x83
	 * アクセスルール:Get(必須)
	 */
	protected abstract byte[] getIdentificationNumber() ;
	
	/**
	 * プロパティ名称:異常内容
	 * EPC:0x89
	 * アクセスルール:Get
	 */
	protected byte[] getFaultContent() {
		return null;
	}
	
	/**
	 * プロパティ名称:個体識別情報	
	 * EPC:0xBF
	 * アクセスルール:Set(必須)/Get(必須)
	 */
	protected abstract boolean setUniqueIdentifierData(byte[] edt);
	
	protected abstract byte[] getUniqueIdentifierData();
	
	/**
	 * プロパティ名称:自ノードインスタンス数
	 * EPC:0xD3
	 * アクセスルール:Get(必須)
	 */
	
	protected byte[] getNumberOfSelfNodeInstances() {
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
	
	protected byte[] getNumberOfSelfNodeClasses() {
		return getNode().getNumberOfSelfNodeClasses();
	}
	
	/**
	 * プロパティ名称:インスタンスリスト通知
	 * EPC:0xD5
	 * アクセスルール:Anno(必須)
	 */
	protected byte[] getInstanceListNotification() {
		return EchoUtils.devicesToByteArray(getNode().getDevices());
	}
	
	/**
	 * プロパティ名称:自ノードインスタンスリストS
	 * EPC:0xD6
	 * アクセスルール:Get(必須)
	 */
	protected byte[] getSelfNodeInstanceListS() {
		return getInstanceListNotification();
	}
	
	
	
	/**
	 * プロパティ名称:自ノードクラスリストS
	 * EPC:0xD7
	 * アクセスルール:Get(必須)
	 */
	
	protected byte[] getSelfNodeClassList() {
		return getNode().getSelfNodeClassList();
	}

	@Override
	protected final void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_OPERATING_STATUS:
			res.addProperty(epc, edt, setOperatingStatus(edt));
			break;
		case EPC_UNIQUE_IDENTIFIER_DATA:
			res.addProperty(epc, edt, setUniqueIdentifierData(edt));
			break;
		}
	}

	@Override
	protected final void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_OPERATING_STATUS:
			edt = getOperatingStatus();
			res.addProperty(epc, edt, (edt != null && edt.length == 1));
			break;
		case EPC_VERSION_INFORMATION:
			edt = getVersionInformation();
			res.addProperty(epc, edt, (edt != null && edt.length == 4));
			break;
		case EPC_IDENTIFICATION_NUMBER:
			edt = getIdentificationNumber();
			res.addProperty(epc, edt, (edt != null && (edt.length == 9 || edt.length == 17)));
			break;
		case EPC_FAULT_CONTENT:
			edt = getFaultContent();
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_UNIQUE_IDENTIFIER_DATA:
			edt = getUniqueIdentifierData();
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_NUMBER_OF_SELF_NODE_INSTANCES:
			edt = getNumberOfSelfNodeInstances();
			res.addProperty(epc, edt, (edt != null && edt.length == 3));
			break;
		case EPC_NUMBER_OF_SELF_NODE_CLASSES:
			edt = getNumberOfSelfNodeClasses();
			res.addProperty(epc, edt, (edt != null && edt.length == 2));
			break;
		case EPC_SELF_NODE_INSTANCE_LIST_S:
			edt = getSelfNodeInstanceListS();
			res.addProperty(epc, edt, (edt != null && edt.length <= 253));
			break;
		case EPC_SELF_NODE_CLASS_LIST:
			edt = getSelfNodeClassList();
			res.addProperty(epc, edt, (edt != null && edt.length <= 253));
			break;
		}
	}

	@Override
	protected final void onReceiveInfReq(EchoFrame res, byte epc) {
		super.onReceiveInfReq(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_INSTANCE_LIST_NOTIFICATION:
			edt = getInstanceListNotification();
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
			case EPC_OPERATING_STATUS:
				onSetOperatingStatus(eoj, tid, (pdc != 0));
				break;
			case EPC_UNIQUE_IDENTIFIER_DATA:
				onSetUniqueIdentifierData(eoj, tid, (pdc != 0));
				break;
			}
		}

		@Override
		protected final void onReceiveGetRes(EchoObject eoj, short tid, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_OPERATING_STATUS:
				onGetOperatingStatus(eoj, tid, pdc, edt);
				break;
			case EPC_VERSION_INFORMATION:
				onGetVersionInformation(eoj, tid, pdc, edt);
				break;
			case EPC_IDENTIFICATION_NUMBER:
				onGetIdentificationNumber(eoj, tid, pdc, edt);
				break;
			case EPC_FAULT_CONTENT:
				onGetFaultContent(eoj, tid, pdc, edt);
				break;
			case EPC_UNIQUE_IDENTIFIER_DATA:
				onGetUniqueIdentifierData(eoj, tid, pdc, edt);
				break;
			case EPC_NUMBER_OF_SELF_NODE_INSTANCES:
				onGetNumberOfSelfNodeInstances(eoj, tid, pdc, edt);
				break;
			case EPC_NUMBER_OF_SELF_NODE_CLASSES:
				onGetNumberOfSelfNodeClasses(eoj, tid, pdc, edt);
				break;
			case EPC_INSTANCE_LIST_NOTIFICATION:
				onGetInstanceListNotification(eoj, tid, pdc, edt);
				break;
			case EPC_SELF_NODE_INSTANCE_LIST_S:
				onGetSelfNodeInstanceListS(eoj, tid, pdc, edt);
				break;
			case EPC_SELF_NODE_CLASS_LIST:
				onGetSelfNodeClassList(eoj, tid, pdc, edt);
				break;
			}
		}

		@Override
		protected final void onReceiveInfC(EchoObject eoj, short tid, byte epc, byte pdc, byte[] edt) {
			super.onReceiveInfC(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_INSTANCE_LIST_NOTIFICATION:
				onGetInstanceListNotification(eoj, tid, pdc, edt);
				break;
			}
		}

		@Override
		protected final void onReceiveInfCRes(EchoObject eoj, short tid, byte epc, byte pdc,
				byte[] edt) {
			super.onReceiveInfCRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_INSTANCE_LIST_NOTIFICATION:
				onInformInstanceListNotification(eoj, tid);
				break;
			}
		}
		
		protected void onSetOperatingStatus(EchoObject eoj, short tid, boolean success) {
			
		}
		
		protected void onGetOperatingStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onGetVersionInformation(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onGetIdentificationNumber(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onGetFaultContent(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onSetUniqueIdentifierData(EchoObject eoj, short tid, boolean success) {
			
		}

		protected void onGetUniqueIdentifierData(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onGetNumberOfSelfNodeInstances(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onGetNumberOfSelfNodeClasses(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onGetInstanceListNotification(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onInformInstanceListNotification(EchoObject eoj, short tid) {
			
		}
		
		protected void onGetSelfNodeInstanceListS(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}

		protected void onGetSelfNodeClassList(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			
		}
		
	}
	
	public interface Setter extends ProfileObject.Setter {
		public Setter reqSetOperatingStatus(byte[] edt);
		public Setter reqSetUniqueIdentifierData(byte[] edt);
	}
	
	public class SetterImpl extends ProfileObject.SetterImpl implements Setter {

		public SetterImpl(byte esv) {
			super(esv);
		}

		@Override
		public Setter reqSetOperatingStatus(byte[] edt) {
			addProperty(EPC_OPERATING_STATUS, edt, setOperatingStatus(edt));
			return this;
		}

		@Override
		public Setter reqSetUniqueIdentifierData(byte[] edt) {
			addProperty(EPC_UNIQUE_IDENTIFIER_DATA, edt, setUniqueIdentifierData(edt));
			return this;
		}
	}
	
	public class SetterProxy extends ProfileObject.SetterProxy implements Setter {

		public SetterProxy(byte esv) {
			super(esv);
		}

		@Override
		public Setter reqSetOperatingStatus(byte[] edt) {
			addProperty(EPC_OPERATING_STATUS, edt, (edt.length == 1));
			return this;
		}

		@Override
		public Setter reqSetUniqueIdentifierData(byte[] edt) {
			addProperty(EPC_UNIQUE_IDENTIFIER_DATA, edt, (edt.length == 2));
			return this;
		}
		
	}
	
	public interface Getter extends ProfileObject.Getter {
		public Getter reqGetFaultStatus();
		public Getter reqGetManufacturerCode();
		public Getter reqGetPlaceOfBusinessCode();
		public Getter reqGetProductCode();
		public Getter reqGetSerialNumber();
		public Getter reqGetDateOfManufacture();
		public Getter reqGetStatusChangeAnnouncementPropertyMap();
		public Getter reqGetSetPropertyMap();
		public Getter reqGetGetPropertyMap();
		
		public Getter reqGetOperatingStatus();
		public Getter reqGetVersionInformation();
		public Getter reqGetIdentificationNumber();
		public Getter reqGetFaultContent();
		public Getter reqGetUniqueIdentifierData();
		public Getter reqGetNumberOfSelfNodeInstances();
		public Getter reqGetNumberOfSelfNodeClasses();
		public Getter reqGetSelfNodeInstanceListS();
		public Getter reqGetSelfNodeClassList();
	}
	
	public class GetterImpl extends ProfileObject.GetterImpl implements Getter {
		@Override
		public Getter reqGetFaultStatus() {
			return (Getter)super.reqGetFaultStatus();
		}
		@Override
		public Getter reqGetManufacturerCode() {
			return (Getter)super.reqGetManufacturerCode();
		}
		@Override
		public Getter reqGetPlaceOfBusinessCode() {
			return (Getter)super.reqGetPlaceOfBusinessCode();
		}
		@Override
		public Getter reqGetProductCode() {
			return (Getter)super.reqGetProductCode();
		}
		@Override
		public Getter reqGetSerialNumber() {
			return (Getter)super.reqGetSerialNumber();
		}
		@Override
		public Getter reqGetDateOfManufacture() {
			return (Getter)super.reqGetDateOfManufacture();
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
		public Getter reqGetOperatingStatus() {
			byte[] edt = getOperatingStatus();
			addProperty(EPC_OPERATING_STATUS, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Getter reqGetVersionInformation() {
			byte[] edt = getVersionInformation();
			addProperty(EPC_VERSION_INFORMATION, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Getter reqGetIdentificationNumber() {
			byte[] edt = getIdentificationNumber();
			addProperty(EPC_IDENTIFICATION_NUMBER, edt, (edt != null && (edt.length == 9 || edt.length == 11)));
			return this;
		}

		@Override
		public Getter reqGetFaultContent() {
			byte[] edt = getFaultContent();
			addProperty(EPC_FAULT_CONTENT, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Getter reqGetUniqueIdentifierData() {
			byte[] edt = getUniqueIdentifierData();
			addProperty(EPC_UNIQUE_IDENTIFIER_DATA, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Getter reqGetNumberOfSelfNodeInstances() {
			byte[] edt = getNumberOfSelfNodeInstances();
			addProperty(EPC_NUMBER_OF_SELF_NODE_INSTANCES, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Getter reqGetNumberOfSelfNodeClasses() {
			byte[] edt = getNumberOfSelfNodeClasses();
			addProperty(EPC_NUMBER_OF_SELF_NODE_CLASSES, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Getter reqGetSelfNodeInstanceListS() {
			byte[] edt = getSelfNodeInstanceListS();
			addProperty(EPC_SELF_NODE_INSTANCE_LIST_S, edt, (edt != null && edt.length <= 253));
			return this;
		}

		@Override
		public Getter reqGetSelfNodeClassList() {
			byte[] edt = getSelfNodeClassList();
			addProperty(EPC_SELF_NODE_CLASS_LIST, edt, (edt != null && edt.length <= 17));
			return this;
		}
		
	}

	public class GetterProxy extends ProfileObject.GetterProxy implements Getter {
		@Override
		public Getter reqGetFaultStatus() {
			return (Getter)super.reqGetFaultStatus();
		}
		@Override
		public Getter reqGetManufacturerCode() {
			return (Getter)super.reqGetManufacturerCode();
		}
		@Override
		public Getter reqGetPlaceOfBusinessCode() {
			return (Getter)super.reqGetPlaceOfBusinessCode();
		}
		@Override
		public Getter reqGetProductCode() {
			return (Getter)super.reqGetProductCode();
		}
		@Override
		public Getter reqGetSerialNumber() {
			return (Getter)super.reqGetSerialNumber();
		}
		@Override
		public Getter reqGetDateOfManufacture() {
			return (Getter)super.reqGetDateOfManufacture();
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
		public Getter reqGetOperatingStatus() {
			addProperty(EPC_OPERATING_STATUS);
			return this;
		}

		@Override
		public Getter reqGetVersionInformation() {
			addProperty(EPC_VERSION_INFORMATION);
			return this;
		}

		@Override
		public Getter reqGetIdentificationNumber() {
			addProperty(EPC_IDENTIFICATION_NUMBER);
			return this;
		}

		@Override
		public Getter reqGetFaultContent() {
			addProperty(EPC_FAULT_CONTENT);
			return this;
		}

		@Override
		public Getter reqGetUniqueIdentifierData() {
			addProperty(EPC_UNIQUE_IDENTIFIER_DATA);
			return this;
		}

		@Override
		public Getter reqGetNumberOfSelfNodeInstances() {
			addProperty(EPC_NUMBER_OF_SELF_NODE_INSTANCES);
			return this;
		}

		@Override
		public Getter reqGetNumberOfSelfNodeClasses() {
			addProperty(EPC_NUMBER_OF_SELF_NODE_CLASSES);
			return this;
		}

		@Override
		public Getter reqGetSelfNodeInstanceListS() {
			addProperty(EPC_SELF_NODE_INSTANCE_LIST_S);
			return this;
		}

		@Override
		public Getter reqGetSelfNodeClassList() {
			addProperty(EPC_SELF_NODE_CLASS_LIST);
			return this;
		}
		
	}
	
	public interface Informer extends ProfileObject.Informer {
		public Informer reqInformFaultStatus();
		public Informer reqInformManufacturerCode();
		public Informer reqInformPlaceOfBusinessCode();
		public Informer reqInformProductCode();
		public Informer reqInformSerialNumber();
		public Informer reqInformDateOfManufacture();
		public Informer reqInformStatusChangeAnnouncementPropertyMap();
		public Informer reqInformSetPropetyMap();
		public Informer reqInformGetPropetyMap();
		
		public Informer reqInformOperatingStatus();
		public Informer reqInformVersionInformation();
		public Informer reqInformIdentificationNumber();
		public Informer reqInformFaultContent();
		public Informer reqInformUniqueIdentifierData();
		public Informer reqInformNumberOfSelfNodeInstances();
		public Informer reqInformNumberOfSelfNodeClasses();
		public Informer reqInformInstanceListNotification();
		public Informer reqInformSelfNodeInstanceListS();
		public Informer reqInformSelfNodeClassList();
	}
	
	public class InformerImpl extends ProfileObject.InformerImpl implements Informer {
		@Override
		public Informer reqInformFaultStatus() {
			return (Informer)super.reqInformFaultStatus();
		}
		@Override
		public Informer reqInformManufacturerCode() {
			return (Informer)super.reqInformManufacturerCode();
		}
		@Override
		public Informer reqInformPlaceOfBusinessCode() {
			return (Informer)super.reqInformPlaceOfBusinessCode();
		}
		@Override
		public Informer reqInformProductCode() {
			return (Informer)super.reqInformProductCode();
		}
		@Override
		public Informer reqInformSerialNumber() {
			return (Informer)super.reqInformSerialNumber();
		}
		@Override
		public Informer reqInformDateOfManufacture() {
			return (Informer)super.reqInformDateOfManufacture();
		}
		@Override
		public Informer reqInformStatusChangeAnnouncementPropertyMap() {
			return (Informer)super.reqInformStatusChangeAnnouncementPropertyMap();
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
		public Informer reqInformOperatingStatus() {
			byte[] edt = getOperatingStatus();
			addProperty(EPC_OPERATING_STATUS, edt, (edt != null && edt.length == 1));
			return this;
		}

		@Override
		public Informer reqInformVersionInformation() {
			byte[] edt = getVersionInformation();
			addProperty(EPC_VERSION_INFORMATION, edt, (edt != null && edt.length == 4));
			return this;
		}

		@Override
		public Informer reqInformIdentificationNumber() {
			byte[] edt = getIdentificationNumber();
			addProperty(EPC_IDENTIFICATION_NUMBER, edt, (edt != null && (edt.length == 9 || edt.length == 11)));
			return this;
		}

		@Override
		public Informer reqInformFaultContent() {
			byte[] edt = getFaultContent();
			addProperty(EPC_FAULT_CONTENT, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformUniqueIdentifierData() {
			byte[] edt = getUniqueIdentifierData();
			addProperty(EPC_UNIQUE_IDENTIFIER_DATA, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformNumberOfSelfNodeInstances() {
			byte[] edt = getNumberOfSelfNodeInstances();
			addProperty(EPC_NUMBER_OF_SELF_NODE_INSTANCES, edt, (edt != null && edt.length == 3));
			return this;
		}

		@Override
		public Informer reqInformNumberOfSelfNodeClasses() {
			byte[] edt = getNumberOfSelfNodeClasses();
			addProperty(EPC_NUMBER_OF_SELF_NODE_CLASSES, edt, (edt != null && edt.length == 2));
			return this;
		}

		@Override
		public Informer reqInformInstanceListNotification() {
			byte[] edt = getInstanceListNotification();
			addProperty(EPC_INSTANCE_LIST_NOTIFICATION, edt, (edt != null && edt.length <= 253));
			return this;
		}

		@Override
		public Informer reqInformSelfNodeInstanceListS() {
			byte[] edt = getSelfNodeInstanceListS();
			addProperty(EPC_SELF_NODE_INSTANCE_LIST_S, edt, (edt != null && edt.length <= 253));
			return this;
		}

		@Override
		public Informer reqInformSelfNodeClassList() {
			byte[] edt = getSelfNodeClassList();
			addProperty(EPC_SELF_NODE_CLASS_LIST, edt, (edt != null && edt.length <= 17));
			return this;
		}
		
	}
	
	public class InformerProxy extends ProfileObject.InformerProxy implements Informer {
		@Override
		public Informer reqInformFaultStatus() {
			return (Informer)super.reqInformFaultStatus();
		}
		@Override
		public Informer reqInformManufacturerCode() {
			return (Informer)super.reqInformManufacturerCode();
		}
		@Override
		public Informer reqInformPlaceOfBusinessCode() {
			return (Informer)super.reqInformPlaceOfBusinessCode();
		}
		@Override
		public Informer reqInformProductCode() {
			return (Informer)super.reqInformProductCode();
		}
		@Override
		public Informer reqInformSerialNumber() {
			return (Informer)super.reqInformSerialNumber();
		}
		@Override
		public Informer reqInformDateOfManufacture() {
			return (Informer)super.reqInformDateOfManufacture();
		}
		@Override
		public Informer reqInformStatusChangeAnnouncementPropertyMap() {
			return (Informer)super.reqInformStatusChangeAnnouncementPropertyMap();
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
		public Informer reqInformOperatingStatus() {
			addProperty(EPC_OPERATING_STATUS);
			return this;
		}
		@Override
		public Informer reqInformVersionInformation() {
			addProperty(EPC_VERSION_INFORMATION);
			return this;
		}
		@Override
		public Informer reqInformIdentificationNumber() {
			addProperty(EPC_IDENTIFICATION_NUMBER);
			return this;
		}
		@Override
		public Informer reqInformFaultContent() {
			addProperty(EPC_FAULT_CONTENT);
			return this;
		}
		@Override
		public Informer reqInformUniqueIdentifierData() {
			addProperty(EPC_UNIQUE_IDENTIFIER_DATA);
			return this;
		}
		@Override
		public Informer reqInformNumberOfSelfNodeInstances() {
			addProperty(EPC_NUMBER_OF_SELF_NODE_INSTANCES);
			return this;
		}
		@Override
		public Informer reqInformNumberOfSelfNodeClasses() {
			addProperty(EPC_NUMBER_OF_SELF_NODE_CLASSES);
			return this;
		}
		@Override
		public Informer reqInformInstanceListNotification() {
			addProperty(EPC_INSTANCE_LIST_NOTIFICATION);
			return this;
		}
		@Override
		public Informer reqInformSelfNodeInstanceListS() {
			addProperty(EPC_SELF_NODE_INSTANCE_LIST_S);
			return this;
		}
		@Override
		public Informer reqInformSelfNodeClassList() {
			addProperty(EPC_SELF_NODE_CLASS_LIST);
			return this;
		}
	}
	

	public interface InformerC extends EchoObject.InformerC {
		public InformerC informInstanceListNotification();
	}

	public class InformerCImpl extends ProfileObject.InformerCImpl implements InformerC {

		@Override
		public InformerC informInstanceListNotification() {
			byte[] edt = getInstanceListNotification();
			addProperty(EPC_INSTANCE_LIST_NOTIFICATION, edt, (edt != null && edt.length <= 253));
			return this;
		}
		

	}
}
