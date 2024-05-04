package com.cetpa.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.admin.repository.EmployeeRepository;
import com.cetpa.admin.service.EditTimeEntryService;
import com.cetpa.timetracker.repository.TimeRepository;

@Service
public class EditTimeEntryServiceImpl implements EditTimeEntryService 
{
	@Autowired private TimeRepository timeRepository;
	@Autowired private EmployeeRepository employeeRepository;
	
	public void updateOutEntry(int eid1, int eid2) 
	{
		timeRepository.updateEmployeeId(eid1,eid2);
		employeeRepository.updateEmployeeStatus(eid1,eid2,"in","out");
	}
	public void updateInEntry(int eid1, int eid2) 
	{
		timeRepository.updateEmployeeInEntry(eid1,eid2);
		employeeRepository.updateEmployeeStatus(eid1,eid2,"out","in");
	}
}
