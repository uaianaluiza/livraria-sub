package br.com.zup.core.mapper

import br.com.zup.core.model.Livro
import br.com.zup.database.entity.LivroEntity


class LivroConverter {
    companion object {
        fun toTransformlivroEntityToLivro(livroEntity: LivroEntity) =
            Livro(
                livroEntity.id,
                livroEntity.nome,
                livroEntity.nomeAutor,
                livroEntity.anoDePublicacao
            )
        fun livroToLivroEntity(livro: Livro) =
            LivroEntity(
                livro.id,
                livro.nome,
                livro.nomeAutor,
                livro.anoDePublicacao
            )

        fun livroEntitytoLivro(livroEntity: LivroEntity) =
            Livro(
                livroEntity.id,
                livroEntity.nome,
                livroEntity.nomeAutor,
                livroEntity.anoDePublicacao
            )
    }
}