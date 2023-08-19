package br.com.bank.contracts;

import java.time.OffsetDateTime;
import java.util.List;

import br.com.bank.entities.Transfer;
import br.com.bank.requests.GetTransferSearch;

public interface TransferServiceContract {
	
	public List<Transfer> findAll();
 
	public GetTransferSearch getTransfers(Long accountNumber, OffsetDateTime startDate, OffsetDateTime EndDate,
			String operatorName);
	
	public List<Transfer> searchTransfersInBank(
			Long accountNumber, OffsetDateTime startDate, OffsetDateTime EndDate,
			String operatorName);
	
}
