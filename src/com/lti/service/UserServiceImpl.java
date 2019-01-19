package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lti.dao.IUserDao;
import com.lti.model.User;
@Service
public class UserServiceImpl implements IUserService{
	private IUserDao iUserDao;
	@Autowired
	public void setUserDao(IUserDao userDao) {
		this.iUserDao = userDao;
	}
	
	@Override
	@Transactional
	public void addUser(User u) {
		// TODO Auto-generated method stub
		
		this.iUserDao.addUser(u);
	}

	@Override
	@Transactional
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		this.iUserDao.updateUser(u);
	}

	@Override
	@Transactional
	public boolean verifyUser(String username, String passwrod) {
		// TODO Auto-generated method stub
	
		return this.iUserDao.verifyUser(username, passwrod);
	}

	@Override
	public void displaypaper() {
		
		
	}

	

	
}
