package com.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.model.Accounts;
import com.accounts.model.Customer;
import com.accounts.repository.AccountsRepository;

@RestController
public class AccountsController {
	
	@Autowired
	private AccountsRepository accountRepository;
	
	
	@PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {
		Accounts accounts = accountRepository.findByCustomerId(customer.getCustomerId());
		if(accounts!=null){
			return accounts;			
		}
		else {
			return null;
		}
	}
	

}
