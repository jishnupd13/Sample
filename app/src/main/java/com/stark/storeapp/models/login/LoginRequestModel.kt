package com.stark.storeapp.models.login

import com.google.gson.annotations.SerializedName


data class LoginRequestModel(
    @SerializedName("username")
    var username:String?="",
    @SerializedName("password")
    var password:String?=""
)