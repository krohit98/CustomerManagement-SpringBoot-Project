package com.cg.apps.customermgt.customerms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.apps.customermgt.customerms.entities.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

}
