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

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoUtils;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.eoj.device.airconditioner.*;
import com.sonycsl.echo.eoj.device.audiovisual.*;
import com.sonycsl.echo.eoj.device.cookinghousehold.*;
import com.sonycsl.echo.eoj.device.health.*;
import com.sonycsl.echo.eoj.device.housingfacilities.*;
import com.sonycsl.echo.eoj.device.managementoperation.*;
import com.sonycsl.echo.eoj.device.sensor.*;
import com.sonycsl.echo.eoj.profile.*;


public final class EchoNode {
	private NodeProfile mNodeProfile;
	private Map<Short, List<DeviceObject>> mDeviceGroups;
	private InetAddress mAddress;
	
	private long mUpdatedTime = 0;
	
	private boolean mProxy = true;
	
	private boolean mInitialized = false;
	
	private boolean mActive = true;
	
	
	/**
	 * 自ipアドレスを取得
	 * @throws UnknownHostException 
	 * @throws SocketException 
	 * @throws IOException 
	 */
	public EchoNode(NodeProfile profile, DeviceObject[] devices) throws IOException {
		initialize(EchoUtils.getLocalIpAddress(), profile, devices, false);
		
	}
	
	public EchoNode(InetAddress address, List<Integer> echoObjectCodeList) {
		ArrayList<DeviceObject> list = new ArrayList<DeviceObject>();
		if(echoObjectCodeList != null) {
			for(int code : echoObjectCodeList) {
				short echoClassCode = (short)((code >> 8) & 0xFFFF);
				byte instanceCode = (byte)(code & 0xFF);
				DeviceObject device = createDeviceProxy(echoClassCode, instanceCode);
				if(device != null) list.add(device);
			}
		}
		initialize(address, new NodeProfile.Proxy(), list.toArray(new DeviceObject[]{}), true);
	}

	public EchoNode(InetAddress address, DeviceObject[] devices) {
		initialize(address, new NodeProfile.Proxy(), devices, true);
	}
	
	private void initialize(InetAddress address, NodeProfile profile, DeviceObject[] devices, boolean proxy) {
		if(mInitialized) return;
		mAddress = address;
		mNodeProfile = profile;
		
		mDeviceGroups = new HashMap<Short, List<DeviceObject>>();
		
		mProxy = proxy;
		
		addDevices(devices);
		
		Echo.addNode(this);
		mInitialized = true;
		mNodeProfile.initialize(this);
		if(devices == null) return;
		for(DeviceObject dev : devices) {
			dev.initialize(this);
		}
	}
	
	public NodeProfile getNodeProfile() {
		return mNodeProfile;
	}
	
	public void addDevices(DeviceObject[] devices) {
		if(devices == null) return;
		for(DeviceObject dev : devices) {
			addDevice(dev);
		}
	}
	
	public void addDevice(DeviceObject device) {
		if(device == null) return;
		if(device.getNode() != null) return;
		short code = device.getEchoClassCode();
		if(mDeviceGroups.containsKey(code)) {
			List<DeviceObject> deviceList = mDeviceGroups.get(code);
			if(deviceList.size() > 0x7F) return;
			deviceList.add(device);
		} else {
			List<DeviceObject> deviceList = new ArrayList<DeviceObject>();
			deviceList.add(device);
			mDeviceGroups.put(code, deviceList);
		}
		if(mInitialized) device.initialize(this);
	}
	
	public void addDevice(short echoClassCode, byte instanceCode) {
		if(containsInstance(echoClassCode, instanceCode)) return;
		DeviceObject device = createDeviceProxy(echoClassCode, instanceCode);
		addDevice(device);
	}
	
	/*
	public void remove(DeviceObject device) {
		if(device == null) return;
		if(device.getNode() != this) return;
		List<DeviceObject> list = mDeviceGroups.get(device.getEchoClassCode());
		if(list == null) return;
		if(!list.contains(device)) return;
		list.set(list.indexOf(device), null);
	}
	*/
	
	public boolean containsInstance(byte classGroupCode, byte classCode, byte instanceCode) {
		short echoClassCode = EchoUtils.getEchoClassCode(classGroupCode, classCode);
		return containsInstance(echoClassCode, instanceCode);
	}
	
	public boolean containsInstance(short echoClassCode, byte instanceCode) {
		if(NodeProfile.ECHO_CLASS_CODE == echoClassCode
				&& NodeProfile.INSTANCE_CODE == instanceCode) return true;
		if(!mDeviceGroups.containsKey(echoClassCode)) return false;
		List<DeviceObject> list = mDeviceGroups.get(echoClassCode);
		if(list == null) return false;
		for(DeviceObject device : list) {
			if(device != null) {
				if(device.getInstanceCode() == instanceCode) return true;
			}
		}
		return false;
	}
	
	public boolean containsNodeProfile(NodeProfile profile) {
		return profile.getNode() == this;
	}
	
	public boolean containsDevice(DeviceObject device) {
		if(device == null) return false;
		if(device.getNode() != this) return false;
		if(!mDeviceGroups.containsKey(device.getEchoClassCode())) return false;
		List<DeviceObject> list = mDeviceGroups.get(device.getEchoClassCode());
		if(list == null) return false;
		return list.contains(device);
	}
	
	public EchoObject getInstance(byte classGroupCode, byte classCode, byte instanceCode) {
		return getInstance(EchoUtils.getEchoClassCode(classGroupCode, classCode), instanceCode);
	}
	
	public EchoObject getInstance(short echoClassCode, byte instanceCode) {
		if(NodeProfile.ECHO_CLASS_CODE == echoClassCode) return mNodeProfile;
		if(!mDeviceGroups.containsKey(echoClassCode)) return null;
		List<DeviceObject> list = mDeviceGroups.get(echoClassCode);
		if(list == null) return null;
		for(DeviceObject device : list) {
			if(device != null) {
				if(device.getInstanceCode() == instanceCode) return device;
			}
		}
		return null;
	}
	
	public DeviceObject getDevice(byte classGroupCode, byte classCode, byte instanceCode) {
		return getDevice(EchoUtils.getEchoClassCode(classGroupCode, classCode), instanceCode);
	}
	
	public DeviceObject getDevice(short echoClassCode, byte instanceCode) {
		if(!mDeviceGroups.containsKey(echoClassCode))
			return null;
		List<DeviceObject> list = mDeviceGroups.get(echoClassCode);
		for(DeviceObject device : list) {
			if(device != null && device.getInstanceCode() == instanceCode) {
				return device;
			}
		}
		return null;
	}
	
	public DeviceObject[] getDevices(byte classGroupCode, byte classCode) {
		return getDevices(EchoUtils.getEchoClassCode(classGroupCode, classCode));
	}
	
	public DeviceObject[] getDevices(short echoClassCode) {
		if(!mDeviceGroups.containsKey(echoClassCode))
			return null;
		List<DeviceObject> deviceList = new ArrayList<DeviceObject>(mDeviceGroups.get(echoClassCode));
		deviceList.remove(null);
		return deviceList.toArray(new DeviceObject[]{});
	}
	
	public DeviceObject[] getDevices() {
		ArrayList<DeviceObject> ret = new ArrayList<DeviceObject>();
		for(List<DeviceObject> devices : mDeviceGroups.values()) {
			//List<DeviceObject> list = new ArrayList<DeviceObject>(devices);
			//list.remove(null);
			//ret.addAll(list);
			for(DeviceObject dev : devices) {
				if(dev.isActive()) ret.add(dev);
			}
		}
		return (DeviceObject[]) ret.toArray(new DeviceObject[]{});
	}
	
	private DeviceObject[] getAllDevices() {
		ArrayList<DeviceObject> ret = new ArrayList<DeviceObject>();
		for(List<DeviceObject> devices : mDeviceGroups.values()) {
			ret.addAll(devices);
		}
		return (DeviceObject[]) ret.toArray(new DeviceObject[]{});
	}
	
	public void setActive(boolean active) {
		mActive = active;
	}
	
	public boolean isActive() {
		return mActive;
	}

	public byte getDeviceNumber(DeviceObject device) {
		if(device == null) return -1;
		List<DeviceObject> list = mDeviceGroups.get(device.getEchoClassCode());
		if(list == null) return -1;
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
			ret[i*2+2] = groupList.get(i)[0].getClassCode();
		}
		return ret;
	}
	
	private List<DeviceObject[]> getDeviceGroupList() {

		List<DeviceObject[]> ret = new ArrayList<DeviceObject[]>();
		for(short code : mDeviceGroups.keySet()) {
			List<DeviceObject> list = new ArrayList<DeviceObject>(mDeviceGroups.get(code));
			//list.remove(null);
			//if(!list.isEmpty()) {
			//	ret.add(list.toArray(new DeviceObject[]{}));
			//}
			ret.add(list.toArray(new DeviceObject[]{}));
		}
		return ret;
	}
	
	public void updateDevices(List<Integer> echoObjectCodeList) {
		//ArrayList<DeviceObject> list = new ArrayList<DeviceObject>();
		if(echoObjectCodeList == null) return;
		for(int code : echoObjectCodeList) {
			short echoClassCode = (short)((code >> 8) & 0xFFFF);
			byte instanceCode = (byte)(code & 0xFF);
			if(!containsInstance(echoClassCode, instanceCode)) {
				DeviceObject device = createDeviceProxy(echoClassCode, instanceCode);

				addDevice(device);
			}
		}
		DeviceObject[] devices = getAllDevices();
		for(DeviceObject dev : devices) {
			boolean active = false;
			for(int code : echoObjectCodeList) {
				if(code == dev.getEchoObjectCode()) {
					active = true;
					break;
				}
			}
			if(active) {
				dev.update();
			} else {
				dev.setActive(false);
			}
		}
	}
	
	private static DeviceObject createDeviceProxy(short echoClassCode, byte instanceCode) {
		switch(echoClassCode) {
		case ActivityAmountSensor.ECHO_CLASS_CODE: return new ActivityAmountSensor.Proxy(instanceCode);
		case AirPollutionSensor.ECHO_CLASS_CODE: return new AirPollutionSensor.Proxy(instanceCode);
		case AirSpeedSensor.ECHO_CLASS_CODE: return new AirSpeedSensor.Proxy(instanceCode);
		case BathHeatingStatusSensor.ECHO_CLASS_CODE: return new BathHeatingStatusSensor.Proxy(instanceCode);
		case BathWaterLevelSensor.ECHO_CLASS_CODE: return new BathWaterLevelSensor.Proxy(instanceCode);
		case BedPresenceSensor.ECHO_CLASS_CODE: return new BedPresenceSensor.Proxy(instanceCode);
		case CallSensor.ECHO_CLASS_CODE: return new CallSensor.Proxy(instanceCode);
		case CigaretteSmokeSensor.ECHO_CLASS_CODE: return new CigaretteSmokeSensor.Proxy(instanceCode);
		case CO2Sensor.ECHO_CLASS_CODE: return new CO2Sensor.Proxy(instanceCode);
		case CondensationSensor.ECHO_CLASS_CODE: return new CondensationSensor.Proxy(instanceCode);
		case CrimePreventionSensor.ECHO_CLASS_CODE: return new CrimePreventionSensor.Proxy(instanceCode);
		case CurrentValueSensor.ECHO_CLASS_CODE: return new CurrentValueSensor.Proxy(instanceCode);
		case DifferentialPressureSensor.ECHO_CLASS_CODE: return new DifferentialPressureSensor.Proxy(instanceCode);
		case EarthquakeSensor.ECHO_CLASS_CODE: return new EarthquakeSensor.Proxy(instanceCode);
		case ElectricEnergySensor.ECHO_CLASS_CODE: return new ElectricEnergySensor.Proxy(instanceCode);
		case ElectricLeakSensor.ECHO_CLASS_CODE: return new ElectricLeakSensor.Proxy(instanceCode);
		case EmergencyButton.ECHO_CLASS_CODE: return new EmergencyButton.Proxy(instanceCode);
		case FireSensor.ECHO_CLASS_CODE: return new FireSensor.Proxy(instanceCode);
		case FirstAidSensor.ECHO_CLASS_CODE: return new FirstAidSensor.Proxy(instanceCode);
		case FlameSensor.ECHO_CLASS_CODE: return new FlameSensor.Proxy(instanceCode);
		case GasLeakSensor.ECHO_CLASS_CODE: return new GasLeakSensor.Proxy(instanceCode);
		case GasSensor.ECHO_CLASS_CODE: return new GasSensor.Proxy(instanceCode);
		case HumanBodyLocationSensor.ECHO_CLASS_CODE: return new HumanBodyLocationSensor.Proxy(instanceCode);
		case HumanDetectionSensor.ECHO_CLASS_CODE: return new HumanDetectionSensor.Proxy(instanceCode);
		case HumiditySensor.ECHO_CLASS_CODE: return new HumiditySensor.Proxy(instanceCode);
		case IlluminanceSensor.ECHO_CLASS_CODE: return new IlluminanceSensor.Proxy(instanceCode);
		case MailingSensor.ECHO_CLASS_CODE: return new MailingSensor.Proxy(instanceCode);
		case MicromotionSensor.ECHO_CLASS_CODE: return new MicromotionSensor.Proxy(instanceCode);
		case OdorSensor.ECHO_CLASS_CODE: return new OdorSensor.Proxy(instanceCode);
		case OpenCloseSensor.ECHO_CLASS_CODE: return new OpenCloseSensor.Proxy(instanceCode);
		case OxygenSensor.ECHO_CLASS_CODE: return new OxygenSensor.Proxy(instanceCode);
		case PassageSensor.ECHO_CLASS_CODE: return new PassageSensor.Proxy(instanceCode);
		case RainSensor.ECHO_CLASS_CODE: return new RainSensor.Proxy(instanceCode);
		case SnowSensor.ECHO_CLASS_CODE: return new SnowSensor.Proxy(instanceCode);
		case SoundSensor.ECHO_CLASS_CODE: return new SoundSensor.Proxy(instanceCode);
		case TemperatureSensor.ECHO_CLASS_CODE: return new TemperatureSensor.Proxy(instanceCode);
		case VisitorSensor.ECHO_CLASS_CODE: return new VisitorSensor.Proxy(instanceCode);
		case VOCSensor.ECHO_CLASS_CODE: return new VOCSensor.Proxy(instanceCode);
		case WaterFlowRateSensor.ECHO_CLASS_CODE: return new WaterFlowRateSensor.Proxy(instanceCode);
		case WaterLeakSensor.ECHO_CLASS_CODE: return new WaterLeakSensor.Proxy(instanceCode);
		case WaterLevelSensor.ECHO_CLASS_CODE: return new WaterLevelSensor.Proxy(instanceCode);
		case WaterOverflowSensor.ECHO_CLASS_CODE: return new WaterOverflowSensor.Proxy(instanceCode);
		case WeightSensor.ECHO_CLASS_CODE: return new WeightSensor.Proxy(instanceCode);
		case AirCleaner.ECHO_CLASS_CODE: return new AirCleaner.Proxy(instanceCode);
		case AirConditionerVentilationFan.ECHO_CLASS_CODE: return new AirConditionerVentilationFan.Proxy(instanceCode);
		case ElectricHeater.ECHO_CLASS_CODE: return new ElectricHeater.Proxy(instanceCode);
		case FanHeater.ECHO_CLASS_CODE: return new FanHeater.Proxy(instanceCode);
		case HomeAirConditioner.ECHO_CLASS_CODE: return new HomeAirConditioner.Proxy(instanceCode);
		case Humidifier.ECHO_CLASS_CODE: return new Humidifier.Proxy(instanceCode);
		case PackageTypeCommercialAirConditionerIndoorUnit.ECHO_CLASS_CODE: return new PackageTypeCommercialAirConditionerIndoorUnit.Proxy(instanceCode);
		case PackageTypeCommercialAirConditionerOutdoorUnit.ECHO_CLASS_CODE: return new PackageTypeCommercialAirConditionerOutdoorUnit.Proxy(instanceCode);
		case VentilationFan.ECHO_CLASS_CODE: return new VentilationFan.Proxy(instanceCode);
		case BathroomHeaterAndDryer.ECHO_CLASS_CODE: return new BathroomHeaterAndDryer.Proxy(instanceCode);
		case Battery.ECHO_CLASS_CODE: return new Battery.Proxy(instanceCode);
		case Buzzer.ECHO_CLASS_CODE: return new Buzzer.Proxy(instanceCode);
		case ColdOrHotWaterHeatSourceEquipment.ECHO_CLASS_CODE: return new ColdOrHotWaterHeatSourceEquipment.Proxy(instanceCode);
		case ElectricallyOperatedShade.ECHO_CLASS_CODE: return new ElectricallyOperatedShade.Proxy(instanceCode);
		case ElectricLock.ECHO_CLASS_CODE: return new ElectricLock.Proxy(instanceCode);
		case ElectricShutter.ECHO_CLASS_CODE: return new ElectricShutter.Proxy(instanceCode);
		case ElectricStormWindow.ECHO_CLASS_CODE: return new ElectricStormWindow.Proxy(instanceCode);
		case ElectricToiletSeat.ECHO_CLASS_CODE: return new ElectricToiletSeat.Proxy(instanceCode);
		case ElectricWaterHeater.ECHO_CLASS_CODE: return new ElectricWaterHeater.Proxy(instanceCode);
		case FloorHeater.ECHO_CLASS_CODE: return new FloorHeater.Proxy(instanceCode);
		case FuelCell.ECHO_CLASS_CODE: return new FuelCell.Proxy(instanceCode);
		case GasMeter.ECHO_CLASS_CODE: return new GasMeter.Proxy(instanceCode);
		case GeneralLighting.ECHO_CLASS_CODE: return new GeneralLighting.Proxy(instanceCode);
		case HouseholdSolarPowerGeneration.ECHO_CLASS_CODE: return new HouseholdSolarPowerGeneration.Proxy(instanceCode);
		case InstantaneousWaterHeater.ECHO_CLASS_CODE: return new InstantaneousWaterHeater.Proxy(instanceCode);
		case LPGasMeter.ECHO_CLASS_CODE: return new LPGasMeter.Proxy(instanceCode);
		case PowerDistributionBoardMetering.ECHO_CLASS_CODE: return new PowerDistributionBoardMetering.Proxy(instanceCode);
		case SmartElectricEnergyMeter.ECHO_CLASS_CODE: return new SmartElectricEnergyMeter.Proxy(instanceCode);
		case SmartGasMeter.ECHO_CLASS_CODE: return new SmartGasMeter.Proxy(instanceCode);
		case Sprinkler.ECHO_CLASS_CODE: return new Sprinkler.Proxy(instanceCode);
		case WaterFlowmeter.ECHO_CLASS_CODE: return new WaterFlowmeter.Proxy(instanceCode);
		case WattHourMeter.ECHO_CLASS_CODE: return new WattHourMeter.Proxy(instanceCode);
		case ClothesDryer.ECHO_CLASS_CODE: return new ClothesDryer.Proxy(instanceCode);
		case CombinationMicrowaveOven.ECHO_CLASS_CODE: return new CombinationMicrowaveOven.Proxy(instanceCode);
		case CookingHeater.ECHO_CLASS_CODE: return new CookingHeater.Proxy(instanceCode);
		case ElectricHotWaterPot.ECHO_CLASS_CODE: return new ElectricHotWaterPot.Proxy(instanceCode);
		case Refrigerator.ECHO_CLASS_CODE: return new Refrigerator.Proxy(instanceCode);
		case RiceCooker.ECHO_CLASS_CODE: return new RiceCooker.Proxy(instanceCode);
		case WasherAndDryer.ECHO_CLASS_CODE: return new WasherAndDryer.Proxy(instanceCode);
		case WashingMachine.ECHO_CLASS_CODE: return new WashingMachine.Proxy(instanceCode);
		case Weighing.ECHO_CLASS_CODE: return new Weighing.Proxy(instanceCode);
		case Controller.ECHO_CLASS_CODE: return new Controller.Proxy(instanceCode);
		case Switch.ECHO_CLASS_CODE: return new Switch.Proxy(instanceCode);
		case Display.ECHO_CLASS_CODE: return new Display.Proxy(instanceCode);
		case Television.ECHO_CLASS_CODE: return new Television.Proxy(instanceCode);
		default: return null;
		}
	}
	
	public InetAddress getAddress() {
		return mAddress;
	}
	
	public boolean isProxy() {
		return mProxy;
	}
	
	public void update() {
		mUpdatedTime = System.currentTimeMillis();
		setActive(true);
	}
	
	public long getUpdatedTime() {
		return mUpdatedTime;
	}
	
	

}
