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

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;



public final class EchoUtils {
	

	public static final byte[] classToByteArray(EchoObject eoj) {
		return new byte[]{eoj.getClassGroupCode(), eoj.getClassCode()};
	}
	
	public static final byte[] instanceToByteArray(EchoObject eoj) {
		return new byte[]{eoj.getClassGroupCode(), eoj.getClassCode(), eoj.getInstanceCode()};
	}
	
	public static byte[] devicesToByteArray(DeviceObject[] devices, int index) {
		// index=0 : 1~84
		// index=1 : 85~168
		// index=2 : 169~252
		// index=3 : 253~255
		int length = devices.length;
		byte[] ret = null;
		int num = 0;
		switch(index) {
		case 0:
			if(length > 84) num = 84;
			else num = length;
			break;
		case 1:
			if(length < 85) return null;
			if(length > 168) num = 84;
			else num = length - 84;
			break;
		case 2:
			if(length < 169) return null;
			if(length > 252) num = 84;
			else num = length - 168;
			break;
		case 3:
			if(length < 253) return null;
			if(length > 255) return null;
			num = length - 252;
			break;
		default:
			return null;
		}
		
		ret = new byte[num * 3 + 1];
		ret[0] = (byte)num;
		for(int i = 0; i < num; i++) {
			byte[] b = instanceToByteArray(devices[84 * index + i]);
			ret[i*3+1] = b[0];
			ret[i*3+2] = b[1];
			ret[i*3+3] = b[2];
		}
		return ret;
	}

	public static byte[] devicesToByteArray(DeviceObject[] devices) {
		int length = devices.length;
		byte[] ret = new byte[length * 3 + 1];
		ret[0] = (byte)length;
		for(int i = 0; i < length; i++) {
			byte[] b = instanceToByteArray(devices[i]);
			ret[i*3+1] = b[0];
			ret[i*3+2] = b[1];
			ret[i*3+3] = b[2];
		}
		return ret;
	}
	
	public static short getEchoClassCode(byte classGroupCode, byte classCode) {
		ByteBuffer buffer = ByteBuffer.allocate(2);
		buffer.order(ByteOrder.BIG_ENDIAN);
		buffer.put(classGroupCode);
		buffer.put(classCode);
		return buffer.getShort(0);
		
	}

	public static int getEchoObjectCode(byte classGroupCode, byte classCode, byte instanceCode) {
		ByteBuffer buffer = ByteBuffer.allocate(4);
		buffer.order(ByteOrder.BIG_ENDIAN);
		buffer.put((byte)0);
		buffer.put(classGroupCode);
		buffer.put(classCode);
		buffer.put(instanceCode);
		return buffer.getInt(0);
	}

	public static int getEchoObjectCode(short echoClassCode, byte instanceCode) {
		ByteBuffer buffer = ByteBuffer.allocate(4);
		buffer.order(ByteOrder.BIG_ENDIAN);
		buffer.put((byte)0);
		buffer.putShort(echoClassCode);
		buffer.put(instanceCode);
		return buffer.getInt(0);
	}

	public static short getEchoClassCodeFromObjectCode(int objectCode) {
		return (short)((objectCode >> 8) & 0xFFFF);
	}
	public static byte getInstanceCodeFromObjectCode(int objectCode) {
		return (byte)(objectCode & 0xFF);
	}
	
	public static InetAddress getLocalIpAddress() throws SocketException {
		Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
		while(en.hasMoreElements()) {
			NetworkInterface intf = en.nextElement();
			Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses();
			while(enumIpAddr.hasMoreElements()) {
				InetAddress inetAddress = enumIpAddr.nextElement();
				if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
					return inetAddress;
				}
			}
		}
		return null;
	}
	
	public static NetworkInterface getNetworkInterface() throws SocketException {

		Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
		while(en.hasMoreElements()) {
			NetworkInterface intf = en.nextElement();
			Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses();
			while(enumIpAddr.hasMoreElements()) {
				InetAddress inetAddress = enumIpAddr.nextElement();
				if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
					return intf;
				}
			}
		}
		return null;
	}
	
	public static String toHexString(byte[] data) {
		return toHexString(data," ") ;
	}
	public static String toHexString(byte[] data,String sep) {
		if(data == null) return "";
		StringBuilder sb = new StringBuilder();
		for(byte b : data) {
			sb.append(String.format("%02x"+sep, b));
		}
		
		return new String(sb);
	}

	public static String toHexString(byte b) {
		return String.format("%02x", b);
	}
	
	public static String toHexString(short s) {
		return String.format("%04x", s);
	}
	
	public static byte[] propertiesToPropertyMap(byte[] properties) {
		byte[] ret;
		int length = properties.length;
		if(length < 16) {
			ret = new byte[length + 1];
			ret[0] = (byte)length;
			for(int i = 0; i < length; i++) {
				ret[i+1] = properties[i];
			}
		} else {
			ret = new byte[17];
			ret[0] = (byte)length;
			//for(int i = 0; i < length; i++) {
			//	ret[i+1] = (byte)0;
			//}
			for(int i = 1; i < ret.length; i++) {
				ret[i] = (byte)0;
			}
			for(byte p : properties) {
				int high = (int)((p >> 4) & 0x0F);
				if (high < 0x08) {
					continue;
				}
				int low = (int)(p & 0x0F);
				//ret[low+1] = (byte)((ret[low+1] & 0xFF) | (1 << (0x0F - high)));
				ret[low+1] = (byte)((ret[low+1] & 0xFF) | (1 << (high - 0x08)));
			}
		}
		return ret;
	}
	
	public static byte[] propertyMapToProperties(byte[] map) {
		if(map == null || map.length == 0) return new byte[]{};
		byte[] ret = new byte[(int)(map[0] & 0xFF)];
		if(ret.length < 16) {
			for(int i = 0; i < ret.length; i++) {
				ret[i] = map[i+1];
			}
		} else {
			int n = 0;
			for(int low = 0; low < 16; low++) {
				byte tmp = map[low + 1];
				for(int high = 0; high < 8; high++) {
					if((tmp & 0x01) == 0x01) {
						//ret[n] = (byte)(i | ((0x0F - j) << 4));
						ret[n] = (byte)(low | ((high + 0x08) << 4));
						n++;
					}
					tmp = (byte)(tmp >> 1);
				}
			}
		}
		
		return ret;
	}

	public static byte[] toByteArray(byte arg, int length) {
		byte[] ret = new byte[length];
		byte num = arg;
		for(int i = length - 1; i >= 0; i--) {
			ret[i] = (byte)(num & 0xFF);
			num >>= 8;
		}
		return ret;
	}

	public static byte[] toByteArray(byte arg) {
		return toByteArray(arg, 1);
	}
	
	public static byte[] toByteArray(short arg, int length) {
		byte[] ret = new byte[length];
		short num = arg;
		for(int i = length - 1; i >= 0; i--) {
			ret[i] = (byte)(num & 0xFF);
			num >>= 8;
		}
		return ret;
	}

	public static byte[] toByteArray(short arg) {
		return toByteArray(arg, 2);
	}
	
	public static byte[] toByteArray(int arg, int length) {
		byte[] ret = new byte[length];
		int num = arg;
		for(int i = length - 1; i >= 0; i--) {
			ret[i] = (byte)(num & 0xFF);
			num >>= 8;
		}
		return ret;
	}

	public static byte[] toByteArray(int arg) {
		return toByteArray(arg, 4);
	}

	public static byte[] toByteArray(long arg, int length) {
		byte[] ret = new byte[length];
		long num = arg;
		for(int i = length - 1; i >= 0; i--) {
			ret[i] = (byte)(num & 0xFF);
			num >>= 8;
		}
		return ret;
	}

	public static byte[] toByteArray(long arg) {
		return toByteArray(arg, 8);
	}
	
	private static HashMap<Short, Byte> sAllocatedSelfDeviceInstanceCode = new HashMap<Short, Byte>();
	
	public static byte allocateSelfDeviceInstanceCode(short echoClassCode) {

		if (sAllocatedSelfDeviceInstanceCode.containsKey(echoClassCode)) {

			byte code =  sAllocatedSelfDeviceInstanceCode.get(echoClassCode);
			code += 1;
			sAllocatedSelfDeviceInstanceCode.put(echoClassCode, code);
			return code;
		} else {
			sAllocatedSelfDeviceInstanceCode.put(echoClassCode, (byte)1);
			return 1;

		}
	}
}

