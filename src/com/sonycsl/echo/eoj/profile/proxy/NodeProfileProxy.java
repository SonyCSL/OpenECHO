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
package com.sonycsl.echo.eoj.profile.proxy;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.profile.NodeProfile;

public class NodeProfileProxy extends NodeProfile {

	public NodeProfileProxy() {
		setReceiver(new Receiver());
	}
	
	@Override
	public byte[] getPower() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getIdNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected byte[] getIdInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean setIdInfo(byte[] args) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected byte[] getInstanceListSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected byte[] getClassListSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected byte[] getClassListS() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected byte[] getMakerCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected byte[] getAnnoPropertyMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected byte[] getSetPropertyMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected byte[] getGetPropertyMap() {
		// TODO Auto-generated method stub
		return null;
	}

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
	

	public static class Receiver extends NodeProfile.Receiver {

		@Override
		protected void onGetInstanceList(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			super.onGetInstanceList(eoj, tid, pdc, edt);
			if(pdc > 0)
				putDevices(eoj, edt);
		}

		@Override
		protected void onGetInstanceListS(EchoObject eoj, short tid, byte pdc, byte[] edt) {
			super.onGetInstanceListS(eoj, tid, pdc, edt);
			if(pdc > 0)
				putDevices(eoj, edt);
		}
		
		protected void putDevices(EchoObject eoj, byte[] edt) {
			Echo.getEcho().refreshProxy(eoj.getNode().getAddress(), edt);
		}
		
	}
}
