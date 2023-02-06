package document.service;

import java.util.Date;
import java.util.Map;

public class ModifyRequest {

	private int emp_no; // 수정하는 사용자id
	private int do_no; // 수정할 글번호
	private String title; // 수정할 제목
	private String plans;// 수정할 내용
	private String Sugg;// 수정할 내용
	private String Uniq;// 수정할 내용
	private String comm;//  수정할 내용

	public ModifyRequest(int emp_no, int do_no, String title, String plans,
			String sugg, String uniq, String comm) {
		this.emp_no = emp_no;
		this.do_no = do_no;
		this.title = title;
		this.plans = plans;
		this.Sugg = sugg;
		this.Uniq = uniq;
		this.comm = comm;
	}


	public int getEmp_no() {
		return emp_no;
	}

	public int getDo_no() {
		return do_no;
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

	public String getUniq() {
		return Uniq;
	}

	public String getComm() {
		return comm;
	}


	@Override
	public String toString() {
		return "ModifyRequest [emp_no=" + emp_no + ", do_no=" + do_no + ", title="
				+ title + ", plans=" + plans + ", Sugg=" + Sugg + ", Uniq=" + Uniq + ", comm=" + comm + "]";
	}


	public void validate(Map<String, Boolean> errors) {
		if (title == null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}
	}
}
