package com.stark.storeapp.remoteservice

import com.stark.storeapp.models.login.LoginRequestModel
import com.stark.storeapp.models.login.LoginResponseModel
import retrofit2.Response

interface ApiHelper {
    suspend fun authenticateUser(
        loginRequestModel: LoginRequestModel
    ): Response<LoginResponseModel>
}