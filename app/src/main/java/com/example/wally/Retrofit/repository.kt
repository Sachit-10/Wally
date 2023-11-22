package com.example.wally.Retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.wally.DataClass.dataclass_item
import com.example.wally.DataClass.queryresult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class repository @Inject constructor(private val apiInterface: api_interface) {



       suspend fun getdetail() : Response<List<dataclass_item>> {
        return apiInterface.getdetails()
    }

    suspend fun getdetailsbyquery(name:String) : Response<queryresult> {
        return apiInterface.getimagesbyquery(name,1)
    }



}