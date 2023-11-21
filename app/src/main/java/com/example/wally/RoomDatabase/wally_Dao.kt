package com.example.wally.RoomDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.wally.DataClass.dataclass_item

@Dao
interface wally_Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(image: image_entity)

    @Query("SELECT * FROM image_table")
    fun fetchalldata() : LiveData<List<image_entity>>

}