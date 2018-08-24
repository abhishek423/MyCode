package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Post;
import model.User;

@Component
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public User retieveByUserIdAndPassword(String userId,String pass) {

		Session session = sessionFactory.getCurrentSession();
		NativeQuery<User> query = session.createNativeQuery("select * from user_registration where user_id='"
				+userId+"' and password = '"+pass+"'", User.class);
		User user = query.uniqueResult();
		System.out.println(user);

		return user;

	}

	@Transactional
	public boolean updateActivityByUserId(String userId,int logValue) {

		/*Session session = sessionFactory.getCurrentSession();
			NativeQuery<User> query = session.createNativeQuery("update user_registration SET activity="+logValue+" where user_id='"
					+userId+"'", User.class);
			User user = query.uniqueResult();
			System.out.println(user);*/

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		try{

			//tx = session.beginTransaction();
			User user = (User)session.get(User.class, userId); 
			user.setActivity(logValue);
			session.update(user); 
			// tx.commit();

		}catch (HibernateException e) {
			// if (tx!=null) //tx.rollback();
			e.printStackTrace(); 
		}

		// session.close();
		return true;

	}
	
	@Transactional
	public List<User> retrieveAllUserId(String searchInput) {
		try {

			Session session =  sessionFactory.getCurrentSession();
			System.out.println("friendList retrieving....."+searchInput);
			
			Query query = session.createQuery("From User u where u.userId like ?");
			query.setParameter(0, "%"+searchInput+"%");
			
			/*String hql = "SELECT u.userId FROM User u";
			Query query = session.createQuery(hql);*/
			List<User> searchList = (List<User>) query.list();
			System.out.println(searchList);
			return searchList;

		}catch(Exception e) {

			e.printStackTrace();
			return null;
		}
	}
	@Transactional
	public User retieveByUserId(String userId) {
		// TODO Auto-generated method stub
		try {

			Session session =  sessionFactory.getCurrentSession();
			System.out.println("friendList retrieving....."+userId);
			
			//String query = session.createQuery("From User u where u.userId like ?");
			//query.setParameter(0,userId);
			
			String hql = "FROM User u where u.userId=?";
			Query query = session.createQuery(hql);
			User result = (User) session.createQuery(hql)
					.setParameter(0,userId)
					.setMaxResults(1)
					.uniqueResult();
			System.out.println(result);
			return result;

		}catch(Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	/*public List<User> retrieveAll() {
		// TODO Auto-generated method stub
		return null;
	}*/
}
