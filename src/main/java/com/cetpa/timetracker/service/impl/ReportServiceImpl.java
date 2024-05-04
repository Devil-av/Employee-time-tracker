package com.cetpa.timetracker.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.admin.model.TimeInfo;
import com.cetpa.timetracker.repository.ReportRepository;
import com.cetpa.timetracker.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService 
{
	@Autowired private ReportRepository reportRepository;

	public List<TimeInfo> getCurrentDateList() 
	{
		LocalDate date=LocalDate.now();
		return reportRepository.getCurrentDateReport(date);
	}
	public List<TimeInfo> getAnyDateList(String date) 
	{
		LocalDate ldate=LocalDate.parse(date);
		return reportRepository.getCurrentDateReport(ldate);
	}
	public List<TimeInfo> getDateBetweenList(String date1, String date2) 
	{
		LocalDate ldate1=LocalDate.parse(date1);
		LocalDate ldate2=LocalDate.parse(date2);
		return reportRepository.getDateBetweenReport(ldate1,ldate2);
	}
	public List<TimeInfo> getCurrentDateList(int eid) 
	{
		LocalDate date=LocalDate.now();
		return reportRepository.getCurrentDateReport(date,eid);
	}
}
