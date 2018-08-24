package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.UserDAO;

@Component
public class SetUserActivityLogOperation {

	@Autowired
	UserDAO udao;
	
	public void execute(String userId, int logValue) {
		boolean update = udao.updateActivityByUserId(userId,logValue);
	}
}
