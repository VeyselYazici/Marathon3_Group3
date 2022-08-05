package com.bilgeadam.marathon.group3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "account_type")
@Entity
public class AccountType 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (name = "accountType", unique = false)
	private String accountType;
	
	@OneToOne
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private Account account;
	
	public AccountType(String accountType)
	{
		super();
		this.accountType = accountType;
	}
}
