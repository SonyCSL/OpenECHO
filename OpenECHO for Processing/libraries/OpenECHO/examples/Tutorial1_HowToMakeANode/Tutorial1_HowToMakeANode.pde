import java.io.IOException;
import com.sonycsl.echo.Echo;
import com.sonycsl.echo.node.EchoNode;
import com.sonycsl.echo.eoj.profile.NodeProfile;
import com.sonycsl.echo.eoj.device.DeviceObject;

import com.sonycsl.echo.processing.defaults.DefaultNodeProfile;
import com.sonycsl.echo.processing.defaults.DefaultController;

void setup() {

  // ノードの作成をします。
  try {
    Echo.start( new DefaultNodeProfile(), new DeviceObject[] {
      new DefaultController()
    });
  } 
  catch( IOException e) { 
    e.printStackTrace();
  }

  while (true) {
    try {
      // ノードに機器オブジェクトのリストを要求します。
      NodeProfile.getG().reqGetSelfNodeInstanceListS().send();

      // すべてのノード
      EchoNode[] nodes = Echo.getNodes() ;
      // 自分のノード
      EchoNode local = Echo.getNode() ;

      for ( EchoNode en : nodes ) {
        if ( en == local ) {
          println("Node id = " + en.getAddress().getHostAddress() + "(local)");
        }
        else {
          println("Node id = " + en.getAddress().getHostAddress());
        }

        println(" Node Profile = " + en.getNodeProfile());

        println(" Devices:");
        DeviceObject[] dos = en.getDevices();

        for ( DeviceObject d : dos ) {
          println("  " + d);
        }
        println("----");
      }
      println("--------");
    } 
    catch( IOException e) { 
      e.printStackTrace();
    }

    // 10秒待つ
    try { 
      Thread.sleep(10000);
    } 
    catch (InterruptedException e) { 
      e.printStackTrace();
    }
  }
}

