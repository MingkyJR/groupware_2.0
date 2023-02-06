package secondHand.service;

import secondHand.model.SecondHandDAO;

public class DeleteService {

	public int service(int no) {
		return new SecondHandDAO().delete(no);
	}
}
