package document.stat;

import java.sql.Connection;
import java.sql.SQLException;

import document.dao.DocumentDAO;
import jdbc.JdbcUtil;
import jdbc.conn.ConnectionProvider;

//삭제처리관련 Service클래스
public class PassStatDocumentService {
	private DocumentDAO documentDAO = new DocumentDAO();
	
	
	public int passDocument(int no) {
		Connection conn = null;
		int cnt2 = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			cnt2 = documentDAO.passDocument(conn,no);
			return cnt2;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn);
		}
		return cnt2;
		
	}

}




