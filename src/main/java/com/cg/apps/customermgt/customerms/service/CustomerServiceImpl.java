package com.cg.apps.customermgt.customerms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.apps.customermgt.customerms.dao.ICustomerDAO;
import com.cg.apps.customermgt.customerms.entities.*;
import com.cg.apps.customermgt.itemms.entities.*;

import java.util.Set;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDAO dao;
	
	@Transactional
	@Override
	public Customer createCustomer(String name) {
		Account account = new Account();
		Customer customer=new Customer(name,account);
		dao.add(customer);
		return customer;
	}
	
	@Override
	public Customer findByID(Long customerID) {
		Customer customer = dao.findByID(customerID);
		return customer;
		}
	
	@Transactional
	@Override
	public Customer addAmount(Long customerID, double amount) {
		Customer customer = dao.findByID(customerID);
		customer.getAccount().setBalance(amount);
		dao.update(customer);
		return customer;
	}
	
	@Override
	public Set<Item> itemsBoughtByCustomer(Long customerId){
		Customer customer  = dao.findByID(customerId);
		Set<Item> boughtItems = customer.getBoughtItems();
		return boughtItems;
	}
}
