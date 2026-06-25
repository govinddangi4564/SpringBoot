package com.example.crud.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entity.Accounts;
import com.example.crud.entity.Transfer;
import com.example.crud.service.AccountService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {

	private AccountService service;

	@GetMapping
	public List<Accounts> getAll() {
		return service.getAllDetails();
	}

	@GetMapping("/{id}")
	public Accounts getOne(@PathVariable Long id) {
		return service.getOne(id);
	}

	@PostMapping
	public Accounts saveNewAccount(@RequestBody Accounts account) {
		return service.create(account);
	}

	@PutMapping("/withdraw/{id}/{amount}")
	public Accounts withdrawlMoney(@PathVariable Long id, @PathVariable Double amount) {
		return service.withdrawl(id, amount);
	}

	@PutMapping("/deposite/{id}/{amount}")
	public Accounts depositeMoney(@PathVariable Long id, @PathVariable Double amount) {
		return service.deposite(id, amount);
	}

	@PostMapping("/transfer")
	public String transfer(@RequestBody Transfer transfer) {
		return service.transfer(transfer);
	}
}
