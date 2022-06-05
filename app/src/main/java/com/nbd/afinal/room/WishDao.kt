package com.nbd.afinal.room

import androidx.room.*

@Dao
interface WishDao {
    @Query("SELECT*FROM $TABLE_WISHES")
    fun getWishesFromDatabase(): List<WishEntity>

    @Query("SELECT*FROM $TABLE_WISHES WHERE id=:id")
    fun getWishById(id: String): WishEntity

    @Delete
    fun delete(wish:WishEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(wish:WishEntity)
}