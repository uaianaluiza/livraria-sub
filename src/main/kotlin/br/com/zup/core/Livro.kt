package br.com.zup.core

import java.util.*

data class Livro (
    val id: UUID? = null,
    val nome: String = "",
    val nomeAutor: String = "",
    val anoDePublicacao: String = "",
        )