package br.com.bank.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.bank.entities.Account;
import br.com.bank.requests.AccountGetRequestBody;


@Mapper(componentModel = "spring")
public abstract class AccountMapper {
	
	public static AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
	
   public abstract Account toAccount(AccountGetRequestBody AccountGetRequestBody);
	
	public abstract List<Account> toListOfAccount(List<AccountGetRequestBody> AccountGetRequestBody);
	
	public abstract AccountGetRequestBody toAccountGetRequestBody(Account Account);
	
	public abstract List<AccountGetRequestBody> toListOfAccountGetRequestBody(List<Account> Account);
	
}
