package br.com.bank.entrypoint.controllers;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bank.core.contracts.TransferServiceContract;
import br.com.bank.entrypoint.mappers.TransferMapper;
import br.com.bank.entrypoint.requests.TransferSearchGetRequestBody;
import br.com.bank.entrypoint.util.DateConfiguration;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/transfers")
@RequiredArgsConstructor
public class TransfersController {

	private final TransferServiceContract transfersService;
	
	@GetMapping(path = "/search")
	public ResponseEntity<TransferSearchGetRequestBody> getTransfers(
			@RequestParam Long accountNumber,
			@RequestParam(value = "startDate",required = false) 
				@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam(value = "endDate", required = false) 
				@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate, 
			@RequestParam(value = "operatorName", required = false) String operatorName, Pageable pageable){

        OffsetDateTime startDateTime = DateConfiguration.formatStartDate(startDate);
        OffsetDateTime endDateTime = DateConfiguration.formatEndDate(endDate);
            
        if(startDate != null && startDate.toString() == "") {
        	startDate = null;
        }
        
        if(endDate != null && endDate.toString() == "") {
        	endDate = null;
        }
        
        if(operatorName != null && operatorName.toString() == "") {
        	operatorName = null;
        }
        
		return ResponseEntity.ok(TransferMapper.INSTANCE.toTransferSearchGetRequestBody(transfersService.getTransfers(accountNumber, startDateTime, 
				endDateTime, operatorName)));
	}

}
