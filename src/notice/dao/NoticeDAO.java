package notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import notice.model.Notice;
import notice.model.Writer;
import notice.service.WriteRequest;
import jdbc.JdbcUtil;

//p647
//이 클래스는 notice, notice_content테이블과 관련된 DB작업실행 클래스이다.
public class NoticeDAO {
	
	
	
	
	//필드
	
	//생성자
	
	//메소드
	
	//목록조회-p647 15라인
	/*파라미터 
	 int startRow : 시작행 인덱스번호, 가장 첫 번쨰 행은 0부터 시작
	 int size : 1페이지당 출력게시물 수 */
	public List<Notice> select(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement pstmt =null;
/*		String sql=	"select notice_no, writer_id, writer_name, " +
					"title, regdate, moddate, read_cnt, isshow " + 
					"from notice where isshow = 'Y' " + 
					"order by notice_no desc limit ?,?";*/
		String sql=	"SELECT notice_no, writer_id, writer_name, title, regdate, moddate, read_cnt, isshow "+ 
					"FROM "+ 
					"(SELECT A.*, ROWNUM RNUM "+ 
					"FROM(select * from  notice order by notice_no desc) A "+ 
					"WHERE ROWNUM <= (?) ) "+ 
					"WHERE RNUM > ?";
		
		
		ResultSet rs = null;
		List<Notice> noticeList = new ArrayList<Notice>();
		
		try {
		//limit 시작행 인덱스번호, 1페이징 당 출력게시물 수 입력!!!
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, (startRow+size));
		pstmt.setInt(2, startRow);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {	//p647 26라인
			Notice notice = convertNotice(rs);
			System.out.println("DAO의 notice="+notice);
//				if(noticeList!=null) { //nullpointException 방지
					noticeList.add(notice); 
//				Notice notice = new Notice
//					(rs.getInt("notice_no"), 
//					new Writer(rs.getString("writer_id"), rs.getString("writer_name")), 
//					rs.getString("title"), 
//					rs.getTimestamp("regdate"), 
//					rs.getTimestamp("moddate"), 
//					rs.getInt("read_cnt"),
//					rs.getString("isshow")
//					);
//				}
			}
			/*확인용 -콘솔출력 => 추후 삭제 하세용~*/
		/*
		for (Iterator iterator = noticeList.iterator(); 
					iterator.hasNext();) {
				Notice notice = (Notice) iterator.next();
				System.out.println("dao의 notice="+notice);
			}*/
			
			System.out.println("dao의 noticeList.size()="+noticeList.size());
			return noticeList; //리턴 void였다가 리턴을 선언하면 바꿔줘야한다.
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}	
	//Notice객체로 변환하기-p647 36라인 --> 위에 while문에 주석 처리된 문구 처럼 하면 복잡하니 따로 분리 한 것.
	private Notice convertNotice(ResultSet rs) throws SQLException {
		return new Notice
				(rs.getInt("notice_no"), 
				new Writer(rs.getString("writer_id"), rs.getString("writer_name")), 
				rs.getString("title"), 
				toDate(rs.getTimestamp("regdate")), 
				toDate(rs.getTimestamp("moddate")), 
				rs.getInt("read_cnt"),
				rs.getString("isshow")
				);
	}
	
	//Timestamp-Date 객체로 변환하기 : p648 47라인
	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	
	//전체 게시글 수-p646
	public int selectCount(Connection conn) throws SQLException {
		PreparedStatement pstmt =null;
		String sql=	"select count(notice_no) "+ 
					"from notice "+
					"where isshow = 'Y'";
		ResultSet rs = null;
		
		try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1); //첫번쨰 컬럼은 무조건 1(?처리를 하든 안하든)
			}
			return 0;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

	}
	
	
	//상세조회-p655
	/*파라미터 int no:상세조회할 글 번호
	 * 리턴유형 Notice : 작성자(Writer: writer_id, writer_name), 제목, 작성일, 마지막수정일, 조회수, 노출여부 */
	public Notice selectById(Connection conn, int no) throws SQLException{
		PreparedStatement pstmt = null;
		String sql = 	"select notice_no, writer_id, writer_name, "+
						"regdate, title, moddate, read_cnt, isshow "+ 
						"from notice "+ 
						"where isshow = 'Y' and notice_no=?";
		ResultSet rs = null;
		Notice notice = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);//상제조회할 글번호
			rs = pstmt.executeQuery();
		if(rs.next()) {
			notice = convertNotice(rs);
			}
			return notice;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}	//상세조회 selectById() 끝
	
	//조회수 증가
	public void increaseReadCount(Connection conn, int no) {
		PreparedStatement pstmt = null;
		String sql = "update notice "+ 
					 "set read_cnt=read_cnt+1 "+ 
					 "where isshow='Y' and notice_no=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			int cnt = pstmt.executeUpdate();
			System.out.println("조회수 증가된 행 수 ="+cnt);
		}catch(SQLException e) {
			e.printStackTrace();
		}		
		
	}
	
	
	//글수정
	/*파라미터 
	  int noticeNumber : 글번호
	  String title : 수정할 제목 */
	public void update(Connection conn, int noticeNumber, String title) {
		PreparedStatement pstmt = null;
//		String sql = "update notice "+ 
//						"set title=?, moddate = now() "+ 
//						"where isshow='Y' and notice_no=?";
		
		String sql = "update notice "+ 
						"set title=?, moddate = sysdate "+ 
						"where isshow='Y' and notice_no=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setInt(2, noticeNumber);
			int cnt = pstmt.executeUpdate();
			System.out.println("notice update된 행 수"+cnt);
		}catch(SQLException e) {
			e.printStackTrace();
		}		
		
	}
	
	
	
	//글삭제-delete
	/*파라미터   int no : 삭제할 글번호
	  리턴타입 int cnt: 삭제(delete)된 행 수. 1이면 삭제성공, 0이면 삭제실패*/
	public int deleteNotice(Connection conn, int no) {
		PreparedStatement pstmt = null;
		String sql = "delete from notice "+ 
					 "where notice_no=?";
		
		int cnt=0; // 삭제(delete)된 행 수를 저장할 변수
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			cnt = pstmt.executeUpdate();
			System.out.println("notice 삭제(delete)된 행 수"+cnt);
			return cnt;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
		}	
		return cnt;
	
	}
	
	
	//글삭제-update
	/*파라미터   int no : 삭제할 글번호
	  리턴타입 int cnt: 삭제(update)된 행 수. 1이면 삭제성공, 0이면 삭제실패*/
	public int deleteNotice2(Connection conn, int no) {
		PreparedStatement pstmt = null;
		String sql = "update notice " + 
						"set isshow='N' " + 
						"where notice_no=?";
		
		int cnt=0; // 삭제(update)된 행 수를 저장할 변수
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			cnt = pstmt.executeUpdate();
			System.out.println("notice 삭제(update)된 행 수"+cnt);
			return cnt;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
		}	
		return cnt;
	}
	
	
	
	
	
	
	//글쓰기
	/*파라미터  Notice notice : Writer(로그인한 유저id, 로그인한 유저명), 입력제목, 입력내용*/
	//리턴타입 Notice : 
	public Notice insert(Connection conn, Notice notice) throws SQLException  {
		PreparedStatement pstmt = null; // insert용
		Statement stmt =null; //select용
		String sql = "insert into notice (notice_no, writer_id, writer_name, title, regdate, moddate, read_cnt, isshow) "+ 
					 "values(tmp_seq.NEXTVAL, ?, ?, ?, ?, ?, 0, 'Y')";
		ResultSet rs =null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice.getWriter().getWriter_id());
			pstmt.setString(2, notice.getWriter().getWriter_name());
			pstmt.setString(3, notice.getTitle());
			pstmt.setTimestamp(4, toTimestamp(notice.getRegdate()) ); //입력일
			pstmt.setTimestamp(5, toTimestamp(notice.getModdate()) ); //마지막 수정일
			int cnt = pstmt.executeUpdate();
			System.out.println("insert결과행수"+cnt);
			
			if(cnt>0) { //입력이 되었다면
				//sql쿼리문이 짧아서 바로 입력해준다.
				stmt = conn.createStatement();
//				rs = stmt.executeQuery("select last_insert_id from notice");
				rs = stmt.executeQuery("select tmp_seq.currval from notice");
				if(rs.next()) {
					Integer newNum = rs.getInt(1); //마지막 글번호 구한것을 매개변수로 준다.
					//그냥 Integer대신에 int로 선언해도 자동 형변환 된다 ~ 작은거에서 큰거로~
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~newNum="+newNum);
					
					return new Notice(	newNum, 
										notice.getWriter(), 
										notice.getTitle(), 
										notice.getRegdate(), 
										notice.getModdate(), 
										0,
										"Y");
										//notice.getRead_cnt(),
										//notice.getIsshow());
										//위와 같이 꺼내올 수 있지만 service에서 준 값으로 초기화되기 때문에 그냥 여기서 설정한다.
					
					}
			}
		
			return null;
			
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
		
		
		
	}

	//Date타입을 Timestamp타입으로 변환해주는 메소드-p635 52라인
	//해당 클래스 안에서만 쓰기 때문에 private 선언
	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
	
	
	
	
	//검색
	public List<Notice> searchSelect(Connection conn, String choice, String keyword, int startRow, int size) throws SQLException {
		PreparedStatement pstmt =null;
		String sql=	"SELECT notice_no, writer_id, writer_name, title, regdate, moddate, read_cnt, isshow "+ 
					"FROM "+ 
					"(SELECT A.*, ROWNUM RNUM "+ 
					"FROM(select * from  notice where "+choice+" like ? order by notice_no desc) A "+ 
					"WHERE ROWNUM <= (?) ) "+ 
					"WHERE RNUM > ?";
		
		
		ResultSet rs = null;
		List<Notice> noticeList = new ArrayList<Notice>();
		
		try {
		//limit 시작행 인덱스번호, 1페이징 당 출력게시물 수 입력!!!
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%"+keyword+"%");
		pstmt.setInt(2, (startRow+size));
		pstmt.setInt(3, startRow);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {	//p647 26라인
			Notice notice = convertNotice(rs);
			System.out.println("DAO의 notice="+notice);
//				if(noticeList!=null) { //nullpointException 방지
					noticeList.add(notice); 
//				Notice notice = new Notice
//					(rs.getInt("notice_no"), 
//					new Writer(rs.getString("writer_id"), rs.getString("writer_name")), 
//					rs.getString("title"), 
//					rs.getTimestamp("regdate"), 
//					rs.getTimestamp("moddate"), 
//					rs.getInt("read_cnt"),
//					rs.getString("isshow")
//					);
//				}
			}
			
			System.out.println("dao의 noticeList.size()="+noticeList.size());
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&"+noticeList);
			return noticeList; //리턴 void였다가 리턴을 선언하면 바꿔줘야한다.
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}	
	
	
	
	public int searchSelectCount(Connection conn, String choice, String keyword) throws SQLException {
		
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql=	"SELECT count(notice_no) count "+ 
					"FROM "+ 
					"(SELECT A.*, ROWNUM RNUM "+ 
					"FROM(select * from  notice where "+choice+" like ? order by notice_no desc) A)"; 
		
		
		try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%"+keyword+"%");
		rs = pstmt.executeQuery();
		
		//count = rs.getInt("count");
		
		if(rs.next()) {
			count = rs.getInt(1); //첫번쨰 컬럼은 무조건 1(?처리를 하든 안하든)
		}
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+count);
		return count;

		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	
		//return count;
	
	}
	
}














