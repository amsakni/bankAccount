package com.socgen.sgcib.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.socgen.sgcib.dao.IAccountDAO;
import com.socgen.sgcib.exception.WithdrawalException;
import com.socgen.sgcib.model.Account;

@Service
@Transactional
public class AccountService {

	@Autowired
	private IAccountDAO accountDAO;

	public AccountService() {
		super();
	}

	public List<Account> getAll() {
		return accountDAO.findAll();
	}

	public synchronized void depositAmount(Double amount) {
		Account currentAccount = accountDAO.findFirstByOrderByIdDesc();
		Account account = initAccount(amount);
		Double balance = currentAccount != null ? currentAccount.getBalance() : new Double(0);
		
		account.setBalance(amount + balance);
		accountDAO.save(account);
		accountDAO.flush();
	}

	public synchronized void withdrawalAmount(Double amount) throws WithdrawalException {
		Account currentAccount = accountDAO.findFirstByOrderByIdDesc();
		Account account = initAccount(- amount);
		Double balance = currentAccount != null ? currentAccount.getBalance() : new Double(0);

		if (balance - amount < 0) {
			throw new WithdrawalException("No enough money to withdrawal");
		}

		account.setBalance(balance - amount);
		accountDAO.save(account);
		accountDAO.flush();
	}

	private Account initAccount(Double amount) {
		Account account = new Account();
		account.setOperationAmount(amount);
		account.setOperationDate(new Date());
		return account;
	}
}
