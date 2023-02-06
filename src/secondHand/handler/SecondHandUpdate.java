package secondHand.handler;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mvc.command.CommandHandler;
import secondHand.model.SecondHandContentDTO;
import secondHand.model.SecondHandDAO;
import secondHand.model.SecondHandDTO;
import secondHand.service.RegisteContentService;
import secondHand.service.UpdateService;

public class SecondHandUpdate implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("GET")) {
			request.setAttribute("no", request.getParameter("no"));
			request.setAttribute("title", request.getParameter("title"));
			request.setAttribute("content", request.getParameter("content"));
			request.setAttribute("price", request.getParameter("price"));
			return request.getContextPath()+"/view/secondHand/updateForm.jsp";
		} else {
			return processSubmit(request, response);
		}
	
	}
	
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		int result = -1;
		MultipartRequest multi = null;
		String saveFolder = request.getServletContext().getRealPath("/upload/");
		try {
			multi = new MultipartRequest(request, saveFolder, 1024*1024*20, "utf-8", new DefaultFileRenamePolicy());
		}catch(IOException e){
			e.printStackTrace();
		}
		SecondHandDTO dto = new SecondHandDTO();
		dto.setNo(Integer.parseInt(multi.getParameter("no")));
		dto.setTitle(multi.getParameter("title"));
		dto.setPrice(Integer.parseInt(multi.getParameter("price")));
		String fileName = multi.getOriginalFileName("fileName");
		if(fileName==null) {
			String query = 	"update secondhand" + 
							" set title=?," + 
							" price=?" + 
							" where no=?";
			result = new UpdateService().service(query, dto);
		}else {
			System.out.println("else 접근");
			String reFileName = new SecondHandDAO().selectContent(dto.getNo()).getRefileName();
			String filePath = request.getServletContext().getRealPath("/upload/"+reFileName);
			File file = new File(filePath);
			System.out.println("----"+filePath);
			if(file.exists()) {
				System.out.println("file.exists()");
				boolean val = file.delete();
				System.out.println(val);
			}
			dto.setFileName(multi.getOriginalFileName("fileName"));
			dto.setRefileName(multi.getFilesystemName("fileName"));
			String query=	"update secondhand" + 
							" set title=?," + 
							" price=?," + 
							" filename=?," + 
							" refilename=?" + 
							" where no=?";
			result = new UpdateService().service(query, dto);
		}
		
		if(result==1) {
			SecondHandContentDTO contentDTO	= new SecondHandContentDTO();
			contentDTO.setNo(Integer.parseInt(multi.getParameter("no")));
			contentDTO.setContent(multi.getParameter("content"));
			System.out.println("content insert if 문"+contentDTO.getContent());
			new RegisteContentService().updateContent(contentDTO);
		}
		return request.getContextPath()+"/secondHand/list.do";
	}

}
