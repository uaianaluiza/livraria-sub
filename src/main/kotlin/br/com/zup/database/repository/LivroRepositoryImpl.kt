package br.com.zup.database.repository

import br.com.zup.core.mapper.LivroConverter
import br.com.zup.core.model.Livro
import br.com.zup.core.port.LivroRepositoryPort
import br.com.zup.database.entity.LivroEntity
import br.com.zup.database.exception.LivroNotFoundException
import org.slf4j.LoggerFactory
import java.lang.RuntimeException
import java.util.*
import java.util.logging.Logger
import javax.inject.Singleton

@Singleton
class LivroRepositoryImpl (private val cqlSession: CqlSession) : LivroRepositoryPort {

    private val LOG: Logger = LoggerFactory.getLogger(LivroRepositoryPort::class.java)

    override fun create(livro: Livro): LivroEntity {
        cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "INSERT INTO livraria.Livros(id,nome,nomeAutor,anoDePublicacao) VALUES (?,?,?,?,)",
                    UUID.randomUUID(),
                    livro.nome,
                    livro.nomeAutor,
                    livro.anoDePublicacao
                )
        )
        LOG.info("livro saved {}")
        return LivroConverter.livroToLivroEntity(livro)
    }

    override fun getAll(): List<Livro> {
        val queryResult = cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "SELECT * FROM livraria.Livros",
                )
        )
        return queryResult.map { livro ->
            Livro(
                livro.getUuid("id")!!,
                livro.getString("nome")!!,
                livro.getString("nomeAutor")!!,
                livro.getString("anoDePublicacao")!!
            )
        }.toList()
    }

    override fun getById(id: UUID): Livro {
        try{
            val queryResult = cqlSession.execute(
                SimpleStatement
                    .newInstance(
                        "SELECT * FROM livraria.Livros WHERE id=?",
                        id
                    )
            )
            return queryResult.map { livro ->
                Livro(
                    livro.getUuid("id")!!,
                    livro.getString("nome")!!,
                    livro.getString("nomeAutor")!!,
                    livro.getString("anoDePublicacao")!!
                )
            }.single()
        }catch (e: RuntimeException){
            throw LivroNotFoundException()
        }
    }

}