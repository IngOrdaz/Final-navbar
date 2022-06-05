package com.nbd.afinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val database= Firebase.database
        val myRef=database.reference
//        myRef.setValue("Hola Mundo 3")
//        myRef.child("usuarios").child("1").setValue(User("Ignacio","naarsee",4,239,115))
//        myRef.child("usuarios").child("2").setValue(User("Bere","killy",5,23,215))
//        myRef.child("usuarios").child("3").setValue(User("Yuni","yun909",4,39,159))

        val navView:BottomNavigationView=findViewById(R.id.bottomNavigationView)
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController=navHostFragment.navController
        navView.setupWithNavController(navController)
    }
}