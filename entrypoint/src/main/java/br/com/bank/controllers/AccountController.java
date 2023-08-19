package br.com.bank.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bank.mappers.AccountMapper;
import br.com.bank.requests.AccountGetRequestBody;
import br.com.bank.useCase.AccountService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/conta")
@RequiredArgsConstructor
public class AccountController {

	private final AccountService accountService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<AccountGetRequestBody> obterContaPorId(@PathVariable Long id){
		return ResponseEntity.ok(AccountMapper.INSTANCE.toAccountGetRequestBody(accountService.findById(id)));
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<AccountGetRequestBody>> buscarTodos(){
		return ResponseEntity.ok(AccountMapper.INSTANCE.toListOfAccountGetRequestBody(accountService.findAll()));
	}
}
