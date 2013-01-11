package com.sonycsl.echo.processing.defaults;

import java.io.IOException;
import com.sonycsl.echo.eoj.device.managementoperation.Controller;

public class DefaultController extends Controller {

	byte[] mStatus = {0x30};
	byte[] mLocation = {0x00};
	byte[] mVersion = {0x0, 0x0, 0x61, 0x00};	// Echo 1.01 Appendix a
	//byte[] mVersion = {0x0, 0x0, 0x41, 0x00}; 	// Echo 1.01 Appendix B
	byte[] mFaultStatus = {0x42};
	byte[] mManufacturerCode = {0,0,0x60};
	byte[] mStatusChangeAnnouncementPropertyMap = {0x03,(byte)0x80,(byte)0x81,(byte)0x88} ;
	byte[] mSetPropertyMap = {0x01,(byte)0x81} ;
	byte[] mGetPropertyMap = {0x08,(byte)0x80,(byte)0x81,(byte)0x82,(byte)0x88,(byte)0x8a,(byte)0x9d,(byte)0x9e,(byte)0x9f} ;
	
	@Override
	protected byte[] getOperationStatus() {	return mStatus;	}
	
	public void changeOperationStatus(boolean status) {
		byte b = (status ? (byte)0x30 : (byte)0x31) ;
		
		if(mStatus[0] == b) return ;

		mStatus[0] = b;
		try {
			inform().reqInformOperationStatus().sendGroup();
		} catch (IOException e) { e.printStackTrace(); }
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
			inform().reqInformInstallationLocation().sendGroup();
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	@Override
	protected byte[] getStandardVersionInformation() {return mVersion;}
	
	@Override
	protected byte[] getFaultStatus() {	return mFaultStatus;}
	
	public void changeFaultStatus(boolean status) {
		byte b = (status?(byte)0x41:(byte)0x42) ;

		if(mFaultStatus[0] == b) return ;
		mFaultStatus[0] = b;
		try {
			inform().reqInformFaultStatus().sendGroup();
		} catch (IOException e) { e.printStackTrace();}
	}

	@Override
	protected byte[] getManufacturerCode() {return mManufacturerCode;}

	@Override
	protected byte[] getStatusChangeAnnouncementPropertyMap() { return mStatusChangeAnnouncementPropertyMap ; }

	@Override
	protected byte[] getSetPropertyMap() { return mSetPropertyMap; }

	@Override
	protected byte[] getGetPropertyMap() { return mGetPropertyMap; }
	
}
