import java.io.IOException;
import processing.net.*;
import controlP5.*;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.node.EchoNode;
import com.sonycsl.echo.eoj.profile.NodeProfile;
import com.sonycsl.echo.eoj.device.DeviceObject;

import com.sonycsl.echo.processing.defaults.DefaultNodeProfile;
import com.sonycsl.echo.eoj.device.housingfacilities.GeneralLighting;

// iRemoconIPはiRemoconアプリで調べたIPアドレスに書き換えてください。
final String iRemoconIP = "192.168.126.101" ;
final int iRemoconPort = 51013 ;

// このアプリで用いるコマンドの番号を扱いやすいように定数にしておきます。
// ベースの番号を適当に定義しました。本来はすでに定義されている番号と
// かち合わない番号にしないといけません。
final int iBase = 100 ;
final int SWITCH_ON = 0 + iBase ;
final int SWITCH_OFF = 1 + iBase ;
// ボタンを作成する時の文字列です。
String[] btnStrs = {"SWITCH_ON","SWITCH_OFF"} ;


void iRemoconLearn(int id){
  println( "iRemoconLearn : "+btnStrs[id-SWITCH_ON] ) ;
  Client c = new Client(this,iRemoconIP,iRemoconPort) ;
  c.write("*ic;"+id+"\r\n");
  c.stop() ;
}

void iRemoconSend(int id){
  println( "iRemoconSend : "+btnStrs[id-SWITCH_ON] ) ;
  Client c = new Client(this,iRemoconIP,iRemoconPort) ;
  c.write("*is;"+id+"\r\n");
  c.stop() ;
}

// 照明クラスを実装します。
public class iRemoconLight extends GeneralLighting {
  byte[] mStatus = {0x31};// 初期の電源状態はOFFだと仮定します。
  byte[] mLocation = {0x00};
  byte[] mVersion = {0x01, 0x01, 0x61, 0x00};
  byte[] mFaultStatus = {0x42};
  byte[] mManufacturerCode = {0,0,0};
  byte[] mLightingMode = {0x42}; // 照明のモードです。

  protected boolean setOperationStatus(byte[] edt) {
    iRemoconSend( edt[0] == 0x30 ? SWITCH_ON : SWITCH_OFF ) ;
    mStatus[0] = edt[0] ;
    //電源状態が変化したことを他のノードに通知します
    try { inform().reqInformOperationStatus().send(); } catch (IOException e) { e.printStackTrace();}
    return true;
  }
  // 現在の電源状態を問われたら、前回送ったコマンドをそのまま返します。
  protected byte[] getOperationStatus() { return mStatus; }
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
  protected byte[] getInstallationLocation() {return mLocation;}
  protected byte[] getStandardVersionInformation() {return mVersion;}
  protected byte[] getFaultStatus() {  return mFaultStatus;}
  protected byte[] getManufacturerCode() {return mManufacturerCode;}
  protected byte[] getLightingModeSetting() { return mLightingMode;}

  protected boolean setLightingModeSetting(byte[] edt) {
    mLightingMode[0] = edt[0];
    return true;
  }
}

ControlP5 cp5 ;
iRemoconLight light ;

void settings() {
  size(210, (btnStrs.length)*30);
}

void setup() {
  Echo.addEventListener(new Echo.Logger(System.out));
  frameRate(30);

  // 次に、学習と再生のユーザーインターフェースを作成します。
  cp5 = new ControlP5(this) ;
  // 送信用のボタンを左に、学習用のボタンを右に表示します。
  for( int bi=0;bi<btnStrs.length;++bi ){
    cp5.addButton(btnStrs[bi],0,0,(bi)*30,100,25) ;
    cp5.addButton("LEARN_"+btnStrs[bi],0,110,(bi)*30,100,25) ;
  }

  try {
      light = new iRemoconLight() ;
      Echo.start( new DefaultNodeProfile(),new DeviceObject[]{light});
  } catch( IOException e){ e.printStackTrace(); }
}

// ボタンを描画するためだけに定義しています。
void draw(){}

// ボタンが押された時の処理です。
// 送信用の関数と、学習用の関数を交互に定義しています。
// ※ControlP5ではボタンのラベルがそのまま関数名になります。
// light.setOperationStatus(new byte[]{0x30});としてはいけません！！！
public void SWITCH_ON(int theValue){
  try{
    light.set().reqSetOperationStatus(new byte[]{0x30}).send();
  } catch(IOException e) {e.printStackTrace();}
}
public void LEARN_SWITCH_ON(int theValue){
  iRemoconLearn(SWITCH_ON);
}
public void SWITCH_OFF(int theValue){
  try{
    light.set().reqSetOperationStatus(new byte[]{0x31}).send();
  } catch(IOException e) {e.printStackTrace();}
}
public void LEARN_SWITCH_OFF(int theValue){
  iRemoconLearn(SWITCH_OFF) ;
}
