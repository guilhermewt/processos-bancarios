package br.com.bank.mappers;

import br.com.bank.entities.Account;
import br.com.bank.requests.AccountGetRequestBody;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-19T17:18:29-0300",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class AccountMapperImpl extends AccountMapper {

    @Override
    public Account toAccount(AccountGetRequestBody AccountGetRequestBody) {
        if ( AccountGetRequestBody == null ) {
            return null;
        }

        Double balance = null;
        Long id = null;
        String nameUser = null;

        balance = AccountGetRequestBody.getBalance();
        id = AccountGetRequestBody.getId();
        nameUser = AccountGetRequestBody.getNameUser();

        Account account = new Account( id, nameUser, balance );

        return account;
    }

    @Override
    public List<Account> toListOfAccount(List<AccountGetRequestBody> AccountGetRequestBody) {
        if ( AccountGetRequestBody == null ) {
            return null;
        }

        List<Account> list = new ArrayList<Account>( AccountGetRequestBody.size() );
        for ( AccountGetRequestBody accountGetRequestBody : AccountGetRequestBody ) {
            list.add( toAccount( accountGetRequestBody ) );
        }

        return list;
    }

    @Override
    public AccountGetRequestBody toAccountGetRequestBody(Account Account) {
        if ( Account == null ) {
            return null;
        }

        AccountGetRequestBody accountGetRequestBody = new AccountGetRequestBody();

        accountGetRequestBody.setBalance( Account.getBalance() );
        accountGetRequestBody.setId( Account.getId() );
        accountGetRequestBody.setNameUser( Account.getNameUser() );

        return accountGetRequestBody;
    }

    @Override
    public List<AccountGetRequestBody> toListOfAccountGetRequestBody(List<Account> Account) {
        if ( Account == null ) {
            return null;
        }

        List<AccountGetRequestBody> list = new ArrayList<AccountGetRequestBody>( Account.size() );
        for ( Account account : Account ) {
            list.add( toAccountGetRequestBody( account ) );
        }

        return list;
    }
}
