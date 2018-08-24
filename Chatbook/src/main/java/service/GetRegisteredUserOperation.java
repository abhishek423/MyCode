package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDAO;
import model.User;

@Service
public class GetRegisteredUserOperation {

	@Autowired
	UserDAO udao;
	
	public List<User> execute(String searchInput){
		
		List<User> ul = udao.retrieveAllUserId(searchInput);
		return ul;
	}
	
}
