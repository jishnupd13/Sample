package com.stark.storeapp.adapters.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.stark.storeapp.databinding.CellBannerBinding
import com.stark.storeapp.models.home.Banner
import com.stark.storeapp.utils.loadImage

class BannerAdapter(private var list:ArrayList<Banner>) : Adapter<BannerAdapter.BannerItemViewHolder>() {

    class BannerItemViewHolder(
        private val binding: CellBannerBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun onBind(item: Banner) = binding.apply{
            imageBanner.loadImage(item.image?:"")
        }
    }

    @SuppressLint("NotifyDataSetChanged")
     fun setData(list: ArrayList<Banner>){
        this.list = arrayListOf()
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerItemViewHolder {
        val binding = CellBannerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BannerItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: BannerItemViewHolder, position: Int) {
       val item = list[position]
       holder.onBind(item)
    }
}