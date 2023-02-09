package work.command;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import work.model.Edit;
import work.service.WorkService;

public class ApproveHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String parEditNum = request.getParameter("num");
		int edit_num = Integer.parseInt(parEditNum);
		String parEmpNo = request.getParameter("emp_no");
		String parRegDate = request.getParameter("regDate");
		int emp_no = Integer.parseInt(parEmpNo);
		Date reg_date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(parRegDate);
		String work_status = "수정";
		String edit_status = "수정";
		
		WorkService workService = new WorkService();
		Edit edit = workService.select_edit_content(edit_num, emp_no, reg_date);
		workService.updateWork(edit.getEdit_out_time(), emp_no, reg_date, work_status);
		workService.updateEdit(edit_num, emp_no, reg_date, edit_status);
		return "editList.do";
	}

}
