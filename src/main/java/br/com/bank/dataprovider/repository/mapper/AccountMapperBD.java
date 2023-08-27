package br.com.bank.dataprovider.repository.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.bank.core.entities.Account;
import br.com.bank.dataprovider.repository.entities.AccountEntityBD;

@Mapper(componentModel = "spring")
public abstract class AccountMapperBD {

	public static AccountMapperBD INSTANCE = Mappers.getMapper(AccountMapperBD.class);
	
	public abstract Account toAccount(AccountEntityBD AccountEntityBD);
	
	public abstract List<Account> toListOfAccount(List<AccountEntityBD> AccountEntityBD);
	
	public abstract AccountEntityBD toAccountEntityBD(Account Account);
	
	public abstract List<AccountEntityBD> toListOfAccountEntityBD(List<Account> Account);
	
}
