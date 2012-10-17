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
import java.io.PrintStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	
	private static EchoNode sNode;
	private static Map<InetAddress, EchoNode> sNodeProxies;
	
	private static ProxyListener sProxyListener = null;
	
	private static PrintStream sOut = null;
	
	private Echo() {
	}
	
	public static EchoNode start(NodeProfile profile, DeviceObject[] devices) throws IOException {

		sNodeProxies = new HashMap<InetAddress, EchoNode>();
		EchoSocket.start();
		sNode = new EchoNode(profile, devices);
		sNode.getProfile().inform().reqInformInstanceListNotification().sendGroup();
		return sNode;
	}
	
	public static void stop() throws IOException {
		sProxyListener = null;
		EchoSocket.stop();
		sNodeProxies.clear();
	}
	
	public static void setProxyListener(ProxyListener listener) {
		sProxyListener = listener;
	}
	
	public static void removeNodeProxy(EchoNode node) {
		sNodeProxies.remove(node.getAddress());
	}
	
	public static void removeAllNodeProxies() {
		sNodeProxies.clear();
	}
	
	public static EchoNode getNode() {
		return sNode;
	}
	
	public static EchoNode[] getNodeProxies() {
		return (EchoNode[]) sNodeProxies.values().toArray(new EchoNode[]{});
	}
	
	public static EchoNode[] getNodes() {
		List<EchoNode> nodes = new ArrayList<EchoNode>();
		EchoNode[] proxies = getNodeProxies();
		nodes.add(sNode);
		for(EchoNode p : proxies) {
			nodes.add(p);
		}
		return (EchoNode[]) nodes.toArray(new EchoNode[]{});
	}
	
	public static void refreshProxy(InetAddress address, byte[] instanceList) {
		if(sNode.getAddress().equals(address)) {
			return;
		}
		int size = instanceList[0] & 0xFF;
		if(size > 84) {
			size = 84;
		} else if(sNodeProxies.containsKey(address)) {
			EchoNode node = sNodeProxies.get(address);
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
					sNode.removeDevice(device);
				}
			}
		}
		for(int i = 0; i < size; i++) {
			putProxy(address, instanceList[i*3+1], instanceList[i*3+2], instanceList[i*3+3]);
		}
		
		
		
	}
	
	public static void putProxy(InetAddress address, byte classGroupCode, byte classCode, byte instanceCode) {

		if(sNode.getAddress().equals(address)) {
			return;
		}
		EchoNode node;
		if(sNodeProxies.containsKey(address)) {
			node = sNodeProxies.get(address);
		} else {
			NodeProfileProxy profile = new NodeProfileProxy();
			node = new EchoNode(address, profile, new DeviceObject[0]);
			sNodeProxies.put(address, node);
			if(sProxyListener != null) {
				sProxyListener.onNewNode(node);
				sProxyListener.onNewProfileObject(profile);
				sProxyListener.onNewNodeProfile(profile);
			}
		}
		if(!node.existsInstance(classGroupCode, classCode, instanceCode)) {
			createDeviceProxy(node, classGroupCode, classCode, instanceCode);
		}
	}
	
	public static EchoObject getInstance(InetAddress address, byte classGroupCode, byte classCode, byte instanceCode) {

		if(sNode.getAddress().equals(address)) {
			return sNode.getInstance(classGroupCode, classCode, instanceCode);
		} else {
			if(sNodeProxies.containsKey(address)) {
				EchoNode node = sNodeProxies.get(address);
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
	

	private static void createDeviceProxy(EchoNode node, byte classGroupCode, byte classCode, byte instanceCode) {
		DeviceObject device;
		if(classGroupCode == 0x00) {
			// Sensor
			switch(classCode) {
			case ActivityAmountSensorProxy.CLASS_CODE:
				device = new ActivityAmountSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewActivityAmountSensor((ActivityAmountSensorProxy)device);
				}
				break;
			case AirPollutionSensorProxy.CLASS_CODE:
				device = new AirPollutionSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewAirPollutionSensor((AirPollutionSensorProxy)device);
				}
				break;
			case AirSpeedSensorProxy.CLASS_CODE:
				device = new AirSpeedSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewAirSpeedSensor((AirSpeedSensorProxy)device);
				}
				break;
			case BathHeatingStatusSensorProxy.CLASS_CODE:
				device = new BathHeatingStatusSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewBathHeatingStatusSensor((BathHeatingStatusSensorProxy)device);
				}
				break;
			case BathWaterLevelSensorProxy.CLASS_CODE:
				device = new BathWaterLevelSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewBathWaterLevelSensor((BathWaterLevelSensorProxy)device);
				}
				break;
			case BedPresenceSensorProxy.CLASS_CODE:
				device = new BedPresenceSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewBedPresenceSensor((BedPresenceSensorProxy)device);
				}
				break;
			case CallSensorProxy.CLASS_CODE:
				device = new CallSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewCallSensor((CallSensorProxy)device);
				}
				break;
			case CigaretteSmokeSensorProxy.CLASS_CODE:
				device = new CigaretteSmokeSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewCigaretteSmokeSensor((CigaretteSmokeSensorProxy)device);
				}
				break;
			case CO2SensorProxy.CLASS_CODE:
				device = new CO2SensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewCO2Sensor((CO2SensorProxy)device);
				}
				break;
			case CondensationSensorProxy.CLASS_CODE:
				device = new CondensationSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewCondensationSensor((CondensationSensorProxy)device);
				}
				break;
			case CrimePreventionSensorProxy.CLASS_CODE:
				device = new CrimePreventionSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewCrimePreventionSensor((CrimePreventionSensorProxy)device);
				}
				break;
			case CurrentValueSensorProxy.CLASS_CODE:
				device = new CurrentValueSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewCurrentValueSensor((CurrentValueSensorProxy)device);
				}
				break;
			case DifferentialPressureSensorProxy.CLASS_CODE:
				device = new DifferentialPressureSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewDifferentialPressureSensor((DifferentialPressureSensorProxy)device);
				}
				break;
			case EarthquakeSensorProxy.CLASS_CODE:
				device = new EarthquakeSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewEarthquakeSensor((EarthquakeSensorProxy)device);
				}
				break;
			case ElectricEnergySensorProxy.CLASS_CODE:
				device = new ElectricEnergySensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewElectricEnergySensor((ElectricEnergySensorProxy)device);
				}
				break;
			case ElectricLeakSensorProxy.CLASS_CODE:
				device = new ElectricLeakSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewElectricLeakSensor((ElectricLeakSensorProxy)device);
				}
				break;
			case EmergencyButtonProxy.CLASS_CODE:
				device = new EmergencyButtonProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewEmergencyButton((EmergencyButtonProxy)device);
				}
				break;
			case FireSensorProxy.CLASS_CODE:
				device = new FireSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewFireSensor((FireSensorProxy)device);
				}
				break;
			case FirstAidSensorProxy.CLASS_CODE:
				device = new FirstAidSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewFirstAidSensor((FirstAidSensorProxy)device);
				}
				break;
			case FlameSensorProxy.CLASS_CODE:
				device = new FlameSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewFlameSensor((FlameSensorProxy)device);
				}
				break;
			case GasLeakSensorProxy.CLASS_CODE:
				device = new GasLeakSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewGasLeakSensor((GasLeakSensorProxy)device);
				}
				break;
			case GasSensorProxy.CLASS_CODE:
				device = new GasSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewGasSensor((GasSensorProxy)device);
				}
				break;
			case HumanBodyLocationSensorProxy.CLASS_CODE:
				device = new HumanBodyLocationSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewHumanBodyLocationSensor((HumanBodyLocationSensorProxy)device);
				}
				break;
			case HumanDetectionSensorProxy.CLASS_CODE:
				device = new HumanDetectionSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewHumanDetectionSensor((HumanDetectionSensorProxy)device);
				}
				break;
			case HumiditySensorProxy.CLASS_CODE:
				device = new HumiditySensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewHumiditySensor((HumiditySensorProxy)device);
				}
				break;
			case IlluminanceSensorProxy.CLASS_CODE:
				device = new IlluminanceSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewIlluminanceSensor((IlluminanceSensorProxy)device);
				}
				break;
			case MailingSensorProxy.CLASS_CODE:
				device = new MailingSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewMailingSensor((MailingSensorProxy)device);
				}
				break;
			case MicromotionSensorProxy.CLASS_CODE:
				device = new MicromotionSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewMicromotionSensor((MicromotionSensorProxy)device);
				}
				break;
			case OdorSensorProxy.CLASS_CODE:
				device = new OdorSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewOdorSensor((OdorSensorProxy)device);
				}
				break;
			case OpenCloseSensorProxy.CLASS_CODE:
				device = new OpenCloseSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewOpenCloseSensor((OpenCloseSensorProxy)device);
				}
				break;
			case OxygenSensorProxy.CLASS_CODE:
				device = new OxygenSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewOxygenSensor((OxygenSensorProxy)device);
				}
				break;
			case PassageSensorProxy.CLASS_CODE:
				device = new PassageSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewPassageSensor((PassageSensorProxy)device);
				}
				break;
			case RainSensorProxy.CLASS_CODE:
				device = new RainSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewRainSensor((RainSensorProxy)device);
				}
				break;
			case SnowSensorProxy.CLASS_CODE:
				device = new SnowSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewSnowSensor((SnowSensorProxy)device);
				}
				break;
			case SoundSensorProxy.CLASS_CODE:
				device = new SoundSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewSoundSensor((SoundSensorProxy)device);
				}
				break;
			case TemperatureSensorProxy.CLASS_CODE:
				device = new TemperatureSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewTemperatureSensor((TemperatureSensorProxy)device);
				}
				break;
			case VisitorSensorProxy.CLASS_CODE:
				device = new VisitorSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewVisitorSensor((VisitorSensorProxy)device);
				}
				break;
			case VOCSensorProxy.CLASS_CODE:
				device = new VOCSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewVOCSensor((VOCSensorProxy)device);
				}
				break;
			case WaterFlowRateSensorProxy.CLASS_CODE:
				device = new WaterFlowRateSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewWaterFlowRateSensor((WaterFlowRateSensorProxy)device);
				}
				break;
			case WaterLeakSensorProxy.CLASS_CODE:
				device = new WaterLeakSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewWaterLeakSensor((WaterLeakSensorProxy)device);
				}
				break;
			case WaterLevelSensorProxy.CLASS_CODE:
				device = new WaterLevelSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewWaterLevelSensor((WaterLevelSensorProxy)device);
				}
				break;
			case WaterOverflowSensorProxy.CLASS_CODE:
				device = new WaterOverflowSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewWaterOverflowSensor((WaterOverflowSensorProxy)device);
				}
				break;
			case WeightSensorProxy.CLASS_CODE:
				device = new WeightSensorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewWeightSensor((WeightSensorProxy)device);
				}
				break;
			}
		} else if(classGroupCode == 0x01) {
			// AirConditioner
			switch(classCode) {
			case AirCleanerProxy.CLASS_CODE:
				device = new AirCleanerProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewAirCleaner((AirCleanerProxy)device);
				}
				break;
			case AirConditionerVentilationFanProxy.CLASS_CODE:
				device = new AirConditionerVentilationFanProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewAirConditionerVentilationFan((AirConditionerVentilationFanProxy)device);
				}
				break;
			case ElectricHeaterProxy.CLASS_CODE:
				device = new ElectricHeaterProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewElectricHeater((ElectricHeaterProxy)device);
				}
				break;
			case FanHeaterProxy.CLASS_CODE:
				device = new FanHeaterProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewFanHeater((FanHeaterProxy)device);
				}
				break;
			case HomeAirConditionerProxy.CLASS_CODE:
				device = new HomeAirConditionerProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewHomeAirConditioner((HomeAirConditionerProxy)device);
				}
				break;
			case HumidifierProxy.CLASS_CODE:
				device = new HumidifierProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewHumidifier((HumidifierProxy)device);
				}
				break;
			case PackageTypeCommercialAirConditionerIndoorUnitProxy.CLASS_CODE:
				device = new PackageTypeCommercialAirConditionerIndoorUnitProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewPackageTypeCommercialAirConditionerIndoorUnit((PackageTypeCommercialAirConditionerIndoorUnitProxy)device);
				}
				break;
			case PackageTypeCommercialAirConditionerOutdoorUnitProxy.CLASS_CODE:
				device = new PackageTypeCommercialAirConditionerOutdoorUnitProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewPackageTypeCommercialAirConditionerOutdoorUnit((PackageTypeCommercialAirConditionerOutdoorUnitProxy)device);
				}
				break;
			case VentilationFanProxy.CLASS_CODE:
				device = new VentilationFanProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewVentilationFan((VentilationFanProxy)device);
				}
				break;
			}
		} else if(classGroupCode == 0x02) {
			// Housing/Facilities
			switch(classCode) {
			case BathroomHeaterAndDryerProxy.CLASS_CODE:
				device = new BathroomHeaterAndDryerProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewBathroomHeaterAndDryer((BathroomHeaterAndDryerProxy)device);
				}
				break;
			case BatteryProxy.CLASS_CODE:
				device = new BatteryProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewBattery((BatteryProxy)device);
				}
				break;
			case BuzzerProxy.CLASS_CODE:
				device = new BuzzerProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewBuzzer((BuzzerProxy)device);
				}
				break;
			case ColdOrHotWaterHeatSourceEquipmentProxy.CLASS_CODE:
				device = new ColdOrHotWaterHeatSourceEquipmentProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewColdOrHotWaterHeatSourceEquipment((ColdOrHotWaterHeatSourceEquipmentProxy)device);
				}
				break;
			case ElectricallyOperatedShadeProxy.CLASS_CODE:
				device = new ElectricallyOperatedShadeProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewElectricallyOperatedShade((ElectricallyOperatedShadeProxy)device);
				}
				break;
			case ElectricLockProxy.CLASS_CODE:
				device = new ElectricLockProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewElectricLock((ElectricLockProxy)device);
				}
				break;
			case ElectricShutterProxy.CLASS_CODE:
				device = new ElectricShutterProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewElectricShutter((ElectricShutterProxy)device);
				}
				break;
			case ElectricStormWindowProxy.CLASS_CODE:
				device = new ElectricStormWindowProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewElectricStormWindow((ElectricStormWindowProxy)device);
				}
				break;
			case ElectricToiletSeatProxy.CLASS_CODE:
				device = new ElectricToiletSeatProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewElectricToiletSeat((ElectricToiletSeatProxy)device);
				}
				break;
			case ElectricWaterHeaterProxy.CLASS_CODE:
				device = new ElectricWaterHeaterProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewElectricWaterHeater((ElectricWaterHeaterProxy)device);
				}
				break;
			case FloorHeaterProxy.CLASS_CODE:
				device = new FloorHeaterProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewFloorHeater((FloorHeaterProxy)device);
				}
				break;
			case FuelCellProxy.CLASS_CODE:
				device = new FuelCellProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewFuelCell((FuelCellProxy)device);
				}
				break;
			case GasMeterProxy.CLASS_CODE:
				device = new GasMeterProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewGasMeter((GasMeterProxy)device);
				}
				break;
			case GeneralLightingProxy.CLASS_CODE:
				device = new GeneralLightingProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewGeneralLighting((GeneralLightingProxy)device);
				}
				break;
			case HouseholdSolarPowerGenerationProxy.CLASS_CODE:
				device = new HouseholdSolarPowerGenerationProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewHouseholdSolarPowerGeneration((HouseholdSolarPowerGenerationProxy)device);
				}
				break;
			case InstantaneousWaterHeaterProxy.CLASS_CODE:
				device = new InstantaneousWaterHeaterProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewInstantaneousWaterHeater((InstantaneousWaterHeaterProxy)device);
				}
				break;
			case LPGasMeterProxy.CLASS_CODE:
				device = new LPGasMeterProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewLPGasMeter((LPGasMeterProxy)device);
				}
				break;
			case PowerDistributionBoardMeteringProxy.CLASS_CODE:
				device = new PowerDistributionBoardMeteringProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewPowerDistributionBoardMetering((PowerDistributionBoardMeteringProxy)device);
				}
				break;
			case SmartElectricEnergyMeterProxy.CLASS_CODE:
				device = new SmartElectricEnergyMeterProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewSmartElectricEnergyMeter((SmartElectricEnergyMeterProxy)device);
				}
				break;
			case SmartGasMeterProxy.CLASS_CODE:
				device = new SmartGasMeterProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewSmartGasMeter((SmartGasMeterProxy)device);
				}
				break;
			case SprinklerProxy.CLASS_CODE:
				device = new SprinklerProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewSprinkler((SprinklerProxy)device);
				}
				break;
			case WaterFlowmeterProxy.CLASS_CODE:
				device = new WaterFlowmeterProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewWaterFlowmeter((WaterFlowmeterProxy)device);
				}
				break;
			case WattHourMeterProxy.CLASS_CODE:
				device = new WattHourMeterProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewWattHourMeter((WattHourMeterProxy)device);
				}
				break;
			}
		} else if(classGroupCode == 0x03) {
			// Cooking/Household
			switch(classCode) {
			case ClothesDryerProxy.CLASS_CODE:
				device = new ClothesDryerProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewClothesDryer((ClothesDryerProxy)device);
				}
				break;
			case CombinationMicrowaveOvenProxy.CLASS_CODE:
				device = new ClothesDryerProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewCombinationMicrowaveOven((CombinationMicrowaveOvenProxy)device);
				}
				break;
			case CookingHeaterProxy.CLASS_CODE:
				device = new CookingHeaterProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewCookingHeater((CookingHeaterProxy)device);
				}
				break;
			case ElectricHotWaterPotProxy.CLASS_CODE:
				device = new ElectricHotWaterPotProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewElectricHotWaterPot((ElectricHotWaterPotProxy)device);
				}
				break;
			case RefrigeratorProxy.CLASS_CODE:
				device = new RefrigeratorProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewRefrigerator((RefrigeratorProxy)device);
				}
				break;
			case RiceCookerProxy.CLASS_CODE:
				device = new RiceCookerProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewRiceCooker((RiceCookerProxy)device);
				}
				break;
			case WasherAndDryerProxy.CLASS_CODE:
				device = new WasherAndDryerProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewWasherAndDryer((WasherAndDryerProxy)device);
				}
				break;
			case WashingMachineProxy.CLASS_CODE:
				device = new WashingMachineProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewWashingMachine((WashingMachineProxy)device);
				}
				break;
			}
		} else if(classGroupCode == 0x04) {
			// Health
			switch(classCode) {
			case WeighingProxy.CLASS_CODE:
				device = new WeighingProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewWeighing((WeighingProxy)device);
				}
				break;
			}
		} else if(classGroupCode == 0x05) {
			// Management/Operation
			switch(classCode) {
			case ControllerProxy.CLASS_CODE:
				device = new ControllerProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewController((ControllerProxy)device);
				}
				break;
			case SwitchProxy.CLASS_CODE:
				device = new SwitchProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewSwitch((SwitchProxy)device);
				}
				break;
			}
		} else if(classGroupCode == 0x06) {
			// Audiovisual
			switch(classCode) {
			case DisplayProxy.CLASS_CODE:
				device = new DisplayProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewDisplay((DisplayProxy)device);
				}
				break;
			case TelevisionProxy.CLASS_CODE:
				device = new TelevisionProxy(instanceCode);
				node.addDevice(device);
				if(sProxyListener != null) {
					sProxyListener.onNewDevice(device);
					sProxyListener.onNewTelevision((TelevisionProxy)device);
				}
				break;
			}
		}
	}
	
	public static void trace(PrintStream out) {
		sOut = out;
	}
	
	public static boolean isTracing() {
		return sOut != null;
	}
	
	public static void log(String x) {
		if(isTracing()) {
			long millis = System.currentTimeMillis();
			x = "millis:" + millis + "," + x;
			sOut.println(x);
		}
	}
	
	public static abstract class  ProxyListener {
		
		protected void notify(EchoNode node) {
			if(Echo.isTracing()) {
				String method = Thread.currentThread().getStackTrace()[2].getMethodName();
				Echo.log("method:"+method+",address:"+node.getAddress().getHostAddress());
			}
		}
		protected void notify(EchoObject eoj) {
			if(Echo.isTracing()) {
				String method = Thread.currentThread().getStackTrace()[2].getMethodName();
				Echo.log("method:"+method+","+eoj.toString());
			}
		}
		public void onNewNode(EchoNode node) {
			notify(node);
		}
		
		public void onNewProfileObject(ProfileObject profile) {
			notify(profile);
		}
		
		public void onNewNodeProfile(NodeProfileProxy profile) {
			notify(profile);
		}
		
		public void onNewDevice(DeviceObject device) {
			notify(device);
		}
		
		public void onNewActivityAmountSensor(ActivityAmountSensorProxy device) {
			notify(device);
		}

		public void onNewAirPollutionSensor(AirPollutionSensorProxy device) {
			notify(device);
		}

		public void onNewAirSpeedSensor(AirSpeedSensorProxy device) {
			notify(device);
		}

		public void onNewBathHeatingStatusSensor(BathHeatingStatusSensorProxy device) {
			notify(device);
		}

		public void onNewBathWaterLevelSensor(BathWaterLevelSensorProxy device) {
			notify(device);
		}

		public void onNewBedPresenceSensor(BedPresenceSensorProxy device) {
			notify(device);
		}

		public void onNewCallSensor(CallSensorProxy device) {
			notify(device);
		}

		public void onNewCigaretteSmokeSensor(CigaretteSmokeSensorProxy device) {
			notify(device);
		}

		public void onNewCO2Sensor(CO2SensorProxy device) {
			notify(device);
		}

		public void onNewCondensationSensor(CondensationSensorProxy device) {
			notify(device);
		}

		public void onNewCrimePreventionSensor(CrimePreventionSensorProxy device) {
			notify(device);
		}

		public void onNewCurrentValueSensor(CurrentValueSensorProxy device) {
			notify(device);
		}

		public void onNewDifferentialPressureSensor(DifferentialPressureSensorProxy device) {
			notify(device);
		}

		public void onNewEarthquakeSensor(EarthquakeSensorProxy device) {
			notify(device);
		}

		public void onNewElectricEnergySensor(ElectricEnergySensorProxy device) {
			notify(device);
		}

		public void onNewElectricLeakSensor(ElectricLeakSensorProxy device) {
			notify(device);
		}

		public void onNewEmergencyButton(EmergencyButtonProxy device) {
			notify(device);
		}

		public void onNewFireSensor(FireSensorProxy device) {
			notify(device);
		}

		public void onNewFirstAidSensor(FirstAidSensorProxy device) {
			notify(device);
		}

		public void onNewFlameSensor(FlameSensorProxy device) {
			notify(device);
		}

		public void onNewGasLeakSensor(GasLeakSensorProxy device) {
			notify(device);
		}

		public void onNewGasSensor(GasSensorProxy device) {
			notify(device);
		}

		public void onNewHumanBodyLocationSensor(HumanBodyLocationSensorProxy device) {
			notify(device);
		}

		public void onNewHumanDetectionSensor(HumanDetectionSensorProxy device) {
			notify(device);
		}

		public void onNewHumiditySensor(HumiditySensorProxy device) {
			notify(device);
		}

		public void onNewIlluminanceSensor(IlluminanceSensorProxy device) {
			notify(device);
		}

		public void onNewMailingSensor(MailingSensorProxy device) {
			notify(device);
		}

		public void onNewMicromotionSensor(MicromotionSensorProxy device) {
			notify(device);
		}

		public void onNewOdorSensor(OdorSensorProxy device) {
			notify(device);
		}

		public void onNewOpenCloseSensor(OpenCloseSensorProxy device) {
			notify(device);
		}

		public void onNewOxygenSensor(OxygenSensorProxy device) {
			notify(device);
		}

		public void onNewPassageSensor(PassageSensorProxy device) {
			notify(device);
		}

		public void onNewRainSensor(RainSensorProxy device) {
			notify(device);
		}

		public void onNewSnowSensor(SnowSensorProxy device) {
			notify(device);
		}

		public void onNewSoundSensor(SoundSensorProxy device) {
			notify(device);
		}

		public void onNewTemperatureSensor(TemperatureSensorProxy device) {
			notify(device);
		}

		public void onNewVisitorSensor(VisitorSensorProxy device) {
			notify(device);
		}

		public void onNewVOCSensor(VOCSensorProxy device) {
			notify(device);
		}

		public void onNewWaterFlowRateSensor(WaterFlowRateSensorProxy device) {
			notify(device);
		}

		public void onNewWaterLeakSensor(WaterLeakSensorProxy device) {
			notify(device);
		}

		public void onNewWaterLevelSensor(WaterLevelSensorProxy device) {
			notify(device);
		}

		public void onNewWaterOverflowSensor(WaterOverflowSensorProxy device) {
			notify(device);
		}

		public void onNewWeightSensor(WeightSensorProxy device) {
			notify(device);
		}

		public void onNewAirCleaner(AirCleanerProxy device) {
			notify(device);
		}

		public void onNewAirConditionerVentilationFan(AirConditionerVentilationFanProxy device) {
			notify(device);
		}

		public void onNewElectricHeater(ElectricHeaterProxy device) {
			notify(device);
		}

		public void onNewFanHeater(FanHeaterProxy device) {
			notify(device);
		}

		public void onNewHomeAirConditioner(HomeAirConditionerProxy device) {
			notify(device);
		}

		public void onNewHumidifier(HumidifierProxy device) {
			notify(device);
		}

		public void onNewPackageTypeCommercialAirConditionerIndoorUnit(PackageTypeCommercialAirConditionerIndoorUnitProxy device) {
			notify(device);
		}

		public void onNewPackageTypeCommercialAirConditionerOutdoorUnit(PackageTypeCommercialAirConditionerOutdoorUnitProxy device) {
			notify(device);
		}

		public void onNewVentilationFan(VentilationFanProxy device) {
			notify(device);
		}

		public void onNewBathroomHeaterAndDryer(BathroomHeaterAndDryerProxy device) {
			notify(device);
		}

		public void onNewBattery(BatteryProxy device) {
			notify(device);
		}

		public void onNewBuzzer(BuzzerProxy device) {
			notify(device);
		}

		public void onNewColdOrHotWaterHeatSourceEquipment(ColdOrHotWaterHeatSourceEquipmentProxy device) {
			notify(device);
		}

		public void onNewElectricallyOperatedShade(ElectricallyOperatedShadeProxy device) {
			notify(device);
		}

		public void onNewElectricLock(ElectricLockProxy device) {
			notify(device);
		}

		public void onNewElectricShutter(ElectricShutterProxy device) {
			notify(device);
		}

		public void onNewElectricStormWindow(ElectricStormWindowProxy device) {
			notify(device);
		}

		public void onNewElectricToiletSeat(ElectricToiletSeatProxy device) {
			notify(device);
		}

		public void onNewElectricWaterHeater(ElectricWaterHeaterProxy device) {
			notify(device);
		}

		public void onNewFloorHeater(FloorHeaterProxy device) {
			notify(device);
		}

		public void onNewFuelCell(FuelCellProxy device) {
			notify(device);
		}

		public void onNewGasMeter(GasMeterProxy device) {
			notify(device);
		}

		public void onNewGeneralLighting(GeneralLightingProxy device) {
			notify(device);
		}

		public void onNewHouseholdSolarPowerGeneration(HouseholdSolarPowerGenerationProxy device) {
			notify(device);
		}

		public void onNewInstantaneousWaterHeater(InstantaneousWaterHeaterProxy device) {
			notify(device);
		}

		public void onNewLPGasMeter(LPGasMeterProxy device) {
			notify(device);
		}

		public void onNewPowerDistributionBoardMetering(PowerDistributionBoardMeteringProxy device) {
			notify(device);
		}

		public void onNewSmartElectricEnergyMeter(SmartElectricEnergyMeterProxy device) {
			notify(device);
		}

		public void onNewSmartGasMeter(SmartGasMeterProxy device) {
			notify(device);
		}

		public void onNewSprinkler(SprinklerProxy device) {
			notify(device);
		}

		public void onNewWaterFlowmeter(WaterFlowmeterProxy device) {
			notify(device);
		}

		public void onNewWattHourMeter(WattHourMeterProxy device) {
			notify(device);
		}

		public void onNewClothesDryer(ClothesDryerProxy device) {
			notify(device);
		}

		public void onNewCombinationMicrowaveOven(CombinationMicrowaveOvenProxy device) {
			notify(device);
		}

		public void onNewCookingHeater(CookingHeaterProxy device) {
			notify(device);
		}

		public void onNewElectricHotWaterPot(ElectricHotWaterPotProxy device) {
			notify(device);
		}

		public void onNewRefrigerator(RefrigeratorProxy device) {
			notify(device);
		}

		public void onNewRiceCooker(RiceCookerProxy device) {
			notify(device);
		}

		public void onNewWasherAndDryer(WasherAndDryerProxy device) {
			notify(device);
		}

		public void onNewWashingMachine(WashingMachineProxy device) {
			notify(device);
		}

		public void onNewWeighing(WeighingProxy device) {
			notify(device);
		}

		public void onNewController(ControllerProxy device) {
			notify(device);
		}

		public void onNewSwitch(SwitchProxy device) {
			notify(device);
		}

		public void onNewDisplay(DisplayProxy device) {
			notify(device);
		}

		public void onNewTelevision(TelevisionProxy device) {
			notify(device);
		}


	}
}
