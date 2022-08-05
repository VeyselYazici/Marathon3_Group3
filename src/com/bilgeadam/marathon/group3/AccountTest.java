package com.bilgeadam.marathon.group3;

import java.util.ArrayList;
import java.util.List;

import com.bilgeadam.marathon.group3.dao.AccountDao;
import com.bilgeadam.marathon.group3.dao.AccountTypeDao;
import com.bilgeadam.marathon.group3.dao.BranchDao;
import com.bilgeadam.marathon.group3.dao.CustomerDao;
import com.bilgeadam.marathon.group3.dao.ProcessDao;
import com.bilgeadam.marathon.group3.dao.ProcessPlaceDao;
import com.bilgeadam.marathon.group3.dao.ProcessTypeDao;
import com.bilgeadam.marathon.group3.entity.Account;
import com.bilgeadam.marathon.group3.entity.AccountType;
import com.bilgeadam.marathon.group3.entity.Branch;
import com.bilgeadam.marathon.group3.entity.Customer;
import com.bilgeadam.marathon.group3.entity.ProcessPlace;
import com.bilgeadam.marathon.group3.entity.ProcessType;
import com.bilgeadam.marathon.group3.entity.Processs;

public class AccountTest 
{
	public static void main(String[] args) 
	{
//		HibernateSession.getSessionFactory().openSession();
		
		List<ProcessPlace> pPList = new ArrayList<>();
		
		CustomerDao cDao = new CustomerDao();
		AccountDao aDao = new AccountDao();
		AccountTypeDao aTDao = new AccountTypeDao();
		BranchDao bDao = new BranchDao();
		ProcessDao pDao = new ProcessDao();
		ProcessTypeDao pTDao = new ProcessTypeDao();
		ProcessPlaceDao pPDao = new ProcessPlaceDao();
		
		
		Customer c1 = new Customer("Can", "DEMIRHAN");
		Customer c2 = new Customer("Elif", "YILDIRIM");
		Customer c3 = new Customer("Veysel Karani", "YAZICI");
		cDao.create(c1);
		cDao.create(c2);
		cDao.create(c3);
		
		Branch b1 = new Branch(34, "Istanbul");
		Branch b2 = new Branch(06, "Ankara");
		bDao.create(b1);
		bDao.create(b2);
		
		Account a1 = new Account(10, new AccountType("TL"), c1, b1);
		Account a2 = new Account(11, new AccountType("USD"), c2, b2);
		Account a3 = new Account(12, new AccountType("EURO"), c3, b2);
		aDao.create(a1);
		aDao.create(a2);
		aDao.create(a3);
		
		
		ProcessType pT = new ProcessType("YATIRMA");
		Processs p1 = new Processs(pT);
		ProcessPlace pP = new ProcessPlace("ATM");
		
		pP.setProcess(p1);
		pPList.add(pP);
		p1.setProcessPlaces(pPList);
		p1.setProcessType(pT);
		pT.setProcess(p1);
		pP.setProcess(p1);
		
		pDao.create(p1);
		pPDao.create(pP);
		pTDao.create(pT);
		
		
		
	}

	
}
