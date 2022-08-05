package com.bilgeadam.marathon.group3.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Account 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "account_no")
	private int accountNo = 10;
	
	@OneToOne(mappedBy = "account")
	private AccountType accountType;
	
	@ManyToOne
	@JoinColumn(name="customer_id", referencedColumnName = "id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="branch_id", referencedColumnName = "id")
	private Branch branch;
	
	

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountType=" + accountType + ", customer=" + customer + "]";
	}



	public Account(int accountNo, AccountType accountType, Customer customer, Branch branch) 
	{
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.customer = customer;
		this.branch = branch;
	}



	
}
