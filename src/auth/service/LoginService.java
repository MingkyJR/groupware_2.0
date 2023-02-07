package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import employee.dao.EmployeeDAO;
import employee.model.Employee;
import jdbc.conn.ConnectionProvider;

public class LoginService {

	private EmployeeDAO employeeDAO = new EmployeeDAO();

	public User login(String id,String pwd) {
		Connection conn;
		try {
			conn = ConnectionProvider.getConnection();
		
			Employee employee = employeeDAO.selectById(id, conn);
			if(employee==null) {//user가 입력한 id를 사용하는 회원이 없다면
				throw new LoginFailException();
			}
			
			boolean result = employee.matchPassword(pwd);
			if(!result) { //user가 입력한 비번과  기존회원의 비밀번호가 일치x하면
				throw new LoginFailException();
			}
			
			return new User(
					employee.getEmp_no(),
					employee.getEmp_id(),
					employee.getEmp_pw(),
					employee.getEmp_kname(),
					employee.getEmp_ename(),
					employee.getEmp_postcode(),
					employee.getEmp_address(),
					employee.getEmp_birthday(),
					employee.getEmp_phonenumber(),
					employee.getEmp_email(),
					employee.getDept_name(),
					employee.getEmp_position(),
					employee.getEmp_extnumber(),
					employee.getEmp_grade()
					);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
}







