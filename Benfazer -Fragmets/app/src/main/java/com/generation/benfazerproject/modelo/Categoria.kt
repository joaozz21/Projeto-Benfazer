package com.generation.benfazerproject.modelo

data class Categoria(
    var id: Long,
    var descricao: String?,
    var produtos: List<Produto>?
){
    override fun toString(): String {
        return descricao!!
    }
}