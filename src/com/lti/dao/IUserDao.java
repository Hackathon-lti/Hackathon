package com.lti.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.model.User;
@Repository
public interface IUserDao {
	public void addUser(User u);//insert
	public void updateUser(User u);//update/modify
	boolean verifyUser(String username,String passwrod);
	void displaypaper();

}
