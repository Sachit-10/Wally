package com.example.wally

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.wally.Fragments.AboutFragment
import com.example.wally.Fragments.FavouriteFragment
import com.example.wally.Fragments.HomeFragment
import com.example.wally.Fragments.SearchFragment
import com.example.wally.Retrofit.Mainviewmodel
import com.example.wally.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    var binding:ActivityMainBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)



        replacefragment(HomeFragment())

        binding?.bottomNavigationView?.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home1 -> replacefragment(HomeFragment())
                R.id.download1 ->    replacefragment(FavouriteFragment())
                R.id.search1-> replacefragment(SearchFragment())
                R.id.about1-> replacefragment(AboutFragment())

            }
            true
        }


    }

    //to replace fragment
    fun replacefragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_layout , fragment).commit()

    }
}


