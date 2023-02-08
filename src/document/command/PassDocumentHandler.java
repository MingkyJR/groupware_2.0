package document.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import document.service.DocumentPage;
import document.service.PassDocumentService;
import mvc.command.CommandHandler;

public class PassDocumentHandler implements CommandHandler {

	private PassDocumentService passDocumentService = new PassDocumentService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String strPageNo = request.getParameter("pageNo"); // 보고싶은페이지
		int pageNo = 1;
		if (strPageNo != null) {
			pageNo = Integer.parseInt(strPageNo);
		}

		String strRowSize = request.getParameter("rowSize"); // 한 페이지당 보여줄 게시물수
		int rsize = 5;
		if (strRowSize != null) {
			rsize = Integer.parseInt(strRowSize);
		}

		DocumentPage documentPage = passDocumentService.getDocumentPage(pageNo, rsize);
		request.setAttribute("documentPage", documentPage);
		request.setAttribute("rsize", rsize);
		return "/view/eApproval/4-07.승인문서리스트.jsp";
	}

}
