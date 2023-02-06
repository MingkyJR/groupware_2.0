package secondHand.service;

import secondHand.model.SecondHandContentDTO;
import secondHand.model.SecondHandDAO;
import secondHand.model.SecondHandDTO;

public class UpdateService {

	public int service(String query, SecondHandDTO dto) {
		System.out.println("=================="+dto.getFileName());
		if(dto.getFileName()==null) {
			return new SecondHandDAO().update(query, dto);
		}else {
			return new SecondHandDAO().update2(query, dto);
		}
	}
	public void contentUpdate(SecondHandContentDTO contentDTO) {
		new SecondHandDAO().contentUpdate(contentDTO);
	}
}
