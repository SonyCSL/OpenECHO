import java.io.IOException;
import processing.net.*;
import controlP5.*;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.node.EchoNode;
import com.sonycsl.echo.eoj.profile.NodeProfile;
import com.sonycsl.echo.eoj.device.DeviceObject;

import com.sonycsl.echo.processing.defaults.DefaultNodeProfile;
import com.sonycsl.echo.eoj.device.housingfacilities.GeneralLighting;

color backgroundLightOnColor = color(255, 204, 0);
color backgroundLightOffColor = color(0, 0, 0);
color backgroundNow = backgroundLightOffColor;

// 照明クラスを実装します。
public class LightEmulator extends GeneralLighting {
  byte[] mStatus = {0x31}; // 電源状態を格納する変数です。デフォルトはOFFと仮定します。
  byte[] mLocation = {0x00}; // 機器の置き場所を格納する変数です。
  byte[] mFaultStatus = {0x42};  // 機器に問題が発生した時に、そのコードを格納します。
  byte[] mManufacturerCode = {0, 0, 0};  // ベンダー固有のメーカーコードです。
  byte[] mLightingMode = {0x42}; // 照明のモードです。


  protected boolean setOperationStatus(byte[] edt) {
    mStatus[0] = edt[0] ;
    //背景色を変更
    if(mStatus[0] == 0x30){
      backgroundNow = backgroundLightOnColor;
    }else{
      backgroundNow = backgroundLightOffColor;
    }
    //電源状態が変化したことを他のノードに通知します
    try {
      inform().reqInformOperationStatus().send();
    } 
    catch (IOException e) { 
      e.printStackTrace();
    }
    return true;
  }

  protected byte[] getOperationStatus() { 
    return mStatus;
  }
  protected boolean setInstallationLocation(byte[] edt) {
    mLocation[0] = edt[0];
    try {
      inform().reqInformInstallationLocation().send();
    } 
    catch (IOException e) { 
      e.printStackTrace();
    }
    return true;
  }
  protected byte[] getInstallationLocation() {
    return mLocation;
  }
  protected byte[] getFaultStatus() {  
    return mFaultStatus;
  }
  protected byte[] getManufacturerCode() {
    return mManufacturerCode;
  }

  protected byte[] getLightingModeSetting() {
    return mLightingMode;
  }

  protected boolean setLightingModeSetting(byte[] edt) {
    mLightingMode[0] = edt[0];
    return true;
  }

  public String toString() {
    if (mStatus[0] == 0x31) {
      return "Light Emulator(Off)";
    }
    else {
      return "Light Emulator(On)";
    }
  }
}

ControlP5 cp5 ;
LightEmulator light ;
String[] btnStrs = {
  "SWITCH_ON", "SWITCH_OFF"
};

void settings() {
  size(210, (btnStrs.length)*30);
}

void setup() {
  frameRate(30);

  // 次に、学習と再生のユーザーインターフェースを作成します。
  cp5 = new ControlP5(this) ;
  // 送信用のボタンを左に、学習用のボタンを右に表示します。
  for ( int bi=0;bi<btnStrs.length;++bi ) {
    cp5.addButton(btnStrs[bi], 0, 0, (bi)*30, 100, 25) ;
  }

  // System.outにログを表示するようにします。
  //Echo.addEventListener( new Echo.Logger(System.out) ) ;

  // 自分自身がLightEmulatorを含むノードになることにしましょう。
  try {
    light = new LightEmulator() ;
    Echo.start( new DefaultNodeProfile(), new DeviceObject[] {
      light
    }
    );
  } 
  catch( IOException e) { 
    e.printStackTrace();
  }
}

void draw() {
  background(backgroundNow);
}

// ボタンが押された時の処理です。
// ※ControlP5ではボタンのラベルがそのまま関数名になります。
public void SWITCH_ON(int theValue) {
  try {
    light.set().reqSetOperationStatus(new byte[]{0x30}).send();
  }
  catch(IOException e) {
    e.printStackTrace();
  }
}
public void SWITCH_OFF(int theValue) {
  try {
    light.set().reqSetOperationStatus(new byte[]{0x31}).send();
  }
  catch(IOException e) {
    e.printStackTrace();
  }
}

