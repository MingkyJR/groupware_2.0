package auth.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import employee.service.ChangeMyInfoService;
import employee.service.InvalidPasswordException;
import employee.service.MemberNotFoundException;
import mvc.command.CommandHandler;

//p622
//이 컨트롤러는  비번변경폼보여줘 & 변경처리요청을 처리하는 클래스이다
//요청주소   http://localhost:포트번호/컨패/changePwd.do
public class changeMyinfoHandler implements CommandHandler {

	private static final String FORM_VIEW = "/view/mypageForm.jsp";
	private ChangeMyInfoService changMyInfoService = new ChangeMyInfoService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("changeMyInfoHandler.process()호출");
		//폼의 요청방식에 따라 비변변경폼보여줘 요청과  비번변경처리요청을 구분
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request,response);//비변변경폼보여줘
		}else if(request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request,response);//비번변경처리요청
		}else {

			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}//process끝
	

	//비번변경폼으로 이동-p623 32라인
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		return FORM_VIEW;
	}
	
	//비번변경처리-p623 37라인
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.파라미터받기
		//세션에서 로그인한 유저정보를 가져오기
		System.out.println("changeMyinfoHandler_processSubmit()진입");
		User user = (User)request.getSession().getAttribute("AUTHUSER"); 
		String curPwd = request.getParameter("curPwd"); //현재 비번(변경전비번)
		String newPwd = request.getParameter("newPwd"); //new 비번(변경할비번)
		String new_kname = request.getParameter("new_kname"); //new 한글이름
		String new_ename = request.getParameter("new_ename"); //new 영어이름
		int new_emp_postcode = Integer.parseInt(request.getParameter("new_emp_postcode")); // 우편번호
		String sample6_address = request.getParameter("new_sample6_address");
		String sample6_detailAddress = request.getParameter("new_sample6_detailAddress");
		String sample6_extraAddress = request.getParameter("new_sample6_extraAddress");
		String new_emp_address = sample6_address+"/"+sample6_detailAddress+"/"+sample6_extraAddress;
		String new_birthday = request.getParameter("new_birthday"); //new 생일
		String new_phonenumber = request.getParameter("new_phonenumber"); //new 핸드폰번호
		String email_id = request.getParameter("emp_email_id"); // 이메일주소 앞
		String email_d = request.getParameter("emp_email_d"); // 이메일주소 뒤
		String new_emp_email = email_id+"@"+email_d; //이메일주소
		String new_dept_name = request.getParameter("new_dept_name"); //new 부서명
		int emp_position = Integer.parseInt(request.getParameter("new_position"));
		
		Map<String,Boolean> errors = new HashMap<String,Boolean>();
		request.setAttribute("errors",errors);//p607 42라인
		
		//현재비번과 새비번필수입력-p623 47라인
		if(curPwd==null || curPwd.isEmpty()) {
			errors.put("curPwd", Boolean.TRUE);
		}
		if(newPwd==null || newPwd.isEmpty()) {
			errors.put("newPwd", Boolean.TRUE);
		}
		
		//p623 53라인
		if(!errors.isEmpty()) {//에러가 존재하면
			return FORM_VIEW;
		}
		
		//2.비즈니스로직수행<->Service<->DAO<->DB-p607 53라인
		//3.Model&4.view-p623 57라인
		try {
			changMyInfoService.changMyInfo(user.getEmp_id(), curPwd, newPwd, new_kname,	new_ename, 
										new_emp_postcode, new_emp_address, new_birthday, 
										new_phonenumber,new_emp_email, new_dept_name, emp_position);
			System.out.println("changMyInfoService비즈니스 로직");
			return request.getContextPath()+"/view/changeSuccess.jsp";
		}catch(InvalidPasswordException e) {
			errors.put("badCurPwd", Boolean.TRUE);
			return FORM_VIEW;
		}catch(MemberNotFoundException e) {
			response.sendError(HttpServletResponse.SC_BAD_GATEWAY);
			return null;
		}
	}

}






