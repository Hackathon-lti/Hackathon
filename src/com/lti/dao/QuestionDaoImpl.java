package com.lti.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import com.lti.model.Question;
@Repository
public class QuestionDaoImpl implements IQuestionDao{
	private static final Logger logger = 			
			LoggerFactory.getLogger(QuestionDaoImpl.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void addQuestion(Question question) {
		
		Session session = sessionFactory.openSession();
		Transaction tcx=session.beginTransaction();
		
		session.save(question);
		System.out.println(question);
		logger.info("Question saved successfully, Question Details="
		+ question);
		tcx.commit();
		session.close();
	
		
	}

	@Override
	public List<Question> listQuestions() {
		Session session = sessionFactory.openSession();
		Transaction tcx=session.beginTransaction();
		List<Question> questionsList = session.createQuery("from Question").list();
		for (Question question : questionsList) {
			logger.info("Question List::" + question);
			
		}
		tcx.commit();
		session.close();
		return questionsList;
	
	}

	@Override
	public void deleteQuestion(int question_id) {
		Session session = sessionFactory.openSession();
		Transaction tcx=session.beginTransaction();
		Question question = 
		(Question) session.load(Question.class, new Integer(question_id));
		
		if (null!= question) {
			session.delete(question);
		}
		else {
			logger.error
			("Question NOT deleted, with Question Id=" +question_id);
		}
		tcx.commit();
		session.close();
		logger.info("Question deleted successfully, question details=" + question);
		
	}
	@Override
	public void updateQuestion(Question question) {
		Session session = sessionFactory.openSession();
		Transaction tcx=session.beginTransaction();
		session.update(question);
		logger.info("Question updated successfully, "
				+ "Question Details=" + question);
		tcx.commit();
		session.close();
	}
	@Override
	public Question getQuestionByQuestion_id(int question_id) {
		Session session = sessionFactory.openSession();
		Transaction tcx=session.beginTransaction();
		Question question = (Question) session.load(Question.class, new Integer(question_id));
		logger.info("Question loaded successfully, Question details=" + question);
		tcx.commit();
		session.close();
		return question;
	}
		
	}


