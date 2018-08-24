package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDAO;
import model.User;

@Service
public class VerifyUserOperation {

	@Autowired
	UserDAO udao;
	User user;
	
	public boolean execute(String userId,String pass) {
		
		boolean verification = false;
		
		user = udao.retieveByUserIdAndPassword(userId, pass);
		System.out.println("User value in service "+user);;
		if(user!=null) {
			verification = true;
		}else {
			verification = false;
		}
		
		return verification;

	}
}
