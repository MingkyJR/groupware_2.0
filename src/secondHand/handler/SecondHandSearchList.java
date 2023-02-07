package secondHand.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import secondHand.model.SecondHandDAO;
import secondHand.model.SecondHandDTO;
import secondHand.model.SecondHandPageDTO;
import secondHand.service.ListService;

public class SecondHandSearchList implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String keyword = request.getParameter("keyword");
		String pageVal = request.getParameter("pageNo");
		if(pageVal==null) {
			pageVal="1";
		}
		SecondHandPageDTO pageDTO = new SecondHandPageDTO(Integer.parseInt(pageVal), keyword);
		List<SecondHandDTO> list = new ArrayList<>();
		list = new SecondHandDAO().listSearch(pageDTO, keyword);
		request.setAttribute("pageDTO", pageDTO);
		request.setAttribute("list", list);
		return request.getContextPath()+"/view/secondHand/list.jsp";
	}

}
