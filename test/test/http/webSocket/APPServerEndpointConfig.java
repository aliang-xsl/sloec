package test.http.webSocket;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;


/**
 * 
 * webSocket   configurator
 *  
 *  用户获取 httpSession
 *  
 * @author aliang    
 * @version 1.0  
 * @created 2014年7月4日 上午10:15:52
 */
public class APPServerEndpointConfig extends  ServerEndpointConfig.Configurator{

	
	 @Override
	    public void modifyHandshake(ServerEndpointConfig config,  HandshakeRequest request, HandshakeResponse response)
	    {
	        HttpSession httpSession = (HttpSession)request.getHttpSession();
	        config.getUserProperties().put(HttpSession.class.getName(),httpSession);
	    }
	
	
}
