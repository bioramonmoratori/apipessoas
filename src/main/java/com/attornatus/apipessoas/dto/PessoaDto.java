package com.attornatus.apipessoas.dto;

import java.time.LocalDate;
import java.util.List;

import com.attornatus.apipessoas.model.Endereco;
import com.attornatus.apipessoas.model.Pessoa;

public class PessoaDto {
	
	private Long id;
	private String nome;
	private LocalDate nascimento;
	private List<Endereco> listaDeEnderecos;
	
	
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
	
	//-----
	public void converterModelEmDto(Pessoa pessoa) {
		
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.nascimento = pessoa.getNascimento();
		this.listaDeEnderecos = pessoa.getListaDeEnderecos();
	}
}
