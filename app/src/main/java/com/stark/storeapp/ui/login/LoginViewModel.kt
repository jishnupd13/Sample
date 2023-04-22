package com.stark.storeapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stark.storeapp.models.login.LoginRequestModel
import com.stark.storeapp.models.login.LoginResponseModel
import com.stark.storeapp.repository.AppRepository
import com.stark.storeapp.utils.BaseResult
import com.stark.storeapp.utils.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel  @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val _authenticateUser = MutableLiveData<BaseResult<LoginResponseModel>>()
    val authenticateUserLiveData: LiveData<BaseResult<LoginResponseModel>>
        get() = _authenticateUser

    fun authenticateUser(loginRequestModel: LoginRequestModel) = viewModelScope.launch{
        _authenticateUser.postValue(BaseResult.loading())
        when (val response =
            repository.authenticateUser(loginRequestModel)) {
            is ResultWrapper.Success ->{

                repository.saveUserToken(response.data.token?:"")
                repository.saveImage(response.data.image?:"")
                repository.saveUserEmail(response.data.email?:"")
                repository.saveName("${response.data.firstName} ${response.data.lastName}")
                repository.saveUsername(response.data.username?:"")

                _authenticateUser.postValue(
                    BaseResult.success(
                        response.data
                    )
                )
            }


            is ResultWrapper.Failure ->
                _authenticateUser.postValue(
                    BaseResult.error(
                        response.message
                    )
                )
        }
    }

   /* init {
        authenticateUser(LoginRequestModel(
            username =  "kminchelle",
            password = "0lelplR"
        ))
    }*/
}