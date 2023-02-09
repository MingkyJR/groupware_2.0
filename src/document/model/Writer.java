package document.model;

public class Writer {
	private String emp_kname;
	private String dept_name;
	private int emp_position;
	
	public Writer(String emp_kname, String dept_name, int emp_position) {
		this.emp_kname = emp_kname;
		this.dept_name = dept_name;
		this.emp_position = emp_position;
	}
	
	public String getEmp_kname() {
		return emp_kname;
	}
	public String getDept_name() {
		return dept_name;
	}
	public int getEmp_position() {
		return emp_position;
	}
	
	@Override
	public String toString() {
		return "Writer [emp_kname=" + emp_kname + ", dept_name=" + dept_name + ", emp_position=" + emp_position + "]";
	}

}
