package com.egmvdev.my_store.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.egmvdev.my_store.data.model.producto
import com.egmvdev.my_store.databinding.ItemCategoriaBinding
import com.squareup.picasso.Picasso

class productoViewHolder (vista: View): RecyclerView.ViewHolder(vista) {
    private val bind = ItemCategoriaBinding.bind(vista)
    fun bind(categoriaElemento: producto){
        bind.tvName.text=categoriaElemento.nombre
        Picasso.get().load(categoriaElemento.foto).into(bind.ivCategoria)
    }
}