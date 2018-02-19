// 電力量センサーは分電盤だけではなく、そのものずばりの電力量センサ
// というクラスもあります。そこから電力量を取得してみましょう。

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.eoj.profile.NodeProfile;
import com.sonycsl.echo.eoj.device.sensor.ElectricEnergySensor ;

import com.sonycsl.echo.processing.defaults.DefaultNodeProfile;
import com.sonycsl.echo.processing.defaults.DefaultController;

// Unsigned byte to int
int bti(byte[] b) {
  int ret = 0 ;
  for ( int bi=0;bi<b.length;++bi ) ret = (ret<<8)|(int)(b[bi]&0xff) ;
  return ret ;
}

void setup() {
  Echo.addEventListener(new Echo.EventListener() {
    public void onNewElectricEnergySensor (ElectricEnergySensor device) {
      println( "ElectricEnergy sensor found.") ;
      device.setReceiver( new ElectricEnergySensor.Receiver() {
        protected void onGetIntegralElectricEnergy (EchoObject eoj, short tid, byte esv, 
                                                      EchoProperty property, boolean success) {
          super.onGetIntegralElectricEnergy(eoj, tid, esv, property, success) ;
          if ( !success ) { 
            println( "error in call reqGetIntegralElectricEnergy" ) ; 
            return ;
          } 
          println("Integral electric energy : "+(0.001*bti(property.edt))+"kWh") ;
        }
        protected void onGetSmallCapacitySensorInstantaneousElectricEnergy (EchoObject eoj, short tid, byte esv, 
                                                                              EchoProperty property, boolean success) {
          super.onGetSmallCapacitySensorInstantaneousElectricEnergy(eoj, tid, esv, property, success) ;
          if ( !success ) { 
            println( "error in call reqGetSmallCapacitySensorInstantaneousElectricEnergy" ) ; 
            return ;
          } 
          println("Small capacity sensor instaneous electric energy : "+(0.1*(bti(property.edt)-0x8001)-3276.7)+"W") ;
        }
        protected void onGetLargeCapacitySensorInstantaneousElectricEnergy (EchoObject eoj, short tid, byte esv,
                                                                              EchoProperty property, boolean success) {
          super.onGetLargeCapacitySensorInstantaneousElectricEnergy(eoj, tid, esv, property, success) ;
          if ( !success ) { 
            println( "error in call reqGetLargeCapacitySensorInstantaneousElectricEnergy" ) ; 
            return ;
          } 
          println("Large capacity sensor instaneous electric energy : "+(0.1*(bti(property.edt)-0x8001)-3276.7)+"W") ;
        }
        protected void onGetIntegralElectricEnergyMeasurementLog (EchoObject eoj, short tid, byte esv, 
                                                                    EchoProperty property, boolean success) {
          super.onGetIntegralElectricEnergyMeasurementLog(eoj, tid, esv, property, success) ;
          if ( !success ) { 
            println( "error in call reqGetIntegralElectricEnergyMeasurementLog" ) ; 
            return ;
          } 
          println("Integram electric energy measurement log : ") ;
          byte[] a = new byte[4] ;
          for ( int i=0;i<48;++i ) {
            System.arraycopy(property.edt, i*4, a, 0, 4) ;
            println(i+": "+(0.001*bti(a))+"kWh") ;
          }
        }
        protected void onGetEffectiveVoltageValue (EchoObject eoj, short tid, byte esv, 
                                                     EchoProperty property, boolean success) {
          super.onGetEffectiveVoltageValue(eoj, tid, esv, property, success) ;
          if ( !success ) { 
            println( "error in call reqGetEffectiveVoltageValue" ) ; 
            return ;
          } 
          println("Effective Voltage : "+bti(property.edt)+"V") ;
        }
      }
      ) ;

      try {
        device.get().reqGetIntegralElectricEnergy().reqGetSmallCapacitySensorInstantaneousElectricEnergy()
          .reqGetLargeCapacitySensorInstantaneousElectricEnergy().reqGetIntegralElectricEnergyMeasurementLog()
          .reqGetEffectiveVoltageValue().send() ;
      } 
      catch(IOException e) {
        e.printStackTrace();
      } 
    }
  }) ;

  try {
    Echo.start( new DefaultNodeProfile(), new DeviceObject[] {
      new DefaultController()
    });
    NodeProfile.getG().reqGetSelfNodeInstanceListS().send();
  } 
  catch( IOException e) { 
    e.printStackTrace();
  }

  println("Started") ;
}

