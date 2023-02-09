package employee.service;

import java.util.Map;


public class JoinRequest {
	
	private String emp_id;
	private String emp_pw;
	private String re_emp_pw; //재확인용 비번
	private String emp_kname;
	private String emp_ename;
	private int emp_postcode;
	private String emp_address;
	private String emp_birthday;
	private String emp_phonenumber;
	private String emp_email;
	private String dept_name;
	private int emp_position;
	
	public String getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}


	public String getEmp_pw() {
		return emp_pw;
	}


	public void setRe_emp_pw(String re_emp_pw) {
		this.re_emp_pw = re_emp_pw;
	}

	public String getRe_emp_pw() {
		return re_emp_pw;
	}


	public void setEmp_pw(String emp_pw) {
		this.emp_pw = emp_pw;
	}

	

	public String getEmp_kname() {
		return emp_kname;
	}


	public void setEmp_kname(String emp_kname) {
		this.emp_kname = emp_kname;
	}


	public String getEmp_ename() {
		return emp_ename;
	}


	public void setEmp_ename(String emp_ename) {
		this.emp_ename = emp_ename;
	}


	public int getEmp_postcode() {
		return emp_postcode;
	}


	public void setEmp_postcode(int emp_postcode) {
		this.emp_postcode = emp_postcode;
	}


	public String getEmp_address() {
		return emp_address;
	}


	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}


	public String getEmp_birthday() {
		return emp_birthday;
	}


	public void setEmp_birthday(String emp_birthday) {
		this.emp_birthday = emp_birthday;
	}


	public String getEmp_phonenumber() {
		return emp_phonenumber;
	}


	public void setEmp_phonenumber(String emp_phonenumber) {
		this.emp_phonenumber = emp_phonenumber;
	}


	public String getEmp_email() {
		return emp_email;
	}


	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}


	public String getDept_name() {
		return dept_name;
	}


	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}


	public int getEmp_position() {
		return emp_position;
	}


	public void setEmp_position(int emp_position) {
		this.emp_position = emp_position;
	}
	
	
	//비번과 재확인용 비번 일치체크 - p594 44라인
	public boolean isPasswordEqualsToConfirm() {
		return emp_pw != null && emp_pw.equals(re_emp_pw);   //조건두개 충족. null이면 안됨
		
	}

	public void validate(Map<String, Boolean> errors) {
		if(!errors.containsKey("re_emp_pw")) {
			if(!isPasswordEqualsToConfirm()) {
				errors.put("notMatch", Boolean.TRUE);
			}
		}
		
	}
	

	
	@Override
	public String toString() {
		return "JoinRequest [emp_id=" + emp_id + ", emp_pw=" + emp_pw + ", re_emp_pw=" + re_emp_pw + ", emp_kname="
				+ emp_kname + ", emp_ename=" + emp_ename + ", emp_postcode=" + emp_postcode + ", emp_address="
				+ emp_address + ", emp_birthday=" + emp_birthday + ", emp_phonenumber=" + emp_phonenumber
				+ ", emp_email=" + emp_email + ", dept_name=" + dept_name + ", emp_position=" + emp_position + "]";
	}
	

	
	
	
}
