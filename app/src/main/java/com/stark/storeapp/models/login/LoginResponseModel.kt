package com.stark.storeapp.models.login


import com.google.gson.annotations.SerializedName

data class LoginResponseModel(
    @SerializedName("email")
    val email: String?="",
    @SerializedName("firstName")
    val firstName: String?="",
    @SerializedName("gender")
    val gender: String?="",
    @SerializedName("id")
    val id: Int?=0,
    @SerializedName("image")
    val image: String?="",
    @SerializedName("lastName")
    val lastName: String?="",
    @SerializedName("token")
    val token: String?="",
    @SerializedName("username")
    val username: String?="",
    @SerializedName("message")
    val message: String?=""
)