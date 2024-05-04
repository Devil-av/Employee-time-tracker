package com.cetpa.timetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.admin.model.Employee;
import com.cetpa.admin.model.TimeInfo;
import com.cetpa.admin.service.EmployeeService;
import com.cetpa.timetracker.service.TimeService;

@Controller
@RequestMapping("timetracker/timeout")
public class TimeoutController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired 
	private TimeService timeService;
	
	@RequestMapping("")
	public String getEmployeeList(Model model)
	{
		List<Employee> empList=employeeService.getList("in");
		model.addAttribute("elist",empList);
		return "timetracker/time/out/employee-list";
	}
	@RequestMapping("record-outtime")
	public String recordOuttime(TimeInfo timeInfo,Model model)
	{
		timeService.saveOuttime(timeInfo);
		model.addAttribute("eid",timeInfo.getEid());
		return "timetracker/time/out/record-outtime";
	}
}
