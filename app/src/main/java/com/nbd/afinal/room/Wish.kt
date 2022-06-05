package com.nbd.afinal.room

class Wish(
        id:String,
        product_name:String,
        product_price: Double,
        product_description:String,
        product_cal: Double
        ) {
        val id:String=id
        val product_name:String=product_name
        val product_price: Double=product_price
        val product_description:String=product_description
        val product_cal:Double =product_cal
}

fun Wish.toEntity()=WishEntity(
        id,
        product_name,
        product_price,
        product_description,
        product_cal
)