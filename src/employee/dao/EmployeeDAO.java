package employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import employee.model.Employee;
import jdbc.JdbcUtil;
import jdbc.conn.ConnectionProvider;


//p592
//DAO(Data Access Object) : DB연동하여 쿼리실행관련된 기능
//이 클래스는 DAO로서 주로 회원관련DB작업을 수행
public class EmployeeDAO {
	
	public Employee selectById(String id,Connection conn) {
		System.out.println("EmployeeDAO-selectById() id="+id);
		
		//1.드라이버로드->2.conn얻기->3.객체준비->4.실행->5.자원해제
		
		//3.객체준비
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select emp_no, emp_id, emp_pw, emp_kname, emp_ename, emp_postcode," + 
						"emp_address, emp_birthday, emp_phonenumber," + 
						"emp_email, dept_name, emp_position, emp_extnumber, emp_grade " + 
						"from employee " +	 
						"where emp_id=?";
		Employee employee = null; //user가 입력한 id를 사용하는 기존employee 정보를 저장하기위한 변수
		
		//4.실행
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
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

	
	//회원가입-p593 42라인
	/*imployee:회원되고싶은 유저가 입력한 user정보
	 *conn:Connection객체*/
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

		
	//회원정보 수정
	
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
	
	
	//회원조회 쿼리 실행
	public List<Employee> getMember(Connection conn) {
		//리스트를 리턴, 서비스에서 db연결을 위한 커넥션 프로바이더를 받아서 연결
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select emp_no, emp_id, emp_kname, emp_phonenumber," + 
						"emp_email, dept_name, emp_position, emp_grade " + 
						"from employee";
		List<Employee> list = new ArrayList<Employee>();
		//리스트 
			
			try {
				stmt = conn.prepareStatement(sql); //커넥션.프리페어스테이트먼트sql에 쿼리문 실행 
				rs = stmt.executeQuery(sql); //쿼리문의 결과를 rs에 저장
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				while(rs.next()) {
					
					int emp_no = rs.getInt("emp_no");
					String emp_id = rs.getString("emp_id");
					String emp_kname = rs.getString("emp_kname");
					String emp_phonenumber = rs.getString("emp_phonenumber");
					String emp_email = rs.getString("emp_email");
					String dept_name = rs.getString("dept_name");
					int emp_position = rs.getInt("emp_position");
					int emp_grade = rs.getInt("emp_grade");
					
					Employee emp = new Employee(emp_no, emp_id, emp_kname,
												emp_phonenumber, emp_email, dept_name, emp_position, emp_grade);
					
					/*
					 * Employee emp = new Employee(rs.getInt("emp_no")... 이랑 똑같음);
					 * 
					 */
					
					
					list.add(emp); //emp = Employee클래스 List<>로 지정했으니까 emp에 리스트로 저장해서 리턴
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {//5.자원해제
				JdbcUtil.close(rs);
				JdbcUtil.close(stmt);
			} return list;
						
				
				
				
				
				
			

	}
	

	
}//class끝



