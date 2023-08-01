package br.com.banco.controles.exceções;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.banco.servicos.exceções.ErrorPadrao;
import br.com.banco.servicos.exceções.FalhaNaRequisicao;

@ControllerAdvice
public class ManipuladorDeExcecao extends ResponseEntityExceptionHandler{
		
	@ExceptionHandler(FalhaNaRequisicao.class)
	public ResponseEntity<ErrorPadrao> errorPadrao(FalhaNaRequisicao bre){
		return new ResponseEntity<>(ErrorPadrao.builder()
				.timestamp(Instant.now())
				.status(HttpStatus.BAD_REQUEST.value())
				.title("bad Request Exception, check the documentation")
				.details(bre.getMessage())
				.developerMessage(bre.getClass().getName())
				.build(), HttpStatus.BAD_REQUEST);
	}
	
}
