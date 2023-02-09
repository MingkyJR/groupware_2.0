package document.stat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class DeleteStatDocumentHandler implements CommandHandler {

	private DeleteStatDocumentService deleteStatDocumentService = new DeleteStatDocumentService();
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String strNo = request.getParameter("no");//글번호
		int no = Integer.parseInt(strNo);
		
		int cnt  = deleteStatDocumentService.deleteDocument(no);
		request.setAttribute("cnt", cnt);
	
		return "/view/eApproval/4-04.문서변경.jsp";
	}
}







