package com.cetpa.timetracker.service;

import java.util.List;

import com.cetpa.admin.model.TimeInfo;

public interface ReportService 
{
	List<TimeInfo> getCurrentDateList();
	List<TimeInfo> getAnyDateList(String date);
	List<TimeInfo> getDateBetweenList(String date1, String date2);
	List<TimeInfo> getCurrentDateList(int eid);
}
