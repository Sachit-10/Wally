package com.example.wally.Retrofit

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object constants {

    const val API_ID:String = "N2__TvKrjMhXRQm4MBpXMi5U99e2P7SF1kzTT6yk1A4"
    const val baseurl:String = "https://api.unsplash.com/"
    const val preferencname = "WallyPreferenceName"
    const val api_response_data = "API Response Data"

    //checking the internet connection
    fun isnetworkavailable(context: Context):Boolean {

        var connectingmanager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


        val network = connectingmanager.activeNetwork ?: return false
        val activenetwork = connectingmanager.getNetworkCapabilities(network) ?:return false


        return  when {
            activenetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            activenetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activenetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

            else -> false
        }





    }


}