package com.cetpa.timetracker.repository.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.cetpa.admin.model.TimeInfo;
import com.cetpa.timetracker.repository.TimeRepository;

@Repository
public class TimeRepositoryImpl implements TimeRepository 
{
	private Session session;
	private Transaction transaction;
	
	public TimeRepositoryImpl(SessionFactory factory)
	{
		session=factory.openSession();
		transaction=session.getTransaction();
	}
	public void persistOuttime(TimeInfo timeInfo) 
	{
		transaction.begin();
		session.save(timeInfo);
		transaction.commit();
	}
	public TimeInfo getTimeInfo(int eid) 
	{
		Query<TimeInfo> query=session.createQuery("from TimeInfo where eid=:arg1 and intime=:arg2",TimeInfo.class);
		query.setParameter("arg1",eid);
		query.setParameter("arg2","Not in yet");
		TimeInfo timeInfo=query.uniqueResult();
		return timeInfo;
	}
	public void updateIntime(TimeInfo timeInfo, String intime, String totaltime) 
	{
		transaction.begin();
		timeInfo.setIntime(intime);
		timeInfo.setTotaltime(totaltime);
		transaction.commit();
	}
	public void updateEmployeeId(int eid1, int eid2) 
	{
		Query query=session.createQuery("update TimeInfo set eid=:arg1 where eid=:arg2 and intime=:arg3");
		query.setParameter("arg1",eid2);
		query.setParameter("arg2",eid1);
		query.setParameter("arg3","Not in yet");
		transaction.begin();
		query.executeUpdate();
		transaction.commit();
	}
	public void updateEmployeeInEntry(int eid1, int eid2) 
	{
		TimeInfo timeInfo1=getTimeinfoById(eid1);
		TimeInfo timeInfo2=getTimeInfo(eid2);
		transaction.begin();
		timeInfo2.setIntime(timeInfo1.getIntime());
		timeInfo2.setTotaltime(timeInfo1.getTotaltime());
		timeInfo1.setIntime("Not in yet");
		timeInfo1.setTotaltime("Not applicable");
		transaction.commit();
		
	}
	private TimeInfo getTimeinfoById(int eid)
	{
		Query<TimeInfo> query=session.createQuery("from TimeInfo where eid=:arg1 and date=:arg2 order by timeid desc",TimeInfo.class);
		query.setParameter("arg1",eid);
		query.setParameter("arg2",LocalDate.now());
		List<TimeInfo> timeInfoList=query.list();
		return timeInfoList.get(0);
	}
}
