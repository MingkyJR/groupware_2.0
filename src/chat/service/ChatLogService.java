package chat.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import chat.dao.ChatDAO;
import chat.model.MessageVO;
import jdbc.JdbcUtil;
import jdbc.conn.ConnectionProvider;

//이 클래스는 chatRoom을 생성하는 서비스를 제공해주는 클래스이다.
public class ChatLogService {
	//필드
	ChatDAO chatDAO = new ChatDAO();

	public List<MessageVO> selectByContent() {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			//int total = chatDAO.selectCount(conn);
			List<MessageVO> mVOList = chatDAO.selectByContent(conn);
			
			return mVOList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			JdbcUtil.close(conn);
		}
		
		
	}
	

	 
	 
	
	
	

}
