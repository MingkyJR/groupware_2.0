package work.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import employee.model.Employee;
import jdbc.conn.ConnectionProvider;
import work.dao.WorkDAO;
import work.model.Edit;
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
	
	public List<Edit> select_edit(String emp_name){
		Connection conn = null;
		List<Edit> editList = null;
			try {
				conn = ConnectionProvider.getConnection();
				editList = workDAO.select_edit(conn, emp_name);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return editList;
	}
	
	public Edit select_edit_content(int edit_num, int emp_no, Date reg_date) {
		Connection conn = null;
		Edit edit = null;
		try {
			conn = ConnectionProvider.getConnection();
			edit = workDAO.select_edit_content(conn,edit_num, emp_no, reg_date);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return edit;
	}
	
	public Employee selectByNo(int no) {
		Connection conn = null;
		Employee employee = null;
		try {
			conn = ConnectionProvider.getConnection();
			employee = workDAO.selectByNo(conn, no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}
	
	public void updateWork(Timestamp work_out_time, int emp_no, Date reg_date, String work_status) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			workDAO.updateWork(conn, work_out_time, emp_no, reg_date, work_status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateEdit(int edit_num, int emp_no, Date reg_date, String edit_status) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			workDAO.updateEdit(conn,edit_num, emp_no, reg_date, edit_status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

}
