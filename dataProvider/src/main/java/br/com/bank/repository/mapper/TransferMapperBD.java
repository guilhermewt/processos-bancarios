package br.com.bank.repository.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.bank.entities.Transfer;
import br.com.bank.repository.entities.TransferEntityBD;

@Mapper(componentModel = "spring")
public abstract class TransferMapperBD {

	public static TransferMapperBD INSTANCE = Mappers.getMapper(TransferMapperBD.class);
	
	public abstract Transfer toTransfer(TransferEntityBD transferEntityBD);
	
	public abstract List<Transfer> toListOfTransfer(List<TransferEntityBD> transferEntityBD);
	
	public abstract TransferEntityBD toTransferEntityBD(Transfer transfer);
	
	public abstract List<TransferEntityBD> toListOfTransferEntityBD(List<Transfer> transfer);
	
}
