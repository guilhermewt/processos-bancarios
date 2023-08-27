package br.com.bank.entrypoint.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.bank.core.entities.Transfer;
import br.com.bank.core.requests.GetTransferSearch;
import br.com.bank.entrypoint.requests.TransferGetRequestBody;
import br.com.bank.entrypoint.requests.TransferSearchGetRequestBody;

@Mapper(componentModel = "spring")
public abstract class TransferMapper {
	
	public static TransferMapper INSTANCE = Mappers.getMapper(TransferMapper.class);
	
   public abstract Transfer toTransfer(TransferGetRequestBody transferGetRequestBody);
	
	public abstract List<Transfer> toListOfTransfer(List<TransferGetRequestBody> transferGetRequestBody);
	
	public abstract TransferGetRequestBody toTransferGetRequestBody(Transfer transfer);
	
	public abstract List<TransferGetRequestBody> toListOfTransferGetRequestBody(List<Transfer> transfer);
	
	public abstract TransferSearchGetRequestBody toTransferSearchGetRequestBody(GetTransferSearch transfer);
	
}
