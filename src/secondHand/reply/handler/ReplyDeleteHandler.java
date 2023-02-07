package secondHand.reply.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import secondHand.reply.service.ReplyDeleteService;

public class ReplyDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int reNo = Integer.parseInt(request.getParameter("reNo"));
		int result = new ReplyDeleteService().deleteService(reNo);
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(result);
		return null;
	}

}
