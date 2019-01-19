package com.lti.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.lti.model.Question;
@Repository
public interface IQuestionDao {
	//public void addQuestion(Question question,Answer answer);//insert
	public List<Question> listQuestions();//retrieve/listAll
	public void deleteQuestion(int question_id);//delete/remove
	public void updateQuestion(Question question);
	public Question getQuestionByQuestion_id(int question_id);
	public void addQuestion(Question question);
}
