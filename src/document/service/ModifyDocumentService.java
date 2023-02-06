package document.service;

import java.sql.Connection;
import java.sql.SQLException;

import document.dao.DocumentContentDAO;
import document.dao.DocumentDAO;
import document.model.Document;
import auth.service.User;
import jdbc.JdbcUtil;
import jdbc.conn.ConnectionProvider;
public class ModifyDocumentService {
	
	private DocumentDAO documentDAO = new DocumentDAO();
	private DocumentContentDAO documentcontentDAO = new DocumentContentDAO();
	
	public void modifiy(ModifyRequest modifyRequest) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);//auto커밋false설정
			
			Document document = documentDAO.selectById(conn,modifyRequest.getDo_no());
			if(document==null) {
				throw new DocumentNotFoundException();
			}
			if(!canModify(modifyRequest.getEmp_no(),document)) {
				throw new PermissionDeniedException();
			}
			documentDAO.update(conn,modifyRequest.getDo_no());
			
			
			documentcontentDAO.update(conn,
											modifyRequest.getDo_no(),
											modifyRequest.getTitle(),
											modifyRequest.getPlans(),
											modifyRequest.getSugg(),
											modifyRequest.getUniq(),
											modifyRequest.getComm()											
											);
			
			conn.commit();//커밋
		}catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}catch(PermissionDeniedException e) {
			JdbcUtil.rollback(conn);
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
	}
	private boolean canModify(int modifyingUser,Document document) {
	
		int id = document.getDraft_empno();
		Integer no = new Integer(id);
		return no.equals(modifyingUser);
	}//canModify()끝
}






