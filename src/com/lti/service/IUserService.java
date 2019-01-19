package com.lti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.model.User;
@Service
public interface IUserService {
	public void addUser(User u);//insert
	public void updateUser(User u);//update/modify
	boolean verifyUser(String username,String passwrod);
	  public void displaypaper();
}
