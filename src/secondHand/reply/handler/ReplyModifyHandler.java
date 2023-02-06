package secondHand.reply.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import secondHand.reply.service.ReplyModifyService;

public class ReplyModifyHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int reNo = Integer.parseInt(request.getParameter("reNo"));
		String reContent = request.getParameter("reContent");
		int result = new ReplyModifyService().modifyService(reNo, reContent);
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(result);
		return null;
	}

}
