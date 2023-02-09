package chat.command;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.User;
import chat.model.MessageVO;
import chat.service.ChatLogService;
import mvc.command.CommandHandler;


public class ChatHandler implements CommandHandler {
	private static final String FORM_VIEW = "view/chat/chatpage.jsp";
	private ChatLogService chatLogService = new ChatLogService();
	
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
		
		return FORM_VIEW;
		
	}
	
	
	
	
	
	
	
	
	//로그인한 유저정보는 세션에서 받자
	public User loginedUser(HttpServletRequest request) {
		User authUser = (User)request.getSession().getAttribute("AUTHUSER");
		return authUser;
	}
	
}//ChatHandler
