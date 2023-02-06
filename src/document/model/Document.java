package document.model;

import java.util.Date;



public class Document {
	private Integer do_no; // 문서번호 do_no
	private Writer writer;
	private int stat_no; // 상태번호 stat_no
	private String title;// 제목title
	private int draft_empno; // 기안사원번호 draft_empno
	private Date draft_date;// 기안일 draft_date
	private int approval_empno; // 결재사원번호 approval_empno
	private Date approval_date;// 결재일 approval_date
	
	


	public Document(Integer do_no, Writer writer, int stat_no, String title, int draft_empno, Date draft_date,
			int approval_empno, Date approval_date) {
		this.do_no = do_no;
		this.writer = writer;
		this.stat_no = stat_no;
		this.title = title;
		this.draft_empno = draft_empno;
		this.draft_date = draft_date;
		this.approval_empno = approval_empno;
		this.approval_date = approval_date;
	}


	public Document(Integer do_no, int stat_no, String title, int draft_empno, Date draft_date) {
		this.do_no = do_no;
		this.stat_no = stat_no;
		this.title = title;
		this.draft_empno = draft_empno;
		this.draft_date = draft_date;
	}


	@Override
	public String toString() {
		return "Document [do_no=" + do_no + ", writer=" + writer + ", stat_no=" + stat_no + ", title=" + title
				+ ", draft_empno=" + draft_empno + ", draft_date=" + draft_date + ", approval_empno=" + approval_empno
				+ ", approval_date=" + approval_date + "]";
	}

	public Writer getWriter() {
		return writer;
	}
	public Integer getDo_no() {
		return do_no;
	}

	public int getStat_no() {
		return stat_no;
	}

	public String getTitle() {
		return title;
	}

	public int getDraft_empno() {
		return draft_empno;
	}

	public Date getDraft_date() {
		return draft_date;
	}

	public int getApproval_empno() {
		return approval_empno;
	}

	public Date getApproval_date() {
		return approval_date;
	}



}
