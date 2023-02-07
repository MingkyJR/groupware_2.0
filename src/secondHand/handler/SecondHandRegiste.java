package secondHand.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mvc.command.CommandHandler;
import secondHand.model.SecondHandContentDTO;
import secondHand.model.SecondHandDTO;
import secondHand.service.RegisteContentService;
import secondHand.service.RegisteService;

public class SecondHandRegiste implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request, response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request, response);
		}else {
			return null;
		}
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		int result = -1;
		MultipartRequest multi = null;
		String saveFolder = request.getServletContext().getRealPath("/upload/");
		System.out.println(saveFolder);
		
		try {
			multi = new MultipartRequest(request, saveFolder, 1024*1024*20, "utf-8", new DefaultFileRenamePolicy());
		}catch(IOException e){
			e.printStackTrace();
		}
		
		SecondHandDTO dto = new SecondHandDTO();
		dto.setEmpID(multi.getParameter("empID"));
		dto.setTitle(multi.getParameter("title"));
		dto.setPrice(Integer.parseInt(multi.getParameter("price")));
		dto.setFileName(multi.getOriginalFileName("fileName"));
		dto.setRefileName(multi.getFilesystemName("fileName"));
		
		RegisteService registeService = new RegisteService();
		result = registeService.service(dto);
		
		SecondHandContentDTO contentDTO = new SecondHandContentDTO(multi.getParameter("content"));
		RegisteContentService contentService = new RegisteContentService(); 
		result += contentService.service(contentDTO);
		
		if(result==2) {
			return request.getContextPath()+"/secondHand/list.do";
		}else {
			return request.getContextPath()+"/idex.jsp";
		}
	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		return request.getContextPath()+"/view/secondHand/registeForm.jsp";
	}

}
