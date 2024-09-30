package com.example.demoKotlin.service

import com.example.demoKotlin.model.Produto
import com.example.demoKotlin.repository.ProdutoRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
class ProdutoService (private val produtoRepository: ProdutoRepository){
    fun listarTodos(): List<Produto> = produtoRepository.findAll()

    fun buscarPorId(id: Long): Produto? = produtoRepository.findById(id).orElse(null)

    fun salvar(produto: Produto): Produto = produtoRepository.save(produto)

    fun atualizar(id: Long, produto: Produto): Produto? {
        val produtoExistente = produtoRepository.findById(id)
        return if (produtoExistente.isPresent) {
            val atualizado = produtoExistente.get().copy(
                    nome = produto.nome,
                    preco = produto.preco,
                    quantidade = produto.quantidade
            )
            produtoRepository.save(atualizado)
        } else {
            null
        }
    }

    fun deletar(id: Long) {
        produtoRepository.deleteById(id)
    }
}