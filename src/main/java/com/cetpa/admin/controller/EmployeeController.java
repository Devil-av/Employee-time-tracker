package com.cetpa.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.admin.model.Employee;
import com.cetpa.admin.service.EmployeeService;

@Controller
@RequestMapping("admin/employee")
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("dashboard")
	public String getDashboard(Model model)
	{
		List<Employee> employeeList=employeeService.getList();
		model.addAttribute("elist",employeeList);
		return "admin/employee/employee-dashboard";
	}
	@RequestMapping("add")
	public String getAddview()
	{
		return "admin/employee/add-employee";
	}
	@RequestMapping("save-record")
	public String saveRecord(Employee employee)
	{
		employeeService.saveEmployee(employee);
		return "redirect:dashboard";
	}
}
