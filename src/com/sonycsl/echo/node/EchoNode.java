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
package com.sonycsl.echo.node;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sonycsl.echo.EchoUtils;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.eoj.profile.NodeProfile;


public class EchoNode {
	private NodeProfile mNodeProfile;
	private Map<Short, List<DeviceObject>> mDeviceGroups;
	private InetAddress mAddress;
	
	
	/**
	 * 自ipアドレスを取得
	 * @throws UnknownHostException 
	 * @throws SocketException 
	 * @throws IOException 
	 */
	public EchoNode(NodeProfile profile, DeviceObject[] devices) throws IOException {
		this(EchoUtils.getLocalIpAddress(), profile, devices);
	}

	public EchoNode(InetAddress address, NodeProfile profile, DeviceObject[] devices) { 
		//System.out.println("EchoNode:address["+address.getHostAddress()+"]");

		mAddress = address;
		mNodeProfile = profile;
		
		mDeviceGroups = new HashMap<Short, List<DeviceObject>>();
		
		mNodeProfile.setNode(this);
		addDevices(devices);
	}
	
	public NodeProfile getProfile() {
		return mNodeProfile;
	}
	
	public void addDevices(DeviceObject[] devices) {
		if(devices == null) return;
		for(DeviceObject dev : devices) {
			addDevice(dev);
		}
	}
	
	public void addDevice(DeviceObject device) {
		if(device.getNode() == null) {
			short code = device.getObjectClassCode();
			if(mDeviceGroups.containsKey(code)) {
				List<DeviceObject> deviceList = mDeviceGroups.get(code);
				if(deviceList.size() > 0x7F) return;
				deviceList.add(device);
			} else {
				List<DeviceObject> deviceList = new ArrayList<DeviceObject>();
				deviceList.add(device);
				mDeviceGroups.put(code, deviceList);
			}

			device.setNode(this);
		}
	}
	
	public void removeDevice(DeviceObject device) {
		List<DeviceObject> deviceList = mDeviceGroups.get(device.getObjectClassCode());
		deviceList.set(deviceList.indexOf(device), null);
	}
	
	public boolean existsInstance(byte classGroupCode, byte classCode, byte instanceCode) {
		if(mNodeProfile.getClassGroupCode() == classGroupCode &&
				mNodeProfile.getClassCode() == classCode &&
				mNodeProfile.getInstanceCode() == instanceCode) {
			return true;
		}
		short code = EchoUtils.getObjectClassCode(classGroupCode, classCode);
		if(!mDeviceGroups.containsKey(code))
			return false;
		List<DeviceObject> devices = mDeviceGroups.get(code);
		for(DeviceObject dev : devices) {
			if(dev != null && dev.getInstanceCode() == instanceCode) {
				return true;
			}
		}
		return false;
	}

	public boolean existsInstance(EchoObject eoj) {
		return existsInstance(eoj.getClassGroupCode(), eoj.getClassCode(), eoj.getInstanceCode());
	}
	
	public EchoObject getInstance(byte classGroupCode, byte classCode, byte instanceCode) { 
		if(mNodeProfile.getClassGroupCode() == classGroupCode &&
				mNodeProfile.getClassCode() == classCode &&
				mNodeProfile.getInstanceCode() == instanceCode) {
			return mNodeProfile;
		}
		return getDevice(classGroupCode, classCode, instanceCode);
	}
	
	public DeviceObject getDevice(byte classGroupCode, byte classCode, byte instanceCode) {
		short code = EchoUtils.getObjectClassCode(classGroupCode, classCode);
		if(!mDeviceGroups.containsKey(code))
			return null;
		List<DeviceObject> devices = mDeviceGroups.get(code);
		for(DeviceObject dev : devices) {
			if(dev != null && dev.getInstanceCode() == instanceCode) {
				return dev;
			}
		}
		return null;
	}
	
	public DeviceObject[] getDevices(byte classGroupCode, byte classCode) {
		short code = EchoUtils.getObjectClassCode(classGroupCode, classCode);
		if(!mDeviceGroups.containsKey(code))
			return null;
		List<DeviceObject> deviceList = new ArrayList<DeviceObject>(mDeviceGroups.get(code));
		deviceList.remove(null);
		return deviceList.toArray(new DeviceObject[]{});
	}
	
	public DeviceObject[] getDevices() {
		ArrayList<DeviceObject> list = new ArrayList<DeviceObject>();
		for(List<DeviceObject> devices : mDeviceGroups.values()) {
			List<DeviceObject> deviceList = new ArrayList<DeviceObject>(devices);
			deviceList.remove(null);
			list.addAll(deviceList);
		}
		return (DeviceObject[]) list.toArray(new DeviceObject[]{});
	}

	public byte getDeviceNumber(DeviceObject device) {
		List<DeviceObject> list = mDeviceGroups.get(device.getObjectClassCode());
		return (byte) ((list.indexOf(device) + 1) & 0xFF);
	}
	
	public byte[] getNumberOfSelfNodeClasses() {
		byte[] ret = new byte[2];
		//int size = getDeviceGroupList().size();
		// number of classes (contains NodeProfile)
		int size = getDeviceGroupList().size() + 1;
		ret[0] = (byte)((size >> 8) & 0xFF);
		ret[1] = (byte)(size & 0xFF);
		return ret;
	}
	
	public byte[] getSelfNodeClassList() {
		List<DeviceObject[]>  groupList = getDeviceGroupList();
		int size = groupList.size();
		byte[] ret;
		if(size > 8) {
			ret = new byte[17];
		} else {
			ret = new byte[size * 2 + 1];
		}
		ret[0] = (byte)(size & 0xFF);
		for(int i = 0; i < 8 && i < size; i++) {
			ret[i*2+1] = groupList.get(i)[0].getClassGroupCode();
			ret[i*2+2] = groupList.get(i)[1].getClassCode();
		}
		return ret;
	}
	
	public List<DeviceObject[]> getDeviceGroupList() {

		List<DeviceObject[]> ret = new ArrayList<DeviceObject[]>();
		for(short code : mDeviceGroups.keySet()) {
			List<DeviceObject> list = new ArrayList<DeviceObject>(mDeviceGroups.get(code));
			list.remove(null);
			if(!list.isEmpty()) {
				ret.add(list.toArray(new DeviceObject[]{}));
			}
		}
		return ret;
	}
	
	public InetAddress getAddress() {
		return mAddress;
	}
	
	

}
