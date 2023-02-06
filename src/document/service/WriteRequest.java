package document.service;

import java.util.Map;

import document.model.Writer;


public class WriteRequest {

	// 필드
	private int create_empno;//
	private Writer writer;	
	private String title; // 수정할 제목
	private String plans;// 수정할 내용
	private String sugg;// 수정할 내용
	private String uniq;// 수정할 내용


	public void validate(Map<String, Boolean> errors) {
		if (title == null || title.isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}
		if (plans == null || plans.isEmpty()) {
			errors.put("plans", Boolean.TRUE);
		}
		if (sugg == null || sugg.isEmpty()) {
			errors.put("sugg", Boolean.TRUE);
		}
		if (uniq == null || uniq.isEmpty()) {
			errors.put("uniq", Boolean.TRUE);
		}
	}


	public WriteRequest(int create_empno, Writer writer, String title, String plans, String sugg, String uniq) {
		this.create_empno = create_empno;
		this.writer = writer;
		this.title = title;
		this.plans = plans;
		this.sugg = sugg;
		this.uniq = uniq;
	}


	
	public  WriteRequest(int create_empno) {
		this.create_empno = create_empno;
	}


	public int getCreate_empno() {
		return create_empno;
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
	public Writer getWriter() {
		return writer;
	}

	@Override
	public String toString() {
		return "WriteRequest [create_empno=" + create_empno + ", title=" + title + ", plans=" + plans + ", sugg=" + sugg
				+ ", uniq=" + uniq + ", writer=" + writer + "]";
	}



}
