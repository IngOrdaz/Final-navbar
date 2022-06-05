package com.nbd.afinal.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyCoroutines (private val wishDao: WishDao){
    suspend fun save(wish: Wish)= withContext(Dispatchers.IO){
        wishDao.save(wish.toEntity())

    }
    suspend fun delete(wish: Wish)= withContext(Dispatchers.IO){
        wishDao.delete(wish.toEntity())
    }
    suspend fun getWishes():LiveData<List<Wish>> =withContext(Dispatchers.IO){

        return@withContext MutableLiveData(wishDao.getWishesFromDatabase().map{eachWish ->
            eachWish.toWish()})
    }
}