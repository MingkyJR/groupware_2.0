package work.command;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import mvc.command.CommandHandler;
import work.service.WorkService;

public class WriteEditHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "/view/work/edit_work_form.jsp";
	
	private WorkService workService = new WorkService();

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
	
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		User authUser = (User)request.getSession().getAttribute("AUTHUSER");
		
		String reason = request.getParameter("reason");
		String parDate = request.getParameter("date");
		String parNewInTime = request.getParameter("newInTime");
		String parNewOutTime = request.getParameter("newOutTime");
		String strNewInTime = parDate +" "+ parNewInTime + ":00.0";
		String strNewOutTime = parDate +" "+ parNewOutTime + ":00.0";
		
		Timestamp newInTime = java.sql.Timestamp.valueOf(strNewInTime);
		Timestamp newOutTime = java.sql.Timestamp.valueOf(strNewOutTime);
		Date date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(parDate);
		System.out.println(newInTime);
		System.out.println(newOutTime);
		System.out.println(date);
		
		workService.insert_edit(date, newInTime, newOutTime, authUser.getEmp_kname(),reason, authUser.getEmp_no());
		workService.update_work_status(date, authUser.getEmp_no());
		
		return "/workEdit.do";
	}

}
