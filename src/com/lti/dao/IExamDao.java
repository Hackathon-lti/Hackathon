package com.lti.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.model.Question;
@Repository
public interface IExamDao {
	public List<Question> fetchAlljavaQuestion(int l);
	public List<Question> fetchAllhtmlQuestion(int l);
	public List<Question> fetchAllsqlQuestion(int l);
	
}
