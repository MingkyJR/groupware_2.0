package notice.model;

//p630
//notice테이블(의 작성자 id, 작성자명)에 해당하는 데이터를 관리하는 클래스
public class Writer {
	private String writer_id; //작성자 id
	private String writer_name; //작성자 이름
	
	
	//생성자
	public Writer(String writer_id, String writer_name) {
		this.writer_id = writer_id;
		this.writer_name = writer_name;
	}

	//메소드(getter setter)
	public String getWriter_id() {
		return writer_id;
	}

	public String getWriter_name() {
		return writer_name;
	}

	@Override
	public String toString() {
		return "Writer [writer_id=" + writer_id + ", writer_name=" + writer_name + "]";
	}
	
	

	
	
}
