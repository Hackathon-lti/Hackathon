package com.lti.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.lti.model.Question;
@Service
public interface IQuestionService {
	//public void addQuestion(Question question, Answer answer);//insert
	public List<Question> listQuestions();//retrieve/listAll
	public void deleteQuestion(int question_id);//delete/remove
	public void updateQuestion(Question question);
	public Question getQuestionByQuestion_id(int question_id);
	public void addQuestion(Question question);
}
