package com.cetpa.timetracker.repository;

import com.cetpa.admin.model.TimeInfo;

public interface TimeRepository 
{
	void persistOuttime(TimeInfo timeInfo);
	TimeInfo getTimeInfo(int eid);
	void updateIntime(TimeInfo timeInfo, String intime, String totaltime);
	void updateEmployeeId(int eid1, int eid2);
	void updateEmployeeInEntry(int eid1, int eid2);
}
