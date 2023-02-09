package notice.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.conn.ConnectionProvider;
import notice.dao.NoticeDAO;
import notice.model.Notice;

public class SearchNoticeService_ {
	
	//필드
	private NoticeDAO noticeDAO = new NoticeDAO();
	Connection conn = null;
	
	public NoticePage getSearchList(String choice, String keyword, int pageNo, int size) { //리턴 유형이 바뀜
		try{
		conn = ConnectionProvider.getConnection();
				
		int total = noticeDAO.searchSelectCount(conn, choice, keyword);//전체 조회
		List<Notice> noticeList = noticeDAO.searchSelect(conn, choice, keyword, (pageNo-1)*size, size);
		
		
//		System.out.println("777777777777777777777777777777777777777777777777777"+total);
//		System.out.println("777777777777777777777777777777777777777777777777"+noticeList);
		
		return new NoticePage(total, pageNo, size, noticeList);
		
		}catch(SQLException e){
		throw new RuntimeException();
		}finally {
			JdbcUtil.close(conn);
		}
		
	}


}
