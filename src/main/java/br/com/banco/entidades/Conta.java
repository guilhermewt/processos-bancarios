package br.com.banco.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
@ToString(exclude = {"transferencias"})
public class Conta implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conta")
	private Long id;
	
	@Column(name = "nome_responsavel")
	private String nomeResponsavel;
	private Double saldo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "conta", fetch = FetchType.LAZY)
	private List<Transferencia> transferencias = new ArrayList<>();

	public Conta(Long id, String nomeResponsavel, Double saldo) {
		super();
		this.id = id;
		this.nomeResponsavel = nomeResponsavel;
		this.saldo = saldo;
	}
	
}