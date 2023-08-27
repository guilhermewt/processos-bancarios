package br.com.bank.entrypoint.mappers;

import br.com.bank.core.entities.Transfer;
import br.com.bank.core.entities.enums.TypeTransfers;
import br.com.bank.core.requests.GetTransferSearch;
import br.com.bank.entrypoint.requests.TransferGetRequestBody;
import br.com.bank.entrypoint.requests.TransferSearchGetRequestBody;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
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
public class TransferMapperImpl extends TransferMapper {

    @Override
    public Transfer toTransfer(TransferGetRequestBody transferGetRequestBody) {
        if ( transferGetRequestBody == null ) {
            return null;
        }

        Long id = null;
        OffsetDateTime transferDate = null;
        BigDecimal value = null;
        TypeTransfers type = null;
        String operatorName = null;

        id = transferGetRequestBody.getId();
        transferDate = transferGetRequestBody.getTransferDate();
        value = transferGetRequestBody.getValue();
        type = transferGetRequestBody.getType();
        operatorName = transferGetRequestBody.getOperatorName();

        Transfer transfer = new Transfer( id, transferDate, value, type, operatorName );

        return transfer;
    }

    @Override
    public List<Transfer> toListOfTransfer(List<TransferGetRequestBody> transferGetRequestBody) {
        if ( transferGetRequestBody == null ) {
            return null;
        }

        List<Transfer> list = new ArrayList<Transfer>( transferGetRequestBody.size() );
        for ( TransferGetRequestBody transferGetRequestBody1 : transferGetRequestBody ) {
            list.add( toTransfer( transferGetRequestBody1 ) );
        }

        return list;
    }

    @Override
    public TransferGetRequestBody toTransferGetRequestBody(Transfer transfer) {
        if ( transfer == null ) {
            return null;
        }

        TransferGetRequestBody transferGetRequestBody = new TransferGetRequestBody();

        transferGetRequestBody.setId( transfer.getId() );
        transferGetRequestBody.setOperatorName( transfer.getOperatorName() );
        transferGetRequestBody.setTransferDate( transfer.getTransferDate() );
        transferGetRequestBody.setType( transfer.getType() );
        transferGetRequestBody.setValue( transfer.getValue() );

        return transferGetRequestBody;
    }

    @Override
    public List<TransferGetRequestBody> toListOfTransferGetRequestBody(List<Transfer> transfer) {
        if ( transfer == null ) {
            return null;
        }

        List<TransferGetRequestBody> list = new ArrayList<TransferGetRequestBody>( transfer.size() );
        for ( Transfer transfer1 : transfer ) {
            list.add( toTransferGetRequestBody( transfer1 ) );
        }

        return list;
    }

    @Override
    public TransferSearchGetRequestBody toTransferSearchGetRequestBody(GetTransferSearch transfer) {
        if ( transfer == null ) {
            return null;
        }

        TransferSearchGetRequestBody transferSearchGetRequestBody = new TransferSearchGetRequestBody();

        transferSearchGetRequestBody.setPeriodBalance( transfer.getperiodBalance() );
        transferSearchGetRequestBody.setTransfers( toListOfTransferGetRequestBody( transfer.gettransfers() ) );

        return transferSearchGetRequestBody;
    }
}
