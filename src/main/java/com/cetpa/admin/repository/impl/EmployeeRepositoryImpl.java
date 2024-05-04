package com.cetpa.admin.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cetpa.admin.model.Employee;
import com.cetpa.admin.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository 
{
	private Session session;
	private Transaction transaction;
	
	@Autowired
	public EmployeeRepositoryImpl(SessionFactory factory)
	{
		session=factory.openSession();
		transaction=session.getTransaction();
	}

	public List<Employee> getEmployeeList() 
	{
		Query<Employee> query=session.createQuery("from Employee",Employee.class);
		return query.list();
	}
	public void saveRecord(Employee employee) 
	{
		transaction.begin();
		session.save(employee);
		transaction.commit();
	}
	public List<Employee> getEmployeeList(String status) 
	{
		Query<Employee> query=session.createQuery("from Employee where status=:arg",Employee.class);
		query.setParameter("arg",status);
		return query.list();
	}
	public void updateEmployeeStatus(int eid, String status) 
	{
		Query query=session.createQuery("update Employee set status=:arg1 where eid=:arg2");
		query.setParameter("arg1",status);
		query.setParameter("arg2",eid);
		transaction.begin();
		query.executeUpdate();
		transaction.commit();
	}
	public void updateEmployeeStatus(int eid1, int eid2, String status1, String status2) 
	{
		updateEmployeeStatus(eid1,status1);
		updateEmployeeStatus(eid2,status2);
	}

	public List<Employee> getList() 
	{
		Query<Employee> query=session.createQuery("from Employee",Employee.class);
		return query.list();
	}
}
