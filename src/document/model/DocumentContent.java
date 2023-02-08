package document.model;

import java.util.Date;


public class DocumentContent {
	private int do_no; // 양식번호 form_no
	private String form_name; // 양식명 form_name
	private int create_empno; // 작성사원 번호
	private Date create_date; // 작성일 번호
	private String title; // 업무명 title
	private String plans; // 계획 plans
	private String sugg; // 건의사항 Sugg
	private String uniq; // 특이사항 Uniq
	private String comm; // 코멘트 Uniq

	public DocumentContent(int do_no, String form_name, int create_empno, Date create_date, String title, String plans,
			String sugg, String uniq, String comm) {
		this.do_no = do_no;
		this.form_name = form_name;
		this.create_empno = create_empno;
		this.create_date = create_date;
		this.title = title;
		this.plans = plans;
		this.sugg = sugg;
		this.uniq = uniq;
		this.comm = comm;
	}

	public DocumentContent(int create_empno, String title, String plans, String sugg, String uniq) {
		this.create_empno = create_empno;
		this.title = title;
		this.plans = plans;
		this.sugg = sugg;
		this.uniq = uniq;
	}

	public int getDo_no() {
		return do_no;
	}

	public String getForm_name() {
		return form_name;
	}

	public int getCreate_empno() {
		return create_empno;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public String getTitle() {
		return title;
	}

	public String getPlans() {
		return plans;
	}

	public String getSugg() {
		return sugg;
	}

	public String getUniq() {
		return uniq;
	}

	public String getComm() {
		return comm;
	}

	@Override
	public String toString() {
		return "DocumentContent [do_no=" + do_no + ", form_name=" + form_name + ", create_empno=" + create_empno
				+ ", create_date=" + create_date + ", title=" + title + ", plans=" + plans + ", sugg=" + sugg
				+ ", uniq=" + uniq + ", comm=" + comm + "]";
	}
}
