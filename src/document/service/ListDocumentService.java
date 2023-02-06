package document.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import document.dao.DocumentDAO;
import document.model.Document;
import jdbc.conn.ConnectionProvider;

public class ListDocumentService {
	private DocumentDAO documentDAO = new DocumentDAO();
	
	public DocumentPage getDocumentPage(int pageNo,int size) {
		try {
			Connection conn = ConnectionProvider.getConnection();

			int total = documentDAO.selectCount(conn);//승인대기 게시물수
			List<Document> documentList = documentDAO.select(conn,(pageNo-1)*size,size);
			return new DocumentPage(total, pageNo, size, documentList);
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
}












