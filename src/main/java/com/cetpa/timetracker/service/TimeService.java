package com.cetpa.timetracker.service;

import com.cetpa.admin.model.TimeInfo;

public interface TimeService 
{
	void saveOuttime(TimeInfo timeInfo);
	void updateIntime(int eid);
}
