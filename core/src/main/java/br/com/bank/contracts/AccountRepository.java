package br.com.bank.contracts;

import java.util.List;
import java.util.Optional;

import br.com.bank.entities.Account;

public interface AccountRepository {

	public Optional<Account> findById(Long id);

	public List<Account> findAll();
}
