package auth.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.LoginFailException;
import auth.service.LoginService;
import auth.service.User;
import mvc.command.CommandHandler;



public class LoginHandler implements CommandHandler {
	
	private static final String FORM_VIEW="/view/loginForm.jsp";
	private LoginService loginService = new LoginService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LoginHandler.process()호출");
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request,response);//회원가입폼보여줘
		}else if(request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request,response);//로그인처리요청
		}else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}//process끝
	
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		String emp_id = request.getParameter("emp_id"); //아이디
		String emp_pw= request.getParameter("emp_pw"); //비밀번호
		
		Map<String,Boolean> errors = new HashMap<String,Boolean>();
		request.setAttribute("errors",errors);//p607 42라인

		//id와 비번필수입력-p607 44라인
		if(emp_id==null || emp_id.isEmpty()) {
			errors.put("emp_id", Boolean.TRUE);
		}
		if(emp_pw==null || emp_pw.isEmpty()) {
			errors.put("emp_pw", Boolean.TRUE);
		}
		
		if(!errors.isEmpty()) {//에러가 존재하면
			return FORM_VIEW;
		}
		
		//2.비즈니스로직수행<->Service<->DAO<->DB-p607 53라인
		//3.Model&4.viewm
		try {//P607 53라인
			User user = loginService.login(emp_id, emp_pw);
			HttpSession session = request.getSession();
			session.setAttribute("AUTHUSER",user);
			response.sendRedirect(request.getContextPath()+"/chat.do");
			return null;
		}catch(LoginFailException e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}
	}
	
	
	//문자열의 좌우공백제거-p607 64라인
	private String trim(String str) {
		return  (str==null)? null:str.trim();
	}
}









