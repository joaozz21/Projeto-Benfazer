package com.generation.benfazerproject.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.generation.benfazerproject.MainViewModel
import com.generation.benfazerproject.R
import com.generation.benfazerproject.modelo.Produto

class Adapter(
    private val taskItemClickListener: TaskItemClickListener,
    private val mainViewModel: MainViewModel,
    private val context: Context?


) : RecyclerView.Adapter<Adapter.ProdutoViewHolder>() {
    private var listProduto = emptyList<Produto>()

    // Referenciando o Card Layout
    class ProdutoViewHolder(View: View) : RecyclerView.ViewHolder(View) {
        val textProd = View.findViewById<TextView>(R.id.textProd)
        val textQuant = View.findViewById<TextView>(R.id.textQuant)
        val textDesc = View.findViewById<TextView>(R.id.textDesc)
        val textValor = View.findViewById<TextView>(R.id.textValor)
        val textCategoria = View.findViewById<TextView>(R.id.textCategoria)
        val Image = View.findViewById<ImageView>(R.id.ImageOng)
        val DelButton = View.findViewById<ImageButton>(R.id.DelButton)
        val editButton = View.findViewById<ImageButton>(R.id.editButton)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)

        return ProdutoViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = listProduto[position]
        holder.textProd.text = produto.nomeMarca
        holder.textDesc.text = produto.descricao
        holder.textValor.text = "R$ ${"%.2f".format(listProduto[position].valor)}"
        holder.textQuant.text = "Qt: "+produto.quantidade.toString()
        holder.textCategoria.text = produto.categoria.descricao

        // Inserindo Link da Imagem
        Glide.with(context!!)
            .load(produto.imagem)
            .placeholder(android.R.drawable.ic_menu_report_image)
            .into(holder.Image)

        // O Button de editar
        holder.editButton.setOnClickListener {
            taskItemClickListener.onTaskClicked(produto)
        }
        //  O Button deletar
        holder.DelButton.setOnClickListener {
            deleteShow(produto.id)
        }

    }


    override fun getItemCount(): Int {
        return listProduto.size
    }

    fun setList(lista: List<Produto>) {
        listProduto = lista
        notifyDataSetChanged()
    }

    fun deleteShow(id: Long) {

        val builder = AlertDialog.Builder(context)
        builder.setTitle("Excluir")
        builder.setMessage("Deseja excluir o registro?")
        builder.setPositiveButton("Sim") { dialogInterface: DialogInterface, i: Int ->
            mainViewModel.deleteProduto(id)
        }
        builder.setNegativeButton("Não") { _dialogInterface: DialogInterface, i: Int ->
        }
        builder.show()

    }


}

