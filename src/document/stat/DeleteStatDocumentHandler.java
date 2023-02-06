package document.stat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

//삭제요청 담당 컨트롤러 클래스(update용)
//요청url http:/localhost/article/deleteArticle2.do
public class DeleteStatDocumentHandler implements CommandHandler {

	private DeleteStatDocumentService deleteStatDocumentService = new DeleteStatDocumentService();
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.파라미터 받기
		String strNo = request.getParameter("no");//글번호
		int no = Integer.parseInt(strNo);
		
		//2.비즈니스로직<->Service<->DAO<->DB
		/*파라미터  int no : 삭제할 글번호
		 *리턴타입  int cnt: 삭제(update)된 행 수. 1이면 삭제성공,0이면 삭제실패*/
		int cnt  = deleteStatDocumentService.deleteDocument(no);
	
		//3.Model
		request.setAttribute("cnt", cnt);
	
		//4.View
		return "/view/eApproval/4-04.문서변경.jsp";
	}
}







