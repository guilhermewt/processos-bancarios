package br.com.banco.servicos;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.banco.dtos.ObterTransferenciasDePesquisa;
import br.com.banco.entidades.Transferencia;
import br.com.banco.repositorios.TransferenciaRepositorio;
import br.com.banco.servicos.exceções.FalhaNaRequisicao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class TransferenciaServico {

	private final TransferenciaRepositorio transferenciaRepositorio;

	public List<Transferencia> findAll() {
		return transferenciaRepositorio.findAll();
	}
 
	public ObterTransferenciasDePesquisa obterTransferencias(Long numeroConta, OffsetDateTime dataInicio, OffsetDateTime dataFim,
			String nomeOperador) {

		List<Transferencia> listaTransferencia = consultarTransferenciasNoBanco(numeroConta, dataInicio, dataFim, nomeOperador);
		BigDecimal saldoNoPeriodo = calcularSaldoNoPeriodo(listaTransferencia);

		return ObterTransferenciasDePesquisa.builder().saldoPeriodo(saldoNoPeriodo)
				.transferencias(listaTransferencia).build();
	}
	
	public List<Transferencia> consultarTransferenciasNoBanco(Long numeroConta, OffsetDateTime dataInicio, OffsetDateTime dataFim,
			String nomeOperador) {
		
		List<Transferencia> transferencia = new ArrayList<>();
		if(numeroConta == null) {
			throw new FalhaNaRequisicao("número da conta vazio ou não encontrado!");
		}
		if (dataInicio == null && dataFim == null && nomeOperador == null) {
			transferencia =  transferenciaRepositorio.findByContaId(numeroConta);
		}

		if (dataInicio != null && dataFim != null && nomeOperador != null) {
			transferencia = transferenciaRepositorio.findByContaIdAndDataInicioAndDataFimAndNomeOperador(numeroConta, dataInicio,
					dataFim, nomeOperador);
		}
		
		if(dataInicio != null && dataFim == null && nomeOperador != null) {
			transferencia = transferenciaRepositorio.findByContaIdApartirDataInicioAndNomeOperador(numeroConta, dataInicio, nomeOperador);
		}

		if (dataInicio != null && dataFim != null && nomeOperador == null) {
			transferencia = transferenciaRepositorio.findByContaIdAndDataInicioAndDataFim(numeroConta, dataInicio, dataFim);
		}
		
		if (dataInicio != null && dataFim == null && nomeOperador == null) {
			transferencia = transferenciaRepositorio.findByContaIdApartirDataInicio(numeroConta, dataInicio);
		}
		
		if(dataFim != null && dataInicio == null && nomeOperador != null) {
			transferencia = transferenciaRepositorio.findByContaIdAteDataFimAndNomeOperador(numeroConta, dataFim, nomeOperador);
		}

		if(dataFim != null && dataInicio == null && nomeOperador == null) {
			transferencia = transferenciaRepositorio.findByContaIdAteDataFim(numeroConta, dataFim);
		}

		if (nomeOperador != null) {
			transferencia = transferenciaRepositorio.findByContaIdAndNomeOperador(numeroConta, nomeOperador);
		}
		
		return transferencia;

	}
	
	public BigDecimal calcularSaldoNoPeriodo(List<Transferencia> transferencias) {
		return transferencias.stream().map(x -> x.getValor()).reduce(BigDecimal.ZERO,(x,y) -> x.add(y));
	}
}
