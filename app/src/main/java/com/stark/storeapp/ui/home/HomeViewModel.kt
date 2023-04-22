package com.stark.storeapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stark.storeapp.R
import com.stark.storeapp.models.home.Banner
import com.stark.storeapp.models.home.HomeModel
import com.stark.storeapp.models.home.TodayDealsModel
import com.stark.storeapp.models.home.TopDealsModel
import com.stark.storeapp.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val _homeMutableLiveData = MutableLiveData<HomeModel>()
    val homeLiveData = _homeMutableLiveData

     fun fetchHomeData() = viewModelScope.launch {
        val homeData = HomeModel(
            bannerList = setBannerList(),
            topDealsList = setUpTopDealsData(),
            todayDealsList = fetchTodayDealsData()
        )
        _homeMutableLiveData.postValue(homeData)
    }

    private fun setBannerList():ArrayList<Banner>{
        val bannerList = arrayListOf<Banner>()
        bannerList.add(Banner(imageId = 1, image = "https://storezaap.com/img/slider/si2.jpg"))
        bannerList.add(Banner(imageId = 2, image = "https://storezaap.com/img/slider/si4.jpg"))
        bannerList.add(Banner(imageId = 3, image = "https://storezaap.com/img/slider/si3.jpg"))
        return bannerList
    }

    private fun setUpTopDealsData():ArrayList<TopDealsModel>{
        val list = arrayListOf<TopDealsModel>()
        list.add(TopDealsModel(id = 1, R.drawable.amazon,))
        list.add(TopDealsModel(id = 2, R.drawable.flipkart))
        list.add(TopDealsModel(id = 3, R.drawable.ebay))
        list.add(TopDealsModel(id = 4, R.drawable.limeroad))
        list.add(TopDealsModel(id = 5, R.drawable.snapdeal))
        list.add(TopDealsModel(id = 6, R.drawable.shopclues))
        return list
    }

    private fun fetchTodayDealsData():ArrayList<TodayDealsModel>{
        val list = arrayListOf<TodayDealsModel>()
        list.add(
            TodayDealsModel(
            id = 1,
            brandImage = R.drawable.flipkart,
            brandName = "FlipKat",
            navigationUrl = "https://www.amazon.com/gp/goldbox/ref=nav_cs_gb"
        ))

        list.add(
            TodayDealsModel(
                id = 2,
                brandImage = R.drawable.amazon,
                brandName = "Amazon",
                navigationUrl = "https://www.amazon.com/gp/goldbox/ref=nav_cs_gb"
            ))

        list.add(
            TodayDealsModel(
                id = 3,
                brandImage = R.drawable.ebay,
                brandName = "Ebay",
                navigationUrl = "https://www.amazon.com/gp/goldbox/ref=nav_cs_gb"
            ))

        list.add(
            TodayDealsModel(
                id = 4,
                brandImage = R.drawable.snapdeal,
                brandName = "SnapDeal",
                navigationUrl = "https://www.amazon.com/gp/goldbox/ref=nav_cs_gb"
            ))

        list.add(
            TodayDealsModel(
                id = 5,
                brandImage = R.drawable.limeroad,
                brandName = "LimeRoad",
                navigationUrl = "https://www.amazon.com/gp/goldbox/ref=nav_cs_gb"
            ))

        list.add(
            TodayDealsModel(
                id = 6,
                brandImage = R.drawable.firstcry,
                brandName = "FirstCry",
                navigationUrl = "https://www.amazon.com/gp/goldbox/ref=nav_cs_gb"
            ))

        list.add(
            TodayDealsModel(
                id = 7,
                brandImage = R.drawable.flipkart,
                brandName = "FlipKat",
                navigationUrl = "https://www.amazon.com/gp/goldbox/ref=nav_cs_gb"
            ))

        list.add(
            TodayDealsModel(
                id = 8,
                brandImage = R.drawable.amazon,
                brandName = "Amazon",
                navigationUrl = "https://www.amazon.com/gp/goldbox/ref=nav_cs_gb"
            ))

        list.add(
            TodayDealsModel(
                id = 9,
                brandImage = R.drawable.ebay,
                brandName = "Ebay",
                navigationUrl = "https://www.amazon.com/gp/goldbox/ref=nav_cs_gb"
            ))

        list.add(
            TodayDealsModel(
                id = 10,
                brandImage = R.drawable.snapdeal,
                brandName = "SnapDeal",
                navigationUrl = "https://www.amazon.com/gp/goldbox/ref=nav_cs_gb"
            ))

        list.add(
            TodayDealsModel(
                id = 11,
                brandImage = R.drawable.limeroad,
                brandName = "LimeRoad",
                navigationUrl = "https://www.amazon.com/gp/goldbox/ref=nav_cs_gb"
            ))

        list.add(
            TodayDealsModel(
                id = 12,
                brandImage = R.drawable.firstcry,
                brandName = "FirstCry",
                navigationUrl = "https://www.amazon.com/gp/goldbox/ref=nav_cs_gb"
            ))
        return list
    }
}