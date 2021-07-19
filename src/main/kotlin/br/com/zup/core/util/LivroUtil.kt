package br.com.zup.core.util

import br.com.zup.core.model.Livro

class LivroUtil {
    companion object{
        fun nameValid(livro: Livro): Livro{
            if(livro.nome.isNullOrEmpty()){
                throw Exception("Nome inválido")
            }
            return livro
        }
    }
}