package document.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.catalina.authenticator.SavedRequest;

import document.model.DocumentContent;
import document.service.WriteRequest;
import jdbc.JdbcUtil;


public class DocumentContentDAO {

	//대기 상세조회
	public DocumentContent selectById(Connection conn, int no ) throws SQLException{
		PreparedStatement stmt = null;
		String sql = "select do_no,form_name,create_empno,create_date,title,plans,Sugg,Uniq,comm " + 
					 "from  E_Form "+
					 "where do_no = ? ";
		ResultSet rs = null;
		DocumentContent content = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			if(rs.next()) {
			  content = DocumentContent(rs);	
			}
			return content;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	private DocumentContent DocumentContent(ResultSet rs) throws SQLException {
		return new DocumentContent(
				rs.getInt("do_no"),
				rs.getString("form_name"),
				rs.getInt("create_empno"),
				rs.getDate("create_date"),
				rs.getString("title"),
				rs.getString("plans"),
				rs.getString("Sugg"),
				rs.getString("Uniq"),
				rs.getString("comm"));
	}

	//글내용수정
	public void update(Connection conn, int do_no , String title,String plans,String sugg,String uniq, String comm) {
		PreparedStatement stmt = null;
		String sql = 	"UPDATE E_Form " + 
						"SET title=?,plans=?,Sugg=?,Uniq=?,comm=? " + 
						"WHERE do_no  = ? ";
	
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,title);
			stmt.setString(2,plans);
			stmt.setString(3,sugg);
			stmt.setString(4,uniq);
			stmt.setString(5,comm);
			stmt.setInt(6,do_no);
			int cnt = stmt.executeUpdate();
			System.out.println("article_content update된 행 수="+cnt);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	//내용입력
	public DocumentContent insert(Connection conn,DocumentContent content) {
		PreparedStatement stmt = null;
		//INSERT INTO E_Form VALUES ( '기안서'||board_seq.nextval,'기안서',1,sysdate,'업무명','계획','제안','특이',null );
		String sql = "INSERT INTO E_Form VALUES "+
					"(donoeup_seq.CURRVAL,'기안서',?,sysdate,?,?,?,?,null) ";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,content.getCreate_empno());
			stmt.setString(2,content.getTitle());
			stmt.setString(3,content.getPlans());
			stmt.setString(4,content.getSugg());
			stmt.setString(5,content.getUniq());
			int cnt = stmt.executeUpdate();
			System.out.println(cnt);
			System.out.println("documentcontent테이블에 insert결과행수"+cnt); 
			if(cnt>0) { 
				return content;
			}else {
				return null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			JdbcUtil.close(stmt);
		}
	}
}




