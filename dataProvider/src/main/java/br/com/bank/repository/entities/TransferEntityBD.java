package br.com.bank.repository.entities;

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

import br.com.bank.repository.entities.enums.TypeTransfer;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "transferencia")
@Data
@ToString(exclude = {"account"})
@NoArgsConstructor
public class TransferEntityBD implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "data_transferencia")
	private OffsetDateTime transferDate;
	
	@Column(name = "valor")
	private BigDecimal value;
	
	@Column(name = "tipo")
	@Enumerated(EnumType.STRING)
	private TypeTransfer Type;
	
	@Column(name = "nome_operador_transacao")
	private String operatorName;
	
	
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name = "conta_id")
	private AccountEntityBD account;

	public TransferEntityBD(Long id, OffsetDateTime transferDate,BigDecimal value, TypeTransfer Type,
			String operatorName) {
		super();
		this.id = id;
		this.transferDate = transferDate;
		this.value = value;
		this.Type = Type;
		this.operatorName = operatorName;
	}

}
