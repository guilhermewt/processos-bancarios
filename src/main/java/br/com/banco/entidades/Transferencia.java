package br.com.banco.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.banco.entidades.enums.TipoTransferencia;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transferencia")
@Data
@NoArgsConstructor
public class Transferencia implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "data_transferencia")
	private OffsetDateTime dataTransferencia;
	
	@Column(name = "valor")
	private BigDecimal valor;
	
	@Column(name = "tipo")
	@Enumerated(EnumType.STRING)
	private TipoTransferencia tipo;
	
	@Column(name = "nome_operador_transacao")
	private String nomeOperador;
	
	@JsonIgnore
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name = "conta_id")
	private Conta conta;

	public Transferencia(Long id, OffsetDateTime dataTransferencia, BigDecimal valor, TipoTransferencia tipo,
			String nomeOperador) {
		super();
		this.id = id;
		this.dataTransferencia = dataTransferencia;
		this.valor = valor;
		this.tipo = tipo;
		this.nomeOperador = nomeOperador;
	}
	
	
}
