package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LinkDAO;
import dao.PostDAO;
import model.Post;

@Service
public class GetFriendMsg {
	
	@Autowired
	PostDAO pdao;
	
	@Autowired
	LinkDAO ldao;
	
	public List<Post> execute(String userId,String friendsValue){
		
		int linkId = ldao.retrieveLinkByUserIdAndFriendValue(userId, friendsValue);
		
		List<Post> pl = pdao.retrieveBylinkId(linkId);
		return pl;
	
	}
	
	
}
