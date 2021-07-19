package br.com.zup.database

import io.micronaut.core.annotation.Introspected
import java.util.*

@Introspected
data class LivroEntity (
    val id: UUID? = null,
    val nome: String = "",
    val nomeAutor: String = "",
    val anoDePublicacao: String = "",
)