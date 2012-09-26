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
package com.sonycsl.echo.eoj.device.audiovisual.proxy;

import com.sonycsl.echo.eoj.device.audiovisual.Display;

public class DisplayProxy extends Display {
	@SuppressWarnings("unused")
	private static final String TAG = DisplayProxy.class.getSimpleName();

	private byte mInstanceCode;
	
	public DisplayProxy(byte instanceCode) {
		mInstanceCode = instanceCode;
	}
	
	@Override
	public byte getInstanceCode() {
		return mInstanceCode;
	}
	
	@Override
	protected byte[] getPower() {return null;}
	@Override
	protected boolean setInstallationLocation(byte[] arg) {return false;}
	@Override
	protected byte[] getInstallationLocation() {return null;}
	@Override
	protected byte[] getVersion() {return null;}
	@Override
	protected byte[] getError() {return null;}
	@Override
	protected byte[] getMakerCode() {return null;}
	@Override
	protected byte[] getAnnoPropertyMap() {return null;}
	@Override
	protected byte[] getSetPropertyMap() {return null;}
	@Override
	protected byte[] getGetPropertyMap() {return null;}
	
	@Override
	protected byte[] getCharacterStringSettingAcceptanceStatus() {return null;}
	@Override
	protected byte[] getSupportedCharacterCodes() {return null;}
	@Override
	protected boolean setCharacterStringToPresentToTheUser(byte[] edt) {return false;}
	@Override
	protected byte[] getLengthOfCharacterStringAccepted() {return null;}

	@Override
	public Setter set() {
		return new SetterProxy(ESV_SETI);
	}

	@Override
	public Setter setC() {
		return new SetterProxy(ESV_SETC);
	}

	@Override
	public Getter get() {
		return new GetterProxy();
	}

	@Override
	public Informer inform() {
		return new InformerProxy();
	}
	
}
