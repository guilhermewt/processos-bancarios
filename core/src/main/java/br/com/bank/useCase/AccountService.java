package br.com.bank.useCase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bank.contracts.AccountRepository;
import br.com.bank.contracts.exceptions.BadRequestException;
import br.com.bank.entities.Account;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public Account findById(Long id) {
		//return accountRepository.findById(id).orElseThrow(() -> new BadRequestException("account not found"));
		return accountRepository.findById(id).orElseThrow(() -> new BadRequestException("account not found"));
		
	}
	
	public List<Account> findAll() {
		return accountRepository.findAll();
	}
}