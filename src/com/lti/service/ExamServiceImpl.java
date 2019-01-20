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
public List<Question> fetchAlljavaQuestion(int i) {
	// TODO Auto-generated method stub
	
	return this.examdao.fetchAlljavaQuestion( i);
}

@Override
public List<Question> fetchAllhtmlQuestion(int l) {
	// TODO Auto-generated method stub
	return this.examdao.fetchAllhtmlQuestion( l);
}

@Override
public List<Question> fetchAllsqlQuestion(int l) {
	// TODO Auto-generated method stub
	return this.examdao.fetchAllsqlQuestion( l);
}

}
