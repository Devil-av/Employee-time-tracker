package com.cetpa.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.admin.model.User;
import com.cetpa.admin.service.UserService;

@Controller
@RequestMapping("admin/user")
public class UserController 
{
	private UserService userService;
	@Autowired
	public void setUserService(UserService userService) 
	{
		this.userService = userService;
	}
	@RequestMapping("dashboard")
	public String getDashboard(Model model)
	{
		List<User> userList=userService.getList();
		model.addAttribute("ulist",userList);
		return "admin/user/user-dashboard";
	}
	@RequestMapping("add")
	public String getAddView()
	{
		return "admin/user/add-user";
	}
	@RequestMapping("save-record")
	public String saveRecord(User user)
	{
		userService.saveUser(user);
		return "redirect:dashboard";
	}
}
