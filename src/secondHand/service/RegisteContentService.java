package secondHand.service;

import secondHand.model.SecondHandContentDTO;
import secondHand.model.SecondHandDAO;

public class RegisteContentService {

	public int service(SecondHandContentDTO dto) {
		SecondHandDAO dao = new SecondHandDAO();
		dto.setNo(dao.lookup());
		return dao.insert(dto);
	}
	public void updateContent(SecondHandContentDTO dto) {
		new SecondHandDAO().contentUpdate(dto);
	}
}
