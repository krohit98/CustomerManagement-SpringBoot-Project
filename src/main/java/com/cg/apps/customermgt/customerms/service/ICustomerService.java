package com.cg.apps.customermgt.customerms.service;

import java.util.Set;

import com.cg.apps.customermgt.customerms.entities.*;

public interface ICustomerService {

	Customer findByID(Long customerID);
    Customer createCustomer(String name); 
    Customer addAmount(Long customerId, double amount);
}
