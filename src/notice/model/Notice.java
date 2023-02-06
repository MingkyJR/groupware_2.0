package notice.model;

import java.util.Date;

//p631
//notice테이블(의 작성자 id, 작성자명)에 해당하는 데이터를 관리하는 클래스
public class Notice {
	private Integer number; //글번호 notice_no
	private Writer writer; //작성자정보(writer_id, writer_name;//작성자명)
	private String title;//제목title
	private Date regdate;//최초작성일    regdate
	private Date moddate;//마지막수정일 moddate
	private int read_cnt; //조회수 read_cnt
	private String isshow;//노출(삭제)여부.기본Y. Y(노출),N(미노출,삭제된 데이터)
	
	
	public Notice(Integer number, Writer writer, String title, Date regdate, Date moddate, int read_cnt,
			String isshow) {
		this.number = number;
		this.writer = writer;
		this.title = title;
		this.regdate = regdate;
		this.moddate = moddate;
		this.read_cnt = read_cnt;
		this.isshow = isshow;
	}


	public Integer getNumber() {
		return number;
	}


	public Writer getWriter() {
		return writer;
	}


	public String getTitle() {
		return title;
	}


	public Date getRegdate() {
		return regdate;
	}


	public Date getModdate() {
		return moddate;
	}


	public int getRead_cnt() {
		return read_cnt;
	}


	public String getIsshow() {
		return isshow;
	}


	@Override
	public String toString() {
		return "Notice [number=" + number + ", writer=" + writer + ", title=" + title + ", regdate=" + regdate
				+ ", moddate=" + moddate + ", read_cnt=" + read_cnt + ", isshow=" + isshow + "]\r\n" ;
	}
	
	
	
	
	
	
	
}
