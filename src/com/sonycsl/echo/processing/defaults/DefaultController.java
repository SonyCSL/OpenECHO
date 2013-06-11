package com.sonycsl.echo.processing.defaults;

import java.io.IOException;
import com.sonycsl.echo.eoj.device.managementoperation.Controller;

public class DefaultController extends Controller {

	byte[] mStatus = {0x30};
	byte[] mLocation = {0x00};
	byte[] mFaultStatus = {0x42};
	byte[] mManufacturerCode = {0,0,0};
	
	@Override
	protected byte[] getOperationStatus() {	return mStatus;	}
	
	public void changeOperationStatus(boolean status) {
		byte b = (status ? (byte)0x30 : (byte)0x31) ;
		
		if(mStatus[0] == b) return ;

		mStatus[0] = b;
		try {
			inform().reqInformOperationStatus().send();
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
			inform().reqInformInstallationLocation().send();
		} catch (IOException e) { e.printStackTrace(); }
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
	protected boolean setOperationStatus(byte[] edt) {
		mStatus = edt;
		return true;
	}
}

