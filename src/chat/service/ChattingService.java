package chat.service;

import java.sql.Connection;
import java.sql.SQLException;

import chat.dao.ChatDAO;
import chat.model.ChatClient;
import jdbc.JdbcUtil;
import jdbc.conn.ConnectionProvider;


public class ChattingService {
		private ChatDAO chatDAO = new ChatDAO();
		
		// 메세지 전송
		public void sendMsg(ChatClient client) {
			Connection conn=null;
			
			try {
				conn = ConnectionProvider.getConnection();
				chatDAO.insert(conn, client);
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				JdbcUtil.close(conn);
			}
			
		}
		
		
		
		
	
	
	
}
