package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName

data class UserResponseData(
    @SerializedName("data")
    val dataUser: DataUser?,
    @SerializedName("message")
    val message: String,
    @SerializedName("statusCode")
    val statusCode: Int
)