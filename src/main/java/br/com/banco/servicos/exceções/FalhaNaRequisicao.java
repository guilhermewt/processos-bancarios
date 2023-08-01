package br.com.banco.servicos.exceções;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FalhaNaRequisicao extends RuntimeException{
	

	private static final long serialVersionUID = 1L;

	public FalhaNaRequisicao(String msg) {
		super(msg);
	}
}
