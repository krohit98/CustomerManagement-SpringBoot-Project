package com.cg.apps.customermgt.customerms.dao;

import com.cg.apps.customermgt.customerms.entities.Customer;

public interface ICustomerDAO {

	Customer add(Customer customer);
    Customer findByID(Long customerID);
    Customer update(Customer customer);
}
