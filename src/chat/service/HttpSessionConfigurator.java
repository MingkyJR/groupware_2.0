package chat.service;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
 
public class HttpSessionConfigurator extends ServerEndpointConfig.Configurator {
  //public static final String Session = "Session";
  //public static final String Context = "Context";
 

  @Override
  public void modifyHandshake(ServerEndpointConfig config, 
                              HandshakeRequest request, 
                              HandshakeResponse response)
  {
      HttpSession httpSession = (HttpSession)request.getHttpSession();
      config.getUserProperties().put(HttpSession.class.getName(),httpSession);
  }
}