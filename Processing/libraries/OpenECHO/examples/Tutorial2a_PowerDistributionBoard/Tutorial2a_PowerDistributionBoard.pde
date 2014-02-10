import java.io.IOException;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.node.EchoNode;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.eoj.device.managementoperation.Controller ;
import com.sonycsl.echo.eoj.device.housingfacilities.PowerDistributionBoardMetering;
import com.sonycsl.echo.eoj.profile.NodeProfile;

import com.sonycsl.echo.processing.defaults.DefaultNodeProfile;
import com.sonycsl.echo.processing.defaults.DefaultController;

void setup() {
  // EventListenerを設定します。
  Echo.addEventListener(new Echo.EventListener() {
    // コントローラがみつかった時に呼びだされるコールバックの設定です。
    public void onNewController( Controller device ) {
      // まず、親クラスの同メソッドを呼び出しておきましょう。
      super.onNewController(device);
      println("Controller found.") ;

      // レシーバーを設定します。
      device.setReceiver(new Controller.Receiver() {
        // 各パラメータの意味は以下のようになっています。
        // eoj:ECHNOETオブジェクト
        // tid:トランザクションID
        // esv:ECHONET Liteサービス
        // property.epc:ECHONETプロパティID
        // property.pdc:プロパティデータカウンタ
        // property.edt:ECHONETプロパティ値データ
        //-----
        // success:正しい応答が返ってきたかどうか
        //-----
        // 詳細はECHONET Lite規格書の第二部を参照してください。
        // ON/OFFを取得する。
        protected void onGetOperationStatus(EchoObject eoj, short tid, byte esv,
        EchoProperty property, boolean success) {
          super.onGetOperationStatus(eoj, tid, esv, property, success);
          System.out.println("Controller power : "+toHexStr(property.edt));
        }
        // 設置場所情報も取得してみましょう。
        protected void onGetInstallationLocation  (EchoObject eoj, short tid, byte esv,
        EchoProperty property, boolean success) {
          super.onGetInstallationLocation  (eoj, tid, esv, property, success) ;
          System.out.println("Installation location : "+toHexStr(property.edt));
        }
      }) ;

      // そして、次にこの機器に対してリクエストを送りますが、ECHONET Liteでは
      // 同種のリクエストであればまとめて送信することができます。
      try {
        device.get().reqGetOperationStatus().reqGetInstallationLocation().send() ;
      }
      catch(IOException e) {
        e.printStackTrace();
      }
    }


    public void onNewPowerDistributionBoardMetering(PowerDistributionBoardMetering device) {
      super.onNewPowerDistributionBoardMetering(device);
      println("PowerDistributionBoardMetering found.") ;
      // 分電盤では電力量を取得してみましょう。
      device.setReceiver(new PowerDistributionBoardMetering.Receiver() {
        // 電力量用のコールバック関数。
        protected void onGetMeasuredInstantaneousCurrents(EchoObject eoj, short tid, byte esv,
        EchoProperty property, boolean success) {
          super.onGetMeasuredInstantaneousCurrents(eoj, tid, esv, property, success) ;
          System.out.println("GetMeasuredInstantaneousCurrents IntCur : "+toHexStr(property.edt));
        }
        // ここでonGetPowerに加え、トータルの電力消費量を取得します。
        protected void onGetOperationStatus(EchoObject eoj, short tid, byte esv,
        EchoProperty property, boolean success) {
          super.onGetOperationStatus(eoj, tid, esv, property, success);
          System.out.println("PowerDistributionBoardMetering power : "+toHexStr(property.edt));
        }
      }) ;
      try {
        device.get().reqGetMeasuredInstantaneousCurrents().reqGetOperationStatus().send() ;
      }
      catch(IOException e) {
        e.printStackTrace();
      }
    }
  }) ;


  //準備が完了したので、機器一覧を得ることにします。
  try {
    //これまでと同じようにネットワーク上のノード一覧(正確には、
    //NodeProfileの一覧)を取得します
    Echo.start( new DefaultNodeProfile(), new DeviceObject[] {
      new DefaultController()
    });
    while (true) {
      // ノード一覧の取得をリクエストしています。
      NodeProfile.getG().reqGetSelfNodeInstanceListS().send();
      try {
        Thread.sleep(10000);
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  catch( IOException e) {
    e.printStackTrace();
  }
}

String toHexStr(byte[] arg) {
  String ret = "" ;
  for ( int i=0;i<arg.length;++i ) ret = Integer.toHexString(arg[i] & 0xff)+ret ;
  return ret ;
}
