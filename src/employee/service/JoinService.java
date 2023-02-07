package employee.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.conn.ConnectionProvider;
import employee.dao.EmployeeDAO;
import employee.model.Employee;



public class JoinService {
	
	
	private EmployeeDAO employeeDAO = new EmployeeDAO();
	
	
	public void join(JoinRequest joinReq) {
		
		Connection conn = null;
		Employee employee = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);//autoCommit기능 해제
			
			employee = employeeDAO.selectById(joinReq.getEmp_id(),conn);
			if(employee!=null){ //id를 이미 사용중인 기존회원이 있으므로 rollback()처리를 하고 id중복에러 발생
				JdbcUtil.rollback(conn);
				throw new DuplicatedIdException();
			}
			
			Employee newEmployee = 
					new Employee(
							joinReq.getEmp_id(),
							joinReq.getEmp_pw(),
							joinReq.getEmp_kname(),
							joinReq.getEmp_ename(),
							joinReq.getEmp_postcode(),
							joinReq.getEmp_address(),
							joinReq.getEmp_birthday(),
							joinReq.getEmp_phonenumber(),
							joinReq.getEmp_email(),
							joinReq.getDept_name(),
							joinReq.getEmp_position()
							
							
							);
			employeeDAO.insert(newEmployee,conn); //(회원되고싶은 유저가 입력한 회원정보);
			
			conn.commit(); //DB commit()처리
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);//DB rollback()처리
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			JdbcUtil.close(conn);
		}
		
	}
	
}

