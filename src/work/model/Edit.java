package work.model;

import java.sql.Timestamp;
import java.util.Date;

public class Edit {
	
	private int edit_num;
	private Date reg_date;
	private Timestamp edit_in_time;
	private Timestamp edit_out_time;
	private String emp_name;
	private Timestamp edit_req_date;
	private String edit_status;
	private String reason;
	private int emp_no;
	
	
	
	public Edit(int edit_num, Date reg_date, Timestamp edit_in_time, Timestamp edit_out_time, String emp_name,
			Timestamp edit_req_date, String edit_status, String reason, int emp_no) {
		this.edit_num = edit_num;
		this.reg_date = reg_date;
		this.edit_in_time = edit_in_time;
		this.edit_out_time = edit_out_time;
		this.emp_name = emp_name;
		this.edit_req_date = edit_req_date;
		this.edit_status = edit_status;
		this.reason = reason;
		this.emp_no = emp_no;
	}
	
	public int getEdit_num() {
		return edit_num;
	}
	
	public void setEdit_num(int edit_num) {
		this.edit_num = edit_num;
	}
	
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Timestamp getEdit_in_time() {
		return edit_in_time;
	}
	public void setEdit_in_time(Timestamp edit_in_time) {
		this.edit_in_time = edit_in_time;
	}
	public Timestamp getEdit_out_time() {
		return edit_out_time;
	}
	public void setEdit_out_time(Timestamp edit_out_time) {
		this.edit_out_time = edit_out_time;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public Timestamp getEdit_req_date() {
		return edit_req_date;
	}
	public void setEdit_req_date(Timestamp edit_req_date) {
		this.edit_req_date = edit_req_date;
	}
	public String getEdit_status() {
		return edit_status;
	}
	public void setEdit_status(String edit_status) {
		this.edit_status = edit_status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	@Override
	public String toString() {
		return "Edit [edit_num=" + edit_num + ", reg_date=" + reg_date + ", edit_in_time=" + edit_in_time
				+ ", edit_out_time=" + edit_out_time + ", emp_name=" + emp_name + ", edit_req_date=" + edit_req_date
				+ ", edit_status=" + edit_status + ", reason=" + reason + ", emp_no=" + emp_no + "]";
	}

	
	
	
	
	

}
