package br.com.banco.repositorios;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.banco.entidades.Transferencia;

@Repository
public interface TransferenciaRepositorio extends JpaRepository<Transferencia, Long>{
	
	List<Transferencia> findByContaId(Long contaId);
	
	List<Transferencia> findByContaIdAndNomeOperador(Long numeroConta,String nomeOperador);
	
	@Query("select u from Transferencia u where u.conta.id = ?1 "
			+ "and LOWER(u.nomeOperador) LIKE LOWER(CONCAT('%', ?4, '%')) "
			+ "and u.dataTransferencia between ?2 and ?3")
	List<Transferencia> findByContaIdAndDataInicioAndDataFimAndNomeOperador(
			Long numeroConta, OffsetDateTime dataInicio, OffsetDateTime dataFim, String nomeOperador);
	
	@Query("select u from Transferencia u where u.conta.id = ?1 and u.dataTransferencia between ?2 and ?3")
	List<Transferencia> findByContaIdAndDataInicioAndDataFim(Long numeroConta,OffsetDateTime dataInicio, OffsetDateTime dataFim);
	
	@Query("select u from Transferencia u where u.conta.id = ?1 and u.dataTransferencia >= ?2")
	List<Transferencia> findByContaIdApartirDataInicio(Long numeroConta,OffsetDateTime dataInicio);
	
	@Query("select u from Transferencia u where u.conta.id = ?1 and u.dataTransferencia >= ?2 "
			+ "and LOWER(u.nomeOperador) LIKE LOWER(CONCAT('%', ?3, '%'))")
	List<Transferencia> findByContaIdApartirDataInicioAndNomeOperador(
			Long numeroConta,OffsetDateTime dataInicio,String nomeOperador);
	
	@Query("select u from Transferencia u where u.conta.id = ?1 and u.dataTransferencia <= ?2")
	List<Transferencia> findByContaIdAteDataFim(Long numeroConta,OffsetDateTime dataInicio);
	
	@Query("select u from Transferencia u where u.conta.id = ?1 and u.dataTransferencia <= ?2 "
			+ "and LOWER(u.nomeOperador) LIKE LOWER(CONCAT('%', ?3, '%'))")
	List<Transferencia> findByContaIdAteDataFimAndNomeOperador(
			Long numeroConta,OffsetDateTime dataInicio,String nomeOperador);
	
}
