package com.egmvdev.my_store.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egmvdev.my_store.R
import com.egmvdev.my_store.data.model.categoria

class categoriaAdapter (val categoria: List<categoria>):RecyclerView.Adapter<categoriaViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): categoriaViewHolder {
        val inflador = LayoutInflater.from(parent.context)
        return categoriaViewHolder(inflador.inflate(R.layout.item_categoria,parent,false))
    }

    override fun onBindViewHolder(holder: categoriaViewHolder, position: Int) {
        holder.bind(categoria[position])
    }

    override fun getItemCount(): Int = categoria.size

}