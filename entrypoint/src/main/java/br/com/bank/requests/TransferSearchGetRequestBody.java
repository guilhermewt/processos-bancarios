package br.com.bank.requests;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransferSearchGetRequestBody implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private BigDecimal periodBalance;
	private List<TransferGetRequestBody> transfers;
}
