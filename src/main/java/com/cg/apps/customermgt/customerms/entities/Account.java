package com.cg.apps.customermgt.customerms.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

	@GeneratedValue
	@Id
	private Long id;
	private double balance;
	private LocalDateTime created;
	
	public Account() {
		this.balance=0;
		this.created=LocalDateTime.now();
	}

	public Account(double balance, LocalDateTime created) {
		this.balance=balance;
		this.created = created;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public LocalDateTime getCreated() {
		return created;
	}
	
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	
}
