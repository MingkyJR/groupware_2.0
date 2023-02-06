package secondHand.service;

import java.util.List;

import secondHand.model.SecondHandDAO;
import secondHand.model.SecondHandDTO;
import secondHand.model.SecondHandPageDTO;

public class ListService {

	public List<SecondHandDTO> service(SecondHandPageDTO pageDTO) {
		SecondHandDAO dao = new SecondHandDAO();
		return dao.listSelect(pageDTO);
	}
}
