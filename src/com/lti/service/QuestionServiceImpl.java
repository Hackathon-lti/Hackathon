package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.IQuestionDao;


import com.lti.model.Question;
@Service

public class QuestionServiceImpl implements IQuestionService{
private IQuestionDao questionDao;
@Autowired
public void setQuestionDao(IQuestionDao questionDao) {
	this.questionDao = questionDao;
}
	@Override
	@Transactional
	public void addQuestion(Question question) {
	
		this.questionDao.addQuestion(question);
		
	}

	@Override
	@Transactional
	public List<Question> listQuestions() {
		return this.questionDao.listQuestions();
	}

	@Override
	@Transactional
	public void deleteQuestion(int question_id) {
		this.questionDao.deleteQuestion(question_id);
		
	}

	@Override
	@Transactional
	public void updateQuestion(Question question) {
		this.questionDao.updateQuestion(question);
		
	}
	@Override
	public Question getQuestionByQuestion_id(int question_id) {
		return this.questionDao.getQuestionByQuestion_id(question_id);
	}

}
