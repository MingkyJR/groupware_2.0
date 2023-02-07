package secondHand.handler;

import java.io.FileInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class ImageOutputStream implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String file = request.getParameter("reFileName");
		response.setContentType("image/jsp");
		ServletOutputStream bout = response.getOutputStream();
		String filePath = request.getServletContext().getRealPath("/upload/");
		
		FileInputStream io = new FileInputStream(filePath+file);
		int length;
		byte[] buffer = new byte[10];
		while((length=io.read(buffer))!=-1) {
			bout.write(buffer, 0, length);
		}
		if(bout!=null) {
			bout.close();
		}
		if(io!=null) {
			io.close();
		}
		return null;
	}

}
