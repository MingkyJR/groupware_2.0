package secondHand.service;

import secondHand.model.SecondHandContentDTO;
import secondHand.model.SecondHandDAO;
import secondHand.model.SecondHandDTO;

public class ContentService {

	public SecondHandContentDTO service(int no) {
		SecondHandContentDTO contentDTO = new SecondHandDAO().selectContent(no);
		if(contentDTO!=null) {
			new SecondHandDAO().viewCount(no);
		}
		return contentDTO;
	}
}
