package com.generation.benfazerproject.modelo

data class Produto(
    val id: Long,
    var nomeMarca: String,
    var descricao: String,
    var imagem: String,
    var quantidade: Int,
    var valor: Double,
    var categoria: Categoria
) {
}