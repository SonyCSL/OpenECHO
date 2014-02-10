// 温度や湿度を取得したいことはよくあると思うので、ノードを探して
// どちらかのセンサーがあったら登録し、値を取得するサンプルプログラムです。
import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.eoj.profile.NodeProfile;
import com.sonycsl.echo.eoj.device.sensor.TemperatureSensor ;
import com.sonycsl.echo.eoj.device.sensor.HumiditySensor ;

import com.sonycsl.echo.processing.defaults.DefaultNodeProfile;
import com.sonycsl.echo.processing.defaults.DefaultController;

// Unsigned byte to int
int bti(byte[] b){
  int ret = 0 ;
  for( int bi=0;bi<b.length;++bi ) ret = (ret<<8)|(int)(b[bi]&0xff) ;
  return ret ;
}

void setup(){
  Echo.addEventListener(new Echo.EventListener() {
    public void onNewTemperatureSensor (TemperatureSensor device){
      println( "Temperature sensor found.") ;
      device.setReceiver( new TemperatureSensor.Receiver(){
        protected void onGetMeasuredTemperatureValue  (EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
         super.onGetMeasuredTemperatureValue(eoj, tid, esv, property, success);
         int ti = bti(property.edt) ;
         //ECHONET Liteでは温度の10倍の値が返ってくるので、1/10倍する
         float tmpe = ti * 0.1;
         println("Temperature : "+ tmpe + " degree");
        }
      }) ;
      try {
        device.get().reqGetMeasuredTemperatureValue().send() ;
      } catch( IOException e){ e.printStackTrace(); }
    }

    public void onNewHumiditySensor (HumiditySensor device){
      println( "Humidity sensor found.") ;
      device.setReceiver( new HumiditySensor.Receiver(){
        protected void onGetMeasuredValueOfRelativeHumidity  (EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
         super.onGetMeasuredValueOfRelativeHumidity(eoj, tid, esv, property, success);
         println("Humidity : "+property.edt[0]+"%") ;
        }
      }) ;
      try {
        device.get().reqGetMeasuredValueOfRelativeHumidity().send() ;
      } catch( IOException e){ e.printStackTrace(); }
    }
  }) ;

  try {
    Echo.start( new DefaultNodeProfile(),new DeviceObject[]{new DefaultController()});
    NodeProfile.getG().reqGetSelfNodeInstanceListS().send();
  } catch( IOException e){ e.printStackTrace(); }  
  println("Started") ;
}

