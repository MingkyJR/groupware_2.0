package secondHand.model;

import java.util.Date;

public class SecondHandContentDTO {

	private int no;
	private String content;
	private String empID;
	private String title;
	private String fileName;
	private String refileName;
	private int price;
	private Date regDate;
	
	public SecondHandContentDTO() {}
	public SecondHandContentDTO(String content) {
		this.content = content;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "SecondHandContentDTO [no=" + no + ", content=" + content + ", empID=" + empID + ", title=" + title
				+ ", fileName=" + fileName + ", refileName=" + refileName + ", price=" + price + ", regDate=" + regDate
				+ "]";
	}
	
	
}
