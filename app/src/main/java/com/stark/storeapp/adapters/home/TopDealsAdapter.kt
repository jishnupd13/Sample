package com.stark.storeapp.adapters.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.stark.storeapp.databinding.CellTopDealsBinding
import com.stark.storeapp.models.home.TopDealsModel

class TopDealsAdapter(private var list:ArrayList<TopDealsModel>): Adapter<TopDealsAdapter.TopDealsItemViewHolder>() {

    class TopDealsItemViewHolder(
        private val binding: CellTopDealsBinding
    ): RecyclerView.ViewHolder(binding.root){
        @SuppressLint("UseCompatLoadingForDrawables")
        fun onBind(item: TopDealsModel) = binding.apply{
            imageTopDeals.setImageDrawable(imageTopDeals.context.getDrawable(item.imageUrl!!))
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: ArrayList<TopDealsModel>){
        this.list = arrayListOf()
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopDealsItemViewHolder {
        val binding = CellTopDealsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TopDealsItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: TopDealsItemViewHolder, position: Int) {
        val item = list[position]
        holder.onBind(item = item)
    }
}