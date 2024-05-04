package com.cetpa.admin.service;

import java.util.List;

import com.cetpa.admin.model.User;

public interface UserService 
{
	List<User> getList();
	void saveUser(User user);
	User getUser(String userid);
}
