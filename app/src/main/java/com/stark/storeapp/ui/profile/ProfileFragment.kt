package com.stark.storeapp.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.stark.storeapp.R
import com.stark.storeapp.databinding.FragmentProfileBinding
import com.stark.storeapp.ui.login.LoginFragment
import com.stark.storeapp.ui.news.NewsViewModel
import com.stark.storeapp.ui.user.UserFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding:FragmentProfileBinding
    private val viewModel by viewModels<ProfileViewModel>()
    private var loginFragment:LoginFragment?=null
    private var userFragment: UserFragment?=null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)
        loginFragment = LoginFragment.newInstance()
        userFragment = UserFragment.newInstance()
        loginFragment?.initializeObserver {
         initializeUserFragment()
        }
        userFragment?.initializeObserver {
            initializeLoginFragment()
        }

        if(viewModel.fetchUserToken().isNotEmpty()){
            initializeUserFragment()
        }else{
            initializeLoginFragment()
        }
    }

    private fun initializeLoginFragment(){
        loginFragment?.let {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(binding.fragmentContainerView.id, it)
                .commit()
        }
    }

    private fun initializeUserFragment(){
        userFragment?.let {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(binding.fragmentContainerView.id, it)
                .commit()
        }
    }

}