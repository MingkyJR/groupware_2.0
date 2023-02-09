package chat.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageVO {
	private int no;
	private String name;
	private String content;
	private Date sendTime;
	
	public MessageVO() {}

	public MessageVO(String content) {
		this.content = content;
	}

	public MessageVO(int no, String name, String content) {
		super();
		this.no = no;
		this.name = name;
		this.content = content;
	}
	
	public MessageVO(int no, String name, String content, Date sendTime) {
		super();
		this.no = no;
		this.name = name;
		this.content = content;
		this.sendTime = sendTime;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	@Override
	public String toString() {
		return "MessageVO [no=" + no + ", name=" + name + ", content=" + content + ", sendTime=" + sendTime + "]";
	}
	
	
	
	
}
