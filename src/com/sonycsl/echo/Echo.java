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
import com.sonycsl.echo.eoj.device.airconditioner.proxy.AirCleanerProxy;
import com.sonycsl.echo.eoj.device.airconditioner.proxy.AirConditionerVentilationFanProxy;
import com.sonycsl.echo.eoj.device.airconditioner.proxy.ElectricHeaterProxy;
import com.sonycsl.echo.eoj.device.airconditioner.proxy.FanHeaterProxy;
import com.sonycsl.echo.eoj.device.airconditioner.proxy.HomeAirConditionerProxy;
import com.sonycsl.echo.eoj.device.airconditioner.proxy.HumidifierProxy;
import com.sonycsl.echo.eoj.device.airconditioner.proxy.PackageTypeCommercialAirConditionerIndoorUnitProxy;
import com.sonycsl.echo.eoj.device.airconditioner.proxy.PackageTypeCommercialAirConditionerOutdoorUnitProxy;
import com.sonycsl.echo.eoj.device.airconditioner.proxy.VentilationFanProxy;
import com.sonycsl.echo.eoj.device.audiovisual.proxy.DisplayProxy;
import com.sonycsl.echo.eoj.device.audiovisual.proxy.TelevisionProxy;
import com.sonycsl.echo.eoj.device.cookinghousehold.proxy.ClothesDryerProxy;
import com.sonycsl.echo.eoj.device.cookinghousehold.proxy.CombinationMicrowaveOvenProxy;
import com.sonycsl.echo.eoj.device.cookinghousehold.proxy.CookingHeaterProxy;
import com.sonycsl.echo.eoj.device.cookinghousehold.proxy.ElectricHotWaterPotProxy;
import com.sonycsl.echo.eoj.device.cookinghousehold.proxy.RefrigeratorProxy;
import com.sonycsl.echo.eoj.device.cookinghousehold.proxy.RiceCookerProxy;
import com.sonycsl.echo.eoj.device.cookinghousehold.proxy.WasherAndDryerProxy;
import com.sonycsl.echo.eoj.device.cookinghousehold.proxy.WashingMachineProxy;
import com.sonycsl.echo.eoj.device.health.proxy.WeighingProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.BathroomHeaterAndDryerProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.BatteryProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.BuzzerProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.ColdOrHotWaterHeatSourceEquipmentProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.ElectricLockProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.ElectricShutterProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.ElectricStormWindowProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.ElectricToiletSeatProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.ElectricWaterHeaterProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.ElectricallyOperatedShadeProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.FloorHeaterProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.FuelCellProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.GasMeterProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.GeneralLightingProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.HouseholdSolarPowerGenerationProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.InstantaneousWaterHeaterProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.LPGasMeterProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.PowerDistributionBoardMeteringProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.SmartElectricEnergyMeterProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.SmartGasMeterProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.SprinklerProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.WaterFlowmeterProxy;
import com.sonycsl.echo.eoj.device.housingfacilities.proxy.WattHourMeterProxy;
import com.sonycsl.echo.eoj.device.managementoperation.proxy.ControllerProxy;
import com.sonycsl.echo.eoj.device.managementoperation.proxy.SwitchProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.ActivityAmountSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.AirPollutionSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.AirSpeedSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.BathHeatingStatusSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.BathWaterLevelSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.BedPresenceSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.CO2SensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.CallSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.CigaretteSmokeSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.CondensationSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.CrimePreventionSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.CurrentValueSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.DifferentialPressureSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.EarthquakeSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.ElectricEnergySensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.ElectricLeakSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.EmergencyButtonProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.FireSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.FirstAidSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.FlameSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.GasLeakSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.GasSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.HumanBodyLocationSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.HumanDetectionSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.HumiditySensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.IlluminanceSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.MailingSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.MicromotionSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.OdorSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.OpenCloseSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.OxygenSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.PassageSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.RainSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.SnowSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.SoundSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.TemperatureSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.VOCSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.VisitorSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.WaterFlowRateSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.WaterLeakSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.WaterLevelSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.WaterOverflowSensorProxy;
import com.sonycsl.echo.eoj.device.sensor.proxy.WeightSensorProxy;
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
		mNode.getProfile().inform().reqInformInstanceListNotification().sendGroup();
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
		if(classGroupCode == 0x00) {
			// Sensor
			switch(classCode) {
			case ActivityAmountSensorProxy.CLASS_CODE:
				device = new ActivityAmountSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewActivityAmountSensor((ActivityAmountSensorProxy)device);
				}
				break;
			case AirPollutionSensorProxy.CLASS_CODE:
				device = new AirPollutionSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewAirPollutionSensor((AirPollutionSensorProxy)device);
				}
				break;
			case AirSpeedSensorProxy.CLASS_CODE:
				device = new AirSpeedSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewAirSpeedSensor((AirSpeedSensorProxy)device);
				}
				break;
			case BathHeatingStatusSensorProxy.CLASS_CODE:
				device = new BathHeatingStatusSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewBathHeatingStatusSensor((BathHeatingStatusSensorProxy)device);
				}
				break;
			case BathWaterLevelSensorProxy.CLASS_CODE:
				device = new BathWaterLevelSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewBathWaterLevelSensor((BathWaterLevelSensorProxy)device);
				}
				break;
			case BedPresenceSensorProxy.CLASS_CODE:
				device = new BedPresenceSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewBedPresenceSensor((BedPresenceSensorProxy)device);
				}
				break;
			case CallSensorProxy.CLASS_CODE:
				device = new CallSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewCallSensor((CallSensorProxy)device);
				}
				break;
			case CigaretteSmokeSensorProxy.CLASS_CODE:
				device = new CigaretteSmokeSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewCigaretteSmokeSensor((CigaretteSmokeSensorProxy)device);
				}
				break;
			case CO2SensorProxy.CLASS_CODE:
				device = new CO2SensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewCO2Sensor((CO2SensorProxy)device);
				}
				break;
			case CondensationSensorProxy.CLASS_CODE:
				device = new CondensationSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewCondensationSensor((CondensationSensorProxy)device);
				}
				break;
			case CrimePreventionSensorProxy.CLASS_CODE:
				device = new CrimePreventionSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewCrimePreventionSensor((CrimePreventionSensorProxy)device);
				}
				break;
			case CurrentValueSensorProxy.CLASS_CODE:
				device = new CurrentValueSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewCurrentValueSensor((CurrentValueSensorProxy)device);
				}
				break;
			case DifferentialPressureSensorProxy.CLASS_CODE:
				device = new DifferentialPressureSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewDifferentialPressureSensor((DifferentialPressureSensorProxy)device);
				}
				break;
			case EarthquakeSensorProxy.CLASS_CODE:
				device = new EarthquakeSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewEarthquakeSensor((EarthquakeSensorProxy)device);
				}
				break;
			case ElectricEnergySensorProxy.CLASS_CODE:
				device = new ElectricEnergySensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewElectricEnergySensor((ElectricEnergySensorProxy)device);
				}
				break;
			case ElectricLeakSensorProxy.CLASS_CODE:
				device = new ElectricLeakSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewElectricLeakSensor((ElectricLeakSensorProxy)device);
				}
				break;
			case EmergencyButtonProxy.CLASS_CODE:
				device = new EmergencyButtonProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewEmergencyButton((EmergencyButtonProxy)device);
				}
				break;
			case FireSensorProxy.CLASS_CODE:
				device = new FireSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewFireSensor((FireSensorProxy)device);
				}
				break;
			case FirstAidSensorProxy.CLASS_CODE:
				device = new FirstAidSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewFirstAidSensor((FirstAidSensorProxy)device);
				}
				break;
			case FlameSensorProxy.CLASS_CODE:
				device = new FlameSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewFlameSensor((FlameSensorProxy)device);
				}
				break;
			case GasLeakSensorProxy.CLASS_CODE:
				device = new GasLeakSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewGasLeakSensor((GasLeakSensorProxy)device);
				}
				break;
			case GasSensorProxy.CLASS_CODE:
				device = new GasSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewGasSensor((GasSensorProxy)device);
				}
				break;
			case HumanBodyLocationSensorProxy.CLASS_CODE:
				device = new HumanBodyLocationSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewHumanBodyLocationSensor((HumanBodyLocationSensorProxy)device);
				}
				break;
			case HumanDetectionSensorProxy.CLASS_CODE:
				device = new HumanDetectionSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewHumanDetectionSensor((HumanDetectionSensorProxy)device);
				}
				break;
			case HumiditySensorProxy.CLASS_CODE:
				device = new HumiditySensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewHumiditySensor((HumiditySensorProxy)device);
				}
				break;
			case IlluminanceSensorProxy.CLASS_CODE:
				device = new IlluminanceSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewIlluminanceSensor((IlluminanceSensorProxy)device);
				}
				break;
			case MailingSensorProxy.CLASS_CODE:
				device = new MailingSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewMailingSensor((MailingSensorProxy)device);
				}
				break;
			case MicromotionSensorProxy.CLASS_CODE:
				device = new MicromotionSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewMicromotionSensor((MicromotionSensorProxy)device);
				}
				break;
			case OdorSensorProxy.CLASS_CODE:
				device = new OdorSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewOdorSensor((OdorSensorProxy)device);
				}
				break;
			case OpenCloseSensorProxy.CLASS_CODE:
				device = new OpenCloseSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewOpenCloseSensor((OpenCloseSensorProxy)device);
				}
				break;
			case OxygenSensorProxy.CLASS_CODE:
				device = new OxygenSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewOxygenSensor((OxygenSensorProxy)device);
				}
				break;
			case PassageSensorProxy.CLASS_CODE:
				device = new PassageSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewPassageSensor((PassageSensorProxy)device);
				}
				break;
			case RainSensorProxy.CLASS_CODE:
				device = new RainSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewRainSensor((RainSensorProxy)device);
				}
				break;
			case SnowSensorProxy.CLASS_CODE:
				device = new SnowSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewSnowSensor((SnowSensorProxy)device);
				}
				break;
			case SoundSensorProxy.CLASS_CODE:
				device = new SoundSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewSoundSensor((SoundSensorProxy)device);
				}
				break;
			case TemperatureSensorProxy.CLASS_CODE:
				device = new TemperatureSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewTemperatureSensor((TemperatureSensorProxy)device);
				}
				break;
			case VisitorSensorProxy.CLASS_CODE:
				device = new VisitorSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewVisitorSensor((VisitorSensorProxy)device);
				}
				break;
			case VOCSensorProxy.CLASS_CODE:
				device = new VOCSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewVOCSensor((VOCSensorProxy)device);
				}
				break;
			case WaterFlowRateSensorProxy.CLASS_CODE:
				device = new WaterFlowRateSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewWaterFlowRateSensor((WaterFlowRateSensorProxy)device);
				}
				break;
			case WaterLeakSensorProxy.CLASS_CODE:
				device = new WaterLeakSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewWaterLeakSensor((WaterLeakSensorProxy)device);
				}
				break;
			case WaterLevelSensorProxy.CLASS_CODE:
				device = new WaterLevelSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewWaterLevelSensor((WaterLevelSensorProxy)device);
				}
				break;
			case WaterOverflowSensorProxy.CLASS_CODE:
				device = new WaterOverflowSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewWaterOverflowSensor((WaterOverflowSensorProxy)device);
				}
				break;
			case WeightSensorProxy.CLASS_CODE:
				device = new WeightSensorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewWeightSensor((WeightSensorProxy)device);
				}
				break;
			}
		} else if(classGroupCode == 0x01) {
			// AirConditioner
			switch(classCode) {
			case AirCleanerProxy.CLASS_CODE:
				device = new AirCleanerProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewAirCleaner((AirCleanerProxy)device);
				}
				break;
			case AirConditionerVentilationFanProxy.CLASS_CODE:
				device = new AirConditionerVentilationFanProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewAirConditionerVentilationFan((AirConditionerVentilationFanProxy)device);
				}
				break;
			case ElectricHeaterProxy.CLASS_CODE:
				device = new ElectricHeaterProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewElectricHeater((ElectricHeaterProxy)device);
				}
				break;
			case FanHeaterProxy.CLASS_CODE:
				device = new FanHeaterProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewFanHeater((FanHeaterProxy)device);
				}
				break;
			case HomeAirConditionerProxy.CLASS_CODE:
				device = new HomeAirConditionerProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewHomeAirConditioner((HomeAirConditionerProxy)device);
				}
				break;
			case HumidifierProxy.CLASS_CODE:
				device = new HumidifierProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewHumidifier((HumidifierProxy)device);
				}
				break;
			case PackageTypeCommercialAirConditionerIndoorUnitProxy.CLASS_CODE:
				device = new PackageTypeCommercialAirConditionerIndoorUnitProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewPackageTypeCommercialAirConditionerIndoorUnit((PackageTypeCommercialAirConditionerIndoorUnitProxy)device);
				}
				break;
			case PackageTypeCommercialAirConditionerOutdoorUnitProxy.CLASS_CODE:
				device = new PackageTypeCommercialAirConditionerOutdoorUnitProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewPackageTypeCommercialAirConditionerOutdoorUnit((PackageTypeCommercialAirConditionerOutdoorUnitProxy)device);
				}
				break;
			case VentilationFanProxy.CLASS_CODE:
				device = new VentilationFanProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewVentilationFan((VentilationFanProxy)device);
				}
				break;
			}
		} else if(classGroupCode == 0x02) {
			// Housing/Facilities
			switch(classCode) {
			case BathroomHeaterAndDryerProxy.CLASS_CODE:
				device = new BathroomHeaterAndDryerProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewBathroomHeaterAndDryer((BathroomHeaterAndDryerProxy)device);
				}
				break;
			case BatteryProxy.CLASS_CODE:
				device = new BatteryProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewBattery((BatteryProxy)device);
				}
				break;
			case BuzzerProxy.CLASS_CODE:
				device = new BuzzerProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewBuzzer((BuzzerProxy)device);
				}
				break;
			case ColdOrHotWaterHeatSourceEquipmentProxy.CLASS_CODE:
				device = new ColdOrHotWaterHeatSourceEquipmentProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewColdOrHotWaterHeatSourceEquipment((ColdOrHotWaterHeatSourceEquipmentProxy)device);
				}
				break;
			case ElectricallyOperatedShadeProxy.CLASS_CODE:
				device = new ElectricallyOperatedShadeProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewElectricallyOperatedShade((ElectricallyOperatedShadeProxy)device);
				}
				break;
			case ElectricLockProxy.CLASS_CODE:
				device = new ElectricLockProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewElectricLock((ElectricLockProxy)device);
				}
				break;
			case ElectricShutterProxy.CLASS_CODE:
				device = new ElectricShutterProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewElectricShutter((ElectricShutterProxy)device);
				}
				break;
			case ElectricStormWindowProxy.CLASS_CODE:
				device = new ElectricStormWindowProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewElectricStormWindow((ElectricStormWindowProxy)device);
				}
				break;
			case ElectricToiletSeatProxy.CLASS_CODE:
				device = new ElectricToiletSeatProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewElectricToiletSeat((ElectricToiletSeatProxy)device);
				}
				break;
			case ElectricWaterHeaterProxy.CLASS_CODE:
				device = new ElectricWaterHeaterProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewElectricWaterHeater((ElectricWaterHeaterProxy)device);
				}
				break;
			case FloorHeaterProxy.CLASS_CODE:
				device = new FloorHeaterProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewFloorHeater((FloorHeaterProxy)device);
				}
				break;
			case FuelCellProxy.CLASS_CODE:
				device = new FuelCellProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewFuelCell((FuelCellProxy)device);
				}
				break;
			case GasMeterProxy.CLASS_CODE:
				device = new GasMeterProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewGasMeter((GasMeterProxy)device);
				}
				break;
			case GeneralLightingProxy.CLASS_CODE:
				device = new GeneralLightingProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewGeneralLighting((GeneralLightingProxy)device);
				}
				break;
			case HouseholdSolarPowerGenerationProxy.CLASS_CODE:
				device = new HouseholdSolarPowerGenerationProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewHouseholdSolarPowerGeneration((HouseholdSolarPowerGenerationProxy)device);
				}
				break;
			case InstantaneousWaterHeaterProxy.CLASS_CODE:
				device = new InstantaneousWaterHeaterProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewInstantaneousWaterHeater((InstantaneousWaterHeaterProxy)device);
				}
				break;
			case LPGasMeterProxy.CLASS_CODE:
				device = new LPGasMeterProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewLPGasMeter((LPGasMeterProxy)device);
				}
				break;
			case PowerDistributionBoardMeteringProxy.CLASS_CODE:
				device = new PowerDistributionBoardMeteringProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewPowerDistributionBoardMetering((PowerDistributionBoardMeteringProxy)device);
				}
				break;
			case SmartElectricEnergyMeterProxy.CLASS_CODE:
				device = new SmartElectricEnergyMeterProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewSmartElectricEnergyMeter((SmartElectricEnergyMeterProxy)device);
				}
				break;
			case SmartGasMeterProxy.CLASS_CODE:
				device = new SmartGasMeterProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewSmartGasMeter((SmartGasMeterProxy)device);
				}
				break;
			case SprinklerProxy.CLASS_CODE:
				device = new SprinklerProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewSprinkler((SprinklerProxy)device);
				}
				break;
			case WaterFlowmeterProxy.CLASS_CODE:
				device = new WaterFlowmeterProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewWaterFlowmeter((WaterFlowmeterProxy)device);
				}
				break;
			case WattHourMeterProxy.CLASS_CODE:
				device = new WattHourMeterProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewWattHourMeter((WattHourMeterProxy)device);
				}
				break;
			}
		} else if(classGroupCode == 0x03) {
			// Cooking/Household
			switch(classCode) {
			case ClothesDryerProxy.CLASS_CODE:
				device = new ClothesDryerProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewClothesDryer((ClothesDryerProxy)device);
				}
				break;
			case CombinationMicrowaveOvenProxy.CLASS_CODE:
				device = new ClothesDryerProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewCombinationMicrowaveOven((CombinationMicrowaveOvenProxy)device);
				}
				break;
			case CookingHeaterProxy.CLASS_CODE:
				device = new CookingHeaterProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewCookingHeater((CookingHeaterProxy)device);
				}
				break;
			case ElectricHotWaterPotProxy.CLASS_CODE:
				device = new ElectricHotWaterPotProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewElectricHotWaterPot((ElectricHotWaterPotProxy)device);
				}
				break;
			case RefrigeratorProxy.CLASS_CODE:
				device = new RefrigeratorProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewRefrigerator((RefrigeratorProxy)device);
				}
				break;
			case RiceCookerProxy.CLASS_CODE:
				device = new RiceCookerProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewRiceCooker((RiceCookerProxy)device);
				}
				break;
			case WasherAndDryerProxy.CLASS_CODE:
				device = new WasherAndDryerProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewWasherAndDryer((WasherAndDryerProxy)device);
				}
				break;
			case WashingMachineProxy.CLASS_CODE:
				device = new WashingMachineProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewWashingMachine((WashingMachineProxy)device);
				}
				break;
			}
		} else if(classGroupCode == 0x04) {
			// Health
			switch(classCode) {
			case WeighingProxy.CLASS_CODE:
				device = new WeighingProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewWeighing((WeighingProxy)device);
				}
				break;
			}
		} else if(classGroupCode == 0x05) {
			// Management/Operation
			switch(classCode) {
			case ControllerProxy.CLASS_CODE:
				device = new ControllerProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewController((ControllerProxy)device);
				}
				break;
			case SwitchProxy.CLASS_CODE:
				device = new SwitchProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewSwitch((SwitchProxy)device);
				}
				break;
			}
		} else if(classGroupCode == 0x06) {
			// Audiovisual
			switch(classCode) {
			case DisplayProxy.CLASS_CODE:
				device = new DisplayProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewDisplay((DisplayProxy)device);
				}
				break;
			case TelevisionProxy.CLASS_CODE:
				device = new TelevisionProxy(instanceCode);
				node.addDevice(device);
				if(mProxyListener != null) {
					mProxyListener.onNewDevice(device);
					mProxyListener.onNewTelevision((TelevisionProxy)device);
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
		
		public void onNewActivityAmountSensor(ActivityAmountSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewActivityAmountSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewAirPollutionSensor(AirPollutionSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewAirPollutionSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewAirSpeedSensor(AirSpeedSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewAirSpeedSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewBathHeatingStatusSensor(BathHeatingStatusSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewBathHeatingStatusSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewBathWaterLevelSensor(BathWaterLevelSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewBathWaterLevelSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewBedPresenceSensor(BedPresenceSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewBedPresenceSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewCallSensor(CallSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewCallSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewCigaretteSmokeSensor(CigaretteSmokeSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewCigaretteSmokeSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewCO2Sensor(CO2SensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewCO2Sensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewCondensationSensor(CondensationSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewCondensationSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewCrimePreventionSensor(CrimePreventionSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewCrimePreventionSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewCurrentValueSensor(CurrentValueSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewCurrentValueSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewDifferentialPressureSensor(DifferentialPressureSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewDifferentialPressureSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewEarthquakeSensor(EarthquakeSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewEarthquakeSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewElectricEnergySensor(ElectricEnergySensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewElectricEnergySensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewElectricLeakSensor(ElectricLeakSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewElectricLeakSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewEmergencyButton(EmergencyButtonProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewEmergencyButton[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewFireSensor(FireSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewFireSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewFirstAidSensor(FirstAidSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewFirstAidSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewFlameSensor(FlameSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewFlameSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewGasLeakSensor(GasLeakSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewGasLeakSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewGasSensor(GasSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewGasSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewHumanBodyLocationSensor(HumanBodyLocationSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewHumanBodyLocationSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewHumanDetectionSensor(HumanDetectionSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewHumanDetectionSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewHumiditySensor(HumiditySensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewHumiditySensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewIlluminanceSensor(IlluminanceSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewIlluminanceSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewMailingSensor(MailingSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewMailingSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewMicromotionSensor(MicromotionSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewMicromotionSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewOdorSensor(OdorSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewOdorSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewOpenCloseSensor(OpenCloseSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewOpenCloseSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewOxygenSensor(OxygenSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewOxygenSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewPassageSensor(PassageSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewPassageSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewRainSensor(RainSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewRainSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewSnowSensor(SnowSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewSnowSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewSoundSensor(SoundSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewSoundSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewTemperatureSensor(TemperatureSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewTemperatureSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewVisitorSensor(VisitorSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewVisitorSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewVOCSensor(VOCSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewVOCSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewWaterFlowRateSensor(WaterFlowRateSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewWaterFlowRateSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewWaterLeakSensor(WaterLeakSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewWaterLeakSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewWaterLevelSensor(WaterLevelSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewWaterLevelSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewWaterOverflowSensor(WaterOverflowSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewWaterOverflowSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewWeightSensor(WeightSensorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewWeightSensor[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewAirCleaner(AirCleanerProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewAirCleaner[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewAirConditionerVentilationFan(AirConditionerVentilationFanProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewAirConditionerVentilationFan[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewElectricHeater(ElectricHeaterProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewElectricHeater[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewFanHeater(FanHeaterProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewFanHeater[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewHomeAirConditioner(HomeAirConditionerProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewHomeAirConditioner[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewHumidifier(HumidifierProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewHumidifier[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewPackageTypeCommercialAirConditionerIndoorUnit(PackageTypeCommercialAirConditionerIndoorUnitProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewPackageTypeCommercialAirConditionerIndoorUnit[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewPackageTypeCommercialAirConditionerOutdoorUnit(PackageTypeCommercialAirConditionerOutdoorUnitProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewPackageTypeCommercialAirConditionerOutdoorUnit[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewVentilationFan(VentilationFanProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewVentilationFan[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewBathroomHeaterAndDryer(BathroomHeaterAndDryerProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewBathroomHeaterAndDryer[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewBattery(BatteryProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewBattery[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewBuzzer(BuzzerProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewBuzzer[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewColdOrHotWaterHeatSourceEquipment(ColdOrHotWaterHeatSourceEquipmentProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewColdOrHotWaterHeatSourceEquipment[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewElectricallyOperatedShade(ElectricallyOperatedShadeProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewElectricallyOperatedShade[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewElectricLock(ElectricLockProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewElectricLock[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewElectricShutter(ElectricShutterProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewElectricShutter[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewElectricStormWindow(ElectricStormWindowProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewElectricStormWindow[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewElectricToiletSeat(ElectricToiletSeatProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewElectricToiletSeat[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewElectricWaterHeater(ElectricWaterHeaterProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewElectricWaterHeater[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewFloorHeater(FloorHeaterProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewFloorHeater[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewFuelCell(FuelCellProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewFuelCell[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewGasMeter(GasMeterProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewGasMeter[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewGeneralLighting(GeneralLightingProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewGeneralLighting[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewHouseholdSolarPowerGeneration(HouseholdSolarPowerGenerationProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewHouseholdSolarPowerGeneration[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewInstantaneousWaterHeater(InstantaneousWaterHeaterProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewInstantaneousWaterHeater[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewLPGasMeter(LPGasMeterProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewLPGasMeter[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewPowerDistributionBoardMetering(PowerDistributionBoardMeteringProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewPowerDistributionBoardMetering[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewSmartElectricEnergyMeter(SmartElectricEnergyMeterProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewSmartElectricEnergyMeter[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewSmartGasMeter(SmartGasMeterProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewSmartGasMeter[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewSprinkler(SprinklerProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewSprinkler[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewWaterFlowmeter(WaterFlowmeterProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewWaterFlowmeter[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewWattHourMeter(WattHourMeterProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewWattHourMeter[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewClothesDryer(ClothesDryerProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewClothesDryer[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewCombinationMicrowaveOven(CombinationMicrowaveOvenProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewCombinationMicrowaveOven[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewCookingHeater(CookingHeaterProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewCookingHeater[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewElectricHotWaterPot(ElectricHotWaterPotProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewElectricHotWaterPot[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewRefrigerator(RefrigeratorProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewRefrigerator[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewRiceCooker(RiceCookerProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewRiceCooker[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewWasherAndDryer(WasherAndDryerProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewWasherAndDryer[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewWashingMachine(WashingMachineProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewWashingMachine[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewWeighing(WeighingProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewWeighing[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewController(ControllerProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewController[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}
		
		public void onNewSwitch(SwitchProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewSwitch[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewDisplay(DisplayProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewDisplay[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

		public void onNewTelevision(TelevisionProxy device) {
			if(Echo.getEcho().isTracing()) {
				System.out.println("onNewTelevision[address:"+device.getNode().getAddress().getHostAddress()+"]");
			}
		}

	}
}
