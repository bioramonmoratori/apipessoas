package com.attornatus.apipessoas.controllerTest;

import java.net.URI;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.attornatus.apipessoas.model.Endereco;
import com.attornatus.apipessoas.model.Pessoa;
import com.attornatus.apipessoas.repository.PessoaRepository;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@SpringBootTest
public class PessoasApiControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	@Test
	@Order(1)
	public void deveReceberCodigo200ParaRequisicaoDeCadastroDePessoa() throws Exception {
		
		URI uri = new URI("/cadastrarpessoa");
		String json = "{\"nome\":\"Fulano\","
						+ "\"nascimento\":\"1994-03-22\","
						+ "\"listaDeEnderecos\":["
							+ "{"
								+ "\"logradouro\":\"Bairro Copacabana, Rua da Praia\","
								+ "\"cep\":\"36050010\","
								+ "\"numero\":305,"
								+ "\"cidade\":\"Rio de Janeiro\""
							+ "}"
						+ "]"
						+ "}";
		
		mockMvc.perform(MockMvcRequestBuilders.post(uri)
		        .content(json)
		        .contentType(MediaType.APPLICATION_JSON))
		        .andExpect(MockMvcResultMatchers.status().is(200));
		
		
	}
	
	@Test
	@Order(2)
	public void deveReceberCodigo200ParaRequisicaoDeCadastroDePessoaQueSeraEditada() throws Exception {
		
		URI uri = new URI("/cadastrarpessoa");
		String json = "{\"nome\":\"Beltrano\","
						+ "\"nascimento\":\"1994-03-22\","
						+ "\"listaDeEnderecos\":["
							+ "{"
								+ "\"logradouro\":\"Bairro Copacabana, Rua da Praia\","
								+ "\"cep\":\"36050010\","
								+ "\"numero\":305,"
								+ "\"cidade\":\"Rio de Janeiro\""
							+ "}"
						+ "]"
						+ "}";
		
		mockMvc.perform(MockMvcRequestBuilders.post(uri)
		        .content(json)
		        .contentType(MediaType.APPLICATION_JSON))
		        .andExpect(MockMvcResultMatchers.status().is(200));
		
		
	}
	
	@Test
	@Order(3)
	public void deveReceberCodigo200ParaRequisicaoDaListaDePessoas() throws Exception {
		
		URI uri = new URI("/listarpessoas");
		
		mockMvc.perform(MockMvcRequestBuilders.get(uri)).andExpect(
				MockMvcResultMatchers.status().is(200));
		
	}
	
	@Test
	@Order(4)
	public void deveReceberCodigo200ParaRequisicaoDeConsultaDePessoaPorId() throws Exception {
		
		//Pegando primeira pessoa e buscando por id
		Pessoa pessoa = pessoaRepository.findAll().get(0);
		
		Integer idDaPessoa = pessoa.getId().intValue();
		String consultaURI = "/consultarpessoaporid/"+idDaPessoa;
		
		URI uri = new URI(consultaURI);
		
		mockMvc.perform(MockMvcRequestBuilders.get(uri)).andExpect(
				MockMvcResultMatchers.status().is(200));
		
	}
	
	@Test
	@Order(5)
	public void deveReceberCodigo200ParaRequisicaoDeEdicaoDePessoa() throws Exception {
		
		URI uri = new URI("/editarpessoa/2");
		String json = "{\"nome\":\"Beltrano\","
						+ "\"nascimento\":\"1994-03-22\","
						+ "\"listaDeEnderecos\":["
							+ "{"
								+ "\"logradouro\":\"Bairro dos Mexilhoes, Rua da Praia\","
								+ "\"cep\":\"36050010\","
								+ "\"numero\":305,"
								+ "\"cidade\":\"Rio de Janeiro\""
							+ "}"
						+ "]"
						+ "}";
		
		mockMvc.perform(MockMvcRequestBuilders.post(uri)
		        .content(json)
		        .contentType(MediaType.APPLICATION_JSON))
		        .andExpect(MockMvcResultMatchers.status().is(200));
		
		
	}
	
	
	@Test
	@Order(6)
	public void deveReceberCodigo200ParaRequisicaoDaListaDeEnderecos() throws Exception {
		
		URI uri = new URI("/listarenderecos/1");
		
		
		mockMvc.perform(MockMvcRequestBuilders.get(uri)).andExpect(
				MockMvcResultMatchers.status().is(200));
		
	}
	
	@Test
	@Order(7)
	public void deveReceberCodigo200ParaRequisicaoDeNovoEndereco() throws Exception {
		
		URI uri = new URI("/novoendereco");
		String json = "{\"enderecoDto\":{"
							+ "\"logradouro\":\"Bairro Morumbi, Rua São Paulo\","
							+ "\"cep\":\"36005030\","
							+ "\"numero\":342,"
							+ "\"cidade\":\"São Paulo\""
						+ "},"
						+ "\"idDaPessoa\":1"
						+ "}";
		
		mockMvc.perform(MockMvcRequestBuilders.post(uri)
		        .content(json)
		        .contentType(MediaType.APPLICATION_JSON))
		        .andExpect(MockMvcResultMatchers.status().is(200));
		
		
	}
	
	@Test
	@Order(8)
	public void deveReceberCodigo200ParaRequisicaoDeAlterarEnderecoParaPrincipal() throws Exception {
		
		//Pegando primeiro endereco da pessoa e alterando para principal
		Pessoa pessoa = pessoaRepository.findAll().get(0);
		List<Endereco> listaDeEnderecos = pessoa.getListaDeEnderecos();
		
		Integer idDoEndereco = listaDeEnderecos.get(0).getId().intValue();
		
		
		URI uri = new URI("/alterarenderecocomoprincipal");
		String json = "{\"idDaPessoa\":1,"
						+ "\"idDoEndereco\":"+ idDoEndereco
						+ "}";
		
		mockMvc.perform(MockMvcRequestBuilders.post(uri)
		        .content(json)
		        .contentType(MediaType.APPLICATION_JSON))
		        .andExpect(MockMvcResultMatchers.status().is(200));
		
		
	}
	
}
