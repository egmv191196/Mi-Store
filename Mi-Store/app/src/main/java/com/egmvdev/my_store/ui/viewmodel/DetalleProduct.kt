package com.egmvdev.my_store.ui.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.egmvdev.my_store.R
import com.squareup.picasso.Picasso
import com.egmvdev.my_store.core.inteface.ApiFake
import com.egmvdev.my_store.databinding.ActivityDetalleProductBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetalleProduct : AppCompatActivity() {
    private lateinit var binding: ActivityDetalleProductBinding

    private val BASE_URL = "https://api.escuelajs.co/api/v1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var id = intent.extras?.getSerializable("id") as String
        val list = id.split("v1/")[1]

       // obtenerProduct(list)
    }

    fun obtenerProduct(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit()
                .create(ApiFake::class.java)
                .getProducts("1","1")
            val infoProduct = call.body()
            runOnUiThread {
                if (call.isSuccessful){
//                    binding.tvtitle.text = infoProduct.toString()
//                    binding.tvDescript.text = infoProduct?.description
//                    binding.tvPrice.text = infoProduct?.price.toString()
//                    //Picasso.get().load(infoProduct?.list<images>).into(binding.ivProduct)

                } else {
                    Toast.makeText(
                        this@DetalleProduct,
                        "Ocurrio un error en la solicitud",
                        Toast.LENGTH_LONG).show()
                }
            }
        }

    }
    fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}