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

import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.eoj.device.airconditioner.AirCleaner;
import com.sonycsl.echo.eoj.device.airconditioner.AirConditionerVentilationFan;
import com.sonycsl.echo.eoj.device.airconditioner.ElectricHeater;
import com.sonycsl.echo.eoj.device.airconditioner.FanHeater;
import com.sonycsl.echo.eoj.device.airconditioner.HomeAirConditioner;
import com.sonycsl.echo.eoj.device.airconditioner.Humidifier;
import com.sonycsl.echo.eoj.device.airconditioner.PackageTypeCommercialAirConditionerIndoorUnit;
import com.sonycsl.echo.eoj.device.airconditioner.PackageTypeCommercialAirConditionerOutdoorUnit;
import com.sonycsl.echo.eoj.device.airconditioner.VentilationFan;
import com.sonycsl.echo.eoj.device.audiovisual.Display;
import com.sonycsl.echo.eoj.device.audiovisual.Television;
import com.sonycsl.echo.eoj.device.cookinghousehold.ClothesDryer;
import com.sonycsl.echo.eoj.device.cookinghousehold.CombinationMicrowaveOven;
import com.sonycsl.echo.eoj.device.cookinghousehold.CookingHeater;
import com.sonycsl.echo.eoj.device.cookinghousehold.ElectricHotWaterPot;
import com.sonycsl.echo.eoj.device.cookinghousehold.Refrigerator;
import com.sonycsl.echo.eoj.device.cookinghousehold.RiceCooker;
import com.sonycsl.echo.eoj.device.cookinghousehold.WasherAndDryer;
import com.sonycsl.echo.eoj.device.cookinghousehold.WashingMachine;
import com.sonycsl.echo.eoj.device.health.Weighing;
import com.sonycsl.echo.eoj.device.housingfacilities.BathroomHeaterAndDryer;
import com.sonycsl.echo.eoj.device.housingfacilities.Battery;
import com.sonycsl.echo.eoj.device.housingfacilities.Buzzer;
import com.sonycsl.echo.eoj.device.housingfacilities.ColdOrHotWaterHeatSourceEquipment;
import com.sonycsl.echo.eoj.device.housingfacilities.ElectricLock;
import com.sonycsl.echo.eoj.device.housingfacilities.ElectricShutter;
import com.sonycsl.echo.eoj.device.housingfacilities.ElectricStormWindow;
import com.sonycsl.echo.eoj.device.housingfacilities.ElectricToiletSeat;
import com.sonycsl.echo.eoj.device.housingfacilities.ElectricVehicle;
import com.sonycsl.echo.eoj.device.housingfacilities.ElectricWaterHeater;
import com.sonycsl.echo.eoj.device.housingfacilities.ElectricallyOperatedShade;
import com.sonycsl.echo.eoj.device.housingfacilities.EngineCogeneration;
import com.sonycsl.echo.eoj.device.housingfacilities.FloorHeater;
import com.sonycsl.echo.eoj.device.housingfacilities.FuelCell;
import com.sonycsl.echo.eoj.device.housingfacilities.GasMeter;
import com.sonycsl.echo.eoj.device.housingfacilities.GeneralLighting;
import com.sonycsl.echo.eoj.device.housingfacilities.HouseholdSolarPowerGeneration;
import com.sonycsl.echo.eoj.device.housingfacilities.InstantaneousWaterHeater;
import com.sonycsl.echo.eoj.device.housingfacilities.LPGasMeter;
import com.sonycsl.echo.eoj.device.housingfacilities.PowerDistributionBoardMetering;
import com.sonycsl.echo.eoj.device.housingfacilities.SmartElectricEnergyMeter;
import com.sonycsl.echo.eoj.device.housingfacilities.SmartGasMeter;
import com.sonycsl.echo.eoj.device.housingfacilities.Sprinkler;
import com.sonycsl.echo.eoj.device.housingfacilities.WaterFlowmeter;
import com.sonycsl.echo.eoj.device.housingfacilities.WattHourMeter;
import com.sonycsl.echo.eoj.device.managementoperation.Controller;
import com.sonycsl.echo.eoj.device.managementoperation.Switch;
import com.sonycsl.echo.eoj.device.sensor.ActivityAmountSensor;
import com.sonycsl.echo.eoj.device.sensor.AirPollutionSensor;
import com.sonycsl.echo.eoj.device.sensor.AirSpeedSensor;
import com.sonycsl.echo.eoj.device.sensor.BathHeatingStatusSensor;
import com.sonycsl.echo.eoj.device.sensor.BathWaterLevelSensor;
import com.sonycsl.echo.eoj.device.sensor.BedPresenceSensor;
import com.sonycsl.echo.eoj.device.sensor.CO2Sensor;
import com.sonycsl.echo.eoj.device.sensor.CallSensor;
import com.sonycsl.echo.eoj.device.sensor.CigaretteSmokeSensor;
import com.sonycsl.echo.eoj.device.sensor.CondensationSensor;
import com.sonycsl.echo.eoj.device.sensor.CrimePreventionSensor;
import com.sonycsl.echo.eoj.device.sensor.CurrentValueSensor;
import com.sonycsl.echo.eoj.device.sensor.DifferentialPressureSensor;
import com.sonycsl.echo.eoj.device.sensor.EarthquakeSensor;
import com.sonycsl.echo.eoj.device.sensor.ElectricEnergySensor;
import com.sonycsl.echo.eoj.device.sensor.ElectricLeakSensor;
import com.sonycsl.echo.eoj.device.sensor.EmergencyButton;
import com.sonycsl.echo.eoj.device.sensor.FireSensor;
import com.sonycsl.echo.eoj.device.sensor.FirstAidSensor;
import com.sonycsl.echo.eoj.device.sensor.FlameSensor;
import com.sonycsl.echo.eoj.device.sensor.GasLeakSensor;
import com.sonycsl.echo.eoj.device.sensor.GasSensor;
import com.sonycsl.echo.eoj.device.sensor.HumanBodyLocationSensor;
import com.sonycsl.echo.eoj.device.sensor.HumanDetectionSensor;
import com.sonycsl.echo.eoj.device.sensor.HumiditySensor;
import com.sonycsl.echo.eoj.device.sensor.IlluminanceSensor;
import com.sonycsl.echo.eoj.device.sensor.MailingSensor;
import com.sonycsl.echo.eoj.device.sensor.MicromotionSensor;
import com.sonycsl.echo.eoj.device.sensor.OdorSensor;
import com.sonycsl.echo.eoj.device.sensor.OpenCloseSensor;
import com.sonycsl.echo.eoj.device.sensor.OxygenSensor;
import com.sonycsl.echo.eoj.device.sensor.PassageSensor;
import com.sonycsl.echo.eoj.device.sensor.RainSensor;
import com.sonycsl.echo.eoj.device.sensor.SnowSensor;
import com.sonycsl.echo.eoj.device.sensor.SoundSensor;
import com.sonycsl.echo.eoj.device.sensor.TemperatureSensor;
import com.sonycsl.echo.eoj.device.sensor.VOCSensor;
import com.sonycsl.echo.eoj.device.sensor.VisitorSensor;
import com.sonycsl.echo.eoj.device.sensor.WaterFlowRateSensor;
import com.sonycsl.echo.eoj.device.sensor.WaterLeakSensor;
import com.sonycsl.echo.eoj.device.sensor.WaterLevelSensor;
import com.sonycsl.echo.eoj.device.sensor.WaterOverflowSensor;
import com.sonycsl.echo.eoj.device.sensor.WeightSensor;
import com.sonycsl.echo.eoj.profile.NodeProfile;
import com.sonycsl.echo.eoj.profile.ProfileObject;
import com.sonycsl.echo.node.EchoNode;

import java.io.IOException;
import java.io.PrintStream;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Echo {

    private static volatile EchoNode sSelfNode;
    private static Map<String, EchoNode> sOtherNodes;

    private static Events sEvents = null;
    private static ArrayList<EventListener> sListeners;

    private volatile static boolean sStarted = false;
    private volatile static boolean sCleared = true;

    static {
        sOtherNodes = new ConcurrentHashMap<String, EchoNode>();
        sListeners = new ArrayList<EventListener>();
        sEvents = new Events();
    }

    private Echo() {
    }

    public synchronized static EchoNode start(NodeProfile profile, DeviceObject[] devices,
            NetworkInterface nwif) throws IOException {
        if (sStarted)
            return null;
        if (!sCleared)
            return null;

        sStarted = true;
        sCleared = false;

        sSelfNode = new EchoNode(profile, devices);
        profile.setNode(sSelfNode);
        for (DeviceObject dev : devices) {
            dev.setNode(sSelfNode);
        }
        EchoSocket.openSocket(nwif);

        return postOpenSocket(devices);
    }

    public synchronized static EchoNode start(NodeProfile profile, DeviceObject[] devices)
            throws IOException {
        if (sStarted)
            return null;
        if (!sCleared)
            return null;

        sStarted = true;
        sCleared = false;

        sSelfNode = new EchoNode(profile, devices);
        profile.setNode(sSelfNode);
        for (DeviceObject dev : devices) {
            dev.setNode(sSelfNode);
        }
        EchoSocket.openSocket();

        return postOpenSocket(devices);
    }

    private static EchoNode postOpenSocket(DeviceObject[] devices) throws IOException {
        // Echo.getEventListener().onNewNode(sSelfNode);
        sSelfNode.onNew();
        // Echo.getEventListener().onFoundNode(sSelfNode);
        sSelfNode.onFound();
        sSelfNode.getNodeProfile().onNew();
        sSelfNode.getNodeProfile().onFound();

        for (DeviceObject dev : devices) {
            dev.onNew();
            dev.onFound();
        }

        sSelfNode.getNodeProfile().inform().reqInformInstanceListNotification().send();
        return sSelfNode;
    }

    public synchronized static void restart() throws IOException {
        if (sCleared)
            return;
        sStarted = true;
        EchoSocket.openSocket();
        sSelfNode.getNodeProfile().inform().reqInformInstanceListNotification().send();
    }

    public synchronized static void stop() throws IOException {
        System.err.println("Echo stop");
        EchoSocket.closeSocket();
        sStarted = false;
        System.err.println("Echo closed");
        // sNodes.clear();
    }

    public synchronized static void clear() throws IOException {
        stop();
        sCleared = true;

        sSelfNode = null;

        sOtherNodes.clear();
        sListeners.clear();
    }

    public static boolean isStarted() {
        return sStarted;
    }

    // remain for back compatibility.
    @Deprecated
    public static EchoNode getNode() {
        return getSelfNode();
    }

    public static EchoNode getSelfNode() {
        return sSelfNode;
    }

    public static EchoNode[] getNodes() {
        Collection<EchoNode> nodes = sOtherNodes.values();
        List<EchoNode> ret = new ArrayList<EchoNode>();
        if (sSelfNode != null) {
            ret.add(sSelfNode);
        }
        for (EchoNode n : nodes) {
            ret.add(n);
        }
        return ret.toArray(new EchoNode[] {});
    }

    public static EchoNode getNode(String address) {
        if (EchoSocket.SELF_ADDRESS.equals(address)) {
            return sSelfNode;
        }
        return sOtherNodes.get(address);
    }

    public synchronized static EchoNode addOtherNode(String address) {
        EchoNode node = new EchoNode(address);
        node.getNodeProfile().setNode(node);
        sOtherNodes.put(address, node);

        return node;
    }

    public static void removeOtherNode(String address) {
        sOtherNodes.remove(address);
    }

    // public static void removeAllNode() {
    // sNodes.clear();
    // }

    /*
     * public synchronized static EchoNode[] getActiveNodes() {
     * Collection<EchoNode> nodes = sOtherNodes.values(); List<EchoNode> ret =
     * new ArrayList<EchoNode>(); if(sSelfNode != null && sSelfNode.isActive()){
     * ret.add(sSelfNode); } for(EchoNode n : nodes) { if(n.isActive())
     * ret.add(n); } return ret.toArray(new EchoNode[]{}); }
     */

    // @Deprecated
    // public static EchoObject getInstance(InetAddress address, byte
    // classGroupCode, byte classCode, byte instanceCode) {
    // return getInstance(address, EchoUtils.getEchoClassCode(classGroupCode,
    // classCode), instanceCode);
    // }
    //
    // @Deprecated
    // public static EchoObject getInstance(InetAddress address, int
    // objectCode){
    // return getInstance(address,
    // EchoUtils.getEchoClassCodeFromObjectCode(objectCode),
    // EchoUtils.getInstanceCodeFromObjectCode(objectCode));
    // }
    //
    // @Deprecated
    // public static EchoObject getInstance(InetAddress address, short
    // echoClassCode, byte instanceCode) {
    //
    // if(sCleared) {
    // return null;
    // }
    // if(address == null) {
    // return null;
    // }
    // if(address.equals(sSelfNode.getAddressStr())) {
    // if(!sSelfNode.containsInstance(echoClassCode, instanceCode)) return null;
    // return sSelfNode.getInstance(echoClassCode, instanceCode);
    // } else if(sOtherNodes.containsKey(address)) {
    // EchoNode node = sOtherNodes.get(address);
    // if(!node.containsInstance(echoClassCode, instanceCode)) return null;
    // return node.getInstance(echoClassCode, instanceCode);
    // } else {
    // return null;
    // }
    // }
    /*
     * public synchronized static void updateNodeInstance(InetAddress address,
     * byte classGroupCode, byte classCode, byte instanceCode) { if(sCleared) {
     * return; } if(address == null) { return; }
     * if(address.equals(sSelfNode.getAddress())) {
     * //if(sLocalNode.containsInstance(classGroupCode, classCode,
     * instanceCode)) return;
     * //sLocalNode.addDevice(EchoUtils.getEchoClassCode(classGroupCode,
     * classCode), instanceCode); if(sSelfNode.containsInstance(classGroupCode,
     * classCode, instanceCode)) { sSelfNode.getInstance(classGroupCode,
     * classCode, instanceCode).setActive(true); return; } } else
     * if(sOtherNodes.containsKey(address)) { EchoNode node =
     * sOtherNodes.get(address); if(node.containsInstance(classGroupCode,
     * classCode, instanceCode)){ node.getInstance(classGroupCode, classCode,
     * instanceCode).setActive(true); return; } else {
     * node.addDevice(EchoUtils.getEchoClassCode(classGroupCode, classCode),
     * instanceCode); } } else { if(NodeProfile.ECHO_CLASS_CODE ==
     * EchoUtils.getEchoClassCode(classGroupCode, classCode) &&
     * NodeProfile.INSTANCE_CODE == instanceCode) { new EchoNode(address, new
     * ArrayList<Integer>()); } else { ArrayList<Integer> list = new
     * ArrayList<Integer>();
     * list.add(EchoUtils.getEchoObjectCode(classGroupCode, classCode,
     * instanceCode)); new EchoNode(address, list); } } }
     */
    // public synchronized static void updateNodeDevices(InetAddress address,
    // List<Integer> echoObjectCodeList) {
    // if(echoObjectCodeList == null) return;
    /*
     * if(sLocalNode.getAddress().equals(address)) {
     * //sLocalNode.updateDevices(echoObjectCodeList); return; }else
     * if(sNodes.containsKey(address)) { EchoNode node = sNodes.get(address);
     * node.updateDevices(echoObjectCodeList); } else { new EchoNode(address,
     * echoObjectCodeList); }
     */
    /*
     * if(sCleared) { return; } if(address == null) { return; }
     * if(!address.equals(sSelfNode.getAddress()) &&
     * !sOtherNodes.containsKey(address)) { new EchoNode(address,
     * echoObjectCodeList); return; } for(int objCode: echoObjectCodeList) {
     * byte[] a = EchoUtils.toByteArray(objCode, 4); updateNodeInstance(address,
     * a[1],a[2],a[3]); } if(!sOtherNodes.containsKey(address)) return;
     * for(DeviceObject dev : sOtherNodes.get(address).getDevices()) { boolean
     * active = false; for(int code : echoObjectCodeList) { if(code ==
     * dev.getEchoObjectCode()) { active = true; break; } }
     * dev.setActive(active); } }
     */

    public static void addEventListener(EventListener listener) {
        sListeners.add(listener);
    }

    public static EventListener getEventListener() {
        return sEvents;
    }

    public static class EventListener {
        public void setProperty(EchoObject eoj, EchoProperty property, boolean success) {
        }

        public void getProperty(EchoObject eoj, EchoProperty property) {
        }

        public void isValidProperty(EchoObject eoj, EchoProperty property, boolean valid) {
        }

        public void onSetProperty(EchoObject eoj, short tid, byte esv, EchoProperty property,
                boolean success) {
        }

        public void onGetProperty(EchoObject eoj, short tid, byte esv, EchoProperty property,
                boolean success) {
        }

        public void onInformProperty(EchoObject eoj, short tid, byte esv, EchoProperty property) {
        }

        public void reqSetPropertyEvent(EchoObject eoj, EchoProperty property) {
        }

        public void reqGetPropertyEvent(EchoObject eoj, EchoProperty property) {
        }

        public void reqInformPropertyEvent(EchoObject eoj, EchoProperty property) {
        }

        public void reqInformCPropertyEvent(EchoObject eoj, EchoProperty property) {
        }

        public void sendEvent(EchoFrame frame) {
        }

        public void receiveEvent(EchoFrame frame) {
        }

        public void onCatchException(Exception e) {
        }

        public void onFoundNode(EchoNode node) {
        }

        public void onFoundEchoObject(EchoObject eoj) {
        }

        public void onNewNode(EchoNode node) {
        }

        public void onNewEchoObject(EchoObject eoj) {
        }

        public void onNewProfileObject(ProfileObject profile) {
        }

        public void onNewNodeProfile(NodeProfile profile) {
        }

        public void onNewDeviceObject(DeviceObject device) {
        }

        public void onNewActivityAmountSensor(ActivityAmountSensor device) {
        }

        public void onNewAirPollutionSensor(AirPollutionSensor device) {
        }

        public void onNewAirSpeedSensor(AirSpeedSensor device) {
        }

        public void onNewBathHeatingStatusSensor(BathHeatingStatusSensor device) {
        }

        public void onNewBathWaterLevelSensor(BathWaterLevelSensor device) {
        }

        public void onNewBedPresenceSensor(BedPresenceSensor device) {
        }

        public void onNewCallSensor(CallSensor device) {
        }

        public void onNewCigaretteSmokeSensor(CigaretteSmokeSensor device) {
        }

        public void onNewCO2Sensor(CO2Sensor device) {
        }

        public void onNewCondensationSensor(CondensationSensor device) {
        }

        public void onNewCrimePreventionSensor(CrimePreventionSensor device) {
        }

        public void onNewCurrentValueSensor(CurrentValueSensor device) {
        }

        public void onNewDifferentialPressureSensor(DifferentialPressureSensor device) {
        }

        public void onNewEarthquakeSensor(EarthquakeSensor device) {
        }

        public void onNewElectricEnergySensor(ElectricEnergySensor device) {
        }

        public void onNewElectricLeakSensor(ElectricLeakSensor device) {
        }

        public void onNewEmergencyButton(EmergencyButton device) {
        }

        public void onNewFireSensor(FireSensor device) {
        }

        public void onNewFirstAidSensor(FirstAidSensor device) {
        }

        public void onNewFlameSensor(FlameSensor device) {
        }

        public void onNewGasLeakSensor(GasLeakSensor device) {
        }

        public void onNewGasSensor(GasSensor device) {
        }

        public void onNewHumanBodyLocationSensor(HumanBodyLocationSensor device) {
        }

        public void onNewHumanDetectionSensor(HumanDetectionSensor device) {
        }

        public void onNewHumiditySensor(HumiditySensor device) {
        }

        public void onNewIlluminanceSensor(IlluminanceSensor device) {
        }

        public void onNewMailingSensor(MailingSensor device) {
        }

        public void onNewMicromotionSensor(MicromotionSensor device) {
        }

        public void onNewOdorSensor(OdorSensor device) {
        }

        public void onNewOpenCloseSensor(OpenCloseSensor device) {
        }

        public void onNewOxygenSensor(OxygenSensor device) {
        }

        public void onNewPassageSensor(PassageSensor device) {
        }

        public void onNewRainSensor(RainSensor device) {
        }

        public void onNewSnowSensor(SnowSensor device) {
        }

        public void onNewSoundSensor(SoundSensor device) {
        }

        public void onNewTemperatureSensor(TemperatureSensor device) {
        }

        public void onNewVisitorSensor(VisitorSensor device) {
        }

        public void onNewVOCSensor(VOCSensor device) {
        }

        public void onNewWaterFlowRateSensor(WaterFlowRateSensor device) {
        }

        public void onNewWaterLeakSensor(WaterLeakSensor device) {
        }

        public void onNewWaterLevelSensor(WaterLevelSensor device) {
        }

        public void onNewWaterOverflowSensor(WaterOverflowSensor device) {
        }

        public void onNewWeightSensor(WeightSensor device) {
        }

        public void onNewAirCleaner(AirCleaner device) {
        }

        public void onNewAirConditionerVentilationFan(AirConditionerVentilationFan device) {
        }

        public void onNewElectricHeater(ElectricHeater device) {
        }

        public void onNewFanHeater(FanHeater device) {
        }

        public void onNewHomeAirConditioner(HomeAirConditioner device) {
        }

        public void onNewHumidifier(Humidifier device) {
        }

        public void onNewPackageTypeCommercialAirConditionerIndoorUnit(
                PackageTypeCommercialAirConditionerIndoorUnit device) {
        }

        public void onNewPackageTypeCommercialAirConditionerOutdoorUnit(
                PackageTypeCommercialAirConditionerOutdoorUnit device) {
        }

        public void onNewVentilationFan(VentilationFan device) {
        }

        public void onNewBathroomHeaterAndDryer(BathroomHeaterAndDryer device) {
        }

        public void onNewBattery(Battery device) {
        }

        public void onNewBuzzer(Buzzer device) {
        }

        public void onNewColdOrHotWaterHeatSourceEquipment(ColdOrHotWaterHeatSourceEquipment device) {
        }

        public void onNewElectricallyOperatedShade(ElectricallyOperatedShade device) {
        }

        public void onNewElectricLock(ElectricLock device) {
        }

        public void onNewElectricShutter(ElectricShutter device) {
        }

        public void onNewElectricStormWindow(ElectricStormWindow device) {
        }

        public void onNewElectricToiletSeat(ElectricToiletSeat device) {
        }

        public void onNewElectricVehicle(ElectricVehicle device) {
        }

        public void onNewElectricWaterHeater(ElectricWaterHeater device) {
        }

        public void onNewEngineCogeneration(EngineCogeneration device) {
        }

        public void onNewFloorHeater(FloorHeater device) {
        }

        public void onNewFuelCell(FuelCell device) {
        }

        public void onNewGasMeter(GasMeter device) {
        }

        public void onNewGeneralLighting(GeneralLighting device) {
        }

        public void onNewHouseholdSolarPowerGeneration(HouseholdSolarPowerGeneration device) {
        }

        public void onNewInstantaneousWaterHeater(InstantaneousWaterHeater device) {
        }

        public void onNewLPGasMeter(LPGasMeter device) {
        }

        public void onNewPowerDistributionBoardMetering(PowerDistributionBoardMetering device) {
        }

        public void onNewSmartElectricEnergyMeter(SmartElectricEnergyMeter device) {
        }

        public void onNewSmartGasMeter(SmartGasMeter device) {
        }

        public void onNewSprinkler(Sprinkler device) {
        }

        public void onNewWaterFlowmeter(WaterFlowmeter device) {
        }

        public void onNewWattHourMeter(WattHourMeter device) {
        }

        public void onNewClothesDryer(ClothesDryer device) {
        }

        public void onNewCombinationMicrowaveOven(CombinationMicrowaveOven device) {
        }

        public void onNewCookingHeater(CookingHeater device) {
        }

        public void onNewElectricHotWaterPot(ElectricHotWaterPot device) {
        }

        public void onNewRefrigerator(Refrigerator device) {
        }

        public void onNewRiceCooker(RiceCooker device) {
        }

        public void onNewWasherAndDryer(WasherAndDryer device) {
        }

        public void onNewWashingMachine(WashingMachine device) {
        }

        public void onNewWeighing(Weighing device) {
        }

        public void onNewController(Controller device) {
        }

        public void onNewSwitch(Switch device) {
        }

        public void onNewDisplay(Display device) {
        }

        public void onNewTelevision(Television device) {
        }
    }

    public static class Logger extends EventListener {
        PrintStream mOut;

        public Logger(PrintStream out) {
            mOut = out;
        }

        @Override
        public void setProperty(EchoObject eoj, EchoProperty property,
                boolean success) {
            long millis = System.currentTimeMillis();
            mOut.println("millis:" + millis
                    + ",method:set," + eoj.toString()
                    + ",epc:" + EchoUtils.toHexString(property.epc)
                    + ",pdc:" + EchoUtils.toHexString(property.pdc)
                    + ",edt:" + EchoUtils.toHexString(property.edt)
                    + ",success:" + success);
        }

        @Override
        public void getProperty(EchoObject eoj, EchoProperty property) {
            long millis = System.currentTimeMillis();
            mOut.println("millis:" + millis
                    + ",method:get," + eoj.toString()
                    + ",epc:" + EchoUtils.toHexString(property.epc)
                    + ",pdc:" + EchoUtils.toHexString(property.pdc)
                    + ",edt:" + EchoUtils.toHexString(property.edt));
        }

        @Override
        public void isValidProperty(EchoObject eoj, EchoProperty property,
                boolean valid) {
            // TODO Auto-generated method stub
            super.isValidProperty(eoj, property, valid);
        }

        @Override
        public void onSetProperty(EchoObject eoj, short tid, byte esv,
                EchoProperty property, boolean success) {
            long millis = System.currentTimeMillis();
            mOut.println("millis:" + millis
                    + ",method:onSet," + eoj.toString()
                    + ",tid:" + EchoUtils.toHexString(tid)
                    + ",esv:" + EchoUtils.toHexString(esv)
                    + ",epc:" + EchoUtils.toHexString(property.epc)
                    + ",pdc:" + EchoUtils.toHexString(property.pdc)
                    + ",edt:" + EchoUtils.toHexString(property.edt)
                    + ",success:" + success);
        }

        @Override
        public void onGetProperty(EchoObject eoj, short tid, byte esv,
                EchoProperty property, boolean success) {
            long millis = System.currentTimeMillis();
            mOut.println("millis:" + millis
                    + ",method:onGet," + eoj.toString()
                    + ",tid:" + EchoUtils.toHexString(tid)
                    + ",esv:" + EchoUtils.toHexString(esv)
                    + ",epc:" + EchoUtils.toHexString(property.epc)
                    + ",pdc:" + EchoUtils.toHexString(property.pdc)
                    + ",edt:" + EchoUtils.toHexString(property.edt));

        }

        @Override
        public void onInformProperty(EchoObject eoj, short tid, byte esv,
                EchoProperty property) {
            long millis = System.currentTimeMillis();
            mOut.println("millis:" + millis
                    + ",method:onInform," + eoj.toString()
                    + ",tid:" + EchoUtils.toHexString(tid)
                    + ",esv:" + EchoUtils.toHexString(esv)
                    + ",epc:" + EchoUtils.toHexString(property.epc));
        }

        @Override
        public void reqSetPropertyEvent(EchoObject eoj, EchoProperty property) {
            long millis = System.currentTimeMillis();
            mOut.println("millis:" + millis
                    + ",method:reqSet," + eoj.toString()
                    + ",epc:" + EchoUtils.toHexString(property.epc)
                    + ",pdc:" + EchoUtils.toHexString(property.pdc)
                    + ",edt:" + EchoUtils.toHexString(property.edt));
        }

        @Override
        public void reqGetPropertyEvent(EchoObject eoj, EchoProperty property) {
            long millis = System.currentTimeMillis();
            mOut.println("millis:" + millis
                    + ",method:reqGet," + eoj.toString()
                    + ",epc:" + EchoUtils.toHexString(property.epc)
                    + ",pdc:" + EchoUtils.toHexString(property.pdc)
                    + ",edt:" + EchoUtils.toHexString(property.edt));
        }

        @Override
        public void reqInformPropertyEvent(EchoObject eoj, EchoProperty property) {
            long millis = System.currentTimeMillis();
            mOut.println("millis:" + millis
                    + ",method:reqInform," + eoj.toString()
                    + ",epc:" + EchoUtils.toHexString(property.epc)
                    + ",pdc:" + EchoUtils.toHexString(property.pdc)
                    + ",edt:" + EchoUtils.toHexString(property.edt));
        }

        @Override
        public void reqInformCPropertyEvent(EchoObject eoj,
                EchoProperty property) {
            long millis = System.currentTimeMillis();
            mOut.println("millis:" + millis
                    + ",method:reqInformC," + eoj.toString()
                    + ",epc:" + EchoUtils.toHexString(property.epc)
                    + ",pdc:" + EchoUtils.toHexString(property.pdc)
                    + ",edt:" + EchoUtils.toHexString(property.edt));
        }

        @Override
        public void sendEvent(EchoFrame frame) {
            long millis = System.currentTimeMillis();
            mOut.println("millis:" + millis
                    + ",method:send,tid:" + EchoUtils.toHexString(frame.getTID())
                    + ",esv:" + EchoUtils.toHexString(frame.getESV())
                    + ",seoj:[class:" + String.format("%04x", frame.getSrcEchoClassCode())
                    + ",instance:" + String.format("%02x", frame.getSrcEchoInstanceCode())
                    + "],deoj:[class:" + String.format("%04x", frame.getDstEchoClassCode())
                    + ",instance:" + String.format("%02x", frame.getDstEchoInstanceCode())
                    + "],data:" + EchoUtils.toHexString(frame.getFrameByteArray()));
        }

        @Override
        public void receiveEvent(EchoFrame frame) {
            long millis = System.currentTimeMillis();
            mOut.println("millis:" + millis
                    + ",method:receive,tid:" + EchoUtils.toHexString(frame.getTID())
                    + ",esv:" + EchoUtils.toHexString(frame.getESV())
                    + ",seoj:[class:" + String.format("%04x", frame.getSrcEchoClassCode())
                    + ",instance:" + String.format("%02x", frame.getSrcEchoInstanceCode())
                    + "],deoj:[class:" + String.format("%04x", frame.getDstEchoClassCode())
                    + ",instance:" + String.format("%02x", frame.getDstEchoInstanceCode())
                    + "],data:" + EchoUtils.toHexString(frame.getFrameByteArray()));
        }

        @Override
        public void onCatchException(Exception e) {
            // TODO Auto-generated method stub
            super.onCatchException(e);
        }

        @Override
        public void onNewNode(EchoNode node) {
            long millis = System.currentTimeMillis();
            mOut.println("millis:" + millis
                    + ",method:new,type:node,address:"
                    + node.getAddressStr());
        }

        @Override
        public void onNewEchoObject(EchoObject eoj) {
            long millis = System.currentTimeMillis();
            mOut.println("millis:" + millis
                    + ",method:new,type:eoj,"
                    + eoj.toString());
        }

    }

    private static class Events extends EventListener {

        @Override
        public void setProperty(EchoObject eoj, EchoProperty property,
                boolean success) {
            super.setProperty(eoj, property, success);
            for (EventListener listener : sListeners) {
                listener.setProperty(eoj, property, success);
            }
        }

        @Override
        public void getProperty(EchoObject eoj, EchoProperty property) {
            for (EventListener listener : sListeners) {
                listener.getProperty(eoj, property);
            }
        }

        @Override
        public void isValidProperty(EchoObject eoj, EchoProperty property,
                boolean valid) {
            for (EventListener listener : sListeners) {
                listener.isValidProperty(eoj, property, valid);
            }
        }

        @Override
        public void onSetProperty(EchoObject eoj, short tid, byte esv,
                EchoProperty property, boolean success) {
            for (EventListener listener : sListeners) {
                listener.onSetProperty(eoj, tid, esv, property, success);
            }
        }

        @Override
        public void onGetProperty(EchoObject eoj, short tid, byte esv,
                EchoProperty property, boolean success) {
            for (EventListener listener : sListeners) {
                listener.onGetProperty(eoj, tid, esv, property, success);
            }
        }

        @Override
        public void onInformProperty(EchoObject eoj, short tid, byte esv,
                EchoProperty property) {
            for (EventListener listener : sListeners) {
                listener.onInformProperty(eoj, tid, esv, property);
            }
        }

        @Override
        public void reqSetPropertyEvent(EchoObject eoj, EchoProperty property) {
            for (EventListener listener : sListeners) {
                listener.reqSetPropertyEvent(eoj, property);
            }
        }

        @Override
        public void reqGetPropertyEvent(EchoObject eoj, EchoProperty property) {
            for (EventListener listener : sListeners) {
                listener.reqGetPropertyEvent(eoj, property);
            }
        }

        @Override
        public void reqInformPropertyEvent(EchoObject eoj, EchoProperty property) {
            for (EventListener listener : sListeners) {
                listener.reqInformPropertyEvent(eoj, property);
            }
        }

        @Override
        public void reqInformCPropertyEvent(EchoObject eoj,
                EchoProperty property) {
            for (EventListener listener : sListeners) {
                listener.reqInformCPropertyEvent(eoj, property);
            }
        }

        @Override
        public void sendEvent(EchoFrame frame) {
            for (EventListener listener : sListeners) {
                listener.sendEvent(frame);
            }
        }

        @Override
        public void receiveEvent(EchoFrame frame) {
            for (EventListener listener : sListeners) {
                listener.receiveEvent(frame);
            }
        }

        @Override
        public void onCatchException(Exception e) {
            for (EventListener listener : sListeners) {
                listener.onCatchException(e);
            }
        }

        @Override
        public void onFoundNode(EchoNode node) {
            for (EventListener listener : sListeners) {
                listener.onFoundNode(node);
            }
        }

        @Override
        public void onFoundEchoObject(EchoObject eoj) {
            for (EventListener listener : sListeners) {
                listener.onFoundEchoObject(eoj);
            }
        }

        @Override
        public void onNewNode(EchoNode node) {
            for (EventListener listener : sListeners) {
                listener.onNewNode(node);
            }
        }

        @Override
        public void onNewEchoObject(EchoObject eoj) {
            for (EventListener listener : sListeners) {
                listener.onNewEchoObject(eoj);
            }
        }

        @Override
        public void onNewProfileObject(ProfileObject profile) {
            for (EventListener listener : sListeners) {
                listener.onNewProfileObject(profile);
            }
        }

        @Override
        public void onNewNodeProfile(NodeProfile profile) {
            for (EventListener listener : sListeners) {
                listener.onNewNodeProfile(profile);
            }
        }

        @Override
        public void onNewDeviceObject(DeviceObject device) {
            for (EventListener listener : sListeners) {
                listener.onNewDeviceObject(device);
            }
        }

        @Override
        public void onNewActivityAmountSensor(ActivityAmountSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewActivityAmountSensor(device);
            }
        }

        @Override
        public void onNewAirPollutionSensor(AirPollutionSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewAirPollutionSensor(device);
            }
        }

        @Override
        public void onNewAirSpeedSensor(AirSpeedSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewAirSpeedSensor(device);
            }
        }

        @Override
        public void onNewBathHeatingStatusSensor(BathHeatingStatusSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewBathHeatingStatusSensor(device);
            }
        }

        @Override
        public void onNewBathWaterLevelSensor(BathWaterLevelSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewBathWaterLevelSensor(device);
            }
        }

        @Override
        public void onNewBedPresenceSensor(BedPresenceSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewBedPresenceSensor(device);
            }
        }

        @Override
        public void onNewCallSensor(CallSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewCallSensor(device);
            }
        }

        @Override
        public void onNewCigaretteSmokeSensor(CigaretteSmokeSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewCigaretteSmokeSensor(device);
            }
        }

        @Override
        public void onNewCO2Sensor(CO2Sensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewCO2Sensor(device);
            }
        }

        @Override
        public void onNewCondensationSensor(CondensationSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewCondensationSensor(device);
            }
        }

        @Override
        public void onNewCrimePreventionSensor(CrimePreventionSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewCrimePreventionSensor(device);
            }
        }

        @Override
        public void onNewCurrentValueSensor(CurrentValueSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewCurrentValueSensor(device);
            }
        }

        @Override
        public void onNewDifferentialPressureSensor(
                DifferentialPressureSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewDifferentialPressureSensor(device);
            }
        }

        @Override
        public void onNewEarthquakeSensor(EarthquakeSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewEarthquakeSensor(device);
            }
        }

        @Override
        public void onNewElectricEnergySensor(ElectricEnergySensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewElectricEnergySensor(device);
            }
        }

        @Override
        public void onNewElectricLeakSensor(ElectricLeakSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewElectricLeakSensor(device);
            }
        }

        @Override
        public void onNewEmergencyButton(EmergencyButton device) {
            for (EventListener listener : sListeners) {
                listener.onNewEmergencyButton(device);
            }
        }

        @Override
        public void onNewFireSensor(FireSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewFireSensor(device);
            }
        }

        @Override
        public void onNewFirstAidSensor(FirstAidSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewFirstAidSensor(device);
            }
        }

        @Override
        public void onNewFlameSensor(FlameSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewFlameSensor(device);
            }
        }

        @Override
        public void onNewGasLeakSensor(GasLeakSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewGasLeakSensor(device);
            }
        }

        @Override
        public void onNewGasSensor(GasSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewGasSensor(device);
            }
        }

        @Override
        public void onNewHumanBodyLocationSensor(HumanBodyLocationSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewHumanBodyLocationSensor(device);
            }
        }

        @Override
        public void onNewHumanDetectionSensor(HumanDetectionSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewHumanDetectionSensor(device);
            }
        }

        @Override
        public void onNewHumiditySensor(HumiditySensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewHumiditySensor(device);
            }
        }

        @Override
        public void onNewIlluminanceSensor(IlluminanceSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewIlluminanceSensor(device);
            }
        }

        @Override
        public void onNewMailingSensor(MailingSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewMailingSensor(device);
            }
        }

        @Override
        public void onNewMicromotionSensor(MicromotionSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewMicromotionSensor(device);
            }
        }

        @Override
        public void onNewOdorSensor(OdorSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewOdorSensor(device);
            }
        }

        @Override
        public void onNewOpenCloseSensor(OpenCloseSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewOpenCloseSensor(device);
            }
        }

        @Override
        public void onNewOxygenSensor(OxygenSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewOxygenSensor(device);
            }
        }

        @Override
        public void onNewPassageSensor(PassageSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewPassageSensor(device);
            }
        }

        @Override
        public void onNewRainSensor(RainSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewRainSensor(device);
            }
        }

        @Override
        public void onNewSnowSensor(SnowSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewSnowSensor(device);
            }
        }

        @Override
        public void onNewSoundSensor(SoundSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewSoundSensor(device);
            }
        }

        @Override
        public void onNewTemperatureSensor(TemperatureSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewTemperatureSensor(device);
            }
        }

        @Override
        public void onNewVisitorSensor(VisitorSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewVisitorSensor(device);
            }
        }

        @Override
        public void onNewVOCSensor(VOCSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewVOCSensor(device);
            }
        }

        @Override
        public void onNewWaterFlowRateSensor(WaterFlowRateSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewWaterFlowRateSensor(device);
            }
        }

        @Override
        public void onNewWaterLeakSensor(WaterLeakSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewWaterLeakSensor(device);
            }
        }

        @Override
        public void onNewWaterLevelSensor(WaterLevelSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewWaterLevelSensor(device);
            }
        }

        @Override
        public void onNewWaterOverflowSensor(WaterOverflowSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewWaterOverflowSensor(device);
            }
        }

        @Override
        public void onNewWeightSensor(WeightSensor device) {
            for (EventListener listener : sListeners) {
                listener.onNewWeightSensor(device);
            }
        }

        @Override
        public void onNewAirCleaner(AirCleaner device) {
            for (EventListener listener : sListeners) {
                listener.onNewAirCleaner(device);
            }
        }

        @Override
        public void onNewAirConditionerVentilationFan(
                AirConditionerVentilationFan device) {
            for (EventListener listener : sListeners) {
                listener.onNewAirConditionerVentilationFan(device);
            }
        }

        @Override
        public void onNewElectricHeater(ElectricHeater device) {
            for (EventListener listener : sListeners) {
                listener.onNewElectricHeater(device);
            }
        }

        @Override
        public void onNewFanHeater(FanHeater device) {
            for (EventListener listener : sListeners) {
                listener.onNewFanHeater(device);
            }
        }

        @Override
        public void onNewHomeAirConditioner(HomeAirConditioner device) {
            for (EventListener listener : sListeners) {
                listener.onNewHomeAirConditioner(device);
            }
        }

        @Override
        public void onNewHumidifier(Humidifier device) {
            for (EventListener listener : sListeners) {
                listener.onNewHumidifier(device);
            }
        }

        @Override
        public void onNewPackageTypeCommercialAirConditionerIndoorUnit(
                PackageTypeCommercialAirConditionerIndoorUnit device) {
            for (EventListener listener : sListeners) {
                listener.onNewPackageTypeCommercialAirConditionerIndoorUnit(device);
            }
        }

        @Override
        public void onNewPackageTypeCommercialAirConditionerOutdoorUnit(
                PackageTypeCommercialAirConditionerOutdoorUnit device) {
            for (EventListener listener : sListeners) {
                listener.onNewPackageTypeCommercialAirConditionerOutdoorUnit(device);
            }
        }

        @Override
        public void onNewVentilationFan(VentilationFan device) {
            for (EventListener listener : sListeners) {
                listener.onNewVentilationFan(device);
            }
        }

        @Override
        public void onNewBathroomHeaterAndDryer(BathroomHeaterAndDryer device) {
            for (EventListener listener : sListeners) {
                listener.onNewBathroomHeaterAndDryer(device);
            }
        }

        @Override
        public void onNewBattery(Battery device) {
            for (EventListener listener : sListeners) {
                listener.onNewBattery(device);
            }
        }

        @Override
        public void onNewBuzzer(Buzzer device) {
            for (EventListener listener : sListeners) {
                listener.onNewBuzzer(device);
            }
        }

        @Override
        public void onNewColdOrHotWaterHeatSourceEquipment(
                ColdOrHotWaterHeatSourceEquipment device) {
            for (EventListener listener : sListeners) {
                listener.onNewColdOrHotWaterHeatSourceEquipment(device);
            }
        }

        @Override
        public void onNewElectricallyOperatedShade(
                ElectricallyOperatedShade device) {
            for (EventListener listener : sListeners) {
                listener.onNewElectricallyOperatedShade(device);
            }
        }

        @Override
        public void onNewElectricLock(ElectricLock device) {
            for (EventListener listener : sListeners) {
                listener.onNewElectricLock(device);
            }
        }

        @Override
        public void onNewElectricShutter(ElectricShutter device) {
            for (EventListener listener : sListeners) {
                listener.onNewElectricShutter(device);
            }
        }

        @Override
        public void onNewElectricStormWindow(ElectricStormWindow device) {
            for (EventListener listener : sListeners) {
                listener.onNewElectricStormWindow(device);
            }
        }

        @Override
        public void onNewElectricToiletSeat(ElectricToiletSeat device) {
            for (EventListener listener : sListeners) {
                listener.onNewElectricToiletSeat(device);
            }
        }

        @Override
        public void onNewElectricVehicle(ElectricVehicle device) {
            for (EventListener listener : sListeners) {
                listener.onNewElectricVehicle(device);
            }
        }

        @Override
        public void onNewElectricWaterHeater(ElectricWaterHeater device) {
            for (EventListener listener : sListeners) {
                listener.onNewElectricWaterHeater(device);
            }
        }

        @Override
        public void onNewEngineCogeneration(EngineCogeneration device) {
            for (EventListener listener : sListeners) {
                listener.onNewEngineCogeneration(device);
            }
        }

        @Override
        public void onNewFloorHeater(FloorHeater device) {
            for (EventListener listener : sListeners) {
                listener.onNewFloorHeater(device);
            }
        }

        @Override
        public void onNewFuelCell(FuelCell device) {
            for (EventListener listener : sListeners) {
                listener.onNewFuelCell(device);
            }
        }

        @Override
        public void onNewGasMeter(GasMeter device) {
            for (EventListener listener : sListeners) {
                listener.onNewGasMeter(device);
            }
        }

        @Override
        public void onNewGeneralLighting(GeneralLighting device) {
            for (EventListener listener : sListeners) {
                listener.onNewGeneralLighting(device);
            }
        }

        @Override
        public void onNewHouseholdSolarPowerGeneration(
                HouseholdSolarPowerGeneration device) {
            for (EventListener listener : sListeners) {
                listener.onNewHouseholdSolarPowerGeneration(device);
            }
        }

        @Override
        public void onNewInstantaneousWaterHeater(
                InstantaneousWaterHeater device) {
            for (EventListener listener : sListeners) {
                listener.onNewInstantaneousWaterHeater(device);
            }
        }

        @Override
        public void onNewLPGasMeter(LPGasMeter device) {
            for (EventListener listener : sListeners) {
                listener.onNewLPGasMeter(device);
            }
        }

        @Override
        public void onNewPowerDistributionBoardMetering(
                PowerDistributionBoardMetering device) {
            for (EventListener listener : sListeners) {
                listener.onNewPowerDistributionBoardMetering(device);
            }
        }

        @Override
        public void onNewSmartElectricEnergyMeter(
                SmartElectricEnergyMeter device) {
            for (EventListener listener : sListeners) {
                listener.onNewSmartElectricEnergyMeter(device);
            }
        }

        @Override
        public void onNewSmartGasMeter(SmartGasMeter device) {
            for (EventListener listener : sListeners) {
                listener.onNewSmartGasMeter(device);
            }
        }

        @Override
        public void onNewSprinkler(Sprinkler device) {
            for (EventListener listener : sListeners) {
                listener.onNewSprinkler(device);
            }
        }

        @Override
        public void onNewWaterFlowmeter(WaterFlowmeter device) {
            for (EventListener listener : sListeners) {
                listener.onNewWaterFlowmeter(device);
            }
        }

        @Override
        public void onNewWattHourMeter(WattHourMeter device) {
            for (EventListener listener : sListeners) {
                listener.onNewWattHourMeter(device);
            }
        }

        @Override
        public void onNewClothesDryer(ClothesDryer device) {
            for (EventListener listener : sListeners) {
                listener.onNewClothesDryer(device);
            }
        }

        @Override
        public void onNewCombinationMicrowaveOven(
                CombinationMicrowaveOven device) {
            for (EventListener listener : sListeners) {
                listener.onNewCombinationMicrowaveOven(device);
            }
        }

        @Override
        public void onNewCookingHeater(CookingHeater device) {
            for (EventListener listener : sListeners) {
                listener.onNewCookingHeater(device);
            }
        }

        @Override
        public void onNewElectricHotWaterPot(ElectricHotWaterPot device) {
            for (EventListener listener : sListeners) {
                listener.onNewElectricHotWaterPot(device);
            }
        }

        @Override
        public void onNewRefrigerator(Refrigerator device) {
            for (EventListener listener : sListeners) {
                listener.onNewRefrigerator(device);
            }
        }

        @Override
        public void onNewRiceCooker(RiceCooker device) {
            for (EventListener listener : sListeners) {
                listener.onNewRiceCooker(device);
            }
        }

        @Override
        public void onNewWasherAndDryer(WasherAndDryer device) {
            for (EventListener listener : sListeners) {
                listener.onNewWasherAndDryer(device);
            }
        }

        @Override
        public void onNewWashingMachine(WashingMachine device) {
            for (EventListener listener : sListeners) {
                listener.onNewWashingMachine(device);
            }
        }

        @Override
        public void onNewWeighing(Weighing device) {
            for (EventListener listener : sListeners) {
                listener.onNewWeighing(device);
            }
        }

        @Override
        public void onNewController(Controller device) {
            for (EventListener listener : sListeners) {
                listener.onNewController(device);
            }
        }

        @Override
        public void onNewSwitch(Switch device) {
            for (EventListener listener : sListeners) {
                listener.onNewSwitch(device);
            }
        }

        @Override
        public void onNewDisplay(Display device) {
            for (EventListener listener : sListeners) {
                listener.onNewDisplay(device);
            }
        }

        @Override
        public void onNewTelevision(Television device) {
            for (EventListener listener : sListeners) {
                listener.onNewTelevision(device);
            }
        }

    }
}
