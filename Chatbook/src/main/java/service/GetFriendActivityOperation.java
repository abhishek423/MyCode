package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDAO;
import model.User;

@Service
public class GetFriendActivityOperation {

	@Autowired
	UserDAO udao;
	
	public User execute(String userId) {
		User u = udao.retieveByUserId(userId);
		return u;
	}
}
