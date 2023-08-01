package br.com.banco.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.banco.entidades.Conta;
import br.com.banco.repositorios.ContaRepositorio;
import br.com.banco.servicos.exceções.FalhaNaRequisicao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class ContaServico {

	private final ContaRepositorio contaRepositorio;

	public Conta buscarPorId(Long id) {
		return contaRepositorio.findById(id).orElseThrow(() -> new FalhaNaRequisicao("conta nao encontrada"));
	}
	
	public List<Conta> BuscarTodos() {
		return contaRepositorio.findAll();
	}
}
