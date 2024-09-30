package com.example.demoKotlin.repository

import com.example.demoKotlin.model.Produto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ProdutoRepository: JpaRepository<Produto, Long>