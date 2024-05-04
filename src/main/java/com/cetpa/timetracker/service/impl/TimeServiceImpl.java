package com.cetpa.timetracker.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.admin.model.TimeInfo;
import com.cetpa.admin.repository.EmployeeRepository;
import com.cetpa.timetracker.repository.TimeRepository;
import com.cetpa.timetracker.service.TimeService;
import com.cetpa.utility.TimeManager;

@Service
public class TimeServiceImpl implements TimeService 
{
	@Autowired
	private TimeRepository timeRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	public void saveOuttime(TimeInfo timeInfo) 
	{
		timeInfo.setOuttime(TimeManager.getCurrentTime());
		LocalDate date=LocalDate.now();
		timeInfo.setDate(date);
		timeRepository.persistOuttime(timeInfo);
		employeeRepository.updateEmployeeStatus(timeInfo.getEid(),"out");
	}
	public void updateIntime(int eid) 
	{
		TimeInfo timeInfo=timeRepository.getTimeInfo(eid);
		String outtime=timeInfo.getOuttime();
		String intime=TimeManager.getCurrentTime();
		String totaltime=TimeManager.getTotalTime(intime,outtime);
		timeRepository.updateIntime(timeInfo,intime,totaltime);
		employeeRepository.updateEmployeeStatus(timeInfo.getEid(),"in");
	}
}
