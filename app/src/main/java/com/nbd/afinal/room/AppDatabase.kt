package com.nbd.afinal.room

import androidx.room.Database
import androidx.room.RoomDatabase

const val DATABASE_VERSION=1
const val  DATABASE_NAME="appdatabase.sqlite"
const val TABLE_WISHES="wishes"
@Database(entities = [WishEntity::class],
    version = 1
    )
abstract class AppDatabase: RoomDatabase() {
    abstract fun wishDao(): WishDao
}