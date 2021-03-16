package com.cg.apps.customermgt.customerms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.apps.customermgt.customerms.entities.Account;

public interface IAccountRepository extends JpaRepository<Account, Long> {

}
