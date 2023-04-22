package com.stark.storeapp.adapters.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.stark.storeapp.databinding.CellTodayDealsBinding
import com.stark.storeapp.models.home.TodayDealsModel

class TodayDealsAdapter(
    private var list:ArrayList<TodayDealsModel>
): Adapter<TodayDealsAdapter.TodayDealsItemViewHolder>() {

    class TodayDealsItemViewHolder(
        private val binding: CellTodayDealsBinding
    ): RecyclerView.ViewHolder(binding.root){
        @SuppressLint("UseCompatLoadingForDrawables")
        fun onBind(item: TodayDealsModel) = binding.apply{
            imageTodayDeals.setImageDrawable(imageTodayDeals.context.getDrawable(item.brandImage))
            textBrand.text = item.brandName
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: ArrayList<TodayDealsModel>){
        this.list = arrayListOf()
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayDealsItemViewHolder {
        val binding = CellTodayDealsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TodayDealsItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: TodayDealsItemViewHolder, position: Int) {
        val item = list[position]
        holder.onBind(item = item)
    }
}