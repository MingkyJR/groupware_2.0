package chat.service;


import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import chat.model.ChatClient;


@ServerEndpoint(value="/webChatServer", configurator = HttpSessionConfigurator.class )
public class WebChatServer  {
	private ChatClient client = new ChatClient();
	 private HttpSession httpSession;
	//접속된 클라이언트 WebSocket session 관리 
	private static Map<Session,ChatClient> users = Collections.synchronizedMap(new HashMap<Session, ChatClient>());
	//WebSocket으로 브라우저가 접속하면 요청되는 함수
	@OnOpen
	public void onOpen(Session session, EndpointConfig config){
		this.httpSession = (HttpSession)config.getUserProperties().get(HttpSession.class.getName());
		String userName = (String)httpSession.getAttribute("name");
		int empNo = (int)httpSession.getAttribute("empNo");
		client.setName(userName);
		client.setEmp_no(empNo);
		//System.out.println(session + "connect");
	
		users.put(session, client);
		sendNotice(userName + "님이 입장하셨습니다. 현재 접속자 " + users.size() + "명");
	}
	
	@OnMessage
	public void onMsg(String message, Session session) throws IOException{
		String userName = users.get(session).getName();
		System.out.println(userName + " : " + message);
		client.setContent(message);
		
		ChattingService chatService = new ChattingService();
		
		chatService.sendMsg(client);
		synchronized (users) {
			Iterator<Session> iterator = users.keySet().iterator();
			while(iterator.hasNext()){
				Session curSession = iterator.next();
				if(!curSession.equals(session)){
					curSession.getBasicRemote().sendText(userName + " : " + message);
				}
			}
		}
		
	}
	@OnClose
	public void onClose(Session session) {
		
		String userName = users.get(session).getName();
		users.remove(session);
		
		sendNotice(userName + "님이 퇴장하셨습니다. 현재 접속자 " + users.size() + "명");
		
		
	}

	public void sendNotice(String message){
		String userName = "Server";
		System.out.println(userName + ":" + message);
		
		synchronized (users) {
			Iterator<Session> iterator = users.keySet().iterator();
			while(iterator.hasNext()){
				Session currentSession = iterator.next();
				try {
					currentSession.getBasicRemote().sendText(userName + ":" + message);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}//sendNotice 
	
	
	
	
	
	
}//WebChatServer 끝