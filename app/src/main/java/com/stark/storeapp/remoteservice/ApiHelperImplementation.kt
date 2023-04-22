package com.stark.storeapp.remoteservice

import com.stark.storeapp.models.login.LoginRequestModel
import com.stark.storeapp.models.login.LoginResponseModel
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImplementation @Inject constructor(
     val apiService: ApiService
):ApiHelper {

    override suspend fun authenticateUser(loginRequestModel: LoginRequestModel): Response<LoginResponseModel> =
        apiService.authenticateUser(loginRequestModel)

}