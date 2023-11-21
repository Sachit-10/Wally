package com.example.wally.RoomDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image_table")
data class image_entity(

    @PrimaryKey(autoGenerate = false)
    val id:Int?=null,

    val image:String,

)

