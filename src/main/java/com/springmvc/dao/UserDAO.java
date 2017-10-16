package com.springmvc.dao;

import java.util.List;

import com.springmvc.entity.User;

public interface UserDAO {

	User findById(long id);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserById(long id);

	List<User> findAllUsers();

	void deleteAllUsers();

	public boolean isUserExist(User user);
}
