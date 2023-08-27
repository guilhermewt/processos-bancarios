package br.com.bank.dataprovider.repository.mapper;

import br.com.bank.core.entities.Account;
import br.com.bank.core.entities.Transfer;
import br.com.bank.core.entities.enums.TypeTransfers;
import br.com.bank.dataprovider.repository.entities.AccountEntityBD;
import br.com.bank.dataprovider.repository.entities.TransferEntityBD;
import br.com.bank.dataprovider.repository.entities.enums.TypeTransfer;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-21T11:06:04-0300",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class TransferMapperBDImpl extends TransferMapperBD {

    @Override
    public Transfer toTransfer(TransferEntityBD transferEntityBD) {
        if ( transferEntityBD == null ) {
            return null;
        }

        Long id = null;
        OffsetDateTime transferDate = null;
        BigDecimal value = null;
        TypeTransfers type = null;
        String operatorName = null;

        id = transferEntityBD.getId();
        transferDate = transferEntityBD.getTransferDate();
        value = transferEntityBD.getValue();
        type = typeTransferToTypeTransfers( transferEntityBD.getType() );
        operatorName = transferEntityBD.getOperatorName();

        Transfer transfer = new Transfer( id, transferDate, value, type, operatorName );

        transfer.setAccount( accountEntityBDToAccount( transferEntityBD.getAccount() ) );

        return transfer;
    }

    @Override
    public List<Transfer> toListOfTransfer(List<TransferEntityBD> transferEntityBD) {
        if ( transferEntityBD == null ) {
            return null;
        }

        List<Transfer> list = new ArrayList<Transfer>( transferEntityBD.size() );
        for ( TransferEntityBD transferEntityBD1 : transferEntityBD ) {
            list.add( toTransfer( transferEntityBD1 ) );
        }

        return list;
    }

    @Override
    public TransferEntityBD toTransferEntityBD(Transfer transfer) {
        if ( transfer == null ) {
            return null;
        }

        TransferEntityBD transferEntityBD = new TransferEntityBD();

        transferEntityBD.setAccount( accountToAccountEntityBD( transfer.getAccount() ) );
        transferEntityBD.setId( transfer.getId() );
        transferEntityBD.setOperatorName( transfer.getOperatorName() );
        transferEntityBD.setTransferDate( transfer.getTransferDate() );
        transferEntityBD.setType( typeTransfersToTypeTransfer( transfer.getType() ) );
        transferEntityBD.setValue( transfer.getValue() );

        return transferEntityBD;
    }

    @Override
    public List<TransferEntityBD> toListOfTransferEntityBD(List<Transfer> transfer) {
        if ( transfer == null ) {
            return null;
        }

        List<TransferEntityBD> list = new ArrayList<TransferEntityBD>( transfer.size() );
        for ( Transfer transfer1 : transfer ) {
            list.add( toTransferEntityBD( transfer1 ) );
        }

        return list;
    }

    protected TypeTransfers typeTransferToTypeTransfers(TypeTransfer typeTransfer) {
        if ( typeTransfer == null ) {
            return null;
        }

        TypeTransfers typeTransfers;

        switch ( typeTransfer ) {
            case DEPOSITO: typeTransfers = TypeTransfers.DEPOSITO;
            break;
            case SAQUE: typeTransfers = TypeTransfers.SAQUE;
            break;
            case TRANSFERENCIA_ENTRADA: typeTransfers = TypeTransfers.TRANSFERENCIA_ENTRADA;
            break;
            case TRANSFERENCIA_SAIDA: typeTransfers = TypeTransfers.TRANSFERENCIA_SAIDA;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + typeTransfer );
        }

        return typeTransfers;
    }

    protected Account accountEntityBDToAccount(AccountEntityBD accountEntityBD) {
        if ( accountEntityBD == null ) {
            return null;
        }

        Long id = null;
        String nameUser = null;
        Double balance = null;

        id = accountEntityBD.getId();
        nameUser = accountEntityBD.getNameUser();
        balance = accountEntityBD.getBalance();

        Account account = new Account( id, nameUser, balance );

        return account;
    }

    protected AccountEntityBD accountToAccountEntityBD(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountEntityBD accountEntityBD = new AccountEntityBD();

        accountEntityBD.setBalance( account.getBalance() );
        accountEntityBD.setId( account.getId() );
        accountEntityBD.setNameUser( account.getNameUser() );

        return accountEntityBD;
    }

    protected TypeTransfer typeTransfersToTypeTransfer(TypeTransfers typeTransfers) {
        if ( typeTransfers == null ) {
            return null;
        }

        TypeTransfer typeTransfer;

        switch ( typeTransfers ) {
            case DEPOSITO: typeTransfer = TypeTransfer.DEPOSITO;
            break;
            case SAQUE: typeTransfer = TypeTransfer.SAQUE;
            break;
            case TRANSFERENCIA_ENTRADA: typeTransfer = TypeTransfer.TRANSFERENCIA_ENTRADA;
            break;
            case TRANSFERENCIA_SAIDA: typeTransfer = TypeTransfer.TRANSFERENCIA_SAIDA;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + typeTransfers );
        }

        return typeTransfer;
    }
}
