package document.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import document.dao.DocumentDAO;
import document.model.Document;
import jdbc.conn.ConnectionProvider;

public class PassDocumentService {
	private DocumentDAO documentDAO = new DocumentDAO();

	public DocumentPage getDocumentPage(int pageNo,int size) {
		try {
			Connection conn = ConnectionProvider.getConnection();

			int total = documentDAO.passCount(conn);
			List<Document> passdocumentList = documentDAO.pass(conn,(pageNo-1)*size,size);
			return new DocumentPage(total, pageNo, 
					   size, passdocumentList);
		
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
}












