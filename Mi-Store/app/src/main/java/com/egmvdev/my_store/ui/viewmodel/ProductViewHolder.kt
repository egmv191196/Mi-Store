package com.egmvdev.my_store.ui.viewmodel

import android.view.View
import androidx.recyclerview.widget.ItemTouchUIUtil
import androidx.recyclerview.widget.RecyclerView
import com.egmvdev.my_store.core.model.ProductList
import com.egmvdev.my_store.databinding.ItemProductBinding

class ProductViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val binding = ItemProductBinding.bind(view)
    fun bind(product: ProductList){
        binding.tvProduct.text
    }

}