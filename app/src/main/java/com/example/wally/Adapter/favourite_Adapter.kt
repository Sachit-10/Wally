package com.example.wally.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wally.RoomDatabase.image_entity
import com.example.wally.databinding.BomItemLayoutBinding

class favourite_Adapter(val context: Context, val data:List<image_entity>):
    RecyclerView.Adapter<favourite_Adapter.viewholder>() {


    class viewholder(val binding:BomItemLayoutBinding): RecyclerView.ViewHolder(binding.root){}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(BomItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {

        val photo = data[position]

        Glide.with(context).load(photo.image).into(holder.binding.bomImage)



    }



}