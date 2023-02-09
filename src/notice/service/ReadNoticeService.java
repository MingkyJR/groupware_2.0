package notice.service;
import java.sql.Connection;
import java.sql.SQLException;

import notice.dao.NoticeContentDAO;
import notice.dao.NoticeDAO;
import notice.model.Notice;
import notice.model.NoticeContent;
import jdbc.conn.ConnectionProvider;

//p658
//상세글조회 관련 Service클래스이다.
public class ReadNoticeService {
	//필드
	private NoticeDAO noticeDAO = new NoticeDAO();
	private NoticeContentDAO contentDAO = new NoticeContentDAO();
	
	//p658 17라인
	/*파라미터
	 int no : 상세조회할 글번호
     boolean increaseReadCount:ture(이면 조회수 증가)
	 * 리턴유형
	 NoticeData : notice테이블과 notice_content테이블 관련 데이터*/
	public NoticeData getNotice(int no, boolean increaseReadCount) {
		
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
		
			Notice notice = noticeDAO.selectById(conn, no);
			if(notice==null) { //notice테이블에서 특정글번호에 해당하는 레코드 존재X
				throw new NoticeNotFoundException();
			}
			NoticeContent content = contentDAO.selectById(conn, no);
			if(content==null) { //notice_content 테이블에서 특정글번호에 해당하는 레코드 존재X
				throw new NoticeContentNotFoundException();
			}
		
			//특정글번호 상세조회시 조회수 증가~~~~~~~~~~~~조회수 증가관련 p659 27라인~ 추가예정~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			//여기서부터 하자~~~ dao조회수 증가쿼리문 메소드 작성!!합시다!! 230113여기까지 했음
			if(increaseReadCount) {
				noticeDAO.increaseReadCount(conn, no);
			}
			
			
			
			
			return new NoticeData(notice, content);
		}catch(SQLException e) {
			System.out.println("ReadNoticeService-getNotice()발생시 exception발생");
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	//생성자
	
	
	
	
	
	
	
	
	
	//메소드
}
