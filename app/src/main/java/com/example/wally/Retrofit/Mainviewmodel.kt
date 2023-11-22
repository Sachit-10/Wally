package com.example.wally.Retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wally.DataClass.dataclass_item
import com.example.wally.DataClass.queryresult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
    class Mainviewmodel @Inject constructor(private val repository: repository) : ViewModel() {

        val productsLiveData : MutableLiveData<Response<List<dataclass_item>>> = MutableLiveData()
    val productsLiveDataforquery : MutableLiveData<Response<queryresult>> = MutableLiveData()



    fun getProductViewModel(){
        viewModelScope.launch {
            productsLiveData.value = repository.getdetail()
        }
    }

    fun getimagesbyquery(name:String){
        viewModelScope.launch {
            productsLiveDataforquery.value = repository.getdetailsbyquery(name)
        }
    }



    }

