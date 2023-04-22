package com.stark.storeapp.ui.news

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel  @Inject constructor() : ViewModel() {

    var loadWebViewUrl = "https://storezaap.com/news/Homepage"
}