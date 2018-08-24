package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PostDAO;
import model.Post;

@Service
public class GetMsgOperation {

	@Autowired
	PostDAO pdao;
	
	public List<Post> execute(int linkId){
		
		List<Post> pl = pdao.retrieveBylinkId(linkId);
		return pl;
	}
}
