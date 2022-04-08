package com.generation.benfazerproject.api

import com.generation.benfazerproject.modelo.Categoria
import com.generation.benfazerproject.modelo.Produto
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("categoria")
    suspend fun listCategoria(): Response<List<Categoria>>

    @POST("produtos")
    suspend fun addProduto(
    @Body produto: Produto
): Response<Produto>

    @GET("produtos")
    suspend fun listProduto(): Response<List<Produto>>

    @PUT("produtos")
    suspend fun updateProduto(
        @Body produto: Produto
    ): Response<Produto>

    @DELETE("produtos/{id}")
    suspend fun deleteProduto(
        @Path("id") valor: Long
    ): Response<Produto>


}
