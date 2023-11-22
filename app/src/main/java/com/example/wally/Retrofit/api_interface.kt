package com.example.wally.Retrofit

import com.example.wally.DataClass.dataclass_item
import com.example.wally.DataClass.queryresult
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface api_interface {

    @GET("photos?client_id=${constants.API_ID}")
    suspend fun getdetails() : Response<List<dataclass_item>>

    @GET("search/photos?client_id=${constants.API_ID}")
    suspend fun getimagesbyquery(
        @Query("query") query:String,
        @Query("pageno") pageno:Int
    ): Response<queryresult>
}