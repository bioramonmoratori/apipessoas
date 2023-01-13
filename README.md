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

- `GET`  "/listarpessoas" : *Listar pessoas*

- `GET`  "/consultarpessoaporid/{ID}" : *Consultar pessoa por ID*

- `POST`  "/editarpessoa/{ID}" : *Editar pessoa por ID* | JSON - Body Parameter:

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

### Endereços:

- `GET`  "/listarenderecos/{ID}" : *Listar endereços passando ID de uma pessoa*

- `POST`  "/novoendereco" : *Cria um novo endereço para pessoa, usando ID. O endereço criado é automaticamente definido como 
  endereço alternativo* | JSON - Body Parameter:

```
{
    "enderecoDto":{
        "logradouro":"Bairro Limoeiro, Rua das Laranjeiras",
        "cep":"36067050",
        "numero":373,
        "cidade":"São Paulo"
    },
    "idDaPessoa":{ID}
}
```

- `POST`  "/alterarenderecocomoprincipal" : *Configura um endereço como principal de uma pessoa, usando os respectivos ID's* | JSON - Body Parameter:

```
{

    "idDaPessoa":{ID_PESSOA},
    "idDoEndereco":{ID_ENDERECO}

}
```
