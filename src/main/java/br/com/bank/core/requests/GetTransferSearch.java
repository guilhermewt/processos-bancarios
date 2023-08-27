package br.com.bank.core.requests;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import br.com.bank.core.entities.Transfer;

public class GetTransferSearch{

	private BigDecimal periodBalance;
	private List<Transfer> transfers;

	public GetTransferSearch(BigDecimal periodBalance, List<Transfer> transfers) {
		super();
		this.periodBalance = periodBalance;
		this.transfers = transfers;
	}

	public BigDecimal getperiodBalance() {
		return periodBalance;
	}

	public void setperiodBalance(BigDecimal periodBalance) {
		this.periodBalance = periodBalance;
	}

	public List<Transfer> gettransfers() {
		return transfers;
	}

	public void settransfers(List<Transfer> transfers) {
		this.transfers = transfers;
	}

	@Override
	public String toString() {
		return "ObtertransfersDePesquisa [periodBalance=" + periodBalance + ", transfers=" + transfers
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(periodBalance, transfers);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GetTransferSearch other = (GetTransferSearch) obj;
		return Objects.equals(periodBalance, other.periodBalance) && Objects.equals(transfers, other.transfers);
	}

}
