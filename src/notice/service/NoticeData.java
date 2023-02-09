package notice.service;

import notice.model.Notice;
import notice.model.NoticeContent;

//p657
//DB의 notice테이블과 notice_content테이블 관련 데이터를 저장, 제공하는 클래스
public class NoticeData {
	//필드
	private Notice notice;
	private NoticeContent content;
	
	
	//생성자
	public NoticeData(Notice notice, NoticeContent content) {
		this.notice = notice;
		this.content = content;
	}


	//메소드
	public Notice getNotice() {
		return notice;
	}

	public NoticeContent getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "NoticeData [notice=" + notice + ", content=" + content + "]";
	}
	
	
	
	
	
	
	

}
