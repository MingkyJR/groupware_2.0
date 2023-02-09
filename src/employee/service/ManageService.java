package employee.service;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import employee.dao.EmployeeDAO;
import jdbc.JdbcUtil;
import jdbc.conn.ConnectionProvider;

public class ManageService {

	//필드 
	//DAO연결을 자주할거같으니까 전역변수로 필드값 설정
	private EmployeeDAO employeeDAO = new EmployeeDAO();
	
	
	//List를 리턴하는 getEmp 메서드 생성
	public List getEmp() throws SQLException {
		
		
		Connection conn = ConnectionProvider.getConnection();
		//DB연결을 위해 사용하는 Connection conn
		List list = employeeDAO.getMember(conn);
		
		//employeeDAO의 getMember메서드 호출
		JdbcUtil.close(conn);
		//커넥션프로바이더로 연결했었던 db conn해제
		return list;
	}
	
	
	
	
	/*
	 * public static void main(String[] args) {} 접근제한자 제어자 리턴유형 메서드명(매개변수리스트)
	 */
	
	
}
