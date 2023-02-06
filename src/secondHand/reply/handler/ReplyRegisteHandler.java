package secondHand.reply.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import secondHand.reply.model.ReplyDTO;
import secondHand.reply.service.ReplyRegisteService;

public class ReplyRegisteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int oriNo = Integer.parseInt(request.getParameter("oriNo"));
		String empid = request.getParameter("empid");
		System.out.println("empid = "+empid);
		String recontent = request.getParameter("recontent");
		ReplyDTO dto = new ReplyDTO();
		dto.setOriNo(oriNo);
		dto.setEmpID(empid);
		dto.setReContent(recontent);
		int result = new ReplyRegisteService().registeService(dto);
		response.getWriter().print(result);
		return null;
	}

}
