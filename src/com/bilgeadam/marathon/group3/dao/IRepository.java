package com.bilgeadam.marathon.group3.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.marathon.group3.util.HibernateSession;


public interface IRepository<T> 
{
public void create(T entity);
	
	public void delete(long id);
	
	public void update(long id, T entity);
	
	public List<T> listAll();
	
	public T find(long id);
	
	
	default Session databaseConnectionHibernate() {
		
		return HibernateSession.getSessionFactory().openSession();
	}
}
