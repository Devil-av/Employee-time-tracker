package com.cetpa.admin.repository;

import java.util.List;

import com.cetpa.admin.model.Employee;

public interface EmployeeRepository 
{
	List<Employee> getEmployeeList();
	void saveRecord(Employee employee);
	List<Employee> getEmployeeList(String status);
	void updateEmployeeStatus(int eid, String status);
	void updateEmployeeStatus(int eid1, int eid2, String status1, String status2);
	List<Employee> getList();
}
