package com.bilgeadam.marathon.group3.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.marathon.group3.entity.Processs;

import jakarta.persistence.TypedQuery;

public class ProcessDao implements IRepository<Processs>
{

	@Override
	public void create(Processs entity) 
	{
		try (Session session = databaseConnectionHibernate())
		{
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Process data is added to DB");
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Process data");
		}
	}

	@Override
	public void delete(long id) 
	{
		try(Session session = databaseConnectionHibernate())
		{
			Processs deleteProcess = find(id);
			if (deleteProcess != null)
			{
				session.getTransaction().begin();
				session.remove(deleteProcess);
				session.getTransaction().commit();
				System.out.println("Process data is delete to DB");
			}	
		}	
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while delete Process data");
		}
			
		
	}

	@Override
	public void update(long id, Processs entity) 
	{
		try(Session session = databaseConnectionHibernate())
		{
			Processs updateProcess = find(id);
			if (updateProcess != null)
			{
				
				session.getTransaction().begin();
				session.merge(updateProcess);
				session.getTransaction().commit();
				System.out.println("Process data is update to DB");
			}	
		}	
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while update Process data");
		}
	}

	@Override
	public List<Processs> listAll() 
	{
		Session session = databaseConnectionHibernate();
		String hql = "SELECT process FROM Process as process";
		TypedQuery<Processs> typedQuery = session.createQuery(hql, Processs.class);
		List<Processs> processs = typedQuery.getResultList();
		for (Processs Process : processs) 
		{
			System.out.println(Process);
		}
		return processs;
	}

	@Override
	public Processs find(long id) 
	{
		try (Session session = databaseConnectionHibernate())
		{
			Processs process = session.find(Processs.class, id);
			if(process != null)
			{
				System.out.println("Process found: " + process);
				return process;
			}
			else
			{
				System.out.println("Process not found");
				return process;
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
