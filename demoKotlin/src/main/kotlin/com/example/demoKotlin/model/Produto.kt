package com.example.demoKotlin.model

import jakarta.persistence.*

@Entity
data class Produto (
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       val id: Long = 0,
       var nome: String,
       var preco: Double,
       var quantidade: Int

)