package com.stark.storeapp.ui.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.stark.storeapp.R
import com.stark.storeapp.databinding.FragmentLoginBinding
import com.stark.storeapp.models.login.LoginRequestModel
import com.stark.storeapp.ui.news.NewsViewModel
import com.stark.storeapp.utils.BaseResult
import com.stark.storeapp.utils.hide
import com.stark.storeapp.utils.hideKeyboard
import com.stark.storeapp.utils.onClick
import com.stark.storeapp.utils.show
import dagger.hilt.android.AndroidEntryPoint

/**
 *
 *  use for login
 *   username =  "kminchelle",
     password = "0lelplR"
 *
 * */


@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

   private lateinit var binding:FragmentLoginBinding
   private val viewModel by viewModels<LoginViewModel>()
    var  observer: (() -> Unit?)? = null


    companion object{
       fun newInstance():LoginFragment{
           return LoginFragment()
       }
   }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        initViews()

    }

    fun initializeObserver(observer:(() -> Unit?)?){
        this.observer = observer
    }

    private fun initViews()=binding.apply{
        observeLoginResponse()
        btnLogin.onClick {
            hideKeyboard()
            if(etEmail.text?.toString()?.isEmpty() == true){
                Toast.makeText(requireContext(),"Please Enter Valid User name",Toast.LENGTH_LONG).show()
            }else if(etPassword.text?.toString()?.isEmpty()==true){
                Toast.makeText(requireContext(),"Please Enter Valid Password",Toast.LENGTH_LONG).show()
            }else if((etPassword.text?.toString()?.length ?: 0) < 5){
                Toast.makeText(requireContext(),"Please Enter Valid Password",Toast.LENGTH_LONG).show()
            }else{
                viewModel.authenticateUser(LoginRequestModel(
                    username = etEmail.text.toString(),
                    password = etPassword.text.toString()
                ))
            }
        }
    }

    private fun observeLoginResponse(){
        viewModel.authenticateUserLiveData.observe(viewLifecycleOwner) {

            when(it.status){
                BaseResult.Status.SUCCESS -> {
                  /*  binding.nestedScrollView.show()
                    binding.progressBar.hide()*/
                    observer?.invoke()
                }

                BaseResult.Status.ERROR->{
                    binding.nestedScrollView.show()
                    binding.progressBar.hide()
                    Toast.makeText(requireContext(),"Invalid Credentials",Toast.LENGTH_LONG).show()
                }

                BaseResult.Status.LOADING->{
                    binding.nestedScrollView.hide()
                    binding.progressBar.show()
                }
            }
        }
    }


}