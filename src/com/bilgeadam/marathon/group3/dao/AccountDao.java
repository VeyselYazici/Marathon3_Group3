package com.bilgeadam.marathon.group3.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.marathon.group3.entity.Account;

import jakarta.persistence.TypedQuery;

public class AccountDao implements IRepository<Account>
{

	@Override
	public void create(Account entity) 
	{
		try (Session session = databaseConnectionHibernate())
		{
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Account data is added to DB");
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Account data");
		}
	}

	@Override
	public void delete(long id) 
	{
		try(Session session = databaseConnectionHibernate())
		{
			Account deleteAccount = find(id);
			if (deleteAccount != null)
			{
				session.getTransaction().begin();
				session.remove(deleteAccount);
				session.getTransaction().commit();
				System.out.println("Account data is delete to DB");
			}	
		}	
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while delete Account data");
		}
			
		
	}

	@Override
	public void update(long id, Account entity) 
	{
		try(Session session = databaseConnectionHibernate())
		{
			Account updateAccount = find(id);
			if (updateAccount != null)
			{
				updateAccount.setAccountNo(entity.getAccountNo());
				updateAccount.setAccountType(entity.getAccountType());
				updateAccount.setCustomer(entity.getCustomer());
				
				session.getTransaction().begin();
				session.merge(updateAccount);
				session.getTransaction().commit();
				System.out.println("Account data is update to DB");
			}	
		}	
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while update Account data");
		}
	}

	@Override
	public List<Account> listAll() 
	{
		Session session = databaseConnectionHibernate();
		String hql = "SELECT account FROM Account as account";
		TypedQuery<Account> typedQuery = session.createQuery(hql, Account.class);
		List<Account> accounts = typedQuery.getResultList();
		for (Account Account : accounts) 
		{
			System.out.println(Account);
		}
		return accounts;
	}

	@Override
	public Account find(long id) 
	{
		try (Session session = databaseConnectionHibernate())
		{
			Account account = session.find(Account.class, id);
			if(account != null)
			{
				System.out.println("Account found: " + account);
				return account;
			}
			else
			{
				System.out.println("Account not found");
				return account;
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
