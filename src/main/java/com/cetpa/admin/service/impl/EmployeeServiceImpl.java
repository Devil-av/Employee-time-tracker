package com.cetpa.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.admin.model.Employee;
import com.cetpa.admin.repository.EmployeeRepository;
import com.cetpa.admin.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getList() 
	{
		return employeeRepository.getEmployeeList();
	}
	public void saveEmployee(Employee employee) 
	{
		employeeRepository.saveRecord(employee);
	}
	public List<Employee> getList(String status) 
	{
		return employeeRepository.getEmployeeList(status);
	}
}
