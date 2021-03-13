package com.cg.apps.customermgt.customerms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Customer {

	@GeneratedValue
	@Id
	private Long id;
	private String name;
	
	@OneToOne
	private Account account;
	
	
	public Customer() {}
	
	public Customer(String name, Account account) {

		this.name=name;
		this.account=account;
	}
	
	//setter methods
	public void setId(Long id) {
		this.id=id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setAccount(Account account) {
		this.account=account;
	}
	
	
	//getter methods
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Account getAccount() {
		return account;
	}
	
	
	@Override
	public String toString() {
		String text="id:"+id +" name:"+name+" AccountID:"+account.getId()+" AccountBalance:"+account.getBalance()+"AccountCreated:"+account.getCreated();
	    return text;
	}
	
}
