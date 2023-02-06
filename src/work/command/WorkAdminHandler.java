package work.command;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import mvc.command.CommandHandler;
import work.model.Work;
import work.service.DatePg;
import work.service.Page;
import work.service.WorkService;

public class WorkAdminHandler implements CommandHandler {

	private static final String FORM_VIEW = "/view/work/work_admin.jsp";
	
	private WorkService workService = new WorkService();
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("WorkHandler process()");
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request,response);//회원가입폼보여줘
		}else if(request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request,response);//가입처리요청
		}else {
			/* 참고. 
			 * 상태코드 => SC_OK
			 * 200(성공): 서버가 요청을 제대로 처리했다는 뜻이다. 
			 * 이는 주로 서버가 요청한 페이지를 제공했다는 의미로 쓰인다.
			 * 
			 * 상태코드 => SC_METHOD_NOT_ALLOWED
			 * 405(허용되지 않는 메소드): 
			 * 요청에 지정된 방법을 사용할 수 없다. 
			 * 예를 들어 POST 방식으로 요청을 받는 서버에 GET 요청을 보내는 경우, 
			 * 또는 읽기 전용 리소스에 PUT 요청을 보내는 경우에 이 코드를 제공한다.*/
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
		
		
		
		
	}




	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		User authUser = (User)request.getSession().getAttribute("AUTHUSER");
	
		
		int emp_no = authUser.getEmp_no();
		String strEmp_no = request.getParameter("empNo");
		if(strEmp_no != null) {
			emp_no = Integer.parseInt(strEmp_no);
		}
		 
		DatePg date = new DatePg();
		
		String strPageYear = request.getParameter("pageYear");
		int pageYear = date.getYear(); //2023
		if(strPageYear != null) {
			pageYear = Integer.parseInt(strPageYear);
		}
		String strPageMon = request.getParameter("pageMon");
		int pageMon = date.getMonth(); //
		if(strPageMon != null) {
			pageMon = Integer.parseInt(strPageMon);
			if(pageMon == 0) {
				pageYear -= 1;
				pageMon = 12;
			}
			if(pageMon == 13) {
				pageYear += 1;
				pageMon = 1;
			}
		}
		List<Work> monthList = workService.selectMonth(pageYear, pageMon, emp_no);
		Page pageAtt = new Page(pageYear, pageMon, emp_no);
		request.setAttribute("pageAtt", pageAtt);
		request.setAttribute("monthList", monthList);
		
		//Model
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		User authUser = (User)request.getSession().getAttribute("AUTHUSER");
		Map<String,Boolean> errors = new HashMap<String,Boolean>();
		request.setAttribute("errors",errors);
		
		int emp_no = authUser.getEmp_no();
		String strEmp_no = request.getParameter("empNo");
		
		 
		DatePg date = new DatePg();
		
		String strPageYear = request.getParameter("pageYear");
		int pageYear = date.getYear(); //2023
		if(strPageYear != null) {
			pageYear = Integer.parseInt(strPageYear);
		}
		String strPageMon = request.getParameter("pageMon");
		int pageMon = date.getMonth(); //
		if(strPageMon != null) {
			pageMon = Integer.parseInt(strPageMon);
		}
		if(strEmp_no==null || strEmp_no.isEmpty()) {
			errors.put("empNo", Boolean.TRUE);
		}
		if(!errors.isEmpty()) {//에러가 존재하면
			return FORM_VIEW;
		}
		
		if(strEmp_no != null) {
			emp_no = Integer.parseInt(strEmp_no);
		}
		List<Work> monthList = workService.selectMonth(pageYear, pageMon, emp_no);
		Page pageAtt = new Page(pageYear, pageMon, emp_no);
		request.setAttribute("pageAtt", pageAtt);
		request.setAttribute("monthList", monthList);
		
		//Model
		return FORM_VIEW;
	}
	

}
