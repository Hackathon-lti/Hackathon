package com.lti.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.model.Question;
@Repository
public interface IExamDao {
	public List<Question> fetchAlljavaQuestion();
	public List<Question> fetchAllhtmlQuestion();
	public List<Question> fetchAllsqlQuestion();
	
}
