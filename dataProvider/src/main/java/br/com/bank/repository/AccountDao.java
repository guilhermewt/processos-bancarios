package br.com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bank.repository.entities.AccountEntityBD;

@Repository
public interface AccountDao extends JpaRepository<AccountEntityBD, Long>{

}
