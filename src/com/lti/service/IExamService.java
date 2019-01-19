package com.lti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.model.Question;
@Service
public interface IExamService {
	public List<Question> fetchAlljavaQuestion(int l);
	public List<Question> fetchAllhtmlQuestion(int l);
	public List<Question> fetchAllsqlQuestion(int l);

}
