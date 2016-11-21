import java.io.IOException;
import processing.net.*;
import controlP5.*;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.node.EchoNode;
import com.sonycsl.echo.eoj.profile.NodeProfile;
import com.sonycsl.echo.eoj.device.DeviceObject;

import com.sonycsl.echo.eoj.profile.NodeProfile;
import com.sonycsl.echo.eoj.device.airconditioner.HomeAirConditioner;

// iRemoconIPはiRemoconアプリで調べたIPアドレスに書き換えてください。
String iRemoconIP = "192.168.126.101" ;
int iRemoconPort = 51013 ;

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

// このアプリで用いるコマンドの番号を扱いやすいように定数にしておきます。
// ベースの番号を適当に定義しました。本来はすでに定義されている番号と
// かち合わない番号にしないといけません。
final int iBase = 100 ;
final int SWITCH_ON = 0 + iBase ;
final int SWITCH_OFF = 1 + iBase ;
final int AUTO_MODE = 2 + iBase ;
final int COOL_MODE = 3 + iBase ;
final int HEAT_MODE = 4 + iBase ;
final int DRY_MODE = 5 + iBase ;
final int TEMP18 = 6 + iBase ;
final int TEMP19 = 7 + iBase ;
final int TEMP20 = 8 + iBase ;
final int TEMP21 = 9 + iBase ;
final int TEMP22 = 10 + iBase ;
// ボタンを作成する時の文字列です。
String[] btnStrs = {"SWITCH_ON","SWITCH_OFF","AUTO_MODE","COOL_MODE",
          "HEAT_MODE","DRY_MODE","TEMP18","TEMP19","TEMP20","TEMP21","TEMP22"} ;


//次に、OpenECHOの設定を記述します。
//まずお決まりのノードプロファイルを作りましょう。
public class MyNodeProfile extends NodeProfile {
  byte[] mManufactureCode = {0,0,0};
  byte[] mStatus = {0x30};
  byte[] mVersion = {1,1,1,0};
  byte[] mIdNumber = {(byte)0xFE,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
  byte[] mUniqueId = {0,0};
  protected byte[] getManufacturerCode() {return mManufactureCode;}
  protected byte[] getOperatingStatus() {  return mStatus;  }
  protected byte[] getVersionInformation() {return mVersion;}
  protected byte[] getIdentificationNumber() {return mIdNumber;}
  protected boolean setUniqueIdentifierData(byte[] edt) {
    if((edt[0] & 0x40) != 0x40)   return false;
    mUniqueId[0] = (byte)((edt[0] & (byte)0x7F) | (mUniqueId[0] & 0x80));
    mUniqueId[1] = edt[1];
    return true;
  }
  protected byte[] getUniqueIdentifierData() {return mUniqueId;}
  protected byte[] getStatusChangeAnnouncementPropertyMap() {  return null;}
  protected byte[] getSetPropertyMap() {return null;}
  protected byte[] getGetPropertyMap() {return null;}
}

//次に、エアコンクラスを継承してiRemoconAirconを作りましょう。
//必須プロパティである動作状態(ONかOFFか)と、運転モード、それに
//温度設定のみ作ることにします。
public class iRemoconAircon extends HomeAirConditioner {
  byte[] mStatus = {0x31};// 初期の電源状態はOFFだと仮定します。
  byte[] mMode = {0x41};  // 初期モードは自動モードと仮定します。
  byte[] mTemperature = {20}; // 初期の設定温度は18度と仮定します。

  //////////////////////////////////
  // 以下、必須プロパティの適当な実装です。
  // 本当はもっときちんと実装しなければいけなさそうです。
  //////////////////////////////////

  byte[] mLocation = {0x00};
  byte[] mVersion = {0x01, 0x01, 0x61, 0x00};
  byte[] mFaultStatus = {0x42};
  byte[] mManufacturerCode = {0,0,0};

  protected boolean setInstallationLocation(byte[] edt) {return true;}
  protected byte[] getInstallationLocation() {return mLocation;}
  protected byte[] getStandardVersionInformation() {return mVersion;}
  protected byte[] getFaultStatus() {  return mFaultStatus;}
  protected byte[] getManufacturerCode() {return mManufacturerCode;}
  protected byte[] getStatusChangeAnnouncementPropertyMap() {  return null;}
  protected byte[] getSetPropertyMap() {return null;}
  protected byte[] getGetPropertyMap() {return null;}

  // 以下は真面目な実装です。
  // 電源のON/OFF操作です。
  protected boolean setOperationStatus(byte[] edt) {
    if(edt[0] == 0x30){
      iRemoconSend( SWITCH_ON );
    }else{
      iRemoconSend( SWITCH_OFF );
    }
    mStatus[0] = edt[0];
    try {
      inform().reqInformOperationStatus().send();
    } catch (IOException e) { e.printStackTrace();}
    return true;
  }

  // 現在の電源状態を問われたら、前回送ったコマンドをそのまま返します。
  protected byte[] getOperationStatus() {
    println("operation status requested : "+mStatus[0]);
    return mStatus;
  }

  // より操作しやすい関数を作ってみました。
  // ※HomeAirConditionerからのオーバーライドではありません。
  public void setOperationStatusBoolean(boolean is_on){
    // 中でSetterを使って機器を制御します。ここで、直接setOperationStatusを
    // 呼びだしてはいけません。
    try{
      if(is_on){
        this.set().reqSetOperationStatus(new byte[]{(byte)0x30}).send();
      }else{
        this.set().reqSetOperationStatus(new byte[]{(byte)0x31}).send();
      }
    }catch (IOException e){
      e.printStackTrace();
    }
  }

  // 動作モードの変更です。
  protected boolean setOperationModeSetting(byte[] edt) {

    // ちょっとトリッキーですが、AUTO_MODE-DRY_MODEの値を作ります。
    int mode = edt[0] - 0x41 + AUTO_MODE;
    iRemoconSend(mode);
    mMode[0] = edt[0];

    try {
      inform().reqInformOperationModeSetting().send();
    } catch (IOException e) { e.printStackTrace();}
    return true;
  }

  protected byte[] getOperationModeSetting() {return mMode;}

  // より操作しやすい関数を作ってみました。
  // ※HomeAirConditionerからのオーバーライドではありません。
  // 引数はAUTO_MODE,COOL_MODE,DRY_MODE,HEAT_MODEのどれかです。
  // (iRemoconのコマンド番号と同一である必要はありませんが
  // コードを短く保つために流用しています。
  public void setOperationModeSettingInt(int mode) {
    byte toSend = (byte)(0x41+(mode-AUTO_MODE));
    try{
      this.set().reqSetOperationModeSetting(new byte[]{toSend}).send();
    } catch (IOException e){
      e.printStackTrace();
    }
  }


  // 温度の変更です
  protected boolean setSetTemperatureValue(byte[] edt) {
    //edt[0]を18-22に制限します
    edt[0] = (byte)min(edt[0],22);
    edt[0] = (byte)max(edt[0],18);

    // edt[0]から、送る値をつくります。
    iRemoconSend(edt[0] - 18 + TEMP18);
    mTemperature[0] = edt[0];
    return true;
  }

  protected byte[] getSetTemperatureValue() {  return mTemperature;}

  // より操作しやすい関数を作ってみました。
  // ※HomeAirConditionerからのオーバーライドではありません。
  protected void setTemperatureValueInt(int temp) {
    try{
      this.set().reqSetSetTemperatureValue(new byte[]{(byte)temp}).send();
    } catch(IOException e){
      e.printStackTrace();
    }
  }
}

ControlP5 cp5 ;
iRemoconAircon aircon ;

void settings() {
  size(210, (btnStrs.length)*30);
}

void setup() {
  frameRate(30);

  cp5 = new ControlP5(this) ;
  // 送信用のボタンを左に、学習用のボタンを右に表示します。
  for( int bi=0;bi<btnStrs.length;++bi ){
    cp5.addButton(btnStrs[bi],0,0,(bi)*30,100,25) ;
    cp5.addButton("LEARN_"+btnStrs[bi],0,110,(bi)*30,100,25) ;
  }

  // System.outにログを表示するようにします。
  Echo.addEventListener( new Echo.Logger(System.out) ) ;

  try {
      aircon = new iRemoconAircon() ;
      Echo.start( new MyNodeProfile(),new DeviceObject[]{aircon});
  } catch( IOException e){ e.printStackTrace(); }
}

// ボタンを描画するためだけに定義しています。
void draw(){}

// ボタンが押された時の処理です。
// 送信用の関数と、学習用の関数を交互に定義しています。
// ※ControlP5ではボタンのラベルがそのまま関数名になります。
public void SWITCH_ON(int theValue){
  aircon.setOperationStatusBoolean(true) ;
}
public void LEARN_SWITCH_ON(int theValue){
  iRemoconLearn(SWITCH_ON) ;
}
public void SWITCH_OFF(int theValue){
  aircon.setOperationStatusBoolean(false) ;
}
public void LEARN_SWITCH_OFF(int theValue){
  iRemoconLearn(SWITCH_OFF) ;
}
public void AUTO_MODE(int theValue){
  aircon.setOperationModeSettingInt(AUTO_MODE) ;
}
public void LEARN_AUTO_MODE(int theValue){
  iRemoconLearn(AUTO_MODE) ;
}
public void COOL_MODE(int theValue){
  aircon.setOperationModeSettingInt(COOL_MODE) ;
}
public void LEARN_COOL_MODE(int theValue){
  iRemoconLearn(COOL_MODE) ;
}
public void HEAT_MODE(int theValue){
  aircon.setOperationModeSettingInt(HEAT_MODE) ;
}
public void LEARN_HEAT_MODE(int theValue){
  iRemoconLearn(HEAT_MODE) ;
}
public void DRY_MODE(int theValue){
  aircon.setOperationModeSettingInt(DRY_MODE) ;
}
public void LEARN_DRY_MODE(int theValue){
  iRemoconLearn(DRY_MODE) ;
}
public void TEMP18(int theValue){
  aircon.setTemperatureValueInt(18) ;
}
public void LEARN_TEMP18(int theValue){
  iRemoconLearn(TEMP18) ;
}
public void TEMP19(int theValue){
  aircon.setTemperatureValueInt(19) ;
}
public void LEARN_TEMP19(int theValue){
  iRemoconLearn(TEMP19) ;
}
public void TEMP20(int theValue){
  aircon.setTemperatureValueInt(20) ;
}
public void LEARN_TEMP20(int theValue){
  iRemoconLearn(TEMP20) ;
}
public void TEMP21(int theValue){
  aircon.setTemperatureValueInt(21) ;
}
public void LEARN_TEMP21(int theValue){
  iRemoconLearn(TEMP21) ;
}
public void TEMP22(int theValue){
  aircon.setTemperatureValueInt(22) ;
}
public void LEARN_TEMP22(int theValue){
  iRemoconLearn(TEMP22) ;
}
