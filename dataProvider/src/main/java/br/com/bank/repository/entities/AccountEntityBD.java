package br.com.bank.repository.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "conta")
@Data
@NoArgsConstructor
@ToString(exclude = {"transfers"})
public class AccountEntityBD implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conta")
	private Long id;
	
	@Column(name = "nome_responsavel")
	private String nameUser;
	
	@Column(name = "saldo")
	private Double balance;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	private List<TransferEntityBD> transfers = new ArrayList<>();

	public AccountEntityBD(Long id, String nameUser, Double balance) {
		super();
		this.id = id;
		this.nameUser = nameUser;
		this.balance = balance;
	}
	

}
