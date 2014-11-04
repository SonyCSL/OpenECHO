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

import com.sonycsl.echo.eoj.profile.NodeProfile;

public class DefaultNodeProfile extends NodeProfile {
	
	byte[] mManufactureCode = {0,0,0};
	byte[] mStatus = {0x30};
	byte[] mIdNumber = {(byte)0xFE,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	byte[] mUniqueId = {0,1};
	
	public DefaultNodeProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected byte[] getManufacturerCode() {return mManufactureCode;}
	
	@Override
	protected byte[] getOperatingStatus() {	return mStatus;	}
	
	public void changeOperatingStatus(boolean status) {
		byte b = (status?(byte)0x30:(byte)0x31) ;
		
		if(mStatus[0] == b) return ;
		mStatus[0] = b;
		try {
			inform().reqInformOperatingStatus().send();
		} catch (IOException e) {e.printStackTrace();}
	}

	@Override
	protected byte[] getIdentificationNumber() {return mIdNumber;}

	@Override
	protected boolean setUniqueIdentifierData(byte[] edt) {
		if((edt[0] & 0x40) != 0)
			return false;

		mUniqueId[0] = (byte)(((edt[0] & (byte)0x3F) | (mUniqueId[0] & 0x80)) | (byte)0x40);
		mUniqueId[1] = edt[1];
		return true;
	}

	@Override
	protected byte[] getUniqueIdentifierData() {return mUniqueId;}

}
