package com.bilgeadam.marathon.group3.util;

import org.hibernate.SessionFactory;




import org.hibernate.cfg.Configuration;

import com.bilgeadam.marathon.group3.entity.Account;
import com.bilgeadam.marathon.group3.entity.AccountType;
import com.bilgeadam.marathon.group3.entity.Branch;
import com.bilgeadam.marathon.group3.entity.Customer;
import com.bilgeadam.marathon.group3.entity.ProcessPlace;
import com.bilgeadam.marathon.group3.entity.ProcessType;
import com.bilgeadam.marathon.group3.entity.Processs;


public class HibernateSession {

	private static SessionFactory sessionFactory = sessionFactory() ;
	
	private static SessionFactory sessionFactory() {
		
		Configuration configuration = new Configuration();
		
		configuration.addAnnotatedClass(Customer.class);
		configuration.addAnnotatedClass(Account.class);
		configuration.addAnnotatedClass(Branch.class);
		configuration.addAnnotatedClass(Processs.class);
		configuration.addAnnotatedClass(ProcessType.class);
		configuration.addAnnotatedClass(ProcessPlace.class);
		configuration.addAnnotatedClass(AccountType.class);
		
		SessionFactory factory = configuration.configure("hibernateaccountdb.cfg.xml").buildSessionFactory();
		
		return factory;
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
