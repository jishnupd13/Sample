package com.stark.storeapp.ui.parentFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.stark.storeapp.R
import com.stark.storeapp.databinding.FragmentParentBinding


class ParentFragment : Fragment(R.layout.fragment_parent) {

    private lateinit var binding: FragmentParentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentParentBinding.bind(view)

        val navController = findNavController(binding.navHostFragment.getFragment())
        binding.bottomNavigation.setupWithNavController(
            navController
        )
    }

}