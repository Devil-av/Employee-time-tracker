package com.cetpa.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.admin.model.Employee;
import com.cetpa.admin.service.EditTimeEntryService;
import com.cetpa.admin.service.EmployeeService;

@Controller
@RequestMapping("admin/edit")
public class EditTimeEntryController 
{
	@Autowired private EmployeeService employeeService;
	@Autowired private EditTimeEntryService timeEntryService;
	
	
	@RequestMapping("outtime")
	public String getEmployeeList1(Model model)
	{
		List<Employee> empList=employeeService.getList();
		model.addAttribute("elist",empList);
		return "admin/edit/outentry/employee-list";
	}
	@RequestMapping("updateoutentry")
	public String updateOutEntry(int eid1,int eid2,Model model)
	{
		timeEntryService.updateOutEntry(eid1,eid2);
		model.addAttribute("eid1",eid1);
		return "admin/edit/outentry/outentry-update-success";
	}
	@RequestMapping("intime")
	public String getEmployeeList2(Model model)
	{
		List<Employee> empList=employeeService.getList();
		model.addAttribute("elist",empList);
		return "admin/edit/inentry/employee-list";
	}
	@RequestMapping("updateinentry")
	public String updateInEntry(int eid1,int eid2,Model model)
	{
		timeEntryService.updateInEntry(eid1,eid2);
		model.addAttribute("eid1",eid1);
		return "admin/edit/inentry/inentry-update-success";
	}
}
