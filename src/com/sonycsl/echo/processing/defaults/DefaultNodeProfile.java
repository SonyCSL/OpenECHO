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
