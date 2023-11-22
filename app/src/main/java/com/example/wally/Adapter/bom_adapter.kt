package com.example.wally.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wally.DataClass.dataclass_item
import com.example.wally.databinding.BomItemLayoutBinding

class bom_adapter(val context: Context, val bestofmonth_list:List<dataclass_item>, val listner:OnClickImagelistener ):
    RecyclerView.Adapter<bom_adapter.viewholder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {

        return viewholder(BomItemLayoutBinding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }

    override fun getItemCount(): Int {

        return bestofmonth_list.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {

        val photo = bestofmonth_list[position].urls.regular

        Glide.with(context).load(photo).into(holder.binding.bomImage)

        holder.itemView.setOnClickListener {

            listner.onClickImg(bestofmonth_list[position])

        }
    }


    class viewholder(var binding: BomItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){}

    interface OnClickImagelistener {
        fun onClickImg(data:dataclass_item)
    }

}
