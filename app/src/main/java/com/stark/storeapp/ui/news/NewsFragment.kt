package com.stark.storeapp.ui.news

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.viewModels
import com.stark.storeapp.R
import com.stark.storeapp.databinding.FragmentNewsBinding
import com.stark.storeapp.ui.home.HomeViewModel
import com.stark.storeapp.utils.hide
import com.stark.storeapp.utils.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment(R.layout.fragment_news) {

    private lateinit var binding: FragmentNewsBinding
    private val viewModel by viewModels<NewsViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsBinding.bind(view)
        initViews()

    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initViews() = binding.apply {
        newsWebView.webViewClient = MyBrowser()
        newsWebView.settings.loadsImagesAutomatically = true
        newsWebView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        newsWebView.settings.domStorageEnabled = true
        newsWebView.settings.databaseEnabled = true
        newsWebView.settings.loadWithOverviewMode = true
        newsWebView.settings.useWideViewPort = true
        newsWebView.settings.builtInZoomControls = true
        newsWebView.settings.javaScriptEnabled = true
        newsWebView.settings.allowContentAccess = true
        newsWebView.settings.allowFileAccess = true
        newsWebView.settings.javaScriptCanOpenWindowsAutomatically = true
        newsWebView.loadUrl(viewModel.loadWebViewUrl)
    }

    inner class MyBrowser() :
        WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView,
            request: WebResourceRequest
        ): Boolean {
            return false
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            binding.progressBar.show()
            binding.newsWebView.hide()
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            binding.progressBar.hide()
            binding.newsWebView.show()
        }

    }
}