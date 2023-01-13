package com.attornatus.apipessoas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.attornatus.apipessoas.dto.EnderecoDto;
import com.attornatus.apipessoas.model.Endereco;
import com.attornatus.apipessoas.model.Pessoa;
import com.attornatus.apipessoas.repository.EnderecoRepository;
import com.attornatus.apipessoas.repository.PessoaRepository;

@Service
public class EnderecoService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;

	
	public ResponseEntity<List<Endereco>> listarEnderecos(Long idDaPessoa){
		
		try {
			
			Pessoa pessoa = pessoaRepository.findById(idDaPessoa).get();
			return ResponseEntity.ok(pessoa.getListaDeEnderecos());
			
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	public ResponseEntity<EnderecoDto> adicionarNovoEndereco(EnderecoDto enderecoDto, Long idDaPessoa){
		
		try {
			
			//Cria o endereco no banco de dados (endereco alternativo) e preenche o dto de retorno
			Endereco endereco = new Endereco();
			endereco.converterDtoEmModel(enderecoDto);
			enderecoRepository.save(endereco);
			enderecoDto.setId(endereco.getId());
			
			//Localiza a pessoa no banco de dados e atribui o endereco a ela
			Pessoa pessoa = pessoaRepository.findById(idDaPessoa).get();
			pessoa.getListaDeEnderecos().add(endereco);
			pessoaRepository.save(pessoa);
			
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(enderecoDto);
		}
		
		return ResponseEntity.ok(enderecoDto);
	}
	
	public ResponseEntity<List<Endereco>> alterarEnderecoComoPrincipal(Long idDaPessoa, Long idDoEndereco){
		
		try {
			
			Pessoa pessoa = pessoaRepository.findById(idDaPessoa).get();
			//Percorre lista e altera o endereco para principal (true), os demais mudam para false
			for(int i = 0; i < pessoa.getListaDeEnderecos().size(); i++) {
				
				Endereco endereco = pessoa.getListaDeEnderecos().get(i);
				
				if(endereco.getId() == idDoEndereco) {
					endereco.setEnderecoPrincipal(true);
				} else {
					endereco.setEnderecoPrincipal(false);
				}
			}
			return ResponseEntity.ok(pessoa.getListaDeEnderecos());
			
		} catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
