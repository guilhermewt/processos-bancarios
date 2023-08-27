package br.com.bank.dataprovider.repository;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bank.dataprovider.repository.entities.TransferEntityBD;


public interface TransferDao extends JpaRepository<TransferEntityBD, Long>{
	
	List<TransferEntityBD> findByAccountId(Long contaId);
	
	List<TransferEntityBD> findByAccountIdAndOperatorName(Long accountNumber, String OperatorName);
	
	@Query("select u from TransferEntityBD u where u.account.id = ?1 "
			+ "and LOWER(u.operatorName) LIKE LOWER(CONCAT('%', ?4, '%')) "
			+ "and u.transferDate between ?2 and ?3")
	List<TransferEntityBD> findByAccountIdAndStartDateAndEndDateAndOperatorName(Long accountNumber, OffsetDateTime startDate,
			OffsetDateTime EndDate, String OperatorName);
	
	@Query("select u from TransferEntityBD u where u.account.id = ?1 and u.transferDate between ?2 and ?3")
	List<TransferEntityBD> findByAccountIdAndStartDateAndEndDate(Long accountNumber, OffsetDateTime startDate,
			OffsetDateTime EndDate);
	
	@Query("select u from TransferEntityBD u where u.account.id = ?1 and u.transferDate >= ?2")
	List<TransferEntityBD> findByAccountIdStartingWithStartDate(Long accountNumber, OffsetDateTime startDate);
	
	@Query("select u from TransferEntityBD u where u.account.id = ?1 and u.transferDate >= ?2 "
			+ "and LOWER(u.operatorName) LIKE LOWER(CONCAT('%', ?3, '%'))")
	List<TransferEntityBD> findByAccountIdStartingWithStartDateAndOperatorName(Long accountNumber, OffsetDateTime startDate,
			String OperatorName);
	
	@Query("select u from TransferEntityBD u where u.account.id = ?1 and u.transferDate <= ?2")
	List<TransferEntityBD> findByAccountIdUntilEndDate(Long accountNumber, OffsetDateTime startDate);
	
	@Query("select u from TransferEntityBD u where u.account.id = ?1 and u.transferDate <= ?2 "
			+ "and LOWER(u.operatorName) LIKE LOWER(CONCAT('%', ?3, '%'))")
	List<TransferEntityBD> findByAccountIdUntilEndDateAndOperatorName(Long accountNumber, OffsetDateTime startDate,
			String OperatorName);

}
