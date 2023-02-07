package notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import notice.service.ListNoticeService;
import notice.service.NoticePage;
import notice.service.SearchNoticeService_;

//게시글 목록 내에서 검색기능과 관련된 담당 컨트롤러
public class SearchNoticeHandler_ implements CommandHandler {
	
	private SearchNoticeService_ searchNoticeService = 
			new SearchNoticeService_();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//1.파라미터 받기
		String strPageNo = request.getParameter("pageNo");//보고싶은 페이지
//		String strPageNo = null;
		int pageNo = 1;
		System.out.println("*************************************"+pageNo);
		if(strPageNo!=null) {
			pageNo=Integer.parseInt(strPageNo);
			System.out.println("*************************************"+pageNo);
		}		
		
		String strRowSize = request.getParameter("rowSize");//한페이지당 보여지는 게시물 수
//		int size = Integer.parseInt(strRowSize);-->>원래 에러 나는 형태.... nullpoint exception 뜬다.
		int rsize = 3;
		if(strRowSize!=null) {
			rsize = Integer.parseInt(strRowSize);			
		}
		//?choice=title&keyword=~~
		String strChoice = request.getParameter("choice");//view페이지 내에 select 태그 id
		String choice = "";
		if(strChoice!=null) {
			choice=strChoice;
		}
		String strKeyword = request.getParameter("keyword");//유저 검색 키워드
		String keyword = "";
		if(strKeyword!=null) {
			keyword=strKeyword;
		}
		
		System.out.println("초이스는"+choice);
		System.out.println("검색어는는"+keyword);
		
		//2. 비즈니스 로직 수행
		//향후 페이징추가 작업예정 ~~ 리턴 유형에 변화를 줄 예정~~
		NoticePage searchPage = searchNoticeService.getSearchList(choice, keyword, pageNo, rsize); //수정해야함
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+searchPage);
		
		//3. model
		//request.setAttribute("listNotice", listNotice);
		request.setAttribute("searchPage", searchPage);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("rsize", rsize);
		
		
		//4.view
		
		return "/view/notice/listNotice.jsp";
	}

}
