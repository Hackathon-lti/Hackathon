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
	   public List<Question> fetchAlljavaQuestion() {
		
		Question q=new Question();
		if(i == 0) {
			System.out.println("1");
			Session session= sessionFactory.openSession(); // creating session
			Transaction tcx=session.beginTransaction();
			String query="From Question where topic='jav1' and lev =1 ";
			
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
			List<Question> l = session.createSQLQuery("Select question,option1,option2,option3,option4 from Qusetionwhere  topic =: javas and lev =: 2  ").list();
			session.save(l);
			tcx.commit();
			return l;
		}
		else if(q.lev==3) {
			Session session= sessionFactory.openSession(); // creating session
			Transaction tcx=session.beginTransaction();
			List<Question> l = session.createSQLQuery("Select question,option1,option2,option3,option4 from Qusetion where  topic =: java and lev =: 3 ").list();
			session.save(l);
			tcx.commit();
			return l;
		}
             
		return null;
		}

	@Override
	public List<Question> fetchAllhtmlQuestion() {
		
		Question q=new Question();
		Exam e=new Exam();
		if(e.getExam_id() != 0) {
			Session session= sessionFactory.openSession();// creating session
			Transaction tcx=session.beginTransaction();
			String query="Select question,option1.option2,option3,option4 from Qusetion where  topic =: html and lev =: 1 ";
		List<Question> l = session.createSQLQuery(query).list();
		session.save(l);
		tcx.commit();
		return l;}
		else if(q.lev==2) { 
			Session session= sessionFactory.openSession(); // creating session
			Transaction tcx=session.beginTransaction();
			List<Question> l = session.createSQLQuery("Select question,option1,option2,option3,option4 from Qusetionwhere  topic =: html and lev =: 2  ").list();
			session.save(l);
			tcx.commit();
			return l;
		}
		else if(q.lev==3) {
			Session session= sessionFactory.openSession(); // creating session
			Transaction tcx=session.beginTransaction();
			List<Question> l = session.createSQLQuery("Select question,option1,option2,option3,option4 from Qusetion where  topic =: html and lev =: 3 ").list();
			session.save(l);
			tcx.commit();
			return l;
		}
		return null;
	}

	@Override
	public List<Question> fetchAllsqlQuestion() {
		
		Question q=new Question();
		Exam e=new Exam();
		if(e.getExam_id() != 0) {
			Session session= sessionFactory.openSession(); // creating session
			Transaction tcx=session.beginTransaction();
			
			
			String query="Select question,option1,option2,option3,option4 From Qusetion where  topic =: sql and lev=:1 ";

			List<Question> l = session.createSQLQuery(query).list();

		session.save(l);
		tcx.commit();
		
		return l;}
		else if(q.lev==2) { 
			Session session= sessionFactory.openSession(); // creating session
			Transaction tcx=session.beginTransaction();
			List<Question> l = session.createSQLQuery("Select question,option1,option2,option3,option4 from Qusetionwhere  topic =: sql and lev =: 2  ").list();
			session.save(l);
			tcx.commit();
			return l;
		}
		else if(q.lev==3) {
			Session session= sessionFactory.openSession(); // creating session
			Transaction tcx=session.beginTransaction();
			List<Question> l = session.createSQLQuery("Select question,option1,option2,option3,option4 from Qusetion where  topic =: sql and lev =: 3 ").list();
			session.save(l);
			tcx.commit();
			return l;
		}
		return null;
	}

}
