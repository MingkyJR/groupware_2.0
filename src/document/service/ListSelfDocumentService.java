package document.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import document.dao.DocumentDAO;
import document.model.Document;
import jdbc.conn.ConnectionProvider;

public class ListSelfDocumentService {
	private DocumentDAO documentDAO = new DocumentDAO();
	
	public DocumentPage getDocumentPage(int pageNo,int empNo,int size) {
		try {
			Connection conn = ConnectionProvider.getConnection();
			
			int total = documentDAO.selectSelfCount(conn, empNo);//대기 게시물수
			
			List<Document> documentList = documentDAO.selfselect(conn,empNo,(pageNo-1)*size,size);
			return new DocumentPage(total, pageNo, size, documentList);
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}

}












