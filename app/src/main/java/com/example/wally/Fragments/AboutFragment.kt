package com.example.wally.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wally.R
import com.example.wally.databinding.FragmentAboutBinding


class AboutFragment : Fragment() {

    var binding:FragmentAboutBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAboutBinding.inflate(layoutInflater,container,false)

        binding?.tvInfo?.text = "1. This is mini Wallpaper app built with kotlin using unsplash API.\n" +"" +
                "2. You can discover and browse a vast collection of high-quality wallpapers.\n" +
                "3. You can save your wallpaper in favourites fragment by just one click on photo. \n" +
                "4. Smooth and responsive UI.\n" +
                "5. API integration is done with Retrofit using dagger-hilt and coroutines. \n" +
                "6. You can search any type of wallpaper.\n" +
                "7. It consists of a splash screen.\n" +
                "6. wallpapers are stored using room database."
        return binding?.root
    }


}