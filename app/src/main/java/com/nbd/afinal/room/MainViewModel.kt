package com.nbd.afinal.room

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.nbd.afinal.room.DatabaseManager
import com.nbd.afinal.room.MyCoroutines
import com.nbd.afinal.room.Wish

class MainViewModel:ViewModel() {
    fun saveWish(wish: Wish){
        viewModelScope.launch {
            val wishDao=DatabaseManager.instance.database.wishDao()
            MyCoroutines(wishDao).save(wish)
        }
    }

    fun deleteWish(wish: Wish){
        viewModelScope.launch {
            val wishDao=DatabaseManager.instance.database.wishDao()
            MyCoroutines(wishDao).delete(wish)
        }
    }
    val savedWishes=MutableLiveData<List<Wish>>()
    fun getWishes(){
        viewModelScope.launch {
            val wishDao=DatabaseManager.instance.database.wishDao()
            savedWishes.value=MyCoroutines(wishDao).getWishes().value
        }
    }
}