package notice.service;

import java.sql.Connection;
import java.sql.SQLException;

import notice.dao.NoticeContentDAO;
import notice.dao.NoticeDAO;
import jdbc.JdbcUtil;
import jdbc.conn.ConnectionProvider;

//삭제처리 관련 Service 클래스
public class DeleteNoticeService {

	//필드
	private NoticeDAO noticeDAO = new NoticeDAO();
	private NoticeContentDAO noticeContentDAO = new NoticeContentDAO();
	
	
	//생성자
	
	
	//메소드
	//삭제(delete용)
	/*파라미터 int no : 삭제할 글번호
	   리턴타입 int cnt: 삭제(delete)된 행 수. 1이면 삭제성공, 0이면 삭제실패*/
	public int deleteNotice(int no) {
		Connection conn = null;
		int cnt=0;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);//auto커밋false설정
			cnt = noticeContentDAO.deleteNotice(conn, no); //notice_content 테이블에서 삭제(자식테이블 먼저 삭제)
			if(cnt==0) {
				throw new NoticeContentNotFoundException();
			}
			if(cnt==1) {
				cnt = noticeDAO.deleteNotice(conn, no); //notice테이블에서 삭제
			}
			conn.commit();//커밋
			return cnt;
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
		}finally {
			JdbcUtil.close(conn);
		}
		return cnt;
	}
	
	//삭제(update용)
	/*파라미터 int no : 삭제할 글번호
	   리턴타입 int cnt: 삭제(update)된 행 수. 1이면 삭제성공, 0이면 삭제실패*/
	public int deleteNotice2(int no) {
		Connection conn = null;
		int cnt=0;
		try {
			conn = ConnectionProvider.getConnection();
			cnt = noticeDAO.deleteNotice2(conn, no);
			return cnt;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn);
		}
		return cnt;
	}
}
