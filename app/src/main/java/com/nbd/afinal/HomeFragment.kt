package com.nbd.afinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.nbd.afinal.databinding.FragmentHomeBinding
import com.nbd.afinal.room.MainViewModel
import com.nbd.afinal.room.Wish
import org.json.JSONObject
import java.util.Random

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var queue: RequestQueue

    override fun onCreateView(


        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(layoutInflater)


        //ROOM
//        mainViewModel.saveWish(
//            Wish(
//            "003",
//            "Ryzen 3 3200g",
//            2100.5,
//            "Procesador potente con graficos incorporados",
//            3.6
//
//       )
//       )


        //save room
        var calAlea=Random()
        binding.btnWish.setOnClickListener {

            var cal=calAlea.nextInt(4)*1.1;

            mainViewModel.saveWish(Wish(
//                id,
//                product_name,
//                product_price,
//                product_description,
//                product_cal
                binding.etSearch.text.toString(),
                binding.tvName.text.toString(),
                binding.tvPrice.text.toString().toDouble(),
                binding.tvDescription.text.toString(),
                cal
            ))
        }

        //show room
        mainViewModel.getWishes()
        //fragment viewLifecycleOwner en vez de this
        mainViewModel.savedWishes.observe(viewLifecycleOwner,{wishesLit ->
            if(!wishesLit.isNullOrEmpty()){
                for (wish in wishesLit){
                    Log.d("roomResponse", wish.product_name)
                }
            }else{
                Log.d("roomResponse","null or empty")
            }
        })


        //ROOM

        //Volley

        queue= Volley.newRequestQueue(context)




        //Volley

        //recep´cion de parametro para busqueda
        binding.btnSearch.setOnClickListener {
            var numberId=binding.etSearch.text.toString().toInt()
            getProductInfo(numberId)
        }
        val navController=findNavController()
        val destination=HomeFragmentDirections.actionHomeFragmentToProfileFragment( )
        return binding.root
    }
    fun getProductInfo(numberId:Int){


        Log.i("storeResponse", numberId.toString())
        val url="https://fakestoreapi.com/products/${numberId}"

        val jsonRequest=JsonObjectRequest(url, Response.Listener<JSONObject>{ response ->
            Log.i("storeResponse", response.toString())
            binding.tvName.setText(response.getString("title"))
            binding.tvPrice.setText(response.getString("price"))
            binding.tvDescription.setText(response.getString("description"))
        },
        Response.ErrorListener { error ->
            Log.w("storeResponse", error.message as String)
        }
            )
        queue.add(jsonRequest)
    }

}