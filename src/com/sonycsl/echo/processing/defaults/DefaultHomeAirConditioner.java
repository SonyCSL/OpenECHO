/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2014 Sony Computer Science Laboratories, Inc.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sonycsl.echo.processing.defaults;

import java.io.IOException;

import com.sonycsl.echo.eoj.device.airconditioner.HomeAirConditioner;

public class DefaultHomeAirConditioner extends HomeAirConditioner {

	byte[] mStatus = {0x30};
	byte[] mLocation = {0x00};
	byte[] mFaultStatus = {0x42};
	byte[] mManufacturerCode = {0,0,0};

	byte[] mMode = {0x41};
	byte[] mTemperature = {0x27};
	
	@Override
	protected boolean setOperationStatus(byte[] edt) {
		changeOperationStatus(edt[0] == 0x30);
		return true;
	}

	@Override
	protected byte[] getOperationStatus() { return mStatus; }
	
	public void changeOperationStatus(boolean status) {
		byte b = (status?(byte)0x30:(byte)0x31) ;
		
		if(mStatus[0] == b) return ;
		mStatus[0] = b;
		try {
			inform().reqInformOperationStatus().send();
		} catch (IOException e) {e.printStackTrace();}
	}
	
	@Override
	protected boolean setInstallationLocation(byte[] edt) {
		changeInstallationLocation(edt[0]);
		return true;
	}
	
	@Override
	protected byte[] getInstallationLocation() {return mLocation;}
	
	public void changeInstallationLocation(byte location) {
		if(mLocation[0] == location) return ;
		mLocation[0] = location;
		try {
			inform().reqInformInstallationLocation().send() ;
		} catch (IOException e) {e.printStackTrace();}
	}
	
	@Override
	protected byte[] getFaultStatus() {	return mFaultStatus;}
	
	public void changeFaultStatus(boolean status) {
		byte b = (status?(byte)0x41:(byte)0x42) ;

		if(mFaultStatus[0] == b) return ;
		mFaultStatus[0] = b;
		try {
			inform().reqInformFaultStatus().send();
		} catch (IOException e) { e.printStackTrace();}
	}

	@Override
	protected byte[] getManufacturerCode() {return mManufacturerCode;}

	@Override
	protected boolean setOperationModeSetting(byte[] edt) {
		changeMode(edt[0]);
		return true;
	}

	@Override
	protected byte[] getOperationModeSetting() {return mMode;}
	
	public void changeMode(byte mode) {
		if(mMode[0] == mode) return ;
		mMode[0] = mode;
		try {
			inform().reqInformOperationModeSetting().send();
		} catch (IOException e) { e.printStackTrace();}
	}

	@Override
	protected boolean setSetTemperatureValue(byte[] edt) {
		mTemperature[0] = edt[0];
		return true;
	}

	@Override
	protected byte[] getSetTemperatureValue() {	return mTemperature;}

}
