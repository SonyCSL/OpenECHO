import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.eoj.profile.NodeProfile;
import com.sonycsl.echo.eoj.device.housingfacilities.ElectricLock ;

import com.sonycsl.echo.processing.defaults.DefaultNodeProfile;

// 電気錠の在室・不在状態のプロパティは必須ではありません。
// このようなプロパティを実装する際は対応するメソッドをオーバーライドし
// プロパティマップに登録します。
public class MyElectricLock extends ElectricLock {
  
  byte[] mStatus = {0x30};
  byte[] mLocation = {0x00};
  byte[] mVersion = {0x01, 0x01, 0x61, 0x00};
  byte[] mFaultStatus = {0x42};
  byte[] mManufacturerCode = {0,0,0};
  
  byte[] mLockStatus = {0x30};
  byte[] mOccupantStatus = {0x42};
  
  // 必須でないプロパティマップは明示的に追加登録します。
  protected void setupPropertyMaps() {
    // 必須なものは、super.setupProperyMapsで登録されています。
    super.setupPropertyMaps();

    // 状態変化時アナウンスプロパティマップに登録する際はaddStatusChangeAnnouncementProperty，
    // Setプロパティマップに登録する際はaddSetProperty，
    // Getプロパティマップに登録する際はaddGetPropertyを使います．
    addGetProperty(EPC_OCCUPANT_NON_OCCUPANT_STATUS);
  }

protected byte[] getOperationStatus() {  return mStatus;  }
  protected boolean setInstallationLocation(byte[] edt) {
    changeInstallationLocation(edt[0]);
    return true;
  }
  protected byte[] getInstallationLocation() {return mLocation;}
  public void changeInstallationLocation(byte location) {
    if(mLocation[0] == location) return ;
    mLocation[0] = location;
    try {
      inform().reqInformInstallationLocation().send();
    } catch (IOException e) { e.printStackTrace(); }
  }
  protected byte[] getStandardVersionInformation() {return mVersion;}
  protected byte[] getFaultStatus() {  return mFaultStatus;}
  protected byte[] getManufacturerCode() {return mManufacturerCode;}
  protected boolean setLockSetting1(byte[] edt) {
    mLockStatus = edt;
    return true;
  }
  protected byte[] getLockSetting1() {
    return mLockStatus;
  }
  
  // 在室・不在状態を得るメソッドをオーバーライドします．
  protected byte[] getOccupantNonOccupantStatus() {return mOccupantStatus;}
}

void setup() {
  // System.outにログを表示するようにします。
  Echo.addEventListener( new Echo.Logger(System.out) ) ;


  try {
    Echo.start( new DefaultNodeProfile(), new DeviceObject[] {
      new MyElectricLock()
    }
    );
    NodeProfile.getG().reqGetSelfNodeInstanceListS().send();
  } 
  catch( IOException e) { 
    e.printStackTrace();
  }

  println("Started") ;
}

