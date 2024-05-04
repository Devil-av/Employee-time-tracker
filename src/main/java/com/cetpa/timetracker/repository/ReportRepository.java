package com.cetpa.timetracker.repository;

import java.time.LocalDate;
import java.util.List;

import com.cetpa.admin.model.TimeInfo;

public interface ReportRepository 
{
	List<TimeInfo> getCurrentDateReport(LocalDate date);
	List<TimeInfo> getDateBetweenReport(LocalDate ldate1, LocalDate ldate2);
	List<TimeInfo> getCurrentDateReport(LocalDate date, int eid);
}
