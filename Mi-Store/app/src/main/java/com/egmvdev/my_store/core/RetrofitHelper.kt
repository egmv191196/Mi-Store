package com.egmvdev.my_store.core

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return  Retrofit
            .Builder()
            .baseUrl("http://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            //.client(obtenerCliente())
            .build()
    }
    fun obtenerCliente(): OkHttpClient = OkHttpClient
        .Builder()
        //.addInterceptor(APIInterceptor())
        .build()
}