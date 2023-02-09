package document.stat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class PassStatDocumentHandler implements CommandHandler {

	private PassStatDocumentService passStatDocumentService = new PassStatDocumentService();
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String strNo = request.getParameter("no");//글번호
		int no = Integer.parseInt(strNo);
		
		int cnt2 = passStatDocumentService.passDocument(no);
		request.setAttribute("cnt2", cnt2);
		
		return "/view/eApproval/4-04.문서변경.jsp";
	}
}







