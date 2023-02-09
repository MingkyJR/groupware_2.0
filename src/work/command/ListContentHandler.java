package work.command;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import work.model.Edit;
import work.service.WorkService;

public class ListContentHandler implements CommandHandler {

	private static final String FORM_VIEW = "/view/work/list_content.jsp";
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String parEditNum = request.getParameter("num");
		int edit_num = Integer.parseInt(parEditNum);
		String parEmpNo = request.getParameter("emp_no");
		String parRegDate = request.getParameter("regDate");
		int emp_no = Integer.parseInt(parEmpNo);
		Date reg_date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(parRegDate);
		
		WorkService workService = new WorkService();
		Edit edit = workService.select_edit_content(edit_num, emp_no, reg_date);
		request.setAttribute("edit", edit);
		return FORM_VIEW;
	}

}
