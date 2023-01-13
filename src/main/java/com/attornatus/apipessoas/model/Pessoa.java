package com.attornatus.apipessoas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.lang.NonNull;

import com.attornatus.apipessoas.dto.PessoaDto;

@Entity
public class Pessoa {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String nome;
	
	@NonNull
	private LocalDate nascimento;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Endereco> listaDeEnderecos = new ArrayList<>();
	
	//Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public List<Endereco> getListaDeEnderecos() {
		return listaDeEnderecos;
	}

	public void setListaDeEnderecos(List<Endereco> listaDeEnderecos) {
		this.listaDeEnderecos = listaDeEnderecos;
	}
	
	//----
	public void converterDtoEmModel(PessoaDto pessoaDto) {
		this.nome = pessoaDto.getNome();
		this.nascimento = pessoaDto.getNascimento();
		this.listaDeEnderecos = pessoaDto.getListaDeEnderecos();
	}
	
}
