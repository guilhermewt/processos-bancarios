package br.com.bank.repository;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.bank.contracts.TransferRepository;
import br.com.bank.entities.Transfer;
import br.com.bank.repository.mapper.TransferMapperBD;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class TransferRepositoryImpl implements TransferRepository{

	private final TransferDao transferRepository;

	@Override
	public List<Transfer> findAll() {
		return TransferMapperBD.INSTANCE.toListOfTransfer(transferRepository.findAll());
	}

	@Override
	public List<Transfer> findByAccountId(Long accountId) {
		return TransferMapperBD.INSTANCE.toListOfTransfer(transferRepository.findByAccountId(accountId));
	}

	@Override
	public List<Transfer> findByAccountIdAndOperatorName(Long accountId, String operatorName) {
		return TransferMapperBD.INSTANCE.toListOfTransfer(transferRepository.findByAccountIdAndOperatorName(
				accountId, operatorName));
	}

	@Override
	public List<Transfer> findByAccountIdAndStartDateAndEndDateAndOperatorName(Long accountId,
			OffsetDateTime startDate, OffsetDateTime endDate, String operatorName) {
		
		return TransferMapperBD.INSTANCE.toListOfTransfer(
				transferRepository.findByAccountIdAndStartDateAndEndDateAndOperatorName(
						accountId, startDate, endDate, operatorName));
	}

	@Override
	public List<Transfer> findByAccountIdAndStartDateAndEndDate(Long accountId, OffsetDateTime startDate,
			OffsetDateTime endDate) {
		
		return TransferMapperBD.INSTANCE.toListOfTransfer(transferRepository.findByAccountIdAndStartDateAndEndDate(
				accountId, startDate, endDate));
	}

	@Override
	public List<Transfer> findByAccountIdStartingWithStartDate(Long accountId, OffsetDateTime startDate) {
		
		return TransferMapperBD.INSTANCE.toListOfTransfer(transferRepository.findByAccountIdStartingWithStartDate(
				accountId, startDate));
	}

	@Override
	public List<Transfer> findByAccountIdStartingWithStartDateAndOperatorName(Long accountId,
			OffsetDateTime startDate, String operatorName) {
		
		return TransferMapperBD.INSTANCE.toListOfTransfer(transferRepository.findByAccountIdStartingWithStartDateAndOperatorName(
				accountId, startDate, operatorName));
	}

	@Override
	public List<Transfer> findByAccountIdUntilEndDateAndOperatorName(Long accountId, OffsetDateTime startDate,
			String operatorName) {
	
		return TransferMapperBD.INSTANCE.toListOfTransfer(transferRepository.findByAccountIdUntilEndDateAndOperatorName(
				accountId, startDate, operatorName));
	}

	@Override
	public List<Transfer> findByAccountIdUntilEndDate(Long accountNumber, OffsetDateTime startDate) {

		return TransferMapperBD.INSTANCE.toListOfTransfer(transferRepository.findByAccountIdUntilEndDate(
				accountNumber, startDate));
	}

}
