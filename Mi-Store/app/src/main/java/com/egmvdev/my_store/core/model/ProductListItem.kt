package com.egmvdev.my_store.core.model

class ProductList (
    val results: List<ProductListItem>
)
data class ProductListItem(
    val id: Int,
    val title: String,
    val description: String,
    val images: List<String>,
    val price: Int,
    //val category: Category
)
data class Category(
    val id: Int,
    val image: String,
    val name: String
)



