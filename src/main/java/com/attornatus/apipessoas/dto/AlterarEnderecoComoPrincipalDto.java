package com.attornatus.apipessoas.dto;

public class AlterarEnderecoComoPrincipalDto {
	
	private Long idDaPessoa;
	private Long idDoEndereco;

	
	//Getters e Setters
	public Long getIdDaPessoa() {
		return idDaPessoa;
	}
	public void setIdDaPessoa(Long idDaPessoa) {
		this.idDaPessoa = idDaPessoa;
	}
	public Long getIdDoEndereco() {
		return idDoEndereco;
	}
	public void setIdDoEndereco(Long idDoEndereco) {
		this.idDoEndereco = idDoEndereco;
	}
}
