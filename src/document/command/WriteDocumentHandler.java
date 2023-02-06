package document.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import document.model.Writer;
import document.service.WriteDocumentService;
import document.service.WriteRequest;
import auth.service.User;
import mvc.command.CommandHandler;

public class WriteDocumentHandler implements CommandHandler {

	private static final String FORM_VIEW = "/view/eApproval/4-08.기안서.jsp";
	private WriteDocumentService writeDocumentService = new WriteDocumentService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request, response);// 쓰기폼보여줘
		} else if (request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request, response);// 쓰기처리요청
		} else {

			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}// process끝

	private String processForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 로그인한 유저정보는 세션에서 받자
		User authUser = loginedUser(request);
		request.setAttribute("AUTHUSER", authUser);
		return FORM_VIEW;
	}

	public User loginedUser(HttpServletRequest request) {

		User authUser = (User) request.getSession().getAttribute("AUTHUSER");

		return authUser;

	}


	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		String title = request.getParameter("title");// 업무명
		String plans = request.getParameter("plans");// 업무계획
		String sugg = request.getParameter("sugg");// 건의사항
		String uniq = request.getParameter("uniq");// 특이사항
		User authUser = loginedUser(request);
			
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		request.setAttribute("errors", errors);// p641 37라인
		WriteRequest writeReq = createWriteRequest(authUser, request);
		writeReq.validate(errors);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		int newDocumentNo = writeDocumentService.write(writeReq);
		request.setAttribute("newDocumentNo", newDocumentNo);
		return "/view/eApproval/4-11.작성성공.jsp";
	}// processSubmit(끝)

	private WriteRequest createWriteRequest(User authUser, HttpServletRequest request) {
		return new WriteRequest(authUser.getEmp_no(),
								new Writer (authUser.getEmp_kname(),
											authUser.getDept_name(),
											authUser.getEmp_position()),
								request.getParameter("title"), 
								request.getParameter("plans"),
								request.getParameter("sugg"), 
								request.getParameter("uniq"));

	}
}
