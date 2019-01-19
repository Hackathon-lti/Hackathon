package com.lti.dao;



import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*import org.springframework.stereotype.Service;*/

import com.lti.model.User;
@Repository

public class UserDaoImpl implements IUserDao{
	private static final Logger logger = 			
			LoggerFactory.getLogger(UserDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
		
	}

	@Override
	public void addUser(User u) {
		try {
			// TODO Auto-generated method stub
			
			Session session = sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(u);
			logger.info("User saved successfully, User Details="
			+ u);
			tx.commit();
			session.close();
		
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
	
		}
	
		
	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		Session session = 
				this.sessionFactory
				.openSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(u);

		logger.info("User updated successfully, "
				+ "User Details=" + u);
		tx.commit();
		session.close();
	}

	@Override
	public boolean verifyUser(String username, String password) {
		Session session = this.sessionFactory.openSession();
		 
		
		  String query="From User a where a.userEmail=:username and a.password=:password";
		  Query q=session.createQuery(query);
		  q.setString("username", username);
		  q.setString("password", password);
		  List<User> l=q.list();
		 
if(l.size()==0)
{
	  return false;
}

session.close();
	  return true;

	}

	@Override
	public void displaypaper() {
		
	}


	

}
