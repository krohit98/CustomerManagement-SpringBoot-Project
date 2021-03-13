package com.cg.apps.customermgt.itemms.entities;

import java.time.LocalDateTime;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Item {

	@Id
	String id;
	double price;
	String description;
	LocalDateTime addedDate;
	
	public Item() {}
	
	public Item(String id, double price, String description, LocalDateTime addedDate) {
		this.id = id;
		this.price = price;
		this.description = description;
		this.addedDate = addedDate;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDateTime addedDate) {
		this.addedDate = addedDate;
	}
	
	@Override
	public String toString() {
		String text="id:"+id +" price:"+price+" Description:"+description+"Added Date:"+addedDate;
	    return text;
	}
	
	
}
