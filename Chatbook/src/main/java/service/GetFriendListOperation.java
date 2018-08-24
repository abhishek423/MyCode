package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LinkDAO;
import dao.UserDAO;
import model.Link;
import model.User;
@Service
public class GetFriendListOperation {

	@Autowired
	LinkDAO ldao;
	
	public List<Link> execute(String userId) {
		
		List<Link> fl = ldao.retrieveLinksByUserId(userId);

		return fl;
		
	}
	
	/*@Autowired
	UserDAO udao;
	
	public List<User> execute(){
		
		List<User> fl = udao.retrieveAllUserId();
		
		return fl;
		
	}*/
}
