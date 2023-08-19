package br.com.bank.requests;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import br.com.bank.entities.enums.TypeTransfers;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransferGetRequestBody implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private OffsetDateTime transferDate;

	private BigDecimal value;

	private TypeTransfers Type;

	private String operatorName;

	public TransferGetRequestBody(Long id, OffsetDateTime transferDate, BigDecimal value, TypeTransfers Type,
			String operatorName) {
		super();
		this.id = id;
		this.transferDate = transferDate;
		this.value = value;
		this.Type = Type;
		this.operatorName = operatorName;
	}

}
