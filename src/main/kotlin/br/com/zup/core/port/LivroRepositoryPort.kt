package br.com.zup.core.port

import br.com.zup.core.model.Livro
import br.com.zup.database.entity.LivroEntity
import java.util.*
import javax.inject.Singleton

@Singleton
interface LivroRepositoryPort {
    fun create(livro:Livro): LivroEntity
    fun getAll(): List<Livro>
    fun getById(id: UUID): Livro?
    fun delete (id:UUID)
    fun update(id:UUID,livro: Livro): LivroEntity
}