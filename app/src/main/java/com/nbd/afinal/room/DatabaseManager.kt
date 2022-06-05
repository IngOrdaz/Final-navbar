package com.nbd.afinal.room

import android.content.Context
import androidx.room.Room

class DatabaseManager {
    lateinit var database:AppDatabase

    fun initializeDb(context: Context){
        createDb(context)
    }
    private fun createDb(context :Context){
        database= Room.databaseBuilder(context,AppDatabase::class.java, DATABASE_NAME).build()
    }
}