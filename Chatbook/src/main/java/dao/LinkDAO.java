package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import model.Link;
import model.Post;
import model.User;

@Component
public class LinkDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Link> retrieveLinksByUserId(String userId) {
		try {

			Session session =  sessionFactory.getCurrentSession();
			System.out.println("friendList retrieving....."+userId);

			//String hql = "from Stock s where s.stockCode = ? and s.stockName = ?";
			//List result = session.createQuery(hql)
			/*.setString(0, "7277")
			.setParameter(1, "DIALOG")
			.list();*/
			
			String hql = "FROM Link l WHERE l.user1 = ? or l.user2 = ?";
			List<Link> result = session.createQuery(hql)
					.setParameter(0, userId)
					.setParameter(1, userId)
					.list();
			//Query query = session.createQuery(hql);
			//List<User> friendList = (List<User>) query.list();
			System.out.println(result);
			return result;

		}catch(Exception e) {

			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	public int retrieveLinkByUserIdAndFriendValue(String userId,String friendValue) {
		try {

			Session session =  sessionFactory.getCurrentSession();
			System.out.println("friendList retrieving....."+userId);

			
			String hql = "SELECT l.linkId FROM Link l WHERE (l.user1 = ? AND l.user2 = ?) OR (l.user1 = ? AND l.user2 = ?)";

			int result = (Integer) session.createQuery(hql)
					.setParameter(0, userId)
					.setParameter(1, friendValue)
					.setParameter(2, friendValue)
					.setParameter(3, userId)
					.setMaxResults(1)
					.uniqueResult();
			
			//Query query = session.createQuery(hql);
			//List<User> friendList = (List<User>) query.list();
			System.out.println(result);
			return result;

		}catch(Exception e) {

			e.printStackTrace();
			return 0;
		}
	}

	@Transactional
	public void create(Link l) {

		Session session =  sessionFactory.getCurrentSession();
		System.out.println(l.toString());
		session.save(l);
		
	}
}

