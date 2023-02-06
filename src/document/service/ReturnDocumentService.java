package document.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import document.dao.DocumentDAO;
import document.model.Document;
import jdbc.conn.ConnectionProvider;

public class ReturnDocumentService {
	private DocumentDAO documentDAO = new DocumentDAO();
	
	public DocumentPage getDocumentPage(int pageNo,int size) {
		try {
			Connection conn = ConnectionProvider.getConnection();
			
			int total = documentDAO.returnCount(conn);//전체게시물수
			List<Document> returndocumentList = documentDAO.retur(conn,(pageNo-1)*size,size);
			return new DocumentPage(total, pageNo, size, returndocumentList);
		
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
}












