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
	
	public static short getObjectClassCode(byte classGroupCode, byte classCode) {
		ByteBuffer buffer = ByteBuffer.allocate(2);
		buffer.order(ByteOrder.BIG_ENDIAN);
		buffer.put(classGroupCode);
		buffer.put(classCode);
		return buffer.getShort(0);
		
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
	
	public static String toHexString(byte[] data) {
		if(data == null) return "";
		StringBuilder sb = new StringBuilder();
		for(byte b : data) {
			sb.append(String.format("%02x ", b));
		}
		
		return new String(sb);
	}

	public static String toHexString(byte b) {
		return String.format("%02x", b);
	}
	
	public static String toHexString(short s) {
		return String.format("%04x", s);
	}
	
}

