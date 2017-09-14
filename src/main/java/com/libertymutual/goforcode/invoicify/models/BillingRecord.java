package com.libertymutual.goforcode.invoicify.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public abstract class BillingRecord {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private User createdBy;
	
	private java.sql.Date createdOn;
	
	private String description;
	
	public abstract double getTotal();

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public java.sql.Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(java.sql.Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
