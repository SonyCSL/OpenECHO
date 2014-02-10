import processing.net.*;
import com.sonycsl.echo.Echo;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.eoj.profile.NodeProfile;
import com.sonycsl.echo.eoj.device.airconditioner.HomeAirConditioner;

import com.sonycsl.echo.processing.defaults.DefaultNodeProfile;
import com.sonycsl.echo.processing.defaults.DefaultController;

Server myServer ;
HomeAirConditioner airCond ;

void setup(){
  
  Echo.addEventListener(new Echo.EventListener() {
    // エアコンが発見された時のハンドラーを追加。
    public void onNewHomeAirConditioner (HomeAirConditioner device){
      super.onNewHomeAirConditioner (device);
      println( "HomeAirConditioner found.");
      // インスタンスを変数に保存しておくだけ。
      airCond = device ;
   }
  });

  try {
    // 機器発見を行う。
    Echo.start( new DefaultNodeProfile(),new DeviceObject[]{new DefaultController()});
    NodeProfile.getG().reqGetSelfNodeInstanceListS().send();
  } catch( IOException e){
    e.printStackTrace(); 
  }

  // JSONPサーバの開始
  myServer = new Server(this,31413) ;
}

void draw(){
  // データを受信したかを判定
  Client c = myServer.available() ;
  if( c == null || c.available() == 0 ) return ;

  // 一行読み込み、"GET"から始まる行じゃない場合は弾く。
  final int lf = 0x0a ;
  String getstr = c.readStringUntil(lf) ;
  if( getstr == null || !getstr.startsWith("GET") ) return ;
  // GET行をスペースで区切り、二つ目の引数を取り出す。
  String pathall = getstr.split(" ")[1] ;
  
  // ?より後ろを取り出し、&で分ける。
  String[] args = pathall.substring(pathall.indexOf("?")+1).split("&") ;

  // &で区切られた各文字列を、さらに=で区切ってkey,valueとし、HashMapに入れる ⇒ URL引数（GET引数)
  HashMap<String,String> m = new HashMap<String,String>() ; 
  for( String term : args ){
    String[] lr = term.split("=");
    if( lr.length < 2 ) continue ;
    m.put(lr[0],lr[1]) ;
  }


  String result ;

  //　もしエアコンが発見されてて、かつpropとvalueがあればその値をセットする。
  if( airCond != null && m.get("prop")!=null && m.get("value")!=null){
      try {
        //16進数限定
        airCond.set().reqSetProperty(
            Integer.decode(m.get("prop")).byteValue()
          , new byte[]{Integer.decode(m.get("value")).byteValue()}).send() ;
        result = "Success" ; 
      } catch(Exception e){
        e.printStackTrace();
        result = "Error : "+e.toString() ;
      }
  } else result = "Airconditioner not found" ;

  // 結果をJSONオブジェクトとして返す。jsoncallbackで囲む。
  String st = m.get("jsoncallback") + "( {\"result\":\""+result+"\"} )" ;
  c.write( "HTTP/1.1 200 OK\nConnection: close\nContent-Length: "+st.length()+"\n"
      + "Content-Type: application/json\n\n" ) ;
  c.write(st) ;
}
