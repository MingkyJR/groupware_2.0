package document.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.User;
import document.service.DocumentPage;
import document.service.ListDocumentService;
import document.service.WriteRequest;
import mvc.command.CommandHandler;

public class ListDocumentHandler implements CommandHandler {
	private ListDocumentService listDocumentService = new ListDocumentService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		User user = (User)(request.getSession().getAttribute("AUTHUSER"));
		int empNo = user.getEmp_no();
		System.out.println(empNo);
		
		String strPageNo = request.getParameter("pageNo"); // 보고싶은페이지
		int pageNo = 1;
		if (strPageNo != null) {
			pageNo = Integer.parseInt(strPageNo);
		}

		String strRowSize = request.getParameter("rowSize"); // 한 페이지당 보여줄 게시물수
		int rsize = 10;
		if (strRowSize != null) {
			rsize = Integer.parseInt(strRowSize);
		}
		
		DocumentPage documentPage = listDocumentService.getDocumentPage(pageNo, rsize);
		request.setAttribute("documentPage", documentPage);
		request.setAttribute("rsize", rsize);
		return "/view/eApproval/4-01.문서리스트2.jsp";
	}
}
