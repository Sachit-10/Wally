package com.example.wally.DataClass

import androidx.room.Entity
import androidx.room.PrimaryKey


data class dataclass_item(
    val color: String,
    val description: String,
    val height: Int,

    val id: String,
    val urls: Urls
//    val user: User,
)
