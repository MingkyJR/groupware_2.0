package work.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import jdbc.conn.ConnectionProvider;
import work.dao.WorkDAO;
import work.model.Work;

public class WorkService {
	
	private WorkDAO workDAO = new WorkDAO();
	
	
	public Work selectIn(int emp_no) {
		Connection conn = null;
		Work work = null;
		try {
			conn = ConnectionProvider.getConnection();
			work = workDAO.selectIn(conn, emp_no);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return work;
	}
	
	public void workIn(int emp_no) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			workDAO.workIn(conn, emp_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void workOut(int emp_no) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			workDAO.workOut(conn, emp_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Work> selectMonth(int year, int month, int emp_no){
		Connection conn = null;
		List<Work> workList = null;
			try {
				conn = ConnectionProvider.getConnection();
				workList = workDAO.selectMonth(conn, year, month, emp_no);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return workList;
	}
	
	public void insert_edit(Date reg_date, Timestamp edit_in_time, Timestamp edit_out_time, String emp_name, String reason, int emp_no) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			workDAO.insert_edit(conn, reg_date, edit_in_time, edit_out_time, emp_name, reason, emp_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update_work_status(Date reg_date, int emp_no) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			workDAO.update_work_status(conn, reg_date, emp_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
