package notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.service.DeleteNoticeService;
import mvc.command.CommandHandler;


//담당 컨트롤러 클래스(delete용)
//http://localhost/article/deleteArticle.do
public class DeleteNoticeHandler implements CommandHandler {
	
//	private static final String FORM_VIEW="../view/notice/deleteNotice.jsp";
	private DeleteNoticeService delNoticeService = new DeleteNoticeService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("DeleteNoticeHandler의 Process()호출성공");
		
		//컨트롤러가 해야 할 일
		//1.파라미터 얻기
		String strNo = request.getParameter("no"); //글번호
		int no = Integer.parseInt(strNo);
		
		
		//2.비즈니스 로직 수행 -> Service -> DAO -> DB -> DAO -> Service -> 비즈니스 로직 수행(되돌아 온다)
		/*파라미터 int no : 삭제할 글번호
		   리턴타입 int cnt: 삭제(update)된 행 수. 1이면 삭제성공, 0이면 삭제실패*/
		int cnt = delNoticeService.deleteNotice(no);
		
		//3.Model(비즈니스로직 수행결과)처리
		request.setAttribute("cnt", cnt);
		
		//4.View지정
		
//		return FORM_VIEW;
		return "/view/notice/deleteNotice2.jsp";
	}

}
