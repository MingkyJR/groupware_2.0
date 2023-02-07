package secondHand.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import secondHand.model.SecondHandDTO;
import secondHand.model.SecondHandPageDTO;
import secondHand.service.ListService;

public class SecondHandList implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageVal = request.getParameter("pageNo");
		if(pageVal==null) {
			pageVal="1";
		}
		SecondHandPageDTO pageDTO = new SecondHandPageDTO(Integer.parseInt(pageVal));
		List<SecondHandDTO> list = new ArrayList<>();
		list = new ListService().service(pageDTO);
		request.setAttribute("pageDTO", pageDTO);
		request.setAttribute("list", list);
		return request.getContextPath()+"/view/secondHand/list.jsp";
	}

}
