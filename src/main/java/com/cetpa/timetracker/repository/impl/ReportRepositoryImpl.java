package com.cetpa.timetracker.repository.impl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cetpa.admin.model.TimeInfo;
import com.cetpa.timetracker.repository.ReportRepository;

@Repository
public class ReportRepositoryImpl implements ReportRepository 
{
	private Session session;
	
	@Autowired
	public ReportRepositoryImpl(SessionFactory factory)
	{
		session=factory.openSession();
	}
	public List<TimeInfo> getCurrentDateReport(LocalDate date) 
	{
		Query<TimeInfo> query=session.createQuery("from TimeInfo where date=:arg",TimeInfo.class);
		query.setParameter("arg",date);
		return query.list();
	}
	public List<TimeInfo> getDateBetweenReport(LocalDate date1, LocalDate date2) 
	{
		Query<TimeInfo> query=session.createQuery("from TimeInfo where date between :arg1 and :arg2",TimeInfo.class);
		query.setParameter("arg1",date1);
		query.setParameter("arg2",date2);
		return query.list();
	}
	public List<TimeInfo> getCurrentDateReport(LocalDate date, int eid) 
	{
		Query<TimeInfo> query=session.createQuery("from TimeInfo where date=:arg1 and eid=:arg2",TimeInfo.class);
		query.setParameter("arg1",date);
		query.setParameter("arg2",eid);
		return query.list();
	}
}
