package br.com.bank.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bank.dataprovider.repository.entities.AccountEntityBD;

@Repository
public interface AccountDao extends JpaRepository<AccountEntityBD, Long>{

}
