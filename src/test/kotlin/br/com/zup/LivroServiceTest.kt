package br.com.zup

import br.com.zup.core.model.Livro
import br.com.zup.core.port.LivroRepositoryPort
import br.com.zup.core.service.LivroServiceImpl
import br.com.zup.database.entity.LivroEntity
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class LivroServiceTest : AnnotationSpec() {

    val repository = mockk<LivroRepositoryPort>(relaxed = true)
    val livroService = LivroServiceImpl(repository)
    lateinit var livro : LivroEntity
    lateinit var livroModel : Livro
    val id : UUID = UUID.fromString("80c2cd3e-e961-11eb-9a03-0242ac130003")

    @BeforeEach
    fun setUp(){
        livro = LivroEntity(id,"O MAPA PARA ACUMULAR 1 MILHÃO DE MILHAS","Rodriogo Goes","2020")
        livroModel = Livro(id,"O MAPA PARA ACUMULAR 1 MILHÃO DE MILHAS","Rodriogo Goes","2020")
    }

    @Test
    fun `should save livro`(){
        every {repository.create(any())} answers {livro}
        val result = livroService.create(livroModel)
        result shouldBe livroModel
    }
}