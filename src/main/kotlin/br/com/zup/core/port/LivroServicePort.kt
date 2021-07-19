package br.com.zup.core.port

import br.com.zup.core.model.Livro
import java.util.*
import javax.inject.Singleton

@Singleton
interface LivroServicePort {
    fun create(livro: Livro): Livro
    fun getAll(): List<Livro>
    fun getById(id: UUID): Livro?
    fun delete(id: UUID)
    fun update(id: UUID, livro: Livro): Livro
}