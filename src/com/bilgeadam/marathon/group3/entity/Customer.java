package com.bilgeadam.marathon.group3.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Customer 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "customer_no")
	private int customerNo = 100;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@OneToMany(mappedBy = "customer")
	private List<Account> accounts;
	
	public Customer(String firstName, String lastName)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerNo = customerNo++;
	}

	@Override
	public String toString() 
	{
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
