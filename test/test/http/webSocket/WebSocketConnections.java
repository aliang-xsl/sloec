package test.http.webSocket;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 *   WebSocket 连接
 *  
 * @author aliang    
 * @version 1.0  
 * @created 2014年7月3日 下午5:18:59
 */
public class WebSocketConnections {
	
	private static  Map<String, WebSocketTest> m=new HashMap<String, WebSocketTest>();


	public   static void add(String key,WebSocketTest onlineUserHandler){
		m.put(key, onlineUserHandler);
	}
	
	public static  WebSocketTest get(String key){
		return m.get(key);
	}
	
	public static  void remove(String key){
		m.remove(key);
	}
	
	private WebSocketConnections(){};

}
