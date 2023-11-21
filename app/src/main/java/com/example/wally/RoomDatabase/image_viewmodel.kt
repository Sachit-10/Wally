package com.example.wally.RoomDatabase

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class image_viewmodel @Inject constructor(
    private val repository:image_repository
): ViewModel() {

    suspend fun fetchalldata(): LiveData<List<image_entity>> {
        return repository.fetchdata()
    }

    suspend fun insert(entity:image_entity){
        return repository.insert(entity)
    }
}