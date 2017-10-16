package com.springmvc.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.entity.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {


	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User findById(long id) {
		User user = (User) getSession().get(User.class, id);
		return user;
	}

	@Override
	public void saveUser(User user) {
		getSession().save(user);
	}

	@Override
	public void updateUser(User user) {
		User userToUpdate = findById(user.getId());
		userToUpdate.setUsername(user.getUsername());
		userToUpdate.setAddress(user.getAddress());
		userToUpdate.setEmail(user.getEmail());
		getSession().update(userToUpdate);
	}

	@Override
	public void deleteUserById(long id) {
		User user = findById(id);
		if(user != null)
			getSession().delete(user);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<User> findAllUsers() {
		return getSession().createCriteria(User.class).list();
	}

	@Override
	public void deleteAllUsers() {
		getSession().createQuery("DELETE FROM user").executeUpdate();
	}

	@Override
	public boolean isUserExist(User user) {
		
		return findById(user.getId()) != null;
	}

	private Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
