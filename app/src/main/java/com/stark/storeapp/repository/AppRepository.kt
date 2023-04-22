package com.stark.storeapp.repository

import com.stark.storeapp.models.login.LoginRequestModel
import com.stark.storeapp.preferencehandler.PreferenceHandler
import com.stark.storeapp.remoteservice.ApiHelper
import com.stark.storeapp.utils.safeApiCall
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val preferenceHandler: PreferenceHandler,
    private val apiHelper: ApiHelper
){
    suspend fun authenticateUser(loginRequestModel: LoginRequestModel) = safeApiCall {
        apiHelper.authenticateUser(loginRequestModel)
    }

    fun saveUserToken(token:String) {
        preferenceHandler.userToken=token
    }

    fun fetchUserToken():String = preferenceHandler.userToken

    fun saveUsername(value:String) {
        preferenceHandler.userToken=value
    }

    fun fetchUserName():String = preferenceHandler.userName

    fun saveUserEmail(value:String) {
        preferenceHandler.email= value
    }

    fun fetchUserEmail():String = preferenceHandler.email

    fun saveName(value:String) {
        preferenceHandler.name= value
    }

    fun fetchName():String = preferenceHandler.name

    fun saveImage(value:String) {
        preferenceHandler.userImage= value
    }

    fun fetchImage():String = preferenceHandler.userImage

    fun clearAllData(){
        preferenceHandler.clearSharedPreferences()
    }
}