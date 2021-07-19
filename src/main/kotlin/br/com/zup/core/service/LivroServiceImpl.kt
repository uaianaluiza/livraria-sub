package br.com.zup.core.service

import br.com.zup.core.mapper.LivroConverter
import br.com.zup.core.model.Livro
import br.com.zup.core.port.LivroRepositoryPort
import br.com.zup.core.port.LivroServicePort
import java.util.*
import javax.inject.Singleton

@Singleton
class LivroServiceImpl (private val livroRepository: LivroRepositoryPort) : LivroServicePort {

    override fun create(livro: Livro): Livro =
        LivroConverter.livroEntitytoLivro((livroRepository.create(livro)))

    override fun delete(id: UUID) = livroRepository.delete(id)

    override fun update(id: UUID, livro: Livro): Livro  =
        LivroConverter.livroEntitytoLivro(livroRepository.update(id,livro))

    override fun getAll(): List<Livro> =
       livroRepository.getAll()

    override fun getById(id: UUID): Livro? =
        livroRepository.getById(id)!!
}