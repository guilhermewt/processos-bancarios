package br.com.banco.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import br.com.banco.entidades.Transferencia;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class ObterTransferenciasDePesquisa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private BigDecimal saldoPeriodo;
	private List<Transferencia> transferencias;

}