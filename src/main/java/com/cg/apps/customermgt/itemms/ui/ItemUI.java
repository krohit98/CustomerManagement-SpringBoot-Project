package com.cg.apps.customermgt.itemms.ui;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.apps.customermgt.customerms.entities.Customer;
import com.cg.apps.customermgt.customerms.service.ICustomerService;
import com.cg.apps.customermgt.itemms.entities.Item;
import com.cg.apps.customermgt.itemms.service.IItemService;

@Component
public class ItemUI {

	@Autowired
	IItemService service;
	
	@Autowired
	ICustomerService cservice;
	
	public void start() {
		
		Customer customer1 = cservice.createCustomer("Rohit");
		Customer customer2 = cservice.createCustomer("Akshay");
		Customer customer3 = cservice.createCustomer("Mohit");
		
		cservice.addAmount(customer1.getId(), 30000);
		cservice.addAmount(customer2.getId(), 20000);
		cservice.addAmount(customer3.getId(), 50000);
		
		Item item1 = service.create(7000, "Redmi Note 7");
		Item item2 = service.create(10000, "Redmi Note 7 Pro");
		Item item3 = service.create(15000, "Iphone 11");
		Item item4 = service.create(20000, "Samsung A47");
		
		service.buyItem(item1.getId(), customer1.getId());
		service.buyItem(item2.getId(), customer2.getId());
		service.buyItem(item3.getId(), customer3.getId());
		service.buyItem(item4.getId(), customer1.getId());
		
		Customer fetchedCustomer1 = cservice.findByID(customer1.getId());
		Customer fetchedCustomer2 = cservice.findByID(customer2.getId());
		Customer fetchedCustomer3 = cservice.findByID(customer3.getId());
		
		Item fetchedItem1 = service.findById(item1.getId());
		Item fetchedItem2 = service.findById(item2.getId());
		Item fetchedItem3 = service.findById(item3.getId());
		Item fetchedItem4 = service.findById(item4.getId());
		
		System.out.println("\n***Displaying output for fetched customer***\n");
		display(fetchedCustomer1);
		display(fetchedCustomer2);
		display(fetchedCustomer3);
		
		System.out.println("\n***Item Details***\n");
		
		display(fetchedItem1);
		display(fetchedItem2);
		display(fetchedItem3);
		display(fetchedItem4);
		
	}
	
	public void display(Customer customer) {
		System.out.println("\nCustomerID: "+customer.getId()
							+"\nCustomer Name: "+customer.getName()
							+"\nCustomer AccountId: "+customer.getAccount().getId()
							+"\nCustomer Balance: "+customer.getAccount().getBalance()
							+"\nAccount created on: "+customer.getAccount().getCreated()
							+"\nItems Bought:");
		Set<Item> itemList = cservice.itemsBoughtByCustomer(customer.getId());
		for(Item item:itemList) {
			System.out.println("Item id = "+item.getId()+" | Item desc. = "+item.getDescription()+" | Item price = "+item.getPrice());
		}
		
	}
	

	public void display(Item item) {
		
		System.out.println("ItemID: "+item.getId()
							+"\nItem Price: "+item.getPrice()
							+"\nItem description: "+item.getDescription()
							+"\nItem added on: "+item.getAddedDate()
							+"\nItem bought by: "+item.getBoughtBy().getName()
							+"\n");
	}
}
