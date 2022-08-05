package com.bilgeadam.marathon.group3.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.marathon.group3.entity.ProcessPlace;

import jakarta.persistence.TypedQuery;

public class ProcessPlaceDao implements IRepository<ProcessPlace>
{

	@Override
	public void create(ProcessPlace entity) 
	{
		try (Session session = databaseConnectionHibernate())
		{
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("ProcessPlace data is added to DB");
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding ProcessPlace data");
		}
	}

	@Override
	public void delete(long id) 
	{
		try(Session session = databaseConnectionHibernate())
		{
			ProcessPlace deleteProcessPlace = find(id);
			if (deleteProcessPlace != null)
			{
				session.getTransaction().begin();
				session.remove(deleteProcessPlace);
				session.getTransaction().commit();
				System.out.println("ProcessPlace data is delete to DB");
			}	
		}	
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while delete ProcessPlace data");
		}
			
		
	}

	@Override
	public void update(long id, ProcessPlace entity) 
	{
		try(Session session = databaseConnectionHibernate())
		{
			ProcessPlace updateProcessPlace = find(id);
			if (updateProcessPlace != null)
			{
				
				session.getTransaction().begin();
				session.merge(updateProcessPlace);
				session.getTransaction().commit();
				System.out.println("ProcessPlace data is update to DB");
			}	
		}	
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while update ProcessPlace data");
		}
	}

	@Override
	public List<ProcessPlace> listAll() 
	{
		Session session = databaseConnectionHibernate();
		String hql = "SELECT processPlace FROM ProcessPlace as processPlace";
		TypedQuery<ProcessPlace> typedQuery = session.createQuery(hql, ProcessPlace.class);
		List<ProcessPlace> processPlaces = typedQuery.getResultList();
		for (ProcessPlace ProcessPlace : processPlaces) 
		{
			System.out.println(ProcessPlace);
		}
		return processPlaces;
	}

	@Override
	public ProcessPlace find(long id) 
	{
		try (Session session = databaseConnectionHibernate())
		{
			ProcessPlace processPlace = session.find(ProcessPlace.class, id);
			if(processPlace != null)
			{
				System.out.println("ProcessPlace found: " + processPlace);
				return processPlace;
			}
			else
			{
				System.out.println("ProcessPlace not found");
				return processPlace;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Some problem occured while FIND operation");
		}
		return null;
	}

}
