package br.com.zup.infraestructure

import br.com.zup.core.model.Livro
import br.com.zup.core.service.LivroServiceImpl
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject
import org.slf4j.LoggerFactory

@NatsListener
class LivroListener(private val livroServiceImpl: LivroServiceImpl) {
    private val logger = LoggerFactory.getLogger(LivroListener::class.java)

    @Subject("livros")
    fun receive(livro:Livro){
        livroServiceImpl.create(livro)
        logger.info("message received")
        println("Got livro - $livro")
    }
}