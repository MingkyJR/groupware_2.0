package chat.model;


public class ChatClient {
	//select chat_no, emp_no, emp_name, chat_content, to_char
	//필드
	private int emp_no;		//사원번호 emp_no		
	private String name;	//사원이름 emp_name
	private String content;	//채팅내용 chat_content

	//생성자
	public ChatClient() {}
	
	public ChatClient(String name) {
		this.name = name;
	}
	
	public ChatClient(int emp_no, String name) {
		this.emp_no = emp_no;
		this.name = name;
	}
	
	public ChatClient(int emp_no, String name, String content) {
		this.emp_no = emp_no;
		this.name = name;
		this.content = content;
	}

	//메서드
	public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "ChatClient [emp_no=" + emp_no + ", name=" + name + ", content=" + content + "]";
	}


	

	
}
