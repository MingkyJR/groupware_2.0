package work.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jdbc.JdbcUtil;
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
					 "set work_status = '수정 요청중' " + 
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
	
	
	
	private Date toDate(Timestamp timestamp) {
		if(timestamp == null) {
			return null;
		}
		return new Date(timestamp.getTime());
	}

}
