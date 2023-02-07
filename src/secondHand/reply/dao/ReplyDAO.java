package secondHand.reply.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import secondHand.reply.model.ReplyDTO;

public class ReplyDAO {

	// 댓글 등록
	public int replyRegiste(Connection conn, ReplyDTO dto) {
		int result = -1;
		PreparedStatement pstmt = null;
		System.out.println("ReplyDTO = "+dto);
		String query = 	"INSERT INTO reply(reno, orino, empid, recontent)" + 
						" VALUES(RENO_SEQ.nextval, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, dto.getOriNo());
			pstmt.setString(2, dto.getEmpID());
			pstmt.setString(3, dto.getReContent());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	// 댓글 리스트
	public List<ReplyDTO> replyList(Connection conn, int oriNo){
		List<ReplyDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from reply where orino=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, oriNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReplyDTO dto = new ReplyDTO();
				dto.setReNo(rs.getInt("reno"));
				dto.setReContent(rs.getString("recontent"));
				dto.setReg_Date(rs.getTimestamp("reg_date"));
				dto.setEmpID(rs.getString("empid"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	// 댓글 삭제
	public int replyDelete(Connection conn, int reNo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query =	"delete reply" + 
						" where reno=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reNo);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	// 댓글 수정
	public int replyModify(Connection conn, int reNo, String reContent) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = 	"UPDATE reply" + 
						" SET recontent=?" + 
						" where reno=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reContent);
			pstmt.setInt(2, reNo);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		return result;
	}
}
