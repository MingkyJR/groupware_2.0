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

public class SecondHandList implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageVal = request.getParameter("pageNo");
		String keyword = request.getParameter("keyword");
		if(pageVal==null) {
			pageVal="1";
		}
		if(keyword!=null) {
			SecondHandPageDTO pageDTO = new SecondHandPageDTO(Integer.parseInt(pageVal), keyword);
			List<SecondHandDTO> list = new ArrayList<>();
			list = new SecondHandDAO().listSearch(pageDTO, keyword);
			request.setAttribute("pageDTO", pageDTO);
			request.setAttribute("list", list);
			request.setAttribute("keyword", keyword);
			return request.getContextPath()+"/view/secondHand/list.jsp";
		}else {
			SecondHandPageDTO pageDTO = new SecondHandPageDTO(Integer.parseInt(pageVal));
			List<SecondHandDTO> list = new ArrayList<>();
			list = new ListService().service(pageDTO);
			request.setAttribute("pageDTO", pageDTO);
			request.setAttribute("list", list);
			request.setAttribute("keyword", keyword);
			return request.getContextPath()+"/view/secondHand/list.jsp";
		}
		
	}

}
