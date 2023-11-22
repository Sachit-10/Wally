package com.example.wally.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wally.Adapter.bom_adapter
import com.example.wally.DataClass.dataclass_item
import com.example.wally.R
import com.example.wally.Retrofit.Mainviewmodel
import com.example.wally.RoomDatabase.image_entity
import com.example.wally.RoomDatabase.image_viewmodel
import com.example.wally.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() , bom_adapter.OnClickImagelistener {

    var binding:FragmentHomeBinding?=null
    val mainviewmodel:Mainviewmodel by viewModels()
    val imageviewmodel:image_viewmodel by  viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater , container , false)


            mainviewmodel.getProductViewModel()
            mainviewmodel.productsLiveData.observe(requireActivity(), Observer{
            val list = it.body()!!

            binding?.imagesRv?.layoutManager = GridLayoutManager(requireContext() , 2)
            binding?.imagesRv?.adapter = bom_adapter(requireContext() , list , this)



        })



        return binding?.root
    }





    override fun onClickImg(data: dataclass_item) {
        Toast.makeText(requireContext(), "Saved to Favourites", Toast.LENGTH_LONG).show()
        imageviewmodel.insert(image_entity(
            id = null,
            image = data.urls.full
        ))




    }


}