package secondHand.service;

import secondHand.model.SecondHandDAO;
import secondHand.model.SecondHandDTO;

public class RegisteService {

	public int service(SecondHandDTO dto) {
		System.out.println("RegisteService");
		SecondHandDAO dao = new SecondHandDAO();
		return dao.insert(dto);
	}
}
