package secondHand.model;

import java.util.Date;

public class SecondHandDTO {

	private int no;
	private String empID;
	private String title;
	private String fileName;
	private String refileName;
	private int price;
	private int views;
	private Date regDate;
	
	public SecondHandDTO() {}
	
	public SecondHandDTO(int no, String empID, String title, String fileName, String refileName, Date regDate, int price, int views) {
		this.no = no;
		this.empID = empID;
		this.title = title;
		this.fileName = fileName;
		this.refileName = refileName;
		this.regDate = regDate;
		this.price = price;
		this.views = views;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getRefileName() {
		return refileName;
	}
	public void setRefileName(String refileName) {
		this.refileName = refileName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}

	@Override
	public String toString() {
		return "SecondHandDTO [no=" + no + ", empID=" + empID + ", title=" + title + ", fileName=" + fileName
				+ ", refileName=" + refileName + ", price=" + price + ", views=" + views + ", regDate=" + regDate + "]";
	}

}
