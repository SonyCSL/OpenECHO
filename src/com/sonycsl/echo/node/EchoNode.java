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
import com.sonycsl.echo.EchoSocket;
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
import com.sonycsl.echo.eoj.profile.NodeProfile.Proxy;


public final class EchoNode {
	private static HashMap<Short, DeviceProxyCreator> mProxyCreators = new HashMap<Short, DeviceProxyCreator>();
	
	private NodeProfile mNodeProfile;
	private List<DeviceObject> mDevices = new ArrayList<DeviceObject>();
	private String mAddress;
	
	public EchoNode(NodeProfile nodeProfile, DeviceObject[] devices) {
		// selfNode
		mAddress = EchoSocket.SELF_ADDRESS;
		mNodeProfile = nodeProfile;
		for(DeviceObject d : devices) {
			if(isSelfNode()) {
				d.allocateSelfDeviceInstanceCode();
			}
			mDevices.add(d);
		}
		
	}
	
	public EchoNode(String address) {
		// otherNode
		mAddress = address;
		mNodeProfile = new NodeProfile.Proxy();
	}

	public void onNew() {
		Echo.getEventListener().onNewNode(this);
	}
	
	public void onFound() {
		Echo.getEventListener().onFoundNode(this);
	}
	
	public boolean isSelfNode() {
		return EchoSocket.SELF_ADDRESS.equals(mAddress);
	}
	
	public boolean isProxy() {
		return !(EchoSocket.SELF_ADDRESS.equals(mAddress));
	}
	
	public InetAddress getAddress() {
		InetAddress address = null;
		try {
			address = InetAddress.getByName(mAddress);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return address;
	}
	
	public String getAddressStr() {
		return mAddress;
	}
	
	public NodeProfile getNodeProfile() {
		return mNodeProfile;
	}
	
	public DeviceObject addOtherDevice(short echoClassCode, byte echoInstanceCode) {
		DeviceObject device = newOtherDevice(echoClassCode, echoInstanceCode);
		addDevice(device);
		return device;
	}
	
	public void addDevice(DeviceObject device) {
		if(device == null) return;
		if(device.getNode() == this) return;

		mDevices.add(device);
		if(isSelfNode()) {
			device.allocateSelfDeviceInstanceCode();
			device.setNode(this);
			device.onNew();
			device.onFound();
		}
		/*
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
		if(mInitialized) {
			device.initialize(this);
		}*/
	}
	
	
	public void removeDevice(DeviceObject device) {
		if(device == null) return;
		if(device.getNode() != this) return;
		mDevices.remove(device);
	}
	
	public boolean containsDevice(short echoClassCode, byte echoInstanceCode) {
		for(DeviceObject d : mDevices) {
			if(d.getEchoClassCode() == echoClassCode
					&& d.getInstanceCode() == echoInstanceCode) {
				return true;
			}
		}
		return false;
	}

	public boolean containsDevice(DeviceObject device) {
		if(device == null) return false;
		if(device.getNode() != this) return false;
		return mDevices.contains(device);
	}

	public EchoObject getInstance(byte classGroupCode, byte classCode, byte instanceCode) {
		return getInstance(EchoUtils.getEchoClassCode(classGroupCode, classCode), instanceCode);
	}
	
	public EchoObject getInstance(short echoClassCode, byte echoInstanceCode) {
		if(mNodeProfile.getEchoClassCode() == echoClassCode
				&& mNodeProfile.getInstanceCode() == echoInstanceCode) {
			return mNodeProfile;
		}
		return getDevice(echoClassCode, echoInstanceCode);
	}
	
	
	public boolean containsInstance(byte classGroupCode, byte classCode, byte instanceCode) {
		short echoClassCode = EchoUtils.getEchoClassCode(classGroupCode, classCode);
		return containsInstance(echoClassCode, instanceCode);
	}
	
	public boolean containsInstance(short echoClassCode, byte echoInstanceCode) {
		if(mNodeProfile.getEchoClassCode() == echoClassCode
				&& mNodeProfile.getInstanceCode() == echoInstanceCode) {
			return true;
		}
	
		return containsDevice(echoClassCode, echoInstanceCode);
	}
	
	public DeviceObject getDevice(byte classGroupCode, byte classCode, byte instanceCode) {
		return getDevice(EchoUtils.getEchoClassCode(classGroupCode, classCode), instanceCode);
	}
	
	public DeviceObject getDevice(short echoClassCode, byte echoInstanceCode) {
		for(DeviceObject d : mDevices) {
			if(d.getEchoClassCode() == echoClassCode
					&& d.getInstanceCode() == echoInstanceCode) {
				return d;
			}
		}
		return null;
	}
	
	public DeviceObject[] getDevices(byte classGroupCode, byte classCode) {
		return getDevices(EchoUtils.getEchoClassCode(classGroupCode, classCode));
	}
	
	public DeviceObject[] getDevices(short echoClassCode) {
		List<DeviceObject> ret = new ArrayList<DeviceObject>();
		for(DeviceObject d : mDevices) {
			if(d.getEchoClassCode() == echoClassCode) {
				ret.add(d);
			}
		}
		return ret.toArray(new DeviceObject[]{});
	}
	
	public DeviceObject[] getDevices() {
		return (DeviceObject[]) mDevices.toArray(new DeviceObject[]{});
	}
	
	private static DeviceObject newOtherDevice(short echoClassCode, byte instanceCode) {
		if(mProxyCreators.containsKey(echoClassCode)) {
			return mProxyCreators.get(echoClassCode).create(instanceCode);
		}
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
		case ElectricVehicle.ECHO_CLASS_CODE: return new ElectricVehicle.Proxy(instanceCode);
		case ElectricWaterHeater.ECHO_CLASS_CODE: return new ElectricWaterHeater.Proxy(instanceCode);
		case EngineCogeneration.ECHO_CLASS_CODE: return new EngineCogeneration.Proxy(instanceCode);
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
		default: return new DeviceObject.Proxy(echoClassCode, instanceCode);
		}
	}
	public static void putDeviceProxyCreator(short echoClassCode, DeviceProxyCreator creator) {
		mProxyCreators.put(echoClassCode, creator);
	}
	public static void removeDeviceProxyCreator(short echoClassCode) {
		mProxyCreators.remove(echoClassCode);
	}
	
	public static interface DeviceProxyCreator {
		public DeviceObject create(byte instanceCode);
	}

}
