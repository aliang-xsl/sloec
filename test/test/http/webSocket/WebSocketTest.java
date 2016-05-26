package test.http.webSocket;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * 
 * 
 * WebSocketTest
 * 
 * @author aliang
 * @version 1.0
 * @created 2014年7月3日 下午5:09:41
 */

@ServerEndpoint(value = "/webSocketTest", configurator = APPServerEndpointConfig.class)
public class WebSocketTest {

	private Session session;

	private HttpSession httpSession;

	@OnOpen
	public void start(Session session, EndpointConfig config) {
		this.session = session;

		this.httpSession = (HttpSession) config.getUserProperties().get(
				HttpSession.class.getName());

		WebSocketConnections.add(session.getId(), this);

		sendMsg("测试通道！", WebSocketConnections.get(session.getId()),
				session.getId());

	}

	@OnClose
	public void end() {
		WebSocketConnections.remove(session.getId());

	}

	@OnMessage
	public void incoming(String message) {

		sendMsg(message, WebSocketConnections.get(session.getId()),
				session.getId());

	}

	@OnError
	public void onError(Throwable t) throws Throwable {
		WebSocketConnections.remove(session.getId());

	}

	public void sendMsg(String msg, WebSocketTest client, String clientID) {

		try {

			synchronized (client) {
				client.session.getBasicRemote().sendText(msg);
			}

		} catch (IOException e) {

			WebSocketConnections.remove(clientID);

			try {
				client.session.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

	}

}
