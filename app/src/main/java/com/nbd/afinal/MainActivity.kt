package com.nbd.afinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.nbd.afinal.room.MainViewModel
import com.nbd.afinal.room.Wish
import org.json.JSONObject
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private val mainViewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val database= Firebase.database
        val myRef=database.reference

//        myRef.setValue("Hola Mundo 3")
//        myRef.child("usuarios").child("1").setValue(User("Ignacio","naarsee",4,239,115))
//        myRef.child("usuarios").child("2").setValue(User("Bere","killy",5,23,215))
//        myRef.child("usuarios").child("3").setValue(User("Yuni","yun909",4,39,159))

        //room
//        mainViewModel.saveWish(Wish(
//            "002",
//            "Ryzen 5 5600x",
//            6300.5,
//            "Procesador potente sin graficos incorporados",
//            3.6
//
//        ))
        //ver datos de room
        mainViewModel.getWishes()
        //fragment viewLifecycleOwner en vez de this
        mainViewModel.savedWishes.observe(this,{wishesLit ->
            if(!wishesLit.isNullOrEmpty()){
                for (wish in wishesLit){
                    Log.d("roomResponse", wish.product_name)
                }
            }else{
                Log.d("roomResponse","null or empty")
            }
        })
        //room

        val navView:BottomNavigationView=findViewById(R.id.bottomNavigationView)
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController=navHostFragment.navController
        navView.setupWithNavController(navController)

    }


}