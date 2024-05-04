package com.cetpa.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminHomeController 
{
	@RequestMapping("login")
	public String getLoginView()
	{
		return "admin/login";
	}
	@RequestMapping("authenticate")
	public String authenticateAdmin(String adminid,String pass,HttpSession ses,Model model)
	{
		if(adminid.equals("admin") && pass.equals("cetpa")) 
		{
			ses.setAttribute("adminid",adminid);
			return "redirect:/admin";
		}
		model.addAttribute("msg","Authentication failed...");
		model.addAttribute("aid",adminid);
		return "admin/login";
	}
	@RequestMapping("")
	public String getHomeView(HttpSession ses)
	{
		if(ses.getAttribute("adminid")==null)
			return "admin/login";
		return "admin/home";
	}
	@RequestMapping("logout")
	public String adminLogout(HttpSession ses)
	{
		if(ses.getAttribute("adminid")==null)
			return "admin/login";
		ses.invalidate();
		return "admin/logout";
	}
}
