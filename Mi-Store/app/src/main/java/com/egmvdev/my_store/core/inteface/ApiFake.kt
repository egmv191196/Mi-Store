package com.egmvdev.my_store.core.inteface

import com.egmvdev.my_store.core.model.ProductListItem
import retrofit2.Response
import retrofit2.http.*

interface ApiFake {

//    @GET("products")
//    suspend fun getProducts(
//        @Query("limit") limit : Int,
//        @Query("offset") offset : Int) : Response<ProductListItem>

    @GET("products")
    suspend fun getProducts(@Query("offset")linmenor:String, @Query("limit")linmayor:String)  : Response <List<ProductListItem>>

}