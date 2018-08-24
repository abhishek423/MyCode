/*package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LinkDAO;
import model.Link;

@Service
public class SearchUserDetailsOperation {
	
		@Autowired
		LinkDAO ldao;
		
		public List<Link> execute(String userId,String friendValue){
			
			List<Link> fl = ldao.retrieveLinksByUserIdAndFriendValue(userId,friendValue);
			
			return fl;
			
		}
		

}
*/