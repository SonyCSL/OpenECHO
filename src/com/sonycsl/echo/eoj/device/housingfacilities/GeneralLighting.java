package com.sonycsl.echo.eoj.device.housingfacilities;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class GeneralLighting extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0290;

	public static final byte EPC_ILLUMINANCE_LEVEL = (byte)0xB0;
	public static final byte EPC_LIGHT_COLOR_SETTING = (byte)0xB1;
	public static final byte EPC_ILLUMINANCE_LEVEL_STEP_SETTING = (byte)0xB2;
	public static final byte EPC_LIGHT_COLOR_STEP_SETTING = (byte)0xB3;
	public static final byte EPC_MAXIMUM_SPECIFIABLE_VALUES = (byte)0xB4;
	public static final byte EPC_MAXIMUM_VALUE_OF_SETTABLE_LEVEL_FOR_NIGHT_LIGHTING = (byte)0xB5;
	public static final byte EPC_LIGHTING_MODE_SETTING = (byte)0xB6;
	public static final byte EPC_ILLUMINANCE_LEVEL_SETTING_FOR_MAIN_LIGHTING = (byte)0xB7;
	public static final byte EPC_ILLUMINANCE_LEVEL_STEP_SETTING_FOR_MAIN_LIGHTING = (byte)0xB8;
	public static final byte EPC_ILLUMINANCE_LEVEL_SETTING_FOR_NIGHT_LIGHTING = (byte)0xB9;
	public static final byte EPC_ILLUMINANCE_LEVEL_STEP_SETTING_FOR_NIGHT_LIGHTING = (byte)0xBA;
	public static final byte EPC_LIGHT_COLOR_SETTING_FOR_MAIN_LIGHTING = (byte)0xBB;
	public static final byte EPC_LIGHT_COLOR_LEVEL_STEP_SETTING_FOR_MAIN_LIGHTING = (byte)0xBC;
	public static final byte EPC_LIGHT_COLOR_SETTING_FOR_NIGHT_LIGHTING = (byte)0xBD;
	public static final byte EPC_LIGHT_COLOR_LEVEL_STEP_SETTING_FOR_NIGHT_LIGHTING = (byte)0xBE;
	public static final byte EPC_LIGHTING_MODE_STATUS_IN_AUTO_MODE = (byte)0xBF;
	public static final byte EPC_RGB_SETTING_FOR_COLOR_LIGHTING = (byte)0xC0;
	public static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_ON_TIMER_SETTING = (byte)0x91;
	public static final byte EPC_OFF_TIMER_RESERVATION_SETTING = (byte)0x94;
	public static final byte EPC_OFF_TIMER_SETTING = (byte)0x95;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		addSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addSetProperty(EPC_LIGHTING_MODE_SETTING);
		addGetProperty(EPC_LIGHTING_MODE_SETTING);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewGeneralLighting(this);
	}
	
	@Override
	public short getEchoClassCode() {
		return ECHO_CLASS_CODE;
	}

	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ON/OFF status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract boolean setOperationStatus(byte[] edt);
	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ON/OFF status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getOperationStatus();
	/**
	 * Property name : Illuminance level<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates illuminance level in %.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setIlluminanceLevel(byte[] edt) {return false;}
	/**
	 * Property name : Illuminance level<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates illuminance level in %.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getIlluminanceLevel() {return null;}
	/**
	 * Property name : Illuminance level<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates illuminance level in %.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidIlluminanceLevel(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Light color setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the color setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Incandescent lamp color = 0x41, white = 0x42, daylight white = 0x43, daylight color = 0x44, other = 0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setLightColorSetting(byte[] edt) {return false;}
	/**
	 * Property name : Light color setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the color setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Incandescent lamp color = 0x41, white = 0x42, daylight white = 0x43, daylight color = 0x44, other = 0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getLightColorSetting() {return null;}
	/**
	 * Property name : Light color setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the color setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Incandescent lamp color = 0x41, white = 0x42, daylight white = 0x43, daylight color = 0x44, other = 0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidLightColorSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Illuminance level step setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * From 0x01 to the maximum specifiable illuminance level value (from dark to bright)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setIlluminanceLevelStepSetting(byte[] edt) {return false;}
	/**
	 * Property name : Illuminance level step setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * From 0x01 to the maximum specifiable illuminance level value (from dark to bright)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getIlluminanceLevelStepSetting() {return null;}
	/**
	 * Property name : Illuminance level step setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * From 0x01 to the maximum specifiable illuminance level value (from dark to bright)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidIlluminanceLevelStepSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Light color step setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the light color in terms of steps and acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setLightColorStepSetting(byte[] edt) {return false;}
	/**
	 * Property name : Light color step setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the light color in terms of steps and acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getLightColorStepSetting() {return null;}
	/**
	 * Property name : Light color step setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the light color in terms of steps and acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidLightColorStepSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Maximum specifiable values<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the maximum specifiable illuminance level value and the maximum specifiable light color value.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * First byte: illuminance  Second byte: light color 0x01.0xFF (Step 1.Step 255)<br>
	 * 0x00 (when the function is not implemented)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMaximumSpecifiableValues() {return null;}
	/**
	 * Property name : Maximum specifiable values<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the maximum specifiable illuminance level value and the maximum specifiable light color value.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * First byte: illuminance  Second byte: light color 0x01.0xFF (Step 1.Step 255)<br>
	 * 0x00 (when the function is not implemented)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMaximumSpecifiableValues(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Maximum value of settable level for night lighting
<br>
	 * <br>
	 * EPC : 0xB5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the maximum values of illuminance and light color settable levels for night lighting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * First byte: illuminance<br>
	 * Second byte: light color<br>
	 * 0x01–0xFF (Step 1–Step 255)<br>
	 * 0x00 (when the function is not implemented)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMaximumValueOfSettableLevelForNightLighting() {return null;}
	/**
	 * Property name : Maximum value of settable level for night lighting
<br>
	 * <br>
	 * EPC : 0xB5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the maximum values of illuminance and light color settable levels for night lighting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * First byte: illuminance<br>
	 * Second byte: light color<br>
	 * 0x01–0xFF (Step 1–Step 255)<br>
	 * 0x00 (when the function is not implemented)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMaximumValueOfSettableLevelForNightLighting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Lighting mode setting<br>
	 * <br>
	 * EPC : 0xB6<br>
	 * <br>
	 * Contents of property :<br>
	 * Auto/main lighting/night lighting/color lighting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Auto=0x41, main lighting=0x42,<br>
	 * night lighting=0x43, color lighting=0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract boolean setLightingModeSetting(byte[] edt);
	/**
	 * Property name : Lighting mode setting<br>
	 * <br>
	 * EPC : 0xB6<br>
	 * <br>
	 * Contents of property :<br>
	 * Auto/main lighting/night lighting/color lighting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Auto=0x41, main lighting=0x42,<br>
	 * night lighting=0x43, color lighting=0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getLightingModeSetting();
	/**
	 * Property name : Lighting mode setting<br>
	 * <br>
	 * EPC : 0xB6<br>
	 * <br>
	 * Contents of property :<br>
	 * Auto/main lighting/night lighting/color lighting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Auto=0x41, main lighting=0x42,<br>
	 * night lighting=0x43, color lighting=0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidLightingModeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Illuminance level setting for main lighting<br>
	 * <br>
	 * EPC : 0xB7<br>
	 * <br>
	 * Contents of property :<br>
	 * Indicates the illuminance level of main lighting in %.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00–0x64(0–100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setIlluminanceLevelSettingForMainLighting(byte[] edt) {return false;}
	/**
	 * Property name : Illuminance level setting for main lighting<br>
	 * <br>
	 * EPC : 0xB7<br>
	 * <br>
	 * Contents of property :<br>
	 * Indicates the illuminance level of main lighting in %.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00–0x64(0–100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getIlluminanceLevelSettingForMainLighting() {return null;}
	/**
	 * Property name : Illuminance level setting for main lighting<br>
	 * <br>
	 * EPC : 0xB7<br>
	 * <br>
	 * Contents of property :<br>
	 * Indicates the illuminance level of main lighting in %.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00–0x64(0–100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidIlluminanceLevelSettingForMainLighting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Illuminance level step setting for main lighting<br>
	 * <br>
	 * EPC : 0xB8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the illuminance level by the number of steps for main lighting and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to the maximum value of settable illuminance level(dark to bright)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setIlluminanceLevelStepSettingForMainLighting(byte[] edt) {return false;}
	/**
	 * Property name : Illuminance level step setting for main lighting<br>
	 * <br>
	 * EPC : 0xB8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the illuminance level by the number of steps for main lighting and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to the maximum value of settable illuminance level(dark to bright)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getIlluminanceLevelStepSettingForMainLighting() {return null;}
	/**
	 * Property name : Illuminance level step setting for main lighting<br>
	 * <br>
	 * EPC : 0xB8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the illuminance level by the number of steps for main lighting and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to the maximum value of settable illuminance level(dark to bright)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidIlluminanceLevelStepSettingForMainLighting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Illuminance level setting for night lighting<br>
	 * <br>
	 * EPC : 0xB9<br>
	 * <br>
	 * Contents of property :<br>
	 * Indicates the illuminance level of night lighting in %.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00–0x64 (0–100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setIlluminanceLevelSettingForNightLighting(byte[] edt) {return false;}
	/**
	 * Property name : Illuminance level setting for night lighting<br>
	 * <br>
	 * EPC : 0xB9<br>
	 * <br>
	 * Contents of property :<br>
	 * Indicates the illuminance level of night lighting in %.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00–0x64 (0–100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getIlluminanceLevelSettingForNightLighting() {return null;}
	/**
	 * Property name : Illuminance level setting for night lighting<br>
	 * <br>
	 * EPC : 0xB9<br>
	 * <br>
	 * Contents of property :<br>
	 * Indicates the illuminance level of night lighting in %.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00–0x64 (0–100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidIlluminanceLevelSettingForNightLighting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Illuminance level step setting for night lighting<br>
	 * <br>
	 * EPC : 0xBA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the illuminance level by the number of steps for night lighting and to acquire the current setting status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to the maximum value of settable illuminance level (dark to bright)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setIlluminanceLevelStepSettingForNightLighting(byte[] edt) {return false;}
	/**
	 * Property name : Illuminance level step setting for night lighting<br>
	 * <br>
	 * EPC : 0xBA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the illuminance level by the number of steps for night lighting and to acquire the current setting status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to the maximum value of settable illuminance level (dark to bright)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getIlluminanceLevelStepSettingForNightLighting() {return null;}
	/**
	 * Property name : Illuminance level step setting for night lighting<br>
	 * <br>
	 * EPC : 0xBA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the illuminance level by the number of steps for night lighting and to acquire the current setting status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to the maximum value of settable illuminance level (dark to bright)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidIlluminanceLevelStepSettingForNightLighting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Light color setting for main lighting<br>
	 * <br>
	 * EPC : 0xBB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the light color for main lighting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Incandescent lamp color=0x41, white= 0x42, daylight white=0x43, daylight color= 0x44, other=0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setLightColorSettingForMainLighting(byte[] edt) {return false;}
	/**
	 * Property name : Light color setting for main lighting<br>
	 * <br>
	 * EPC : 0xBB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the light color for main lighting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Incandescent lamp color=0x41, white= 0x42, daylight white=0x43, daylight color= 0x44, other=0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getLightColorSettingForMainLighting() {return null;}
	/**
	 * Property name : Light color setting for main lighting<br>
	 * <br>
	 * EPC : 0xBB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the light color for main lighting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Incandescent lamp color=0x41, white= 0x42, daylight white=0x43, daylight color= 0x44, other=0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidLightColorSettingForMainLighting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Light color level step setting for main lighting<br>
	 * <br>
	 * EPC : 0xBC<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the light color level by the number of steps for main lighting and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01to the maximum value of settable light color level (incandescent lamp color to white)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setLightColorLevelStepSettingForMainLighting(byte[] edt) {return false;}
	/**
	 * Property name : Light color level step setting for main lighting<br>
	 * <br>
	 * EPC : 0xBC<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the light color level by the number of steps for main lighting and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01to the maximum value of settable light color level (incandescent lamp color to white)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getLightColorLevelStepSettingForMainLighting() {return null;}
	/**
	 * Property name : Light color level step setting for main lighting<br>
	 * <br>
	 * EPC : 0xBC<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the light color level by the number of steps for main lighting and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01to the maximum value of settable light color level (incandescent lamp color to white)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidLightColorLevelStepSettingForMainLighting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Light color setting for night lighting<br>
	 * <br>
	 * EPC : 0xBD<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the light color for night lighting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * incandescent lamp color=0x41, white=0x42, daylight white=0x43, daylight color=0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setLightColorSettingForNightLighting(byte[] edt) {return false;}
	/**
	 * Property name : Light color setting for night lighting<br>
	 * <br>
	 * EPC : 0xBD<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the light color for night lighting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * incandescent lamp color=0x41, white=0x42, daylight white=0x43, daylight color=0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getLightColorSettingForNightLighting() {return null;}
	/**
	 * Property name : Light color setting for night lighting<br>
	 * <br>
	 * EPC : 0xBD<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the light color for night lighting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * incandescent lamp color=0x41, white=0x42, daylight white=0x43, daylight color=0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidLightColorSettingForNightLighting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Light color level step setting for night lighting<br>
	 * <br>
	 * EPC : 0xBE<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the light color level by the number of steps for night lighting and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to the maximum value of settable light color level (incandescent lamp color to white)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setLightColorLevelStepSettingForNightLighting(byte[] edt) {return false;}
	/**
	 * Property name : Light color level step setting for night lighting<br>
	 * <br>
	 * EPC : 0xBE<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the light color level by the number of steps for night lighting and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to the maximum value of settable light color level (incandescent lamp color to white)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getLightColorLevelStepSettingForNightLighting() {return null;}
	/**
	 * Property name : Light color level step setting for night lighting<br>
	 * <br>
	 * EPC : 0xBE<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the light color level by the number of steps for night lighting and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to the maximum value of settable light color level (incandescent lamp color to white)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidLightColorLevelStepSettingForNightLighting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Lighting mode status in auto mode<br>
	 * <br>
	 * EPC : 0xBF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the current lighting mode in auto mode.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * main lighting=0x42, night lighting=0x43, off=0x44, color lighting=0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setLightingModeStatusInAutoMode(byte[] edt) {return false;}
	/**
	 * Property name : Lighting mode status in auto mode<br>
	 * <br>
	 * EPC : 0xBF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the current lighting mode in auto mode.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * main lighting=0x42, night lighting=0x43, off=0x44, color lighting=0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getLightingModeStatusInAutoMode() {return null;}
	/**
	 * Property name : Lighting mode status in auto mode<br>
	 * <br>
	 * EPC : 0xBF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the current lighting mode in auto mode.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * main lighting=0x42, night lighting=0x43, off=0x44, color lighting=0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidLightingModeStatusInAutoMode(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : RGB setting for color lighting<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the RGB value for color lighting and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Byte 1: R<br>
	 * Byte 2: G<br>
	 * Byte 3: B 0x00–0xFF (0–255)<br>
	 * Minimum brightness=0x00,maximum brightness=0xFF<br>
	 * <br>
	 * Data type : unsigned char×3<br>
	 * <br>
	 * Data size : 3 bytes<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setRgbSettingForColorLighting(byte[] edt) {return false;}
	/**
	 * Property name : RGB setting for color lighting<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the RGB value for color lighting and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Byte 1: R<br>
	 * Byte 2: G<br>
	 * Byte 3: B 0x00–0xFF (0–255)<br>
	 * Minimum brightness=0x00,maximum brightness=0xFF<br>
	 * <br>
	 * Data type : unsigned char×3<br>
	 * <br>
	 * Data size : 3 bytes<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getRgbSettingForColorLighting() {return null;}
	/**
	 * Property name : RGB setting for color lighting<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the RGB value for color lighting and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Byte 1: R<br>
	 * Byte 2: G<br>
	 * Byte 3: B 0x00–0xFF (0–255)<br>
	 * Minimum brightness=0x00,maximum brightness=0xFF<br>
	 * <br>
	 * Data type : unsigned char×3<br>
	 * <br>
	 * Data size : 3 bytes<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRgbSettingForColorLighting(byte[] edt) {
		if(edt == null || !(edt.length == 3)) return false;
		return true;
	}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON=0x41, Reservation OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON=0x41, Reservation OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON=0x41, Reservation OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOnTimerReservationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : ON timer setting<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (=0.23):(=0.59)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Property name : ON timer setting<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (=0.23):(=0.59)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOnTimerSetting() {return null;}
	/**
	 * Property name : ON timer setting<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (=0.23):(=0.59)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOnTimerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : OFF timer reservation setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON=0x41, Reservation OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOffTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Property name : OFF timer reservation setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON=0x41, Reservation OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOffTimerReservationSetting() {return null;}
	/**
	 * Property name : OFF timer reservation setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON=0x41, Reservation OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOffTimerReservationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : OFF timer setting<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (=0.23):(=0.59)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOffTimerSetting(byte[] edt) {return false;}
	/**
	 * Property name : OFF timer setting<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (=0.23):(=0.59)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOffTimerSetting() {return null;}
	/**
	 * Property name : OFF timer setting<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (=0.23):(=0.59)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOffTimerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_ILLUMINANCE_LEVEL : return setIlluminanceLevel(property.edt);
		case EPC_LIGHT_COLOR_SETTING : return setLightColorSetting(property.edt);
		case EPC_ILLUMINANCE_LEVEL_STEP_SETTING : return setIlluminanceLevelStepSetting(property.edt);
		case EPC_LIGHT_COLOR_STEP_SETTING : return setLightColorStepSetting(property.edt);
		case EPC_LIGHTING_MODE_SETTING : return setLightingModeSetting(property.edt);
		case EPC_ILLUMINANCE_LEVEL_SETTING_FOR_MAIN_LIGHTING : return setIlluminanceLevelSettingForMainLighting(property.edt);
		case EPC_ILLUMINANCE_LEVEL_STEP_SETTING_FOR_MAIN_LIGHTING : return setIlluminanceLevelStepSettingForMainLighting(property.edt);
		case EPC_ILLUMINANCE_LEVEL_SETTING_FOR_NIGHT_LIGHTING : return setIlluminanceLevelSettingForNightLighting(property.edt);
		case EPC_ILLUMINANCE_LEVEL_STEP_SETTING_FOR_NIGHT_LIGHTING : return setIlluminanceLevelStepSettingForNightLighting(property.edt);
		case EPC_LIGHT_COLOR_SETTING_FOR_MAIN_LIGHTING : return setLightColorSettingForMainLighting(property.edt);
		case EPC_LIGHT_COLOR_LEVEL_STEP_SETTING_FOR_MAIN_LIGHTING : return setLightColorLevelStepSettingForMainLighting(property.edt);
		case EPC_LIGHT_COLOR_SETTING_FOR_NIGHT_LIGHTING : return setLightColorSettingForNightLighting(property.edt);
		case EPC_LIGHT_COLOR_LEVEL_STEP_SETTING_FOR_NIGHT_LIGHTING : return setLightColorLevelStepSettingForNightLighting(property.edt);
		case EPC_LIGHTING_MODE_STATUS_IN_AUTO_MODE : return setLightingModeStatusInAutoMode(property.edt);
		case EPC_RGB_SETTING_FOR_COLOR_LIGHTING : return setRgbSettingForColorLighting(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return setOnTimerReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING : return setOnTimerSetting(property.edt);
		case EPC_OFF_TIMER_RESERVATION_SETTING : return setOffTimerReservationSetting(property.edt);
		case EPC_OFF_TIMER_SETTING : return setOffTimerSetting(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_ILLUMINANCE_LEVEL : return getIlluminanceLevel();
		case EPC_LIGHT_COLOR_SETTING : return getLightColorSetting();
		case EPC_ILLUMINANCE_LEVEL_STEP_SETTING : return getIlluminanceLevelStepSetting();
		case EPC_LIGHT_COLOR_STEP_SETTING : return getLightColorStepSetting();
		case EPC_MAXIMUM_SPECIFIABLE_VALUES : return getMaximumSpecifiableValues();
		case EPC_MAXIMUM_VALUE_OF_SETTABLE_LEVEL_FOR_NIGHT_LIGHTING : return getMaximumValueOfSettableLevelForNightLighting();
		case EPC_LIGHTING_MODE_SETTING : return getLightingModeSetting();
		case EPC_ILLUMINANCE_LEVEL_SETTING_FOR_MAIN_LIGHTING : return getIlluminanceLevelSettingForMainLighting();
		case EPC_ILLUMINANCE_LEVEL_STEP_SETTING_FOR_MAIN_LIGHTING : return getIlluminanceLevelStepSettingForMainLighting();
		case EPC_ILLUMINANCE_LEVEL_SETTING_FOR_NIGHT_LIGHTING : return getIlluminanceLevelSettingForNightLighting();
		case EPC_ILLUMINANCE_LEVEL_STEP_SETTING_FOR_NIGHT_LIGHTING : return getIlluminanceLevelStepSettingForNightLighting();
		case EPC_LIGHT_COLOR_SETTING_FOR_MAIN_LIGHTING : return getLightColorSettingForMainLighting();
		case EPC_LIGHT_COLOR_LEVEL_STEP_SETTING_FOR_MAIN_LIGHTING : return getLightColorLevelStepSettingForMainLighting();
		case EPC_LIGHT_COLOR_SETTING_FOR_NIGHT_LIGHTING : return getLightColorSettingForNightLighting();
		case EPC_LIGHT_COLOR_LEVEL_STEP_SETTING_FOR_NIGHT_LIGHTING : return getLightColorLevelStepSettingForNightLighting();
		case EPC_LIGHTING_MODE_STATUS_IN_AUTO_MODE : return getLightingModeStatusInAutoMode();
		case EPC_RGB_SETTING_FOR_COLOR_LIGHTING : return getRgbSettingForColorLighting();
		case EPC_ON_TIMER_RESERVATION_SETTING : return getOnTimerReservationSetting();
		case EPC_ON_TIMER_SETTING : return getOnTimerSetting();
		case EPC_OFF_TIMER_RESERVATION_SETTING : return getOffTimerReservationSetting();
		case EPC_OFF_TIMER_SETTING : return getOffTimerSetting();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_ILLUMINANCE_LEVEL : return isValidIlluminanceLevel(property.edt);
		case EPC_LIGHT_COLOR_SETTING : return isValidLightColorSetting(property.edt);
		case EPC_ILLUMINANCE_LEVEL_STEP_SETTING : return isValidIlluminanceLevelStepSetting(property.edt);
		case EPC_LIGHT_COLOR_STEP_SETTING : return isValidLightColorStepSetting(property.edt);
		case EPC_MAXIMUM_SPECIFIABLE_VALUES : return isValidMaximumSpecifiableValues(property.edt);
		case EPC_MAXIMUM_VALUE_OF_SETTABLE_LEVEL_FOR_NIGHT_LIGHTING : return isValidMaximumValueOfSettableLevelForNightLighting(property.edt);
		case EPC_LIGHTING_MODE_SETTING : return isValidLightingModeSetting(property.edt);
		case EPC_ILLUMINANCE_LEVEL_SETTING_FOR_MAIN_LIGHTING : return isValidIlluminanceLevelSettingForMainLighting(property.edt);
		case EPC_ILLUMINANCE_LEVEL_STEP_SETTING_FOR_MAIN_LIGHTING : return isValidIlluminanceLevelStepSettingForMainLighting(property.edt);
		case EPC_ILLUMINANCE_LEVEL_SETTING_FOR_NIGHT_LIGHTING : return isValidIlluminanceLevelSettingForNightLighting(property.edt);
		case EPC_ILLUMINANCE_LEVEL_STEP_SETTING_FOR_NIGHT_LIGHTING : return isValidIlluminanceLevelStepSettingForNightLighting(property.edt);
		case EPC_LIGHT_COLOR_SETTING_FOR_MAIN_LIGHTING : return isValidLightColorSettingForMainLighting(property.edt);
		case EPC_LIGHT_COLOR_LEVEL_STEP_SETTING_FOR_MAIN_LIGHTING : return isValidLightColorLevelStepSettingForMainLighting(property.edt);
		case EPC_LIGHT_COLOR_SETTING_FOR_NIGHT_LIGHTING : return isValidLightColorSettingForNightLighting(property.edt);
		case EPC_LIGHT_COLOR_LEVEL_STEP_SETTING_FOR_NIGHT_LIGHTING : return isValidLightColorLevelStepSettingForNightLighting(property.edt);
		case EPC_LIGHTING_MODE_STATUS_IN_AUTO_MODE : return isValidLightingModeStatusInAutoMode(property.edt);
		case EPC_RGB_SETTING_FOR_COLOR_LIGHTING : return isValidRgbSettingForColorLighting(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return isValidOnTimerReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING : return isValidOnTimerSetting(property.edt);
		case EPC_OFF_TIMER_RESERVATION_SETTING : return isValidOffTimerReservationSetting(property.edt);
		case EPC_OFF_TIMER_SETTING : return isValidOffTimerSetting(property.edt);
		default : return false;
		}
	}

	@Override
	public Setter set() {
		return set(true);
	}

	@Override
	public Setter set(boolean responseRequired) {
		return new Setter(getEchoClassCode(), getInstanceCode()
				, getNode().getAddressStr(), responseRequired);
	}

	@Override
	public Getter get() {
		return new Getter(getEchoClassCode(), getInstanceCode()
				, getNode().getAddressStr());
	}

	@Override
	public Informer inform() {
		return inform(isSelfObject());
	}

	@Override
	protected Informer inform(boolean multicast) {
		String address;
		if(multicast) {
			address = EchoSocket.MULTICAST_ADDRESS;
		} else {
			address = getNode().getAddressStr();
		}
		return new Informer(getEchoClassCode(), getInstanceCode()
				, address, isSelfObject());
	}
	
	public static class Receiver extends DeviceObject.Receiver {

		@Override
		protected boolean onSetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onSetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_ILLUMINANCE_LEVEL : 
				onSetIlluminanceLevel(eoj, tid, esv, property, success);
				return true;
			case EPC_LIGHT_COLOR_SETTING : 
				onSetLightColorSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ILLUMINANCE_LEVEL_STEP_SETTING : 
				onSetIlluminanceLevelStepSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_LIGHT_COLOR_STEP_SETTING : 
				onSetLightColorStepSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_LIGHTING_MODE_SETTING : 
				onSetLightingModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ILLUMINANCE_LEVEL_SETTING_FOR_MAIN_LIGHTING : 
				onSetIlluminanceLevelSettingForMainLighting(eoj, tid, esv, property, success);
				return true;
			case EPC_ILLUMINANCE_LEVEL_STEP_SETTING_FOR_MAIN_LIGHTING : 
				onSetIlluminanceLevelStepSettingForMainLighting(eoj, tid, esv, property, success);
				return true;
			case EPC_ILLUMINANCE_LEVEL_SETTING_FOR_NIGHT_LIGHTING : 
				onSetIlluminanceLevelSettingForNightLighting(eoj, tid, esv, property, success);
				return true;
			case EPC_ILLUMINANCE_LEVEL_STEP_SETTING_FOR_NIGHT_LIGHTING : 
				onSetIlluminanceLevelStepSettingForNightLighting(eoj, tid, esv, property, success);
				return true;
			case EPC_LIGHT_COLOR_SETTING_FOR_MAIN_LIGHTING : 
				onSetLightColorSettingForMainLighting(eoj, tid, esv, property, success);
				return true;
			case EPC_LIGHT_COLOR_LEVEL_STEP_SETTING_FOR_MAIN_LIGHTING : 
				onSetLightColorLevelStepSettingForMainLighting(eoj, tid, esv, property, success);
				return true;
			case EPC_LIGHT_COLOR_SETTING_FOR_NIGHT_LIGHTING : 
				onSetLightColorSettingForNightLighting(eoj, tid, esv, property, success);
				return true;
			case EPC_LIGHT_COLOR_LEVEL_STEP_SETTING_FOR_NIGHT_LIGHTING : 
				onSetLightColorLevelStepSettingForNightLighting(eoj, tid, esv, property, success);
				return true;
			case EPC_LIGHTING_MODE_STATUS_IN_AUTO_MODE : 
				onSetLightingModeStatusInAutoMode(eoj, tid, esv, property, success);
				return true;
			case EPC_RGB_SETTING_FOR_COLOR_LIGHTING : 
				onSetRgbSettingForColorLighting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onSetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING : 
				onSetOnTimerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_RESERVATION_SETTING : 
				onSetOffTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING : 
				onSetOffTimerSetting(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}

		@Override
		protected boolean onGetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onGetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_ILLUMINANCE_LEVEL : 
				onGetIlluminanceLevel(eoj, tid, esv, property, success);
				return true;
			case EPC_LIGHT_COLOR_SETTING : 
				onGetLightColorSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ILLUMINANCE_LEVEL_STEP_SETTING : 
				onGetIlluminanceLevelStepSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_LIGHT_COLOR_STEP_SETTING : 
				onGetLightColorStepSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MAXIMUM_SPECIFIABLE_VALUES : 
				onGetMaximumSpecifiableValues(eoj, tid, esv, property, success);
				return true;
			case EPC_MAXIMUM_VALUE_OF_SETTABLE_LEVEL_FOR_NIGHT_LIGHTING : 
				onGetMaximumValueOfSettableLevelForNightLighting(eoj, tid, esv, property, success);
				return true;
			case EPC_LIGHTING_MODE_SETTING : 
				onGetLightingModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ILLUMINANCE_LEVEL_SETTING_FOR_MAIN_LIGHTING : 
				onGetIlluminanceLevelSettingForMainLighting(eoj, tid, esv, property, success);
				return true;
			case EPC_ILLUMINANCE_LEVEL_STEP_SETTING_FOR_MAIN_LIGHTING : 
				onGetIlluminanceLevelStepSettingForMainLighting(eoj, tid, esv, property, success);
				return true;
			case EPC_ILLUMINANCE_LEVEL_SETTING_FOR_NIGHT_LIGHTING : 
				onGetIlluminanceLevelSettingForNightLighting(eoj, tid, esv, property, success);
				return true;
			case EPC_ILLUMINANCE_LEVEL_STEP_SETTING_FOR_NIGHT_LIGHTING : 
				onGetIlluminanceLevelStepSettingForNightLighting(eoj, tid, esv, property, success);
				return true;
			case EPC_LIGHT_COLOR_SETTING_FOR_MAIN_LIGHTING : 
				onGetLightColorSettingForMainLighting(eoj, tid, esv, property, success);
				return true;
			case EPC_LIGHT_COLOR_LEVEL_STEP_SETTING_FOR_MAIN_LIGHTING : 
				onGetLightColorLevelStepSettingForMainLighting(eoj, tid, esv, property, success);
				return true;
			case EPC_LIGHT_COLOR_SETTING_FOR_NIGHT_LIGHTING : 
				onGetLightColorSettingForNightLighting(eoj, tid, esv, property, success);
				return true;
			case EPC_LIGHT_COLOR_LEVEL_STEP_SETTING_FOR_NIGHT_LIGHTING : 
				onGetLightColorLevelStepSettingForNightLighting(eoj, tid, esv, property, success);
				return true;
			case EPC_LIGHTING_MODE_STATUS_IN_AUTO_MODE : 
				onGetLightingModeStatusInAutoMode(eoj, tid, esv, property, success);
				return true;
			case EPC_RGB_SETTING_FOR_COLOR_LIGHTING : 
				onGetRgbSettingForColorLighting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onGetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING : 
				onGetOnTimerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_RESERVATION_SETTING : 
				onGetOffTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING : 
				onGetOffTimerSetting(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Illuminance level<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates illuminance level in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetIlluminanceLevel(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Illuminance level<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates illuminance level in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetIlluminanceLevel(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Light color setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the color setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Incandescent lamp color = 0x41, white = 0x42, daylight white = 0x43, daylight color = 0x44, other = 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetLightColorSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Light color setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the color setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Incandescent lamp color = 0x41, white = 0x42, daylight white = 0x43, daylight color = 0x44, other = 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetLightColorSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Illuminance level step setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * From 0x01 to the maximum specifiable illuminance level value (from dark to bright)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetIlluminanceLevelStepSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Illuminance level step setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * From 0x01 to the maximum specifiable illuminance level value (from dark to bright)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetIlluminanceLevelStepSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Light color step setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the light color in terms of steps and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetLightColorStepSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Light color step setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the light color in terms of steps and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetLightColorStepSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Maximum specifiable values<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the maximum specifiable illuminance level value and the maximum specifiable light color value.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: illuminance  Second byte: light color 0x01.0xFF (Step 1.Step 255)<br>
		 * 0x00 (when the function is not implemented)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMaximumSpecifiableValues(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Maximum value of settable level for night lighting
<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the maximum values of illuminance and light color settable levels for night lighting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: illuminance<br>
		 * Second byte: light color<br>
		 * 0x01–0xFF (Step 1–Step 255)<br>
		 * 0x00 (when the function is not implemented)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMaximumValueOfSettableLevelForNightLighting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Lighting mode setting<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents of property :<br>
		 * Auto/main lighting/night lighting/color lighting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Auto=0x41, main lighting=0x42,<br>
		 * night lighting=0x43, color lighting=0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onSetLightingModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Lighting mode setting<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents of property :<br>
		 * Auto/main lighting/night lighting/color lighting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Auto=0x41, main lighting=0x42,<br>
		 * night lighting=0x43, color lighting=0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onGetLightingModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Illuminance level setting for main lighting<br>
		 * <br>
		 * EPC : 0xB7<br>
		 * <br>
		 * Contents of property :<br>
		 * Indicates the illuminance level of main lighting in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00–0x64(0–100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetIlluminanceLevelSettingForMainLighting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Illuminance level setting for main lighting<br>
		 * <br>
		 * EPC : 0xB7<br>
		 * <br>
		 * Contents of property :<br>
		 * Indicates the illuminance level of main lighting in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00–0x64(0–100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetIlluminanceLevelSettingForMainLighting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Illuminance level step setting for main lighting<br>
		 * <br>
		 * EPC : 0xB8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the illuminance level by the number of steps for main lighting and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to the maximum value of settable illuminance level(dark to bright)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetIlluminanceLevelStepSettingForMainLighting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Illuminance level step setting for main lighting<br>
		 * <br>
		 * EPC : 0xB8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the illuminance level by the number of steps for main lighting and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to the maximum value of settable illuminance level(dark to bright)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetIlluminanceLevelStepSettingForMainLighting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Illuminance level setting for night lighting<br>
		 * <br>
		 * EPC : 0xB9<br>
		 * <br>
		 * Contents of property :<br>
		 * Indicates the illuminance level of night lighting in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00–0x64 (0–100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetIlluminanceLevelSettingForNightLighting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Illuminance level setting for night lighting<br>
		 * <br>
		 * EPC : 0xB9<br>
		 * <br>
		 * Contents of property :<br>
		 * Indicates the illuminance level of night lighting in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00–0x64 (0–100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetIlluminanceLevelSettingForNightLighting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Illuminance level step setting for night lighting<br>
		 * <br>
		 * EPC : 0xBA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the illuminance level by the number of steps for night lighting and to acquire the current setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to the maximum value of settable illuminance level (dark to bright)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetIlluminanceLevelStepSettingForNightLighting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Illuminance level step setting for night lighting<br>
		 * <br>
		 * EPC : 0xBA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the illuminance level by the number of steps for night lighting and to acquire the current setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to the maximum value of settable illuminance level (dark to bright)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetIlluminanceLevelStepSettingForNightLighting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Light color setting for main lighting<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the light color for main lighting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Incandescent lamp color=0x41, white= 0x42, daylight white=0x43, daylight color= 0x44, other=0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetLightColorSettingForMainLighting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Light color setting for main lighting<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the light color for main lighting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Incandescent lamp color=0x41, white= 0x42, daylight white=0x43, daylight color= 0x44, other=0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetLightColorSettingForMainLighting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Light color level step setting for main lighting<br>
		 * <br>
		 * EPC : 0xBC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the light color level by the number of steps for main lighting and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01to the maximum value of settable light color level (incandescent lamp color to white)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetLightColorLevelStepSettingForMainLighting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Light color level step setting for main lighting<br>
		 * <br>
		 * EPC : 0xBC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the light color level by the number of steps for main lighting and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01to the maximum value of settable light color level (incandescent lamp color to white)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetLightColorLevelStepSettingForMainLighting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Light color setting for night lighting<br>
		 * <br>
		 * EPC : 0xBD<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the light color for night lighting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * incandescent lamp color=0x41, white=0x42, daylight white=0x43, daylight color=0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetLightColorSettingForNightLighting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Light color setting for night lighting<br>
		 * <br>
		 * EPC : 0xBD<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the light color for night lighting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * incandescent lamp color=0x41, white=0x42, daylight white=0x43, daylight color=0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetLightColorSettingForNightLighting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Light color level step setting for night lighting<br>
		 * <br>
		 * EPC : 0xBE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the light color level by the number of steps for night lighting and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to the maximum value of settable light color level (incandescent lamp color to white)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetLightColorLevelStepSettingForNightLighting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Light color level step setting for night lighting<br>
		 * <br>
		 * EPC : 0xBE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the light color level by the number of steps for night lighting and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to the maximum value of settable light color level (incandescent lamp color to white)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetLightColorLevelStepSettingForNightLighting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Lighting mode status in auto mode<br>
		 * <br>
		 * EPC : 0xBF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current lighting mode in auto mode.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * main lighting=0x42, night lighting=0x43, off=0x44, color lighting=0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetLightingModeStatusInAutoMode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Lighting mode status in auto mode<br>
		 * <br>
		 * EPC : 0xBF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current lighting mode in auto mode.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * main lighting=0x42, night lighting=0x43, off=0x44, color lighting=0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetLightingModeStatusInAutoMode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : RGB setting for color lighting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the RGB value for color lighting and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Byte 1: R<br>
		 * Byte 2: G<br>
		 * Byte 3: B 0x00–0xFF (0–255)<br>
		 * Minimum brightness=0x00,maximum brightness=0xFF<br>
		 * <br>
		 * Data type : unsigned char×3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetRgbSettingForColorLighting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : RGB setting for color lighting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the RGB value for color lighting and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Byte 1: R<br>
		 * Byte 2: G<br>
		 * Byte 3: B 0x00–0xFF (0–255)<br>
		 * Minimum brightness=0x00,maximum brightness=0xFF<br>
		 * <br>
		 * Data type : unsigned char×3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetRgbSettingForColorLighting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON=0x41, Reservation OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON=0x41, Reservation OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (=0.23):(=0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (=0.23):(=0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON=0x41, Reservation OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOffTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON=0x41, Reservation OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOffTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer setting<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (=0.23):(=0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOffTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer setting<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (=0.23):(=0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOffTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
	}

	public static class Setter extends DeviceObject.Setter {
		public Setter(short dstEchoClassCode, byte dstEchoInstanceCode
				, String dstEchoAddress, boolean responseRequired) {
			super(dstEchoClassCode, dstEchoInstanceCode
					, dstEchoAddress, responseRequired);
		}
		
		@Override
		public Setter reqSetProperty(byte epc, byte[] edt) {
			return (Setter)super.reqSetProperty(epc, edt);
		}
		
		@Override
		public Setter reqSetOperationStatus(byte[] edt) {
			return (Setter)super.reqSetOperationStatus(edt);
		}
		@Override
		public Setter reqSetInstallationLocation(byte[] edt) {
			return (Setter)super.reqSetInstallationLocation(edt);
		}
		@Override
		public Setter reqSetCurrentLimitSetting(byte[] edt) {
			return (Setter)super.reqSetCurrentLimitSetting(edt);
		}
		@Override
		public Setter reqSetPowerSavingOperationSetting(byte[] edt) {
			return (Setter)super.reqSetPowerSavingOperationSetting(edt);
		}
		@Override
		public Setter reqSetRemoteControlSetting(byte[] edt) {
			return (Setter)super.reqSetRemoteControlSetting(edt);
		}
		@Override
		public Setter reqSetCurrentTimeSetting(byte[] edt) {
			return (Setter)super.reqSetCurrentTimeSetting(edt);
		}
		@Override
		public Setter reqSetCurrentDateSetting(byte[] edt) {
			return (Setter)super.reqSetCurrentDateSetting(edt);
		}
		@Override
		public Setter reqSetPowerLimitSetting(byte[] edt) {
			return (Setter)super.reqSetPowerLimitSetting(edt);
		}
		
		/**
		 * Property name : Illuminance level<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates illuminance level in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetIlluminanceLevel(byte[] edt) {
			reqSetProperty(EPC_ILLUMINANCE_LEVEL, edt);
			return this;
		}
		/**
		 * Property name : Light color setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the color setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Incandescent lamp color = 0x41, white = 0x42, daylight white = 0x43, daylight color = 0x44, other = 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetLightColorSetting(byte[] edt) {
			reqSetProperty(EPC_LIGHT_COLOR_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Illuminance level step setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * From 0x01 to the maximum specifiable illuminance level value (from dark to bright)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetIlluminanceLevelStepSetting(byte[] edt) {
			reqSetProperty(EPC_ILLUMINANCE_LEVEL_STEP_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Light color step setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the light color in terms of steps and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetLightColorStepSetting(byte[] edt) {
			reqSetProperty(EPC_LIGHT_COLOR_STEP_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Lighting mode setting<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents of property :<br>
		 * Auto/main lighting/night lighting/color lighting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Auto=0x41, main lighting=0x42,<br>
		 * night lighting=0x43, color lighting=0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Setter reqSetLightingModeSetting(byte[] edt) {
			reqSetProperty(EPC_LIGHTING_MODE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Illuminance level setting for main lighting<br>
		 * <br>
		 * EPC : 0xB7<br>
		 * <br>
		 * Contents of property :<br>
		 * Indicates the illuminance level of main lighting in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00–0x64(0–100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetIlluminanceLevelSettingForMainLighting(byte[] edt) {
			reqSetProperty(EPC_ILLUMINANCE_LEVEL_SETTING_FOR_MAIN_LIGHTING, edt);
			return this;
		}
		/**
		 * Property name : Illuminance level step setting for main lighting<br>
		 * <br>
		 * EPC : 0xB8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the illuminance level by the number of steps for main lighting and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to the maximum value of settable illuminance level(dark to bright)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetIlluminanceLevelStepSettingForMainLighting(byte[] edt) {
			reqSetProperty(EPC_ILLUMINANCE_LEVEL_STEP_SETTING_FOR_MAIN_LIGHTING, edt);
			return this;
		}
		/**
		 * Property name : Illuminance level setting for night lighting<br>
		 * <br>
		 * EPC : 0xB9<br>
		 * <br>
		 * Contents of property :<br>
		 * Indicates the illuminance level of night lighting in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00–0x64 (0–100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetIlluminanceLevelSettingForNightLighting(byte[] edt) {
			reqSetProperty(EPC_ILLUMINANCE_LEVEL_SETTING_FOR_NIGHT_LIGHTING, edt);
			return this;
		}
		/**
		 * Property name : Illuminance level step setting for night lighting<br>
		 * <br>
		 * EPC : 0xBA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the illuminance level by the number of steps for night lighting and to acquire the current setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to the maximum value of settable illuminance level (dark to bright)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetIlluminanceLevelStepSettingForNightLighting(byte[] edt) {
			reqSetProperty(EPC_ILLUMINANCE_LEVEL_STEP_SETTING_FOR_NIGHT_LIGHTING, edt);
			return this;
		}
		/**
		 * Property name : Light color setting for main lighting<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the light color for main lighting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Incandescent lamp color=0x41, white= 0x42, daylight white=0x43, daylight color= 0x44, other=0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetLightColorSettingForMainLighting(byte[] edt) {
			reqSetProperty(EPC_LIGHT_COLOR_SETTING_FOR_MAIN_LIGHTING, edt);
			return this;
		}
		/**
		 * Property name : Light color level step setting for main lighting<br>
		 * <br>
		 * EPC : 0xBC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the light color level by the number of steps for main lighting and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01to the maximum value of settable light color level (incandescent lamp color to white)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetLightColorLevelStepSettingForMainLighting(byte[] edt) {
			reqSetProperty(EPC_LIGHT_COLOR_LEVEL_STEP_SETTING_FOR_MAIN_LIGHTING, edt);
			return this;
		}
		/**
		 * Property name : Light color setting for night lighting<br>
		 * <br>
		 * EPC : 0xBD<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the light color for night lighting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * incandescent lamp color=0x41, white=0x42, daylight white=0x43, daylight color=0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetLightColorSettingForNightLighting(byte[] edt) {
			reqSetProperty(EPC_LIGHT_COLOR_SETTING_FOR_NIGHT_LIGHTING, edt);
			return this;
		}
		/**
		 * Property name : Light color level step setting for night lighting<br>
		 * <br>
		 * EPC : 0xBE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the light color level by the number of steps for night lighting and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to the maximum value of settable light color level (incandescent lamp color to white)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetLightColorLevelStepSettingForNightLighting(byte[] edt) {
			reqSetProperty(EPC_LIGHT_COLOR_LEVEL_STEP_SETTING_FOR_NIGHT_LIGHTING, edt);
			return this;
		}
		/**
		 * Property name : Lighting mode status in auto mode<br>
		 * <br>
		 * EPC : 0xBF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current lighting mode in auto mode.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * main lighting=0x42, night lighting=0x43, off=0x44, color lighting=0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetLightingModeStatusInAutoMode(byte[] edt) {
			reqSetProperty(EPC_LIGHTING_MODE_STATUS_IN_AUTO_MODE, edt);
			return this;
		}
		/**
		 * Property name : RGB setting for color lighting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the RGB value for color lighting and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Byte 1: R<br>
		 * Byte 2: G<br>
		 * Byte 3: B 0x00–0xFF (0–255)<br>
		 * Minimum brightness=0x00,maximum brightness=0xFF<br>
		 * <br>
		 * Data type : unsigned char×3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetRgbSettingForColorLighting(byte[] edt) {
			reqSetProperty(EPC_RGB_SETTING_FOR_COLOR_LIGHTING, edt);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON=0x41, Reservation OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			reqSetProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (=0.23):(=0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOnTimerSetting(byte[] edt) {
			reqSetProperty(EPC_ON_TIMER_SETTING, edt);
			return this;
		}
		/**
		 * Property name : OFF timer reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON=0x41, Reservation OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOffTimerReservationSetting(byte[] edt) {
			reqSetProperty(EPC_OFF_TIMER_RESERVATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : OFF timer setting<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (=0.23):(=0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOffTimerSetting(byte[] edt) {
			reqSetProperty(EPC_OFF_TIMER_SETTING, edt);
			return this;
		}
	}
	
	public static class Getter extends DeviceObject.Getter {
		public Getter(short dstEchoClassCode, byte dstEchoInstanceCode
				, String dstEchoAddress) {
			super(dstEchoClassCode, dstEchoInstanceCode
					, dstEchoAddress);
		}
		
		@Override
		public Getter reqGetProperty(byte epc) {
			return (Getter)super.reqGetProperty(epc);
		}
		
		@Override
		public Getter reqGetOperationStatus() {
			return (Getter)super.reqGetOperationStatus();
		}
		@Override
		public Getter reqGetInstallationLocation() {
			return (Getter)super.reqGetInstallationLocation();
		}
		@Override
		public Getter reqGetStandardVersionInformation() {
			return (Getter)super.reqGetStandardVersionInformation();
		}
		@Override
		public Getter reqGetIdentificationNumber() {
			return (Getter)super.reqGetIdentificationNumber();
		}
		@Override
		public Getter reqGetMeasuredInstantaneousPowerConsumption() {
			return (Getter)super.reqGetMeasuredInstantaneousPowerConsumption();
		}
		@Override
		public Getter reqGetMeasuredCumulativePowerConsumption() {
			return (Getter)super.reqGetMeasuredCumulativePowerConsumption();
		}
		@Override
		public Getter reqGetManufacturersFaultCode() {
			return (Getter)super.reqGetManufacturersFaultCode();
		}
		@Override
		public Getter reqGetCurrentLimitSetting() {
			return (Getter)super.reqGetCurrentLimitSetting();
		}
		@Override
		public Getter reqGetFaultStatus() {
			return (Getter)super.reqGetFaultStatus();
		}
		@Override
		public Getter reqGetFaultDescription() {
			return (Getter)super.reqGetFaultDescription();
		}
		@Override
		public Getter reqGetManufacturerCode() {
			return (Getter)super.reqGetManufacturerCode();
		}
		@Override
		public Getter reqGetBusinessFacilityCode() {
			return (Getter)super.reqGetBusinessFacilityCode();
		}
		@Override
		public Getter reqGetProductCode() {
			return (Getter)super.reqGetProductCode();
		}
		@Override
		public Getter reqGetProductionNumber() {
			return (Getter)super.reqGetProductionNumber();
		}
		@Override
		public Getter reqGetProductionDate() {
			return (Getter)super.reqGetProductionDate();
		}
		@Override
		public Getter reqGetPowerSavingOperationSetting() {
			return (Getter)super.reqGetPowerSavingOperationSetting();
		}
		@Override
		public Getter reqGetRemoteControlSetting() {
			return (Getter)super.reqGetRemoteControlSetting();
		}
		@Override
		public Getter reqGetCurrentTimeSetting() {
			return (Getter)super.reqGetCurrentTimeSetting();
		}
		@Override
		public Getter reqGetCurrentDateSetting() {
			return (Getter)super.reqGetCurrentDateSetting();
		}
		@Override
		public Getter reqGetPowerLimitSetting() {
			return (Getter)super.reqGetPowerLimitSetting();
		}
		@Override
		public Getter reqGetCumulativeOperatingTime() {
			return (Getter)super.reqGetCumulativeOperatingTime();
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
		
		/**
		 * Property name : Illuminance level<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates illuminance level in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetIlluminanceLevel() {
			reqGetProperty(EPC_ILLUMINANCE_LEVEL);
			return this;
		}
		/**
		 * Property name : Light color setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the color setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Incandescent lamp color = 0x41, white = 0x42, daylight white = 0x43, daylight color = 0x44, other = 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetLightColorSetting() {
			reqGetProperty(EPC_LIGHT_COLOR_SETTING);
			return this;
		}
		/**
		 * Property name : Illuminance level step setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * From 0x01 to the maximum specifiable illuminance level value (from dark to bright)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetIlluminanceLevelStepSetting() {
			reqGetProperty(EPC_ILLUMINANCE_LEVEL_STEP_SETTING);
			return this;
		}
		/**
		 * Property name : Light color step setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the light color in terms of steps and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetLightColorStepSetting() {
			reqGetProperty(EPC_LIGHT_COLOR_STEP_SETTING);
			return this;
		}
		/**
		 * Property name : Maximum specifiable values<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the maximum specifiable illuminance level value and the maximum specifiable light color value.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: illuminance  Second byte: light color 0x01.0xFF (Step 1.Step 255)<br>
		 * 0x00 (when the function is not implemented)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMaximumSpecifiableValues() {
			reqGetProperty(EPC_MAXIMUM_SPECIFIABLE_VALUES);
			return this;
		}
		/**
		 * Property name : Maximum value of settable level for night lighting
<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the maximum values of illuminance and light color settable levels for night lighting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: illuminance<br>
		 * Second byte: light color<br>
		 * 0x01–0xFF (Step 1–Step 255)<br>
		 * 0x00 (when the function is not implemented)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMaximumValueOfSettableLevelForNightLighting() {
			reqGetProperty(EPC_MAXIMUM_VALUE_OF_SETTABLE_LEVEL_FOR_NIGHT_LIGHTING);
			return this;
		}
		/**
		 * Property name : Lighting mode setting<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents of property :<br>
		 * Auto/main lighting/night lighting/color lighting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Auto=0x41, main lighting=0x42,<br>
		 * night lighting=0x43, color lighting=0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetLightingModeSetting() {
			reqGetProperty(EPC_LIGHTING_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Illuminance level setting for main lighting<br>
		 * <br>
		 * EPC : 0xB7<br>
		 * <br>
		 * Contents of property :<br>
		 * Indicates the illuminance level of main lighting in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00–0x64(0–100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetIlluminanceLevelSettingForMainLighting() {
			reqGetProperty(EPC_ILLUMINANCE_LEVEL_SETTING_FOR_MAIN_LIGHTING);
			return this;
		}
		/**
		 * Property name : Illuminance level step setting for main lighting<br>
		 * <br>
		 * EPC : 0xB8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the illuminance level by the number of steps for main lighting and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to the maximum value of settable illuminance level(dark to bright)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetIlluminanceLevelStepSettingForMainLighting() {
			reqGetProperty(EPC_ILLUMINANCE_LEVEL_STEP_SETTING_FOR_MAIN_LIGHTING);
			return this;
		}
		/**
		 * Property name : Illuminance level setting for night lighting<br>
		 * <br>
		 * EPC : 0xB9<br>
		 * <br>
		 * Contents of property :<br>
		 * Indicates the illuminance level of night lighting in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00–0x64 (0–100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetIlluminanceLevelSettingForNightLighting() {
			reqGetProperty(EPC_ILLUMINANCE_LEVEL_SETTING_FOR_NIGHT_LIGHTING);
			return this;
		}
		/**
		 * Property name : Illuminance level step setting for night lighting<br>
		 * <br>
		 * EPC : 0xBA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the illuminance level by the number of steps for night lighting and to acquire the current setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to the maximum value of settable illuminance level (dark to bright)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetIlluminanceLevelStepSettingForNightLighting() {
			reqGetProperty(EPC_ILLUMINANCE_LEVEL_STEP_SETTING_FOR_NIGHT_LIGHTING);
			return this;
		}
		/**
		 * Property name : Light color setting for main lighting<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the light color for main lighting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Incandescent lamp color=0x41, white= 0x42, daylight white=0x43, daylight color= 0x44, other=0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetLightColorSettingForMainLighting() {
			reqGetProperty(EPC_LIGHT_COLOR_SETTING_FOR_MAIN_LIGHTING);
			return this;
		}
		/**
		 * Property name : Light color level step setting for main lighting<br>
		 * <br>
		 * EPC : 0xBC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the light color level by the number of steps for main lighting and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01to the maximum value of settable light color level (incandescent lamp color to white)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetLightColorLevelStepSettingForMainLighting() {
			reqGetProperty(EPC_LIGHT_COLOR_LEVEL_STEP_SETTING_FOR_MAIN_LIGHTING);
			return this;
		}
		/**
		 * Property name : Light color setting for night lighting<br>
		 * <br>
		 * EPC : 0xBD<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the light color for night lighting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * incandescent lamp color=0x41, white=0x42, daylight white=0x43, daylight color=0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetLightColorSettingForNightLighting() {
			reqGetProperty(EPC_LIGHT_COLOR_SETTING_FOR_NIGHT_LIGHTING);
			return this;
		}
		/**
		 * Property name : Light color level step setting for night lighting<br>
		 * <br>
		 * EPC : 0xBE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the light color level by the number of steps for night lighting and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to the maximum value of settable light color level (incandescent lamp color to white)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetLightColorLevelStepSettingForNightLighting() {
			reqGetProperty(EPC_LIGHT_COLOR_LEVEL_STEP_SETTING_FOR_NIGHT_LIGHTING);
			return this;
		}
		/**
		 * Property name : Lighting mode status in auto mode<br>
		 * <br>
		 * EPC : 0xBF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current lighting mode in auto mode.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * main lighting=0x42, night lighting=0x43, off=0x44, color lighting=0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetLightingModeStatusInAutoMode() {
			reqGetProperty(EPC_LIGHTING_MODE_STATUS_IN_AUTO_MODE);
			return this;
		}
		/**
		 * Property name : RGB setting for color lighting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the RGB value for color lighting and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Byte 1: R<br>
		 * Byte 2: G<br>
		 * Byte 3: B 0x00–0xFF (0–255)<br>
		 * Minimum brightness=0x00,maximum brightness=0xFF<br>
		 * <br>
		 * Data type : unsigned char×3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRgbSettingForColorLighting() {
			reqGetProperty(EPC_RGB_SETTING_FOR_COLOR_LIGHTING);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON=0x41, Reservation OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOnTimerReservationSetting() {
			reqGetProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (=0.23):(=0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOnTimerSetting() {
			reqGetProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		/**
		 * Property name : OFF timer reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON=0x41, Reservation OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOffTimerReservationSetting() {
			reqGetProperty(EPC_OFF_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : OFF timer setting<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (=0.23):(=0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOffTimerSetting() {
			reqGetProperty(EPC_OFF_TIMER_SETTING);
			return this;
		}
	}
	
	public static class Informer extends DeviceObject.Informer {
		public Informer(short echoClassCode, byte echoInstanceCode
				, String dstEchoAddress, boolean isSelfObject) {
			super(echoClassCode, echoInstanceCode
					, dstEchoAddress, isSelfObject);
		}
		
		@Override
		public Informer reqInformProperty(byte epc) {
			return (Informer)super.reqInformProperty(epc);
		}
				@Override
		public Informer reqInformOperationStatus() {
			return (Informer)super.reqInformOperationStatus();
		}
		@Override
		public Informer reqInformInstallationLocation() {
			return (Informer)super.reqInformInstallationLocation();
		}
		@Override
		public Informer reqInformStandardVersionInformation() {
			return (Informer)super.reqInformStandardVersionInformation();
		}
		@Override
		public Informer reqInformIdentificationNumber() {
			return (Informer)super.reqInformIdentificationNumber();
		}
		@Override
		public Informer reqInformMeasuredInstantaneousPowerConsumption() {
			return (Informer)super.reqInformMeasuredInstantaneousPowerConsumption();
		}
		@Override
		public Informer reqInformMeasuredCumulativePowerConsumption() {
			return (Informer)super.reqInformMeasuredCumulativePowerConsumption();
		}
		@Override
		public Informer reqInformManufacturersFaultCode() {
			return (Informer)super.reqInformManufacturersFaultCode();
		}
		@Override
		public Informer reqInformCurrentLimitSetting() {
			return (Informer)super.reqInformCurrentLimitSetting();
		}
		@Override
		public Informer reqInformFaultStatus() {
			return (Informer)super.reqInformFaultStatus();
		}
		@Override
		public Informer reqInformFaultDescription() {
			return (Informer)super.reqInformFaultDescription();
		}
		@Override
		public Informer reqInformManufacturerCode() {
			return (Informer)super.reqInformManufacturerCode();
		}
		@Override
		public Informer reqInformBusinessFacilityCode() {
			return (Informer)super.reqInformBusinessFacilityCode();
		}
		@Override
		public Informer reqInformProductCode() {
			return (Informer)super.reqInformProductCode();
		}
		@Override
		public Informer reqInformProductionNumber() {
			return (Informer)super.reqInformProductionNumber();
		}
		@Override
		public Informer reqInformProductionDate() {
			return (Informer)super.reqInformProductionDate();
		}
		@Override
		public Informer reqInformPowerSavingOperationSetting() {
			return (Informer)super.reqInformPowerSavingOperationSetting();
		}
		@Override
		public Informer reqInformRemoteControlSetting() {
			return (Informer)super.reqInformRemoteControlSetting();
		}
		@Override
		public Informer reqInformCurrentTimeSetting() {
			return (Informer)super.reqInformCurrentTimeSetting();
		}
		@Override
		public Informer reqInformCurrentDateSetting() {
			return (Informer)super.reqInformCurrentDateSetting();
		}
		@Override
		public Informer reqInformPowerLimitSetting() {
			return (Informer)super.reqInformPowerLimitSetting();
		}
		@Override
		public Informer reqInformCumulativeOperatingTime() {
			return (Informer)super.reqInformCumulativeOperatingTime();
		}
		@Override
		public Informer reqInformStatusChangeAnnouncementPropertyMap() {
			return (Informer)super.reqInformStatusChangeAnnouncementPropertyMap();
		}
		@Override
		public Informer reqInformSetPropertyMap() {
			return (Informer)super.reqInformSetPropertyMap();
		}
		@Override
		public Informer reqInformGetPropertyMap() {
			return (Informer)super.reqInformGetPropertyMap();
		}
		
		/**
		 * Property name : Illuminance level<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates illuminance level in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformIlluminanceLevel() {
			reqInformProperty(EPC_ILLUMINANCE_LEVEL);
			return this;
		}
		/**
		 * Property name : Light color setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the color setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Incandescent lamp color = 0x41, white = 0x42, daylight white = 0x43, daylight color = 0x44, other = 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformLightColorSetting() {
			reqInformProperty(EPC_LIGHT_COLOR_SETTING);
			return this;
		}
		/**
		 * Property name : Illuminance level step setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * From 0x01 to the maximum specifiable illuminance level value (from dark to bright)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformIlluminanceLevelStepSetting() {
			reqInformProperty(EPC_ILLUMINANCE_LEVEL_STEP_SETTING);
			return this;
		}
		/**
		 * Property name : Light color step setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the light color in terms of steps and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformLightColorStepSetting() {
			reqInformProperty(EPC_LIGHT_COLOR_STEP_SETTING);
			return this;
		}
		/**
		 * Property name : Maximum specifiable values<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the maximum specifiable illuminance level value and the maximum specifiable light color value.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: illuminance  Second byte: light color 0x01.0xFF (Step 1.Step 255)<br>
		 * 0x00 (when the function is not implemented)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMaximumSpecifiableValues() {
			reqInformProperty(EPC_MAXIMUM_SPECIFIABLE_VALUES);
			return this;
		}
		/**
		 * Property name : Maximum value of settable level for night lighting
<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the maximum values of illuminance and light color settable levels for night lighting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: illuminance<br>
		 * Second byte: light color<br>
		 * 0x01–0xFF (Step 1–Step 255)<br>
		 * 0x00 (when the function is not implemented)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMaximumValueOfSettableLevelForNightLighting() {
			reqInformProperty(EPC_MAXIMUM_VALUE_OF_SETTABLE_LEVEL_FOR_NIGHT_LIGHTING);
			return this;
		}
		/**
		 * Property name : Lighting mode setting<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents of property :<br>
		 * Auto/main lighting/night lighting/color lighting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Auto=0x41, main lighting=0x42,<br>
		 * night lighting=0x43, color lighting=0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformLightingModeSetting() {
			reqInformProperty(EPC_LIGHTING_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Illuminance level setting for main lighting<br>
		 * <br>
		 * EPC : 0xB7<br>
		 * <br>
		 * Contents of property :<br>
		 * Indicates the illuminance level of main lighting in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00–0x64(0–100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformIlluminanceLevelSettingForMainLighting() {
			reqInformProperty(EPC_ILLUMINANCE_LEVEL_SETTING_FOR_MAIN_LIGHTING);
			return this;
		}
		/**
		 * Property name : Illuminance level step setting for main lighting<br>
		 * <br>
		 * EPC : 0xB8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the illuminance level by the number of steps for main lighting and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to the maximum value of settable illuminance level(dark to bright)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformIlluminanceLevelStepSettingForMainLighting() {
			reqInformProperty(EPC_ILLUMINANCE_LEVEL_STEP_SETTING_FOR_MAIN_LIGHTING);
			return this;
		}
		/**
		 * Property name : Illuminance level setting for night lighting<br>
		 * <br>
		 * EPC : 0xB9<br>
		 * <br>
		 * Contents of property :<br>
		 * Indicates the illuminance level of night lighting in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00–0x64 (0–100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformIlluminanceLevelSettingForNightLighting() {
			reqInformProperty(EPC_ILLUMINANCE_LEVEL_SETTING_FOR_NIGHT_LIGHTING);
			return this;
		}
		/**
		 * Property name : Illuminance level step setting for night lighting<br>
		 * <br>
		 * EPC : 0xBA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the illuminance level by the number of steps for night lighting and to acquire the current setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to the maximum value of settable illuminance level (dark to bright)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformIlluminanceLevelStepSettingForNightLighting() {
			reqInformProperty(EPC_ILLUMINANCE_LEVEL_STEP_SETTING_FOR_NIGHT_LIGHTING);
			return this;
		}
		/**
		 * Property name : Light color setting for main lighting<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the light color for main lighting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Incandescent lamp color=0x41, white= 0x42, daylight white=0x43, daylight color= 0x44, other=0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformLightColorSettingForMainLighting() {
			reqInformProperty(EPC_LIGHT_COLOR_SETTING_FOR_MAIN_LIGHTING);
			return this;
		}
		/**
		 * Property name : Light color level step setting for main lighting<br>
		 * <br>
		 * EPC : 0xBC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the light color level by the number of steps for main lighting and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01to the maximum value of settable light color level (incandescent lamp color to white)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformLightColorLevelStepSettingForMainLighting() {
			reqInformProperty(EPC_LIGHT_COLOR_LEVEL_STEP_SETTING_FOR_MAIN_LIGHTING);
			return this;
		}
		/**
		 * Property name : Light color setting for night lighting<br>
		 * <br>
		 * EPC : 0xBD<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the light color for night lighting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * incandescent lamp color=0x41, white=0x42, daylight white=0x43, daylight color=0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformLightColorSettingForNightLighting() {
			reqInformProperty(EPC_LIGHT_COLOR_SETTING_FOR_NIGHT_LIGHTING);
			return this;
		}
		/**
		 * Property name : Light color level step setting for night lighting<br>
		 * <br>
		 * EPC : 0xBE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the light color level by the number of steps for night lighting and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to the maximum value of settable light color level (incandescent lamp color to white)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformLightColorLevelStepSettingForNightLighting() {
			reqInformProperty(EPC_LIGHT_COLOR_LEVEL_STEP_SETTING_FOR_NIGHT_LIGHTING);
			return this;
		}
		/**
		 * Property name : Lighting mode status in auto mode<br>
		 * <br>
		 * EPC : 0xBF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current lighting mode in auto mode.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * main lighting=0x42, night lighting=0x43, off=0x44, color lighting=0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformLightingModeStatusInAutoMode() {
			reqInformProperty(EPC_LIGHTING_MODE_STATUS_IN_AUTO_MODE);
			return this;
		}
		/**
		 * Property name : RGB setting for color lighting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the RGB value for color lighting and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Byte 1: R<br>
		 * Byte 2: G<br>
		 * Byte 3: B 0x00–0xFF (0–255)<br>
		 * Minimum brightness=0x00,maximum brightness=0xFF<br>
		 * <br>
		 * Data type : unsigned char×3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRgbSettingForColorLighting() {
			reqInformProperty(EPC_RGB_SETTING_FOR_COLOR_LIGHTING);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON=0x41, Reservation OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOnTimerReservationSetting() {
			reqInformProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (=0.23):(=0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOnTimerSetting() {
			reqInformProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		/**
		 * Property name : OFF timer reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON=0x41, Reservation OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOffTimerReservationSetting() {
			reqInformProperty(EPC_OFF_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : OFF timer setting<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (=0.23):(=0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOffTimerSetting() {
			reqInformProperty(EPC_OFF_TIMER_SETTING);
			return this;
		}
	}

	public static class Proxy extends GeneralLighting {
		public Proxy(byte instanceCode) {
			super();
			mEchoInstanceCode = instanceCode;
		}
		@Override
		public byte getInstanceCode() {
			return mEchoInstanceCode;
		}
		@Override
		protected byte[] getOperationStatus() {return null;}
		@Override
		protected boolean setInstallationLocation(byte[] edt) {return false;}
		@Override
		protected byte[] getInstallationLocation() {return null;}
		@Override
		protected byte[] getStandardVersionInformation() {return null;}
		@Override
		protected byte[] getFaultStatus() {return null;}
		@Override
		protected byte[] getManufacturerCode() {return null;}
		@Override
		protected boolean setOperationStatus(byte[] edt) {return false;}
		@Override
		protected boolean setLightingModeSetting(byte[] edt) {return false;}
		@Override
		protected byte[] getLightingModeSetting() {return null;}
	}
	
	public static Setter setG() {
		return setG((byte)0);
	}

	public static Setter setG(byte instanceCode) {
		return setG(instanceCode, true);
	}

	public static Setter setG(boolean responseRequired) {
		return setG((byte)0, responseRequired);
	}

	public static Setter setG(byte instanceCode, boolean responseRequired) {
		return new Setter(ECHO_CLASS_CODE, instanceCode
				, EchoSocket.MULTICAST_ADDRESS, responseRequired);
	}

	public static Getter getG() {
		return getG((byte)0);
	}
	
	public static Getter getG(byte instanceCode) {
		return new Getter(ECHO_CLASS_CODE, instanceCode
				, EchoSocket.MULTICAST_ADDRESS);
	}

	public static Informer informG() {
		return informG((byte)0);
	}

	public static Informer informG(byte instanceCode) {
		return new Informer(ECHO_CLASS_CODE, instanceCode
				, EchoSocket.MULTICAST_ADDRESS, false);
	}

}
