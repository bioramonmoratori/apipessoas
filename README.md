<h1 align="center">
  API - Pessoas
</h1>

<p>
  API para o processo seletivo da empresa Attornatus.
</p>

## :hammer: Objetivos

- `Pessoa`: Cada Pessoa possui um nome, data de nascimento e endereço.
- `Funcionalidades`: API capaz de Listar, Cadastrar, Editar por ID e Consultar pessoas por ID.
----------------------------------------------------------------------------------------
- `Endereço`: Cada endereço possui um logradouro, número residencial, CEP, cidade e um valor boleano para marcar se o endereço da pessoa é o endereço principal
- `Funcionalidades`: API capaz de criar novo endereço por ID, listar endereços por ID e alterar endereço principal de uma pessoa

## Tecnologias Utilizadas

- Java [v.17]
- Spring (JPA, REST, Test) [v.2.7.6]
- Banco de Dados H2 e MariaDB
- Postman
- Maven [v.4.0.0]

## Endpoints

A URI principal onde estão reunidos todos os endpoints é **http://localhost:8080/**

### Pessoas:

- `POST`  "/cadastrarpessoa" : *Cadastrar pessoa* | JSON - Body Parameter:

```
{
    "nome":"Fulano",
    "nascimento":"1994-03-22",
    "listaDeEnderecos":[
      {
        "logradouro":"Bairro Limoeiro, Rua das Laranjeiras",
        "cep":"36067050",
        "numero":373,
        "cidade":"São Paulo"
      }
    ]
}
```

- `GET`  "/listarpessoas" : *Listar pessoas*:

- `GET`  "/consultarpessoaporid/{ID}" : *Consultar pessoa por ID*:
