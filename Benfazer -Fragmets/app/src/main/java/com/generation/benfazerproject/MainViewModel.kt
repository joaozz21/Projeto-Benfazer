package com.generation.benfazerproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.benfazerproject.modelo.Categoria
import com.generation.benfazerproject.modelo.Produto
import com.generation.benfazerproject.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
    ): ViewModel() {

    var produtoSelecionado : Produto? = null

    private val _myCategoriaResponse =
        MutableLiveData<Response<List<Categoria>>>()

    val myCategoriaResponse: LiveData<Response<List<Categoria>>> =
        _myCategoriaResponse

    private val _myProdutoResponse =
        MutableLiveData<Response<List<Produto>>>()

    val myProdutoResponse : LiveData<Response<List<Produto>>> =
        _myProdutoResponse

    init {
        listCategoria()
    }

    fun listCategoria() {
        viewModelScope.launch {
            try {
                val response = repository.listCategoria()
                _myCategoriaResponse.value = response
            } catch (e: Exception) {
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun addProduto(produto: Produto){
        viewModelScope.launch {
            try {
                repository.addProduto(produto)
                listProduto()
            }catch (e: Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun listProduto() {
        viewModelScope.launch {
            try {
                val response = repository.listProduto()
                _myProdutoResponse.value = response
            } catch (e: Exception) {
                Log.e("develop","erro",e)
            }
        }
    }

    fun updateProduto(produto: Produto){
        viewModelScope.launch {
            try {
                repository.updateProduto(produto)
                listProduto()
            }catch (e: Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun deleteProduto(id: Long){
        viewModelScope.launch {
            try {
                repository.deleteProduto(id)
                listProduto()
            }catch (e: Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }
}
