package secondHand.reply.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.conn.ConnectionProvider;
import secondHand.reply.dao.ReplyDAO;

public class ReplyDeleteService {

	public int deleteService(int reNo) {
		Connection conn = null;
		int result = -1;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			result = new ReplyDAO().replyDelete(conn, reNo);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
