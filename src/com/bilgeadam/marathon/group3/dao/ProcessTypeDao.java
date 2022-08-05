package com.bilgeadam.marathon.group3.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.marathon.group3.entity.ProcessType;

import jakarta.persistence.TypedQuery;

public class ProcessTypeDao implements IRepository<ProcessType>
{

	@Override
	public void create(ProcessType entity) 
	{
		try (Session session = databaseConnectionHibernate())
		{
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("ProcessType data is added to DB");
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding ProcessType data");
		}
	}

	@Override
	public void delete(long id) 
	{
		try(Session session = databaseConnectionHibernate())
		{
			ProcessType deleteProcessType = find(id);
			if (deleteProcessType != null)
			{
				session.getTransaction().begin();
				session.remove(deleteProcessType);
				session.getTransaction().commit();
				System.out.println("ProcessType data is delete to DB");
			}	
		}	
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while delete ProcessType data");
		}
			
		
	}

	@Override
	public void update(long id, ProcessType entity) 
	{
		try(Session session = databaseConnectionHibernate())
		{
			ProcessType updateProcessType = find(id);
			if (updateProcessType != null)
			{
				
				
				session.getTransaction().begin();
				session.merge(updateProcessType);
				session.getTransaction().commit();
				System.out.println("ProcessType data is update to DB");
			}	
		}	
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while update ProcessType data");
		}
	}

	@Override
	public List<ProcessType> listAll() 
	{
		Session session = databaseConnectionHibernate();
		String hql = "SELECT processType FROM ProcessType as processType";
		TypedQuery<ProcessType> typedQuery = session.createQuery(hql, ProcessType.class);
		List<ProcessType> processTypes = typedQuery.getResultList();
		for (ProcessType ProcessType : processTypes) 
		{
			System.out.println(ProcessType);
		}
		return processTypes;
	}

	@Override
	public ProcessType find(long id) 
	{
		try (Session session = databaseConnectionHibernate())
		{
			ProcessType processType = session.find(ProcessType.class, id);
			if(processType != null)
			{
				System.out.println("ProcessType found: " + processType);
				return processType;
			}
			else
			{
				System.out.println("ProcessType not found");
				return processType;
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
