package document.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import document.service.DocumentData;
import document.service.ReadDocumentService;
import mvc.command.CommandHandler;

public class ReadDocumentHandler implements CommandHandler {

	private ReadDocumentService readService = new ReadDocumentService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String strNo = request.getParameter("no");
		if (strNo == null) {
			throw new RuntimeException();
		}
		int no = Integer.parseInt(strNo);// 상세조회할글번호

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

		DocumentData documentData = readService.getDocument(no);
		request.setAttribute("documentData", documentData);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("rowSize", rsize);

		return "/view/eApproval/4-03.문서읽기.jsp";
	}

}
