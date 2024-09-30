Projeto simples em Kotlin

Utilizando SpringBoot e banco de dados Postgres

Este projeto expõe os seguintes endpoints:

GET /produtos: Lista todos os produtos.
GET /produtos/{id}: Retorna um produto específico.
POST /produtos: Cria um novo produto.
PUT /produtos/{id}: Atualiza um produto existente.
DELETE /produtos/{id}: Deleta um produto.


Testando o CRUD
Execute a aplicação e utilize uma ferramenta como Postman ou URL para fazer requisições:

Criar Produto (POST):
POST localhost:8080/produtos/produtos
{
  "nome": "Cadeira",
  "preco": 150.0,
  "quantidade": 10
}


Listar Produtos (GET):
GET localhost:8080/produtos/produtos


Atualizar Produto (PUT):
PUT localhost:8080/produtos/produtos/1
{
  "nome": "Cadeira de Escritório",
  "preco": 180.0,
  "quantidade": 5
}

Deletar Produto (DELETE):
DELETE localhost:8080/produtos/produtos/1
