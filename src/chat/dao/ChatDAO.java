package chat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import auth.service.User;
import chat.model.ChatClient;
import chat.model.MessageVO;
import jdbc.JdbcUtil;

//이 클래스는 DAO로서 주로 회원관련 DB작업을 수행
public class ChatDAO {
	
	
	//채팅 내용  insert
	public void insert(Connection conn, ChatClient client) {
		PreparedStatement stmt = null;
		String sql =  
				"insert into chat(chat_no, emp_no, emp_name, chat_content) " + 
				"values(chat_seq.nextval, ?, ?, ?)";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, client.getEmp_no());
			stmt.setString(2, client.getName());
			stmt.setString(3, client.getContent());
			int result = stmt.executeUpdate();
			System.out.println("result=>"+result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
		}
		
		
	}
	
	//채팅 내용 조회(전체)
	/*파라미터 
	   int startRow:시작행인덱번호, 가장 첫 번째 행은 0부터 시작
	   int rsize:    1페이지당출력게시물 */
	public List<MessageVO> selectByContent(Connection conn) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = 
				"select chat_no, emp_no, emp_name, chat_content, chat_time " + 
				"from chat " + 
				"order by chat_no asc";
		List<MessageVO> mVOList = new ArrayList<MessageVO>();

		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				MessageVO messageVO = new MessageVO(rs.getInt("chat_no"),
													rs.getString("emp_name"),
													rs.getString("chat_content"),
													toDate(rs.getTimestamp("chat_time")));
				mVOList.add(messageVO);								
			}
			return mVOList;
			
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	//Timestamp->Date객체로 변환하기:p648 47라인
		private Date toDate(Timestamp timestamp) {
			return new Date(timestamp.getTime());
		}


}
				
		
	
		
		
	
	
	
	
	
	
	
	
	

