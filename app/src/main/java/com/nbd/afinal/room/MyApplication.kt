package com.nbd.afinal.room

import android.app.Application

open class MyApplication :Application(){
    override fun onCreate(){
        DatabaseManager.instance.initializeDb(applicationContext)

        super.onCreate()
    }
}