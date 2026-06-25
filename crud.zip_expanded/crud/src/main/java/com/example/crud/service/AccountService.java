package com.example.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crud.entity.Accounts;
import com.example.crud.entity.Transfer;
import com.example.crud.repository.AccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountService {
	private AccountRepository repo;

	public Accounts create(Accounts ac) {
		return repo.save(ac);
	}

	public Accounts withdrawl(Long id, Double amount) {
		Accounts ac = repo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
		ac.setBalance(ac.getBalance() - amount);
		return repo.save(ac);
	}

	public Accounts deposite(Long id, Double amount) {
		Accounts ac = repo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
		ac.setBalance(ac.getBalance() + amount);
		return repo.save(ac);
	}

	public List<Accounts> getAllDetails() {
		return repo.findAll();
	}

	public Accounts getOne(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
	}

	@Transactional
	public String transfer(Transfer tr) {
		Accounts from = repo.findById(tr.from()).orElseThrow(() -> new RuntimeException("Not Found"));
		Accounts to = repo.findById(tr.to()).orElseThrow(() -> new RuntimeException("Not Found"));

		if (from.getBalance() > tr.amount()) {
			from.setBalance(from.getBalance() - tr.amount());
			to.setBalance(to.getBalance() + tr.amount());

			repo.save(from);
			repo.save(to);
		} else {
			throw new RuntimeException("Insuficcient Fund..");
		}

		return "Transfer Successfully";
	}

}
