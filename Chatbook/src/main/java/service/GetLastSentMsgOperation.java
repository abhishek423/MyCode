package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PostDAO;
import model.Post;

@Service
public class GetLastSentMsgOperation {

		@Autowired
		PostDAO pdao;
		
		public Post execute(int linkId){
			
			Post p = pdao.retrieveLastMsg(linkId);
			//System.out.println("last msg "+p.getMsg());
			return p;
		}
	}
