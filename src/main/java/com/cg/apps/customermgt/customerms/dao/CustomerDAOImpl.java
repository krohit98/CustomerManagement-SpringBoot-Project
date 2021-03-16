/*
package com.cg.apps.customermgt.customerms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.apps.customermgt.customerms.entities.Account;
import com.cg.apps.customermgt.customerms.entities.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class CustomerDAOImpl implements ICustomerDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Customer add(Customer customer){
		
		Account account = customer.getAccount();
		entityManager.persist(account);
		entityManager.persist(customer);
		return customer;
	}
	
	@Override
    public Customer findByID(Long customerID) {
    	
    	Customer customer=entityManager.find(Customer.class, customerID);
    	return customer;
    }
	
	@Override
    public Customer update(Customer customer) {
    	
		Account account = customer.getAccount();
		account=entityManager.merge(account);
		customer=entityManager.merge(customer);
		return customer;
    }
}
*/