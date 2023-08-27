package br.com.bank.core.entities;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nameUser;
	private Double balance;

	public Account(Long id, String nameUser, Double balance) {
		super();
		this.id = id;
		this.nameUser = nameUser;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, id, nameUser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(balance, other.balance) && Objects.equals(id, other.id)
				&& Objects.equals(nameUser, other.nameUser);
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", nameUser=" + nameUser + ", balance=" + balance + "]";
	}

}
