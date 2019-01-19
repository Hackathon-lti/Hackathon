package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.IExamDao;
import com.lti.model.Question;
@Service
public class ExamServiceImpl implements IExamService {
	
private IExamDao examdao;

@Autowired
public void setExamdao(IExamDao examdao) {
	this.examdao = examdao;
}

@Override
public List<Question> fetchAlljavaQuestion() {
	// TODO Auto-generated method stub
	
	return this.examdao.fetchAlljavaQuestion();
}

@Override
public List<Question> fetchAllhtmlQuestion() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Question> fetchAllsqlQuestion() {
	// TODO Auto-generated method stub
	return null;
}

}
