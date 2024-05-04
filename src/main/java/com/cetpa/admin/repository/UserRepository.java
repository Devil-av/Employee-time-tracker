package com.cetpa.admin.repository;

import java.util.List;

import com.cetpa.admin.model.User;

public interface UserRepository 
{
	List<User> getUserList();
	void saveRecord(User user);
	User getUser(String userid);
}
