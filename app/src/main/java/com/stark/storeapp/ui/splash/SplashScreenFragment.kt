package com.stark.storeapp.ui.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.stark.storeapp.R
import com.stark.storeapp.databinding.FragmentSplashScreenBinding
import com.stark.storeapp.utils.animationCompletionObserveListener
import dagger.hilt.android.AndroidEntryPoint


@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen) {

    private lateinit var binding: FragmentSplashScreenBinding
    private val viewModel by viewModels<SplashViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashScreenBinding.bind(view)
        binding.motionLayout.animationCompletionObserveListener{
            findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToParentFragment())
        }

    }

}