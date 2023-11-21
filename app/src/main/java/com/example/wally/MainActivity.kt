package com.example.wally

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.wally.Retrofit.Mainviewmodel
import com.example.wally.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    var binding:ActivityMainBinding?=null
    val mainViewModel: Mainviewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        mainViewModel.getProductViewModel()
        mainViewModel.productsLiveData.observe(this, Observer{
            val list = it.body()!!
//            Glide.with(this).load(list[0].urls.regular).into(binding!!.imageIv)

        })


    }
}


