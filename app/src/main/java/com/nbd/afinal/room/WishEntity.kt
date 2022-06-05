package com.nbd.afinal.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TABLE_WISHES)
data class WishEntity(
    @PrimaryKey val id:String,
    val product_name :String,
    val product_price:Double,
    val product_description:String,
    val product_cal:Double
)

fun WishEntity.toWish()=Wish(
    id,
    product_name,
    product_price,
    product_description,
    product_cal
)