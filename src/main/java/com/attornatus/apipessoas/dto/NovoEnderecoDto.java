package com.attornatus.apipessoas.dto;

public class NovoEnderecoDto {
	
	private Long idDaPessoa;
	private EnderecoDto enderecoDto;
	
	//Getters e Setters
	public Long getIdDaPessoa() {
		return idDaPessoa;
	}
	public void setIdDaPessoa(Long idDaPessoa) {
		this.idDaPessoa = idDaPessoa;
	}
	public EnderecoDto getEnderecoDto() {
		return enderecoDto;
	}
	public void setEnderecoDto(EnderecoDto enderecoDto) {
		this.enderecoDto = enderecoDto;
	}
	
	
	
}
