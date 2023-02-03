package work.service;

public class Page {
	
	int year;
	int mon;
	int emp_no;
	
	public Page(int year, int mon, int emp_no) {
		this.year = year;
		this.mon = mon;
		this.emp_no = emp_no;
	}

	public int getYear() {
		return year;
	}

	public int getMon() {
		return mon;
	}
	
	public int getEmp_no() {
		return emp_no;
	}

	@Override
	public String toString() {
		return "Page [year=" + year + ", mon=" + mon + ", emp_no=" + emp_no + "]";
	}


	
	

}
