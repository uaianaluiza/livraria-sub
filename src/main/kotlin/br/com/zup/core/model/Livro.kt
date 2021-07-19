package br.com.zup.core.model

import java.util.*

data class Livro (
    val id: UUID? = null,
    val nome: String = "",
    val nomeAutor: String = "",
    val anoDePublicacao: String = "",
        )