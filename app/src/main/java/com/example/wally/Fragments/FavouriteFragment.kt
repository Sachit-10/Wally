package com.example.wally.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wally.Adapter.bom_adapter
import com.example.wally.Adapter.favourite_Adapter
import com.example.wally.R
import com.example.wally.RoomDatabase.image_entity
import com.example.wally.RoomDatabase.image_viewmodel
import com.example.wally.databinding.FragmentFavouriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteFragment : Fragment() {

    var binding:FragmentFavouriteBinding?=null
    val imageviewmodel:image_viewmodel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavouriteBinding.inflate(layoutInflater , container, false)


        // fetching all the data stored in roo database
       imageviewmodel.fetchalldata().observe(requireActivity()){

            binding?.saveRv?.layoutManager = GridLayoutManager(requireContext(), 2)
            binding?.saveRv?.adapter = favourite_Adapter(requireContext(),it)
        }








        return binding?.root
    }


}