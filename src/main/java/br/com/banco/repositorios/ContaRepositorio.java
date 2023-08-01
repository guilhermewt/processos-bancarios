package br.com.banco.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.banco.entidades.Conta;

@Repository
public interface ContaRepositorio extends JpaRepository<Conta, Long>{

}
