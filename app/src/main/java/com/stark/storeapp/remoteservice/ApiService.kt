package com.stark.storeapp.remoteservice

import com.stark.storeapp.models.login.LoginRequestModel
import com.stark.storeapp.models.login.LoginResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("auth/login")
    suspend fun authenticateUser(@Body loginRequestModel: LoginRequestModel):Response<LoginResponseModel>
}