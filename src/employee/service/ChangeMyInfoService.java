package employee.service;

import java.sql.Connection;
import java.sql.SQLException;

import employee.dao.EmployeeDAO;
import employee.model.Employee;
import jdbc.JdbcUtil;
import jdbc.conn.ConnectionProvider;

//p621
//비번변경,(회원정보)
public class ChangeMyInfoService {

	//필드
	private EmployeeDAO employeeDAO = new EmployeeDAO();
	
	//생성자
	
	//메서드
	//비번변경,(회원정보) -P621 15라인
	/*파라미터
	 * String userid:(로그인하면서 입력한)id
	 * String curPwd:(비번변경전 현재)비번
	 * String newPwd:새롭게 변경할 new비번
	 */
	public void changMyInfo(String emp_id, String curPwd, String newPwd, String new_kname,
						String new_ename, int new_emp_postcode, String new_emp_address, String new_birthday, 
						String new_phonenumber, String new_emp_email, String new_dept_name, int new_position) {
		Connection conn = null;
		Employee employee = null;
		try {
			conn = ConnectionProvider.getConnection();
		
			conn.setAutoCommit(false);//autoCommit 설정x
			
			//로그인한 회원임을 확인
			//1.user가 입력한 id와 기존  회원의 id와 일치
			//user가 입력한 id를 사용하는 기존member정보가 담긴  Member객체받는다
			System.out.println("ChangeMyInfoService 진입");
			employee = employeeDAO.selectById(emp_id,conn);
			System.out.println("employeeDAO-selectById()리턴받은 employee="+employee);
			
			if(employee==null) { //id와 일치하는 회원이 존재하지 않으면
				JdbcUtil.rollback(conn);//rollback()처리
				throw new MemberNotFoundException(); //특정회원존재x 예외발생
			}
			
			//2.user가 입력한 (변경전 현재)비번과 기존  회원의 비번과 일치
			//일치하면 true리턴, 불일치하면 false
			if(!employee.matchPassword(curPwd)) {
				throw new InvalidPasswordException(); //비번불일치예외 발생
			}
			
			
			//여기서 무한로딩
			//3.비번변경p621 28라인 
			System.out.println("employee.change실행");
			employee.change_emp_pw(newPwd); //새비번을 Member클래스의 필드memberpwd의 값으로 설정
			employee.change_emp_kname(new_kname);
			employee.change_emp_ename(new_ename);
			employee.change_emp_postcode(new_emp_postcode);
			employee.change_emp_address(new_emp_address);
			employee.change_emp_birthday(new_birthday);
			employee.change_emp_phonenumber(new_phonenumber);
			employee.change_emp_email(new_emp_email);
			employee.change_dept_name(new_dept_name);
			employee.change_emp_position(new_position);
			
			employeeDAO.update(conn,employee);
			
			conn.commit();//커밋해라
		} catch (SQLException e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw new RuntimeException();
		}finally {
			JdbcUtil.close(conn);
		}
		
	}
	
}





