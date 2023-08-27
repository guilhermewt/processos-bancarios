package br.com.bank.core.useCase;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.bank.core.contracts.TransferRepository;
import br.com.bank.core.contracts.TransferServiceContract;
import br.com.bank.core.contracts.exceptions.BadRequestException;
import br.com.bank.core.entities.Transfer;
import br.com.bank.core.requests.GetTransferSearch;


public class TransferService implements TransferServiceContract{

	private final TransferRepository transferRepository;
	
	public TransferService(TransferRepository transferRepository) {
		this.transferRepository = transferRepository;
	}

	public List<Transfer> findAll() {
		return transferRepository.findAll();
	}
 
	public GetTransferSearch getTransfers(Long accountNumber, OffsetDateTime startDate, OffsetDateTime EndDate,
			String operatorName) {

		List<Transfer> listatransfers = searchTransfersInBank(accountNumber, startDate, EndDate, operatorName);
		BigDecimal PeriodBalance = calculatePeriodBalance(listatransfers);

		return new GetTransferSearch(PeriodBalance,listatransfers);
	}
	
	public List<Transfer> searchTransfersInBank(Long accountNumber, OffsetDateTime startDate, OffsetDateTime EndDate,
			String operatorName) {
		
		List<Transfer> transfers = new ArrayList<>();
		if(accountNumber == null) {
			throw new BadRequestException("the account number is empty or not found!");
		}
		if (startDate == null && EndDate == null && operatorName == null) {
			transfers =  transferRepository.findByAccountId(accountNumber);
		}

		if (startDate != null && EndDate != null && operatorName != null) {
			transfers = transferRepository.findByAccountIdAndStartDateAndEndDateAndOperatorName(accountNumber, startDate,
					EndDate, operatorName);
		}
		
		if(startDate != null && EndDate == null && operatorName != null) {
			transfers = transferRepository.findByAccountIdStartingWithStartDateAndOperatorName(accountNumber, startDate, operatorName);
		}

		if (startDate != null && EndDate != null && operatorName == null) {
			transfers = transferRepository.findByAccountIdAndStartDateAndEndDate(accountNumber, startDate, EndDate);
		}
		
		if (startDate != null && EndDate == null && operatorName == null) {
			transfers = transferRepository.findByAccountIdStartingWithStartDate(accountNumber, startDate);
		}
		
		if(EndDate != null && startDate == null && operatorName != null) {
			transfers = transferRepository.findByAccountIdUntilEndDateAndOperatorName(accountNumber, EndDate, operatorName);
		}

		if(EndDate != null && startDate == null && operatorName == null) {
			transfers = transferRepository.findByAccountIdUntilEndDate(accountNumber, EndDate);
		}

		if (operatorName != null) {
			transfers = transferRepository.findByAccountIdAndOperatorName(accountNumber, operatorName);
		}
		
		return transfers;

	}
	
	public BigDecimal calculatePeriodBalance(List<Transfer> transferss) {
		return transferss.stream().map(x -> x.getValue()).reduce(BigDecimal.ZERO,(x,y) -> x.add(y));
	}
}
