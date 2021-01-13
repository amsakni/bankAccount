package com.socgen.sgcib.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socgen.sgcib.model.Account;

@Repository
public interface IAccountDAO extends JpaRepository<Account, Integer>{


    List<Account> findAll();
    
    Account findFirstByOrderByIdDesc();
	
}
