package com.egmvdev.my_store.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.egmvdev.my_store.data.model.categoria
import com.egmvdev.my_store.data.model.producto
import com.egmvdev.my_store.databinding.FragmentHomeBinding
import com.egmvdev.my_store.ui.adapter.categoriaAdapter
import com.egmvdev.my_store.ui.adapter.productoAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private  lateinit var categoriaAdaptador: categoriaAdapter
    private  lateinit var productoAdaptador: productoAdapter
    private val listaCategoria = mutableListOf<categoria>()
    private val listaProducto = mutableListOf<producto>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //val homeViewModel =
          //  ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        iniciarRecyclerView()
        llenarArreglo()
        /*val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun iniciarRecyclerView(){
        categoriaAdaptador= categoriaAdapter(listaCategoria)
        binding.rvCategorias.layoutManager = GridLayoutManager(requireContext(),3)
        binding.rvCategorias.adapter = categoriaAdaptador
        //Adapter de producto
        productoAdaptador= productoAdapter(listaProducto)
        binding.rvProductos.layoutManager = GridLayoutManager(requireContext(),2)
        binding.rvProductos.adapter = productoAdaptador
    }
    fun llenarArreglo(){
        listaProducto.clear()
        listaCategoria.clear()
        listaCategoria.add(categoria(0,"Ropa","https://placeimg.com/640/480/any"))
        listaCategoria.add(categoria(1,"Comida","https://api.escuelajs.co/api/v1/files/9807.jpg"))
        listaCategoria.add(categoria(2,"Celular","https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-13-pro-graphite-select?wid=940&hei=1112&fmt=png-alpha&.v=1645552346276"))
        listaCategoria.add(categoria(3,"Ropa","https://placeimg.com/640/480/any"))
        listaCategoria.add(categoria(4,"Ropa","https://placeimg.com/640/480/any"))
        listaCategoria.add(categoria(5,"Ropa","https://placeimg.com/640/480/any"))
        categoriaAdaptador.notifyDataSetChanged()
        listaProducto.add(producto(0,"Ropa","https://placeimg.com/640/480/any"))
        listaProducto.add(producto(1,"Comida","https://api.escuelajs.co/api/v1/files/9807.jpg"))
        listaProducto.add(producto(2,"Celular","https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-13-pro-graphite-select?wid=940&hei=1112&fmt=png-alpha&.v=1645552346276"))
        listaProducto.add(producto(3,"Ropa","https://placeimg.com/640/480/any"))
        listaProducto.add(producto(4,"Ropa","https://placeimg.com/640/480/any"))
        listaProducto.add(producto(5,"Ropa","https://placeimg.com/640/480/any"))
        productoAdaptador.notifyDataSetChanged()
    }
}