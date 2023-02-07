package work.command;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class WriteEditHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "/view/work/edit_work_form.jsp";

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("WriteEditHandler process()");
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request,response);//회원가입폼보여줘
		}else if(request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request,response);//가입처리요청
		}else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}


	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		String date = request.getParameter("date");
		String strInTime = request.getParameter("inTime");
		String inTime = strInTime.substring(11, 16);
		
		request.setAttribute("date", date);
		request.setAttribute("inTime", inTime);
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		String strNewInTime = request.getParameter("NewInTime");
		String strOutTime = request.getParameter("outTime");
		System.out.println(strNewInTime);
		System.out.println(strOutTime);
		return FORM_VIEW;
	}

}
