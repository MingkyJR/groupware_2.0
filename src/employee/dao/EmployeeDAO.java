package employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import employee.model.Employee;
import jdbc.JdbcUtil;


public class EmployeeDAO {
	
	public Employee selectById(String id,Connection conn) {
		System.out.println("EmployeeDAO-selectById() id="+id);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select emp_no, emp_id, emp_pw, emp_kname, emp_ename, emp_postcode," + 
						"emp_address, emp_birthday, emp_phonenumber," + 
						"emp_email, dept_name, emp_position, emp_extnumber, emp_grade " + 
						"from employee " +	 
						"where emp_id=?";
		Employee employee = null; //user가 입력한 id를 사용하는 기존employee 정보를 저장하기위한 변수
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
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

	public void insert(Employee employee,Connection conn) throws SQLException {
		String sql = "insert into employee(emp_id, emp_pw, emp_kname, emp_ename, emp_postcode," + 
					"emp_address, emp_birthday, emp_phonenumber," + 
					"emp_email, dept_name, emp_position) " + 
					"values (?,?,?,?,?,?,?,?,?,?,?)"; 
					
					
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		
		stmt.setString(1, employee.getEmp_id());
		stmt.setString(2, employee.getEmp_pw());
		stmt.setString(3, employee.getEmp_kname());
		stmt.setString(4, employee.getEmp_ename());
		stmt.setInt(5, employee.getEmp_postcode());
		stmt.setString(6, employee.getEmp_address());
		stmt.setString(7, employee.getEmp_birthday());		
		stmt.setString(8, employee.getEmp_phonenumber());
		stmt.setString(9, employee.getEmp_email());
		stmt.setString(10, employee.getDept_name());
		stmt.setInt(11, employee.getEmp_position());
		
		int result = stmt.executeUpdate();
		System.out.println("회원insert실행결과 result="+result);
	}

		
	
	public void update(Connection conn, Employee employee) {
	
		
		PreparedStatement stmt = null;
		String sql="update employee " + 
					"set emp_pw = ?, emp_kname = ?, emp_ename = ?, emp_postcode = ?, "
					+ "emp_address = ?, emp_birthday = ?, emp_phonenumber = ?, "
					+ "emp_email = ? ,dept_name = ?, emp_position = ?" + 
					"where emp_no=?";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, employee.getEmp_pw());
			stmt.setString(2, employee.getEmp_kname());
			stmt.setString(3, employee.getEmp_ename());
			stmt.setInt(4, employee.getEmp_postcode());
			stmt.setString(5, employee.getEmp_address());
			stmt.setString(6, employee.getEmp_birthday());
			stmt.setString(7, employee.getEmp_phonenumber());
			stmt.setString(8, employee.getEmp_email());
			stmt.setString(9, employee.getDept_name());
			stmt.setInt(10, employee.getEmp_position());
			stmt.setInt(11, employee.getEmp_no());
			
			
			int result = stmt.executeUpdate();
			System.out.println("EmployeeDAO에서 update후 result ="+result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}//class끝






