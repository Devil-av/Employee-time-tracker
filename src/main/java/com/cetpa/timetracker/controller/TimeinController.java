package com.cetpa.timetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.admin.model.Employee;
import com.cetpa.admin.service.EmployeeService;
import com.cetpa.timetracker.service.TimeService;

@Controller
@RequestMapping("timetracker/timein")
public class TimeinController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired 
	private TimeService timeService;
	
	@RequestMapping("")
	public String getEmployeeList(Model model)
	{
		List<Employee> empList=employeeService.getList("out");
		model.addAttribute("elist",empList);
		return "timetracker/time/in/employee-list";
	}
	@RequestMapping("update-intime")
	public String updateEmployeeIntime(int eid,Model model)
	{
		timeService.updateIntime(eid);
		model.addAttribute("eid",eid);
		return "timetracker/time/in/update-intime";
	}
}
