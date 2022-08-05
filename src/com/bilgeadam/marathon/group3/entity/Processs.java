package com.bilgeadam.marathon.group3.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table (name = "processes")
public class Processs
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (name = "process_Date")
	private LocalDate processDate;
	
	@OneToOne (mappedBy = "process")
	private ProcessType processType;
	
	@OneToMany (mappedBy = "process")
	private List<ProcessPlace> processPlaces;

	public Processs(ProcessType processType) 
	{
		super();
		this.processDate = LocalDate.now();
		this.processType = processType;
	}	
	
}
