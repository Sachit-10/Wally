package com.example.wally.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wally.Adapter.bom_adapter
import com.example.wally.DataClass.dataclass_item
import com.example.wally.R
import com.example.wally.Retrofit.Mainviewmodel
import com.example.wally.RoomDatabase.image_entity
import com.example.wally.RoomDatabase.image_viewmodel
import com.example.wally.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(), bom_adapter.OnClickImagelistener {

    var binding:FragmentSearchBinding?=null
    val viewmodel:Mainviewmodel by viewModels()
    val imageviewmodel: image_viewmodel by  viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(layoutInflater,container,false)


        // to recieve the text written in search box
        binding?.searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {

                //calling the api
                viewmodel.getimagesbyquery(p0.toString())
                viewmodel.productsLiveDataforquery.observe(requireActivity(), Observer {

                    val list = it.body()!!
                    val array:Array<dataclass_item> = list.results


                    binding?.searchRv?.layoutManager = GridLayoutManager(requireContext() , 2)
                    binding?.searchRv?.adapter = bom_adapter(requireContext() , array.toList(),this@SearchFragment)
                })

                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }

        })

        return binding?.root
    }


//when a item is clicked
    override fun onClickImg(data: dataclass_item) {
        Toast.makeText(requireContext(), "Saved to Favourites", Toast.LENGTH_LONG).show()
        imageviewmodel.insert(
            image_entity(
            id = null,
            image = data.urls.full
        )
        )
    }


}