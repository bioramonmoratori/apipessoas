package com.attornatus.apipessoas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.attornatus.apipessoas.dto.PessoaDto;
import com.attornatus.apipessoas.model.Pessoa;
import com.attornatus.apipessoas.repository.EnderecoRepository;
import com.attornatus.apipessoas.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	
	public ResponseEntity<List<Pessoa>> listarPessoas(){
		
		try {
			
			return ResponseEntity.ok(pessoaRepository.findAll());
			
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	public ResponseEntity<PessoaDto> consultarPessoaPorId(Long idDaPessoa) {
		
		try {
			
			PessoaDto pessoaDto = new PessoaDto();
			Pessoa pessoa = pessoaRepository.findById(idDaPessoa).get();
			pessoaDto.converterModelEmDto(pessoa);
			
			return ResponseEntity.ok(pessoaDto);
			
		} catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	public ResponseEntity<PessoaDto> cadastrarPessoa(PessoaDto pessoaDto) {
		
		try {
			
			//Salvando no banco de dados e devolvendo um DTO completo
			Pessoa pessoa = new Pessoa();
			pessoa.converterDtoEmModel(pessoaDto);
			pessoaRepository.save(pessoa);
			pessoaDto.setId(pessoa.getId());
			
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(pessoaDto);
		}
		
		return ResponseEntity.ok(pessoaDto);
	}
	
	public ResponseEntity<PessoaDto> editarPessoa(Long idDaPessoa, PessoaDto pessoaDto) {
		
		try {
			
			Pessoa pessoa = pessoaRepository.findById(idDaPessoa).get();
			pessoa.converterDtoEmModel(pessoaDto);
			pessoaRepository.save(pessoa);
			pessoaDto.setId(pessoa.getId());
			
			return ResponseEntity.ok(pessoaDto);
			
		} catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	

}
