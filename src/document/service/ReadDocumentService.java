package document.service;

import java.sql.Connection;
import java.sql.SQLException;

import document.dao.DocumentContentDAO;
import document.dao.DocumentDAO;
import document.model.Document;
import document.model.DocumentContent;
import jdbc.conn.ConnectionProvider;

public class ReadDocumentService {
	
	private DocumentDAO documentDAO = new DocumentDAO();
	private DocumentContentDAO contentDAO = new DocumentContentDAO();

	public DocumentData getDocument(int no) {
		Connection conn = null;
		
		try {
			conn= ConnectionProvider.getConnection();
			Document document = documentDAO.selectById(conn, no);
			if(document==null) { //document테이블에서 특정글번호에 해당하는 레코드존재x
				throw new DocumentNotFoundException();
			}
			DocumentContent content = contentDAO.selectById(conn,no);
			if(content==null) { //content테이블에서 특정글번호에 해당하는 레코드존재x
				throw new DocumentContentNotFoundException();
			}
			return new DocumentData(document, content);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}








