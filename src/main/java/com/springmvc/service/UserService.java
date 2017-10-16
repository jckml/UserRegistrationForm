package com.springmvc.service;

import java.util.List;

import com.springmvc.entity.User;



public interface UserService {
	
	User findById(long id);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(long id);

	List<User> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(User user);
	
}
