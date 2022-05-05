package com.egmvdev.my_store.ui.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egmvdev.my_store.R
import com.egmvdev.my_store.core.model.ProductList
import com.egmvdev.my_store.core.model.ProductListItem


class AdapterProduct(private val product: List<ProductList>, val productId: (Int) -> Unit) :
    RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ProductViewHolder(inflater.inflate(R.layout.item_product, parent, false))
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(product[position])
        holder.itemView.setOnClickListener {
            productId(position)
        }

    }

    override fun getItemCount(): Int {
        return product.size
    }

}


