package br.com.banco.controles;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.controles.util.FormatarDatas;
import br.com.banco.dtos.ObterTransferenciasDePesquisa;
import br.com.banco.servicos.TransferenciaServico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(path = "/api/transferencias")
@RequiredArgsConstructor
@Log4j2
public class TransferenciaControles {

	private final TransferenciaServico transferenciaServicos;
	
	@GetMapping(path = "/pesquisar")
	public ResponseEntity<ObterTransferenciasDePesquisa> obterTransferencias(
			@RequestParam Long numeroConta,
			@RequestParam(value = "dataInicio",required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
			@RequestParam(value = "dataFim", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim, 
			@RequestParam(value = "nomeOperador", required = false) String nomeOperador, Pageable pageable){

        OffsetDateTime inicioDateTime = FormatarDatas.formatarDataInicio(dataInicio);
        OffsetDateTime fimDateTime = FormatarDatas.formatarDataFim(dataFim);
            
        if(dataInicio != null && dataInicio.toString() == "") {
        	dataInicio = null;
        }
        
        if(dataFim != null && dataFim.toString() == "") {
        	dataFim = null;
        }
        
        if(nomeOperador != null && nomeOperador.toString() == "") {
        	nomeOperador = null;
        }
		return ResponseEntity.ok(transferenciaServicos.obterTransferencias(numeroConta, inicioDateTime, 
				fimDateTime, nomeOperador));
	}
}
