package document.service;

import java.util.Date;
import java.util.Map;

public class DocumentRequest {

	private int form_no;// 양식번호
	private Date creat_date;//작성일
	private String title;//업무명
	private String plans;//업무계획
	private String Sugg;//건의사항
	private String Uniqe;//특이사항
	private int create_date;//작성자번호

	public DocumentRequest(int form_no, Date creat_date, String title, String plans, String sugg, String uniqe,	int create_date) {
		this.form_no = form_no;
		this.creat_date = creat_date;
		this.title = title;
		this.plans = plans;
		this.Sugg = sugg;
		this.Uniqe = uniqe;
		this.create_date = create_date;
	}
	 
	public int getForm_no() {
		return form_no;
	}

	public Date getCreat_date() {
		return creat_date;
	}


	public String getTitle() {
		return title;
	}


	public String getPlans() {
		return plans;
	}


	public String getSugg() {
		return Sugg;
	}

	public String getUniqe() {
		return Uniqe;
	}


	public int getCreate_date() {
		return create_date;
	}
	
	
	@Override
	public String toString() {
		return "DocumentRequest [form_no=" + form_no + ", creat_date=" + creat_date + ", title=" + title + ", plans="
				+ plans + ", Sugg=" + Sugg + ", Uniqe=" + Uniqe + ", create_date=" + create_date + "]";
	}
}






