package document.stat;

import java.sql.Connection;
import java.sql.SQLException;

import document.dao.DocumentDAO;
import jdbc.JdbcUtil;
import jdbc.conn.ConnectionProvider;

public class DeleteStatDocumentService {
	private DocumentDAO documentDAO = new DocumentDAO();
	
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




