package secondHand.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import secondHand.model.SecondHandContentDTO;
import secondHand.reply.service.ReplyListService;
import secondHand.service.ContentService;

public class SecondHandContent implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("---SecondHandContent()----");
		int no = Integer.parseInt(request.getParameter("no"));
		ContentService contentService = new ContentService();
		request.setAttribute("reply", new ReplyListService().listService(no));
		request.setAttribute("views", Integer.parseInt(request.getParameter("views")));
		request.setAttribute("currentPage", Integer.parseInt(request.getParameter("currentPage")));
		request.setAttribute("content", (SecondHandContentDTO)contentService.service(no));
		request.setAttribute("no", no);
		request.setAttribute("price", request.getParameter("price"));
		return request.getContextPath()+"/view/secondHand/content.jsp";
	}

}
