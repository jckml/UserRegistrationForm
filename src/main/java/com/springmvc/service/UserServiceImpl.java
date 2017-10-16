package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.UserDAOImpl;
import com.springmvc.entity.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAOImpl userDAOImpl;
	
	public List<User> findAllUsers() {
		return userDAOImpl.findAllUsers();
	}
	
	public User findById(long id) {
		return userDAOImpl.findById(id);
	}
	
	public void saveUser(User user) {
		userDAOImpl.saveUser(user);
	}

	public void updateUser(User user) {
		userDAOImpl.updateUser(user);
	}

	public void deleteUserById(long id) {
		userDAOImpl.deleteUserById(id);
	}

	public boolean isUserExist(User user) {
		return userDAOImpl.isUserExist(user);
	}
	
	public void deleteAllUsers(){
		userDAOImpl.deleteAllUsers();
	}


}
