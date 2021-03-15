package com.cg.apps.customermgt.customerms.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.HashSet;
import java.util.Set;

import com.cg.apps.customermgt.itemms.entities.Item;


@Entity
public class Customer {

	@GeneratedValue
	@Id
	private Long id;
	private String name;
	@OneToOne
	private Account account;
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Item> boughtItems;
	
	
	public Customer() {}
	
	public Customer(String name, Account account) {
		this.name=name;
		this.account=account;
		this.boughtItems = new HashSet<Item>();
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
	
	public void setBoughtItems(Set<Item> boughtItems) {
		this.boughtItems=boughtItems;
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
	
	public Set<Item> getBoughtItems() {
		return boughtItems;
	}
	
	
	@Override
	public String toString() {
		String text="id:"+id +" name:"+name+" AccountID:"+account.getId()+" AccountBalance:"+account.getBalance()+"AccountCreated:"+account.getCreated();
	    return text;
	}
	
}
