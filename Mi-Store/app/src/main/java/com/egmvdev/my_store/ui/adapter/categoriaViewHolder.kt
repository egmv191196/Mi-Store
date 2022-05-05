package com.egmvdev.my_store.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.egmvdev.my_store.data.model.categoria
import com.egmvdev.my_store.databinding.ItemCategoriaBinding
import com.squareup.picasso.Picasso

class categoriaViewHolder(vista: View): RecyclerView.ViewHolder(vista){
    private val bind = ItemCategoriaBinding.bind(vista)
    fun bind(categoriaElemento: categoria){
        bind.tvName.text=categoriaElemento.nombre
        Picasso.get().load(categoriaElemento.foto).into(bind.ivCategoria)
    }
}