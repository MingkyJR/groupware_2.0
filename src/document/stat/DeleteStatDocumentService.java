package document.stat;

import java.sql.Connection;
import java.sql.SQLException;

import document.dao.DocumentDAO;
import jdbc.JdbcUtil;
import jdbc.conn.ConnectionProvider;

//삭제처리관련 Service클래스
public class DeleteStatDocumentService {
	private DocumentDAO documentDAO = new DocumentDAO();
	
	//삭제(update용)
	/*파라미터  int no : 삭제할 글번호
	 *리턴타입  int : 삭제(update)된 행 수. 1이면 삭제성공,0이면 삭제실패*/
	public int deleteDocument(int no) {
		Connection conn = null;
		int cnt = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			cnt = documentDAO.deleteDocument(conn,no);
			return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn);
		}
		return cnt;
		
	}
	
	
}




