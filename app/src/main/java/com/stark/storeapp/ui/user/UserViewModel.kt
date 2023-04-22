package com.stark.storeapp.ui.user

import androidx.lifecycle.ViewModel
import com.stark.storeapp.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel  @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    fun fetchUserName() = repository.fetchUserName()
    fun fetchName() = repository.fetchName()
    fun fetchEmail() = repository.fetchUserEmail()
    fun fetchUserImage() = repository.fetchImage()
    fun clearAllData() = repository.clearAllData()
}
