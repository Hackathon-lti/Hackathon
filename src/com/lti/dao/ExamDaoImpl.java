package com.lti.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.model.Exam;
import com.lti.model.Question;
@Repository
public class ExamDaoImpl implements IExamDao{
	private static final Logger logger = 			
			LoggerFactory.getLogger(QuestionDaoImpl.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	int i=0;
	@Override
	   public List<Question> fetchAlljavaQuestion(int i) {
		
		Question q=new Question();
		if(q.lev==3) {
			System.out.println("1");
			Session session= sessionFactory.openSession(); // creating session
			Transaction tcx=session.beginTransaction();
			String query="From Question where topic='jav1' and lev = 3 ";
		Query query1 = session.createQuery(query);
			List<Question> l = query1.list();
		tcx.commit();
		session.close();
		System.out.println("I am from fetchAll......"+l);
		return l;
		}
		else if(q.lev==2) {
			Session session= sessionFactory.openSession();// creating session
			Transaction tcx=session.beginTransaction();
			List<Question> l = session.createQuery("From Question where  topic='jav1' and lev = 2  ").list();
			tcx.commit();
			session.close();
			return l;
		}
		else  {
			Session session= sessionFactory.openSession(); // creating session
			Transaction tcx=session.beginTransaction();
			List<Question> l = session.createQuery(" From Question where  topic='jav1' and lev =1 ").list();
			tcx.commit();
			session.close();
			return l;
		}
             
		
		}

	@Override
	public List<Question> fetchAllhtmlQuestion(int i) {
		
		Question q=new Question();
		Exam e=new Exam();
		q.setLev(i);
		if(q.lev == 3) {
			Session session= sessionFactory.openSession();// creating session
			Transaction tcx=session.beginTransaction();
			String query="from Question where  topic ='html' and lev = 3";
		List<Question> l = session.createQuery(query).list();
		tcx.commit();
		session.close();
		return l;}
		else if(q.lev==2) { 
			Session session= sessionFactory.openSession(); // creating session
			Transaction tcx=session.beginTransaction();
			List<Question> l = session.createQuery("From Question where  topic ='html' and lev =2  ").list();
			session.save(l);
			tcx.commit();
			return l;
		}
		else  {
			Session session= sessionFactory.openSession(); // creating session
			Transaction tcx=session.beginTransaction();
			List<Question> l = session.createQuery("From Question where  topic ='html' and lev =1 ").list();
			tcx.commit();
			session.close();
			return l;
		}
	
	}

	@Override
	public List<Question> fetchAllsqlQuestion(int i) {
		
		Question q=new Question();
		Exam e=new Exam();
		if(q.lev==3) {
			Session session= sessionFactory.openSession(); // creating session
			Transaction tcx=session.beginTransaction();
			String query=" From Question where  topic ='sql'and lev=3 ";

			List<Question> l = session.createQuery(query).list();
		tcx.commit();
		session.close();
		return l;}
		else if(q.lev==2) { 
			Session session= sessionFactory.openSession(); // creating session
			Transaction tcx=session.beginTransaction();
			List<Question> l = session.createQuery(" from Question where  topic ='sql' and lev = 2  ").list();
			tcx.commit();
			session.close();
			return l;
		}
		else {
			Session session= sessionFactory.openSession(); // creating session
			Transaction tcx=session.beginTransaction();
			List<Question> l = session.createQuery(" from Question where  topic ='sql' and lev = 1 ").list();
			tcx.commit();
			session.close();
			return l;
		}
	
	}

}
