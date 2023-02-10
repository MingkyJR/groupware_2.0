package document.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import auth.service.User;
import document.model.Writer;
import document.model.Document;
import jdbc.JdbcUtil;

public class DocumentDAO {
	// 전체대기목록페이징
	public List<Document> select(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "SELECT do_no,stat_no,title,draft_empno,draft_date,emp_kname,dept_name,emp_position    "
				+ "FROM  ( SELECT SEQ, do_no,stat_no,title,draft_empno,draft_date,emp_kname,dept_name,emp_position  "
				+ "			         FROM  (  SELECT ROWNUM AS SEQ, do_no,stat_no,title,draft_empno,draft_date,emp_kname,dept_name,emp_position   "
				+ "			                FROM  (   SELECT do_no,stat_no,title,draft_empno,draft_date,emp_kname,dept_name,emp_position   "
				+ "			                           FROM E_Approval where stat_no in 1 "
				+ "			                           order by do_no asc ) ) " + "            WHERE SEQ > ? ) "
				+ "WHERE ROWNUM <= ? ";
		ResultSet rs = null;
		List<Document> documentList = new ArrayList<Document>();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, startRow);
			stmt.setInt(2, size);
			rs = stmt.executeQuery();
			while (rs.next()) {// p647 26
				Document document = convertDocument(rs);
				documentList.add(document);
			}
			return documentList;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	//셀프게시글 리스트 페이징
	public List<Document> selfselect(Connection conn, int empNo, int startRow, int size) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "SELECT do_no,stat_no,title,draft_empno,draft_date,emp_kname,dept_name,emp_position    "
				+ "			 FROM  ( SELECT SEQ, do_no,stat_no,title,draft_empno,draft_date,emp_kname,dept_name,emp_position  "
				+ "			         FROM  (  SELECT ROWNUM AS SEQ, do_no,stat_no,title,draft_empno,draft_date,emp_kname,dept_name,emp_position   "
				+ "			                FROM  (   SELECT do_no,stat_no,title,draft_empno,draft_date,emp_kname,dept_name,emp_position   "
				+ "			                           FROM E_Approval where draft_empno= ? "
				+ "			                           order by do_no asc )   " 
				+ "          		  where stat_no in (1,2) )  "
				+ "          WHERE SEQ > ? ) "
				+ "WHERE ROWNUM <= ? ";
		ResultSet rs = null;
		List<Document> documentList = new ArrayList<Document>();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, empNo);
			stmt.setInt(2, startRow);
			stmt.setInt(3, size);
			rs = stmt.executeQuery();
												
			while (rs.next()) {// p647 26
				Document document = convertDocument(rs);
				documentList.add(document);
			}
			return documentList;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	// 셀프대기 게시글 수
	public int selectSelfCount(Connection conn,int empNo) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "select count(do_no)  " + 
					"from E_Approval  " + 
					"where draft_empno=? " + 
					"and stat_no in (1,2) ";
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, empNo);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	// 대기 게시글 수
	public int selectCount(Connection conn) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "select count(do_no) from E_Approval where stat_no in (1,2) ";
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	// 대기객체
	private Document convertDocument(ResultSet rs) throws SQLException {
		return new Document(rs.getInt("do_no"),
				new Writer(rs.getString("emp_kname"), rs.getString("dept_name"), rs.getInt("emp_position")),
				rs.getInt("stat_no"), rs.getString("title"), rs.getInt("draft_empno"), rs.getDate("draft_date"), 0,
				null);
	}

	// 대기 상세조회
	public Document selectById(Connection conn, int no) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "select do_no,stat_no,title,draft_empno,draft_date,approval_empno,approval_date,emp_kname,dept_name,emp_position  "
				+ "from  E_Approval " + "where do_no=? ";
		ResultSet rs = null;
		Document document = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);// 상세조회할 글 번호
			rs = stmt.executeQuery();
			if (rs.next()) {
				document = convertDocument(rs);
			}
			return document;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}// 상세조회 selectById()끝

	// 반려 목록페이징
	public List<Document> retur(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "SELECT do_no,stat_no,title,draft_empno,draft_date,emp_kname,dept_name,emp_position  "
				+ "FROM  ( SELECT SEQ, do_no,stat_no,title,draft_empno,draft_date,emp_kname,dept_name,emp_position  "
				+ "			         FROM  (  SELECT ROWNUM AS SEQ, do_no,stat_no,title,draft_empno,draft_date,emp_kname,dept_name,emp_position "
				+ "			                FROM  (   SELECT do_no,stat_no,title,draft_empno,draft_date,emp_kname,dept_name,emp_position "
				+ "			                           FROM E_Approval where stat_no=2 "
				+ "			                           order by do_no asc ) ) " + "            WHERE SEQ > ? ) "
				+ "WHERE ROWNUM <= ? ";
		ResultSet rs = null;
		List<Document> returndocumentList = new ArrayList<Document>();

		try {// limit 시작행인덱번호,1페이지당출력게시물수
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, startRow);
			stmt.setInt(2, size);
			rs = stmt.executeQuery();
			while (rs.next()) {// p647 26
				Document returndocument = returnConvertDocument(rs);
				returndocumentList.add(returndocument);
			}
			return returndocumentList;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	// 반려 게시글 수
	public int returnCount(Connection conn) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "select count(do_no) " + "from E_Approval " + "where stat_no='2' ";
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	// 통과 목록조회
	public List<Document> pass(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "SELECT do_no,stat_no,title,draft_empno,draft_date,emp_kname,dept_name,emp_position  "
				+ "FROM  ( SELECT SEQ, do_no,stat_no,title,draft_empno,draft_date,emp_kname,dept_name,emp_position  "
				+ "			         FROM  (  SELECT ROWNUM AS SEQ, do_no,stat_no,title,draft_empno,draft_date,emp_kname,dept_name,emp_position "
				+ "			                FROM  (   SELECT do_no,stat_no,title,draft_empno,draft_date,emp_kname,dept_name,emp_position "
				+ "			                           FROM E_Approval where stat_no=3 "
				+ "			                           order by do_no asc ) ) " + "            WHERE SEQ > ? ) "
				+ "WHERE ROWNUM <= ? ";
		ResultSet rs = null;
		List<Document> passdocumentList = new ArrayList<Document>();

		try {// limit 시작행인덱번호,1페이지당출력게시물수
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, startRow);
			stmt.setInt(2, size);
			rs = stmt.executeQuery();
			while (rs.next()) {// p647 26
				Document passdocument = passConvertDocument(rs);
				passdocumentList.add(passdocument);
			}
			return passdocumentList;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	// 대기 게시글 수
	public int passCount(Connection conn) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "select count(do_no) " + "from E_Approval " + "where stat_no='3' ";
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	// 반려객체
	private Document returnConvertDocument(ResultSet rs) throws SQLException {
		return new Document(rs.getInt("do_no"),
				new Writer(rs.getString("emp_kname"), rs.getString("dept_name"), rs.getInt("emp_position")),
				rs.getInt("stat_no"), rs.getString("title"), rs.getInt("draft_empno"), rs.getDate("draft_date"), 0,
				null);
	}

	// 통과객체
	private Document passConvertDocument(ResultSet rs) throws SQLException {
		return new Document(rs.getInt("do_no"),
				new Writer(rs.getString("emp_kname"), rs.getString("dept_name"), rs.getInt("emp_position")),
				rs.getInt("stat_no"), rs.getString("title"), rs.getInt("draft_empno"), rs.getDate("draft_date"), 0,
				null);
	}

	// 글삭제-update
	public int deleteDocument(Connection conn, int no) {
		PreparedStatement stmt = null;
		String sql = "UPDATE E_Approval " + "SET stat_no= 4 " + "WHERE do_no  = ? ";
		int cnt = 0;// 삭제(update)된 행 수를 저당할 변수
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			cnt = stmt.executeUpdate();
			System.out.println("document 삭제(update)된 행 수=" + cnt);
			return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
		}
		return cnt;
	}

	// 글승인-update
	public int passDocument(Connection conn, int no) {
		PreparedStatement stmt = null;
		String sql = "UPDATE E_Approval " + "SET stat_no= 3 " + "WHERE do_no  = ? ";
		int cnt2 = 0;// 삭제(update)된 행 수를 저당할 변수
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			cnt2 = stmt.executeUpdate();
			System.out.println("document 승인(update)된 행 수=" + cnt2);
			return cnt2;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
		}
		return cnt2;
	}

	// 글반려-update
	public int returnDocument(Connection conn, int no) {
		PreparedStatement stmt = null;
		String sql = "UPDATE E_Approval " + "SET stat_no= 2 " + "WHERE do_no  = ? ";
		int cnt1 = 0;// 삭제(update)된 행 수를 저당할 변수
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			cnt1 = stmt.executeUpdate();
			System.out.println("document 반려(update)된 행 수=" + cnt1);
			return cnt1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
		}
		return cnt1;
	}

	// 글수정
	public void update(Connection conn, int do_no) {
		PreparedStatement stmt = null;
		String sql = "UPDATE E_Approval " + "WHERE do_no  = ? ";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, do_no);
			int cnt = stmt.executeUpdate();
			System.out.println("article update된 행 수=" + cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 글쓰기
	public Document insert(Connection conn, Document document) throws SQLException {
		PreparedStatement stmt = null; // insert용
		Statement stmt2 = null; // select용
		String sql = "INSERT INTO E_Approval  "
				+ "VALUES(donoeup_seq.NEXTVAL,1,gian_seq.nextval||'.기안서',?,sysdate,5,sysdate,?,?,? ) ";
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, document.getDraft_empno());
			stmt.setString(2, document.getWriter().getEmp_kname());
			stmt.setString(3, document.getWriter().getDept_name());
			stmt.setInt(4, document.getWriter().getEmp_position());
			int cnt = stmt.executeUpdate();
			System.out.println("insert결과행수" + cnt);
			if (cnt > 0) { // 입력이 되었다면
				stmt2 = conn.createStatement();
				String sql1 = "select donoeup_seq.CURRVAL from E_Approval";
				rs = stmt2.executeQuery(sql1);
				if (rs.next()) {// p635 34라인
					Integer newNum = rs.getInt(1);
					return new Document(newNum, 
										document.getWriter(), 
										document.getStat_no(), 
										document.getTitle(),
										document.getDraft_empno(), 
										document.getDraft_date(), 
										document.getApproval_empno(),
										document.getApproval_date());
				}
			}
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt2);
			JdbcUtil.close(stmt);
		}
	}
	// Date타입을 Timestamp타입으로 변환-p635 52라인
	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
}
