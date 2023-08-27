package br.com.bank.dataprovider.repository.mapper;

import br.com.bank.core.entities.Account;
import br.com.bank.dataprovider.repository.entities.AccountEntityBD;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-21T11:06:03-0300",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class AccountMapperBDImpl extends AccountMapperBD {

    @Override
    public Account toAccount(AccountEntityBD AccountEntityBD) {
        if ( AccountEntityBD == null ) {
            return null;
        }

        Long id = null;
        String nameUser = null;
        Double balance = null;

        id = AccountEntityBD.getId();
        nameUser = AccountEntityBD.getNameUser();
        balance = AccountEntityBD.getBalance();

        Account account = new Account( id, nameUser, balance );

        return account;
    }

    @Override
    public List<Account> toListOfAccount(List<AccountEntityBD> AccountEntityBD) {
        if ( AccountEntityBD == null ) {
            return null;
        }

        List<Account> list = new ArrayList<Account>( AccountEntityBD.size() );
        for ( AccountEntityBD accountEntityBD : AccountEntityBD ) {
            list.add( toAccount( accountEntityBD ) );
        }

        return list;
    }

    @Override
    public AccountEntityBD toAccountEntityBD(Account Account) {
        if ( Account == null ) {
            return null;
        }

        AccountEntityBD accountEntityBD = new AccountEntityBD();

        accountEntityBD.setBalance( Account.getBalance() );
        accountEntityBD.setId( Account.getId() );
        accountEntityBD.setNameUser( Account.getNameUser() );

        return accountEntityBD;
    }

    @Override
    public List<AccountEntityBD> toListOfAccountEntityBD(List<Account> Account) {
        if ( Account == null ) {
            return null;
        }

        List<AccountEntityBD> list = new ArrayList<AccountEntityBD>( Account.size() );
        for ( Account account : Account ) {
            list.add( toAccountEntityBD( account ) );
        }

        return list;
    }
}
