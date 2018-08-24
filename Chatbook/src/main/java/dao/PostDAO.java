package dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import model.Link;
import model.Post;

@Component
public class PostDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Post> retrieveBylinkId(int linkId) {
		try {

			Session session =  sessionFactory.getCurrentSession();
			System.out.println("msg retrieving.....");

			String hql = " FROM Post p WHERE p.linkId = ? ";
			List<Post> result = session.createQuery(hql)
					.setParameter(0, linkId)
					.list();
			/*Query query = session.createQuery(hql);
			List<Post> msg = (List<Post>) query.list();*/
			System.out.println(result);
			return result;

		}catch(Exception e) {

			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	public void create(Post p) {

		Session session =  sessionFactory.getCurrentSession();
		System.out.println(p.toString());
		session.save(p);
		
	}
	
	@Transactional
	public Post retrieveLastMsg(int linkId) {
		try {

			Session session =  sessionFactory.getCurrentSession();
			System.out.println("msg retrieving.....");

			String hql = " FROM Post p WHERE p.linkId = ? order by dateTime DESC";
			Post result = (Post) session.createQuery(hql)
					.setParameter(0, linkId)
					.setMaxResults(1)
					.uniqueResult();
			System.out.println(result);
			return result;

		}catch(Exception e) {

			e.printStackTrace();
			return null;
		}
	}
	@Transactional
	public Post retrieveLastMsg(String userId, String friendValue) {
		// TODO Auto-generated method stub
		return null;
	}
}
