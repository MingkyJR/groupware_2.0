package secondHand.reply.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.conn.ConnectionProvider;
import secondHand.reply.dao.ReplyDAO;
import secondHand.reply.model.ReplyDTO;

public class ReplyRegisteService {

	public int registeService(ReplyDTO dto) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ReplyDAO().replyRegiste(conn, dto);
	}
}
