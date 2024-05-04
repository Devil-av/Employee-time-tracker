package com.cetpa.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.admin.model.User;
import com.cetpa.admin.repository.UserRepository;
import com.cetpa.admin.service.UserService;

@Service
public class UserServiceImpl implements UserService 
{
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getList() 
	{
		return userRepository.getUserList();
	}
	public void saveUser(User user) 
	{
		userRepository.saveRecord(user);
	}
	public User getUser(String userid) 
	{
		return userRepository.getUser(userid);
	}
}
