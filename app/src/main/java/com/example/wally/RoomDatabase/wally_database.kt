package com.example.wally.RoomDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.wally.DataClass.dataclass_item

@Database(entities = [image_entity::class], version = 1)
abstract class wally_database : RoomDatabase() {

    abstract fun getDao() : wally_Dao

}