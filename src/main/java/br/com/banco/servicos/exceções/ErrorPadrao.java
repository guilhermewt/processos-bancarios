package br.com.banco.servicos.exceções;

import java.io.Serializable;
import java.time.Instant;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorPadrao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected Instant timestamp;
	protected Integer status;
	protected String title;
	protected String details;
	protected String developerMessage;

}
