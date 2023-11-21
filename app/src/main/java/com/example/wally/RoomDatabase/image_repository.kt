package com.example.wally.RoomDatabase

import com.example.wally.DataClass.dataclass_item
import javax.inject.Inject

class image_repository @Inject constructor(
    private val getdao:wally_Dao
){

    suspend fun insert(entity: image_entity){
        return getdao.insert(entity)
    }

    suspend fun fetchdata() = getdao.fetchalldata()
}