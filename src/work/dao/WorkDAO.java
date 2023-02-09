package work.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import employee.model.Employee;
import jdbc.JdbcUtil;
import work.model.Edit;
import work.model.Work;

public class WorkDAO {
	
	
	public Work selectIn(Connection conn, int emp_no) throws SQLException {
		String sql = "select * " + 
				"from work_history " + 
				"where emp_no = ? and TO_DATE(work_reg_date, 'YY/MM/DD') = to_CHAR(SYSDATE,'YY/MM/DD') and work_in_time is not null";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Work work = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp_no);
			rs = pstmt.executeQuery();
			System.out.println("selectIn 결과 = "+rs);
			while(rs.next()) {
				work = new Work(rs.getTimestamp("work_in_time"),
								rs.getTimestamp("work_out_time"),
								rs.getString("status"),
								rs.getInt("emp_no"),
								rs.getDate("work_reg_date")
								);
				System.out.println("selectIn() work = " + work);
			}
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return work;
	}
	
	
	
	public void workIn(Connection conn, int emp_no) throws SQLException {
		String sql = "insert into work_history(work_num,work_in_time,work_out_time,status,work_reg_date,emp_no,work_late,work_status) " + 
				"values(work_histroy_seq.nextval,current_timestamp,null,'출근',sysdate,?,(CASE WHEN TO_CHAR(sysdate, 'HH24:MI:SS') > '09:10:59' THEN '지각' " + 
				"     ELSE null " + 
				"     end),'근태이상')";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp_no);
			int result = pstmt.executeUpdate();
			System.out.println("workIn 실행 결과 수 = "+result);
		}finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	public void workOut(Connection conn, int emp_no) throws SQLException {
		String sql = "update work_history " + 
				"set work_out_time = CURRENT_TIMESTAMP, status = '퇴근', work_status = '정상처리' " + 
				"where emp_no = ? and TO_DATE(work_reg_date, 'YY/MM/DD') = to_CHAR(SYSDATE,'YY/MM/DD')";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp_no);
			int result = pstmt.executeUpdate();
			System.out.println("workOut 실행 결과 수 = "+result);
		}finally {
			JdbcUtil.close(pstmt);
		}
		
	}
	
	public List<Work> selectMonth(Connection conn,int year, int month, int emp_no) throws SQLException{
		String sql = "select to_char(trunc(sysdate) + (work_out_time-work_in_time), 'HH24') || ':' || " + 
				"    to_char(trunc(sysdate) + (work_out_time-work_in_time), 'MI')   || ':' || " + 
				"    to_char(trunc(sysdate) + (work_out_time-work_in_time), 'SS') as total, " + 
				"    work_in_time,work_out_time,work_reg_date,work_status, " + 
				"    case when to_char(work_out_time, 'HH24:MI:SS') > '18:00:00' THEN " + 
				"    to_char(trunc(sysdate) + (work_out_time-to_timestamp('18:00:00','HH24:MI:SS')), 'HH24') || ':' || " + 
				"    to_char(trunc(sysdate) + (work_out_time-to_timestamp('18:00:00','HH24:MI:SS')), 'MI')   || ':' || " + 
				"    to_char(trunc(sysdate) + (work_out_time-to_timestamp('18:00:00','HH24:MI:SS')), 'SS') " + 
				"    ELSE null " + 
				"    end as overtime " + 
				"from work_history " + 
				"where extract(year from work_reg_date) = ? and extract(month from work_reg_date) = ? and emp_no = ? " + 
				"order by work_reg_date";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Work> workList = new ArrayList<Work>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, year);
			pstmt.setInt(2, month);
			pstmt.setInt(3, emp_no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Work work = new Work(rs.getString("total"),
									 rs.getTimestamp("work_in_time"),
									 rs.getTimestamp("work_out_time"),
									 rs.getDate("work_reg_date"),
									 rs.getString("overtime"),
									 rs.getString("work_status"));
				workList.add(work);
			}
			return workList;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public void insert_edit(Connection conn, Date reg_date, Timestamp edit_in_time, Timestamp edit_out_time, String emp_name, String reason, int emp_no) throws SQLException {
		String sql = "insert into w_edit(edit_num, reg_date, edit_in_time, edit_out_time, emp_name, edit_req_date,reason,emp_no) " + 
					 "values(w_edit_seq.nextval,?,?,?,?,current_timestamp,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, new java.sql.Date(reg_date.getTime()));
			pstmt.setTimestamp(2, edit_in_time);
			pstmt.setTimestamp(3, edit_out_time);
			pstmt.setString(4, emp_name);
			pstmt.setString(5, reason);
			pstmt.setInt(6, emp_no);
			int result = pstmt.executeUpdate();
			System.out.println("insert_edit 실행 결과 수 = "+result);
		}finally {
			JdbcUtil.close(pstmt);
		}
		
	}
	
	
	public void update_work_status(Connection conn, Date reg_date, int emp_no) throws SQLException {
		String sql = "update work_history " + 
					 "set work_status = '요청중' " + 
					 "where TO_DATE(work_reg_date, 'YY/MM/DD') = to_CHAR(?,'YY/MM/DD') and emp_no = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, new java.sql.Date(reg_date.getTime()));
			pstmt.setInt(2, emp_no);
			int result = pstmt.executeUpdate();
			System.out.println("update_work_status 실행 결과 수 = "+result);
		}finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	public List<Edit> select_edit(Connection conn, String emp_name) throws SQLException{
		String sql1 = "select * " + 
					 "from w_edit";
		String sql2 = "select * " + 
					  "from w_edit " + 
					  "where emp_name = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Edit> editList = new ArrayList<Edit>();
		try {
			if(emp_name == null) {
				pstmt = conn.prepareStatement(sql1);
			}else {
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, emp_name);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Edit edit = new Edit(rs.getInt("edit_num"),
									 rs.getDate("reg_date"),
									 rs.getTimestamp("edit_in_time"),
									 rs.getTimestamp("edit_out_time"),
									 rs.getString("emp_name"),
									 rs.getTimestamp("edit_req_date"),
									 rs.getString("edit_status"),
									 rs.getString("reason"),
									 rs.getInt("emp_no"));
				editList.add(edit);
			}
			return editList;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public Edit select_edit_content(Connection conn, int edit_num, int emp_no, Date reg_date) throws SQLException{
		String sql = "select * " + 
					  "from w_edit " + 
					  "where edit_num = ? and emp_no = ? and TO_CHAR(reg_date, 'YY/MM/DD') = to_CHAR(?,'YY/MM/DD')";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Edit edit = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, edit_num);
			pstmt.setInt(2, emp_no);
			pstmt.setDate(3, new java.sql.Date(reg_date.getTime()));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				edit = new Edit(rs.getInt("edit_num"),
									 rs.getDate("reg_date"),
									 rs.getTimestamp("edit_in_time"),
									 rs.getTimestamp("edit_out_time"),
									 rs.getString("emp_name"),
									 rs.getTimestamp("edit_req_date"),
									 rs.getString("edit_status"),
									 rs.getString("reason"),
									 rs.getInt("emp_no"));
			}
			return edit;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public Employee selectByNo(Connection conn, int no) {
		System.out.println("EmployeeDAO-selectById() id="+no);
		
		//1.드라이버로드->2.conn얻기->3.객체준비->4.실행->5.자원해제
		
		//3.객체준비
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select emp_no, emp_id, emp_pw, emp_kname, emp_ename, emp_postcode," + 
						"emp_address, emp_birthday, emp_phonenumber," + 
						"emp_email, dept_name, emp_position, emp_extnumber, emp_grade " + 
						"from employee " +	 
						"where emp_no=?";
		Employee employee = null; //user가 입력한 id를 사용하는 기존employee 정보를 저장하기위한 변수
		
		//4.실행
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,no);
			rs = pstmt.executeQuery();
			System.out.println("rs="+rs);
			
			//결과가 있다면=>user가 입력한 id를 사용하는 기존member가 존재
			if(rs.next()) {
				//select memberno,memberid,memberpwd,membername,email,regdate,grade의 결과를 이용
				
				int emp_no = rs.getInt("emp_no");
				String emp_id = rs.getString("emp_id");
				String emp_pw = rs.getString("emp_pw");;
				String emp_kname = rs.getString("emp_kname");;
				String emp_ename = rs.getString("emp_ename");;
				int emp_postcode = rs.getInt("emp_postcode");
				String emp_address = rs.getString("emp_address");;
				String emp_birthday = rs.getString("emp_birthday");;
				String emp_phonenumber = rs.getString("emp_phonenumber");
				String emp_email = rs.getString("emp_email");;
				String dept_name = rs.getString("dept_name");;
				int emp_position = rs.getInt("emp_position");
				int emp_extnumber = rs.getInt("emp_extnumber");
				int emp_grade = rs.getInt("emp_grade");
				
				//해당 회원의 정보를 가지는 회원객체를 생성
				employee = new Employee(emp_no, emp_id, emp_pw, emp_kname, emp_ename,
									emp_postcode, emp_address, emp_birthday,
									emp_phonenumber, emp_email, dept_name, emp_position,
									emp_extnumber, emp_grade);
				System.out.println("employee="+employee);
				return employee;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {//5.자원해제
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return employee;
		
	}// selectById()끝
	
	public void updateWork(Connection conn, Timestamp work_out_time, int emp_no, Date reg_date, String work_status) throws SQLException {
		String sql = "update work_history " + 
					 "set work_out_time = ?, status = '퇴근', work_status = ? " + 
					 "where emp_no = ? and TO_CHAR(work_reg_date, 'YY/MM/DD') = to_CHAR(?,'YY/MM/DD')";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, work_out_time);
			pstmt.setString(2, work_status);
			pstmt.setInt(3, emp_no);
			pstmt.setDate(4, new java.sql.Date(reg_date.getTime()));
			int result = pstmt.executeUpdate();
			System.out.println("update_work_status 실행 결과 수 = "+result);
		}finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	public void updateEdit(Connection conn, int edit_num, int emp_no, Date reg_date, String edit_status) throws SQLException {
		String sql = "update w_edit " + 
					 "set edit_status = ? " + 
					 "where edit_num = ? and emp_no = ? and TO_CHAR(reg_date, 'YY/MM/DD') = to_CHAR(?,'YY/MM/DD')";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, edit_status);
			pstmt.setInt(2, edit_num);
			pstmt.setInt(3, emp_no);
			pstmt.setDate(4, new java.sql.Date(reg_date.getTime()));
			int result = pstmt.executeUpdate();
			System.out.println("update_work_status 실행 결과 수 = "+result);
		}finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	

}
