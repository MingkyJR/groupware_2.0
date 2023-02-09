package employee.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.service.ManageService;
import mvc.command.CommandHandler;

public class ManageHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//파라미터 받기
		
		
		//비즈니스 로직 수행 <-> 서비스 <-> DAO <-> DB

		//매니지서비스 호출을 위해 manageService 객체 생성
		ManageService manageService = new ManageService();

		
		//매니지서비스 안의 메서드 호출
		List list = manageService.getEmp();
		
		
		
		//비즈니스 로직 수행 결과 (모델) 
		//서비스에서 리턴값으로 받아온 list를 폼에 넘겨주기 위한 setAttribute
		request.setAttribute("list", list);
		

		
		
		//뷰 지정
		//뷰가 스트링타입인 이유는 커맨드핸들러에서 지정해두었기 때문에
		return request.getContextPath()+"view/empManageForm.jsp";
		
	}

}
