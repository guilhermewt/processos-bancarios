package br.com.banco.controles;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.entidades.Conta;
import br.com.banco.servicos.ContaServico;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/conta")
@RequiredArgsConstructor
public class ContaControles {

	private final ContaServico contaServicos;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Conta> obterContaPorId(@PathVariable Long id){
		return ResponseEntity.ok(contaServicos.buscarPorId(id));
	}
	
	@GetMapping(path = "/todos")
	public ResponseEntity<List<Conta>> buscarTodos(){
		return ResponseEntity.ok(contaServicos.BuscarTodos());
	}
}
