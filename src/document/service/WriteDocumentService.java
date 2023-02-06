package document.service;

import java.sql.Connection;
import java.sql.SQLException;
import document.dao.DocumentContentDAO;
import document.dao.DocumentDAO;
import document.model.Document;
import document.model.DocumentContent;
import jdbc.JdbcUtil;
import jdbc.conn.ConnectionProvider;


public class WriteDocumentService {

	private DocumentDAO documentDAO = new DocumentDAO();
	private DocumentContentDAO documentContentDAO = new DocumentContentDAO();
	
	

	public Integer write(WriteRequest writeReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			
			conn.setAutoCommit(false);//autocommit 설정해제
			Document document = toDocument(writeReq);
			System.out.println("서비스document "+document);
			//파라미터  
			Document savedDocument = documentDAO.insert(conn,document);
			System.out.println("서비스savedDocument "+savedDocument);
			if(savedDocument==null) {
				throw new RuntimeException();
			}
			
			//p639 30라인
			DocumentContent content = 
				new DocumentContent(
									savedDocument.getDraft_empno(), 
										writeReq.getTitle(),
										writeReq.getPlans(),
										writeReq.getSugg(),
										writeReq.getUniq()
						);
			DocumentContent savedContent = documentContentDAO.insert(conn,content);
			if(savedContent==null) {
				throw new RuntimeException("DocumentContent테이블에 insert 실패");
			}
			System.out.println("savedContent"+savedContent);
			conn.commit();//커밋
			System.out.println("sadsad"+savedDocument.getDo_no());
			return savedDocument.getDo_no();
		}catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException();
		}catch (RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		}finally{
			JdbcUtil.close(conn);
		}
		
	}//write()끝


	private Document toDocument(WriteRequest writeReq) {
		return new Document(	null,
								writeReq.getWriter(), 
								1, 
								null, 
								writeReq.getCreate_empno(), 
								null, 
								5, 
								null);
							}
	
}









