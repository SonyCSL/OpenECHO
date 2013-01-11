package com.sonycsl.echo.processing.defaults;

import java.io.IOException;

import com.sonycsl.echo.eoj.profile.NodeProfile;

public class DefaultNodeProfile extends NodeProfile {
	
	byte[] mManufactureCode = {0,0,0x60};
	byte[] mStatus = {0x30};
	byte[] mVersion = {1,1,1,0};
	byte[] mIdNumber = {(byte)0xFE,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	byte[] mUniqueId = {(byte)0xff,0};
	
	byte[] mStatusChangeAnnouncementPropertyMap = {0x02,(byte)0x80,(byte)0xd5} ;
	byte[] mSetPropertyMap = {0x01,(byte)0xbf} ;
	byte[] mGetPropertyMap = {0x0c,(byte)0x8a,(byte)0x9d,(byte)0x9e,(byte)0x9f,(byte)0x80,(byte)0x82
			,(byte)0x83,(byte)0xbf,(byte)0xd3,(byte)0xd4,(byte)0xd6,(byte)0xd7} ;

	
	@Override
	protected byte[] getOperatingStatus() {	return mStatus;	}
	
	public void changeOperatingStatus(boolean status) {
		byte b = (status?(byte)0x30:(byte)0x31) ;
		
		if(mStatus[0] == b) return ;
		mStatus[0] = b;
		try {
			inform().reqInformOperatingStatus().sendGroup();
		} catch (IOException e) {e.printStackTrace();}
	}

	@Override
	protected byte[] getVersionInformation() {return mVersion;}

	@Override
	protected byte[] getIdentificationNumber() {return mIdNumber;}

	@Override
	protected boolean setUniqueIdentifierData(byte[] edt) {
		if((edt[0] & 0x40) == 0x0)
			return false;

		mUniqueId[0] = (byte)((edt[0] & (byte)0x3F) | (mUniqueId[0] & 0xC0));
		mUniqueId[1] = edt[1];
		return true;
	}

	@Override
	protected byte[] getUniqueIdentifierData() {return mUniqueId;}

	@Override
	protected byte[] getManufacturerCode() {return mManufactureCode;}

	@Override
	protected byte[] getStatusChangeAnnouncementPropertyMap() { return mStatusChangeAnnouncementPropertyMap ; }

	@Override
	protected byte[] getSetPropertyMap() { return mSetPropertyMap; }

	@Override
	protected byte[] getGetPropertyMap() { return mGetPropertyMap; }
}
