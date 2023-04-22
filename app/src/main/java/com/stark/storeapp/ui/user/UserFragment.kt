package com.stark.storeapp.ui.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.stark.storeapp.R
import com.stark.storeapp.databinding.FragmentUserBinding
import com.stark.storeapp.ui.login.LoginFragment
import com.stark.storeapp.ui.profile.ProfileFragment
import com.stark.storeapp.ui.profile.ProfileViewModel
import com.stark.storeapp.utils.loadImage
import com.stark.storeapp.utils.onClick
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UserFragment : Fragment(R.layout.fragment_user) {

    private lateinit var binding:FragmentUserBinding
    private val viewModel by viewModels<UserViewModel>()
    private  var observer : (() -> Unit?)? =null

    companion object{
        fun newInstance(): UserFragment {
            return UserFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserBinding.bind(view)
        initViews()
    }

    private fun initViews() = binding.apply {
        imageUser.loadImage(viewModel.fetchUserImage())
        textHeader.text = viewModel.fetchName()
        imageProfile.loadImage(viewModel.fetchUserImage())
        textUserName.text = viewModel.fetchName()
        textEmail.text = viewModel.fetchEmail()

        logout.onClick {
            viewModel.clearAllData()
            observer?.invoke()
        }
    }

    fun initializeObserver(observer:(()->Unit?)){
        this.observer = observer
    }

}