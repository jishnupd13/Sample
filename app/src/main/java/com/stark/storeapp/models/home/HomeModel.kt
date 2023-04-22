package com.stark.storeapp.models.home

data class HomeModel(
    val bannerList:ArrayList<Banner>? = arrayListOf(),
    val topDealsList:ArrayList<TopDealsModel>? = arrayListOf(),
    val todayDealsList:ArrayList<TodayDealsModel>? = arrayListOf()
)

data class Banner(
    val imageId:Int,
    val image:String?=""
)

