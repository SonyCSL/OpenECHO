import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.eoj.profile.NodeProfile;
import com.sonycsl.echo.eoj.device.housingfacilities.GeneralLighting ;
import com.sonycsl.echo.eoj.device.airconditioner.HomeAirConditioner;

import com.sonycsl.echo.processing.defaults.DefaultNodeProfile;
import com.sonycsl.echo.processing.defaults.DefaultController;


void setup(){
  // GeneralLighting/HomeAirConditionerが見付かった時のハンドラを定義する
  // (一斉にイベントを送るのでなく、個々の機器に別々にリクエストを送りたい時
  // にはこちらを使う)
  Echo.addEventListener(new Echo.EventListener() {
    public void onNewGeneralLighting (GeneralLighting device){
      super.onNewGeneralLighting(device);
      println( "General Lighting found.");

      // ここで必要な照明のみを対象にするようなコードを加える
      try {
        device.set().reqSetOperationStatus( new byte[]{0x31}).send() ;
      } catch(IOException e){
        e.printStackTrace();
      }
    }
    public void onNewHomeAirConditioner (HomeAirConditioner device){
      super.onNewHomeAirConditioner (device);
      println( "HomeAirConditioner found.");

      // ここで必要なエアコンのみを対象にするようなコードを加える

      try {
        device.set().reqSetOperationStatus( new byte[]{0x31}).send() ;
      } catch(IOException e){
        e.printStackTrace();
      }
   }
  });

  try {
    Echo.start( new DefaultNodeProfile(),new DeviceObject[]{new DefaultController()});
    NodeProfile.getG().reqGetSelfNodeInstanceListS().send();
  } catch( IOException e){
    e.printStackTrace(); 
  }
  println("Started") ;
}
