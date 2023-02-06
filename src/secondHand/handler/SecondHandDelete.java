package secondHand.handler;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import mvc.command.CommandHandler;
import secondHand.model.SecondHandContentDTO;
import secondHand.model.SecondHandDAO;
import secondHand.service.DeleteService;

public class SecondHandDelete implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		int result = -1;
		SecondHandContentDTO dto = new SecondHandDAO().selectContent(no);
		String fileName = dto.getRefileName();
		String filePath = request.getServletContext().getRealPath("/upload/"+fileName);
		result = new DeleteService().service(no);
		if(result==1) {
			File file = new File(filePath);
			System.out.println("----"+filePath);
			if(file.exists()) {
				System.out.println("file.exists()");
				boolean val = file.delete();
				System.out.println(val);
			}
		}
		return request.getContextPath()+"/secondHand/list.do";
	}

}
