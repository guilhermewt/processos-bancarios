package br.com.bank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.bank.contracts.AccountRepository;
import br.com.bank.entities.Account;
import br.com.bank.repository.mapper.AccountMapperBD;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class AccountRepositoryImpl implements AccountRepository{

	private final AccountDao accountDao;
	
	@Override
	public Optional<Account> findById(Long id) {
		return Optional.of(AccountMapperBD.INSTANCE.toAccount(accountDao.findById(id).get()));
	}

	@Override
	public List<Account> findAll() {
		return AccountMapperBD.INSTANCE.toListOfAccount(accountDao.findAll());
	}

}
