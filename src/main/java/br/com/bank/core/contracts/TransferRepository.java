package br.com.bank.core.contracts;

import java.time.OffsetDateTime;
import java.util.List;

import br.com.bank.core.entities.Transfer;

public interface TransferRepository {

	List<Transfer> findAll();

	List<Transfer> findByAccountId(Long contaId);

	List<Transfer> findByAccountIdAndOperatorName(Long accountNumber, String OperatorName);

	List<Transfer> findByAccountIdAndStartDateAndEndDateAndOperatorName(Long accountNumber, OffsetDateTime startDate,
			OffsetDateTime EndDate, String OperatorName);

	List<Transfer> findByAccountIdAndStartDateAndEndDate(Long accountNumber, OffsetDateTime startDate,
			OffsetDateTime EndDate);

	List<Transfer> findByAccountIdStartingWithStartDate(Long accountNumber, OffsetDateTime startDate);

	List<Transfer> findByAccountIdStartingWithStartDateAndOperatorName(Long accountNumber, OffsetDateTime startDate,
			String OperatorName);

	List<Transfer> findByAccountIdUntilEndDate(Long accountNumber, OffsetDateTime startDate);

	List<Transfer> findByAccountIdUntilEndDateAndOperatorName(Long accountNumber, OffsetDateTime startDate,
			String OperatorName);
}
