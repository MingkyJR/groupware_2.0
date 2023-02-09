package work.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import work.model.Edit;
import work.service.WorkService;

public class EditListHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "/view/work/edit_list.jsp";

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("EditListHandler process()");
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
		String emp_name = null;
		WorkService workService = new WorkService();
		List<Edit> editList = workService.select_edit(emp_name);
		request.setAttribute("editList", editList);
		
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		String emp_name = null;
		String parEmp_name = request.getParameter("emp_name");
		if(parEmp_name != null) {
			emp_name = parEmp_name;
		}
		WorkService workService = new WorkService();
		List<Edit> editList = workService.select_edit(emp_name);
		request.setAttribute("editList", editList);
		
		return FORM_VIEW;
	}
}
