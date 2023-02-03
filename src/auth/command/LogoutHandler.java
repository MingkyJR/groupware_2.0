package auth.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;

//이 컨트롤러 클래스는 로그아웃요청에 따라 호출되는 클래스이다
//요청주소   http://ip주소/컨패/logout.do
public class LogoutHandler implements CommandHandler {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LogoutHandler.process()호출");
		//컨트롤러가 해야 하는 일
		//1.파라미터받기
		//2.비즈니스로직수행<->Service<->DAO<->DB
		HttpSession session = request.getSession();
		if(session!=null) {
			session.invalidate(); //세션종료
		}
		//3.Model
		//4.view
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		return null;
	}

}





