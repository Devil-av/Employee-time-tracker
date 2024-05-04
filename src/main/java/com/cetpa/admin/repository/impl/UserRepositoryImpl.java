package com.cetpa.admin.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cetpa.admin.model.User;
import com.cetpa.admin.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository 
{
	private Session session;
	private Transaction transaction;
	
	@Autowired
	public UserRepositoryImpl(SessionFactory factory)
	{
		session=factory.openSession();
		transaction=session.getTransaction();
	}
	public List<User> getUserList() 
	{
		Query<User> query=session.createQuery("from User",User.class);
		return query.list();
	}
	public void saveRecord(User user) 
	{
		transaction.begin();
		session.persist(user);
		transaction.commit();
	}
	public User getUser(String userid) 
	{
		User user=session.get(User.class,userid);
		return user;
	}
}
