package com.attornatus.apipessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attornatus.apipessoas.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
