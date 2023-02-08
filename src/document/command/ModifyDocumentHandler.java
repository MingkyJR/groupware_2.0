package document.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import document.service.ReadDocumentService;
import document.service.DocumentData;
import document.service.DocumentNotFoundException;
import document.service.ModifyDocumentService;
import document.service.ModifyRequest;
import document.service.PermissionDeniedException;
import auth.service.User;
import mvc.command.CommandHandler;

public class ModifyDocumentHandler implements CommandHandler {

	private static final String FORM_VIEW = "/view/eApproval/4-02.문서수정.jsp";

	private ReadDocumentService readService = new ReadDocumentService();
	private ModifyDocumentService modifyService = new ModifyDocumentService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ModifyDocumentHandler.process()호출");

		// 폼의 요청방식에 따라 수정폼보여줘 요청과 수정처리요청을 구분
		if (request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request, response);// 수정폼보여줘
		} else if (request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request, response);// 수정처리요청
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}// process끝

	private String processForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {

			String strNo = request.getParameter("no");// 글번호
			if (strNo == null) {
				throw new RuntimeException();
			}
			int no = Integer.parseInt(strNo);// 상세조회할글번호
			// 만약 파라미터pageNo(즉,요청페이지)가 null이면 요청페이지를 1로 설정
			String strPageNo = request.getParameter("pageNo"); // 보고싶은페이지
			int pageNo = 1;
			if (strPageNo != null) {
				pageNo = Integer.parseInt(strPageNo);
			}
			// 만약 파라미터rowSize(페이지당게시글수)가 null이면 페이지당게시글수를 3으로 설정
			String strRowSize = request.getParameter("rowSize"); // 한 페이지당 보여줄 게시물수
			int rsize = 3;
			if (strRowSize != null) {
				rsize = Integer.parseInt(strRowSize);
			}

			String title = request.getParameter("title");// 수정할 제목
			String plans = request.getParameter("plans");// 수정할 내용
			String Sugg = request.getParameter("Sugg");// 수정할 내용
			String Uniq = request.getParameter("Uniq");// 수정할 내용
			String comm = request.getParameter("comm");// 수정할 내용

			DocumentData documentData = readService.getDocument(no);
			User authUser = (User) request.getSession().getAttribute("AUTHUSER");

			if (!canModify(authUser, documentData)) {// 수정불가이면
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}

			ModifyRequest modReq = new ModifyRequest(authUser.getEmp_no(), no, documentData.getContent().getTitle(),
					documentData.getContent().getPlans(), documentData.getContent().getSugg(),
					documentData.getContent().getUniq(), documentData.getContent().getComm());

			request.setAttribute("modReq", modReq);

			return FORM_VIEW;
		} catch (DocumentNotFoundException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);// 404에러
			return null;
		}
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("processSubmit");

		String strNo = request.getParameter("no");// 글번호

		if (strNo == null) {
			throw new RuntimeException();
		}
		int no = Integer.parseInt(strNo);// 상세조회할글번호
		System.out.println("no=" + no);

		String strPageNo = request.getParameter("pageNo"); // 보고싶은페이지
		System.out.println("strPageNo=" + strPageNo);
		int pageNo = 1;
		if (strPageNo != null) {
			pageNo = Integer.parseInt(strPageNo);
		}

		String strRowSize = request.getParameter("rowSize"); // 한 페이지당 보여줄 게시물수
		System.out.println("strRowSize=" + strRowSize);
		int rsize = 5;
		if (strRowSize != null) {
			rsize = Integer.parseInt(strRowSize);
		}

		User authUser = (User) request.getSession().getAttribute("AUTHUSER");
		String title = request.getParameter("title");// 수정할 제목
		String plans = request.getParameter("plans");// 수정할 내용
		String Sugg = request.getParameter("Sugg");// 수정할 내용
		String Uniq = request.getParameter("Uniq");// 수정할 내용
		String comm = request.getParameter("comm");// 수정할 내용

		ModifyRequest modReq = new ModifyRequest(authUser.getEmp_no(), no, title, plans, Sugg, Uniq, comm);

		request.setAttribute("modReq", modReq);

		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		request.setAttribute("errors", errors);// p670 78라인
		modReq.validate(errors);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {

			modifyService.modifiy(modReq);

			return "/view/eApproval/4-05.문서수정성공.jsp";

		} catch (DocumentNotFoundException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);// 404에러
			return null;
		} catch (PermissionDeniedException e) {// p671 89라인
			response.sendError(HttpServletResponse.SC_FORBIDDEN);// 403에러
			return null;
		}

	}// processSubmit()끝

	private boolean canModify(User authUser, DocumentData documentData) {
		int userId = authUser.getEmp_no();
		Integer userid = new Integer(userId);
		int writerId = documentData.getDocument().getDraft_empno();
		return userid.equals(writerId);
	}// canModify()끝

}
