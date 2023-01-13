package com.attornatus.apipessoas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attornatus.apipessoas.dto.AlterarEnderecoComoPrincipalDto;
import com.attornatus.apipessoas.dto.NovoEnderecoDto;
import com.attornatus.apipessoas.dto.PessoaDto;
import com.attornatus.apipessoas.service.EnderecoService;
import com.attornatus.apipessoas.service.PessoaService;

@RestController
@RequestMapping("/")
public class APIController {
	
	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	EnderecoService enderecoService;
	
	
	//PESSOA ----------------------
	
	@GetMapping("/listarpessoas")
    public ResponseEntity listarPessoas() {
		
		return pessoaService.listarPessoas();
	}
	
	@PostMapping("/cadastrarpessoa")
    public ResponseEntity cadastrarPessoa(@RequestBody PessoaDto pessoaDto) {
		
		return pessoaService.cadastrarPessoa(pessoaDto);
		
	}
	
	@GetMapping("/consultarpessoaporid/{idDaPessoa}")
    public ResponseEntity consultarPessoaPorId(@PathVariable Long idDaPessoa) {
		
		return pessoaService.consultarPessoaPorId(idDaPessoa);
	}
	
	@PostMapping("/editarpessoa/{idDaPessoa}")
    public ResponseEntity editarPessoa(@PathVariable Long idDaPessoa, @RequestBody PessoaDto pessoaDto) {
		
		return pessoaService.editarPessoa(idDaPessoa, pessoaDto);
		
	}
	
	//ENDERECO ----------------------
	
	@PostMapping("/novoendereco")
    public ResponseEntity adicionarNovoEndereco(@RequestBody NovoEnderecoDto novoEnderecoDto) {
		
		return enderecoService.adicionarNovoEndereco(novoEnderecoDto.getEnderecoDto(), novoEnderecoDto.getIdDaPessoa());
		
	}
	
	@GetMapping("/listarenderecos/{idDaPessoa}")
    public ResponseEntity listarEnderecos(@PathVariable Long idDaPessoa) {
		
		return enderecoService.listarEnderecos(idDaPessoa);
		
	}
	
	@PostMapping("/alterarenderecocomoprincipal")
    public ResponseEntity alterarEnderecoComoPrincipal(@RequestBody AlterarEnderecoComoPrincipalDto alterarEnderecoComoPrincipalDto) {
		
		return enderecoService.alterarEnderecoComoPrincipal(alterarEnderecoComoPrincipalDto.getIdDaPessoa(), alterarEnderecoComoPrincipalDto.getIdDoEndereco());
		
	}
}
