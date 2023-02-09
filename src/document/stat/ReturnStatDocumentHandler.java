package document.stat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class ReturnStatDocumentHandler implements CommandHandler {

	private ReturnStatDocumentService returnStatDocumentService = new ReturnStatDocumentService();
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String strNo = request.getParameter("no");//글번호
		int no = Integer.parseInt(strNo);
		
		int cnt1 = returnStatDocumentService.returnDocument(no);
	
		request.setAttribute("cnt1", cnt1);
	
		return "/view/eApproval/4-04.문서변경.jsp";
	}
}







