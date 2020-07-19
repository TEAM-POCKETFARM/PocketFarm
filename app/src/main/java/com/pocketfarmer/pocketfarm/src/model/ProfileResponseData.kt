package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName

data class ProfileResponseData(
    @SerializedName("data")
    val dataProfile: DataProfile,
    @SerializedName("message")
    val message: String,
    @SerializedName("statusCode")
    val statusCode: Int
)