package com.cg.apps.customermgt.customerms.ui;

import com.cg.apps.customermgt.customerms.entities.Customer;
import com.cg.apps.customermgt.customerms.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerUI {

	@Autowired
	private ICustomerService service;
	
	public void start() {
		
		Customer customer1 = service.createCustomer("Rohit");
		Customer customer2 = service.createCustomer("Akshay");
		Customer customer3 = service.createCustomer("Mohit");
		
		System.out.println("\n***Customer records before adding balance***\n");
		display(customer1);
		display(customer2);
		display(customer3);
		
		service.addAmount(customer1.getId(), 30000);
		service.addAmount(customer2.getId(), 20000);
		service.addAmount(customer3.getId(), 50000);
		
		Customer fetchedCustomer1 = service.findByID(customer1.getId());
		Customer fetchedCustomer2 = service.findByID(customer2.getId());
		Customer fetchedCustomer3 = service.findByID(customer3.getId());
		
		System.out.println("\n***Displaying output for fetched customer***\n");
		display(fetchedCustomer1);
		display(fetchedCustomer2);
		display(fetchedCustomer3);
		
	}
	
	public void display(Customer customer) {
		System.out.println("CustomerID: "+customer.getId()
							+"\nCustomer Name: "+customer.getName()
							+"\nCustomer AccountId: "+customer.getAccount().getId()
							+"\nCustomer Balance: "+customer.getAccount().getBalance()
							+"\nAccount created on: "+customer.getAccount().getCreated()
							+"\n");
	}
	
}
