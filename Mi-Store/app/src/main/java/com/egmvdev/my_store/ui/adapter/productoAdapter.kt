package com.egmvdev.my_store.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egmvdev.my_store.R
import com.egmvdev.my_store.data.model.producto

class productoAdapter (val productos: List<producto>): RecyclerView.Adapter<productoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): productoViewHolder {
        val inflador = LayoutInflater.from(parent.context)
        return productoViewHolder(inflador.inflate(R.layout.item_categoria,parent,false))
    }

    override fun onBindViewHolder(holder: productoViewHolder, position: Int) {
        holder.bind(productos[position])
    }

    override fun getItemCount(): Int = productos.size

}