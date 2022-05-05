package com.egmvdev.my_store.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.egmvdev.my_store.core.inteface.ApiFake
import com.egmvdev.my_store.core.model.ProductList
import com.egmvdev.my_store.databinding.ActivityProductListBinding
import com.egmvdev.my_store.ui.viewmodel.AdapterProduct
import com.egmvdev.my_store.ui.viewmodel.DetalleProduct
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ProductListActivity : AppCompatActivity() {
    private val BASE_URL ="https://api.escuelajs.co/api/v1"
    private lateinit var binding: ActivityProductListBinding
    private lateinit var adaptador: AdapterProduct
    private var contador = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getProduct(1)
        binding.btAnt.setOnClickListener{
            if (contador > 0){
                contador -=10
                getProduct(contador)
            }
        }
        binding.btSig.setOnClickListener{
            contador +=10
            getProduct(contador)
        }
    }

    fun getProduct(contador: Int){
        CoroutineScope(Dispatchers.IO).launch {
            val llamada = getRetrofit()
                .create(ApiFake::class.java)
                .getProducts("0", "10")
            val infoProduct = llamada.body()
            runOnUiThread{
                if (llamada.isSuccessful){
                   // adaptador = AdapterProduct((infoProduct?.title ?: listOf<ProductList>()) as List<ProductList>){
                       // val intent = Intent(this@ProductListActivity, DetalleProduct::class.java)
                   // Log.i("productos",infoProduct.toString())
                    infoProduct?.forEach {
                        Log.i("productos",it.title)
                    }

                    }
                    }
            }

        }

    fun getRetrofit () : Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://api.escuelajs.co/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
