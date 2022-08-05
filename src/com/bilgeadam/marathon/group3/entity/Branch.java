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
@Table (name = "branches")
public class Branch 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "city_no")
	private int cityNo;
	
	@Column(name = "city_name")
	private String cityName;
	
	@OneToMany (mappedBy = "branch")
	private List<Account> accounts;

	public Branch(int cityNo, String cityName) 
	{
		super();
		this.cityNo = cityNo;
		this.cityName = cityName;
	}
	
	
	
}
