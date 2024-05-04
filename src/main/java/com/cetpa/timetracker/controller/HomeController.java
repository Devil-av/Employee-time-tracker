package com.cetpa.timetracker.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.admin.model.User;
import com.cetpa.admin.service.UserService;

@Controller
@RequestMapping("timetracker")
public class HomeController 
{
	@Autowired
	private UserService userService;
	
	@RequestMapping("")
	public String getHomeView(HttpSession ses)
	{
		if(ses.getAttribute("name")==null)
			return "timetracker/login";
		return "timetracker/home";
	}
	@RequestMapping("authenticate")
	public String authenticateUser(String userid,String pass,HttpSession ses,Model model)
	{
		User user=userService.getUser(userid);
		if(user==null)
		{
			model.addAttribute("msg","Given userid does not exist");
			model.addAttribute("uid",userid);
			return "timetracker/login";
		}
		String dpass=user.getPassword();
		if(!pass.equals(dpass))
		{
			model.addAttribute("msg","Given password is wrong");
			model.addAttribute("uid",userid);
			return "timetracker/login";
		}
		ses.setAttribute("name",user.getName());
		return "redirect:/timetracker";
	}
	@RequestMapping("logout")
	public String loggedUserOut(HttpSession ses,Model model)
	{
		if(ses.getAttribute("name")==null)
			return "timetracker/login";
		model.addAttribute("name",ses.getAttribute("name"));
		ses.invalidate();
		return "timetracker/logout";
	}
}
