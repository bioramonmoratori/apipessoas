package com.attornatus.apipessoas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

import com.attornatus.apipessoas.dto.EnderecoDto;

@Entity
public class Endereco {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String logradouro;
	
	@NonNull
	private String cep;
	
	@NonNull
	private Integer numero;
	
	@NonNull
	private String cidade;
	
	private boolean isEnderecoPrincipal;
	
	
	//Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public boolean isEnderecoPrincipal() {
		return isEnderecoPrincipal;
	}

	public void setEnderecoPrincipal(boolean isEnderecoPrincipal) {
		this.isEnderecoPrincipal = isEnderecoPrincipal;
	}
	
	//-----
	public void converterDtoEmModel(EnderecoDto enderecoDto) {
		this.logradouro = enderecoDto.getLogradouro();
		this.cep = enderecoDto.getCep();
		this.numero = enderecoDto.getNumero();
		this.cidade = enderecoDto.getCidade();
		this.isEnderecoPrincipal = false;
	}
	
	
}
