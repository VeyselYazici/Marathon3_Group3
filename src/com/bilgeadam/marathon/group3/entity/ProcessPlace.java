package com.bilgeadam.marathon.group3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "process_place")
public class ProcessPlace 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (name = "process_place")
	private String processPlace;
	
	@ManyToOne
	private Processs process;

	public ProcessPlace(String processPlace) {
		super();
		this.processPlace = processPlace;
	}
	
	
}
