package com.bilgeadam.marathon.group3.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.marathon.group3.entity.Customer;

import jakarta.persistence.TypedQuery;

public class CustomerDao implements IRepository<Customer>
{

	@Override
	public void create(Customer entity) 
	{
		try (Session session = databaseConnectionHibernate())
		{
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Customer data is added to DB");
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Customer data");
		}
	}

	@Override
	public void delete(long id) 
	{
		try(Session session = databaseConnectionHibernate())
		{
			Customer deleteCustomer = find(id);
			if (deleteCustomer != null)
			{
				session.getTransaction().begin();
				session.remove(deleteCustomer);
				session.getTransaction().commit();
				System.out.println("Customer data is delete to DB");
			}	
		}	
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while delete Customer data");
		}
			
		
	}

	@Override
	public void update(long id, Customer entity) 
	{
		try(Session session = databaseConnectionHibernate())
		{
			Customer updateCustomer = find(id);
			if (updateCustomer != null)
			{
				updateCustomer.setFirstName(entity.getFirstName());
				updateCustomer.setLastName(entity.getLastName());
				updateCustomer.setCustomerNo(entity.getCustomerNo());
				
				session.getTransaction().begin();
				session.merge(updateCustomer);
				session.getTransaction().commit();
				System.out.println("Customer data is update to DB");
			}	
		}	
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while update Customer data");
		}
	}

	@Override
	public List<Customer> listAll() 
	{
		Session session = databaseConnectionHibernate();
		String hql = "SELECT customer FROM Customer as customer";
		TypedQuery<Customer> typedQuery = session.createQuery(hql, Customer.class);
		List<Customer> customers = typedQuery.getResultList();
		for (Customer Customer : customers) 
		{
			System.out.println(Customer);
		}
		return customers;
	}

	@Override
	public Customer find(long id) 
	{
		try (Session session = databaseConnectionHibernate())
		{
			Customer customer = session.find(Customer.class, id);
			if(customer != null)
			{
				System.out.println("Customer found: " + customer);
				return customer;
			}
			else
			{
				System.out.println("Customer not found");
				return customer;
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
