package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LinkDAO;

@Service
public class GetlinkIdOperation {

	@Autowired
	LinkDAO ldao;
	
	public int execute(String userId,String friendValue) {
		int linkId = ldao.retrieveLinkByUserIdAndFriendValue(userId, friendValue);
		return linkId;
	}
}
