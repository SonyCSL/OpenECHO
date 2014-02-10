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
  try {
    Echo.start( new DefaultNodeProfile(),new DeviceObject[]{new DefaultController()});

    // 全ての照明のOff
    GeneralLighting.setG().reqSetOperationStatus(new byte[]{0x31}).send();
    // 全てのエアコンのOff
    HomeAirConditioner.setG().reqSetOperationStatus(new byte[]{0x31}).send();
  } catch( IOException e){ 
    e.printStackTrace();
  }
  println("Started") ;
}
