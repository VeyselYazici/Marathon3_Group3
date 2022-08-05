package com.bilgeadam.marathon.group3.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.marathon.group3.entity.Branch;

import jakarta.persistence.TypedQuery;

public class BranchDao implements IRepository<Branch>
{

	@Override
	public void create(Branch entity) 
	{
		try (Session session = databaseConnectionHibernate())
		{
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Branch data is added to DB");
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Branch data");
		}
	}

	@Override
	public void delete(long id) 
	{
		try(Session session = databaseConnectionHibernate())
		{
			Branch deleteBranch = find(id);
			if (deleteBranch != null)
			{
				session.getTransaction().begin();
				session.remove(deleteBranch);
				session.getTransaction().commit();
				System.out.println("Branch data is delete to DB");
			}	
		}	
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while delete Branch data");
		}
			
		
	}

	@Override
	public void update(long id, Branch entity) 
	{
		try(Session session = databaseConnectionHibernate())
		{
			Branch updateBranch = find(id);
			if (updateBranch != null)
			{
				
				session.getTransaction().begin();
				session.merge(updateBranch);
				session.getTransaction().commit();
				System.out.println("Branch data is update to DB");
			}	
		}	
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while update Branch data");
		}
	}

	@Override
	public List<Branch> listAll() 
	{
		Session session = databaseConnectionHibernate();
		String hql = "SELECT branch FROM Branch as branch";
		TypedQuery<Branch> typedQuery = session.createQuery(hql, Branch.class);
		List<Branch> branchs = typedQuery.getResultList();
		for (Branch Branch : branchs) 
		{
			System.out.println(Branch);
		}
		return branchs;
	}

	@Override
	public Branch find(long id) 
	{
		try (Session session = databaseConnectionHibernate())
		{
			Branch branch = session.find(Branch.class, id);
			if(branch != null)
			{
				System.out.println("Branch found: " + branch);
				return branch;
			}
			else
			{
				System.out.println("Branch not found");
				return branch;
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
