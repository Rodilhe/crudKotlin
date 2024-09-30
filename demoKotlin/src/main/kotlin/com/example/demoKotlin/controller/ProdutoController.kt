package com.example.demoKotlin.controller

import com.example.demoKotlin.model.Produto
import com.example.demoKotlin.service.ProdutoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/produtos")
class ProdutoController (private val produtoService: ProdutoService){
    @GetMapping
    fun listarTodos():ResponseEntity<List<Produto>> = ResponseEntity.ok(produtoService.listarTodos())

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<Produto> =
            produtoService.buscarPorId(id)?.let { ResponseEntity.ok(it) }
                    ?: ResponseEntity.notFound().build()
    @PostMapping
    fun salvar(@RequestBody produto: Produto): ResponseEntity<Produto>  =
            ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvar(produto))

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody produto: Produto): ResponseEntity<Produto> =
            produtoService.atualizar(id, produto)?.let { ResponseEntity.ok(it) }
                    ?: ResponseEntity.notFound().build();

    @DeleteMapping("/{id}")
    fun deleteProduto(@PathVariable id: Long): ResponseEntity<Void> {
        produtoService.deletar(id)
        return ResponseEntity.noContent().build()
    }

}