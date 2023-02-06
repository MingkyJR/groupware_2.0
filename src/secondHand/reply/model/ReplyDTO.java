package secondHand.reply.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReplyDTO {

	private int reNo;
	private int oriNo;
	private String empID;
	private String reContent;
	private Date reg_Date;
	private String str_Date;
	
	public int getReNo() {
		return reNo;
	}
	public void setReNo(int reNo) {
		this.reNo = reNo;
	}
	public int getOriNo() {
		return oriNo;
	}
	public void setOriNo(int oriNo) {
		this.oriNo = oriNo;
	}
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getReContent() {
		return reContent;
	}
	public void setReContent(String reContent) {
		this.reContent = reContent;
	}
	public Date getReg_Date() {
		return reg_Date;
	}
	public void setReg_Date(Date reg_Date) {
		this.reg_Date = reg_Date;
		long milliSeconds = new Date().getTime()-reg_Date.getTime();
		System.out.println("new Date().getTime() : "+new Date().getTime());
		System.out.println("reg_Date.getTime() : "+reg_Date.getTime());
		System.out.println("milliSeconds : "+milliSeconds);
		long seconds = milliSeconds/1000;
		long minutes = seconds/60;
		long hours = minutes/60;
		if(seconds<60) {
			this.str_Date = "방금전";
		}else if(minutes<60) {
			this.str_Date = ((long)Math.floor(minutes))+"분 전";
		}else if(hours<24) {
			this.str_Date = ((long)Math.floor(hours))+"시간 전";
		}else {
			this.str_Date = new SimpleDateFormat("yy-MM-dd").format(reg_Date);
		}
		
	}
	public String getStr_Date() {
		return str_Date;
	}
	@Override
	public String toString() {
		return "ReplyDTO [reNo=" + reNo + ", oriNo=" + oriNo + ", empID=" + empID + ", reContent=" + reContent
				+ ", reg_Date=" + reg_Date + ", str_Date=" + str_Date + "]";
	}
	
	
}
