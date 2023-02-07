package secondHand.reply.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.conn.ConnectionProvider;
import secondHand.reply.dao.ReplyDAO;
import secondHand.reply.model.ReplyDTO;

public class ReplyListService {

	public List<ReplyDTO> listService(int oriNo) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ReplyDAO().replyList(conn, oriNo);
	}
}
