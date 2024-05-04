package com.cetpa.timetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.admin.model.Employee;
import com.cetpa.admin.model.TimeInfo;
import com.cetpa.admin.repository.EmployeeRepository;
import com.cetpa.timetracker.service.ReportService;

@Controller
@RequestMapping("timetracker/report/empwise")
public class EmployeeWiseReportController 
{
	@Autowired private EmployeeRepository employeeRepository;
	@Autowired private ReportService reportService;
	
	@RequestMapping("")
	public String getEmployeeList(Model model)
	{
		List<Employee> empList=employeeRepository.getList();
		model.addAttribute("elist",empList);
		return "timetracker/reports/employee/employee-list";
	}
	@RequestMapping("choosedate")
	public String getDatecChoiceView(Model model,int eid)
	{
		model.addAttribute("eid",eid);
		return "timetracker/reports/employee/choose-date";
	}
	@RequestMapping("current")
	public String getCurrentDateReportOfEmployee(Model model,int eid)
	{
		List<TimeInfo> list=reportService.getCurrentDateList(eid);
		model.addAttribute("clist",list);
		model.addAttribute("eid",eid);
		return "timetracker/reports/employee/current-date";
	}
}
