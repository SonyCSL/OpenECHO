import java.io.IOException;
import com.sonycsl.echo.Echo;
import com.sonycsl.echo.node.EchoNode;
import com.sonycsl.echo.eoj.profile.NodeProfile;
import com.sonycsl.echo.eoj.device.DeviceObject;

import com.sonycsl.echo.eoj.profile.NodeProfile;
import com.sonycsl.echo.eoj.device.managementoperation.Controller;

// NodeProfileを継承して、自分の処理を組みこみます。
public class MyNodeProfile extends NodeProfile {
  byte[] mManufactureCode = { 0, 0, 0 };
  byte[] mStatus = { 0x30 };
  byte[] mVersion = { 1, 1, 1, 0 };
  byte[] mIdNumber = { (byte)0xFE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  byte[] mUniqueId = { 0, 0 };
  protected byte[] getManufacturerCode() {
    return mManufactureCode;
  }
  protected byte[] getOperatingStatus() {  
    return mStatus;
  }
  protected byte[] getVersionInformation() {
    return mVersion;
  }
  protected byte[] getIdentificationNumber() {
    return mIdNumber;
  }
  protected boolean setUniqueIdentifierData(byte[] edt) {
    if ((edt[0] & 0x40) != 0x40)   return false;
    mUniqueId[0] = (byte)((edt[0] & (byte)0x7F) | (mUniqueId[0] & 0x80));
    mUniqueId[1] = edt[1];
    return true;
  }
  protected byte[] getUniqueIdentifierData() {
    return mUniqueId;
  }
}

public class MyController extends Controller {
  byte[] mStatus = { 0x30 };
  byte[] mLocation = { 0x00 };
  byte[] mVersion = { 0x01, 0x01, 0x61, 0x00 };
  byte[] mFaultStatus = { 0x42 };
  byte[] mManufacturerCode = { 0, 0, 0 };

  protected boolean setOperationStatus(byte[] edt) {  
    mStatus[0] = edt[0] ; 
    return true ;
  }
  protected byte[] getOperationStatus() {  
    return mStatus;
  }
  protected boolean setInstallationLocation(byte[] edt) {
    changeInstallationLocation(edt[0]);
    return true;
  }
  protected byte[] getInstallationLocation() {
    return mLocation;
  }
  public void changeInstallationLocation(byte location) {
    if (mLocation[0] == location) return ;
    mLocation[0] = location;
    try {
      inform().reqInformInstallationLocation().send();
    } 
    catch (IOException e) { 
      e.printStackTrace();
    }
  }
  protected byte[] getStandardVersionInformation() {
    return mVersion;
  }
  protected byte[] getFaultStatus() {  
    return mFaultStatus;
  }
  protected byte[] getManufacturerCode() {
    return mManufacturerCode;
  }
}

void setup() {
  try {
    Echo.start( new MyNodeProfile(), new DeviceObject[] {
      new MyController()
    }
    );
  } catch( IOException e) { 
    e.printStackTrace();
  }

  while (true) {

    try {
      NodeProfile.getG().reqGetSelfNodeInstanceListS().send();

      EchoNode[] nodes = Echo.getNodes() ;
      EchoNode local = Echo.getSelfNode() ;

      for ( EchoNode en : nodes ) {
        if ( en == local ) {
          println("Node id = " + en.getAddress().getHostAddress() + "(local)");
        }
        else {
          println("Node id = " + en.getAddress().getHostAddress());
        }

        println(" Node Profile = " + en.getNodeProfile());

        println(" Devices:");
        DeviceObject[] dos = en.getDevices();

        for ( DeviceObject d : dos ) {
          println("  " + d);
        }
        println("----");
      }
      println("--------");
    } 
    catch( IOException e) { 
      e.printStackTrace();
    }

    // 10秒待つ
    try { 
      Thread.sleep(10000);
    } 
    catch (InterruptedException e) { 
      e.printStackTrace();
    }
  }
}

