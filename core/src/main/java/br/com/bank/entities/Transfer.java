package br.com.bank.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

import br.com.bank.entities.enums.TypeTransfers;

public class Transfer implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private OffsetDateTime transferDate;

	private BigDecimal value;

	private TypeTransfers type;

	private String operatorName;

	private Account account;

	public Transfer(Long id, OffsetDateTime transferDate, BigDecimal value, TypeTransfers type,
			String operatorName) {
		super();
		this.id = id;
		this.transferDate = transferDate;
		this.value = value;
		this.type = type;
		this.operatorName = operatorName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(OffsetDateTime transferDate) {
		this.transferDate = transferDate;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public TypeTransfers getType() {
		return type;
	}

	public void setType(TypeTransfers type) {
		this.type = type;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, operatorName, transferDate, type, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transfer other = (Transfer) obj;
		return Objects.equals(id, other.id) && Objects.equals(operatorName, other.operatorName)
				&& Objects.equals(transferDate, other.transferDate) && type == other.type
				&& Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "Transfer [id=" + id + ", transferDate=" + transferDate + ", value=" + value + ", type=" + type
				+ ", operatorName=" + operatorName + "]";
	}

}
