package work.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class WriteEditHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "/view/work/edit_work_form.jsp";

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return FORM_VIEW;
	}

}
