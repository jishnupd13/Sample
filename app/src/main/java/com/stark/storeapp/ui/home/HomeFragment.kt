package com.stark.storeapp.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.stark.storeapp.R
import com.stark.storeapp.adapters.home.BannerAdapter
import com.stark.storeapp.adapters.home.TodayDealsAdapter
import com.stark.storeapp.adapters.home.TopDealsAdapter
import com.stark.storeapp.databinding.FragmentHomeBinding
import com.stark.storeapp.utils.HorizontalItemDecorator
import com.stark.storeapp.utils.currentPageListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

   private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var bannerAdapter: BannerAdapter
    private lateinit var topDealsAdapter:TopDealsAdapter
    private lateinit var todayDealsAdapter: TodayDealsAdapter
    private var job:Job?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        initViews()
    }

    private fun initViews(){
        bannerAdapter = BannerAdapter(arrayListOf())
        topDealsAdapter = TopDealsAdapter(arrayListOf())
        todayDealsAdapter = TodayDealsAdapter(arrayListOf())
        binding.viewPagerBanners.isUserInputEnabled = false
        binding.viewPagerBanners.adapter  = bannerAdapter

        binding.recyclerviewTopDeals.addItemDecoration(HorizontalItemDecorator(14,8))
        binding.recyclerviewTopDeals.adapter = topDealsAdapter

        binding.recyclerviewTodayDeals.adapter = todayDealsAdapter

        observeHomeDate()
        viewModel.fetchHomeData()
        viewPagerPageListener()


    }

    private fun observeHomeDate(){
        viewModel.homeLiveData.observe(viewLifecycleOwner){
            bannerAdapter.setData(list = it.bannerList!!)
            topDealsAdapter.setData(list = it.topDealsList!!)
            todayDealsAdapter.setData(list = it.todayDealsList!!)
        }
    }

    private fun viewPagerPageListener(){


        binding.viewPagerBanners.currentPageListener {
            job =  lifecycleScope.launch(Dispatchers.Main) {
                delay(3000)
                val currentPosition = binding.viewPagerBanners.currentItem
                val accuratePosition = if(currentPosition<2) currentPosition+1 else 0
                binding.viewPagerBanners.setCurrentItem(accuratePosition,true)
                setDots(binding.viewPagerBanners.currentItem)
            }
            job?.start()
        }
    }

    private fun setDots(position:Int){

        when(position){
            0->{
                binding.dotOne.setImageResource(R.drawable.bg_white_circle)
                binding.dotTwo.setImageResource(R.drawable.bg_grey_circle)
                binding.dotThree.setImageResource(R.drawable.bg_grey_circle)
            }

            1->{
                binding.dotOne.setImageResource(R.drawable.bg_grey_circle)
                binding.dotTwo.setImageResource(R.drawable.bg_white_circle)
                binding.dotThree.setImageResource(R.drawable.bg_grey_circle)
            }

            else->{
                binding.dotOne.setImageResource(R.drawable.bg_grey_circle)
                binding.dotTwo.setImageResource(R.drawable.bg_grey_circle)
                binding.dotThree.setImageResource(R.drawable.bg_white_circle)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        job?.cancel()
    }
}