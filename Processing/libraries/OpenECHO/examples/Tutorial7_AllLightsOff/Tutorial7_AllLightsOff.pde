// 電気錠(electric lock)の通知を受けて人が在室しているかどうかを
// 取得し、不在ならば全ての照明をオフにします。

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.eoj.profile.NodeProfile;
import com.sonycsl.echo.eoj.device.housingfacilities.ElectricLock ;
import com.sonycsl.echo.eoj.device.housingfacilities.GeneralLighting ;

import com.sonycsl.echo.processing.defaults.DefaultNodeProfile;
import com.sonycsl.echo.processing.defaults.DefaultController;


void setup(){
  Echo.addEventListener(new Echo.EventListener() {
    public void onNewElectricLock (ElectricLock device){
      println( "ElectricLock sensor found.") ;
      device.setReceiver( new ElectricLock.Receiver(){
        protected void onGetLockSetting1 (EchoObject eoj, short tid, byte esv, 
                                            EchoProperty property, boolean success) {
          super.onGetLockSetting1(eoj, tid, esv, property, success) ;
          if( !success ){ println( "error in call reqGetLockSetting1" ) ; return ; } 
          if(property.edt[0]==0x42) { println("unlock") ; return ; }
          
          // 電気錠が施錠されると在室状態を得るために電文を送ります。
          // 但し、在室状態のプロパティは必須項目ではないため確実に取得できるとは限りません。
          try {
            ((ElectricLock)eoj).get().reqGetOccupantNonOccupantStatus().send();
          } catch(IOException e){e.printStackTrace();} ;
        }
        protected void onGetOccupantNonOccupantStatus (EchoObject eoj, short tid, byte esv,
                                                         EchoProperty property, boolean success) {
          super.onGetOccupantNonOccupantStatus(eoj, tid, esv, property, success) ;
          if( !success ){ println( "error in call reqGetOccupantNonOccupantStatus" ) ; return ; } 
          if(property.edt[0]==0x41) { println("occupant") ; return ; }
          
          // 不在状態であるならば全ての照明をオフにする電文をマルチキャストで送ります。
          try {
            GeneralLighting.setG().reqSetOperationStatus(new byte[]{0x31}).send();
          } catch(IOException e){e.printStackTrace();} ;
        }
      }) ;
      
      // 施錠・解錠は状態が変化すると通知されます。
      // なので最初だけgetのリクエストを送信します。
      try{
        device.get().reqGetLockSetting1().send() ;
      } catch(IOException e){e.printStackTrace();} ;
    }
  }) ;

  try {
    Echo.start( new DefaultNodeProfile(),new DeviceObject[]{new DefaultController()});
    NodeProfile.getG().reqGetSelfNodeInstanceListS().send();

  } catch( IOException e){ e.printStackTrace(); }
  
  println("Started") ;
}

