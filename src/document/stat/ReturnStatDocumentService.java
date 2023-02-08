package document.stat;

import java.sql.Connection;
import java.sql.SQLException;

import document.dao.DocumentDAO;
import jdbc.JdbcUtil;
import jdbc.conn.ConnectionProvider;

public class ReturnStatDocumentService {
	private DocumentDAO documentDAO = new DocumentDAO();
	
	public int returnDocument(int no) {
		Connection conn = null;
		int cnt1 = 0;
		try {
			conn = ConnectionProvider.getConnection();
			cnt1 = documentDAO.returnDocument(conn,no);
			return cnt1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn);
		}
		return cnt1;
		
	}
}




