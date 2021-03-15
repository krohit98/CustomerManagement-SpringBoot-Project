package com.cg.apps.customermgt.customerms.service;

import java.util.Set;

import com.cg.apps.customermgt.customerms.entities.*;
import com.cg.apps.customermgt.itemms.entities.*;

public interface ICustomerService {

	Customer findByID(Long customerID);
    Customer createCustomer(String name); 
    Set<Item> itemsBoughtByCustomer(Long customerId);
    Customer addAmount(Long customerId, double amount);
}
