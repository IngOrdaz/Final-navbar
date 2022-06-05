package com.nbd.afinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.nbd.afinal.databinding.FragmentHomeBinding
import com.nbd.afinal.databinding.FragmentProfileBinding
import org.json.JSONObject

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater)
        val database= Firebase.database
        val myRef=database.reference
//        myRef.child("usuarios").child("1").setValue(User("Ignacio","naarsee",4,239,115))
//        myRef.child("usuarios").child("2").setValue(User("Bere","killy",5,23,215))
//        myRef.child("usuarios").child("3").setValue(User("Yuni","yun909",4,39,159))
//        myRef.child("usuarios").child("4").setValue(User("Alex","naarsee",4,239,115))

        myRef.child("usuarios").child("2").get().addOnSuccessListener { response->
            Log.d("fireResponse",response.value.toString())
            val jsonObject=JSONObject(response.value.toString())
            binding.tvName.setText(jsonObject.getString("name"))
            binding.tvLevelNumber.setText(jsonObject.getString("level"))
            binding.tvPointNumber.setText(jsonObject.getString("points"))
            binding.tvUsername.setText(jsonObject.getString("username"))
            binding.tvPointNumberNext.setText(jsonObject.getString("nextLevelPoints"))


        }.addOnFailureListener{
            Log.e("fireResponse","error getting data")
        }

        return binding.root
    }

}