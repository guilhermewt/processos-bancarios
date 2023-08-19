package br.com.bank.requests;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountGetRequestBody implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nameUser;

	private Double balance;

	public AccountGetRequestBody(Long id, String nameUser, Double balance) {
		super();
		this.id = id;
		this.nameUser = nameUser;
		this.balance = balance;
	}

}
