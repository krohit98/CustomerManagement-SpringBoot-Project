package com.cg.apps.customermgt.customerms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.apps.customermgt.customerms.dao.IAccountRepository;
import com.cg.apps.customermgt.customerms.dao.ICustomerRepository;
import com.cg.apps.customermgt.customerms.entities.*;
import com.cg.apps.customermgt.itemms.entities.*;
import com.cg.apps.customermgt.customerms.exceptions.*;

import java.util.*;

@Service
public class CustomerServiceImpl implements ICustomerService {

	//@Autowired
	//private ICustomerDAO dao;
	
	@Autowired
	ICustomerRepository customerRepository;
	
	@Autowired
	IAccountRepository accountRepository;
	
	@Transactional
	@Override
	public Customer createCustomer(String name) {
		Account account = new Account();
		Customer customer=new Customer(name,account);
		//dao.add(customer);
		accountRepository.save(account);
		customerRepository.save(customer);
		return customer;
	}
	
	@Override
	public Customer findByID(Long customerID) {
		//Customer customer = dao.findByID(customerID);
		Customer customer;
		Optional<Customer> optional = customerRepository.findById(customerID);
		if(!optional.isPresent()) {
			throw new CustomerNotFoundException("Customer doesn't exist");
		}
		else {
			customer = optional.get();
		}
		return customer;
		}
	
	@Transactional
	@Override
	public Customer addAmount(Long customerID, double amount) {
		//Customer customer = dao.findByID(customerID);
		Customer customer = findByID(customerID);
		Account account =customer.getAccount();
		account.setBalance(amount);
		//dao.update(customer);
		accountRepository.save(account);
		customerRepository.save(customer);
		
		return customer;
	}
	
	@Override
	public Set<Item> itemsBoughtByCustomer(Long customerId){
		//Customer customer  = dao.findByID(customerId);
		Customer customer = findByID(customerId);
		Set<Item> boughtItems = customer.getBoughtItems();
		return boughtItems;
	}
}
