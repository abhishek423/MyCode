package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LinkDAO;
import model.Link;

@Service
public class AddFriendOperation {
	
	@Autowired
	LinkDAO ldao;
	
	public void execute(Link l) {
		/*Link l = new Link();
		l.setUser1(userId);
		l.setUser2(friendValue);*/
		ldao.create(l);
	}

	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
