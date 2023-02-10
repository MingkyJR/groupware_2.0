package chat.command;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.User;
import chat.model.MessageVO;
import chat.service.ChatLogService;
import mvc.command.CommandHandler;
import notice.service.ListNoticeService;
import notice.service.NoticePage;


public class ChatHandler implements CommandHandler {
	private static final String FORM_VIEW = "view/chat/chatpage.jsp";
	private ChatLogService chatLogService = new ChatLogService();
	
	private ListNoticeService listNoticeService = new ListNoticeService();
	
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ChatHandler_process() 접속");
		
		//1.HttpSession 선언
		HttpSession session = request.getSession();
		//2.비지니스 로직 수행
		List<MessageVO> mVOList = chatLogService.selectByContent();
		User authUser = loginedUser(request);
		//로그인 된 유저 세션값을 받아 이름, 직원 번호 세션을 생성
		session.setAttribute("name", authUser.getEmp_kname());	//WebSocket에서 호출할 이름 세션	
		session.setAttribute("empNo", authUser.getEmp_no());	
		request.setAttribute("mVOList", mVOList);
		
		
		
		String strPageNo = request.getParameter("pageNo");//보고싶은 페이지
//		int pageNo = Integer.parseInt(strPageNo);
		int pageNo = 1;
		if(strPageNo!=null) {
			pageNo=Integer.parseInt(strPageNo);
		}
//		if (pageNo==0) {
//			pageNo=1;
//		}else {
//			if(strPageNo!=null) {
//				pageNo=Integer.parseInt(strPageNo);
//			}else if(strPageNo==null) {
//				pageNo=1;
//			}
//		}
		
		String strRowSize = request.getParameter("rowSize");//한페이지당 보여지는 게시물 수
//		int size = Integer.parseInt(strRowSize);-->>원래 에러 나는 형태.... nullpoint exception 뜬다.
		int rowSize = 5;
//		if(strRowSize==null) {
//			rowSize=3;
//		}else {
//			rowSize = Integer.parseInt(strRowSize);			
//		}
		if(strRowSize!=null) {
			rowSize = Integer.parseInt(strRowSize);			
		}
		
		
		
		//?choice=title&keyword=~~
		String strChoice = request.getParameter("choice");//view페이지 내에 select 태그 id
		String choice = "";
		if(strChoice!=null) {
			choice=strChoice;
		}
		String strKeyword = request.getParameter("keyword");//유저 검색 키워드
		String keyword = "";
		if(strKeyword!=null) {
			keyword=strKeyword;
		}
		
		System.out.println("초이스는"+choice);
		System.out.println("검색어는는"+keyword);
		

		
		
		//2.비즈니스 로직 수행 -> Service -> DAO -> DB -> DAO -> Service -> 비즈니스 로직 수행(되돌아 온다)
		//p652 22라인
		//향후 페이징추가 작업예정 ~~ 리턴 유형에 변화를 줄 예정~~
		//List<Notice> listNotice = listNoticeService.getNoticePage(pageNo, size);
		//NoticePage listNotice = listNoticeService.getNoticePage(pageNo, size);
		//System.out.println("~~~~~~~~~~~~~~~~~"+pageNo);
		NoticePage noticePage = null;
		if(keyword==null || keyword=="") {
			noticePage = listNoticeService.getNoticePage(pageNo, rowSize);	//원래소스
		}else {
			noticePage = listNoticeService.getNoticePage(choice, keyword, pageNo, rowSize);
		}

		//System.out.println("게시글 수"+noticePage); //list타입에서 NoticePage로 바뀌어서 이제 .size 할 수 없다.
		//System.out.println("게시글 수"+listNotice.size()); //list타입에서 NoticePage로 바뀌어서 이제 .size 할 수 없다.
		//3.Model(비즈니스로직 수행결과)처리
		//request.setAttribute("listNotice", listNotice);
		request.setAttribute("noticePage", noticePage);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("rowSize", rowSize);
		request.setAttribute("choice", choice);
		request.setAttribute("keyword", keyword);
		
		
		
		
		
		return FORM_VIEW;
		
	}
	
	
	
	//로그인한 유저정보는 세션에서 받자
	public User loginedUser(HttpServletRequest request) {
		User authUser = (User)request.getSession().getAttribute("AUTHUSER");
		return authUser;
	}
	
	
	
	
	
	
	
	
	
}//ChatHandler
