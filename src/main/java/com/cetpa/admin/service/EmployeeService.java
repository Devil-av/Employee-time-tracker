package com.cetpa.admin.service;

import java.util.List;

import com.cetpa.admin.model.Employee;

public interface EmployeeService 
{
	List<Employee> getList();
	void saveEmployee(Employee employee);
	List<Employee> getList(String status);
}
