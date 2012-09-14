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
package com.sonycsl.echo;

import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.eoj.device.airconditioner.proxy.AirConditionerProxy;
import com.sonycsl.echo.eoj.device.house.proxy.PanelBoardsMeterProxy;
import com.sonycsl.echo.eoj.profile.NodeProfile;
import com.sonycsl.echo.eoj.profile.ProfileObject;
import com.sonycsl.echo.eoj.profile.proxy.NodeProfileProxy;
import com.sonycsl.echo.node.EchoNode;



public final class Echo {
	@SuppressWarnings("unused")
	private static final String TAG = Echo.class.getSimpleName();
	private static Echo self = null;
	
	private EchoNode mNode;
	private Map<InetAddress, EchoNode> mNodeProxies;
	
	private ProxyListener mProxyListener = null;
	
	private boolean mTracing = false;
	
	private Echo() {
		mNodeProxies = new HashMap<InetAddress, EchoNode>();
	}
	
	public static Echo getEcho() {
		if(self == null) {
			self = new Echo();
		}
		return self;
	}
	
	public EchoNode start(NodeProfile profile, DeviceObject[] devices) throws IOException {
		
		EchoSocket.getSocket().start();
		mNode = new EchoNode(profile, devices);
		mNode.getProfile().inform().reqInformInstanceList().sendGroup();
		return mNode;
	}
	
	public void stop() throws IOException {
		mProxyListener = null;
		EchoSocket.getSocket().stop();
		mNodeProxies.clear();
	}
	
	public void setProxyListener(ProxyListener listener) {
		mProxyListener = listener;
	}
	
	public void removeNodeProxy(EchoNode node) {
		mNodeProxies.remove(node.getAddress());
	}
	
	public void removeAllNodeProxies() {
		mNodeProxies.clear();
	}
	
	public EchoNode getNode() {
		return mNode;
	}
	
	public EchoNode[] getNodeProxies() {
		return (EchoNode[]) mNodeProxies.values().toArray(new EchoNode[]{});
	}
	
	public void refreshProxy(InetAddress address, byte[] instanceList) {
		if(mNode.getAddress().equals(address)) {
			return;
		}
		int size = instanceList[0] & 0xFF;
		if(size > 84) {
			size = 84;
		} else if(mNodeProxies.containsKey(address)) {
			EchoNode node = mNodeProxies.get(address);
			DeviceObject[] devices = node.getDevices();
			for(DeviceObject device : devices) {
				int i = 0;
				for(; i < size; i++) {
					if(device.getClassGroupCode() == instanceList[i*3+1] &&
							device.getClassCode() == instanceList[i*3+2] &&
							device.getInstanceCode() == instanceList[i*3+3]) {
						break;
					}
				}
				if(i == size) {
					mNode.removeDevice(device);
				}
			}
		}
		for(int i = 0; i < size; i++) {
			putProxy(address, instanceList[i*3+1], instanceList[i*3+2], instanceList[i*3+3]);
		}
		
		
		
	}
	
	public void putProxy(InetAddress address, byte classGroupCode, byte classCode, byte instanceCode) {

		if(mNode.getAddress().equals(address)) {
			return;
		}
		EchoNode node;
		if(mNodeProxies.containsKey(address)) {
			node = mNodeProxies.get(address);
		} else {
			NodeProfileProxy profile = new NodeProfileProxy();
			node = new EchoNode(address, profile, new DeviceObject[0]);
			mNodeProxies.put(address, node);
			if(mProxyListener != null) {
				mProxyListener.onNewNode(node);
				mProxyListener.onNewProfileObject(profile);
				mProxyListener.onNewNodeProfile(profile);
			}
		}
		if(!node.existsInstance(classGroupCode, classCode, instanceCode)) {
			createDeviceProxy(node, classGroupCode, classCode, instanceCode);
		}
	}
	
	public EchoObject getInstance(InetAddress address, byte classGroupCode, byte classCode, byte instanceCode) {

		if(mNode.getAddress().equals(address)) {
			return mNode.getInstance(classGroupCode, classCode, instanceCode);
		} else {
			if(mNodeProxies.containsKey(address)) {
				EchoNode node = mNodeProxies.get(address);
				if(node.existsInstance(classGroupCode, classCode, instanceCode)) {
					return node.getInstance(classGroupCode, classCode, instanceCode);
				} else {
					return null;
				}
			} else {
				return null;
			}
		}
	}
	

	private void createDeviceProxy(EchoNode node, byte classGroupCode, byte classCode, byte instanceCode) {
		
		DeviceObject device;
		if(classGroupCode == 0x1) {
			// AirConditioner
			switch(classCode) {
			case AirConditionerProxy.CLASS_CODE:
				device = new AirConditionerProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewAirConditioner((AirConditionerProxy)device);
				}
				break;
			}
		} else if(classGroupCode == 0x02) {
			// House
			switch(classCode) {
			case PanelBoardsMeterProxy.CLASS_CODE:
				device = new PanelBoardsMeterProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewPanelBoardsMeter((PanelBoardsMeterProxy)device);
				}
				break;
			}
		}
	}
	
	public void trace(boolean t) {
		mTracing = t;
	}
	
	public boolean isTracing() {
		return mTracing;
	}
	
	public static abstract class  ProxyListener {
		public void onNewNode(EchoNode node) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewNode[address:"+node.getAddress().getHostAddress()+"]");
			}
		}
		
		public void onNewProfileObject(ProfileObject profile) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewProfileObject[address:"+profile.getNode().getAddress().getHostAddress()+"]");
			}
		}
		
		public void onNewNodeProfile(NodeProfileProxy profile) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewNodeProfile[address:"+profile.getNode().getAddress().getHostAddress()+"]");
			}
		}
		
		public void onNewDevice(DeviceObject device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewDevice[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
			
		}

		public void onNewPanelBoardsMeter(PanelBoardsMeterProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewPanelBoardsMeter[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}
		
		public void onNewAirConditioner(AirConditionerProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewAirConditioner[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
			
		}
	}
}
