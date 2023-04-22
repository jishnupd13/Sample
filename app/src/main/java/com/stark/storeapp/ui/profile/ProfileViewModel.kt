package com.stark.storeapp.ui.profile

import androidx.lifecycle.ViewModel
import com.stark.storeapp.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel  @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    fun  fetchUserToken():String = repository.fetchUserToken()

}
