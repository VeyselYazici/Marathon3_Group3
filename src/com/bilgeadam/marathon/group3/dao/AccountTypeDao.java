package com.bilgeadam.marathon.group3.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.marathon.group3.entity.AccountType;

import jakarta.persistence.TypedQuery;

public class AccountTypeDao implements IRepository<AccountType>
{

	@Override
	public void create(AccountType entity) 
	{
		try (Session session = databaseConnectionHibernate())
		{
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("AccountType data is added to DB");
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding AccountType data");
		}
	}

	@Override
	public void delete(long id) 
	{
		try(Session session = databaseConnectionHibernate())
		{
			AccountType deleteAccountType = find(id);
			if (deleteAccountType != null)
			{
				session.getTransaction().begin();
				session.remove(deleteAccountType);
				session.getTransaction().commit();
				System.out.println("AccountType data is delete to DB");
			}	
		}	
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while delete AccountType data");
		}
			
		
	}

	@Override
	public void update(long id, AccountType entity) 
	{
		try(Session session = databaseConnectionHibernate())
		{
			AccountType updateAccountType = find(id);
			if (updateAccountType != null)
			{
				updateAccountType.setAccount(entity.getAccount());
				updateAccountType.setAccountType(entity.getAccountType());
				
				session.getTransaction().begin();
				session.merge(updateAccountType);
				session.getTransaction().commit();
				System.out.println("AccountType data is update to DB");
			}	
		}	
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while update AccountType data");
		}
	}

	@Override
	public List<AccountType> listAll() 
	{
		Session session = databaseConnectionHibernate();
		String hql = "SELECT accountType FROM AccountType as accountType";
		TypedQuery<AccountType> typedQuery = session.createQuery(hql, AccountType.class);
		List<AccountType> accountTypes = typedQuery.getResultList();
		for (AccountType AccountType : accountTypes) 
		{
			System.out.println(AccountType);
		}
		return accountTypes;
	}

	@Override
	public AccountType find(long id) 
	{
		try (Session session = databaseConnectionHibernate())
		{
			AccountType accountType = session.find(AccountType.class, id);
			if(accountType != null)
			{
				System.out.println("AccountType found: " + accountType);
				return accountType;
			}
			else
			{
				System.out.println("AccountType not found");
				return accountType;
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
